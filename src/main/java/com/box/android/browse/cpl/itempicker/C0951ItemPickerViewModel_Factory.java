package com.box.android.browse.cpl.itempicker;

import android.os.Bundle;
import com.box.android.cpl.IStoreFactory;
import dagger.internal.Provider;

/* JADX INFO: renamed from: com.box.android.browse.cpl.itempicker.ItemPickerViewModel_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C0951ItemPickerViewModel_Factory {
    private final Provider<FolderItemPickerEnvironment> environmentProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private C0951ItemPickerViewModel_Factory(Provider<FolderItemPickerEnvironment> provider, Provider<IStoreFactory> provider2) {
        this.environmentProvider = provider;
        this.storeFactoryProvider = provider2;
    }

    public ItemPickerViewModel get(Bundle bundle) {
        return newInstance(bundle, this.environmentProvider.get(), this.storeFactoryProvider.get());
    }

    public static C0951ItemPickerViewModel_Factory create(Provider<FolderItemPickerEnvironment> provider, Provider<IStoreFactory> provider2) {
        return new C0951ItemPickerViewModel_Factory(provider, provider2);
    }

    public static ItemPickerViewModel newInstance(Bundle bundle, FolderItemPickerEnvironment folderItemPickerEnvironment, IStoreFactory iStoreFactory) {
        return new ItemPickerViewModel(bundle, folderItemPickerEnvironment, iStoreFactory);
    }
}
