package com.box.android.base.presentation.views.menu;

import com.box.android.base.presentation.fragments.BottomSheetMenuFragment_MembersInjector;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.LocalSortPreferences;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class SortSheetFragment_MembersInjector implements MembersInjector<SortSheetFragment> {
    private final Provider<IBaseModelController> mBaseMocoProvider;
    private final Provider<FeatureFlips> mFeatureFlipsProvider;
    private final Provider<LocalSortPreferences> mSortPrefsProvider;
    private final Provider<IUserContextManager> mUserContextManagerProvider;

    private SortSheetFragment_MembersInjector(Provider<IUserContextManager> provider, Provider<FeatureFlips> provider2, Provider<LocalSortPreferences> provider3, Provider<IBaseModelController> provider4) {
        this.mUserContextManagerProvider = provider;
        this.mFeatureFlipsProvider = provider2;
        this.mSortPrefsProvider = provider3;
        this.mBaseMocoProvider = provider4;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(SortSheetFragment sortSheetFragment) {
        BottomSheetMenuFragment_MembersInjector.injectMUserContextManager(sortSheetFragment, this.mUserContextManagerProvider.get());
        BottomSheetMenuFragment_MembersInjector.injectMFeatureFlips(sortSheetFragment, this.mFeatureFlipsProvider.get());
        injectMSortPrefs(sortSheetFragment, this.mSortPrefsProvider.get());
        injectMBaseMoco(sortSheetFragment, this.mBaseMocoProvider.get());
    }

    public static MembersInjector<SortSheetFragment> create(Provider<IUserContextManager> provider, Provider<FeatureFlips> provider2, Provider<LocalSortPreferences> provider3, Provider<IBaseModelController> provider4) {
        return new SortSheetFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    public static void injectMSortPrefs(SortSheetFragment sortSheetFragment, LocalSortPreferences localSortPreferences) {
        sortSheetFragment.mSortPrefs = localSortPreferences;
    }

    public static void injectMBaseMoco(SortSheetFragment sortSheetFragment, IBaseModelController iBaseModelController) {
        sortSheetFragment.mBaseMoco = iBaseModelController;
    }
}
