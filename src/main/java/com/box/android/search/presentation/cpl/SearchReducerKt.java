package com.box.android.search.presentation.cpl;

import com.box.android.domain.models.search.SearchMode;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchReducer.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0001*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"hasRecents", "", "Lcom/box/android/search/presentation/cpl/SearchReducer$State;", "getHasRecents", "(Lcom/box/android/search/presentation/cpl/SearchReducer$State;)Z", "supportsRecentAiSessions", "Lcom/box/android/domain/models/search/SearchMode;", "getSupportsRecentAiSessions", "(Lcom/box/android/domain/models/search/SearchMode;)Z", "search_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SearchReducerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getHasRecents(SearchReducer.State state) {
        if (state.getRecentQueries().isEmpty()) {
            return getSupportsRecentAiSessions(SearchModeStateKt.toSearchMode(state.getSearchModeState())) && !state.getRecentAiSessions().isEmpty();
        }
        return true;
    }

    private static final boolean getSupportsRecentAiSessions(SearchMode searchMode) {
        return searchMode instanceof SearchMode.Files;
    }
}
