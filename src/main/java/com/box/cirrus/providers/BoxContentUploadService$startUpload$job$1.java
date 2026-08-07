package com.box.cirrus.providers;

import androidx.exifinterface.media.ExifInterface;
import com.box.android.coreservices.R;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.services.IUploadFileService;
import com.box.android.domain.utils.result.Result;
import com.box.android.domain.utils.result.ResultProgressWrapper;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.margelo.nitro.boxcontext.ItemIdentifier;
import com.margelo.nitro.boxcontext.ItemInfo;
import com.margelo.nitro.boxcontext.PendingItemError;
import com.margelo.nitro.boxcontext.PendingItemUpdate;
import com.margelo.nitro.boxcontext.PendingItemUpdateType;
import java.io.File;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: BoxContentUploadService.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.cirrus.providers.BoxContentUploadService$startUpload$job$1", f = "BoxContentUploadService.kt", i = {0, 1, 1, 1}, l = {81, 94}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "progressWrapper", "progressJob"}, s = {"L$0", "L$0", "L$1", "L$2"}, v = 1)
final class BoxContentUploadService$startUpload$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $file;
    final /* synthetic */ ItemIdentifier $itemId;
    final /* synthetic */ String $itemName;
    final /* synthetic */ Function1<PendingItemUpdate, Unit> $onUpdate;
    final /* synthetic */ ItemId.Remote $parentFolderId;
    final /* synthetic */ String $uploadFolderId;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ BoxContentUploadService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    BoxContentUploadService$startUpload$job$1(String str, BoxContentUploadService boxContentUploadService, File file, String str2, ItemId.Remote remote, Function1<? super PendingItemUpdate, Unit> function1, ItemIdentifier itemIdentifier, Continuation<? super BoxContentUploadService$startUpload$job$1> continuation) {
        super(2, continuation);
        this.$uploadFolderId = str;
        this.this$0 = boxContentUploadService;
        this.$file = file;
        this.$itemName = str2;
        this.$parentFolderId = remote;
        this.$onUpdate = function1;
        this.$itemId = itemIdentifier;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BoxContentUploadService$startUpload$job$1 boxContentUploadService$startUpload$job$1 = new BoxContentUploadService$startUpload$job$1(this.$uploadFolderId, this.this$0, this.$file, this.$itemName, this.$parentFolderId, this.$onUpdate, this.$itemId, continuation);
        boxContentUploadService$startUpload$job$1.L$0 = obj;
        return boxContentUploadService$startUpload$job$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BoxContentUploadService$startUpload$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:27:0x0120  */
    /* JADX WARN: Code duplicated, block: B:29:0x0124  */
    /* JADX WARN: Code duplicated, block: B:32:0x0139  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objUploadFile$default;
        Object objMapResultToUploadResult;
        Job jobLaunch$default;
        Object objFirstOrNull;
        BoxContentUploadService boxContentUploadService;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                objUploadFile$default = obj;
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                boxContentUploadService = (BoxContentUploadService) this.L$3;
                Job job = (Job) this.L$2;
                ResultKt.throwOnFailure(obj);
                jobLaunch$default = job;
                objFirstOrNull = obj;
            }
            objMapResultToUploadResult = boxContentUploadService.mapResultToUploadResult((Result) objFirstOrNull);
            Job.DefaultImpls.cancel$default(jobLaunch$default, (CancellationException) null, 1, (Object) null);
            if (objMapResultToUploadResult instanceof BoxContentUploadService.UploadResultWrapper.Success) {
                FileModel fileModel = ((BoxContentUploadService.UploadResultWrapper.Success) objMapResultToUploadResult).getFileModel();
                this.$onUpdate.invoke(new PendingItemUpdate(PendingItemUpdateType.COMPLETED, null, new ItemInfo(this.$itemId, fileModel.getName(), fileModel.boxIdOrNull(), null, null, null), null));
            } else {
                if (!(objMapResultToUploadResult instanceof BoxContentUploadService.UploadResultWrapper.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                this.$onUpdate.invoke(new PendingItemUpdate(PendingItemUpdateType.FAILED, null, null, ((BoxContentUploadService.UploadResultWrapper.Error) objMapResultToUploadResult).getPendingItemError()));
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        if (this.$uploadFolderId.length() == 0) {
            BoxLogUtils.e("The folderId provided was empty");
            objMapResultToUploadResult = (BoxContentUploadService.UploadResultWrapper) new BoxContentUploadService.UploadResultWrapper.Error(new PendingItemError("1", this.this$0.resourcesProvider.getString(R.string.This_item_does_not_exist), true, false));
        } else {
            if (this.$file.length() > 0) {
                this.L$0 = coroutineScope;
                this.label = 1;
                objUploadFile$default = IUploadFileService.uploadFile$default(this.this$0.uploadFileService, this.$file, this.$itemName, this.$parentFolderId, null, this, 8, null);
                if (objUploadFile$default != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            BoxLogUtils.e("File was empty unexpectedly");
            objMapResultToUploadResult = (BoxContentUploadService.UploadResultWrapper) new BoxContentUploadService.UploadResultWrapper.Error(new PendingItemError(ExifInterface.GPS_MEASUREMENT_3D, this.this$0.resourcesProvider.getString(R.string.job_item_error_corrupted), false, false));
        }
        if (objMapResultToUploadResult instanceof BoxContentUploadService.UploadResultWrapper.Success) {
            FileModel fileModel2 = ((BoxContentUploadService.UploadResultWrapper.Success) objMapResultToUploadResult).getFileModel();
            this.$onUpdate.invoke(new PendingItemUpdate(PendingItemUpdateType.COMPLETED, null, new ItemInfo(this.$itemId, fileModel2.getName(), fileModel2.boxIdOrNull(), null, null, null), null));
        } else {
            if (!(objMapResultToUploadResult instanceof BoxContentUploadService.UploadResultWrapper.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            this.$onUpdate.invoke(new PendingItemUpdate(PendingItemUpdateType.FAILED, null, null, ((BoxContentUploadService.UploadResultWrapper.Error) objMapResultToUploadResult).getPendingItemError()));
        }
        return Unit.INSTANCE;
        ResultProgressWrapper resultProgressWrapper = (ResultProgressWrapper) objUploadFile$default;
        jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new BoxContentUploadService$startUpload$job$1$result$progressJob$1(resultProgressWrapper, this.$onUpdate, null), 3, null);
        BoxContentUploadService boxContentUploadService2 = this.this$0;
        this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
        this.L$1 = SpillingKt.nullOutSpilledVariable(resultProgressWrapper);
        this.L$2 = jobLaunch$default;
        this.L$3 = boxContentUploadService2;
        this.label = 2;
        objFirstOrNull = FlowKt.firstOrNull(resultProgressWrapper.getResult(), this);
        if (objFirstOrNull != coroutine_suspended) {
            boxContentUploadService = boxContentUploadService2;
            objMapResultToUploadResult = boxContentUploadService.mapResultToUploadResult((Result) objFirstOrNull);
            Job.DefaultImpls.cancel$default(jobLaunch$default, (CancellationException) null, 1, (Object) null);
            if (objMapResultToUploadResult instanceof BoxContentUploadService.UploadResultWrapper.Success) {
                FileModel fileModel3 = ((BoxContentUploadService.UploadResultWrapper.Success) objMapResultToUploadResult).getFileModel();
                this.$onUpdate.invoke(new PendingItemUpdate(PendingItemUpdateType.COMPLETED, null, new ItemInfo(this.$itemId, fileModel3.getName(), fileModel3.boxIdOrNull(), null, null, null), null));
            } else {
                if (!(objMapResultToUploadResult instanceof BoxContentUploadService.UploadResultWrapper.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                this.$onUpdate.invoke(new PendingItemUpdate(PendingItemUpdateType.FAILED, null, null, ((BoxContentUploadService.UploadResultWrapper.Error) objMapResultToUploadResult).getPendingItemError()));
            }
            return Unit.INSTANCE;
        }
        return coroutine_suspended;
    }
}
