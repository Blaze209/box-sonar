package com.box.android.updates.di;

import android.content.Context;
import com.google.android.play.core.appupdate.AppUpdateManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class AppUpdatesModule_Companion_ProvideAppUpdateManagerFactory implements Factory<AppUpdateManager> {
    private final Provider<Context> contextProvider;

    private AppUpdatesModule_Companion_ProvideAppUpdateManagerFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AppUpdateManager get() {
        return provideAppUpdateManager(this.contextProvider.get());
    }

    public static AppUpdatesModule_Companion_ProvideAppUpdateManagerFactory create(Provider<Context> provider) {
        return new AppUpdatesModule_Companion_ProvideAppUpdateManagerFactory(provider);
    }

    public static AppUpdateManager provideAppUpdateManager(Context context) {
        return (AppUpdateManager) Preconditions.checkNotNullFromProvides(AppUpdatesModule.INSTANCE.provideAppUpdateManager(context));
    }
}
