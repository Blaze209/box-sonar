package com.box.android.coreservices.jobmanager.jobcollections;

import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.R;
import com.box.android.coreservices.jobmanager.JobCollectionList;
import com.box.android.coreservices.jobmanager.dao.ProgressReporter;
import com.box.android.coreservices.jobmanager.jobs.BoxJob;
import com.box.android.coreservices.jobmanager.jobs.OfflineBoxJob;
import com.box.android.coreservices.jobmanager.tasks.BoxTask;
import com.box.android.coreservices.jobmanager.tasks.PrepareOfflineTask;
import com.box.android.coreservices.modelcontroller.MoCoContainerBuilder;
import com.box.android.coreservices.services.NotificationServices;
import com.box.androidsdk.content.models.BoxItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class OfflineBoxJobCollection extends TransferBoxJobCollection {
    public static final String TYPE = "offlineBoxJobCollection";
    protected transient boolean mHasShownErrorDialog;
    private NotificationServices mNotificationServices;

    @Override // com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection
    public boolean shouldAppearInNotifCenter() {
        return true;
    }

    @Override // com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection
    public boolean shouldAutoClear() {
        return true;
    }

    public OfflineBoxJobCollection(MoCoContainerBuilder.MoCoContainer moCoContainer, JobCollectionList jobCollectionList, NotificationServices notificationServices, Collection<BoxItem> collection, boolean z) {
        super(TYPE, moCoContainer, jobCollectionList);
        this.mNotificationServices = notificationServices;
        this.mHasShownErrorDialog = false;
        List<BoxJob> arrayList = new ArrayList<>();
        Iterator<BoxItem> it = collection.iterator();
        while (it.hasNext()) {
            OfflineBoxJobCollection offlineBoxJobCollection = this;
            MoCoContainerBuilder.MoCoContainer moCoContainer2 = moCoContainer;
            boolean z2 = z;
            BoxJob offlineBoxJob = new OfflineBoxJob(moCoContainer2, offlineBoxJobCollection, it.next(), z2, this.mNotificationServices);
            if (offlineBoxJob.getTasks() != null && offlineBoxJob.getTasks().size() >= 1) {
                arrayList.add(offlineBoxJob);
            }
            moCoContainer = moCoContainer2;
            this = offlineBoxJobCollection;
            z = z2;
        }
        OfflineBoxJobCollection offlineBoxJobCollection2 = this;
        if (arrayList.size() < 1) {
            offlineBoxJobCollection2.reportCompleted(offlineBoxJobCollection2);
        }
        if (arrayList.size() == 1) {
            Iterator<BoxTask> it2 = arrayList.get(0).getTasks().iterator();
            while (it2.hasNext()) {
                if (!(it2.next() instanceof PrepareOfflineTask)) {
                    offlineBoxJobCollection2.mHasShownErrorDialog = true;
                }
            }
        }
        offlineBoxJobCollection2.addJobs(arrayList);
    }

    public OfflineBoxJobCollection() {
    }

    private void showErrorDialog() {
        if (this.mHasShownErrorDialog) {
            return;
        }
        Iterator<BoxJob> it = getJobs().iterator();
        while (it.hasNext()) {
            if (((OfflineBoxJob) it.next()).shouldShowErrorDialog()) {
                this.mNotificationServices.displayDialog(CommonBoxUtil.LS(R.string.unable_to_offline_files_title), CommonBoxUtil.LS(R.string.unable_to_offline_files_message), CommonBoxUtil.LS(R.string.LO_Continue));
                this.mHasShownErrorDialog = true;
                return;
            }
        }
    }

    @Override // com.box.android.coreservices.jobmanager.JobItem
    protected void reportTaskAdded(BoxTask boxTask) {
        showErrorDialog();
        super.reportTaskAdded(boxTask);
    }

    @Override // com.box.android.coreservices.jobmanager.JobItem
    protected void reportStarted(ProgressReporter progressReporter) {
        showErrorDialog();
        super.reportStarted(progressReporter);
    }

    @Override // com.box.android.coreservices.jobmanager.JobItem
    protected void reportCompleted(ProgressReporter progressReporter) {
        showErrorDialog();
        super.reportCompleted(progressReporter);
        MoCoContainerBuilder.MoCoContainer moCoContainer = this.mMoCoContainer;
        this.mMoCoContainer.broadcastJobStatus(MoCoContainerBuilder.MoCoContainer.createStatusMessage(this, null));
    }

    @Override // com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection
    protected int getInProgressTitleResId() {
        return R.array.Saving_item_and_n_other_items_for_offline;
    }

    @Override // com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection
    protected int getCompletedTitleResId() {
        return R.array.Saved_item_and_n_other_items_for_offline;
    }

    @Override // com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection
    protected int getErrorTextResId() {
        return R.array.N_items_failed_to_save_for_offline;
    }

    @Override // com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection
    public boolean shouldDisplayCompleteTransferToast() {
        return getChildJobItems() != null && getChildJobItems().size() > 0;
    }
}
