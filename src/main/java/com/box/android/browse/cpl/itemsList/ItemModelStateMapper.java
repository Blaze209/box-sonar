package com.box.android.browse.cpl.itemsList;

import com.box.android.base.presentation.ThumbnailManager;
import com.box.android.coreservices.models.BoxModelOfflineManager;
import com.box.android.coreservices.models.BoxModelOfflineManagerWrapper;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemModelKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemModelStateMapper.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/ItemModelStateMapper;", "", "modelOfflineManagerWrapper", "Lcom/box/android/coreservices/models/BoxModelOfflineManagerWrapper;", "thumbnailManager", "Lcom/box/android/base/presentation/ThumbnailManager;", "<init>", "(Lcom/box/android/coreservices/models/BoxModelOfflineManagerWrapper;Lcom/box/android/base/presentation/ThumbnailManager;)V", "toItemModelState", "Lcom/box/android/browse/cpl/itemsList/ItemReducer$State;", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "state", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$State;", "(Lcom/box/android/domain/models/item/ItemModel;Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ItemModelStateMapper {
    public static final int $stable = 8;
    private final BoxModelOfflineManagerWrapper modelOfflineManagerWrapper;
    private final ThumbnailManager thumbnailManager;

    /* JADX INFO: renamed from: com.box.android.browse.cpl.itemsList.ItemModelStateMapper$toItemModelState$1, reason: invalid class name */
    /* JADX INFO: compiled from: ItemModelStateMapper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.itemsList.ItemModelStateMapper", f = "ItemModelStateMapper.kt", i = {0, 0, 0, 0}, l = {41}, m = "toItemModelState", n = {"itemModel", "state", "oldItem", "shouldDisableItem"}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ItemModelStateMapper.this.toItemModelState(null, null, this);
        }
    }

    @Inject
    public ItemModelStateMapper(BoxModelOfflineManagerWrapper modelOfflineManagerWrapper, ThumbnailManager thumbnailManager) {
        Intrinsics.checkNotNullParameter(modelOfflineManagerWrapper, "modelOfflineManagerWrapper");
        Intrinsics.checkNotNullParameter(thumbnailManager, "thumbnailManager");
        this.modelOfflineManagerWrapper = modelOfflineManagerWrapper;
        this.thumbnailManager = thumbnailManager;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object toItemModelState(ItemModel itemModel, ItemsListReducer.State state, Continuation<? super ItemReducer.State> continuation) {
        AnonymousClass1 anonymousClass1;
        ItemModel itemModel2;
        int i;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            ItemReducer.State state2 = (ItemReducer.State) state.getItems().getById(ItemModelKt.toItemIdRemoteId(itemModel));
            int i3 = ((!state.getShouldDisableNonFolderItems() || (itemModel instanceof FolderModel)) && !CollectionsKt.contains(state.getDisabledItems(), itemModel.getItemId())) ? 0 : 1;
            if (state2 != null && this.thumbnailManager.canReuseThumbnailFromOldItem(state2.getItemModel(), itemModel)) {
                return new ItemReducer.State(itemModel, i3 ^ 1, state2.getThumbnailState(), state2.getOfflineState(), state2.getUniqueCancelEffectKey());
            }
            if (state2 != null) {
                return new ItemReducer.State(itemModel, i3 ^ 1, null, state2.getOfflineState(), state2.getUniqueCancelEffectKey(), 4, null);
            }
            itemModel2 = itemModel;
            int i4 = i3 ^ 1;
            BoxModelOfflineManagerWrapper boxModelOfflineManagerWrapper = this.modelOfflineManagerWrapper;
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(itemModel2);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(state);
            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(state2);
            anonymousClass1.L$3 = itemModel2;
            anonymousClass1.I$0 = i3;
            anonymousClass1.I$1 = i4;
            anonymousClass1.label = 1;
            Object state3 = boxModelOfflineManagerWrapper.getState(itemModel2, anonymousClass1);
            if (state3 == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = state3;
            i = i4;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = anonymousClass1.I$1;
            int i5 = anonymousClass1.I$0;
            itemModel2 = (ItemModel) anonymousClass1.L$3;
            ResultKt.throwOnFailure(obj);
        }
        return new ItemReducer.State(itemModel2, i != 0, null, (BoxModelOfflineManager.State) obj, null, 20, null);
    }
}
