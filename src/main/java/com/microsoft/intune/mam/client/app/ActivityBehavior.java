package com.microsoft.intune.mam.client.app;

import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import com.microsoft.intune.mam.client.MAMIdentitySwitchResult;
import com.microsoft.intune.mam.client.identity.MAMIdentity;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes3.dex */
public interface ActivityBehavior {
    void attachBaseContext(HookedActivity hookedActivity, Context context);

    boolean isLayoutInflaterFactoryInUse();

    void onActivityResult(int i, int i2, Intent intent);

    void onCreate(Bundle bundle);

    boolean onCreateThumbnail(Bitmap bitmap, Canvas canvas);

    View onCreateView(View view, String str, Context context, AttributeSet attributeSet);

    void onDestroy();

    void onMAMActivityResult(int i, int i2, Intent intent);

    void onMAMCreate(Bundle bundle);

    void onMAMDestroy();

    void onMAMIdentitySwitchRequired(MAMIdentity mAMIdentity, AppIdentitySwitchReason appIdentitySwitchReason, AppIdentitySwitchResultCallback appIdentitySwitchResultCallback);

    @Deprecated
    void onMAMIdentitySwitchRequired(String str, AppIdentitySwitchReason appIdentitySwitchReason, AppIdentitySwitchResultCallback appIdentitySwitchResultCallback);

    void onMAMNewIntent(Intent intent);

    void onMAMPause();

    boolean onMAMPictureInPictureRequested();

    void onMAMPostCreate(Bundle bundle);

    void onMAMPostResume();

    void onMAMProvideAssistContent(Object obj);

    Uri onMAMProvideReferrer();

    void onMAMResume();

    void onMAMSaveInstanceState(Bundle bundle);

    boolean onMAMSearchRequested(Object obj);

    void onMAMStateNotSaved();

    void onMAMUserLeaveHint();

    void onNewIntent(Intent intent);

    void onPause();

    boolean onPictureInPictureRequested();

    void onPostCreate(Bundle bundle);

    void onPostResume();

    boolean onPrepareOptionsMenu(Menu menu);

    void onProvideAssistContent(Object obj);

    Uri onProvideReferrer();

    void onResume();

    void onSaveInstanceState(Bundle bundle);

    boolean onSearchRequested(Object obj);

    void onStateNotSaved();

    void onSwitchMAMIdentityComplete(MAMIdentitySwitchResult mAMIdentitySwitchResult);

    void onUserLeaveHint();

    void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks);

    void startActivities(Intent[] intentArr, Bundle bundle);

    void startActivityForResult(Intent intent, int i);

    void startActivityForResult(Intent intent, int i, Bundle bundle);

    void startActivityFromFragment(Fragment fragment, Intent intent, int i);

    void startActivityFromFragment(Fragment fragment, Intent intent, int i, Bundle bundle);

    boolean startActivityIfNeeded(Intent intent, int i);

    boolean startActivityIfNeeded(Intent intent, int i, Bundle bundle);

    void switchMAMIdentity(MAMIdentity mAMIdentity, EnumSet<IdentitySwitchOption> enumSet);

    @Deprecated
    void switchMAMIdentity(String str);

    @Deprecated
    void switchMAMIdentity(String str, EnumSet<IdentitySwitchOption> enumSet);

    void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks);
}
