package com.box.android.autoupload;

import com.box.android.base.presentation.fragments.BoxFragment_MembersInjector;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.data.service.impl.LocalItemService;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.androidsdk.content.BoxApiUser;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class AutoContentUploadFragment_MembersInjector implements MembersInjector<AutoContentUploadFragment> {
    private final Provider<AutoUploadSwitchListener.Factory> factoryProvider;
    private final Provider<IBaseModelController> mBaseModelControllerProvider;
    private final Provider<BoxApiUser> mBoxApiUserProvider;
    private final Provider<FeatureFlips> mFeatureFlipsProvider;
    private final Provider<BoxExtendedApiFolder> mFolderApiProvider;
    private final Provider<LocalItemService> mLocalItemServiceProvider;
    private final Provider<IUserContextManager> mUserContextManagerProvider;

    private AutoContentUploadFragment_MembersInjector(Provider<IBaseModelController> provider, Provider<BoxApiUser> provider2, Provider<IUserContextManager> provider3, Provider<BoxExtendedApiFolder> provider4, Provider<FeatureFlips> provider5, Provider<LocalItemService> provider6, Provider<AutoUploadSwitchListener.Factory> provider7) {
        this.mBaseModelControllerProvider = provider;
        this.mBoxApiUserProvider = provider2;
        this.mUserContextManagerProvider = provider3;
        this.mFolderApiProvider = provider4;
        this.mFeatureFlipsProvider = provider5;
        this.mLocalItemServiceProvider = provider6;
        this.factoryProvider = provider7;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(AutoContentUploadFragment autoContentUploadFragment) {
        BoxFragment_MembersInjector.injectMBaseModelController(autoContentUploadFragment, this.mBaseModelControllerProvider.get());
        BoxFragment_MembersInjector.injectMBoxApiUser(autoContentUploadFragment, this.mBoxApiUserProvider.get());
        BoxFragment_MembersInjector.injectMUserContextManager(autoContentUploadFragment, this.mUserContextManagerProvider.get());
        injectMFolderApi(autoContentUploadFragment, this.mFolderApiProvider.get());
        injectMFeatureFlips(autoContentUploadFragment, this.mFeatureFlipsProvider.get());
        injectMLocalItemService(autoContentUploadFragment, this.mLocalItemServiceProvider.get());
        injectFactory(autoContentUploadFragment, this.factoryProvider.get());
    }

    public static MembersInjector<AutoContentUploadFragment> create(Provider<IBaseModelController> provider, Provider<BoxApiUser> provider2, Provider<IUserContextManager> provider3, Provider<BoxExtendedApiFolder> provider4, Provider<FeatureFlips> provider5, Provider<LocalItemService> provider6, Provider<AutoUploadSwitchListener.Factory> provider7) {
        return new AutoContentUploadFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static void injectMFolderApi(AutoContentUploadFragment autoContentUploadFragment, BoxExtendedApiFolder boxExtendedApiFolder) {
        autoContentUploadFragment.mFolderApi = boxExtendedApiFolder;
    }

    public static void injectMFeatureFlips(AutoContentUploadFragment autoContentUploadFragment, FeatureFlips featureFlips) {
        autoContentUploadFragment.mFeatureFlips = featureFlips;
    }

    public static void injectMLocalItemService(AutoContentUploadFragment autoContentUploadFragment, LocalItemService localItemService) {
        autoContentUploadFragment.mLocalItemService = localItemService;
    }

    public static void injectFactory(AutoContentUploadFragment autoContentUploadFragment, AutoUploadSwitchListener.Factory factory) {
        autoContentUploadFragment.factory = factory;
    }
}
