package com.box.android.routers;

import com.box.android.browse.cpl.itemsList.ActionableItemsListRouter;
import com.box.android.browse.cpl.offlined.OfflinedReducer;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.box.android.cpl.Wrapped;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.KClassesJvm;

/* JADX INFO: compiled from: Store.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0004\b\u0001\u0010\u0004\"\n\b\u0002\u0010\u0005\u0018\u0001*\u0002H\u0002\"\u0004\b\u0003\u0010\u00062\u0006\u0010\u0007\u001a\u0002H\u0005H\u008a@¨\u0006\b"}, d2 = {"<anonymous>", "", "GlobalState", "", "Action", "ConcreteState", "LocalAction", "it", "com/box/android/cpl/StoreKt$switchScope$3"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.routers.NavigationRouter$initOfflinedNavigation$2$5$invokeSuspend$$inlined$switchScope$3", f = "NavigationRouter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class NavigationRouter$initOfflinedNavigation$2$5$invokeSuspend$$inlined$switchScope$3 extends SuspendLambda implements Function2<OfflinedReducer.Route.ItemAction, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1 $fromLocalAction;
    final /* synthetic */ Store $store$inlined;
    final /* synthetic */ KClass $switchCase;
    final /* synthetic */ Store $this_switchScope;
    int label;
    final /* synthetic */ NavigationRouter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavigationRouter$initOfflinedNavigation$2$5$invokeSuspend$$inlined$switchScope$3(Store store, KClass kClass, Function1 function1, Continuation continuation, NavigationRouter navigationRouter, Store store2) {
        super(2, continuation);
        this.$this_switchScope = store;
        this.$switchCase = kClass;
        this.$fromLocalAction = function1;
        this.this$0 = navigationRouter;
        this.$store$inlined = store2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NavigationRouter$initOfflinedNavigation$2$5$invokeSuspend$$inlined$switchScope$3(this.$this_switchScope, this.$switchCase, this.$fromLocalAction, continuation, this.this$0, this.$store$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(OfflinedReducer.Route.ItemAction itemAction, Continuation<? super Unit> continuation) {
        return ((NavigationRouter$initOfflinedNavigation$2$5$invokeSuspend$$inlined$switchScope$3) create(itemAction, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Store storeScope = this.$this_switchScope.scope(KClassesJvm.getJvmName(this.$switchCase), new Function1<OfflinedReducer.Route, Wrapped<OfflinedReducer.Route.ItemAction>>() { // from class: com.box.android.routers.NavigationRouter$initOfflinedNavigation$2$5$invokeSuspend$$inlined$switchScope$3.1
            @Override // kotlin.jvm.functions.Function1
            public final Wrapped<OfflinedReducer.Route.ItemAction> invoke(OfflinedReducer.Route globalState) {
                Intrinsics.checkNotNullParameter(globalState, "globalState");
                if (!(globalState instanceof OfflinedReducer.Route.ItemAction)) {
                    globalState = null;
                }
                OfflinedReducer.Route.ItemAction itemAction = (OfflinedReducer.Route.ItemAction) globalState;
                if (itemAction != null) {
                    return StoreKt.wrap(itemAction);
                }
                return null;
            }
        }, this.$fromLocalAction);
        ActionableItemsListRouter actionableItemsListRouter = this.this$0.offlinedRouter;
        if (actionableItemsListRouter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("offlinedRouter");
            actionableItemsListRouter = null;
        }
        actionableItemsListRouter.navigate(((OfflinedReducer.Route.ItemAction) StoreKt.stateValue(storeScope)).getRoute(), this.$store$inlined.scope(new PropertyReference1Impl() { // from class: com.box.android.routers.NavigationRouter$initOfflinedNavigation$2$5$2$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj2) {
                return ((OfflinedReducer.State) obj2).getActionableItemsListState();
            }
        }, NavigationRouter$initOfflinedNavigation$2$5$2$2.INSTANCE));
        return Unit.INSTANCE;
    }
}
