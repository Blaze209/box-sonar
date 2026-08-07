package com.box.android.browse.cpl;

import com.box.android.browse.cpl.itempicker.RecentItemPickerEnvironment;
import com.box.android.cpl.IStoreFactory;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class RecentsItemPickerViewModel_Factory implements Factory<RecentsItemPickerViewModel> {
    private final Provider<RecentItemPickerEnvironment> environmentProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private RecentsItemPickerViewModel_Factory(Provider<RecentItemPickerEnvironment> provider, Provider<IStoreFactory> provider2) {
        this.environmentProvider = provider;
        this.storeFactoryProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RecentsItemPickerViewModel get() {
        return newInstance(this.environmentProvider.get(), this.storeFactoryProvider.get());
    }

    public static RecentsItemPickerViewModel_Factory create(Provider<RecentItemPickerEnvironment> provider, Provider<IStoreFactory> provider2) {
        return new RecentsItemPickerViewModel_Factory(provider, provider2);
    }

    public static RecentsItemPickerViewModel newInstance(RecentItemPickerEnvironment recentItemPickerEnvironment, IStoreFactory iStoreFactory) {
        return new RecentsItemPickerViewModel(recentItemPickerEnvironment, iStoreFactory);
    }
}
