package com.box.androidsdk.content.models;

import android.text.TextUtils;
import com.eclipsesource.json.JsonObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes13.dex */
@Deprecated
public class BoxFolder extends BoxCollaborationItem {
    public static final String FIELD_CONTENT_CREATED_AT = "content_created_at";
    public static final String FIELD_CONTENT_MODIFIED_AT = "content_modified_at";
    public static final String FIELD_FOLDER_UPLOAD_EMAIL = "folder_upload_email";
    public static final String FIELD_SHA1 = "sha1";
    public static final String FIELD_SIZE = "size";
    public static final String TYPE = "folder";
    private static final long serialVersionUID = 8020073615785970254L;
    private transient ArrayList<BoxSharedLink.Access> mCachedAccessLevels;
    public static final String FIELD_ITEM_COLLECTION = "item_collection";
    public static final String FIELD_SYNC_STATE = "sync_state";
    public static final String[] ALL_FIELDS = {"description", "type", "sha1", "id", BoxItem.FIELD_ETAG, "name", "created_at", "modified_at", "size", BoxItem.FIELD_PATH_COLLECTION, "modified_by", "content_created_at", "content_modified_at", BoxItem.FIELD_OWNED_BY, "shared_link", "parent", BoxItem.FIELD_ITEM_STATUS, FIELD_ITEM_COLLECTION, FIELD_SYNC_STATE, BoxCollaborationItem.FIELD_HAS_COLLABORATIONS, "permissions", BoxCollaborationItem.FIELD_IS_EXTERNALLY_OWNED, BoxCollaborationItem.FIELD_ALLOWED_INVITEE_ROLES, BoxItem.FIELD_COLLECTIONS};

    public BoxFolder() {
    }

    public BoxFolder(JsonObject jsonObject) {
        super(jsonObject);
    }

    public static BoxFolder createFromId(String str) {
        return createFromIdAndName(str, null);
    }

    public static BoxFolder createFromIdAndName(String str, String str2) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("id", str);
        jsonObject.add("type", "folder");
        if (str2 != null && !str2.isEmpty()) {
            jsonObject.add("name", str2);
        }
        return new BoxFolder(jsonObject);
    }

    public BoxUploadEmail getUploadEmail() {
        return (BoxUploadEmail) getPropertyAsJsonObject(BoxEntity.getBoxJsonObjectCreator(BoxUploadEmail.class), FIELD_FOLDER_UPLOAD_EMAIL);
    }

    public SyncState getSyncState() {
        return SyncState.fromString(getPropertyAsString(FIELD_SYNC_STATE));
    }

    public BoxIteratorItems getItemCollection() {
        return (BoxIteratorItems) getPropertyAsJsonObject(BoxJsonObject.getBoxJsonObjectCreator(BoxIteratorItems.class), FIELD_ITEM_COLLECTION);
    }

    public BoxFolder copy(String str) {
        JsonObject jsonObject = new JsonObject(getOriginalJsonObject());
        if (str != null && !str.isEmpty()) {
            jsonObject.set("id", str);
        }
        return new BoxFolder(jsonObject);
    }

    @Override // com.box.androidsdk.content.models.BoxItem
    public ArrayList<BoxSharedLink.Access> getAllowedSharedLinkAccessLevels() {
        ArrayList<BoxSharedLink.Access> arrayList = this.mCachedAccessLevels;
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList<String> propertyAsStringArray = getPropertyAsStringArray(BoxItem.FIELD_ALLOWED_SHARED_LINK_ACCESS_LEVELS);
        if (propertyAsStringArray == null) {
            return null;
        }
        this.mCachedAccessLevels = new ArrayList<>(propertyAsStringArray.size());
        Iterator<String> it = propertyAsStringArray.iterator();
        while (it.hasNext()) {
            this.mCachedAccessLevels.add(BoxSharedLink.Access.fromString(it.next()));
        }
        return this.mCachedAccessLevels;
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

    public enum SyncState {
        SYNCED("synced"),
        NOT_SYNCED("not_synced"),
        PARTIALLY_SYNCED("partially_synced");

        private final String mValue;

        SyncState(String str) {
            this.mValue = str;
        }

        public static SyncState fromString(String str) {
            if (!TextUtils.isEmpty(str)) {
                for (SyncState syncState : values()) {
                    if (str.equalsIgnoreCase(syncState.toString())) {
                        return syncState;
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
