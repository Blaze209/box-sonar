package com.box.android.base.vm;

import android.app.Application;
import com.box.android.domain.identity.IUserContextManager;
import dagger.internal.Factory;
import dagger.internal.Provider;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes9.dex */
public final class BiometricsVM_Factory implements Factory<BiometricsVM> {
    private final Provider<Application> applicationProvider;
    private final Provider<ThreadPoolExecutor> executorProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private BiometricsVM_Factory(Provider<Application> provider, Provider<IUserContextManager> provider2, Provider<ThreadPoolExecutor> provider3) {
        this.applicationProvider = provider;
        this.userContextManagerProvider = provider2;
        this.executorProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BiometricsVM get() {
        return newInstance(this.applicationProvider.get(), this.userContextManagerProvider.get(), this.executorProvider.get());
    }

    public static BiometricsVM_Factory create(Provider<Application> provider, Provider<IUserContextManager> provider2, Provider<ThreadPoolExecutor> provider3) {
        return new BiometricsVM_Factory(provider, provider2, provider3);
    }

    public static BiometricsVM newInstance(Application application, IUserContextManager iUserContextManager, ThreadPoolExecutor threadPoolExecutor) {
        return new BiometricsVM(application, iUserContextManager, threadPoolExecutor);
    }
}
