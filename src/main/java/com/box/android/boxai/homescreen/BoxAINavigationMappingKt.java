package com.box.android.boxai.homescreen;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAINavigationMapping.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0004\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"graphToRoute", "", "Lcom/box/android/boxai/homescreen/BoxAiDestination$Companion;", "toRoute", "Lcom/box/android/boxai/homescreen/BoxAiDestination$HomeScreen;", "BOX_AI_GRAPH_ROUTE", "BOX_AI_DESTINATION_ROUTE", "boxai_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxAINavigationMappingKt {
    private static final String BOX_AI_DESTINATION_ROUTE = "box_ai_start_destination_route";
    private static final String BOX_AI_GRAPH_ROUTE = "box_ai_graph_route";

    public static final String graphToRoute(BoxAiDestination.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return BOX_AI_GRAPH_ROUTE;
    }

    public static final String toRoute(BoxAiDestination.HomeScreen homeScreen) {
        Intrinsics.checkNotNullParameter(homeScreen, "<this>");
        return BOX_AI_DESTINATION_ROUTE;
    }
}
