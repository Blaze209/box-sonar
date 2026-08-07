package com.microsoft.intune.mam.client.app.data;

import com.microsoft.intune.mam.client.app.LazyInit;
import com.microsoft.intune.mam.client.app.LocalSettingsBase;
import com.microsoft.intune.mam.client.identity.MAMIdentity;
import com.microsoft.intune.mam.client.telemetry.events.MAMInterfaceError;
import com.microsoft.intune.mam.log.MAMLogPIIFactory;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import com.microsoft.intune.mam.policy.MAMEnrollmentStatusCache;
import com.microsoft.intune.mam.policy.WipeReason;
import com.microsoft.intune.mam.policy.cache.MAMEnrolledIdentitiesCache;
import com.microsoft.intune.mam.util.NamedThreadFactory;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractUserDataWiper {
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(AbstractUserDataWiper.class);
    private static AtomicInteger mWipesInProgress = new AtomicInteger();
    LazyInit<Executor> mExecutor = new LazyInit<>(new LazyInit.Provider() { // from class: com.microsoft.intune.mam.client.app.data.AbstractUserDataWiper$$ExternalSyntheticLambda0
        @Override // com.microsoft.intune.mam.client.app.LazyInit.Provider
        public final Object get() {
            return AbstractUserDataWiper.lambda$new$0();
        }
    });
    private LocalSettingsBase mLocalSettings;
    final MAMEnrolledIdentitiesCache mMAMEnrolledIdentitiesCache;
    final MAMEnrollmentStatusCache mMAMEnrollmentStatusCache;
    final MAMLogPIIFactory mMAMLogPIIFactory;

    public abstract boolean doWipe(MAMIdentity mAMIdentity, WipeReason wipeReason, boolean z);

    static /* synthetic */ Executor lambda$new$0() {
        return new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("Intune MAM wiper"));
    }

    public AbstractUserDataWiper(MAMLogPIIFactory mAMLogPIIFactory, LocalSettingsBase localSettingsBase, MAMEnrollmentStatusCache mAMEnrollmentStatusCache, MAMEnrolledIdentitiesCache mAMEnrolledIdentitiesCache) {
        this.mMAMLogPIIFactory = mAMLogPIIFactory;
        this.mLocalSettings = localSettingsBase;
        this.mMAMEnrollmentStatusCache = mAMEnrollmentStatusCache;
        this.mMAMEnrolledIdentitiesCache = mAMEnrolledIdentitiesCache;
    }

    public static boolean isWipeInProgress() {
        return mWipesInProgress.intValue() > 0;
    }

    public static void waitForWipesToComplete() {
        synchronized (mWipesInProgress) {
            while (isWipeInProgress()) {
                try {
                    mWipesInProgress.wait();
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    private void onImplicitWipeSucceeded() {
        LOGGER.info("Clearing local caches after successful implicit wipe.", new Object[0]);
        this.mLocalSettings.clearLocalSettings();
        this.mMAMEnrolledIdentitiesCache.clear();
        if (this.mMAMEnrollmentStatusCache.getSystemWipeNotice()) {
            this.mMAMEnrollmentStatusCache.clearCacheAndSetSystemWipeNotice();
        } else {
            this.mMAMEnrollmentStatusCache.clearCacheAndSetImplicitWipeNotice();
        }
    }

    public void doWipeAllAsync(final WipeReason wipeReason) {
        mWipesInProgress.incrementAndGet();
        this.mExecutor.get().execute(new Runnable() { // from class: com.microsoft.intune.mam.client.app.data.AbstractUserDataWiper$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m13863x99994b53(wipeReason);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$doWipeAllAsync$1$com-microsoft-intune-mam-client-app-data-AbstractUserDataWiper, reason: not valid java name */
    /* synthetic */ void m13863x99994b53(WipeReason wipeReason) {
        boolean zDoWipe = true;
        try {
            for (MAMIdentity mAMIdentity : this.mMAMEnrolledIdentitiesCache.getManagedIdentities()) {
                LOGGER.info("Attempting to call registered user data wipe handler for {0}", this.mMAMLogPIIFactory.getPIIUPN(mAMIdentity));
                zDoWipe &= doWipe(mAMIdentity, wipeReason, false);
            }
            if (zDoWipe && wipeReason.isImplicit()) {
                onImplicitWipeSucceeded();
            }
            if (!zDoWipe) {
                LOGGER.error(MAMInterfaceError.WIPE_FAILED, "Wipe attempt failed. Wipe reason: " + wipeReason, new Object[0]);
            }
            if (mWipesInProgress.decrementAndGet() == 0) {
                synchronized (mWipesInProgress) {
                    mWipesInProgress.notifyAll();
                }
            }
        } catch (Throwable th) {
            if (!zDoWipe) {
                LOGGER.error(MAMInterfaceError.WIPE_FAILED, "Wipe attempt failed. Wipe reason: " + wipeReason, new Object[0]);
            }
            if (mWipesInProgress.decrementAndGet() == 0) {
                synchronized (mWipesInProgress) {
                    mWipesInProgress.notifyAll();
                }
            }
            throw th;
        }
    }
}
