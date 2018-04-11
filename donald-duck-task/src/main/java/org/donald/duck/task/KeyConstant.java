package org.donald.duck.task;


/**
 * 对应 mulan-config/${env}/key.properties 配置文件
 *
 * @author fengquanwei
 * @create 2017/3/31 14:32
 **/
public class KeyConstant {
    @Config("customer_aes_key")
    public static String CUSTOMER_AES_KEY;

    @Config("password_aes_key")
    public static String PASSWORD_AES_KEY;
    
    @Config("wredis_appkey")
    public static String WREDIS_APPKEY;
    
    @Config("pruduct_cd")
    public static String PRODUCT_CD;
    
    @Config("token_name")
    public static String TOKEN_NAME;
    
    @Config("monitor_mail_receives")
    public static String MONITOR_MAIL_RECEIVES;

    @Config("pay_channel_code")
    public static String PAY_CHANNEL_CODE;

    @Config("credit_md5key")
    public static String CREDIT_MD5KEY;

    @Config("repay.notice.local.dir")
    public static String REPAY_NOTICE_LOCAL_DIR;
    
    @Config("risk_control_md5_key")
    public static String RISK_CONTROL_MD5_KEY;
    
    @Config("risk_control_query_md5_key")
    public static String RISK_CONTROL_QUERY_MD5_KEY;

    @Config("wos_app_id")
    public static String WOS_APP_ID;

    @Config("wos_secrect_key")
    public static String WOS_SECRECT_KEY;

    @Config("wos_secrect_id")
    public static String WOS_SECRECT_ID;

    @Config("wos_bucket")
    public static String WOS_BUCKET;

    @Config("wos_expire_seconds")
    public static Long WOS_EXPIRE_SECONDS;

}
