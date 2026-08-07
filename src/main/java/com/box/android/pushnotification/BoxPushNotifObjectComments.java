package com.box.android.pushnotification;

import android.app.PendingIntent;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.app.RemoteInput;
import com.box.android.R;
import com.box.android.application.BoxBaseApplication;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.models.BoxPushNotificationV1;
import com.box.android.domain.analytics.BoxAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.services.IAppInBackgroundService;
import com.box.android.receiver.CommentsReplyReceiver;
import com.box.boxandroidlibv2private.model.BoxPushNotification;
import com.microsoft.intune.mam.client.app.MAMPendingIntent;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class BoxPushNotifObjectComments extends BoxPushNotifHandler {
    public static final String KEY_TEXT_REPLY = "key_text_reply";
    NotificationCompat.MessagingStyle mMessagingStyle;
    private boolean mShouldHaveMute;

    public BoxPushNotifObjectComments(ArrayList<BoxPushNotification> arrayList, UserNotificationManager userNotificationManager, boolean z, IAppInBackgroundService iAppInBackgroundService) {
        super(arrayList, userNotificationManager, z, iAppInBackgroundService);
    }

    @Override // com.box.android.pushnotification.BoxPushNotifHandler
    protected NotificationCompat.Builder getBuilder(Context context, int i, BoxPushNotification boxPushNotification) {
        BoxPushNotification latestNotification = getLatestNotification();
        NotificationCompat.Builder builder = super.getBuilder(context, i, latestNotification);
        String string = context.getResources().getString(R.string.reply);
        RemoteInput remoteInputBuild = new RemoteInput.Builder(KEY_TEXT_REPLY).setLabel(string).build();
        PendingIntent broadcast = MAMPendingIntent.getBroadcast(context, i, CommentsReplyReceiver.getReplyMessageIntent(context, i, 0, latestNotification.getTargetResourceId(), this.ids), 167772160);
        if (this.mShouldHaveMute) {
            builder.addAction(0, context.getString(R.string.mute_conversation_button), buildMuteIntent(context, i));
        }
        builder.addAction(new NotificationCompat.Action.Builder(0, string, broadcast).addRemoteInput(remoteInputBuild).build());
        builder.setStyle(this.mMessagingStyle);
        return builder;
    }

    private void buildFromSingleObject(BoxPushNotification boxPushNotification) {
        setContentText(boxPushNotification.getMessage());
        setWhen(System.currentTimeMillis());
        NotificationCompat.MessagingStyle messagingStyle = new NotificationCompat.MessagingStyle("");
        this.mMessagingStyle = messagingStyle;
        messagingStyle.setConversationTitle(getDisplayTitle(boxPushNotification));
        this.mMessagingStyle.addMessage(buildMessage(BoxBaseApplication.getInstance().getApplicationContext(), boxPushNotification));
        setSmallIcon(2131231969);
        this.mShouldHaveMute = !isMentionedNotification(boxPushNotification);
        setOrDownloadUserAvatar(boxPushNotification);
    }

    private static NotificationCompat.MessagingStyle.Message buildMessage(Context context, BoxPushNotification boxPushNotification) {
        return new NotificationCompat.MessagingStyle.Message(boxPushNotification.getCommentMessage(), System.currentTimeMillis(), boxPushNotification.getSourceUserName());
    }

    private void buildFromMultipleObjects(List<BoxPushNotification> list) {
        String string;
        BoxPushNotification boxPushNotification = list.get(list.size() - 1);
        setWhen(System.currentTimeMillis());
        setSmallIcon(2131231969);
        String sourceUserId = list.get(0).getSourceUserId();
        NotificationCompat.MessagingStyle messagingStyle = new NotificationCompat.MessagingStyle("");
        this.mMessagingStyle = messagingStyle;
        messagingStyle.setConversationTitle(String.format(CommonBoxUtil.plural(R.array.new_comments_notification_title, list.size()), boxPushNotification.getTargetResourceName()));
        boolean z = true;
        int i = 0;
        for (BoxPushNotification boxPushNotification2 : list) {
            if (!TextUtils.equals(sourceUserId, boxPushNotification2.getSourceUserId())) {
                z = false;
            }
            if (isMentionedNotification(boxPushNotification2)) {
                i++;
            }
            this.mShouldHaveMute |= !isMentionedNotification(boxPushNotification2);
            this.mMessagingStyle.addMessage(buildMessage(BoxBaseApplication.getInstance().getApplicationContext(), boxPushNotification2));
        }
        if (isSinglePluralFormat(list.get(list.size() - 1))) {
            if (i == 0) {
                string = String.format(boxPushNotification.getPluralFormat(), Integer.valueOf(list.size()));
            } else {
                string = BoxBaseApplication.getInstance().getResources().getString(R.string.mentioned_notifications, Integer.valueOf(i));
            }
            setContentText(string);
        } else {
            setContentText(BoxBaseApplication.getInstance().getResources().getString(R.string.Pushnotif_comments, Integer.valueOf(list.size())));
        }
        if (z) {
            setOrDownloadUserAvatar(list.get(0));
        } else {
            this.mIsGroup = true;
            setLargeIcon("group", this.mUserNotificationManager.getGroupUserBitmap());
        }
    }

    public static boolean isMentionedNotification(BoxPushNotification boxPushNotification) {
        return TextUtils.equals(boxPushNotification.getEventTag(), BoxPushNotification.MENTIONED_NOTIFICATION_TAG);
    }

    public String getDisplayTitle(BoxPushNotification boxPushNotification) {
        if (boxPushNotification instanceof BoxPushNotificationV1) {
            return ((BoxPushNotificationV1) boxPushNotification).getTitle();
        }
        if (isMentionedNotification(boxPushNotification)) {
            return BoxBaseApplication.getInstance().getString(R.string.mentioned_you, new Object[]{boxPushNotification.getSourceUserName()});
        }
        return String.format(CommonBoxUtil.plural(R.array.new_comments_notification_title, 1), getLatestNotification().getTargetResourceName());
    }

    @Override // com.box.android.pushnotification.BoxPushNotifHandler
    public void doHandle() {
        BoxPushNotification latestNotification = getLatestNotification();
        if (this.mNotificationData.size() > 1) {
            buildFromMultipleObjects(this.mNotificationData);
            BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_PUSH_NOTIFICATIONS, "collapse", getLatestNotification().getNotifTypeString());
        } else {
            buildFromSingleObject(latestNotification);
        }
    }

    @Override // com.box.android.pushnotification.BoxPushNotifHandler
    protected void updateNotification(BoxPushNotification boxPushNotification) {
        boxPushNotification.setDisplayMessage(boxPushNotification.getCommentMessage());
        boxPushNotification.setDisplayTitle(getDisplayTitle(boxPushNotification));
    }

    @Override // com.box.android.pushnotification.BoxPushNotifHandler
    public BoxPushNotification.PushNotifType getNotifType() {
        return BoxPushNotification.PushNotifType.COMMENT_CREATE;
    }
}
