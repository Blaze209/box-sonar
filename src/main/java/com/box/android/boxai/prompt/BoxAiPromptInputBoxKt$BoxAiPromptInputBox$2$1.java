package com.box.android.boxai.prompt;

import com.box.android.boxai.voice.VoiceInputReducer;
import com.box.android.cpl.Store;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: BoxAiPromptInputBox.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.boxai.prompt.BoxAiPromptInputBoxKt$BoxAiPromptInputBox$2$1", f = "BoxAiPromptInputBox.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class BoxAiPromptInputBoxKt$BoxAiPromptInputBox$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $onVoiceInputError;
    final /* synthetic */ boolean $shouldShowVoiceInputError;
    final /* synthetic */ Store<BoxAiPromptReducer.State, BoxAiPromptReducer.Action> $store;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    BoxAiPromptInputBoxKt$BoxAiPromptInputBox$2$1(boolean z, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Store<BoxAiPromptReducer.State, BoxAiPromptReducer.Action> store, Continuation<? super BoxAiPromptInputBoxKt$BoxAiPromptInputBox$2$1> continuation) {
        super(2, continuation);
        this.$shouldShowVoiceInputError = z;
        this.$onVoiceInputError = function1;
        this.$store = store;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BoxAiPromptInputBoxKt$BoxAiPromptInputBox$2$1(this.$shouldShowVoiceInputError, this.$onVoiceInputError, this.$store, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BoxAiPromptInputBoxKt$BoxAiPromptInputBox$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$shouldShowVoiceInputError) {
                Function1<Continuation<? super Unit>, Object> function1 = this.$onVoiceInputError;
                this.label = 1;
                if (function1.invoke(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Store<BoxAiPromptReducer.State, BoxAiPromptReducer.Action> store = this.$store;
        if (store != null) {
            store.send(new BoxAiPromptReducer.Action.VoiceInputAction(VoiceInputReducer.Action.RecognitionErrorShown.INSTANCE));
        }
        return Unit.INSTANCE;
    }
}
