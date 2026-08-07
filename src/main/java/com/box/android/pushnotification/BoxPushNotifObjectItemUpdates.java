package com.box.android.pushnotification;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.box.android.R;
import com.box.android.coreservices.modelcontroller.BoxAppFutureTask;
import com.box.android.coreservices.models.BoxModelOfflineManager;
import com.box.android.domain.services.IAppInBackgroundService;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxCollection;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.boxandroidlibv2private.model.BoxPushNotification;
import com.box.boxandroidlibv2private.requests.BoxRequestDeletePushNotification;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes12.dex */
public abstract class BoxPushNotifObjectItemUpdates extends BoxPushNotifHandler {

    protected interface INotificationMessageUpdate {
        void updateNotificationMessage();
    }

    protected BoxPushNotifObjectItemUpdates(ArrayList<BoxPushNotification> arrayList, UserNotificationManager userNotificationManager, boolean z, IAppInBackgroundService iAppInBackgroundService) {
        super(arrayList, userNotificationManager, z, iAppInBackgroundService);
    }

    @Override // com.box.android.pushnotification.BoxPushNotifHandler
    protected NotificationCompat.Builder getBuilder(Context context, int i, BoxPushNotification boxPushNotification) {
        NotificationCompat.Builder builder = super.getBuilder(context, i, boxPushNotification);
        builder.addAction(0, context.getString(R.string.mute_updates_button), buildMuteIntent(context, i));
        return builder;
    }

    private abstract class UpdatesParentOp {
        private UpdatesParentOp() {
        }

        public void abortNotificationProcessing() {
            deletePushNotification(BoxPushNotifObjectItemUpdates.this.getLatestNotification());
            BoxPushNotifObjectItemUpdates.this.mPendingOps.abort();
        }

        public void deletePushNotification(BoxPushNotification boxPushNotification) {
            try {
                new BoxRequestDeletePushNotification(null, boxPushNotification).sendForCachedResult();
            } catch (BoxException e) {
                BoxLogUtils.logException("deletePushNotification", "Failed to delete push notification", e);
            }
        }
    }

    class CheckFileRelevantOp extends UpdatesParentOp implements BoxPushNotifHandler.Operation, BoxAppFutureTask.OnCompletedListener, BoxFutureTask.OnCompletedListener {
        private static final int FAVORITES_CHECK_STATE = 1;
        private static final int FILE_INFO_STATE = 0;
        private static final int USER_INFO_STATE = 2;
        private BoxFile mBoxFile;
        private BoxPushNotifHandler.GetFavoriteCollectionOp mFavoritesOp;
        private String mFileId;
        private BoxPushNotifHandler mNotifHandler;
        private INotificationMessageUpdate mNotifMsgUpdate;
        private BoxPushNotifHandler.PendingOps mPendingOps;
        private int mState;

        protected CheckFileRelevantOp(String str, INotificationMessageUpdate iNotificationMessageUpdate) {
            super();
            this.mFileId = str;
            this.mNotifMsgUpdate = iNotificationMessageUpdate;
            this.mState = 0;
        }

        @Override // com.box.android.pushnotification.BoxPushNotifHandler.Operation
        public void execute(BoxPushNotifHandler.PendingOps pendingOps, BoxPushNotifHandler boxPushNotifHandler) {
            if (this.mFavoritesOp != null) {
                return;
            }
            this.mNotifHandler = boxPushNotifHandler;
            this.mPendingOps = pendingOps;
            BoxFutureTask task = boxPushNotifHandler.mUserNotificationManager.getFileApi().getInfoRequest(this.mFileId).setFields(BoxApiPrivate.BASE_FIELDS).toTask();
            task.addOnCompletedListener(this);
            this.mNotifHandler.mUserNotificationManager.executeTask(task);
        }

        @Override // com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
        public void onCompleted(BoxResponse boxResponse) {
            BoxFile boxFile;
            int i = this.mState;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        BoxPushNotification latestNotification = this.mNotifHandler.getLatestNotification();
                        if (boxResponse.isSuccess()) {
                            BoxUser boxUser = (BoxUser) boxResponse.getResult();
                            if (boxUser != null) {
                                latestNotification.setSourceUserName(boxUser.getUserName());
                            }
                        } else {
                            latestNotification.setSourceUserId("-1");
                        }
                        if (postProcess(latestNotification)) {
                            return;
                        }
                    }
                } else if (boxResponse.isSuccess()) {
                    this.mPendingOps.onOperationCompleted(this.mFavoritesOp);
                    BoxCollection boxCollection = (BoxCollection) boxResponse.getResult();
                    if (boxCollection != null && (boxFile = this.mBoxFile) != null) {
                        Iterator<BoxCollection> it = boxFile.getCollections().iterator();
                        while (it.hasNext()) {
                            if (it.next().getUserId().equals(boxCollection.getUserId())) {
                                this.mPendingOps.onOperationCompleted(this);
                                return;
                            }
                        }
                    }
                }
            } else if (boxResponse.isSuccess()) {
                this.mBoxFile = (BoxFile) boxResponse.getResult();
                BoxPushNotification latestNotification2 = this.mNotifHandler.getLatestNotification();
                BoxFile boxFile2 = this.mBoxFile;
                if (boxFile2 != null) {
                    if (boxFile2.getPermissions() == null || !this.mBoxFile.getPermissions().contains(BoxItem.Permission.CAN_PREVIEW)) {
                        abortNotificationProcessing();
                        return;
                    }
                    latestNotification2.setTargetResourceName(this.mBoxFile.getName());
                    if (!latestNotification2.isAnonymousNotification() && this.mBoxFile != null && TextUtils.isEmpty(latestNotification2.getSourceUserName())) {
                        this.mState = 2;
                        BoxFutureTask task = this.mNotifHandler.mUserNotificationManager.getUserApi().getUserInfoRequest(latestNotification2.getSourceUserId()).toTask();
                        task.addOnCompletedListener(this);
                        this.mNotifHandler.mUserNotificationManager.executeTask(task);
                        return;
                    }
                }
                if (postProcess(latestNotification2)) {
                    return;
                }
            }
            abortNotificationProcessing();
        }

        private boolean postProcess(BoxPushNotification boxPushNotification) {
            BoxPushNotifObjectItemUpdates.this.setOrDownloadUserAvatar(boxPushNotification);
            this.mNotifMsgUpdate.updateNotificationMessage();
            String eventTag = boxPushNotification.getEventTag();
            if (eventTag == null || !eventTag.equals(BoxPushNotification.UNFILTERED_UPDATE_TAG)) {
                boxPushNotification.setTargetResourceName(this.mBoxFile.getName());
                BoxPushNotifObjectItemUpdates.this.updateNotification(boxPushNotification);
                this.mPendingOps.onOperationCompleted(this);
                return true;
            }
            BoxFile boxFile = this.mBoxFile;
            if (boxFile == null) {
                return false;
            }
            if (BoxModelOfflineManager.isOfflineUserSavedBlocking(boxFile, this.mNotifHandler.mUserNotificationManager.getUserContextManager())) {
                this.mPendingOps.onOperationCompleted(this);
                return true;
            }
            this.mState = 1;
            BoxPushNotifHandler.GetFavoriteCollectionOp getFavoriteCollectionOp = new BoxPushNotifHandler.GetFavoriteCollectionOp(this);
            this.mFavoritesOp = getFavoriteCollectionOp;
            this.mPendingOps.add(getFavoriteCollectionOp);
            this.mFavoritesOp.execute(this.mPendingOps, this.mNotifHandler);
            return true;
        }
    }
}
