package com.microsoft.identity.common.java.telemetry;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes14.dex */
@Deprecated
public class TelemetryConfiguration implements Serializable {
    private static final long serialVersionUID = 4048693049821792485L;

    @SerializedName("pii_enabled")
    private boolean mPiiEnabled = false;

    @SerializedName(SerializedNames.NOTIFY_ON_FAILTURE_ONLY)
    private boolean mNotifyOnFailureOnly = true;

    @SerializedName(SerializedNames.DEBUG_ENABLED)
    private boolean mDebugEnabled = false;

    public static final class SerializedNames {
        public static final String DEBUG_ENABLED = "debug_enabled";
        public static final String NOTIFY_ON_FAILTURE_ONLY = "notify_on_failure_only";
        public static final String PII_ENABLED = "pii_enabled";
    }

    public boolean isPiiEnabled() {
        return this.mPiiEnabled;
    }

    public void setPiiEnabled(boolean z) {
        this.mPiiEnabled = z;
    }

    public boolean shouldNotifyOnFailureOnly() {
        return this.mNotifyOnFailureOnly;
    }

    public void setNotifyOnFailureOnly(boolean z) {
        this.mNotifyOnFailureOnly = z;
    }

    public boolean isDebugEnabled() {
        return this.mDebugEnabled;
    }

    public void setDebugEnabled(boolean z) {
        this.mDebugEnabled = z;
    }
}
