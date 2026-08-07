package com.box.android.coreservices.modelcontroller;

import android.content.Context;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import dagger.internal.Factory;
import dagger.internal.Provider;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes9.dex */
public final class MoCoBoxGlobalSettings_Factory implements Factory<MoCoBoxGlobalSettings> {
    private final Provider<Context> contextProvider;
    private final Provider<ThreadPoolExecutor> globalExecutorProvider;
    private final Provider<ILocalSharedPreferences> localSharedPreferencesProvider;

    private MoCoBoxGlobalSettings_Factory(Provider<Context> provider, Provider<ILocalSharedPreferences> provider2, Provider<ThreadPoolExecutor> provider3) {
        this.contextProvider = provider;
        this.localSharedPreferencesProvider = provider2;
        this.globalExecutorProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public MoCoBoxGlobalSettings get() {
        return newInstance(this.contextProvider.get(), this.localSharedPreferencesProvider.get(), this.globalExecutorProvider.get());
    }

    public static MoCoBoxGlobalSettings_Factory create(Provider<Context> provider, Provider<ILocalSharedPreferences> provider2, Provider<ThreadPoolExecutor> provider3) {
        return new MoCoBoxGlobalSettings_Factory(provider, provider2, provider3);
    }

    public static MoCoBoxGlobalSettings newInstance(Context context, ILocalSharedPreferences iLocalSharedPreferences, ThreadPoolExecutor threadPoolExecutor) {
        return new MoCoBoxGlobalSettings(context, iLocalSharedPreferences, threadPoolExecutor);
    }
}
