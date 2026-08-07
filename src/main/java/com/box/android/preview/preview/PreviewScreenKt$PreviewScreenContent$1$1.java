package com.box.android.preview.preview;

import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.State;
import com.box.android.common.utilities.BoxCommonConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PreviewScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.preview.preview.PreviewScreenKt$PreviewScreenContent$1$1", f = "PreviewScreen.kt", i = {}, l = {BoxCommonConstants.REQUEST_RENAME}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class PreviewScreenKt$PreviewScreenContent$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PagerState $pagerState;
    final /* synthetic */ State<PreviewReducer.State> $state$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PreviewScreenKt$PreviewScreenContent$1$1(PagerState pagerState, State<PreviewReducer.State> state, Continuation<? super PreviewScreenKt$PreviewScreenContent$1$1> continuation) {
        super(2, continuation);
        this.$pagerState = pagerState;
        this.$state$delegate = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PreviewScreenKt$PreviewScreenContent$1$1(this.$pagerState, this.$state$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PreviewScreenKt$PreviewScreenContent$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (PreviewScreenKt.PreviewScreenContent$lambda$0(this.$state$delegate).getIndexOfSelectedItemId() != this.$pagerState.getSettledPage()) {
                this.label = 1;
                if (PagerState.scrollToPage$default(this.$pagerState, PreviewScreenKt.PreviewScreenContent$lambda$0(this.$state$delegate).getIndexOfSelectedItemId(), 0.0f, this, 2, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
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
