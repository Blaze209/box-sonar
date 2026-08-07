package com.box.android.search.presentation.cpl;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchReducer.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class SearchReducer$build$7 extends FunctionReferenceImpl implements Function1<HubsSearchReducer.Action, SearchReducer.Action.HubsSearch> {
    public static final SearchReducer$build$7 INSTANCE = new SearchReducer$build$7();

    SearchReducer$build$7() {
        super(1, SearchReducer.Action.HubsSearch.class, "<init>", "<init>(Lcom/box/android/search/presentation/cpl/HubsSearchReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final SearchReducer.Action.HubsSearch invoke(HubsSearchReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new SearchReducer.Action.HubsSearch(p0);
    }
}
