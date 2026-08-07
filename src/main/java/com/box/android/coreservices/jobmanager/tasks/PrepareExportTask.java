package com.box.android.coreservices.jobmanager.tasks;

import com.box.android.coreservices.jobmanager.JobManager;
import com.box.android.coreservices.jobmanager.dao.NameIdPair;
import com.box.android.coreservices.jobmanager.dao.ProgressReporter;
import com.box.android.coreservices.jobmanager.jobs.BoxJob;
import com.box.android.coreservices.jobmanager.jobs.ExportBoxJob;
import com.box.android.coreservices.modelcontroller.BoxAppFutureTask;
import com.box.android.coreservices.modelcontroller.BoxFutureTask;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.coreservices.modelcontroller.IMoCoBoxTransfers;
import com.box.android.coreservices.modelcontroller.MoCoContainerBuilder;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.android.coreservices.utilities.CoreServiceUtils;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.boxandroidlibv2private.requests.requestobjects.BoxFullFolder;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes9.dex */
public class PrepareExportTask extends BoxItemTask {
    public static final String DESTINATION_FOLDER_PATH = "mDestinationFolderPath";
    public static final String SHOULD_OVERWRITE = "mShouldOverwrite";
    public static final String TYPE = "prepareExportTask";
    private BoxExtendedApiFolder mBoxExtendedApiFolder;
    private IMoCoBoxTransfers mMoCoBoxTransfers;

    public PrepareExportTask() {
    }

    public PrepareExportTask(MoCoContainerBuilder.MoCoContainer moCoContainer, BoxJob boxJob, BoxFolder boxFolder, BoxExtendedApiFolder boxExtendedApiFolder, IMoCoBoxTransfers iMoCoBoxTransfers, String str, boolean z) {
        super(TYPE, JobManager.generateId(), boxFolder, moCoContainer, boxJob);
        this.mBoxExtendedApiFolder = boxExtendedApiFolder;
        this.mMoCoBoxTransfers = iMoCoBoxTransfers;
        setDestinationFolderPath(str);
        setShouldOverwrite(z);
        saveToLevelDB();
    }

