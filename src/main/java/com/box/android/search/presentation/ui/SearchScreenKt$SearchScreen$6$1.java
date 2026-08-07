package com.box.android.search.presentation.ui;

import com.box.android.domain.models.ItemId;
import com.box.android.search.presentation.cpl.SearchReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchScreen.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class SearchScreenKt$SearchScreen$6$1 extends FunctionReferenceImpl implements Function1<ItemId.Remote, Boolean> {
    SearchScreenKt$SearchScreen$6$1(Object obj) {
        super(1, obj, SearchReducer.State.class, "isItemChecked", "isItemChecked(Lcom/box/android/domain/models/ItemId$Remote;)Z", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(ItemId.Remote p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return Boolean.valueOf(((SearchReducer.State) this.receiver).isItemChecked(p0));
    }
}
