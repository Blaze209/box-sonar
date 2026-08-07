package com.box.android.pushnotification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.box.android.R;
import com.box.android.activities.NotificationInterceptorActivity;
import com.box.android.application.BoxBaseApplication;
import com.box.android.base.BoxNotificationManager;
import com.box.android.coreservices.modelcontroller.BoxAppFutureTask;
import com.box.android.coreservices.modelcontroller.messages.BoxResponseMessage;
import com.box.android.coreservices.models.BoxPushNotificationV1;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.localrepo.sqlitetables.BoxPushNotificationSQLData;
import com.box.android.domain.services.IAppInBackgroundService;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxCollection;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.boxandroidlibv2private.model.BoxPushNotification;
import com.box.boxandroidlibv2private.requests.BoxRequestGetFavoritesCollection;
import com.box.boxandroidlibv2private.requests.BoxRequestStorePushNotification;
import com.microsoft.intune.mam.client.app.MAMPendingIntent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public abstract class BoxPushNotifHandler {
    protected static final String GROUP_USER_ID = "group";
    private String contentInfo;
    private String contentText;
    protected ArrayList<String> ids;
    protected IAppInBackgroundService mAppInBackgroundService;
    protected boolean mIsGroup;
    protected List<BoxPushNotification> mNotificationData;
    protected boolean mNotifyUser;
    protected PendingOps mPendingOps;
    private int mPriority;
    private HashMap<String, Bitmap> mUserIdToLargeIconMap;
    protected UserNotificationManager mUserNotificationManager;
    private int smallIcon;
    private String title;
    private long when;

    protected interface Operation {
        void execute(PendingOps pendingOps, BoxPushNotifHandler boxPushNotifHandler);
    }

    protected abstract void doHandle();

    public abstract BoxPushNotification.PushNotifType getNotifType();

    protected abstract void updateNotification(BoxPushNotification boxPushNotification);

    protected BoxPushNotifHandler(IAppInBackgroundService iAppInBackgroundService) {
        this.mUserIdToLargeIconMap = new HashMap<>();
        this.mPriority = 1;
        this.mAppInBackgroundService = iAppInBackgroundService;
    }

    protected BoxPushNotifHandler(ArrayList<BoxPushNotification> arrayList, UserNotificationManager userNotificationManager, boolean z, IAppInBackgroundService iAppInBackgroundService) {
        this(iAppInBackgroundService);
        this.mUserNotificationManager = userNotificationManager;
        this.mNotificationData = arrayList;
        this.mNotifyUser = z;
        buildNotifIds(arrayList);
        this.mPendingOps = new PendingOps(this);
    }

    /* JADX INFO: renamed from: com.box.android.pushnotification.BoxPushNotifHandler$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$box$boxandroidlibv2private$model$BoxPushNotification$PushNotifType;

        static {
            int[] iArr = new int[BoxPushNotification.PushNotifType.values().length];
            $SwitchMap$com$box$boxandroidlibv2private$model$BoxPushNotification$PushNotifType = iArr;
            try {
                iArr[BoxPushNotification.PushNotifType.COLLAB_INVITE_COLLABORATOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$box$boxandroidlibv2private$model$BoxPushNotification$PushNotifType[BoxPushNotification.PushNotifType.COMMENT_CREATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$box$boxandroidlibv2private$model$BoxPushNotification$PushNotifType[BoxPushNotification.PushNotifType.ITEM_MODIFY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$box$boxandroidlibv2private$model$BoxPushNotification$PushNotifType[BoxPushNotification.PushNotifType.ITEM_UPLOAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static BoxPushNotifHandler create(ArrayList<BoxPushNotification> arrayList, BoxPushNotification.PushNotifType pushNotifType, UserNotificationManager userNotificationManager, boolean z, IAppInBackgroundService iAppInBackgroundService) {
        int i = AnonymousClass1.$SwitchMap$com$box$boxandroidlibv2private$model$BoxPushNotification$PushNotifType[pushNotifType.ordinal()];
        if (i == 1) {
            return new BoxPushNotifObjectCollaborations(arrayList, userNotificationManager, z, iAppInBackgroundService);
        }
        if (i == 2) {
            return new BoxPushNotifObjectComments(arrayList, userNotificationManager, z, iAppInBackgroundService);
        }
        if (i == 3) {
            return new BoxPushNotifObjectItemModify(arrayList, userNotificationManager, z, iAppInBackgroundService);
        }
        if (i != 4) {
            return null;
        }
        return new BoxPushNotifObjectItemUpload(arrayList, userNotificationManager, z, iAppInBackgroundService);
    }

    public BoxPushNotification getLatestNotification() {
        BoxPushNotification boxPushNotification = this.mNotificationData.get(0);
        Long bestNotifTime = BoxPushNotificationSQLData.getBestNotifTime(boxPushNotification);
        for (int i = 1; i < this.mNotificationData.size(); i++) {
            BoxPushNotification boxPushNotification2 = this.mNotificationData.get(i);
            Long bestNotifTime2 = BoxPushNotificationSQLData.getBestNotifTime(boxPushNotification2);
            if (bestNotifTime != null && bestNotifTime2 != null && bestNotifTime2.longValue() > bestNotifTime.longValue()) {
                boxPushNotification = boxPushNotification2;
                bestNotifTime = bestNotifTime2;
            }
        }
        return boxPushNotification;
    }

    protected String getTitle() {
        return this.title;
    }

    protected void setTitle(String str) {
        this.title = str;
    }

    protected String getContentText() {
        return this.contentText;
    }

    protected void setContentText(String str) {
        this.contentText = str;
    }

    protected String getContentInfo() {
        return this.contentInfo;
    }

    protected long getWhen() {
        return this.when;
    }

    protected void setWhen(long j) {
        this.when = j;
    }

    protected void setPriority(int i) {
        if (i > 2 || i < -2) {
            return;
        }
        this.mPriority = i;
    }

    protected void setLargeIcon(String str, Bitmap bitmap) {
        this.mUserIdToLargeIconMap.put(str, bitmap);
    }

    protected int getSmallIcon() {
        return this.smallIcon;
    }

    protected void setSmallIcon(int i) {
        this.smallIcon = i;
    }

    private PendingIntent buildContentIntent(Context context, int i) {
        BoxPushNotification latestNotification = getLatestNotification();
        return MAMPendingIntent.getActivity(context, i, NotificationInterceptorActivity.getLaunchIntent(this.ids, latestNotification.getTargetResourceId(), latestNotification.getTargetResourceName(), latestNotification.getNotifType(), context, latestNotification instanceof BoxPushNotificationV1 ? ((BoxPushNotificationV1) latestNotification).getRedirectUrl() : null, latestNotification.getCommentId()), 201326592);
    }

    private PendingIntent buildDismissIntent(Context context, int i) {
        BoxPushNotification latestNotification = getLatestNotification();
        return MAMPendingIntent.getActivity(context, -i, NotificationInterceptorActivity.getDismissIntent(this.ids, latestNotification.getTargetResourceId(), latestNotification.getTargetResourceName(), latestNotification.getNotifType(), context), 201326592);
    }

    protected PendingIntent buildMuteIntent(Context context, int i) {
        BoxPushNotification latestNotification = getLatestNotification();
        Intent muteIntent = NotificationInterceptorActivity.getMuteIntent(this.ids, latestNotification.getTargetResourceId(), latestNotification.getTargetResourceName(), latestNotification.getNotifType(), context, i);
        muteIntent.setData(Uri.parse("notification://muteNotification"));
        return MAMPendingIntent.getActivity(context, i, muteIntent, 201326592);
    }

    private void publishNotif(Context context) {
        BoxPushNotification latestNotification = getLatestNotification();
        int iBuildNotifId = buildNotifId(latestNotification.getTargetResourceId(), latestNotification.getTargetResourceType(), latestNotification.getNotifType());
        Notification notificationBuild = getBuilder(context, iBuildNotifId, latestNotification).build();
        notificationBuild.flags = 24;
        notificationBuild.defaults = this.mPriority < 0 ? 4 : -1;
        BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_PUSH_NOTIFICATIONS, BoxAnalyticsParams.ACTION_NOTIFICATION_DISPLAYED, latestNotification.getNotifType().name());
        BoxNotificationManager.notify(iBuildNotifId, notificationBuild);
        if (this.mAppInBackgroundService.isAppInBackground()) {
            BoxAmplitudeAnalytics.createPushNotifEventPropertyBuilder().logPushNotifDisplayed(latestNotification.getNotifType());
        }
    }

    protected NotificationCompat.Builder getBuilder(Context context, int i, BoxPushNotification boxPushNotification) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, getChannelId(boxPushNotification));
        builder.setPriority(this.mPriority);
        builder.setVibrate(new long[0]);
        builder.setSmallIcon(getSmallIcon()).setContentTitle(getTitle()).setColor(context.getResources().getColor(R.color.box_blue)).setContentTitle(getTitle()).setContentInfo(getContentInfo()).setContentText(getContentText()).setWhen(getWhen());
        builder.setContentIntent(buildContentIntent(context, i));
        builder.setDeleteIntent(buildDismissIntent(context, i));
        Bitmap largeIcon = getLargeIcon(boxPushNotification.getSourceUserId());
        if (largeIcon != null) {
            builder.setLargeIcon(largeIcon);
        }
        builder.setStyle(new NotificationCompat.BigTextStyle().bigText(getContentText()));
        return builder;
    }

    private String getChannelId(BoxPushNotification boxPushNotification) {
        int i = AnonymousClass1.$SwitchMap$com$box$boxandroidlibv2private$model$BoxPushNotification$PushNotifType[boxPushNotification.getNotifType().ordinal()];
        if (i == 1) {
            return BoxNotificationManager.COLLABORATIONS_CHANNEL_ID;
        }
        if (i == 2) {
            return BoxNotificationManager.COMMENTS_CHANNEL_ID;
        }
        if (i == 3 || i == 4) {
            return BoxNotificationManager.UPDATES_CHANNEL_ID;
        }
        return null;
    }

    protected Bitmap getLargeIcon(String str) {
        if (this.mIsGroup) {
            return this.mUserIdToLargeIconMap.get("group");
        }
        return this.mUserIdToLargeIconMap.get(str);
    }

    public static int buildNotifId(BoxPushNotification boxPushNotification) {
        return buildNotifId(boxPushNotification.getTargetResourceId(), boxPushNotification.getTargetResourceType(), boxPushNotification.getNotifType());
    }

    private static int buildNotifId(String str, String str2, BoxPushNotification.PushNotifType pushNotifType) {
        return new ResourceAndNotifType(str, str2, pushNotifType).toIntIdentifier();
    }

    private void buildNotifIds(ArrayList<BoxPushNotification> arrayList) {
        this.ids = new ArrayList<>();
        Iterator<BoxPushNotification> it = arrayList.iterator();
        while (it.hasNext()) {
            this.ids.add(it.next().getUserId());
        }
    }

    protected static boolean isSinglePluralFormat(BoxPushNotification boxPushNotification) {
        String pluralFormat = boxPushNotification.getPluralFormat();
        return (pluralFormat == null || !pluralFormat.contains("%1$s") || pluralFormat.contains("%2$s")) ? false : true;
    }

    protected void setOrDownloadUserAvatar(BoxPushNotification boxPushNotification) {
        String sourceUserId = boxPushNotification.getSourceUserId();
        String sourceUserName = boxPushNotification.getSourceUserName();
        setLargeIcon(sourceUserId, this.mUserNotificationManager.getBestBitmapIconForUser(sourceUserId, sourceUserName));
        if (this.mUserNotificationManager.getAvatarFile(sourceUserId).exists() || boxPushNotification.isAnonymousNotification()) {
            return;
        }
        this.mPendingOps.add(new GetAvatarOp(sourceUserId, sourceUserName));
    }

    protected void onPendingOpsFinished() {
        if (this.mNotifyUser && this.mUserNotificationManager.allowNotificationType(getNotifType())) {
            publishNotif(BoxBaseApplication.getInstance().getApplicationContext());
        }
    }

    public void doProcessNotifications() {
        Iterator<BoxPushNotification> it = this.mNotificationData.iterator();
        while (it.hasNext()) {
            updateNotification(it.next());
        }
        doHandle();
        this.mPendingOps.start();
    }

    protected class PendingOps {
        private BoxPushNotifHandler mNotifHandler;
        private List<Operation> mPendingOps = new ArrayList();

        public PendingOps(BoxPushNotifHandler boxPushNotifHandler) {
            this.mNotifHandler = boxPushNotifHandler;
        }

        public void add(Operation operation) {
            this.mPendingOps.add(operation);
        }

        public void onOperationCompleted(Operation operation) {
            this.mPendingOps.remove(operation);
            if (this.mPendingOps.size() > 0) {
                this.mPendingOps.get(0).execute(this, this.mNotifHandler);
            } else {
                onFinish();
            }
        }

        protected void start() {
            this.mPendingOps.add(new SaveNotificationCheckMuteOp());
            if (this.mPendingOps.size() > 0) {
                this.mPendingOps.get(0).execute(this, this.mNotifHandler);
            } else {
                onFinish();
            }
        }

        private void onFinish() {
            this.mNotifHandler.onPendingOpsFinished();
        }

        protected void abort() {
            this.mPendingOps.clear();
        }
    }

    protected static class GetAvatarOp implements Operation, BoxFutureTask.OnCompletedListener {
        private BoxPushNotifHandler mNotifHandler;
        private PendingOps mPendingOps;
        private String mUserId;
        private String mUserName;

        protected GetAvatarOp(String str, String str2) {
            this.mUserId = str;
            this.mUserName = str2;
        }

        @Override // com.box.android.pushnotification.BoxPushNotifHandler.Operation
        public void execute(PendingOps pendingOps, BoxPushNotifHandler boxPushNotifHandler) {
            this.mNotifHandler = boxPushNotifHandler;
            this.mPendingOps = pendingOps;
            if (!boxPushNotifHandler.mUserNotificationManager.getAvatarFile(this.mUserId).exists()) {
                this.mNotifHandler.mUserNotificationManager.executeAvatarDownloadRequest(this.mUserId, this);
                return;
            }
            BoxPushNotifHandler boxPushNotifHandler2 = this.mNotifHandler;
            boxPushNotifHandler2.setLargeIcon(this.mUserId, boxPushNotifHandler2.mUserNotificationManager.getBestBitmapIconForUser(this.mUserId, this.mUserName));
            this.mPendingOps.onOperationCompleted(this);
        }

        @Override // com.box.androidsdk.content.BoxFutureTask.OnCompletedListener
        public void onCompleted(BoxResponse boxResponse) {
            if (this.mNotifHandler.mUserNotificationManager.getAvatarFile(((BoxRequestsFile.DownloadAvatar) boxResponse.getRequest()).getId()).exists()) {
                this.mPendingOps.mNotifHandler.setLargeIcon(((BoxRequestsFile.DownloadAvatar) boxResponse.getRequest()).getId(), this.mNotifHandler.mUserNotificationManager.getBestBitmapIconForUser(((BoxRequestsFile.DownloadAvatar) boxResponse.getRequest()).getId(), null));
            }
            this.mPendingOps.onOperationCompleted(this);
        }
    }

    protected static class GetFavoriteCollectionOp implements Operation, BoxAppFutureTask.OnCompletedListener {
        private BoxFutureTask.OnCompletedListener mListener;
        private BoxPushNotifHandler mNotifHandler;

        public GetFavoriteCollectionOp(BoxFutureTask.OnCompletedListener onCompletedListener) {
            this.mListener = onCompletedListener;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.box.android.pushnotification.BoxPushNotifHandler.Operation
        public void execute(PendingOps pendingOps, BoxPushNotifHandler boxPushNotifHandler) {
            this.mNotifHandler = boxPushNotifHandler;
            BoxRequestGetFavoritesCollection favoritesCollectionRequest = boxPushNotifHandler.mUserNotificationManager.getFavoritesCollectionRequest();
            try {
                onCompleted(new BoxResponse((BoxCollection) favoritesCollectionRequest.send(), null, favoritesCollectionRequest));
            } catch (BoxException e) {
                onCompleted(new BoxResponse(null, e, favoritesCollectionRequest));
            }
        }

        @Override // com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
        public void onCompleted(BoxResponse boxResponse) {
            this.mListener.onCompleted(boxResponse);
        }
    }

    private static class SaveNotificationCheckMuteOp implements Operation, BoxAppFutureTask.OnCompletedListener {
        private BoxPushNotifHandler mNotifHandler;

        private SaveNotificationCheckMuteOp() {
        }

        @Override // com.box.android.pushnotification.BoxPushNotifHandler.Operation
        public void execute(PendingOps pendingOps, BoxPushNotifHandler boxPushNotifHandler) {
            this.mNotifHandler = boxPushNotifHandler;
            BoxResponse boxResponse = null;
            for (BoxPushNotification boxPushNotification : boxPushNotifHandler.mNotificationData) {
                boxPushNotification.setIsProcessed();
                BoxRequestStorePushNotification storePushNotificationRequest = this.mNotifHandler.mUserNotificationManager.getStorePushNotificationRequest(boxPushNotification);
                try {
                    BoxPushNotification boxPushNotificationSendForCachedResult = storePushNotificationRequest.sendForCachedResult();
                    if (boxResponse == null) {
                        boxResponse = new BoxResponse(boxPushNotificationSendForCachedResult, null, storePushNotificationRequest);
                    }
                } catch (BoxException e) {
                    boxResponse = new BoxResponse(null, e, storePushNotificationRequest);
                }
            }
            onCompleted(boxResponse);
        }

        @Override // com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
        public void onCompleted(BoxResponse boxResponse) {
            if (boxResponse.isSuccess()) {
                BoxPushNotification boxPushNotification = (BoxPushNotification) boxResponse.getResult();
                if (boxPushNotification != null && boxPushNotification.getMuteTypes() != null && boxPushNotification.getMuteTypes().contains(this.mNotifHandler.getNotifType().getMuteCollectionType())) {
                    this.mNotifHandler.mPendingOps.mNotifHandler.mNotifyUser = false;
                    BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_PUSH_NOTIFICATIONS, BoxAnalyticsParams.ACTION_NOTIFICATION_DROPPED, boxPushNotification.getNotifTypeString());
                }
                LocalBroadcastManager.getInstance(BoxBaseApplication.getInstance()).sendBroadcast(new BoxResponseMessage(boxResponse, false));
            }
            this.mNotifHandler.mPendingOps.onOperationCompleted(this);
        }
    }
}
