package com.box.android.search.analytics;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchAnalytics.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0010J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J!\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010\u000f¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lcom/box/android/search/analytics/SearchAnalytics;", "", "recentItemTapped", "", "recentAiSessionTapped", "viewAllAiSessionsTapped", "askAiTapped", "filterApplied", "filterType", "", "clearFiltersTapped", "resultTapped", "searchResultType", ViewProps.POSITION, "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "NoOp", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SearchAnalytics {
    default void askAiTapped() {
    }

    default void clearFiltersTapped() {
    }

    default void filterApplied(String filterType) {
    }

    default void recentAiSessionTapped() {
    }

    default void recentItemTapped() {
    }

    default void resultTapped(String searchResultType, Integer position) {
    }

    default void viewAllAiSessionsTapped() {
    }

    /* JADX INFO: compiled from: SearchAnalytics.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void recentItemTapped(SearchAnalytics searchAnalytics) {
            SearchAnalytics.super.recentItemTapped();
        }

        @Deprecated
        public static void recentAiSessionTapped(SearchAnalytics searchAnalytics) {
            SearchAnalytics.super.recentAiSessionTapped();
        }

        @Deprecated
        public static void viewAllAiSessionsTapped(SearchAnalytics searchAnalytics) {
            SearchAnalytics.super.viewAllAiSessionsTapped();
        }

        @Deprecated
        public static void askAiTapped(SearchAnalytics searchAnalytics) {
            SearchAnalytics.super.askAiTapped();
        }

        @Deprecated
        public static void filterApplied(SearchAnalytics searchAnalytics, String str) {
            SearchAnalytics.super.filterApplied(str);
        }

        @Deprecated
        public static void clearFiltersTapped(SearchAnalytics searchAnalytics) {
            SearchAnalytics.super.clearFiltersTapped();
        }

        @Deprecated
        public static void resultTapped(SearchAnalytics searchAnalytics, String str, Integer num) {
            SearchAnalytics.super.resultTapped(str, num);
        }
    }

    /* JADX INFO: compiled from: SearchAnalytics.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/search/analytics/SearchAnalytics$NoOp;", "Lcom/box/android/search/analytics/SearchAnalytics;", "<init>", "()V", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class NoOp implements SearchAnalytics {
        public static final int $stable = 0;
        public static final NoOp INSTANCE = new NoOp();

        private NoOp() {
        }

        @Override // com.box.android.search.analytics.SearchAnalytics
        public /* bridge */ void askAiTapped() {
            super.askAiTapped();
        }

        @Override // com.box.android.search.analytics.SearchAnalytics
        public /* bridge */ void clearFiltersTapped() {
            super.clearFiltersTapped();
        }

        @Override // com.box.android.search.analytics.SearchAnalytics
        public /* bridge */ void filterApplied(String str) {
            super.filterApplied(str);
        }

        @Override // com.box.android.search.analytics.SearchAnalytics
        public /* bridge */ void recentAiSessionTapped() {
            super.recentAiSessionTapped();
        }

        @Override // com.box.android.search.analytics.SearchAnalytics
        public /* bridge */ void recentItemTapped() {
            super.recentItemTapped();
        }

        @Override // com.box.android.search.analytics.SearchAnalytics
        public /* bridge */ void resultTapped(String str, Integer num) {
            super.resultTapped(str, num);
        }

        @Override // com.box.android.search.analytics.SearchAnalytics
        public /* bridge */ void viewAllAiSessionsTapped() {
            super.viewAllAiSessionsTapped();
        }
    }
}
