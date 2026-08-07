package com.box.android.coreservices.jobmanager.jobcollections;

import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.common.utilities.FileSizeUtils;
import com.box.android.coreservices.R;
import com.box.android.coreservices.jobmanager.JobCollectionList;
import com.box.android.coreservices.jobmanager.JobItem;
import com.box.android.coreservices.jobmanager.dao.ProgressReporter;
import com.box.android.coreservices.jobmanager.jobs.BoxItemJob;
import com.box.android.coreservices.modelcontroller.MoCoContainerBuilder;

/* JADX INFO: loaded from: classes9.dex */
public abstract class TransferBoxJobCollection extends BoxJobCollection {

    public enum JobCollectionResult {
        COMPLETED,
        CANT_RETRY,
        REQUEUE
    }

    protected TransferBoxJobCollection(String str, MoCoContainerBuilder.MoCoContainer moCoContainer, JobCollectionList jobCollectionList) {
        super(str, moCoContainer, jobCollectionList);
    }

    protected TransferBoxJobCollection() {
    }

    @Override // com.box.android.coreservices.jobmanager.ParentJobItem
    public String getDescription() {
        if (isPaused()) {
            if (getProgress(ProgressReporter.ProgressType.PERCENTAGE) == -4) {
                return CommonBoxUtil.LS(R.string.Pausing_dot_dot_dot);
            }
            return CommonBoxUtil.LS(R.string.Paused);
        }
        JobItem.JobItemState currentState = getCurrentState();
        if (currentState == JobItem.JobItemState.QUEUED) {
            return CommonBoxUtil.LS(R.string.Queued);
        }
        if (currentState == JobItem.JobItemState.COMPLETED) {
            return CommonBoxUtil.LS(R.string.Done);
        }
        return getInProgressDescription();
    }

    protected String getInProgressDescription() {
        if (getMax(ProgressReporter.ProgressType.BYTES) == -1 || getProgress(ProgressReporter.ProgressType.BYTES) == -4) {
            return CommonBoxUtil.LS(R.string.Preparing_dot_dot_dot);
        }
        long max = getMax(ProgressReporter.ProgressType.BYTES) - getProgress(ProgressReporter.ProgressType.BYTES);
        if (max < 0) {
            max = 0;
        }
        return ApplicationProvider.getApplication().getString(R.string.x_remaining, new Object[]{FileSizeUtils.getFileSize(Long.valueOf(max))});
    }

    public JobCollectionResult getJobCollectionResult() {
        if (!hasError()) {
            return JobCollectionResult.COMPLETED;
        }
        for (JobItem jobItem : this.mFailedJobItems) {
            if ((jobItem instanceof BoxItemJob) && ((BoxItemJob) jobItem).canRetryJobOnFailure()) {
                return JobCollectionResult.REQUEUE;
            }
        }
        return JobCollectionResult.CANT_RETRY;
    }
}
