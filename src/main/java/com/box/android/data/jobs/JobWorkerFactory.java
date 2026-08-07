package com.box.android.data.jobs;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerFactory;
import androidx.work.WorkerParameters;
import com.box.android.common.utilities.WorkerUtilsKt;
import com.box.android.coreservices.jobmanager.JobManager;
import com.box.android.coreservices.jobmanager.tasks.BoxRetryWorker;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.IJobWorkerFactory;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JobWorkerFactory.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B)\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\"\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/jobs/JobWorkerFactory;", "Landroidx/work/WorkerFactory;", "Lcom/box/android/domain/services/IJobWorkerFactory;", "jobService", "Lcom/box/android/data/jobs/JobService;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "boxApiPrivate", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxApiPrivate;", "jobManager", "Lcom/box/android/coreservices/jobmanager/JobManager;", "<init>", "(Lcom/box/android/data/jobs/JobService;Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/boxandroidlibv2private/resourcemanagers/BoxApiPrivate;Lcom/box/android/coreservices/jobmanager/JobManager;)V", "createWorker", "Landroidx/work/ListenableWorker;", "appContext", "Landroid/content/Context;", "workerClassName", "", "workerParameters", "Landroidx/work/WorkerParameters;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class JobWorkerFactory extends WorkerFactory implements IJobWorkerFactory {
    private BoxApiPrivate boxApiPrivate;
    private final JobManager jobManager;
    private final JobService jobService;
    private final IUserContextManager userContextManager;

    @Inject
    public JobWorkerFactory(JobService jobService, IUserContextManager userContextManager, BoxApiPrivate boxApiPrivate, JobManager jobManager) {
        Intrinsics.checkNotNullParameter(jobService, "jobService");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(boxApiPrivate, "boxApiPrivate");
        Intrinsics.checkNotNullParameter(jobManager, "jobManager");
        this.jobService = jobService;
        this.userContextManager = userContextManager;
        this.boxApiPrivate = boxApiPrivate;
        this.jobManager = jobManager;
    }

    @Override // androidx.work.WorkerFactory
    public ListenableWorker createWorker(Context appContext, String workerClassName, WorkerParameters workerParameters) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(workerClassName, "workerClassName");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParameters");
        String strWorkerNameFix = WorkerUtilsKt.workerNameFix(workerClassName);
        if (Class.forName(strWorkerNameFix).isAssignableFrom(JobWorker.class)) {
            return new JobWorker(this.jobService, this.userContextManager, this.boxApiPrivate, appContext, workerParameters);
        }
        if (Class.forName(strWorkerNameFix).isAssignableFrom(JobTriggerWorker.class)) {
            return new JobTriggerWorker(this.jobService, this.userContextManager, this.boxApiPrivate, appContext, workerParameters);
        }
        if (Class.forName(strWorkerNameFix).isAssignableFrom(BoxRetryWorker.class)) {
            return new BoxRetryWorker(appContext, workerParameters, this.jobManager);
        }
        return null;
    }
}
