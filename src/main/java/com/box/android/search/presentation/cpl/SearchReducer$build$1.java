package com.box.android.search.presentation.cpl;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchReducer.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class SearchReducer$build$1 extends FunctionReferenceImpl implements Function2<SearchReducer.State, SearchReducer.Action, ReducerResult<SearchReducer.State, SearchReducer.Action>> {
    SearchReducer$build$1(Object obj) {
        super(2, obj, SearchAnalyticsHelperKt.class, "reduceSearchAnalytics", "reduceSearchAnalytics(Lcom/box/android/search/presentation/cpl/SearchReducer;Lcom/box/android/search/presentation/cpl/SearchReducer$State;Lcom/box/android/search/presentation/cpl/SearchReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 1);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<SearchReducer.State, SearchReducer.Action> invoke(SearchReducer.State p0, SearchReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return SearchAnalyticsHelperKt.reduceSearchAnalytics((SearchReducer) this.receiver, p0, p1);
    }
}
