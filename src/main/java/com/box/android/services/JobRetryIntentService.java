package com.box.android.services;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.app.JobIntentService;
import com.box.android.application.BoxBaseApplication;
import com.box.android.base.BoxNotificationManager;
import com.box.android.coreservices.jobmanager.JobManager;
import com.box.android.coreservices.jobmanager.ParentJobItem;
import com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection;
import com.microsoft.intune.mam.client.content.MAMBroadcastReceiver;

/* JADX INFO: loaded from: classes13.dex */
public class JobRetryIntentService extends JobIntentService {
    static final int JOB_ID = 5000;
    static String JOB_ITEM = "JobRetryIntentService.JobItem";
    static String NOTIFICATION_ID = "JobRetryIntentService.NotificationId";

    public static void enqueueWork(Context context, Intent intent) {
        enqueueWork(context, (Class<?>) JobRetryIntentService.class, 5000, intent);
    }

    @Override // androidx.core.app.JobIntentService
    protected void onHandleWork(Intent intent) {
        if (intent == null || !intent.hasExtra(JOB_ITEM)) {
            return;
        }
        ParentJobItem parentJobItem = (ParentJobItem) intent.getSerializableExtra(JOB_ITEM);
        JobManager jobManager = BoxBaseApplication.getInstance().getJobManager();
        if (jobManager == null) {
            return;
        }
        for (BoxJobCollection boxJobCollection : jobManager.getAllJobCollections()) {
            if (TextUtils.equals(boxJobCollection.getId(), parentJobItem.getId())) {
                jobManager.addJobCollection(boxJobCollection, true);
            }
        }
        BoxNotificationManager.cancel(intent.getIntExtra(NOTIFICATION_ID, 0));
    }

    public static class JobRetryBroadcastReceiver extends MAMBroadcastReceiver {
        @Override // com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
        public void onMAMReceive(Context context, Intent intent) {
            JobRetryIntentService.enqueueWork(context, intent);
        }

        public static Intent newIntent(Context context, ParentJobItem parentJobItem, int i) {
            Intent intent = new Intent(context, (Class<?>) JobRetryBroadcastReceiver.class);
            intent.putExtra(JobRetryIntentService.JOB_ITEM, parentJobItem);
            intent.putExtra(JobRetryIntentService.NOTIFICATION_ID, i);
            return intent;
        }
    }
}
