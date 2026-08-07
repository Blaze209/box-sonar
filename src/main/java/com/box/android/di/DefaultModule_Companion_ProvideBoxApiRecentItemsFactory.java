package com.box.android.di;

import android.content.Context;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.domain.identity.IUserContextManager;
import com.box.androidsdk.content.BoxApiRecentItems;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DefaultModule_Companion_ProvideBoxApiRecentItemsFactory implements Factory<BoxApiRecentItems> {
    private final Provider<Context> contextProvider;
    private final Provider<IntentServices> intentServicesProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private DefaultModule_Companion_ProvideBoxApiRecentItemsFactory(Provider<IUserContextManager> provider, Provider<IntentServices> provider2, Provider<Context> provider3) {
        this.userContextManagerProvider = provider;
        this.intentServicesProvider = provider2;
        this.contextProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxApiRecentItems get() {
        return provideBoxApiRecentItems(this.userContextManagerProvider.get(), this.intentServicesProvider.get(), this.contextProvider.get());
    }

    public static DefaultModule_Companion_ProvideBoxApiRecentItemsFactory create(Provider<IUserContextManager> provider, Provider<IntentServices> provider2, Provider<Context> provider3) {
        return new DefaultModule_Companion_ProvideBoxApiRecentItemsFactory(provider, provider2, provider3);
    }

    public static BoxApiRecentItems provideBoxApiRecentItems(IUserContextManager iUserContextManager, IntentServices intentServices, Context context) {
        return (BoxApiRecentItems) Preconditions.checkNotNullFromProvides(DefaultModule.INSTANCE.provideBoxApiRecentItems(iUserContextManager, intentServices, context));
    }
}
