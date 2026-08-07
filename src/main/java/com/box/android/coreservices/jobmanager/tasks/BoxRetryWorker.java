package com.box.android.coreservices.jobmanager.tasks;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.box.android.coreservices.jobmanager.JobManager;
import com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection;
import com.box.android.coreservices.jobmanager.jobs.BoxItemJob;

/* JADX INFO: loaded from: classes9.dex */
public class BoxRetryWorker extends Worker {
    private final JobManager mJobManager;

    public BoxRetryWorker(Context context, WorkerParameters workerParameters, JobManager jobManager) {
        super(context, workerParameters);
        this.mJobManager = jobManager;
    }

    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() {
        BoxJobCollection jobCollection = this.mJobManager.getJobCollection(getInputData().getString(BoxItemJob.COLLECTION_ID));
        if (jobCollection != null && !this.mJobManager.restartCollectionOnFailure(jobCollection)) {
            return ListenableWorker.Result.failure();
        }
        return ListenableWorker.Result.success();
    }
}