    @Override // com.box.android.coreservices.jobmanager.tasks.BoxTask
    protected BoxFutureTask<BoxMessage<?>> createTask() {
        final ArrayList arrayList = new ArrayList();
        return new BoxFutureTask<BoxMessage<?>>(new Callable<BoxMessage<?>>() { // from class: com.box.android.coreservices.jobmanager.tasks.PrepareExportTask.1
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
                BoxResponse boxResponse;
                PrepareExportTask.this.mProgress = 0L;
                PrepareExportTask prepareExportTask = PrepareExportTask.this;
                prepareExportTask.reportProgressUpdated(prepareExportTask, ProgressReporter.ProgressType.NUM_TASKS, 1L, 0L);
                BoxMessage<?> boxMessage = new BoxMessage<>();
                boxMessage.setSuccess(false);
                LinkedList<BoxFile> linkedList = new LinkedList();
                arrayList.add(PrepareExportTask.this.mMoCoContainer.getBaseModelController().performRemote(PrepareExportTask.this.mBoxExtendedApiFolder.getFullFolderRequest(PrepareExportTask.this.getItemId())));
                try {
                    boxResponse = (BoxResponse) ((BoxAppFutureTask) arrayList.get(0)).get();
                } catch (Exception e) {
                    BoxLogUtils.logException(e);
                    boxResponse = null;
                }
                if (boxResponse != null && boxResponse.getException() != null) {
                    boxMessage.setException(boxResponse.getException());
                }
                if (boxResponse != null && boxResponse.isSuccess() && boxMessage.getException() == null) {
                    BoxFullFolder boxFullFolder = (BoxFullFolder) boxResponse.getResult();
                    File file = new File(PrepareExportTask.this.getFileSystemPath(boxFullFolder));
                    if (!file.exists() && !file.mkdirs()) {
                        PrepareExportTask.this.mMoCoBoxTransfers.getContentProviderDocumentFile(file, true);
                    }
                    for (BoxItem boxItem : boxFullFolder.getChildren()) {
                        if (boxItem instanceof BoxFile) {
                            linkedList.add((BoxFile) boxItem);
                        } else if (boxItem instanceof BoxFolder) {
                            File file2 = new File(PrepareExportTask.this.getFileSystemPath(boxItem));
                            if (!file2.exists() && !file2.mkdirs()) {
                                PrepareExportTask.this.mMoCoBoxTransfers.getContentProviderDocumentFile(file2, true);
                            }
                        }
                    }
                    ArrayList arrayList2 = new ArrayList(linkedList.size());
                    for (BoxFile boxFile : linkedList) {
                        ((ExportBoxJob) PrepareExportTask.this.mParentJob).addApplicableTasks(boxFile, arrayList2, new File(PrepareExportTask.this.getFileSystemPath(boxFile)), PrepareExportTask.this.getShouldOverwrite(), PrepareExportTask.this.getSharedLink(), PrepareExportTask.this.getSharedLinkPassword());
                    }
                    PrepareExportTask.this.mParentJob.addTasks(arrayList2, true, true);
                    PrepareExportTask prepareExportTask2 = PrepareExportTask.this;
                    prepareExportTask2.reportCompleted(prepareExportTask2);
                    return boxMessage;
                }
                PrepareExportTask prepareExportTask3 = PrepareExportTask.this;
                prepareExportTask3.reportError(prepareExportTask3, boxMessage.getException());
                return boxMessage;
            }
        }, IBaseModelController.INSTANCE.getNextRequestId()) { // from class: com.box.android.coreservices.jobmanager.tasks.PrepareExportTask.2
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

    /* JADX INFO: Access modifiers changed from: private */
    public String getFileSystemPath(BoxItem boxItem) {
        List<NameIdPair> arrayList;
        StringBuilder sb = new StringBuilder(getDestinationFolderPath());
        try {
            arrayList = CoreServiceUtils.getLineage(this.mMoCoContainer.getUserContextManager(), boxItem.getUserId(), boxItem.getType());
        } catch (SQLException unused) {
            arrayList = new ArrayList();
        }
        arrayList.add(0, new NameIdPair(boxItem.getName(), boxItem.getUserId()));
        for (NameIdPair nameIdPair : arrayList) {
            sb.insert(getDestinationFolderPath().length(), nameIdPair.getName());
            sb.insert(getDestinationFolderPath().length(), File.separator);
            if (nameIdPair.getId().equals(getItemId())) {
                break;
            }
        }
        return sb.toString();
    }

    @Override // com.box.android.coreservices.jobmanager.tasks.BoxItemTask
    public void setSharedLinkPassword(String str) {
        this.mProperties.put(BoxItemTask.SHARED_LINK_PASSWORD, str);
    }

    @Override // com.box.android.coreservices.jobmanager.tasks.BoxItemTask
    public void setSharedLink(String str) {
        this.mProperties.put(BoxItemTask.SHARED_LINK, str);
    }

    @Override // com.box.android.coreservices.jobmanager.tasks.BoxItemTask
    public String getSharedLink() {
        return (String) this.mProperties.get(BoxItemTask.SHARED_LINK);
    }

    @Override // com.box.android.coreservices.jobmanager.tasks.BoxItemTask
    public String getSharedLinkPassword() {
        return (String) this.mProperties.get(BoxItemTask.SHARED_LINK_PASSWORD);
    }

    public String getDestinationFolderPath() {
        return (String) this.mProperties.get("mDestinationFolderPath");
    }

    public void setDestinationFolderPath(String str) {
        this.mProperties.put("mDestinationFolderPath", str);
    }

    public boolean getShouldOverwrite() {
        return ((Boolean) this.mProperties.get(SHOULD_OVERWRITE)).booleanValue();
    }

    public void setShouldOverwrite(boolean z) {
        this.mProperties.put(SHOULD_OVERWRITE, Boolean.valueOf(z));
    }

    @Override // com.box.android.coreservices.jobmanager.tasks.BoxItemTask, com.box.android.coreservices.jobmanager.tasks.BoxTask, com.box.android.coreservices.jobmanager.JobItem, com.box.android.coreservices.jobmanager.JobItemJsonEntity, com.box.android.coreservices.models.BoxPersistableObject
    protected void parseJSONMember(JsonObject.Member member) {
        String name = member.getName();
        JsonValue value = member.getValue();
        if (name.equals("mDestinationFolderPath")) {
            setDestinationFolderPath(value.asString());
        } else if (name.equals(SHOULD_OVERWRITE)) {
            setShouldOverwrite(value.asBoolean());
        } else {
            super.parseJSONMember(member);
        }
    }
}
