package com.box.android.data.persistence.jobs;

import com.box.android.data.jobs.JobWorker;
import com.box.android.domain.jobs.JobId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JobIdToWorkIdRelation.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/data/persistence/jobs/JobIdToWorkIdRelation;", "", JobWorker.JOB_ID_PARAM, "Lcom/box/android/domain/jobs/JobId;", "workId", "", "<init>", "(Lcom/box/android/domain/jobs/JobId;Ljava/lang/String;)V", "getJobId", "()Lcom/box/android/domain/jobs/JobId;", "getWorkId", "()Ljava/lang/String;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class JobIdToWorkIdRelation {
    private final JobId jobId;
    private final String workId;

    public JobIdToWorkIdRelation(JobId jobId, String workId) {
        Intrinsics.checkNotNullParameter(jobId, "jobId");
        Intrinsics.checkNotNullParameter(workId, "workId");
        this.jobId = jobId;
        this.workId = workId;
    }

    public final JobId getJobId() {
        return this.jobId;
    }

    public final String getWorkId() {
        return this.workId;
    }
}
