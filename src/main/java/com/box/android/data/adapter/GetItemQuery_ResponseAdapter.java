package com.box.android.data.adapter;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.BooleanExpressions;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.box.android.data.GetItemQuery;
import com.box.android.data.datasource.gql.cache.GQLCacheConstants;
import com.box.android.data.type.DateTime;
import com.box.android.data.type.ItemType;
import com.box.android.data.type.adapter.ItemType_ResponseAdapter;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.box.androidsdk.content.models.BoxClassification;
import com.box.androidsdk.content.models.BoxItem;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GetItemQuery_ResponseAdapter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b%\bÆ\u0002\u0018\u00002\u00020\u0001:\"\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006&"}, d2 = {"Lcom/box/android/data/adapter/GetItemQuery_ResponseAdapter;", "", "<init>", "()V", "Data", "Item", "OnFile", "ItemCollectionConnection", "Edge", "Node", "Classification", "Watermark", "OwnedBy", "UpdatedBy", "Parent", "PermissionsV2Api", "FileVersion", "FileLock", "CreatedBy", "SharedLink", "OnFolder", "ItemCollectionConnection1", "Edge1", "Node1", "OwnedBy1", "UpdatedBy1", "Parent1", "PermissionsV2Api1", "SharedLink1", "OnWeblink", "ItemCollectionConnection2", "Edge2", "Node2", "OwnedBy2", "UpdatedBy2", "Parent2", "PermissionsV2Api2", "SharedLink2", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GetItemQuery_ResponseAdapter {
    public static final GetItemQuery_ResponseAdapter INSTANCE = new GetItemQuery_ResponseAdapter();

    /* JADX INFO: compiled from: GetItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetItemQuery_ResponseAdapter$Data;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetItemQuery$Data;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Data implements Adapter<GetItemQuery.Data> {
        public static final Data INSTANCE = new Data();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf("item");

        private Data() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetItemQuery.Data fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            GetItemQuery.Item item = null;
            while (reader.selectName(RESPONSE_NAMES) == 0) {
                item = (GetItemQuery.Item) Adapters.m11185nullable(Adapters.m11186obj(Item.INSTANCE, true)).fromJson(reader, customScalarAdapters);
            }
            return new GetItemQuery.Data(item);
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetItemQuery.Data value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("item");
            Adapters.m11185nullable(Adapters.m11186obj(Item.INSTANCE, true)).toJson(writer, customScalarAdapters, value.getItem());
        }
    }

    private GetItemQuery_ResponseAdapter() {
    }

    /* JADX INFO: compiled from: GetItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetItemQuery_ResponseAdapter$Item;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetItemQuery$Item;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Item implements Adapter<GetItemQuery.Item> {
        public static final Item INSTANCE = new Item();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf(GQLCacheConstants.TYPENAME_KEY);

        private Item() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetItemQuery.Item fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            GetItemQuery.OnFile onFileFromJson;
            GetItemQuery.OnFolder onFolderFromJson;
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            GetItemQuery.OnWeblink onWeblinkFromJson = null;
            String strFromJson = null;
            while (reader.selectName(RESPONSE_NAMES) == 0) {
                strFromJson = Adapters.StringAdapter.fromJson(reader, customScalarAdapters);
            }
            if (strFromJson == null) {
                throw new IllegalStateException("__typename was not found".toString());
            }
            if (BooleanExpressions.evaluate(BooleanExpressions.possibleTypes("File"), customScalarAdapters.getAdapterContext().variables(), strFromJson, customScalarAdapters.getAdapterContext(), null)) {
                reader.rewind();
                onFileFromJson = OnFile.INSTANCE.fromJson(reader, customScalarAdapters);
            } else {
                onFileFromJson = null;
            }
            if (BooleanExpressions.evaluate(BooleanExpressions.possibleTypes("Folder"), customScalarAdapters.getAdapterContext().variables(), strFromJson, customScalarAdapters.getAdapterContext(), null)) {
                reader.rewind();
                onFolderFromJson = OnFolder.INSTANCE.fromJson(reader, customScalarAdapters);
            } else {
                onFolderFromJson = null;
            }
            if (BooleanExpressions.evaluate(BooleanExpressions.possibleTypes("Weblink"), customScalarAdapters.getAdapterContext().variables(), strFromJson, customScalarAdapters.getAdapterContext(), null)) {
                reader.rewind();
                onWeblinkFromJson = OnWeblink.INSTANCE.fromJson(reader, customScalarAdapters);
            }
            return new GetItemQuery.Item(strFromJson, onFileFromJson, onFolderFromJson, onWeblinkFromJson);
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetItemQuery.Item value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name(GQLCacheConstants.TYPENAME_KEY);
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.get__typename());
            if (value.getOnFile() != null) {
                OnFile.INSTANCE.toJson(writer, customScalarAdapters, value.getOnFile());
            }
            if (value.getOnFolder() != null) {
                OnFolder.INSTANCE.toJson(writer, customScalarAdapters, value.getOnFolder());
            }
            if (value.getOnWeblink() != null) {
                OnWeblink.INSTANCE.toJson(writer, customScalarAdapters, value.getOnWeblink());
            }
        }
    }

    /* JADX INFO: compiled from: GetItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetItemQuery_ResponseAdapter$OnFile;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetItemQuery$OnFile;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class OnFile implements Adapter<GetItemQuery.OnFile> {
        public static final OnFile INSTANCE = new OnFile();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "type", "name", "createdAt", "updatedAt", "description", "contentCreatedAt", "contentUpdatedAt", "isRooted", "commentCount", "annotationCount", "itemCollectionConnection", BoxItem.FIELD_CLASSIFICATION, "size", "hasCollaborations", "isExternallyOwned", "sha1", "watermark", "ownedBy", "updatedBy", "parent", "permissionsV2Api", "fileVersion", "fileLock", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK});

        private OnFile() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Failed to find 'out' block for switch in B:4:0x003b. Please report as an issue. */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetItemQuery.OnFile fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            ItemType itemTypeFromJson = null;
            String strFromJson2 = null;
            Date date = null;
            Date date2 = null;
            String strFromJson3 = null;
            Date date3 = null;
            Date date4 = null;
            Boolean boolFromJson = null;
            Integer numFromJson = null;
            Integer numFromJson2 = null;
            GetItemQuery.ItemCollectionConnection itemCollectionConnection = null;
            GetItemQuery.Classification classification = null;
            Object objFromJson = null;
            Boolean boolFromJson2 = null;
            Boolean boolFromJson3 = null;
            String strFromJson4 = null;
            GetItemQuery.Watermark watermark = null;
            GetItemQuery.OwnedBy ownedBy = null;
            GetItemQuery.UpdatedBy updatedBy = null;
            GetItemQuery.Parent parent = null;
            GetItemQuery.PermissionsV2Api permissionsV2Api = null;
            GetItemQuery.FileVersion fileVersion = null;
            GetItemQuery.FileLock fileLock = null;
            GetItemQuery.SharedLink sharedLink = null;
            while (true) {
                switch (reader.selectName(RESPONSE_NAMES)) {
                    case 0:
                        itemTypeFromJson = itemTypeFromJson;
                        strFromJson = Adapters.StringAdapter.fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 1:
                        itemTypeFromJson = ItemType_ResponseAdapter.INSTANCE.fromJson(reader, customScalarAdapters);
                        break;
                    case 2:
                        itemTypeFromJson = itemTypeFromJson;
                        strFromJson2 = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 3:
                        itemTypeFromJson = itemTypeFromJson;
                        date = (Date) Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 4:
                        itemTypeFromJson = itemTypeFromJson;
                        date2 = (Date) Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 5:
                        itemTypeFromJson = itemTypeFromJson;
                        strFromJson3 = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 6:
                        itemTypeFromJson = itemTypeFromJson;
                        date3 = (Date) Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 7:
                        itemTypeFromJson = itemTypeFromJson;
                        date4 = (Date) Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 8:
                        itemTypeFromJson = itemTypeFromJson;
                        boolFromJson = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 9:
                        itemTypeFromJson = itemTypeFromJson;
                        numFromJson = Adapters.NullableIntAdapter.fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 10:
                        itemTypeFromJson = itemTypeFromJson;
                        numFromJson2 = Adapters.NullableIntAdapter.fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 11:
                        itemCollectionConnection = (GetItemQuery.ItemCollectionConnection) Adapters.m11185nullable(Adapters.m11187obj$default(ItemCollectionConnection.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        strFromJson = strFromJson;
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 12:
                        classification = (GetItemQuery.Classification) Adapters.m11185nullable(Adapters.m11187obj$default(Classification.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        strFromJson = strFromJson;
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 13:
                        objFromJson = Adapters.NullableAnyAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 14:
                        boolFromJson2 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 15:
                        boolFromJson3 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 16:
                        strFromJson4 = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 17:
                        watermark = (GetItemQuery.Watermark) Adapters.m11185nullable(Adapters.m11187obj$default(Watermark.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        strFromJson = strFromJson;
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 18:
                        ownedBy = (GetItemQuery.OwnedBy) Adapters.m11185nullable(Adapters.m11187obj$default(OwnedBy.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        strFromJson = strFromJson;
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 19:
                        updatedBy = (GetItemQuery.UpdatedBy) Adapters.m11185nullable(Adapters.m11187obj$default(UpdatedBy.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        strFromJson = strFromJson;
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 20:
                        parent = (GetItemQuery.Parent) Adapters.m11185nullable(Adapters.m11187obj$default(Parent.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        strFromJson = strFromJson;
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 21:
                        permissionsV2Api = (GetItemQuery.PermissionsV2Api) Adapters.m11185nullable(Adapters.m11187obj$default(PermissionsV2Api.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        strFromJson = strFromJson;
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 22:
                        fileVersion = (GetItemQuery.FileVersion) Adapters.m11185nullable(Adapters.m11187obj$default(FileVersion.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        strFromJson = strFromJson;
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 23:
                        fileLock = (GetItemQuery.FileLock) Adapters.m11185nullable(Adapters.m11187obj$default(FileLock.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        strFromJson = strFromJson;
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 24:
                        sharedLink = (GetItemQuery.SharedLink) Adapters.m11185nullable(Adapters.m11187obj$default(SharedLink.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        strFromJson = strFromJson;
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                }
                Intrinsics.checkNotNull(strFromJson);
                Intrinsics.checkNotNull(itemTypeFromJson);
                return new GetItemQuery.OnFile(strFromJson, itemTypeFromJson, strFromJson2, date, date2, strFromJson3, date3, date4, boolFromJson, numFromJson, numFromJson2, itemCollectionConnection, classification, objFromJson, boolFromJson2, boolFromJson3, strFromJson4, watermark, ownedBy, updatedBy, parent, permissionsV2Api, fileVersion, fileLock, sharedLink);
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetItemQuery.OnFile value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getId());
            writer.name("type");
            ItemType_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.getType());
            writer.name("name");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getName());
            writer.name("createdAt");
            Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).toJson(writer, customScalarAdapters, value.getCreatedAt());
            writer.name("updatedAt");
            Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).toJson(writer, customScalarAdapters, value.getUpdatedAt());
            writer.name("description");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getDescription());
            writer.name("contentCreatedAt");
            Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).toJson(writer, customScalarAdapters, value.getContentCreatedAt());
            writer.name("contentUpdatedAt");
            Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).toJson(writer, customScalarAdapters, value.getContentUpdatedAt());
            writer.name("isRooted");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.isRooted());
            writer.name("commentCount");
            Adapters.NullableIntAdapter.toJson(writer, customScalarAdapters, value.getCommentCount());
            writer.name("annotationCount");
            Adapters.NullableIntAdapter.toJson(writer, customScalarAdapters, value.getAnnotationCount());
            writer.name("itemCollectionConnection");
            Adapters.m11185nullable(Adapters.m11187obj$default(ItemCollectionConnection.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getItemCollectionConnection());
            writer.name(BoxItem.FIELD_CLASSIFICATION);
            Adapters.m11185nullable(Adapters.m11187obj$default(Classification.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getClassification());
            writer.name("size");
            Adapters.NullableAnyAdapter.toJson(writer, customScalarAdapters, value.getSize());
            writer.name("hasCollaborations");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getHasCollaborations());
            writer.name("isExternallyOwned");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.isExternallyOwned());
            writer.name("sha1");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getSha1());
            writer.name("watermark");
            Adapters.m11185nullable(Adapters.m11187obj$default(Watermark.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getWatermark());
            writer.name("ownedBy");
            Adapters.m11185nullable(Adapters.m11187obj$default(OwnedBy.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getOwnedBy());
            writer.name("updatedBy");
            Adapters.m11185nullable(Adapters.m11187obj$default(UpdatedBy.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getUpdatedBy());
            writer.name("parent");
            Adapters.m11185nullable(Adapters.m11187obj$default(Parent.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getParent());
            writer.name("permissionsV2Api");
            Adapters.m11185nullable(Adapters.m11187obj$default(PermissionsV2Api.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getPermissionsV2Api());
            writer.name("fileVersion");
            Adapters.m11185nullable(Adapters.m11187obj$default(FileVersion.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getFileVersion());
            writer.name("fileLock");
            Adapters.m11185nullable(Adapters.m11187obj$default(FileLock.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getFileLock());
            writer.name(BoxNoteConstants.NOTES_BUILDER_SHARED_LINK);
            Adapters.m11185nullable(Adapters.m11187obj$default(SharedLink.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getSharedLink());
        }
    }

    /* JADX INFO: compiled from: GetItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetItemQuery_ResponseAdapter$ItemCollectionConnection;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetItemQuery$ItemCollectionConnection;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ItemCollectionConnection implements Adapter<GetItemQuery.ItemCollectionConnection> {
        public static final ItemCollectionConnection INSTANCE = new ItemCollectionConnection();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf("edges");

        private ItemCollectionConnection() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetItemQuery.ItemCollectionConnection fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            List listFromJson = null;
            while (reader.selectName(RESPONSE_NAMES) == 0) {
                listFromJson = Adapters.m11184list(Adapters.m11187obj$default(Edge.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
            }
            Intrinsics.checkNotNull(listFromJson);
            return new GetItemQuery.ItemCollectionConnection(listFromJson);
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetItemQuery.ItemCollectionConnection value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("edges");
            Adapters.m11184list(Adapters.m11187obj$default(Edge.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, (List) value.getEdges());
        }
    }

    /* JADX INFO: compiled from: GetItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetItemQuery_ResponseAdapter$Edge;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetItemQuery$Edge;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Edge implements Adapter<GetItemQuery.Edge> {
        public static final Edge INSTANCE = new Edge();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "node"});

        private Edge() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetItemQuery.Edge fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            GetItemQuery.Node node = null;
            while (true) {
                int iSelectName = reader.selectName(RESPONSE_NAMES);
                if (iSelectName == 0) {
                    strFromJson = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 1) {
                    node = (GetItemQuery.Node) Adapters.m11187obj$default(Node.INSTANCE, false, 1, null).fromJson(reader, customScalarAdapters);
                } else {
                    Intrinsics.checkNotNull(node);
                    return new GetItemQuery.Edge(strFromJson, node);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetItemQuery.Edge value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getId());
            writer.name("node");
            Adapters.m11187obj$default(Node.INSTANCE, false, 1, null).toJson(writer, customScalarAdapters, value.getNode());
        }
    }

    /* JADX INFO: compiled from: GetItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetItemQuery_ResponseAdapter$Node;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetItemQuery$Node;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Node implements Adapter<GetItemQuery.Node> {
        public static final Node INSTANCE = new Node();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "name", "collectionType"});

        private Node() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetItemQuery.Node fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            String strFromJson2 = null;
            String strFromJson3 = null;
            while (true) {
                int iSelectName = reader.selectName(RESPONSE_NAMES);
                if (iSelectName == 0) {
                    strFromJson = Adapters.StringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 1) {
                    strFromJson2 = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 2) {
                    strFromJson3 = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                } else {
                    Intrinsics.checkNotNull(strFromJson);
                    return new GetItemQuery.Node(strFromJson, strFromJson2, strFromJson3);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetItemQuery.Node value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getId());
            writer.name("name");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getName());
            writer.name("collectionType");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getCollectionType());
        }
    }

    /* JADX INFO: compiled from: GetItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetItemQuery_ResponseAdapter$Classification;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetItemQuery$Classification;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Classification implements Adapter<GetItemQuery.Classification> {
        public static final Classification INSTANCE = new Classification();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"name", "color", BoxClassification.FIELD_DEFINITION});

        private Classification() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetItemQuery.Classification fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            String strFromJson2 = null;
            String strFromJson3 = null;
            while (true) {
                int iSelectName = reader.selectName(RESPONSE_NAMES);
                if (iSelectName == 0) {
                    strFromJson = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 1) {
                    strFromJson2 = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 2) {
                    strFromJson3 = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                } else {
                    return new GetItemQuery.Classification(strFromJson, strFromJson2, strFromJson3);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetItemQuery.Classification value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("name");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getName());
            writer.name("color");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getColor());
            writer.name(BoxClassification.FIELD_DEFINITION);
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getDefinition());
        }
    }

    /* JADX INFO: compiled from: GetItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetItemQuery_ResponseAdapter$Watermark;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetItemQuery$Watermark;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Watermark implements Adapter<GetItemQuery.Watermark> {
        public static final Watermark INSTANCE = new Watermark();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf("isWatermarked");

        private Watermark() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetItemQuery.Watermark fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Boolean boolFromJson = null;
            while (reader.selectName(RESPONSE_NAMES) == 0) {
                boolFromJson = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
            }
            return new GetItemQuery.Watermark(boolFromJson);
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetItemQuery.Watermark value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("isWatermarked");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.isWatermarked());
        }
    }

    /* JADX INFO: compiled from: GetItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetItemQuery_ResponseAdapter$OwnedBy;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetItemQuery$OwnedBy;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class OwnedBy implements Adapter<GetItemQuery.OwnedBy> {
        public static final OwnedBy INSTANCE = new OwnedBy();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "name"});

        private OwnedBy() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetItemQuery.OwnedBy fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            String strFromJson2 = null;
            while (true) {
                int iSelectName = reader.selectName(RESPONSE_NAMES);
                if (iSelectName == 0) {
                    strFromJson = Adapters.StringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 1) {
                    strFromJson2 = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                } else {
                    Intrinsics.checkNotNull(strFromJson);
                    return new GetItemQuery.OwnedBy(strFromJson, strFromJson2);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetItemQuery.OwnedBy value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getId());
            writer.name("name");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getName());
        }
    }

    /* JADX INFO: compiled from: GetItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetItemQuery_ResponseAdapter$UpdatedBy;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetItemQuery$UpdatedBy;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class UpdatedBy implements Adapter<GetItemQuery.UpdatedBy> {
        public static final UpdatedBy INSTANCE = new UpdatedBy();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "name"});

        private UpdatedBy() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetItemQuery.UpdatedBy fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            String strFromJson2 = null;
            while (true) {
                int iSelectName = reader.selectName(RESPONSE_NAMES);
                if (iSelectName == 0) {
                    strFromJson = Adapters.StringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 1) {
                    strFromJson2 = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                } else {
                    Intrinsics.checkNotNull(strFromJson);
                    return new GetItemQuery.UpdatedBy(strFromJson, strFromJson2);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetItemQuery.UpdatedBy value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getId());
            writer.name("name");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getName());
        }
    }

    /* JADX INFO: compiled from: GetItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetItemQuery_ResponseAdapter$Parent;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetItemQuery$Parent;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Parent implements Adapter<GetItemQuery.Parent> {
        public static final Parent INSTANCE = new Parent();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "name"});

        private Parent() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetItemQuery.Parent fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            String strFromJson2 = null;
            while (true) {
                int iSelectName = reader.selectName(RESPONSE_NAMES);
                if (iSelectName == 0) {
                    strFromJson = Adapters.StringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 1) {
                    strFromJson2 = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                } else {
                    Intrinsics.checkNotNull(strFromJson);
                    return new GetItemQuery.Parent(strFromJson, strFromJson2);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetItemQuery.Parent value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getId());
            writer.name("name");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getName());
        }
    }

    /* JADX INFO: compiled from: GetItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetItemQuery_ResponseAdapter$PermissionsV2Api;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetItemQuery$PermissionsV2Api;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class PermissionsV2Api implements Adapter<GetItemQuery.PermissionsV2Api> {
        public static final PermissionsV2Api INSTANCE = new PermissionsV2Api();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"canComment", "canDelete", "canDownload", "canInviteCollaborator", "canPreview", "canRename", "canSetShareAccess", "canShare", "canUpload", "canViewAnnotations", "canCreateAnnotations"});

        private PermissionsV2Api() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetItemQuery.PermissionsV2Api fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Boolean boolFromJson = null;
            Boolean boolFromJson2 = null;
            Boolean boolFromJson3 = null;
            Boolean boolFromJson4 = null;
            Boolean boolFromJson5 = null;
            Boolean boolFromJson6 = null;
            Boolean boolFromJson7 = null;
            Boolean boolFromJson8 = null;
            Boolean boolFromJson9 = null;
            Boolean boolFromJson10 = null;
            Boolean boolFromJson11 = null;
            while (true) {
                switch (reader.selectName(RESPONSE_NAMES)) {
                    case 0:
                        boolFromJson = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 1:
                        boolFromJson2 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 2:
                        boolFromJson3 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 3:
                        boolFromJson4 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 4:
                        boolFromJson5 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 5:
                        boolFromJson6 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 6:
                        boolFromJson7 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 7:
                        boolFromJson8 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 8:
                        boolFromJson9 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 9:
                        boolFromJson10 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 10:
                        boolFromJson11 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    default:
                        return new GetItemQuery.PermissionsV2Api(boolFromJson, boolFromJson2, boolFromJson3, boolFromJson4, boolFromJson5, boolFromJson6, boolFromJson7, boolFromJson8, boolFromJson9, boolFromJson10, boolFromJson11);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetItemQuery.PermissionsV2Api value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("canComment");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getCanComment());
            writer.name("canDelete");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getCanDelete());
            writer.name("canDownload");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getCanDownload());
            writer.name("canInviteCollaborator");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getCanInviteCollaborator());
            writer.name("canPreview");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getCanPreview());
            writer.name("canRename");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getCanRename());
            writer.name("canSetShareAccess");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getCanSetShareAccess());
            writer.name("canShare");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getCanShare());
            writer.name("canUpload");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getCanUpload());
            writer.name("canViewAnnotations");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getCanViewAnnotations());
            writer.name("canCreateAnnotations");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getCanCreateAnnotations());
        }
    }

    /* JADX INFO: compiled from: GetItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetItemQuery_ResponseAdapter$FileVersion;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetItemQuery$FileVersion;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class FileVersion implements Adapter<GetItemQuery.FileVersion> {
        public static final FileVersion INSTANCE = new FileVersion();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "sha1"});

        private FileVersion() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetItemQuery.FileVersion fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            String strFromJson2 = null;
            while (true) {
                int iSelectName = reader.selectName(RESPONSE_NAMES);
                if (iSelectName == 0) {
                    strFromJson = Adapters.StringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 1) {
                    strFromJson2 = Adapters.StringAdapter.fromJson(reader, customScalarAdapters);
                } else {
                    Intrinsics.checkNotNull(strFromJson);
                    Intrinsics.checkNotNull(strFromJson2);
                    return new GetItemQuery.FileVersion(strFromJson, strFromJson2);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetItemQuery.FileVersion value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getId());
            writer.name("sha1");
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getSha1());
        }
    }

    /* JADX INFO: compiled from: GetItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetItemQuery_ResponseAdapter$FileLock;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetItemQuery$FileLock;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class FileLock implements Adapter<GetItemQuery.FileLock> {
        public static final FileLock INSTANCE = new FileLock();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "appType", "createdAt", "createdBy", "expiresAt", "isDownloadPrevented"});

        private FileLock() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetItemQuery.FileLock fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            String strFromJson2 = null;
            Date date = null;
            GetItemQuery.CreatedBy createdBy = null;
            Date date2 = null;
            Boolean boolFromJson = null;
            while (true) {
                int iSelectName = reader.selectName(RESPONSE_NAMES);
                if (iSelectName == 0) {
                    strFromJson = Adapters.StringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 1) {
                    strFromJson2 = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 2) {
                    date = (Date) Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 3) {
                    createdBy = (GetItemQuery.CreatedBy) Adapters.m11185nullable(Adapters.m11187obj$default(CreatedBy.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 4) {
                    date2 = (Date) Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 5) {
                    boolFromJson = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                } else {
                    Intrinsics.checkNotNull(strFromJson);
                    return new GetItemQuery.FileLock(strFromJson, strFromJson2, date, createdBy, date2, boolFromJson);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetItemQuery.FileLock value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getId());
            writer.name("appType");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getAppType());
            writer.name("createdAt");
            Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).toJson(writer, customScalarAdapters, value.getCreatedAt());
            writer.name("createdBy");
            Adapters.m11185nullable(Adapters.m11187obj$default(CreatedBy.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getCreatedBy());
            writer.name("expiresAt");
            Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).toJson(writer, customScalarAdapters, value.getExpiresAt());
            writer.name("isDownloadPrevented");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.isDownloadPrevented());
        }
    }

    /* JADX INFO: compiled from: GetItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetItemQuery_ResponseAdapter$CreatedBy;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetItemQuery$CreatedBy;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class CreatedBy implements Adapter<GetItemQuery.CreatedBy> {
        public static final CreatedBy INSTANCE = new CreatedBy();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "name", "login"});

        private CreatedBy() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetItemQuery.CreatedBy fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            String strFromJson2 = null;
            String strFromJson3 = null;
            while (true) {
                int iSelectName = reader.selectName(RESPONSE_NAMES);
                if (iSelectName == 0) {
                    strFromJson = Adapters.StringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 1) {
                    strFromJson2 = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 2) {
                    strFromJson3 = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                } else {
                    Intrinsics.checkNotNull(strFromJson);
                    return new GetItemQuery.CreatedBy(strFromJson, strFromJson2, strFromJson3);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetItemQuery.CreatedBy value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getId());
            writer.name("name");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getName());
            writer.name("login");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getLogin());
        }
    }

    /* JADX INFO: compiled from: GetItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetItemQuery_ResponseAdapter$SharedLink;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetItemQuery$SharedLink;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class SharedLink implements Adapter<GetItemQuery.SharedLink> {
        public static final SharedLink INSTANCE = new SharedLink();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"url", "effectiveAccess", "effectivePermission", "isPasswordEnabled", "unsharedAt", "canDownload"});

        private SharedLink() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetItemQuery.SharedLink fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            String strFromJson2 = null;
            String strFromJson3 = null;
            Boolean boolFromJson = null;
            Date date = null;
            Boolean boolFromJson2 = null;
            while (true) {
                int iSelectName = reader.selectName(RESPONSE_NAMES);
                if (iSelectName == 0) {
                    strFromJson = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 1) {
                    strFromJson2 = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 2) {
                    strFromJson3 = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 3) {
                    boolFromJson = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 4) {
                    date = (Date) Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 5) {
                    boolFromJson2 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                } else {
                    return new GetItemQuery.SharedLink(strFromJson, strFromJson2, strFromJson3, boolFromJson, date, boolFromJson2);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetItemQuery.SharedLink value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("url");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getUrl());
            writer.name("effectiveAccess");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getEffectiveAccess());
            writer.name("effectivePermission");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getEffectivePermission());
            writer.name("isPasswordEnabled");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.isPasswordEnabled());
            writer.name("unsharedAt");
            Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).toJson(writer, customScalarAdapters, value.getUnsharedAt());
            writer.name("canDownload");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getCanDownload());
        }
    }

    /* JADX INFO: compiled from: GetItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetItemQuery_ResponseAdapter$OnFolder;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetItemQuery$OnFolder;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class OnFolder implements Adapter<GetItemQuery.OnFolder> {
        public static final OnFolder INSTANCE = new OnFolder();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "type", "name", "createdAt", "description", "updatedAt", "contentCreatedAt", "contentUpdatedAt", "isRooted", "itemCollectionConnection", "size", "hasCollaborations", "isExternallyOwned", "ownedBy", "updatedBy", "parent", "permissionsV2Api", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK});

        private OnFolder() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Failed to find 'out' block for switch in B:4:0x002d. Please report as an issue. */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetItemQuery.OnFolder fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            ItemType itemTypeFromJson = null;
            String strFromJson2 = null;
            Date date = null;
            String strFromJson3 = null;
            Date date2 = null;
            Date date3 = null;
            Date date4 = null;
            Boolean boolFromJson = null;
            GetItemQuery.ItemCollectionConnection1 itemCollectionConnection1 = null;
            Object objFromJson = null;
            Boolean boolFromJson2 = null;
            Boolean boolFromJson3 = null;
            GetItemQuery.OwnedBy1 ownedBy1 = null;
            GetItemQuery.UpdatedBy1 updatedBy1 = null;
            GetItemQuery.Parent1 parent1 = null;
            GetItemQuery.PermissionsV2Api1 permissionsV2Api1 = null;
            GetItemQuery.SharedLink1 sharedLink1 = null;
            while (true) {
                switch (reader.selectName(RESPONSE_NAMES)) {
                    case 0:
                        itemTypeFromJson = itemTypeFromJson;
                        strFromJson = Adapters.StringAdapter.fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 1:
                        itemTypeFromJson = ItemType_ResponseAdapter.INSTANCE.fromJson(reader, customScalarAdapters);
                        break;
                    case 2:
                        itemTypeFromJson = itemTypeFromJson;
                        strFromJson2 = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 3:
                        itemTypeFromJson = itemTypeFromJson;
                        date = (Date) Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 4:
                        itemTypeFromJson = itemTypeFromJson;
                        strFromJson3 = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 5:
                        itemTypeFromJson = itemTypeFromJson;
                        date2 = (Date) Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 6:
                        itemTypeFromJson = itemTypeFromJson;
                        date3 = (Date) Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 7:
                        itemTypeFromJson = itemTypeFromJson;
                        date4 = (Date) Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 8:
                        itemTypeFromJson = itemTypeFromJson;
                        boolFromJson = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 9:
                        itemCollectionConnection1 = (GetItemQuery.ItemCollectionConnection1) Adapters.m11185nullable(Adapters.m11187obj$default(ItemCollectionConnection1.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        strFromJson = strFromJson;
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 10:
                        objFromJson = Adapters.NullableAnyAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 11:
                        boolFromJson2 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 12:
                        boolFromJson3 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 13:
                        ownedBy1 = (GetItemQuery.OwnedBy1) Adapters.m11185nullable(Adapters.m11187obj$default(OwnedBy1.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        strFromJson = strFromJson;
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 14:
                        updatedBy1 = (GetItemQuery.UpdatedBy1) Adapters.m11185nullable(Adapters.m11187obj$default(UpdatedBy1.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        strFromJson = strFromJson;
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 15:
                        parent1 = (GetItemQuery.Parent1) Adapters.m11185nullable(Adapters.m11187obj$default(Parent1.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        strFromJson = strFromJson;
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 16:
                        permissionsV2Api1 = (GetItemQuery.PermissionsV2Api1) Adapters.m11185nullable(Adapters.m11187obj$default(PermissionsV2Api1.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        strFromJson = strFromJson;
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 17:
                        sharedLink1 = (GetItemQuery.SharedLink1) Adapters.m11185nullable(Adapters.m11187obj$default(SharedLink1.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        strFromJson = strFromJson;
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                }
                Intrinsics.checkNotNull(strFromJson);
                Intrinsics.checkNotNull(itemTypeFromJson);
                return new GetItemQuery.OnFolder(strFromJson, itemTypeFromJson, strFromJson2, date, strFromJson3, date2, date3, date4, boolFromJson, itemCollectionConnection1, objFromJson, boolFromJson2, boolFromJson3, ownedBy1, updatedBy1, parent1, permissionsV2Api1, sharedLink1);
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetItemQuery.OnFolder value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getId());
            writer.name("type");
            ItemType_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.getType());
            writer.name("name");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getName());
            writer.name("createdAt");
            Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).toJson(writer, customScalarAdapters, value.getCreatedAt());
            writer.name("description");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getDescription());
            writer.name("updatedAt");
            Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).toJson(writer, customScalarAdapters, value.getUpdatedAt());
            writer.name("contentCreatedAt");
            Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).toJson(writer, customScalarAdapters, value.getContentCreatedAt());
            writer.name("contentUpdatedAt");
            Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).toJson(writer, customScalarAdapters, value.getContentUpdatedAt());
            writer.name("isRooted");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.isRooted());
            writer.name("itemCollectionConnection");
            Adapters.m11185nullable(Adapters.m11187obj$default(ItemCollectionConnection1.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getItemCollectionConnection());
            writer.name("size");
            Adapters.NullableAnyAdapter.toJson(writer, customScalarAdapters, value.getSize());
            writer.name("hasCollaborations");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getHasCollaborations());
            writer.name("isExternallyOwned");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.isExternallyOwned());
            writer.name("ownedBy");
            Adapters.m11185nullable(Adapters.m11187obj$default(OwnedBy1.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getOwnedBy());
            writer.name("updatedBy");
            Adapters.m11185nullable(Adapters.m11187obj$default(UpdatedBy1.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getUpdatedBy());
            writer.name("parent");
            Adapters.m11185nullable(Adapters.m11187obj$default(Parent1.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getParent());
            writer.name("permissionsV2Api");
            Adapters.m11185nullable(Adapters.m11187obj$default(PermissionsV2Api1.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getPermissionsV2Api());
            writer.name(BoxNoteConstants.NOTES_BUILDER_SHARED_LINK);
            Adapters.m11185nullable(Adapters.m11187obj$default(SharedLink1.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getSharedLink());
        }
    }

    /* JADX INFO: compiled from: GetItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetItemQuery_ResponseAdapter$ItemCollectionConnection1;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetItemQuery$ItemCollectionConnection1;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ItemCollectionConnection1 implements Adapter<GetItemQuery.ItemCollectionConnection1> {
        public static final ItemCollectionConnection1 INSTANCE = new ItemCollectionConnection1();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf("edges");

        private ItemCollectionConnection1() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetItemQuery.ItemCollectionConnection1 fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            List listFromJson = null;
            while (reader.selectName(RESPONSE_NAMES) == 0) {
                listFromJson = Adapters.m11184list(Adapters.m11187obj$default(Edge1.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
            }
            Intrinsics.checkNotNull(listFromJson);
            return new GetItemQuery.ItemCollectionConnection1(listFromJson);
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetItemQuery.ItemCollectionConnection1 value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("edges");
            Adapters.m11184list(Adapters.m11187obj$default(Edge1.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, (List) value.getEdges());
        }
    }

    /* JADX INFO: compiled from: GetItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetItemQuery_ResponseAdapter$Edge1;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetItemQuery$Edge1;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Edge1 implements Adapter<GetItemQuery.Edge1> {
        public static final Edge1 INSTANCE = new Edge1();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "node"});

        private Edge1() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetItemQuery.Edge1 fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            GetItemQuery.Node1 node1 = null;
            while (true) {
                int iSelectName = reader.selectName(RESPONSE_NAMES);
                if (iSelectName == 0) {
                    strFromJson = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 1) {
                    node1 = (GetItemQuery.Node1) Adapters.m11187obj$default(Node1.INSTANCE, false, 1, null).fromJson(reader, customScalarAdapters);
                } else {
                    Intrinsics.checkNotNull(node1);
                    return new GetItemQuery.Edge1(strFromJson, node1);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetItemQuery.Edge1 value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getId());
            writer.name("node");
            Adapters.m11187obj$default(Node1.INSTANCE, false, 1, null).toJson(writer, customScalarAdapters, value.getNode());
        }
    }

    /* JADX INFO: compiled from: GetItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetItemQuery_ResponseAdapter$Node1;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetItemQuery$Node1;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Node1 implements Adapter<GetItemQuery.Node1> {
        public static final Node1 INSTANCE = new Node1();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "name", "collectionType"});

        private Node1() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetItemQuery.Node1 fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            String strFromJson2 = null;
            String strFromJson3 = null;
            while (true) {
                int iSelectName = reader.selectName(RESPONSE_NAMES);
                if (iSelectName == 0) {
                    strFromJson = Adapters.StringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 1) {
                    strFromJson2 = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 2) {
                    strFromJson3 = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                } else {
                    Intrinsics.checkNotNull(strFromJson);
                    return new GetItemQuery.Node1(strFromJson, strFromJson2, strFromJson3);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetItemQuery.Node1 value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getId());
            writer.name("name");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getName());
            writer.name("collectionType");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getCollectionType());
        }
    }

    /* JADX INFO: compiled from: GetItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetItemQuery_ResponseAdapter$OwnedBy1;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetItemQuery$OwnedBy1;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class OwnedBy1 implements Adapter<GetItemQuery.OwnedBy1> {
        public static final OwnedBy1 INSTANCE = new OwnedBy1();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "name"});

        private OwnedBy1() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetItemQuery.OwnedBy1 fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            String strFromJson2 = null;
            while (true) {
                int iSelectName = reader.selectName(RESPONSE_NAMES);
                if (iSelectName == 0) {
                    strFromJson = Adapters.StringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 1) {
                    strFromJson2 = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                } else {
                    Intrinsics.checkNotNull(strFromJson);
                    return new GetItemQuery.OwnedBy1(strFromJson, strFromJson2);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetItemQuery.OwnedBy1 value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getId());
            writer.name("name");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getName());
        }
    }

    /* JADX INFO: compiled from: GetItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetItemQuery_ResponseAdapter$UpdatedBy1;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetItemQuery$UpdatedBy1;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class UpdatedBy1 implements Adapter<GetItemQuery.UpdatedBy1> {
        public static final UpdatedBy1 INSTANCE = new UpdatedBy1();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "name"});

        private UpdatedBy1() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetItemQuery.UpdatedBy1 fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            String strFromJson2 = null;
            while (true) {
                int iSelectName = reader.selectName(RESPONSE_NAMES);
                if (iSelectName == 0) {
                    strFromJson = Adapters.StringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 1) {
                    strFromJson2 = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                } else {
                    Intrinsics.checkNotNull(strFromJson);
                    return new GetItemQuery.UpdatedBy1(strFromJson, strFromJson2);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetItemQuery.UpdatedBy1 value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getId());
            writer.name("name");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getName());
        }
    }

    /* JADX INFO: compiled from: GetItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetItemQuery_ResponseAdapter$Parent1;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetItemQuery$Parent1;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Parent1 implements Adapter<GetItemQuery.Parent1> {
        public static final Parent1 INSTANCE = new Parent1();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "name"});

        private Parent1() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetItemQuery.Parent1 fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            String strFromJson2 = null;
            while (true) {
                int iSelectName = reader.selectName(RESPONSE_NAMES);
                if (iSelectName == 0) {
                    strFromJson = Adapters.StringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 1) {
                    strFromJson2 = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                } else {
                    Intrinsics.checkNotNull(strFromJson);
                    return new GetItemQuery.Parent1(strFromJson, strFromJson2);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetItemQuery.Parent1 value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getId());
            writer.name("name");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getName());
        }
    }

    /* JADX INFO: compiled from: GetItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetItemQuery_ResponseAdapter$PermissionsV2Api1;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetItemQuery$PermissionsV2Api1;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class PermissionsV2Api1 implements Adapter<GetItemQuery.PermissionsV2Api1> {
        public static final PermissionsV2Api1 INSTANCE = new PermissionsV2Api1();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"canDelete", "canDownload", "canInviteCollaborator", "canRename", "canSetShareAccess", "canShare", "canUpload", "canPreview", "canComment", "canViewAnnotations", "canCreateAnnotations"});

        private PermissionsV2Api1() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetItemQuery.PermissionsV2Api1 fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Boolean boolFromJson = null;
            Boolean boolFromJson2 = null;
            Boolean boolFromJson3 = null;
            Boolean boolFromJson4 = null;
            Boolean boolFromJson5 = null;
            Boolean boolFromJson6 = null;
            Boolean boolFromJson7 = null;
            Boolean boolFromJson8 = null;
            Boolean boolFromJson9 = null;
            Boolean boolFromJson10 = null;
            Boolean boolFromJson11 = null;
            while (true) {
                switch (reader.selectName(RESPONSE_NAMES)) {
                    case 0:
                        boolFromJson = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 1:
                        boolFromJson2 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 2:
                        boolFromJson3 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 3:
                        boolFromJson4 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 4:
                        boolFromJson5 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 5:
                        boolFromJson6 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 6:
                        boolFromJson7 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 7:
                        boolFromJson8 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 8:
                        boolFromJson9 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 9:
                        boolFromJson10 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 10:
                        boolFromJson11 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    default:
                        return new GetItemQuery.PermissionsV2Api1(boolFromJson, boolFromJson2, boolFromJson3, boolFromJson4, boolFromJson5, boolFromJson6, boolFromJson7, boolFromJson8, boolFromJson9, boolFromJson10, boolFromJson11);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetItemQuery.PermissionsV2Api1 value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("canDelete");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getCanDelete());
            writer.name("canDownload");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getCanDownload());
            writer.name("canInviteCollaborator");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getCanInviteCollaborator());
            writer.name("canRename");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getCanRename());
            writer.name("canSetShareAccess");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getCanSetShareAccess());
            writer.name("canShare");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getCanShare());
            writer.name("canUpload");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getCanUpload());
            writer.name("canPreview");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getCanPreview());
            writer.name("canComment");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getCanComment());
            writer.name("canViewAnnotations");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getCanViewAnnotations());
            writer.name("canCreateAnnotations");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getCanCreateAnnotations());
        }
    }

    /* JADX INFO: compiled from: GetItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetItemQuery_ResponseAdapter$SharedLink1;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetItemQuery$SharedLink1;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class SharedLink1 implements Adapter<GetItemQuery.SharedLink1> {
        public static final SharedLink1 INSTANCE = new SharedLink1();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"url", "effectiveAccess", "effectivePermission", "isPasswordEnabled", "unsharedAt", "canDownload"});

        private SharedLink1() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetItemQuery.SharedLink1 fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            String strFromJson2 = null;
            String strFromJson3 = null;
            Boolean boolFromJson = null;
            Date date = null;
            Boolean boolFromJson2 = null;
            while (true) {
                int iSelectName = reader.selectName(RESPONSE_NAMES);
                if (iSelectName == 0) {
                    strFromJson = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 1) {
                    strFromJson2 = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 2) {
                    strFromJson3 = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 3) {
                    boolFromJson = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 4) {
                    date = (Date) Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 5) {
                    boolFromJson2 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                } else {
                    return new GetItemQuery.SharedLink1(strFromJson, strFromJson2, strFromJson3, boolFromJson, date, boolFromJson2);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetItemQuery.SharedLink1 value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("url");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getUrl());
            writer.name("effectiveAccess");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getEffectiveAccess());
            writer.name("effectivePermission");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getEffectivePermission());
            writer.name("isPasswordEnabled");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.isPasswordEnabled());
            writer.name("unsharedAt");
            Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).toJson(writer, customScalarAdapters, value.getUnsharedAt());
            writer.name("canDownload");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getCanDownload());
        }
    }

    /* JADX INFO: compiled from: GetItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetItemQuery_ResponseAdapter$OnWeblink;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetItemQuery$OnWeblink;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class OnWeblink implements Adapter<GetItemQuery.OnWeblink> {
        public static final OnWeblink INSTANCE = new OnWeblink();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "type", "name", "createdAt", "description", "updatedAt", "isRooted", "itemCollectionConnection", "url", "ownedBy", "updatedBy", "parent", "permissionsV2Api", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK});

        private OnWeblink() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0025. Please report as an issue. */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetItemQuery.OnWeblink fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            ItemType itemTypeFromJson = null;
            String strFromJson2 = null;
            Date date = null;
            String strFromJson3 = null;
            Date date2 = null;
            Boolean boolFromJson = null;
            GetItemQuery.ItemCollectionConnection2 itemCollectionConnection2 = null;
            Object objFromJson = null;
            GetItemQuery.OwnedBy2 ownedBy2 = null;
            GetItemQuery.UpdatedBy2 updatedBy2 = null;
            GetItemQuery.Parent2 parent2 = null;
            GetItemQuery.PermissionsV2Api2 permissionsV2Api2 = null;
            GetItemQuery.SharedLink2 sharedLink2 = null;
            while (true) {
                switch (reader.selectName(RESPONSE_NAMES)) {
                    case 0:
                        strFromJson = Adapters.StringAdapter.fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 1:
                        itemTypeFromJson = ItemType_ResponseAdapter.INSTANCE.fromJson(reader, customScalarAdapters);
                        break;
                    case 2:
                        strFromJson2 = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 3:
                        date = (Date) Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 4:
                        strFromJson3 = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 5:
                        date2 = (Date) Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 6:
                        boolFromJson = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 7:
                        itemCollectionConnection2 = (GetItemQuery.ItemCollectionConnection2) Adapters.m11185nullable(Adapters.m11187obj$default(ItemCollectionConnection2.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        strFromJson = strFromJson;
                        break;
                    case 8:
                        objFromJson = Adapters.NullableAnyAdapter.fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 9:
                        ownedBy2 = (GetItemQuery.OwnedBy2) Adapters.m11185nullable(Adapters.m11187obj$default(OwnedBy2.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        strFromJson = strFromJson;
                        break;
                    case 10:
                        updatedBy2 = (GetItemQuery.UpdatedBy2) Adapters.m11185nullable(Adapters.m11187obj$default(UpdatedBy2.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        strFromJson = strFromJson;
                        break;
                    case 11:
                        parent2 = (GetItemQuery.Parent2) Adapters.m11185nullable(Adapters.m11187obj$default(Parent2.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        strFromJson = strFromJson;
                        break;
                    case 12:
                        permissionsV2Api2 = (GetItemQuery.PermissionsV2Api2) Adapters.m11185nullable(Adapters.m11187obj$default(PermissionsV2Api2.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        strFromJson = strFromJson;
                        break;
                    case 13:
                        sharedLink2 = (GetItemQuery.SharedLink2) Adapters.m11185nullable(Adapters.m11187obj$default(SharedLink2.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        strFromJson = strFromJson;
                        break;
                }
                Intrinsics.checkNotNull(strFromJson);
                Intrinsics.checkNotNull(itemTypeFromJson);
                return new GetItemQuery.OnWeblink(strFromJson, itemTypeFromJson, strFromJson2, date, strFromJson3, date2, boolFromJson, itemCollectionConnection2, objFromJson, ownedBy2, updatedBy2, parent2, permissionsV2Api2, sharedLink2);
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetItemQuery.OnWeblink value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getId());
            writer.name("type");
            ItemType_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.getType());
            writer.name("name");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getName());
            writer.name("createdAt");
            Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).toJson(writer, customScalarAdapters, value.getCreatedAt());
            writer.name("description");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getDescription());
            writer.name("updatedAt");
            Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).toJson(writer, customScalarAdapters, value.getUpdatedAt());
            writer.name("isRooted");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.isRooted());
            writer.name("itemCollectionConnection");
            Adapters.m11185nullable(Adapters.m11187obj$default(ItemCollectionConnection2.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getItemCollectionConnection());
            writer.name("url");
            Adapters.NullableAnyAdapter.toJson(writer, customScalarAdapters, value.getUrl());
            writer.name("ownedBy");
            Adapters.m11185nullable(Adapters.m11187obj$default(OwnedBy2.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getOwnedBy());
            writer.name("updatedBy");
            Adapters.m11185nullable(Adapters.m11187obj$default(UpdatedBy2.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getUpdatedBy());
            writer.name("parent");
            Adapters.m11185nullable(Adapters.m11187obj$default(Parent2.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getParent());
            writer.name("permissionsV2Api");
            Adapters.m11185nullable(Adapters.m11187obj$default(PermissionsV2Api2.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getPermissionsV2Api());
            writer.name(BoxNoteConstants.NOTES_BUILDER_SHARED_LINK);
            Adapters.m11185nullable(Adapters.m11187obj$default(SharedLink2.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getSharedLink());
        }
    }

    /* JADX INFO: compiled from: GetItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetItemQuery_ResponseAdapter$ItemCollectionConnection2;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetItemQuery$ItemCollectionConnection2;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ItemCollectionConnection2 implements Adapter<GetItemQuery.ItemCollectionConnection2> {
        public static final ItemCollectionConnection2 INSTANCE = new ItemCollectionConnection2();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf("edges");

        private ItemCollectionConnection2() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetItemQuery.ItemCollectionConnection2 fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            List listFromJson = null;
            while (reader.selectName(RESPONSE_NAMES) == 0) {
                listFromJson = Adapters.m11184list(Adapters.m11187obj$default(Edge2.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
            }
            Intrinsics.checkNotNull(listFromJson);
            return new GetItemQuery.ItemCollectionConnection2(listFromJson);
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetItemQuery.ItemCollectionConnection2 value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("edges");
            Adapters.m11184list(Adapters.m11187obj$default(Edge2.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, (List) value.getEdges());
        }
    }

    /* JADX INFO: compiled from: GetItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetItemQuery_ResponseAdapter$Edge2;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetItemQuery$Edge2;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Edge2 implements Adapter<GetItemQuery.Edge2> {
        public static final Edge2 INSTANCE = new Edge2();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "node"});

        private Edge2() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetItemQuery.Edge2 fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            GetItemQuery.Node2 node2 = null;
            while (true) {
                int iSelectName = reader.selectName(RESPONSE_NAMES);
                if (iSelectName == 0) {
                    strFromJson = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 1) {
                    node2 = (GetItemQuery.Node2) Adapters.m11187obj$default(Node2.INSTANCE, false, 1, null).fromJson(reader, customScalarAdapters);
                } else {
                    Intrinsics.checkNotNull(node2);
                    return new GetItemQuery.Edge2(strFromJson, node2);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetItemQuery.Edge2 value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getId());
            writer.name("node");
            Adapters.m11187obj$default(Node2.INSTANCE, false, 1, null).toJson(writer, customScalarAdapters, value.getNode());
        }
    }

    /* JADX INFO: compiled from: GetItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetItemQuery_ResponseAdapter$Node2;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetItemQuery$Node2;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Node2 implements Adapter<GetItemQuery.Node2> {
        public static final Node2 INSTANCE = new Node2();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "name", "collectionType"});

        private Node2() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetItemQuery.Node2 fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            String strFromJson2 = null;
            String strFromJson3 = null;
            while (true) {
                int iSelectName = reader.selectName(RESPONSE_NAMES);
                if (iSelectName == 0) {
                    strFromJson = Adapters.StringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 1) {
                    strFromJson2 = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 2) {
                    strFromJson3 = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                } else {
                    Intrinsics.checkNotNull(strFromJson);
                    return new GetItemQuery.Node2(strFromJson, strFromJson2, strFromJson3);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetItemQuery.Node2 value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getId());
            writer.name("name");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getName());
            writer.name("collectionType");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getCollectionType());
        }
    }

    /* JADX INFO: compiled from: GetItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetItemQuery_ResponseAdapter$OwnedBy2;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetItemQuery$OwnedBy2;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class OwnedBy2 implements Adapter<GetItemQuery.OwnedBy2> {
        public static final OwnedBy2 INSTANCE = new OwnedBy2();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "name"});

        private OwnedBy2() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetItemQuery.OwnedBy2 fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            String strFromJson2 = null;
            while (true) {
                int iSelectName = reader.selectName(RESPONSE_NAMES);
                if (iSelectName == 0) {
                    strFromJson = Adapters.StringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 1) {
                    strFromJson2 = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                } else {
                    Intrinsics.checkNotNull(strFromJson);
                    return new GetItemQuery.OwnedBy2(strFromJson, strFromJson2);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetItemQuery.OwnedBy2 value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getId());
            writer.name("name");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getName());
        }
    }

    /* JADX INFO: compiled from: GetItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetItemQuery_ResponseAdapter$UpdatedBy2;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetItemQuery$UpdatedBy2;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class UpdatedBy2 implements Adapter<GetItemQuery.UpdatedBy2> {
        public static final UpdatedBy2 INSTANCE = new UpdatedBy2();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "name"});

        private UpdatedBy2() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetItemQuery.UpdatedBy2 fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            String strFromJson2 = null;
            while (true) {
                int iSelectName = reader.selectName(RESPONSE_NAMES);
                if (iSelectName == 0) {
                    strFromJson = Adapters.StringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 1) {
                    strFromJson2 = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                } else {
                    Intrinsics.checkNotNull(strFromJson);
                    return new GetItemQuery.UpdatedBy2(strFromJson, strFromJson2);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetItemQuery.UpdatedBy2 value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getId());
            writer.name("name");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getName());
        }
    }

    /* JADX INFO: compiled from: GetItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetItemQuery_ResponseAdapter$Parent2;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetItemQuery$Parent2;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Parent2 implements Adapter<GetItemQuery.Parent2> {
        public static final Parent2 INSTANCE = new Parent2();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "name"});

        private Parent2() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetItemQuery.Parent2 fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            String strFromJson2 = null;
            while (true) {
                int iSelectName = reader.selectName(RESPONSE_NAMES);
                if (iSelectName == 0) {
                    strFromJson = Adapters.StringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 1) {
                    strFromJson2 = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                } else {
                    Intrinsics.checkNotNull(strFromJson);
                    return new GetItemQuery.Parent2(strFromJson, strFromJson2);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetItemQuery.Parent2 value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getId());
            writer.name("name");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getName());
        }
    }

    /* JADX INFO: compiled from: GetItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetItemQuery_ResponseAdapter$PermissionsV2Api2;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetItemQuery$PermissionsV2Api2;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class PermissionsV2Api2 implements Adapter<GetItemQuery.PermissionsV2Api2> {
        public static final PermissionsV2Api2 INSTANCE = new PermissionsV2Api2();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"canInviteCollaborator", "canSetShareAccess", "canDownload", "canPreview", "canComment", "canUpload", "canRename", "canDelete", "canShare", "canViewAnnotations", "canCreateAnnotations"});

        private PermissionsV2Api2() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetItemQuery.PermissionsV2Api2 fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Boolean boolFromJson = null;
            Boolean boolFromJson2 = null;
            Boolean boolFromJson3 = null;
            Boolean boolFromJson4 = null;
            Boolean boolFromJson5 = null;
            Boolean boolFromJson6 = null;
            Boolean boolFromJson7 = null;
            Boolean boolFromJson8 = null;
            Boolean boolFromJson9 = null;
            Boolean boolFromJson10 = null;
            Boolean boolFromJson11 = null;
            while (true) {
                switch (reader.selectName(RESPONSE_NAMES)) {
                    case 0:
                        boolFromJson = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 1:
                        boolFromJson2 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 2:
                        boolFromJson3 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 3:
                        boolFromJson4 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 4:
                        boolFromJson5 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 5:
                        boolFromJson6 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 6:
                        boolFromJson7 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 7:
                        boolFromJson8 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 8:
                        boolFromJson9 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 9:
                        boolFromJson10 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 10:
                        boolFromJson11 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    default:
                        return new GetItemQuery.PermissionsV2Api2(boolFromJson, boolFromJson2, boolFromJson3, boolFromJson4, boolFromJson5, boolFromJson6, boolFromJson7, boolFromJson8, boolFromJson9, boolFromJson10, boolFromJson11);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetItemQuery.PermissionsV2Api2 value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("canInviteCollaborator");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getCanInviteCollaborator());
            writer.name("canSetShareAccess");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getCanSetShareAccess());
            writer.name("canDownload");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getCanDownload());
            writer.name("canPreview");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getCanPreview());
            writer.name("canComment");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getCanComment());
            writer.name("canUpload");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getCanUpload());
            writer.name("canRename");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getCanRename());
            writer.name("canDelete");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getCanDelete());
            writer.name("canShare");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getCanShare());
            writer.name("canViewAnnotations");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getCanViewAnnotations());
            writer.name("canCreateAnnotations");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getCanCreateAnnotations());
        }
    }

    /* JADX INFO: compiled from: GetItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetItemQuery_ResponseAdapter$SharedLink2;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetItemQuery$SharedLink2;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class SharedLink2 implements Adapter<GetItemQuery.SharedLink2> {
        public static final SharedLink2 INSTANCE = new SharedLink2();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"url", "effectiveAccess", "effectivePermission", "isPasswordEnabled", "unsharedAt", "canDownload"});

        private SharedLink2() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetItemQuery.SharedLink2 fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            String strFromJson2 = null;
            String strFromJson3 = null;
            Boolean boolFromJson = null;
            Date date = null;
            Boolean boolFromJson2 = null;
            while (true) {
                int iSelectName = reader.selectName(RESPONSE_NAMES);
                if (iSelectName == 0) {
                    strFromJson = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 1) {
                    strFromJson2 = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 2) {
                    strFromJson3 = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 3) {
                    boolFromJson = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 4) {
                    date = (Date) Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 5) {
                    boolFromJson2 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                } else {
                    return new GetItemQuery.SharedLink2(strFromJson, strFromJson2, strFromJson3, boolFromJson, date, boolFromJson2);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetItemQuery.SharedLink2 value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("url");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getUrl());
            writer.name("effectiveAccess");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getEffectiveAccess());
            writer.name("effectivePermission");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getEffectivePermission());
            writer.name("isPasswordEnabled");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.isPasswordEnabled());
            writer.name("unsharedAt");
            Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).toJson(writer, customScalarAdapters, value.getUnsharedAt());
            writer.name("canDownload");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getCanDownload());
        }
    }
}
