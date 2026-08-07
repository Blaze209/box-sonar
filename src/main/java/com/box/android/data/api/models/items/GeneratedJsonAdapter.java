package com.box.android.data.api.models.items;

import com.box.android.data.api.models.ClassificationDTO;
import com.box.android.data.api.models.FileLockDTO;
import com.box.android.data.api.models.PathCollectionDTO;
import com.box.android.data.api.models.PermissionsDTO;
import com.box.android.data.api.models.RepresentationsDTO;
import com.box.android.data.api.models.SharedLinkDTO;
import com.box.android.data.api.models.UserMiniDTO;
import com.box.android.data.api.models.WatermarkDTO;
import com.box.android.data.api.models.collections.CollectionDTO;
import com.box.android.data.api.models.fileversions.FileVersionMiniDTO;
import com.box.android.data.api.models.items.mini.FolderMiniDTO;
import com.box.android.domain.models.CollaborationRole;
import com.box.android.domain.models.SharedLinkModel;
import com.box.android.domain.models.SharedLinkPermissionOptionType;
import com.box.android.domain.models.item.ItemStatus;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxItem;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.box.android.data.api.models.items.FileDTOJsonAdapter, reason: from toString */
/* JADX INFO: compiled from: FileDTOJsonAdapter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u00103\u001a\u00020\nH\u0016J\u0010\u00104\u001a\u00020\u00022\u0006\u00105\u001a\u000206H\u0016J\u001a\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u0002H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00170\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00170\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00170\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00170\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00170\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010*0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010.0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001000\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u00101\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/box/android/data/api/models/items/FileDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/box/android/data/api/models/items/FileDTO;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "nullableStringAdapter", "nullableFolderMiniDTOAdapter", "Lcom/box/android/data/api/models/items/mini/FolderMiniDTO;", "nullableSharedLinkDTOAdapter", "Lcom/box/android/data/api/models/SharedLinkDTO;", "nullablePathCollectionDTOAdapter", "Lcom/box/android/data/api/models/PathCollectionDTO;", "nullableUserMiniDTOAdapter", "Lcom/box/android/data/api/models/UserMiniDTO;", "nullablePermissionsDTOAdapter", "Lcom/box/android/data/api/models/PermissionsDTO;", "nullableListOfSharedLinkPermissionOptionTypeAdapter", "", "Lcom/box/android/domain/models/SharedLinkPermissionOptionType;", "nullableListOfAccessAdapter", "Lcom/box/android/domain/models/SharedLinkModel$Access;", "nullableListOfStringAdapter", "nullableListOfCollectionDTOAdapter", "Lcom/box/android/data/api/models/collections/CollectionDTO;", "nullableLongAdapter", "", "nullableBooleanAdapter", "", "nullableListOfCollaborationRoleAdapter", "Lcom/box/android/domain/models/CollaborationRole;", "nullableCollaborationRoleAdapter", "nullableFileVersionMiniDTOAdapter", "Lcom/box/android/data/api/models/fileversions/FileVersionMiniDTO;", "nullableItemStatusAdapter", "Lcom/box/android/domain/models/item/ItemStatus;", "nullableFileLockDTOAdapter", "Lcom/box/android/data/api/models/FileLockDTO;", "nullableRepresentationsDTOAdapter", "Lcom/box/android/data/api/models/RepresentationsDTO;", "nullableClassificationDTOAdapter", "Lcom/box/android/data/api/models/ClassificationDTO;", "nullableWatermarkDTOAdapter", "Lcom/box/android/data/api/models/WatermarkDTO;", "constructorRef", "Ljava/lang/reflect/Constructor;", "toString", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GeneratedJsonAdapter extends JsonAdapter<FileDTO> {
    private volatile Constructor<FileDTO> constructorRef;
    private final JsonAdapter<Boolean> nullableBooleanAdapter;
    private final JsonAdapter<ClassificationDTO> nullableClassificationDTOAdapter;
    private final JsonAdapter<CollaborationRole> nullableCollaborationRoleAdapter;
    private final JsonAdapter<FileLockDTO> nullableFileLockDTOAdapter;
    private final JsonAdapter<FileVersionMiniDTO> nullableFileVersionMiniDTOAdapter;
    private final JsonAdapter<FolderMiniDTO> nullableFolderMiniDTOAdapter;
    private final JsonAdapter<ItemStatus> nullableItemStatusAdapter;
    private final JsonAdapter<List<SharedLinkModel.Access>> nullableListOfAccessAdapter;
    private final JsonAdapter<List<CollaborationRole>> nullableListOfCollaborationRoleAdapter;
    private final JsonAdapter<List<CollectionDTO>> nullableListOfCollectionDTOAdapter;
    private final JsonAdapter<List<SharedLinkPermissionOptionType>> nullableListOfSharedLinkPermissionOptionTypeAdapter;
    private final JsonAdapter<List<String>> nullableListOfStringAdapter;
    private final JsonAdapter<Long> nullableLongAdapter;
    private final JsonAdapter<PathCollectionDTO> nullablePathCollectionDTOAdapter;
    private final JsonAdapter<PermissionsDTO> nullablePermissionsDTOAdapter;
    private final JsonAdapter<RepresentationsDTO> nullableRepresentationsDTOAdapter;
    private final JsonAdapter<SharedLinkDTO> nullableSharedLinkDTOAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonAdapter<UserMiniDTO> nullableUserMiniDTOAdapter;
    private final JsonAdapter<WatermarkDTO> nullableWatermarkDTOAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public GeneratedJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options optionsOf = JsonReader.Options.of("id", "type", "name", BoxItem.FIELD_ETAG, "parent", "shared_link", "created_at", "modified_at", "content_created_at", "content_modified_at", "description", BoxItem.FIELD_PATH_COLLECTION, "modified_by", BoxItem.FIELD_OWNED_BY, "permissions", BoxFile.FIELD_SHARED_LINK_PERMISSION_OPTIONS, BoxItem.FIELD_ALLOWED_SHARED_LINK_ACCESS_LEVELS, "tags", BoxItem.FIELD_COLLECTIONS, "size", BoxCollaborationItem.FIELD_HAS_COLLABORATIONS, BoxCollaborationItem.FIELD_ALLOWED_INVITEE_ROLES, BoxCollaborationItem.FIELD_DEFAULT_INVITEE_ROLE, BoxCollaborationItem.FIELD_IS_EXTERNALLY_OWNED, "comment_count", "annotation_count", "sha1", "file_version", BoxFile.FIELD_VERSION_NUMBER, BoxItem.FIELD_ITEM_STATUS, BoxFile.FIELD_LOCK, BoxFile.FIELD_REPRESENTATIONS, BoxItem.FIELD_CLASSIFICATION, BoxFile.FIELD_WATERMARK);
        Intrinsics.checkNotNullExpressionValue(optionsOf, "of(...)");
        this.options = optionsOf;
        JsonAdapter<String> jsonAdapterAdapter = moshi.adapter(String.class, SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter, "adapter(...)");
        this.stringAdapter = jsonAdapterAdapter;
        JsonAdapter<String> jsonAdapterAdapter2 = moshi.adapter(String.class, SetsKt.emptySet(), "name");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter2, "adapter(...)");
        this.nullableStringAdapter = jsonAdapterAdapter2;
        JsonAdapter<FolderMiniDTO> jsonAdapterAdapter3 = moshi.adapter(FolderMiniDTO.class, SetsKt.emptySet(), "parent");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter3, "adapter(...)");
        this.nullableFolderMiniDTOAdapter = jsonAdapterAdapter3;
        JsonAdapter<SharedLinkDTO> jsonAdapterAdapter4 = moshi.adapter(SharedLinkDTO.class, SetsKt.emptySet(), BoxNoteConstants.NOTES_BUILDER_SHARED_LINK);
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter4, "adapter(...)");
        this.nullableSharedLinkDTOAdapter = jsonAdapterAdapter4;
        JsonAdapter<PathCollectionDTO> jsonAdapterAdapter5 = moshi.adapter(PathCollectionDTO.class, SetsKt.emptySet(), "pathCollection");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter5, "adapter(...)");
        this.nullablePathCollectionDTOAdapter = jsonAdapterAdapter5;
        JsonAdapter<UserMiniDTO> jsonAdapterAdapter6 = moshi.adapter(UserMiniDTO.class, SetsKt.emptySet(), "modifiedBy");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter6, "adapter(...)");
        this.nullableUserMiniDTOAdapter = jsonAdapterAdapter6;
        JsonAdapter<PermissionsDTO> jsonAdapterAdapter7 = moshi.adapter(PermissionsDTO.class, SetsKt.emptySet(), "permissions");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter7, "adapter(...)");
        this.nullablePermissionsDTOAdapter = jsonAdapterAdapter7;
        JsonAdapter<List<SharedLinkPermissionOptionType>> jsonAdapterAdapter8 = moshi.adapter(Types.newParameterizedType(List.class, SharedLinkPermissionOptionType.class), SetsKt.emptySet(), "sharedLinkPermissions");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter8, "adapter(...)");
        this.nullableListOfSharedLinkPermissionOptionTypeAdapter = jsonAdapterAdapter8;
        JsonAdapter<List<SharedLinkModel.Access>> jsonAdapterAdapter9 = moshi.adapter(Types.newParameterizedType(List.class, SharedLinkModel.Access.class), SetsKt.emptySet(), "allowedSharedLinkAccessLevels");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter9, "adapter(...)");
        this.nullableListOfAccessAdapter = jsonAdapterAdapter9;
        JsonAdapter<List<String>> jsonAdapterAdapter10 = moshi.adapter(Types.newParameterizedType(List.class, String.class), SetsKt.emptySet(), "tags");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter10, "adapter(...)");
        this.nullableListOfStringAdapter = jsonAdapterAdapter10;
        JsonAdapter<List<CollectionDTO>> jsonAdapterAdapter11 = moshi.adapter(Types.newParameterizedType(List.class, CollectionDTO.class), SetsKt.emptySet(), BoxItem.FIELD_COLLECTIONS);
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter11, "adapter(...)");
        this.nullableListOfCollectionDTOAdapter = jsonAdapterAdapter11;
        JsonAdapter<Long> jsonAdapterAdapter12 = moshi.adapter(Long.class, SetsKt.emptySet(), "size");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter12, "adapter(...)");
        this.nullableLongAdapter = jsonAdapterAdapter12;
        JsonAdapter<Boolean> jsonAdapterAdapter13 = moshi.adapter(Boolean.class, SetsKt.emptySet(), "hasCollaborations");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter13, "adapter(...)");
        this.nullableBooleanAdapter = jsonAdapterAdapter13;
        JsonAdapter<List<CollaborationRole>> jsonAdapterAdapter14 = moshi.adapter(Types.newParameterizedType(List.class, CollaborationRole.class), SetsKt.emptySet(), "allowedInviteeRoles");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter14, "adapter(...)");
        this.nullableListOfCollaborationRoleAdapter = jsonAdapterAdapter14;
        JsonAdapter<CollaborationRole> jsonAdapterAdapter15 = moshi.adapter(CollaborationRole.class, SetsKt.emptySet(), "defaultInviteeRole");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter15, "adapter(...)");
        this.nullableCollaborationRoleAdapter = jsonAdapterAdapter15;
        JsonAdapter<FileVersionMiniDTO> jsonAdapterAdapter16 = moshi.adapter(FileVersionMiniDTO.class, SetsKt.emptySet(), "fileVersion");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter16, "adapter(...)");
        this.nullableFileVersionMiniDTOAdapter = jsonAdapterAdapter16;
        JsonAdapter<ItemStatus> jsonAdapterAdapter17 = moshi.adapter(ItemStatus.class, SetsKt.emptySet(), "itemStatus");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter17, "adapter(...)");
        this.nullableItemStatusAdapter = jsonAdapterAdapter17;
        JsonAdapter<FileLockDTO> jsonAdapterAdapter18 = moshi.adapter(FileLockDTO.class, SetsKt.emptySet(), "fileLock");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter18, "adapter(...)");
        this.nullableFileLockDTOAdapter = jsonAdapterAdapter18;
        JsonAdapter<RepresentationsDTO> jsonAdapterAdapter19 = moshi.adapter(RepresentationsDTO.class, SetsKt.emptySet(), BoxFile.FIELD_REPRESENTATIONS);
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter19, "adapter(...)");
        this.nullableRepresentationsDTOAdapter = jsonAdapterAdapter19;
        JsonAdapter<ClassificationDTO> jsonAdapterAdapter20 = moshi.adapter(ClassificationDTO.class, SetsKt.emptySet(), BoxItem.FIELD_CLASSIFICATION);
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter20, "adapter(...)");
        this.nullableClassificationDTOAdapter = jsonAdapterAdapter20;
        JsonAdapter<WatermarkDTO> jsonAdapterAdapter21 = moshi.adapter(WatermarkDTO.class, SetsKt.emptySet(), "watermark");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter21, "adapter(...)");
        this.nullableWatermarkDTOAdapter = jsonAdapterAdapter21;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(29);
        sb.append("GeneratedJsonAdapter(FileDTO)");
        return sb.toString();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public FileDTO fromJson(JsonReader reader) throws IllegalAccessException, NoSuchMethodException, InstantiationException, IOException, InvocationTargetException {
        int i;
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.beginObject();
        int i2 = -1;
        String strFromJson = null;
        String strFromJson2 = null;
        String strFromJson3 = null;
        String strFromJson4 = null;
        FolderMiniDTO folderMiniDTOFromJson = null;
        SharedLinkDTO sharedLinkDTOFromJson = null;
        String strFromJson5 = null;
        String strFromJson6 = null;
        String strFromJson7 = null;
        String strFromJson8 = null;
        String strFromJson9 = null;
        PathCollectionDTO pathCollectionDTOFromJson = null;
        UserMiniDTO userMiniDTOFromJson = null;
        UserMiniDTO userMiniDTOFromJson2 = null;
        PermissionsDTO permissionsDTOFromJson = null;
        List<SharedLinkPermissionOptionType> listFromJson = null;
        List<SharedLinkModel.Access> listFromJson2 = null;
        List<String> listFromJson3 = null;
        List<CollectionDTO> listFromJson4 = null;
        Long lFromJson = null;
        Boolean boolFromJson = null;
        List<CollaborationRole> listFromJson5 = null;
        CollaborationRole collaborationRoleFromJson = null;
        Boolean boolFromJson2 = null;
        Long lFromJson2 = null;
        Long lFromJson3 = null;
        String strFromJson10 = null;
        FileVersionMiniDTO fileVersionMiniDTOFromJson = null;
        String strFromJson11 = null;
        ItemStatus itemStatusFromJson = null;
        FileLockDTO fileLockDTOFromJson = null;
        RepresentationsDTO representationsDTOFromJson = null;
        ClassificationDTO classificationDTOFromJson = null;
        WatermarkDTO watermarkDTOFromJson = null;
        int i3 = -1;
        while (true) {
            String str = strFromJson;
            String str2 = strFromJson2;
            if (reader.hasNext()) {
                String str3 = strFromJson3;
                switch (reader.selectName(this.options)) {
                    case -1:
                        reader.skipName();
                        reader.skipValue();
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        break;
                    case 0:
                        strFromJson = this.stringAdapter.fromJson(reader);
                        if (strFromJson == null) {
                            JsonDataException jsonDataExceptionUnexpectedNull = Util.unexpectedNull("id", "id", reader);
                            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull, "unexpectedNull(...)");
                            throw jsonDataExceptionUnexpectedNull;
                        }
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        break;
                    case 1:
                        strFromJson2 = this.stringAdapter.fromJson(reader);
                        if (strFromJson2 == null) {
                            JsonDataException jsonDataExceptionUnexpectedNull2 = Util.unexpectedNull("type", "type", reader);
                            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull2, "unexpectedNull(...)");
                            throw jsonDataExceptionUnexpectedNull2;
                        }
                        strFromJson = str;
                        strFromJson3 = str3;
                        break;
                        break;
                    case 2:
                        strFromJson3 = this.nullableStringAdapter.fromJson(reader);
                        i2 &= -5;
                        strFromJson = str;
                        strFromJson2 = str2;
                        break;
                    case 3:
                        strFromJson4 = this.nullableStringAdapter.fromJson(reader);
                        i2 &= -9;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        break;
                    case 4:
                        folderMiniDTOFromJson = this.nullableFolderMiniDTOAdapter.fromJson(reader);
                        i2 &= -17;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        break;
                    case 5:
                        sharedLinkDTOFromJson = this.nullableSharedLinkDTOAdapter.fromJson(reader);
                        i2 &= -33;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        break;
                    case 6:
                        strFromJson5 = this.nullableStringAdapter.fromJson(reader);
                        i2 &= -65;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        break;
                    case 7:
                        strFromJson6 = this.nullableStringAdapter.fromJson(reader);
                        i2 &= -129;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        break;
                    case 8:
                        strFromJson7 = this.nullableStringAdapter.fromJson(reader);
                        i2 &= -257;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        break;
                    case 9:
                        strFromJson8 = this.nullableStringAdapter.fromJson(reader);
                        i2 &= -513;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        break;
                    case 10:
                        strFromJson9 = this.nullableStringAdapter.fromJson(reader);
                        i2 &= -1025;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        break;
                    case 11:
                        pathCollectionDTOFromJson = this.nullablePathCollectionDTOAdapter.fromJson(reader);
                        i2 &= -2049;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        break;
                    case 12:
                        userMiniDTOFromJson = this.nullableUserMiniDTOAdapter.fromJson(reader);
                        i2 &= -4097;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        break;
                    case 13:
                        userMiniDTOFromJson2 = this.nullableUserMiniDTOAdapter.fromJson(reader);
                        i2 &= -8193;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        break;
                    case 14:
                        permissionsDTOFromJson = this.nullablePermissionsDTOAdapter.fromJson(reader);
                        i2 &= -16385;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        break;
                    case 15:
                        listFromJson = this.nullableListOfSharedLinkPermissionOptionTypeAdapter.fromJson(reader);
                        i = -32769;
                        i2 &= i;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        break;
                    case 16:
                        listFromJson2 = this.nullableListOfAccessAdapter.fromJson(reader);
                        i = -65537;
                        i2 &= i;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        break;
                    case 17:
                        listFromJson3 = this.nullableListOfStringAdapter.fromJson(reader);
                        i = -131073;
                        i2 &= i;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        break;
                    case 18:
                        listFromJson4 = this.nullableListOfCollectionDTOAdapter.fromJson(reader);
                        i = -262145;
                        i2 &= i;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        break;
                    case 19:
                        lFromJson = this.nullableLongAdapter.fromJson(reader);
                        i = -524289;
                        i2 &= i;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        break;
                    case 20:
                        boolFromJson = this.nullableBooleanAdapter.fromJson(reader);
                        i = -1048577;
                        i2 &= i;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        break;
                    case 21:
                        listFromJson5 = this.nullableListOfCollaborationRoleAdapter.fromJson(reader);
                        i = -2097153;
                        i2 &= i;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        break;
                    case 22:
                        collaborationRoleFromJson = this.nullableCollaborationRoleAdapter.fromJson(reader);
                        i = -4194305;
                        i2 &= i;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        break;
                    case 23:
                        boolFromJson2 = this.nullableBooleanAdapter.fromJson(reader);
                        i = -8388609;
                        i2 &= i;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        break;
                    case 24:
                        lFromJson2 = this.nullableLongAdapter.fromJson(reader);
                        i = -16777217;
                        i2 &= i;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        break;
                    case 25:
                        lFromJson3 = this.nullableLongAdapter.fromJson(reader);
                        i = -33554433;
                        i2 &= i;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        break;
                    case 26:
                        strFromJson10 = this.nullableStringAdapter.fromJson(reader);
                        i = -67108865;
                        i2 &= i;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        break;
                    case 27:
                        fileVersionMiniDTOFromJson = this.nullableFileVersionMiniDTOAdapter.fromJson(reader);
                        i = -134217729;
                        i2 &= i;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        break;
                    case 28:
                        strFromJson11 = this.nullableStringAdapter.fromJson(reader);
                        i = -268435457;
                        i2 &= i;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        break;
                    case 29:
                        itemStatusFromJson = this.nullableItemStatusAdapter.fromJson(reader);
                        i = -536870913;
                        i2 &= i;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        break;
                    case 30:
                        fileLockDTOFromJson = this.nullableFileLockDTOAdapter.fromJson(reader);
                        i = -1073741825;
                        i2 &= i;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        break;
                    case 31:
                        representationsDTOFromJson = this.nullableRepresentationsDTOAdapter.fromJson(reader);
                        i = Integer.MAX_VALUE;
                        i2 &= i;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        break;
                    case 32:
                        classificationDTOFromJson = this.nullableClassificationDTOAdapter.fromJson(reader);
                        i3 &= -2;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        break;
                    case 33:
                        watermarkDTOFromJson = this.nullableWatermarkDTOAdapter.fromJson(reader);
                        i3 &= -3;
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        break;
                    default:
                        strFromJson = str;
                        strFromJson2 = str2;
                        strFromJson3 = str3;
                        break;
                }
            } else {
                String str4 = strFromJson3;
                reader.endObject();
                if (i2 == 3 && i3 == -4) {
                    if (str == null) {
                        JsonDataException jsonDataExceptionMissingProperty = Util.missingProperty("id", "id", reader);
                        Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty, "missingProperty(...)");
                        throw jsonDataExceptionMissingProperty;
                    }
                    if (str2 != null) {
                        String str5 = strFromJson7;
                        String str6 = strFromJson6;
                        return new FileDTO(str, str2, str4, strFromJson4, folderMiniDTOFromJson, sharedLinkDTOFromJson, strFromJson5, str6, str5, strFromJson8, strFromJson9, pathCollectionDTOFromJson, userMiniDTOFromJson, userMiniDTOFromJson2, permissionsDTOFromJson, listFromJson, listFromJson2, listFromJson3, listFromJson4, lFromJson, boolFromJson, listFromJson5, collaborationRoleFromJson, boolFromJson2, lFromJson2, lFromJson3, strFromJson10, fileVersionMiniDTOFromJson, strFromJson11, itemStatusFromJson, fileLockDTOFromJson, representationsDTOFromJson, classificationDTOFromJson, watermarkDTOFromJson);
                    }
                    JsonDataException jsonDataExceptionMissingProperty2 = Util.missingProperty("type", "type", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty2, "missingProperty(...)");
                    throw jsonDataExceptionMissingProperty2;
                }
                int i4 = i2;
                int i5 = i3;
                String str7 = strFromJson7;
                String str8 = strFromJson6;
                String str9 = strFromJson5;
                SharedLinkDTO sharedLinkDTO = sharedLinkDTOFromJson;
                FolderMiniDTO folderMiniDTO = folderMiniDTOFromJson;
                String str10 = strFromJson4;
                Constructor<FileDTO> declaredConstructor = this.constructorRef;
                if (declaredConstructor == null) {
                    declaredConstructor = FileDTO.class.getDeclaredConstructor(String.class, String.class, String.class, String.class, FolderMiniDTO.class, SharedLinkDTO.class, String.class, String.class, String.class, String.class, String.class, PathCollectionDTO.class, UserMiniDTO.class, UserMiniDTO.class, PermissionsDTO.class, List.class, List.class, List.class, List.class, Long.class, Boolean.class, List.class, CollaborationRole.class, Boolean.class, Long.class, Long.class, String.class, FileVersionMiniDTO.class, String.class, ItemStatus.class, FileLockDTO.class, RepresentationsDTO.class, ClassificationDTO.class, WatermarkDTO.class, Integer.TYPE, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
                    this.constructorRef = declaredConstructor;
                    Intrinsics.checkNotNullExpressionValue(declaredConstructor, "also(...)");
                }
                Constructor<FileDTO> constructor = declaredConstructor;
                if (str == null) {
                    JsonDataException jsonDataExceptionMissingProperty3 = Util.missingProperty("id", "id", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty3, "missingProperty(...)");
                    throw jsonDataExceptionMissingProperty3;
                }
                if (r6 == 0) {
                    JsonDataException jsonDataExceptionMissingProperty4 = Util.missingProperty("type", "type", reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty4, "missingProperty(...)");
                    throw jsonDataExceptionMissingProperty4;
                }
                FileDTO fileDTONewInstance = constructor.newInstance(str, str2, str4, str10, folderMiniDTO, sharedLinkDTO, str9, str8, str7, strFromJson8, strFromJson9, pathCollectionDTOFromJson, userMiniDTOFromJson, userMiniDTOFromJson2, permissionsDTOFromJson, listFromJson, listFromJson2, listFromJson3, listFromJson4, lFromJson, boolFromJson, listFromJson5, collaborationRoleFromJson, boolFromJson2, lFromJson2, lFromJson3, strFromJson10, fileVersionMiniDTOFromJson, strFromJson11, itemStatusFromJson, fileLockDTOFromJson, representationsDTOFromJson, classificationDTOFromJson, watermarkDTOFromJson, Integer.valueOf(i4), Integer.valueOf(i5), null);
                Intrinsics.checkNotNullExpressionValue(fileDTONewInstance, "newInstance(...)");
                return fileDTONewInstance;
            }
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, FileDTO value_) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name("id");
        this.stringAdapter.toJson(writer, value_.getId());
        writer.name("type");
        this.stringAdapter.toJson(writer, value_.getType());
        writer.name("name");
        this.nullableStringAdapter.toJson(writer, value_.getName());
        writer.name(BoxItem.FIELD_ETAG);
        this.nullableStringAdapter.toJson(writer, value_.getEtag());
        writer.name("parent");
        this.nullableFolderMiniDTOAdapter.toJson(writer, value_.getParent());
        writer.name("shared_link");
        this.nullableSharedLinkDTOAdapter.toJson(writer, value_.getSharedLink());
        writer.name("created_at");
        this.nullableStringAdapter.toJson(writer, value_.getCreatedAt());
        writer.name("modified_at");
        this.nullableStringAdapter.toJson(writer, value_.getModifiedAt());
        writer.name("content_created_at");
        this.nullableStringAdapter.toJson(writer, value_.getContentCreatedAt());
        writer.name("content_modified_at");
        this.nullableStringAdapter.toJson(writer, value_.getContentModifiedAt());
        writer.name("description");
        this.nullableStringAdapter.toJson(writer, value_.getDescription());
        writer.name(BoxItem.FIELD_PATH_COLLECTION);
        this.nullablePathCollectionDTOAdapter.toJson(writer, value_.getPathCollection());
        writer.name("modified_by");
        this.nullableUserMiniDTOAdapter.toJson(writer, value_.getModifiedBy());
        writer.name(BoxItem.FIELD_OWNED_BY);
        this.nullableUserMiniDTOAdapter.toJson(writer, value_.getOwnedBy());
        writer.name("permissions");
        this.nullablePermissionsDTOAdapter.toJson(writer, value_.getPermissions());
        writer.name(BoxFile.FIELD_SHARED_LINK_PERMISSION_OPTIONS);
        this.nullableListOfSharedLinkPermissionOptionTypeAdapter.toJson(writer, value_.getSharedLinkPermissions());
        writer.name(BoxItem.FIELD_ALLOWED_SHARED_LINK_ACCESS_LEVELS);
        this.nullableListOfAccessAdapter.toJson(writer, value_.getAllowedSharedLinkAccessLevels());
        writer.name("tags");
        this.nullableListOfStringAdapter.toJson(writer, value_.getTags());
        writer.name(BoxItem.FIELD_COLLECTIONS);
        this.nullableListOfCollectionDTOAdapter.toJson(writer, value_.getCollections());
        writer.name("size");
        this.nullableLongAdapter.toJson(writer, value_.getSize());
        writer.name(BoxCollaborationItem.FIELD_HAS_COLLABORATIONS);
        this.nullableBooleanAdapter.toJson(writer, value_.getHasCollaborations());
        writer.name(BoxCollaborationItem.FIELD_ALLOWED_INVITEE_ROLES);
        this.nullableListOfCollaborationRoleAdapter.toJson(writer, value_.getAllowedInviteeRoles());
        writer.name(BoxCollaborationItem.FIELD_DEFAULT_INVITEE_ROLE);
        this.nullableCollaborationRoleAdapter.toJson(writer, value_.getDefaultInviteeRole());
        writer.name(BoxCollaborationItem.FIELD_IS_EXTERNALLY_OWNED);
        this.nullableBooleanAdapter.toJson(writer, value_.isExternallyOwned());
        writer.name("comment_count");
        this.nullableLongAdapter.toJson(writer, value_.getCommentCount());
        writer.name("annotation_count");
        this.nullableLongAdapter.toJson(writer, value_.getAnnotationCount());
        writer.name("sha1");
        this.nullableStringAdapter.toJson(writer, value_.getSha1());
        writer.name("file_version");
        this.nullableFileVersionMiniDTOAdapter.toJson(writer, value_.getFileVersion());
        writer.name(BoxFile.FIELD_VERSION_NUMBER);
        this.nullableStringAdapter.toJson(writer, value_.getVersionNumber());
        writer.name(BoxItem.FIELD_ITEM_STATUS);
        this.nullableItemStatusAdapter.toJson(writer, value_.getItemStatus());
        writer.name(BoxFile.FIELD_LOCK);
        this.nullableFileLockDTOAdapter.toJson(writer, value_.getFileLock());
        writer.name(BoxFile.FIELD_REPRESENTATIONS);
        this.nullableRepresentationsDTOAdapter.toJson(writer, value_.getRepresentations());
        writer.name(BoxItem.FIELD_CLASSIFICATION);
        this.nullableClassificationDTOAdapter.toJson(writer, value_.getClassification());
        writer.name(BoxFile.FIELD_WATERMARK);
        this.nullableWatermarkDTOAdapter.toJson(writer, value_.getWatermark());
        writer.endObject();
    }
}
