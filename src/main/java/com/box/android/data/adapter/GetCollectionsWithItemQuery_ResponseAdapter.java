package com.box.android.data.adapter;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.BooleanExpressions;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.box.android.data.GetCollectionsWithItemQuery;
import com.box.android.data.datasource.gql.cache.GQLCacheConstants;
import com.box.android.data.type.ItemType;
import com.box.android.data.type.adapter.ItemType_ResponseAdapter;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GetCollectionsWithItemQuery_ResponseAdapter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\n"}, d2 = {"Lcom/box/android/data/adapter/GetCollectionsWithItemQuery_ResponseAdapter;", "", "<init>", "()V", "Data", "Item", "OnCoreItem", "ItemCollectionConnection", "Edge", "Node", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GetCollectionsWithItemQuery_ResponseAdapter {
    public static final GetCollectionsWithItemQuery_ResponseAdapter INSTANCE = new GetCollectionsWithItemQuery_ResponseAdapter();

    /* JADX INFO: compiled from: GetCollectionsWithItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetCollectionsWithItemQuery_ResponseAdapter$Data;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetCollectionsWithItemQuery$Data;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Data implements Adapter<GetCollectionsWithItemQuery.Data> {
        public static final Data INSTANCE = new Data();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf("item");

        private Data() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetCollectionsWithItemQuery.Data fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            GetCollectionsWithItemQuery.Item item = null;
            while (reader.selectName(RESPONSE_NAMES) == 0) {
                item = (GetCollectionsWithItemQuery.Item) Adapters.m11185nullable(Adapters.m11186obj(Item.INSTANCE, true)).fromJson(reader, customScalarAdapters);
            }
            return new GetCollectionsWithItemQuery.Data(item);
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetCollectionsWithItemQuery.Data value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("item");
            Adapters.m11185nullable(Adapters.m11186obj(Item.INSTANCE, true)).toJson(writer, customScalarAdapters, value.getItem());
        }
    }

    private GetCollectionsWithItemQuery_ResponseAdapter() {
    }

    /* JADX INFO: compiled from: GetCollectionsWithItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetCollectionsWithItemQuery_ResponseAdapter$Item;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetCollectionsWithItemQuery$Item;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Item implements Adapter<GetCollectionsWithItemQuery.Item> {
        public static final Item INSTANCE = new Item();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf(GQLCacheConstants.TYPENAME_KEY);

        private Item() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetCollectionsWithItemQuery.Item fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            GetCollectionsWithItemQuery.OnCoreItem onCoreItemFromJson = null;
            String strFromJson = null;
            while (reader.selectName(RESPONSE_NAMES) == 0) {
                strFromJson = Adapters.StringAdapter.fromJson(reader, customScalarAdapters);
            }
            if (strFromJson == null) {
                throw new IllegalStateException("__typename was not found".toString());
            }
            if (BooleanExpressions.evaluate(BooleanExpressions.possibleTypes("File", "Folder", "Weblink"), customScalarAdapters.getAdapterContext().variables(), strFromJson, customScalarAdapters.getAdapterContext(), null)) {
                reader.rewind();
                onCoreItemFromJson = OnCoreItem.INSTANCE.fromJson(reader, customScalarAdapters);
            }
            return new GetCollectionsWithItemQuery.Item(strFromJson, onCoreItemFromJson);
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetCollectionsWithItemQuery.Item value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name(GQLCacheConstants.TYPENAME_KEY);
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.get__typename());
            if (value.getOnCoreItem() != null) {
                OnCoreItem.INSTANCE.toJson(writer, customScalarAdapters, value.getOnCoreItem());
            }
        }
    }

    /* JADX INFO: compiled from: GetCollectionsWithItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetCollectionsWithItemQuery_ResponseAdapter$OnCoreItem;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetCollectionsWithItemQuery$OnCoreItem;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class OnCoreItem implements Adapter<GetCollectionsWithItemQuery.OnCoreItem> {
        public static final OnCoreItem INSTANCE = new OnCoreItem();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "type", "itemCollectionConnection"});

        private OnCoreItem() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetCollectionsWithItemQuery.OnCoreItem fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            ItemType itemTypeFromJson = null;
            GetCollectionsWithItemQuery.ItemCollectionConnection itemCollectionConnection = null;
            while (true) {
                int iSelectName = reader.selectName(RESPONSE_NAMES);
                if (iSelectName == 0) {
                    strFromJson = Adapters.StringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 1) {
                    itemTypeFromJson = ItemType_ResponseAdapter.INSTANCE.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 2) {
                    itemCollectionConnection = (GetCollectionsWithItemQuery.ItemCollectionConnection) Adapters.m11185nullable(Adapters.m11187obj$default(ItemCollectionConnection.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                } else {
                    Intrinsics.checkNotNull(strFromJson);
                    Intrinsics.checkNotNull(itemTypeFromJson);
                    return new GetCollectionsWithItemQuery.OnCoreItem(strFromJson, itemTypeFromJson, itemCollectionConnection);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetCollectionsWithItemQuery.OnCoreItem value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getId());
            writer.name("type");
            ItemType_ResponseAdapter.INSTANCE.toJson(writer, customScalarAdapters, value.getType());
            writer.name("itemCollectionConnection");
            Adapters.m11185nullable(Adapters.m11187obj$default(ItemCollectionConnection.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getItemCollectionConnection());
        }
    }

    /* JADX INFO: compiled from: GetCollectionsWithItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetCollectionsWithItemQuery_ResponseAdapter$ItemCollectionConnection;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetCollectionsWithItemQuery$ItemCollectionConnection;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ItemCollectionConnection implements Adapter<GetCollectionsWithItemQuery.ItemCollectionConnection> {
        public static final ItemCollectionConnection INSTANCE = new ItemCollectionConnection();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf("edges");

        private ItemCollectionConnection() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetCollectionsWithItemQuery.ItemCollectionConnection fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            List listFromJson = null;
            while (reader.selectName(RESPONSE_NAMES) == 0) {
                listFromJson = Adapters.m11184list(Adapters.m11187obj$default(Edge.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
            }
            Intrinsics.checkNotNull(listFromJson);
            return new GetCollectionsWithItemQuery.ItemCollectionConnection(listFromJson);
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetCollectionsWithItemQuery.ItemCollectionConnection value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("edges");
            Adapters.m11184list(Adapters.m11187obj$default(Edge.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, (List) value.getEdges());
        }
    }

    /* JADX INFO: compiled from: GetCollectionsWithItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetCollectionsWithItemQuery_ResponseAdapter$Edge;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetCollectionsWithItemQuery$Edge;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Edge implements Adapter<GetCollectionsWithItemQuery.Edge> {
        public static final Edge INSTANCE = new Edge();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "node"});

        private Edge() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetCollectionsWithItemQuery.Edge fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            GetCollectionsWithItemQuery.Node node = null;
            while (true) {
                int iSelectName = reader.selectName(RESPONSE_NAMES);
                if (iSelectName == 0) {
                    strFromJson = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 1) {
                    node = (GetCollectionsWithItemQuery.Node) Adapters.m11187obj$default(Node.INSTANCE, false, 1, null).fromJson(reader, customScalarAdapters);
                } else {
                    Intrinsics.checkNotNull(node);
                    return new GetCollectionsWithItemQuery.Edge(strFromJson, node);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetCollectionsWithItemQuery.Edge value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getId());
            writer.name("node");
            Adapters.m11187obj$default(Node.INSTANCE, false, 1, null).toJson(writer, customScalarAdapters, value.getNode());
        }
    }

    /* JADX INFO: compiled from: GetCollectionsWithItemQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetCollectionsWithItemQuery_ResponseAdapter$Node;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetCollectionsWithItemQuery$Node;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Node implements Adapter<GetCollectionsWithItemQuery.Node> {
        public static final Node INSTANCE = new Node();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "collectionType", "name"});

        private Node() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetCollectionsWithItemQuery.Node fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
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
                    return new GetCollectionsWithItemQuery.Node(strFromJson, strFromJson2, strFromJson3);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetCollectionsWithItemQuery.Node value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getId());
            writer.name("collectionType");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getCollectionType());
            writer.name("name");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getName());
        }
    }
}
