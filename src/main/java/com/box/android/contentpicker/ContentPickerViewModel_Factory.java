package com.box.android.contentpicker;

import com.box.android.cpl.IStoreFactory;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class ContentPickerViewModel_Factory implements Factory<ContentPickerViewModel> {
    private final Provider<ContentPickerEnvironment> environmentProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private ContentPickerViewModel_Factory(Provider<ContentPickerEnvironment> provider, Provider<IStoreFactory> provider2) {
        this.environmentProvider = provider;
        this.storeFactoryProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ContentPickerViewModel get() {
        return newInstance(this.environmentProvider.get(), this.storeFactoryProvider.get());
    }

    public static ContentPickerViewModel_Factory create(Provider<ContentPickerEnvironment> provider, Provider<IStoreFactory> provider2) {
        return new ContentPickerViewModel_Factory(provider, provider2);
    }

    public static ContentPickerViewModel newInstance(ContentPickerEnvironment contentPickerEnvironment, IStoreFactory iStoreFactory) {
        return new ContentPickerViewModel(contentPickerEnvironment, iStoreFactory);
    }
}
