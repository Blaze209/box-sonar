package com.box.android.domain.usecases.collections;

import com.box.android.domain.services.IBaseModelControllerService;
import com.box.android.domain.services.ICaptureHistoryFilesService;
import com.box.android.domain.services.ICollectionsService;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiWeblink;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class CollectionMembershipsInteractor_Factory implements Factory<CollectionMembershipsInteractor> {
    private final Provider<IBaseModelControllerService> baseModelControllerServiceProvider;
    private final Provider<BoxExtendedApiFile> boxExtendedApiFileProvider;
    private final Provider<BoxExtendedApiFolder> boxExtendedApiFolderProvider;
    private final Provider<BoxExtendedApiWeblink> boxExtendedApiWeblinkProvider;
    private final Provider<ICaptureHistoryFilesService> captureHistoryFilesServiceProvider;
    private final Provider<ICollectionsService> collectionsServiceProvider;

    private CollectionMembershipsInteractor_Factory(Provider<ICollectionsService> provider, Provider<BoxExtendedApiFile> provider2, Provider<BoxExtendedApiFolder> provider3, Provider<BoxExtendedApiWeblink> provider4, Provider<IBaseModelControllerService> provider5, Provider<ICaptureHistoryFilesService> provider6) {
        this.collectionsServiceProvider = provider;
        this.boxExtendedApiFileProvider = provider2;
        this.boxExtendedApiFolderProvider = provider3;
        this.boxExtendedApiWeblinkProvider = provider4;
        this.baseModelControllerServiceProvider = provider5;
        this.captureHistoryFilesServiceProvider = provider6;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CollectionMembershipsInteractor get() {
        return newInstance(this.collectionsServiceProvider.get(), this.boxExtendedApiFileProvider.get(), this.boxExtendedApiFolderProvider.get(), this.boxExtendedApiWeblinkProvider.get(), this.baseModelControllerServiceProvider.get(), this.captureHistoryFilesServiceProvider.get());
    }

    public static CollectionMembershipsInteractor_Factory create(Provider<ICollectionsService> provider, Provider<BoxExtendedApiFile> provider2, Provider<BoxExtendedApiFolder> provider3, Provider<BoxExtendedApiWeblink> provider4, Provider<IBaseModelControllerService> provider5, Provider<ICaptureHistoryFilesService> provider6) {
        return new CollectionMembershipsInteractor_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static CollectionMembershipsInteractor newInstance(ICollectionsService iCollectionsService, BoxExtendedApiFile boxExtendedApiFile, BoxExtendedApiFolder boxExtendedApiFolder, BoxExtendedApiWeblink boxExtendedApiWeblink, IBaseModelControllerService iBaseModelControllerService, ICaptureHistoryFilesService iCaptureHistoryFilesService) {
        return new CollectionMembershipsInteractor(iCollectionsService, boxExtendedApiFile, boxExtendedApiFolder, boxExtendedApiWeblink, iBaseModelControllerService, iCaptureHistoryFilesService);
    }
}
