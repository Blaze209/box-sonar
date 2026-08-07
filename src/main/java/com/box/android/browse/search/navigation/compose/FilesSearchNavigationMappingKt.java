package com.box.android.browse.search.navigation.compose;

import com.box.android.browse.search.navigation.FilesSearchDestination;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FilesSearchNavigationMapping.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0004\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"graphToRoute", "", "Lcom/box/android/browse/search/navigation/FilesSearchDestination$Companion;", "toRoute", "Lcom/box/android/browse/search/navigation/FilesSearchDestination$InnerDestination$Search;", "FILES_SEARCH_GRAPH_ROUTE", "FILES_SEARCH_START_DESTINATION_ROUTE", "browse_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FilesSearchNavigationMappingKt {
    private static final String FILES_SEARCH_GRAPH_ROUTE = "files_search_graph_route";
    private static final String FILES_SEARCH_START_DESTINATION_ROUTE = "files_search_start_destination_route";

    public static final String graphToRoute(FilesSearchDestination.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return FILES_SEARCH_GRAPH_ROUTE;
    }

    public static final String toRoute(FilesSearchDestination.InnerDestination.Search search) {
        Intrinsics.checkNotNullParameter(search, "<this>");
        return FILES_SEARCH_START_DESTINATION_ROUTE;
    }
}
