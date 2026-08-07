package com.box.android.base.presentation.fragments;

import com.box.android.domain.identity.IUserContextManager;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class TabLayoutFragment_MembersInjector implements MembersInjector<TabLayoutFragment> {
    private final Provider<IUserContextManager> mUserContextManagerProvider;

    private TabLayoutFragment_MembersInjector(Provider<IUserContextManager> provider) {
        this.mUserContextManagerProvider = provider;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(TabLayoutFragment tabLayoutFragment) {
        injectMUserContextManager(tabLayoutFragment, this.mUserContextManagerProvider.get());
    }

    public static MembersInjector<TabLayoutFragment> create(Provider<IUserContextManager> provider) {
        return new TabLayoutFragment_MembersInjector(provider);
    }

    public static void injectMUserContextManager(TabLayoutFragment tabLayoutFragment, IUserContextManager iUserContextManager) {
        tabLayoutFragment.mUserContextManager = iUserContextManager;
    }
}
