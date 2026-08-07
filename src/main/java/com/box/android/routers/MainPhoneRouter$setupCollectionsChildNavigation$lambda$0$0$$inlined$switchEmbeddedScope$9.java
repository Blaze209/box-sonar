package com.box.android.routers;

import com.box.android.base.presentation.utilities.IItemActionHandler;
import com.box.android.browse.cpl.CollectionReducer;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.box.android.cpl.Wrapped;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.WebLinkModel;
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
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0004\b\u0001\u0010\u0004\"\u0010\b\u0002\u0010\u0005\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0003\u0010\b\"\u0004\b\u0004\u0010\u00072\u0006\u0010\t\u001a\u0002H\u0005H\u008a@¨\u0006\n"}, d2 = {"<anonymous>", "", "GlobalState", "", "Action", "ConcreteState", "Lcom/box/android/cpl/Embedded;", "LocalState", "LocalAction", "it", "com/box/android/cpl/StoreKt$switchEmbeddedScope$3"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.routers.MainPhoneRouter$setupCollectionsChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$9", f = "MainPhoneRouter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class MainPhoneRouter$setupCollectionsChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$9 extends SuspendLambda implements Function2<CollectionReducer.Route.WebLink, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1 $fromLocalAction;
    final /* synthetic */ Store $store$inlined;
    final /* synthetic */ KClass $switchCase;
    final /* synthetic */ Store $this_switchEmbeddedScope;
    int label;
    final /* synthetic */ MainPhoneRouter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainPhoneRouter$setupCollectionsChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$9(Store store, KClass kClass, Function1 function1, Continuation continuation, MainPhoneRouter mainPhoneRouter, Store store2) {
        super(2, continuation);
        this.$this_switchEmbeddedScope = store;
        this.$switchCase = kClass;
        this.$fromLocalAction = function1;
        this.this$0 = mainPhoneRouter;
        this.$store$inlined = store2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainPhoneRouter$setupCollectionsChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$9(this.$this_switchEmbeddedScope, this.$switchCase, this.$fromLocalAction, continuation, this.this$0, this.$store$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CollectionReducer.Route.WebLink webLink, Continuation<? super Unit> continuation) {
        return ((MainPhoneRouter$setupCollectionsChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$9) create(webLink, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        IItemActionHandler.onItemClick$default(this.this$0.itemActionHandler, (ItemModel) this.$this_switchEmbeddedScope.scope(KClassesJvm.getJvmName(this.$switchCase), new Function1<CollectionReducer.Route, Wrapped<WebLinkModel>>() { // from class: com.box.android.routers.MainPhoneRouter$setupCollectionsChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$9.1
            @Override // kotlin.jvm.functions.Function1
            public final Wrapped<WebLinkModel> invoke(CollectionReducer.Route globalState) {
                WebLinkModel action;
                Intrinsics.checkNotNullParameter(globalState, "globalState");
                if (!(globalState instanceof CollectionReducer.Route.WebLink)) {
                    globalState = null;
                }
                CollectionReducer.Route.WebLink webLink = (CollectionReducer.Route.WebLink) globalState;
                if (webLink == null || (action = webLink.getAction()) == null) {
                    return null;
                }
                return StoreKt.wrap(action);
            }
        }, this.$fromLocalAction).getState().getValue(), false, null, 6, null);
        this.$store$inlined.send(CollectionReducer.Action.NavigationCompleted.INSTANCE);
        return Unit.INSTANCE;
    }
}
