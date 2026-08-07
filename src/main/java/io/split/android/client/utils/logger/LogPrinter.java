package io.split.android.client.utils.logger;

/* JADX INFO: loaded from: classes4.dex */
public interface LogPrinter {
    void d(String tag, String msg, Throwable tr);

    void e(String tag, String msg, Throwable tr);

    void i(String tag, String msg, Throwable tr);

    void v(String tag, String msg, Throwable tr);

    void w(String tag, String msg, Throwable tr);

    void wtf(String tag, String msg, Throwable tr);
}
