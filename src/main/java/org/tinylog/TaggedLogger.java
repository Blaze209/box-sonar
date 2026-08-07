package org.tinylog;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.tinylog.configuration.Configuration;
import org.tinylog.format.AdvancedMessageFormatter;
import org.tinylog.format.MessageFormatter;
import org.tinylog.provider.LoggingProvider;
import org.tinylog.provider.ProviderRegistry;

/* JADX INFO: loaded from: classes5.dex */
public final class TaggedLogger {
    private static final int STACKTRACE_DEPTH = 2;
    private static final MessageFormatter formatter = new AdvancedMessageFormatter(Configuration.getLocale(), Configuration.isEscapingEnabled());
    private static final LoggingProvider provider = ProviderRegistry.getLoggingProvider();
    private final Set<String> debugTags;
    private final Set<String> errorTags;
    private final Set<String> infoTags;
    private final boolean minimumLevelCoversDebug;
    private final boolean minimumLevelCoversError;
    private final boolean minimumLevelCoversInfo;
    private final boolean minimumLevelCoversTrace;
    private final boolean minimumLevelCoversWarn;
    private final Set<String> tags;
    private final Set<String> traceTags;
    private final Set<String> warnTags;

    TaggedLogger(String str) {
        this((Set<String>) Collections.singleton(str));
    }

    TaggedLogger(Set<String> set) {
        this.tags = Collections.unmodifiableSet(set);
        Set<String> coveredTags = getCoveredTags(set, Level.TRACE);
        this.traceTags = coveredTags;
        Set<String> coveredTags2 = getCoveredTags(set, Level.DEBUG);
        this.debugTags = coveredTags2;
        Set<String> coveredTags3 = getCoveredTags(set, Level.INFO);
        this.infoTags = coveredTags3;
        Set<String> coveredTags4 = getCoveredTags(set, Level.WARN);
        this.warnTags = coveredTags4;
        Set<String> coveredTags5 = getCoveredTags(set, Level.ERROR);
        this.errorTags = coveredTags5;
        this.minimumLevelCoversTrace = !coveredTags.isEmpty();
        this.minimumLevelCoversDebug = !coveredTags2.isEmpty();
        this.minimumLevelCoversInfo = !coveredTags3.isEmpty();
        this.minimumLevelCoversWarn = !coveredTags4.isEmpty();
        this.minimumLevelCoversError = !coveredTags5.isEmpty();
    }

    public boolean isTraceEnabled() {
        return this.minimumLevelCoversTrace && anyEnabled(this.traceTags, Level.TRACE);
    }

