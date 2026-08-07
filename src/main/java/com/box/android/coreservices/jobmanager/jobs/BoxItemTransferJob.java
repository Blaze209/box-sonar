package com.box.android.coreservices.jobmanager.jobs;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.coreservices.jobmanager.dao.ProgressReporter;
import com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection;
import com.box.android.coreservices.jobmanager.progresslisteners.LocalBroadcastTransferTaskProgressListener;
import com.box.android.coreservices.jobmanager.tasks.BoxTask;
import com.box.android.coreservices.modelcontroller.MoCoContainerBuilder;
import com.box.androidsdk.content.models.BoxItem;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public abstract class BoxItemTransferJob extends BoxItemJob {
    private final transient LocalBroadcastTransferTaskProgressListener mTransferTaskBroadcastListener;

    protected BoxItemTransferJob() {
        this.mTransferTaskBroadcastListener = new LocalBroadcastTransferTaskProgressListener(LocalBroadcastManager.getInstance(ApplicationProvider.getApplication()));
    }

    protected BoxItemTransferJob(String str, MoCoContainerBuilder.MoCoContainer moCoContainer, BoxJobCollection boxJobCollection, BoxItem boxItem) {
        super(str, moCoContainer, boxJobCollection, boxItem);
        this.mTransferTaskBroadcastListener = new LocalBroadcastTransferTaskProgressListener(LocalBroadcastManager.getInstance(ApplicationProvider.getApplication()));
    }

    @Override // com.box.android.coreservices.jobmanager.jobs.BoxJob
    public void addTasks(List<BoxTask> list) {
        Iterator<BoxTask> it = list.iterator();
        while (it.hasNext()) {
            it.next().addProgressListener(this.mTransferTaskBroadcastListener);
        }
        super.addTasks(list);
        Iterator<BoxTask> it2 = list.iterator();
        while (it2.hasNext()) {
            onTaskAdded(it2.next());
        }
    }

    @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter
    public ProgressReporter.ProgressType[] getSupportedProgressTypes() {
        return new ProgressReporter.ProgressType[]{ProgressReporter.ProgressType.NUM_TASKS, ProgressReporter.ProgressType.BYTES, ProgressReporter.ProgressType.PERCENTAGE};
    }

    @Override // com.box.android.coreservices.jobmanager.JobItem
    protected void reportCompleted(ProgressReporter progressReporter) {
        super.reportCompleted(progressReporter);
    }
}
