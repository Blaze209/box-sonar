package com.box.android.pushnotification;

import android.content.Context;
import com.box.android.R;
import com.box.android.application.BoxBaseApplication;
import com.box.android.domain.services.IAppInBackgroundService;
import com.box.boxandroidlibv2private.model.BoxPushNotification;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes12.dex */
public class BoxPushNotifObjectCollaborations extends BoxPushNotifHandler {
    public BoxPushNotifObjectCollaborations(ArrayList<BoxPushNotification> arrayList, UserNotificationManager userNotificationManager, boolean z, IAppInBackgroundService iAppInBackgroundService) {
        super(arrayList, userNotificationManager, z, iAppInBackgroundService);
    }

    @Override // com.box.android.pushnotification.BoxPushNotifHandler
    public void doHandle() {
        BoxPushNotification latestNotification = getLatestNotification();
        setTitle(getTitleBasedOnResourceType(latestNotification));
        setContentText(getMessageBasedOnNotification(latestNotification));
        setWhen(System.currentTimeMillis());
        setSmallIcon(2131231969);
        setOrDownloadUserAvatar(latestNotification);
    }

    private String getTitleBasedOnResourceType(BoxPushNotification boxPushNotification) {
        Context applicationContext = BoxBaseApplication.getInstance().getApplicationContext();
        if (boxPushNotification.getTargetResourceType().equals("file")) {
            return applicationContext.getString(R.string.file_collaboration_notification_title);
        }
        return applicationContext.getString(R.string.folder_collaboration_notification_title);
    }

    private String getMessageBasedOnNotification(BoxPushNotification boxPushNotification) {
        if (isNotificationAnonymized(boxPushNotification)) {
            Context applicationContext = BoxBaseApplication.getInstance().getApplicationContext();
            if (boxPushNotification.getTargetResourceType().equals("file")) {
                return applicationContext.getString(R.string.anonymized_added_to_collaborate_on_a_file);
            }
            return applicationContext.getString(R.string.anonymized_added_to_collaborate_on_a_folder);
        }
        return boxPushNotification.getMessage();
    }

    private boolean isNotificationAnonymized(BoxPushNotification boxPushNotification) {
        return boxPushNotification.getSourceUserName() == null;
    }

    @Override // com.box.android.pushnotification.BoxPushNotifHandler
    protected void updateNotification(BoxPushNotification boxPushNotification) {
        boxPushNotification.setDisplayTitle(getTitle());
        boxPushNotification.setDisplayMessage(getMessageBasedOnNotification(boxPushNotification));
    }

    @Override // com.box.android.pushnotification.BoxPushNotifHandler
    public BoxPushNotification.PushNotifType getNotifType() {
        return BoxPushNotification.PushNotifType.COLLAB_INVITE_COLLABORATOR;
    }
}
