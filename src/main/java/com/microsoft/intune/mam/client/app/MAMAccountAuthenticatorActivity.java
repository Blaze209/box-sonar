package com.microsoft.intune.mam.client.app;

import android.accounts.AccountAuthenticatorActivity;
import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.assist.AssistContent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.SearchEvent;
import android.view.View;
import com.microsoft.intune.mam.client.MAMIdentitySwitchResult;
import com.microsoft.intune.mam.client.identity.ExternalIdentityUtils;
import com.microsoft.intune.mam.client.identity.MAMIdentity;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MAMAccountAuthenticatorActivity extends AccountAuthenticatorActivity implements HookedActivity {
    ActivityBehavior mBehavior;
    private MAMIdentity mOfflineIdentity;
    private static final Class<?> CLASS = MAMAccountAuthenticatorActivity.class;
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(MAMAccountAuthenticatorActivity.class);
    private static final ThreadLocal<String> IDENTITY_SWITCH_OID = new ThreadLocal<>();

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public final Activity asActivity() {
        return this;
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        LOGGER.entering("attachBaseContext");
        try {
            MAMComponents.initialize(context);
            ActivityBehavior activityBehavior = (ActivityBehavior) MAMComponents.get(ActivityBehavior.class);
            this.mBehavior = activityBehavior;
            activityBehavior.attachBaseContext(this, context);
        } finally {
            LOGGER.exiting("attachBaseContext");
        }
    }

    @Override // com.microsoft.intune.mam.client.app.HookedContextWrapper
    public final void attachBaseContextReal(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.accounts.AccountAuthenticatorActivity, android.app.Activity
    protected final void onCreate(Bundle bundle) {
        LOGGER.entering("onCreate");
        try {
            this.mBehavior.onCreate(bundle);
        } finally {
            LOGGER.exiting("onCreate");
        }
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        LOGGER.entering("onMAMCreate");
        try {
            this.mBehavior.onMAMCreate(bundle);
        } finally {
            LOGGER.exiting("onMAMCreate");
        }
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public final void onCreateReal(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    protected final void onResume() {
        LOGGER.entering("onResume");
        try {
            this.mBehavior.onResume();
        } finally {
            LOGGER.exiting("onResume");
        }
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMResume() {
        LOGGER.entering("onMAMResume");
        try {
            this.mBehavior.onMAMResume();
        } finally {
            LOGGER.exiting("onMAMResume");
        }
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public final void onResumeReal() {
        super.onResume();
    }

    @Override // android.app.Activity
    protected final void onPause() {
        this.mBehavior.onPause();
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMPause() {
        this.mBehavior.onMAMPause();
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public final void onPauseReal() {
        super.onPause();
    }

    @Override // android.app.Activity
    protected final void onPostCreate(Bundle bundle) {
        LOGGER.entering("onPostCreate");
        try {
            this.mBehavior.onPostCreate(bundle);
        } finally {
            LOGGER.exiting("onPostCreate");
        }
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMPostCreate(Bundle bundle) {
        LOGGER.entering("onMAMPostCreate");
        try {
            this.mBehavior.onMAMPostCreate(bundle);
        } finally {
            LOGGER.exiting("onMAMPostCreate");
        }
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public final void onPostCreateReal(Bundle bundle) {
        super.onPostCreate(bundle);
    }

    @Override // android.app.Activity
    protected final void onPostResume() {
        LOGGER.entering("onPostResume");
        try {
            this.mBehavior.onPostResume();
        } finally {
            LOGGER.exiting("onPostResume");
        }
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMPostResume() {
        LOGGER.entering("onMAMPostResume");
        try {
            this.mBehavior.onMAMPostResume();
        } finally {
            LOGGER.exiting("onMAMPostResume");
        }
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public final void onPostResumeReal() {
        super.onPostResume();
    }

    @Override // android.app.Activity
    protected final void onDestroy() {
        this.mBehavior.onDestroy();
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMDestroy() {
        this.mBehavior.onMAMDestroy();
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public final void onDestroyReal() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected final void onNewIntent(Intent intent) {
        this.mBehavior.onNewIntent(intent);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMNewIntent(Intent intent) {
        this.mBehavior.onMAMNewIntent(intent);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public final void onNewIntentReal(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override // android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        this.mBehavior.onSaveInstanceState(bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMSaveInstanceState(Bundle bundle) {
        this.mBehavior.onMAMSaveInstanceState(bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public final void onSaveInstanceStateReal(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        this.mBehavior.onUserLeaveHint();
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMUserLeaveHint() {
        this.mBehavior.onMAMUserLeaveHint();
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public final void onUserLeaveHintReal() {
        super.onUserLeaveHint();
    }

    @Override // android.app.Activity
    public boolean onPictureInPictureRequested() {
        return this.mBehavior.onPictureInPictureRequested();
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public boolean onMAMPictureInPictureRequested() {
        return this.mBehavior.onMAMPictureInPictureRequested();
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public boolean onPictureInPictureRequestedReal() {
        return super.onPictureInPictureRequested();
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        this.mBehavior.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        this.mBehavior.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr, Bundle bundle) {
        this.mBehavior.startActivities(intentArr, bundle);
    }

    @Override // android.app.Activity
    public void startActivityFromFragment(Fragment fragment, Intent intent, int i) {
        this.mBehavior.startActivityFromFragment(fragment, intent, i);
    }

    @Override // android.app.Activity
    public void startActivityFromFragment(Fragment fragment, Intent intent, int i, Bundle bundle) {
        this.mBehavior.startActivityFromFragment(fragment, intent, i, bundle);
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent intent, int i) {
        return this.mBehavior.startActivityIfNeeded(intent, i);
    }

    @Override // android.app.Activity
    public boolean startActivityIfNeeded(Intent intent, int i, Bundle bundle) {
        return this.mBehavior.startActivityIfNeeded(intent, i, bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public final void startActivityForResultReal(Intent intent, int i) {
        super.startActivityForResult(intent, i, null);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public final void startActivityForResultReal(Intent intent, int i, Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public final void startActivitiesReal(Intent[] intentArr, Bundle bundle) {
        super.startActivities(intentArr, bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public final void startActivityFromFragmentReal(Fragment fragment, Intent intent, int i) {
        super.startActivityFromFragment(fragment, intent, i, null);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public final void startActivityFromFragmentReal(Fragment fragment, Intent intent, int i, Bundle bundle) {
        super.startActivityFromFragment(fragment, intent, i, bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public final boolean startActivityIfNeededReal(Intent intent, int i) {
        return super.startActivityIfNeeded(intent, i, null);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public final boolean startActivityIfNeededReal(Intent intent, int i, Bundle bundle) {
        return super.startActivityIfNeeded(intent, i, bundle);
    }

    @Override // android.app.Activity
    protected final void onActivityResult(int i, int i2, Intent intent) {
        this.mBehavior.onActivityResult(i, i2, intent);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMActivityResult(int i, int i2, Intent intent) {
        this.mBehavior.onMAMActivityResult(i, i2, intent);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public final void onActivityResultReal(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public final void finishReal() {
        super.finish();
    }

    @Override // android.app.Activity
    public boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas) {
        return this.mBehavior.onCreateThumbnail(bitmap, canvas);
    }

    @Override // android.app.Activity
    public final void onProvideAssistContent(AssistContent assistContent) {
        this.mBehavior.onProvideAssistContent(assistContent);
    }

    public void onMAMProvideAssistContent(AssistContent assistContent) {
        this.mBehavior.onMAMProvideAssistContent(assistContent);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public final void onMAMRawProvideAssistContent(Object obj) {
        onMAMProvideAssistContent((AssistContent) obj);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public final void onProvideAssistContentReal(Object obj) {
        super.onProvideAssistContent((AssistContent) obj);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onSearchRequested(SearchEvent searchEvent) {
        return this.mBehavior.onSearchRequested(searchEvent);
    }

    public boolean onMAMSearchRequested(SearchEvent searchEvent) {
        return this.mBehavior.onMAMSearchRequested(searchEvent);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public final boolean onMAMRawSearchRequested(Object obj) {
        return onMAMSearchRequested((SearchEvent) obj);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public final boolean onSearchRequestedReal(Object obj) {
        return super.onSearchRequested((SearchEvent) obj);
    }

    @Override // android.app.Activity
    public Uri onProvideReferrer() {
        return this.mBehavior.onProvideReferrer();
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public Uri onMAMProvideReferrer() {
        return this.mBehavior.onMAMProvideReferrer();
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public final Uri onProvideReferrerReal() {
        return super.onProvideReferrer();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mBehavior.onStateNotSaved();
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMStateNotSaved() {
        this.mBehavior.onMAMStateNotSaved();
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public final void onStateNotSavedReal() {
        super.onStateNotSaved();
    }

    @Override // android.app.Activity
    public final boolean onPrepareOptionsMenu(Menu menu) {
        return this.mBehavior.onPrepareOptionsMenu(menu);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public boolean onMAMPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public final boolean onPrepareOptionsMenuReal(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mBehavior.onCreateView(view, str, context, attributeSet);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public View onMAMCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    @Deprecated
    public final void onMAMIdentitySwitchRequired(String str, AppIdentitySwitchResultCallback appIdentitySwitchResultCallback) {
        throw new IllegalStateException("This method is no longer valid. Use the three-parameter version");
    }

    @Override // com.microsoft.intune.mam.client.app.MAMActivityIdentityRequirementListener
    @Deprecated
    public void onMAMIdentitySwitchRequired(String str, AppIdentitySwitchReason appIdentitySwitchReason, AppIdentitySwitchResultCallback appIdentitySwitchResultCallback) {
        this.mBehavior.onMAMIdentitySwitchRequired(ExternalIdentityUtils.fromUpnAndOid(str, IDENTITY_SWITCH_OID.get()), appIdentitySwitchReason, appIdentitySwitchResultCallback);
    }

    @Override // com.microsoft.intune.mam.client.app.MAMActivityIdentityRequirementListener
    public void onMAMIdentitySwitchRequired(String str, String str2, AppIdentitySwitchReason appIdentitySwitchReason, AppIdentitySwitchResultCallback appIdentitySwitchResultCallback) {
        IDENTITY_SWITCH_OID.set(str2);
        try {
            onMAMIdentitySwitchRequired(str, appIdentitySwitchReason, appIdentitySwitchResultCallback);
        } finally {
            IDENTITY_SWITCH_OID.remove();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public static void defaultOnMAMIdentitySwitchRequired(Activity activity, String str, AppIdentitySwitchReason appIdentitySwitchReason, AppIdentitySwitchResultCallback appIdentitySwitchResultCallback) {
        if (activity instanceof HookedActivity) {
            defaultOnMAMIdentitySwitchRequired(activity, str, IDENTITY_SWITCH_OID.get(), appIdentitySwitchReason, appIdentitySwitchResultCallback);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void defaultOnMAMIdentitySwitchRequired(Activity activity, String str, String str2, AppIdentitySwitchReason appIdentitySwitchReason, AppIdentitySwitchResultCallback appIdentitySwitchResultCallback) {
        if (activity instanceof HookedActivity) {
            ((HookedActivity) activity).getBehavior().onMAMIdentitySwitchRequired(ExternalIdentityUtils.fromUpnAndOid(str, str2), appIdentitySwitchReason, appIdentitySwitchResultCallback);
        }
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public final ActivityBehavior getBehavior() {
        return this.mBehavior;
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    @Deprecated
    public final void switchMAMIdentity(String str, EnumSet<IdentitySwitchOption> enumSet) {
        this.mBehavior.switchMAMIdentity(str, enumSet);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public final void switchMAMIdentityOID(String str, EnumSet<IdentitySwitchOption> enumSet) {
        this.mBehavior.switchMAMIdentity(ExternalIdentityUtils.identityFromOID(str), enumSet);
    }

    @Override // com.microsoft.intune.mam.client.app.MAMActivityIdentitySwitchListener
    public void onSwitchMAMIdentityComplete(MAMIdentitySwitchResult mAMIdentitySwitchResult) {
        this.mBehavior.onSwitchMAMIdentityComplete(mAMIdentitySwitchResult);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedContextWrapper
    public void setMAMOfflineIdentity(MAMIdentity mAMIdentity) {
        this.mOfflineIdentity = mAMIdentity;
    }

    @Override // com.microsoft.intune.mam.client.app.HookedContextWrapper
    public MAMIdentity getMAMOfflineIdentity() {
        return this.mOfflineIdentity;
    }

    @Override // android.app.Activity
    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.mBehavior.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public void registerActivityLifecycleCallbacksReal(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        super.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    @Override // android.app.Activity
    public void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.mBehavior.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedActivity
    public void unregisterActivityLifecycleCallbacksReal(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        super.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }
}
