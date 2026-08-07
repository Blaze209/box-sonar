package com.box.android.capture.cpl;

import com.box.android.domain.models.ItemId;
import com.box.android.domain.usecases.capture.CaptureLocalItemsUseCase;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CaptureReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.capture.cpl.CaptureReducer$reduceCamera$1$1", f = "CaptureReducer.kt", i = {}, l = {403}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class CaptureReducer$reduceCamera$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ ImageCaptureReducer.Action $action;
    final /* synthetic */ ItemId $folderId;
    int label;
    final /* synthetic */ CaptureReducer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CaptureReducer$reduceCamera$1$1(CaptureReducer captureReducer, ImageCaptureReducer.Action action, ItemId itemId, Continuation<? super CaptureReducer$reduceCamera$1$1> continuation) {
        super(1, continuation);
        this.this$0 = captureReducer;
        this.$action = action;
        this.$folderId = itemId;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new CaptureReducer$reduceCamera$1$1(this.this$0, this.$action, this.$folderId, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((CaptureReducer$reduceCamera$1$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CaptureLocalItemsUseCase captureLocalItemsUseCase = this.this$0.environment.getCaptureLocalItemsUseCase();
            String name = ((ImageCaptureReducer.Action.UploadPhoto) this.$action).getFile().getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            this.label = 1;
            if (captureLocalItemsUseCase.createFile(name, this.$folderId, ((ImageCaptureReducer.Action.UploadPhoto) this.$action).getFile(), this) == coroutine_suspended) {
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
