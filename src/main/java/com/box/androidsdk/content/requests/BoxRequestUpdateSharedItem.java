package com.box.androidsdk.content.requests;

import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxSharedLink;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.utils.BoxDateFormat;
import com.box.androidsdk.content.utils.SdkUtils;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import java.text.ParseException;
import java.util.Date;

/* JADX INFO: loaded from: classes13.dex */
public abstract class BoxRequestUpdateSharedItem<E extends BoxItem, R extends BoxRequest<E, R>> extends BoxRequestItemUpdate<E, R> {
    @Override // com.box.androidsdk.content.requests.BoxRequestItemUpdate
    public BoxRequestUpdateSharedItem updateSharedLink() {
        return this;
    }

    protected BoxRequestUpdateSharedItem(Class<E> cls, String str, String str2, BoxSession boxSession) {
        super(cls, str, str2, boxSession);
        this.mRequestMethod = BoxRequest.Methods.PUT;
    }

    protected BoxRequestUpdateSharedItem(BoxRequestItemUpdate boxRequestItemUpdate) {
        super(boxRequestItemUpdate);
    }

    public BoxSharedLink.Access getAccess() {
        if (this.mBodyMap.containsKey("shared_link")) {
            return ((BoxSharedLink) this.mBodyMap.get("shared_link")).getAccess();
        }
        return null;
    }

    public R setAccess(BoxSharedLink.Access access) {
        JsonObject sharedLinkJsonObject = getSharedLinkJsonObject();
        sharedLinkJsonObject.add("access", SdkUtils.getAsStringSafely(access));
        this.mBodyMap.put("shared_link", new BoxSharedLink(sharedLinkJsonObject));
        return this;
    }

    public Date getUnsharedAt() {
        if (this.mBodyMap.containsKey("shared_link")) {
            return ((BoxSharedLink) this.mBodyMap.get("shared_link")).getUnsharedDate();
        }
        return null;
    }

    public R setUnsharedAt(Date date) throws ParseException {
        JsonObject sharedLinkJsonObject = getSharedLinkJsonObject();
        if (date == null) {
            sharedLinkJsonObject.add(BoxSharedLink.FIELD_UNSHARED_AT, JsonValue.NULL);
        } else {
            sharedLinkJsonObject.add(BoxSharedLink.FIELD_UNSHARED_AT, BoxDateFormat.format(date));
        }
        this.mBodyMap.put("shared_link", new BoxSharedLink(sharedLinkJsonObject));
        return this;
    }

    public R setRemoveUnsharedAtDate() throws ParseException {
        return (R) setUnsharedAt(null);
    }

    public String getPassword() {
        if (this.mBodyMap.containsKey("shared_link")) {
            return ((BoxSharedLink) this.mBodyMap.get("shared_link")).getPassword();
        }
        return null;
    }

    public R setPassword(String str) {
        JsonObject sharedLinkJsonObject = getSharedLinkJsonObject();
        sharedLinkJsonObject.add("password", str);
        this.mBodyMap.put("shared_link", new BoxSharedLink(sharedLinkJsonObject));
        return this;
    }

    protected Boolean getCanDownload() {
        if (this.mBodyMap.containsKey("shared_link")) {
            return ((BoxSharedLink) this.mBodyMap.get("shared_link")).getPermissions().getCanDownload();
        }
        return null;
    }

    protected R setPermission(BoxSharedLink.Permission permission) {
        JsonObject permissionsJsonObject = getPermissionsJsonObject();
        if (permission == BoxSharedLink.Permission.CAN_EDIT) {
            permissionsJsonObject.add(BoxSharedLink.Permissions.FIELD_CAN_EDIT, true);
            permissionsJsonObject.add(BoxSharedLink.Permissions.FIELD_CAN_DOWNLOAD, true);
        } else {
            permissionsJsonObject.add(BoxSharedLink.Permissions.FIELD_CAN_EDIT, false);
            permissionsJsonObject.add(BoxSharedLink.Permissions.FIELD_CAN_DOWNLOAD, permission == BoxSharedLink.Permission.CAN_DOWNLOAD);
        }
        BoxSharedLink.Permissions permissions = new BoxSharedLink.Permissions(permissionsJsonObject);
        JsonObject sharedLinkJsonObject = getSharedLinkJsonObject();
        sharedLinkJsonObject.add("permissions", permissions.toJsonObject());
        this.mBodyMap.put("shared_link", new BoxSharedLink(sharedLinkJsonObject));
        return this;
    }

    private JsonObject getSharedLinkJsonObject() {
        if (this.mBodyMap.containsKey("shared_link")) {
            return ((BoxSharedLink) this.mBodyMap.get("shared_link")).toJsonObject();
        }
        return new JsonObject();
    }

    private JsonObject getPermissionsJsonObject() {
        if (this.mBodyMap.containsKey("permissions")) {
            return ((BoxSharedLink.Permissions) this.mBodyMap.get("permissions")).toJsonObject();
        }
        return new JsonObject();
    }
}
