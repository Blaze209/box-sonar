package com.microsoft.intune.mam.client.app.appsearch;

import android.app.appsearch.AppSearchResult;
import android.app.appsearch.SearchResult;
import android.app.appsearch.SearchResults;
import com.microsoft.intune.mam.client.CachedBehaviorProvider;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMSearchResultsManagement {
    private static CachedBehaviorProvider<SearchResultsManagementBehavior> sCachedBehavior = new CachedBehaviorProvider<>(SearchResultsManagementBehavior.class);

    private MAMSearchResultsManagement() {
    }

    public static void getNextPage(SearchResults searchResults, Executor executor, Consumer<AppSearchResult<List<SearchResult>>> consumer) {
        getBehavior().getNextPage(searchResults, executor, consumer);
    }

    private static SearchResultsManagementBehavior getBehavior() {
        return sCachedBehavior.get();
    }
}
