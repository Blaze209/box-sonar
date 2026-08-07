package com.box.android.di;

import android.content.Context;
import com.box.android.domain.identity.IUserContextManager;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiSearch;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DefaultModule_Companion_ProvideSearchApiFactory implements Factory<BoxExtendedApiSearch> {
    private final Provider<Context> contextProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private DefaultModule_Companion_ProvideSearchApiFactory(Provider<IUserContextManager> provider, Provider<Context> provider2) {
        this.userContextManagerProvider = provider;
        this.contextProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxExtendedApiSearch get() {
        return provideSearchApi(this.userContextManagerProvider.get(), this.contextProvider.get());
    }

    public static DefaultModule_Companion_ProvideSearchApiFactory create(Provider<IUserContextManager> provider, Provider<Context> provider2) {
        return new DefaultModule_Companion_ProvideSearchApiFactory(provider, provider2);
    }

    public static BoxExtendedApiSearch provideSearchApi(IUserContextManager iUserContextManager, Context context) {
        return (BoxExtendedApiSearch) Preconditions.checkNotNullFromProvides(DefaultModule.INSTANCE.provideSearchApi(iUserContextManager, context));
    }
}
