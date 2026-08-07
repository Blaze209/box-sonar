package com.box.android.base.presentation.components.tabscreen;

import androidx.compose.material3.SnackbarData;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.MutableIntState;
import java.util.List;
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

/* JADX INFO: compiled from: CommonTabsScreen.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$CommonTabsScreen$4$7$1", f = "CommonTabsScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class CommonTabsScreenKt$CommonTabsScreen$4$7$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableIntState $currentTabIndex$delegate;
    final /* synthetic */ Function1<T, Unit> $onCurrentTabChanged;
    final /* synthetic */ SnackbarHostState $snackbarHostState;
    final /* synthetic */ List<T> $tabs;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CommonTabsScreenKt$CommonTabsScreen$4$7$1(Function1<? super T, Unit> function1, List<? extends T> list, SnackbarHostState snackbarHostState, MutableIntState mutableIntState, Continuation<? super CommonTabsScreenKt$CommonTabsScreen$4$7$1> continuation) {
        super(2, continuation);
        this.$onCurrentTabChanged = function1;
        this.$tabs = list;
        this.$snackbarHostState = snackbarHostState;
        this.$currentTabIndex$delegate = mutableIntState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CommonTabsScreenKt$CommonTabsScreen$4$7$1(this.$onCurrentTabChanged, this.$tabs, this.$snackbarHostState, this.$currentTabIndex$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CommonTabsScreenKt$CommonTabsScreen$4$7$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SnackbarData currentSnackbarData;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$onCurrentTabChanged.invoke((T) this.$tabs.get(CommonTabsScreenKt.CommonTabsScreen_DuhZ5jU$lambda$2(this.$currentTabIndex$delegate)));
            SnackbarHostState snackbarHostState = this.$snackbarHostState;
            if (snackbarHostState != null && (currentSnackbarData = snackbarHostState.getCurrentSnackbarData()) != null) {
                currentSnackbarData.dismiss();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
