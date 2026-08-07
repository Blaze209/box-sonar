package com.box.android.coreservices.jobmanager.jobcollections;

import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.R;
import com.box.android.coreservices.jobmanager.JobCollectionList;
import com.box.android.coreservices.jobmanager.JobManager;
import com.box.android.coreservices.jobmanager.dao.ProgressReporter;
import com.box.android.coreservices.jobmanager.jobs.RemoveOfflineBoxJob;
import com.box.android.coreservices.modelcontroller.MoCoContainerBuilder;
import com.box.androidsdk.content.models.BoxItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes9.dex */
public class RemoveOfflineBoxJobCollection extends TaskNumberBoxJobCollection {
    public static final String TYPE = "removeOfflineBoxJobCollection";

    public RemoveOfflineBoxJobCollection(MoCoContainerBuilder.MoCoContainer moCoContainer, JobCollectionList jobCollectionList, Collection<BoxItem> collection, JobManager jobManager) {
        super(TYPE, moCoContainer, jobCollectionList);
        ArrayList arrayList = new ArrayList();
        Iterator<BoxItem> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new RemoveOfflineBoxJob(moCoContainer, this, it.next(), jobManager));
        }
        addJobs(arrayList);
    }

    public RemoveOfflineBoxJobCollection() {
    }

    @Override // com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection
    protected int getInProgressTitleResId() {
        return R.array.Removing_item_and_n_other_items_from_offline;
    }

    @Override // com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection
    protected int getCompletedTitleResId() {
        return R.array.Removed_item_and_n_other_items_from_offline;
    }

    @Override // com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection
    protected int getErrorTextResId() {
        return R.array.N_items_failed_to_be_removed_from_offline;
    }

    @Override // com.box.android.coreservices.jobmanager.jobcollections.TransferBoxJobCollection, com.box.android.coreservices.jobmanager.ParentJobItem
    public String getDescription() {
        return "";
    }

    @Override // com.box.android.coreservices.jobmanager.jobcollections.TaskNumberBoxJobCollection, com.box.android.coreservices.jobmanager.jobcollections.TransferBoxJobCollection
    protected String getInProgressDescription() {
        return CommonBoxUtil.LS(R.string.Removing_items_from_offline);
    }

    @Override // com.box.android.coreservices.jobmanager.ParentJobItem, com.box.android.coreservices.jobmanager.dao.ProgressReporter
    public long getProgress(ProgressReporter.ProgressType progressType) {
        if (progressType == ProgressReporter.ProgressType.PERCENTAGE) {
            return this.mCompletedJobItems.size();
        }
        return super.getProgress(progressType);
    }

    @Override // com.box.android.coreservices.jobmanager.ParentJobItem, com.box.android.coreservices.jobmanager.dao.ProgressReporter
    public long getMax(ProgressReporter.ProgressType progressType) {
        if (progressType == ProgressReporter.ProgressType.PERCENTAGE) {
            return getChildJobItems().size();
        }
        return super.getMax(progressType);
    }

    @Override // com.box.android.coreservices.jobmanager.JobItem
    public void reportCompleted(ProgressReporter progressReporter) {
        super.reportCompleted(progressReporter);
        MoCoContainerBuilder.MoCoContainer moCoContainer = this.mMoCoContainer;
        this.mMoCoContainer.broadcastJobStatus(MoCoContainerBuilder.MoCoContainer.createStatusMessage(this, null));
    }
}
