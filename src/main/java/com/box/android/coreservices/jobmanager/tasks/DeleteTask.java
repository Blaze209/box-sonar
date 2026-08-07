package com.box.android.coreservices.jobmanager.tasks;

import com.box.android.coreservices.jobmanager.JobManager;
import com.box.android.coreservices.jobmanager.jobs.BoxJob;
import com.box.android.coreservices.modelcontroller.BoxFutureTask;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.coreservices.modelcontroller.MoCoContainerBuilder;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxBookmark;
import com.box.androidsdk.content.models.BoxCollaboration;
import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxIteratorCollaborations;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.utils.BoxItemUtility;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes9.dex */
public final class DeleteTask extends CleanUpItemTask {
    public static final String TYPE = "DeleteTask";

    public DeleteTask() {
    }

    public DeleteTask(MoCoContainerBuilder.MoCoContainer moCoContainer, BoxJob boxJob, BoxItem boxItem) {
        super(TYPE, JobManager.generateId(), boxItem, moCoContainer, boxJob);
        saveToLevelDB();
    }

    @Override // com.box.android.coreservices.jobmanager.tasks.BoxTask
    protected BoxFutureTask<BoxMessage<?>> createTask() {
        return new BoxFutureTask<>(new Callable<BoxMessage<?>>() { // from class: com.box.android.coreservices.jobmanager.tasks.DeleteTask.1
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
                Exception exception;
                DeleteTask deleteTask = DeleteTask.this;
                deleteTask.reportStarted(deleteTask);
                if (DeleteTask.this.getItem() instanceof BoxCollaborationItem) {
                    exception = deleteCollaboratorItem((BoxCollaborationItem) DeleteTask.this.getItem());
                } else {
                    exception = DeleteTask.this.getItem() instanceof BoxBookmark ? getException((BoxResponse) DeleteTask.this.mMoCoContainer.getBaseModelController().performRemote(DeleteTask.this.mMoCoContainer.getWeblinkApi().getDeleteRequest(DeleteTask.this.getItem())).get()) : null;
                }
                if (exception == null) {
                    DeleteTask deleteTask2 = DeleteTask.this;
                    deleteTask2.reportCompleted(deleteTask2);
                } else {
                    DeleteTask deleteTask3 = DeleteTask.this;
                    deleteTask3.reportError(deleteTask3, exception);
                }
                return null;
            }

            private Exception deleteCollaboratorItem(BoxCollaborationItem boxCollaborationItem) {
                try {
                    if (!boxCollaborationItem.getPermissions().contains(BoxItem.Permission.CAN_DELETE) && BoxItemUtility.isSharedWithMe(boxCollaborationItem, DeleteTask.this.mMoCoContainer.getUserContextManager().getUserInfo())) {
                        BoxCollaboration boxCollaborationFindDirectCollaboration = findDirectCollaboration(boxCollaborationItem);
                        if (boxCollaborationFindDirectCollaboration != null) {
                            return getException((BoxResponse) DeleteTask.this.mMoCoContainer.getBaseModelController().performRemote(DeleteTask.this.mMoCoContainer.getCollabApi().getDeleteRequest(boxCollaborationFindDirectCollaboration)).get());
                        }
                        return performDelete(boxCollaborationItem);
                    }
                    return performDelete(boxCollaborationItem);
                } catch (BoxException | InterruptedException | ExecutionException e) {
                    if (e instanceof InterruptedException) {
                        Thread.currentThread().interrupt();
                    }
                    return e;
                }
            }

            private BoxCollaboration findDirectCollaboration(BoxCollaborationItem boxCollaborationItem) throws BoxException {
                BoxIteratorCollaborations<BoxCollaboration> collaborations = getCollaborations(boxCollaborationItem);
                String currentContextId = DeleteTask.this.mMoCoContainer.getUserContextManager().getCurrentContextId();
                for (BoxCollaboration boxCollaboration : collaborations) {
                    if (boxCollaboration.getAccessibleBy().getUserId().equals(currentContextId) && boxCollaboration.getItem().getUserId().equals(boxCollaborationItem.getUserId())) {
                        return boxCollaboration;
                    }
                }
                return null;
            }

            private Exception performDelete(BoxCollaborationItem boxCollaborationItem) throws ExecutionException, InterruptedException {
                BoxResponse boxResponse;
                if ("folder".equals(boxCollaborationItem.getType())) {
                    boxResponse = (BoxResponse) DeleteTask.this.mMoCoContainer.getBaseModelController().performRemote(DeleteTask.this.mMoCoContainer.getFolderApi().getDeleteRequest(DeleteTask.this.getItem())).get();
                } else {
                    boxResponse = "file".equals(boxCollaborationItem.getType()) ? (BoxResponse) DeleteTask.this.mMoCoContainer.getBaseModelController().performRemote(DeleteTask.this.mMoCoContainer.getFileApi().getDeleteRequest(DeleteTask.this.getItem())).get() : null;
                }
                return getException(boxResponse);
            }

            /* JADX WARN: Multi-variable type inference failed */
            private BoxIteratorCollaborations getCollaborations(BoxCollaborationItem boxCollaborationItem) throws BoxException {
                BoxIteratorCollaborations boxIteratorCollaborations = new BoxIteratorCollaborations();
                if ("folder".equals(boxCollaborationItem.getType())) {
                    return (BoxIteratorCollaborations) DeleteTask.this.mMoCoContainer.getFolderApi().getCollaborationsRequest(boxCollaborationItem.getUserId()).send();
                }
                return "file".equals(boxCollaborationItem.getType()) ? (BoxIteratorCollaborations) DeleteTask.this.mMoCoContainer.getFileApi().getCollaborationsRequest(boxCollaborationItem.getUserId()).send() : boxIteratorCollaborations;
            }

            private Exception getException(BoxResponse boxResponse) {
                if (boxResponse == null || boxResponse.isSuccess()) {
                    return null;
                }
                return boxResponse.getException();
            }
        }, IBaseModelController.INSTANCE.getNextRequestId());
    }
}
