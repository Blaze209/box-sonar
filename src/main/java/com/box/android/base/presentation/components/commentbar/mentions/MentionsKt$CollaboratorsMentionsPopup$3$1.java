package com.box.android.base.presentation.components.commentbar.mentions;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: Mentions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.base.presentation.components.commentbar.mentions.MentionsKt$CollaboratorsMentionsPopup$3$1", f = "Mentions.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class MentionsKt$CollaboratorsMentionsPopup$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $isExpanded$delegate;
    final /* synthetic */ SoftwareKeyboardController $keyboardController;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MentionsKt$CollaboratorsMentionsPopup$3$1(SoftwareKeyboardController softwareKeyboardController, MutableState<Boolean> mutableState, Continuation<? super MentionsKt$CollaboratorsMentionsPopup$3$1> continuation) {
        super(2, continuation);
        this.$keyboardController = softwareKeyboardController;
        this.$isExpanded$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MentionsKt$CollaboratorsMentionsPopup$3$1(this.$keyboardController, this.$isExpanded$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MentionsKt$CollaboratorsMentionsPopup$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SoftwareKeyboardController softwareKeyboardController;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (MentionsKt.CollaboratorsMentionsPopup_Cxxc4bg$lambda$4(this.$isExpanded$delegate) && (softwareKeyboardController = this.$keyboardController) != null) {
                softwareKeyboardController.hide();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
