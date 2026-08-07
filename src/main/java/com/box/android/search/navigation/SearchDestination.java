package com.box.android.search.navigation;

import com.box.android.base.compose.DestinationWithNavArgs;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.search.FilesSearchFilters;
import com.box.android.domain.models.search.SearchMode;
import com.box.brownfieldApi.featuresNavigator.HubDetailsInitialContext;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchDestination.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00062\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lcom/box/android/search/navigation/SearchDestination;", "", "<init>", "()V", "InnerDestination", "OuterDestination", "Companion", "Lcom/box/android/search/navigation/SearchDestination$InnerDestination;", "Lcom/box/android/search/navigation/SearchDestination$OuterDestination;", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class SearchDestination {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ SearchDestination(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private SearchDestination() {
    }

    /* JADX INFO: compiled from: SearchDestination.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lcom/box/android/search/navigation/SearchDestination$InnerDestination;", "Lcom/box/android/search/navigation/SearchDestination;", "Lcom/box/android/base/compose/DestinationWithNavArgs;", "<init>", "()V", "Search", "Filters", "Lcom/box/android/search/navigation/SearchDestination$InnerDestination$Filters;", "Lcom/box/android/search/navigation/SearchDestination$InnerDestination$Search;", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class InnerDestination extends SearchDestination implements DestinationWithNavArgs {
        public static final int $stable = 0;

        public /* synthetic */ InnerDestination(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private InnerDestination() {
            super(null);
        }

        @Override // com.box.android.base.compose.DestinationWithNavArgs
        public /* bridge */ Map<String, Object> getNavArgs() {
            return super.getNavArgs();
        }

        /* JADX INFO: compiled from: SearchDestination.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\rH\u0016J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/box/android/search/navigation/SearchDestination$InnerDestination$Search;", "Lcom/box/android/search/navigation/SearchDestination$InnerDestination;", "searchMode", "Lcom/box/android/domain/models/search/SearchMode;", "includeRecentSharedLinks", "", "<init>", "(Lcom/box/android/domain/models/search/SearchMode;Z)V", "getSearchMode", "()Lcom/box/android/domain/models/search/SearchMode;", "getIncludeRecentSharedLinks", "()Z", "getNavArgs", "", "", "", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "Companion", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Search extends InnerDestination {
            public static final String AI_CENTER_ENABLED = "ai_center_enabled";
            public static final String INCLUDE_RECENT_SHARED_LINKS = "include_recent_shared_links";
            public static final String SEARCH_MODE = "search_mode";
            private final boolean includeRecentSharedLinks;
            private final SearchMode searchMode;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            public static final int $stable = 8;

            public static /* synthetic */ Search copy$default(Search search, SearchMode searchMode, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    searchMode = search.searchMode;
                }
                if ((i & 2) != 0) {
                    z = search.includeRecentSharedLinks;
                }
                return search.copy(searchMode, z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final SearchMode getSearchMode() {
                return this.searchMode;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getIncludeRecentSharedLinks() {
                return this.includeRecentSharedLinks;
            }

            public final Search copy(SearchMode searchMode, boolean includeRecentSharedLinks) {
                Intrinsics.checkNotNullParameter(searchMode, "searchMode");
                return new Search(searchMode, includeRecentSharedLinks);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Search)) {
                    return false;
                }
                Search search = (Search) other;
                return Intrinsics.areEqual(this.searchMode, search.searchMode) && this.includeRecentSharedLinks == search.includeRecentSharedLinks;
            }

            public int hashCode() {
                return (this.searchMode.hashCode() * 31) + Boolean.hashCode(this.includeRecentSharedLinks);
            }

            public String toString() {
                return "Search(searchMode=" + this.searchMode + ", includeRecentSharedLinks=" + this.includeRecentSharedLinks + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Search(SearchMode searchMode, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(searchMode, "searchMode");
                this.searchMode = searchMode;
                this.includeRecentSharedLinks = z;
            }

            public /* synthetic */ Search(SearchMode searchMode, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(searchMode, (i & 2) != 0 ? false : z);
            }

            public final boolean getIncludeRecentSharedLinks() {
                return this.includeRecentSharedLinks;
            }

            public final SearchMode getSearchMode() {
                return this.searchMode;
            }

            @Override // com.box.android.search.navigation.SearchDestination.InnerDestination, com.box.android.base.compose.DestinationWithNavArgs
            public Map<String, Object> getNavArgs() {
                return MapsKt.mapOf(TuplesKt.to(SEARCH_MODE, this.searchMode), TuplesKt.to(INCLUDE_RECENT_SHARED_LINKS, Boolean.valueOf(this.includeRecentSharedLinks)));
            }

            /* JADX INFO: compiled from: SearchDestination.kt */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/box/android/search/navigation/SearchDestination$InnerDestination$Search$Companion;", "", "<init>", "()V", "SEARCH_MODE", "", "AI_CENTER_ENABLED", "INCLUDE_RECENT_SHARED_LINKS", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }
            }
        }

        /* JADX INFO: compiled from: SearchDestination.kt */
        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tH\u0016J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/box/android/search/navigation/SearchDestination$InnerDestination$Filters;", "Lcom/box/android/search/navigation/SearchDestination$InnerDestination;", Filters.FILTERS_ARGS_KEY, "Lcom/box/android/domain/models/search/FilesSearchFilters;", "<init>", "(Lcom/box/android/domain/models/search/FilesSearchFilters;)V", "getInitialFilters", "()Lcom/box/android/domain/models/search/FilesSearchFilters;", "getNavArgs", "", "", "", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "Companion", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Filters extends InnerDestination {
            public static final String FILTERS_ARGS_KEY = "initialFilters";
            private final FilesSearchFilters initialFilters;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            public static final int $stable = 8;

            public static /* synthetic */ Filters copy$default(Filters filters, FilesSearchFilters filesSearchFilters, int i, Object obj) {
                if ((i & 1) != 0) {
                    filesSearchFilters = filters.initialFilters;
                }
                return filters.copy(filesSearchFilters);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FilesSearchFilters getInitialFilters() {
                return this.initialFilters;
            }

            public final Filters copy(FilesSearchFilters initialFilters) {
                Intrinsics.checkNotNullParameter(initialFilters, "initialFilters");
                return new Filters(initialFilters);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Filters) && Intrinsics.areEqual(this.initialFilters, ((Filters) other).initialFilters);
            }

            public int hashCode() {
                return this.initialFilters.hashCode();
            }

            public String toString() {
                return "Filters(initialFilters=" + this.initialFilters + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Filters(FilesSearchFilters initialFilters) {
                super(null);
                Intrinsics.checkNotNullParameter(initialFilters, "initialFilters");
                this.initialFilters = initialFilters;
            }

            public final FilesSearchFilters getInitialFilters() {
                return this.initialFilters;
            }

            @Override // com.box.android.search.navigation.SearchDestination.InnerDestination, com.box.android.base.compose.DestinationWithNavArgs
            public Map<String, Object> getNavArgs() {
                return MapsKt.mapOf(TuplesKt.to(FILTERS_ARGS_KEY, this.initialFilters));
            }

            /* JADX INFO: compiled from: SearchDestination.kt */
            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/box/android/search/navigation/SearchDestination$InnerDestination$Filters$Companion;", "", "<init>", "()V", "FILTERS_ARGS_KEY", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchDestination.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/search/navigation/SearchDestination$OuterDestination;", "Lcom/box/android/search/navigation/SearchDestination;", "<init>", "()V", "Item", "Hub", "ItemMoreActionsMenu", "Lcom/box/android/search/navigation/SearchDestination$OuterDestination$Hub;", "Lcom/box/android/search/navigation/SearchDestination$OuterDestination$Item;", "Lcom/box/android/search/navigation/SearchDestination$OuterDestination$ItemMoreActionsMenu;", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class OuterDestination extends SearchDestination {
        public static final int $stable = 0;

        public /* synthetic */ OuterDestination(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: SearchDestination.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/search/navigation/SearchDestination$OuterDestination$Item;", "Lcom/box/android/search/navigation/SearchDestination$OuterDestination;", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "accessibleSharedLink", "", "<init>", "(Lcom/box/android/domain/models/item/ItemModel;Ljava/lang/String;)V", "getItemModel", "()Lcom/box/android/domain/models/item/ItemModel;", "getAccessibleSharedLink", "()Ljava/lang/String;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Item extends OuterDestination {
            public static final int $stable = 8;
            private final String accessibleSharedLink;
            private final ItemModel itemModel;

            public static /* synthetic */ Item copy$default(Item item, ItemModel itemModel, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    itemModel = item.itemModel;
                }
                if ((i & 2) != 0) {
                    str = item.accessibleSharedLink;
                }
                return item.copy(itemModel, str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemModel getItemModel() {
                return this.itemModel;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getAccessibleSharedLink() {
                return this.accessibleSharedLink;
            }

            public final Item copy(ItemModel itemModel, String accessibleSharedLink) {
                Intrinsics.checkNotNullParameter(itemModel, "itemModel");
                return new Item(itemModel, accessibleSharedLink);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Item)) {
                    return false;
                }
                Item item = (Item) other;
                return Intrinsics.areEqual(this.itemModel, item.itemModel) && Intrinsics.areEqual(this.accessibleSharedLink, item.accessibleSharedLink);
            }

            public int hashCode() {
                int iHashCode = this.itemModel.hashCode() * 31;
                String str = this.accessibleSharedLink;
                return iHashCode + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                return "Item(itemModel=" + this.itemModel + ", accessibleSharedLink=" + this.accessibleSharedLink + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Item(ItemModel itemModel, String str) {
                super(null);
                Intrinsics.checkNotNullParameter(itemModel, "itemModel");
                this.itemModel = itemModel;
                this.accessibleSharedLink = str;
            }

            public /* synthetic */ Item(ItemModel itemModel, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(itemModel, (i & 2) != 0 ? null : str);
            }

            public final String getAccessibleSharedLink() {
                return this.accessibleSharedLink;
            }

            public final ItemModel getItemModel() {
                return this.itemModel;
            }
        }

        private OuterDestination() {
            super(null);
        }

        /* JADX INFO: compiled from: SearchDestination.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/search/navigation/SearchDestination$OuterDestination$Hub;", "Lcom/box/android/search/navigation/SearchDestination$OuterDestination;", HubDetailsInitialContext.HUB_ID_KEY, "", "<init>", "(Ljava/lang/String;)V", "getHubId", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Hub extends OuterDestination {
            public static final int $stable = 0;
            private final String hubId;

            public static /* synthetic */ Hub copy$default(Hub hub, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = hub.hubId;
                }
                return hub.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getHubId() {
                return this.hubId;
            }

            public final Hub copy(String hubId) {
                Intrinsics.checkNotNullParameter(hubId, "hubId");
                return new Hub(hubId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Hub) && Intrinsics.areEqual(this.hubId, ((Hub) other).hubId);
            }

            public int hashCode() {
                return this.hubId.hashCode();
            }

            public String toString() {
                return "Hub(hubId=" + this.hubId + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Hub(String hubId) {
                super(null);
                Intrinsics.checkNotNullParameter(hubId, "hubId");
                this.hubId = hubId;
            }

            public final String getHubId() {
                return this.hubId;
            }
        }

        /* JADX INFO: compiled from: SearchDestination.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/search/navigation/SearchDestination$OuterDestination$ItemMoreActionsMenu;", "Lcom/box/android/search/navigation/SearchDestination$OuterDestination;", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "<init>", "(Lcom/box/android/domain/models/item/ItemModel;)V", "getItemModel", "()Lcom/box/android/domain/models/item/ItemModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ItemMoreActionsMenu extends OuterDestination {
            public static final int $stable = 8;
            private final ItemModel itemModel;

            public static /* synthetic */ ItemMoreActionsMenu copy$default(ItemMoreActionsMenu itemMoreActionsMenu, ItemModel itemModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    itemModel = itemMoreActionsMenu.itemModel;
                }
                return itemMoreActionsMenu.copy(itemModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemModel getItemModel() {
                return this.itemModel;
            }

            public final ItemMoreActionsMenu copy(ItemModel itemModel) {
                Intrinsics.checkNotNullParameter(itemModel, "itemModel");
                return new ItemMoreActionsMenu(itemModel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ItemMoreActionsMenu) && Intrinsics.areEqual(this.itemModel, ((ItemMoreActionsMenu) other).itemModel);
            }

            public int hashCode() {
                return this.itemModel.hashCode();
            }

            public String toString() {
                return "ItemMoreActionsMenu(itemModel=" + this.itemModel + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ItemMoreActionsMenu(ItemModel itemModel) {
                super(null);
                Intrinsics.checkNotNullParameter(itemModel, "itemModel");
                this.itemModel = itemModel;
            }

            public final ItemModel getItemModel() {
                return this.itemModel;
            }
        }
    }

    /* JADX INFO: compiled from: SearchDestination.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/search/navigation/SearchDestination$Companion;", "", "<init>", "()V", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
