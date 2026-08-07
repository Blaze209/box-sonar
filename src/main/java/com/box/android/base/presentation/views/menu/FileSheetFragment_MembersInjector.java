package com.box.android.base.presentation.views.menu;

import com.box.android.base.presentation.ThumbnailManager;
import com.box.android.base.presentation.fragments.BottomSheetMenuFragment_MembersInjector;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.usecases.boxai.GetBoxAiAvailabilityUseCase;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class FileSheetFragment_MembersInjector implements MembersInjector<FileSheetFragment> {
    private final Provider<FeatureFlips> mFeatureFlipsProvider;
    private final Provider<FeatureFlips> mFeatureFlipsProvider2;
    private final Provider<GetBoxAiAvailabilityUseCase> mGetBoxAiAvailabilityUseCaseProvider;
    private final Provider<ThumbnailManager> mThumbnailManagerProvider;
    private final Provider<IUserContextManager> mUserContextManagerProvider;

    private FileSheetFragment_MembersInjector(Provider<IUserContextManager> provider, Provider<FeatureFlips> provider2, Provider<ThumbnailManager> provider3, Provider<GetBoxAiAvailabilityUseCase> provider4, Provider<FeatureFlips> provider5) {
        this.mUserContextManagerProvider = provider;
        this.mFeatureFlipsProvider = provider2;
        this.mThumbnailManagerProvider = provider3;
        this.mGetBoxAiAvailabilityUseCaseProvider = provider4;
        this.mFeatureFlipsProvider2 = provider5;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(FileSheetFragment fileSheetFragment) {
        BottomSheetMenuFragment_MembersInjector.injectMUserContextManager(fileSheetFragment, this.mUserContextManagerProvider.get());
        BottomSheetMenuFragment_MembersInjector.injectMFeatureFlips(fileSheetFragment, this.mFeatureFlipsProvider.get());
        injectMThumbnailManager(fileSheetFragment, this.mThumbnailManagerProvider.get());
        injectMGetBoxAiAvailabilityUseCase(fileSheetFragment, this.mGetBoxAiAvailabilityUseCaseProvider.get());
        injectMFeatureFlips(fileSheetFragment, this.mFeatureFlipsProvider2.get());
    }

    public static MembersInjector<FileSheetFragment> create(Provider<IUserContextManager> provider, Provider<FeatureFlips> provider2, Provider<ThumbnailManager> provider3, Provider<GetBoxAiAvailabilityUseCase> provider4, Provider<FeatureFlips> provider5) {
        return new FileSheetFragment_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    public static void injectMThumbnailManager(FileSheetFragment fileSheetFragment, ThumbnailManager thumbnailManager) {
        fileSheetFragment.mThumbnailManager = thumbnailManager;
    }

    public static void injectMGetBoxAiAvailabilityUseCase(FileSheetFragment fileSheetFragment, GetBoxAiAvailabilityUseCase getBoxAiAvailabilityUseCase) {
        fileSheetFragment.mGetBoxAiAvailabilityUseCase = getBoxAiAvailabilityUseCase;
    }

    public static void injectMFeatureFlips(FileSheetFragment fileSheetFragment, FeatureFlips featureFlips) {
        fileSheetFragment.mFeatureFlips = featureFlips;
    }
}
