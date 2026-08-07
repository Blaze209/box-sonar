package com.box.android.base.presentation.components.tabscreen;

import androidx.compose.runtime.MutableIntState;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: CommonTabsScreen.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$CommonTabsScreen$3$1", f = "CommonTabsScreen.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class CommonTabsScreenKt$CommonTabsScreen$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableIntState $currentTabIndex$delegate;
    final /* synthetic */ List<T> $tabs;
    final /* synthetic */ TabsSelector<T> $tabsSelector;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CommonTabsScreenKt$CommonTabsScreen$3$1(TabsSelector<T> tabsSelector, List<? extends T> list, MutableIntState mutableIntState, Continuation<? super CommonTabsScreenKt$CommonTabsScreen$3$1> continuation) {
        super(2, continuation);
        this.$tabsSelector = tabsSelector;
        this.$tabs = list;
        this.$currentTabIndex$delegate = mutableIntState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CommonTabsScreenKt$CommonTabsScreen$3$1(this.$tabsSelector, this.$tabs, this.$currentTabIndex$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CommonTabsScreenKt$CommonTabsScreen$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Channel channel$base_generalProdRelease;
        Flow flowReceiveAsFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TabsSelector<T> tabsSelector = this.$tabsSelector;
            if (tabsSelector != 0 && (channel$base_generalProdRelease = tabsSelector.getChannel$base_generalProdRelease()) != null && (flowReceiveAsFlow = FlowKt.receiveAsFlow(channel$base_generalProdRelease)) != null) {
                final List<T> list = this.$tabs;
                final MutableIntState mutableIntState = this.$currentTabIndex$delegate;
                this.label = 1;
                if (flowReceiveAsFlow.collect(new FlowCollector() { // from class: com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt$CommonTabsScreen$3$1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(T t, Continuation<? super Unit> continuation) {
                        int iIndexOf = list.indexOf(t);
                        if (iIndexOf >= 0) {
                            mutableIntState.setIntValue(iIndexOf);
                        }
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
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
