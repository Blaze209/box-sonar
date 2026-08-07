package com.box.android.di;

import com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings;
import com.box.android.coreservices.modelcontroller.MoCoBoxGlobalSettings;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class BoxModule_Companion_ProvidesIMoCoBoxGlobalSettingsFactory implements Factory<IMoCoBoxGlobalSettings> {
    private final Provider<MoCoBoxGlobalSettings> mocoProvider;

    private BoxModule_Companion_ProvidesIMoCoBoxGlobalSettingsFactory(Provider<MoCoBoxGlobalSettings> provider) {
        this.mocoProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public IMoCoBoxGlobalSettings get() {
        return providesIMoCoBoxGlobalSettings(this.mocoProvider.get());
    }

    public static BoxModule_Companion_ProvidesIMoCoBoxGlobalSettingsFactory create(Provider<MoCoBoxGlobalSettings> provider) {
        return new BoxModule_Companion_ProvidesIMoCoBoxGlobalSettingsFactory(provider);
    }

    public static IMoCoBoxGlobalSettings providesIMoCoBoxGlobalSettings(MoCoBoxGlobalSettings moCoBoxGlobalSettings) {
        return (IMoCoBoxGlobalSettings) Preconditions.checkNotNullFromProvides(BoxModule.INSTANCE.providesIMoCoBoxGlobalSettings(moCoBoxGlobalSettings));
    }
}
