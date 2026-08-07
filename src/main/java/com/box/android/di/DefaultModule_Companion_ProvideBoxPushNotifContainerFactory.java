package com.box.android.di;

import com.box.android.localrepo.LocalSharedPreferences;
import com.box.android.pushnotification.BoxPushNotifContainer;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DefaultModule_Companion_ProvideBoxPushNotifContainerFactory implements Factory<BoxPushNotifContainer> {
    private final Provider<LocalSharedPreferences> localSharedPreferencesProvider;

    private DefaultModule_Companion_ProvideBoxPushNotifContainerFactory(Provider<LocalSharedPreferences> provider) {
        this.localSharedPreferencesProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxPushNotifContainer get() {
        return provideBoxPushNotifContainer(this.localSharedPreferencesProvider.get());
    }

    public static DefaultModule_Companion_ProvideBoxPushNotifContainerFactory create(Provider<LocalSharedPreferences> provider) {
        return new DefaultModule_Companion_ProvideBoxPushNotifContainerFactory(provider);
    }

    public static BoxPushNotifContainer provideBoxPushNotifContainer(LocalSharedPreferences localSharedPreferences) {
        return (BoxPushNotifContainer) Preconditions.checkNotNullFromProvides(DefaultModule.INSTANCE.provideBoxPushNotifContainer(localSharedPreferences));
    }
}
