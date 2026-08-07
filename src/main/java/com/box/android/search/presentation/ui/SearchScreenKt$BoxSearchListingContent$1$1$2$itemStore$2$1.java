package com.box.android.search.presentation.ui;

import com.box.android.browse.cpl.itemsList.ItemReducer;
import com.box.android.search.presentation.cpl.SearchItemReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchScreen.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class SearchScreenKt$BoxSearchListingContent$1$1$2$itemStore$2$1 extends FunctionReferenceImpl implements Function1<ItemReducer.Action, SearchItemReducer.Action.FileAction> {
    public static final SearchScreenKt$BoxSearchListingContent$1$1$2$itemStore$2$1 INSTANCE = new SearchScreenKt$BoxSearchListingContent$1$1$2$itemStore$2$1();

    SearchScreenKt$BoxSearchListingContent$1$1$2$itemStore$2$1() {
        super(1, SearchItemReducer.Action.FileAction.class, "<init>", "<init>(Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final SearchItemReducer.Action.FileAction invoke(ItemReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new SearchItemReducer.Action.FileAction(p0);
    }
}
