package com.box.android.domain.localrepo.sqlitetables;

import com.box.boxandroidlibv2private.model.BoxTaskCollaborator;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/* JADX INFO: loaded from: classes11.dex */
@DatabaseTable(tableName = "BoxTaskCollaborators")
public class BoxTaskCollaboratorsSQLData extends BoxTypedObjectSQLData {
    public static final String LIST_POSITION = "list_position";
    public static final String TASK_COLLABORATOR_STATUS = "task_collaborator_status";
    public static final String TASK_ID = "task_id";

    @DatabaseField(canBeNull = false, columnName = LIST_POSITION, index = true)
    private Integer listPosition;

    @DatabaseField(canBeNull = false, columnName = TASK_COLLABORATOR_STATUS, index = true)
    private String taskCollaboratorStatus;

    @DatabaseField(canBeNull = false, columnName = "task_id", index = true)
    private String taskId;

    public BoxTaskCollaboratorsSQLData() {
    }

    public BoxTaskCollaboratorsSQLData(String str, BoxTaskCollaborator boxTaskCollaborator, Integer num) {
        super(boxTaskCollaborator);
        this.taskId = str;
        this.taskCollaboratorStatus = boxTaskCollaborator.getStatus();
        this.listPosition = num;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public String getTaskCollaboratorId() {
        return getId();
    }

    public Integer getListPosition() {
        return this.listPosition;
    }

    public String getTaskCollaboratorStatus() {
        return this.taskCollaboratorStatus;
    }
}
