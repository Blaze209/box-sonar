package org.tinylog;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.tinylog.configuration.Configuration;
import org.tinylog.format.AdvancedMessageFormatter;
import org.tinylog.format.MessageFormatter;
import org.tinylog.provider.LoggingProvider;
import org.tinylog.provider.ProviderRegistry;

/* JADX INFO: loaded from: classes5.dex */
public final class Logger {
    private static final int STACKTRACE_DEPTH = 2;
    private static final TaggedLogger instance;
    private static final ConcurrentMap<Set<String>, TaggedLogger> loggers;
    private static final MessageFormatter formatter = new AdvancedMessageFormatter(Configuration.getLocale(), Configuration.isEscapingEnabled());
    private static final LoggingProvider provider = ProviderRegistry.getLoggingProvider();
    private static final boolean MINIMUM_LEVEL_COVERS_TRACE = isCoveredByMinimumLevel(Level.TRACE);
    private static final boolean MINIMUM_LEVEL_COVERS_DEBUG = isCoveredByMinimumLevel(Level.DEBUG);
    private static final boolean MINIMUM_LEVEL_COVERS_INFO = isCoveredByMinimumLevel(Level.INFO);
    private static final boolean MINIMUM_LEVEL_COVERS_WARN = isCoveredByMinimumLevel(Level.WARN);
    private static final boolean MINIMUM_LEVEL_COVERS_ERROR = isCoveredByMinimumLevel(Level.ERROR);

    static {
        TaggedLogger taggedLogger = new TaggedLogger((String) null);
        instance = taggedLogger;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        loggers = concurrentHashMap;
        concurrentHashMap.put(toUnmodifiableTagsSet(null), taggedLogger);
    }

    private Logger() {
    }

    public static TaggedLogger tag(String str) {
        return (str == null || str.isEmpty()) ? instance : tags(str);
    }

