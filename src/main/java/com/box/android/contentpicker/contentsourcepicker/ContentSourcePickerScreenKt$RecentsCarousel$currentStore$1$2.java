package com.box.android.contentpicker.contentsourcepicker;

import com.box.android.browse.cpl.itempicker.ItemPickerReducer;
import com.box.android.browse.cpl.itemsList.ItemsListReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContentSourcePickerScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ContentSourcePickerScreenKt$RecentsCarousel$currentStore$1$2 extends FunctionReferenceImpl implements Function2<Integer, ItemsListReducer.Action, ItemPickerReducer.Action.ItemsList> {
    public static final ContentSourcePickerScreenKt$RecentsCarousel$currentStore$1$2 INSTANCE = new ContentSourcePickerScreenKt$RecentsCarousel$currentStore$1$2();

    ContentSourcePickerScreenKt$RecentsCarousel$currentStore$1$2() {
        super(2, ItemPickerReducer.Action.ItemsList.class, "<init>", "<init>(ILcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;)V", 0);
    }

    public final ItemPickerReducer.Action.ItemsList invoke(int i, ItemsListReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p1, "p1");
        return new ItemPickerReducer.Action.ItemsList(i, p1);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ ItemPickerReducer.Action.ItemsList invoke(Integer num, ItemsListReducer.Action action) {
        return invoke(num.intValue(), action);
    }
}
