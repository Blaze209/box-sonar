package com.box.android.di;

import android.content.Context;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.requests.BoxApiFeatures;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DefaultModule_Companion_ProvideBoxApiFeaturesFactory implements Factory<BoxApiFeatures> {
    private final Provider<Context> contextProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private DefaultModule_Companion_ProvideBoxApiFeaturesFactory(Provider<IUserContextManager> provider, Provider<Context> provider2) {
        this.userContextManagerProvider = provider;
        this.contextProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxApiFeatures get() {
        return provideBoxApiFeatures(this.userContextManagerProvider.get(), this.contextProvider.get());
    }

    public static DefaultModule_Companion_ProvideBoxApiFeaturesFactory create(Provider<IUserContextManager> provider, Provider<Context> provider2) {
        return new DefaultModule_Companion_ProvideBoxApiFeaturesFactory(provider, provider2);
    }

    public static BoxApiFeatures provideBoxApiFeatures(IUserContextManager iUserContextManager, Context context) {
        return (BoxApiFeatures) Preconditions.checkNotNullFromProvides(DefaultModule.INSTANCE.provideBoxApiFeatures(iUserContextManager, context));
    }
}
