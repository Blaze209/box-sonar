package com.box.android.jobmanager;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import com.box.android.R;
import com.box.android.activities.MainPhone;
import com.box.android.application.BoxBaseApplication;
import com.box.android.base.BoxNotificationManager;
import com.box.android.common.utilities.IntentConstants;
import com.box.android.coreservices.api.ShareController;
import com.box.android.coreservices.jobmanager.IJobManagerNotificationCenter;
import com.box.android.coreservices.jobmanager.JobItem;
import com.box.android.coreservices.jobmanager.dao.ProgressReporter;
import com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection;
import com.box.android.coreservices.jobmanager.jobs.BoxJob;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.services.JobRetryIntentService;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import com.microsoft.intune.mam.client.app.MAMPendingIntent;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes12.dex */
public class JobManagerNotificationCenter implements IJobManagerNotificationCenter {
    IBaseModelController mBaseModelController;
    BoxExtendedApiFolder mBoxExtendedApiFolder;
    private int mNotificationColor;
    ShareController mShareController;
    IUserContextManager mUserContextManager;
    private Set<BoxJobCollection> mFailedJobCollections = new HashSet();
    private NotificationIdGenerator mNotifIdGen = new NotificationIdGenerator();
    private NotificationsLiveUpdateManager mUpdateNotifsMgr = new NotificationsLiveUpdateManager();
    private final AtomicBoolean mIsShutdown = new AtomicBoolean(false);

    private class NotificationIdGenerator {
        private final boolean[] notifArr;

        public NotificationIdGenerator() {
            boolean[] zArr = new boolean[20];
            this.notifArr = zArr;
            Arrays.fill(zArr, false);
        }

        public int getNotifId() {
            for (int i = 0; i < 20; i++) {
                boolean[] zArr = this.notifArr;
                if (!zArr[i]) {
                    zArr[i] = true;
                    return i + 102;
                }
            }
            return -1;
        }

        public void clearNotifId(int i) {
            this.notifArr[i - 102] = false;
        }
    }

    @Inject
    public JobManagerNotificationCenter(Context context, IBaseModelController iBaseModelController, ShareController shareController, IUserContextManager iUserContextManager, BoxExtendedApiFolder boxExtendedApiFolder) {
        this.mBaseModelController = iBaseModelController;
        this.mUserContextManager = iUserContextManager;
        this.mShareController = shareController;
        this.mNotificationColor = context.getResources().getColor(R.color.box_blue);
        this.mBoxExtendedApiFolder = boxExtendedApiFolder;
    }

