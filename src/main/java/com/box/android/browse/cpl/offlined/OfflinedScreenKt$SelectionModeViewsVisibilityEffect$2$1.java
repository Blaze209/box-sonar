package com.box.android.browse.cpl.offlined;

import com.box.android.base.presentation.state.HomeScreenViewsVisibilityState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: OfflinedScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.browse.cpl.offlined.OfflinedScreenKt$SelectionModeViewsVisibilityEffect$2$1", f = "OfflinedScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class OfflinedScreenKt$SelectionModeViewsVisibilityEffect$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ HomeScreenViewsVisibilityState $homeScreenViewsVisibilityState;
    final /* synthetic */ boolean $isSelecting;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OfflinedScreenKt$SelectionModeViewsVisibilityEffect$2$1(boolean z, HomeScreenViewsVisibilityState homeScreenViewsVisibilityState, Continuation<? super OfflinedScreenKt$SelectionModeViewsVisibilityEffect$2$1> continuation) {
        super(2, continuation);
        this.$isSelecting = z;
        this.$homeScreenViewsVisibilityState = homeScreenViewsVisibilityState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OfflinedScreenKt$SelectionModeViewsVisibilityEffect$2$1(this.$isSelecting, this.$homeScreenViewsVisibilityState, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OfflinedScreenKt$SelectionModeViewsVisibilityEffect$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (this.$isSelecting) {
            this.$homeScreenViewsVisibilityState.hidePrimaryTabRow();
            this.$homeScreenViewsVisibilityState.hideNavigationBar();
        } else {
            this.$homeScreenViewsVisibilityState.showPrimaryTabRow();
            this.$homeScreenViewsVisibilityState.showNavigationBar();
        }
        return Unit.INSTANCE;
    }
}
