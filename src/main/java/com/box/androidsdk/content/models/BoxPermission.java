package com.box.androidsdk.content.models;

import com.eclipsesource.json.JsonObject;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes13.dex */
public class BoxPermission extends BoxJsonObject {
    public BoxPermission() {
    }

    public BoxPermission(JsonObject jsonObject) {
        super(jsonObject);
    }

    EnumSet<BoxItem.Permission> getPermissions() {
        EnumSet<BoxItem.Permission> enumSetNoneOf = EnumSet.noneOf(BoxItem.Permission.class);
        for (String str : getPropertiesKeySet()) {
            Boolean propertyAsBoolean = getPropertyAsBoolean(str);
            if (propertyAsBoolean != null && propertyAsBoolean.booleanValue()) {
                if (str.equals(BoxItem.Permission.CAN_DOWNLOAD.toString())) {
                    enumSetNoneOf.add(BoxItem.Permission.CAN_DOWNLOAD);
                } else if (str.equals(BoxItem.Permission.CAN_UPLOAD.toString())) {
                    enumSetNoneOf.add(BoxItem.Permission.CAN_UPLOAD);
                } else if (str.equals(BoxItem.Permission.CAN_RENAME.toString())) {
                    enumSetNoneOf.add(BoxItem.Permission.CAN_RENAME);
                } else if (str.equals(BoxItem.Permission.CAN_DELETE.toString())) {
                    enumSetNoneOf.add(BoxItem.Permission.CAN_DELETE);
                } else if (str.equals(BoxItem.Permission.CAN_SHARE.toString())) {
                    enumSetNoneOf.add(BoxItem.Permission.CAN_SHARE);
                } else if (str.equals(BoxItem.Permission.CAN_SET_SHARE_ACCESS.toString())) {
                    enumSetNoneOf.add(BoxItem.Permission.CAN_SET_SHARE_ACCESS);
                } else if (str.equals(BoxItem.Permission.CAN_PREVIEW.toString())) {
                    enumSetNoneOf.add(BoxItem.Permission.CAN_PREVIEW);
                } else if (str.equals(BoxItem.Permission.CAN_COMMENT.toString())) {
                    enumSetNoneOf.add(BoxItem.Permission.CAN_COMMENT);
                } else if (str.equals(BoxItem.Permission.CAN_INVITE_COLLABORATOR.toString())) {
                    enumSetNoneOf.add(BoxItem.Permission.CAN_INVITE_COLLABORATOR);
                } else if (str.equals(BoxItem.Permission.CAN_CREATE_ANNOTATIONS.toString())) {
                    enumSetNoneOf.add(BoxItem.Permission.CAN_CREATE_ANNOTATIONS);
                } else if (str.equals(BoxItem.Permission.CAN_VIEW_ANNOTATIONS.toString())) {
                    enumSetNoneOf.add(BoxItem.Permission.CAN_VIEW_ANNOTATIONS);
                }
            }
        }
        return enumSetNoneOf;
    }
}
