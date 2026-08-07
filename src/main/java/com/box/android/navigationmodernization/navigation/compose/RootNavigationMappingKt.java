package com.box.android.navigationmodernization.navigation.compose;

import com.box.android.browse.search.navigation.FilesSearchDestination;
import com.box.android.browse.search.navigation.compose.FilesSearchNavigationMappingKt;
import com.box.android.inbox.InboxDestination;
import com.box.android.inbox.InboxNavigationMappingKt;
import com.box.android.navigationmodernization.navigation.RootNavigationDestination;
import com.box.android.search.navigation.SearchDestination;
import com.box.android.search.navigation.compose.SearchNavigationMappingKt;
import com.box.android.search.navigation.notes.NotesSearchDestination;
import com.box.android.search.navigation.notes.compose.NotesSearchNavigationMappingKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RootNavigationMapping.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0004"}, d2 = {"HOME_SCREEN_ROUTE", "", "toRoute", "Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination$InnerDestination;", "box_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class RootNavigationMappingKt {
    private static final String HOME_SCREEN_ROUTE = "home_screen";

    public static final String toRoute(RootNavigationDestination.InnerDestination innerDestination) {
        Intrinsics.checkNotNullParameter(innerDestination, "<this>");
        if (Intrinsics.areEqual(innerDestination, RootNavigationDestination.InnerDestination.HomeScreen.INSTANCE)) {
            return HOME_SCREEN_ROUTE;
        }
        if (Intrinsics.areEqual(innerDestination, RootNavigationDestination.InnerDestination.Search.Files.INSTANCE)) {
            return FilesSearchNavigationMappingKt.graphToRoute(FilesSearchDestination.INSTANCE);
        }
        if (Intrinsics.areEqual(innerDestination, RootNavigationDestination.InnerDestination.Search.Unified.INSTANCE)) {
            return SearchNavigationMappingKt.graphToRoute(SearchDestination.INSTANCE);
        }
        if (Intrinsics.areEqual(innerDestination, RootNavigationDestination.InnerDestination.NotesSearch.INSTANCE)) {
            return NotesSearchNavigationMappingKt.graphToRoute(NotesSearchDestination.INSTANCE);
        }
        if (Intrinsics.areEqual(innerDestination, RootNavigationDestination.InnerDestination.Inbox.INSTANCE)) {
            return InboxNavigationMappingKt.graphToRoute(InboxDestination.INSTANCE);
        }
        if (!Intrinsics.areEqual(innerDestination, RootNavigationDestination.InnerDestination.Search.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        throw new IllegalStateException("RootNavigationDestination.InnerDestination.Search must be resolved by RootNavigator into Search.Files or Search.Unified before mapping to a route.".toString());
    }
}
