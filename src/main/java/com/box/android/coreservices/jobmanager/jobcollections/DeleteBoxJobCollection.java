package com.box.android.coreservices.jobmanager.jobcollections;

import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.R;
import com.box.android.coreservices.jobmanager.JobCollectionList;
import com.box.android.coreservices.jobmanager.JobManager;
import com.box.android.coreservices.jobmanager.jobs.DeleteBoxJob;
import com.box.android.coreservices.modelcontroller.MoCoContainerBuilder;
import com.box.androidsdk.content.models.BoxItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes9.dex */
public final class DeleteBoxJobCollection extends TaskNumberBoxJobCollection {
    public static final String TYPE = "deleteBoxJobCollection";

    public DeleteBoxJobCollection(MoCoContainerBuilder.MoCoContainer moCoContainer, JobCollectionList jobCollectionList, Collection<BoxItem> collection, JobManager jobManager) {
        super(TYPE, moCoContainer, jobCollectionList);
        ArrayList arrayList = new ArrayList();
        Iterator<BoxItem> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new DeleteBoxJob(moCoContainer, this, it.next(), jobManager));
        }
        addJobs(arrayList);
    }

    public DeleteBoxJobCollection() {
    }

    @Override // com.box.android.coreservices.jobmanager.jobcollections.TransferBoxJobCollection, com.box.android.coreservices.jobmanager.ParentJobItem
    public String getDescription() {
        return "";
    }

    @Override // com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection
    protected int getInProgressTitleResId() {
        return R.array.Deleting_item_and_n_other_items;
    }

    @Override // com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection
    protected int getCompletedTitleResId() {
        return R.array.Deleted_item_and_n_other_items;
    }

    @Override // com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection
    protected int getErrorTextResId() {
        return R.array.N_items_failed_to_delete;
    }

    @Override // com.box.android.coreservices.jobmanager.jobcollections.TaskNumberBoxJobCollection, com.box.android.coreservices.jobmanager.jobcollections.TransferBoxJobCollection
    protected String getInProgressDescription() {
        return CommonBoxUtil.LS(R.string.LS_Deleting___);
    }
}
