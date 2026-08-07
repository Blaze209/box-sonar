package com.box.android.hubs.hubDetails.presentation;

import android.os.Bundle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.box.android.common.utilities.ViewModelAssistedFactory;
import com.box.android.cpl.IStoreFactory;
import com.box.android.cpl.Store;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HubDetailsViewModel.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0002\u0010\u0011B#\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/box/android/hubs/hubDetails/presentation/HubDetailsViewModel;", "Landroidx/lifecycle/ViewModel;", "args", "Landroid/os/Bundle;", "storeFactory", "Lcom/box/android/cpl/IStoreFactory;", "environment", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsEnvironment;", "<init>", "(Landroid/os/Bundle;Lcom/box/android/cpl/IStoreFactory;Lcom/box/android/hubs/hubDetails/presentation/HubDetailsEnvironment;)V", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$State;", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsReducer$Action;", "getStore", "()Lcom/box/android/cpl/Store;", "Factory", "Companion", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HubDetailsViewModel extends ViewModel {
    public static final String VM_HUB_ID_KEY = "VM_HUB_ID_KEY";
    private final Bundle args;
    private final Store<HubDetailsReducer.State, HubDetailsReducer.Action> store;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: HubDetailsViewModel.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003À\u0006\u0003"}, d2 = {"Lcom/box/android/hubs/hubDetails/presentation/HubDetailsViewModel$Factory;", "Lcom/box/android/common/utilities/ViewModelAssistedFactory;", "Lcom/box/android/hubs/hubDetails/presentation/HubDetailsViewModel;", "hubs_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @AssistedFactory
    public interface Factory extends ViewModelAssistedFactory<HubDetailsViewModel> {
    }

    @AssistedInject
    public HubDetailsViewModel(@Assisted Bundle args, IStoreFactory storeFactory, HubDetailsEnvironment environment) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(storeFactory, "storeFactory");
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.args = args;
        String string = args.getString(VM_HUB_ID_KEY);
        Intrinsics.checkNotNull(string);
        this.store = storeFactory.create(new HubDetailsReducer.State(string, HubDetailsReducer.ScreenState.Initializing.INSTANCE, null, 4, null), new HubDetailsReducer(environment), ViewModelKt.getViewModelScope(this));
    }

    public final Store<HubDetailsReducer.State, HubDetailsReducer.Action> getStore() {
        return this.store;
    }
}
