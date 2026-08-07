package com.box.android.base.presentation.views.menu;

import com.box.android.base.presentation.fragments.BottomSheetMenuFragment_MembersInjector;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class FolderSheetFragment_MembersInjector implements MembersInjector<FolderSheetFragment> {
    private final Provider<FeatureFlips> mFeatureFlipsProvider;
    private final Provider<FeatureFlips> mFeatureFlipsProvider2;
    private final Provider<IUserContextManager> mUserContextManagerProvider;

    private FolderSheetFragment_MembersInjector(Provider<IUserContextManager> provider, Provider<FeatureFlips> provider2, Provider<FeatureFlips> provider3) {
        this.mUserContextManagerProvider = provider;
        this.mFeatureFlipsProvider = provider2;
        this.mFeatureFlipsProvider2 = provider3;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(FolderSheetFragment folderSheetFragment) {
        BottomSheetMenuFragment_MembersInjector.injectMUserContextManager(folderSheetFragment, this.mUserContextManagerProvider.get());
        BottomSheetMenuFragment_MembersInjector.injectMFeatureFlips(folderSheetFragment, this.mFeatureFlipsProvider.get());
        injectMFeatureFlips(folderSheetFragment, this.mFeatureFlipsProvider2.get());
    }

    public static MembersInjector<FolderSheetFragment> create(Provider<IUserContextManager> provider, Provider<FeatureFlips> provider2, Provider<FeatureFlips> provider3) {
        return new FolderSheetFragment_MembersInjector(provider, provider2, provider3);
    }

    public static void injectMFeatureFlips(FolderSheetFragment folderSheetFragment, FeatureFlips featureFlips) {
        folderSheetFragment.mFeatureFlips = featureFlips;
    }
}
