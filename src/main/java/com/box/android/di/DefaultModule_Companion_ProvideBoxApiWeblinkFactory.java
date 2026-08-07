package com.box.android.di;

import android.content.Context;
import com.box.android.domain.identity.IUserContextManager;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiWeblink;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DefaultModule_Companion_ProvideBoxApiWeblinkFactory implements Factory<BoxExtendedApiWeblink> {
    private final Provider<Context> contextProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private DefaultModule_Companion_ProvideBoxApiWeblinkFactory(Provider<IUserContextManager> provider, Provider<Context> provider2) {
        this.userContextManagerProvider = provider;
        this.contextProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxExtendedApiWeblink get() {
        return provideBoxApiWeblink(this.userContextManagerProvider.get(), this.contextProvider.get());
    }

    public static DefaultModule_Companion_ProvideBoxApiWeblinkFactory create(Provider<IUserContextManager> provider, Provider<Context> provider2) {
        return new DefaultModule_Companion_ProvideBoxApiWeblinkFactory(provider, provider2);
    }

    public static BoxExtendedApiWeblink provideBoxApiWeblink(IUserContextManager iUserContextManager, Context context) {
        return (BoxExtendedApiWeblink) Preconditions.checkNotNullFromProvides(DefaultModule.INSTANCE.provideBoxApiWeblink(iUserContextManager, context));
    }
}
