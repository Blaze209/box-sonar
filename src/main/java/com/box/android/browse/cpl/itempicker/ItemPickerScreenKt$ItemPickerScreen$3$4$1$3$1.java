package com.box.android.browse.cpl.itempicker;

import androidx.compose.runtime.State;
import com.box.android.cpl.Store;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ItemPickerScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.browse.cpl.itempicker.ItemPickerScreenKt$ItemPickerScreen$3$4$1$3$1", f = "ItemPickerScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class ItemPickerScreenKt$ItemPickerScreen$3$4$1$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<FolderModel, Unit> $onInviteCollaborators;
    final /* synthetic */ State<ItemPickerReducer.State> $state$delegate;
    final /* synthetic */ Store<ItemPickerReducer.State, ItemPickerReducer.Action> $store;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ItemPickerScreenKt$ItemPickerScreen$3$4$1$3$1(State<ItemPickerReducer.State> state, Function1<? super FolderModel, Unit> function1, Store<ItemPickerReducer.State, ItemPickerReducer.Action> store, Continuation<? super ItemPickerScreenKt$ItemPickerScreen$3$4$1$3$1> continuation) {
        super(2, continuation);
        this.$state$delegate = state;
        this.$onInviteCollaborators = function1;
        this.$store = store;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ItemPickerScreenKt$ItemPickerScreen$3$4$1$3$1(this.$state$delegate, this.$onInviteCollaborators, this.$store, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ItemPickerScreenKt$ItemPickerScreen$3$4$1$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ItemPickerReducer.Route navigationRoute = ItemPickerScreenKt.ItemPickerScreen$lambda$2(this.$state$delegate).getNavigationRoute();
            ItemPickerReducer.Route.InviteCollaborators inviteCollaborators = navigationRoute instanceof ItemPickerReducer.Route.InviteCollaborators ? (ItemPickerReducer.Route.InviteCollaborators) navigationRoute : null;
            if (inviteCollaborators != null) {
                Function1<FolderModel, Unit> function1 = this.$onInviteCollaborators;
                Store<ItemPickerReducer.State, ItemPickerReducer.Action> store = this.$store;
                function1.invoke(inviteCollaborators.getFolder());
                store.send(ItemPickerReducer.Action.NavigatedToRoute.INSTANCE);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
