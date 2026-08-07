package com.box.android.fragments.boxitem;

import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.domain.identity.IUserContextManager;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class PushNotificationsFragment_MembersInjector implements MembersInjector<PushNotificationsFragment> {
    private final Provider<IBaseModelController> mBaseMocoProvider;
    private final Provider<BoxApiPrivate> mBoxApiPrivateProvider;
    private final Provider<IUserContextManager> mUserContextManagerProvider;

    private PushNotificationsFragment_MembersInjector(Provider<IBaseModelController> provider, Provider<BoxApiPrivate> provider2, Provider<IUserContextManager> provider3) {
        this.mBaseMocoProvider = provider;
        this.mBoxApiPrivateProvider = provider2;
        this.mUserContextManagerProvider = provider3;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(PushNotificationsFragment pushNotificationsFragment) {
        injectMBaseMoco(pushNotificationsFragment, this.mBaseMocoProvider.get());
        injectMBoxApiPrivate(pushNotificationsFragment, this.mBoxApiPrivateProvider.get());
        injectMUserContextManager(pushNotificationsFragment, this.mUserContextManagerProvider.get());
    }

    public static MembersInjector<PushNotificationsFragment> create(Provider<IBaseModelController> provider, Provider<BoxApiPrivate> provider2, Provider<IUserContextManager> provider3) {
        return new PushNotificationsFragment_MembersInjector(provider, provider2, provider3);
    }

    public static void injectMBaseMoco(PushNotificationsFragment pushNotificationsFragment, IBaseModelController iBaseModelController) {
        pushNotificationsFragment.mBaseMoco = iBaseModelController;
    }

    public static void injectMBoxApiPrivate(PushNotificationsFragment pushNotificationsFragment, BoxApiPrivate boxApiPrivate) {
        pushNotificationsFragment.mBoxApiPrivate = boxApiPrivate;
    }

    public static void injectMUserContextManager(PushNotificationsFragment pushNotificationsFragment, IUserContextManager iUserContextManager) {
        pushNotificationsFragment.mUserContextManager = iUserContextManager;
    }
}
