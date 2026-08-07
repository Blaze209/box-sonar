package com.box.android.data.service.impl;

import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.search.FileSearchItem;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class SearchService$searchFiles$2$1 extends FunctionReferenceImpl implements Function2<ItemModel, String, FileSearchItem> {
    public static final SearchService$searchFiles$2$1 INSTANCE = new SearchService$searchFiles$2$1();

    SearchService$searchFiles$2$1() {
        super(2, FileSearchItem.class, "<init>", "<init>(Lcom/box/android/domain/models/item/ItemModel;Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final FileSearchItem invoke(ItemModel p0, String str) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new FileSearchItem(p0, str);
    }
}
