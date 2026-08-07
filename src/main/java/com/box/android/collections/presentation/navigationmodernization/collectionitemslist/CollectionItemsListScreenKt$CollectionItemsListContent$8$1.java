package com.box.android.collections.presentation.navigationmodernization.collectionitemslist;

import androidx.compose.runtime.State;
import com.box.android.base.presentation.fragments.models.BottomSheetAttributes;
import com.box.android.cpl.Store;
import com.box.android.domain.models.item.ItemModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CollectionItemsListScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListScreenKt$CollectionItemsListContent$8$1", f = "CollectionItemsListScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class CollectionItemsListScreenKt$CollectionItemsListContent$8$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ItemModel, Unit> $onOpenItem;
    final /* synthetic */ Function2<ItemModel, BottomSheetAttributes.BottomSheetMenuType, Unit> $onOpenItemMoreActionsMenu;
    final /* synthetic */ State<CollectionItemsListReducer.State> $state$delegate;
    final /* synthetic */ Store<CollectionItemsListReducer.State, CollectionItemsListReducer.Action> $store;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CollectionItemsListScreenKt$CollectionItemsListContent$8$1(Function1<? super ItemModel, Unit> function1, Store<CollectionItemsListReducer.State, CollectionItemsListReducer.Action> store, Function2<? super ItemModel, ? super BottomSheetAttributes.BottomSheetMenuType, Unit> function2, State<CollectionItemsListReducer.State> state, Continuation<? super CollectionItemsListScreenKt$CollectionItemsListContent$8$1> continuation) {
        super(2, continuation);
        this.$onOpenItem = function1;
        this.$store = store;
        this.$onOpenItemMoreActionsMenu = function2;
        this.$state$delegate = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CollectionItemsListScreenKt$CollectionItemsListContent$8$1(this.$onOpenItem, this.$store, this.$onOpenItemMoreActionsMenu, this.$state$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CollectionItemsListScreenKt$CollectionItemsListContent$8$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CollectionItemsListReducer.Route navigationRoute = CollectionItemsListScreenKt.CollectionItemsListContent$lambda$0(this.$state$delegate).getNavigationRoute();
            if (navigationRoute instanceof CollectionItemsListReducer.Route.OpenItem) {
                this.$onOpenItem.invoke(((CollectionItemsListReducer.Route.OpenItem) navigationRoute).getItem());
                this.$store.send(new CollectionItemsListReducer.Action.Navigate(CollectionItemsListReducer.Route.None.INSTANCE));
            } else if (navigationRoute instanceof CollectionItemsListReducer.Route.OpenItemMoreActionsMenu) {
                CollectionItemsListReducer.Route.OpenItemMoreActionsMenu openItemMoreActionsMenu = (CollectionItemsListReducer.Route.OpenItemMoreActionsMenu) navigationRoute;
                this.$onOpenItemMoreActionsMenu.invoke(openItemMoreActionsMenu.getItem(), new BottomSheetAttributes.BottomSheetMenuType.RemoveCollectionItems(openItemMoreActionsMenu.getCollectionName(), openItemMoreActionsMenu.getCollectionId()));
                this.$store.send(new CollectionItemsListReducer.Action.Navigate(CollectionItemsListReducer.Route.None.INSTANCE));
            } else if (!Intrinsics.areEqual(navigationRoute, CollectionItemsListReducer.Route.None.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
