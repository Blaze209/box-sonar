package com.box.android.di;

import com.box.android.domain.identity.IUserContextManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes11.dex */
public final class BoxModule_Companion_ProvideThumbnailExecutorFactory implements Factory<ThreadPoolExecutor> {
    private final Provider<IUserContextManager> userContextManagerProvider;

    private BoxModule_Companion_ProvideThumbnailExecutorFactory(Provider<IUserContextManager> provider) {
        this.userContextManagerProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ThreadPoolExecutor get() {
        return provideThumbnailExecutor(this.userContextManagerProvider.get());
    }

    public static BoxModule_Companion_ProvideThumbnailExecutorFactory create(Provider<IUserContextManager> provider) {
        return new BoxModule_Companion_ProvideThumbnailExecutorFactory(provider);
    }

    public static ThreadPoolExecutor provideThumbnailExecutor(IUserContextManager iUserContextManager) {
        return (ThreadPoolExecutor) Preconditions.checkNotNullFromProvides(BoxModule.INSTANCE.provideThumbnailExecutor(iUserContextManager));
    }
}
