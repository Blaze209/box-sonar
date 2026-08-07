package com.box.android.coreservices.jobmanager.tasks;

import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.jobmanager.JobItem;
import com.box.android.coreservices.jobmanager.JobManager;
import com.box.android.coreservices.jobmanager.dao.ProgressReporter;
import com.box.android.coreservices.jobmanager.jobs.BoxJob;
import com.box.android.coreservices.modelcontroller.BoxFutureTask;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.coreservices.modelcontroller.MoCoContainerBuilder;
import com.box.android.coreservices.modelcontroller.messages.BoxFileTransferMessage;
import com.box.android.coreservices.utilities.CoreServiceUtils;
import com.box.android.domain.exceptions.PermissionDeniedException;
import com.box.android.domain.utils.SupportedFileExtensions;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxExtendedApiPreview;
import com.box.androidsdk.content.models.BoxError;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.utils.SdkUtils;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes9.dex */
public class OfflinePreviewTask extends BoxFileTransferTask implements Comparable<OfflinePreviewTask> {
    public static final String TYPE = "offlinePreviewTask";
    public static final String USER_SAVED = "userSaved";
    private transient long mRetryStartTime;
    private transient long mRetryWaitTime;

    public OfflinePreviewTask() {
        this.mRetryStartTime = 0L;
        this.mRetryWaitTime = 0L;
    }

    public OfflinePreviewTask(MoCoContainerBuilder.MoCoContainer moCoContainer, BoxJob boxJob, BoxFile boxFile, boolean z) {
        super(TYPE, JobManager.generateId(), boxFile, moCoContainer, boxJob);
        this.mRetryStartTime = 0L;
        this.mRetryWaitTime = 0L;
        setUserSaved(z);
        saveToLevelDB();
    }

    public boolean isUserSaved() {
        if (getUserSaved() == null) {
            return false;
        }
        return getUserSaved().booleanValue();
    }

    public Boolean getUserSaved() {
        return (Boolean) this.mProperties.get("userSaved");
    }

    public void setUserSaved(boolean z) {
        this.mProperties.put("userSaved", Boolean.valueOf(z));
    }

    @Override // com.box.android.coreservices.jobmanager.tasks.BoxItemTask, com.box.android.coreservices.jobmanager.tasks.BoxTask, com.box.android.coreservices.jobmanager.JobItem, com.box.android.coreservices.jobmanager.JobItemJsonEntity, com.box.android.coreservices.models.BoxPersistableObject
    protected void parseJSONMember(JsonObject.Member member) {
        String name = member.getName();
        JsonValue value = member.getValue();
        if (name.equals("userSaved")) {
            setUserSaved(value.asBoolean());
        } else {
            super.parseJSONMember(member);
        }
    }

    @Override // com.box.android.coreservices.jobmanager.tasks.BoxTask, com.box.android.coreservices.jobmanager.JobItem
    protected void reportError(ProgressReporter progressReporter, Exception exc) {
        BoxError asBoxError;
        if ((exc instanceof BoxException) && (asBoxError = ((BoxException) exc).getAsBoxError()) != null) {
            if (202 == asBoxError.getStatus().intValue()) {
                this.mRetryStartTime = System.currentTimeMillis();
                long j = (this.mRetryWaitTime * 2) + 1000;
                this.mRetryWaitTime = j;
                if (j > TimeUnit.HOURS.toMillis(1L)) {
                    setErrorType(JobItem.ErrorType.TIMED_OUT_EXCEPTION);
                } else {
                    clearState();
                    this.mParentJob.rescheduleTask(this);
                    return;
                }
            } else if (400 == asBoxError.getStatus().intValue() && "requested_preview_unavailable".equals(asBoxError.getCode()) && isAndroidPreviewableItem()) {
                List<BoxTask> childJobItems = this.mParentJob.getChildJobItems();
                if (childJobItems != null) {
                    for (BoxTask boxTask : childJobItems) {
                        if (!(boxTask instanceof OfflineTask) || !((OfflineTask) boxTask).getItem().getUserId().equals(this.mBoxItem.getUserId())) {
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new OfflineTask(this.mMoCoContainer, this.mParentJob, (BoxFile) this.mBoxItem, isUserSaved()));
                    this.mParentJob.addTasks(arrayList, true, true);
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(new OfflineTask(this.mMoCoContainer, this.mParentJob, (BoxFile) this.mBoxItem, isUserSaved()));
                    this.mParentJob.addTasks(arrayList2, true, true);
                }
                reportCompleted(progressReporter);
                return;
            }
        }
        super.reportError(progressReporter, exc);
    }

    private boolean isAndroidPreviewableItem() {
        String fileExtension = CommonBoxUtil.getFileExtension(this.mBoxItem.getName(), "");
        return SupportedFileExtensions.INSTANCE.isPlayableAudio(fileExtension) || SupportedFileExtensions.INSTANCE.isPlayableVideo(fileExtension) || SupportedFileExtensions.INSTANCE.isOpenableDocument(fileExtension);
    }

    public long getNextScheduledRunTime() {
        return this.mRetryStartTime + this.mRetryWaitTime;
    }

    @Override // com.box.android.coreservices.jobmanager.tasks.BoxTask
    protected BoxFutureTask<BoxFileTransferMessage> createTask() {
        if (this.mRetryStartTime > 0) {
            long nextRequestId = IBaseModelController.INSTANCE.getNextRequestId();
            final ArrayList arrayList = new ArrayList(1);
            return new BoxFutureTask<BoxFileTransferMessage>(new Callable<BoxFileTransferMessage>() { // from class: com.box.android.coreservices.jobmanager.tasks.OfflinePreviewTask.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public BoxFileTransferMessage call() throws Exception {
                    long nextScheduledRunTime = OfflinePreviewTask.this.getNextScheduledRunTime() - System.currentTimeMillis();
                    if (nextScheduledRunTime > 0) {
                        Thread.sleep(nextScheduledRunTime);
                    }
                    arrayList.add(OfflinePreviewTask.this.createPreviewTask());
                    return (BoxFileTransferMessage) ((BoxFutureTask) arrayList.get(0)).runAndGet();
                }
            }, nextRequestId) { // from class: com.box.android.coreservices.jobmanager.tasks.OfflinePreviewTask.2
                @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
                public boolean cancel(boolean z) {
                    if (arrayList.size() > 0) {
                        ((BoxFutureTask) arrayList.get(0)).cancel(z);
                    }
                    return super.cancel(z);
                }
            };
        }
        return createPreviewTask();
    }

