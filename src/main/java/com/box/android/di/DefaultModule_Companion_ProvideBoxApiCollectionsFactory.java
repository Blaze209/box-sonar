package com.box.android.di;

import android.content.Context;
import com.box.android.domain.identity.IUserContextManager;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiCollections;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DefaultModule_Companion_ProvideBoxApiCollectionsFactory implements Factory<BoxExtendedApiCollections> {
    private final Provider<Context> contextProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private DefaultModule_Companion_ProvideBoxApiCollectionsFactory(Provider<IUserContextManager> provider, Provider<Context> provider2) {
        this.userContextManagerProvider = provider;
        this.contextProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxExtendedApiCollections get() {
        return provideBoxApiCollections(this.userContextManagerProvider.get(), this.contextProvider.get());
    }

    public static DefaultModule_Companion_ProvideBoxApiCollectionsFactory create(Provider<IUserContextManager> provider, Provider<Context> provider2) {
        return new DefaultModule_Companion_ProvideBoxApiCollectionsFactory(provider, provider2);
    }

    public static BoxExtendedApiCollections provideBoxApiCollections(IUserContextManager iUserContextManager, Context context) {
        return (BoxExtendedApiCollections) Preconditions.checkNotNullFromProvides(DefaultModule.INSTANCE.provideBoxApiCollections(iUserContextManager, context));
    }
}
