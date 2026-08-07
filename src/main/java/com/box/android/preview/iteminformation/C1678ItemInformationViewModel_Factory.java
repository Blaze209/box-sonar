package com.box.android.preview.iteminformation;

import android.os.Bundle;
import com.box.android.cpl.IStoreFactory;
import dagger.internal.Provider;

/* JADX INFO: renamed from: com.box.android.preview.iteminformation.ItemInformationViewModel_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes12.dex */
public final class C1678ItemInformationViewModel_Factory {
    private final Provider<ItemInformationEnvironment> environmentProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private C1678ItemInformationViewModel_Factory(Provider<ItemInformationEnvironment> provider, Provider<IStoreFactory> provider2) {
        this.environmentProvider = provider;
        this.storeFactoryProvider = provider2;
    }

    public ItemInformationViewModel get(Bundle bundle) {
        return newInstance(bundle, this.environmentProvider.get(), this.storeFactoryProvider.get());
    }

    public static C1678ItemInformationViewModel_Factory create(Provider<ItemInformationEnvironment> provider, Provider<IStoreFactory> provider2) {
        return new C1678ItemInformationViewModel_Factory(provider, provider2);
    }

    public static ItemInformationViewModel newInstance(Bundle bundle, ItemInformationEnvironment itemInformationEnvironment, IStoreFactory iStoreFactory) {
        return new ItemInformationViewModel(bundle, itemInformationEnvironment, iStoreFactory);
    }
}
