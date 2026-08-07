package com.google.androidbrowserhelper.trusted;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.browser.trusted.TrustedWebActivityCallbackRemote;

/* JADX INFO: loaded from: classes13.dex */
public class NotificationDelegationExtraCommandHandler implements ExtraCommandHandler {
    static final String COMMAND_CHECK_NOTIFICATION_PERMISSION = "checkNotificationPermission";
    private static final String COMMAND_GET_NOTIFICATION_PERMISSION_REQUEST_PENDING_INTENT = "getNotificationPermissionRequestPendingIntent";
    private static final String KEY_NOTIFICATION_CHANNEL_NAME = "notificationChannelName";
    private static final String KEY_NOTIFICATION_PERMISSION_REQUEST_PENDING_INTENT = "notificationPermissionRequestPendingIntent";

    @Override // com.google.androidbrowserhelper.trusted.ExtraCommandHandler
    public Bundle handleExtraCommand(Context context, String str, Bundle bundle, TrustedWebActivityCallbackRemote trustedWebActivityCallbackRemote) {
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("success", false);
        String string = bundle.getString(KEY_NOTIFICATION_CHANNEL_NAME);
        str.hashCode();
        if (str.equals(COMMAND_CHECK_NOTIFICATION_PERMISSION)) {
            if (!TextUtils.isEmpty(string)) {
                int i = !NotificationUtils.areNotificationsEnabled(context, string) ? 1 : 0;
                if (i == 1 && !PrefUtils.hasRequestedNotificationPermission(context)) {
                    i = 2;
                }
                bundle2.putInt("permissionStatus", i);
                bundle2.putBoolean("success", true);
                return bundle2;
            }
        } else if (str.equals(COMMAND_GET_NOTIFICATION_PERMISSION_REQUEST_PENDING_INTENT) && !TextUtils.isEmpty(string)) {
            bundle2.putParcelable(KEY_NOTIFICATION_PERMISSION_REQUEST_PENDING_INTENT, NotificationPermissionRequestActivity.createPermissionRequestPendingIntent(context, string));
            bundle2.putBoolean("success", true);
            return bundle2;
        }
        return bundle2;
    }
}
