package com.microsoft.intune.mam.client.app;

import android.app.Application;
import android.content.Context;
import com.microsoft.intune.mam.client.MAMInfo;
import com.microsoft.intune.mam.client.app.offline.OfflineMAMEnrollmentManager;
import com.microsoft.intune.mam.client.config.ConfigOnlyModeBehavior;
import com.microsoft.intune.mam.client.identity.ExternalIdentityUtils;
import com.microsoft.intune.mam.client.identity.IdentityParamConverter;
import com.microsoft.intune.mam.client.identity.MAMIdentity;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import com.microsoft.intune.mam.policy.MAMEnrollmentManager;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMConfigOnly {
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(MAMConfigOnly.class);

    private MAMConfigOnly() {
    }

    public static void initialize(Application application) {
        MAMComponents.initialize(application.getApplicationContext());
        if (!MAMInfo.isConfigOnlyMode()) {
            throw new IllegalStateException("MAMConfigOnly can only be initialized in config-only mode.");
        }
        ((ConfigOnlyModeBehavior) MAMComponents.get(ConfigOnlyModeBehavior.class)).initialize(application);
    }

    @Deprecated
    public static boolean showInstallCompanyPortalUIIfNeeded(Context context, String str) {
        if (!MAMInfo.isConfigOnlyMode()) {
            throw new IllegalStateException("showInstallCompanyPortalUIIfNeeded() in only supported in config-only mode");
        }
        return showInstallCompanyPortalUIIfNeeded(context, ((IdentityParamConverter) MAMComponents.get(IdentityParamConverter.class)).fromUpnParam(str));
    }

    public static boolean showInstallCompanyPortalUIForOIDIfNeeded(Context context, String str) {
        if (!MAMInfo.isConfigOnlyMode()) {
            throw new IllegalStateException("showInstallCompanyPortalUIForOIDIfNeeded() in only supported in config-only mode");
        }
        return showInstallCompanyPortalUIIfNeeded(context, ExternalIdentityUtils.identityFromOID(str));
    }

    private static boolean showInstallCompanyPortalUIIfNeeded(Context context, MAMIdentity mAMIdentity) {
        if (!MAMComponents.isAppOffline() || MAMIdentity.isNullOrEmpty(mAMIdentity)) {
            return false;
        }
        OfflineMAMEnrollmentManager offlineMAMEnrollmentManager = (OfflineMAMEnrollmentManager) MAMComponents.get(OfflineMAMEnrollmentManager.class);
        if (offlineMAMEnrollmentManager.getRegisteredAccountStatus(mAMIdentity.rawUPN(), mAMIdentity.aadId()) != MAMEnrollmentManager.Result.COMPANY_PORTAL_REQUIRED && !MAMComponents.getAgentOutdated()) {
            return false;
        }
        offlineMAMEnrollmentManager.showNonBlockingInstallSSPUI(mAMIdentity, context);
        return true;
    }
}
