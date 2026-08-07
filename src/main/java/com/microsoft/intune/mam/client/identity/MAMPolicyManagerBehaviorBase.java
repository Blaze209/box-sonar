package com.microsoft.intune.mam.client.identity;

import android.content.Context;
import com.microsoft.intune.mam.client.MAMIdentitySwitchResult;
import com.microsoft.intune.mam.client.app.IdentitySwitchOption;
import com.microsoft.intune.mam.policy.AppPolicy;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MAMPolicyManagerBehaviorBase implements MAMPolicyManagerBehavior {
    protected final IdentityParamConverter mIdentityParamConverter;

    public MAMPolicyManagerBehaviorBase(IdentityParamConverter identityParamConverter) {
        this.mIdentityParamConverter = identityParamConverter;
    }

    @Override // com.microsoft.intune.mam.client.identity.MAMPolicyManagerBehavior
    @Deprecated
    public MAMIdentitySwitchResult setProcessIdentity(String str) {
        return setProcessMAMIdentity(this.mIdentityParamConverter.fromUpnParam(str));
    }

    @Override // com.microsoft.intune.mam.client.identity.MAMPolicyManagerBehavior
    @Deprecated
    public String getProcessIdentity() {
        MAMIdentity processMAMIdentity = getProcessMAMIdentity();
        if (processMAMIdentity == null) {
            return null;
        }
        return processMAMIdentity.rawUPN();
    }

    @Override // com.microsoft.intune.mam.client.identity.MAMPolicyManagerBehavior
    @Deprecated
    public void setUIPolicyIdentity(Context context, String str, MAMSetUIIdentityCallback mAMSetUIIdentityCallback) {
        setUIPolicyIdentity(context, str, mAMSetUIIdentityCallback, EnumSet.noneOf(IdentitySwitchOption.class));
    }

    @Override // com.microsoft.intune.mam.client.identity.MAMPolicyManagerBehavior
    @Deprecated
    public void setUIPolicyIdentity(Context context, String str, MAMSetUIIdentityCallback mAMSetUIIdentityCallback, EnumSet<IdentitySwitchOption> enumSet) {
        setUIPolicyMAMIdentity(context, this.mIdentityParamConverter.fromUpnParam(str), mAMSetUIIdentityCallback, enumSet);
    }

    @Override // com.microsoft.intune.mam.client.identity.MAMPolicyManagerBehavior
    @Deprecated
    public String getUIPolicyIdentity(Context context) {
        MAMIdentity uIPolicyMAMIdentity = getUIPolicyMAMIdentity(context);
        if (uIPolicyMAMIdentity == null) {
            return null;
        }
        return uIPolicyMAMIdentity.rawUPN();
    }

    @Override // com.microsoft.intune.mam.client.identity.MAMPolicyManagerBehavior
    @Deprecated
    public MAMIdentitySwitchResult setCurrentThreadIdentity(String str) {
        return setCurrentThreadMAMIdentity(this.mIdentityParamConverter.fromUpnParam(str));
    }

    @Override // com.microsoft.intune.mam.client.identity.MAMPolicyManagerBehavior
    @Deprecated
    public String getCurrentThreadIdentity() {
        MAMIdentity currentThreadMAMIdentity = getCurrentThreadMAMIdentity();
        if (currentThreadMAMIdentity == null) {
            return null;
        }
        return currentThreadMAMIdentity.rawUPN();
    }

    @Override // com.microsoft.intune.mam.client.identity.MAMPolicyManagerBehavior
    @Deprecated
    public AppPolicy getAppPolicyForIdentity(String str) {
        return getAppPolicyForMAMIdentity(this.mIdentityParamConverter.fromUpnParam(str));
    }

    @Override // com.microsoft.intune.mam.client.identity.MAMPolicyManagerBehavior
    @Deprecated
    public boolean getIsIdentityManaged(String str) {
        return getIsMAMIdentityManaged(this.mIdentityParamConverter.fromUpnParam(str));
    }

    @Override // com.microsoft.intune.mam.client.identity.MAMPolicyManagerBehavior
    @Deprecated
    public String getCurrentIdentity(Context context) {
        return getCurrentMAMIdentity(context).rawUPN();
    }
}
