package com.box.android.coreservices.jobmanager.tasks;

import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.jobmanager.JobManager;
import com.box.android.coreservices.jobmanager.dao.ProgressReporter;
import com.box.android.coreservices.jobmanager.jobs.BoxJob;
import com.box.android.coreservices.modelcontroller.BoxAppFutureTask;
import com.box.android.coreservices.modelcontroller.BoxFutureTask;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.coreservices.modelcontroller.MoCoContainerBuilder;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.android.coreservices.utilities.PreviewOrigin;
import com.box.androidsdk.content.BoxApiPreview;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxDocumentFile;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.utils.SdkUtils;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes9.dex */
public class OfflineTask extends BoxFileTransferTask {
    public static final String METADATA_DOCUMENT_TAG = "doc";
    public static final String TEMP_FILE_TAG = "temp";
    public static final String TYPE = "offlineTask";
    public static final String USER_SAVED = "userSaved";
    public BoxMessage<?> msg;

    public OfflineTask() {
        this.msg = new BoxMessage<>();
    }

    public OfflineTask(MoCoContainerBuilder.MoCoContainer moCoContainer, BoxJob boxJob, BoxFile boxFile, boolean z) {
        super(TYPE, JobManager.generateId(), boxFile, moCoContainer, boxJob);
        this.msg = new BoxMessage<>();
        setUserSaved(z);
        saveToLevelDB();
    }

    public boolean isUserSaved() {
        return getUserSaved();
    }

    @Override // com.box.android.coreservices.jobmanager.tasks.BoxTask
    protected BoxFutureTask<BoxMessage<?>> createTask() {
        final ArrayList arrayList = new ArrayList();
        return new BoxFutureTask<BoxMessage<?>>(new Callable<BoxMessage<?>>() { // from class: com.box.android.coreservices.jobmanager.tasks.OfflineTask.1
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
                OfflineTask.this.mProgress = 0L;
                OfflineTask offlineTask = OfflineTask.this;
                offlineTask.reportProgressUpdated(offlineTask, ProgressReporter.ProgressType.NUM_TASKS, 1L, 0L);
                OfflineTask.this.msg.setSuccess(false);
                BoxResponse boxResponse = OfflineTask.this.mMoCoContainer.getBaseModelController().performLocal(OfflineTask.this.mMoCoContainer.getFileApi().getInfoRequest(OfflineTask.this.getItemId())).get();
                if (boxResponse.getException() instanceof BoxException) {
                    BoxAppFutureTask boxAppFutureTaskPerformRemote = OfflineTask.this.mMoCoContainer.getBaseModelController().performRemote(OfflineTask.this.mMoCoContainer.getFileApi().getInfoRequest(OfflineTask.this.getItemId()));
                    arrayList.add(boxAppFutureTaskPerformRemote);
                    boxResponse = (BoxResponse) boxAppFutureTaskPerformRemote.get();
                }
                if (boxResponse.isSuccess()) {
                    OfflineTask.this.mBoxItem = (BoxItem) boxResponse.getResult();
                    if (SdkUtils.isBlank(OfflineTask.this.getSharedLink())) {
                        OfflineTask.this.mMoCoContainer.getMocoTransfers().saveFileForOffline(OfflineTask.this.getItemId(), OfflineTask.this.mMoCoContainer.getUserContextManager(), OfflineTask.this.getFileTransferProgressListener()).run();
                    } else {
                        OfflineTask.this.mMoCoContainer.getMocoTransfers().saveFileForOffline(OfflineTask.this.getItemId(), OfflineTask.this.mMoCoContainer.getUserContextManager(), OfflineTask.this.getFileTransferProgressListener(), new BoxExtendedApiFile(OfflineTask.this.createSharedLinkSession())).run();
                    }
                    OfflineTask.this.msg.setSuccess(true);
                } else {
                    OfflineTask.this.msg.setException(boxResponse.getException());
                    OfflineTask offlineTask2 = OfflineTask.this;
                    offlineTask2.reportError(offlineTask2, offlineTask2.msg.getException());
                }
                return OfflineTask.this.msg;
            }
        }, IBaseModelController.INSTANCE.getNextRequestId()) { // from class: com.box.android.coreservices.jobmanager.tasks.OfflineTask.2
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

    public boolean getUserSaved() {
        return ((Boolean) this.mProperties.get("userSaved")).booleanValue();
    }

    public void setUserSaved(boolean z) {
        this.mProperties.put("userSaved", Boolean.valueOf(z));
    }

    @Override // com.box.android.coreservices.jobmanager.JobItemJsonEntity
    public void deleteFromLevelDB() {
        super.deleteFromLevelDB();
        File offlineFile = this.mMoCoContainer.getUserContextManager().getPreviewStorage().getOfflineFile((BoxFile) this.mBoxItem, "temp");
        if (offlineFile.exists()) {
            offlineFile.delete();
        }
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
    protected void reportCompleted(ProgressReporter progressReporter) {
        MoCoContainerBuilder.MoCoContainer moCoContainer = this.mMoCoContainer;
        this.mMoCoContainer.broadcastJobStatus(MoCoContainerBuilder.MoCoContainer.createStatusMessage(this, getItem()));
        super.reportCompleted(progressReporter);
        saveMetadataAsync(this.mBoxItem, this.mMoCoContainer);
    }

    private void saveMetadataAsync(final BoxItem boxItem, final MoCoContainerBuilder.MoCoContainer moCoContainer) {
        new Thread(new Runnable() { // from class: com.box.android.coreservices.jobmanager.tasks.OfflineTask$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$saveMetadataAsync$0(boxItem, moCoContainer);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: saveMetadata, reason: merged with bridge method [inline-methods] */
    public void lambda$saveMetadataAsync$0(BoxItem boxItem, MoCoContainerBuilder.MoCoContainer moCoContainer) {
        BoxFile boxFile = (BoxFile) boxItem;
        if (BoxApiPreview.Extensions.PDF.toString().equalsIgnoreCase(CommonBoxUtil.getFileExtension(boxFile.getName(), ""))) {
            BoxDocumentFile boxDocumentFileCreateBoxDocumentFile = createBoxDocumentFile(boxFile);
            boxDocumentFileCreateBoxDocumentFile.setContentLength(boxFile.getSize().longValue());
            moCoContainer.getUserContextManager().getPreviewStorage().cacheMetadata(boxDocumentFileCreateBoxDocumentFile, "doc", PreviewOrigin.INSTANCE.original());
        }
    }

    BoxDocumentFile createBoxDocumentFile(BoxFile boxFile) {
        return new BoxDocumentFile(boxFile);
    }
}
