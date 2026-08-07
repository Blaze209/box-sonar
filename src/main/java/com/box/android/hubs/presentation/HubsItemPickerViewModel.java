package com.box.android.hubs.presentation;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.box.android.base.presentation.multiselect.MultiselectReducer;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.cpl.IStoreFactory;
import com.box.android.cpl.Store;
import com.box.android.domain.models.ItemsScreenMode;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HubsItemPickerViewModel.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/box/android/hubs/presentation/HubsItemPickerViewModel;", "Landroidx/lifecycle/ViewModel;", "hubsEnvironment", "Lcom/box/android/hubs/presentation/HubsEnvironment;", "storeFactory", "Lcom/box/android/cpl/IStoreFactory;", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "<init>", "(Lcom/box/android/hubs/presentation/HubsEnvironment;Lcom/box/android/cpl/IStoreFactory;Lcom/box/android/coreservices/services/IntentServices;)V", "getIntentServices", "()Lcom/box/android/coreservices/services/IntentServices;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/hubs/presentation/HubsReducer$State;", "Lcom/box/android/hubs/presentation/HubsReducer$Action;", "getStore", "()Lcom/box/android/cpl/Store;", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HubsItemPickerViewModel extends ViewModel {
    public static final int $stable = 8;
    private final IntentServices intentServices;
    private final Store<HubsReducer.State, HubsReducer.Action> store;

    /* JADX WARN: Multi-variable type inference failed */
    @Inject
    public HubsItemPickerViewModel(HubsEnvironment hubsEnvironment, IStoreFactory storeFactory, IntentServices intentServices) {
        Intrinsics.checkNotNullParameter(hubsEnvironment, "hubsEnvironment");
        Intrinsics.checkNotNullParameter(storeFactory, "storeFactory");
        Intrinsics.checkNotNullParameter(intentServices, "intentServices");
        this.intentServices = intentServices;
        Store<HubsReducer.State, HubsReducer.Action> storeCreate = storeFactory.create(new HubsReducer.State(null, null, null, ItemsScreenMode.LIST, HubsReducer.ConfigBarMode.SORT_ONLY, null, false, false, null, null, 999, null), new HubsReducer(hubsEnvironment, null, 2, 0 == true ? 1 : 0), ViewModelKt.getViewModelScope(this));
        this.store = storeCreate;
        storeCreate.send(new HubsReducer.Action.Multiselect(MultiselectReducer.Action.StartMultiSelectMode.INSTANCE));
    }

    public final IntentServices getIntentServices() {
        return this.intentServices;
    }

    public final Store<HubsReducer.State, HubsReducer.Action> getStore() {
        return this.store;
    }
}
