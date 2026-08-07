package com.box.android.coreservices.jobmanager.jobs;

import com.box.android.coreservices.jobmanager.JobManager;
import com.box.android.coreservices.jobmanager.dao.ProgressReporter;
import com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection;
import com.box.android.coreservices.jobmanager.tasks.DeleteTask;
import com.box.android.coreservices.jobmanager.tasks.RemoveOfflineTask;
import com.box.android.coreservices.modelcontroller.MoCoContainerBuilder;
import com.box.android.domain.identity.IExecutorPool;
import com.box.android.domain.identity.IUserContext;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import java.util.ArrayList;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes9.dex */
public final class DeleteBoxJob extends BoxItemJob {
    public static final String TYPE = "deleteJob";

    public DeleteBoxJob() {
    }

    public DeleteBoxJob(MoCoContainerBuilder.MoCoContainer moCoContainer, BoxJobCollection boxJobCollection, BoxItem boxItem, JobManager jobManager) {
        super(TYPE, moCoContainer, boxJobCollection, boxItem);
        ArrayList arrayList = new ArrayList(1);
        if (boxItem instanceof BoxFolder) {
            arrayList.add(new RemoveOfflineTask(moCoContainer, this, boxItem, jobManager));
        }
        arrayList.add(new DeleteTask(moCoContainer, this, boxItem));
        addTasks(arrayList);
    }

    @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter
    public ProgressReporter.ProgressType[] getSupportedProgressTypes() {
        return new ProgressReporter.ProgressType[]{ProgressReporter.ProgressType.NUM_TASKS, ProgressReporter.ProgressType.PERCENTAGE};
    }

    @Override // com.box.android.coreservices.jobmanager.jobs.BoxJob
    protected ThreadPoolExecutor getExecutor() {
        return ((IExecutorPool) this.mMoCoContainer.getUserContextManager().getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.EXECUTOR_POOL)).getPriorityJobManagerExecutor();
    }
}
