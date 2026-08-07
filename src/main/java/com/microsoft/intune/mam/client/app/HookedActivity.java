package com.microsoft.intune.mam.client.app;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes3.dex */
public interface HookedActivity extends HookedContextWrapper, MAMActivityBlockingListener, MAMActivityIdentityRequirementListener, MAMActivityIdentitySwitchListener {
    Activity asActivity();

    void finishReal();

    ActivityBehavior getBehavior();

    void onActivityResultReal(int i, int i2, Intent intent);

    void onCreateReal(Bundle bundle);

    void onDestroyReal();

    void onMAMActivityResult(int i, int i2, Intent intent);

    void onMAMCreate(Bundle bundle);

    View onMAMCreateView(View view, String str, Context context, AttributeSet attributeSet);

    void onMAMDestroy();

    @Deprecated
    void onMAMIdentitySwitchRequired(String str, AppIdentitySwitchResultCallback appIdentitySwitchResultCallback);

    void onMAMNewIntent(Intent intent);

    void onMAMPause();

    boolean onMAMPictureInPictureRequested();

    void onMAMPostCreate(Bundle bundle);

    void onMAMPostResume();

    boolean onMAMPrepareOptionsMenu(Menu menu);

    Uri onMAMProvideReferrer();

    void onMAMRawProvideAssistContent(Object obj);

    boolean onMAMRawSearchRequested(Object obj);

    void onMAMResume();

    void onMAMSaveInstanceState(Bundle bundle);

    void onMAMStateNotSaved();

    void onMAMUserLeaveHint();

    void onNewIntentReal(Intent intent);

    void onPauseReal();

    boolean onPictureInPictureRequestedReal();

    void onPostCreateReal(Bundle bundle);

    void onPostResumeReal();

    boolean onPrepareOptionsMenuReal(Menu menu);

    void onProvideAssistContentReal(Object obj);

    Uri onProvideReferrerReal();

    void onResumeReal();

    void onSaveInstanceStateReal(Bundle bundle);

    boolean onSearchRequestedReal(Object obj);

    void onStateNotSavedReal();

    void onUserLeaveHintReal();

    void registerActivityLifecycleCallbacksReal(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks);

    void startActivitiesReal(Intent[] intentArr, Bundle bundle);

    void startActivityForResultReal(Intent intent, int i);

    void startActivityForResultReal(Intent intent, int i, Bundle bundle);

    void startActivityFromFragmentReal(Fragment fragment, Intent intent, int i);

    void startActivityFromFragmentReal(Fragment fragment, Intent intent, int i, Bundle bundle);

    boolean startActivityIfNeededReal(Intent intent, int i);

    boolean startActivityIfNeededReal(Intent intent, int i, Bundle bundle);

    @Deprecated
    void switchMAMIdentity(String str, EnumSet<IdentitySwitchOption> enumSet);

    void switchMAMIdentityOID(String str, EnumSet<IdentitySwitchOption> enumSet);

    void unregisterActivityLifecycleCallbacksReal(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks);

    @Deprecated
    default void switchMAMIdentity(String str) {
        switchMAMIdentity(str, EnumSet.noneOf(IdentitySwitchOption.class));
    }

    default void switchMAMIdentityOID(String str) {
        switchMAMIdentityOID(str, EnumSet.noneOf(IdentitySwitchOption.class));
    }
}
