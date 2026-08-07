package com.box.android.pushnotification;

import android.text.TextUtils;
import com.box.android.R;
import com.box.android.application.BoxBaseApplication;
import com.box.android.domain.services.IAppInBackgroundService;
import com.box.boxandroidlibv2private.model.BoxPushNotification;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes12.dex */
public class BoxPushNotifObjectItemUpload extends BoxPushNotifObjectItemUpdates implements BoxPushNotifObjectItemUpdates.INotificationMessageUpdate {
    private String mFileId;

    public BoxPushNotifObjectItemUpload(ArrayList<BoxPushNotification> arrayList, UserNotificationManager userNotificationManager, boolean z, IAppInBackgroundService iAppInBackgroundService) {
        super(arrayList, userNotificationManager, z, iAppInBackgroundService);
    }

    @Override // com.box.android.pushnotification.BoxPushNotifHandler
    public BoxPushNotification.PushNotifType getNotifType() {
        return BoxPushNotification.PushNotifType.ITEM_UPLOAD;
    }

    @Override // com.box.android.pushnotification.BoxPushNotifHandler
    public void doHandle() {
        this.mFileId = getLatestNotification().getTargetResourceId();
        setWhen(System.currentTimeMillis());
        setSmallIcon(2131231969);
        setPriority(-1);
        addDependencyOps();
    }

    private void addDependencyOps() {
        this.mPendingOps.add(new BoxPushNotifObjectItemUpdates.CheckFileRelevantOp(this.mFileId, this));
    }

    @Override // com.box.android.pushnotification.BoxPushNotifObjectItemUpdates.INotificationMessageUpdate
    public void updateNotificationMessage() {
        BoxPushNotification latestNotification = getLatestNotification();
        setTitle(latestNotification.getTargetResourceName());
        setNotificationMessage(latestNotification);
    }

    @Override // com.box.android.pushnotification.BoxPushNotifHandler
    protected void updateNotification(BoxPushNotification boxPushNotification) {
        setTitle(BoxBaseApplication.getInstance().getApplicationContext().getString(R.string.update_notification_title));
        setNotificationMessage(boxPushNotification);
    }

    private void setNotificationMessage(BoxPushNotification boxPushNotification) {
        String string;
        String eventTag = boxPushNotification.getEventTag();
        if (TextUtils.isEmpty(boxPushNotification.getSourceUserId())) {
            if (eventTag != null && eventTag.equalsIgnoreCase(BoxPushNotification.UNFILTERED_UPDATE_TAG)) {
                string = BoxBaseApplication.getInstance().getString(R.string.file_upload_anonymous_push_notification_body);
            } else {
                string = BoxBaseApplication.getInstance().getString(R.string.upload_anonymous_notication_message, new Object[]{boxPushNotification.getTargetResourceName()});
            }
        } else if (eventTag != null && eventTag.equalsIgnoreCase(BoxPushNotification.UNFILTERED_UPDATE_TAG)) {
            string = BoxBaseApplication.getInstance().getString(R.string.file_upload_push_notification_body, new Object[]{boxPushNotification.getSourceUserName()});
        } else {
            string = BoxBaseApplication.getInstance().getString(R.string.upload_notication_message, new Object[]{boxPushNotification.getSourceUserName(), boxPushNotification.getTargetResourceName()});
        }
        boxPushNotification.setDisplayMessage(string);
        setContentText(string);
    }
}
