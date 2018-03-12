package com.silent.fiveghost.tourist.utils;

public interface UrlUtils {
	public static String HTTP_XNXZ_SERVER_APP = "http://120.79.137.110:80";//test
//	public static String HTTP_XNXZ_SERVER_APP = "";//pre
//	public static String HTTP_XNXZ_SERVER_APP = "";//production

	String YZM_URL = HTTP_XNXZ_SERVER_APP + "/api/v1/sms/send";
	String LOGIN_URL = HTTP_XNXZ_SERVER_APP + "/api/v1/auth/login";
	String REGISTER_URL = HTTP_XNXZ_SERVER_APP + "/api/v1/auth/signup";
	String FORGET_URL = HTTP_XNXZ_SERVER_APP + "/api/v1/auth/reset-password";
	String HOME_URL = HTTP_XNXZ_SERVER_APP + "/api/v1/home/tourist-index?access_token=_za8e8fMg-ueDPbvVeZCBDWrFCrabPa-&order_id= 2018022295140111";
//	String HOME_URL = "http://120.79.137.110:83/api/v1/home/tourist-index?access_token=_za8e8fMg-ueDPbvVeZCBDWrFCrabPa-&order_id= 2018022295140111";


}
