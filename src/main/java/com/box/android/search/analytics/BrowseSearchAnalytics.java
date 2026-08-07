package com.box.android.search.analytics;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.facebook.react.uimanager.ViewProps;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BrowseSearchAnalytics.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J!\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0002¨\u0006\u0014"}, d2 = {"Lcom/box/android/search/analytics/BrowseSearchAnalytics;", "Lcom/box/android/search/analytics/SearchAnalytics;", "<init>", "()V", "recentItemTapped", "", "recentAiSessionTapped", "viewAllAiSessionsTapped", "askAiTapped", "filterApplied", "filterType", "", "clearFiltersTapped", "resultTapped", "searchResultType", ViewProps.POSITION, "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "searchEventBuilder", "Lcom/box/android/domain/analytics/BoxAmplitudeAnalytics$SearchEventPropertyBuilder;", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BrowseSearchAnalytics implements SearchAnalytics {
    public static final int $stable = 0;

    @Inject
    public BrowseSearchAnalytics() {
    }

    @Override // com.box.android.search.analytics.SearchAnalytics
    public void recentItemTapped() {
        searchEventBuilder().logEvent(BoxAnalyticsParams.EVENT_BROWSE_SEARCH_RECENT_ITEM_TAPPED);
    }

    @Override // com.box.android.search.analytics.SearchAnalytics
    public void recentAiSessionTapped() {
        searchEventBuilder().logEvent(BoxAnalyticsParams.EVENT_BROWSE_SEARCH_RECENT_AI_SESSION_TAPPED);
    }

    @Override // com.box.android.search.analytics.SearchAnalytics
    public void viewAllAiSessionsTapped() {
        searchEventBuilder().logEvent(BoxAnalyticsParams.EVENT_BROWSE_SEARCH_VIEW_ALL_AI_SESSIONS_TAPPED);
    }

    @Override // com.box.android.search.analytics.SearchAnalytics
    public void askAiTapped() {
        searchEventBuilder().logEvent(BoxAnalyticsParams.EVENT_BROWSE_SEARCH_ASK_AI_TAPPED);
    }

    @Override // com.box.android.search.analytics.SearchAnalytics
    public void filterApplied(String filterType) {
        BoxAmplitudeAnalytics.SearchEventPropertyBuilder searchEventPropertyBuilderSearchEventBuilder = searchEventBuilder();
        if (filterType != null) {
            searchEventPropertyBuilderSearchEventBuilder.setFilterType(filterType);
        }
        searchEventPropertyBuilderSearchEventBuilder.logEvent(BoxAnalyticsParams.EVENT_BROWSE_SEARCH_FILTER_APPLIED);
    }

    @Override // com.box.android.search.analytics.SearchAnalytics
    public void clearFiltersTapped() {
        searchEventBuilder().logEvent(BoxAnalyticsParams.EVENT_BROWSE_SEARCH_CLEAR_FILTERS_TAPPED);
    }

    @Override // com.box.android.search.analytics.SearchAnalytics
    public void resultTapped(String searchResultType, Integer position) {
        BoxAmplitudeAnalytics.SearchEventPropertyBuilder searchEventPropertyBuilderSearchEventBuilder = searchEventBuilder();
        if (searchResultType != null) {
            searchEventPropertyBuilderSearchEventBuilder.setSearchResultType(searchResultType);
        }
        if (position != null) {
            searchEventPropertyBuilderSearchEventBuilder.setPositionTapped(position.intValue());
        }
        searchEventPropertyBuilderSearchEventBuilder.logEvent(BoxAnalyticsParams.EVENT_BROWSE_SEARCH_RESULT_TAPPED);
    }

    private final BoxAmplitudeAnalytics.SearchEventPropertyBuilder searchEventBuilder() {
        BoxAmplitudeAnalytics.SearchEventPropertyBuilder searchEventPropertyBuilderCreateSearchEventBuilder = BoxAmplitudeAnalytics.createSearchEventBuilder();
        searchEventPropertyBuilderCreateSearchEventBuilder.setFlow(BoxAnalyticsParams.FLOW_FILE_NAVIGATION);
        Intrinsics.checkNotNullExpressionValue(searchEventPropertyBuilderCreateSearchEventBuilder, "apply(...)");
        return searchEventPropertyBuilderCreateSearchEventBuilder;
    }
}
