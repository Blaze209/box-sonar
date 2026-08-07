package com.pspdfkit.ui.search;

import com.pspdfkit.document.search.SearchResult;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SimpleSearchResultListener implements PdfSearchView.Listener {
    @Override // com.pspdfkit.ui.search.PdfSearchView.Listener
    public void onMoreSearchResults(List<SearchResult> list) {
    }

    @Override // com.pspdfkit.ui.search.PdfSearchView.Listener
    public void onSearchCleared() {
    }

    @Override // com.pspdfkit.ui.search.PdfSearchView.Listener
    public void onSearchCompleted() {
    }

    @Override // com.pspdfkit.ui.search.PdfSearchView.Listener
    public void onSearchError(Throwable th) {
    }

    @Override // com.pspdfkit.ui.search.PdfSearchView.Listener
    public void onSearchResultSelected(SearchResult searchResult) {
    }

    @Override // com.pspdfkit.ui.search.PdfSearchView.Listener
    public void onSearchStarted(String str) {
    }
}
