package org.tinylog.kotlin;

import com.box.androidsdk.content.models.BoxRepresentation;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pspdfkit.internal.jni.NativeFormNotifications;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.tinylog.Level;
import org.tinylog.Supplier;
import org.tinylog.configuration.Configuration;
import org.tinylog.format.AdvancedMessageFormatter;
import org.tinylog.format.MessageFormatter;
import org.tinylog.provider.LoggingProvider;
import org.tinylog.provider.ProviderRegistry;

/* JADX INFO: compiled from: TaggedLogger.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\u0002\u0010\u0005J \u0010\u0018\u001a\u00020\f2\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0014\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u001eJ\u0010\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004J7\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00042\"\u0010\u001f\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001e0 \"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001e¢\u0006\u0002\u0010!J+\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00042\u0016\u0010\u001f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010 \"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\"J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$J\u001c\u0010\u001b\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u001eJ\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\u0004J?\u0010\u001b\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\u00042\"\u0010\u001f\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001e0 \"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001e¢\u0006\u0002\u0010%J3\u0010\u001b\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\u00042\u0016\u0010\u001f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010 \"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010&J\u0014\u0010'\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u001eJ\u0010\u0010'\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001J\u000e\u0010'\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004J7\u0010'\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00042\"\u0010\u001f\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001e0 \"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001e¢\u0006\u0002\u0010!J+\u0010'\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00042\u0016\u0010\u001f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010 \"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\"J\u000e\u0010'\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$J\u001c\u0010'\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u001eJ\u0016\u0010'\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\u0004J?\u0010'\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\u00042\"\u0010\u001f\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001e0 \"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001e¢\u0006\u0002\u0010%J3\u0010'\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\u00042\u0016\u0010\u001f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010 \"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010&J(\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0014\u0010)\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u001eJ\u0010\u0010)\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001J\u000e\u0010)\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004J7\u0010)\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00042\"\u0010\u001f\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001e0 \"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001e¢\u0006\u0002\u0010!J+\u0010)\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00042\u0016\u0010\u001f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010 \"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\"J\u000e\u0010)\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$J\u001c\u0010)\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u001eJ\u0016\u0010)\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\u0004J?\u0010)\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\u00042\"\u0010\u001f\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001e0 \"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001e¢\u0006\u0002\u0010%J3\u0010)\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\u00042\u0016\u0010\u001f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010 \"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010&J\u001a\u0010*\u001a\u00020\f2\b\u0010+\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0006\u0010,\u001a\u00020\fJ\u0006\u0010-\u001a\u00020\fJ\u0006\u0010.\u001a\u00020\fJ\u0006\u0010/\u001a\u00020\fJ\u0006\u00100\u001a\u00020\fJ\u0014\u00101\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u001eJ\u0010\u00101\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001J\u000e\u00101\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004J7\u00101\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00042\"\u0010\u001f\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001e0 \"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001e¢\u0006\u0002\u0010!J+\u00101\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00042\u0016\u0010\u001f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010 \"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\"J\u000e\u00101\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$J\u001c\u00101\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u001eJ\u0016\u00101\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\u0004J?\u00101\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\u00042\"\u0010\u001f\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001e0 \"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001e¢\u0006\u0002\u0010%J3\u00101\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\u00042\u0016\u0010\u001f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010 \"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010&J\u0014\u00102\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u001eJ\u0010\u00102\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001J\u000e\u00102\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004J7\u00102\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00042\"\u0010\u001f\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001e0 \"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001e¢\u0006\u0002\u0010!J+\u00102\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00042\u0016\u0010\u001f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010 \"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\"J\u000e\u00102\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$J\u001c\u00102\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u001eJ\u0016\u00102\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\u0004J?\u00102\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\u00042\"\u0010\u001f\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001e0 \"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001e¢\u0006\u0002\u0010%J3\u00102\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\u00042\u0016\u0010\u001f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010 \"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010&R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lorg/tinylog/kotlin/TaggedLogger;", "", "tags", "", "", "(Ljava/util/Set;)V", "debugTags", "errorTags", "formatter", "Lorg/tinylog/format/AdvancedMessageFormatter;", "infoTags", "minimumLevelCoversDebug", "", "minimumLevelCoversError", "minimumLevelCoversInfo", "minimumLevelCoversTrace", "minimumLevelCoversWarn", NativeFormNotifications.PROVIDER_INDEX_INFO_KEY, "Lorg/tinylog/provider/LoggingProvider;", "kotlin.jvm.PlatformType", "stackTraceDepth", "", "traceTags", "warnTags", "anyEnabled", FirebaseAnalytics.Param.LEVEL, "Lorg/tinylog/Level;", "debug", "", "message", "Lkotlin/Function0;", "arguments", "", "(Ljava/lang/String;[Lkotlin/jvm/functions/Function0;)V", "(Ljava/lang/String;[Ljava/lang/Object;)V", "exception", "", "(Ljava/lang/Throwable;Ljava/lang/String;[Lkotlin/jvm/functions/Function0;)V", "(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V", "error", "getCoveredTags", BoxRepresentation.FIELD_INFO, "isCoveredByMinimumLevel", "tag", "isDebugEnabled", "isErrorEnabled", "isInfoEnabled", "isTraceEnabled", "isWarnEnabled", "trace", "warn", "tinylog-api-kotlin"}, k = 1, mv = {1, 1, 18})
public final class TaggedLogger {
    private final Set<String> debugTags;
    private final Set<String> errorTags;
    private final AdvancedMessageFormatter formatter;
    private final Set<String> infoTags;
    private final boolean minimumLevelCoversDebug;
    private final boolean minimumLevelCoversError;
    private final boolean minimumLevelCoversInfo;
    private final boolean minimumLevelCoversTrace;
    private final boolean minimumLevelCoversWarn;
    private final LoggingProvider provider;
    private final int stackTraceDepth;
    private final Set<String> tags;
    private final Set<String> traceTags;
    private final Set<String> warnTags;

    public TaggedLogger(Set<String> tags) {
        Intrinsics.checkParameterIsNotNull(tags, "tags");
        this.tags = tags;
        this.stackTraceDepth = 2;
        this.formatter = new AdvancedMessageFormatter(Configuration.getLocale(), Configuration.isEscapingEnabled());
        this.provider = ProviderRegistry.getLoggingProvider();
        Set<String> coveredTags = getCoveredTags(tags, Level.TRACE);
        this.traceTags = coveredTags;
        Set<String> coveredTags2 = getCoveredTags(tags, Level.DEBUG);
        this.debugTags = coveredTags2;
        Set<String> coveredTags3 = getCoveredTags(tags, Level.INFO);
        this.infoTags = coveredTags3;
        Set<String> coveredTags4 = getCoveredTags(tags, Level.WARN);
        this.warnTags = coveredTags4;
        Set<String> coveredTags5 = getCoveredTags(tags, Level.ERROR);
        this.errorTags = coveredTags5;
        this.minimumLevelCoversTrace = !coveredTags.isEmpty();
        this.minimumLevelCoversDebug = !coveredTags2.isEmpty();
        this.minimumLevelCoversInfo = !coveredTags3.isEmpty();
        this.minimumLevelCoversWarn = !coveredTags4.isEmpty();
        this.minimumLevelCoversError = !coveredTags5.isEmpty();
    }

    public final boolean isTraceEnabled() {
        return this.minimumLevelCoversTrace && anyEnabled(this.traceTags, Level.TRACE);
    }

    public final void trace(Object message) {
        if (this.minimumLevelCoversTrace) {
            Iterator<String> it = this.traceTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.TRACE, (Throwable) null, (MessageFormatter) null, message, new Object[0]);
            }
        }
    }

    public final void trace(String message) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (this.minimumLevelCoversTrace) {
            Iterator<String> it = this.traceTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.TRACE, (Throwable) null, (MessageFormatter) null, message, new Object[0]);
            }
        }
    }

    public final void trace(Function0<String> message) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (this.minimumLevelCoversTrace) {
            Iterator<String> it = this.traceTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.TRACE, (Throwable) null, (MessageFormatter) null, SupplierUtilsKt.asSupplier(message), new Object[0]);
            }
        }
    }

    public final void trace(String message, Object... arguments) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (this.minimumLevelCoversTrace) {
            Iterator<String> it = this.traceTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.TRACE, (Throwable) null, this.formatter, message, Arrays.copyOf(arguments, arguments.length));
            }
        }
    }

    public final void trace(String message, Function0<? extends Object>... arguments) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (this.minimumLevelCoversTrace) {
            for (String str : this.traceTags) {
                LoggingProvider loggingProvider = this.provider;
                int i = this.stackTraceDepth;
                Level level = Level.TRACE;
                AdvancedMessageFormatter advancedMessageFormatter = this.formatter;
                Supplier[] supplierArrAsSuppliers = SupplierUtilsKt.asSuppliers(arguments);
                loggingProvider.log(i, str, level, (Throwable) null, advancedMessageFormatter, message, Arrays.copyOf(supplierArrAsSuppliers, supplierArrAsSuppliers.length));
            }
        }
    }

    public final void trace(Throwable exception) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        if (this.minimumLevelCoversTrace) {
            Iterator<String> it = this.traceTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.TRACE, exception, (MessageFormatter) null, (Object) null, new Object[0]);
            }
        }
    }

    public final void trace(Throwable exception, String message) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (this.minimumLevelCoversTrace) {
            Iterator<String> it = this.traceTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.TRACE, exception, (MessageFormatter) null, message, new Object[0]);
            }
        }
    }

    public final void trace(Throwable exception, Function0<String> message) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (this.minimumLevelCoversTrace) {
            Iterator<String> it = this.traceTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.TRACE, exception, (MessageFormatter) null, SupplierUtilsKt.asSupplier(message), new Object[0]);
            }
        }
    }

    public final void trace(Throwable exception, String message, Object... arguments) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (this.minimumLevelCoversTrace) {
            Iterator<String> it = this.traceTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.TRACE, exception, this.formatter, message, Arrays.copyOf(arguments, arguments.length));
            }
        }
    }

    public final void trace(Throwable exception, String message, Function0<? extends Object>... arguments) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (this.minimumLevelCoversTrace) {
            for (String str : this.traceTags) {
                LoggingProvider loggingProvider = this.provider;
                int i = this.stackTraceDepth;
                Level level = Level.TRACE;
                AdvancedMessageFormatter advancedMessageFormatter = this.formatter;
                Supplier[] supplierArrAsSuppliers = SupplierUtilsKt.asSuppliers(arguments);
                loggingProvider.log(i, str, level, exception, advancedMessageFormatter, message, Arrays.copyOf(supplierArrAsSuppliers, supplierArrAsSuppliers.length));
            }
        }
    }

    public final boolean isDebugEnabled() {
        return this.minimumLevelCoversDebug && anyEnabled(this.debugTags, Level.DEBUG);
    }

    public final void debug(Object message) {
        if (this.minimumLevelCoversDebug) {
            Iterator<String> it = this.debugTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.DEBUG, (Throwable) null, (MessageFormatter) null, message, new Object[0]);
            }
        }
    }

    public final void debug(String message) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (this.minimumLevelCoversDebug) {
            Iterator<String> it = this.debugTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.DEBUG, (Throwable) null, (MessageFormatter) null, message, new Object[0]);
            }
        }
    }

    public final void debug(Function0<String> message) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (this.minimumLevelCoversDebug) {
            Iterator<String> it = this.debugTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.DEBUG, (Throwable) null, (MessageFormatter) null, SupplierUtilsKt.asSupplier(message), new Object[0]);
            }
        }
    }

    public final void debug(String message, Object... arguments) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (this.minimumLevelCoversDebug) {
            Iterator<String> it = this.debugTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.DEBUG, (Throwable) null, this.formatter, message, Arrays.copyOf(arguments, arguments.length));
            }
        }
    }

    public final void debug(String message, Function0<? extends Object>... arguments) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (this.minimumLevelCoversDebug) {
            for (String str : this.debugTags) {
                LoggingProvider loggingProvider = this.provider;
                int i = this.stackTraceDepth;
                Level level = Level.DEBUG;
                AdvancedMessageFormatter advancedMessageFormatter = this.formatter;
                Supplier[] supplierArrAsSuppliers = SupplierUtilsKt.asSuppliers(arguments);
                loggingProvider.log(i, str, level, (Throwable) null, advancedMessageFormatter, message, Arrays.copyOf(supplierArrAsSuppliers, supplierArrAsSuppliers.length));
            }
        }
    }

    public final void debug(Throwable exception) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        if (this.minimumLevelCoversDebug) {
            Iterator<String> it = this.debugTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.DEBUG, exception, (MessageFormatter) null, (Object) null, new Object[0]);
            }
        }
    }

    public final void debug(Throwable exception, String message) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (this.minimumLevelCoversDebug) {
            Iterator<String> it = this.debugTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.DEBUG, exception, (MessageFormatter) null, message, new Object[0]);
            }
        }
    }

    public final void debug(Throwable exception, Function0<String> message) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (this.minimumLevelCoversDebug) {
            Iterator<String> it = this.debugTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.DEBUG, exception, (MessageFormatter) null, SupplierUtilsKt.asSupplier(message), new Object[0]);
            }
        }
    }

    public final void debug(Throwable exception, String message, Object... arguments) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (this.minimumLevelCoversDebug) {
            Iterator<String> it = this.debugTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.DEBUG, exception, this.formatter, message, Arrays.copyOf(arguments, arguments.length));
            }
        }
    }

    public final void debug(Throwable exception, String message, Function0<? extends Object>... arguments) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (this.minimumLevelCoversDebug) {
            for (String str : this.debugTags) {
                LoggingProvider loggingProvider = this.provider;
                int i = this.stackTraceDepth;
                Level level = Level.DEBUG;
                AdvancedMessageFormatter advancedMessageFormatter = this.formatter;
                Supplier[] supplierArrAsSuppliers = SupplierUtilsKt.asSuppliers(arguments);
                loggingProvider.log(i, str, level, exception, advancedMessageFormatter, message, Arrays.copyOf(supplierArrAsSuppliers, supplierArrAsSuppliers.length));
            }
        }
    }

    public final boolean isInfoEnabled() {
        if (!this.minimumLevelCoversInfo) {
            return false;
        }
        Set<String> set = this.infoTags;
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        for (String str : set) {
            if (anyEnabled(this.infoTags, Level.INFO)) {
                return true;
            }
        }
        return false;
    }

    public final void info(Object message) {
        if (this.minimumLevelCoversInfo) {
            Iterator<String> it = this.infoTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.INFO, (Throwable) null, (MessageFormatter) null, message, new Object[0]);
            }
        }
    }

    public final void info(String message) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (this.minimumLevelCoversInfo) {
            Iterator<String> it = this.infoTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.INFO, (Throwable) null, (MessageFormatter) null, message, new Object[0]);
            }
        }
    }

    public final void info(Function0<String> message) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (this.minimumLevelCoversInfo) {
            Iterator<String> it = this.infoTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.INFO, (Throwable) null, (MessageFormatter) null, SupplierUtilsKt.asSupplier(message), new Object[0]);
            }
        }
    }

    public final void info(String message, Object... arguments) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (this.minimumLevelCoversInfo) {
            Iterator<String> it = this.infoTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.INFO, (Throwable) null, this.formatter, message, Arrays.copyOf(arguments, arguments.length));
            }
        }
    }

    public final void info(String message, Function0<? extends Object>... arguments) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (this.minimumLevelCoversInfo) {
            for (String str : this.infoTags) {
                LoggingProvider loggingProvider = this.provider;
                int i = this.stackTraceDepth;
                Level level = Level.INFO;
                AdvancedMessageFormatter advancedMessageFormatter = this.formatter;
                Supplier[] supplierArrAsSuppliers = SupplierUtilsKt.asSuppliers(arguments);
                loggingProvider.log(i, str, level, (Throwable) null, advancedMessageFormatter, message, Arrays.copyOf(supplierArrAsSuppliers, supplierArrAsSuppliers.length));
            }
        }
    }

    public final void info(Throwable exception) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        if (this.minimumLevelCoversInfo) {
            Iterator<String> it = this.infoTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.INFO, exception, (MessageFormatter) null, (Object) null, new Object[0]);
            }
        }
    }

    public final void info(Throwable exception, String message) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (this.minimumLevelCoversInfo) {
            Iterator<String> it = this.infoTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.INFO, exception, (MessageFormatter) null, message, new Object[0]);
            }
        }
    }

    public final void info(Throwable exception, Function0<String> message) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (this.minimumLevelCoversInfo) {
            Iterator<String> it = this.infoTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.INFO, exception, (MessageFormatter) null, SupplierUtilsKt.asSupplier(message), new Object[0]);
            }
        }
    }

    public final void info(Throwable exception, String message, Object... arguments) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (this.minimumLevelCoversInfo) {
            Iterator<String> it = this.infoTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.INFO, exception, this.formatter, message, Arrays.copyOf(arguments, arguments.length));
            }
        }
    }

    public final void info(Throwable exception, String message, Function0<? extends Object>... arguments) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (this.minimumLevelCoversInfo) {
            for (String str : this.infoTags) {
                LoggingProvider loggingProvider = this.provider;
                int i = this.stackTraceDepth;
                Level level = Level.INFO;
                AdvancedMessageFormatter advancedMessageFormatter = this.formatter;
                Supplier[] supplierArrAsSuppliers = SupplierUtilsKt.asSuppliers(arguments);
                loggingProvider.log(i, str, level, exception, advancedMessageFormatter, message, Arrays.copyOf(supplierArrAsSuppliers, supplierArrAsSuppliers.length));
            }
        }
    }

    public final boolean isWarnEnabled() {
        if (!this.minimumLevelCoversWarn) {
            return false;
        }
        Set<String> set = this.warnTags;
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        for (String str : set) {
            if (anyEnabled(this.warnTags, Level.WARN)) {
                return true;
            }
        }
        return false;
    }

    public final void warn(Object message) {
        if (this.minimumLevelCoversWarn) {
            Iterator<String> it = this.warnTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.WARN, (Throwable) null, (MessageFormatter) null, message, new Object[0]);
            }
        }
    }

    public final void warn(String message) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (this.minimumLevelCoversWarn) {
            Iterator<String> it = this.warnTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.WARN, (Throwable) null, (MessageFormatter) null, message, new Object[0]);
            }
        }
    }

    public final void warn(Function0<String> message) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (this.minimumLevelCoversWarn) {
            Iterator<String> it = this.warnTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.WARN, (Throwable) null, (MessageFormatter) null, SupplierUtilsKt.asSupplier(message), new Object[0]);
            }
        }
    }

    public final void warn(String message, Object... arguments) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (this.minimumLevelCoversWarn) {
            Iterator<String> it = this.warnTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.WARN, (Throwable) null, this.formatter, message, Arrays.copyOf(arguments, arguments.length));
            }
        }
    }

    public final void warn(String message, Function0<? extends Object>... arguments) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (this.minimumLevelCoversWarn) {
            for (String str : this.warnTags) {
                LoggingProvider loggingProvider = this.provider;
                int i = this.stackTraceDepth;
                Level level = Level.WARN;
                AdvancedMessageFormatter advancedMessageFormatter = this.formatter;
                Supplier[] supplierArrAsSuppliers = SupplierUtilsKt.asSuppliers(arguments);
                loggingProvider.log(i, str, level, (Throwable) null, advancedMessageFormatter, message, Arrays.copyOf(supplierArrAsSuppliers, supplierArrAsSuppliers.length));
            }
        }
    }

    public final void warn(Throwable exception) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        if (this.minimumLevelCoversWarn) {
            Iterator<String> it = this.warnTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.WARN, exception, (MessageFormatter) null, (Object) null, new Object[0]);
            }
        }
    }

    public final void warn(Throwable exception, String message) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (this.minimumLevelCoversWarn) {
            Iterator<String> it = this.warnTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.WARN, exception, (MessageFormatter) null, message, new Object[0]);
            }
        }
    }

    public final void warn(Throwable exception, Function0<String> message) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (this.minimumLevelCoversWarn) {
            Iterator<String> it = this.warnTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.WARN, exception, (MessageFormatter) null, SupplierUtilsKt.asSupplier(message), new Object[0]);
            }
        }
    }

    public final void warn(Throwable exception, String message, Object... arguments) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (this.minimumLevelCoversWarn) {
            Iterator<String> it = this.warnTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.WARN, exception, this.formatter, message, Arrays.copyOf(arguments, arguments.length));
            }
        }
    }

    public final void warn(Throwable exception, String message, Function0<? extends Object>... arguments) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (this.minimumLevelCoversWarn) {
            for (String str : this.warnTags) {
                LoggingProvider loggingProvider = this.provider;
                int i = this.stackTraceDepth;
                Level level = Level.WARN;
                AdvancedMessageFormatter advancedMessageFormatter = this.formatter;
                Supplier[] supplierArrAsSuppliers = SupplierUtilsKt.asSuppliers(arguments);
                loggingProvider.log(i, str, level, exception, advancedMessageFormatter, message, Arrays.copyOf(supplierArrAsSuppliers, supplierArrAsSuppliers.length));
            }
        }
    }

    public final boolean isErrorEnabled() {
        if (!this.minimumLevelCoversError) {
            return false;
        }
        Set<String> set = this.errorTags;
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        for (String str : set) {
            if (anyEnabled(this.errorTags, Level.ERROR)) {
                return true;
            }
        }
        return false;
    }

    public final void error(Object message) {
        if (this.minimumLevelCoversError) {
            Iterator<String> it = this.errorTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.ERROR, (Throwable) null, (MessageFormatter) null, message, new Object[0]);
            }
        }
    }

    public final void error(String message) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (this.minimumLevelCoversError) {
            Iterator<String> it = this.errorTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.ERROR, (Throwable) null, (MessageFormatter) null, message, new Object[0]);
            }
        }
    }

    public final void error(Function0<String> message) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (this.minimumLevelCoversError) {
            Iterator<String> it = this.errorTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.ERROR, (Throwable) null, (MessageFormatter) null, SupplierUtilsKt.asSupplier(message), new Object[0]);
            }
        }
    }

    public final void error(String message, Object... arguments) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (this.minimumLevelCoversError) {
            Iterator<String> it = this.errorTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.ERROR, (Throwable) null, this.formatter, message, Arrays.copyOf(arguments, arguments.length));
            }
        }
    }

    public final void error(String message, Function0<? extends Object>... arguments) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (this.minimumLevelCoversError) {
            for (String str : this.errorTags) {
                LoggingProvider loggingProvider = this.provider;
                int i = this.stackTraceDepth;
                Level level = Level.ERROR;
                AdvancedMessageFormatter advancedMessageFormatter = this.formatter;
                Supplier[] supplierArrAsSuppliers = SupplierUtilsKt.asSuppliers(arguments);
                loggingProvider.log(i, str, level, (Throwable) null, advancedMessageFormatter, message, Arrays.copyOf(supplierArrAsSuppliers, supplierArrAsSuppliers.length));
            }
        }
    }

    public final void error(Throwable exception) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        if (this.minimumLevelCoversError) {
            Iterator<String> it = this.errorTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.ERROR, exception, (MessageFormatter) null, (Object) null, new Object[0]);
            }
        }
    }

    public final void error(Throwable exception, String message) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (this.minimumLevelCoversError) {
            Iterator<String> it = this.errorTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.ERROR, exception, (MessageFormatter) null, message, new Object[0]);
            }
        }
    }

    public final void error(Throwable exception, Function0<String> message) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (this.minimumLevelCoversError) {
            Iterator<String> it = this.errorTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.ERROR, exception, (MessageFormatter) null, SupplierUtilsKt.asSupplier(message), new Object[0]);
            }
        }
    }

    public final void error(Throwable exception, String message, Object... arguments) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (this.minimumLevelCoversError) {
            Iterator<String> it = this.errorTags.iterator();
            while (it.hasNext()) {
                this.provider.log(this.stackTraceDepth, it.next(), Level.ERROR, exception, this.formatter, message, Arrays.copyOf(arguments, arguments.length));
            }
        }
    }

    public final void error(Throwable exception, String message, Function0<? extends Object>... arguments) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(arguments, "arguments");
        if (this.minimumLevelCoversError) {
            for (String str : this.errorTags) {
                LoggingProvider loggingProvider = this.provider;
                int i = this.stackTraceDepth;
                Level level = Level.ERROR;
                AdvancedMessageFormatter advancedMessageFormatter = this.formatter;
                Supplier[] supplierArrAsSuppliers = SupplierUtilsKt.asSuppliers(arguments);
                loggingProvider.log(i, str, level, exception, advancedMessageFormatter, message, Arrays.copyOf(supplierArrAsSuppliers, supplierArrAsSuppliers.length));
            }
        }
    }

    private final boolean anyEnabled(Set<String> tags, Level level) {
        Iterator<String> it = tags.iterator();
        while (it.hasNext()) {
            if (this.provider.isEnabled(this.stackTraceDepth + 1, it.next(), level)) {
                return true;
            }
        }
        return false;
    }

    private final Set<String> getCoveredTags(Set<String> tags, Level level) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : tags) {
            if (isCoveredByMinimumLevel((String) obj, level)) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.toHashSet(arrayList);
    }

    private final boolean isCoveredByMinimumLevel(String tag, Level level) {
        return this.provider.getMinimumLevel(tag).ordinal() <= level.ordinal();
    }
}
