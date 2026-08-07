package com.box.android.browse.utilities;

import android.content.Context;
import com.box.android.browse.fragments.SearchFragment;
import com.box.android.domain.controller.IBrowseController;
import com.box.android.domain.identity.IUserContextManager;
import com.box.androidsdk.content.models.BoxUser;
import dagger.hilt.android.qualifiers.ApplicationContext;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FilesSearchHelper.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eJ\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eJ\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/box/android/browse/utilities/FilesSearchHelper;", "", "browseController", "Lcom/box/android/domain/controller/IBrowseController;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "searchActionLogHelper", "Lcom/box/android/browse/fragments/SearchFragment$SearchActionLogHelper;", "context", "Landroid/content/Context;", "<init>", "(Lcom/box/android/domain/controller/IBrowseController;Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/browse/fragments/SearchFragment$SearchActionLogHelper;Landroid/content/Context;)V", "loadRecentSearchQueries", "", "", "addRecentSearchQuery", "", "query", "deleteRecentSearchQuery", "indexToRemove", "", "logRecentSearchClick", "logSearch", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FilesSearchHelper {
    public static final int $stable = 8;
    private final IBrowseController browseController;
    private final Context context;
    private final SearchFragment.SearchActionLogHelper searchActionLogHelper;
    private final IUserContextManager userContextManager;

    @Inject
    public FilesSearchHelper(IBrowseController browseController, IUserContextManager userContextManager, SearchFragment.SearchActionLogHelper searchActionLogHelper, @ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(browseController, "browseController");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(searchActionLogHelper, "searchActionLogHelper");
        Intrinsics.checkNotNullParameter(context, "context");
        this.browseController = browseController;
        this.userContextManager = userContextManager;
        this.searchActionLogHelper = searchActionLogHelper;
        this.context = context;
    }

    public final List<String> loadRecentSearchQueries() {
        IBrowseController iBrowseController = this.browseController;
        Context context = this.context;
        BoxUser userInfo = this.userContextManager.getUserInfo();
        Intrinsics.checkNotNullExpressionValue(userInfo, "getUserInfo(...)");
        return iBrowseController.getRecentSearches(context, userInfo);
    }

    public final void addRecentSearchQuery(String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        IBrowseController iBrowseController = this.browseController;
        Context context = this.context;
        BoxUser userInfo = this.userContextManager.getUserInfo();
        Intrinsics.checkNotNullExpressionValue(userInfo, "getUserInfo(...)");
        iBrowseController.addToRecentSearches(context, userInfo, query);
    }

    public final List<String> deleteRecentSearchQuery(int indexToRemove) {
        List<String> listFilterNotNull;
        ArrayList<String> arrayListDeleteFromRecentSearches = this.browseController.deleteFromRecentSearches(this.context, this.userContextManager.getUserInfo(), indexToRemove);
        return (arrayListDeleteFromRecentSearches == null || (listFilterNotNull = CollectionsKt.filterNotNull(arrayListDeleteFromRecentSearches)) == null) ? CollectionsKt.emptyList() : listFilterNotNull;
    }

    public final void logRecentSearchClick(String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        this.searchActionLogHelper.setRecentClicked(query);
    }

    public final void logSearch(String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        if (this.searchActionLogHelper.isSearchLogged()) {
            if (this.searchActionLogHelper.isQueryRecentClicked(query)) {
                this.searchActionLogHelper.logRecentAction();
            } else {
                this.searchActionLogHelper.logTypingAction();
            }
        }
    }
}
