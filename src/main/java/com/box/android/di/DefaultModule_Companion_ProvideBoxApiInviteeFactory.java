package com.box.android.di;

import android.content.Context;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.requests.BoxApiInvitee;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DefaultModule_Companion_ProvideBoxApiInviteeFactory implements Factory<BoxApiInvitee> {
    private final Provider<Context> contextProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private DefaultModule_Companion_ProvideBoxApiInviteeFactory(Provider<IUserContextManager> provider, Provider<Context> provider2) {
        this.userContextManagerProvider = provider;
        this.contextProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxApiInvitee get() {
        return provideBoxApiInvitee(this.userContextManagerProvider.get(), this.contextProvider.get());
    }

    public static DefaultModule_Companion_ProvideBoxApiInviteeFactory create(Provider<IUserContextManager> provider, Provider<Context> provider2) {
        return new DefaultModule_Companion_ProvideBoxApiInviteeFactory(provider, provider2);
    }

    public static BoxApiInvitee provideBoxApiInvitee(IUserContextManager iUserContextManager, Context context) {
        return (BoxApiInvitee) Preconditions.checkNotNullFromProvides(DefaultModule.INSTANCE.provideBoxApiInvitee(iUserContextManager, context));
    }
}
