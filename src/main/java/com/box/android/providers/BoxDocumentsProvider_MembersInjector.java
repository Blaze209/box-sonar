package com.box.android.providers;

import com.box.android.base.presentation.ThumbnailManager;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.coreservices.modelcontroller.IMoCoBoxRecentEvents;
import com.box.android.coreservices.modelcontroller.IMoCoBoxTransfers;
import com.box.android.domain.controller.IBrowseController;
import com.box.android.domain.identity.IUserContextManager;
import com.box.androidsdk.content.BoxApiSearch;
import com.box.androidsdk.content.BoxApiUser;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class BoxDocumentsProvider_MembersInjector implements MembersInjector<BoxDocumentsProvider> {
    private final Provider<IBaseModelController> mBaseModelControllerProvider;
    private final Provider<BoxApiPrivate> mBoxApiPrivateProvider;
    private final Provider<BoxApiSearch> mBoxApiSearchProvider;
    private final Provider<BoxApiUser> mBoxApiUserProvider;
    private final Provider<BoxExtendedApiFile> mBoxExtendedApiFileProvider;
    private final Provider<BoxExtendedApiFolder> mBoxExtendedApiFolderProvider;
    private final Provider<IBrowseController> mBrowseControllerProvider;
    private final Provider<IMoCoBoxRecentEvents> mRecentEventsModelControllerProvider;
    private final Provider<ThumbnailManager> mThumbnailManagerProvider;
    private final Provider<IMoCoBoxTransfers> mTransfersModelControllerProvider;
    private final Provider<IUserContextManager> mUserContextManagerProvider;

    private BoxDocumentsProvider_MembersInjector(Provider<IUserContextManager> provider, Provider<IBaseModelController> provider2, Provider<IMoCoBoxTransfers> provider3, Provider<IMoCoBoxRecentEvents> provider4, Provider<BoxApiSearch> provider5, Provider<BoxApiUser> provider6, Provider<BoxExtendedApiFile> provider7, Provider<BoxExtendedApiFolder> provider8, Provider<IBrowseController> provider9, Provider<ThumbnailManager> provider10, Provider<BoxApiPrivate> provider11) {
        this.mUserContextManagerProvider = provider;
        this.mBaseModelControllerProvider = provider2;
        this.mTransfersModelControllerProvider = provider3;
        this.mRecentEventsModelControllerProvider = provider4;
        this.mBoxApiSearchProvider = provider5;
        this.mBoxApiUserProvider = provider6;
        this.mBoxExtendedApiFileProvider = provider7;
        this.mBoxExtendedApiFolderProvider = provider8;
        this.mBrowseControllerProvider = provider9;
        this.mThumbnailManagerProvider = provider10;
        this.mBoxApiPrivateProvider = provider11;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(BoxDocumentsProvider boxDocumentsProvider) {
        injectMUserContextManager(boxDocumentsProvider, this.mUserContextManagerProvider.get());
        injectMBaseModelController(boxDocumentsProvider, this.mBaseModelControllerProvider.get());
        injectMTransfersModelController(boxDocumentsProvider, this.mTransfersModelControllerProvider.get());
        injectMRecentEventsModelController(boxDocumentsProvider, this.mRecentEventsModelControllerProvider.get());
        injectMBoxApiSearch(boxDocumentsProvider, this.mBoxApiSearchProvider.get());
        injectMBoxApiUser(boxDocumentsProvider, this.mBoxApiUserProvider.get());
        injectMBoxExtendedApiFile(boxDocumentsProvider, this.mBoxExtendedApiFileProvider.get());
        injectMBoxExtendedApiFolder(boxDocumentsProvider, this.mBoxExtendedApiFolderProvider.get());
        injectMBrowseController(boxDocumentsProvider, this.mBrowseControllerProvider.get());
        injectMThumbnailManager(boxDocumentsProvider, this.mThumbnailManagerProvider.get());
        injectMBoxApiPrivate(boxDocumentsProvider, this.mBoxApiPrivateProvider.get());
    }

    public static MembersInjector<BoxDocumentsProvider> create(Provider<IUserContextManager> provider, Provider<IBaseModelController> provider2, Provider<IMoCoBoxTransfers> provider3, Provider<IMoCoBoxRecentEvents> provider4, Provider<BoxApiSearch> provider5, Provider<BoxApiUser> provider6, Provider<BoxExtendedApiFile> provider7, Provider<BoxExtendedApiFolder> provider8, Provider<IBrowseController> provider9, Provider<ThumbnailManager> provider10, Provider<BoxApiPrivate> provider11) {
        return new BoxDocumentsProvider_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    public static void injectMUserContextManager(BoxDocumentsProvider boxDocumentsProvider, IUserContextManager iUserContextManager) {
        boxDocumentsProvider.mUserContextManager = iUserContextManager;
    }

    public static void injectMBaseModelController(BoxDocumentsProvider boxDocumentsProvider, IBaseModelController iBaseModelController) {
        boxDocumentsProvider.mBaseModelController = iBaseModelController;
    }

    public static void injectMTransfersModelController(BoxDocumentsProvider boxDocumentsProvider, IMoCoBoxTransfers iMoCoBoxTransfers) {
        boxDocumentsProvider.mTransfersModelController = iMoCoBoxTransfers;
    }

    public static void injectMRecentEventsModelController(BoxDocumentsProvider boxDocumentsProvider, IMoCoBoxRecentEvents iMoCoBoxRecentEvents) {
        boxDocumentsProvider.mRecentEventsModelController = iMoCoBoxRecentEvents;
    }

    public static void injectMBoxApiSearch(BoxDocumentsProvider boxDocumentsProvider, BoxApiSearch boxApiSearch) {
        boxDocumentsProvider.mBoxApiSearch = boxApiSearch;
    }

    public static void injectMBoxApiUser(BoxDocumentsProvider boxDocumentsProvider, BoxApiUser boxApiUser) {
        boxDocumentsProvider.mBoxApiUser = boxApiUser;
    }

    public static void injectMBoxExtendedApiFile(BoxDocumentsProvider boxDocumentsProvider, BoxExtendedApiFile boxExtendedApiFile) {
        boxDocumentsProvider.mBoxExtendedApiFile = boxExtendedApiFile;
    }

    public static void injectMBoxExtendedApiFolder(BoxDocumentsProvider boxDocumentsProvider, BoxExtendedApiFolder boxExtendedApiFolder) {
        boxDocumentsProvider.mBoxExtendedApiFolder = boxExtendedApiFolder;
    }

    public static void injectMBrowseController(BoxDocumentsProvider boxDocumentsProvider, IBrowseController iBrowseController) {
        boxDocumentsProvider.mBrowseController = iBrowseController;
    }

    public static void injectMThumbnailManager(BoxDocumentsProvider boxDocumentsProvider, ThumbnailManager thumbnailManager) {
        boxDocumentsProvider.mThumbnailManager = thumbnailManager;
    }

    public static void injectMBoxApiPrivate(BoxDocumentsProvider boxDocumentsProvider, BoxApiPrivate boxApiPrivate) {
        boxDocumentsProvider.mBoxApiPrivate = boxApiPrivate;
    }
}
