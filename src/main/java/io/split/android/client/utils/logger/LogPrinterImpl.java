package io.split.android.client.utils.logger;

import android.util.Log;

/* JADX INFO: loaded from: classes4.dex */
public class LogPrinterImpl implements LogPrinter {
    @Override // io.split.android.client.utils.logger.LogPrinter
    public void v(String tag, String msg, Throwable tr) {
        Log.v(tag, msg);
    }

    @Override // io.split.android.client.utils.logger.LogPrinter
    public void d(String tag, String msg, Throwable tr) {
        Log.d(tag, msg, tr);
    }

    @Override // io.split.android.client.utils.logger.LogPrinter
    public void i(String tag, String msg, Throwable tr) {
        Log.i(tag, msg, tr);
    }

    @Override // io.split.android.client.utils.logger.LogPrinter
    public void w(String tag, String msg, Throwable tr) {
        Log.w(tag, msg, tr);
    }

    @Override // io.split.android.client.utils.logger.LogPrinter
    public void e(String tag, String msg, Throwable tr) {
        Log.e(tag, msg, tr);
    }

    @Override // io.split.android.client.utils.logger.LogPrinter
    public void wtf(String tag, String msg, Throwable tr) {
        Log.wtf(tag, msg, tr);
    }
}
