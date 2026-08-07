package com.box.android.notes.navigationmodernization.compose;

import com.box.android.notes.navigationmodernization.NotesDestination;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotesNavigationMapping.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0004\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"graphToRoute", "", "Lcom/box/android/notes/navigationmodernization/NotesDestination$Companion;", "toRoute", "Lcom/box/android/notes/navigationmodernization/NotesDestination$InnerDestination$TabsScreen;", "NOTES_GRAPH_ROUTE", "NOTES_DESTINATION_ROUTE", "notes_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class NotesNavigationMappingKt {
    private static final String NOTES_DESTINATION_ROUTE = "notes_start_destination_route";
    private static final String NOTES_GRAPH_ROUTE = "notes_graph_route";

    public static final String graphToRoute(NotesDestination.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return NOTES_GRAPH_ROUTE;
    }

    public static final String toRoute(NotesDestination.InnerDestination.TabsScreen tabsScreen) {
        Intrinsics.checkNotNullParameter(tabsScreen, "<this>");
        return NOTES_DESTINATION_ROUTE;
    }
}
