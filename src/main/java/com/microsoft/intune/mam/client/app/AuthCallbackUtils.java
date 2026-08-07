package com.microsoft.intune.mam.client.app;

import com.microsoft.intune.mam.client.identity.MAMIdentity;
import com.microsoft.intune.mam.client.telemetry.events.MAMInterfaceError;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import com.microsoft.intune.mam.policy.MAMServiceAuthentication;
import com.microsoft.intune.mam.policy.MAMServiceAuthenticationCallbackExtended;

/* JADX INFO: loaded from: classes3.dex */
public final class AuthCallbackUtils {
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(AuthCallbackUtils.class);

    private AuthCallbackUtils() {
    }

    public static String acquireMAMServiceToken(MAMServiceAuthenticationCallbackExtended mAMServiceAuthenticationCallbackExtended, MAMIdentity mAMIdentity) {
        if (mAMServiceAuthenticationCallbackExtended == null) {
            LOGGER.warning("No auth callback was passed to acquireMAMServiceToken.", new Object[0]);
            return null;
        }
        if (mAMIdentity == null) {
            LOGGER.error(MAMInterfaceError.AUTH_CALLBACK_NULL_IDENTITY, "Got unexpected null identity in acquireMAMServiceToken", new Object[0]);
            return null;
        }
        try {
            MAMLogger mAMLogger = LOGGER;
            mAMLogger.info("Calling app's acquireToken callback.", new Object[0]);
            String strAcquireToken = mAMServiceAuthenticationCallbackExtended.acquireToken(mAMIdentity.rawUPN(), mAMIdentity.aadId(), mAMIdentity.tenantId(), mAMIdentity.authority(), MAMServiceAuthentication.MAMSERVICE_RESOURCE_ID);
            if (strAcquireToken == null) {
                mAMLogger.info("App's acquireToken callback did not return a token.", new Object[0]);
                return strAcquireToken;
            }
            mAMLogger.info("App's acquireToken callback successfully returned a token.", new Object[0]);
            return strAcquireToken;
        } catch (Exception e) {
            LOGGER.error(MAMInterfaceError.AUTH_CALLBACK_UNEXPECTED_EXCEPTION, "App's acquireToken callback threw an exception.", e);
            return null;
        }
    }
}
