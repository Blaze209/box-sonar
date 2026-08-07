package com.box.android.domain.metrics;

import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.observability.JobManagerVersion;
import com.box.android.domain.models.observability.OfflineEvent;
import com.box.android.domain.usecases.observability.MetricsUseCase;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import external.sdk.pendo.io.mozilla.javascript.Token;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: Gen204OfflineEventLogger.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007JB\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000fJL\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000fJ2\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00122\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0012JD\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00122\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u000fJR\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000fH\u0007JJ\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/box/android/domain/metrics/Gen204OfflineEventLogger;", "", "metricsUseCase", "Lcom/box/android/domain/usecases/observability/MetricsUseCase;", "coroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/box/android/domain/usecases/observability/MetricsUseCase;Lkotlinx/coroutines/CoroutineDispatcher;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "fileSuccess", "", "remoteId", "Lcom/box/android/domain/models/ItemId$Remote;", "downloadOriginalStatus", "", "downloadPreviewStatus", "numberOfAutomaticRetries", "", "numberOfManualRetries", "itemState", "fileFailure", "failReason", "folderSuccess", "totalFiles", "succeededFiles", "folderFailure", "failedFiles", "logFile", TelemetryEventStrings.Value.FAILED, "", "logFolder", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Gen204OfflineEventLogger {
    private final CoroutineDispatcher coroutineDispatcher;
    private CoroutineScope coroutineScope;
    private final MetricsUseCase metricsUseCase;

    @Inject
    public Gen204OfflineEventLogger(MetricsUseCase metricsUseCase, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(metricsUseCase, "metricsUseCase");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "coroutineDispatcher");
        this.metricsUseCase = metricsUseCase;
        this.coroutineDispatcher = coroutineDispatcher;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(coroutineDispatcher);
    }

    public static /* synthetic */ void fileSuccess$default(Gen204OfflineEventLogger gen204OfflineEventLogger, ItemId.Remote remote, String str, String str2, int i, int i2, String str3, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            i = 0;
        }
        if ((i3 & 16) != 0) {
            i2 = 0;
        }
        if ((i3 & 32) != 0) {
            str3 = null;
        }
        gen204OfflineEventLogger.fileSuccess(remote, str, str2, i, i2, str3);
    }

    public final void fileSuccess(ItemId.Remote remoteId, String downloadOriginalStatus, String downloadPreviewStatus, int numberOfAutomaticRetries, int numberOfManualRetries, String itemState) {
        Intrinsics.checkNotNullParameter(remoteId, "remoteId");
        logFile(remoteId, false, null, downloadOriginalStatus, downloadPreviewStatus, numberOfAutomaticRetries, numberOfManualRetries, itemState);
    }

    public static /* synthetic */ void fileFailure$default(Gen204OfflineEventLogger gen204OfflineEventLogger, ItemId.Remote remote, String str, String str2, String str3, int i, int i2, String str4, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            i = 0;
        }
        if ((i3 & 32) != 0) {
            i2 = 0;
        }
        if ((i3 & 64) != 0) {
            str4 = null;
        }
        gen204OfflineEventLogger.fileFailure(remote, str, str2, str3, i, i2, str4);
    }

    public final void fileFailure(ItemId.Remote remoteId, String failReason, String downloadOriginalStatus, String downloadPreviewStatus, int numberOfAutomaticRetries, int numberOfManualRetries, String itemState) {
        Intrinsics.checkNotNullParameter(remoteId, "remoteId");
        logFile(remoteId, true, failReason, downloadOriginalStatus, downloadPreviewStatus, numberOfAutomaticRetries, numberOfManualRetries, itemState);
    }

    public static /* synthetic */ void folderSuccess$default(Gen204OfflineEventLogger gen204OfflineEventLogger, ItemId.Remote remote, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i3 = 0;
        }
        if ((i5 & 16) != 0) {
            i4 = 0;
        }
        gen204OfflineEventLogger.folderSuccess(remote, i, i2, i3, i4);
    }

    public final void folderSuccess(ItemId.Remote remoteId, int totalFiles, int succeededFiles, int numberOfAutomaticRetries, int numberOfManualRetries) {
        Intrinsics.checkNotNullParameter(remoteId, "remoteId");
        logFolder(remoteId, totalFiles, succeededFiles, 0, numberOfAutomaticRetries, numberOfManualRetries, false, null);
    }

    public static /* synthetic */ void folderFailure$default(Gen204OfflineEventLogger gen204OfflineEventLogger, ItemId.Remote remote, int i, int i2, int i3, int i4, int i5, String str, int i6, Object obj) {
        if ((i6 & 16) != 0) {
            i4 = 0;
        }
        if ((i6 & 32) != 0) {
            i5 = 0;
        }
        gen204OfflineEventLogger.folderFailure(remote, i, i2, i3, i4, i5, str);
    }

    public final void folderFailure(ItemId.Remote remoteId, int totalFiles, int succeededFiles, int failedFiles, int numberOfAutomaticRetries, int numberOfManualRetries, String failReason) {
        Intrinsics.checkNotNullParameter(remoteId, "remoteId");
        logFolder(remoteId, totalFiles, succeededFiles, failedFiles, numberOfAutomaticRetries, numberOfManualRetries, true, failReason);
    }

    /* JADX INFO: renamed from: com.box.android.domain.metrics.Gen204OfflineEventLogger$logFile$1, reason: invalid class name */
    /* JADX INFO: compiled from: Gen204OfflineEventLogger.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.metrics.Gen204OfflineEventLogger$logFile$1", f = "Gen204OfflineEventLogger.kt", i = {}, l = {116}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $downloadOriginalStatus;
        final /* synthetic */ String $downloadPreviewStatus;
        final /* synthetic */ String $failReason;
        final /* synthetic */ boolean $failed;
        final /* synthetic */ String $itemState;
        final /* synthetic */ int $numberOfAutomaticRetries;
        final /* synthetic */ int $numberOfManualRetries;
        final /* synthetic */ ItemId.Remote $remoteId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ItemId.Remote remote, boolean z, String str, String str2, String str3, int i, int i2, String str4, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$remoteId = remote;
            this.$failed = z;
            this.$failReason = str;
            this.$downloadOriginalStatus = str2;
            this.$downloadPreviewStatus = str3;
            this.$numberOfAutomaticRetries = i;
            this.$numberOfManualRetries = i2;
            this.$itemState = str4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Gen204OfflineEventLogger.this.new AnonymousClass1(this.$remoteId, this.$failed, this.$failReason, this.$downloadOriginalStatus, this.$downloadPreviewStatus, this.$numberOfAutomaticRetries, this.$numberOfManualRetries, this.$itemState, continuation);
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
                if (Gen204OfflineEventLogger.this.metricsUseCase.log(new OfflineEvent(OfflineEvent.EventType.MarkForOfflineFile, this.$remoteId, this.$failed, JobManagerVersion.V2, this.$failReason, this.$downloadOriginalStatus, this.$downloadPreviewStatus, null, null, null, this.$numberOfAutomaticRetries, this.$numberOfManualRetries, this.$itemState, null, null, 25472, null), this) == coroutine_suspended) {
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

    public final void logFile(ItemId.Remote remoteId, boolean failed, String failReason, String downloadOriginalStatus, String downloadPreviewStatus, int numberOfAutomaticRetries, int numberOfManualRetries, String itemState) {
        Intrinsics.checkNotNullParameter(remoteId, "remoteId");
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new AnonymousClass1(remoteId, failed, failReason, downloadOriginalStatus, downloadPreviewStatus, numberOfAutomaticRetries, numberOfManualRetries, itemState, null), 3, null);
    }

    /* JADX INFO: renamed from: com.box.android.domain.metrics.Gen204OfflineEventLogger$logFolder$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Gen204OfflineEventLogger.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.metrics.Gen204OfflineEventLogger$logFolder$1", f = "Gen204OfflineEventLogger.kt", i = {}, l = {Token.COLONCOLON}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C15871 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $failReason;
        final /* synthetic */ boolean $failed;
        final /* synthetic */ int $failedFiles;
        final /* synthetic */ int $numberOfAutomaticRetries;
        final /* synthetic */ int $numberOfManualRetries;
        final /* synthetic */ ItemId.Remote $remoteId;
        final /* synthetic */ int $succeededFiles;
        final /* synthetic */ int $totalFiles;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15871(ItemId.Remote remote, boolean z, String str, int i, int i2, int i3, int i4, int i5, Continuation<? super C15871> continuation) {
            super(2, continuation);
            this.$remoteId = remote;
            this.$failed = z;
            this.$failReason = str;
            this.$totalFiles = i;
            this.$succeededFiles = i2;
            this.$failedFiles = i3;
            this.$numberOfAutomaticRetries = i4;
            this.$numberOfManualRetries = i5;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Gen204OfflineEventLogger.this.new C15871(this.$remoteId, this.$failed, this.$failReason, this.$totalFiles, this.$succeededFiles, this.$failedFiles, this.$numberOfAutomaticRetries, this.$numberOfManualRetries, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C15871) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (Gen204OfflineEventLogger.this.metricsUseCase.log(new OfflineEvent(OfflineEvent.EventType.MarkForOfflineFolder, this.$remoteId, this.$failed, JobManagerVersion.V2, this.$failReason, null, null, Boxing.boxInt(this.$totalFiles), Boxing.boxInt(this.$succeededFiles), Boxing.boxInt(this.$failedFiles), this.$numberOfAutomaticRetries, this.$numberOfManualRetries, null, null, null, 28768, null), this) == coroutine_suspended) {
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

    public final void logFolder(ItemId.Remote remoteId, int totalFiles, int succeededFiles, int failedFiles, int numberOfAutomaticRetries, int numberOfManualRetries, boolean failed, String failReason) {
        Intrinsics.checkNotNullParameter(remoteId, "remoteId");
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C15871(remoteId, failed, failReason, totalFiles, succeededFiles, failedFiles, numberOfAutomaticRetries, numberOfManualRetries, null), 3, null);
    }
}
