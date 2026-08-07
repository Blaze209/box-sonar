package com.microsoft.intune.mam.policy;

import com.microsoft.intune.mam.client.MAMInfo;
import com.microsoft.intune.mam.client.app.AuthCallbackUtils;
import com.microsoft.intune.mam.client.identity.MAMIdentity;
import com.microsoft.intune.mam.log.MAMLogger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractEnrollmentManager implements MAMEnrollmentManager, MAMWEEnroller {
    private static final ThreadLocal<Boolean> AUTH_CALLBACK_TRACKER = new ThreadLocal<>();
    protected volatile MAMServiceAuthenticationCallbackExtended mAuthenticationCallback;

    protected abstract MAMLogger logger();

    protected abstract void scheduleEnrollmentRetriesConfigOnly();

    public boolean acquireTokenInProgress() {
        return AUTH_CALLBACK_TRACKER.get() != null;
    }

    @Override // com.microsoft.intune.mam.policy.MAMEnrollmentManager
    public void registerAuthenticationCallback(MAMServiceAuthenticationCallback mAMServiceAuthenticationCallback) {
        if (mAMServiceAuthenticationCallback == null) {
            this.mAuthenticationCallback = null;
            return;
        }
        this.mAuthenticationCallback = wrapAuthenticationCallback(adaptAuthCallback(mAMServiceAuthenticationCallback));
        if (MAMInfo.isConfigOnlyMode()) {
            scheduleEnrollmentRetriesConfigOnly();
        }
    }

    protected MAMServiceAuthenticationCallbackExtended adaptAuthCallback(final MAMServiceAuthenticationCallback mAMServiceAuthenticationCallback) {
        if (mAMServiceAuthenticationCallback instanceof MAMServiceAuthenticationCallbackExtended) {
            return (MAMServiceAuthenticationCallbackExtended) mAMServiceAuthenticationCallback;
        }
        return new MAMServiceAuthenticationCallbackExtended() { // from class: com.microsoft.intune.mam.policy.AbstractEnrollmentManager.1
            @Override // com.microsoft.intune.mam.policy.MAMServiceAuthenticationCallbackExtended, com.microsoft.intune.mam.policy.MAMServiceAuthenticationCallback
            public String acquireToken(String str, String str2, String str3) {
                return mAMServiceAuthenticationCallback.acquireToken(str, str2, str3);
            }

            @Override // com.microsoft.intune.mam.policy.MAMServiceAuthenticationCallbackExtended
            public String acquireToken(String str, String str2, String str3, String str4, String str5) {
                return mAMServiceAuthenticationCallback.acquireToken(str, str2, str5);
            }
        };
    }

    protected MAMServiceAuthenticationCallbackExtended wrapAuthenticationCallback(final MAMServiceAuthenticationCallbackExtended mAMServiceAuthenticationCallbackExtended) {
        return new MAMServiceAuthenticationCallbackExtended() { // from class: com.microsoft.intune.mam.policy.AbstractEnrollmentManager.2
            @Override // com.microsoft.intune.mam.policy.MAMServiceAuthenticationCallbackExtended
            public String acquireToken(String str, String str2, String str3, String str4, String str5) {
                AbstractEnrollmentManager.AUTH_CALLBACK_TRACKER.set(true);
                try {
                    return mAMServiceAuthenticationCallbackExtended.acquireToken(str, str2, str3, str4, str5);
                } finally {
                    AbstractEnrollmentManager.AUTH_CALLBACK_TRACKER.remove();
                }
            }
        };
    }

    @Override // com.microsoft.intune.mam.policy.MAMWEEnroller
    public String getMAMServiceTokenFromCallback(MAMIdentity mAMIdentity) {
        if (this.mAuthenticationCallback == null) {
            logger().warning("No auth callback is registered in getMAMServiceTokenFromCallback(). Returning null.", new Object[0]);
            return null;
        }
        return AuthCallbackUtils.acquireMAMServiceToken(this.mAuthenticationCallback, mAMIdentity);
    }

    @Override // com.microsoft.intune.mam.policy.MAMWEEnroller
    public boolean isAuthenticationCallbackRegistered() {
        return this.mAuthenticationCallback != null;
    }
}
