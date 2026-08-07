package com.box.android.domain.metrics;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.services.IApdexScoreProvider;
import com.box.android.domain.usecases.observability.MetricsUseCase;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: Gen204UploadEventLogger.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJt\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/box/android/domain/metrics/Gen204UploadEventLogger;", "", "metricsUseCase", "Lcom/box/android/domain/usecases/observability/MetricsUseCase;", "coroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "apdexScoreProvider", "Lcom/box/android/domain/services/IApdexScoreProvider;", "<init>", "(Lcom/box/android/domain/usecases/observability/MetricsUseCase;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/box/android/domain/services/IApdexScoreProvider;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "logV2", "", "jobType", "", "itemId", "Lcom/box/android/domain/models/ItemId;", "folderId", "numberOfAutoRetries", "", "numberOfManualRetries", "size", "", "bytesProcessed", "ttuSinceEnqueued", "ttuSinceStarted", "isAutoRetrying", "", "domainError", "Lcom/box/android/domain/models/DomainError;", "isNewVersionUpload", "isUserTriggeredJob", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Gen204UploadEventLogger {
    private final IApdexScoreProvider apdexScoreProvider;
    private final CoroutineDispatcher coroutineDispatcher;
    private final CoroutineScope coroutineScope;
    private final MetricsUseCase metricsUseCase;

    @Inject
    public Gen204UploadEventLogger(MetricsUseCase metricsUseCase, CoroutineDispatcher coroutineDispatcher, IApdexScoreProvider apdexScoreProvider) {
        Intrinsics.checkNotNullParameter(metricsUseCase, "metricsUseCase");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "coroutineDispatcher");
        Intrinsics.checkNotNullParameter(apdexScoreProvider, "apdexScoreProvider");
        this.metricsUseCase = metricsUseCase;
        this.coroutineDispatcher = coroutineDispatcher;
        this.apdexScoreProvider = apdexScoreProvider;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(coroutineDispatcher);
    }

    /* JADX INFO: renamed from: com.box.android.domain.metrics.Gen204UploadEventLogger$logV2$1, reason: invalid class name */
    /* JADX INFO: compiled from: Gen204UploadEventLogger.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.metrics.Gen204UploadEventLogger$logV2$1", f = "Gen204UploadEventLogger.kt", i = {0, 0, 1, 1, 1, 1}, l = {49, 80}, m = "invokeSuspend", n = {TelemetryEventStrings.Value.FAILED, "fileSizeKB", "milliSecondsPerKb", "apdexScore", TelemetryEventStrings.Value.FAILED, "fileSizeKB"}, s = {"I$0", "D$0", "L$0", "L$1", "I$0", "D$0"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $bytesProcessed;
        final /* synthetic */ DomainError $domainError;
        final /* synthetic */ String $folderId;
        final /* synthetic */ boolean $isAutoRetrying;
        final /* synthetic */ boolean $isNewVersionUpload;
        final /* synthetic */ boolean $isUserTriggeredJob;
        final /* synthetic */ ItemId $itemId;
        final /* synthetic */ String $jobType;
        final /* synthetic */ int $numberOfAutoRetries;
        final /* synthetic */ int $numberOfManualRetries;
        final /* synthetic */ long $size;
        final /* synthetic */ long $ttuSinceEnqueued;
        final /* synthetic */ long $ttuSinceStarted;
        double D$0;
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ Gen204UploadEventLogger this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(DomainError domainError, long j, Gen204UploadEventLogger gen204UploadEventLogger, String str, ItemId itemId, boolean z, int i, int i2, long j2, long j3, long j4, String str2, boolean z2, boolean z3, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$domainError = domainError;
            this.$size = j;
            this.this$0 = gen204UploadEventLogger;
            this.$jobType = str;
            this.$itemId = itemId;
            this.$isAutoRetrying = z;
            this.$numberOfAutoRetries = i;
            this.$numberOfManualRetries = i2;
            this.$ttuSinceStarted = j2;
            this.$ttuSinceEnqueued = j3;
            this.$bytesProcessed = j4;
            this.$folderId = str2;
            this.$isUserTriggeredJob = z2;
            this.$isNewVersionUpload = z3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$domainError, this.$size, this.this$0, this.$jobType, this.$itemId, this.$isAutoRetrying, this.$numberOfAutoRetries, this.$numberOfManualRetries, this.$ttuSinceStarted, this.$ttuSinceEnqueued, this.$bytesProcessed, this.$folderId, this.$isUserTriggeredJob, this.$isNewVersionUpload, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:34:0x0110  */
        /* JADX WARN: Code duplicated, block: B:36:0x0126  */
        /* JADX WARN: Code duplicated, block: B:37:0x0129  */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0150, code lost:
        
            if (r3.log(new com.box.android.domain.models.observability.ApdexGen204Metric(r10, null, r12, null, r15, r16, r17, r18, 10, null), r29) == r1) goto L40;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v0 */
        /* JADX WARN: Type inference failed for: r10v1, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r10v2 */
        /* JADX WARN: Type inference failed for: r2v11 */
        /* JADX WARN: Type inference failed for: r2v7 */
        /* JADX WARN: Type inference failed for: r2v8, types: [int] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r30) {
            /*
                Method dump skipped, instruction units count: 342
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.domain.metrics.Gen204UploadEventLogger.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void logV2(String jobType, ItemId itemId, String folderId, int numberOfAutoRetries, int numberOfManualRetries, long size, long bytesProcessed, long ttuSinceEnqueued, long ttuSinceStarted, boolean isAutoRetrying, DomainError domainError, boolean isNewVersionUpload, boolean isUserTriggeredJob) {
        Intrinsics.checkNotNullParameter(jobType, "jobType");
        Intrinsics.checkNotNullParameter(folderId, "folderId");
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new AnonymousClass1(domainError, size, this, jobType, itemId, isAutoRetrying, numberOfAutoRetries, numberOfManualRetries, ttuSinceStarted, ttuSinceEnqueued, bytesProcessed, folderId, isUserTriggeredJob, isNewVersionUpload, null), 3, null);
    }
}
