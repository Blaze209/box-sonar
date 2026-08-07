package com.box.android.base.presentation.fragments;

import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class BottomSheetMenuFragment_MembersInjector implements MembersInjector<BottomSheetMenuFragment> {
    private final Provider<FeatureFlips> mFeatureFlipsProvider;
    private final Provider<IUserContextManager> mUserContextManagerProvider;

    private BottomSheetMenuFragment_MembersInjector(Provider<IUserContextManager> provider, Provider<FeatureFlips> provider2) {
        this.mUserContextManagerProvider = provider;
        this.mFeatureFlipsProvider = provider2;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(BottomSheetMenuFragment bottomSheetMenuFragment) {
        injectMUserContextManager(bottomSheetMenuFragment, this.mUserContextManagerProvider.get());
        injectMFeatureFlips(bottomSheetMenuFragment, this.mFeatureFlipsProvider.get());
    }

    public static MembersInjector<BottomSheetMenuFragment> create(Provider<IUserContextManager> provider, Provider<FeatureFlips> provider2) {
        return new BottomSheetMenuFragment_MembersInjector(provider, provider2);
    }

    public static void injectMUserContextManager(BottomSheetMenuFragment bottomSheetMenuFragment, IUserContextManager iUserContextManager) {
        bottomSheetMenuFragment.mUserContextManager = iUserContextManager;
    }

    public static void injectMFeatureFlips(BottomSheetMenuFragment bottomSheetMenuFragment, FeatureFlips featureFlips) {
        bottomSheetMenuFragment.mFeatureFlips = featureFlips;
    }
}
