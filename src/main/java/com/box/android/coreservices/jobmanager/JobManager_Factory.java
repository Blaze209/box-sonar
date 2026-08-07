package com.box.android.coreservices.jobmanager;

import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.coreservices.modelcontroller.IMoCoAdminSettings;
import com.box.android.coreservices.modelcontroller.IMoCoBatchOperations;
import com.box.android.coreservices.modelcontroller.IMoCoBoxTransfers;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.coreservices.services.NotificationServices;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.metrics.Gen204MoveCopyEventLogger;
import com.box.android.domain.services.IRemoteItemService;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiCollaboration;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiWeblink;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class JobManager_Factory implements Factory<JobManager> {
    private final Provider<BoxExtendedApiCollaboration> apiCollaborationProvider;
    private final Provider<BoxApiPrivate> apiPrivateProvider;
    private final Provider<IBaseModelController> baseModelControllerProvider;
    private final Provider<BoxExtendedApiWeblink> bookmarkApiProvider;
    private final Provider<BoxExtendedApiFile> fileApiProvider;
    private final Provider<BoxExtendedApiFolder> folderApiProvider;
    private final Provider<IntentServices> intentServicesProvider;
    private final Provider<IRemoteItemService> itemServiceProvider;
    private final Provider<IJobManagerNotificationCenter> jobManagerNotificationCenterProvider;
    private final Provider<IMoCoAdminSettings> moCoAdminSettingsProvider;
    private final Provider<IMoCoBatchOperations> moCoBatchOperationsProvider;
    private final Provider<IMoCoBoxTransfers> moCoBoxTransfersProvider;
    private final Provider<Gen204MoveCopyEventLogger> moveCopyEventLoggerProvider;
    private final Provider<NotificationServices> notificationServicesProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private JobManager_Factory(Provider<IMoCoBoxTransfers> provider, Provider<BoxExtendedApiFile> provider2, Provider<BoxExtendedApiFolder> provider3, Provider<BoxExtendedApiWeblink> provider4, Provider<IBaseModelController> provider5, Provider<IUserContextManager> provider6, Provider<IMoCoBatchOperations> provider7, Provider<IMoCoAdminSettings> provider8, Provider<BoxApiPrivate> provider9, Provider<BoxExtendedApiCollaboration> provider10, Provider<NotificationServices> provider11, Provider<IRemoteItemService> provider12, Provider<IntentServices> provider13, Provider<IJobManagerNotificationCenter> provider14, Provider<Gen204MoveCopyEventLogger> provider15) {
        this.moCoBoxTransfersProvider = provider;
        this.fileApiProvider = provider2;
        this.folderApiProvider = provider3;
        this.bookmarkApiProvider = provider4;
        this.baseModelControllerProvider = provider5;
        this.userContextManagerProvider = provider6;
        this.moCoBatchOperationsProvider = provider7;
        this.moCoAdminSettingsProvider = provider8;
        this.apiPrivateProvider = provider9;
        this.apiCollaborationProvider = provider10;
        this.notificationServicesProvider = provider11;
        this.itemServiceProvider = provider12;
        this.intentServicesProvider = provider13;
        this.jobManagerNotificationCenterProvider = provider14;
        this.moveCopyEventLoggerProvider = provider15;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public JobManager get() {
        return newInstance(this.moCoBoxTransfersProvider.get(), this.fileApiProvider.get(), this.folderApiProvider.get(), this.bookmarkApiProvider.get(), this.baseModelControllerProvider.get(), this.userContextManagerProvider.get(), this.moCoBatchOperationsProvider.get(), this.moCoAdminSettingsProvider.get(), this.apiPrivateProvider.get(), this.apiCollaborationProvider.get(), this.notificationServicesProvider.get(), this.itemServiceProvider.get(), this.intentServicesProvider.get(), this.jobManagerNotificationCenterProvider.get(), this.moveCopyEventLoggerProvider.get());
    }

    public static JobManager_Factory create(Provider<IMoCoBoxTransfers> provider, Provider<BoxExtendedApiFile> provider2, Provider<BoxExtendedApiFolder> provider3, Provider<BoxExtendedApiWeblink> provider4, Provider<IBaseModelController> provider5, Provider<IUserContextManager> provider6, Provider<IMoCoBatchOperations> provider7, Provider<IMoCoAdminSettings> provider8, Provider<BoxApiPrivate> provider9, Provider<BoxExtendedApiCollaboration> provider10, Provider<NotificationServices> provider11, Provider<IRemoteItemService> provider12, Provider<IntentServices> provider13, Provider<IJobManagerNotificationCenter> provider14, Provider<Gen204MoveCopyEventLogger> provider15) {
        return new JobManager_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15);
    }

    public static JobManager newInstance(IMoCoBoxTransfers iMoCoBoxTransfers, BoxExtendedApiFile boxExtendedApiFile, BoxExtendedApiFolder boxExtendedApiFolder, BoxExtendedApiWeblink boxExtendedApiWeblink, IBaseModelController iBaseModelController, IUserContextManager iUserContextManager, IMoCoBatchOperations iMoCoBatchOperations, IMoCoAdminSettings iMoCoAdminSettings, BoxApiPrivate boxApiPrivate, BoxExtendedApiCollaboration boxExtendedApiCollaboration, NotificationServices notificationServices, IRemoteItemService iRemoteItemService, IntentServices intentServices, IJobManagerNotificationCenter iJobManagerNotificationCenter, Gen204MoveCopyEventLogger gen204MoveCopyEventLogger) {
        return new JobManager(iMoCoBoxTransfers, boxExtendedApiFile, boxExtendedApiFolder, boxExtendedApiWeblink, iBaseModelController, iUserContextManager, iMoCoBatchOperations, iMoCoAdminSettings, boxApiPrivate, boxExtendedApiCollaboration, notificationServices, iRemoteItemService, intentServices, iJobManagerNotificationCenter, gen204MoveCopyEventLogger);
    }
}
