package com.box.android.domain.metrics;

import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.observability.FolderLoadEvent;
import com.box.android.domain.usecases.observability.MetricsUseCase;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import javax.inject.Inject;
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

/* JADX INFO: compiled from: Gen204FolderItemsEventLogger.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u001e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fJA\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/box/android/domain/metrics/Gen204FolderItemsEventLogger;", "", "metricsUseCase", "Lcom/box/android/domain/usecases/observability/MetricsUseCase;", "coroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/box/android/domain/usecases/observability/MetricsUseCase;Lkotlinx/coroutines/CoroutineDispatcher;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "success", "", "remoteId", "Lcom/box/android/domain/models/ItemId$Remote;", "numberOfItems", "", "failure", "errorMessage", "", "errorCode", "log", TelemetryEventStrings.Value.FAILED, "", "(Lcom/box/android/domain/models/ItemId$Remote;ZLjava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Gen204FolderItemsEventLogger {
    private final CoroutineDispatcher coroutineDispatcher;
    private CoroutineScope coroutineScope;
    private final MetricsUseCase metricsUseCase;

    @Inject
    public Gen204FolderItemsEventLogger(MetricsUseCase metricsUseCase, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(metricsUseCase, "metricsUseCase");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "coroutineDispatcher");
        this.metricsUseCase = metricsUseCase;
        this.coroutineDispatcher = coroutineDispatcher;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(coroutineDispatcher);
    }

    public final void success(ItemId.Remote remoteId, int numberOfItems) {
        Intrinsics.checkNotNullParameter(remoteId, "remoteId");
        log$default(this, remoteId, false, Integer.valueOf(numberOfItems), null, null, 24, null);
    }

    public final void failure(ItemId.Remote remoteId, String errorMessage, int errorCode) {
        Intrinsics.checkNotNullParameter(remoteId, "remoteId");
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        log$default(this, remoteId, true, null, errorMessage, Integer.valueOf(errorCode), 4, null);
    }

    static /* synthetic */ void log$default(Gen204FolderItemsEventLogger gen204FolderItemsEventLogger, ItemId.Remote remote, boolean z, Integer num, String str, Integer num2, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            str = null;
        }
        if ((i & 16) != 0) {
            num2 = null;
        }
        gen204FolderItemsEventLogger.log(remote, z, num, str, num2);
    }

    /* JADX INFO: renamed from: com.box.android.domain.metrics.Gen204FolderItemsEventLogger$log$1, reason: invalid class name */
    /* JADX INFO: compiled from: Gen204FolderItemsEventLogger.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.metrics.Gen204FolderItemsEventLogger$log$1", f = "Gen204FolderItemsEventLogger.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Integer $errorCode;
        final /* synthetic */ String $errorMessage;
        final /* synthetic */ boolean $failed;
        final /* synthetic */ Integer $numberOfItems;
        final /* synthetic */ ItemId.Remote $remoteId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ItemId.Remote remote, Integer num, boolean z, String str, Integer num2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$remoteId = remote;
            this.$numberOfItems = num;
            this.$failed = z;
            this.$errorMessage = str;
            this.$errorCode = num2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return Gen204FolderItemsEventLogger.this.new AnonymousClass1(this.$remoteId, this.$numberOfItems, this.$failed, this.$errorMessage, this.$errorCode, continuation);
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
                if (Gen204FolderItemsEventLogger.this.metricsUseCase.log(new FolderLoadEvent(this.$remoteId, this.$numberOfItems, this.$failed, this.$errorMessage, this.$errorCode, null, null, 96, null), this) == coroutine_suspended) {
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

    private final void log(ItemId.Remote remoteId, boolean failed, Integer numberOfItems, String errorMessage, Integer errorCode) {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new AnonymousClass1(remoteId, numberOfItems, failed, errorMessage, errorCode, null), 3, null);
    }
}
