package com.microsoft.intune.mam.client.app;

import android.app.Activity;
import android.app.Service;
import android.app.job.JobService;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import com.microsoft.intune.mam.R;
import com.microsoft.intune.mam.Version;
import com.microsoft.intune.mam.client.ComponentsContainer;
import com.microsoft.intune.mam.client.InterfaceComponentsAccess;
import com.microsoft.intune.mam.client.InterfaceVersion;
import com.microsoft.intune.mam.client.MAMInfo;
import com.microsoft.intune.mam.client.MAMSDKCapability;
import com.microsoft.intune.mam.client.OfflineReasonStore;
import com.microsoft.intune.mam.client.OutdatedAgentChecker;
import com.microsoft.intune.mam.client.app.offline.OfflineComponents;
import com.microsoft.intune.mam.client.app.resolver.MAMResolverActivity;
import com.microsoft.intune.mam.client.app.startup.MAMComplianceBlockActivity;
import com.microsoft.intune.mam.client.app.startup.MAMStartupActivity;
import com.microsoft.intune.mam.client.content.pm.PackageManagerCompat;
import com.microsoft.intune.mam.client.notification.OfflineCompanyPortalInstallReceiver;
import com.microsoft.intune.mam.client.service.MAMBackgroundJobService;
import com.microsoft.intune.mam.client.service.MAMBackgroundService;
import com.microsoft.intune.mam.client.telemetry.TelemetryLogger;
import com.microsoft.intune.mam.client.telemetry.events.MAMExternalError;
import com.microsoft.intune.mam.client.telemetry.events.ScenarioEvent;
import com.microsoft.intune.mam.log.MAMLogManager;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import com.microsoft.intune.mam.log.MAMSubOpTrace;
import com.microsoft.intune.mam.log.MAMTrace;
import com.microsoft.intune.mam.policy.MAMWEAccountManager;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMComponents {
    private static final long MAX_PORTAL_REINSTALL_WAIT_MS = 30000;
    private static final int MAX_RELEASES_SDK_AHEAD = 0;
    private static final long PORTAL_REINSTALL_SLEEP_MS = 500;
    private static String mAgentOutdatedMessage;
    private static ComponentsContainer mComponents;
    private static String mMAMAppPackageName;
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(MAMComponents.class);
    private static volatile boolean mInitialized = false;
    private static boolean mAgentOutdated = false;
    private static final List<String> RELEASE_CHECK_PACKAGE_NAMES = Arrays.asList("com.microsoft.skydrive", "com.microsoft.mdm.testapp1");
    private static final AndroidManifestData MANIFEST_DATA = new AndroidManifestData() { // from class: com.microsoft.intune.mam.client.app.MAMComponents.1
        @Override // com.microsoft.intune.mam.client.app.AndroidManifestData
        public Class<? extends Activity> getResolverActivity() {
            return MAMResolverActivity.class;
        }

        @Override // com.microsoft.intune.mam.client.app.AndroidManifestData
        public Class<? extends Activity> getStartupActivity() {
            return MAMStartupActivity.class;
        }

        @Override // com.microsoft.intune.mam.client.app.AndroidManifestData
        public Class<? extends Activity> getComplianceBlockActivity() {
            return MAMComplianceBlockActivity.class;
        }

        @Override // com.microsoft.intune.mam.client.app.AndroidManifestData
        public Class<? extends Service> getBackgroundService() {
            return MAMBackgroundService.class;
        }

        @Override // com.microsoft.intune.mam.client.app.AndroidManifestData
        public Class<? extends JobService> getBackgroundJobService() {
            return MAMBackgroundJobService.class;
        }

        @Override // com.microsoft.intune.mam.client.app.AndroidManifestData
        public InterfaceVersion getInterfaceVersion() {
            return CurrentInterfaceVersion.INSTANCE;
        }

        @Override // com.microsoft.intune.mam.client.app.AndroidManifestData
        public Version getSDKVersion() {
            return new Version(11, 0, 0);
        }

        @Override // com.microsoft.intune.mam.client.app.AndroidManifestData
        public int getIntuneMAMManifestResourceId() {
            return R.raw.intune_mam_manifest;
        }

        @Override // com.microsoft.intune.mam.client.app.AndroidManifestData
        public EnumSet<MAMSDKCapability> getCapabilities() {
            return EnumSet.allOf(MAMSDKCapability.class);
        }
    };
    private static final InvocationHandler EXTERNAL_INVOCATION_HANDLER = new InvocationHandler() { // from class: com.microsoft.intune.mam.client.app.MAMComponents$$ExternalSyntheticLambda0
        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            return MAMComponents.lambda$static$0(obj, method, objArr);
        }
    };

    static /* synthetic */ Object lambda$static$0(Object obj, Method method, Object[] objArr) throws Throwable {
        try {
            return method.invoke(obj, objArr);
        } catch (InvocationTargetException e) {
            if (e.getTargetException() != null) {
                throw e.getTargetException();
            }
            throw new UndeclaredThrowableException(e);
        }
    }

    private MAMComponents() {
    }

    public static void initialize(Context context) {
        if (mInitialized) {
            return;
        }
        synchronized (MAMComponents.class) {
            if (mInitialized) {
                return;
            }
            MAMLogger mAMLogger = LOGGER;
            mAMLogger.finer("Initialize start", new Object[0]);
            try {
                MAMTrace.start(ScenarioEvent.Scenario.MAMCOMPONENTS_INIT);
                initializeInner(context);
                mInitialized = true;
                mAMLogger.finer("Initialize done", new Object[0]);
                if (mComponents != null) {
                    MAMTrace.endAndLog(ScenarioEvent.Scenario.MAMCOMPONENTS_INIT, (TelemetryLogger) OfflineComponents.get(TelemetryLogger.class), context.getPackageName());
                } else {
                    MAMTrace.end(ScenarioEvent.Scenario.MAMCOMPONENTS_INIT);
                }
            } catch (Throwable th) {
                LOGGER.finer("Initialize done", new Object[0]);
                if (mComponents != null) {
                    MAMTrace.endAndLog(ScenarioEvent.Scenario.MAMCOMPONENTS_INIT, (TelemetryLogger) OfflineComponents.get(TelemetryLogger.class), context.getPackageName());
                } else {
                    MAMTrace.end(ScenarioEvent.Scenario.MAMCOMPONENTS_INIT);
                }
                throw th;
            }
        }
    }

    private static void initializeInner(Context context) {
        MAMInfo.initializeFromContext(context);
        if (MAMInfo.isOfflineLoggingDisabled()) {
            MAMLogger.setLoggingDisabled(true);
        }
        InterfaceComponentsAccess.initialize(new ComponentsContainer() { // from class: com.microsoft.intune.mam.client.app.MAMComponents$$ExternalSyntheticLambda1
            @Override // com.microsoft.intune.mam.client.ComponentsContainer
            public final Object get(Class cls) {
                return MAMComponents.get(cls);
            }
        });
        try {
            try {
                OfflineComponents.initialize(context);
                if (!MAMInfo.isOfflineLoggingDisabled()) {
                    ((MAMLogManager) OfflineComponents.get(MAMLogManager.class)).init();
                }
                if (AppUtils.isAllowedNonMAMProcess(context)) {
                    LOGGER.warning("Skipped ComponentsImpl.create for allowed non MAM process.", new Object[0]);
                    OfflineReasonStore.setOfflineReason("Allowed isolated process");
                    if (mComponents != null) {
                        MAMLogger.setLoggingDisabled(false);
                        return;
                    }
                    return;
                }
                MAMTrace.SubOp subOpSubOperation = MAMTrace.subOperation(ScenarioEvent.Scenario.MAMCOMPONENTS_INIT, MAMSubOpTrace.LOAD_INTERNAL_DISABLED);
                try {
                    boolean zIsLoadInternalDisabled = isLoadInternalDisabled(context);
                    if (subOpSubOperation != null) {
                        subOpSubOperation.close();
                    }
                    if (zIsLoadInternalDisabled) {
                        boolean zIsManagedApp = isManagedApp(context);
                        if (zIsManagedApp && MAMInfo.isConfigOnlyMode()) {
                            throw new IllegalStateException("Attempted to initialize config-only app in Offline mode, but the app is managed.");
                        }
                        if (zIsManagedApp || ((MAMWEAccountManager) OfflineComponents.get(MAMWEAccountManager.class)).isCompanyPortalRequired()) {
                            onAgentOutdated(context.getText(R.string.wg_offline_initialization_failure).toString());
                            ((OfflineCompanyPortalInstallReceiver) OfflineComponents.get(OfflineCompanyPortalInstallReceiver.class)).registerReceiver(context);
                            OfflineReasonStore.setOfflineReason("loadInternal disabled for managed app");
                        } else {
                            LOGGER.info("App is unmanaged and loading Internal is disabled, proceeding in Offline.", new Object[0]);
                            OfflineReasonStore.setOfflineReason("loadInternal disabled for unmanaged app");
                        }
                        if (mComponents != null) {
                            MAMLogger.setLoggingDisabled(false);
                            return;
                        }
                        return;
                    }
                    MAMTrace.SubOp subOpSubOperation2 = MAMTrace.subOperation(ScenarioEvent.Scenario.MAMCOMPONENTS_INIT, MAMSubOpTrace.GET_MDM_CONTEXT);
                    try {
                        Context mDMContextAndCheckSignatures = getMDMContextAndCheckSignatures(context);
                        if (subOpSubOperation2 != null) {
                            subOpSubOperation2.close();
                        }
                        if (mDMContextAndCheckSignatures == null) {
                            if (mComponents != null) {
                                MAMLogger.setLoggingDisabled(false);
                                return;
                            }
                            return;
                        }
                        MAMTrace.SubOp subOpSubOperation3 = MAMTrace.subOperation(ScenarioEvent.Scenario.MAMCOMPONENTS_INIT, MAMSubOpTrace.INIT_ONLINE_COMPS);
                        try {
                            boolean components = getComponents(context, mDMContextAndCheckSignatures);
                            if (subOpSubOperation3 != null) {
                                subOpSubOperation3.close();
                            }
                            if (!components) {
                                if (mComponents != null) {
                                    MAMLogger.setLoggingDisabled(false);
                                }
                            } else {
                                mMAMAppPackageName = context.getPackageName();
                                checkForOutdatedAgent(mDMContextAndCheckSignatures);
                                if (mComponents != null) {
                                    MAMLogger.setLoggingDisabled(false);
                                }
                            }
                        } catch (Throwable th) {
                            if (subOpSubOperation3 != null) {
                                try {
                                    subOpSubOperation3.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        if (subOpSubOperation2 != null) {
                            try {
                                subOpSubOperation2.close();
                            } catch (Throwable th4) {
                                th3.addSuppressed(th4);
                            }
                        }
                        throw th3;
                    }
                } catch (Throwable th5) {
                    if (subOpSubOperation != null) {
                        try {
                            subOpSubOperation.close();
                        } catch (Throwable th6) {
                            th5.addSuppressed(th6);
                        }
                    }
                    throw th5;
                }
            } catch (Exception e) {
                MAMLogger.setLoggingDisabled(false);
                LOGGER.severe("A unexpected exception happened.", e);
                OfflineReasonStore.setOfflineReason("Unexpected exception", e);
                if (mComponents != null) {
                    MAMLogger.setLoggingDisabled(false);
                }
            }
        } catch (Throwable th7) {
            if (mComponents != null) {
                MAMLogger.setLoggingDisabled(false);
            }
            throw th7;
        }
    }

    private static boolean checkSignatures(Context context) {
        PackageInfo agentPackageInfo = getAgentPackageInfo(context);
        if (agentPackageInfo == null) {
            LOGGER.info("Not initializing MAM classes because the MDM package is not installed.", new Object[0]);
            OfflineReasonStore.setOfflineReason("Agent not installed");
            return false;
        }
        if (Signatures.checkSignatures(agentPackageInfo.signatures)) {
            return true;
        }
        LOGGER.info("Not initializing MAM classes because the MDM package has the wrong signature.", new Object[0]);
        OfflineReasonStore.setOfflineReason("Agent signature mismatch");
        return false;
    }

    private static PackageInfo getAgentPackageInfo(Context context) {
        try {
            return PackageManagerCompat.getPackageInfo(context.getPackageManager(), MAMInfo.getPackageName(), 64L);
        } catch (PackageManager.NameNotFoundException unused) {
            if (!isAgentPackageVisibleAsUninstalled(context)) {
                return null;
            }
            MAMLogger mAMLogger = LOGGER;
            mAMLogger.info("Agent appears to be uninstalled but with data left behind. It may be upgrading", new Object[0]);
            if (!wasAppManaged(context)) {
                return null;
            }
            mAMLogger.info("Waiting for assumed agent reinstall to finish", new Object[0]);
            for (long j = 0; j < 30000; j += 500) {
                try {
                    Thread.sleep(500L);
                    return PackageManagerCompat.getPackageInfo(context.getPackageManager(), MAMInfo.getPackageName(), 64L);
                } catch (PackageManager.NameNotFoundException | InterruptedException unused2) {
                }
            }
            LOGGER.error(MAMExternalError.AGENT_REINSTALL_TIMEOUT, "Timed out while waiting for assumed agent reinstall to finish", new Object[0]);
            new OfflineLocalSettings(context).clearIsManaged();
            return null;
        }
    }

    private static boolean wasAppManaged(Context context) {
        OfflineLocalSettings offlineLocalSettings = new OfflineLocalSettings(context);
        if (offlineLocalSettings.getIsManaged()) {
            LOGGER.info("Local settings records app as previously managed", new Object[0]);
            return true;
        }
        if (offlineLocalSettings.isManagementRecorded()) {
            LOGGER.info("Local settings records app as not managed", new Object[0]);
            return false;
        }
        if (!offlineLocalSettings.isEmpty()) {
            LOGGER.info("local settings is non-empty but no management recorded, assuming managed", new Object[0]);
            return true;
        }
        LOGGER.info("Local settings is empty", new Object[0]);
        return false;
    }

    private static boolean isAgentPackageVisibleAsUninstalled(Context context) {
        try {
            PackageManagerCompat.getPackageInfo(context.getPackageManager(), MAMInfo.getPackageName(), 8192L);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    private static Context getMDMContextAndCheckSignatures(Context context) {
        if (!checkSignatures(context)) {
            return null;
        }
        try {
            return context.createPackageContext(MAMInfo.getPackageName(), 3);
        } catch (PackageManager.NameNotFoundException e) {
            throw new AssertionError(e);
        }
    }

    private static boolean getComponents(Context context, Context context2) {
        try {
            Object objInvoke = context2.getClassLoader().loadClass("com.microsoft.intune.mam.ComponentsImpl").getDeclaredMethod(PasskeyWebListener.CREATE_UNIQUE_KEY, Context.class, Context.class, Object.class, InvocationHandler.class).invoke(null, context2, context, MANIFEST_DATA, EXTERNAL_INVOCATION_HANDLER);
            if (objInvoke == null || !(objInvoke instanceof ComponentsContainer)) {
                LOGGER.warning("Not initializing MAM classes because the MDM package did not return a Components container.", new Object[0]);
                OfflineReasonStore.setOfflineReason("Agent did not return components");
                return false;
            }
            mComponents = (ComponentsContainer) objInvoke;
            return true;
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Not initializing MAM classes because the MDM package implementation could not be accessed.", e);
            OfflineReasonStore.setOfflineReason("Agent threw while creating components", e);
            return false;
        }
    }

    public static boolean isWipeInProgress(Context context) {
        return callBooleanFunctionViaClassloader(context, "isWipeInProgress", "Unable to check for wipe in progress as MDM package implementation could not be accessed.", "Wipe in progress check returned invalid object.");
    }

    public static boolean isManagedApp(Context context) {
        return callBooleanFunctionViaClassloader(context, "isManagedApp", "Unable to check for policy as MDM package implementation could not be accessed.", "Policy check returned invalid object.");
    }

    public static boolean isLoadInternalDisabled(Context context) {
        return callBooleanFunctionViaClassloader(context, "isLoadInternalDisabled", "Unable to check internal load disabled as MDM package implementation could not be accessed.", "Internal load disabled check returned invalid object.");
    }

    private static boolean callBooleanFunctionViaClassloader(Context context, String str, String str2, String str3) {
        Context mDMContextAndCheckSignatures = getMDMContextAndCheckSignatures(context);
        if (mDMContextAndCheckSignatures == null) {
            return false;
        }
        try {
            Object objInvoke = mDMContextAndCheckSignatures.getClassLoader().loadClass("com.microsoft.intune.mam.ComponentsImpl").getDeclaredMethod(str, Context.class).invoke(null, context);
            if (objInvoke == null || !(objInvoke instanceof Boolean)) {
                LOGGER.error(MAMExternalError.CLASSLOADER_PROXY_INVALID_OBJECT, str3, new Object[0]);
                return false;
            }
            return ((Boolean) objInvoke).booleanValue();
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, str2, e);
            return false;
        }
    }

    public static boolean isCompanyPortalInstalled(Context context) {
        return checkSignatures(context);
    }

    private static void checkForOutdatedAgent(Context context) {
        try {
            context.getClassLoader().loadClass("com.microsoft.intune.mam.OutdatedAgentCheckerImpl");
            OutdatedAgentChecker outdatedAgentChecker = (OutdatedAgentChecker) mComponents.get(OutdatedAgentChecker.class);
            if (outdatedAgentChecker.isSDKNewerThanAgent()) {
                LOGGER.info("Not initializing MAM classes because the agent is an incompatible previous version.", new Object[0]);
            } else {
                int numberOfReleasesSDKIsAhead = MAMVersionComparer.INSTANCE.getNumberOfReleasesSDKIsAhead();
                MAMLogger mAMLogger = LOGGER;
                mAMLogger.info(String.format(Locale.getDefault(), "SDK is [%d] releases ahead of agent.", Integer.valueOf(numberOfReleasesSDKIsAhead)), new Object[0]);
                if (numberOfReleasesSDKIsAhead > 0 && RELEASE_CHECK_PACKAGE_NAMES.contains(mMAMAppPackageName)) {
                    mAMLogger.info(String.format(Locale.getDefault(), "Not initializing MAM classes because the agent is [%d] releases behind.", Integer.valueOf(numberOfReleasesSDKIsAhead)), new Object[0]);
                } else {
                    mAMLogger.info("Initializing MAM classes with the MDM package: " + MAMInfo.getPackageName(), new Object[0]);
                    return;
                }
            }
            onAgentOutdated(outdatedAgentChecker.getUserFacingOutOfDateMessage());
            OfflineReasonStore.setOfflineReason("Company Portal is out of date. Found version: " + AppUtils.getPackageVersion(context, MAMInfo.getPackageName()));
        } catch (ClassNotFoundException unused) {
            LOGGER.info("Not initializing MAM classes because the MDM package does not contain OutdatedAgentChecker.", new Object[0]);
            onAgentOutdated("This app could not be launched because the Company Portal app on your device is out of date. To fix this problem, go to the Google Play store and install the latest version of the Company Portal app.");
            OfflineReasonStore.setOfflineReason("Company Portal is out of date. Found version: " + AppUtils.getPackageVersion(context, MAMInfo.getPackageName()));
        }
    }

    private static void onAgentOutdated(String str) {
        mComponents = null;
        mAgentOutdated = true;
        mAgentOutdatedMessage = str;
    }

    public static boolean getAgentOutdated() {
        return mAgentOutdated;
    }

    public static String getAgentOutdatedMessage() {
        return mAgentOutdatedMessage;
    }

    public static boolean isAppOffline() {
        return mComponents == null;
    }

    public static AndroidManifestData getManifestData() {
        return MANIFEST_DATA;
    }

    public static <T> T get(Class<T> cls) {
        ComponentsContainer componentsContainer = mComponents;
        return componentsContainer == null ? (T) OfflineComponents.get(cls) : (T) componentsContainer.get(cls);
    }
}