    public static TaggedLogger tags(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return instance;
        }
        Set<String> unmodifiableTagsSet = toUnmodifiableTagsSet(strArr);
        ConcurrentMap<Set<String>, TaggedLogger> concurrentMap = loggers;
        TaggedLogger taggedLogger = concurrentMap.get(unmodifiableTagsSet);
        if (taggedLogger != null) {
            return taggedLogger;
        }
        TaggedLogger taggedLogger2 = new TaggedLogger(unmodifiableTagsSet);
        TaggedLogger taggedLoggerPutIfAbsent = concurrentMap.putIfAbsent(unmodifiableTagsSet, taggedLogger2);
        return taggedLoggerPutIfAbsent == null ? taggedLogger2 : taggedLoggerPutIfAbsent;
    }

    private static Set<String> toUnmodifiableTagsSet(String... strArr) {
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            if (str == null || str.isEmpty()) {
                hashSet.add(null);
            } else {
                hashSet.add(str);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public static boolean isTraceEnabled() {
        return MINIMUM_LEVEL_COVERS_TRACE && provider.isEnabled(2, (String) null, Level.TRACE);
    }

    public static void trace(Object obj) {
        if (MINIMUM_LEVEL_COVERS_TRACE) {
            provider.log(2, (String) null, Level.TRACE, (Throwable) null, (MessageFormatter) null, obj, (Object[]) null);
        }
    }

    public static void trace(Supplier<?> supplier) {
        if (MINIMUM_LEVEL_COVERS_TRACE) {
            provider.log(2, (String) null, Level.TRACE, (Throwable) null, (MessageFormatter) null, supplier, (Object[]) null);
        }
    }

    public static void trace(String str, Object... objArr) {
        if (MINIMUM_LEVEL_COVERS_TRACE) {
            provider.log(2, (String) null, Level.TRACE, (Throwable) null, formatter, str, objArr);
        }
    }

    public static void trace(String str, Supplier<?>... supplierArr) {
        if (MINIMUM_LEVEL_COVERS_TRACE) {
            provider.log(2, (String) null, Level.TRACE, (Throwable) null, formatter, str, supplierArr);
        }
    }

    public static void trace(Throwable th) {
        if (MINIMUM_LEVEL_COVERS_TRACE) {
            provider.log(2, (String) null, Level.TRACE, th, (MessageFormatter) null, (Object) null, (Object[]) null);
        }
    }

    public static void trace(Throwable th, String str) {
        if (MINIMUM_LEVEL_COVERS_TRACE) {
            provider.log(2, (String) null, Level.TRACE, th, (MessageFormatter) null, str, (Object[]) null);
        }
    }

    public static void trace(Throwable th, Supplier<String> supplier) {
        if (MINIMUM_LEVEL_COVERS_TRACE) {
            provider.log(2, (String) null, Level.TRACE, th, (MessageFormatter) null, supplier, (Object[]) null);
        }
    }

    public static void trace(Throwable th, String str, Object... objArr) {
        if (MINIMUM_LEVEL_COVERS_TRACE) {
            provider.log(2, (String) null, Level.TRACE, th, formatter, str, objArr);
        }
    }

    public static void trace(Throwable th, String str, Supplier<?>... supplierArr) {
        if (MINIMUM_LEVEL_COVERS_TRACE) {
            provider.log(2, (String) null, Level.TRACE, th, formatter, str, supplierArr);
        }
    }

    public static boolean isDebugEnabled() {
        return MINIMUM_LEVEL_COVERS_DEBUG && provider.isEnabled(2, (String) null, Level.DEBUG);
    }

    public static void debug(Object obj) {
        if (MINIMUM_LEVEL_COVERS_DEBUG) {
            provider.log(2, (String) null, Level.DEBUG, (Throwable) null, (MessageFormatter) null, obj, (Object[]) null);
        }
    }

    public static void debug(Supplier<?> supplier) {
        if (MINIMUM_LEVEL_COVERS_DEBUG) {
            provider.log(2, (String) null, Level.DEBUG, (Throwable) null, (MessageFormatter) null, supplier, (Object[]) null);
        }
    }

    public static void debug(String str, Object... objArr) {
        if (MINIMUM_LEVEL_COVERS_DEBUG) {
            provider.log(2, (String) null, Level.DEBUG, (Throwable) null, formatter, str, objArr);
        }
    }

    public static void debug(String str, Supplier<?>... supplierArr) {
        if (MINIMUM_LEVEL_COVERS_DEBUG) {
            provider.log(2, (String) null, Level.DEBUG, (Throwable) null, formatter, str, supplierArr);
        }
    }

    public static void debug(Throwable th) {
        if (MINIMUM_LEVEL_COVERS_DEBUG) {
            provider.log(2, (String) null, Level.DEBUG, th, (MessageFormatter) null, (Object) null, (Object[]) null);
        }
    }

    public static void debug(Throwable th, String str) {
        if (MINIMUM_LEVEL_COVERS_DEBUG) {
            provider.log(2, (String) null, Level.DEBUG, th, (MessageFormatter) null, str, (Object[]) null);
        }
    }

    public static void debug(Throwable th, Supplier<String> supplier) {
        if (MINIMUM_LEVEL_COVERS_DEBUG) {
            provider.log(2, (String) null, Level.DEBUG, th, (MessageFormatter) null, supplier, (Object[]) null);
        }
    }

    public static void debug(Throwable th, String str, Object... objArr) {
        if (MINIMUM_LEVEL_COVERS_DEBUG) {
            provider.log(2, (String) null, Level.DEBUG, th, formatter, str, objArr);
        }
    }

    public static void debug(Throwable th, String str, Supplier<?>... supplierArr) {
        if (MINIMUM_LEVEL_COVERS_DEBUG) {
            provider.log(2, (String) null, Level.DEBUG, th, formatter, str, supplierArr);
        }
    }

    public static boolean isInfoEnabled() {
        return MINIMUM_LEVEL_COVERS_INFO && provider.isEnabled(2, (String) null, Level.INFO);
    }

    public static void info(Object obj) {
        if (MINIMUM_LEVEL_COVERS_INFO) {
            provider.log(2, (String) null, Level.INFO, (Throwable) null, (MessageFormatter) null, obj, (Object[]) null);
        }
    }

    public static void info(Supplier<?> supplier) {
        if (MINIMUM_LEVEL_COVERS_INFO) {
            provider.log(2, (String) null, Level.INFO, (Throwable) null, (MessageFormatter) null, supplier, (Object[]) null);
        }
    }

    public static void info(String str, Object... objArr) {
        if (MINIMUM_LEVEL_COVERS_INFO) {
            provider.log(2, (String) null, Level.INFO, (Throwable) null, formatter, str, objArr);
        }
    }

    public static void info(String str, Supplier<?>... supplierArr) {
        if (MINIMUM_LEVEL_COVERS_INFO) {
            provider.log(2, (String) null, Level.INFO, (Throwable) null, formatter, str, supplierArr);
        }
    }

    public static void info(Throwable th) {
        if (MINIMUM_LEVEL_COVERS_INFO) {
            provider.log(2, (String) null, Level.INFO, th, (MessageFormatter) null, (Object) null, (Object[]) null);
        }
    }

    public static void info(Throwable th, String str) {
        if (MINIMUM_LEVEL_COVERS_INFO) {
            provider.log(2, (String) null, Level.INFO, th, (MessageFormatter) null, str, (Object[]) null);
        }
    }

    public static void info(Throwable th, Supplier<String> supplier) {
        if (MINIMUM_LEVEL_COVERS_INFO) {
            provider.log(2, (String) null, Level.INFO, th, (MessageFormatter) null, supplier, (Object[]) null);
        }
    }

    public static void info(Throwable th, String str, Object... objArr) {
        if (MINIMUM_LEVEL_COVERS_INFO) {
            provider.log(2, (String) null, Level.INFO, th, formatter, str, objArr);
        }
    }

    public static void info(Throwable th, String str, Supplier<?>... supplierArr) {
        if (MINIMUM_LEVEL_COVERS_INFO) {
            provider.log(2, (String) null, Level.INFO, th, formatter, str, supplierArr);
        }
    }

    public static boolean isWarnEnabled() {
        return MINIMUM_LEVEL_COVERS_WARN && provider.isEnabled(2, (String) null, Level.WARN);
    }

    public static void warn(Object obj) {
        if (MINIMUM_LEVEL_COVERS_WARN) {
            provider.log(2, (String) null, Level.WARN, (Throwable) null, (MessageFormatter) null, obj, (Object[]) null);
        }
    }

    public static void warn(Supplier<?> supplier) {
        if (MINIMUM_LEVEL_COVERS_WARN) {
            provider.log(2, (String) null, Level.WARN, (Throwable) null, (MessageFormatter) null, supplier, (Object[]) null);
        }
    }

    public static void warn(String str, Object... objArr) {
        if (MINIMUM_LEVEL_COVERS_WARN) {
            provider.log(2, (String) null, Level.WARN, (Throwable) null, formatter, str, objArr);
        }
    }

    public static void warn(String str, Supplier<?>... supplierArr) {
        if (MINIMUM_LEVEL_COVERS_WARN) {
            provider.log(2, (String) null, Level.WARN, (Throwable) null, formatter, str, supplierArr);
        }
    }

    public static void warn(Throwable th) {
        if (MINIMUM_LEVEL_COVERS_WARN) {
            provider.log(2, (String) null, Level.WARN, th, (MessageFormatter) null, (Object) null, (Object[]) null);
        }
    }

    public static void warn(Throwable th, String str) {
        if (MINIMUM_LEVEL_COVERS_WARN) {
            provider.log(2, (String) null, Level.WARN, th, (MessageFormatter) null, str, (Object[]) null);
        }
    }

    public static void warn(Throwable th, Supplier<String> supplier) {
        if (MINIMUM_LEVEL_COVERS_WARN) {
            provider.log(2, (String) null, Level.WARN, th, (MessageFormatter) null, supplier, (Object[]) null);
        }
    }

    public static void warn(Throwable th, String str, Object... objArr) {
        if (MINIMUM_LEVEL_COVERS_WARN) {
            provider.log(2, (String) null, Level.WARN, th, formatter, str, objArr);
        }
    }

    public static void warn(Throwable th, String str, Supplier<?>... supplierArr) {
        if (MINIMUM_LEVEL_COVERS_WARN) {
            provider.log(2, (String) null, Level.WARN, th, formatter, str, supplierArr);
        }
    }

    public static boolean isErrorEnabled() {
        return MINIMUM_LEVEL_COVERS_ERROR && provider.isEnabled(2, (String) null, Level.ERROR);
    }

    public static void error(Object obj) {
        if (MINIMUM_LEVEL_COVERS_ERROR) {
            provider.log(2, (String) null, Level.ERROR, (Throwable) null, (MessageFormatter) null, obj, (Object[]) null);
        }
    }

    public static void error(Supplier<?> supplier) {
        if (MINIMUM_LEVEL_COVERS_ERROR) {
            provider.log(2, (String) null, Level.ERROR, (Throwable) null, (MessageFormatter) null, supplier, (Object[]) null);
        }
    }

    public static void error(String str, Object... objArr) {
        if (MINIMUM_LEVEL_COVERS_ERROR) {
            provider.log(2, (String) null, Level.ERROR, (Throwable) null, formatter, str, objArr);
        }
    }

    public static void error(String str, Supplier<?>... supplierArr) {
        if (MINIMUM_LEVEL_COVERS_ERROR) {
            provider.log(2, (String) null, Level.ERROR, (Throwable) null, formatter, str, supplierArr);
        }
    }

    public static void error(Throwable th) {
        if (MINIMUM_LEVEL_COVERS_ERROR) {
            provider.log(2, (String) null, Level.ERROR, th, (MessageFormatter) null, (Object) null, (Object[]) null);
        }
    }

    public static void error(Throwable th, String str) {
        if (MINIMUM_LEVEL_COVERS_ERROR) {
            provider.log(2, (String) null, Level.ERROR, th, (MessageFormatter) null, str, (Object[]) null);
        }
    }

    public static void error(Throwable th, Supplier<String> supplier) {
        if (MINIMUM_LEVEL_COVERS_ERROR) {
            provider.log(2, (String) null, Level.ERROR, th, (MessageFormatter) null, supplier, (Object[]) null);
        }
    }

    public static void error(Throwable th, String str, Object... objArr) {
        if (MINIMUM_LEVEL_COVERS_ERROR) {
            provider.log(2, (String) null, Level.ERROR, th, formatter, str, objArr);
        }
    }

    public static void error(Throwable th, String str, Supplier<?>... supplierArr) {
        if (MINIMUM_LEVEL_COVERS_ERROR) {
            provider.log(2, (String) null, Level.ERROR, th, formatter, str, supplierArr);
        }
    }

    private static boolean isCoveredByMinimumLevel(Level level) {
        return provider.getMinimumLevel(null).ordinal() <= level.ordinal();
    }
}
