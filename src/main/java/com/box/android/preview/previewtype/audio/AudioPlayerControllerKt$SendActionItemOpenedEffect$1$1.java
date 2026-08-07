package com.box.android.preview.previewtype.audio;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AudioPlayerController.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.preview.previewtype.audio.AudioPlayerControllerKt$SendActionItemOpenedEffect$1$1", f = "AudioPlayerController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class AudioPlayerControllerKt$SendActionItemOpenedEffect$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $onItemChanged;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AudioPlayerControllerKt$SendActionItemOpenedEffect$1$1(Function0<Unit> function0, Continuation<? super AudioPlayerControllerKt$SendActionItemOpenedEffect$1$1> continuation) {
        super(2, continuation);
        this.$onItemChanged = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AudioPlayerControllerKt$SendActionItemOpenedEffect$1$1(this.$onItemChanged, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AudioPlayerControllerKt$SendActionItemOpenedEffect$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$onItemChanged.invoke();
        return Unit.INSTANCE;
    }
}
