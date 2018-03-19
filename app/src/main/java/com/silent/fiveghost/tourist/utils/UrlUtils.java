package com.silent.fiveghost.tourist.utils;

public interface UrlUtils {
	public static String HTTP_XNXZ_SERVER_APP = "http://120.79.137.110:80";//test
//	public static String HTTP_XNXZ_SERVER_APP = "";//pre
//	public static String HTTP_XNXZ_SERVER_APP = "";//production

	String YZM_URL = HTTP_XNXZ_SERVER_APP + "/api/v1/sms/send";
	String LOGIN_URL = HTTP_XNXZ_SERVER_APP + "/api/v1/auth/login";
	String REGISTER_URL = HTTP_XNXZ_SERVER_APP + "/api/v1/auth/signup";
	String FORGET_URL = HTTP_XNXZ_SERVER_APP + "/api/v1/auth/reset-password";
	String HOME_URL = HTTP_XNXZ_SERVER_APP + "/api/v1/home/tourist-index?&order_id=2018022295140111&access_token=";
	String ROUTE_URL = HTTP_XNXZ_SERVER_APP + "/api/v1/route/hot-route?access_token=";
	String GUIDE_URL = HTTP_XNXZ_SERVER_APP + "/api/v1/guide/guide-info?access_token=";
	String GUIDE_ORDER_URL = HTTP_XNXZ_SERVER_APP + "/api/v1/order/tourist-order-info?access_token=";
	String ORDER_LIST = HTTP_XNXZ_SERVER_APP + "/api/v1/order/tourist-order-list?access_token=";
	String ONE_STEP_URL = HTTP_XNXZ_SERVER_APP + "/api/v1/order/custom-order?access_token=";
}
