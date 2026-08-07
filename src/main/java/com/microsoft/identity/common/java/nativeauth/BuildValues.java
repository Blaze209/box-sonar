package com.microsoft.identity.common.java.nativeauth;

import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes14.dex */
public class BuildValues {

    @Nonnull
    private static String DC = "";

    @Nonnull
    private static Boolean USE_MOCK_API_FOR_NATIVE_AUTH_AUTHORITY = false;
    private static String MOCK_API_URL = "";
    private static String NATIVE_AUTH_CONFIG_STRING = "";
    private static String NATIVE_AUTH_CONFIG_FILE_PATH = "";

    public static String getDC() {
        return DC;
    }

    public static void setDC(String str) {
        DC = str;
    }

    public static Boolean shouldUseMockApiForNativeAuth() {
        return USE_MOCK_API_FOR_NATIVE_AUTH_AUTHORITY;
    }

    public static void setUseMockApiForNativeAuth(Boolean bool) {
        USE_MOCK_API_FOR_NATIVE_AUTH_AUTHORITY = bool;
    }

    public static String getMockApiUrl() {
        return MOCK_API_URL;
    }

    public static String getNativeAuthConfigString() {
        return NATIVE_AUTH_CONFIG_STRING;
    }

    public static String getNativeAuthConfigFilePath() {
        return NATIVE_AUTH_CONFIG_FILE_PATH;
    }
}
