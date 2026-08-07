package uk.co.senab.photoview.log;

/* JADX INFO: loaded from: classes6.dex */
public final class LogManager {
    private static Logger logger = new LoggerDefault();

    public static void setLogger(Logger logger2) {
        logger = logger2;
    }

    public static Logger getLogger() {
        return logger;
    }
}
