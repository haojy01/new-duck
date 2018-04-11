package org.donald.duck.task;

import java.beans.PropertyEditor;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.ByteArrayPropertyEditor;
import org.springframework.beans.propertyeditors.CharArrayPropertyEditor;
import org.springframework.beans.propertyeditors.CharacterEditor;
import org.springframework.beans.propertyeditors.CharsetEditor;
import org.springframework.beans.propertyeditors.ClassArrayEditor;
import org.springframework.beans.propertyeditors.ClassEditor;
import org.springframework.beans.propertyeditors.CurrencyEditor;
import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.beans.propertyeditors.CustomMapEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.beans.propertyeditors.FileEditor;
import org.springframework.beans.propertyeditors.InputSourceEditor;
import org.springframework.beans.propertyeditors.InputStreamEditor;
import org.springframework.beans.propertyeditors.LocaleEditor;
import org.springframework.beans.propertyeditors.PatternEditor;
import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.beans.propertyeditors.ReaderEditor;
import org.springframework.beans.propertyeditors.TimeZoneEditor;
import org.springframework.beans.propertyeditors.URIEditor;
import org.springframework.beans.propertyeditors.URLEditor;
import org.springframework.beans.propertyeditors.UUIDEditor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourceArrayPropertyEditor;
import org.springframework.stereotype.Service;
import org.xml.sax.InputSource;

@Service
public class ConfigPropertyInjector implements ApplicationListener<ContextRefreshedEvent> {
    private static Logger logger = LoggerFactory.getLogger(ConfigPropertyInjector.class);

    private Map<Class<?>, PropertyEditor> editors;

    @Autowired
    private CustomizedPropertyPlaceholderConfigurer customizedPropertyPlaceholderConfigurer;

    public ConfigPropertyInjector() {
        this.editors = new HashMap<Class<?>, PropertyEditor>(64);

        this.editors.put(Charset.class, new CharsetEditor());
        this.editors.put(Class.class, new ClassEditor());
        this.editors.put(Class[].class, new ClassArrayEditor());
        this.editors.put(Currency.class, new CurrencyEditor());
        this.editors.put(File.class, new FileEditor());
        this.editors.put(InputStream.class, new InputStreamEditor());
        this.editors.put(InputSource.class, new InputSourceEditor());
        this.editors.put(Locale.class, new LocaleEditor());
        this.editors.put(Pattern.class, new PatternEditor());
        this.editors.put(Properties.class, new PropertiesEditor());
        this.editors.put(Reader.class, new ReaderEditor());
        this.editors.put(Resource[].class, new ResourceArrayPropertyEditor());
        this.editors.put(TimeZone.class, new TimeZoneEditor());
        this.editors.put(URI.class, new URIEditor());
        this.editors.put(URL.class, new URLEditor());
        this.editors.put(UUID.class, new UUIDEditor());
        this.editors.put(Collection.class, new CustomCollectionEditor(Collection.class));
        this.editors.put(Set.class, new CustomCollectionEditor(Set.class));
        this.editors.put(SortedSet.class, new CustomCollectionEditor(SortedSet.class));
        this.editors.put(List.class, new CustomCollectionEditor(List.class));
        this.editors.put(SortedMap.class, new CustomMapEditor(SortedMap.class));
        this.editors.put(byte[].class, new ByteArrayPropertyEditor());
        this.editors.put(char[].class, new CharArrayPropertyEditor());
        this.editors.put(char.class, new CharacterEditor(false));
        this.editors.put(Character.class, new CharacterEditor(true));
        this.editors.put(boolean.class, new CustomBooleanEditor(false));
        this.editors.put(Boolean.class, new CustomBooleanEditor(true));
        this.editors.put(byte.class, new CustomNumberEditor(Byte.class, false));
        this.editors.put(Byte.class, new CustomNumberEditor(Byte.class, true));
        this.editors.put(short.class, new CustomNumberEditor(Short.class, false));
        this.editors.put(Short.class, new CustomNumberEditor(Short.class, true));
        this.editors.put(int.class, new CustomNumberEditor(Integer.class, false));
        this.editors.put(Integer.class, new CustomNumberEditor(Integer.class, true));
        this.editors.put(long.class, new CustomNumberEditor(Long.class, false));
        this.editors.put(Long.class, new CustomNumberEditor(Long.class, true));
        this.editors.put(float.class, new CustomNumberEditor(Float.class, false));
        this.editors.put(Float.class, new CustomNumberEditor(Float.class, true));
        this.editors.put(double.class, new CustomNumberEditor(Double.class, false));
        this.editors.put(Double.class, new CustomNumberEditor(Double.class, true));
        this.editors.put(BigDecimal.class, new CustomNumberEditor(BigDecimal.class, true));
        this.editors.put(BigInteger.class, new CustomNumberEditor(BigInteger.class, true));
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            if (null == contextRefreshedEvent.getApplicationContext().getParent()) {
                Class[] configClazzes = getConfigClazzes();
                for (Class clazz : configClazzes) {
                    propertyInject(clazz);
                }
                out();
            }
        } catch (Exception e) {
            logger.error("", e);
        }
    }

    // 属性注入
    private void propertyInject(Class clazz) throws IllegalAccessException, InstantiationException {
        Object instance = clazz.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        if (null != fields && fields.length > 0) {
            for (Field field : fields) {
                if (Modifier.isStatic(field.getModifiers())) {
                    Config annotation = field.getAnnotation(Config.class);
                    if (null != annotation) {
                        String property = customizedPropertyPlaceholderConfigurer.getProperty(annotation.value());
                        if (null != property) {
                            field.set(instance, convert(field.getType(), property));
                        }
                    }
                }
            }
        }
    }

    // 将字符串值转换为指定类型的值
    private Object convert(Class requiredType, String value) {
        if (String.class.equals(requiredType)) {
            return value;
        }

        PropertyEditor editor = editors.get(requiredType);
        if (null != editor) {
            editor.setAsText(value);
            return editor.getValue();
        } else {
            throw new IllegalArgumentException("不能将" + value + "转换为" + requiredType.getName() + "类型");
        }
    }

    // 把配置的值打印到日志中
    private void out() throws Exception {
        Class[] configClazzes = getConfigClazzes();
        if (null == configClazzes || configClazzes.length == 0) {
            logger.info("没有可配置的系统常量");
            return;
        }
        for (Class configClazz : configClazzes) {
            Field[] fields = configClazz.getFields();
            String clazzName = configClazz.getSimpleName();
            for (Field f : fields) {
                String name = f.getName();
                logger.info("可配置系统常量类{}=====>{}:{}", clazzName, name, f.get(configClazz));
            }
        }
    }

    // 获取配置类
    private Class[] getConfigClazzes() {
        return new Class[]{KeyConstant.class, UrlConstant.class};
    }
}
