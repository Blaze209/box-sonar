package com.box.android.domain.metrics;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.observability.Gen204Event;
import com.box.android.domain.usecases.observability.MetricsUseCase;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: Gen204PerformanceLogger.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0017B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tJ*\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00140\u0013J2\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\t2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00140\u0013J\b\u0010\u0016\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/box/android/domain/metrics/Gen204PerformanceLogger;", "", "metricsUseCase", "Lcom/box/android/domain/usecases/observability/MetricsUseCase;", "<init>", "(Lcom/box/android/domain/usecases/observability/MetricsUseCase;)V", "startTimeMap", "", "Lcom/box/android/domain/metrics/Gen204PerformanceLogger$PerformanceKey;", "", "registerStart", "", "type", "Lcom/box/android/domain/metrics/PerformanceType;", "id", "", "startTime", "registerEnd", "eventProducer", "Lkotlin/Function1;", "Lcom/box/android/domain/models/observability/Gen204Event;", "endTime", "getCurrentMillis", "PerformanceKey", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Gen204PerformanceLogger {
    private final MetricsUseCase metricsUseCase;
    private final Map<PerformanceKey, Long> startTimeMap;

    @Inject
    public Gen204PerformanceLogger(MetricsUseCase metricsUseCase) {
        Intrinsics.checkNotNullParameter(metricsUseCase, "metricsUseCase");
        this.metricsUseCase = metricsUseCase;
        this.startTimeMap = new LinkedHashMap();
    }

    /* JADX INFO: compiled from: Gen204PerformanceLogger.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/domain/metrics/Gen204PerformanceLogger$PerformanceKey;", "", "type", "Lcom/box/android/domain/metrics/PerformanceType;", "id", "", "<init>", "(Lcom/box/android/domain/metrics/PerformanceType;Ljava/lang/String;)V", "getType", "()Lcom/box/android/domain/metrics/PerformanceType;", "getId", "()Ljava/lang/String;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final /* data */ class PerformanceKey {
        private final String id;
        private final PerformanceType type;

        public static /* synthetic */ PerformanceKey copy$default(PerformanceKey performanceKey, PerformanceType performanceType, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                performanceType = performanceKey.type;
            }
            if ((i & 2) != 0) {
                str = performanceKey.id;
            }
            return performanceKey.copy(performanceType, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final PerformanceType getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getId() {
            return this.id;
        }

        public final PerformanceKey copy(PerformanceType type, String id) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(id, "id");
            return new PerformanceKey(type, id);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PerformanceKey)) {
                return false;
            }
            PerformanceKey performanceKey = (PerformanceKey) other;
            return this.type == performanceKey.type && Intrinsics.areEqual(this.id, performanceKey.id);
        }

        public int hashCode() {
            return (this.type.hashCode() * 31) + this.id.hashCode();
        }

        public String toString() {
            return "PerformanceKey(type=" + this.type + ", id=" + this.id + ")";
        }

        public PerformanceKey(PerformanceType type, String id) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(id, "id");
            this.type = type;
            this.id = id;
        }

        public final String getId() {
            return this.id;
        }

        public final PerformanceType getType() {
            return this.type;
        }
    }

    public final void registerStart(PerformanceType type, String id) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(id, "id");
        registerStart(type, id, getCurrentMillis());
    }

    public final void registerStart(PerformanceType type, String id, long startTime) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(id, "id");
        this.startTimeMap.put(new PerformanceKey(type, id), Long.valueOf(startTime));
    }

    public final void registerEnd(PerformanceType type, String id, Function1<? super Long, ? extends Gen204Event> eventProducer) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(eventProducer, "eventProducer");
        registerEnd(type, id, getCurrentMillis(), eventProducer);
    }

    public final void registerEnd(PerformanceType type, String id, long endTime, Function1<? super Long, ? extends Gen204Event> eventProducer) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(eventProducer, "eventProducer");
        Long lRemove = this.startTimeMap.remove(new PerformanceKey(type, id));
        if (lRemove != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(eventProducer.invoke(Long.valueOf(endTime - lRemove.longValue())), null), 3, null);
        }
    }

    /* JADX INFO: renamed from: com.box.android.domain.metrics.Gen204PerformanceLogger$registerEnd$1, reason: invalid class name */
    /* JADX INFO: compiled from: Gen204PerformanceLogger.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.metrics.Gen204PerformanceLogger$registerEnd$1", f = "Gen204PerformanceLogger.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Gen204Event $performanceEvent;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Gen204Event gen204Event, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$performanceEvent = gen204Event;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Gen204PerformanceLogger.this.new AnonymousClass1(this.$performanceEvent, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (Gen204PerformanceLogger.this.metricsUseCase.log(this.$performanceEvent, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    private final long getCurrentMillis() {
        return System.currentTimeMillis();
    }
}
