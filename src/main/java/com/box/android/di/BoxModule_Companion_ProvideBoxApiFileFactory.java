package com.box.android.di;

import android.content.Context;
import com.box.android.domain.identity.IUserContextManager;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class BoxModule_Companion_ProvideBoxApiFileFactory implements Factory<BoxExtendedApiFile> {
    private final Provider<Context> contextProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private BoxModule_Companion_ProvideBoxApiFileFactory(Provider<IUserContextManager> provider, Provider<Context> provider2) {
        this.userContextManagerProvider = provider;
        this.contextProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxExtendedApiFile get() {
        return provideBoxApiFile(this.userContextManagerProvider.get(), this.contextProvider.get());
    }

    public static BoxModule_Companion_ProvideBoxApiFileFactory create(Provider<IUserContextManager> provider, Provider<Context> provider2) {
        return new BoxModule_Companion_ProvideBoxApiFileFactory(provider, provider2);
    }

    public static BoxExtendedApiFile provideBoxApiFile(IUserContextManager iUserContextManager, Context context) {
        return (BoxExtendedApiFile) Preconditions.checkNotNullFromProvides(BoxModule.INSTANCE.provideBoxApiFile(iUserContextManager, context));
    }
}
