package com.box.android.di;

import android.content.Context;
import com.box.android.domain.identity.IUserContextManager;
import com.box.androidsdk.content.BoxApiSearch;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DefaultModule_Companion_ProvideBoxApiSearchFactory implements Factory<BoxApiSearch> {
    private final Provider<Context> contextProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private DefaultModule_Companion_ProvideBoxApiSearchFactory(Provider<IUserContextManager> provider, Provider<Context> provider2) {
        this.userContextManagerProvider = provider;
        this.contextProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxApiSearch get() {
        return provideBoxApiSearch(this.userContextManagerProvider.get(), this.contextProvider.get());
    }

    public static DefaultModule_Companion_ProvideBoxApiSearchFactory create(Provider<IUserContextManager> provider, Provider<Context> provider2) {
        return new DefaultModule_Companion_ProvideBoxApiSearchFactory(provider, provider2);
    }

    public static BoxApiSearch provideBoxApiSearch(IUserContextManager iUserContextManager, Context context) {
        return (BoxApiSearch) Preconditions.checkNotNullFromProvides(DefaultModule.INSTANCE.provideBoxApiSearch(iUserContextManager, context));
    }
}
