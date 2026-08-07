package com.pspdfkit.ui.search;

import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.pspdfkit.configuration.search.SearchConfiguration;
import com.pspdfkit.document.search.SearchResult;
import com.pspdfkit.ui.PSPDFKitViews;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0001\u0013J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H&J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&R\u0018\u0010\r\u001a\u00020\u000eX¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lcom/pspdfkit/ui/search/PdfSearchView;", "Lcom/pspdfkit/ui/PSPDFKitViews$PSPDFView;", "isShown", "", "clearSearch", "", "setInputFieldText", "text", "", "startSearch", "setSearchViewListener", "searchViewListener", "Lcom/pspdfkit/ui/search/PdfSearchView$Listener;", "searchConfiguration", "Lcom/pspdfkit/configuration/search/SearchConfiguration;", "getSearchConfiguration", "()Lcom/pspdfkit/configuration/search/SearchConfiguration;", "setSearchConfiguration", "(Lcom/pspdfkit/configuration/search/SearchConfiguration;)V", "Listener", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface PdfSearchView extends PSPDFKitViews.PSPDFView {

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\tH&¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lcom/pspdfkit/ui/search/PdfSearchView$Listener;", "", "onSearchStarted", "", "searchTerm", "", "onMoreSearchResults", "results", "", "Lcom/pspdfkit/document/search/SearchResult;", "onSearchCompleted", "onSearchCleared", "onSearchError", "error", "", "onSearchResultSelected", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public interface Listener {
        void onMoreSearchResults(List<SearchResult> results);

        void onSearchCleared();

        void onSearchCompleted();

        void onSearchError(Throwable error);

        void onSearchResultSelected(SearchResult result);

        void onSearchStarted(String searchTerm);
    }

    void clearSearch();

    SearchConfiguration getSearchConfiguration();

    boolean isShown();

    void setInputFieldText(String text, boolean startSearch);

    void setSearchConfiguration(SearchConfiguration searchConfiguration);

    void setSearchViewListener(Listener searchViewListener);
}
