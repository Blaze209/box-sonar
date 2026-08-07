package com.box.android.di;

import android.content.SharedPreferences;
import com.box.android.coreservices.jobmanager.JobManager;
import com.box.android.coreservices.observability.appstart.AppStartHandler;
import com.box.android.coreservices.observability.appstart.IAppStartDestinationPageHolder;
import com.box.android.coreservices.utilities.intune.IntuneAuthManager;
import com.box.android.data.service.impl.RemoteConfig;
import com.box.android.data.service.impl.UploadFileCleanupService;
import com.box.android.domain.configuration.ConfigManager;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.DeviceId;
import com.box.android.domain.usecases.observability.MetricsUseCase;
import com.box.android.observability.MetricsUploadScheduler;
import com.box.android.services.JobsNotificationService;
import com.box.android.utilities.LegacyMessageToGQLBridge;
import com.box.android.workers.AllWorkerFactories;
import com.box.androidsdk.content.BoxCache;
import com.box.cirrus.CirrusLoader;
import javax.inject.Named;
import kotlin.Metadata;

/* JADX INFO: compiled from: BoxApplicationEntryPoint.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010B\u001a\u00020CH'J\b\u0010D\u001a\u00020EH'R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00020\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0012\u0010\u001e\u001a\u00020\u001fX¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0012\u0010\"\u001a\u00020#X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0012\u0010&\u001a\u00020'X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0012\u0010*\u001a\u00020+X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0012\u0010.\u001a\u00020/X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0012\u00102\u001a\u000203X¦\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0012\u00106\u001a\u000207X¦\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u0012\u0010:\u001a\u00020;X¦\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0012\u0010>\u001a\u00020?X¦\u0004¢\u0006\u0006\u001a\u0004\b@\u0010A¨\u0006FÀ\u0006\u0003"}, d2 = {"Lcom/box/android/di/BoxApplicationEntryPoint;", "", "configManager", "Lcom/box/android/domain/configuration/ConfigManager;", "getConfigManager", "()Lcom/box/android/domain/configuration/ConfigManager;", "deviceId", "Lcom/box/android/domain/identity/DeviceId;", "getDeviceId", "()Lcom/box/android/domain/identity/DeviceId;", "boxCache", "Lcom/box/androidsdk/content/BoxCache;", "getBoxCache", "()Lcom/box/androidsdk/content/BoxCache;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "getFeatureFlips", "()Lcom/box/android/domain/configuration/FeatureFlips;", "legacyMessageToGQLBridge", "Lcom/box/android/utilities/LegacyMessageToGQLBridge;", "getLegacyMessageToGQLBridge", "()Lcom/box/android/utilities/LegacyMessageToGQLBridge;", "jobManager", "Lcom/box/android/coreservices/jobmanager/JobManager;", "getJobManager", "()Lcom/box/android/coreservices/jobmanager/JobManager;", "allWorkerFactories", "Lcom/box/android/workers/AllWorkerFactories;", "getAllWorkerFactories", "()Lcom/box/android/workers/AllWorkerFactories;", "intuneAuthManager", "Lcom/box/android/coreservices/utilities/intune/IntuneAuthManager;", "getIntuneAuthManager", "()Lcom/box/android/coreservices/utilities/intune/IntuneAuthManager;", "metricsUploadScheduler", "Lcom/box/android/observability/MetricsUploadScheduler;", "getMetricsUploadScheduler", "()Lcom/box/android/observability/MetricsUploadScheduler;", "jobsNotificationService", "Lcom/box/android/services/JobsNotificationService;", "getJobsNotificationService", "()Lcom/box/android/services/JobsNotificationService;", "metricsUseCase", "Lcom/box/android/domain/usecases/observability/MetricsUseCase;", "getMetricsUseCase", "()Lcom/box/android/domain/usecases/observability/MetricsUseCase;", "appStartHandler", "Lcom/box/android/coreservices/observability/appstart/AppStartHandler;", "getAppStartHandler", "()Lcom/box/android/coreservices/observability/appstart/AppStartHandler;", "appStartTargetHolder", "Lcom/box/android/coreservices/observability/appstart/IAppStartDestinationPageHolder;", "getAppStartTargetHolder", "()Lcom/box/android/coreservices/observability/appstart/IAppStartDestinationPageHolder;", "remoteConfig", "Lcom/box/android/data/service/impl/RemoteConfig;", "getRemoteConfig", "()Lcom/box/android/data/service/impl/RemoteConfig;", "cirrusLoader", "Lcom/box/cirrus/CirrusLoader;", "getCirrusLoader", "()Lcom/box/cirrus/CirrusLoader;", "uploadFileCleanupService", "Lcom/box/android/data/service/impl/UploadFileCleanupService;", "getUploadFileCleanupService", "()Lcom/box/android/data/service/impl/UploadFileCleanupService;", "getGlobalSharedPreferences", "Landroid/content/SharedPreferences;", "getAppFlavor", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface BoxApplicationEntryPoint {
    AllWorkerFactories getAllWorkerFactories();

    @Named("app-flavor")
    String getAppFlavor();

    AppStartHandler getAppStartHandler();

    IAppStartDestinationPageHolder getAppStartTargetHolder();

    BoxCache getBoxCache();

    CirrusLoader getCirrusLoader();

    ConfigManager getConfigManager();

    DeviceId getDeviceId();

    FeatureFlips getFeatureFlips();

    @Named("global-shared-preference")
    SharedPreferences getGlobalSharedPreferences();

    IntuneAuthManager getIntuneAuthManager();

    JobManager getJobManager();

    JobsNotificationService getJobsNotificationService();

    LegacyMessageToGQLBridge getLegacyMessageToGQLBridge();

    MetricsUploadScheduler getMetricsUploadScheduler();

    MetricsUseCase getMetricsUseCase();

    RemoteConfig getRemoteConfig();

    UploadFileCleanupService getUploadFileCleanupService();
}
