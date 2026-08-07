package com.box.android.coreservices.jobmanager.jobcollections;

import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.R;
import com.box.android.coreservices.jobmanager.JobCollectionList;
import com.box.android.coreservices.jobmanager.dao.ProgressReporter;
import com.box.android.coreservices.modelcontroller.MoCoContainerBuilder;

/* JADX INFO: loaded from: classes9.dex */
public abstract class TaskNumberBoxJobCollection extends TransferBoxJobCollection {
    protected TaskNumberBoxJobCollection(String str, MoCoContainerBuilder.MoCoContainer moCoContainer, JobCollectionList jobCollectionList) {
        super(str, moCoContainer, jobCollectionList);
    }

    protected TaskNumberBoxJobCollection() {
    }

    @Override // com.box.android.coreservices.jobmanager.jobcollections.TransferBoxJobCollection
    protected String getInProgressDescription() {
        if (getProgress(ProgressReporter.ProgressType.PERCENTAGE) == -4) {
            return CommonBoxUtil.LS(R.string.Preparing_dot_dot_dot);
        }
        return ApplicationProvider.getApplication().getString(R.string.x_remaining, new Object[]{ApplicationProvider.getApplication().getString(R.string.x_of_y, new Object[]{Integer.valueOf((int) getProgress(ProgressReporter.ProgressType.NUM_FILES)), Integer.valueOf((int) getMax(ProgressReporter.ProgressType.NUM_FILES))})});
    }
}
