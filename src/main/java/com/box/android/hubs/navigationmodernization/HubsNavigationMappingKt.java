package com.box.android.hubs.navigationmodernization;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HubsNavigationMapping.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0004\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"graphToRoute", "", "Lcom/box/android/hubs/navigationmodernization/HubsDestination$Companion;", "toRoute", "Lcom/box/android/hubs/navigationmodernization/HubsDestination$Hubs;", "HUBS_GRAPH_ROUTE", "HUBS_DESTINATION_ROUTE", "hubs_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class HubsNavigationMappingKt {
    private static final String HUBS_DESTINATION_ROUTE = "hubs_start_destination_route";
    private static final String HUBS_GRAPH_ROUTE = "hubs_graph_route";

    public static final String graphToRoute(HubsDestination.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return HUBS_GRAPH_ROUTE;
    }

    public static final String toRoute(HubsDestination.Hubs hubs) {
        Intrinsics.checkNotNullParameter(hubs, "<this>");
        return HUBS_DESTINATION_ROUTE;
    }
}
