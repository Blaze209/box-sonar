package com.box.android.preview.preview.previewbar.topbar;

import android.view.View;
import androidx.compose.animation.core.Transition;
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

/* JADX INFO: compiled from: TopBarTitle.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.preview.preview.previewbar.topbar.TopBarTitleKt$PreviewTopBarTitle$1$1$1", f = "TopBarTitle.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class TopBarTitleKt$PreviewTopBarTitle$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $focusOnRename;
    final /* synthetic */ FocusRequester $focusRequester;
    final /* synthetic */ Transition<Boolean> $renameTransition;
    final /* synthetic */ View $view;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TopBarTitleKt$PreviewTopBarTitle$1$1$1(Transition<Boolean> transition, boolean z, View view, FocusRequester focusRequester, Continuation<? super TopBarTitleKt$PreviewTopBarTitle$1$1$1> continuation) {
        super(2, continuation);
        this.$renameTransition = transition;
        this.$focusOnRename = z;
        this.$view = view;
        this.$focusRequester = focusRequester;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TopBarTitleKt$PreviewTopBarTitle$1$1$1(this.$renameTransition, this.$focusOnRename, this.$view, this.$focusRequester, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TopBarTitleKt$PreviewTopBarTitle$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (this.$renameTransition.getCurrentState().booleanValue() && this.$focusOnRename && !this.$view.isInEditMode()) {
            FocusRequester.m6474requestFocus3ESFkO8$default(this.$focusRequester, 0, 1, null);
        }
        return Unit.INSTANCE;
    }
}
