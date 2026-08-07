package com.box.boxandroidlibv2private.model;

import android.text.TextUtils;
import com.box.androidsdk.content.models.BoxEntity;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxJsonObject;
import com.eclipsesource.json.JsonObject;
import java.util.EnumSet;
import java.util.Locale;

/* JADX INFO: loaded from: classes13.dex */
public class BoxTaskLink extends BoxEntity {
    private static final String DELETE_FIELD = "can_delete";
    public static final String FIELD_DESCRIPTION = "description";
    public static final String FIELD_PERMISSIONS = "permissions";
    public static final String FIELD_TARGET = "target";
    public static final String FIELD_TASK = "task";
    public static final String TYPE = "task_link";
    private static final String UPDATE_FIELD = "can_update";
    protected transient EnumSet<TaskPermission> mPermissions;

    public BoxTaskLink() {
        this.mPermissions = null;
    }

    public BoxTaskLink(JsonObject jsonObject) {
        super(jsonObject);
        this.mPermissions = null;
    }

    public BoxTask getTask() {
        return (BoxTask) getPropertyAsJsonObject(BoxEntity.getBoxJsonObjectCreator(BoxTask.class), "task");
    }

    public BoxEntity getTarget() {
        return (BoxEntity) getPropertyAsJsonObject(BoxItem.getBoxJsonObjectCreator(), "target");
    }

    public String getDescription() {
        return getPropertyAsString("description");
    }

    public EnumSet getPermissions() {
        if (this.mPermissions == null) {
            parsePermissions();
        }
        return this.mPermissions;
    }

    protected EnumSet parsePermissions() {
        BoxTaskPermission boxTaskPermission = (BoxTaskPermission) getPropertyAsJsonObject(BoxEntity.getBoxJsonObjectCreator(BoxTaskPermission.class), "permissions");
        if (boxTaskPermission == null) {
            return null;
        }
        EnumSet<TaskPermission> permissions = boxTaskPermission.getPermissions();
        this.mPermissions = permissions;
        return permissions;
    }

    public enum TaskPermission {
        CAN_UPDATE("task_link.update"),
        CAN_DELETE("task_link.delete");

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
                    if (str.equals(BoxTaskLink.UPDATE_FIELD)) {
                        enumSetNoneOf.add(TaskPermission.CAN_UPDATE);
                    } else if (str.equals(BoxTaskLink.DELETE_FIELD)) {
                        enumSetNoneOf.add(TaskPermission.CAN_DELETE);
                    }
                }
            }
            return enumSetNoneOf;
        }
    }
}
