package com.box.android.coreservices.jobmanager.tasks;

import com.box.android.coreservices.jobmanager.JobManager;
import com.box.android.coreservices.jobmanager.jobs.BoxJob;
import com.box.android.coreservices.modelcontroller.BoxFutureTask;
import com.box.android.coreservices.modelcontroller.IMoCoBoxTransfers;
import com.box.android.coreservices.modelcontroller.MoCoContainerBuilder;
import com.box.android.coreservices.modelcontroller.messages.BoxFileTransferMessage;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.utils.SdkUtils;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import java.io.File;

/* JADX INFO: loaded from: classes9.dex */
public class ExportTask extends BoxFileTransferTask implements IMoCoBoxTransfers.FileDestinationListener {
    public static final String DESTINATION_FILE_PATH = "mDestinationFilePath";
    public static final String FINAL_PATH = "mFinalPath";
    public static final String OVERWRITE_FILE = "mOverwriteFile";
    public static final String TYPE = "exportTask";

    public ExportTask() {
    }

    public ExportTask(MoCoContainerBuilder.MoCoContainer moCoContainer, BoxJob boxJob, BoxFile boxFile, File file, boolean z) {
        super(TYPE, JobManager.generateId(), boxFile, moCoContainer, boxJob);
        setDestinationFilePath(file.getAbsolutePath());
        setOverwriteFile(z);
        setFinalPath(null);
        saveToLevelDB();
    }

    @Override // com.box.android.coreservices.jobmanager.tasks.BoxTask
    protected BoxFutureTask<? extends BoxFileTransferMessage> createTask() {
        if (SdkUtils.isBlank(getSharedLink())) {
            return this.mMoCoContainer.getMocoTransfers().exportFile(getItemId(), new File(getDestinationFilePath()), getOverwriteFile(), false, getFileTransferProgressListener(), this);
        }
        return this.mMoCoContainer.getMocoTransfers().exportFile(getItemId(), new File(getDestinationFilePath()), getOverwriteFile(), false, getFileTransferProgressListener(), this, new BoxExtendedApiFile(createSharedLinkSession()));
    }

    @Override // com.box.android.coreservices.modelcontroller.IMoCoBoxTransfers.FileDestinationListener
    public void onFileKnown(File file) {
        setFinalPath(file.getAbsolutePath());
    }

    public String getFinalFilePath() {
        return getFinalPath();
    }

    public String getDestinationFilePath() {
        return (String) this.mProperties.get(DESTINATION_FILE_PATH);
    }

    public void setDestinationFilePath(String str) {
        this.mProperties.put(DESTINATION_FILE_PATH, str);
    }

    public boolean getOverwriteFile() {
        return ((Boolean) this.mProperties.get(OVERWRITE_FILE)).booleanValue();
    }

    public void setOverwriteFile(boolean z) {
        this.mProperties.put(OVERWRITE_FILE, Boolean.valueOf(z));
    }

    public String getFinalPath() {
        return (String) this.mProperties.get(FINAL_PATH);
    }

    public void setFinalPath(String str) {
        this.mProperties.put(FINAL_PATH, str);
    }

    @Override // com.box.android.coreservices.jobmanager.tasks.BoxItemTask, com.box.android.coreservices.jobmanager.tasks.BoxTask, com.box.android.coreservices.jobmanager.JobItem, com.box.android.coreservices.jobmanager.JobItemJsonEntity, com.box.android.coreservices.models.BoxPersistableObject
    protected void parseJSONMember(JsonObject.Member member) {
        String name = member.getName();
        JsonValue value = member.getValue();
        if (name.equals(DESTINATION_FILE_PATH)) {
            setDestinationFilePath(value.asString());
            return;
        }
        if (name.equals(OVERWRITE_FILE)) {
            setOverwriteFile(value.asBoolean());
        } else if (name.equals(FINAL_PATH)) {
            setFinalPath(value.asString());
        } else {
            super.parseJSONMember(member);
        }
    }
}
