package com.box.android.search.presentation.ui;

import com.box.android.search.presentation.cpl.SearchItemReducer;
import com.box.android.search.presentation.cpl.SearchReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchScreen.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class SearchScreenKt$SearchScreen$scopedStoreProvider$1$1$2 extends FunctionReferenceImpl implements Function2<String, SearchItemReducer.Action, SearchReducer.Action.SearchAction> {
    public static final SearchScreenKt$SearchScreen$scopedStoreProvider$1$1$2 INSTANCE = new SearchScreenKt$SearchScreen$scopedStoreProvider$1$1$2();

    SearchScreenKt$SearchScreen$scopedStoreProvider$1$1$2() {
        super(2, SearchReducer.Action.SearchAction.class, "<init>", "<init>(Ljava/lang/String;Lcom/box/android/search/presentation/cpl/SearchItemReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final SearchReducer.Action.SearchAction invoke(String p0, SearchItemReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return new SearchReducer.Action.SearchAction(p0, p1);
    }
}
