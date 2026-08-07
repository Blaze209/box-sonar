package com.box.android.coreservices.jobmanager;

import com.box.android.coreservices.jobmanager.dao.ProgressReporter;
import com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection;
import com.box.android.coreservices.jobmanager.jobs.BoxJob;
import com.box.android.coreservices.jobmanager.tasks.BoxTask;
import com.box.android.coreservices.modelcontroller.MoCoContainerBuilder;
import com.box.android.domain.localrepo.IKeyValueStore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes9.dex */
public class JobCollectionList extends ParentJobItem {
    public static final String ID = "0";
    public static final String TYPE = "jobCollectionList";
    private final transient CopyOnWriteArrayList<BoxJobCollection> mJobCollections;
    private transient ListModifiedListener mListModifiedListener;
    private transient ProgressReporter.ProgressListener mOverallProgressListener;

    public interface ListModifiedListener {
        void onCollectionAdded(BoxJobCollection boxJobCollection);

        void onCollectionError(BoxJobCollection boxJobCollection);

        void onCollectionRemoved(BoxJobCollection boxJobCollection);

        void onCollectionsCleared();
    }

    @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter
    public ProgressReporter.ProgressType[] getSupportedProgressTypes() {
        return null;
    }

    public JobCollectionList() {
        this.mJobCollections = new CopyOnWriteArrayList<>();
    }

    public JobCollectionList(MoCoContainerBuilder.MoCoContainer moCoContainer, ProgressReporter.ProgressListener progressListener, JobManager jobManager) {
        super(TYPE, "0");
        this.mJobCollections = new CopyOnWriteArrayList<>();
        init(moCoContainer, progressListener, jobManager);
    }

    public void setListModifiedListener(ListModifiedListener listModifiedListener) {
        this.mListModifiedListener = listModifiedListener;
    }

    public void init(MoCoContainerBuilder.MoCoContainer moCoContainer, ProgressReporter.ProgressListener progressListener, JobManager jobManager) {
        super.init(moCoContainer.getBaseModelController().getKeyValueStore());
        this.mOverallProgressListener = progressListener;
        for (JobItemJsonEntity.TypedId typedId : getJobCollectionTypedIds()) {
            IKeyValueStore kVStore = moCoContainer.getUserContextManager().getCurrentContext().getKVStore();
            IKeyValueStore.KeyNamer keyNamer = kVStore.keyNamer();
            BoxJobCollection boxJobCollection = (BoxJobCollection) kVStore.getBoxPersistableObject(keyNamer.getKey(JobItemJsonEntity.SCHEME, typedId.getType(), typedId.getId()));
            if (boxJobCollection != null) {
                boxJobCollection.init(moCoContainer, this);
                List<JobItemJsonEntity.TypedId> jobTypedIds = boxJobCollection.getJobTypedIds();
                ArrayList arrayList = new ArrayList(jobTypedIds.size());
                for (JobItemJsonEntity.TypedId typedId2 : jobTypedIds) {
                    BoxJob boxJob = (BoxJob) kVStore.getBoxPersistableObject(keyNamer.getKey(JobItemJsonEntity.SCHEME, typedId2.getType(), typedId2.getId()));
                    boxJob.init(moCoContainer, boxJobCollection);
                    arrayList.add(boxJob);
                    List<JobItemJsonEntity.TypedId> taskTypedIds = boxJob.getTaskTypedIds();
                    ArrayList arrayList2 = new ArrayList(taskTypedIds.size());
                    for (JobItemJsonEntity.TypedId typedId3 : taskTypedIds) {
                        BoxTask boxTask = (BoxTask) kVStore.getBoxPersistableObject(keyNamer.getKey(JobItemJsonEntity.SCHEME, typedId3.getType(), typedId3.getId()));
                        if (boxTask != null) {
                            boxTask.init(moCoContainer, boxJob);
                            arrayList2.add(boxTask);
                        }
                    }
                    boxJob.addTasks(arrayList2, false, false);
                }
                boxJobCollection.addJobs(arrayList, false);
                jobManager.addJobCollection(boxJobCollection, false);
            }
        }
    }

    public List<BoxJobCollection> getJobCollections() {
        return this.mJobCollections;
    }

    public void addJobCollection(BoxJobCollection boxJobCollection, boolean z) {
        this.mJobCollections.add(boxJobCollection);
        boxJobCollection.addProgressListener(this.mOverallProgressListener);
        if (z) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(boxJobCollection);
            addChildTypedIds(arrayList);
            saveToLevelDB();
        }
        ListModifiedListener listModifiedListener = this.mListModifiedListener;
        if (listModifiedListener != null) {
            listModifiedListener.onCollectionAdded(boxJobCollection);
        }
    }

    public void clearAllCompletedJobCollections() {
        ArrayList arrayList = new ArrayList();
        for (BoxJobCollection boxJobCollection : getJobCollections()) {
            if (boxJobCollection.isSuccessfullyCompleted()) {
                arrayList.add(boxJobCollection);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((BoxJobCollection) it.next()).cancel();
        }
        ListModifiedListener listModifiedListener = this.mListModifiedListener;
        if (listModifiedListener != null) {
            listModifiedListener.onCollectionsCleared();
        }
    }

    public void removeJobCollection(BoxJobCollection boxJobCollection) {
        removeChildJobItem(boxJobCollection);
        saveToLevelDB();
        boxJobCollection.deleteFromLevelDB();
        ListModifiedListener listModifiedListener = this.mListModifiedListener;
        if (listModifiedListener != null) {
            listModifiedListener.onCollectionRemoved(boxJobCollection);
        }
    }

    public List<JobItemJsonEntity.TypedId> getJobCollectionTypedIds() {
        return getChildTypedIds();
    }

    @Override // com.box.android.coreservices.jobmanager.ParentJobItem
    public List<? extends JobItem> getChildJobItems() {
        return this.mJobCollections;
    }

    @Override // com.box.android.coreservices.jobmanager.ParentJobItem
    public String getDescription() {
        throw new UnsupportedOperationException("JobCollectionList does not support returning a description");
    }

    @Override // com.box.android.coreservices.jobmanager.JobItem
    public String getTitle() {
        throw new UnsupportedOperationException("JobCollectionList does not support returning a title");
    }

    @Override // com.box.android.coreservices.jobmanager.JobItem
    public String getErrorText() {
        throw new UnsupportedOperationException("JobCollectionList does not support returning error text");
    }

    @Override // com.box.android.coreservices.jobmanager.JobItem
    protected void reportError(ProgressReporter progressReporter, Exception exc) {
        super.reportError(progressReporter, exc);
        ListModifiedListener listModifiedListener = this.mListModifiedListener;
        if (listModifiedListener != null) {
            listModifiedListener.onCollectionError((BoxJobCollection) progressReporter);
        }
    }

    @Override // com.box.android.coreservices.jobmanager.ParentJobItem, com.box.android.coreservices.jobmanager.JobItem
    public boolean hasError() {
        Iterator<BoxJobCollection> it = this.mJobCollections.iterator();
        while (it.hasNext()) {
            if (it.next().hasError()) {
                return true;
            }
        }
        return false;
    }
}
