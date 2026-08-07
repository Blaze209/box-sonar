package com.box.android.base.presentation.components.inputbar;

import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.platform.SoftwareKeyboardController;
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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: InputTextField.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.base.presentation.components.inputbar.InputTextFieldKt$KeyboardActionsHandler$1$1", f = "InputTextField.kt", i = {}, l = {277}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class InputTextFieldKt$KeyboardActionsHandler$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FocusManager $focusManager;
    final /* synthetic */ FocusRequester $focusRequester;
    final /* synthetic */ KeyboardAction $keyboardAction;
    final /* synthetic */ SoftwareKeyboardController $keyboardController;
    final /* synthetic */ Function0<Unit> $onKeyboardFocusHandled;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InputTextFieldKt$KeyboardActionsHandler$1$1(KeyboardAction keyboardAction, FocusRequester focusRequester, SoftwareKeyboardController softwareKeyboardController, FocusManager focusManager, Function0<Unit> function0, Continuation<? super InputTextFieldKt$KeyboardActionsHandler$1$1> continuation) {
        super(2, continuation);
        this.$keyboardAction = keyboardAction;
        this.$focusRequester = focusRequester;
        this.$keyboardController = softwareKeyboardController;
        this.$focusManager = focusManager;
        this.$onKeyboardFocusHandled = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InputTextFieldKt$KeyboardActionsHandler$1$1(this.$keyboardAction, this.$focusRequester, this.$keyboardController, this.$focusManager, this.$onKeyboardFocusHandled, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InputTextFieldKt$KeyboardActionsHandler$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$keyboardAction == KeyboardAction.SHOW) {
                FocusRequester.m6474requestFocus3ESFkO8$default(this.$focusRequester, 0, 1, null);
                this.label = 1;
                if (DelayKt.delay(250L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (this.$keyboardAction == KeyboardAction.HIDE) {
                FocusManager.clearFocus$default(this.$focusManager, false, 1, null);
            }
            this.$onKeyboardFocusHandled.invoke();
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        SoftwareKeyboardController softwareKeyboardController = this.$keyboardController;
        if (softwareKeyboardController != null) {
            softwareKeyboardController.show();
        }
        this.$onKeyboardFocusHandled.invoke();
        return Unit.INSTANCE;
    }
}
