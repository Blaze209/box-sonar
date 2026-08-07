package com.box.android.data.persistence.jobs;

import com.box.android.domain.jobs.JobId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JobDependencyRelation.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/box/android/data/persistence/jobs/JobDependencyRelation;", "", "successor", "Lcom/box/android/domain/jobs/JobId;", "predecessor", "<init>", "(Lcom/box/android/domain/jobs/JobId;Lcom/box/android/domain/jobs/JobId;)V", "getSuccessor", "()Lcom/box/android/domain/jobs/JobId;", "getPredecessor", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class JobDependencyRelation {
    private final JobId predecessor;
    private final JobId successor;

    public JobDependencyRelation(JobId successor, JobId predecessor) {
        Intrinsics.checkNotNullParameter(successor, "successor");
        Intrinsics.checkNotNullParameter(predecessor, "predecessor");
        this.successor = successor;
        this.predecessor = predecessor;
    }

    public final JobId getSuccessor() {
        return this.successor;
    }

    public final JobId getPredecessor() {
        return this.predecessor;
    }
}
