package com.box.android.contentpicker.contentsourcepicker;

import com.box.android.browse.cpl.itemsList.ItemReducer;
import com.box.android.browse.cpl.itemsList.ItemsListReducer;
import com.box.android.domain.models.ItemId;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContentSourcePickerScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ContentSourcePickerScreenKt$RecentsCarousel$2$1$1$2$1 extends FunctionReferenceImpl implements Function2<ItemId.Remote, ItemReducer.Action, ItemsListReducer.Action.ItemAction> {
    public static final ContentSourcePickerScreenKt$RecentsCarousel$2$1$1$2$1 INSTANCE = new ContentSourcePickerScreenKt$RecentsCarousel$2$1$1$2$1();

    ContentSourcePickerScreenKt$RecentsCarousel$2$1$1$2$1() {
        super(2, ItemsListReducer.Action.ItemAction.class, "<init>", "<init>(Lcom/box/android/domain/models/ItemId$Remote;Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ItemsListReducer.Action.ItemAction invoke(ItemId.Remote p0, ItemReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return new ItemsListReducer.Action.ItemAction(p0, p1);
    }
}
