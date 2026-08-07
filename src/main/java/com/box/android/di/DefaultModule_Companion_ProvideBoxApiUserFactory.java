package com.box.android.di;

import android.content.Context;
import com.box.android.domain.identity.IUserContextManager;
import com.box.androidsdk.content.BoxApiUser;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DefaultModule_Companion_ProvideBoxApiUserFactory implements Factory<BoxApiUser> {
    private final Provider<Context> contextProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private DefaultModule_Companion_ProvideBoxApiUserFactory(Provider<IUserContextManager> provider, Provider<Context> provider2) {
        this.userContextManagerProvider = provider;
        this.contextProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxApiUser get() {
        return provideBoxApiUser(this.userContextManagerProvider.get(), this.contextProvider.get());
    }

    public static DefaultModule_Companion_ProvideBoxApiUserFactory create(Provider<IUserContextManager> provider, Provider<Context> provider2) {
        return new DefaultModule_Companion_ProvideBoxApiUserFactory(provider, provider2);
    }

    public static BoxApiUser provideBoxApiUser(IUserContextManager iUserContextManager, Context context) {
        return (BoxApiUser) Preconditions.checkNotNullFromProvides(DefaultModule.INSTANCE.provideBoxApiUser(iUserContextManager, context));
    }
}
