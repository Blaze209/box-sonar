package com.box.android.search.presentation.cpl;

import com.box.android.browse.cpl.itemsList.ItemReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchItemReducer.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class SearchItemReducer$build$8 extends FunctionReferenceImpl implements Function1<ItemReducer.Action, SearchItemReducer.Action.FileAction> {
    public static final SearchItemReducer$build$8 INSTANCE = new SearchItemReducer$build$8();

    SearchItemReducer$build$8() {
        super(1, SearchItemReducer.Action.FileAction.class, "<init>", "<init>(Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final SearchItemReducer.Action.FileAction invoke(ItemReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new SearchItemReducer.Action.FileAction(p0);
    }
}
