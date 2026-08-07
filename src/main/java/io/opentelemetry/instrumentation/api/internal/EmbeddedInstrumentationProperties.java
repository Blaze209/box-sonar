package io.opentelemetry.instrumentation.api.internal;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class EmbeddedInstrumentationProperties {
    private static final ClassLoader DEFAULT_LOADER;
    private static volatile ClassLoader loader;
    private static final Logger logger = Logger.getLogger(EmbeddedInstrumentationProperties.class.getName());
    private static final Map<String, String> versions;

    static {
        ClassLoader classLoader = EmbeddedInstrumentationProperties.class.getClassLoader();
        if (classLoader == null) {
            classLoader = new BootstrapProxy();
        }
        DEFAULT_LOADER = classLoader;
        loader = classLoader;
        versions = new ConcurrentHashMap();
    }

    public static void setPropertiesLoader(ClassLoader classLoader) {
        if (loader != DEFAULT_LOADER) {
            logger.warning("Embedded properties loader has already been set up, further setPropertiesLoader() calls are ignored");
        } else {
            loader = classLoader;
        }
    }

    @Nullable
    public static String findVersion(String str) {
        return versions.computeIfAbsent(str, new Function() { // from class: io.opentelemetry.instrumentation.api.internal.EmbeddedInstrumentationProperties$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return EmbeddedInstrumentationProperties.loadVersion((String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static String loadVersion(String str) {
        String str2 = "META-INF/io/opentelemetry/instrumentation/" + str + ".properties";
        try {
            InputStream resourceAsStream = loader.getResourceAsStream(str2);
            try {
                if (resourceAsStream == null) {
                    logger.log(Level.FINE, "Did not find embedded instrumentation properties file {0}", str2);
                    if (resourceAsStream != null) {
                        resourceAsStream.close();
                    }
                    return null;
                }
                Properties properties = new Properties();
                properties.load(resourceAsStream);
                String property = properties.getProperty("version");
                if (resourceAsStream != null) {
                    resourceAsStream.close();
                }
                return property;
            } catch (Throwable th) {
                if (resourceAsStream != null) {
                    try {
                        resourceAsStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (IOException e) {
            logger.log(Level.FINE, "Failed to load embedded instrumentation properties file " + str2, (Throwable) e);
            return null;
        }
    }

    private static final class BootstrapProxy extends ClassLoader {
        BootstrapProxy() {
            super(null);
        }
    }

    private EmbeddedInstrumentationProperties() {
    }
}