    @Override // com.box.android.coreservices.jobmanager.IJobManagerNotificationCenter
    public void addInProgressJobCollection(BoxJobCollection boxJobCollection) {
        removeFailedJobCollection(boxJobCollection);
        int notifId = this.mNotifIdGen.getNotifId();
        if (notifId == -1) {
            return;
        }
        NotificationCompat.Builder builderBuildNotif = buildNotif(BoxNotificationManager.TRANSFERS_CHANNEL_ID);
        builderBuildNotif.setContentTitle(boxJobCollection.getTitle()).setContentText(boxJobCollection.getDescription()).setSmallIcon(2131231969).setColor(this.mNotificationColor).setOngoing(true).setTicker(boxJobCollection.getTitle());
        boxJobCollection.setLocalNotificationId(notifId);
        this.mUpdateNotifsMgr.addUpdateNotifRunnable(new UpdateNotificationRunnable(boxJobCollection, notifId, builderBuildNotif));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCompletedJobCollection(BoxJobCollection boxJobCollection) {
        removeFailedJobCollection(boxJobCollection);
        NotificationCompat.Builder builderBuildNotif = buildNotif(BoxNotificationManager.TRANSFERS_CHANNEL_ID);
        builderBuildNotif.setContentTitle(boxJobCollection.getTitle()).setContentText("").setSmallIcon(2131231969).setColor(this.mNotificationColor);
        showNotification(101, builderBuildNotif.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFailedJobCollection(BoxJobCollection boxJobCollection) {
        this.mFailedJobCollections.add(boxJobCollection);
        NotificationCompat.Builder builderBuildNotif = buildNotif(BoxNotificationManager.TRANSFERS_CHANNEL_ID);
        int notifId = this.mNotifIdGen.getNotifId();
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        builderBuildNotif.setStyle(inboxStyle);
        builderBuildNotif.setContentTitle(boxJobCollection.getErrorText()).setSmallIcon(2131231969).setColor(this.mNotificationColor);
        BoxBaseApplication boxBaseApplication = BoxBaseApplication.getInstance();
        for (BoxJob boxJob : boxJobCollection.getChildJobItems()) {
            if (boxJob.hasError()) {
                inboxStyle.addLine(boxJob.getTitle() + " " + boxJob.getErrorText());
            }
        }
        boxJobCollection.setLocalNotificationId(notifId);
        builderBuildNotif.addAction(R.drawable.retry_icon, boxBaseApplication.getString(R.string.retry), MAMPendingIntent.getBroadcast(boxBaseApplication, notifId, JobRetryIntentService.JobRetryBroadcastReceiver.newIntent(boxBaseApplication, boxJobCollection, notifId), 201326592));
        showNotification(notifId, builderBuildNotif.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNotification(int i, Notification notification) {
        BoxNotificationManager.notify(i, notification);
    }

    private void removeFailedJobCollection(BoxJobCollection boxJobCollection) {
        if (this.mFailedJobCollections.contains(boxJobCollection)) {
            this.mFailedJobCollections.remove(boxJobCollection);
            BoxNotificationManager.cancel(boxJobCollection.getLocalNotificationId());
        }
    }

    private NotificationCompat.Builder buildNotif(String str) {
        Intent intent = new Intent(BoxBaseApplication.getInstance(), (Class<?>) MainPhone.class);
        intent.setFlags(805306368);
        intent.putExtra(IntentConstants.EXTRA_INIT_NAV_DRAWER_ITEM_ID, 10);
        return new NotificationCompat.Builder(BoxBaseApplication.getInstance(), str).setAutoCancel(true).setContentIntent(MAMPendingIntent.getActivity(BoxBaseApplication.getInstance(), 1, intent, 67108864));
    }

    @Override // com.box.android.coreservices.jobmanager.IJobManagerNotificationCenter
    public void clearAllCompleted() {
        BoxNotificationManager.cancel(101);
    }

    @Override // com.box.android.coreservices.jobmanager.IJobManagerNotificationCenter
    public void clearAllInProgress() {
        for (int i = 0; i < 20; i++) {
            BoxNotificationManager.cancel(i + 102);
        }
    }

    @Override // com.box.android.coreservices.jobmanager.IJobManagerNotificationCenter
    public void shutdown() {
        this.mIsShutdown.set(true);
        clearAllCompleted();
        clearAllInProgress();
    }

    private class NotificationsLiveUpdateManager {
        private Thread mUpdateAllNotificationsThread;
        private List<UpdateNotificationRunnable> updateNotifRunnableList;

        private NotificationsLiveUpdateManager() {
            this.updateNotifRunnableList = new CopyOnWriteArrayList();
        }

        public void addUpdateNotifRunnable(UpdateNotificationRunnable updateNotificationRunnable) {
            this.updateNotifRunnableList.add(updateNotificationRunnable);
            Thread thread = this.mUpdateAllNotificationsThread;
            if (thread == null || !thread.isAlive()) {
                Thread thread2 = new Thread() { // from class: com.box.android.jobmanager.JobManagerNotificationCenter.NotificationsLiveUpdateManager.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        while (!NotificationsLiveUpdateManager.this.updateNotifRunnableList.isEmpty() && !JobManagerNotificationCenter.this.mIsShutdown.get()) {
                            Iterator it = NotificationsLiveUpdateManager.this.updateNotifRunnableList.iterator();
                            while (it.hasNext()) {
                                ((UpdateNotificationRunnable) it.next()).run();
                            }
                            try {
                                Thread.sleep(500L);
                            } catch (InterruptedException e) {
                                BoxLogUtils.logException(e);
                                Thread.currentThread().interrupt();
                            }
                        }
                    }
                };
                this.mUpdateAllNotificationsThread = thread2;
                thread2.start();
            }
        }

        public void removeUpdateNotifRunnable(UpdateNotificationRunnable updateNotificationRunnable) {
            this.updateNotifRunnableList.remove(updateNotificationRunnable);
        }
    }

    private class UpdateNotificationRunnable implements Runnable {
        private final NotificationCompat.Builder mBuilder;
        private final BoxJobCollection mJobCollection;
        private final int mNotifId;

        public UpdateNotificationRunnable(BoxJobCollection boxJobCollection, int i, NotificationCompat.Builder builder) {
            this.mJobCollection = boxJobCollection;
            this.mNotifId = i;
            this.mBuilder = builder;
        }

        @Override // java.lang.Runnable
        public void run() {
            JobItem.JobItemState currentState = this.mJobCollection.getCurrentState();
            if (currentState != JobItem.JobItemState.COMPLETED && currentState != JobItem.JobItemState.CANCELLED) {
                this.mBuilder.setProgress(100, (int) this.mJobCollection.getProgress(ProgressReporter.ProgressType.PERCENTAGE), false);
                this.mBuilder.setContentText(this.mJobCollection.getDescription());
                this.mBuilder.setContentTitle(this.mJobCollection.getTitle());
                JobManagerNotificationCenter.this.showNotification(this.mNotifId, this.mBuilder.build());
                return;
            }
            if (currentState != JobItem.JobItemState.CANCELLED) {
                if (this.mJobCollection.isSuccessfullyCompleted()) {
                    if (!this.mJobCollection.shouldAutoClear()) {
                        JobManagerNotificationCenter.this.addCompletedJobCollection(this.mJobCollection);
                    }
                } else {
                    JobManagerNotificationCenter.this.addFailedJobCollection(this.mJobCollection);
                }
            }
            BoxNotificationManager.cancel(this.mNotifId);
            JobManagerNotificationCenter.this.mNotifIdGen.clearNotifId(this.mNotifId);
            JobManagerNotificationCenter.this.mUpdateNotifsMgr.removeUpdateNotifRunnable(this);
        }
    }
}
