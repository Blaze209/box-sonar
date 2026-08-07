package com.box.android.di;

import android.content.Context;
import com.box.android.domain.identity.IUserContextManager;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DefaultModule_Companion_ProvideBoxExtendedApiFolderFactory implements Factory<BoxExtendedApiFolder> {
    private final Provider<Context> contextProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private DefaultModule_Companion_ProvideBoxExtendedApiFolderFactory(Provider<IUserContextManager> provider, Provider<Context> provider2) {
        this.userContextManagerProvider = provider;
        this.contextProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxExtendedApiFolder get() {
        return provideBoxExtendedApiFolder(this.userContextManagerProvider.get(), this.contextProvider.get());
    }

    public static DefaultModule_Companion_ProvideBoxExtendedApiFolderFactory create(Provider<IUserContextManager> provider, Provider<Context> provider2) {
        return new DefaultModule_Companion_ProvideBoxExtendedApiFolderFactory(provider, provider2);
    }

    public static BoxExtendedApiFolder provideBoxExtendedApiFolder(IUserContextManager iUserContextManager, Context context) {
        return (BoxExtendedApiFolder) Preconditions.checkNotNullFromProvides(DefaultModule.INSTANCE.provideBoxExtendedApiFolder(iUserContextManager, context));
    }
}
