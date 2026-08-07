package org.tinylog.kotlin;

import com.box.androidsdk.content.models.BoxRepresentation;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pspdfkit.internal.jni.NativeFormNotifications;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.tinylog.Level;
import org.tinylog.Supplier;
import org.tinylog.configuration.Configuration;
import org.tinylog.format.AdvancedMessageFormatter;
import org.tinylog.format.MessageFormatter;
import org.tinylog.provider.LoggingProvider;
import org.tinylog.provider.ProviderRegistry;

/* JADX INFO: compiled from: Logger.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u0019J\u0010\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0012J7\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00122\"\u0010\u001a\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00190\u001b\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019¢\u0006\u0002\u0010\u001cJ+\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00122\u0016\u0010\u001a\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001b\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u001dJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fJ\u001c\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u0019J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u0012J?\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u00122\"\u0010\u001a\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00190\u001b\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019¢\u0006\u0002\u0010 J3\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u00122\u0016\u0010\u001a\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001b\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010!J\u0014\u0010\"\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u0019J\u0010\u0010\"\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\"\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0012J7\u0010\"\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00122\"\u0010\u001a\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00190\u001b\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019¢\u0006\u0002\u0010\u001cJ+\u0010\"\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00122\u0016\u0010\u001a\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001b\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u001dJ\u000e\u0010\"\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fJ\u001c\u0010\"\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u0019J\u0016\u0010\"\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u0012J?\u0010\"\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u00122\"\u0010\u001a\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00190\u001b\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019¢\u0006\u0002\u0010 J3\u0010\"\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u00122\u0016\u0010\u001a\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001b\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010!J\u0014\u0010#\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u0019J\u0010\u0010#\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001J\u000e\u0010#\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0012J7\u0010#\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00122\"\u0010\u001a\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00190\u001b\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019¢\u0006\u0002\u0010\u001cJ+\u0010#\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00122\u0016\u0010\u001a\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001b\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u001dJ\u000e\u0010#\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fJ\u001c\u0010#\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u0019J\u0016\u0010#\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u0012J?\u0010#\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u00122\"\u0010\u001a\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00190\u001b\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019¢\u0006\u0002\u0010 J3\u0010#\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u00122\u0016\u0010\u001a\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001b\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010!J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020&H\u0002J\u0006\u0010'\u001a\u00020\u0004J\u0006\u0010(\u001a\u00020\u0004J\u0006\u0010)\u001a\u00020\u0004J\u0006\u0010*\u001a\u00020\u0004J\u0006\u0010+\u001a\u00020\u0004J\u0010\u0010,\u001a\u00020\u000e2\b\u0010,\u001a\u0004\u0018\u00010\u0012J#\u0010-\u001a\u00020\u000e2\u0016\u0010-\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00120\u001b\"\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010.J\u0014\u0010/\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u0019J\u0010\u0010/\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001J\u000e\u0010/\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0012J7\u0010/\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00122\"\u0010\u001a\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00190\u001b\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019¢\u0006\u0002\u0010\u001cJ+\u0010/\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00122\u0016\u0010\u001a\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001b\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u001dJ\u000e\u0010/\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fJ\u001c\u0010/\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u0019J\u0016\u0010/\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u0012J?\u0010/\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u00122\"\u0010\u001a\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00190\u001b\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019¢\u0006\u0002\u0010 J3\u0010/\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u00122\u0016\u0010\u001a\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001b\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010!J\u0014\u00100\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u0019J\u0010\u00100\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001J\u000e\u00100\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0012J7\u00100\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00122\"\u0010\u001a\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00190\u001b\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019¢\u0006\u0002\u0010\u001cJ+\u00100\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00122\u0016\u0010\u001a\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001b\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u001dJ\u000e\u00100\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fJ\u001c\u00100\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u0019J\u0016\u00100\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u0012J?\u00100\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u00122\"\u0010\u001a\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00190\u001b\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019¢\u0006\u0002\u0010 J3\u00100\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u00122\u0016\u0010\u001a\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001b\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010!R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000f\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011\u0012\u0004\u0012\u00020\u000e0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lorg/tinylog/kotlin/Logger;", "", "()V", "MINIMUM_LEVEL_COVERS_DEBUG", "", "MINIMUM_LEVEL_COVERS_ERROR", "MINIMUM_LEVEL_COVERS_INFO", "MINIMUM_LEVEL_COVERS_TRACE", "MINIMUM_LEVEL_COVERS_WARN", "STACKTRACE_DEPTH", "", "formatter", "Lorg/tinylog/format/AdvancedMessageFormatter;", "instance", "Lorg/tinylog/kotlin/TaggedLogger;", "loggers", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", NativeFormNotifications.PROVIDER_INDEX_INFO_KEY, "Lorg/tinylog/provider/LoggingProvider;", "kotlin.jvm.PlatformType", "debug", "", "message", "Lkotlin/Function0;", "arguments", "", "(Ljava/lang/String;[Lkotlin/jvm/functions/Function0;)V", "(Ljava/lang/String;[Ljava/lang/Object;)V", "exception", "", "(Ljava/lang/Throwable;Ljava/lang/String;[Lkotlin/jvm/functions/Function0;)V", "(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V", "error", BoxRepresentation.FIELD_INFO, "isCoveredByMinimumLevel", FirebaseAnalytics.Param.LEVEL, "Lorg/tinylog/Level;", "isDebugEnabled", "isErrorEnabled", "isInfoEnabled", "isTraceEnabled", "isWarnEnabled", "tag", "tags", "([Ljava/lang/String;)Lorg/tinylog/kotlin/TaggedLogger;", "trace", "warn", "tinylog-api-kotlin"}, k = 1, mv = {1, 1, 18})
public final class Logger {
    public static final Logger INSTANCE;
    private static final boolean MINIMUM_LEVEL_COVERS_DEBUG;
    private static final boolean MINIMUM_LEVEL_COVERS_ERROR;
    private static final boolean MINIMUM_LEVEL_COVERS_INFO;
    private static final boolean MINIMUM_LEVEL_COVERS_TRACE;
    private static final boolean MINIMUM_LEVEL_COVERS_WARN;
    private static final int STACKTRACE_DEPTH = 2;
    private static final AdvancedMessageFormatter formatter;
    private static final TaggedLogger instance;
    private static final ConcurrentHashMap<Set<String>, TaggedLogger> loggers;
    private static final LoggingProvider provider;

    static {
        Logger logger = new Logger();
        INSTANCE = logger;
        formatter = new AdvancedMessageFormatter(Configuration.getLocale(), Configuration.isEscapingEnabled());
        provider = ProviderRegistry.getLoggingProvider();
        MINIMUM_LEVEL_COVERS_TRACE = logger.isCoveredByMinimumLevel(Level.TRACE);
        MINIMUM_LEVEL_COVERS_DEBUG = logger.isCoveredByMinimumLevel(Level.DEBUG);
        MINIMUM_LEVEL_COVERS_INFO = logger.isCoveredByMinimumLevel(Level.INFO);
        MINIMUM_LEVEL_COVERS_WARN = logger.isCoveredByMinimumLevel(Level.WARN);
        MINIMUM_LEVEL_COVERS_ERROR = logger.isCoveredByMinimumLevel(Level.ERROR);
        TaggedLogger taggedLogger = new TaggedLogger(SetsKt.setOf((Object) null));
        instance = taggedLogger;
        ConcurrentHashMap<Set<String>, TaggedLogger> concurrentHashMap = new ConcurrentHashMap<>();
        loggers = concurrentHashMap;
        concurrentHashMap.put(SetsKt.setOf((Object) null), taggedLogger);
    }

    private Logger() {
    }

    public final TaggedLogger tag(String tag) {
        return (tag == null || tag.length() == 0) ? instance : tags(tag);
    }

    public final TaggedLogger tags(String... tags) {
        Intrinsics.checkParameterIsNotNull(tags, "tags");
        if (tags.length == 0) {
            return instance;
        }
        ArrayList arrayList = new ArrayList(tags.length);
        for (String str : tags) {
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                str = null;
            }
            arrayList.add(str);
        }
        TaggedLogger taggedLoggerComputeIfAbsent = loggers.computeIfAbsent(CollectionsKt.toSet(arrayList), new Function() { // from class: org.tinylog.kotlin.Logger.tags.1
            @Override // java.util.function.Function
            public final TaggedLogger apply(Set<String> it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return new TaggedLogger(it);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(taggedLoggerComputeIfAbsent, "loggers.computeIfAbsent(…Set) { TaggedLogger(it) }");
        return taggedLoggerComputeIfAbsent;
    }

    public final boolean isTraceEnabled() {
        return MINIMUM_LEVEL_COVERS_TRACE && provider.isEnabled(2, (String) null, Level.TRACE);
    }

    public final void trace(Object message) {
        if (MINIMUM_LEVEL_COVERS_TRACE) {
            provider.log(2, (String) null, Level.TRACE, (Throwable) null, (MessageFormatter) null, message, new Object[0]);
        }
    }

    public final void trace(String message) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (MINIMUM_LEVEL_COVERS_TRACE) {
            provider.log(2, (String) null, Level.TRACE, (Throwable) null, (MessageFormatter) null, message, new Object[0]);
        }
    }

    public final void trace(Function0<String> message) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (MINIMUM_LEVEL_COVERS_TRACE) {
            provider.log(2, (String) null, Level.TRACE, (Throwable) null, (MessageFormatter) null, SupplierUtilsKt.asSupplier(message), new Object[0]);
        }
    }

    public final void trace(String message, Object... arguments) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_TRACE) {
            provider.log(2, (String) null, Level.TRACE, (Throwable) null, formatter, message, Arrays.copyOf(arguments, arguments.length));
        }
    }

    public final void trace(String message, Function0<? extends Object>... arguments) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_TRACE) {
            LoggingProvider loggingProvider = provider;
            Level level = Level.TRACE;
            AdvancedMessageFormatter advancedMessageFormatter = formatter;
            Supplier[] supplierArrAsSuppliers = SupplierUtilsKt.asSuppliers(arguments);
            loggingProvider.log(2, (String) null, level, (Throwable) null, advancedMessageFormatter, message, Arrays.copyOf(supplierArrAsSuppliers, supplierArrAsSuppliers.length));
        }
    }

    public final void trace(Throwable exception) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        if (MINIMUM_LEVEL_COVERS_TRACE) {
            provider.log(2, (String) null, Level.TRACE, exception, (MessageFormatter) null, (Object) null, new Object[0]);
        }
    }

    public final void trace(Throwable exception, String message) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (MINIMUM_LEVEL_COVERS_TRACE) {
            provider.log(2, (String) null, Level.TRACE, exception, (MessageFormatter) null, message, new Object[0]);
        }
    }

    public final void trace(Throwable exception, Function0<String> message) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (MINIMUM_LEVEL_COVERS_TRACE) {
            provider.log(2, (String) null, Level.TRACE, exception, (MessageFormatter) null, SupplierUtilsKt.asSupplier(message), new Object[0]);
        }
    }

    public final void trace(Throwable exception, String message, Object... arguments) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_TRACE) {
            provider.log(2, (String) null, Level.TRACE, exception, formatter, message, Arrays.copyOf(arguments, arguments.length));
        }
    }

    public final void trace(Throwable exception, String message, Function0<? extends Object>... arguments) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_TRACE) {
            LoggingProvider loggingProvider = provider;
            Level level = Level.TRACE;
            AdvancedMessageFormatter advancedMessageFormatter = formatter;
            Supplier[] supplierArrAsSuppliers = SupplierUtilsKt.asSuppliers(arguments);
            loggingProvider.log(2, (String) null, level, exception, advancedMessageFormatter, message, Arrays.copyOf(supplierArrAsSuppliers, supplierArrAsSuppliers.length));
        }
    }

    public final boolean isDebugEnabled() {
        return MINIMUM_LEVEL_COVERS_DEBUG && provider.isEnabled(2, (String) null, Level.DEBUG);
    }

    public final void debug(Object message) {
        if (MINIMUM_LEVEL_COVERS_DEBUG) {
            provider.log(2, (String) null, Level.DEBUG, (Throwable) null, (MessageFormatter) null, message, new Object[0]);
        }
    }

    public final void debug(String message) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (MINIMUM_LEVEL_COVERS_DEBUG) {
            provider.log(2, (String) null, Level.DEBUG, (Throwable) null, (MessageFormatter) null, message, new Object[0]);
        }
    }

    public final void debug(Function0<String> message) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (MINIMUM_LEVEL_COVERS_DEBUG) {
            provider.log(2, (String) null, Level.DEBUG, (Throwable) null, (MessageFormatter) null, SupplierUtilsKt.asSupplier(message), new Object[0]);
        }
    }

    public final void debug(String message, Object... arguments) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_DEBUG) {
            provider.log(2, (String) null, Level.DEBUG, (Throwable) null, formatter, message, Arrays.copyOf(arguments, arguments.length));
        }
    }

    public final void debug(String message, Function0<? extends Object>... arguments) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_DEBUG) {
            LoggingProvider loggingProvider = provider;
            Level level = Level.DEBUG;
            AdvancedMessageFormatter advancedMessageFormatter = formatter;
            Supplier[] supplierArrAsSuppliers = SupplierUtilsKt.asSuppliers(arguments);
            loggingProvider.log(2, (String) null, level, (Throwable) null, advancedMessageFormatter, message, Arrays.copyOf(supplierArrAsSuppliers, supplierArrAsSuppliers.length));
        }
    }

    public final void debug(Throwable exception) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        if (MINIMUM_LEVEL_COVERS_DEBUG) {
            provider.log(2, (String) null, Level.DEBUG, exception, (MessageFormatter) null, (Object) null, new Object[0]);
        }
    }

    public final void debug(Throwable exception, String message) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (MINIMUM_LEVEL_COVERS_DEBUG) {
            provider.log(2, (String) null, Level.DEBUG, exception, (MessageFormatter) null, message, new Object[0]);
        }
    }

    public final void debug(Throwable exception, Function0<String> message) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (MINIMUM_LEVEL_COVERS_DEBUG) {
            provider.log(2, (String) null, Level.DEBUG, exception, (MessageFormatter) null, SupplierUtilsKt.asSupplier(message), new Object[0]);
        }
    }

    public final void debug(Throwable exception, String message, Object... arguments) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_DEBUG) {
            provider.log(2, (String) null, Level.DEBUG, exception, formatter, message, Arrays.copyOf(arguments, arguments.length));
        }
    }

    public final void debug(Throwable exception, String message, Function0<? extends Object>... arguments) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_DEBUG) {
            LoggingProvider loggingProvider = provider;
            Level level = Level.DEBUG;
            AdvancedMessageFormatter advancedMessageFormatter = formatter;
            Supplier[] supplierArrAsSuppliers = SupplierUtilsKt.asSuppliers(arguments);
            loggingProvider.log(2, (String) null, level, exception, advancedMessageFormatter, message, Arrays.copyOf(supplierArrAsSuppliers, supplierArrAsSuppliers.length));
        }
    }

    public final boolean isInfoEnabled() {
        return MINIMUM_LEVEL_COVERS_INFO && provider.isEnabled(2, (String) null, Level.INFO);
    }

    public final void info(Object message) {
        if (MINIMUM_LEVEL_COVERS_INFO) {
            provider.log(2, (String) null, Level.INFO, (Throwable) null, (MessageFormatter) null, message, new Object[0]);
        }
    }

    public final void info(String message) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (MINIMUM_LEVEL_COVERS_INFO) {
            provider.log(2, (String) null, Level.INFO, (Throwable) null, (MessageFormatter) null, message, new Object[0]);
        }
    }

    public final void info(Function0<String> message) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (MINIMUM_LEVEL_COVERS_INFO) {
            provider.log(2, (String) null, Level.INFO, (Throwable) null, (MessageFormatter) null, SupplierUtilsKt.asSupplier(message), new Object[0]);
        }
    }

    public final void info(String message, Object... arguments) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_INFO) {
            provider.log(2, (String) null, Level.INFO, (Throwable) null, formatter, message, Arrays.copyOf(arguments, arguments.length));
        }
    }

    public final void info(String message, Function0<? extends Object>... arguments) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_INFO) {
            LoggingProvider loggingProvider = provider;
            Level level = Level.INFO;
            AdvancedMessageFormatter advancedMessageFormatter = formatter;
            Supplier[] supplierArrAsSuppliers = SupplierUtilsKt.asSuppliers(arguments);
            loggingProvider.log(2, (String) null, level, (Throwable) null, advancedMessageFormatter, message, Arrays.copyOf(supplierArrAsSuppliers, supplierArrAsSuppliers.length));
        }
    }

    public final void info(Throwable exception) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        if (MINIMUM_LEVEL_COVERS_INFO) {
            provider.log(2, (String) null, Level.INFO, exception, (MessageFormatter) null, (Object) null, new Object[0]);
        }
    }

    public final void info(Throwable exception, String message) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (MINIMUM_LEVEL_COVERS_INFO) {
            provider.log(2, (String) null, Level.INFO, exception, (MessageFormatter) null, message, new Object[0]);
        }
    }

    public final void info(Throwable exception, Function0<String> message) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (MINIMUM_LEVEL_COVERS_INFO) {
            provider.log(2, (String) null, Level.INFO, exception, (MessageFormatter) null, SupplierUtilsKt.asSupplier(message), new Object[0]);
        }
    }

    public final void info(Throwable exception, String message, Object... arguments) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_INFO) {
            provider.log(2, (String) null, Level.INFO, exception, formatter, message, Arrays.copyOf(arguments, arguments.length));
        }
    }

    public final void info(Throwable exception, String message, Function0<? extends Object>... arguments) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_INFO) {
            LoggingProvider loggingProvider = provider;
            Level level = Level.INFO;
            AdvancedMessageFormatter advancedMessageFormatter = formatter;
            Supplier[] supplierArrAsSuppliers = SupplierUtilsKt.asSuppliers(arguments);
            loggingProvider.log(2, (String) null, level, exception, advancedMessageFormatter, message, Arrays.copyOf(supplierArrAsSuppliers, supplierArrAsSuppliers.length));
        }
    }

    public final boolean isWarnEnabled() {
        return MINIMUM_LEVEL_COVERS_WARN && provider.isEnabled(2, (String) null, Level.WARN);
    }

    public final void warn(Object message) {
        if (MINIMUM_LEVEL_COVERS_WARN) {
            provider.log(2, (String) null, Level.WARN, (Throwable) null, (MessageFormatter) null, message, new Object[0]);
        }
    }

    public final void warn(String message) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (MINIMUM_LEVEL_COVERS_WARN) {
            provider.log(2, (String) null, Level.WARN, (Throwable) null, (MessageFormatter) null, message, new Object[0]);
        }
    }

    public final void warn(Function0<String> message) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (MINIMUM_LEVEL_COVERS_WARN) {
            provider.log(2, (String) null, Level.WARN, (Throwable) null, (MessageFormatter) null, SupplierUtilsKt.asSupplier(message), new Object[0]);
        }
    }

    public final void warn(String message, Object... arguments) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_WARN) {
            provider.log(2, (String) null, Level.WARN, (Throwable) null, formatter, message, Arrays.copyOf(arguments, arguments.length));
        }
    }

    public final void warn(String message, Function0<? extends Object>... arguments) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_WARN) {
            LoggingProvider loggingProvider = provider;
            Level level = Level.WARN;
            AdvancedMessageFormatter advancedMessageFormatter = formatter;
            Supplier[] supplierArrAsSuppliers = SupplierUtilsKt.asSuppliers(arguments);
            loggingProvider.log(2, (String) null, level, (Throwable) null, advancedMessageFormatter, message, Arrays.copyOf(supplierArrAsSuppliers, supplierArrAsSuppliers.length));
        }
    }

    public final void warn(Throwable exception) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        if (MINIMUM_LEVEL_COVERS_WARN) {
            provider.log(2, (String) null, Level.WARN, exception, (MessageFormatter) null, (Object) null, new Object[0]);
        }
    }

    public final void warn(Throwable exception, String message) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (MINIMUM_LEVEL_COVERS_WARN) {
            provider.log(2, (String) null, Level.WARN, exception, (MessageFormatter) null, message, new Object[0]);
        }
    }

    public final void warn(Throwable exception, Function0<String> message) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (MINIMUM_LEVEL_COVERS_WARN) {
            provider.log(2, (String) null, Level.WARN, exception, (MessageFormatter) null, SupplierUtilsKt.asSupplier(message), new Object[0]);
        }
    }

    public final void warn(Throwable exception, String message, Object... arguments) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_WARN) {
            provider.log(2, (String) null, Level.WARN, exception, formatter, message, Arrays.copyOf(arguments, arguments.length));
        }
    }

    public final void warn(Throwable exception, String message, Function0<? extends Object>... arguments) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_WARN) {
            LoggingProvider loggingProvider = provider;
            Level level = Level.WARN;
            AdvancedMessageFormatter advancedMessageFormatter = formatter;
            Supplier[] supplierArrAsSuppliers = SupplierUtilsKt.asSuppliers(arguments);
            loggingProvider.log(2, (String) null, level, exception, advancedMessageFormatter, message, Arrays.copyOf(supplierArrAsSuppliers, supplierArrAsSuppliers.length));
        }
    }

    public final boolean isErrorEnabled() {
        return MINIMUM_LEVEL_COVERS_ERROR && provider.isEnabled(2, (String) null, Level.ERROR);
    }

    public final void error(Object message) {
        if (MINIMUM_LEVEL_COVERS_ERROR) {
            provider.log(2, (String) null, Level.ERROR, (Throwable) null, (MessageFormatter) null, message, new Object[0]);
        }
    }

    public final void error(String message) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (MINIMUM_LEVEL_COVERS_ERROR) {
            provider.log(2, (String) null, Level.ERROR, (Throwable) null, (MessageFormatter) null, message, new Object[0]);
        }
    }

    public final void error(Function0<String> message) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (MINIMUM_LEVEL_COVERS_ERROR) {
            provider.log(2, (String) null, Level.ERROR, (Throwable) null, (MessageFormatter) null, SupplierUtilsKt.asSupplier(message), new Object[0]);
        }
    }

    public final void error(String message, Object... arguments) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_ERROR) {
            provider.log(2, (String) null, Level.ERROR, (Throwable) null, formatter, message, Arrays.copyOf(arguments, arguments.length));
        }
    }

    public final void error(String message, Function0<? extends Object>... arguments) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_ERROR) {
            LoggingProvider loggingProvider = provider;
            Level level = Level.ERROR;
            AdvancedMessageFormatter advancedMessageFormatter = formatter;
            Supplier[] supplierArrAsSuppliers = SupplierUtilsKt.asSuppliers(arguments);
            loggingProvider.log(2, (String) null, level, (Throwable) null, advancedMessageFormatter, message, Arrays.copyOf(supplierArrAsSuppliers, supplierArrAsSuppliers.length));
        }
    }

    public final void error(Throwable exception) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        if (MINIMUM_LEVEL_COVERS_ERROR) {
            provider.log(2, (String) null, Level.ERROR, exception, (MessageFormatter) null, (Object) null, new Object[0]);
        }
    }

    public final void error(Throwable exception, String message) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (MINIMUM_LEVEL_COVERS_ERROR) {
            provider.log(2, (String) null, Level.ERROR, exception, (MessageFormatter) null, message, new Object[0]);
        }
    }

    public final void error(Throwable exception, Function0<String> message) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (MINIMUM_LEVEL_COVERS_ERROR) {
            provider.log(2, (String) null, Level.ERROR, exception, (MessageFormatter) null, SupplierUtilsKt.asSupplier(message), new Object[0]);
        }
    }

    public final void error(Throwable exception, String message, Object... arguments) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_ERROR) {
            provider.log(2, (String) null, Level.ERROR, exception, formatter, message, Arrays.copyOf(arguments, arguments.length));
        }
    }

    public final void error(Throwable exception, String message, Function0<? extends Object>... arguments) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_ERROR) {
            LoggingProvider loggingProvider = provider;
            Level level = Level.ERROR;
            AdvancedMessageFormatter advancedMessageFormatter = formatter;
            Supplier[] supplierArrAsSuppliers = SupplierUtilsKt.asSuppliers(arguments);
            loggingProvider.log(2, (String) null, level, exception, advancedMessageFormatter, message, Arrays.copyOf(supplierArrAsSuppliers, supplierArrAsSuppliers.length));
        }
    }

    private final boolean isCoveredByMinimumLevel(Level level) {
        return provider.getMinimumLevel(null).ordinal() <= level.ordinal();
    }
}
