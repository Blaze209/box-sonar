package com.box.android.notes.presentation.cpl;

import com.box.android.browse.cpl.itemsList.IItemsListViewEnvironment;
import com.box.android.domain.services.IFavoritesService;
import com.box.android.notes.navigationmodernization.NotesAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotesListReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/box/android/notes/presentation/cpl/NotesEnvironment;", "", "itemsListViewEnvironment", "Lcom/box/android/browse/cpl/itemsList/IItemsListViewEnvironment;", "favoritesService", "Lcom/box/android/domain/services/IFavoritesService;", "analytics", "Lcom/box/android/notes/navigationmodernization/NotesAnalytics;", "<init>", "(Lcom/box/android/browse/cpl/itemsList/IItemsListViewEnvironment;Lcom/box/android/domain/services/IFavoritesService;Lcom/box/android/notes/navigationmodernization/NotesAnalytics;)V", "getItemsListViewEnvironment", "()Lcom/box/android/browse/cpl/itemsList/IItemsListViewEnvironment;", "getFavoritesService", "()Lcom/box/android/domain/services/IFavoritesService;", "getAnalytics", "()Lcom/box/android/notes/navigationmodernization/NotesAnalytics;", "notes_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NotesEnvironment {
    public static final int $stable = 8;
    private final NotesAnalytics analytics;
    private final IFavoritesService favoritesService;
    private final IItemsListViewEnvironment itemsListViewEnvironment;

    public NotesEnvironment(IItemsListViewEnvironment itemsListViewEnvironment, IFavoritesService favoritesService, NotesAnalytics analytics) {
        Intrinsics.checkNotNullParameter(itemsListViewEnvironment, "itemsListViewEnvironment");
        Intrinsics.checkNotNullParameter(favoritesService, "favoritesService");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.itemsListViewEnvironment = itemsListViewEnvironment;
        this.favoritesService = favoritesService;
        this.analytics = analytics;
    }

    public final IItemsListViewEnvironment getItemsListViewEnvironment() {
        return this.itemsListViewEnvironment;
    }

    public final IFavoritesService getFavoritesService() {
        return this.favoritesService;
    }

    public final NotesAnalytics getAnalytics() {
        return this.analytics;
    }
}
