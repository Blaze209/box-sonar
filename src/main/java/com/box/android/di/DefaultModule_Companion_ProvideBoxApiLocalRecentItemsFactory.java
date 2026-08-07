package com.box.android.di;

import android.content.Context;
import com.box.android.domain.identity.IUserContextManager;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiRecentItems;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DefaultModule_Companion_ProvideBoxApiLocalRecentItemsFactory implements Factory<BoxExtendedApiRecentItems> {
    private final Provider<Context> contextProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private DefaultModule_Companion_ProvideBoxApiLocalRecentItemsFactory(Provider<IUserContextManager> provider, Provider<Context> provider2) {
        this.userContextManagerProvider = provider;
        this.contextProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxExtendedApiRecentItems get() {
        return provideBoxApiLocalRecentItems(this.userContextManagerProvider.get(), this.contextProvider.get());
    }

    public static DefaultModule_Companion_ProvideBoxApiLocalRecentItemsFactory create(Provider<IUserContextManager> provider, Provider<Context> provider2) {
        return new DefaultModule_Companion_ProvideBoxApiLocalRecentItemsFactory(provider, provider2);
    }

    public static BoxExtendedApiRecentItems provideBoxApiLocalRecentItems(IUserContextManager iUserContextManager, Context context) {
        return (BoxExtendedApiRecentItems) Preconditions.checkNotNullFromProvides(DefaultModule.INSTANCE.provideBoxApiLocalRecentItems(iUserContextManager, context));
    }
}
