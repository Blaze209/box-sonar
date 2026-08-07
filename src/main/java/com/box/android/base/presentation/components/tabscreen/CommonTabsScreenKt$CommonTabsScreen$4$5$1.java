package com.box.android.base.presentation.components.tabscreen;

import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.MutableIntState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CommonTabsScreen.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$CommonTabsScreen$4$5$1", f = "CommonTabsScreen.kt", i = {}, l = {192}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class CommonTabsScreenKt$CommonTabsScreen$4$5$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableIntState $currentTabIndex$delegate;
    final /* synthetic */ PagerState $pagerState;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CommonTabsScreenKt$CommonTabsScreen$4$5$1(PagerState pagerState, MutableIntState mutableIntState, Continuation<? super CommonTabsScreenKt$CommonTabsScreen$4$5$1> continuation) {
        super(2, continuation);
        this.$pagerState = pagerState;
        this.$currentTabIndex$delegate = mutableIntState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CommonTabsScreenKt$CommonTabsScreen$4$5$1(this.$pagerState, this.$currentTabIndex$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CommonTabsScreenKt$CommonTabsScreen$4$5$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$2(this.$currentTabIndex$delegate) != this.$pagerState.getTargetPage()) {
                this.label = 1;
                if (PagerState.animateScrollToPage$default(this.$pagerState, CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$2(this.$currentTabIndex$delegate), 0.0f, null, this, 6, null) == coroutine_suspended) {
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
