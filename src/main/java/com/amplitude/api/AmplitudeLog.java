package com.amplitude.api;

import android.util.Log;

/* JADX INFO: loaded from: classes9.dex */
public class AmplitudeLog {
    protected static AmplitudeLog instance = new AmplitudeLog();
    private volatile boolean enableLogging = true;
    private volatile int logLevel = 4;
    private AmplitudeLogCallback amplitudeLogCallback = null;

    public static AmplitudeLog getLogger() {
        return instance;
    }

    private AmplitudeLog() {
    }

    AmplitudeLog setEnableLogging(boolean z) {
        this.enableLogging = z;
        return instance;
    }

    AmplitudeLog setLogLevel(int i) {
        this.logLevel = i;
        return instance;
    }

    int d(String str, String str2) {
        if (!this.enableLogging || this.logLevel > 3) {
            return 0;
        }
        return Log.d(str, str2);
    }

    int d(String str, String str2, Throwable th) {
        if (!this.enableLogging || this.logLevel > 3) {
            return 0;
        }
        return Log.d(str, str2, th);
    }

    int e(String str, String str2) {
        if (!this.enableLogging || this.logLevel > 6) {
            return 0;
        }
        AmplitudeLogCallback amplitudeLogCallback = this.amplitudeLogCallback;
        if (amplitudeLogCallback != null) {
            amplitudeLogCallback.onError(str, str2);
        }
        return Log.e(str, str2);
    }

    int e(String str, String str2, Throwable th) {
        if (!this.enableLogging || this.logLevel > 6) {
            return 0;
        }
        AmplitudeLogCallback amplitudeLogCallback = this.amplitudeLogCallback;
        if (amplitudeLogCallback != null) {
            amplitudeLogCallback.onError(str, str2);
        }
        return Log.e(str, str2, th);
    }

    String getStackTraceString(Throwable th) {
        return Log.getStackTraceString(th);
    }

    int i(String str, String str2) {
        if (!this.enableLogging || this.logLevel > 4) {
            return 0;
        }
        return Log.i(str, str2);
    }

    int i(String str, String str2, Throwable th) {
        if (!this.enableLogging || this.logLevel > 4) {
            return 0;
        }
        return Log.i(str, str2, th);
    }

    boolean isLoggable(String str, int i) {
        return Log.isLoggable(str, i);
    }

    int println(int i, String str, String str2) {
        return Log.println(i, str, str2);
    }

    int v(String str, String str2) {
        if (!this.enableLogging || this.logLevel > 2) {
            return 0;
        }
        return Log.v(str, str2);
    }

    int v(String str, String str2, Throwable th) {
        if (!this.enableLogging || this.logLevel > 2) {
            return 0;
        }
        return Log.v(str, str2, th);
    }

    int w(String str, String str2) {
        if (!this.enableLogging || this.logLevel > 5) {
            return 0;
        }
        return Log.w(str, str2);
    }

    int w(String str, Throwable th) {
        if (!this.enableLogging || this.logLevel > 5) {
            return 0;
        }
        return Log.w(str, th);
    }

    int w(String str, String str2, Throwable th) {
        if (!this.enableLogging || this.logLevel > 5) {
            return 0;
        }
        return Log.w(str, str2, th);
    }

    int wtf(String str, String str2) {
        if (!this.enableLogging || this.logLevel > 7) {
            return 0;
        }
        return Log.wtf(str, str2);
    }

    int wtf(String str, Throwable th) {
        if (!this.enableLogging || this.logLevel > 7) {
            return 0;
        }
        return Log.wtf(str, th);
    }

    int wtf(String str, String str2, Throwable th) {
        if (!this.enableLogging || this.logLevel > 7) {
            return 0;
        }
        return Log.wtf(str, str2, th);
    }

    void setAmplitudeLogCallback(AmplitudeLogCallback amplitudeLogCallback) {
        this.amplitudeLogCallback = amplitudeLogCallback;
    }
}
