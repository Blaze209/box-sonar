package com.box.android.browse.cpl.browse;

import androidx.compose.runtime.State;
import com.box.android.browse.cpl.itempicker.ItemPickerReducer;
import com.box.android.browse.cpl.itemsList.ItemsListReducer;
import com.box.android.cpl.Store;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FolderModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: FolderItemPickerScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.browse.cpl.browse.FolderItemPickerScreenKt$FolderItemPickerScreen$5$1", f = "FolderItemPickerScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class FolderItemPickerScreenKt$FolderItemPickerScreen$5$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<String, Boolean, Unit> $onFolderChanged;
    final /* synthetic */ Function2<List<FolderModel>, Function1<? super ItemId.Remote, Unit>, Unit> $onFolderStackChanged;
    final /* synthetic */ State<ItemPickerReducer.State> $state$delegate;
    final /* synthetic */ Store<ItemPickerReducer.State, ItemPickerReducer.Action> $store;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    FolderItemPickerScreenKt$FolderItemPickerScreen$5$1(Function2<? super String, ? super Boolean, Unit> function2, Function2<? super List<FolderModel>, ? super Function1<? super ItemId.Remote, Unit>, Unit> function3, State<ItemPickerReducer.State> state, Store<ItemPickerReducer.State, ItemPickerReducer.Action> store, Continuation<? super FolderItemPickerScreenKt$FolderItemPickerScreen$5$1> continuation) {
        super(2, continuation);
        this.$onFolderChanged = function2;
        this.$onFolderStackChanged = function3;
        this.$state$delegate = state;
        this.$store = store;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FolderItemPickerScreenKt$FolderItemPickerScreen$5$1(this.$onFolderChanged, this.$onFolderStackChanged, this.$state$delegate, this.$store, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FolderItemPickerScreenKt$FolderItemPickerScreen$5$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List<ItemsListReducer.State> stack = FolderItemPickerScreenKt.FolderItemPickerScreen$lambda$0(this.$state$delegate).getStack();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(stack, 10));
            Iterator<T> it = stack.iterator();
            while (it.hasNext()) {
                arrayList.add(((ItemsListReducer.State) it.next()).getCurrentFolder());
            }
            ArrayList arrayList2 = arrayList;
            this.$onFolderChanged.invoke(((FolderModel) CollectionsKt.last((List) arrayList2)).getName(), Boxing.boxBoolean(arrayList2.size() == 1));
            Function2<List<FolderModel>, Function1<? super ItemId.Remote, Unit>, Unit> function2 = this.$onFolderStackChanged;
            final Store<ItemPickerReducer.State, ItemPickerReducer.Action> store = this.$store;
            function2.invoke(arrayList2, new Function1() { // from class: com.box.android.browse.cpl.browse.FolderItemPickerScreenKt$FolderItemPickerScreen$5$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return FolderItemPickerScreenKt$FolderItemPickerScreen$5$1.invokeSuspend$lambda$1(store, (ItemId.Remote) obj2);
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1(Store store, ItemId.Remote remote) {
        store.send(new ItemPickerReducer.Action.GoBackTo(remote));
        return Unit.INSTANCE;
    }
}
