package com.box.android.observability;

import android.content.Context;
import android.net.Uri;
import com.box.android.R;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.domain.analytics.BoxAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: DiagnosticsNotificationHandler.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.observability.DiagnosticsNotificationHandler$onReceive$1", f = "DiagnosticsNotificationHandler.kt", i = {0}, l = {57}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"}, v = 1)
final class DiagnosticsNotificationHandler$onReceive$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DiagnosticsNotificationHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DiagnosticsNotificationHandler$onReceive$1(DiagnosticsNotificationHandler diagnosticsNotificationHandler, Context context, Continuation<? super DiagnosticsNotificationHandler$onReceive$1> continuation) {
        super(2, continuation);
        this.this$0 = diagnosticsNotificationHandler;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DiagnosticsNotificationHandler$onReceive$1 diagnosticsNotificationHandler$onReceive$1 = new DiagnosticsNotificationHandler$onReceive$1(this.this$0, this.$context, continuation);
        diagnosticsNotificationHandler$onReceive$1.L$0 = obj;
        return diagnosticsNotificationHandler$onReceive$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DiagnosticsNotificationHandler$onReceive$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.L$0 = coroutineScope;
            this.label = 1;
            obj = this.this$0.getCreateLogArchiveInteractor().invoke(R.string.fileProviderAuthority, ObservabilitySettingsManager.INSTANCE.getLogTag(), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        Result result = (Result) obj;
        boolean z = result instanceof Result.Success;
        if (z) {
            BoxLogUtils.i(ExtensionsKt.getTAG(coroutineScope), "Created zip archive: " + ((Uri) ((Result.Success) result).getValue()).getPath());
        } else if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (!z) {
            if (!(result instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            BoxLogUtils.i(ExtensionsKt.getTAG(coroutineScope), "Failed to create zip archive");
        }
        UploadLogsWorker.INSTANCE.schedule();
        BoxPresentationUtils.displayToast(R.string.log_uploads_started, this.$context, new String[0]);
        BoxLogUtils.i(ExtensionsKt.getTAG(coroutineScope), "Enqueued Upload Work Request");
        BoxAnalytics.trackEvent$default(BoxAnalytics.INSTANCE, "observability", BoxAnalyticsParams.ACTION_SEND_LOGS_NOTIFICATION, "", null, 8, null);
        return Unit.INSTANCE;
    }
}
