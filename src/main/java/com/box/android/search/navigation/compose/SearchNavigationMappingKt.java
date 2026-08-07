package com.box.android.search.navigation.compose;

import com.box.android.search.navigation.SearchDestination;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchNavigationMapping.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0005\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0007\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\b\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\t\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"SEARCH_GRAPH_ROUTE", "", "SEARCH_ROUTE", "FILTERS_ROUTE", "graphToRoute", "Lcom/box/android/search/navigation/SearchDestination$Companion;", "toRoute", "Lcom/box/android/search/navigation/SearchDestination$InnerDestination$Search$Companion;", "Lcom/box/android/search/navigation/SearchDestination$InnerDestination$Filters$Companion;", "Lcom/box/android/search/navigation/SearchDestination$InnerDestination;", "search_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SearchNavigationMappingKt {
    private static final String FILTERS_ROUTE = "filters_route";
    private static final String SEARCH_GRAPH_ROUTE = "search_graph_route";
    private static final String SEARCH_ROUTE = "search_route";

    public static final String graphToRoute(SearchDestination.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return SEARCH_GRAPH_ROUTE;
    }

    public static final String toRoute(SearchDestination.InnerDestination.Search.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return SEARCH_ROUTE;
    }

    public static final String toRoute(SearchDestination.InnerDestination.Filters.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return FILTERS_ROUTE;
    }

    public static final String toRoute(SearchDestination.InnerDestination innerDestination) {
        Intrinsics.checkNotNullParameter(innerDestination, "<this>");
        if (innerDestination instanceof SearchDestination.InnerDestination.Search) {
            return SEARCH_ROUTE;
        }
        if (innerDestination instanceof SearchDestination.InnerDestination.Filters) {
            return FILTERS_ROUTE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
