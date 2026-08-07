package com.box.android.domain.metrics;

import com.box.android.domain.services.IApdexScoreProvider;
import com.box.android.domain.usecases.observability.MetricsUseCase;
import javax.inject.Inject;
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

/* JADX INFO: compiled from: Gen204DownloadEventLogger.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJO\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0018Ja\u0010\u0019\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/box/android/domain/metrics/Gen204DownloadEventLogger;", "", "metricsUseCase", "Lcom/box/android/domain/usecases/observability/MetricsUseCase;", "coroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "apdexScoreProvider", "Lcom/box/android/domain/services/IApdexScoreProvider;", "<init>", "(Lcom/box/android/domain/usecases/observability/MetricsUseCase;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/box/android/domain/services/IApdexScoreProvider;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "success", "", "fileId", "", "numberOfAutoRetries", "", "numberOfManualRetries", "size", "", "initiatedAt", "runningDuration", "itemState", "(Ljava/lang/String;IIJLjava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "failure", "isRecoverable", "", "errorMessage", "(Ljava/lang/String;IIJZLjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Gen204DownloadEventLogger {
    private final IApdexScoreProvider apdexScoreProvider;
    private final CoroutineDispatcher coroutineDispatcher;
    private final CoroutineScope coroutineScope;
    private final MetricsUseCase metricsUseCase;

    @Inject
    public Gen204DownloadEventLogger(MetricsUseCase metricsUseCase, CoroutineDispatcher coroutineDispatcher, IApdexScoreProvider apdexScoreProvider) {
        Intrinsics.checkNotNullParameter(metricsUseCase, "metricsUseCase");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "coroutineDispatcher");
        Intrinsics.checkNotNullParameter(apdexScoreProvider, "apdexScoreProvider");
        this.metricsUseCase = metricsUseCase;
        this.coroutineDispatcher = coroutineDispatcher;
        this.apdexScoreProvider = apdexScoreProvider;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(coroutineDispatcher);
    }

    public static /* synthetic */ void success$default(Gen204DownloadEventLogger gen204DownloadEventLogger, String str, int i, int i2, long j, Long l, Long l2, String str2, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            l = null;
        }
        if ((i3 & 32) != 0) {
            l2 = null;
        }
        if ((i3 & 64) != 0) {
            str2 = null;
        }
        gen204DownloadEventLogger.success(str, i, i2, j, l, l2, str2);
    }

    /* JADX INFO: renamed from: com.box.android.domain.metrics.Gen204DownloadEventLogger$success$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Gen204DownloadEventLogger.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.metrics.Gen204DownloadEventLogger$success$1", f = "Gen204DownloadEventLogger.kt", i = {0, 1, 1, 1, 1, 1}, l = {36, 61}, m = "invokeSuspend", n = {"fileSizeKB", "milliSecondsPerKb", "apdexScore", "fileSizeKB", "it", "$i$a$-let-Gen204DownloadEventLogger$success$1$1"}, s = {"D$0", "L$0", "L$1", "D$0", "J$0", "I$0"}, v = 1)
    static final class C15861 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $fileId;
        final /* synthetic */ Long $initiatedAt;
        final /* synthetic */ String $itemState;
        final /* synthetic */ int $numberOfAutoRetries;
        final /* synthetic */ int $numberOfManualRetries;
        final /* synthetic */ Long $runningDuration;
        final /* synthetic */ long $size;
        double D$0;
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ Gen204DownloadEventLogger this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15861(long j, Gen204DownloadEventLogger gen204DownloadEventLogger, String str, int i, int i2, Long l, Long l2, String str2, Continuation<? super C15861> continuation) {
            super(2, continuation);
            this.$size = j;
            this.this$0 = gen204DownloadEventLogger;
            this.$fileId = str;
            this.$numberOfAutoRetries = i;
            this.$numberOfManualRetries = i2;
            this.$initiatedAt = l;
            this.$runningDuration = l2;
            this.$itemState = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C15861(this.$size, this.this$0, this.$fileId, this.$numberOfAutoRetries, this.$numberOfManualRetries, this.$initiatedAt, this.$runningDuration, this.$itemState, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C15861) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x0116, code lost:
        
            if (r6.log(r2, r29) == r1) goto L28;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r30) {
            /*
                Method dump skipped, instruction units count: 284
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.domain.metrics.Gen204DownloadEventLogger.C15861.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void success(String fileId, int numberOfAutoRetries, int numberOfManualRetries, long size, Long initiatedAt, Long runningDuration, String itemState) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C15861(size, this, fileId, numberOfAutoRetries, numberOfManualRetries, initiatedAt, runningDuration, itemState, null), 3, null);
    }

    public static /* synthetic */ void failure$default(Gen204DownloadEventLogger gen204DownloadEventLogger, String str, int i, int i2, long j, boolean z, String str2, Long l, Long l2, String str3, int i3, Object obj) {
        if ((i3 & 64) != 0) {
            l = null;
        }
        if ((i3 & 128) != 0) {
            l2 = null;
        }
        if ((i3 & 256) != 0) {
            str3 = null;
        }
        gen204DownloadEventLogger.failure(str, i, i2, j, z, str2, l, l2, str3);
    }

    /* JADX INFO: renamed from: com.box.android.domain.metrics.Gen204DownloadEventLogger$failure$1, reason: invalid class name */
    /* JADX INFO: compiled from: Gen204DownloadEventLogger.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.metrics.Gen204DownloadEventLogger$failure$1", f = "Gen204DownloadEventLogger.kt", i = {0, 1}, l = {89, 106}, m = "invokeSuspend", n = {"fileSizeKB", "fileSizeKB"}, s = {"D$0", "D$0"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $errorMessage;
        final /* synthetic */ String $fileId;
        final /* synthetic */ Long $initiatedAt;
        final /* synthetic */ boolean $isRecoverable;
        final /* synthetic */ String $itemState;
        final /* synthetic */ int $numberOfAutoRetries;
        final /* synthetic */ int $numberOfManualRetries;
        final /* synthetic */ Long $runningDuration;
        final /* synthetic */ long $size;
        double D$0;
        int label;
        final /* synthetic */ Gen204DownloadEventLogger this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(long j, Gen204DownloadEventLogger gen204DownloadEventLogger, String str, boolean z, String str2, int i, int i2, Long l, Long l2, String str3, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$size = j;
            this.this$0 = gen204DownloadEventLogger;
            this.$fileId = str;
            this.$isRecoverable = z;
            this.$errorMessage = str2;
            this.$numberOfAutoRetries = i;
            this.$numberOfManualRetries = i2;
            this.$initiatedAt = l;
            this.$runningDuration = l2;
            this.$itemState = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$size, this.this$0, this.$fileId, this.$isRecoverable, this.$errorMessage, this.$numberOfAutoRetries, this.$numberOfManualRetries, this.$initiatedAt, this.$runningDuration, this.$itemState, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x00c7, code lost:
        
            if (r2.log(new com.box.android.domain.models.observability.ApdexGen204Metric(r7, null, r8, null, kotlin.coroutines.jvm.internal.Boxing.boxDouble(r4), null, true, com.box.android.domain.models.observability.ApdexScore.Zero.INSTANCE, 42, null), r25) == r1) goto L22;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r26) {
            /*
                Method dump skipped, instruction units count: 205
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.domain.metrics.Gen204DownloadEventLogger.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void failure(String fileId, int numberOfAutoRetries, int numberOfManualRetries, long size, boolean isRecoverable, String errorMessage, Long initiatedAt, Long runningDuration, String itemState) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new AnonymousClass1(size, this, fileId, isRecoverable, errorMessage, numberOfAutoRetries, numberOfManualRetries, initiatedAt, runningDuration, itemState, null), 3, null);
    }
}
