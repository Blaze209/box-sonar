package com.microsoft.intune.mam.client.app.offline;

import android.app.appsearch.AppSearchResult;
import android.app.appsearch.SearchResult;
import android.app.appsearch.SearchResults;
import com.microsoft.intune.mam.client.app.appsearch.SearchResultsManagementBehavior;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineSearchResultsManagementBehavior implements SearchResultsManagementBehavior {
    @Override // com.microsoft.intune.mam.client.app.appsearch.SearchResultsManagementBehavior
    public void getNextPage(SearchResults searchResults, Executor executor, Consumer<AppSearchResult<List<SearchResult>>> consumer) {
        searchResults.getNextPage(executor, consumer);
    }
}
