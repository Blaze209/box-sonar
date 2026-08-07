package com.box.android.search.presentation.vm;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.box.android.common.utilities.ViewModelAssistedFactory;
import com.box.android.cpl.IStoreFactory;
import com.box.android.cpl.Store;
import com.box.android.domain.models.hubs.HubsSort;
import com.box.android.domain.models.search.FilesSearchFilters;
import com.box.android.domain.models.search.SearchMode;
import com.box.android.search.analytics.BrowseSearchAnalytics;
import com.box.android.search.analytics.SearchAnalytics;
import com.box.android.search.navigation.SearchDestination;
import com.box.android.search.presentation.cpl.FilesSearchReducer;
import com.box.android.search.presentation.cpl.HubsSearchReducer;
import com.box.android.search.presentation.cpl.NotesSearchReducer;
import com.box.android.search.presentation.cpl.SearchEnvironment;
import com.box.android.search.presentation.cpl.SearchReducer;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchViewModel.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0017B+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/box/android/search/presentation/vm/SearchViewModel;", "Landroidx/lifecycle/ViewModel;", "storeFactory", "Lcom/box/android/cpl/IStoreFactory;", "searchEnvironment", "Lcom/box/android/search/presentation/cpl/SearchEnvironment;", "browseSearchAnalytics", "Lcom/box/android/search/analytics/BrowseSearchAnalytics;", "args", "Landroid/os/Bundle;", "<init>", "(Lcom/box/android/cpl/IStoreFactory;Lcom/box/android/search/presentation/cpl/SearchEnvironment;Lcom/box/android/search/analytics/BrowseSearchAnalytics;Landroid/os/Bundle;)V", "searchMode", "Lcom/box/android/domain/models/search/SearchMode;", "aiCenterEnabled", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/search/presentation/cpl/SearchReducer$State;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action;", "getStore", "()Lcom/box/android/cpl/Store;", "isAiSearchEnabled", "Factory", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SearchViewModel extends ViewModel {
    public static final int $stable = 8;
    private final boolean aiCenterEnabled;
    private final SearchMode searchMode;
    private final Store<SearchReducer.State, SearchReducer.Action> store;

    /* JADX INFO: compiled from: SearchViewModel.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003À\u0006\u0003"}, d2 = {"Lcom/box/android/search/presentation/vm/SearchViewModel$Factory;", "Lcom/box/android/common/utilities/ViewModelAssistedFactory;", "Lcom/box/android/search/presentation/vm/SearchViewModel;", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @AssistedFactory
    public interface Factory extends ViewModelAssistedFactory<SearchViewModel> {
    }

    /* JADX WARN: Code duplicated, block: B:23:0x008c A[EDGE_INSN: B:23:0x008c->B:24:0x008d BREAK  A[LOOP:0: B:18:0x007a->B:46:?]] */
    @AssistedInject
    public SearchViewModel(IStoreFactory storeFactory, SearchEnvironment searchEnvironment, BrowseSearchAnalytics browseSearchAnalytics, @Assisted Bundle args) {
        Parcelable parcelable;
        boolean z;
        NotesSearchReducer.State state;
        Parcelable parcelable2;
        SearchAnalytics browseSearchAnalytics2 = browseSearchAnalytics;
        Intrinsics.checkNotNullParameter(storeFactory, "storeFactory");
        Intrinsics.checkNotNullParameter(searchEnvironment, "searchEnvironment");
        Intrinsics.checkNotNullParameter(browseSearchAnalytics2, "browseSearchAnalytics");
        Intrinsics.checkNotNullParameter(args, "args");
        HubsSort hubsSort = null;
        boolean z2 = false;
        boolean z3 = false;
        if (Build.VERSION.SDK_INT >= 33) {
            parcelable2 = (Parcelable) args.getParcelable(SearchDestination.InnerDestination.Search.SEARCH_MODE, SearchMode.class);
        } else {
            Parcelable parcelable3 = args.getParcelable(SearchDestination.InnerDestination.Search.SEARCH_MODE);
            parcelable = (SearchMode) (parcelable3 instanceof SearchMode ? parcelable3 : null);
        }
        if (parcelable != null) {
            this.searchMode = (SearchMode) parcelable;
            this.aiCenterEnabled = args.getBoolean("ai_center_enabled", true);
            List listListOf = CollectionsKt.listOf(this.searchMode);
            if (!args.getBoolean(SearchDestination.InnerDestination.Search.INCLUDE_RECENT_SHARED_LINKS, false)) {
                parcelable = parcelable2;
                parcelable = parcelable2;
                z = false;
                break;
            }
            List list = listListOf;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                parcelable = parcelable2;
                parcelable = parcelable2;
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        parcelable = parcelable2;
                        parcelable = parcelable2;
                        z = false;
                        break;
                    } else if (((SearchMode) it.next()) instanceof SearchMode.Files) {
                        z = true;
                        break;
                    }
                }
            } else {
                parcelable = parcelable2;
                parcelable = parcelable2;
                z = false;
                break;
            }
            SearchMode searchMode = this.searchMode;
            if (searchMode instanceof SearchMode.Hubs) {
                state = new HubsSearchReducer.State(hubsSort, z3 ? 1 : 0, 3, z2 ? 1 : 0);
            } else if (searchMode instanceof SearchMode.Files) {
                state = new FilesSearchReducer.State(((SearchMode.Files) this.searchMode).getParentFolder(), null, new FilesSearchFilters(null, null, null, 7, null), z, 2, null);
            } else {
                if (!(searchMode instanceof SearchMode.Notes)) {
                    throw new NoWhenBranchMatchedException();
                }
                state = NotesSearchReducer.State.INSTANCE;
            }
            this.store = storeFactory.create(new SearchReducer.State(state, z, "", 0, null, null, null, null, false, null, listListOf, isAiSearchEnabled(this.searchMode, searchEnvironment), null, null, 13304, null), new SearchReducer(searchEnvironment, this.searchMode instanceof SearchMode.Files ? browseSearchAnalytics2 : SearchAnalytics.NoOp.INSTANCE), ViewModelKt.getViewModelScope(this));
            return;
        }
        parcelable = parcelable2;
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final Store<SearchReducer.State, SearchReducer.Action> getStore() {
        return this.store;
    }

    private final boolean isAiSearchEnabled(SearchMode searchMode, SearchEnvironment searchEnvironment) {
        if (this.aiCenterEnabled) {
            return (searchMode instanceof SearchMode.Files) && searchEnvironment.getBoxAccountSettings().isAxCenterEnabled() && searchEnvironment.getFeatureFlips().getAxForSearch().getEnabled();
        }
        return false;
    }
}
