package com.microsoft.intune.mam.client.identity;

import android.app.Activity;
import android.content.Context;
import com.microsoft.intune.mam.client.MAMIdentitySwitchResult;
import com.microsoft.intune.mam.client.app.IdentitySwitchOption;
import com.microsoft.intune.mam.policy.AppPolicy;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes3.dex */
public interface MAMPolicyManagerBehavior {
    void bypassConditionalLaunchChecks(Activity activity);

    AppPolicy getAppPolicy();

    AppPolicy getAppPolicy(Context context);

    @Deprecated
    AppPolicy getAppPolicyForIdentity(String str);

    AppPolicy getAppPolicyForMAMIdentity(MAMIdentity mAMIdentity);

    @Deprecated
    String getCurrentIdentity(Context context);

    MAMIdentity getCurrentMAMIdentity(Context context);

    @Deprecated
    String getCurrentThreadIdentity();

    MAMIdentity getCurrentThreadMAMIdentity();

    @Deprecated
    boolean getIsIdentityManaged(String str);

    boolean getIsMAMIdentityManaged(MAMIdentity mAMIdentity);

    @Deprecated
    String getProcessIdentity();

    MAMIdentity getProcessMAMIdentity();

    @Deprecated
    String getUIPolicyIdentity(Context context);

    MAMIdentity getUIPolicyMAMIdentity(Context context);

    @Deprecated
    MAMIdentitySwitchResult setCurrentThreadIdentity(String str);

    MAMIdentitySwitchResult setCurrentThreadMAMIdentity(MAMIdentity mAMIdentity);

    @Deprecated
    MAMIdentitySwitchResult setProcessIdentity(String str);

    MAMIdentitySwitchResult setProcessMAMIdentity(MAMIdentity mAMIdentity);

    @Deprecated
    void setUIPolicyIdentity(Context context, String str, MAMSetUIIdentityCallback mAMSetUIIdentityCallback);

    @Deprecated
    void setUIPolicyIdentity(Context context, String str, MAMSetUIIdentityCallback mAMSetUIIdentityCallback, EnumSet<IdentitySwitchOption> enumSet);

    void setUIPolicyMAMIdentity(Context context, MAMIdentity mAMIdentity, MAMSetUIIdentityCallback mAMSetUIIdentityCallback, EnumSet<IdentitySwitchOption> enumSet);

    void showDiagnostics(Context context);
}
