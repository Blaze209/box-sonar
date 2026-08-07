package com.microsoft.identity.common.java.telemetry.rules;

import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.java.util.StringUtil;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes14.dex */
@Deprecated
public final class TelemetryPiiOiiRules {
    private static TelemetryPiiOiiRules sInstance;
    private final String[] oiiArray;
    private Set<String> oiiPropertiesSet;
    private final String[] piiArray;
    private Set<String> piiPropertiesSet;

    private TelemetryPiiOiiRules() {
        String[] strArr = {TelemetryEventStrings.Key.USER_ID, TelemetryEventStrings.Device.ID, TelemetryEventStrings.Key.LOGIN_HINT, TelemetryEventStrings.Key.ERROR_DESCRIPTION, TelemetryEventStrings.Key.REQUEST_QUERY_PARAMS, TelemetryEventStrings.Key.REDIRECT_URI, TelemetryEventStrings.Key.SCOPE, TelemetryEventStrings.Key.CLAIM_REQUEST};
        this.piiArray = strArr;
        String[] strArr2 = {TelemetryEventStrings.Key.TENANT_ID, TelemetryEventStrings.Key.CLIENT_ID, TelemetryEventStrings.Key.REDIRECT_URI, TelemetryEventStrings.Key.HTTP_PATH, TelemetryEventStrings.Key.AUTHORITY, TelemetryEventStrings.Key.IDP_NAME, TelemetryEventStrings.Key.CALLER_APP_PACKAGE_NAME, TelemetryEventStrings.Key.CALLER_APP_UUID, TelemetryEventStrings.Key.CALLER_APP_VERSION};
        this.oiiArray = strArr2;
        this.piiPropertiesSet = new HashSet(Arrays.asList(strArr));
        this.oiiPropertiesSet = new HashSet(Arrays.asList(strArr2));
    }

    public static synchronized TelemetryPiiOiiRules getInstance() {
        if (sInstance == null) {
            sInstance = new TelemetryPiiOiiRules();
        }
        return sInstance;
    }

    public boolean isPii(String str) {
        if (StringUtil.isNullOrEmpty(str)) {
            return false;
        }
        return this.piiPropertiesSet.contains(str);
    }

    public boolean isOii(String str) {
        if (StringUtil.isNullOrEmpty(str)) {
            return false;
        }
        return this.oiiPropertiesSet.contains(str);
    }

    public boolean isPiiOrOii(String str) {
        return isPii(str) || isOii(str);
    }
}
