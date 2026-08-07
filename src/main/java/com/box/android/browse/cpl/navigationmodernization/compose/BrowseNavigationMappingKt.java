package com.box.android.browse.cpl.navigationmodernization.compose;

import com.box.android.browse.cpl.navigationmodernization.BrowseDestination;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BrowseNavigationMapping.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0004\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"graphToRoute", "", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$Companion;", "toRoute", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$InnerDestination$TabsScreen;", "BROWSE_GRAPH_ROUTE", "BROWSE_START_DESTINATION_ROUTE", "browse_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BrowseNavigationMappingKt {
    private static final String BROWSE_GRAPH_ROUTE = "browse_graph_route";
    private static final String BROWSE_START_DESTINATION_ROUTE = "browse_start_destination_route";

    public static final String graphToRoute(BrowseDestination.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return BROWSE_GRAPH_ROUTE;
    }

    public static final String toRoute(BrowseDestination.InnerDestination.TabsScreen tabsScreen) {
        Intrinsics.checkNotNullParameter(tabsScreen, "<this>");
        return BROWSE_START_DESTINATION_ROUTE;
    }
}
