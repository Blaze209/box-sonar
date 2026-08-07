package com.box.android.routers;

import com.box.android.browse.cpl.browse.BrowseReducer;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.box.android.cpl.Wrapped;
import com.box.android.domain.mappers.FolderModelMapper;
import com.box.android.domain.models.item.FolderModel;
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
@DebugMetadata(c = "com.box.android.routers.NavigationRouter$initBrowseNavigation$lambda$0$$inlined$switchEmbeddedScope$15", f = "NavigationRouter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class NavigationRouter$initBrowseNavigation$lambda$0$$inlined$switchEmbeddedScope$15 extends SuspendLambda implements Function2<BrowseReducer.Route.InviteCollaborators, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1 $fromLocalAction;
    final /* synthetic */ Store $store$inlined;
    final /* synthetic */ KClass $switchCase;
    final /* synthetic */ Store $this_switchEmbeddedScope;
    int label;
    final /* synthetic */ NavigationRouter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavigationRouter$initBrowseNavigation$lambda$0$$inlined$switchEmbeddedScope$15(Store store, KClass kClass, Function1 function1, Continuation continuation, NavigationRouter navigationRouter, Store store2) {
        super(2, continuation);
        this.$this_switchEmbeddedScope = store;
        this.$switchCase = kClass;
        this.$fromLocalAction = function1;
        this.this$0 = navigationRouter;
        this.$store$inlined = store2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NavigationRouter$initBrowseNavigation$lambda$0$$inlined$switchEmbeddedScope$15(this.$this_switchEmbeddedScope, this.$switchCase, this.$fromLocalAction, continuation, this.this$0, this.$store$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(BrowseReducer.Route.InviteCollaborators inviteCollaborators, Continuation<? super Unit> continuation) {
        return ((NavigationRouter$initBrowseNavigation$lambda$0$$inlined$switchEmbeddedScope$15) create(inviteCollaborators, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.this$0.launcher.launch(this.this$0.intentServices.inviteCollaboratorsActivityIntent(this.this$0.activity, FolderModelMapper.toBoxFolder$default(FolderModelMapper.INSTANCE, (FolderModel) StoreKt.stateValue(this.$this_switchEmbeddedScope.scope(KClassesJvm.getJvmName(this.$switchCase), new Function1<BrowseReducer.Route, Wrapped<FolderModel>>() { // from class: com.box.android.routers.NavigationRouter$initBrowseNavigation$lambda$0$$inlined$switchEmbeddedScope$15.1
            @Override // kotlin.jvm.functions.Function1
            public final Wrapped<FolderModel> invoke(BrowseReducer.Route globalState) {
                FolderModel action;
                Intrinsics.checkNotNullParameter(globalState, "globalState");
                if (!(globalState instanceof BrowseReducer.Route.InviteCollaborators)) {
                    globalState = null;
                }
                BrowseReducer.Route.InviteCollaborators inviteCollaborators = (BrowseReducer.Route.InviteCollaborators) globalState;
                if (inviteCollaborators == null || (action = inviteCollaborators.getAction()) == null) {
                    return null;
                }
                return StoreKt.wrap(action);
            }
        }, this.$fromLocalAction)), false, 1, null), this.this$0.mUserContextManager.getBoxSession(this.this$0.activity)));
        this.$store$inlined.send(BrowseReducer.Action.NavigationCompleted.INSTANCE);
        return Unit.INSTANCE;
    }
}
