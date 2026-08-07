package com.google.androidbrowserhelper.trusted;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import com.microsoft.intune.mam.client.app.MAMActivity;
import com.microsoft.intune.mam.client.app.MAMPendingIntent;

/* JADX INFO: loaded from: classes13.dex */
public class NotificationPermissionRequestActivity extends MAMActivity {
    private static final String EXTRA_MESSENGER = "messenger";
    private static final String EXTRA_NOTIFICATION_CHANNEL_NAME = "notificationChannelName";
    static final String KEY_PERMISSION_STATUS = "permissionStatus";
    private static final String PERMISSION_POST_NOTIFICATIONS = "android.permission.POST_NOTIFICATIONS";
    private static final String TAG = "Notifications";
    private static final int VERSION_T = 33;
    private String mChannelName;
    private Messenger mMessenger;

    public static PendingIntent createPermissionRequestPendingIntent(Context context, String str) {
        Intent intent = new Intent(context.getApplicationContext(), (Class<?>) NotificationPermissionRequestActivity.class);
        intent.putExtra(EXTRA_NOTIFICATION_CHANNEL_NAME, str);
        return MAMPendingIntent.getActivity(context.getApplicationContext(), 0, intent, Build.VERSION.SDK_INT >= 31 ? 33554432 : 0);
    }

    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        this.mChannelName = getIntent().getStringExtra(EXTRA_NOTIFICATION_CHANNEL_NAME);
        Messenger messenger = (Messenger) getIntent().getParcelableExtra(EXTRA_MESSENGER);
        this.mMessenger = messenger;
        if (this.mChannelName == null || messenger == null) {
            Log.w(TAG, "Finishing because no channel name or messenger for returning the result was provided.");
            finish();
        } else {
            if (Build.VERSION.SDK_INT >= 33 && getApplicationContext().getApplicationInfo().targetSdkVersion < 33) {
                NotificationUtils.createNotificationChannel(this, this.mChannelName);
            }
            ActivityCompat.requestPermissions(this, new String[]{PERMISSION_POST_NOTIFICATIONS}, 0);
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        boolean zAreNotificationsEnabled = false;
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (strArr[i2].equals(PERMISSION_POST_NOTIFICATIONS)) {
                PrefUtils.setHasRequestedNotificationPermission(this);
                if (iArr[i2] != 0) {
                    break;
                }
                zAreNotificationsEnabled = true;
                break;
            }
        }
        if (!zAreNotificationsEnabled) {
            zAreNotificationsEnabled = NotificationUtils.areNotificationsEnabled(this, this.mChannelName);
        }
        sendPermissionMessage(this.mMessenger, zAreNotificationsEnabled);
        finish();
    }

    private static void sendPermissionMessage(Messenger messenger, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_PERMISSION_STATUS, !z ? 1 : 0);
        Message messageObtain = Message.obtain();
        messageObtain.setData(bundle);
        try {
            messenger.send(messageObtain);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
