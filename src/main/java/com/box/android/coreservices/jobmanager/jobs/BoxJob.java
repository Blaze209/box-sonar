package com.box.android.coreservices.jobmanager.jobs;

import com.box.android.coreservices.jobmanager.JobItem;
import com.box.android.coreservices.jobmanager.JobItemJsonEntity;
import com.box.android.coreservices.jobmanager.ParentJobItem;
import com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection;
import com.box.android.coreservices.jobmanager.tasks.BoxTask;
import com.box.android.coreservices.modelcontroller.MoCoContainerBuilder;
import com.box.android.domain.identity.IExecutorPool;
import com.box.android.domain.identity.IUserContext;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes9.dex */
public abstract class BoxJob extends ParentJobItem {
    private transient boolean isCancelled;
    protected transient MoCoContainerBuilder.MoCoContainer mMoCoContainer;
    protected transient BoxJobCollection mParentJobCollection;
    protected final transient CopyOnWriteArrayList<BoxTask> mTasks;

    protected BoxJob() {
        this.mTasks = new CopyOnWriteArrayList<>();
    }

    protected BoxJob(String str, String str2, MoCoContainerBuilder.MoCoContainer moCoContainer, BoxJobCollection boxJobCollection) {
        super(str, str2);
        this.mTasks = new CopyOnWriteArrayList<>();
        init(moCoContainer, boxJobCollection);
    }

    public void init(MoCoContainerBuilder.MoCoContainer moCoContainer, BoxJobCollection boxJobCollection) {
        super.init(moCoContainer.getBaseModelController().getKeyValueStore());
        this.mMoCoContainer = moCoContainer;
        this.mParentJobCollection = boxJobCollection;
    }

    public void addTasks(List<BoxTask> list) {
        addTasks(list, true, false);
    }

    public void addTasks(List<BoxTask> list, boolean z, boolean z2) {
        for (BoxTask boxTask : list) {
            addListenerToChild(boxTask);
            boxTask.init(this.mMoCoContainer, this);
            this.mTasks.add(boxTask);
            if (z2 && boxTask.getCurrentState() != JobItem.JobItemState.COMPLETED) {
                scheduleTaskForExecution(boxTask);
            }
        }
        if (z) {
            addTaskIds(list);
            saveToLevelDB();
        } else {
            addChildren(list);
        }
        Iterator<BoxTask> it = list.iterator();
        while (it.hasNext()) {
            reportTaskAdded(it.next());
        }
    }

    public List<BoxTask> getTasks() {
        return this.mTasks;
    }

    public void rescheduleTask(BoxTask boxTask) {
        this.mExecutingJobItems.remove(boxTask);
        scheduleTaskForExecution(boxTask);
    }

    protected void scheduleTaskForExecution(BoxTask boxTask) {
        if (isPaused() || boxTask.isCancelled() || boxTask.isDone()) {
            return;
        }
        try {
            getExecutor(boxTask).execute(boxTask);
        } catch (RejectedExecutionException e) {
            BoxLogUtils.logException(e);
        }
    }

    protected ThreadPoolExecutor getExecutor() {
        return ((IExecutorPool) this.mMoCoContainer.getUserContextManager().getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.EXECUTOR_POOL)).getFileTransferServiceExecutor();
    }

    protected ThreadPoolExecutor getExecutor(BoxTask boxTask) {
        return getExecutor();
    }

    private void purgeCancelledTasks() {
        getExecutor().purge();
    }

    public BoxJobCollection getParent() {
        return this.mParentJobCollection;
    }

    public void addTaskIds(List<BoxTask> list) {
        addChildTypedIds(list);
    }

    public List<JobItemJsonEntity.TypedId> getTaskTypedIds() {
        return getChildTypedIds();
    }

    @Override // com.box.android.coreservices.jobmanager.ParentJobItem
    public List<BoxTask> getChildJobItems() {
        return this.mTasks;
    }

    public void removeTask(BoxTask boxTask) {
        removeChildJobItem(boxTask);
        if (this.mTasks.isEmpty()) {
            this.mParentJobCollection.removeJob(this);
            deleteFromLevelDB();
        } else {
            if (this.isCancelled) {
                return;
            }
            saveToLevelDB();
        }
    }

    @Override // com.box.android.coreservices.jobmanager.ParentJobItem, com.box.android.coreservices.jobmanager.JobItem
    public void cancel() {
        this.isCancelled = true;
        super.cancel();
        purgeCancelledTasks();
        this.mParentJobCollection.removeJob(this);
    }

    @Override // com.box.android.coreservices.jobmanager.ParentJobItem, com.box.android.coreservices.jobmanager.JobItem
    public boolean pause() {
        boolean zPause = super.pause();
        purgeCancelledTasks();
        return zPause;
    }

    @Override // com.box.android.coreservices.jobmanager.ParentJobItem, com.box.android.coreservices.jobmanager.JobItem
    public boolean restart(boolean z) {
        boolean zRestart = super.restart(z);
        if (zRestart) {
            Iterator<BoxTask> it = this.mTasks.iterator();
            while (it.hasNext()) {
                scheduleTaskForExecution(it.next());
            }
        }
        return zRestart;
    }

    public List<BoxTask> getFailedTasks() {
        ArrayList arrayList = new ArrayList(this.mFailedJobItems.size());
        arrayList.addAll(this.mFailedJobItems);
        return arrayList;
    }
}
