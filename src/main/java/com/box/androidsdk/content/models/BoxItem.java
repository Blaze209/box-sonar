package com.box.androidsdk.content.models;

import android.text.TextUtils;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes13.dex */
@Deprecated
public abstract class BoxItem extends BoxEntity {
    public static final String FIELD_ALLOWED_SHARED_LINK_ACCESS_LEVELS = "allowed_shared_link_access_levels";
    public static final String FIELD_CLASSIFICATION = "classification";
    public static final String FIELD_COLLECTIONS = "collections";
    public static final String FIELD_CREATED_AT = "created_at";
    public static final String FIELD_CREATED_BY = "created_by";
    public static final String FIELD_DESCRIPTION = "description";
    public static final String FIELD_ETAG = "etag";
    public static final String FIELD_ITEM_STATUS = "item_status";
    public static final String FIELD_MODIFIED_AT = "modified_at";
    public static final String FIELD_MODIFIED_BY = "modified_by";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_OWNED_BY = "owned_by";
    public static final String FIELD_PARENT = "parent";
    public static final String FIELD_PATH_COLLECTION = "path_collection";
    public static final String FIELD_PERMISSIONS = "permissions";
    public static final String FIELD_SHARED_LINK = "shared_link";
    public static final String FIELD_TAGS = "tags";
    private static final long serialVersionUID = 4876182952337609430L;
    protected transient EnumSet<Permission> mPermissions;

    protected BoxItem() {
        this.mPermissions = null;
    }

    protected BoxItem(JsonObject jsonObject) {
        super(jsonObject);
        this.mPermissions = null;
    }

    public String getEtag() {
        return getPropertyAsString(FIELD_ETAG);
    }

    public String getName() {
        return getPropertyAsString("name");
    }

    public Date getCreatedAt() {
        return getPropertyAsDate("created_at");
    }

    public Date getModifiedAt() {
        return getPropertyAsDate("modified_at");
    }

    public Long getSize() {
        return getPropertyAsLong("size");
    }

    public BoxIterator<BoxFolder> getPathCollection() {
        return (BoxIterator) getPropertyAsJsonObject(BoxJsonObject.getBoxJsonObjectCreator(BoxIteratorBoxEntity.class), FIELD_PATH_COLLECTION);
    }

    public BoxUser getModifiedBy() {
        return (BoxUser) getPropertyAsJsonObject(BoxEntity.getBoxJsonObjectCreator(BoxUser.class), "modified_by");
    }

    protected Date getContentCreatedAt() {
        return getPropertyAsDate("content_created_at");
    }

    protected Date getContentModifiedAt() {
        return getPropertyAsDate("content_modified_at");
    }

    public BoxUser getOwnedBy() {
        return (BoxUser) getPropertyAsJsonObject(BoxEntity.getBoxJsonObjectCreator(BoxUser.class), FIELD_OWNED_BY);
    }

    public BoxSharedLink getSharedLink() {
        return (BoxSharedLink) getPropertyAsJsonObject(BoxEntity.getBoxJsonObjectCreator(BoxSharedLink.class), "shared_link");
    }

    public ArrayList<BoxSharedLink.Access> getAllowedSharedLinkAccessLevels() {
        ArrayList<String> propertyAsStringArray = getPropertyAsStringArray(FIELD_ALLOWED_SHARED_LINK_ACCESS_LEVELS);
        if (propertyAsStringArray == null) {
            return null;
        }
        ArrayList<BoxSharedLink.Access> arrayList = new ArrayList<>(propertyAsStringArray.size());
        Iterator<String> it = propertyAsStringArray.iterator();
        while (it.hasNext()) {
            arrayList.add(BoxSharedLink.Access.fromString(it.next()));
        }
        return arrayList;
    }

    public BoxFolder getParent() {
        return (BoxFolder) getPropertyAsJsonObject(BoxEntity.getBoxJsonObjectCreator(BoxFolder.class), "parent");
    }

    public String getItemStatus() {
        return getPropertyAsString(FIELD_ITEM_STATUS);
    }

    public List<String> getTags() {
        return getPropertyAsStringArray("tags");
    }

    public List<BoxCollection> getCollections() {
        return getPropertyAsJsonObjectArray(BoxEntity.getBoxJsonObjectCreator(BoxCollection.class), FIELD_COLLECTIONS);
    }

