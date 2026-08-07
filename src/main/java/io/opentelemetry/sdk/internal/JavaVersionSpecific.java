package io.opentelemetry.sdk.internal;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
public class JavaVersionSpecific {
    private static final JavaVersionSpecific CURRENT;
    private static final Logger logger;

    static {
        Logger logger2 = Logger.getLogger(JavaVersionSpecific.class.getName());
        logger = logger2;
        JavaVersionSpecific javaVersionSpecific = CurrentJavaVersionSpecific.get();
        CURRENT = javaVersionSpecific;
        if (javaVersionSpecific.getClass() != JavaVersionSpecific.class) {
            logger2.log(Level.FINE, "Using the APIs optimized for: {0}", javaVersionSpecific.name());
        }
    }

    public static JavaVersionSpecific get() {
        return CURRENT;
    }

    String name() {
        return "Java 8";
    }

    public long currentTimeNanos() {
        return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
    }
}
