package com.box.android.navigationmodernization.homescreen.navigation.compose;

import com.box.android.browse.cpl.navigationmodernization.BrowseNavigator;
import com.box.android.collections.presentation.navigationmodernization.navigation.CollectionsNavigator;
import com.box.android.notes.navigationmodernization.NotesNavigator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HomeScreenInnerNavigatorsProvider.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/box/android/navigationmodernization/homescreen/navigation/compose/HomeScreenInnerNavigatorsProvider;", "", "browseNavigator", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseNavigator;", "collectionsNavigator", "Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsNavigator;", "notesNavigator", "Lcom/box/android/notes/navigationmodernization/NotesNavigator;", "<init>", "(Lcom/box/android/browse/cpl/navigationmodernization/BrowseNavigator;Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsNavigator;Lcom/box/android/notes/navigationmodernization/NotesNavigator;)V", "getBrowseNavigator", "()Lcom/box/android/browse/cpl/navigationmodernization/BrowseNavigator;", "getCollectionsNavigator", "()Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsNavigator;", "getNotesNavigator", "()Lcom/box/android/notes/navigationmodernization/NotesNavigator;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HomeScreenInnerNavigatorsProvider {
    public static final int $stable = (NotesNavigator.$stable | CollectionsNavigator.$stable) | BrowseNavigator.$stable;
    private final BrowseNavigator browseNavigator;
    private final CollectionsNavigator collectionsNavigator;
    private final NotesNavigator notesNavigator;

    public HomeScreenInnerNavigatorsProvider(BrowseNavigator browseNavigator, CollectionsNavigator collectionsNavigator, NotesNavigator notesNavigator) {
        Intrinsics.checkNotNullParameter(browseNavigator, "browseNavigator");
        Intrinsics.checkNotNullParameter(collectionsNavigator, "collectionsNavigator");
        Intrinsics.checkNotNullParameter(notesNavigator, "notesNavigator");
        this.browseNavigator = browseNavigator;
        this.collectionsNavigator = collectionsNavigator;
        this.notesNavigator = notesNavigator;
    }

    public final BrowseNavigator getBrowseNavigator() {
        return this.browseNavigator;
    }

    public final CollectionsNavigator getCollectionsNavigator() {
        return this.collectionsNavigator;
    }

    public final NotesNavigator getNotesNavigator() {
        return this.notesNavigator;
    }
}
