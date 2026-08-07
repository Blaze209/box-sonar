package com.box.android.pushnotification;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.box.android.R;
import com.box.android.application.BoxBaseApplication;
import com.box.android.controller.ExecutorPool;
import com.box.android.coreservices.modelcontroller.IMoCoBoxGlobalSettings;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.IAppInBackgroundService;
import com.box.androidsdk.content.BoxApiUser;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxDownload;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import com.box.androidsdk.content.views.DefaultAvatarController;
import com.box.boxandroidlibv2private.model.BoxIteratorBoxPushNotification;
import com.box.boxandroidlibv2private.model.BoxPushNotification;
import com.box.boxandroidlibv2private.requests.BoxRequestGetFavoritesCollection;
import com.box.boxandroidlibv2private.requests.BoxRequestStorePushNotification;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiCollections;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public class UserNotificationManager {
    public static final int DISMISS_GRACE_PERIOD_MS = 14400000;
    protected final BoxApiPrivate mApiPrivate;
    private final IAppInBackgroundService mAppInBgService;
    private final DefaultAvatarController mAvatarController;
    private final BoxApiUser mBoxApiUser;
    protected final BoxExtendedApiFile mBoxExtendedApiFile;
    protected final BoxExtendedApiCollections mCollectionsApi;
    private final Context mContext = BoxBaseApplication.getInstance();
    protected final IMoCoBoxGlobalSettings mGlobalSettings;
    private final BoxSession mSession;
    private final IUserContextManager mUserContextManager;

    public UserNotificationManager(BoxSession boxSession, IUserContextManager iUserContextManager, IMoCoBoxGlobalSettings iMoCoBoxGlobalSettings, IAppInBackgroundService iAppInBackgroundService) {
        this.mSession = boxSession;
        this.mBoxApiUser = new BoxApiUser(boxSession);
        this.mAvatarController = new DefaultAvatarController(boxSession);
        this.mApiPrivate = new BoxApiPrivate(boxSession);
        this.mCollectionsApi = new BoxExtendedApiCollections(boxSession);
        this.mBoxExtendedApiFile = new BoxExtendedApiFile(boxSession);
        this.mGlobalSettings = iMoCoBoxGlobalSettings;
        this.mUserContextManager = iUserContextManager;
        this.mAppInBgService = iAppInBackgroundService;
    }

    private HashMap<String, ArrayList<BoxPushNotification>> splitNotificationObjectsIntoGroups(BoxIteratorBoxPushNotification boxIteratorBoxPushNotification) {
        HashMap<String, ArrayList<BoxPushNotification>> map = new HashMap<>();
        ArrayList<BoxPushNotification> entries = boxIteratorBoxPushNotification.getEntries();
        for (int size = entries.size() - 1; size >= 0; size--) {
            BoxPushNotification boxPushNotification = entries.get(size);
            if (boxPushNotification != null && !boxPushNotification.isDismissed().booleanValue()) {
                String stringIdentifier = new ResourceAndNotifType(boxPushNotification.getTargetResourceId(), boxPushNotification.getTargetResourceType(), boxPushNotification.getNotifType()).toStringIdentifier();
                ArrayList<BoxPushNotification> arrayList = map.get(stringIdentifier);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    map.put(stringIdentifier, arrayList);
                }
                arrayList.add(boxPushNotification);
            }
        }
        return map;
    }

    public synchronized void updateDeviceNotification(boolean z) {
        try {
            BoxIteratorBoxPushNotification boxIteratorBoxPushNotificationSendForCachedResult = this.mApiPrivate.getPushNotificationsRequest().setShowNonProcessed(true).sendForCachedResult();
            if (boxIteratorBoxPushNotificationSendForCachedResult == null) {
                BoxLogUtils.d("UserNotificationManager", "Unable to fetch non-processed push notifications");
                BoxLogUtils.d("UserNotificationManager", "isApplication in background: " + this.mAppInBgService.isAppInBackground());
                return;
            }
            for (Map.Entry<String, ArrayList<BoxPushNotification>> entry : splitNotificationObjectsIntoGroups(boxIteratorBoxPushNotificationSendForCachedResult).entrySet()) {
                BoxPushNotification.PushNotifType notifType = ResourceAndNotifType.fromStringIdentifier(entry.getKey()).getNotifType();
                ArrayList<BoxPushNotification> value = entry.getValue();
                boolean z2 = false;
                long jLongValue = 0;
                for (BoxPushNotification boxPushNotification : value) {
                    if (!boxPushNotification.isProcessed()) {
                        z2 = true;
                    }
                    if (boxPushNotification.getPreviousDismissTime() != null && jLongValue < boxPushNotification.getPreviousDismissTime().longValue()) {
                        jLongValue = boxPushNotification.getPreviousDismissTime().longValue();
                    }
                }
                if (14400000 <= System.currentTimeMillis() - jLongValue) {
                    BoxPushNotifHandler boxPushNotifHandlerCreate = BoxPushNotifHandler.create(value, notifType, this, z, this.mAppInBgService);
                    if (z2 && boxPushNotifHandlerCreate != null) {
                        boxPushNotifHandlerCreate.doProcessNotifications();
                    }
                }
            }
        } catch (BoxException e) {
            BoxLogUtils.e("updateDeviceNotification", e);
        }
    }

    public BoxFutureTask<BoxDownload> executeAvatarDownloadRequest(String str, BoxFutureTask.OnCompletedListener onCompletedListener) {
        try {
            BoxFutureTask task = this.mBoxApiUser.getDownloadAvatarRequest(getAvatarFile(str).getParentFile(), str).toTask();
            task.addOnCompletedListener(onCompletedListener);
            ((ExecutorPool) this.mUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.EXECUTOR_POOL)).getNotificationExecutor().execute(task);
            return task;
        } catch (IOException e) {
            BoxLogUtils.e("unable to createFile ", e);
            return null;
        }
    }

    public void executeTask(BoxFutureTask boxFutureTask) {
        ((ExecutorPool) this.mUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.EXECUTOR_POOL)).getNotificationExecutor().execute(boxFutureTask);
    }

    private static int getLargeImageSize(Resources resources) {
        return (int) (resources.getDisplayMetrics().densityDpi / 2.5f);
    }

    public Bitmap generateInitialsImage(String str) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.mContext);
        if (layoutInflaterFrom == null) {
            return null;
        }
        View viewInflate = layoutInflaterFrom.inflate(R.layout.boxsdk_avatar_item, (ViewGroup) null);
        SdkUtils.setInitialsThumb(this.mContext, (TextView) viewInflate.findViewById(R.id.box_avatar_initials), str);
        int largeImageSize = getLargeImageSize(this.mContext.getResources());
        viewInflate.measure(View.MeasureSpec.makeMeasureSpec(largeImageSize, 1073741824), View.MeasureSpec.makeMeasureSpec(largeImageSize, 1073741824));
        viewInflate.layout(0, 0, largeImageSize, largeImageSize);
        viewInflate.buildDrawingCache();
        return viewInflate.getDrawingCache();
    }

    public Bitmap getBestBitmapIconForUser(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return getUnkownUserBitmap();
        }
        File avatarFile = getAvatarFile(str);
        if (avatarFile != null && avatarFile.exists()) {
            int largeImageSize = (int) getLargeImageSize(this.mContext.getResources());
            RoundedBitmapDrawable roundedBitmapDrawableCreate = RoundedBitmapDrawableFactory.create(this.mContext.getResources(), Bitmap.createScaledBitmap(BitmapFactory.decodeFile(avatarFile.getAbsolutePath()), largeImageSize, largeImageSize, true));
            roundedBitmapDrawableCreate.setCircular(true);
            return getBitmapFromDrawable(roundedBitmapDrawableCreate);
        }
        if (TextUtils.isEmpty(str2)) {
            return getUnkownUserBitmap();
        }
        return generateInitialsImage(str2);
    }

    private Bitmap getUnkownUserBitmap() {
        return getBitmapFromDrawable(R.drawable.ic_unknown_user_24dp);
    }

    public Bitmap getGroupUserBitmap() {
        return getBitmapFromDrawable(R.drawable.ic_group_users_24dp);
    }

    private Bitmap getBitmapFromDrawable(int i) {
        return getBitmapFromDrawable(ContextCompat.getDrawable(this.mContext, i));
    }

    private Bitmap getBitmapFromDrawable(Drawable drawable) {
        int largeImageSize = getLargeImageSize(this.mContext.getResources());
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(largeImageSize, largeImageSize, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public File getAvatarFile(String str) {
        return this.mAvatarController.getAvatarFile(str);
    }

    public String getUserId() {
        return this.mSession.getUserId();
    }

    public BoxExtendedApiFile getFileApi() {
        return this.mBoxExtendedApiFile;
    }

    public BoxApiUser getUserApi() {
        return this.mBoxApiUser;
    }

    public IUserContextManager getUserContextManager() {
        return this.mUserContextManager;
    }

    public BoxRequestGetFavoritesCollection getFavoritesCollectionRequest() {
        return this.mCollectionsApi.getFavoritesCollectionRequest();
    }

    public BoxRequestStorePushNotification getStorePushNotificationRequest(BoxPushNotification boxPushNotification) {
        return this.mApiPrivate.getStorePushNotificationRequest(boxPushNotification);
    }

    /* JADX INFO: renamed from: com.box.android.pushnotification.UserNotificationManager$1, reason: invalid class name */
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

    public boolean allowNotificationType(BoxPushNotification.PushNotifType pushNotifType) {
        int i = AnonymousClass1.$SwitchMap$com$box$boxandroidlibv2private$model$BoxPushNotification$PushNotifType[pushNotifType.ordinal()];
        if (i == 1) {
            return this.mGlobalSettings.shouldAllowCollabsPushNotification();
        }
        if (i == 2) {
            return this.mGlobalSettings.shouldAllowCommentsPushNotification();
        }
        if (i == 3 || i == 4) {
            return this.mGlobalSettings.shouldAllowUpdatesPushNotification();
        }
        return false;
    }
}
