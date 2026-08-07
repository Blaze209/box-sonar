package com.microsoft.identity.client.configuration;

import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.client.Logger;

/* JADX INFO: loaded from: classes14.dex */
public class LoggerConfiguration {

    @SerializedName(SerializedNames.LOG_LEVEL)
    private Logger.LogLevel mLogLevel;

    @SerializedName(SerializedNames.LOGCAT_ENABLED)
    private boolean mLogcatEnabled;

    @SerializedName("pii_enabled")
    private boolean mPiiEnabled;

    public static final class SerializedNames {
        public static final String LOGCAT_ENABLED = "logcat_enabled";
        public static final String LOG_LEVEL = "log_level";
        public static final String PII_ENABLED = "pii_enabled";
    }

    public boolean isPiiEnabled() {
        return this.mPiiEnabled;
    }

    public Logger.LogLevel getLogLevel() {
        return this.mLogLevel;
    }

    public boolean isLogcatEnabled() {
        return this.mLogcatEnabled;
    }
}
