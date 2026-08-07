package com.box.android.data.service.impl;

import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.coreservices.modelcontroller.IMoCoBoxRecentEvents;
import com.box.android.data.datasource.RecentsRemoteDataSource;
import com.box.android.domain.controller.IPreviewController;
import com.box.android.domain.services.IdMappingService;
import com.box.androidsdk.content.BoxApiRecentItems;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiRecentItems;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class RecentsService_Factory implements Factory<RecentsService> {
    private final Provider<IBaseModelController> baseModelControllerProvider;
    private final Provider<BoxExtendedApiRecentItems> extendedRecentApiProvider;
    private final Provider<IdMappingService> idMappingServiceProvider;
    private final Provider<IMoCoBoxRecentEvents> mocoRecentEventsProvider;
    private final Provider<IPreviewController> previewControllerProvider;
    private final Provider<BoxApiRecentItems> recentApiProvider;
    private final Provider<RecentsRemoteDataSource> recentsRemoteDataSourceProvider;

    private RecentsService_Factory(Provider<RecentsRemoteDataSource> recentsRemoteDataSourceProvider, Provider<BoxExtendedApiRecentItems> extendedRecentApiProvider, Provider<BoxApiRecentItems> recentApiProvider, Provider<IBaseModelController> baseModelControllerProvider, Provider<IMoCoBoxRecentEvents> mocoRecentEventsProvider, Provider<IPreviewController> previewControllerProvider, Provider<IdMappingService> idMappingServiceProvider) {
        this.recentsRemoteDataSourceProvider = recentsRemoteDataSourceProvider;
        this.extendedRecentApiProvider = extendedRecentApiProvider;
        this.recentApiProvider = recentApiProvider;
        this.baseModelControllerProvider = baseModelControllerProvider;
        this.mocoRecentEventsProvider = mocoRecentEventsProvider;
        this.previewControllerProvider = previewControllerProvider;
        this.idMappingServiceProvider = idMappingServiceProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RecentsService get() {
        return newInstance(this.recentsRemoteDataSourceProvider.get(), this.extendedRecentApiProvider.get(), this.recentApiProvider.get(), this.baseModelControllerProvider.get(), this.mocoRecentEventsProvider.get(), this.previewControllerProvider.get(), this.idMappingServiceProvider.get());
    }

    public static RecentsService_Factory create(Provider<RecentsRemoteDataSource> recentsRemoteDataSourceProvider, Provider<BoxExtendedApiRecentItems> extendedRecentApiProvider, Provider<BoxApiRecentItems> recentApiProvider, Provider<IBaseModelController> baseModelControllerProvider, Provider<IMoCoBoxRecentEvents> mocoRecentEventsProvider, Provider<IPreviewController> previewControllerProvider, Provider<IdMappingService> idMappingServiceProvider) {
        return new RecentsService_Factory(recentsRemoteDataSourceProvider, extendedRecentApiProvider, recentApiProvider, baseModelControllerProvider, mocoRecentEventsProvider, previewControllerProvider, idMappingServiceProvider);
    }

    public static RecentsService newInstance(RecentsRemoteDataSource recentsRemoteDataSource, BoxExtendedApiRecentItems extendedRecentApi, BoxApiRecentItems recentApi, IBaseModelController baseModelController, IMoCoBoxRecentEvents mocoRecentEvents, IPreviewController previewController, IdMappingService idMappingService) {
        return new RecentsService(recentsRemoteDataSource, extendedRecentApi, recentApi, baseModelController, mocoRecentEvents, previewController, idMappingService);
    }
}
