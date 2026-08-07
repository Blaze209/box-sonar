package com.microsoft.intune.mam.client.app.offline;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.ContextThemeWrapper;
import com.microsoft.intune.mam.R;
import com.microsoft.intune.mam.client.MAMIdentitySwitchResult;
import com.microsoft.intune.mam.client.app.HookedActivity;
import com.microsoft.intune.mam.client.app.HookedContextWrapper;
import com.microsoft.intune.mam.client.app.IdentitySwitchOption;
import com.microsoft.intune.mam.client.identity.IdentityParamConverter;
import com.microsoft.intune.mam.client.identity.MAMIdentity;
import com.microsoft.intune.mam.client.identity.MAMIdentityManager;
import com.microsoft.intune.mam.client.identity.MAMPolicyManagerBehaviorBase;
import com.microsoft.intune.mam.client.identity.MAMSetUIIdentityCallback;
import com.microsoft.intune.mam.policy.AppPolicy;
import com.microsoft.intune.mam.policy.MAMEnrollmentManager;
import com.microsoft.intune.mam.policy.MAMWEAccountManager;
import com.microsoft.intune.mam.policy.cache.MAMEnrolledIdentitiesCache;
import java.util.EnumSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineMAMPolicyManagerBehavior extends MAMPolicyManagerBehaviorBase {
    private static MAMIdentity mProcessIdentity;
    private static ThreadLocal<MAMIdentity> mThreadIdentity = new ThreadLocal<>();
    private final MAMWEAccountManager mAccountManager;
    private final Context mContext;
    private final MAMEnrolledIdentitiesCache mEnrolledIdentitiesCache;
    private final MAMIdentityManager mIdentityManager;

    @Override // com.microsoft.intune.mam.client.identity.MAMPolicyManagerBehavior
    public void bypassConditionalLaunchChecks(Activity activity) {
    }

    public OfflineMAMPolicyManagerBehavior(Context context, MAMIdentityManager mAMIdentityManager, MAMWEAccountManager mAMWEAccountManager, MAMEnrolledIdentitiesCache mAMEnrolledIdentitiesCache, IdentityParamConverter identityParamConverter) {
        super(identityParamConverter);
        this.mContext = context;
        this.mIdentityManager = mAMIdentityManager;
        this.mAccountManager = mAMWEAccountManager;
        this.mEnrolledIdentitiesCache = mAMEnrolledIdentitiesCache;
    }

    @Override // com.microsoft.intune.mam.client.identity.MAMPolicyManagerBehavior
    public MAMIdentitySwitchResult setProcessMAMIdentity(MAMIdentity mAMIdentity) {
        mProcessIdentity = mAMIdentity;
        return MAMIdentitySwitchResult.SUCCEEDED;
    }

    @Override // com.microsoft.intune.mam.client.identity.MAMPolicyManagerBehavior
    public MAMIdentity getProcessMAMIdentity() {
        return mProcessIdentity;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.microsoft.intune.mam.client.identity.MAMPolicyManagerBehavior
    public void setUIPolicyMAMIdentity(Context context, MAMIdentity mAMIdentity, MAMSetUIIdentityCallback mAMSetUIIdentityCallback, EnumSet<IdentitySwitchOption> enumSet) {
        MAMIdentitySwitchResult mAMIdentitySwitchResult;
        if (context instanceof HookedActivity) {
            if (mAMIdentity != null && !MAMIdentity.isValid(mAMIdentity)) {
                ((HookedActivity) context).switchMAMIdentity(mAMIdentity.rawUPN(), enumSet);
            } else {
                ((HookedActivity) context).switchMAMIdentityOID(mAMIdentity == null ? null : mAMIdentity.aadId(), enumSet);
            }
            mAMIdentitySwitchResult = MAMIdentitySwitchResult.SUCCEEDED;
        } else if (context instanceof HookedContextWrapper) {
            ((HookedContextWrapper) context).setMAMOfflineIdentity(mAMIdentity);
            mAMIdentitySwitchResult = MAMIdentitySwitchResult.SUCCEEDED;
        } else {
            mAMIdentitySwitchResult = MAMIdentitySwitchResult.FAILED;
        }
        if (mAMSetUIIdentityCallback != null) {
            mAMSetUIIdentityCallback.notifyIdentityResult(mAMIdentitySwitchResult);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.microsoft.intune.mam.client.identity.MAMPolicyManagerBehavior
    public MAMIdentity getUIPolicyMAMIdentity(Context context) {
        if (context instanceof HookedContextWrapper) {
            return ((HookedContextWrapper) context).getMAMOfflineIdentity();
        }
        return null;
    }

    @Override // com.microsoft.intune.mam.client.identity.MAMPolicyManagerBehavior
    public MAMIdentitySwitchResult setCurrentThreadMAMIdentity(MAMIdentity mAMIdentity) {
        mThreadIdentity.set(mAMIdentity);
        return MAMIdentitySwitchResult.SUCCEEDED;
    }

    @Override // com.microsoft.intune.mam.client.identity.MAMPolicyManagerBehavior
    public MAMIdentity getCurrentThreadMAMIdentity() {
        return mThreadIdentity.get();
    }

    @Override // com.microsoft.intune.mam.client.identity.MAMPolicyManagerBehavior
    public AppPolicy getAppPolicy() {
        return new OfflineAppPolicy(this.mIdentityParamConverter);
    }

    @Override // com.microsoft.intune.mam.client.identity.MAMPolicyManagerBehavior
    public AppPolicy getAppPolicy(Context context) {
        return new OfflineAppPolicy(this.mIdentityParamConverter);
    }

    @Override // com.microsoft.intune.mam.client.identity.MAMPolicyManagerBehavior
    public AppPolicy getAppPolicyForMAMIdentity(MAMIdentity mAMIdentity) {
        return new OfflineAppPolicy(this.mIdentityParamConverter);
    }

    @Override // com.microsoft.intune.mam.client.identity.MAMPolicyManagerBehavior
    public boolean getIsMAMIdentityManaged(MAMIdentity mAMIdentity) {
        if (MAMIdentity.isNullOrEmpty(mAMIdentity)) {
            return false;
        }
        Iterator<MAMIdentity> it = this.mEnrolledIdentitiesCache.getManagedIdentities().iterator();
        while (it.hasNext()) {
            if (compareUnreliableIdentities(mAMIdentity, it.next())) {
                return true;
            }
        }
        return this.mAccountManager.getAccountStatus(mAMIdentity) == MAMEnrollmentManager.Result.COMPANY_PORTAL_REQUIRED;
    }

    private boolean compareUnreliableIdentities(MAMIdentity mAMIdentity, MAMIdentity mAMIdentity2) {
        if (MAMIdentity.isValid(mAMIdentity) && MAMIdentity.isValid(mAMIdentity2)) {
            return mAMIdentity.equals(mAMIdentity2);
        }
        if (MAMIdentity.isValid(mAMIdentity)) {
            return mAMIdentity.hasUPN(mAMIdentity2.rawUPN());
        }
        return mAMIdentity2.hasUPN(mAMIdentity.rawUPN());
    }

    @Override // com.microsoft.intune.mam.client.identity.MAMPolicyManagerBehavior
    public void showDiagnostics(Context context) {
        new AlertDialog.Builder(new ContextThemeWrapper(context, R.style.MAMDialogTheme)).setMessage(context.getResources().getString(R.string.wg_offline_show_diagnostics_message)).setNegativeButton(context.getText(R.string.wg_offline_go_back), new DialogInterface.OnClickListener() { // from class: com.microsoft.intune.mam.client.app.offline.OfflineMAMPolicyManagerBehavior$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).setCancelable(true).create().show();
    }

    @Override // com.microsoft.intune.mam.client.identity.MAMPolicyManagerBehavior
    public MAMIdentity getCurrentMAMIdentity(Context context) {
        MAMIdentity currentThreadMAMIdentity = getCurrentThreadMAMIdentity();
        if (currentThreadMAMIdentity != null) {
            return currentThreadMAMIdentity;
        }
        MAMIdentity uIPolicyMAMIdentity = getUIPolicyMAMIdentity(context);
        if (uIPolicyMAMIdentity != null) {
            return uIPolicyMAMIdentity;
        }
        MAMIdentity processMAMIdentity = getProcessMAMIdentity();
        return processMAMIdentity != null ? processMAMIdentity : MAMIdentity.EMPTY;
    }
}
