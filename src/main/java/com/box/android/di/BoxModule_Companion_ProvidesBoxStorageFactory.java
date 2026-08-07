package com.box.android.di;

import android.content.Context;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.IBoxStorage;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class BoxModule_Companion_ProvidesBoxStorageFactory implements Factory<IBoxStorage> {
    private final Provider<Context> contextProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private BoxModule_Companion_ProvidesBoxStorageFactory(Provider<Context> provider, Provider<IUserContextManager> provider2) {
        this.contextProvider = provider;
        this.userContextManagerProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public IBoxStorage get() {
        return providesBoxStorage(this.contextProvider.get(), this.userContextManagerProvider.get());
    }

    public static BoxModule_Companion_ProvidesBoxStorageFactory create(Provider<Context> provider, Provider<IUserContextManager> provider2) {
        return new BoxModule_Companion_ProvidesBoxStorageFactory(provider, provider2);
    }

    public static IBoxStorage providesBoxStorage(Context context, IUserContextManager iUserContextManager) {
        return (IBoxStorage) Preconditions.checkNotNullFromProvides(BoxModule.INSTANCE.providesBoxStorage(context, iUserContextManager));
    }
}
