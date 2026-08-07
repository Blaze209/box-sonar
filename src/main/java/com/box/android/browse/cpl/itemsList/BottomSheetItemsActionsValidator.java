package com.box.android.browse.cpl.itemsList;

import com.box.android.domain.models.item.ItemModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BottomSheetItemsActions.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\b\u001a\u00020\t¨\u0006\u000b"}, d2 = {"Lcom/box/android/browse/cpl/itemsList/BottomSheetItemsActionsValidator;", "", "<init>", "()V", "filterInvalid", "", "Lcom/box/android/browse/cpl/itemsList/BottomSheetItemAction;", "actions", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "Companion", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BottomSheetItemsActionsValidator {
    public static final int $stable = 0;
    private static final Map<BottomSheetItemAction, Function1<ItemModel, Boolean>> validators = MapsKt.mapOf(TuplesKt.to(BottomSheetItemAction.ViewContainingFolder, new Function1() { // from class: com.box.android.browse.cpl.itemsList.BottomSheetItemsActionsValidator$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return Boolean.valueOf(BottomSheetItemsActionsValidator.validators$lambda$0((ItemModel) obj));
        }
    }));

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean validators$lambda$0(ItemModel itemModel) {
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        return itemModel.getParentFolder() != null;
    }

    public final List<BottomSheetItemAction> filterInvalid(List<? extends BottomSheetItemAction> actions, ItemModel itemModel) {
        Intrinsics.checkNotNullParameter(actions, "actions");
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        ArrayList arrayList = new ArrayList();
        for (Object obj : actions) {
            Function1<ItemModel, Boolean> function1 = validators.get((BottomSheetItemAction) obj);
            if (function1 != null ? function1.invoke(itemModel).booleanValue() : true) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
