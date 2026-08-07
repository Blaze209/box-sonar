package com.box.android.preview.iteminformation;

import com.box.android.base.cpl.ItemThumbnailReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemInformationReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ItemInformationReducer$build$6 extends FunctionReferenceImpl implements Function1<ItemThumbnailReducer.Action, ItemInformationReducer.Action.ItemThumbnail> {
    public static final ItemInformationReducer$build$6 INSTANCE = new ItemInformationReducer$build$6();

    ItemInformationReducer$build$6() {
        super(1, ItemInformationReducer.Action.ItemThumbnail.class, "<init>", "<init>(Lcom/box/android/base/cpl/ItemThumbnailReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ItemInformationReducer.Action.ItemThumbnail invoke(ItemThumbnailReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new ItemInformationReducer.Action.ItemThumbnail(p0);
    }
}
