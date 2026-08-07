package com.box.android.base.presentation.views.menu;

import com.box.android.base.presentation.ThumbnailManager;
import com.box.android.base.presentation.fragments.BottomSheetMenuFragment_MembersInjector;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class PushNotificationSheetFragment_MembersInjector implements MembersInjector<PushNotificationSheetFragment> {
    private final Provider<BoxExtendedApiFile> mBoxExtendedApiFileProvider;
    private final Provider<FeatureFlips> mFeatureFlipsProvider;
    private final Provider<ThumbnailManager> mThumbnailManagerProvider;
    private final Provider<IUserContextManager> mUserContextManagerProvider;
    private final Provider<IUserContextManager> mUserContextManagerProvider2;

    private PushNotificationSheetFragment_MembersInjector(Provider<IUserContextManager> provider, Provider<FeatureFlips> provider2, Provider<BoxExtendedApiFile> provider3, Provider<ThumbnailManager> provider4, Provider<IUserContextManager> provider5) {
        this.mUserContextManagerProvider = provider;
        this.mFeatureFlipsProvider = provider2;
        this.mBoxExtendedApiFileProvider = provider3;
        this.mThumbnailManagerProvider = provider4;
        this.mUserContextManagerProvider2 = provider5;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(PushNotificationSheetFragment pushNotificationSheetFragment) {
        BottomSheetMenuFragment_MembersInjector.injectMUserContextManager(pushNotificationSheetFragment, this.mUserContextManagerProvider.get());
        BottomSheetMenuFragment_MembersInjector.injectMFeatureFlips(pushNotificationSheetFragment, this.mFeatureFlipsProvider.get());
        injectMBoxExtendedApiFile(pushNotificationSheetFragment, this.mBoxExtendedApiFileProvider.get());
        injectMThumbnailManager(pushNotificationSheetFragment, this.mThumbnailManagerProvider.get());
        injectMUserContextManager(pushNotificationSheetFragment, this.mUserContextManagerProvider2.get());
    }

    public static MembersInjector<PushNotificationSheetFragment> create(Provider<IUserContextManager> provider, Provider<FeatureFlips> provider2, Provider<BoxExtendedApiFile> provider3, Provider<ThumbnailManager> provider4, Provider<IUserContextManager> provider5) {
        return new PushNotificationSheetFragment_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    public static void injectMBoxExtendedApiFile(PushNotificationSheetFragment pushNotificationSheetFragment, BoxExtendedApiFile boxExtendedApiFile) {
        pushNotificationSheetFragment.mBoxExtendedApiFile = boxExtendedApiFile;
    }

    public static void injectMThumbnailManager(PushNotificationSheetFragment pushNotificationSheetFragment, ThumbnailManager thumbnailManager) {
        pushNotificationSheetFragment.mThumbnailManager = thumbnailManager;
    }

    public static void injectMUserContextManager(PushNotificationSheetFragment pushNotificationSheetFragment, IUserContextManager iUserContextManager) {
        pushNotificationSheetFragment.mUserContextManager = iUserContextManager;
    }
}
