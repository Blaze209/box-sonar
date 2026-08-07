package com.box.android.coreservices.jobmanager.tasks;

import com.box.android.coreservices.jobmanager.JobManager;
import com.box.android.coreservices.jobmanager.dao.ProgressReporter;
import com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection;
import com.box.android.coreservices.jobmanager.jobcollections.OfflineBoxJobCollection;
import com.box.android.coreservices.jobmanager.jobs.BoxItemJob;
import com.box.android.coreservices.jobmanager.jobs.BoxJob;
import com.box.android.coreservices.modelcontroller.BoxFutureTask;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.coreservices.modelcontroller.MoCoContainerBuilder;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.android.coreservices.models.BoxModelOfflineManager;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes9.dex */
public final class RemoveOfflineTask extends CleanUpItemTask {
    public static final String TYPE = "RemoveOfflineTask";
    private JobManager mJobManager;

    public RemoveOfflineTask() {
    }

    public RemoveOfflineTask(MoCoContainerBuilder.MoCoContainer moCoContainer, BoxJob boxJob, BoxItem boxItem, JobManager jobManager) {
        super(TYPE, JobManager.generateId(), boxItem, moCoContainer, boxJob);
        this.mJobManager = jobManager;
        saveToLevelDB();
    }

    @Override // com.box.android.coreservices.jobmanager.tasks.BoxTask
    protected BoxFutureTask<BoxMessage<?>> createTask() {
        final ArrayList arrayList = new ArrayList();
        return new BoxFutureTask<BoxMessage<?>>(new Callable<BoxMessage<?>>() { // from class: com.box.android.coreservices.jobmanager.tasks.RemoveOfflineTask.1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // java.util.concurrent.Callable
            public BoxMessage<?> call() throws Exception {
                RemoveOfflineTask removeOfflineTask = RemoveOfflineTask.this;
                removeOfflineTask.reportStarted(removeOfflineTask);
                BoxMessage<?> boxMessage = new BoxMessage<>();
                boxMessage.setSuccess(false);
                LinkedList<BoxFile> linkedList = new LinkedList();
                LinkedList<BoxFolder> linkedList2 = new LinkedList();
                LinkedList linkedList3 = new LinkedList();
                RemoveOfflineTask removeOfflineTask2 = RemoveOfflineTask.this;
                removeOfflineTask2.populateListsWithChildren(linkedList2, linkedList, linkedList3, removeOfflineTask2.mMoCoContainer.getUserContextManager().getBoxSession(null));
                RemoveOfflineTask.this.updateProgress(0L, linkedList.size() + linkedList2.size());
                if (boxMessage.getException() != null) {
                    boxMessage.setSuccess(false);
                    RemoveOfflineTask removeOfflineTask3 = RemoveOfflineTask.this;
                    removeOfflineTask3.reportError(removeOfflineTask3, boxMessage.getException());
                    return boxMessage;
                }
                List<BoxJobCollection> allJobCollections = RemoveOfflineTask.this.mJobManager.getAllJobCollections();
                ArrayList arrayList2 = new ArrayList();
                for (BoxJobCollection boxJobCollection : allJobCollections) {
                    if (boxJobCollection instanceof OfflineBoxJobCollection) {
                        arrayList2.add(boxJobCollection);
                    }
                }
                HashMap map = new HashMap();
                HashMap map2 = new HashMap();
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    for (BoxJob boxJob : ((BoxJobCollection) it.next()).getJobs()) {
                        BoxItemJob boxItemJob = (BoxItemJob) boxJob;
                        map.put(boxItemJob.getItemId(), boxItemJob);
                        for (BoxTask boxTask : boxJob.getTasks()) {
                            if (boxTask instanceof OfflineTask) {
                                map2.put(((OfflineTask) boxTask).getItemId(), boxTask);
                            } else if (boxTask instanceof PrepareOfflineTask) {
                                map2.put(((PrepareOfflineTask) boxTask).getItemId(), boxTask);
                            }
                        }
                    }
                }
                int i = 0;
                for (BoxFolder boxFolder : linkedList2) {
                    BoxModelOfflineManager.setFolderOfflineSavedStartedBlocking(boxFolder, false, 0L, RemoveOfflineTask.this.mMoCoContainer.getUserContextManager());
                    BoxItemJob boxItemJob2 = (BoxItemJob) map.get(boxFolder.getUserId());
                    if (boxItemJob2 != null) {
                        boxItemJob2.cancel();
                    }
                    BoxTask boxTask2 = (BoxTask) map2.get(boxFolder.getUserId());
                    if (boxTask2 != null && !boxTask2.isCancelled()) {
                        boxTask2.cancel();
                    }
                    i++;
                    RemoveOfflineTask removeOfflineTask4 = RemoveOfflineTask.this;
                    removeOfflineTask4.updateProgress(i, removeOfflineTask4.mProgressMax);
                }
                for (BoxFile boxFile : linkedList) {
                    BoxTask boxTask3 = (BoxTask) map2.get(boxFile.getUserId());
                    if (boxTask3 != null && !boxTask3.isCancelled()) {
                        boxTask3.cancel();
                    }
                    RemoveOfflineTask.this.mMoCoContainer.getUserContextManager().getPreviewStorage().clearCacheForFile(boxFile);
                    BoxModelOfflineManager.setFileOfflineUserSavedBlocking(boxFile, false, RemoveOfflineTask.this.mMoCoContainer.getUserContextManager());
                    i++;
                    RemoveOfflineTask removeOfflineTask5 = RemoveOfflineTask.this;
                    removeOfflineTask5.updateProgress(i, removeOfflineTask5.mProgressMax);
                }
                RemoveOfflineTask removeOfflineTask6 = RemoveOfflineTask.this;
                removeOfflineTask6.reportCompleted(removeOfflineTask6);
                return boxMessage;
            }
        }, IBaseModelController.INSTANCE.getNextRequestId()) { // from class: com.box.android.coreservices.jobmanager.tasks.RemoveOfflineTask.2
            @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
            public boolean cancel(boolean z) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((BoxFutureTask) it.next()).cancel(z);
                }
                return super.cancel(z);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgress(long j, long j2) {
        if (this.mProgress == j && this.mProgressMax == j2) {
            return;
        }
        long j3 = j - this.mProgress;
        long j4 = j2 - this.mProgressMax;
        this.mProgress = j;
        this.mProgressMax = j2;
        reportProgressUpdated(this, ProgressReporter.ProgressType.NUM_FILES, j3, j4);
    }

    @Override // com.box.android.coreservices.jobmanager.tasks.BoxItemTask, com.box.android.coreservices.jobmanager.tasks.BoxTask
    protected void handleCancelProgress() {
        updateProgress(0L, 0L);
    }
}
