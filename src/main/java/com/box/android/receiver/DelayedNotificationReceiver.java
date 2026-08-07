package com.box.android.receiver;

import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.box.android.application.BoxBaseApplication;
import com.box.android.controller.ExecutorPool;
import com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.identity.IUserContextComponent;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.IAppInBackgroundService;
import com.box.android.pushnotification.BoxPushNotifHandler;
import com.box.android.pushnotification.UserNotificationManager;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.auth.BoxAuthentication;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import com.box.boxandroidlibv2private.model.BoxIteratorBoxPushNotification;
import com.box.boxandroidlibv2private.model.BoxPushNotification;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import com.microsoft.intune.mam.client.app.MAMPendingIntent;
import java.util.concurrent.ThreadPoolExecutor;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes12.dex */
public class DelayedNotificationReceiver extends Hilt_DelayedNotificationReceiver {
    public static final String EXTRA_NOTIFICATION = "notification";
    public static final String EXTRA_SHOULD_UPDATE_UI = "shouldUpdateUI";

    @Inject
    protected BoxApiPrivate mApiPrivate;

    @Inject
    protected IAppInBackgroundService mAppInBgService;

    @Inject
    protected IMoCoBoxGlobalSettings mGlobalSettings;

    @Inject
    protected IUserContextManager mUserContextManager;
    private UserNotificationManager mUserNotificationManager;

    public DelayedNotificationReceiver() {
        try {
            BoxBaseApplication.getInstance().mCreationCountDownLatch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            BoxLogUtils.v("isApplication in background: " + this.mAppInBgService.isAppInBackground());
            BoxLogUtils.logException("Unable to start application", e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0043 A[RETURN] */
    private boolean initNotificationManager() {
        if (this.mUserNotificationManager == null || !TextUtils.equals(this.mUserContextManager.getCurrentContextId(), this.mUserNotificationManager.getUserId())) {
            if (this.mUserContextManager.hasValidUserId() && !this.mUserContextManager.isSwitchingOrDestroyingUser()) {
                this.mUserNotificationManager = new UserNotificationManager(this.mUserContextManager.getBoxSession(BoxBaseApplication.getInstance()), this.mUserContextManager, this.mGlobalSettings, this.mAppInBgService);
                if (this.mUserNotificationManager != null) {
                    return true;
                }
            }
        } else if (this.mUserNotificationManager != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void dispatchNotification(Intent intent) {
        String stringExtra = intent.getStringExtra("notification");
        BoxPushNotification boxPushNotification = null;
        if (stringExtra != null) {
            try {
                BoxIteratorBoxPushNotification boxIteratorBoxPushNotificationSendForCachedResult = this.mApiPrivate.getPushNotificationsRequest().setShowNonProcessed(true).setNotificationId(stringExtra).sendForCachedResult();
                if (boxIteratorBoxPushNotificationSendForCachedResult != null && boxIteratorBoxPushNotificationSendForCachedResult.size() > 0) {
                    boxPushNotification = (BoxPushNotification) boxIteratorBoxPushNotificationSendForCachedResult.get(0);
                }
            } catch (BoxException e) {
                BoxLogUtils.v("isApplication in background: " + this.mAppInBgService.isAppInBackground());
                BoxLogUtils.logException("unable to fetch stored notification", e);
            }
        }
        boolean booleanExtra = intent.getBooleanExtra(EXTRA_SHOULD_UPDATE_UI, false);
        if (stringExtra == null || boxPushNotification != null) {
            this.mUserNotificationManager.updateDeviceNotification(booleanExtra);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.box.android.receiver.DelayedNotificationReceiver$1] */
    @Override // com.box.android.receiver.Hilt_DelayedNotificationReceiver, com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
    public void onMAMReceive(Context context, final Intent intent) {
        super.onMAMReceive(context, intent);
        String lastAuthenticatedUserId = BoxAuthentication.getInstance().getLastAuthenticatedUserId(BoxBaseApplication.getInstance());
        if (!SdkUtils.isBlank(lastAuthenticatedUserId) && !this.mUserContextManager.hasValidUserId() && !this.mUserContextManager.isSwitchingOrDestroyingUser()) {
            try {
                this.mUserContextManager.createUser(lastAuthenticatedUserId, this.mApiPrivate);
            } catch (IUserContextComponent.UserContextComponentCreationException e) {
                BoxLogUtils.e("BoxGcmListenerService", e);
            }
        }
        if (!initNotificationManager()) {
            BoxLogUtils.v("isApplication in background: " + this.mAppInBgService.isAppInBackground());
            BoxLogUtils.logException("DelayedNotificationReceiver.onReceive", "Unable to initialize NotificationManager.", new RuntimeException("Unable to create notification manager"));
        } else {
            ThreadPoolExecutor notificationExecutor = ((ExecutorPool) this.mUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.EXECUTOR_POOL)).getNotificationExecutor();
            if (notificationExecutor == null) {
                return;
            }
            new AsyncTask<Void, Void, Void>() { // from class: com.box.android.receiver.DelayedNotificationReceiver.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public Void doInBackground(Void... voidArr) {
                    DelayedNotificationReceiver.this.dispatchNotification(intent);
                    return null;
                }
            }.executeOnExecutor(notificationExecutor, new Void[0]);
        }
    }

    public static synchronized void notify(Context context, boolean z, long j, BoxPushNotification boxPushNotification) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        int iBuildNotifId = j > 0 ? BoxPushNotifHandler.buildNotifId(boxPushNotification) : 0;
        Intent intent = new Intent(context, (Class<?>) DelayedNotificationReceiver.class);
        intent.putExtra(EXTRA_SHOULD_UPDATE_UI, z);
        if (boxPushNotification != null) {
            intent.putExtra("notification", boxPushNotification.getUserId());
        }
        alarmManager.set(2, SystemClock.elapsedRealtime() + j, MAMPendingIntent.getBroadcast(context, iBuildNotifId, intent, 201326592));
    }

    public static synchronized void notify(Context context, boolean z, BoxPushNotification boxPushNotification) {
        if (z && boxPushNotification != null) {
            if (boxPushNotification.getPreviousDismissTime() != null) {
                long jLongValue = (boxPushNotification.getPreviousDismissTime().longValue() + 14400000) - System.currentTimeMillis();
                if (jLongValue > 0) {
                    notify(context, true, jLongValue + 3000, boxPushNotification);
                    return;
                }
            }
        }
        notify(context, z, 0L, boxPushNotification);
    }
}
