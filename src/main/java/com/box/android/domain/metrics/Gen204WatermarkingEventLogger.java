package com.box.android.domain.metrics;

import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.observability.WatermarkingUpdateEvent;
import com.box.android.domain.usecases.observability.MetricsUseCase;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: Gen204WatermarkingEventLogger.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ \u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J*\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/box/android/domain/metrics/Gen204WatermarkingEventLogger;", "", "metricsUseCase", "Lcom/box/android/domain/usecases/observability/MetricsUseCase;", "coroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/box/android/domain/usecases/observability/MetricsUseCase;Lkotlinx/coroutines/CoroutineDispatcher;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "logSuccess", "", "remoteId", "Lcom/box/android/domain/models/ItemId$Remote;", "isWatermarkEnabled", "", "logFailure", "failReason", "", "log", TelemetryEventStrings.Value.FAILED, "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Gen204WatermarkingEventLogger {
    private final CoroutineDispatcher coroutineDispatcher;
    private CoroutineScope coroutineScope;
    private final MetricsUseCase metricsUseCase;

    @Inject
    public Gen204WatermarkingEventLogger(MetricsUseCase metricsUseCase, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(metricsUseCase, "metricsUseCase");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "coroutineDispatcher");
        this.metricsUseCase = metricsUseCase;
        this.coroutineDispatcher = coroutineDispatcher;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(coroutineDispatcher);
    }

    public final void logSuccess(ItemId.Remote remoteId, boolean isWatermarkEnabled) {
        Intrinsics.checkNotNullParameter(remoteId, "remoteId");
        log(remoteId, isWatermarkEnabled, false, null);
    }

    public final void logFailure(ItemId.Remote remoteId, boolean isWatermarkEnabled, String failReason) {
        Intrinsics.checkNotNullParameter(remoteId, "remoteId");
        log(remoteId, isWatermarkEnabled, true, failReason);
    }

    /* JADX INFO: renamed from: com.box.android.domain.metrics.Gen204WatermarkingEventLogger$log$1, reason: invalid class name */
    /* JADX INFO: compiled from: Gen204WatermarkingEventLogger.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.metrics.Gen204WatermarkingEventLogger$log$1", f = "Gen204WatermarkingEventLogger.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $failReason;
        final /* synthetic */ boolean $failed;
        final /* synthetic */ boolean $isWatermarkEnabled;
        final /* synthetic */ ItemId.Remote $remoteId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ItemId.Remote remote, boolean z, boolean z2, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$remoteId = remote;
            this.$isWatermarkEnabled = z;
            this.$failed = z2;
            this.$failReason = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Gen204WatermarkingEventLogger.this.new AnonymousClass1(this.$remoteId, this.$isWatermarkEnabled, this.$failed, this.$failReason, continuation);
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
                if (Gen204WatermarkingEventLogger.this.metricsUseCase.log(new WatermarkingUpdateEvent(this.$remoteId, this.$isWatermarkEnabled, this.$failed, this.$failReason, null, null, 48, null), this) == coroutine_suspended) {
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

    public final void log(ItemId.Remote remoteId, boolean isWatermarkEnabled, boolean failed, String failReason) {
        Intrinsics.checkNotNullParameter(remoteId, "remoteId");
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new AnonymousClass1(remoteId, isWatermarkEnabled, failed, failReason, null), 3, null);
    }
}
