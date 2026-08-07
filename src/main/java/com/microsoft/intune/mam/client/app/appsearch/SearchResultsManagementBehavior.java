package com.microsoft.intune.mam.client.app.appsearch;

import android.app.appsearch.AppSearchResult;
import android.app.appsearch.SearchResult;
import android.app.appsearch.SearchResults;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
public interface SearchResultsManagementBehavior {
    void getNextPage(SearchResults searchResults, Executor executor, Consumer<AppSearchResult<List<SearchResult>>> consumer);
}
