package com.microsoft.intune.mam.client.app.offline;

import android.content.Context;
import android.content.Intent;
import com.microsoft.intune.mam.R;
import com.microsoft.intune.mam.Version;
import com.microsoft.intune.mam.client.app.MAMBuildUtils;
import com.microsoft.intune.mam.client.app.MAMComponents;
import com.microsoft.intune.mam.client.app.startup.ADALConnectionDetails;
import com.microsoft.intune.mam.client.identity.MAMIdentity;
import com.microsoft.intune.mam.client.identity.MAMIdentityManager;
import com.microsoft.intune.mam.client.notification.MAMNotificationReceiverRegistryInternal;
import com.microsoft.intune.mam.client.notification.OfflineCompanyPortalInstallReceiver;
import com.microsoft.intune.mam.client.telemetry.TelemetryLogger;
import com.microsoft.intune.mam.client.telemetry.events.ScenarioEvent;
import com.microsoft.intune.mam.http.MAMSDLSSLSocketFactory;
import com.microsoft.intune.mam.log.MAMLogPIIFactory;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import com.microsoft.intune.mam.policy.AbstractEnrollmentManager;
import com.microsoft.intune.mam.policy.MAMCAComplianceStatus;
import com.microsoft.intune.mam.policy.MAMComplianceManager;
import com.microsoft.intune.mam.policy.MAMEnrollmentManager;
import com.microsoft.intune.mam.policy.MAMEnrollmentNotificationReceiver;
import com.microsoft.intune.mam.policy.MAMEnrollmentStatusCache;
import com.microsoft.intune.mam.policy.MAMServiceAuthentication;
import com.microsoft.intune.mam.policy.MAMServiceGeneralQueryParameters;
import com.microsoft.intune.mam.policy.MAMServiceLookupThread;
import com.microsoft.intune.mam.policy.MAMServiceLookupThreadFactory;
import com.microsoft.intune.mam.policy.MAMWEAccountManager;
import com.microsoft.intune.mam.policy.MAMWEError;
import com.microsoft.intune.mam.policy.TokenNeededReason;
import com.microsoft.intune.mam.policy.cache.MAMServiceUrlCache;
import com.microsoft.intune.mam.policy.notification.MAMComplianceNotification;
import com.microsoft.intune.mam.policy.notification.MAMEnrollmentNotification;
import com.microsoft.intune.mam.policy.notification.MAMNotificationType;
import java.security.GeneralSecurityException;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineMAMEnrollmentManager extends AbstractEnrollmentManager implements MAMComplianceManager {
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(OfflineMAMEnrollmentManager.class);
    private static final long OFFLINE_THROTTLE_INTERVAL_MS = 43200000;
    private final Context mContext;
    private final MAMEnrollmentStatusCache mEnrollmentCache;
    private boolean mHasShownNonBlockingInstallSSPUI = false;
    private final MAMIdentityManager mMAMIdentityManager;
    private final MAMLogPIIFactory mMAMLogPIIFactory;
    private final MAMNotificationReceiverRegistryInternal mNotificationReceiverRegistry;
    private final TelemetryLogger mTelemetryLogger;
    private final MAMServiceUrlCache mUrlCache;

    @Override // com.microsoft.intune.mam.policy.MAMEnrollmentManager
    public void registerADALConnectionDetails(String str, ADALConnectionDetails aDALConnectionDetails) {
    }

    public OfflineMAMEnrollmentManager(Context context, MAMNotificationReceiverRegistryInternal mAMNotificationReceiverRegistryInternal, MAMIdentityManager mAMIdentityManager, TelemetryLogger telemetryLogger, MAMLogPIIFactory mAMLogPIIFactory, MAMEnrollmentStatusCache mAMEnrollmentStatusCache, MAMServiceUrlCache mAMServiceUrlCache) {
        this.mContext = context;
        this.mNotificationReceiverRegistry = mAMNotificationReceiverRegistryInternal;
        this.mMAMIdentityManager = mAMIdentityManager;
        this.mTelemetryLogger = telemetryLogger;
        this.mMAMLogPIIFactory = mAMLogPIIFactory;
        this.mEnrollmentCache = mAMEnrollmentStatusCache;
        this.mUrlCache = mAMServiceUrlCache;
        mAMNotificationReceiverRegistryInternal.registerReceiver(new MAMEnrollmentNotificationReceiver(context, telemetryLogger, true, mAMLogPIIFactory, mAMIdentityManager), MAMNotificationType.MAM_ENROLLMENT_RESULT);
    }

    protected class MAMServiceCallback implements MAMServiceLookupThread.Callback {
        private final MAMIdentity mIdentity;
        private final String mSessionid;

        public MAMServiceCallback(MAMIdentity mAMIdentity, String str) {
            this.mIdentity = mAMIdentity;
            this.mSessionid = str;
        }

        @Override // com.microsoft.intune.mam.policy.MAMServiceLookupThread.Callback
        public void onSuccess(Map<String, String> map, String str) throws Throwable {
            OfflineMAMEnrollmentManager.this.handleCompanyPortalRequirement(this.mIdentity.rawUPN(), this.mIdentity.aadId(), this.mIdentity.authority(), this.mSessionid);
        }

        @Override // com.microsoft.intune.mam.policy.MAMServiceLookupThread.Callback
        public void onFailure(MAMEnrollmentManager.Result result, MAMWEError mAMWEError) throws Throwable {
            ((MAMWEAccountManager) MAMComponents.get(MAMWEAccountManager.class)).updateAccount(this.mIdentity, result, mAMWEError);
            OfflineMAMEnrollmentManager.this.sendEnrollmentNotification(this.mIdentity, result, this.mSessionid, mAMWEError);
        }
    }

    @Override // com.microsoft.intune.mam.policy.AbstractEnrollmentManager
    protected MAMLogger logger() {
        return LOGGER;
    }

    private void clearCachedEnrollmentData(MAMIdentity mAMIdentity) {
        this.mUrlCache.clear(mAMIdentity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCompanyPortalRequirement(String str, String str2, String str3, String str4) throws Throwable {
        MAMIdentity mAMIdentityCreate = this.mMAMIdentityManager.create(str, str2, str3);
        ((MAMWEAccountManager) MAMComponents.get(MAMWEAccountManager.class)).updateAccount(mAMIdentityCreate, MAMEnrollmentManager.Result.COMPANY_PORTAL_REQUIRED, MAMWEError.NONE_KNOWN);
        sendEnrollmentNotification(mAMIdentityCreate, MAMEnrollmentManager.Result.COMPANY_PORTAL_REQUIRED, str4, MAMWEError.NONE_KNOWN);
        if (MAMComponents.isCompanyPortalInstalled(this.mContext)) {
            OfflineActivityBehavior.softRestart(this.mContext);
        } else {
            ((OfflineCompanyPortalInstallReceiver) OfflineComponents.get(OfflineCompanyPortalInstallReceiver.class)).registerReceiver(this.mContext);
            showNonBlockingInstallSSPUI(mAMIdentityCreate, this.mContext);
        }
    }

    @Override // com.microsoft.intune.mam.policy.MAMEnrollmentManager
    public void updateToken(String str, String str2, String str3, String str4) {
        if (acquireTokenInProgress()) {
            LOGGER.severe("updateToken should not be called from within acquireToken!", new Object[0]);
            return;
        }
        if (!str3.equals(MAMServiceAuthentication.MAMSERVICE_RESOURCE_ID)) {
            LOGGER.warning("Unknown resource ID passed to updateToken.", new Object[0]);
            return;
        }
        if (str4 == null || str4.isEmpty()) {
            LOGGER.warning("Invalid token passed to updateToken.", new Object[0]);
            return;
        }
        MAMIdentity mAMIdentityCreate = this.mMAMIdentityManager.create(str, str2);
        if (((MAMWEAccountManager) MAMComponents.get(MAMWEAccountManager.class)).getAccountNeedsToken(mAMIdentityCreate) == TokenNeededReason.NOT_NEEDED) {
            LOGGER.info("Account passed to updateToken doesn't need a token update; skipping.", new Object[0]);
        } else {
            attemptMamEnrollment(mAMIdentityCreate, str4);
        }
    }

    @Override // com.microsoft.intune.mam.policy.MAMEnrollmentManager
    public void registerAccountForMAM(String str, String str2, String str3) {
        registerAccountForMAM(str, str2, str3, null);
    }

    @Override // com.microsoft.intune.mam.policy.MAMEnrollmentManager
    public void registerAccountForMAM(String str, String str2, String str3, String str4) {
        if (str == null || str.isEmpty()) {
            LOGGER.warning("registerAccountForMAM called with invalid identity", new Object[0]);
            throw new IllegalArgumentException("Invalid identity passed to registerAccountForMAM");
        }
        if (str2 == null || str2.isEmpty()) {
            LOGGER.warning("registerAccountForMAM called with invalid adalId", new Object[0]);
            throw new IllegalArgumentException("Invalid AAD id passed to registerAccountForMAM");
        }
        MAMIdentity mAMIdentityInsertOrUpdate = this.mMAMIdentityManager.insertOrUpdate(str2, str, str3, str4, false);
        if (!((MAMWEAccountManager) MAMComponents.get(MAMWEAccountManager.class)).registerAccount(mAMIdentityInsertOrUpdate)) {
            LOGGER.info("registerAccountForMAM skipping already registered account: {0}", this.mMAMLogPIIFactory.getPIIUPN(mAMIdentityInsertOrUpdate));
        } else {
            attemptMamEnrollment(mAMIdentityInsertOrUpdate);
        }
    }

    private void attemptMamEnrollment(MAMIdentity mAMIdentity, String str) {
        MAMSDLSSLSocketFactory mAMSDLSSLSocketFactory;
        MAMLogger mAMLogger = LOGGER;
        mAMLogger.info("attempting MAM-WE V2 enrollment for: {0}", this.mMAMLogPIIFactory.getPIIUPN(mAMIdentity));
        if (this.mAuthenticationCallback == null && str == null) {
            mAMLogger.severe("MAM-WE V2 enrollment attempt without a registered instance of MAMServiceAuthenticationCallback.", new Object[0]);
        }
        ((MAMWEAccountManager) MAMComponents.get(MAMWEAccountManager.class)).removeScheduledRetries(mAMIdentity);
        String string = UUID.randomUUID().toString();
        this.mTelemetryLogger.logMAMScenarioStart(ScenarioEvent.Scenario.OFFLINE_ENROLLMENT, this.mContext.getPackageName(), string);
        MAMServiceCallback mAMServiceCallback = new MAMServiceCallback(mAMIdentity, string);
        OfflineMAMServiceLookupCache offlineMAMServiceLookupCache = new OfflineMAMServiceLookupCache(this.mMAMLogPIIFactory, this.mUrlCache);
        if (MAMBuildUtils.isDeveloperBuild()) {
            mAMLogger.log(Level.WARNING, "SSL cert pinning disabled due to developer build flag.");
            mAMSDLSSLSocketFactory = null;
        } else {
            try {
                mAMSDLSSLSocketFactory = new MAMSDLSSLSocketFactory(mAMIdentity.authority(), this.mTelemetryLogger, this.mContext.getPackageName());
            } catch (GeneralSecurityException e) {
                LOGGER.severe("Error constructing socket factory", e);
                mAMServiceCallback.onFailure(MAMEnrollmentManager.Result.ENROLLMENT_FAILED, MAMWEError.NONE_KNOWN);
                return;
            }
        }
        Context context = this.mContext;
        MAMServiceGeneralQueryParameters androidMamSDKVersion = new MAMServiceGeneralQueryParameters(context, context.getPackageName()).setAndroidMamSDKVersion(new Version(11, 0, 0).toString());
        Context context2 = this.mContext;
        MAMServiceLookupThread mAMServiceLookupThreadBuild = new MAMServiceLookupThreadFactory(context2, context2.getPackageName()).setIdentity(mAMIdentity).setLookupCache(offlineMAMServiceLookupCache).setCallback(mAMServiceCallback).setTelemetryInfo(this.mTelemetryLogger, string).setAuthenticationCallback(this.mAuthenticationCallback).setSslSocketFactory(mAMSDLSSLSocketFactory).setMAMServiceQueryParameters(androidMamSDKVersion).build();
        if (str != null) {
            mAMServiceLookupThreadBuild.skipTokenAcquisition(str);
        }
        mAMServiceLookupThreadBuild.setCheckForPolicy(true);
        mAMServiceLookupThreadBuild.setName("Intune MAM enrollment");
        mAMServiceLookupThreadBuild.start();
    }

    @Override // com.microsoft.intune.mam.policy.MAMWEEnroller
    public void attemptMamEnrollment(MAMIdentity mAMIdentity) {
        attemptMamEnrollment(mAMIdentity, null);
    }

    @Override // com.microsoft.intune.mam.policy.MAMEnrollmentManager
    public void unregisterAccountForMAM(String str) {
        unregisterAccountForMAM(str, null);
    }

    @Override // com.microsoft.intune.mam.policy.MAMEnrollmentManager
    public void unregisterAccountForMAM(String str, String str2) {
        if (str2 == null || str2.isEmpty()) {
            LOGGER.warning("unregisterAccountForMAM called without valid OID; identity may be ambiguous.", new Object[0]);
        }
        MAMIdentity mAMIdentityCreate = this.mMAMIdentityManager.create(str, str2);
        if (((MAMWEAccountManager) MAMComponents.get(MAMWEAccountManager.class)).removeAccount(mAMIdentityCreate)) {
            clearCachedEnrollmentData(mAMIdentityCreate);
        } else {
            LOGGER.info("unregisterAccountForMAM skipping non-registered account: {0}", this.mMAMLogPIIFactory.getPIIUPN(mAMIdentityCreate));
        }
    }

    @Override // com.microsoft.intune.mam.policy.MAMEnrollmentManager
    public MAMEnrollmentManager.Result getRegisteredAccountStatus(String str) {
        return getRegisteredAccountStatus(str, null);
    }

    @Override // com.microsoft.intune.mam.policy.MAMEnrollmentManager
    public MAMEnrollmentManager.Result getRegisteredAccountStatus(String str, String str2) {
        if (str2 == null || str2.isEmpty()) {
            LOGGER.warning("getRegisteredAccountStatus called without valid OID; results may be incorrect.", new Object[0]);
        }
        return ((MAMWEAccountManager) MAMComponents.get(MAMWEAccountManager.class)).getAccountStatus(this.mMAMIdentityManager.create(str, str2));
    }

    @Override // com.microsoft.intune.mam.policy.MAMComplianceManager
    public void remediateCompliance(final String str, final String str2, String str3, final String str4, boolean z) {
        if (str == null || str.isEmpty()) {
            LOGGER.warning("remediateCompliance called with invalid UPN", new Object[0]);
            throw new IllegalArgumentException("Invalid UPN passed to remediateCompliance");
        }
        if (str2 == null || str2.isEmpty()) {
            LOGGER.warning("remediateCompliance called with invalid AAD ID", new Object[0]);
            throw new IllegalArgumentException("Invalid AAD ID passed to remediateCompliance");
        }
        LOGGER.info("remediateCompliance called for: {0}; showUX: {1}", this.mMAMLogPIIFactory.getPIIUPN(str, str2), Boolean.valueOf(z));
        new Thread(new Runnable() { // from class: com.microsoft.intune.mam.client.app.offline.OfflineMAMEnrollmentManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f$0.m13867x9a80323c(str, str2, str4);
            }
        }, "Intune MAM compliance").start();
    }

    /* JADX INFO: renamed from: lambda$remediateCompliance$0$com-microsoft-intune-mam-client-app-offline-OfflineMAMEnrollmentManager, reason: not valid java name */
    /* synthetic */ void m13867x9a80323c(String str, String str2, String str3) throws Throwable {
        handleCompanyPortalRequirement(str, str2, str3, UUID.randomUUID().toString());
        sendComplianceNotification(str, str2, MAMCAComplianceStatus.COMPANY_PORTAL_REQUIRED, this.mContext.getResources().getString(R.string.wg_offline_mamca_failed_title), this.mContext.getResources().getString(R.string.wg_offline_mamca_failed_message));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendEnrollmentNotification(final MAMIdentity mAMIdentity, final MAMEnrollmentManager.Result result, final String str, final MAMWEError mAMWEError) {
        this.mNotificationReceiverRegistry.sendNotification(new MAMEnrollmentNotification() { // from class: com.microsoft.intune.mam.client.app.offline.OfflineMAMEnrollmentManager.1
            @Override // com.microsoft.intune.mam.policy.notification.MAMUserNotification
            public String getUserIdentity() {
                return mAMIdentity.rawUPN();
            }

            @Override // com.microsoft.intune.mam.policy.notification.MAMUserNotification
            public String getUserOid() {
                return mAMIdentity.aadId();
            }

            @Override // com.microsoft.intune.mam.policy.notification.MAMNotification
            public MAMNotificationType getType() {
                return MAMNotificationType.MAM_ENROLLMENT_RESULT;
            }

            @Override // com.microsoft.intune.mam.policy.notification.MAMEnrollmentNotification
            public MAMEnrollmentManager.Result getEnrollmentResult() {
                return result;
            }

            @Override // com.microsoft.intune.mam.policy.notification.MAMEnrollmentNotification
            public String getSessionId() {
                return str;
            }

            @Override // com.microsoft.intune.mam.policy.notification.MAMEnrollmentNotification
            public ScenarioEvent.Scenario getScenario() {
                return ScenarioEvent.Scenario.OFFLINE_ENROLLMENT;
            }

            @Override // com.microsoft.intune.mam.policy.notification.MAMEnrollmentNotification
            public MAMWEError getError() {
                return mAMWEError;
            }
        });
    }

    private void sendComplianceNotification(final String str, final String str2, final MAMCAComplianceStatus mAMCAComplianceStatus, final String str3, final String str4) {
        this.mNotificationReceiverRegistry.sendNotification(new MAMComplianceNotification() { // from class: com.microsoft.intune.mam.client.app.offline.OfflineMAMEnrollmentManager.2
            @Override // com.microsoft.intune.mam.policy.notification.MAMComplianceNotification
            public MAMCAComplianceStatus getComplianceStatus() {
                return mAMCAComplianceStatus;
            }

            @Override // com.microsoft.intune.mam.policy.notification.MAMComplianceNotification
            public String getComplianceErrorTitle() {
                return str3;
            }

            @Override // com.microsoft.intune.mam.policy.notification.MAMComplianceNotification
            public String getComplianceErrorMessage() {
                return str4;
            }

            @Override // com.microsoft.intune.mam.policy.notification.MAMUserNotification
            public String getUserIdentity() {
                return str;
            }

            @Override // com.microsoft.intune.mam.policy.notification.MAMUserNotification
            public String getUserOid() {
                return str2;
            }

            @Override // com.microsoft.intune.mam.policy.notification.MAMNotification
            public MAMNotificationType getType() {
                return MAMNotificationType.COMPLIANCE_STATUS;
            }
        });
    }

    public boolean showNonBlockingInstallSSPUIIfNeeded(MAMIdentity mAMIdentity, Context context) {
        if (this.mHasShownNonBlockingInstallSSPUI) {
            LOGGER.info("Skipped showing the nonblocking install SSP dialog since it has been shown before.", new Object[0]);
            return false;
        }
        showNonBlockingInstallSSPUI(mAMIdentity, context);
        return true;
    }

    public void showNonBlockingInstallSSPUI(MAMIdentity mAMIdentity, Context context) {
        Intent intent = new Intent(context, (Class<?>) OfflineInstallCompanyPortalDialogActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("identityAuthority", mAMIdentity == null ? null : mAMIdentity.authority());
        context.startActivity(intent);
        this.mHasShownNonBlockingInstallSSPUI = true;
    }

    @Override // com.microsoft.intune.mam.policy.AbstractEnrollmentManager
    protected void scheduleEnrollmentRetriesConfigOnly() {
        OfflineCommonApplicationOnCreateOps.retryEnrollments();
    }
}
