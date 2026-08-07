package com.box.android.di;

import com.box.android.coreservices.modelcontroller.IMoCoAdminSettings;
import com.box.android.modelcontroller.MoCoAdminSettings;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DefaultModule_Companion_ProvideIMoCoAdminSettingsFactory implements Factory<IMoCoAdminSettings> {
    private final Provider<MoCoAdminSettings> mocoProvider;

    private DefaultModule_Companion_ProvideIMoCoAdminSettingsFactory(Provider<MoCoAdminSettings> provider) {
        this.mocoProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public IMoCoAdminSettings get() {
        return provideIMoCoAdminSettings(this.mocoProvider.get());
    }

    public static DefaultModule_Companion_ProvideIMoCoAdminSettingsFactory create(Provider<MoCoAdminSettings> provider) {
        return new DefaultModule_Companion_ProvideIMoCoAdminSettingsFactory(provider);
    }

    public static IMoCoAdminSettings provideIMoCoAdminSettings(MoCoAdminSettings moCoAdminSettings) {
        return (IMoCoAdminSettings) Preconditions.checkNotNullFromProvides(DefaultModule.INSTANCE.provideIMoCoAdminSettings(moCoAdminSettings));
    }
}
