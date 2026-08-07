package com.box.android.capture;

import com.box.android.domain.models.CaptureHistoryModel;
import com.box.android.domain.models.JobInfo;
import com.box.android.domain.models.item.PermissionsModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: CaptureHistoryFragment.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.capture.CaptureHistoryFragment$MultiSelectHandler$isItemSelectable$1", f = "CaptureHistoryFragment.kt", i = {}, l = {359}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class CaptureHistoryFragment$MultiSelectHandler$isItemSelectable$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ CaptureHistoryModel $item;
    int label;
    final /* synthetic */ CaptureHistoryFragment.MultiSelectHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CaptureHistoryFragment$MultiSelectHandler$isItemSelectable$1(CaptureHistoryModel captureHistoryModel, CaptureHistoryFragment.MultiSelectHandler multiSelectHandler, Continuation<? super CaptureHistoryFragment$MultiSelectHandler$isItemSelectable$1> continuation) {
        super(2, continuation);
        this.$item = captureHistoryModel;
        this.this$0 = multiSelectHandler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CaptureHistoryFragment$MultiSelectHandler$isItemSelectable$1(this.$item, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((CaptureHistoryFragment$MultiSelectHandler$isItemSelectable$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        JobInfo.Status status;
        Flow<JobInfo.Status> status2;
        PermissionsModel permissions;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            JobInfo jobInfo = this.$item.getJobInfo();
            if (jobInfo == null || (status2 = jobInfo.getStatus()) == null) {
                status = null;
            } else {
                this.label = 1;
                obj = FlowKt.first(status2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            if ((!(status instanceof JobInfo.Status.Running) || (permissions = this.$item.getFileModel().getPermissions()) == null || !permissions.getCanDelete()) && (this.$item.getJobInfo() == null || this.this$0.getPendingItems().contains(this.$item))) {
            }
            return Boxing.boxBoolean(z);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        status = (JobInfo.Status) obj;
        z = !(status instanceof JobInfo.Status.Running) ? false : false;
        return Boxing.boxBoolean(z);
    }
}
