package com.box.androidsdk.content.models;

import android.text.TextUtils;
import com.eclipsesource.json.JsonObject;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes13.dex */
public class BoxCollaboration extends BoxEntity {
    public static final String FIELD_ACCESSIBLE_BY = "accessible_by";
    public static final String FIELD_CREATED_AT = "created_at";
    public static final String FIELD_ITEM = "item";
    public static final String FIELD_MODIFIED_AT = "modified_at";
    public static final String FIELD_ROLE = "role";
    public static final String FIELD_STATUS = "status";
    public static final String TYPE = "collaboration";
    private static final long serialVersionUID = 8125965031679671555L;
    public static final String FIELD_EXPIRES_AT = "expires_at";
    public static final String FIELD_ACKNOWLEDGED_AT = "acknowledged_at";
    public static final String FIELD_INVITE_EMAIL = "invite_email";
    public static final String[] ALL_FIELDS = {"type", "id", "created_at", "modified_at", FIELD_EXPIRES_AT, "status", "accessible_by", "role", FIELD_ACKNOWLEDGED_AT, "item", FIELD_INVITE_EMAIL};

    public BoxCollaboration() {
    }

    public BoxCollaboration(JsonObject jsonObject) {
        super(jsonObject);
    }

    public Date getCreatedAt() {
        return getPropertyAsDate("created_at");
    }

    public Date getModifiedAt() {
        return getPropertyAsDate("modified_at");
    }

    public Date getExpiresAt() {
        return getPropertyAsDate(FIELD_EXPIRES_AT);
    }

    public Status getStatus() {
        return Status.fromString(getPropertyAsString("status"));
    }

    public BoxCollaborator getAccessibleBy() {
        return (BoxCollaborator) getPropertyAsJsonObject(BoxEntity.getBoxJsonObjectCreator(), "accessible_by");
    }

    public String getInviteEmail() {
        return getPropertyAsString(FIELD_INVITE_EMAIL);
    }

    public Role getRole() {
        return Role.fromString(getPropertyAsString("role"));
    }

    public Date getAcknowledgedAt() {
        return getPropertyAsDate(FIELD_ACKNOWLEDGED_AT);
    }

    public BoxCollaborationItem getItem() {
        return (BoxCollaborationItem) getPropertyAsJsonObject(BoxEntity.getBoxJsonObjectCreator(), "item");
    }

    public enum Status {
        ACCEPTED("accepted"),
        PENDING("pending"),
        REJECTED("rejected");

        private final String mValue;

        Status(String str) {
            this.mValue = str;
        }

        public static Status fromString(String str) {
            if (!TextUtils.isEmpty(str)) {
                for (Status status : values()) {
                    if (str.equalsIgnoreCase(status.toString())) {
                        return status;
                    }
                }
            }
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "No enum with text %s found", str));
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.mValue;
        }
    }

    public enum Role {
        OWNER("owner"),
        CO_OWNER("co-owner"),
        EDITOR("editor"),
        VIEWER_UPLOADER("viewer uploader"),
        PREVIEWER_UPLOADER("previewer uploader"),
        VIEWER("viewer"),
        PREVIEWER("previewer"),
        UPLOADER("uploader");

        private final String mValue;

        Role(String str) {
            this.mValue = str;
        }

        public static Role fromString(String str) {
            if (!TextUtils.isEmpty(str)) {
                for (Role role : values()) {
                    if (str.equalsIgnoreCase(role.toString())) {
                        return role;
                    }
                }
            }
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "No enum with text %s found", str));
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.mValue;
        }
    }
}
