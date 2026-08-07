package com.box.android.navigationmodernization.homescreen.navigation.configuration;

import com.box.android.browse.cpl.navigationmodernization.BrowseDestination;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.navigationmodernization.homescreen.navigation.HomeNavigationBarDestination;
import com.box.android.notes.navigationmodernization.NotesDestination;
import com.box.androidsdk.content.models.BoxItem;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NavigationPersistenceKeys.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u0010\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u0010\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u0018\u0010\r\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0001\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\b\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u000b¨\u0006\u0010"}, d2 = {"persistenceKey", "", "Lcom/box/android/navigationmodernization/homescreen/navigation/HomeNavigationBarDestination;", "getPersistenceKey", "(Lcom/box/android/navigationmodernization/homescreen/navigation/HomeNavigationBarDestination;)Ljava/lang/String;", "graphFromPersistenceKey", "key", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$InnerDestination$TabsScreen$BrowseTab;", "(Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$InnerDestination$TabsScreen$BrowseTab;)Ljava/lang/String;", "browseTabFromPersistenceKey", "Lcom/box/android/notes/navigationmodernization/NotesDestination$InnerDestination$TabsScreen$NotesTab;", "(Lcom/box/android/notes/navigationmodernization/NotesDestination$InnerDestination$TabsScreen$NotesTab;)Ljava/lang/String;", "notesTabFromPersistenceKey", "innerTabNameToPersistenceKey", "graph", "tabName", "box_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class NavigationPersistenceKeysKt {

    /* JADX INFO: compiled from: NavigationPersistenceKeys.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[BrowseDestination.InnerDestination.TabsScreen.BrowseTab.values().length];
            try {
                iArr[BrowseDestination.InnerDestination.TabsScreen.BrowseTab.AllFilesTab.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BrowseDestination.InnerDestination.TabsScreen.BrowseTab.OfflinedTab.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BrowseDestination.InnerDestination.TabsScreen.BrowseTab.RecentsTab.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[NotesDestination.InnerDestination.TabsScreen.NotesTab.values().length];
            try {
                iArr2[NotesDestination.InnerDestination.TabsScreen.NotesTab.RecentsTab.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[NotesDestination.InnerDestination.TabsScreen.NotesTab.FavoritesTab.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final String getPersistenceKey(HomeNavigationBarDestination homeNavigationBarDestination) {
        Intrinsics.checkNotNullParameter(homeNavigationBarDestination, "<this>");
        if (Intrinsics.areEqual(homeNavigationBarDestination, HomeNavigationBarDestination.Browse.INSTANCE)) {
            return "browse";
        }
        if (Intrinsics.areEqual(homeNavigationBarDestination, HomeNavigationBarDestination.Notes.INSTANCE)) {
            return "notes";
        }
        if (Intrinsics.areEqual(homeNavigationBarDestination, HomeNavigationBarDestination.Hubs.INSTANCE)) {
            return "hubs";
        }
        if (Intrinsics.areEqual(homeNavigationBarDestination, HomeNavigationBarDestination.Collections.INSTANCE)) {
            return BoxItem.FIELD_COLLECTIONS;
        }
        if (Intrinsics.areEqual(homeNavigationBarDestination, HomeNavigationBarDestination.BoxAi.INSTANCE)) {
            return "box_ai";
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final HomeNavigationBarDestination graphFromPersistenceKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        switch (key.hashCode()) {
            case -1383130340:
                if (key.equals("box_ai")) {
                    return HomeNavigationBarDestination.BoxAi.INSTANCE;
                }
                return null;
            case -1380604278:
                if (key.equals("browse")) {
                    return HomeNavigationBarDestination.Browse.INSTANCE;
                }
                return null;
            case 3213854:
                if (key.equals("hubs")) {
                    return HomeNavigationBarDestination.Hubs.INSTANCE;
                }
                return null;
            case 105008833:
                if (key.equals("notes")) {
                    return HomeNavigationBarDestination.Notes.INSTANCE;
                }
                return null;
            case 1853891989:
                if (key.equals(BoxItem.FIELD_COLLECTIONS)) {
                    return HomeNavigationBarDestination.Collections.INSTANCE;
                }
                return null;
            default:
                return null;
        }
    }

    public static final String getPersistenceKey(BrowseDestination.InnerDestination.TabsScreen.BrowseTab browseTab) {
        Intrinsics.checkNotNullParameter(browseTab, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[browseTab.ordinal()];
        if (i == 1) {
            return "all_files";
        }
        if (i == 2) {
            return "offlined";
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return BoxAnalyticsParams.ACTION_RECENTS;
    }

    public static final BrowseDestination.InnerDestination.TabsScreen.BrowseTab browseTabFromPersistenceKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int iHashCode = key.hashCode();
        if (iHashCode == -762335519) {
            if (key.equals("offlined")) {
                return BrowseDestination.InnerDestination.TabsScreen.BrowseTab.OfflinedTab;
            }
            return null;
        }
        if (iHashCode == -101115303) {
            if (key.equals("all_files")) {
                return BrowseDestination.InnerDestination.TabsScreen.BrowseTab.AllFilesTab;
            }
            return null;
        }
        if (iHashCode == 1082295672 && key.equals(BoxAnalyticsParams.ACTION_RECENTS)) {
            return BrowseDestination.InnerDestination.TabsScreen.BrowseTab.RecentsTab;
        }
        return null;
    }

    public static final String getPersistenceKey(NotesDestination.InnerDestination.TabsScreen.NotesTab notesTab) {
        Intrinsics.checkNotNullParameter(notesTab, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$1[notesTab.ordinal()];
        if (i == 1) {
            return BoxAnalyticsParams.ACTION_RECENTS;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return "favorites";
    }

    public static final NotesDestination.InnerDestination.TabsScreen.NotesTab notesTabFromPersistenceKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (Intrinsics.areEqual(key, BoxAnalyticsParams.ACTION_RECENTS)) {
            return NotesDestination.InnerDestination.TabsScreen.NotesTab.RecentsTab;
        }
        if (Intrinsics.areEqual(key, "favorites")) {
            return NotesDestination.InnerDestination.TabsScreen.NotesTab.FavoritesTab;
        }
        return null;
    }

    public static final String innerTabNameToPersistenceKey(HomeNavigationBarDestination graph, String tabName) {
        NotesDestination.InnerDestination.TabsScreen.NotesTab next;
        BrowseDestination.InnerDestination.TabsScreen.BrowseTab next2;
        Intrinsics.checkNotNullParameter(graph, "graph");
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        if (!Intrinsics.areEqual(graph, HomeNavigationBarDestination.Browse.INSTANCE)) {
            if (!Intrinsics.areEqual(graph, HomeNavigationBarDestination.Notes.INSTANCE)) {
                if (Intrinsics.areEqual(graph, HomeNavigationBarDestination.Collections.INSTANCE) || Intrinsics.areEqual(graph, HomeNavigationBarDestination.Hubs.INSTANCE) || Intrinsics.areEqual(graph, HomeNavigationBarDestination.BoxAi.INSTANCE)) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }
            Iterator<NotesDestination.InnerDestination.TabsScreen.NotesTab> it = NotesDestination.InnerDestination.TabsScreen.NotesTab.getEntries().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(next.name(), tabName));
            NotesDestination.InnerDestination.TabsScreen.NotesTab notesTab = next;
            if (notesTab != null) {
                return getPersistenceKey(notesTab);
            }
            return null;
        }
        Iterator<BrowseDestination.InnerDestination.TabsScreen.BrowseTab> it2 = BrowseDestination.InnerDestination.TabsScreen.BrowseTab.getEntries().iterator();
        do {
            if (!it2.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it2.next();
        } while (!Intrinsics.areEqual(next2.name(), tabName));
        BrowseDestination.InnerDestination.TabsScreen.BrowseTab browseTab = next2;
        if (browseTab != null) {
            return getPersistenceKey(browseTab);
        }
        return null;
    }
}
