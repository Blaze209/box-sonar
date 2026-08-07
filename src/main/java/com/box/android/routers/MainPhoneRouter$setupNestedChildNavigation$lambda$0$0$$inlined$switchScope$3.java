package com.box.android.routers;

import com.box.android.browse.cpl.NestedViewState;
import com.box.android.browse.cpl.browse.BrowseReducer;
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
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.KClassesJvm;

/* JADX INFO: compiled from: Store.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0004\b\u0001\u0010\u0004\"\n\b\u0002\u0010\u0005\u0018\u0001*\u0002H\u0002\"\u0004\b\u0003\u0010\u00062\u0006\u0010\u0007\u001a\u0002H\u0005H\u008a@¨\u0006\b"}, d2 = {"<anonymous>", "", "GlobalState", "", "Action", "ConcreteState", "LocalAction", "it", "com/box/android/cpl/StoreKt$switchScope$3"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.routers.MainPhoneRouter$setupNestedChildNavigation$lambda$0$0$$inlined$switchScope$3", f = "MainPhoneRouter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class MainPhoneRouter$setupNestedChildNavigation$lambda$0$0$$inlined$switchScope$3 extends SuspendLambda implements Function2<BrowseReducer.State, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1 $fromLocalAction;
    final /* synthetic */ KClass $switchCase;
    final /* synthetic */ Store $this_switchScope;
    int label;
    final /* synthetic */ MainPhoneRouter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainPhoneRouter$setupNestedChildNavigation$lambda$0$0$$inlined$switchScope$3(Store store, KClass kClass, Function1 function1, Continuation continuation, MainPhoneRouter mainPhoneRouter) {
        super(2, continuation);
        this.$this_switchScope = store;
        this.$switchCase = kClass;
        this.$fromLocalAction = function1;
        this.this$0 = mainPhoneRouter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainPhoneRouter$setupNestedChildNavigation$lambda$0$0$$inlined$switchScope$3(this.$this_switchScope, this.$switchCase, this.$fromLocalAction, continuation, this.this$0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(BrowseReducer.State state, Continuation<? super Unit> continuation) {
        return ((MainPhoneRouter$setupNestedChildNavigation$lambda$0$0$$inlined$switchScope$3) create(state, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.this$0.navigateToFolder(this.$this_switchScope.scope(KClassesJvm.getJvmName(this.$switchCase), new Function1<NestedViewState, Wrapped<BrowseReducer.State>>() { // from class: com.box.android.routers.MainPhoneRouter$setupNestedChildNavigation$lambda$0$0$$inlined$switchScope$3.1
            @Override // kotlin.jvm.functions.Function1
            public final Wrapped<BrowseReducer.State> invoke(NestedViewState globalState) {
                Intrinsics.checkNotNullParameter(globalState, "globalState");
                if (!(globalState instanceof BrowseReducer.State)) {
                    globalState = null;
                }
                BrowseReducer.State state = (BrowseReducer.State) globalState;
                if (state != null) {
                    return StoreKt.wrap(state);
                }
                return null;
            }
        }, this.$fromLocalAction));
        return Unit.INSTANCE;
    }
}
