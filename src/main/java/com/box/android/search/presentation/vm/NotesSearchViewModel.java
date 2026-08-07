package com.box.android.search.presentation.vm;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.box.android.cpl.IStoreFactory;
import com.box.android.cpl.Store;
import com.box.android.domain.models.search.SearchMode;
import com.box.android.search.presentation.cpl.NotesSearchReducer;
import com.box.android.search.presentation.cpl.SearchEnvironment;
import com.box.android.search.presentation.cpl.SearchReducer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotesSearchViewModel.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/box/android/search/presentation/vm/NotesSearchViewModel;", "Landroidx/lifecycle/ViewModel;", "storeFactory", "Lcom/box/android/cpl/IStoreFactory;", "searchEnvironment", "Lcom/box/android/search/presentation/cpl/SearchEnvironment;", "<init>", "(Lcom/box/android/cpl/IStoreFactory;Lcom/box/android/search/presentation/cpl/SearchEnvironment;)V", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/search/presentation/cpl/SearchReducer$State;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action;", "getStore", "()Lcom/box/android/cpl/Store;", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NotesSearchViewModel extends ViewModel {
    public static final int $stable = 8;
    private final Store<SearchReducer.State, SearchReducer.Action> store;

    /* JADX WARN: Multi-variable type inference failed */
    @Inject
    public NotesSearchViewModel(IStoreFactory storeFactory, SearchEnvironment searchEnvironment) {
        Intrinsics.checkNotNullParameter(storeFactory, "storeFactory");
        Intrinsics.checkNotNullParameter(searchEnvironment, "searchEnvironment");
        this.store = storeFactory.create(new SearchReducer.State(NotesSearchReducer.State.INSTANCE, false, "", 0, null, null, null, null, false, null, CollectionsKt.listOf(SearchMode.Notes.INSTANCE), false, null, null, 15354, null), new SearchReducer(searchEnvironment, null, 2, 0 == true ? 1 : 0), ViewModelKt.getViewModelScope(this));
    }

    public final Store<SearchReducer.State, SearchReducer.Action> getStore() {
        return this.store;
    }
}
