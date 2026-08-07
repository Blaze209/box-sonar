package com.box.android.di;

import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.LocalSortPreferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DefaultModule_Companion_ProvidesSortPreferencesFactory implements Factory<LocalSortPreferences> {
    private final Provider<IUserContextManager> userContextManagerProvider;

    private DefaultModule_Companion_ProvidesSortPreferencesFactory(Provider<IUserContextManager> provider) {
        this.userContextManagerProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public LocalSortPreferences get() {
        return providesSortPreferences(this.userContextManagerProvider.get());
    }

    public static DefaultModule_Companion_ProvidesSortPreferencesFactory create(Provider<IUserContextManager> provider) {
        return new DefaultModule_Companion_ProvidesSortPreferencesFactory(provider);
    }

    public static LocalSortPreferences providesSortPreferences(IUserContextManager iUserContextManager) {
        return (LocalSortPreferences) Preconditions.checkNotNullFromProvides(DefaultModule.INSTANCE.providesSortPreferences(iUserContextManager));
    }
}
