package org.tinylog.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ServiceLoader;
import org.tinylog.Level;
import org.tinylog.configuration.Configuration;
import org.tinylog.runtime.RuntimeProvider;

/* JADX INFO: loaded from: classes5.dex */
public final class ProviderRegistry {
    private static final String NOP_PROVIDER_NAME = "nop";
    private static final String PROVIDER_PROPERTY = "provider";
    private static final LoggingProvider loggingProvider = loadLoggingProvider();

    private ProviderRegistry() {
    }

    public static LoggingProvider getLoggingProvider() {
        return loggingProvider;
    }

    public static List<LoggingProvider> getLoggingProviders() {
        LoggingProvider loggingProvider2 = loggingProvider;
        if (loggingProvider2 instanceof BundleLoggingProvider) {
            return ((BundleLoggingProvider) loggingProvider2).getLoggingProviders();
        }
        return Collections.singletonList(loggingProvider2);
    }

    private static LoggingProvider loadLoggingProvider() {
        if (RuntimeProvider.getProcessId() == Long.MIN_VALUE) {
            ServiceLoader.load(LoggingProvider.class);
        }
        org.tinylog.configuration.ServiceLoader serviceLoader = new org.tinylog.configuration.ServiceLoader(LoggingProvider.class, new Class[0]);
        String str = Configuration.get("provider");
        if (str == null) {
            Collection collectionCreateAll = serviceLoader.createAll(new Object[0]);
            int size = collectionCreateAll.size();
            if (size == 0) {
                InternalLogger.log(Level.WARN, "No logging framework implementation found in classpath. Add tinylog-impl.jar for outputting log entries.");
                return new NopLoggingProvider();
            }
            if (size == 1) {
                return (LoggingProvider) collectionCreateAll.iterator().next();
            }
            return new BundleLoggingProvider(collectionCreateAll);
        }
        if (NOP_PROVIDER_NAME.equalsIgnoreCase(str)) {
            return new NopLoggingProvider();
        }
        String[] strArrSplit = str.trim().split(",");
        ArrayList arrayList = new ArrayList(strArrSplit.length);
        for (String str2 : strArrSplit) {
            String strTrim = str2.trim();
            if (strTrim.isEmpty()) {
                InternalLogger.log(Level.WARN, "Requested logging provider 'empty string' will be ignored.");
            } else {
                LoggingProvider loggingProvider2 = (LoggingProvider) serviceLoader.create(strTrim, new Object[0]);
                if (loggingProvider2 == null) {
                    InternalLogger.log(Level.ERROR, "Requested logging provider '" + strTrim + "' is not available.");
                } else {
                    arrayList.add(loggingProvider2);
                }
            }
        }
        if (arrayList.size() == 0) {
            InternalLogger.log(Level.ERROR, "Requested logging provider '" + str + "' is not available. Logging will be disabled.");
            return new NopLoggingProvider();
        }
        if (arrayList.size() == 1) {
            return (LoggingProvider) arrayList.iterator().next();
        }
        return new BundleLoggingProvider(arrayList);
    }
}
