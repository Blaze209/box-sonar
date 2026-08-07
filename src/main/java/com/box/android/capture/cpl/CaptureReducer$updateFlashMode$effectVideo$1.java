package com.box.android.capture.cpl;

import com.box.android.domain.models.capture.FlashMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: CaptureReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.capture.cpl.CaptureReducer$updateFlashMode$effectVideo$1", f = "CaptureReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class CaptureReducer$updateFlashMode$effectVideo$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<FlashMode> $newFlashMode;
    int label;
    final /* synthetic */ CaptureReducer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CaptureReducer$updateFlashMode$effectVideo$1(CaptureReducer captureReducer, Ref.ObjectRef<FlashMode> objectRef, Continuation<? super CaptureReducer$updateFlashMode$effectVideo$1> continuation) {
        super(1, continuation);
        this.this$0 = captureReducer;
        this.$newFlashMode = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new CaptureReducer$updateFlashMode$effectVideo$1(this.this$0, this.$newFlashMode, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((CaptureReducer$updateFlashMode$effectVideo$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.environment.getCapturePreferencesService().saveFlashModeVideo(this.$newFlashMode.element);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
