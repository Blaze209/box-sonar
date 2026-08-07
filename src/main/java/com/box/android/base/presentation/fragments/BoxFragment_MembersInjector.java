package com.box.android.base.presentation.fragments;

import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.domain.identity.IUserContextManager;
import com.box.androidsdk.content.BoxApiUser;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class BoxFragment_MembersInjector implements MembersInjector<BoxFragment> {
    private final Provider<IBaseModelController> mBaseModelControllerProvider;
    private final Provider<BoxApiUser> mBoxApiUserProvider;
    private final Provider<IUserContextManager> mUserContextManagerProvider;

    private BoxFragment_MembersInjector(Provider<IBaseModelController> provider, Provider<BoxApiUser> provider2, Provider<IUserContextManager> provider3) {
        this.mBaseModelControllerProvider = provider;
        this.mBoxApiUserProvider = provider2;
        this.mUserContextManagerProvider = provider3;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(BoxFragment boxFragment) {
        injectMBaseModelController(boxFragment, this.mBaseModelControllerProvider.get());
        injectMBoxApiUser(boxFragment, this.mBoxApiUserProvider.get());
        injectMUserContextManager(boxFragment, this.mUserContextManagerProvider.get());
    }

    public static MembersInjector<BoxFragment> create(Provider<IBaseModelController> provider, Provider<BoxApiUser> provider2, Provider<IUserContextManager> provider3) {
        return new BoxFragment_MembersInjector(provider, provider2, provider3);
    }

    public static void injectMBaseModelController(BoxFragment boxFragment, IBaseModelController iBaseModelController) {
        boxFragment.mBaseModelController = iBaseModelController;
    }

    public static void injectMBoxApiUser(BoxFragment boxFragment, BoxApiUser boxApiUser) {
        boxFragment.mBoxApiUser = boxApiUser;
    }

    public static void injectMUserContextManager(BoxFragment boxFragment, IUserContextManager iUserContextManager) {
        boxFragment.mUserContextManager = iUserContextManager;
    }
}
