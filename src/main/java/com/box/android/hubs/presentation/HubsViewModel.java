package com.box.android.hubs.presentation;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.box.android.common.utilities.BuildConfigProvider;
import com.box.android.cpl.IStoreFactory;
import com.box.android.cpl.Store;
import com.box.android.domain.localrepo.HubsScreenPreferences;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HubsViewModel.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/box/android/hubs/presentation/HubsViewModel;", "Landroidx/lifecycle/ViewModel;", "hubsEnvironment", "Lcom/box/android/hubs/presentation/HubsEnvironment;", "storeFactory", "Lcom/box/android/cpl/IStoreFactory;", "<init>", "(Lcom/box/android/hubs/presentation/HubsEnvironment;Lcom/box/android/cpl/IStoreFactory;)V", "hubsScreenPreferences", "Lcom/box/android/domain/localrepo/HubsScreenPreferences;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/hubs/presentation/HubsReducer$State;", "Lcom/box/android/hubs/presentation/HubsReducer$Action;", "getStore", "()Lcom/box/android/cpl/Store;", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HubsViewModel extends ViewModel {
    public static final int $stable = 8;
    private final HubsScreenPreferences hubsScreenPreferences;
    private final Store<HubsReducer.State, HubsReducer.Action> store;

    /* JADX WARN: Multi-variable type inference failed */
    @Inject
    public HubsViewModel(HubsEnvironment hubsEnvironment, IStoreFactory storeFactory) {
        Intrinsics.checkNotNullParameter(hubsEnvironment, "hubsEnvironment");
        Intrinsics.checkNotNullParameter(storeFactory, "storeFactory");
        HubsScreenPreferences hubsScreenPreferences = hubsEnvironment.getHubsScreenPreferences();
        this.hubsScreenPreferences = hubsScreenPreferences;
        this.store = storeFactory.create(new HubsReducer.State(null, hubsScreenPreferences.getSortBy(), hubsScreenPreferences.getSortDirection(), hubsScreenPreferences.getScreenModePreference(), null, null, false, BuildConfigProvider.INSTANCE.isDebugBuild(), null, null, 881, null), new HubsReducer(hubsEnvironment, 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0), ViewModelKt.getViewModelScope(this));
    }

    public final Store<HubsReducer.State, HubsReducer.Action> getStore() {
        return this.store;
    }
}
