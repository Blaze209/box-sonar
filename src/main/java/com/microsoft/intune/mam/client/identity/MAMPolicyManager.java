package com.microsoft.intune.mam.client.identity;

import android.app.Activity;
import android.content.Context;
import com.microsoft.intune.mam.client.MAMIdentitySwitchResult;
import com.microsoft.intune.mam.client.app.IdentitySwitchOption;
import com.microsoft.intune.mam.client.app.MAMComponents;
import com.microsoft.intune.mam.policy.AppPolicy;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMPolicyManager {
    private MAMPolicyManager() {
    }

    @Deprecated
    public static void setUIPolicyIdentity(Context context, String str, MAMSetUIIdentityCallback mAMSetUIIdentityCallback) {
        ((MAMPolicyManagerBehavior) MAMComponents.get(MAMPolicyManagerBehavior.class)).setUIPolicyIdentity(context, str, mAMSetUIIdentityCallback, EnumSet.noneOf(IdentitySwitchOption.class));
    }

    @Deprecated
    public static void setUIPolicyIdentity(Context context, String str, MAMSetUIIdentityCallback mAMSetUIIdentityCallback, EnumSet<IdentitySwitchOption> enumSet) {
        ((MAMPolicyManagerBehavior) MAMComponents.get(MAMPolicyManagerBehavior.class)).setUIPolicyIdentity(context, str, mAMSetUIIdentityCallback, enumSet);
    }

    public static void setUIPolicyIdentityOID(Context context, String str, MAMSetUIIdentityCallback mAMSetUIIdentityCallback) {
        ((MAMPolicyManagerBehavior) MAMComponents.get(MAMPolicyManagerBehavior.class)).setUIPolicyMAMIdentity(context, ExternalIdentityUtils.identityFromOID(str), mAMSetUIIdentityCallback, EnumSet.noneOf(IdentitySwitchOption.class));
    }

    public static void setUIPolicyIdentityOID(Context context, String str, MAMSetUIIdentityCallback mAMSetUIIdentityCallback, EnumSet<IdentitySwitchOption> enumSet) {
        ((MAMPolicyManagerBehavior) MAMComponents.get(MAMPolicyManagerBehavior.class)).setUIPolicyMAMIdentity(context, ExternalIdentityUtils.identityFromOID(str), mAMSetUIIdentityCallback, enumSet);
    }

    @Deprecated
    public static String getUIPolicyIdentity(Context context) {
        return ((MAMPolicyManagerBehavior) MAMComponents.get(MAMPolicyManagerBehavior.class)).getUIPolicyIdentity(context);
    }

    public static String getUIPolicyIdentityOID(Context context) {
        MAMIdentity uIPolicyMAMIdentity = ((MAMPolicyManagerBehavior) MAMComponents.get(MAMPolicyManagerBehavior.class)).getUIPolicyMAMIdentity(context);
        if (uIPolicyMAMIdentity == null) {
            return null;
        }
        return uIPolicyMAMIdentity.aadId();
    }

    @Deprecated
    public static MAMIdentitySwitchResult setProcessIdentity(String str) {
        return ((MAMPolicyManagerBehavior) MAMComponents.get(MAMPolicyManagerBehavior.class)).setProcessIdentity(str);
    }

    public static MAMIdentitySwitchResult setProcessIdentityOID(String str) {
        return ((MAMPolicyManagerBehavior) MAMComponents.get(MAMPolicyManagerBehavior.class)).setProcessMAMIdentity(ExternalIdentityUtils.identityFromOID(str));
    }

    @Deprecated
    public static String getProcessIdentity() {
        return ((MAMPolicyManagerBehavior) MAMComponents.get(MAMPolicyManagerBehavior.class)).getProcessIdentity();
    }

    public static String getProcessIdentityOID() {
        MAMIdentity processMAMIdentity = ((MAMPolicyManagerBehavior) MAMComponents.get(MAMPolicyManagerBehavior.class)).getProcessMAMIdentity();
        if (processMAMIdentity == null) {
            return null;
        }
        return processMAMIdentity.aadId();
    }

    @Deprecated
    public static MAMIdentitySwitchResult setCurrentThreadIdentity(String str) {
        return ((MAMPolicyManagerBehavior) MAMComponents.get(MAMPolicyManagerBehavior.class)).setCurrentThreadIdentity(str);
    }

    public static MAMIdentitySwitchResult setCurrentThreadIdentityOID(String str) {
        return ((MAMPolicyManagerBehavior) MAMComponents.get(MAMPolicyManagerBehavior.class)).setCurrentThreadMAMIdentity(ExternalIdentityUtils.identityFromOID(str));
    }

    @Deprecated
    public static String getCurrentThreadIdentity() {
        return ((MAMPolicyManagerBehavior) MAMComponents.get(MAMPolicyManagerBehavior.class)).getCurrentThreadIdentity();
    }

    public static String getCurrentThreadIdentityOID() {
        MAMIdentity currentThreadMAMIdentity = ((MAMPolicyManagerBehavior) MAMComponents.get(MAMPolicyManagerBehavior.class)).getCurrentThreadMAMIdentity();
        if (currentThreadMAMIdentity == null) {
            return null;
        }
        return currentThreadMAMIdentity.aadId();
    }

    @Deprecated
    public static String getCurrentIdentity(Context context) {
        return ((MAMPolicyManagerBehavior) MAMComponents.get(MAMPolicyManagerBehavior.class)).getCurrentIdentity(context);
    }

    public static String getCurrentIdentityOID(Context context) {
        MAMIdentity currentMAMIdentity = ((MAMPolicyManagerBehavior) MAMComponents.get(MAMPolicyManagerBehavior.class)).getCurrentMAMIdentity(context);
        if (currentMAMIdentity == null) {
            return null;
        }
        return currentMAMIdentity.aadId();
    }

    public static AppPolicy getCurrentThreadPolicy() {
        return ((MAMPolicyManagerBehavior) MAMComponents.get(MAMPolicyManagerBehavior.class)).getAppPolicy();
    }

    @Deprecated
    public static AppPolicy getPolicy() {
        return getCurrentThreadPolicy();
    }

    public static AppPolicy getPolicy(Context context) {
        return ((MAMPolicyManagerBehavior) MAMComponents.get(MAMPolicyManagerBehavior.class)).getAppPolicy(context);
    }

    @Deprecated
    public static AppPolicy getPolicyForIdentity(String str) {
        return ((MAMPolicyManagerBehavior) MAMComponents.get(MAMPolicyManagerBehavior.class)).getAppPolicyForIdentity(str);
    }

    public static AppPolicy getPolicyForIdentityOID(String str) {
        return ((MAMPolicyManagerBehavior) MAMComponents.get(MAMPolicyManagerBehavior.class)).getAppPolicyForMAMIdentity(ExternalIdentityUtils.identityFromOID(str));
    }

    @Deprecated
    public static boolean getIsIdentityManaged(String str) {
        return ((MAMPolicyManagerBehavior) MAMComponents.get(MAMPolicyManagerBehavior.class)).getIsIdentityManaged(str);
    }

    public static boolean getIsIdentityOIDManaged(String str) {
        return ((MAMPolicyManagerBehavior) MAMComponents.get(MAMPolicyManagerBehavior.class)).getIsMAMIdentityManaged(ExternalIdentityUtils.identityFromOID(str));
    }

    public static void showDiagnostics(Context context) {
        ((MAMPolicyManagerBehavior) MAMComponents.get(MAMPolicyManagerBehavior.class)).showDiagnostics(context);
    }

    public static void bypassConditionalLaunchChecks(Activity activity) {
        ((MAMPolicyManagerBehavior) MAMComponents.get(MAMPolicyManagerBehavior.class)).bypassConditionalLaunchChecks(activity);
    }
}
