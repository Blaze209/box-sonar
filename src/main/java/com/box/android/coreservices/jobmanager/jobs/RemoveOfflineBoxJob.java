package com.box.android.coreservices.jobmanager.jobs;

import com.box.android.coreservices.jobmanager.JobManager;
import com.box.android.coreservices.jobmanager.dao.ProgressReporter;
import com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection;
import com.box.android.coreservices.jobmanager.tasks.RemoveOfflineTask;
import com.box.android.coreservices.modelcontroller.MoCoContainerBuilder;
import com.box.android.coreservices.models.BoxModelOfflineManager;
import com.box.android.domain.identity.IExecutorPool;
import com.box.android.domain.identity.IUserContext;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import java.util.ArrayList;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes9.dex */
public class RemoveOfflineBoxJob extends BoxItemJob {
    public static final String TYPE = "RemoveOfflineBoxJob";

    public RemoveOfflineBoxJob() {
    }

    public RemoveOfflineBoxJob(MoCoContainerBuilder.MoCoContainer moCoContainer, BoxJobCollection boxJobCollection, BoxItem boxItem, JobManager jobManager) {
        super(TYPE, moCoContainer, boxJobCollection, boxItem);
        if (boxItem instanceof BoxFolder) {
            BoxModelOfflineManager.setFolderOfflineSavedStartedBlocking((BoxFolder) boxItem, false, 0L, moCoContainer.getUserContextManager());
        } else if (boxItem instanceof BoxFile) {
            BoxModelOfflineManager.setFileOfflineUserSavedBlocking((BoxFile) boxItem, false, moCoContainer.getUserContextManager());
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new RemoveOfflineTask(moCoContainer, this, boxItem, jobManager));
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

    @Override // com.box.android.coreservices.jobmanager.JobItem
    protected void reportCompleted(ProgressReporter progressReporter) {
        MoCoContainerBuilder.MoCoContainer moCoContainer = this.mMoCoContainer;
        this.mMoCoContainer.broadcastJobStatus(MoCoContainerBuilder.MoCoContainer.createStatusMessage(this, getBoxItem()));
        super.reportCompleted(progressReporter);
    }
}
