package com.box.android.search.presentation.ui;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.box.android.domain.models.search.SearchMode;
import com.box.android.search.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchScreen.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u0000 \u001d2\u00020\u0001:\u0004\u001a\u001b\u001c\u001dBO\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011\u0082\u0001\u0003\u001e\u001f ¨\u0006!"}, d2 = {"Lcom/box/android/search/presentation/ui/SearchModeConfig;", "", "searchMode", "Lcom/box/android/domain/models/search/SearchMode;", "emptyQueryDrawableRes", "", "searchBarHintRes", "emptyQueryTitleRes", "emptyQuerySubtitleRes", "recentQueriesTitleRes", "recentAiSessionsTitleRes", "tabNameRes", "<init>", "(Lcom/box/android/domain/models/search/SearchMode;IIIILjava/lang/Integer;Ljava/lang/Integer;I)V", "getSearchMode", "()Lcom/box/android/domain/models/search/SearchMode;", "getEmptyQueryDrawableRes", "()I", "getSearchBarHintRes", "getEmptyQueryTitleRes", "getEmptyQuerySubtitleRes", "getRecentQueriesTitleRes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRecentAiSessionsTitleRes", "getTabNameRes", "Hubs", "Files", "Notes", "Companion", "Lcom/box/android/search/presentation/ui/SearchModeConfig$Files;", "Lcom/box/android/search/presentation/ui/SearchModeConfig$Hubs;", "Lcom/box/android/search/presentation/ui/SearchModeConfig$Notes;", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
abstract class SearchModeConfig {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int emptyQueryDrawableRes;
    private final int emptyQuerySubtitleRes;
    private final int emptyQueryTitleRes;
    private final Integer recentAiSessionsTitleRes;
    private final Integer recentQueriesTitleRes;
    private final int searchBarHintRes;
    private final SearchMode searchMode;
    private final int tabNameRes;

    public /* synthetic */ SearchModeConfig(SearchMode searchMode, int i, int i2, int i3, int i4, Integer num, Integer num2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(searchMode, i, i2, i3, i4, num, num2, i5);
    }

    private SearchModeConfig(SearchMode searchMode, int i, int i2, int i3, int i4, Integer num, Integer num2, int i5) {
        this.searchMode = searchMode;
        this.emptyQueryDrawableRes = i;
        this.searchBarHintRes = i2;
        this.emptyQueryTitleRes = i3;
        this.emptyQuerySubtitleRes = i4;
        this.recentQueriesTitleRes = num;
        this.recentAiSessionsTitleRes = num2;
        this.tabNameRes = i5;
    }

    public /* synthetic */ SearchModeConfig(SearchMode searchMode, int i, int i2, int i3, int i4, Integer num, Integer num2, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(searchMode, i, i2, i3, i4, num, (i6 & 64) != 0 ? null : num2, i5, null);
    }

    public final SearchMode getSearchMode() {
        return this.searchMode;
    }

    public final int getEmptyQueryDrawableRes() {
        return this.emptyQueryDrawableRes;
    }

    public final int getSearchBarHintRes() {
        return this.searchBarHintRes;
    }

    public final int getEmptyQueryTitleRes() {
        return this.emptyQueryTitleRes;
    }

    public final int getEmptyQuerySubtitleRes() {
        return this.emptyQuerySubtitleRes;
    }

    public final Integer getRecentQueriesTitleRes() {
        return this.recentQueriesTitleRes;
    }

    public final Integer getRecentAiSessionsTitleRes() {
        return this.recentAiSessionsTitleRes;
    }

    public final int getTabNameRes() {
        return this.tabNameRes;
    }

    /* JADX INFO: compiled from: SearchScreen.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/search/presentation/ui/SearchModeConfig$Hubs;", "Lcom/box/android/search/presentation/ui/SearchModeConfig;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Hubs extends SearchModeConfig {
        public static final Hubs INSTANCE = new Hubs();
        public static final int $stable = 8;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Hubs)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -260816190;
        }

        public String toString() {
            return "Hubs";
        }

        private Hubs() {
            super(SearchMode.Hubs.INSTANCE, R.drawable.empty_hubs, R.string.default_search_hint, R.string.search_initial_title, R.string.search_initial_subtitle_hubs, Integer.valueOf(R.string.recent_hub_searches), null, R.string.hubs, 64, null);
        }
    }

    /* JADX INFO: compiled from: SearchScreen.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/search/presentation/ui/SearchModeConfig$Files;", "Lcom/box/android/search/presentation/ui/SearchModeConfig;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Files extends SearchModeConfig {
        public static final Files INSTANCE = new Files();
        public static final int $stable = 8;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Files)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 502437459;
        }

        public String toString() {
            return "Files";
        }

        private Files() {
            super(new SearchMode.Files(null, 1, null), R.drawable.ic_missing140, R.string.default_search_hint, R.string.search_initial_title, R.string.search_initial_subtitle_files, Integer.valueOf(R.string.recent_searches), Integer.valueOf(R.string.recent_ai_sessions), R.string.files, null);
        }
    }

    /* JADX INFO: compiled from: SearchScreen.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/search/presentation/ui/SearchModeConfig$Notes;", "Lcom/box/android/search/presentation/ui/SearchModeConfig;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Notes extends SearchModeConfig {
        public static final Notes INSTANCE = new Notes();
        public static final int $stable = 8;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Notes)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 510012061;
        }

        public String toString() {
            return "Notes";
        }

        private Notes() {
            super(SearchMode.Notes.INSTANCE, R.drawable.ic_missing140, R.string.search_notes_hint, R.string.search_initial_title_notes, R.string.search_initial_subtitle_notes, Integer.valueOf(R.string.recent_notes_searches), null, R.string.search_notes_tab, 64, null);
        }
    }

    /* JADX INFO: compiled from: SearchScreen.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/search/presentation/ui/SearchModeConfig$Companion;", "", "<init>", "()V", TypedValues.TransitionType.S_FROM, "Lcom/box/android/search/presentation/ui/SearchModeConfig;", "searchMode", "Lcom/box/android/domain/models/search/SearchMode;", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SearchModeConfig from(SearchMode searchMode) {
            Intrinsics.checkNotNullParameter(searchMode, "searchMode");
            if (searchMode instanceof SearchMode.Hubs) {
                return Hubs.INSTANCE;
            }
            if (searchMode instanceof SearchMode.Files) {
                return Files.INSTANCE;
            }
            if (searchMode instanceof SearchMode.Notes) {
                return Notes.INSTANCE;
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
