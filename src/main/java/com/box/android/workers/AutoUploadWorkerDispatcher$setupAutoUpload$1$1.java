package com.box.android.workers;

import com.box.android.domain.services.ILocalItemService;
import com.box.android.localrepo.LocalAutoContentUploadInformation;
import com.box.androidsdk.content.utils.BoxLogUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AutoUploadWorkerDispatcher.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.workers.AutoUploadWorkerDispatcher$setupAutoUpload$1$1", f = "AutoUploadWorkerDispatcher.kt", i = {0, 0, 0}, l = {23}, m = "invokeSuspend", n = {"$this$launch", "$this$invokeSuspend_u24lambda_u240", "$i$a$-runCatching-AutoUploadWorkerDispatcher$setupAutoUpload$1$1$1"}, s = {"L$0", "L$2", "I$0"}, v = 1)
final class AutoUploadWorkerDispatcher$setupAutoUpload$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ILocalItemService $localItemService;
    final /* synthetic */ LocalAutoContentUploadInformation $uploadInfo;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AutoUploadWorkerDispatcher$setupAutoUpload$1$1(ILocalItemService iLocalItemService, LocalAutoContentUploadInformation localAutoContentUploadInformation, Continuation<? super AutoUploadWorkerDispatcher$setupAutoUpload$1$1> continuation) {
        super(2, continuation);
        this.$localItemService = iLocalItemService;
        this.$uploadInfo = localAutoContentUploadInformation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AutoUploadWorkerDispatcher$setupAutoUpload$1$1 autoUploadWorkerDispatcher$setupAutoUpload$1$1 = new AutoUploadWorkerDispatcher$setupAutoUpload$1$1(this.$localItemService, this.$uploadInfo, continuation);
        autoUploadWorkerDispatcher$setupAutoUpload$1$1.L$0 = obj;
        return autoUploadWorkerDispatcher$setupAutoUpload$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AutoUploadWorkerDispatcher$setupAutoUpload$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objM14780constructorimpl;
        LocalAutoContentUploadInformation localAutoContentUploadInformation;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ILocalItemService iLocalItemService = this.$localItemService;
                LocalAutoContentUploadInformation localAutoContentUploadInformation2 = this.$uploadInfo;
                Result.Companion companion = Result.INSTANCE;
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = localAutoContentUploadInformation2;
                this.L$2 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.I$0 = 0;
                this.label = 1;
                if (iLocalItemService.initiateAutoUpload(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                localAutoContentUploadInformation = localAutoContentUploadInformation2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                localAutoContentUploadInformation = (LocalAutoContentUploadInformation) this.L$1;
                ResultKt.throwOnFailure(obj);
            }
            localAutoContentUploadInformation.setLastAutoUploadSyncTime();
            objM14780constructorimpl = Result.m14780constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14780constructorimpl = Result.m14780constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM14783exceptionOrNullimpl = Result.m14783exceptionOrNullimpl(objM14780constructorimpl);
        if (thM14783exceptionOrNullimpl != null) {
            BoxLogUtils.e("AutoUploadWorkerDispatcher", "Auto upload failed", thM14783exceptionOrNullimpl);
        }
        return Unit.INSTANCE;
    }
}
