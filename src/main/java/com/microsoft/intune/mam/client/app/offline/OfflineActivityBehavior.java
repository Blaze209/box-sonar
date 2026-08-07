package com.microsoft.intune.mam.client.app.offline;

import android.app.Application;
import android.app.Fragment;
import android.app.assist.AssistContent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.SearchEvent;
import android.view.View;
import com.microsoft.intune.mam.client.MAMIdentitySwitchResult;
import com.microsoft.intune.mam.client.MAMInfo;
import com.microsoft.intune.mam.client.app.ActivityBehaviorBase;
import com.microsoft.intune.mam.client.app.ActivityLifecycleMonitorBase;
import com.microsoft.intune.mam.client.app.AppIdentitySwitchReason;
import com.microsoft.intune.mam.client.app.AppIdentitySwitchResult;
import com.microsoft.intune.mam.client.app.AppIdentitySwitchResultCallback;
import com.microsoft.intune.mam.client.app.HookedActivity;
import com.microsoft.intune.mam.client.app.IdentitySwitchOption;
import com.microsoft.intune.mam.client.app.MAMApplication;
import com.microsoft.intune.mam.client.app.MAMComponents;
import com.microsoft.intune.mam.client.app.data.AbstractUserDataWiper;
import com.microsoft.intune.mam.client.identity.IdentityParamConverter;
import com.microsoft.intune.mam.client.identity.MAMIdentity;
import com.microsoft.intune.mam.client.identity.MAMIdentityManager;
import com.microsoft.intune.mam.client.identity.MAMPolicyManagerBehavior;
import com.microsoft.intune.mam.client.lifecycle.LifecycleSuppressionRegistry;
import com.microsoft.intune.mam.client.telemetry.events.MAMExternalError;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import com.microsoft.intune.mam.policy.MAMEnrollmentManager;
import com.microsoft.intune.mam.policy.MAMEnrollmentStatusCache;
import com.microsoft.intune.mam.policy.MAMUserInfo;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes3.dex */
public final class OfflineActivityBehavior extends ActivityBehaviorBase {
    public static final String EXTRA_ORIGINAL_FLAGS = "com.microsoft.intune.mam.OriginalFlags";
    private HookedActivity mActivity;
    private boolean mCreated;
    private MAMEnrollmentStatusCache mEnrollmentStatus;
    private final MAMIdentityManager mMAMIdentityManager;
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(OfflineActivityBehavior.class);
    private static boolean sRestartUIShowing = false;
    private static boolean sRestartRequired = false;

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public boolean isLayoutInflaterFactoryInUse() {
        return false;
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        return false;
    }

