package com.box.android.coreservices.jobmanager.tasks;

import com.box.android.coreservices.jobmanager.JobManager;
import com.box.android.coreservices.jobmanager.dao.ProgressReporter;
import com.box.android.coreservices.jobmanager.jobs.BoxJob;
import com.box.android.coreservices.jobmanager.jobs.OfflineBoxJob;
import com.box.android.coreservices.modelcontroller.BoxAppFutureTask;
import com.box.android.coreservices.modelcontroller.BoxFutureTask;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.coreservices.modelcontroller.MoCoContainerBuilder;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.android.coreservices.models.BoxAccountManager;
import com.box.android.coreservices.models.BoxModelOfflineManager;
import com.box.android.domain.exceptions.PermissionDeniedException;
import com.box.androidsdk.content.models.BoxBookmark;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.boxandroidlibv2private.requests.requestobjects.BoxFullFolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes9.dex */
public class PrepareOfflineTask extends BoxItemTask {
    public static final String TYPE = "prepareOfflineTask";

    public PrepareOfflineTask() {
    }

    public PrepareOfflineTask(MoCoContainerBuilder.MoCoContainer moCoContainer, BoxJob boxJob, BoxFolder boxFolder) {
        super(TYPE, JobManager.generateId(), boxFolder, moCoContainer, boxJob);
    }

    @Override // com.box.android.coreservices.jobmanager.tasks.BoxTask
    protected BoxFutureTask<BoxMessage<?>> createTask() {
        final ArrayList arrayList = new ArrayList();
        return new BoxFutureTask<BoxMessage<?>>(new Callable<BoxMessage<?>>() { // from class: com.box.android.coreservices.jobmanager.tasks.PrepareOfflineTask.1
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
                PrepareOfflineTask.this.mProgress = 0L;
                PrepareOfflineTask prepareOfflineTask = PrepareOfflineTask.this;
                prepareOfflineTask.reportProgressUpdated(prepareOfflineTask, ProgressReporter.ProgressType.NUM_TASKS, 1L, 0L);
                BoxMessage<?> boxMessage = new BoxMessage<>();
                boxMessage.setSuccess(false);
                if (!BoxAccountManager.isMobilePreviewOnlyOffliningEnabled(PrepareOfflineTask.this.mMoCoContainer.getUserContextManager().getUserSharedPrefs())) {
                    BoxResponse boxResponse = PrepareOfflineTask.this.mMoCoContainer.getBaseModelController().performLocal(PrepareOfflineTask.this.mMoCoContainer.getFolderApi().getInfoRequest(PrepareOfflineTask.this.getItemId())).get();
                    if (boxResponse.isSuccess() && !((BoxFolder) boxResponse.getResult()).getPermissions().contains(BoxItem.Permission.CAN_DOWNLOAD)) {
                        BoxResponse boxResponse2 = PrepareOfflineTask.this.mMoCoContainer.getBaseModelController().performRemote(PrepareOfflineTask.this.mMoCoContainer.getFolderApi().getInfoRequest(PrepareOfflineTask.this.getItemId()), null).get();
                        if (boxResponse2.isSuccess()) {
                            if (!((BoxFolder) boxResponse2.getResult()).getPermissions().contains(BoxItem.Permission.CAN_DOWNLOAD)) {
                                PrepareOfflineTask prepareOfflineTask2 = PrepareOfflineTask.this;
                                prepareOfflineTask2.reportError(prepareOfflineTask2, new PermissionDeniedException());
                                return boxMessage;
                            }
                        } else {
                            PrepareOfflineTask prepareOfflineTask3 = PrepareOfflineTask.this;
                            prepareOfflineTask3.reportError(prepareOfflineTask3, boxMessage.getException());
                            return boxMessage;
                        }
                    }
                }
                LinkedList linkedList = new LinkedList();
                BoxAppFutureTask boxAppFutureTaskPerformRemote = PrepareOfflineTask.this.mMoCoContainer.getBaseModelController().performRemote(PrepareOfflineTask.this.mMoCoContainer.getFolderApi().getFullFolderRequest(PrepareOfflineTask.this.getItemId()));
                arrayList.add(boxAppFutureTaskPerformRemote);
                BoxResponse boxResponse3 = boxAppFutureTaskPerformRemote.get();
                if (boxResponse3.isSuccess()) {
                    for (BoxItem boxItem : ((BoxFullFolder) boxResponse3.getResult()).getChildren()) {
                        if (boxItem instanceof BoxFile) {
                            BoxFile boxFile = (BoxFile) boxItem;
                            if (!BoxModelOfflineManager.isOfflineUserRemovedBlocking(boxFile, PrepareOfflineTask.this.mMoCoContainer.getUserContextManager())) {
                                linkedList.add(boxFile);
                            }
                        } else if (!(boxItem instanceof BoxFolder)) {
                            boolean z = boxItem instanceof BoxBookmark;
                        }
                    }
                    ArrayList arrayList2 = new ArrayList(linkedList.size());
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        ((OfflineBoxJob) PrepareOfflineTask.this.mParentJob).addApplicableTasks((BoxFile) it.next(), arrayList2, PrepareOfflineTask.this.getSharedLink(), PrepareOfflineTask.this.getSharedLinkPassword());
                    }
                    PrepareOfflineTask.this.mParentJob.addTasks(arrayList2, true, true);
                    PrepareOfflineTask prepareOfflineTask4 = PrepareOfflineTask.this;
                    prepareOfflineTask4.reportCompleted(prepareOfflineTask4);
                    return boxMessage;
                }
                PrepareOfflineTask prepareOfflineTask5 = PrepareOfflineTask.this;
                prepareOfflineTask5.reportError(prepareOfflineTask5, boxMessage.getException());
                return boxMessage;
            }
        }, IBaseModelController.INSTANCE.getNextRequestId()) { // from class: com.box.android.coreservices.jobmanager.tasks.PrepareOfflineTask.2
            @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
            public boolean cancel(boolean z) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((BoxAppFutureTask) it.next()).cancel(z);
                }
                return super.cancel(z);
            }
        };
    }
}
