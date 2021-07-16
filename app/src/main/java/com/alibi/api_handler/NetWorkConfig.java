package com.alibi.api_handler;

public class NetWorkConfig {
    //Production Url
    public static String _BASE_URL_PROD = "https://followchess.com/";
    //Development Url
    public static String _BASE_URL_DEV = "https://followchess.com/";
    private static final String _ENV = "DEV"; // DEV / PRODUCTION

    public static String GET_BASE_URL() {
        if (_ENV.equals("PRODUCTION"))
            return _BASE_URL_PROD;
        else
            return _BASE_URL_DEV;
    }
}
