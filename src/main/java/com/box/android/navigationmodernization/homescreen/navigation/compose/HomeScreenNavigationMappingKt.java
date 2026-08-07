package com.box.android.navigationmodernization.homescreen.navigation.compose;

import com.box.android.boxai.homescreen.BoxAINavigationMappingKt;
import com.box.android.boxai.homescreen.BoxAiDestination;
import com.box.android.browse.cpl.navigationmodernization.BrowseDestination;
import com.box.android.browse.cpl.navigationmodernization.compose.BrowseNavigationMappingKt;
import com.box.android.collections.presentation.navigationmodernization.navigation.CollectionsDestination;
import com.box.android.collections.presentation.navigationmodernization.navigation.compose.CollectionsNavigationMappingKt;
import com.box.android.hubs.navigationmodernization.HubsDestination;
import com.box.android.hubs.navigationmodernization.HubsNavigationMappingKt;
import com.box.android.navigationmodernization.homescreen.navigation.HomeNavigationBarDestination;
import com.box.android.notes.navigationmodernization.NotesDestination;
import com.box.android.notes.navigationmodernization.compose.NotesNavigationMappingKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HomeScreenNavigationMapping.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toRoute", "", "Lcom/box/android/navigationmodernization/homescreen/navigation/HomeNavigationBarDestination;", "box_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class HomeScreenNavigationMappingKt {
    public static final String toRoute(HomeNavigationBarDestination homeNavigationBarDestination) {
        Intrinsics.checkNotNullParameter(homeNavigationBarDestination, "<this>");
        if (Intrinsics.areEqual(homeNavigationBarDestination, HomeNavigationBarDestination.Browse.INSTANCE)) {
            return BrowseNavigationMappingKt.graphToRoute(BrowseDestination.INSTANCE);
        }
        if (Intrinsics.areEqual(homeNavigationBarDestination, HomeNavigationBarDestination.Collections.INSTANCE)) {
            return CollectionsNavigationMappingKt.graphToRoute(CollectionsDestination.INSTANCE);
        }
        if (Intrinsics.areEqual(homeNavigationBarDestination, HomeNavigationBarDestination.Notes.INSTANCE)) {
            return NotesNavigationMappingKt.graphToRoute(NotesDestination.INSTANCE);
        }
        if (Intrinsics.areEqual(homeNavigationBarDestination, HomeNavigationBarDestination.Hubs.INSTANCE)) {
            return HubsNavigationMappingKt.graphToRoute(HubsDestination.INSTANCE);
        }
        if (Intrinsics.areEqual(homeNavigationBarDestination, HomeNavigationBarDestination.BoxAi.INSTANCE)) {
            return BoxAINavigationMappingKt.graphToRoute(BoxAiDestination.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }
}
