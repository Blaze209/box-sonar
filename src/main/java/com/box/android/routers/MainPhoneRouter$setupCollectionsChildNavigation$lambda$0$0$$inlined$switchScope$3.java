package com.box.android.routers;

import androidx.navigation.NavController;
import com.box.android.browse.cpl.CollectionReducer;
import com.box.android.common.utilities.BoxCommonConstants;
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
@DebugMetadata(c = "com.box.android.routers.MainPhoneRouter$setupCollectionsChildNavigation$lambda$0$0$$inlined$switchScope$3", f = "MainPhoneRouter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class MainPhoneRouter$setupCollectionsChildNavigation$lambda$0$0$$inlined$switchScope$3 extends SuspendLambda implements Function2<CollectionReducer.Route.None, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1 $fromLocalAction;
    final /* synthetic */ Store $store$inlined;
    final /* synthetic */ KClass $switchCase;
    final /* synthetic */ Store $this_switchScope;
    int label;
    final /* synthetic */ MainPhoneRouter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainPhoneRouter$setupCollectionsChildNavigation$lambda$0$0$$inlined$switchScope$3(Store store, KClass kClass, Function1 function1, Continuation continuation, MainPhoneRouter mainPhoneRouter, Store store2) {
        super(2, continuation);
        this.$this_switchScope = store;
        this.$switchCase = kClass;
        this.$fromLocalAction = function1;
        this.this$0 = mainPhoneRouter;
        this.$store$inlined = store2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainPhoneRouter$setupCollectionsChildNavigation$lambda$0$0$$inlined$switchScope$3(this.$this_switchScope, this.$switchCase, this.$fromLocalAction, continuation, this.this$0, this.$store$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CollectionReducer.Route.None none, Continuation<? super Unit> continuation) {
        return ((MainPhoneRouter$setupCollectionsChildNavigation$lambda$0$0$$inlined$switchScope$3) create(none, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$this_switchScope.scope(KClassesJvm.getJvmName(this.$switchCase), new Function1<CollectionReducer.Route, Wrapped<CollectionReducer.Route.None>>() { // from class: com.box.android.routers.MainPhoneRouter$setupCollectionsChildNavigation$lambda$0$0$$inlined$switchScope$3.1
            @Override // kotlin.jvm.functions.Function1
            public final Wrapped<CollectionReducer.Route.None> invoke(CollectionReducer.Route globalState) {
                Intrinsics.checkNotNullParameter(globalState, "globalState");
                if (!(globalState instanceof CollectionReducer.Route.None)) {
                    globalState = null;
                }
                CollectionReducer.Route.None none = (CollectionReducer.Route.None) globalState;
                if (none != null) {
                    return StoreKt.wrap(none);
                }
                return null;
            }
        }, this.$fromLocalAction);
        NavController navController = this.this$0.navController;
        if (navController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController = null;
        }
        MainPhoneRouterKt.popBackStackToArgument(navController, BoxCommonConstants.STORE_KEY, this.$store$inlined.getKey());
        return Unit.INSTANCE;
    }
}
