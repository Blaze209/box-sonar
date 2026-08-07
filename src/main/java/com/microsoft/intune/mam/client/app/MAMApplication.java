package com.microsoft.intune.mam.client.app;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.microsoft.intune.mam.client.app.data.OfflineUserDataWiper;
import com.microsoft.intune.mam.client.app.offline.OfflineCommonApplicationOnCreateOps;
import com.microsoft.intune.mam.client.app.offline.OfflineComponents;
import com.microsoft.intune.mam.client.identity.MAMIdentity;
import com.microsoft.intune.mam.client.lifecycle.ActivityLifecycleCallbacksUtils;
import com.microsoft.intune.mam.client.lifecycle.LifecycleSuppressionRegistry;
import com.microsoft.intune.mam.client.lifecycle.MAMActivityLifecycleCallbacks;
import com.microsoft.intune.mam.client.lifecycle.OfflineActivityLifecycleCallbacksFactory;
import com.microsoft.intune.mam.client.service.MAMBackgroundReceiver;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import com.microsoft.intune.mam.policy.MAMEnrollmentStatusCache;
import com.microsoft.intune.mam.policy.WipeReason;
import com.microsoft.intune.mam.policy.cache.MAMEnrolledIdentitiesCache;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class MAMApplication extends Application implements HookedApplication {
    private static final String PACKAGE_DATA_SCHEME = "package";
    private MAMIdentity mOfflineIdentity;

    @Override // com.microsoft.intune.mam.client.app.HookedApplication
    public final Application asApplication() {
        return this;
    }

    @Override // com.microsoft.intune.mam.client.app.HookedApplication
    public byte[] getADALSecretKey() {
        return null;
    }

    public void onMAMCreate() {
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        Impl.attachBaseContext(this, context);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedContextWrapper
    public final void attachBaseContextReal(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.app.Application
    public final void onCreate() {
        Impl.onCreate(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCreateReal() {
        super.onCreate();
    }

    private static class Impl {
        private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(MAMApplication.class);
        private static boolean mAttached = false;
        private static ApplicationBehavior mBehavior;

        private Impl() {
        }

        public static void attachBaseContext(MAMApplication mAMApplication, Context context) {
            MAMLogger mAMLogger = LOGGER;
            mAMLogger.entering("attachBaseContext");
            try {
                if (mAttached) {
                    mAMLogger.warning("attachBaseContext called a second time. Not initializing MAM components again", new Object[0]);
                    mAMApplication.attachBaseContextReal(context);
                } else {
                    MAMComponents.initialize(context);
                    ApplicationBehavior applicationBehavior = (ApplicationBehavior) MAMComponents.get(ApplicationBehavior.class);
                    mBehavior = applicationBehavior;
                    if (applicationBehavior == null) {
                        mAMApplication.attachBaseContextReal(context);
                    } else {
                        applicationBehavior.attachBaseContext(mAMApplication, context);
                    }
                }
                mAttached = true;
            } finally {
                mAttached = true;
                LOGGER.exiting("attachBaseContext");
            }
        }

        public static void onCreate(MAMApplication mAMApplication) {
            MAMLogger mAMLogger = LOGGER;
            mAMLogger.entering("onCreate");
            try {
                if (AppUtils.isAllowedNonMAMProcess(mAMApplication.getApplicationContext())) {
                    mAMApplication.onCreateReal();
                    mAMApplication.onMAMCreate();
                    mAMLogger.exiting("onCreate");
                    return;
                }
                mAMApplication.onCreateReal();
                ApplicationBehavior applicationBehavior = mBehavior;
                if (applicationBehavior != null) {
                    applicationBehavior.onCreate();
                } else {
                    OfflineCommonApplicationOnCreateOps.registerInstallReceivers(mAMApplication);
                    Context superBaseContext = mAMApplication.getSuperBaseContext();
                    if (superBaseContext == null) {
                        throw new IllegalStateException("Cannot call onCreate for an application which has not been attached.");
                    }
                    MAMEnrolledIdentitiesCache mAMEnrolledIdentitiesCache = (MAMEnrolledIdentitiesCache) OfflineComponents.get(MAMEnrolledIdentitiesCache.class);
                    MAMEnrollmentStatusCache mAMEnrollmentStatusCache = (MAMEnrollmentStatusCache) OfflineComponents.get(MAMEnrollmentStatusCache.class);
                    DirectBootUtils.migrateSharedPrefsToDeviceProtectedStorageIfNeeded(superBaseContext);
                    if (AppUtils.isPrimaryProcess(superBaseContext)) {
                        onCreatePrimaryProcess(mAMApplication, mAMEnrollmentStatusCache, mAMEnrolledIdentitiesCache);
                    } else {
                        onCreateSecondaryProcess(mAMApplication, superBaseContext, mAMEnrolledIdentitiesCache);
                    }
                }
                mAMLogger.exiting("onCreate");
            } catch (Throwable th) {
                LOGGER.exiting("onCreate");
                throw th;
            }
        }

        public static Context getBaseContext(MAMApplication mAMApplication) {
            ApplicationBehavior applicationBehavior = mBehavior;
            return applicationBehavior != null ? applicationBehavior.getBaseContext() : mAMApplication.getSuperBaseContext();
        }

        public static void endProcess() {
            AppUtils.endProcess(((ActivityLifecycleMonitorBase) OfflineComponents.get(ActivityLifecycleMonitorBase.class)).getAppActivities());
        }

        public static void registerActivityLifecycleCallbacks(MAMApplication mAMApplication, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            ApplicationBehavior applicationBehavior = mBehavior;
            if (applicationBehavior != null) {
                applicationBehavior.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
            } else {
                mAMApplication.registerActivityLifecycleCallbacksReal(MAMApplication.offlineRegisterActivityLifecycleCallbacks(activityLifecycleCallbacks, false));
            }
        }

        public static void unregisterActivityLifecycleCallbacks(MAMApplication mAMApplication, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            ApplicationBehavior applicationBehavior = mBehavior;
            if (applicationBehavior != null) {
                applicationBehavior.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
            } else {
                mAMApplication.unregisterActivityLifecycleCallbacksReal(MAMApplication.offlineUnregisterActivityLifecycleCallbacks(activityLifecycleCallbacks));
            }
        }

        private static void onCreateSecondaryProcess(MAMApplication mAMApplication, final Context context, final MAMEnrolledIdentitiesCache mAMEnrolledIdentitiesCache) {
            mAMApplication.onMAMCreate();
            new Thread(new Runnable() { // from class: com.microsoft.intune.mam.client.app.MAMApplication.Impl.1
                @Override // java.lang.Runnable
                public void run() {
                    if (Impl.requiresOfflineWipe(mAMEnrolledIdentitiesCache)) {
                        Impl.LOGGER.info("Secondary process detected wipe. Waking up main process.", new Object[0]);
                        context.sendBroadcast(new Intent(context, (Class<?>) MAMBackgroundReceiver.class));
                    }
                }
            }, "Intune MAM wipe").start();
        }

        private static void onCreatePrimaryProcess(MAMApplication mAMApplication, MAMEnrollmentStatusCache mAMEnrollmentStatusCache, MAMEnrolledIdentitiesCache mAMEnrolledIdentitiesCache) {
            boolean z;
            boolean zRequiresOfflineWipe = requiresOfflineWipe(mAMEnrolledIdentitiesCache);
            List<MAMIdentity> enrolledIdentities = mAMEnrolledIdentitiesCache.getEnrolledIdentities();
            List<MAMIdentity> managedIdentities = mAMEnrolledIdentitiesCache.getManagedIdentities();
            try {
                mAMApplication.onMAMCreate();
                z = false;
            } catch (Throwable th) {
                if (!handleWipeForOnCreateFailure(mAMApplication, zRequiresOfflineWipe, mAMEnrollmentStatusCache)) {
                    throw th;
                }
                z = true;
            }
            if (zRequiresOfflineWipe && !z) {
                LOGGER.warning("Detected Company Portal removal while app was enrolled and managed.  Wiping data now.", new Object[0]);
                ((OfflineUserDataWiper) OfflineComponents.get(OfflineUserDataWiper.class)).doWipeAllAsync(WipeReason.COMPANY_PORTAL_REMOVED);
            }
            if (!enrolledIdentities.isEmpty() && !MAMComponents.getAgentOutdated()) {
                for (MAMIdentity mAMIdentity : enrolledIdentities) {
                    OfflineCommonApplicationOnCreateOps.cleanUpEnrollment(mAMEnrolledIdentitiesCache, mAMIdentity, managedIdentities.contains(mAMIdentity));
                }
            }
            OfflineCommonApplicationOnCreateOps.retryEnrollments();
        }

        private static boolean handleWipeForOnCreateFailure(MAMApplication mAMApplication, boolean z, MAMEnrollmentStatusCache mAMEnrollmentStatusCache) {
            if (z) {
                LOGGER.warning("Detected Company Portal removal while app was enrolled and managed. App's onCreate failed. Wiping anyway.", new Object[0]);
                ((OfflineUserDataWiper) OfflineComponents.get(OfflineUserDataWiper.class)).doWipeAllAsync(WipeReason.COMPANY_PORTAL_REMOVED);
                return true;
            }
            if (!mAMEnrollmentStatusCache.getSystemWipeNotice()) {
                return false;
            }
            LOGGER.warning("Doing system wipe without showing user notification because process won't stay live long enough to show notification.", new Object[0]);
            ((ActivityManager) mAMApplication.getSystemService("activity")).clearApplicationUserData();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean requiresOfflineWipe(MAMEnrolledIdentitiesCache mAMEnrolledIdentitiesCache) {
            if (MAMComponents.getAgentOutdated()) {
                return false;
            }
            return mAMEnrolledIdentitiesCache.getWasManagedForAnyIdentity();
        }
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        return Impl.getBaseContext(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getSuperBaseContext() {
        return super.getBaseContext();
    }

    @Override // com.microsoft.intune.mam.client.app.HookedContextWrapper
    public void setMAMOfflineIdentity(MAMIdentity mAMIdentity) {
        this.mOfflineIdentity = mAMIdentity;
    }

    @Override // com.microsoft.intune.mam.client.app.HookedContextWrapper
    public MAMIdentity getMAMOfflineIdentity() {
        return this.mOfflineIdentity;
    }

    public static final void endProcess() {
        Impl.endProcess();
    }

    @Override // android.app.Application
    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        Impl.registerActivityLifecycleCallbacks(this, activityLifecycleCallbacks);
    }

    @Override // android.app.Application
    public void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        Impl.unregisterActivityLifecycleCallbacks(this, activityLifecycleCallbacks);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedApplication
    public void registerActivityLifecycleCallbacksReal(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        super.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedApplication
    public void unregisterActivityLifecycleCallbacksReal(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        super.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    public static Application.ActivityLifecycleCallbacks offlineRegisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks, boolean z) {
        if (!ActivityLifecycleCallbacksUtils.shouldWrapActivityLifecycleCallbacks(activityLifecycleCallbacks)) {
            return activityLifecycleCallbacks;
        }
        MAMActivityLifecycleCallbacks mAMActivityLifecycleCallbacksCreate = ((OfflineActivityLifecycleCallbacksFactory) OfflineComponents.get(OfflineActivityLifecycleCallbacksFactory.class)).create(activityLifecycleCallbacks);
        if (z) {
            mAMActivityLifecycleCallbacksCreate.setIsActivityCallback();
        }
        ((LifecycleSuppressionRegistry) OfflineComponents.get(LifecycleSuppressionRegistry.class)).registerWrappedCallbacks(activityLifecycleCallbacks, mAMActivityLifecycleCallbacksCreate);
        return mAMActivityLifecycleCallbacksCreate;
    }

    public static Application.ActivityLifecycleCallbacks offlineUnregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        MAMActivityLifecycleCallbacks mAMActivityLifecycleCallbacksUnregisterWrappedCallbacks = ((LifecycleSuppressionRegistry) OfflineComponents.get(LifecycleSuppressionRegistry.class)).unregisterWrappedCallbacks(activityLifecycleCallbacks);
        return mAMActivityLifecycleCallbacksUnregisterWrappedCallbacks != null ? mAMActivityLifecycleCallbacksUnregisterWrappedCallbacks : activityLifecycleCallbacks;
    }
}
