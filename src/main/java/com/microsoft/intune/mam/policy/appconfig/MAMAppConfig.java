package com.microsoft.intune.mam.policy.appconfig;

/* JADX INFO: loaded from: classes3.dex */
public interface MAMAppConfig extends MAMAppConfigBase {

    public enum BooleanQueryType {
        Any,
        Or,
        And
    }

    public enum NumberQueryType {
        Any,
        Min,
        Max
    }

    public enum StringQueryType {
        Any,
        Min,
        Max
    }

    Boolean getBooleanForKey(String str, BooleanQueryType booleanQueryType);

    Double getDoubleForKey(String str, NumberQueryType numberQueryType);

    Long getIntegerForKey(String str, NumberQueryType numberQueryType);

    String getStringForKey(String str, StringQueryType stringQueryType);
}