    @Override // com.box.android.coreservices.jobmanager.tasks.BoxTask, com.box.android.coreservices.jobmanager.JobItem
    protected void reportCompleted(ProgressReporter progressReporter) {
        MoCoContainerBuilder.MoCoContainer moCoContainer = this.mMoCoContainer;
        this.mMoCoContainer.broadcastJobStatus(MoCoContainerBuilder.MoCoContainer.createStatusMessage(this, getItem()));
        super.reportCompleted(progressReporter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BoxFutureTask<BoxFileTransferMessage> createPreviewTask() {
        try {
            if (CoreServiceUtils.canOfflineFile(this.mBoxItem, this.mMoCoContainer.getUserContextManager().getUserSharedPrefs())) {
                if (SdkUtils.isBlank(getSharedLink())) {
                    return this.mMoCoContainer.getMocoTransfers().savePreviewForOffline(this.mBoxItem.getUserId(), this.mMoCoContainer.getUserContextManager(), getFileTransferProgressListener());
                }
                return this.mMoCoContainer.getMocoTransfers().savePreviewForOffline(this.mBoxItem.getUserId(), this.mMoCoContainer.getUserContextManager(), getFileTransferProgressListener(), new BoxExtendedApiPreview(createSharedLinkSession()));
            }
            return new BoxFutureTask<>(new Callable<BoxFileTransferMessage>() { // from class: com.box.android.coreservices.jobmanager.tasks.OfflinePreviewTask.4
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
                public BoxFileTransferMessage call() throws Exception {
                    new BoxFileTransferMessage().setSuccess(false);
                    OfflinePreviewTask offlinePreviewTask = OfflinePreviewTask.this;
                    offlinePreviewTask.reportStarted(offlinePreviewTask);
                    OfflinePreviewTask.this.reportError(null, new PermissionDeniedException());
                    return new BoxFileTransferMessage();
                }
            }, IBaseModelController.INSTANCE.getNextRequestId());
        } catch (Exception e) {
            return new BoxFutureTask<>(new Callable<BoxFileTransferMessage>() { // from class: com.box.android.coreservices.jobmanager.tasks.OfflinePreviewTask.3
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
                public BoxFileTransferMessage call() throws Exception {
                    new BoxFileTransferMessage().setSuccess(false);
                    OfflinePreviewTask offlinePreviewTask = OfflinePreviewTask.this;
                    offlinePreviewTask.reportStarted(offlinePreviewTask);
                    OfflinePreviewTask.this.reportError(null, e);
                    return new BoxFileTransferMessage();
                }
            }, IBaseModelController.INSTANCE.getNextRequestId());
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(OfflinePreviewTask offlinePreviewTask) {
        return (int) (getNextScheduledRunTime() - offlinePreviewTask.getNextScheduledRunTime());
    }

    @Override // com.box.android.coreservices.jobmanager.tasks.BoxFileTransferTask, com.box.android.coreservices.jobmanager.tasks.BoxTask
    protected void setErrorStateFromError(Exception exc) {
        BoxError asBoxError;
        if ((exc instanceof BoxException) && (asBoxError = ((BoxException) exc).getAsBoxError()) != null && CommonBoxUtil.valuePresentInSet(asBoxError.getStatus().intValue(), 400, 404) && ("requested_preview_unavailable".equals(asBoxError.getCode()) || "preview_cannot_be_generated".equals(asBoxError.getCode()))) {
            setErrorType(JobItem.ErrorType.PREVIEW_NOT_AVAILABLE);
        } else {
            super.setErrorStateFromError(exc);
        }
    }
}
