package com.box.android.capture;

import com.box.android.base.presentation.presenters.BaseListingPresenter;
import com.box.android.domain.models.CaptureHistoryModel;
import com.box.android.domain.models.JobInfo;
import com.box.android.domain.models.item.FileModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: CaptureHistoryFragment.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.capture.CaptureHistoryFragment$createAdapter$2$onSecondaryAction$1", f = "CaptureHistoryFragment.kt", i = {0, 0}, l = {241}, m = "invokeSuspend", n = {"jobInfo", "fileModel"}, s = {"L$0", "L$1"}, v = 1)
final class CaptureHistoryFragment$createAdapter$2$onSecondaryAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CaptureHistoryModel $item;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ CaptureHistoryFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CaptureHistoryFragment$createAdapter$2$onSecondaryAction$1(CaptureHistoryModel captureHistoryModel, CaptureHistoryFragment captureHistoryFragment, Continuation<? super CaptureHistoryFragment$createAdapter$2$onSecondaryAction$1> continuation) {
        super(2, continuation);
        this.$item = captureHistoryModel;
        this.this$0 = captureHistoryFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CaptureHistoryFragment$createAdapter$2$onSecondaryAction$1(this.$item, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CaptureHistoryFragment$createAdapter$2$onSecondaryAction$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        JobInfo jobInfo;
        FileModel fileModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            jobInfo = this.$item.getJobInfo();
            Intrinsics.checkNotNull(jobInfo);
            FileModel fileModel2 = this.$item.getFileModel();
            this.L$0 = jobInfo;
            this.L$1 = fileModel2;
            this.label = 1;
            Object objFirst = FlowKt.first(jobInfo.getStatus(), this);
            if (objFirst == coroutine_suspended) {
                return coroutine_suspended;
            }
            fileModel = fileModel2;
            obj = objFirst;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            fileModel = (FileModel) this.L$1;
            jobInfo = (JobInfo) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (((JobInfo.Status) obj) instanceof JobInfo.Status.Failed) {
            BaseListingPresenter presenter = this.this$0.getPresenter();
            Intrinsics.checkNotNull(presenter, "null cannot be cast to non-null type com.box.android.capture.CaptureHistoryPresenter");
            ((CaptureHistoryPresenter) presenter).retryJob(jobInfo.getId(), fileModel.getItemId());
        }
        return Unit.INSTANCE;
    }
}
