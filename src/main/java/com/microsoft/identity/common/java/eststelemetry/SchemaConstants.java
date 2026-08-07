package com.microsoft.identity.common.java.eststelemetry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public class SchemaConstants {
    public static final String CURRENT_PLATFORM_SCHEMA_VERSION = "2";
    public static final String CURRENT_REQUEST_HEADER_NAME = "x-client-current-telemetry";
    public static final String CURRENT_SCHEMA_VERSION = "2";
    public static final int HEADER_DATA_LIMIT = 3800;
    public static final String LAST_REQUEST_HEADER_NAME = "x-client-last-telemetry";
    public static final String SCHEMA_VERSION_KEY = "schema_version";
    public static final String SEPARATOR_COMMA = ",";
    public static final String SEPARATOR_PIPE = "|";
    private static final List<String> currentRequestAndroidPlatformFields = Arrays.asList("Microsoft.MSAL.account_status", "Microsoft.MSAL.id_token_status", "Microsoft.MSAL.at_status", "Microsoft.MSAL.rt_status", "Microsoft.MSAL.frt_status", "Microsoft.MSAL.mrrt_status");
    private static final List<String> currentRequestSharedFlwPlatformFieldsForAndroidAndiOSBroker = Arrays.asList(Key.IS_SHARED_DEVICE, Key.REG_TYPE, Key.REG_SOURCE, Key.FLW_SIGNOUT_APP, Key.FLW_SIGNIN_APP);
    private static final List<String> currentRequestSharedMultipleWpjPlatformFieldsForAndroidAndiOSBroker = Arrays.asList(Key.IS_SHARED_DEVICE, Key.REG_NUM, Key.CLOUD_NUM, Key.REG_SEQ_NUM, Key.REQ_PURPOSE, Key.REG_SOURCE);
    private static final List<String> lastRequestPlatformFields = Arrays.asList(Key.PLATFORM_SCHEMA_VERSION, Key.ALL_TELEMETRY_DATA_SENT);
    private static final List<String> allowedFieldsForOfflineEmit = Arrays.asList(Key.FLW_SIGNIN_APP, Key.FLW_SIGNOUT_APP);

    public static final class Key {
        public static final String ACCOUNT_STATUS = "Microsoft.MSAL.account_status";
        public static final String ALL_TELEMETRY_DATA_SENT = "is_all_telemetry_data_sent";
        public static final String API_ID = "Microsoft.MSAL.api_id";
        public static final String AT_STATUS = "Microsoft.MSAL.at_status";
        public static final String CLOUD_NUM = "cloud_num";
        public static final String CORRELATION_ID = "Microsoft.MSAL.correlation_id";
        public static final String ERROR_CODE = "Microsoft.MSAL.error_code";
        public static final String FLW_SIGNIN_APP = "flw_signin_app";
        public static final String FLW_SIGNOUT_APP = "flw_signout_app";
        public static final String FORCE_REFRESH = "Microsoft.MSAL.force_refresh";
        public static final String FRT_STATUS = "Microsoft.MSAL.frt_status";
        public static final String ID_TOKEN_STATUS = "Microsoft.MSAL.id_token_status";
        public static final String IS_SHARED_DEVICE = "isSharedScenario";
        public static final String MRRT_STATUS = "Microsoft.MSAL.mrrt_status";
        public static final String PLATFORM_SCHEMA_VERSION = "platform_schema_version";
        public static final String REG_NUM = "reg_num";
        public static final String REG_SEQ_NUM = "reg_seq_num";
        public static final String REG_SOURCE = "reg_source";
        public static final String REG_TYPE = "reg_type";
        public static final String REQ_PURPOSE = "req_purpose";
        public static final String RT_STATUS = "Microsoft.MSAL.rt_status";
    }

    public static final class Value {
        public static final String EMPTY = "";
        public static final String FALSE = "0";
        public static final String TRUE = "1";
    }

    static boolean isCurrentPlatformField(String str) {
        return currentRequestAndroidPlatformFields.contains(str) || currentRequestSharedFlwPlatformFieldsForAndroidAndiOSBroker.contains(str) || currentRequestSharedMultipleWpjPlatformFieldsForAndroidAndiOSBroker.contains(str);
    }

    static boolean isLastPlatformField(String str) {
        return lastRequestPlatformFields.contains(str);
    }

    static boolean isOfflineEmitAllowedForThisField(String str) {
        return allowedFieldsForOfflineEmit.contains(str);
    }

    static List<String> getCurrentRequestPlatformFields(boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Key.PLATFORM_SCHEMA_VERSION);
        if (z) {
            arrayList.addAll(currentRequestSharedFlwPlatformFieldsForAndroidAndiOSBroker);
        } else {
            arrayList.addAll(currentRequestSharedMultipleWpjPlatformFieldsForAndroidAndiOSBroker);
        }
        arrayList.addAll(currentRequestAndroidPlatformFields);
        return arrayList;
    }

    static List<String> getLastRequestPlatformFields() {
        return lastRequestPlatformFields;
    }
}
