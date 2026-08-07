package com.box.boxandroidlibv2private.model;

import android.text.TextUtils;
import com.box.androidsdk.content.models.BoxEntity;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxJsonObject;
import com.eclipsesource.json.JsonObject;
import java.util.Date;
import java.util.EnumSet;
import java.util.Locale;

/* JADX INFO: loaded from: classes13.dex */
public class BoxTask extends BoxItem {
    public static final String COMPLETION_RULE_ALL_ASSIGNEES = "ALL_ASSIGNEES";
    public static final String COMPLETION_RULE_ANY_ASSIGNEE = "ANY_ASSIGNEE";
    public static final String FIELD_ASSIGNMENT_COLLABORATORS = "assigned_to";
    public static final String FIELD_COMPLETED_AT = "completed_at";
    public static final String FIELD_COMPLETION_RULE = "completion_rule";
    public static final String FIELD_DESCRIPTION = "description";
    public static final String FIELD_DUE_AT = "due_at";
    public static final String FIELD_PROGRESS_AT = "progress_at";
    public static final String FIELD_REQUEST_CHANGE_COLLABORATOR_STATUS = "request_collaborator_status";
    public static final String FIELD_STATUS = "status";
    public static final String FIELD_TASK_LINKS = "task_links";
    public static final String FIELD_TASK_TYPE = "task_type";
    public static final String REQUEST_STATUS_COMPLETE = "COMPLETE";
    public static final String REQUEST_STATUS_ERROR = "ERROR";
    public static final String REQUEST_STATUS_IN_PROGRESS = "IN_PROGRESS";
    public static final String STATUS_APPROVED = "APPROVED";
    public static final String STATUS_COMPLETED = "COMPLETED";
    public static final String STATUS_IN_PROGRESS = "IN_PROGRESS";
    public static final String STATUS_NOT_STARTED = "NOT_STARTED";
    public static final String STATUS_REJECTED = "REJECTED";
    public static final String TASK_TYPE_APPROVAL = "APPROVAL";
    public static final String TASK_TYPE_GENERAL = "GENERAL";
    public static final String TYPE = "task";
    protected transient EnumSet<TaskPermission> mTaskPermissions;

    static {
        addEntityType("task", new BoxTask$$ExternalSyntheticLambda0());
    }

    public BoxTask() {
        this.mTaskPermissions = null;
    }

    public BoxTask(JsonObject jsonObject) {
        super(jsonObject);
        this.mTaskPermissions = null;
    }

    public boolean isTaskComplete() {
        String status = getStatus();
        return status.equals("APPROVED") || status.equals("COMPLETED") || status.equals("REJECTED");
    }

    public String getStatus() {
        return getPropertyAsString("status");
    }

    public Date getDueAt() {
        return getPropertyAsDate(FIELD_DUE_AT);
    }

    public String getTaskType() {
        return getPropertyAsString(FIELD_TASK_TYPE);
    }

    public Date getProgressAt() {
        return getPropertyAsDate(FIELD_PROGRESS_AT);
    }

    public String getCompletionRule() {
        return getPropertyAsString(FIELD_COMPLETION_RULE);
    }

    @Override // com.box.androidsdk.content.models.BoxItem
    public String getDescription() {
        return getPropertyAsString("description");
    }

    public Date getCompletedAt() {
        return getPropertyAsDate(FIELD_COMPLETED_AT);
    }

    public BoxIteratorTaskCollaborators getAssignmentCollaborators() {
        return (BoxIteratorTaskCollaborators) getPropertyAsJsonObject(BoxJsonObject.getBoxJsonObjectCreator(BoxIteratorTaskCollaborators.class), FIELD_ASSIGNMENT_COLLABORATORS);
    }

    public BoxIteratorTaskLinks getTaskLinks() {
        return (BoxIteratorTaskLinks) getPropertyAsJsonObject(BoxJsonObject.getBoxJsonObjectCreator(BoxIteratorTaskLinks.class), FIELD_TASK_LINKS);
    }

    public BoxTaskCollaborator getCreatedByCollaborator() {
        return (BoxTaskCollaborator) getPropertyAsJsonObject(BoxEntity.getBoxJsonObjectCreator(BoxTaskCollaborator.class), "created_by");
    }

    @Override // com.box.androidsdk.content.models.BoxItem
    public EnumSet getPermissions() {
        if (this.mTaskPermissions == null) {
            parsePermissions();
        }
        return this.mTaskPermissions;
    }

    @Override // com.box.androidsdk.content.models.BoxItem
    protected EnumSet parsePermissions() {
        BoxTaskPermission boxTaskPermission = (BoxTaskPermission) getPropertyAsJsonObject(BoxEntity.getBoxJsonObjectCreator(BoxTaskPermission.class), "permissions");
        if (boxTaskPermission == null) {
            return null;
        }
        EnumSet<TaskPermission> permissions = boxTaskPermission.getPermissions();
        this.mTaskPermissions = permissions;
        return permissions;
    }

    public enum TaskPermission {
        CAN_UPDATE("can_update"),
        CAN_DELETE("can_delete"),
        CAN_CREATE_TASK_COLLABORATOR("can_create_task_collaborator"),
        CAN_CREATE_TASK_LINK("can_create_task_link");

        private final String value;

        TaskPermission(String str) {
            this.value = str;
        }

        public static TaskPermission fromString(String str) {
            if (!TextUtils.isEmpty(str)) {
                for (TaskPermission taskPermission : values()) {
                    if (str.equalsIgnoreCase(taskPermission.name())) {
                        return taskPermission;
                    }
                }
            }
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "No enum with text %s found", str));
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.value;
        }
    }

    protected static class BoxTaskPermission extends BoxJsonObject {
        public BoxTaskPermission() {
        }

        public BoxTaskPermission(JsonObject jsonObject) {
            super(jsonObject);
        }

        EnumSet<TaskPermission> getPermissions() {
            EnumSet<TaskPermission> enumSetNoneOf = EnumSet.noneOf(TaskPermission.class);
            for (String str : getPropertiesKeySet()) {
                Boolean propertyAsBoolean = getPropertyAsBoolean(str);
                if (propertyAsBoolean != null && propertyAsBoolean.booleanValue()) {
                    if (str.equals(TaskPermission.CAN_UPDATE.toString())) {
                        enumSetNoneOf.add(TaskPermission.CAN_UPDATE);
                    } else if (str.equals(TaskPermission.CAN_DELETE.toString())) {
                        enumSetNoneOf.add(TaskPermission.CAN_DELETE);
                    } else if (str.equals(TaskPermission.CAN_CREATE_TASK_COLLABORATOR.toString())) {
                        enumSetNoneOf.add(TaskPermission.CAN_CREATE_TASK_COLLABORATOR);
                    } else if (str.equals(TaskPermission.CAN_CREATE_TASK_LINK.toString())) {
                        enumSetNoneOf.add(TaskPermission.CAN_CREATE_TASK_LINK);
                    }
                }
            }
            return enumSetNoneOf;
        }
    }

    public static BoxTask createFromId(String str) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("id", str);
        jsonObject.add("type", "task");
        return new BoxTask(jsonObject);
    }
}
