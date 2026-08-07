package com.box.android.data.api.models.items;

import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: ItemDTOFields.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0015\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0013\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\u0015\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0011\u0010\u0017\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000eR\u0011\u0010\u0019\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/box/android/data/api/models/items/ItemDTOFields;", "", "<init>", "()V", "defaultFields", "", "", "allFileFields", "allFolderFields", "allWeblinkFields", "folderMiniWithParent", "folderMini", "DEFAULT_ITEM_FIELDS", "getDEFAULT_ITEM_FIELDS", "()Ljava/lang/String;", "ALL_FILE_FIELDS", "getALL_FILE_FIELDS", "ALL_FILE_FIELDS_WITH_REPRESENTATIONS", "getALL_FILE_FIELDS_WITH_REPRESENTATIONS", "ALL_FOLDER_FIELDS", "getALL_FOLDER_FIELDS", "ALL_WEBLINK_FIELDS", "getALL_WEBLINK_FIELDS", "FOLDER_MINI_FIELDS", "getFOLDER_MINI_FIELDS", "FOLDER_MINI_FIELDS_WITH_PARENT", "getFOLDER_MINI_FIELDS_WITH_PARENT", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ItemDTOFields {
    private static final String ALL_FILE_FIELDS;
    private static final String ALL_FILE_FIELDS_WITH_REPRESENTATIONS;
    private static final String ALL_FOLDER_FIELDS;
    private static final String ALL_WEBLINK_FIELDS;
    private static final String DEFAULT_ITEM_FIELDS;
    private static final String FOLDER_MINI_FIELDS;
    private static final String FOLDER_MINI_FIELDS_WITH_PARENT;
    public static final ItemDTOFields INSTANCE = new ItemDTOFields();
    private static final List<String> allFileFields;
    private static final List<String> allFolderFields;
    private static final List<String> allWeblinkFields;
    private static final List<String> defaultFields;
    private static final List<String> folderMini;
    private static final List<String> folderMiniWithParent;

    private ItemDTOFields() {
    }

    static {
        List<String> listListOf = CollectionsKt.listOf((Object[]) new String[]{"id", "type", "name", "size", BoxItem.FIELD_ETAG, "parent", BoxItem.FIELD_OWNED_BY, "modified_at", "description", "modified_by", "permissions", BoxItem.FIELD_COLLECTIONS, BoxItem.FIELD_PATH_COLLECTION, "content_created_at", BoxCollaborationItem.FIELD_HAS_COLLABORATIONS, "content_modified_at", BoxCollaborationItem.FIELD_IS_EXTERNALLY_OWNED, "sha1", BoxFile.FIELD_WATERMARK, "url", "file_version", "comment_count", "annotation_count", "description", "shared_link"});
        defaultFields = listListOf;
        List<String> listListOf2 = CollectionsKt.listOf((Object[]) new String[]{"created_at", BoxItem.FIELD_ETAG, "id", BoxItem.FIELD_ITEM_STATUS, "modified_at", "modified_by", "name", BoxItem.FIELD_OWNED_BY, "parent", BoxItem.FIELD_PATH_COLLECTION, "permissions", "shared_link", "type", "description", BoxCollaborationItem.FIELD_ALLOWED_INVITEE_ROLES, "content_created_at", "content_modified_at", BoxCollaborationItem.FIELD_HAS_COLLABORATIONS, BoxCollaborationItem.FIELD_IS_EXTERNALLY_OWNED, "size", BoxItem.FIELD_COLLECTIONS, "sha1", BoxFile.FIELD_WATERMARK, "comment_count", "annotation_count", "file_version", BoxFile.FIELD_VERSION_NUMBER, BoxFile.FIELD_SHARED_LINK_PERMISSION_OPTIONS, BoxFile.FIELD_LOCK, "uploader_display_name", BoxItem.FIELD_CLASSIFICATION});
        allFileFields = listListOf2;
        List<String> listListOf3 = CollectionsKt.listOf((Object[]) new String[]{"created_at", BoxItem.FIELD_ETAG, "id", BoxItem.FIELD_ITEM_STATUS, "modified_at", "modified_by", "name", BoxItem.FIELD_OWNED_BY, "parent", BoxItem.FIELD_PATH_COLLECTION, "permissions", "shared_link", "type", "description", BoxCollaborationItem.FIELD_ALLOWED_INVITEE_ROLES, "content_created_at", "content_modified_at", BoxCollaborationItem.FIELD_HAS_COLLABORATIONS, BoxCollaborationItem.FIELD_IS_EXTERNALLY_OWNED, "size", BoxItem.FIELD_COLLECTIONS, "sha1", BoxFolder.FIELD_SYNC_STATE, BoxFile.FIELD_WATERMARK});
        allFolderFields = listListOf3;
        List<String> listListOf4 = CollectionsKt.listOf((Object[]) new String[]{"created_at", BoxItem.FIELD_ETAG, "id", BoxItem.FIELD_ITEM_STATUS, "modified_at", "modified_by", "name", BoxItem.FIELD_OWNED_BY, "parent", BoxItem.FIELD_PATH_COLLECTION, "permissions", "shared_link", "type", "description", "comment_count", "url"});
        allWeblinkFields = listListOf4;
        List<String> listListOf5 = CollectionsKt.listOf((Object[]) new String[]{"id", "name", "parent"});
        folderMiniWithParent = listListOf5;
        List<String> listListOf6 = CollectionsKt.listOf((Object[]) new String[]{"id", "name"});
        folderMini = listListOf6;
        DEFAULT_ITEM_FIELDS = CollectionsKt.joinToString$default(listListOf, ",", null, null, 0, null, null, 62, null);
        ALL_FILE_FIELDS = CollectionsKt.joinToString$default(listListOf2, ",", null, null, 0, null, null, 62, null);
        ALL_FILE_FIELDS_WITH_REPRESENTATIONS = CollectionsKt.joinToString$default(CollectionsKt.plus((Collection<? extends String>) listListOf2, BoxFile.FIELD_REPRESENTATIONS), ",", null, null, 0, null, null, 62, null);
        ALL_FOLDER_FIELDS = CollectionsKt.joinToString$default(listListOf3, ",", null, null, 0, null, null, 62, null);
        ALL_WEBLINK_FIELDS = CollectionsKt.joinToString$default(listListOf4, ",", null, null, 0, null, null, 62, null);
        FOLDER_MINI_FIELDS = CollectionsKt.joinToString$default(listListOf6, ",", null, null, 0, null, null, 62, null);
        FOLDER_MINI_FIELDS_WITH_PARENT = CollectionsKt.joinToString$default(listListOf5, ",", null, null, 0, null, null, 62, null);
    }

    public final String getDEFAULT_ITEM_FIELDS() {
        return DEFAULT_ITEM_FIELDS;
    }

    public final String getALL_FILE_FIELDS() {
        return ALL_FILE_FIELDS;
    }

    public final String getALL_FILE_FIELDS_WITH_REPRESENTATIONS() {
        return ALL_FILE_FIELDS_WITH_REPRESENTATIONS;
    }

    public final String getALL_FOLDER_FIELDS() {
        return ALL_FOLDER_FIELDS;
    }

    public final String getALL_WEBLINK_FIELDS() {
        return ALL_WEBLINK_FIELDS;
    }

    public final String getFOLDER_MINI_FIELDS() {
        return FOLDER_MINI_FIELDS;
    }

    public final String getFOLDER_MINI_FIELDS_WITH_PARENT() {
        return FOLDER_MINI_FIELDS_WITH_PARENT;
    }
}
