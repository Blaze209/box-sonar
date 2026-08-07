package com.box.android.di;

import android.content.Context;
import com.box.android.application.UserContextMigration;
import com.box.android.domain.services.IAppRestrictionsManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DefaultModule_Companion_ProvideUserContextMigrationFactory implements Factory<UserContextMigration> {
    private final Provider<IAppRestrictionsManager> appRestrictionsManagerProvider;
    private final Provider<Context> contextProvider;

    private DefaultModule_Companion_ProvideUserContextMigrationFactory(Provider<Context> provider, Provider<IAppRestrictionsManager> provider2) {
        this.contextProvider = provider;
        this.appRestrictionsManagerProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UserContextMigration get() {
        return provideUserContextMigration(this.contextProvider.get(), this.appRestrictionsManagerProvider.get());
    }

    public static DefaultModule_Companion_ProvideUserContextMigrationFactory create(Provider<Context> provider, Provider<IAppRestrictionsManager> provider2) {
        return new DefaultModule_Companion_ProvideUserContextMigrationFactory(provider, provider2);
    }

    public static UserContextMigration provideUserContextMigration(Context context, IAppRestrictionsManager iAppRestrictionsManager) {
        return (UserContextMigration) Preconditions.checkNotNullFromProvides(DefaultModule.INSTANCE.provideUserContextMigration(context, iAppRestrictionsManager));
    }
}
