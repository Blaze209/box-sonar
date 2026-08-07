package com.box.androidsdk.content.models;

import com.box.android.common.utilities.CommonBoxUtil;
import com.eclipsesource.json.JsonObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/* JADX INFO: loaded from: classes13.dex */
@Deprecated
public class BoxFile extends BoxCollaborationItem {
    public static final String FIELD_ANNOTATION_COUNT = "annotation_count";
    public static final String FIELD_COMMENT_COUNT = "comment_count";
    public static final String FIELD_CONTENT_CREATED_AT = "content_created_at";
    public static final String FIELD_CONTENT_MODIFIED_AT = "content_modified_at";
    public static final String FIELD_FILE_VERSION = "file_version";
    public static final String FIELD_IS_PACKAGE = "is_package";
    public static final String FIELD_REPRESENTATIONS = "representations";
    public static final String FIELD_SHA1 = "sha1";
    public static final String FIELD_SIZE = "size";
    public static final String FIELD_UPLOADER_DISPLAY_NAME = "uploader_display_name";
    public static final String TYPE = "file";
    private static final long serialVersionUID = -4732748896882484735L;
    private transient ArrayList<BoxSharedLink.Permission> mCachedSharedLinkPermissionOptions;
    public static final String FIELD_VERSION_NUMBER = "version_number";
    public static final String FIELD_SHARED_LINK_PERMISSION_OPTIONS = "shared_link_permission_options";
    public static final String FIELD_EXTENSION = "extension";
    public static final String FIELD_LOCK = "lock";
    public static final String FIELD_WATERMARK = "watermark_info";
    public static final String[] ALL_FIELDS = {"type", "id", "file_version", BoxItem.FIELD_ETAG, "sha1", "name", "created_at", "modified_at", "size", BoxItem.FIELD_PATH_COLLECTION, "uploader_display_name", "modified_by", "content_created_at", "content_modified_at", BoxItem.FIELD_OWNED_BY, "shared_link", "parent", BoxItem.FIELD_ITEM_STATUS, FIELD_VERSION_NUMBER, "comment_count", "permissions", FIELD_SHARED_LINK_PERMISSION_OPTIONS, FIELD_EXTENSION, BoxItem.FIELD_COLLECTIONS, BoxCollaborationItem.FIELD_HAS_COLLABORATIONS, BoxCollaborationItem.FIELD_IS_EXTERNALLY_OWNED, BoxCollaborationItem.FIELD_ALLOWED_INVITEE_ROLES, BoxItem.FIELD_CLASSIFICATION, "annotation_count", FIELD_LOCK, "description", FIELD_WATERMARK};

    public BoxFile() {
    }

    public BoxFile(JsonObject jsonObject) {
        super(jsonObject);
    }

    public static BoxFile createFromId(String str) {
        return createFromIdAndName(str, null);
    }

    public static BoxFile createFromIdAndName(String str, String str2) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("id", str);
        jsonObject.add("type", "file");
        if (str2 != null && !str2.isEmpty()) {
            jsonObject.add("name", str2);
        }
        return new BoxFile(jsonObject);
    }

    public static BoxFile createFromIdForModelMapping(String str) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("id", str);
        jsonObject.add("type", "file");
        jsonObject.add("name", "");
        jsonObject.add("sha1", "");
        return new BoxFile(jsonObject);
    }

    public BoxFileVersion getFileVersion() {
        return (BoxFileVersion) getPropertyAsJsonObject(BoxJsonObject.getBoxJsonObjectCreator(BoxFileVersion.class), "file_version");
    }

    public String getSha1() {
        return getPropertyAsString("sha1");
    }

    public String getVersionNumber() {
        return getPropertyAsString(FIELD_VERSION_NUMBER);
    }

    public String getExtension() {
        return getName() == null ? "" : CommonBoxUtil.getFileExtension(getName(), "");
    }

    public Boolean getIsPackage() {
        return getPropertyAsBoolean("is_package");
    }

    public ArrayList<BoxSharedLink.Permission> getSharedLinkPermissionOptions() {
        ArrayList<BoxSharedLink.Permission> arrayList = this.mCachedSharedLinkPermissionOptions;
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList<String> propertyAsStringArray = getPropertyAsStringArray(FIELD_SHARED_LINK_PERMISSION_OPTIONS);
        if (propertyAsStringArray == null) {
            return null;
        }
        this.mCachedSharedLinkPermissionOptions = new ArrayList<>(propertyAsStringArray.size());
        Iterator<String> it = propertyAsStringArray.iterator();
        while (it.hasNext()) {
            this.mCachedSharedLinkPermissionOptions.add(BoxSharedLink.Permission.fromString(it.next()));
        }
        return this.mCachedSharedLinkPermissionOptions;
    }

    public String getUploaderDisplayName() {
        return getPropertyAsString("uploader_display_name");
    }

    @Override // com.box.androidsdk.content.models.BoxItem
    public Date getContentCreatedAt() {
        return super.getContentCreatedAt();
    }

    @Override // com.box.androidsdk.content.models.BoxItem
    public Long getSize() {
        return super.getSize();
    }

    @Override // com.box.androidsdk.content.models.BoxItem
    public Date getContentModifiedAt() {
        return super.getContentModifiedAt();
    }

    @Override // com.box.androidsdk.content.models.BoxItem
    public Long getCommentCount() {
        return super.getCommentCount();
    }

    public Long getCommentCount(Boolean bool) {
        Long commentCount = getCommentCount();
        if (bool.booleanValue()) {
            Long annotationCount = super.getAnnotationCount();
            if (commentCount != null && annotationCount != null) {
                return Long.valueOf(commentCount.longValue() + annotationCount.longValue());
            }
        }
        return commentCount;
    }

    public BoxIteratorRepresentations getRepresentations() {
        return (BoxIteratorRepresentations) getPropertyAsJsonObject(BoxJsonObject.getBoxJsonObjectCreator(BoxIteratorRepresentations.class), FIELD_REPRESENTATIONS);
    }

    public BoxLock getLock() {
        return (BoxLock) getPropertyAsJsonObject(BoxJsonObject.getBoxJsonObjectCreator(BoxLock.class), FIELD_LOCK);
    }

    public BoxWatermark getWatermark() {
        return (BoxWatermark) getPropertyAsJsonObject(BoxJsonObject.getBoxJsonObjectCreator(BoxWatermark.class), FIELD_WATERMARK);
    }
}
