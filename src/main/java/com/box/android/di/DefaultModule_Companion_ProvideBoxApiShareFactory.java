package com.box.android.di;

import android.content.Context;
import com.box.android.domain.identity.IUserContextManager;
import com.box.androidsdk.content.BoxApiShare;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DefaultModule_Companion_ProvideBoxApiShareFactory implements Factory<BoxApiShare> {
    private final Provider<Context> contextProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private DefaultModule_Companion_ProvideBoxApiShareFactory(Provider<IUserContextManager> provider, Provider<Context> provider2) {
        this.userContextManagerProvider = provider;
        this.contextProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxApiShare get() {
        return provideBoxApiShare(this.userContextManagerProvider.get(), this.contextProvider.get());
    }

    public static DefaultModule_Companion_ProvideBoxApiShareFactory create(Provider<IUserContextManager> provider, Provider<Context> provider2) {
        return new DefaultModule_Companion_ProvideBoxApiShareFactory(provider, provider2);
    }

    public static BoxApiShare provideBoxApiShare(IUserContextManager iUserContextManager, Context context) {
        return (BoxApiShare) Preconditions.checkNotNullFromProvides(DefaultModule.INSTANCE.provideBoxApiShare(iUserContextManager, context));
    }
}
