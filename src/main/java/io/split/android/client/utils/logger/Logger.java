package io.split.android.client.utils.logger;

/* JADX INFO: loaded from: classes4.dex */
public class Logger {
    private static final String TAG = "SplitSDK";
    private static volatile Logger instance;
    private int mLevel = -100;
    private LogPrinter mLogPrinter = new LogPrinterImpl();

    private Logger() {
    }

    public static synchronized Logger instance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void setLevel(int logLevel) {
        this.mLevel = logLevel;
    }

    public void setPrinter(LogPrinter printer) {
        this.mLogPrinter = printer;
    }

    private void log(int priority, String msg, Throwable tr) {
        int i = this.mLevel;
        if (i == -100 || priority < 2 || i > priority) {
            return;
        }
        switch (priority) {
            case 2:
                this.mLogPrinter.v(TAG, msg, tr);
                break;
            case 3:
                this.mLogPrinter.d(TAG, msg, tr);
                break;
            case 4:
                this.mLogPrinter.i(TAG, msg, tr);
                break;
            case 5:
                this.mLogPrinter.w(TAG, msg, tr);
                break;
            case 6:
                this.mLogPrinter.e(TAG, msg, tr);
                break;
            case 7:
                this.mLogPrinter.wtf(TAG, msg, tr);
                break;
        }
    }

    private static String formatMessage(String message, Object[] args) {
        return (args == null || args.length <= 0) ? message : String.format(message, args);
    }

    public static void v(String msg, Object... args) {
        v(formatMessage(msg, args));
    }

    public static void v(String msg) {
        instance().log(2, msg, null);
    }

    public static void v(String msg, Throwable tr) {
        instance().log(2, msg, tr);
    }

    public static void d(String msg, Object... args) {
        d(formatMessage(msg, args));
    }

    public static void d(String msg) {
        instance().log(3, msg, null);
    }

    public static void d(String msg, Throwable tr) {
        instance().log(3, msg, tr);
    }

    public static void i(String msg, Object... args) {
        i(formatMessage(msg, args));
    }

    public static void i(String msg) {
        instance().log(4, msg, null);
    }

    public static void i(String msg, Throwable tr) {
        instance().log(4, msg, tr);
    }

    public static void w(String msg, Object... args) {
        w(formatMessage(msg, args));
    }

    public static void w(Throwable tr, String msg, Object... args) {
        w(formatMessage(msg, args), tr);
    }

    public static void w(String msg) {
        instance().log(5, msg, null);
    }

    public static void w(String msg, Throwable tr) {
        instance().log(5, msg, tr);
    }

    public static void e(String msg, Object... args) {
        e(formatMessage(msg, args));
    }

    public static void e(Throwable tr, String msg, Object... args) {
        e(formatMessage(msg, args), tr);
    }

    public static void e(String msg) {
        instance().log(6, msg, null);
    }

    public static void e(String msg, Throwable tr) {
        instance().log(6, msg, tr);
    }

    public static void e(Throwable tr) {
        instance().log(6, "", tr);
    }

    public static void wtf(String msg, Object... args) {
        wtf(formatMessage(msg, args));
    }

    public static void wtf(String msg) {
        instance().log(7, msg, null);
    }

    public static void wtf(String msg, Throwable tr) {
        instance().log(7, msg, tr);
    }
}