    public OfflineActivityBehavior(MAMIdentityManager mAMIdentityManager, MAMEnrollmentStatusCache mAMEnrollmentStatusCache, IdentityParamConverter identityParamConverter) {
        super(identityParamConverter);
        this.mCreated = false;
        this.mMAMIdentityManager = mAMIdentityManager;
        this.mEnrollmentStatus = mAMEnrollmentStatusCache;
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public void attachBaseContext(HookedActivity hookedActivity, Context context) {
        this.mActivity = hookedActivity;
        hookedActivity.attachBaseContextReal(context);
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public void onCreate(Bundle bundle) {
        Intent intent = this.mActivity.asActivity().getIntent();
        if (intent != null) {
            try {
                if (intent.hasExtra(EXTRA_ORIGINAL_FLAGS)) {
                    intent.setFlags(intent.getIntExtra(EXTRA_ORIGINAL_FLAGS, intent.getFlags()));
                }
            } catch (RuntimeException e) {
                if ((e.getCause() instanceof ClassNotFoundException) || (e.getCause() instanceof BadParcelableException)) {
                    LOGGER.info("Exception when un-parceling intent extra, this can occur if a MAM app receives an intent that has a bad extra in it. This is not a MAM issue.We are just the first to hit it, continuing.", new Object[0]);
                } else {
                    throw e;
                }
            }
        }
        if (displayBlockingUIIfNecessary()) {
            ((LifecycleSuppressionRegistry) OfflineComponents.get(LifecycleSuppressionRegistry.class)).onActivityCreateSuppressed(this.mActivity.asActivity());
            this.mActivity.onCreateReal(null);
        } else {
            this.mActivity.onMAMCreate(bundle);
            this.mCreated = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean displayBlockingUIIfNecessary() {
        Intent intentCreateIntentForInstallCompanyPortal;
        boolean zIsDefaultMAMEnrollmentEnabled = MAMInfo.isDefaultMAMEnrollmentEnabled();
        boolean zIsCompanyPortalRequired = isCompanyPortalRequired();
        boolean zCheckLaunchBlocked = checkLaunchBlocked();
        boolean zIsNotifyImplicitWipeRequired = isNotifyImplicitWipeRequired();
        if (AbstractUserDataWiper.isWipeInProgress()) {
            LOGGER.info("Offline wipe in progress, we will need to notify when it is finished.", new Object[0]);
            this.mActivity.startActivityForResultReal(createIntentToNotifyWipe(true), -1);
        } else if (this.mEnrollmentStatus.getSystemWipeNotice()) {
            LOGGER.info("System Wipe is triggered, displaying notification dialog now.", new Object[0]);
            this.mActivity.startActivityForResultReal(createIntentToNotifyWipe(false), -1);
        } else if (getRestartRequired()) {
            showRestartUI(this.mActivity.asActivity());
        } else {
            if (!zCheckLaunchBlocked && !zIsCompanyPortalRequired && !zIsDefaultMAMEnrollmentEnabled && !zIsNotifyImplicitWipeRequired) {
                return false;
            }
            MAMLogger mAMLogger = LOGGER;
            mAMLogger.info("OfflineActivityBehavior displaying blocking UI", new Object[0]);
            if (zIsNotifyImplicitWipeRequired) {
                mAMLogger.info("Implicit Wipe just happened from external code, notifying user ...", new Object[0]);
                intentCreateIntentForInstallCompanyPortal = createIntentToNotifyWipe(true);
            } else if (zIsDefaultMAMEnrollmentEnabled) {
                intentCreateIntentForInstallCompanyPortal = createIntentForInstallCompanyPortal();
            } else if (zCheckLaunchBlocked) {
                intentCreateIntentForInstallCompanyPortal = new Intent(this.mActivity.asActivity(), (Class<?>) OfflineStartupBlockedActivity.class);
                intentCreateIntentForInstallCompanyPortal.addFlags(32768);
                intentCreateIntentForInstallCompanyPortal.putExtra("message", (CharSequence) (MAMComponents.getAgentOutdated() ? MAMComponents.getAgentOutdatedMessage() : null));
                intentCreateIntentForInstallCompanyPortal.putExtra("identityAuthority", getIdentityAuthority());
            } else {
                MAMIdentity currentIdentity = getCurrentIdentity();
                if (currentIdentity == null) {
                    mAMLogger.error(MAMExternalError.AGENT_REQUIRED_NO_PRIMARY_IDENTITY, "Company Portal is required but effective identity is null. This should not be possible.", new Object[0]);
                    return false;
                }
                this.mActivity.onMAMCompanyPortalRequired(currentIdentity.rawUPN(), currentIdentity.aadId());
                if (!currentIdentity.equals(getCurrentIdentity()) || !isCompanyPortalRequired()) {
                    return false;
                }
                if (this.mActivity.asActivity().isFinishing()) {
                    return true;
                }
                intentCreateIntentForInstallCompanyPortal = createIntentForInstallCompanyPortal();
            }
            this.mActivity.startActivityForResultReal(intentCreateIntentForInstallCompanyPortal, -1);
        }
        if (this.mCreated) {
            this.mActivity.asActivity().finish();
        } else {
            this.mActivity.finishReal();
        }
        return true;
    }

    private Intent createIntentToNotifyWipe(boolean z) {
        Intent intent = new Intent(this.mActivity.asActivity(), (Class<?>) OfflineNotifyWipeActivity.class);
        intent.setFlags(268435456);
        if (z) {
            intent.putExtra(OfflineStartupBlockedActivity.EXTRA_RESTART_ON_FINISH, true);
            intent.putExtra("android.intent.extra.INTENT", this.mActivity.asActivity().getIntent());
        }
        return intent;
    }

    private boolean showNonBlockingInstallSSPUIIfNeeded() {
        if (isCompanyPortalRequired()) {
            return ((OfflineMAMEnrollmentManager) OfflineComponents.get(OfflineMAMEnrollmentManager.class)).showNonBlockingInstallSSPUIIfNeeded(getCurrentIdentity(), this.mActivity.asActivity());
        }
        return false;
    }

    private void handleWipeInProgress() {
        final Runnable runnable = new Runnable() { // from class: com.microsoft.intune.mam.client.app.offline.OfflineActivityBehavior.1
            @Override // java.lang.Runnable
            public void run() {
                if (OfflineActivityBehavior.this.displayBlockingUIIfNecessary()) {
                    return;
                }
                OfflineActivityBehavior.LOGGER.warning("Waited for wipes to complete, but not displaying blocking UI now. Recreating the activity...", new Object[0]);
                OfflineActivityBehavior.this.mActivity.asActivity().recreate();
            }
        };
        new Thread(new Runnable() { // from class: com.microsoft.intune.mam.client.app.offline.OfflineActivityBehavior.2
            @Override // java.lang.Runnable
            public void run() {
                AbstractUserDataWiper.waitForWipesToComplete();
                OfflineActivityBehavior.this.mActivity.asActivity().runOnUiThread(runnable);
            }
        }, "Intune MAM wipe").start();
    }

    private Intent createIntentForInstallCompanyPortal() {
        Intent intent = new Intent(this.mActivity.asActivity(), (Class<?>) OfflineInstallCompanyPortalDialogActivity.class);
        intent.setFlags(268435456);
        intent.putExtra(OfflineInstallCompanyPortalDialogActivity.ACTIVITY_BLOCKED_EXTRA, true);
        intent.putExtra("identityAuthority", getIdentityAuthority());
        return intent;
    }

    private boolean checkLaunchBlocked() {
        return MAMInfo.isPolicyRequired() || MAMComponents.getAgentOutdated();
    }

    private boolean isCompanyPortalRequired() {
        MAMEnrollmentManager.Result registeredAccountStatus;
        MAMIdentity currentIdentity = getCurrentIdentity();
        return MAMIdentity.isValid(currentIdentity) && (registeredAccountStatus = ((MAMEnrollmentManager) OfflineComponents.get(MAMEnrollmentManager.class)).getRegisteredAccountStatus(currentIdentity.rawUPN(), currentIdentity.aadId())) != null && registeredAccountStatus == MAMEnrollmentManager.Result.COMPANY_PORTAL_REQUIRED;
    }

    private boolean isNotifyImplicitWipeRequired() {
        return this.mEnrollmentStatus.getImplicitWipeNotice();
    }

    private MAMIdentity getCurrentIdentity() {
        MAMIdentity mAMOfflineIdentity = this.mActivity.getMAMOfflineIdentity();
        if (mAMOfflineIdentity != null) {
            return mAMOfflineIdentity;
        }
        MAMIdentity processMAMIdentity = ((MAMPolicyManagerBehavior) OfflineComponents.get(MAMPolicyManagerBehavior.class)).getProcessMAMIdentity();
        if (processMAMIdentity != null) {
            return processMAMIdentity;
        }
        if (MAMInfo.isMultiIdentityEnabled()) {
            return MAMIdentity.EMPTY;
        }
        MAMUserInfo mAMUserInfo = (MAMUserInfo) OfflineComponents.get(MAMUserInfo.class);
        return this.mMAMIdentityManager.create(mAMUserInfo.getPrimaryUser(), mAMUserInfo.getPrimaryUserOID());
    }

    private String getIdentityAuthority() {
        MAMIdentity currentIdentity = getCurrentIdentity();
        if (currentIdentity != null) {
            return currentIdentity.authority();
        }
        return null;
    }

    public static boolean getRestartRequired() {
        return sRestartRequired;
    }

    public static void showRestartUI(Context context) {
        if (sRestartUIShowing) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) OfflineRestartRequiredActivity.class);
        intent.setFlags(805437440);
        context.startActivity(intent);
        sRestartUIShowing = true;
    }

    public static void softRestart(Context context) {
        sRestartRequired = true;
        if (((ActivityLifecycleMonitorBase) OfflineComponents.get(ActivityLifecycleMonitorBase.class)).isAppInForeground()) {
            showRestartUI(context);
        } else {
            MAMApplication.endProcess();
        }
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public void onResume() {
        if (showNonBlockingInstallSSPUIIfNeeded()) {
            ((LifecycleSuppressionRegistry) OfflineComponents.get(LifecycleSuppressionRegistry.class)).onActivityResumeSuppressed(this.mActivity.asActivity());
            this.mActivity.onResumeReal();
        } else {
            this.mActivity.onMAMResume();
        }
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public void onPause() {
        this.mActivity.onMAMPause();
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public void onDestroy() {
        if (this.mCreated) {
            this.mActivity.onMAMDestroy();
        } else {
            this.mActivity.onDestroyReal();
        }
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public void onPostCreate(Bundle bundle) {
        if (this.mCreated) {
            this.mActivity.onMAMPostCreate(bundle);
        } else {
            this.mActivity.onPostCreateReal(bundle);
        }
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public void onPostResume() {
        this.mActivity.onMAMPostResume();
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public void onNewIntent(Intent intent) {
        this.mActivity.onMAMNewIntent(intent);
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public void onSaveInstanceState(Bundle bundle) {
        this.mActivity.onMAMSaveInstanceState(bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public void onUserLeaveHint() {
        if (this.mCreated) {
            this.mActivity.onMAMUserLeaveHint();
        } else {
            this.mActivity.onUserLeaveHintReal();
        }
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public boolean onPictureInPictureRequested() {
        if (this.mCreated) {
            return this.mActivity.onMAMPictureInPictureRequested();
        }
        return this.mActivity.onPictureInPictureRequestedReal();
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public void onMAMCreate(Bundle bundle) {
        this.mActivity.onCreateReal(bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public void onMAMResume() {
        this.mActivity.onResumeReal();
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public void onMAMUserLeaveHint() {
        this.mActivity.onUserLeaveHintReal();
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public boolean onMAMPictureInPictureRequested() {
        return this.mActivity.onPictureInPictureRequestedReal();
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public void onMAMPause() {
        this.mActivity.onPauseReal();
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public void onMAMDestroy() {
        this.mActivity.onDestroyReal();
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public void onMAMPostCreate(Bundle bundle) {
        this.mActivity.onPostCreateReal(bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public void onMAMPostResume() {
        this.mActivity.onPostResumeReal();
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public void onMAMNewIntent(Intent intent) {
        this.mActivity.onNewIntentReal(intent);
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public void onMAMSaveInstanceState(Bundle bundle) {
        this.mActivity.onSaveInstanceStateReal(bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public void startActivityForResult(Intent intent, int i) {
        this.mActivity.startActivityForResultReal(intent, i);
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        this.mActivity.startActivityForResultReal(intent, i, bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public void startActivities(Intent[] intentArr, Bundle bundle) {
        this.mActivity.startActivitiesReal(intentArr, bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public void startActivityFromFragment(Fragment fragment, Intent intent, int i) {
        this.mActivity.startActivityFromFragmentReal(fragment, intent, i);
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public void startActivityFromFragment(Fragment fragment, Intent intent, int i, Bundle bundle) {
        this.mActivity.startActivityFromFragmentReal(fragment, intent, i, bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public boolean startActivityIfNeeded(Intent intent, int i) {
        return this.mActivity.startActivityIfNeededReal(intent, i);
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public boolean startActivityIfNeeded(Intent intent, int i, Bundle bundle) {
        return this.mActivity.startActivityIfNeededReal(intent, i, bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public void onActivityResult(int i, int i2, Intent intent) {
        this.mActivity.onMAMActivityResult(i, i2, intent);
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public void onMAMActivityResult(int i, int i2, Intent intent) {
        this.mActivity.onActivityResultReal(i, i2, intent);
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public void onProvideAssistContent(Object obj) {
        this.mActivity.onMAMRawProvideAssistContent(obj);
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public void onMAMProvideAssistContent(Object obj) {
        this.mActivity.onProvideAssistContentReal((AssistContent) obj);
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public boolean onSearchRequested(Object obj) {
        return this.mActivity.onMAMRawSearchRequested(obj);
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public boolean onMAMSearchRequested(Object obj) {
        return this.mActivity.onSearchRequestedReal((SearchEvent) obj);
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public void switchMAMIdentity(MAMIdentity mAMIdentity, EnumSet<IdentitySwitchOption> enumSet) {
        MAMIdentity mAMOfflineIdentity = this.mActivity.getMAMOfflineIdentity();
        this.mActivity.setMAMOfflineIdentity(mAMIdentity);
        this.mActivity.onSwitchMAMIdentityComplete(MAMIdentitySwitchResult.SUCCEEDED);
        if (mAMOfflineIdentity == null || !mAMOfflineIdentity.equals(mAMIdentity)) {
            displayBlockingUIIfNecessary();
        }
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public void onMAMIdentitySwitchRequired(MAMIdentity mAMIdentity, AppIdentitySwitchReason appIdentitySwitchReason, AppIdentitySwitchResultCallback appIdentitySwitchResultCallback) {
        appIdentitySwitchResultCallback.reportIdentitySwitchResult(AppIdentitySwitchResult.SUCCESS);
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public Uri onProvideReferrer() {
        return this.mActivity.onMAMProvideReferrer();
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public Uri onMAMProvideReferrer() {
        return this.mActivity.onProvideReferrerReal();
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public void onStateNotSaved() {
        this.mActivity.onMAMStateNotSaved();
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public void onMAMStateNotSaved() {
        this.mActivity.onStateNotSavedReal();
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (!this.mCreated) {
            LOGGER.info("Not calling onMAMPrepareOptionsMenu(), blocking UI is being displayed.", new Object[0]);
            return this.mActivity.onPrepareOptionsMenuReal(menu);
        }
        return this.mActivity.onMAMPrepareOptionsMenu(menu);
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mActivity.onMAMCreateView(view, str, context, attributeSet);
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public void onSwitchMAMIdentityComplete(MAMIdentitySwitchResult mAMIdentitySwitchResult) {
        if (mAMIdentitySwitchResult != MAMIdentitySwitchResult.SUCCEEDED) {
            LOGGER.info("Identity switch failed, finishing the activity.", new Object[0]);
            this.mActivity.asActivity().finish();
        }
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.mActivity.registerActivityLifecycleCallbacksReal(MAMApplication.offlineRegisterActivityLifecycleCallbacks(activityLifecycleCallbacks, true));
    }

    @Override // com.microsoft.intune.mam.client.app.ActivityBehavior
    public void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.mActivity.unregisterActivityLifecycleCallbacksReal(MAMApplication.offlineUnregisterActivityLifecycleCallbacks(activityLifecycleCallbacks));
    }
}
