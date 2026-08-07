package com.box.android.base.compose.textfield;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.focus.FocusRequester;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: RequestFocusOnLaunch.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.base.compose.textfield.RequestFocusOnLaunchKt$RequestFocusOnLaunch$1$1", f = "RequestFocusOnLaunch.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class RequestFocusOnLaunchKt$RequestFocusOnLaunch$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delay;
    final /* synthetic */ FocusRequester $focusRequester;
    final /* synthetic */ MutableState<Boolean> $wasKeyboardOpened$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RequestFocusOnLaunchKt$RequestFocusOnLaunch$1$1(long j, FocusRequester focusRequester, MutableState<Boolean> mutableState, Continuation<? super RequestFocusOnLaunchKt$RequestFocusOnLaunch$1$1> continuation) {
        super(2, continuation);
        this.$delay = j;
        this.$focusRequester = focusRequester;
        this.$wasKeyboardOpened$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RequestFocusOnLaunchKt$RequestFocusOnLaunch$1$1(this.$delay, this.$focusRequester, this.$wasKeyboardOpened$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RequestFocusOnLaunchKt$RequestFocusOnLaunch$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!RequestFocusOnLaunchKt.RequestFocusOnLaunch$lambda$1(this.$wasKeyboardOpened$delegate)) {
                this.label = 1;
                if (DelayKt.delay(this.$delay, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        FocusRequester.m6474requestFocus3ESFkO8$default(this.$focusRequester, 0, 1, null);
        RequestFocusOnLaunchKt.RequestFocusOnLaunch$lambda$2(this.$wasKeyboardOpened$delegate, true);
        return Unit.INSTANCE;
    }
}