    public BoxClassification getClassification() {
        return (BoxClassification) getPropertyAsJsonObject(BoxJsonObject.getBoxJsonObjectCreator(BoxClassification.class), FIELD_CLASSIFICATION);
    }

    public String getDescription() {
        return getPropertyAsString("description");
    }

    protected Long getCommentCount() {
        return getPropertyAsLong("comment_count");
    }

    protected Long getAnnotationCount() {
        return getPropertyAsLong("annotation_count");
    }

    private List<BoxFolder> parsePathCollection(JsonObject jsonObject) {
        ArrayList arrayList = new ArrayList(jsonObject.get(BoxIterator.FIELD_TOTAL_COUNT).asInt());
        Iterator<JsonValue> it = jsonObject.get("entries").asArray().iterator();
        while (it.hasNext()) {
            JsonObject jsonObjectAsObject = it.next().asObject();
            BoxFolder boxFolder = new BoxFolder();
            boxFolder.createFromJson(jsonObjectAsObject);
            arrayList.add(boxFolder);
        }
        return arrayList;
    }

    private BoxUser parseUserInfo(JsonObject jsonObject) {
        BoxUser boxUser = new BoxUser();
        boxUser.createFromJson(jsonObject);
        return boxUser;
    }

    private List<String> parseTags(JsonArray jsonArray) {
        ArrayList arrayList = new ArrayList();
        Iterator<JsonValue> it = jsonArray.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().asString());
        }
        return arrayList;
    }

    @Deprecated
    public static BoxItem createBoxItemFromJson(String str) {
        BoxEntity boxEntity = new BoxEntity();
        boxEntity.createFromJson(str);
        String type = boxEntity.getType();
        type.hashCode();
        switch (type) {
            case "folder":
                BoxFolder boxFolder = new BoxFolder();
                boxFolder.createFromJson(str);
                return boxFolder;
            case "web_link":
                BoxBookmark boxBookmark = new BoxBookmark();
                boxBookmark.createFromJson(str);
                return boxBookmark;
            case "file":
                BoxFile boxFile = new BoxFile();
                boxFile.createFromJson(str);
                return boxFile;
            default:
                return null;
        }
    }

    @Deprecated
    public static BoxItem createBoxItemFromJson(JsonObject jsonObject) {
        BoxEntity boxEntity = new BoxEntity();
        boxEntity.createFromJson(jsonObject);
        String type = boxEntity.getType();
        type.hashCode();
        switch (type) {
            case "folder":
                BoxFolder boxFolder = new BoxFolder();
                boxFolder.createFromJson(jsonObject);
                return boxFolder;
            case "web_link":
                BoxBookmark boxBookmark = new BoxBookmark();
                boxBookmark.createFromJson(jsonObject);
                return boxBookmark;
            case "file":
                BoxFile boxFile = new BoxFile();
                boxFile.createFromJson(jsonObject);
                return boxFile;
            default:
                return null;
        }
    }

    public EnumSet<Permission> getPermissions() {
        if (this.mPermissions == null) {
            parsePermissions();
        }
        return this.mPermissions;
    }

    protected EnumSet<Permission> parsePermissions() {
        BoxPermission boxPermission = (BoxPermission) getPropertyAsJsonObject(BoxEntity.getBoxJsonObjectCreator(BoxPermission.class), "permissions");
        if (boxPermission == null) {
            return null;
        }
        EnumSet<Permission> permissions = boxPermission.getPermissions();
        this.mPermissions = permissions;
        return permissions;
    }

    public enum Permission {
        CAN_PREVIEW("can_preview"),
        CAN_DOWNLOAD(BoxSharedLink.Permissions.FIELD_CAN_DOWNLOAD),
        CAN_UPLOAD("can_upload"),
        CAN_INVITE_COLLABORATOR("can_invite_collaborator"),
        CAN_RENAME("can_rename"),
        CAN_DELETE("can_delete"),
        CAN_SHARE("can_share"),
        CAN_SET_SHARE_ACCESS("can_set_share_access"),
        CAN_COMMENT("can_comment"),
        CAN_VIEW_ANNOTATIONS("can_view_annotations"),
        CAN_CREATE_ANNOTATIONS("can_create_annotations");

        private final String value;

        Permission(String str) {
            this.value = str;
        }

        public static Permission fromString(String str) {
            if (!TextUtils.isEmpty(str)) {
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
}
