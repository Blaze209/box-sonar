package com.box.android.coreservices.jobmanager.tasks;

import com.box.android.coreservices.jobmanager.JobItem;
import com.box.android.coreservices.jobmanager.JobManager;
import com.box.android.coreservices.jobmanager.jobs.BoxJob;
import com.box.android.coreservices.modelcontroller.MoCoContainerBuilder;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxError;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;

/* JADX INFO: loaded from: classes9.dex */
public abstract class DestinationFolderTask extends BoxItemTask {
    public static final String DESTINATION_FOLDER_ID = "mDestinationFolderId";

    @Override // com.box.android.coreservices.jobmanager.tasks.BoxItemTask, com.box.android.coreservices.jobmanager.tasks.BoxTask
    protected void handleCancelProgress() {
    }

    protected DestinationFolderTask() {
    }

    protected DestinationFolderTask(String str, MoCoContainerBuilder.MoCoContainer moCoContainer, BoxJob boxJob, BoxItem boxItem, BoxFolder boxFolder) {
        super(str, JobManager.generateId(), boxItem, moCoContainer, boxJob);
        setDestinationFolderId(boxFolder.getUserId());
        saveToLevelDB();
    }

    @Override // com.box.android.coreservices.jobmanager.tasks.BoxTask
    protected void setErrorStateFromError(Exception exc) {
        BoxError asBoxError;
        if ((exc instanceof BoxException) && (asBoxError = ((BoxException) exc).getAsBoxError()) != null) {
            int iIntValue = asBoxError.getStatus().intValue();
            if (iIntValue == 400) {
                setErrorType(JobItem.ErrorType.GENERIC_EXCEPTION);
                return;
            } else if (iIntValue == 404) {
                setErrorType(JobItem.ErrorType.SOURCE_OR_DESTINATION_NOT_FOUND);
                return;
            }
        }
        super.setErrorStateFromError(exc);
    }

    public String getDestinationFolderId() {
        return (String) this.mProperties.get(DESTINATION_FOLDER_ID);
    }

    public void setDestinationFolderId(String str) {
        this.mProperties.put(DESTINATION_FOLDER_ID, str);
    }

    @Override // com.box.android.coreservices.jobmanager.tasks.BoxItemTask, com.box.android.coreservices.jobmanager.tasks.BoxTask, com.box.android.coreservices.jobmanager.JobItem, com.box.android.coreservices.jobmanager.JobItemJsonEntity, com.box.android.coreservices.models.BoxPersistableObject
    protected void parseJSONMember(JsonObject.Member member) {
        String name = member.getName();
        JsonValue value = member.getValue();
        if (name.equals(DESTINATION_FOLDER_ID)) {
            setDestinationFolderId(value.asString());
        } else {
            super.parseJSONMember(member);
        }
    }
}
