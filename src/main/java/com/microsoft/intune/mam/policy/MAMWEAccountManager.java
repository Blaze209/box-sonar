package com.microsoft.intune.mam.policy;

import android.content.Context;
import com.microsoft.intune.mam.client.app.AppUtils;
import com.microsoft.intune.mam.client.identity.MAMIdentity;
import com.microsoft.intune.mam.client.identity.MAMIdentityManagerBase;
import com.microsoft.intune.mam.log.MAMLogPIIFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class MAMWEAccountManager {
    final MAMWEAccountRegistry mAccountRegistry;
    final boolean mIsPrimaryProcess;
    final MAMWERetryScheduler mRetryScheduler;

    public static MAMWEAccountManager create(Context context, MAMLogPIIFactory mAMLogPIIFactory, MAMWERetryScheduler mAMWERetryScheduler) {
        return new MAMWEAccountManager(new MAMWEAccountRegistry(context, mAMLogPIIFactory), mAMWERetryScheduler, AppUtils.isPrimaryProcess(context));
    }

    public MAMWEAccountManager(MAMWEAccountRegistry mAMWEAccountRegistry, MAMWERetryScheduler mAMWERetryScheduler, boolean z) {
        this.mAccountRegistry = mAMWEAccountRegistry;
        this.mRetryScheduler = mAMWERetryScheduler;
        this.mIsPrimaryProcess = z;
    }

    public boolean registerAccount(MAMIdentity mAMIdentity) {
        return this.mAccountRegistry.registerAccount(mAMIdentity);
    }

    public void updateAccount(MAMIdentity mAMIdentity, MAMEnrollmentManager.Result result, MAMWEError mAMWEError) throws Throwable {
        MAMWEAccountRegistry.AccountInfo accountInfo = this.mAccountRegistry.getAccountInfo(mAMIdentity);
        if (accountInfo == null) {
            return;
        }
        TokenNeededReason tokenNeededReason = TokenNeededReason.NOT_NEEDED;
        if (result == MAMEnrollmentManager.Result.AUTHORIZATION_NEEDED) {
            if (accountInfo.mStatus != MAMEnrollmentManager.Result.PENDING) {
                result = accountInfo.mStatus;
                mAMWEError = accountInfo.mError;
            }
            tokenNeededReason = accountInfo.mTokenReason == TokenNeededReason.COMPLIANCE ? TokenNeededReason.COMPLIANCE : TokenNeededReason.ENROLLMENT;
        }
        MAMWEAccountRegistry.AccountInfo accountInfoUpdateAccount = this.mAccountRegistry.updateAccount(mAMIdentity, result, mAMWEError, tokenNeededReason);
        if (accountInfoUpdateAccount != null) {
            this.mRetryScheduler.scheduleEnrollmentRetry(accountInfoUpdateAccount);
        }
    }

    public boolean removeAccount(MAMIdentity mAMIdentity) {
        boolean zRemoveAccount = this.mAccountRegistry.removeAccount(mAMIdentity);
        if (zRemoveAccount) {
            this.mRetryScheduler.removeAccount(mAMIdentity);
        }
        return zRemoveAccount;
    }

    public void removeScheduledRetries(MAMIdentity mAMIdentity) {
        this.mRetryScheduler.removeTasksForAccount(mAMIdentity);
    }

    public MAMEnrollmentManager.Result getAccountStatus(MAMIdentity mAMIdentity) {
        MAMWEAccountRegistry.AccountInfo accountInfo = this.mAccountRegistry.getAccountInfo(mAMIdentity);
        if (accountInfo == null) {
            return null;
        }
        return accountInfo.mStatus;
    }

    public TokenNeededReason getAccountNeedsToken(MAMIdentity mAMIdentity) {
        MAMWEAccountRegistry.AccountInfo accountInfo = this.mAccountRegistry.getAccountInfo(mAMIdentity);
        if (accountInfo == null) {
            return TokenNeededReason.NOT_NEEDED;
        }
        return accountInfo.mTokenReason;
    }

    public void setAccountNeedsToken(MAMIdentity mAMIdentity, TokenNeededReason tokenNeededReason) {
        MAMWEAccountRegistry.AccountInfo accountInfo = this.mAccountRegistry.getAccountInfo(mAMIdentity);
        if (accountInfo == null || accountInfo.mTokenReason == tokenNeededReason) {
            return;
        }
        if (accountInfo.mTokenReason != TokenNeededReason.COMPLIANCE || tokenNeededReason == TokenNeededReason.NOT_NEEDED) {
            this.mAccountRegistry.setAccountNeedsToken(mAMIdentity, tokenNeededReason);
        }
    }

    public void retryEnrollmentsAtStartup(MAMIdentity mAMIdentity) throws Throwable {
        if (this.mIsPrimaryProcess) {
            this.mRetryScheduler.scheduleEnrollmentRetriesAtStartup(this.mAccountRegistry.getAllAccounts(), mAMIdentity);
        }
    }

    public void primaryUserRemoved(MAMIdentity mAMIdentity) throws Throwable {
        this.mRetryScheduler.primaryUserRemoved(this.mAccountRegistry.getAllAccounts(), mAMIdentity);
    }

    public boolean isCompanyPortalRequired() {
        return isCompanyPortalRequired(this.mAccountRegistry);
    }

    public static boolean isCompanyPortalRequired(Context context, MAMLogPIIFactory mAMLogPIIFactory) {
        return isCompanyPortalRequired(new MAMWEAccountRegistry(context, mAMLogPIIFactory));
    }

    private static boolean isCompanyPortalRequired(MAMWEAccountRegistry mAMWEAccountRegistry) {
        Iterator<MAMWEAccountRegistry.AccountInfo> it = mAMWEAccountRegistry.getAllAccounts().iterator();
        while (it.hasNext()) {
            if (it.next().mStatus == MAMEnrollmentManager.Result.COMPANY_PORTAL_REQUIRED) {
                return true;
            }
        }
        return false;
    }

    public List<MAMIdentity> getRegisteredIdentitiesDirect() {
        List<MAMWEAccountRegistry.AccountInfo> allAccounts = this.mAccountRegistry.getAllAccounts();
        ArrayList arrayList = new ArrayList();
        for (MAMWEAccountRegistry.AccountInfo accountInfo : allAccounts) {
            MAMIdentity mAMIdentityCreateDirect = MAMIdentityManagerBase.createDirect(accountInfo.mUpn, accountInfo.mAadId, accountInfo.mAuthority, accountInfo.mTenantId);
            if (MAMIdentity.isValid(mAMIdentityCreateDirect)) {
                arrayList.add(mAMIdentityCreateDirect);
            }
        }
        return arrayList;
    }
}
