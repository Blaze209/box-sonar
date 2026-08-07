package com.box.android.utilities;

import androidx.appcompat.app.AppCompatActivity;
import com.box.android.base.presentation.utilities.FTUXController;
import com.box.android.browse.utilities.CopyOrMoveHelper;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.coreservices.modelcontroller.IMoCoBoxTransfers;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.coreservices.utilities.FileActionsManager;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.services.IOfflineService;
import com.box.android.domain.usecases.collections.CollectionMembershipsInteractor;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiWeblink;
import dagger.internal.Provider;

/* JADX INFO: renamed from: com.box.android.utilities.ItemActionHandler_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class C1727ItemActionHandler_Factory {
    private final Provider<IBaseModelController> baseMocoProvider;
    private final Provider<BoxExtendedApiWeblink> boxExtendedApiBookmarkProvider;
    private final Provider<BoxExtendedApiFile> boxExtendedApiFileProvider;
    private final Provider<BoxExtendedApiFolder> boxExtendedApiFolderProvider;
    private final Provider<CollectionMembershipsInteractor> collectionMembershipsInteractorProvider;
    private final Provider<CopyOrMoveHelper> copyOrMoveHelperProvider;
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<FileActionsManager> fileActionsManagerProvider;
    private final Provider<FTUXController> ftuxControllerProvider;
    private final Provider<IntentServices> intentServicesProvider;
    private final Provider<ItemClickHandler.Factory> itemClickHandlerFactoryProvider;
    private final Provider<ILocalItemService> localItemServiceProvider;
    private final Provider<IOfflineService> offlineServiceProvider;
    private final Provider<IMoCoBoxTransfers> transfersModelControllerProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private C1727ItemActionHandler_Factory(Provider<CollectionMembershipsInteractor> provider, Provider<BoxExtendedApiFile> provider2, Provider<BoxExtendedApiFolder> provider3, Provider<BoxExtendedApiWeblink> provider4, Provider<IBaseModelController> provider5, Provider<IUserContextManager> provider6, Provider<FTUXController> provider7, Provider<FeatureFlips> provider8, Provider<CopyOrMoveHelper> provider9, Provider<IntentServices> provider10, Provider<IOfflineService> provider11, Provider<ILocalItemService> provider12, Provider<IMoCoBoxTransfers> provider13, Provider<FileActionsManager> provider14, Provider<ItemClickHandler.Factory> provider15) {
        this.collectionMembershipsInteractorProvider = provider;
        this.boxExtendedApiFileProvider = provider2;
        this.boxExtendedApiFolderProvider = provider3;
        this.boxExtendedApiBookmarkProvider = provider4;
        this.baseMocoProvider = provider5;
        this.userContextManagerProvider = provider6;
        this.ftuxControllerProvider = provider7;
        this.featureFlipsProvider = provider8;
        this.copyOrMoveHelperProvider = provider9;
        this.intentServicesProvider = provider10;
        this.offlineServiceProvider = provider11;
        this.localItemServiceProvider = provider12;
        this.transfersModelControllerProvider = provider13;
        this.fileActionsManagerProvider = provider14;
        this.itemClickHandlerFactoryProvider = provider15;
    }

    public ItemActionHandler get(AppCompatActivity appCompatActivity) {
        return newInstance(this.collectionMembershipsInteractorProvider.get(), this.boxExtendedApiFileProvider.get(), this.boxExtendedApiFolderProvider.get(), this.boxExtendedApiBookmarkProvider.get(), this.baseMocoProvider.get(), this.userContextManagerProvider.get(), this.ftuxControllerProvider.get(), this.featureFlipsProvider.get(), this.copyOrMoveHelperProvider.get(), this.intentServicesProvider.get(), this.offlineServiceProvider.get(), this.localItemServiceProvider.get(), this.transfersModelControllerProvider.get(), this.fileActionsManagerProvider.get(), this.itemClickHandlerFactoryProvider.get(), appCompatActivity);
    }

    public static C1727ItemActionHandler_Factory create(Provider<CollectionMembershipsInteractor> provider, Provider<BoxExtendedApiFile> provider2, Provider<BoxExtendedApiFolder> provider3, Provider<BoxExtendedApiWeblink> provider4, Provider<IBaseModelController> provider5, Provider<IUserContextManager> provider6, Provider<FTUXController> provider7, Provider<FeatureFlips> provider8, Provider<CopyOrMoveHelper> provider9, Provider<IntentServices> provider10, Provider<IOfflineService> provider11, Provider<ILocalItemService> provider12, Provider<IMoCoBoxTransfers> provider13, Provider<FileActionsManager> provider14, Provider<ItemClickHandler.Factory> provider15) {
        return new C1727ItemActionHandler_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15);
    }

    public static ItemActionHandler newInstance(CollectionMembershipsInteractor collectionMembershipsInteractor, BoxExtendedApiFile boxExtendedApiFile, BoxExtendedApiFolder boxExtendedApiFolder, BoxExtendedApiWeblink boxExtendedApiWeblink, IBaseModelController iBaseModelController, IUserContextManager iUserContextManager, FTUXController fTUXController, FeatureFlips featureFlips, CopyOrMoveHelper copyOrMoveHelper, IntentServices intentServices, IOfflineService iOfflineService, ILocalItemService iLocalItemService, IMoCoBoxTransfers iMoCoBoxTransfers, FileActionsManager fileActionsManager, ItemClickHandler.Factory factory, AppCompatActivity appCompatActivity) {
        return new ItemActionHandler(collectionMembershipsInteractor, boxExtendedApiFile, boxExtendedApiFolder, boxExtendedApiWeblink, iBaseModelController, iUserContextManager, fTUXController, featureFlips, copyOrMoveHelper, intentServices, iOfflineService, iLocalItemService, iMoCoBoxTransfers, fileActionsManager, factory, appCompatActivity);
    }
}
