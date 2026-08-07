package com.box.android.preview.annotations.ui.compose;

import androidx.compose.runtime.State;
import com.box.android.preview.annotations.cpl.CreateAnnotationReducer;
import com.box.android.preview.annotations.managers.AnnotationsToolbarManager;
import com.box.android.preview.annotations.managers.BoxAnnotationMarkupType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ComposeAnnotationToolbar.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.preview.annotations.ui.compose.ComposeAnnotationToolbarKt$ComposeAnnotationToolbar$3$1", f = "ComposeAnnotationToolbar.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class ComposeAnnotationToolbarKt$ComposeAnnotationToolbar$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<CreateAnnotationReducer.State> $state$delegate;
    final /* synthetic */ Boolean $switchMarkupTypeConfirmed;
    final /* synthetic */ AnnotationsToolbarManager $toolbarManager;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComposeAnnotationToolbarKt$ComposeAnnotationToolbar$3$1(Boolean bool, AnnotationsToolbarManager annotationsToolbarManager, State<CreateAnnotationReducer.State> state, Continuation<? super ComposeAnnotationToolbarKt$ComposeAnnotationToolbar$3$1> continuation) {
        super(2, continuation);
        this.$switchMarkupTypeConfirmed = bool;
        this.$toolbarManager = annotationsToolbarManager;
        this.$state$delegate = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ComposeAnnotationToolbarKt$ComposeAnnotationToolbar$3$1(this.$switchMarkupTypeConfirmed, this.$toolbarManager, this.$state$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ComposeAnnotationToolbarKt$ComposeAnnotationToolbar$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (Intrinsics.areEqual(this.$switchMarkupTypeConfirmed, Boxing.boxBoolean(true))) {
            AnnotationsToolbarManager annotationsToolbarManager = this.$toolbarManager;
            CreateAnnotationReducer.SwitchingMarkupTypeState switchingMarkupType = ComposeAnnotationToolbarKt.ComposeAnnotationToolbar$lambda$1(this.$state$delegate).getSwitchingMarkupType();
            BoxAnnotationMarkupType markupType = switchingMarkupType != null ? switchingMarkupType.getMarkupType() : null;
            Intrinsics.checkNotNull(markupType);
            annotationsToolbarManager.enterAnnotationMarkupMode(markupType);
        } else if (this.$switchMarkupTypeConfirmed == null) {
            this.$toolbarManager.cancelExitOrSwitch();
        }
        return Unit.INSTANCE;
    }
}
