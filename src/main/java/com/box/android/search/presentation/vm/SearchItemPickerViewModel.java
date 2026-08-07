package com.box.android.search.presentation.vm;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.box.android.base.presentation.multiselect.MultiselectReducer;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.cpl.IStoreFactory;
import com.box.android.cpl.Store;
import com.box.android.domain.models.ClientSettingsModel;
import com.box.android.domain.models.search.SearchMode;
import com.box.android.domain.utils.result.ResultKt;
import com.box.android.search.presentation.cpl.FilesSearchReducer;
import com.box.android.search.presentation.cpl.HubsSearchReducer;
import com.box.android.search.presentation.cpl.SearchEnvironment;
import com.box.android.search.presentation.cpl.SearchReducer;
import com.box.android.search.presentation.ui.SearchItemPickerNavArg;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchItemPickerViewModel.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/box/android/search/presentation/vm/SearchItemPickerViewModel;", "Landroidx/lifecycle/ViewModel;", "storeFactory", "Lcom/box/android/cpl/IStoreFactory;", "searchEnvironment", "Lcom/box/android/search/presentation/cpl/SearchEnvironment;", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "<init>", "(Lcom/box/android/cpl/IStoreFactory;Lcom/box/android/search/presentation/cpl/SearchEnvironment;Lcom/box/android/coreservices/services/IntentServices;Landroidx/lifecycle/SavedStateHandle;)V", "getIntentServices", "()Lcom/box/android/coreservices/services/IntentServices;", "searchMode", "Lcom/box/android/domain/models/search/SearchMode;", "enabledTabs", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/search/presentation/cpl/SearchReducer$State;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action;", "getStore", "()Lcom/box/android/cpl/Store;", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SearchItemPickerViewModel extends ViewModel {
    public static final int $stable = 8;
    private final List<SearchMode> enabledTabs;
    private final IntentServices intentServices;
    private final SearchMode searchMode;
    private final Store<SearchReducer.State, SearchReducer.Action> store;

    /* JADX WARN: Multi-variable type inference failed */
    @Inject
    public SearchItemPickerViewModel(IStoreFactory storeFactory, SearchEnvironment searchEnvironment, IntentServices intentServices, SavedStateHandle savedStateHandle) {
        FilesSearchReducer.State state;
        Intrinsics.checkNotNullParameter(storeFactory, "storeFactory");
        Intrinsics.checkNotNullParameter(searchEnvironment, "searchEnvironment");
        Intrinsics.checkNotNullParameter(intentServices, "intentServices");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        this.intentServices = intentServices;
        SearchMode searchModeFromName = SearchMode.INSTANCE.fromName((String) savedStateHandle.get(SearchItemPickerNavArg.INITIAL_SEARCH_MODE_KEY));
        this.searchMode = searchModeFromName;
        ClientSettingsModel clientSettingsModel = (ClientSettingsModel) ResultKt.getOrNull(searchEnvironment.getClientSettingsService().getClientSettingsLocal());
        int i = 1;
        boolean zAreEqual = clientSettingsModel != null ? Intrinsics.areEqual((Object) clientSettingsModel.isHubsAIEnabled(), (Object) true) : false;
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        listCreateListBuilder.add(new SearchMode.Files(null, i, null == true ? 1 : 0));
        if (zAreEqual) {
            listCreateListBuilder.add(SearchMode.Hubs.INSTANCE);
        }
        List<SearchMode> listBuild = CollectionsKt.build(listCreateListBuilder);
        this.enabledTabs = listBuild;
        if (searchModeFromName instanceof SearchMode.Hubs) {
            state = new HubsSearchReducer.State(null == true ? 1 : 0, null == true ? 1 : 0, 3, null == true ? 1 : 0);
        } else if (searchModeFromName instanceof SearchMode.Files) {
            state = new FilesSearchReducer.State(null, null, null, false, 15, null);
        } else {
            if (!(searchModeFromName instanceof SearchMode.Notes)) {
                throw new NoWhenBranchMatchedException();
            }
            state = new FilesSearchReducer.State(null, null, null, false, 15, null);
        }
        Store<SearchReducer.State, SearchReducer.Action> storeCreate = storeFactory.create(new SearchReducer.State(state, false, "", 0, null, null, null, null, false, null, listBuild, false, null, null, 15354, null), new SearchReducer(searchEnvironment, null == true ? 1 : 0, 2, null == true ? 1 : 0), ViewModelKt.getViewModelScope(this));
        this.store = storeCreate;
        storeCreate.send(new SearchReducer.Action.Multiselect(MultiselectReducer.Action.StartMultiSelectMode.INSTANCE));
    }

    public final IntentServices getIntentServices() {
        return this.intentServices;
    }

    public final Store<SearchReducer.State, SearchReducer.Action> getStore() {
        return this.store;
    }
}
