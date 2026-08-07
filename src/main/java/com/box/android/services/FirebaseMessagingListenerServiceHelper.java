package com.box.android.services;

import android.content.Context;
import android.os.Bundle;
import com.box.android.application.BoxBaseApplication;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.models.BoxPushNotificationV1;
import com.box.android.domain.analytics.BoxAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.receiver.DelayedNotificationReceiver;
import com.box.android.utilities.BoxUtils;
import com.box.androidsdk.content.auth.BoxAuthentication;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.boxandroidlibv2private.model.BoxPushNotification;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import com.google.firebase.messaging.RemoteMessage;
import java.util.Map;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes13.dex */
public class FirebaseMessagingListenerServiceHelper {
    protected BoxApiPrivate mApiPrivate;
    protected FeatureFlips mFeatureFlips;
    protected IUserContextManager mUserContextManager;

    @Inject
    public FirebaseMessagingListenerServiceHelper(IUserContextManager iUserContextManager, BoxApiPrivate boxApiPrivate, FeatureFlips featureFlips) {
        this.mUserContextManager = iUserContextManager;
        this.mApiPrivate = boxApiPrivate;
        this.mFeatureFlips = featureFlips;
    }

    private void logNotification(Context context, BoxPushNotification boxPushNotification, Bundle bundle) {
        StringBuffer stringBuffer = new StringBuffer(boxPushNotification.getNotifTypeString());
        if (!boxPushNotification.getNotifType().equals(BoxPushNotification.PushNotifType.ITEM_MODIFY) && !boxPushNotification.getNotifType().equals(BoxPushNotification.PushNotifType.ITEM_UPLOAD)) {
            BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_PUSH_NOTIFICATIONS, "receive", stringBuffer.toString());
        }
        BoxUtils.logcatBundle(bundle, context);
    }

    public void onMessageReceived(Context context, RemoteMessage remoteMessage) {
        Map<String, String> data = remoteMessage.getData();
        data.put(BoxPushNotification.FIREBASE_SENT_TIME, String.valueOf(remoteMessage.getSentTime()));
        messageHandler(context, CommonBoxUtil.convertMapToBundle(data));
    }

    void messageHandler(Context context, Bundle bundle) {
        BoxPushNotification boxPushNotification;
        if (bundle == null) {
            return;
        }
        if ("1".equals(bundle.getString(BoxPushNotificationV1.FIELD_NOTIFICATION_VERSION))) {
            boxPushNotification = new BoxPushNotificationV1(bundle);
        } else {
            boxPushNotification = new BoxPushNotification(bundle);
        }
        try {
            logNotification(context, boxPushNotification, bundle);
            storeNotification(context, boxPushNotification);
        } catch (IllegalArgumentException | NullPointerException e) {
            BoxLogUtils.logException(e);
        }
    }

    private void storeNotification(Context context, BoxPushNotification boxPushNotification) {
        try {
            BoxPushNotification boxPushNotificationSendForCachedResult = this.mApiPrivate.getStorePushNotificationRequest(boxPushNotification).sendForCachedResult();
            if (isForCurrentUser(context, boxPushNotification)) {
                DelayedNotificationReceiver.notify(BoxBaseApplication.getInstance(), true, boxPushNotificationSendForCachedResult);
            }
        } catch (Exception e) {
            BoxLogUtils.e("Problem storing notification", e);
            BoxLogUtils.logException("FirebaseMessagingListenerServiceHelper", "Problem storing notification", e);
        }
    }

    private boolean isForCurrentUser(Context context, BoxPushNotification boxPushNotification) {
        String lastAuthenticatedUserId;
        if (this.mUserContextManager.hasValidUserId()) {
            lastAuthenticatedUserId = this.mUserContextManager.getCurrentContextId();
        } else {
            lastAuthenticatedUserId = BoxAuthentication.getInstance().getLastAuthenticatedUserId(context);
        }
        return lastAuthenticatedUserId != null && lastAuthenticatedUserId.equals(boxPushNotification.getTargetUserId());
    }
}
