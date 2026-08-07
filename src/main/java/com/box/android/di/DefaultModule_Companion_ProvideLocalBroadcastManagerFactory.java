package com.box.android.di;

import android.content.Context;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DefaultModule_Companion_ProvideLocalBroadcastManagerFactory implements Factory<LocalBroadcastManager> {
    private final Provider<Context> contextProvider;

    private DefaultModule_Companion_ProvideLocalBroadcastManagerFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public LocalBroadcastManager get() {
        return provideLocalBroadcastManager(this.contextProvider.get());
    }

    public static DefaultModule_Companion_ProvideLocalBroadcastManagerFactory create(Provider<Context> provider) {
        return new DefaultModule_Companion_ProvideLocalBroadcastManagerFactory(provider);
    }

    public static LocalBroadcastManager provideLocalBroadcastManager(Context context) {
        return (LocalBroadcastManager) Preconditions.checkNotNullFromProvides(DefaultModule.INSTANCE.provideLocalBroadcastManager(context));
    }
}
