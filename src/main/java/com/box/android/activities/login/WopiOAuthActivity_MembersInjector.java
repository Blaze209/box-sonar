package com.box.android.activities.login;

import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.IBVEManager;
import com.box.android.domain.services.IForceUpdateCoordinator;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class WopiOAuthActivity_MembersInjector implements MembersInjector<WopiOAuthActivity> {
    private final Provider<IBVEManager> mBveManagerProvider;
    private final Provider<IUserContextManager> mUserContextManagerProvider;
    private final Provider<IForceUpdateCoordinator> p0Provider;

    private WopiOAuthActivity_MembersInjector(Provider<IUserContextManager> provider, Provider<IBVEManager> provider2, Provider<IForceUpdateCoordinator> provider3) {
        this.mUserContextManagerProvider = provider;
        this.mBveManagerProvider = provider2;
        this.p0Provider = provider3;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(WopiOAuthActivity wopiOAuthActivity) {
        injectMUserContextManager(wopiOAuthActivity, this.mUserContextManagerProvider.get());
        injectMBveManager(wopiOAuthActivity, this.mBveManagerProvider.get());
        injectSetForceUpdateCoordinator(wopiOAuthActivity, this.p0Provider.get());
    }

    public static MembersInjector<WopiOAuthActivity> create(Provider<IUserContextManager> provider, Provider<IBVEManager> provider2, Provider<IForceUpdateCoordinator> provider3) {
        return new WopiOAuthActivity_MembersInjector(provider, provider2, provider3);
    }

    public static void injectMUserContextManager(WopiOAuthActivity wopiOAuthActivity, IUserContextManager iUserContextManager) {
        wopiOAuthActivity.mUserContextManager = iUserContextManager;
    }

    public static void injectMBveManager(WopiOAuthActivity wopiOAuthActivity, IBVEManager iBVEManager) {
        wopiOAuthActivity.mBveManager = iBVEManager;
    }

    public static void injectSetForceUpdateCoordinator(WopiOAuthActivity wopiOAuthActivity, IForceUpdateCoordinator iForceUpdateCoordinator) {
        wopiOAuthActivity.setForceUpdateCoordinator(iForceUpdateCoordinator);
    }
}
