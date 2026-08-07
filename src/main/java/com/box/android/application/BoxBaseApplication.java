package com.box.android.application;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.webkit.WebView;
import android.widget.Toast;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.work.Configuration;
import com.box.android.R;
import com.box.android.auth.AuthenticationActivity;
import com.box.android.base.BoxNotificationManager;
import com.box.android.base.presentation.fragments.IApplicationFragmentCallback;
import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.common.utilities.BuildConfigProvider;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.common.utilities.RationaleScreenHelper;
import com.box.android.coreservices.jobmanager.JobManager;
import com.box.android.coreservices.jobmanager.dao.BoxLocalFileData;
import com.box.android.coreservices.modelcontroller.messages.BoxSwitchUserMessage;
import com.box.android.coreservices.modelcontroller.messages.Controller;
import com.box.android.coreservices.observability.appstart.AppStartHandler;
import com.box.android.coreservices.observability.appstart.IAppStartDestinationPageHolder;
import com.box.android.coreservices.utilities.intune.IntuneAuthManager;
import com.box.android.dao.LoadingMoreItem;
import com.box.android.data.service.impl.RemoteConfig;
import com.box.android.data.service.impl.UploadFileCleanupService;
import com.box.android.di.BoxApplicationEntryPoint;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.PendoAnalytics;
import com.box.android.domain.configuration.BoxConfigConstants;
import com.box.android.domain.configuration.ConfigManager;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.DeviceId;
import com.box.android.domain.usecases.observability.MetricsUseCase;
import com.box.android.exceptions.NullBoxApplicationException;
import com.box.android.observability.MetricsTree;
import com.box.android.observability.MetricsUploadScheduler;
import com.box.android.services.JobsNotificationService;
import com.box.android.utilities.BoxUtils;
import com.box.android.utilities.LegacyMessageToGQLBridge;
import com.box.android.utilities.OOMErrorsLoggingHelper;
import com.box.android.workers.AllWorkerFactories;
import com.box.androidsdk.content.BoxCache;
import com.box.androidsdk.content.BoxConfig;
import com.box.androidsdk.content.models.BoxEntity;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.logging.CrashlyticsTree;
import com.box.boxandroidlibv2private.dao.BoxAdminSettings;
import com.box.boxandroidlibv2private.dao.BoxConvertedPushNotificationDevice;
import com.box.brownfieldApi.ReactNativeHostManager;
import com.box.cirrus.CirrusLoader;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactHost;
import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.FirebaseMessaging;
import com.microsoft.intune.mam.client.app.MAMApplication;
import com.microsoft.intune.mam.client.content.MAMBroadcastReceiver;
import com.microsoft.intune.mam.client.strict.MAMStrictCheck;
import com.microsoft.intune.mam.client.strict.MAMStrictMode;
import dagger.hilt.EntryPoints;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes9.dex */
public class BoxBaseApplication extends MAMApplication implements LifecycleObserver, Configuration.Provider, IApplicationFragmentCallback, ReactApplication {
    private static final AtomicInteger BOX_ACTIVITY_SYNCHRONIZER = new AtomicInteger(0);
    private static BoxBaseApplication mInstance;
    AppStartHandler appStartHandler;
    IAppStartDestinationPageHolder appStartTargetHolder;
    protected BoxApplicationEntryPoint boxApplicationEntryPoint;
    protected CirrusLoader cirrusLoader;
    IntuneAuthManager intuneAuthManager;
    boolean isInitialized = false;
    JobsNotificationService jobsNotificationService;
    String mAppFlavor;
    protected BoxCache mCache;
    private Runnable mClosingRunnable;
    ConfigManager mConfigManager;
    public CountDownLatch mCreationCountDownLatch;
    protected DeviceId mDeviceId;
    protected AllWorkerFactories mFactories;
    protected FeatureFlips mFeatureFlips;
    SharedPreferences mGlobalSharedPreferences;
    JobManager mJobManager;
    protected LegacyMessageToGQLBridge mLegacyMessageToGQLBridge;
    private boolean mNeedsKilling;
    MetricsUploadScheduler metricsUploadScheduler;
    MetricsUseCase metricsUseCase;
    RemoteConfig remoteConfig;
    UploadFileCleanupService uploadFileCleanupService;

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return this;
    }

    protected void onPostCreate() {
    }

    public static BoxBaseApplication getInstance() {
        BoxBaseApplication boxBaseApplication = mInstance;
        if (boxBaseApplication != null) {
            return boxBaseApplication;
        }
        throw new NullBoxApplicationException();
    }

    @Override // com.microsoft.intune.mam.client.app.MAMApplication, com.microsoft.intune.mam.client.app.HookedApplication
    public void onMAMCreate() {
        mInstance = this;
        FirebaseApp.initializeApp(this);
        ApplicationProvider.setApplication(this);
        super.onMAMCreate();
        this.mCreationCountDownLatch = new CountDownLatch(1);
        if (BuildConfigProvider.INSTANCE.isDebugBuild()) {
            WebView.setWebContentsDebuggingEnabled(true);
            BoxLogUtils.setLoggers(new PrefixedDebugTree());
            FirebaseMessaging.getInstance().setDeliveryMetricsExportToBigQuery(true);
        } else if (CommonBoxUtil.isRunningAutomatedTest()) {
            BoxLogUtils.setLoggers(new PrefixedDebugTree());
        } else {
            BoxLogUtils.setLoggers(new CrashlyticsTree());
        }
        initializePendo();
        expandBoxEntity();
        boolean zIsDebugBuild = BuildConfigProvider.INSTANCE.isDebugBuild();
        BoxConfig.IS_DEBUG = zIsDebugBuild;
        BoxConfig.IS_LOG_ENABLED = zIsDebugBuild;
        initControllerBroadcastReceiver();
        BoxUtils.wipeTempCacheFiles(this);
        try {
            initializeHiltDependencies();
            initBoxApp();
        } catch (IllegalStateException unused) {
        }
        OOMErrorsLoggingHelper.INSTANCE.initLoggingAllOOMsTogether();
        onPostCreate();
    }

    public void initBoxApp() {
        IAppStartDestinationPageHolder iAppStartDestinationPageHolder;
        if (this.isInitialized) {
            return;
        }
        this.mCreationCountDownLatch.countDown();
        ProcessLifecycleOwner.get().getLifecycleRegistry().addObserver(this);
        if (!"prod".equals("dev")) {
            if (BuildConfigProvider.INSTANCE.isDebugBuild()) {
                MAMStrictMode.enable();
                MAMStrictMode.global().disable(MAMStrictCheck.APPLICATION_CONTEXT_DISCOVERED);
                MAMStrictMode.global().disable(MAMStrictCheck.SEVERE_EVENT);
                MAMStrictMode.global().disable(MAMStrictCheck.UPN_IDENTITY_PARAM);
            }
            IntuneAuthManager intuneAuthManager = this.intuneAuthManager;
            if (intuneAuthManager != null) {
                intuneAuthManager.registerAuthCallBack();
            }
        }
        BoxNotificationManager.createAllChannels();
        RationaleScreenHelper.INSTANCE.setFirstLaunchTime();
        AppStartHandler appStartHandler = this.appStartHandler;
        if (appStartHandler != null && (iAppStartDestinationPageHolder = this.appStartTargetHolder) != null) {
            appStartHandler.onBoxApplicationCreated(this, iAppStartDestinationPageHolder);
        }
        this.cirrusLoader.init(this);
        scheduleOrphanedFileCleanup();
        this.isInitialized = true;
    }

    private void scheduleOrphanedFileCleanup() {
        UploadFileCleanupService uploadFileCleanupService = this.uploadFileCleanupService;
        if (uploadFileCleanupService == null) {
            BoxLogUtils.w("BoxBaseApplication", "UploadFileCleanupService not available for orphaned file cleanup");
        } else {
            uploadFileCleanupService.scheduleCleanup(5000L, false);
        }
    }

    protected void initializePendo() {
        PendoAnalytics.INSTANCE.initialize(this);
    }

    public static boolean isInitialized() {
        return mInstance != null;
    }

    private void expandBoxEntity() {
        BoxEntity.addEntityType(BoxAdminSettings.TYPE, new BoxEntity.BoxEntityCreator() { // from class: com.box.android.application.BoxBaseApplication.1
            @Override // com.box.androidsdk.content.models.BoxEntity.BoxEntityCreator
            public BoxEntity createEntity() {
                return new BoxAdminSettings();
            }
        });
        BoxEntity.addEntityType(BoxConvertedPushNotificationDevice.TYPE, new BoxEntity.BoxEntityCreator() { // from class: com.box.android.application.BoxBaseApplication.2
            @Override // com.box.androidsdk.content.models.BoxEntity.BoxEntityCreator
            public BoxEntity createEntity() {
                return new BoxConvertedPushNotificationDevice();
            }
        });
        BoxEntity.addEntityType(BoxLocalFileData.TYPE, new BoxEntity.BoxEntityCreator() { // from class: com.box.android.application.BoxBaseApplication.3
            @Override // com.box.androidsdk.content.models.BoxEntity.BoxEntityCreator
            public BoxEntity createEntity() {
                return new BoxLocalFileData();
            }
        });
        BoxEntity.addEntityType(LoadingMoreItem.TYPE, new BoxEntity.BoxEntityCreator() { // from class: com.box.android.application.BoxBaseApplication.4
            @Override // com.box.androidsdk.content.models.BoxEntity.BoxEntityCreator
            public BoxEntity createEntity() {
                return LoadingMoreItem.INSTANCE;
            }
        });
    }

    private void initCache() {
        BoxConfig.setCache(this.mCache);
    }

    private void initControllerBroadcastReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BoxSwitchUserMessage.ACTION_DESTROYED_USER);
        intentFilter.addAction(BoxSwitchUserMessage.ACTION_SET_USER);
        LocalBroadcastManager.getInstance(this).registerReceiver(new MAMBroadcastReceiver() { // from class: com.box.android.application.BoxBaseApplication.5
            @Override // com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
            public void onMAMReceive(Context context, Intent intent) {
                if (intent.getAction().equals(BoxSwitchUserMessage.ACTION_DESTROYED_USER)) {
                    if (intent.getBooleanExtra(Controller.ARG_KILL_PROCESS_AT_LOGOUT, false)) {
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.box.android.application.BoxBaseApplication.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Process.killProcess(Process.myPid());
                            }
                        }, 500L);
                        return;
                    }
                    Intent intentCreateLaunchIntent = AuthenticationActivity.INSTANCE.createLaunchIntent(BoxBaseApplication.this);
                    intentCreateLaunchIntent.setFlags(268435456);
                    BoxBaseApplication.this.startActivity(intentCreateLaunchIntent);
                    String stringExtra = intent.hasExtra(Controller.ARG_CUSTOM_LOGOUT_MSG) ? intent.getStringExtra(Controller.ARG_CUSTOM_LOGOUT_MSG) : null;
                    if (StringUtils.isBlank(stringExtra)) {
                        Toast.makeText(BoxBaseApplication.this, R.string.you_have_successfully_logged_out, 1).show();
                    } else {
                        Toast.makeText(BoxBaseApplication.this, stringExtra, 1).show();
                    }
                }
            }
        }, intentFilter);
    }

    public void resetBoxClient() {
        ConfigManager configManager = getInstance().getConfigManager();
        String string = configManager.getString(BoxConfigConstants.CONFIG_KEY_CLIENT_ID);
        String string2 = configManager.getString(BoxConfigConstants.CONFIG_KEY_CLIENT_SECRET);
        BoxConfig.CLIENT_ID = string;
        BoxConfig.CLIENT_SECRET = string2;
    }

    protected void setBoxApplicationEntryPoint() {
        this.boxApplicationEntryPoint = (BoxApplicationEntryPoint) EntryPoints.get(this, BoxApplicationEntryPoint.class);
    }

    protected BoxApplicationEntryPoint getBoxApplicationEntryPoint() {
        if (this.boxApplicationEntryPoint == null) {
            this.boxApplicationEntryPoint = (BoxApplicationEntryPoint) EntryPoints.get(this, BoxApplicationEntryPoint.class);
        }
        return this.boxApplicationEntryPoint;
    }

    protected void initFirebaseRemoteConfig() {
        this.remoteConfig.init();
    }

    private void initializeDependencies() {
        this.mConfigManager = this.boxApplicationEntryPoint.getConfigManager();
        this.mDeviceId = this.boxApplicationEntryPoint.getDeviceId();
        this.mCache = this.boxApplicationEntryPoint.getBoxCache();
        this.mFeatureFlips = this.boxApplicationEntryPoint.getFeatureFlips();
        this.mLegacyMessageToGQLBridge = this.boxApplicationEntryPoint.getLegacyMessageToGQLBridge();
        this.mJobManager = this.boxApplicationEntryPoint.getJobManager();
        this.mFactories = this.boxApplicationEntryPoint.getAllWorkerFactories();
        this.mGlobalSharedPreferences = this.boxApplicationEntryPoint.getGlobalSharedPreferences();
        this.mAppFlavor = this.boxApplicationEntryPoint.getAppFlavor();
        this.intuneAuthManager = this.boxApplicationEntryPoint.getIntuneAuthManager();
        this.metricsUploadScheduler = this.boxApplicationEntryPoint.getMetricsUploadScheduler();
        this.jobsNotificationService = this.boxApplicationEntryPoint.getJobsNotificationService();
        this.metricsUseCase = this.boxApplicationEntryPoint.getMetricsUseCase();
        this.appStartHandler = this.boxApplicationEntryPoint.getAppStartHandler();
        this.appStartTargetHolder = this.boxApplicationEntryPoint.getAppStartTargetHolder();
        this.remoteConfig = this.boxApplicationEntryPoint.getRemoteConfig();
        this.cirrusLoader = this.boxApplicationEntryPoint.getCirrusLoader();
        this.uploadFileCleanupService = this.boxApplicationEntryPoint.getUploadFileCleanupService();
    }

    public ConfigManager getConfigManager() {
        if (this.mConfigManager == null) {
            this.mConfigManager = getBoxApplicationEntryPoint().getConfigManager();
        }
        return this.mConfigManager;
    }

    public JobManager getJobManager() {
        if (this.mJobManager == null) {
            this.mJobManager = getBoxApplicationEntryPoint().getJobManager();
        }
        return this.mJobManager;
    }

    @Override // com.box.android.base.presentation.fragments.IApplicationFragmentCallback
    public void onFragmentStarted() {
        AtomicInteger atomicInteger = BOX_ACTIVITY_SYNCHRONIZER;
        if (atomicInteger.incrementAndGet() > 1) {
            return;
        }
        synchronized (atomicInteger) {
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.box.android.application.BoxBaseApplication$6] */
    @Override // com.box.android.base.presentation.fragments.IApplicationFragmentCallback
    public void onFragmentStopped() {
        new Thread() { // from class: com.box.android.application.BoxBaseApplication.6
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    Thread.sleep(TimeUnit.SECONDS.toMillis(5L));
                } catch (InterruptedException e) {
                    BoxLogUtils.logException(e);
                    Thread.currentThread().interrupt();
                }
                if (BoxBaseApplication.BOX_ACTIVITY_SYNCHRONIZER.decrementAndGet() >= 1) {
                    return;
                }
                synchronized (BoxBaseApplication.BOX_ACTIVITY_SYNCHRONIZER) {
                    if (BoxBaseApplication.this.mClosingRunnable != null) {
                        BoxBaseApplication.this.mClosingRunnable.run();
                        BoxBaseApplication.this.mClosingRunnable = null;
                    }
                }
            }
        }.start();
    }

    public boolean shouldKillAppOnSignout() {
        return this.mNeedsKilling;
    }

    @Override // androidx.work.Configuration.Provider
    public Configuration getWorkManagerConfiguration() {
        return new Configuration.Builder().setWorkerFactory(this.mFactories).build();
    }

    public void initializeHiltDependencies() {
        setBoxApplicationEntryPoint();
        initializeDependencies();
        initCache();
        BoxLogUtils.setLoggers(new MetricsTree(this.metricsUseCase));
        initFirebaseRemoteConfig();
        BoxAmplitudeAnalytics.createAppInfoBuilder(this.mGlobalSharedPreferences, this.mAppFlavor).update();
    }

    @Override // com.facebook.react.ReactApplication
    public ReactHost getReactHost() {
        return ReactNativeHostManager.INSTANCE.getReactHost();
    }
}
