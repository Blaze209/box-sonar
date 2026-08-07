package com.box.androidsdk.content.utils.logging;

import com.box.androidsdk.content.models.BoxRepresentation;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pspdfkit.internal.jni.NativeFormNotifications;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.tinylog.Level;
import org.tinylog.Supplier;
import org.tinylog.TaggedLogger;
import org.tinylog.format.AdvancedMessageFormatter;
import org.tinylog.format.MessageFormatter;
import org.tinylog.provider.LoggingProvider;
import org.tinylog.provider.ProviderRegistry;

/* JADX INFO: compiled from: FileLogger.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001aJ-\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00132\u0016\u0010\u001b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001c\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u001dJ5\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00132\u001e\u0010\u001b\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u001a0\u001c\"\b\u0012\u0002\b\u0003\u0018\u00010\u001a¢\u0006\u0002\u0010\u001eJ\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u001a\u0010\u0017\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013J\"\u0010\u0017\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u001aJ7\u0010\u0017\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00132\u0016\u0010\u001b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001c\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010!J?\u0010\u0017\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00132\u001e\u0010\u001b\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u001a0\u001c\"\b\u0012\u0002\b\u0003\u0018\u00010\u001a¢\u0006\u0002\u0010\"J\u0010\u0010$\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001J\u0014\u0010$\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001aJ-\u0010$\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00132\u0016\u0010\u001b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001c\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u001dJ5\u0010$\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00132\u001e\u0010\u001b\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u001a0\u001c\"\b\u0012\u0002\b\u0003\u0018\u00010\u001a¢\u0006\u0002\u0010\u001eJ\u0010\u0010$\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u001a\u0010$\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013J\"\u0010$\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u001aJ7\u0010$\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00132\u0016\u0010\u001b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001c\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010!J?\u0010$\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00132\u001e\u0010\u001b\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u001a0\u001c\"\b\u0012\u0002\b\u0003\u0018\u00010\u001a¢\u0006\u0002\u0010\"J\u0010\u0010&\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001J\u0014\u0010&\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001aJ-\u0010&\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00132\u0016\u0010\u001b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001c\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u001dJ5\u0010&\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00132\u001e\u0010\u001b\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u001a0\u001c\"\b\u0012\u0002\b\u0003\u0018\u00010\u001a¢\u0006\u0002\u0010\u001eJ\u0010\u0010&\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u001a\u0010&\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013J\"\u0010&\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u001aJ7\u0010&\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00132\u0016\u0010\u001b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001c\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010!J?\u0010&\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00132\u001e\u0010\u001b\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u001a0\u001c\"\b\u0012\u0002\b\u0003\u0018\u00010\u001a¢\u0006\u0002\u0010\"J\u0010\u0010(\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001J\u0014\u0010(\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001aJ-\u0010(\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00132\u0016\u0010\u001b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001c\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u001dJ5\u0010(\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00132\u001e\u0010\u001b\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u001a0\u001c\"\b\u0012\u0002\b\u0003\u0018\u00010\u001a¢\u0006\u0002\u0010\u001eJ\u0010\u0010(\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u001a\u0010(\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013J\"\u0010(\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u001aJ7\u0010(\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00132\u0016\u0010\u001b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001c\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010!J?\u0010(\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00132\u001e\u0010\u001b\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u001a0\u001c\"\b\u0012\u0002\b\u0003\u0018\u00010\u001a¢\u0006\u0002\u0010\"J\u0010\u0010*\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001J\u0014\u0010*\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001aJ-\u0010*\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00132\u0016\u0010\u001b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001c\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u001dJ5\u0010*\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00132\u001e\u0010\u001b\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u001a0\u001c\"\b\u0012\u0002\b\u0003\u0018\u00010\u001a¢\u0006\u0002\u0010\u001eJ\u0010\u0010*\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u001a\u0010*\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013J\"\u0010*\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u001aJ7\u0010*\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00132\u0016\u0010\u001b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001c\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010!J?\u0010*\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00132\u001e\u0010\u001b\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u001a0\u001c\"\b\u0012\u0002\b\u0003\u0018\u00010\u001a¢\u0006\u0002\u0010\"J\u0010\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020-H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010#\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b#\u0010\u0016R\u0011\u0010%\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b%\u0010\u0016R\u0011\u0010'\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b'\u0010\u0016R\u0011\u0010)\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b)\u0010\u0016¨\u0006."}, d2 = {"Lcom/box/androidsdk/content/utils/logging/FileLogger;", "", "<init>", "()V", "STACKTRACE_DEPTH", "", "formatter", "Lorg/tinylog/format/MessageFormatter;", NativeFormNotifications.PROVIDER_INDEX_INFO_KEY, "Lorg/tinylog/provider/LoggingProvider;", "kotlin.jvm.PlatformType", "MINIMUM_LEVEL_COVERS_TRACE", "", "MINIMUM_LEVEL_COVERS_DEBUG", "MINIMUM_LEVEL_COVERS_INFO", "MINIMUM_LEVEL_COVERS_WARN", "MINIMUM_LEVEL_COVERS_ERROR", "loggers", "Ljava/util/concurrent/ConcurrentMap;", "", "Lorg/tinylog/TaggedLogger;", "isTraceEnabled", "()Z", "trace", "", "message", "Lorg/tinylog/Supplier;", "arguments", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "(Ljava/lang/String;[Lorg/tinylog/Supplier;)V", "exception", "", "(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V", "(Ljava/lang/Throwable;Ljava/lang/String;[Lorg/tinylog/Supplier;)V", "isDebugEnabled", "debug", "isInfoEnabled", BoxRepresentation.FIELD_INFO, "isWarnEnabled", "warn", "isErrorEnabled", "error", "isCoveredByMinimumLevel", FirebaseAnalytics.Param.LEVEL, "Lorg/tinylog/Level;", "content_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileLogger {
    public static final FileLogger INSTANCE;
    private static final boolean MINIMUM_LEVEL_COVERS_DEBUG;
    private static final boolean MINIMUM_LEVEL_COVERS_ERROR;
    private static final boolean MINIMUM_LEVEL_COVERS_INFO;
    private static final boolean MINIMUM_LEVEL_COVERS_TRACE;
    private static final boolean MINIMUM_LEVEL_COVERS_WARN;
    private static final int STACKTRACE_DEPTH = 7;
    private static final MessageFormatter formatter;
    private static final ConcurrentMap<String, TaggedLogger> loggers;
    private static final LoggingProvider provider;

    private FileLogger() {
    }

    static {
        FileLogger fileLogger = new FileLogger();
        INSTANCE = fileLogger;
        formatter = new AdvancedMessageFormatter(org.tinylog.configuration.Configuration.getLocale(), org.tinylog.configuration.Configuration.isEscapingEnabled());
        provider = ProviderRegistry.getLoggingProvider();
        MINIMUM_LEVEL_COVERS_TRACE = fileLogger.isCoveredByMinimumLevel(Level.TRACE);
        MINIMUM_LEVEL_COVERS_DEBUG = fileLogger.isCoveredByMinimumLevel(Level.DEBUG);
        MINIMUM_LEVEL_COVERS_INFO = fileLogger.isCoveredByMinimumLevel(Level.INFO);
        MINIMUM_LEVEL_COVERS_WARN = fileLogger.isCoveredByMinimumLevel(Level.WARN);
        MINIMUM_LEVEL_COVERS_ERROR = fileLogger.isCoveredByMinimumLevel(Level.ERROR);
        loggers = new ConcurrentHashMap();
    }

    public final boolean isTraceEnabled() {
        return MINIMUM_LEVEL_COVERS_TRACE && provider.isEnabled(7, (String) null, Level.TRACE);
    }

    public final void trace(Object message) {
        if (MINIMUM_LEVEL_COVERS_TRACE) {
            provider.log(7, (String) null, Level.TRACE, (Throwable) null, (MessageFormatter) null, message, Arrays.copyOf(new Object[0], 0));
        }
    }

    public final void trace(Supplier<?> message) {
        if (MINIMUM_LEVEL_COVERS_TRACE) {
            provider.log(7, (String) null, Level.TRACE, (Throwable) null, (MessageFormatter) null, message, Arrays.copyOf(new Object[0], 0));
        }
    }

    public final void trace(String message, Object... arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_TRACE) {
            provider.log(7, (String) null, Level.TRACE, (Throwable) null, formatter, message, Arrays.copyOf(arguments, arguments.length));
        }
    }

    public final void trace(String message, Supplier<?>... arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_TRACE) {
            provider.log(7, (String) null, Level.TRACE, (Throwable) null, formatter, message, Arrays.copyOf(arguments, arguments.length));
        }
    }

    public final void trace(Throwable exception) {
        if (MINIMUM_LEVEL_COVERS_TRACE) {
            provider.log(7, (String) null, Level.TRACE, exception, (MessageFormatter) null, (Object) null, Arrays.copyOf(new Object[0], 0));
        }
    }

    public final void trace(Throwable exception, String message) {
        if (MINIMUM_LEVEL_COVERS_TRACE) {
            provider.log(7, (String) null, Level.TRACE, exception, (MessageFormatter) null, message, Arrays.copyOf(new Object[0], 0));
        }
    }

    public final void trace(Throwable exception, Supplier<String> message) {
        if (MINIMUM_LEVEL_COVERS_TRACE) {
            provider.log(7, (String) null, Level.TRACE, exception, (MessageFormatter) null, message, Arrays.copyOf(new Object[0], 0));
        }
    }

    public final void trace(Throwable exception, String message, Object... arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_TRACE) {
            provider.log(7, (String) null, Level.TRACE, exception, formatter, message, Arrays.copyOf(arguments, arguments.length));
        }
    }

    public final void trace(Throwable exception, String message, Supplier<?>... arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_TRACE) {
            provider.log(7, (String) null, Level.TRACE, exception, formatter, message, Arrays.copyOf(arguments, arguments.length));
        }
    }

    public final boolean isDebugEnabled() {
        return MINIMUM_LEVEL_COVERS_DEBUG && provider.isEnabled(7, (String) null, Level.DEBUG);
    }

    public final void debug(Object message) {
        if (MINIMUM_LEVEL_COVERS_DEBUG) {
            provider.log(7, (String) null, Level.DEBUG, (Throwable) null, (MessageFormatter) null, message, Arrays.copyOf(new Object[0], 0));
        }
    }

    public final void debug(Supplier<?> message) {
        if (MINIMUM_LEVEL_COVERS_DEBUG) {
            provider.log(7, (String) null, Level.DEBUG, (Throwable) null, (MessageFormatter) null, message, Arrays.copyOf(new Object[0], 0));
        }
    }

    public final void debug(String message, Object... arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_DEBUG) {
            provider.log(7, (String) null, Level.DEBUG, (Throwable) null, formatter, message, Arrays.copyOf(arguments, arguments.length));
        }
    }

    public final void debug(String message, Supplier<?>... arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_DEBUG) {
            provider.log(7, (String) null, Level.DEBUG, (Throwable) null, formatter, message, arguments);
        }
    }

    public final void debug(Throwable exception) {
        if (MINIMUM_LEVEL_COVERS_DEBUG) {
            provider.log(7, (String) null, Level.DEBUG, exception, (MessageFormatter) null, (Object) null, Arrays.copyOf(new Object[0], 0));
        }
    }

    public final void debug(Throwable exception, String message) {
        if (MINIMUM_LEVEL_COVERS_DEBUG) {
            provider.log(7, (String) null, Level.DEBUG, exception, (MessageFormatter) null, message, Arrays.copyOf(new Object[0], 0));
        }
    }

    public final void debug(Throwable exception, Supplier<String> message) {
        if (MINIMUM_LEVEL_COVERS_DEBUG) {
            provider.log(7, (String) null, Level.DEBUG, exception, (MessageFormatter) null, message, Arrays.copyOf(new Object[0], 0));
        }
    }

    public final void debug(Throwable exception, String message, Object... arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_DEBUG) {
            provider.log(7, (String) null, Level.DEBUG, exception, formatter, message, Arrays.copyOf(arguments, arguments.length));
        }
    }

    public final void debug(Throwable exception, String message, Supplier<?>... arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_DEBUG) {
            provider.log(7, (String) null, Level.DEBUG, exception, formatter, message, Arrays.copyOf(arguments, arguments.length));
        }
    }

    public final boolean isInfoEnabled() {
        return MINIMUM_LEVEL_COVERS_INFO && provider.isEnabled(7, (String) null, Level.INFO);
    }

    public final void info(Object message) {
        if (MINIMUM_LEVEL_COVERS_INFO) {
            provider.log(7, (String) null, Level.INFO, (Throwable) null, (MessageFormatter) null, message, Arrays.copyOf(new Object[0], 0));
        }
    }

    public final void info(Supplier<?> message) {
        if (MINIMUM_LEVEL_COVERS_INFO) {
            provider.log(7, (String) null, Level.INFO, (Throwable) null, (MessageFormatter) null, message, Arrays.copyOf(new Object[0], 0));
        }
    }

    public final void info(String message, Object... arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_INFO) {
            provider.log(7, (String) null, Level.INFO, (Throwable) null, formatter, message, Arrays.copyOf(arguments, arguments.length));
        }
    }

    public final void info(String message, Supplier<?>... arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_INFO) {
            provider.log(7, (String) null, Level.INFO, (Throwable) null, formatter, message, Arrays.copyOf(arguments, arguments.length));
        }
    }

    public final void info(Throwable exception) {
        if (MINIMUM_LEVEL_COVERS_INFO) {
            provider.log(7, (String) null, Level.INFO, exception, (MessageFormatter) null, (Object) null, Arrays.copyOf(new Object[0], 0));
        }
    }

    public final void info(Throwable exception, String message) {
        if (MINIMUM_LEVEL_COVERS_INFO) {
            provider.log(7, (String) null, Level.INFO, exception, (MessageFormatter) null, message, Arrays.copyOf(new Object[0], 0));
        }
    }

    public final void info(Throwable exception, Supplier<String> message) {
        if (MINIMUM_LEVEL_COVERS_INFO) {
            provider.log(7, (String) null, Level.INFO, exception, (MessageFormatter) null, message, Arrays.copyOf(new Object[0], 0));
        }
    }

    public final void info(Throwable exception, String message, Object... arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_INFO) {
            provider.log(7, (String) null, Level.INFO, exception, formatter, message, Arrays.copyOf(arguments, arguments.length));
        }
    }

    public final void info(Throwable exception, String message, Supplier<?>... arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_INFO) {
            provider.log(7, (String) null, Level.INFO, exception, formatter, message, Arrays.copyOf(arguments, arguments.length));
        }
    }

    public final boolean isWarnEnabled() {
        return MINIMUM_LEVEL_COVERS_WARN && provider.isEnabled(7, (String) null, Level.WARN);
    }

    public final void warn(Object message) {
        if (MINIMUM_LEVEL_COVERS_WARN) {
            provider.log(7, (String) null, Level.WARN, (Throwable) null, (MessageFormatter) null, message, Arrays.copyOf(new Object[0], 0));
        }
    }

    public final void warn(Supplier<?> message) {
        if (MINIMUM_LEVEL_COVERS_WARN) {
            provider.log(7, (String) null, Level.WARN, (Throwable) null, (MessageFormatter) null, message, Arrays.copyOf(new Object[0], 0));
        }
    }

    public final void warn(String message, Object... arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_WARN) {
            provider.log(7, (String) null, Level.WARN, (Throwable) null, formatter, message, Arrays.copyOf(arguments, arguments.length));
        }
    }

    public final void warn(String message, Supplier<?>... arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_WARN) {
            provider.log(7, (String) null, Level.WARN, (Throwable) null, formatter, message, Arrays.copyOf(arguments, arguments.length));
        }
    }

    public final void warn(Throwable exception) {
        if (MINIMUM_LEVEL_COVERS_WARN) {
            provider.log(7, (String) null, Level.WARN, exception, (MessageFormatter) null, (Object) null, Arrays.copyOf(new Object[0], 0));
        }
    }

    public final void warn(Throwable exception, String message) {
        if (MINIMUM_LEVEL_COVERS_WARN) {
            provider.log(7, (String) null, Level.WARN, exception, (MessageFormatter) null, message, Arrays.copyOf(new Object[0], 0));
        }
    }

    public final void warn(Throwable exception, Supplier<String> message) {
        if (MINIMUM_LEVEL_COVERS_WARN) {
            provider.log(7, (String) null, Level.WARN, exception, (MessageFormatter) null, message, Arrays.copyOf(new Object[0], 0));
        }
    }

    public final void warn(Throwable exception, String message, Object... arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_WARN) {
            provider.log(7, (String) null, Level.WARN, exception, formatter, message, Arrays.copyOf(arguments, arguments.length));
        }
    }

    public final void warn(Throwable exception, String message, Supplier<?>... arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_WARN) {
            provider.log(7, (String) null, Level.WARN, exception, formatter, message, Arrays.copyOf(arguments, arguments.length));
        }
    }

    public final boolean isErrorEnabled() {
        return MINIMUM_LEVEL_COVERS_ERROR && provider.isEnabled(7, (String) null, Level.ERROR);
    }

    public final void error(Object message) {
        if (MINIMUM_LEVEL_COVERS_ERROR) {
            provider.log(7, (String) null, Level.ERROR, (Throwable) null, (MessageFormatter) null, message, Arrays.copyOf(new Object[0], 0));
        }
    }

    public final void error(Supplier<?> message) {
        if (MINIMUM_LEVEL_COVERS_ERROR) {
            provider.log(7, (String) null, Level.ERROR, (Throwable) null, (MessageFormatter) null, message, Arrays.copyOf(new Object[0], 0));
        }
    }

    public final void error(String message, Object... arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_ERROR) {
            provider.log(7, (String) null, Level.ERROR, (Throwable) null, formatter, message, Arrays.copyOf(arguments, arguments.length));
        }
    }

    public final void error(String message, Supplier<?>... arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_ERROR) {
            provider.log(7, (String) null, Level.ERROR, (Throwable) null, formatter, message, Arrays.copyOf(arguments, arguments.length));
        }
    }

    public final void error(Throwable exception) {
        if (MINIMUM_LEVEL_COVERS_ERROR) {
            provider.log(7, (String) null, Level.ERROR, exception, (MessageFormatter) null, (Object) null, Arrays.copyOf(new Object[0], 0));
        }
    }

    public final void error(Throwable exception, String message) {
        if (MINIMUM_LEVEL_COVERS_ERROR) {
            provider.log(7, (String) null, Level.ERROR, exception, (MessageFormatter) null, message, Arrays.copyOf(new Object[0], 0));
        }
    }

    public final void error(Throwable exception, Supplier<String> message) {
        if (MINIMUM_LEVEL_COVERS_ERROR) {
            provider.log(7, (String) null, Level.ERROR, exception, (MessageFormatter) null, message, Arrays.copyOf(new Object[0], 0));
        }
    }

    public final void error(Throwable exception, String message, Object... arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_ERROR) {
            provider.log(7, (String) null, Level.ERROR, exception, formatter, message, Arrays.copyOf(arguments, arguments.length));
        }
    }

    public final void error(Throwable exception, String message, Supplier<?>... arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        if (MINIMUM_LEVEL_COVERS_ERROR) {
            provider.log(7, (String) null, Level.ERROR, exception, formatter, message, Arrays.copyOf(arguments, arguments.length));
        }
    }

    private final boolean isCoveredByMinimumLevel(Level level) {
        return provider.getMinimumLevel(null).ordinal() <= level.ordinal();
    }
}
