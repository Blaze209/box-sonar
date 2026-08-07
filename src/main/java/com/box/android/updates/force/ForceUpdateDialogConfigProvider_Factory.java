package com.box.android.updates.force;

import com.box.android.domain.configuration.IBoxAccountSettings;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class ForceUpdateDialogConfigProvider_Factory implements Factory<ForceUpdateDialogConfigProvider> {
    private final Provider<IBoxAccountSettings> accountSettingsProvider;

    private ForceUpdateDialogConfigProvider_Factory(Provider<IBoxAccountSettings> provider) {
        this.accountSettingsProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ForceUpdateDialogConfigProvider get() {
        return newInstance(this.accountSettingsProvider.get());
    }

    public static ForceUpdateDialogConfigProvider_Factory create(Provider<IBoxAccountSettings> provider) {
        return new ForceUpdateDialogConfigProvider_Factory(provider);
    }

    public static ForceUpdateDialogConfigProvider newInstance(IBoxAccountSettings iBoxAccountSettings) {
        return new ForceUpdateDialogConfigProvider(iBoxAccountSettings);
    }
}
