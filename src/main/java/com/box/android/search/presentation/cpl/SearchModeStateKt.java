package com.box.android.search.presentation.cpl;

import com.box.android.domain.models.search.SearchMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchModeState.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toSearchMode", "Lcom/box/android/domain/models/search/SearchMode;", "Lcom/box/android/search/presentation/cpl/SearchModeState;", "search_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SearchModeStateKt {
    public static final SearchMode toSearchMode(SearchModeState searchModeState) {
        Intrinsics.checkNotNullParameter(searchModeState, "<this>");
        if (searchModeState instanceof HubsSearchReducer.State) {
            return SearchMode.Hubs.INSTANCE;
        }
        if (searchModeState instanceof FilesSearchReducer.State) {
            return new SearchMode.Files(((FilesSearchReducer.State) searchModeState).getParentFolder());
        }
        if (searchModeState instanceof NotesSearchReducer.State) {
            return SearchMode.Notes.INSTANCE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
