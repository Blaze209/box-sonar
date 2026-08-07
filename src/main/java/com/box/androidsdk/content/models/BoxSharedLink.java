package com.box.androidsdk.content.models;

import com.eclipsesource.json.JsonObject;
import java.util.Date;
import java.util.EnumSet;
import java.util.Locale;

/* JADX INFO: loaded from: classes13.dex */
@Deprecated
public class BoxSharedLink extends BoxJsonObject {
    public static final String FIELD_ACCESS = "access";
    public static final String FIELD_DOWNLOAD_COUNT = "download_count";
    public static final String FIELD_DOWNLOAD_URL = "download_url";
    public static final String FIELD_EFFECTIVE_ACCESS = "effective_access";
    public static final String FIELD_EFFECTIVE_PERMISSION = "effective_permission";
    public static final String FIELD_IS_PASSWORD_ENABLED = "is_password_enabled";
    public static final String FIELD_PASSWORD = "password";
    public static final String FIELD_PERMISSIONS = "permissions";
    public static final String FIELD_PREVIEW_COUNT = "preview_count";
    public static final String FIELD_UNSHARED_AT = "unshared_at";
    public static final String FIELD_URL = "url";
    public static final String FIELD_VANITY_URL = "vanity_url";
    private static final long serialVersionUID = -4595593930118314932L;

    public BoxSharedLink() {
    }

    public BoxSharedLink(JsonObject jsonObject) {
        super(jsonObject);
    }

    public String getURL() {
        return getPropertyAsString("url");
    }

    public String getDownloadURL() {
        return getPropertyAsString(FIELD_DOWNLOAD_URL);
    }

    public String getVanityURL() {
        return getPropertyAsString(FIELD_VANITY_URL);
    }

    public Boolean getIsPasswordEnabled() {
        return getPropertyAsBoolean(FIELD_IS_PASSWORD_ENABLED);
    }

    public Date getUnsharedDate() {
        return getPropertyAsDate(FIELD_UNSHARED_AT);
    }

    public Long getDownloadCount() {
        return getPropertyAsLong(FIELD_DOWNLOAD_COUNT);
    }

    public Long getPreviewCount() {
        return getPropertyAsLong(FIELD_PREVIEW_COUNT);
    }

    public Access getAccess() {
        return Access.fromString(getPropertyAsString("access"));
    }

    public String getPassword() {
        return getPropertyAsString("password");
    }

    public Access getEffectiveAccess() {
        return Access.fromString(getPropertyAsString(FIELD_EFFECTIVE_ACCESS));
    }

    public Permissions getPermissions() {
        return (Permissions) getPropertyAsJsonObject(BoxEntity.getBoxJsonObjectCreator(Permissions.class), "permissions");
    }

    public EffectivePermission getEffectivePermission() {
        return EffectivePermission.fromString(getPropertyAsString(FIELD_EFFECTIVE_PERMISSION));
    }

    public static class Permissions extends BoxJsonObject {
        public static final String FIELD_CAN_DOWNLOAD = "can_download";
        public static final String FIELD_CAN_EDIT = "can_edit";

        public Permissions() {
        }

        public Permissions(JsonObject jsonObject) {
            super(jsonObject);
        }

        public Boolean getCanDownload() {
            return getPropertyAsBoolean(FIELD_CAN_DOWNLOAD);
        }

        public Boolean getCanEdit() {
            return getPropertyAsBoolean(FIELD_CAN_EDIT);
        }

        EnumSet<Permission> getPermissions() {
            EnumSet<Permission> enumSetNoneOf = EnumSet.noneOf(Permission.class);
            for (String str : getPropertiesKeySet()) {
                Boolean propertyAsBoolean = getPropertyAsBoolean(str);
                if (propertyAsBoolean != null && propertyAsBoolean.booleanValue()) {
                    if (str.equals(Permission.CAN_DOWNLOAD.toString())) {
                        enumSetNoneOf.add(Permission.CAN_DOWNLOAD);
                    } else if (str.equals(Permission.CAN_EDIT.toString())) {
                        enumSetNoneOf.add(Permission.CAN_EDIT);
                    } else if (str.equals(Permission.CAN_PREVIEW.toString())) {
                        enumSetNoneOf.add(Permission.CAN_PREVIEW);
                    }
                }
            }
            return enumSetNoneOf;
        }
    }

    public enum Permission {
        CAN_PREVIEW("can_preview"),
        CAN_EDIT(Permissions.FIELD_CAN_EDIT),
        CAN_DOWNLOAD(Permissions.FIELD_CAN_DOWNLOAD);

        private final String value;

        Permission(String str) {
            this.value = str;
        }

        public static Permission fromString(String str) {
            if (str != null && !str.isEmpty()) {
                for (Permission permission : values()) {
                    if (str.equalsIgnoreCase(permission.name())) {
                        return permission;
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

    public enum EffectivePermission {
        CAN_EDIT(Permissions.FIELD_CAN_EDIT),
        CAN_PREVIEW("can_preview"),
        CAN_DOWNLOAD(Permissions.FIELD_CAN_DOWNLOAD),
        NO_ACCESS("no_access");

        private final String mValue;

        public boolean canEdit() {
            return this == CAN_EDIT;
        }

        public boolean canDownload() {
            return this == CAN_DOWNLOAD;
        }

        public boolean canPreview() {
            return this == CAN_PREVIEW;
        }

        public static EffectivePermission fromString(String str) {
            if (str != null && !str.isEmpty()) {
                for (EffectivePermission effectivePermission : values()) {
                    if (str.equalsIgnoreCase(effectivePermission.toString())) {
                        return effectivePermission;
                    }
                }
            }
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "No enum with text %s found", str));
        }

        EffectivePermission(String str) {
            this.mValue = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.mValue;
        }
    }

    public enum Access {
        DEFAULT(null),
        OPEN("open"),
        COMPANY("company"),
        COLLABORATORS("collaborators");

        private final String mValue;

        public static Access fromString(String str) {
            if (str != null && !str.isEmpty()) {
                for (Access access : values()) {
                    if (str.equalsIgnoreCase(access.toString())) {
                        return access;
                    }
                }
            }
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "No enum with text %s found", str));
        }

        Access(String str) {
            this.mValue = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.mValue;
        }
    }
}
