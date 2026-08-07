package com.pspdfkit.utils;

import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public class LogCatLogger implements PdfLog.Logger {
    private boolean isEnabled = true;

    @Override // com.pspdfkit.utils.PdfLog.Logger
    public boolean isLogged(int i, String str) {
        return this.isEnabled;
    }

    @Override // com.pspdfkit.utils.PdfLog.Logger
    public void log(int i, String str, String str2, Throwable th) {
        switch (i) {
            case 2:
                Log.v(str, str2);
                break;
            case 3:
                Log.d(str, str2);
                break;
            case 4:
                Log.i(str, str2);
                break;
            case 5:
                Log.w(str, str2);
                break;
            case 6:
                Log.e(str, str2);
                break;
            case 7:
                Log.wtf(str, str2);
                break;
        }
    }

    public void setEnabled(boolean z) {
        this.isEnabled = z;
    }
}
