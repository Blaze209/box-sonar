package com.box.android.data.adapter;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.box.android.data.CreateFolderMutation;
import com.box.android.data.type.DateTime;
import com.box.android.data.type.ItemType;
import com.box.android.data.type.adapter.ItemType_ResponseAdapter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CreateFolderMutation_ResponseAdapter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001:\n\u0004\u0005\u0006\u0007\b\t\n\u000b\f\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u000e"}, d2 = {"Lcom/box/android/data/adapter/CreateFolderMutation_ResponseAdapter;", "", "<init>", "()V", "Data", CreateFolderMutation.OPERATION_NAME, "Value", "OwnedBy", "Parent", "UpdatedBy", "PermissionsV2Api", "ItemCollectionConnection", "Edge", "Node", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreateFolderMutation_ResponseAdapter {
    public static final CreateFolderMutation_ResponseAdapter INSTANCE = new CreateFolderMutation_ResponseAdapter();

    /* JADX INFO: compiled from: CreateFolderMutation_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/CreateFolderMutation_ResponseAdapter$Data;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/CreateFolderMutation$Data;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Data implements Adapter<CreateFolderMutation.Data> {
        public static final Data INSTANCE = new Data();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf("createFolder");

        private Data() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public CreateFolderMutation.Data fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            CreateFolderMutation.CreateFolder createFolder = null;
            while (reader.selectName(RESPONSE_NAMES) == 0) {
                createFolder = (CreateFolderMutation.CreateFolder) Adapters.m11187obj$default(CreateFolder.INSTANCE, false, 1, null).fromJson(reader, customScalarAdapters);
            }
            Intrinsics.checkNotNull(createFolder);
            return new CreateFolderMutation.Data(createFolder);
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, CreateFolderMutation.Data value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("createFolder");
            Adapters.m11187obj$default(CreateFolder.INSTANCE, false, 1, null).toJson(writer, customScalarAdapters, value.getCreateFolder());
        }
    }

    private CreateFolderMutation_ResponseAdapter() {
    }

    /* JADX INFO: compiled from: CreateFolderMutation_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/CreateFolderMutation_ResponseAdapter$CreateFolder;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/CreateFolderMutation$CreateFolder;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class CreateFolder implements Adapter<CreateFolderMutation.CreateFolder> {
        public static final CreateFolder INSTANCE = new CreateFolder();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf("value");

        private CreateFolder() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public CreateFolderMutation.CreateFolder fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            CreateFolderMutation.Value value = null;
            while (reader.selectName(RESPONSE_NAMES) == 0) {
                value = (CreateFolderMutation.Value) Adapters.m11185nullable(Adapters.m11187obj$default(Value.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
            }
            return new CreateFolderMutation.CreateFolder(value);
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, CreateFolderMutation.CreateFolder value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("value");
            Adapters.m11185nullable(Adapters.m11187obj$default(Value.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getValue());
        }
    }

    /* JADX INFO: compiled from: CreateFolderMutation_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/CreateFolderMutation_ResponseAdapter$Value;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/CreateFolderMutation$Value;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Value implements Adapter<CreateFolderMutation.Value> {
        public static final Value INSTANCE = new Value();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "type", "name", "size", "createdAt", "updatedAt", "contentCreatedAt", "contentUpdatedAt", "isRooted", "ownedBy", "hasCollaborations", "isExternallyOwned", "parent", "updatedBy", "permissionsV2Api", "itemCollectionConnection"});

        private Value() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0029. Please report as an issue. */
        @Override // com.apollographql.apollo3.api.Adapter
        public CreateFolderMutation.Value fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            ItemType itemTypeFromJson = null;
            String strFromJson2 = null;
            Object objFromJson = null;
            Date date = null;
            Date date2 = null;
            Date date3 = null;
            Date date4 = null;
            Boolean boolFromJson = null;
            CreateFolderMutation.OwnedBy ownedBy = null;
            Boolean boolFromJson2 = null;
            Boolean boolFromJson3 = null;
            CreateFolderMutation.Parent parent = null;
            CreateFolderMutation.UpdatedBy updatedBy = null;
            CreateFolderMutation.PermissionsV2Api permissionsV2Api = null;
            CreateFolderMutation.ItemCollectionConnection itemCollectionConnection = null;
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
                        objFromJson = Adapters.NullableAnyAdapter.fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 4:
                        itemTypeFromJson = itemTypeFromJson;
                        date = (Date) Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).fromJson(reader, customScalarAdapters);
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
                        ownedBy = (CreateFolderMutation.OwnedBy) Adapters.m11185nullable(Adapters.m11187obj$default(OwnedBy.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        strFromJson = strFromJson;
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 10:
                        boolFromJson2 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 11:
                        boolFromJson3 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 12:
                        parent = (CreateFolderMutation.Parent) Adapters.m11185nullable(Adapters.m11187obj$default(Parent.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        strFromJson = strFromJson;
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 13:
                        updatedBy = (CreateFolderMutation.UpdatedBy) Adapters.m11185nullable(Adapters.m11187obj$default(UpdatedBy.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        strFromJson = strFromJson;
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 14:
                        permissionsV2Api = (CreateFolderMutation.PermissionsV2Api) Adapters.m11185nullable(Adapters.m11187obj$default(PermissionsV2Api.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        strFromJson = strFromJson;
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 15:
                        itemCollectionConnection = (CreateFolderMutation.ItemCollectionConnection) Adapters.m11185nullable(Adapters.m11187obj$default(ItemCollectionConnection.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        strFromJson = strFromJson;
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                }
                Intrinsics.checkNotNull(strFromJson);
                Intrinsics.checkNotNull(itemTypeFromJson);
                return new CreateFolderMutation.Value(strFromJson, itemTypeFromJson, strFromJson2, objFromJson, date, date2, date3, date4, boolFromJson, ownedBy, boolFromJson2, boolFromJson3, parent, updatedBy, permissionsV2Api, itemCollectionConnection);
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, CreateFolderMutation.Value value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getId());
            writer.name("type");
            ItemType_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.getType());
            writer.name("name");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getName());
            writer.name("size");
            Adapters.NullableAnyAdapter.toJson(writer, customScalarAdapters, value.getSize());
            writer.name("createdAt");
            Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).toJson(writer, customScalarAdapters, value.getCreatedAt());
            writer.name("updatedAt");
            Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).toJson(writer, customScalarAdapters, value.getUpdatedAt());
            writer.name("contentCreatedAt");
            Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).toJson(writer, customScalarAdapters, value.getContentCreatedAt());
            writer.name("contentUpdatedAt");
            Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).toJson(writer, customScalarAdapters, value.getContentUpdatedAt());
            writer.name("isRooted");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.isRooted());
            writer.name("ownedBy");
            Adapters.m11185nullable(Adapters.m11187obj$default(OwnedBy.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getOwnedBy());
            writer.name("hasCollaborations");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getHasCollaborations());
            writer.name("isExternallyOwned");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.isExternallyOwned());
            writer.name("parent");
            Adapters.m11185nullable(Adapters.m11187obj$default(Parent.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getParent());
            writer.name("updatedBy");
            Adapters.m11185nullable(Adapters.m11187obj$default(UpdatedBy.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getUpdatedBy());
            writer.name("permissionsV2Api");
            Adapters.m11185nullable(Adapters.m11187obj$default(PermissionsV2Api.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getPermissionsV2Api());
            writer.name("itemCollectionConnection");
            Adapters.m11185nullable(Adapters.m11187obj$default(ItemCollectionConnection.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getItemCollectionConnection());
        }
    }

    /* JADX INFO: compiled from: CreateFolderMutation_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/CreateFolderMutation_ResponseAdapter$OwnedBy;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/CreateFolderMutation$OwnedBy;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class OwnedBy implements Adapter<CreateFolderMutation.OwnedBy> {
        public static final OwnedBy INSTANCE = new OwnedBy();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "name"});

        private OwnedBy() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public CreateFolderMutation.OwnedBy fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
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
                    return new CreateFolderMutation.OwnedBy(strFromJson, strFromJson2);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, CreateFolderMutation.OwnedBy value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getId());
            writer.name("name");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getName());
        }
    }

    /* JADX INFO: compiled from: CreateFolderMutation_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/CreateFolderMutation_ResponseAdapter$Parent;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/CreateFolderMutation$Parent;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Parent implements Adapter<CreateFolderMutation.Parent> {
        public static final Parent INSTANCE = new Parent();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "name"});

        private Parent() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public CreateFolderMutation.Parent fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
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
                    return new CreateFolderMutation.Parent(strFromJson, strFromJson2);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, CreateFolderMutation.Parent value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getId());
            writer.name("name");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getName());
        }
    }

    /* JADX INFO: compiled from: CreateFolderMutation_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/CreateFolderMutation_ResponseAdapter$UpdatedBy;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/CreateFolderMutation$UpdatedBy;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class UpdatedBy implements Adapter<CreateFolderMutation.UpdatedBy> {
        public static final UpdatedBy INSTANCE = new UpdatedBy();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "name"});

        private UpdatedBy() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public CreateFolderMutation.UpdatedBy fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
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
                    return new CreateFolderMutation.UpdatedBy(strFromJson, strFromJson2);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, CreateFolderMutation.UpdatedBy value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getId());
            writer.name("name");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getName());
        }
    }

    /* JADX INFO: compiled from: CreateFolderMutation_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/CreateFolderMutation_ResponseAdapter$PermissionsV2Api;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/CreateFolderMutation$PermissionsV2Api;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class PermissionsV2Api implements Adapter<CreateFolderMutation.PermissionsV2Api> {
        public static final PermissionsV2Api INSTANCE = new PermissionsV2Api();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"canInviteCollaborator", "canSetShareAccess", "canDownload", "canPreview", "canComment", "canUpload", "canRename", "canDelete", "canShare", "canViewAnnotations", "canCreateAnnotations"});

        private PermissionsV2Api() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public CreateFolderMutation.PermissionsV2Api fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) {
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
                        return new CreateFolderMutation.PermissionsV2Api(boolFromJson, boolFromJson2, boolFromJson3, boolFromJson4, boolFromJson5, boolFromJson6, boolFromJson7, boolFromJson8, boolFromJson9, boolFromJson10, boolFromJson11);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, CreateFolderMutation.PermissionsV2Api value) throws IOException {
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

    /* JADX INFO: compiled from: CreateFolderMutation_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/CreateFolderMutation_ResponseAdapter$ItemCollectionConnection;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/CreateFolderMutation$ItemCollectionConnection;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ItemCollectionConnection implements Adapter<CreateFolderMutation.ItemCollectionConnection> {
        public static final ItemCollectionConnection INSTANCE = new ItemCollectionConnection();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf("edges");

        private ItemCollectionConnection() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public CreateFolderMutation.ItemCollectionConnection fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            List listFromJson = null;
            while (reader.selectName(RESPONSE_NAMES) == 0) {
                listFromJson = Adapters.m11184list(Adapters.m11187obj$default(Edge.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
            }
            Intrinsics.checkNotNull(listFromJson);
            return new CreateFolderMutation.ItemCollectionConnection(listFromJson);
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, CreateFolderMutation.ItemCollectionConnection value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("edges");
            Adapters.m11184list(Adapters.m11187obj$default(Edge.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, (List) value.getEdges());
        }
    }

    /* JADX INFO: compiled from: CreateFolderMutation_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/CreateFolderMutation_ResponseAdapter$Edge;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/CreateFolderMutation$Edge;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Edge implements Adapter<CreateFolderMutation.Edge> {
        public static final Edge INSTANCE = new Edge();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "node"});

        private Edge() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public CreateFolderMutation.Edge fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            CreateFolderMutation.Node node = null;
            while (true) {
                int iSelectName = reader.selectName(RESPONSE_NAMES);
                if (iSelectName == 0) {
                    strFromJson = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 1) {
                    node = (CreateFolderMutation.Node) Adapters.m11187obj$default(Node.INSTANCE, false, 1, null).fromJson(reader, customScalarAdapters);
                } else {
                    Intrinsics.checkNotNull(node);
                    return new CreateFolderMutation.Edge(strFromJson, node);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, CreateFolderMutation.Edge value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getId());
            writer.name("node");
            Adapters.m11187obj$default(Node.INSTANCE, false, 1, null).toJson(writer, customScalarAdapters, value.getNode());
        }
    }

    /* JADX INFO: compiled from: CreateFolderMutation_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/CreateFolderMutation_ResponseAdapter$Node;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/CreateFolderMutation$Node;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Node implements Adapter<CreateFolderMutation.Node> {
        public static final Node INSTANCE = new Node();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "name", "collectionType"});

        private Node() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public CreateFolderMutation.Node fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
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
                    return new CreateFolderMutation.Node(strFromJson, strFromJson2, strFromJson3);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, CreateFolderMutation.Node value) throws IOException {
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
}
