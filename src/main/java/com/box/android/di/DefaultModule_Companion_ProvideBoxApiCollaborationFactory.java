package com.box.android.di;

import android.content.Context;
import com.box.android.domain.identity.IUserContextManager;
import com.box.androidsdk.content.BoxCache;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiCollaboration;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DefaultModule_Companion_ProvideBoxApiCollaborationFactory implements Factory<BoxExtendedApiCollaboration> {
    private final Provider<BoxCache> cacheProvider;
    private final Provider<Context> contextProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private DefaultModule_Companion_ProvideBoxApiCollaborationFactory(Provider<IUserContextManager> provider, Provider<BoxCache> provider2, Provider<Context> provider3) {
        this.userContextManagerProvider = provider;
        this.cacheProvider = provider2;
        this.contextProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxExtendedApiCollaboration get() {
        return provideBoxApiCollaboration(this.userContextManagerProvider.get(), this.cacheProvider.get(), this.contextProvider.get());
    }

    public static DefaultModule_Companion_ProvideBoxApiCollaborationFactory create(Provider<IUserContextManager> provider, Provider<BoxCache> provider2, Provider<Context> provider3) {
        return new DefaultModule_Companion_ProvideBoxApiCollaborationFactory(provider, provider2, provider3);
    }

    public static BoxExtendedApiCollaboration provideBoxApiCollaboration(IUserContextManager iUserContextManager, BoxCache boxCache, Context context) {
        return (BoxExtendedApiCollaboration) Preconditions.checkNotNullFromProvides(DefaultModule.INSTANCE.provideBoxApiCollaboration(iUserContextManager, boxCache, context));
    }
}
