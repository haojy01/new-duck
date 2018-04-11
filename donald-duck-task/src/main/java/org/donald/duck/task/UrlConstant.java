package org.donald.duck.task;


/**
 * 对应 mulan-config/${env}/url.properties 配置文件
 *
 * @author fengquanwei
 * @create 2017/6/6 15:50
 **/
public class UrlConstant {
    @Config("image_upload_path")
    public static String IMAGE_UPLOAD_PATH;

    @Config("image_download_url")
    public static String IMAGE_DOWNLOAD_URL;

    @Config("pay_bind_url")
    public static String PAY_BIND_URL;

    @Config("pay_bind_list_url")
    public static String PAY_BIND_LIST_URL;

    @Config("pay_set_password_url")
    public static String PAY_SET_PASSWORD_URL;

    @Config("pay_verify_password_url")
    public static String PAY_VERIFY_PASSWORD_URL;

    @Config("pay_reset_password_url")
    public static String PAY_RESET_PASSWORD_URL;

    @Config("pay_withdraw_url")
    public static String PAY_WITHDRAW_URL;

    @Config("pay_withdraw_query_url")
    public static String PAY_WITHDRAW_QUERY_URL;

    @Config("pay_withhold_url")
    public static String PAY_WITHHOLD_URL;

    @Config("pay_withhold_query_url")
    public static String PAY_WITHHOLD_QUERY_URL;

    @Config("pay_withdraw_callback_url")
    public static String PAY_WITHDRAW_CALLBACK_URL;

    @Config("pay_withhold_callback_url")
    public static String PAY_WITHHOLD_CALLBACK_URL;

    @Config("credit_whitelist_url")
    public static String CREDIT_WHITELIST_URL;

    @Config("credit_idcard_ocr_url")
    public static String CREDIT_IDCARD_OCR_URL;

    @Config("credit_random_number_url")
    public static String CREDIT_RANDOM_NUMBER_URL;

    @Config("credit_upload_video_url")
    public static String CREDIT_UPLOAD_VIDEO_URL;

    @Config("credit_faceverify_url")
    public static String CREDIT_FACEVERIFY_URL;

    @Config("credit_cardbin_url")
    public static String CREDIT_CARDBIN_URL;

    @Config("credit_messagecode_url")
    public static String CREDIT_MESSAGECODE_URL;

    @Config("credit_bankauth_url")
    public static String CREDIT_BANKAUTH_URL;

    @Config("credit_query_body_alive_check_result_from_info_secure")
    public static String CREDIT_QUERY_BODY_ALIVE_CHECK_RESULT_FROM_INFO_SECURE;

    @Config("core_root_url")
    public static String CORE_ROOT_URL;

    @Config("risk_control_push_url")
    public static String RISK_CONTROL_PUSH_URL;
    
    @Config("risk_control_withdraw_url")
    public static String RISK_CONTROL_WITHDRAW_URL;

    @Config("risk_control_query_url")
    public static String RISK_CONTROL_QUERY_URL;

    @Config("wos_get_token_url")
    public static String WOS_GET_TOKEN_URL;
}
