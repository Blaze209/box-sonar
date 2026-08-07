package com.box.android.domain.metrics;

import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.observability.JobManagerVersion;
import com.box.android.domain.models.observability.MoveCopyEvent;
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

/* JADX INFO: compiled from: Gen204MoveCopyEventLogger.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J(\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J2\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/box/android/domain/metrics/Gen204MoveCopyEventLogger;", "", "metricsUseCase", "Lcom/box/android/domain/usecases/observability/MetricsUseCase;", "coroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/box/android/domain/usecases/observability/MetricsUseCase;Lkotlinx/coroutines/CoroutineDispatcher;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "success", "", "eventType", "Lcom/box/android/domain/models/observability/MoveCopyEvent$EventType;", "remoteId", "Lcom/box/android/domain/models/ItemId$Remote;", "jobManagerVersion", "Lcom/box/android/domain/models/observability/JobManagerVersion;", "failure", "failReason", "", "log", TelemetryEventStrings.Value.FAILED, "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Gen204MoveCopyEventLogger {
    private final CoroutineDispatcher coroutineDispatcher;
    private CoroutineScope coroutineScope;
    private final MetricsUseCase metricsUseCase;

    @Inject
    public Gen204MoveCopyEventLogger(MetricsUseCase metricsUseCase, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(metricsUseCase, "metricsUseCase");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "coroutineDispatcher");
        this.metricsUseCase = metricsUseCase;
        this.coroutineDispatcher = coroutineDispatcher;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(coroutineDispatcher);
    }

    public final void success(MoveCopyEvent.EventType eventType, ItemId.Remote remoteId, JobManagerVersion jobManagerVersion) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(remoteId, "remoteId");
        Intrinsics.checkNotNullParameter(jobManagerVersion, "jobManagerVersion");
        log(eventType, remoteId, false, jobManagerVersion, null);
    }

    public final void failure(MoveCopyEvent.EventType eventType, ItemId.Remote remoteId, JobManagerVersion jobManagerVersion, String failReason) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(remoteId, "remoteId");
        Intrinsics.checkNotNullParameter(jobManagerVersion, "jobManagerVersion");
        log(eventType, remoteId, true, jobManagerVersion, failReason);
    }

    /* JADX INFO: renamed from: com.box.android.domain.metrics.Gen204MoveCopyEventLogger$log$1, reason: invalid class name */
    /* JADX INFO: compiled from: Gen204MoveCopyEventLogger.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.metrics.Gen204MoveCopyEventLogger$log$1", f = "Gen204MoveCopyEventLogger.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MoveCopyEvent.EventType $eventType;
        final /* synthetic */ String $failReason;
        final /* synthetic */ boolean $failed;
        final /* synthetic */ JobManagerVersion $jobManagerVersion;
        final /* synthetic */ ItemId.Remote $remoteId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MoveCopyEvent.EventType eventType, ItemId.Remote remote, boolean z, JobManagerVersion jobManagerVersion, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$eventType = eventType;
            this.$remoteId = remote;
            this.$failed = z;
            this.$jobManagerVersion = jobManagerVersion;
            this.$failReason = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Gen204MoveCopyEventLogger.this.new AnonymousClass1(this.$eventType, this.$remoteId, this.$failed, this.$jobManagerVersion, this.$failReason, continuation);
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
                if (Gen204MoveCopyEventLogger.this.metricsUseCase.log(new MoveCopyEvent(this.$eventType, this.$remoteId, this.$failed, this.$jobManagerVersion, this.$failReason, null, null, 96, null), this) == coroutine_suspended) {
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

    public final void log(MoveCopyEvent.EventType eventType, ItemId.Remote remoteId, boolean failed, JobManagerVersion jobManagerVersion, String failReason) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(remoteId, "remoteId");
        Intrinsics.checkNotNullParameter(jobManagerVersion, "jobManagerVersion");
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new AnonymousClass1(eventType, remoteId, failed, jobManagerVersion, failReason, null), 3, null);
    }
}