    public void trace(Object obj) {
        if (this.minimumLevelCoversTrace) {
            Iterator<String> it = this.traceTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.TRACE, (Throwable) null, (MessageFormatter) null, obj, (Object[]) null);
            }
        }
    }

    public void trace(Supplier<?> supplier) {
        if (this.minimumLevelCoversTrace) {
            Iterator<String> it = this.traceTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.TRACE, (Throwable) null, (MessageFormatter) null, supplier, (Object[]) null);
            }
        }
    }

    public void trace(String str, Object... objArr) {
        if (this.minimumLevelCoversTrace) {
            Iterator<String> it = this.traceTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.TRACE, (Throwable) null, formatter, str, objArr);
            }
        }
    }

    public void trace(String str, Supplier<?>... supplierArr) {
        if (this.minimumLevelCoversTrace) {
            Iterator<String> it = this.traceTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.TRACE, (Throwable) null, formatter, str, supplierArr);
            }
        }
    }

    public void trace(Throwable th) {
        if (this.minimumLevelCoversTrace) {
            Iterator<String> it = this.traceTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.TRACE, th, (MessageFormatter) null, (Object) null, (Object[]) null);
            }
        }
    }

    public void trace(Throwable th, String str) {
        if (this.minimumLevelCoversTrace) {
            Iterator<String> it = this.traceTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.TRACE, th, (MessageFormatter) null, str, (Object[]) null);
            }
        }
    }

    public void trace(Throwable th, Supplier<String> supplier) {
        if (this.minimumLevelCoversTrace) {
            Iterator<String> it = this.traceTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.TRACE, th, (MessageFormatter) null, supplier, (Object[]) null);
            }
        }
    }

    public void trace(Throwable th, String str, Object... objArr) {
        if (this.minimumLevelCoversTrace) {
            Iterator<String> it = this.traceTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.TRACE, th, formatter, str, objArr);
            }
        }
    }

    public void trace(Throwable th, String str, Supplier<?>... supplierArr) {
        if (this.minimumLevelCoversTrace) {
            Iterator<String> it = this.traceTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.TRACE, th, formatter, str, supplierArr);
            }
        }
    }

    public boolean isDebugEnabled() {
        return this.minimumLevelCoversDebug && anyEnabled(this.debugTags, Level.DEBUG);
    }

    public void debug(Object obj) {
        if (this.minimumLevelCoversDebug) {
            Iterator<String> it = this.debugTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.DEBUG, (Throwable) null, (MessageFormatter) null, obj, (Object[]) null);
            }
        }
    }

    public void debug(Supplier<?> supplier) {
        if (this.minimumLevelCoversDebug) {
            Iterator<String> it = this.debugTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.DEBUG, (Throwable) null, (MessageFormatter) null, supplier, (Object[]) null);
            }
        }
    }

    public void debug(String str, Object... objArr) {
        if (this.minimumLevelCoversDebug) {
            Iterator<String> it = this.debugTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.DEBUG, (Throwable) null, formatter, str, objArr);
            }
        }
    }

    public void debug(String str, Supplier<?>... supplierArr) {
        if (this.minimumLevelCoversDebug) {
            Iterator<String> it = this.debugTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.DEBUG, (Throwable) null, formatter, str, supplierArr);
            }
        }
    }

    public void debug(Throwable th) {
        if (this.minimumLevelCoversDebug) {
            Iterator<String> it = this.debugTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.DEBUG, th, (MessageFormatter) null, (Object) null, (Object[]) null);
            }
        }
    }

    public void debug(Throwable th, String str) {
        if (this.minimumLevelCoversDebug) {
            Iterator<String> it = this.debugTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.DEBUG, th, (MessageFormatter) null, str, (Object[]) null);
            }
        }
    }

    public void debug(Throwable th, Supplier<String> supplier) {
        if (this.minimumLevelCoversDebug) {
            Iterator<String> it = this.debugTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.DEBUG, th, (MessageFormatter) null, supplier, (Object[]) null);
            }
        }
    }

    public void debug(Throwable th, String str, Object... objArr) {
        if (this.minimumLevelCoversDebug) {
            Iterator<String> it = this.debugTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.DEBUG, th, formatter, str, objArr);
            }
        }
    }

    public void debug(Throwable th, String str, Supplier<?>... supplierArr) {
        if (this.minimumLevelCoversDebug) {
            Iterator<String> it = this.debugTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.DEBUG, th, formatter, str, supplierArr);
            }
        }
    }

    public boolean isInfoEnabled() {
        return this.minimumLevelCoversInfo && anyEnabled(this.infoTags, Level.INFO);
    }

    public void info(Object obj) {
        if (this.minimumLevelCoversInfo) {
            Iterator<String> it = this.infoTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.INFO, (Throwable) null, (MessageFormatter) null, obj, (Object[]) null);
            }
        }
    }

    public void info(Supplier<?> supplier) {
        if (this.minimumLevelCoversInfo) {
            Iterator<String> it = this.infoTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.INFO, (Throwable) null, (MessageFormatter) null, supplier, (Object[]) null);
            }
        }
    }

    public void info(String str, Object... objArr) {
        if (this.minimumLevelCoversInfo) {
            Iterator<String> it = this.infoTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.INFO, (Throwable) null, formatter, str, objArr);
            }
        }
    }

    public void info(String str, Supplier<?>... supplierArr) {
        if (this.minimumLevelCoversInfo) {
            Iterator<String> it = this.infoTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.INFO, (Throwable) null, formatter, str, supplierArr);
            }
        }
    }

    public void info(Throwable th) {
        if (this.minimumLevelCoversInfo) {
            Iterator<String> it = this.infoTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.INFO, th, (MessageFormatter) null, (Object) null, (Object[]) null);
            }
        }
    }

    public void info(Throwable th, String str) {
        if (this.minimumLevelCoversInfo) {
            Iterator<String> it = this.infoTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.INFO, th, (MessageFormatter) null, str, (Object[]) null);
            }
        }
    }

    public void info(Throwable th, Supplier<String> supplier) {
        if (this.minimumLevelCoversInfo) {
            Iterator<String> it = this.infoTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.INFO, th, (MessageFormatter) null, supplier, (Object[]) null);
            }
        }
    }

    public void info(Throwable th, String str, Object... objArr) {
        if (this.minimumLevelCoversInfo) {
            Iterator<String> it = this.infoTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.INFO, th, formatter, str, objArr);
            }
        }
    }

    public void info(Throwable th, String str, Supplier<?>... supplierArr) {
        if (this.minimumLevelCoversInfo) {
            Iterator<String> it = this.infoTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.INFO, th, formatter, str, supplierArr);
            }
        }
    }

    public boolean isWarnEnabled() {
        return this.minimumLevelCoversWarn && anyEnabled(this.warnTags, Level.WARN);
    }

    public void warn(Object obj) {
        if (this.minimumLevelCoversWarn) {
            Iterator<String> it = this.warnTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.WARN, (Throwable) null, (MessageFormatter) null, obj, (Object[]) null);
            }
        }
    }

    public void warn(Supplier<?> supplier) {
        if (this.minimumLevelCoversWarn) {
            Iterator<String> it = this.warnTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.WARN, (Throwable) null, (MessageFormatter) null, supplier, (Object[]) null);
            }
        }
    }

    public void warn(String str, Object... objArr) {
        if (this.minimumLevelCoversWarn) {
            Iterator<String> it = this.warnTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.WARN, (Throwable) null, formatter, str, objArr);
            }
        }
    }

    public void warn(String str, Supplier<?>... supplierArr) {
        if (this.minimumLevelCoversWarn) {
            Iterator<String> it = this.warnTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.WARN, (Throwable) null, formatter, str, supplierArr);
            }
        }
    }

    public void warn(Throwable th) {
        if (this.minimumLevelCoversWarn) {
            Iterator<String> it = this.warnTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.WARN, th, (MessageFormatter) null, (Object) null, (Object[]) null);
            }
        }
    }

    public void warn(Throwable th, String str) {
        if (this.minimumLevelCoversWarn) {
            Iterator<String> it = this.warnTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.WARN, th, (MessageFormatter) null, str, (Object[]) null);
            }
        }
    }

    public void warn(Throwable th, Supplier<String> supplier) {
        if (this.minimumLevelCoversWarn) {
            Iterator<String> it = this.warnTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.WARN, th, (MessageFormatter) null, supplier, (Object[]) null);
            }
        }
    }

    public void warn(Throwable th, String str, Object... objArr) {
        if (this.minimumLevelCoversWarn) {
            Iterator<String> it = this.warnTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.WARN, th, formatter, str, objArr);
            }
        }
    }

    public void warn(Throwable th, String str, Supplier<?>... supplierArr) {
        if (this.minimumLevelCoversWarn) {
            Iterator<String> it = this.warnTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.WARN, th, formatter, str, supplierArr);
            }
        }
    }

    public boolean isErrorEnabled() {
        return this.minimumLevelCoversError && anyEnabled(this.errorTags, Level.ERROR);
    }

    public void error(Object obj) {
        if (this.minimumLevelCoversError) {
            Iterator<String> it = this.errorTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.ERROR, (Throwable) null, (MessageFormatter) null, obj, (Object[]) null);
            }
        }
    }

    public void error(Supplier<?> supplier) {
        if (this.minimumLevelCoversError) {
            Iterator<String> it = this.errorTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.ERROR, (Throwable) null, (MessageFormatter) null, supplier, (Object[]) null);
            }
        }
    }

    public void error(String str, Object... objArr) {
        if (this.minimumLevelCoversError) {
            Iterator<String> it = this.errorTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.ERROR, (Throwable) null, formatter, str, objArr);
            }
        }
    }

    public void error(String str, Supplier<?>... supplierArr) {
        if (this.minimumLevelCoversError) {
            Iterator<String> it = this.errorTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.ERROR, (Throwable) null, formatter, str, supplierArr);
            }
        }
    }

    public void error(Throwable th) {
        if (this.minimumLevelCoversError) {
            Iterator<String> it = this.errorTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.ERROR, th, (MessageFormatter) null, (Object) null, (Object[]) null);
            }
        }
    }

    public void error(Throwable th, String str) {
        if (this.minimumLevelCoversError) {
            Iterator<String> it = this.errorTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.ERROR, th, (MessageFormatter) null, str, (Object[]) null);
            }
        }
    }

    public void error(Throwable th, Supplier<String> supplier) {
        if (this.minimumLevelCoversError) {
            Iterator<String> it = this.errorTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.ERROR, th, (MessageFormatter) null, supplier, (Object[]) null);
            }
        }
    }

    public void error(Throwable th, String str, Object... objArr) {
        if (this.minimumLevelCoversError) {
            Iterator<String> it = this.errorTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.ERROR, th, formatter, str, objArr);
            }
        }
    }

    public void error(Throwable th, String str, Supplier<?>... supplierArr) {
        if (this.minimumLevelCoversError) {
            Iterator<String> it = this.errorTags.iterator();
            while (it.hasNext()) {
                provider.log(2, it.next(), Level.ERROR, th, formatter, str, supplierArr);
            }
        }
    }

    private static boolean anyEnabled(Set<String> set, Level level) {
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            if (provider.isEnabled(3, it.next(), level)) {
                return true;
            }
        }
        return false;
    }

    private static Set<String> getCoveredTags(Set<String> set, Level level) {
        HashSet hashSet = new HashSet();
        for (String str : set) {
            if (isCoveredByMinimumLevel(str, level)) {
                hashSet.add(str);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static boolean isCoveredByMinimumLevel(String str, Level level) {
        return provider.getMinimumLevel(str).ordinal() <= level.ordinal();
    }
}
