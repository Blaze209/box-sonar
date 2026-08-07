package com.box.android.data.adapter;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.BooleanExpressions;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.box.android.data.GetCollectionItemsQuery;
import com.box.android.data.datasource.gql.cache.GQLCacheConstants;
import com.box.android.data.type.DateTime;
import com.box.android.data.type.ItemType;
import com.box.android.data.type.adapter.ItemType_ResponseAdapter;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.box.androidsdk.content.models.BoxCollection;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GetCollectionItemsQuery_ResponseAdapter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u001b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0018\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u001c"}, d2 = {"Lcom/box/android/data/adapter/GetCollectionItemsQuery_ResponseAdapter;", "", "<init>", "()V", "Data", "Collection", "CollectionItemConnection", "Edge", "Node", "OnFile", "OwnedBy", "UpdatedBy", "Watermark", "Parent", "PermissionsV2Api", "SharedLink", "OnFolder", "OwnedBy1", "UpdatedBy1", "Parent1", "PermissionsV2Api1", "SharedLink1", "OnWeblink", "OwnedBy2", "UpdatedBy2", "Parent2", "PermissionsV2Api2", "SharedLink2", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GetCollectionItemsQuery_ResponseAdapter {
    public static final GetCollectionItemsQuery_ResponseAdapter INSTANCE = new GetCollectionItemsQuery_ResponseAdapter();

    /* JADX INFO: compiled from: GetCollectionItemsQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetCollectionItemsQuery_ResponseAdapter$Data;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetCollectionItemsQuery$Data;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Data implements Adapter<GetCollectionItemsQuery.Data> {
        public static final Data INSTANCE = new Data();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf(BoxCollection.TYPE);

        private Data() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetCollectionItemsQuery.Data fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            GetCollectionItemsQuery.Collection collection = null;
            while (reader.selectName(RESPONSE_NAMES) == 0) {
                collection = (GetCollectionItemsQuery.Collection) Adapters.m11185nullable(Adapters.m11187obj$default(Collection.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
            }
            return new GetCollectionItemsQuery.Data(collection);
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetCollectionItemsQuery.Data value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name(BoxCollection.TYPE);
            Adapters.m11185nullable(Adapters.m11187obj$default(Collection.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getCollection());
        }
    }

    private GetCollectionItemsQuery_ResponseAdapter() {
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetCollectionItemsQuery_ResponseAdapter$Collection;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetCollectionItemsQuery$Collection;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Collection implements Adapter<GetCollectionItemsQuery.Collection> {
        public static final Collection INSTANCE = new Collection();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "collectionItemConnection"});

        private Collection() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetCollectionItemsQuery.Collection fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            GetCollectionItemsQuery.CollectionItemConnection collectionItemConnection = null;
            while (true) {
                int iSelectName = reader.selectName(RESPONSE_NAMES);
                if (iSelectName == 0) {
                    strFromJson = Adapters.StringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 1) {
                    collectionItemConnection = (GetCollectionItemsQuery.CollectionItemConnection) Adapters.m11185nullable(Adapters.m11187obj$default(CollectionItemConnection.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                } else {
                    Intrinsics.checkNotNull(strFromJson);
                    return new GetCollectionItemsQuery.Collection(strFromJson, collectionItemConnection);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetCollectionItemsQuery.Collection value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getId());
            writer.name("collectionItemConnection");
            Adapters.m11185nullable(Adapters.m11187obj$default(CollectionItemConnection.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getCollectionItemConnection());
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetCollectionItemsQuery_ResponseAdapter$CollectionItemConnection;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetCollectionItemsQuery$CollectionItemConnection;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class CollectionItemConnection implements Adapter<GetCollectionItemsQuery.CollectionItemConnection> {
        public static final CollectionItemConnection INSTANCE = new CollectionItemConnection();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf("edges");

        private CollectionItemConnection() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetCollectionItemsQuery.CollectionItemConnection fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            List listFromJson = null;
            while (reader.selectName(RESPONSE_NAMES) == 0) {
                listFromJson = Adapters.m11184list(Adapters.m11187obj$default(Edge.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
            }
            Intrinsics.checkNotNull(listFromJson);
            return new GetCollectionItemsQuery.CollectionItemConnection(listFromJson);
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetCollectionItemsQuery.CollectionItemConnection value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("edges");
            Adapters.m11184list(Adapters.m11187obj$default(Edge.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, (List) value.getEdges());
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetCollectionItemsQuery_ResponseAdapter$Edge;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetCollectionItemsQuery$Edge;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Edge implements Adapter<GetCollectionItemsQuery.Edge> {
        public static final Edge INSTANCE = new Edge();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "node"});

        private Edge() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetCollectionItemsQuery.Edge fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            GetCollectionItemsQuery.Node node = null;
            while (true) {
                int iSelectName = reader.selectName(RESPONSE_NAMES);
                if (iSelectName == 0) {
                    strFromJson = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                } else if (iSelectName == 1) {
                    node = (GetCollectionItemsQuery.Node) Adapters.m11186obj(Node.INSTANCE, true).fromJson(reader, customScalarAdapters);
                } else {
                    Intrinsics.checkNotNull(node);
                    return new GetCollectionItemsQuery.Edge(strFromJson, node);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetCollectionItemsQuery.Edge value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getId());
            writer.name("node");
            Adapters.m11186obj(Node.INSTANCE, true).toJson(writer, customScalarAdapters, value.getNode());
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetCollectionItemsQuery_ResponseAdapter$Node;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetCollectionItemsQuery$Node;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Node implements Adapter<GetCollectionItemsQuery.Node> {
        public static final Node INSTANCE = new Node();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf(GQLCacheConstants.TYPENAME_KEY);

        private Node() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetCollectionItemsQuery.Node fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            GetCollectionItemsQuery.OnFile onFileFromJson;
            GetCollectionItemsQuery.OnFolder onFolderFromJson;
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            GetCollectionItemsQuery.OnWeblink onWeblinkFromJson = null;
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
            return new GetCollectionItemsQuery.Node(strFromJson, onFileFromJson, onFolderFromJson, onWeblinkFromJson);
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetCollectionItemsQuery.Node value) throws IOException {
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

    /* JADX INFO: compiled from: GetCollectionItemsQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetCollectionItemsQuery_ResponseAdapter$OnFile;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetCollectionItemsQuery$OnFile;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class OnFile implements Adapter<GetCollectionItemsQuery.OnFile> {
        public static final OnFile INSTANCE = new OnFile();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "type", "name", "size", "createdAt", "updatedAt", "contentCreatedAt", "contentUpdatedAt", "ownedBy", "updatedBy", "hasCollaborations", "isExternallyOwned", "sha1", "watermark", "parent", "permissionsV2Api", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK});

        private OnFile() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Failed to find 'out' block for switch in B:4:0x002b. Please report as an issue. */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetCollectionItemsQuery.OnFile fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
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
            GetCollectionItemsQuery.OwnedBy ownedBy = null;
            GetCollectionItemsQuery.UpdatedBy updatedBy = null;
            Boolean boolFromJson = null;
            Boolean boolFromJson2 = null;
            String strFromJson3 = null;
            GetCollectionItemsQuery.Watermark watermark = null;
            GetCollectionItemsQuery.Parent parent = null;
            GetCollectionItemsQuery.PermissionsV2Api permissionsV2Api = null;
            GetCollectionItemsQuery.SharedLink sharedLink = null;
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
                        ownedBy = (GetCollectionItemsQuery.OwnedBy) Adapters.m11185nullable(Adapters.m11187obj$default(OwnedBy.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        strFromJson = strFromJson;
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 9:
                        updatedBy = (GetCollectionItemsQuery.UpdatedBy) Adapters.m11185nullable(Adapters.m11187obj$default(UpdatedBy.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        strFromJson = strFromJson;
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 10:
                        boolFromJson = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 11:
                        boolFromJson2 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 12:
                        strFromJson3 = Adapters.NullableStringAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 13:
                        watermark = (GetCollectionItemsQuery.Watermark) Adapters.m11185nullable(Adapters.m11187obj$default(Watermark.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        strFromJson = strFromJson;
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 14:
                        parent = (GetCollectionItemsQuery.Parent) Adapters.m11185nullable(Adapters.m11187obj$default(Parent.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        strFromJson = strFromJson;
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 15:
                        permissionsV2Api = (GetCollectionItemsQuery.PermissionsV2Api) Adapters.m11185nullable(Adapters.m11187obj$default(PermissionsV2Api.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        strFromJson = strFromJson;
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 16:
                        sharedLink = (GetCollectionItemsQuery.SharedLink) Adapters.m11185nullable(Adapters.m11187obj$default(SharedLink.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        strFromJson = strFromJson;
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                }
                Intrinsics.checkNotNull(strFromJson);
                Intrinsics.checkNotNull(itemTypeFromJson);
                return new GetCollectionItemsQuery.OnFile(strFromJson, itemTypeFromJson, strFromJson2, objFromJson, date, date2, date3, date4, ownedBy, updatedBy, boolFromJson, boolFromJson2, strFromJson3, watermark, parent, permissionsV2Api, sharedLink);
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetCollectionItemsQuery.OnFile value) throws IOException {
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
            writer.name("ownedBy");
            Adapters.m11185nullable(Adapters.m11187obj$default(OwnedBy.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getOwnedBy());
            writer.name("updatedBy");
            Adapters.m11185nullable(Adapters.m11187obj$default(UpdatedBy.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getUpdatedBy());
            writer.name("hasCollaborations");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getHasCollaborations());
            writer.name("isExternallyOwned");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.isExternallyOwned());
            writer.name("sha1");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getSha1());
            writer.name("watermark");
            Adapters.m11185nullable(Adapters.m11187obj$default(Watermark.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getWatermark());
            writer.name("parent");
            Adapters.m11185nullable(Adapters.m11187obj$default(Parent.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getParent());
            writer.name("permissionsV2Api");
            Adapters.m11185nullable(Adapters.m11187obj$default(PermissionsV2Api.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getPermissionsV2Api());
            writer.name(BoxNoteConstants.NOTES_BUILDER_SHARED_LINK);
            Adapters.m11185nullable(Adapters.m11187obj$default(SharedLink.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getSharedLink());
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetCollectionItemsQuery_ResponseAdapter$OwnedBy;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetCollectionItemsQuery$OwnedBy;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class OwnedBy implements Adapter<GetCollectionItemsQuery.OwnedBy> {
        public static final OwnedBy INSTANCE = new OwnedBy();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf("id");

        private OwnedBy() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetCollectionItemsQuery.OwnedBy fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            while (reader.selectName(RESPONSE_NAMES) == 0) {
                strFromJson = Adapters.StringAdapter.fromJson(reader, customScalarAdapters);
            }
            Intrinsics.checkNotNull(strFromJson);
            return new GetCollectionItemsQuery.OwnedBy(strFromJson);
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetCollectionItemsQuery.OwnedBy value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getId());
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetCollectionItemsQuery_ResponseAdapter$UpdatedBy;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetCollectionItemsQuery$UpdatedBy;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class UpdatedBy implements Adapter<GetCollectionItemsQuery.UpdatedBy> {
        public static final UpdatedBy INSTANCE = new UpdatedBy();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "name"});

        private UpdatedBy() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetCollectionItemsQuery.UpdatedBy fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
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
                    return new GetCollectionItemsQuery.UpdatedBy(strFromJson, strFromJson2);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetCollectionItemsQuery.UpdatedBy value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getId());
            writer.name("name");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getName());
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetCollectionItemsQuery_ResponseAdapter$Watermark;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetCollectionItemsQuery$Watermark;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Watermark implements Adapter<GetCollectionItemsQuery.Watermark> {
        public static final Watermark INSTANCE = new Watermark();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf("isWatermarked");

        private Watermark() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetCollectionItemsQuery.Watermark fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Boolean boolFromJson = null;
            while (reader.selectName(RESPONSE_NAMES) == 0) {
                boolFromJson = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
            }
            return new GetCollectionItemsQuery.Watermark(boolFromJson);
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetCollectionItemsQuery.Watermark value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("isWatermarked");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.isWatermarked());
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetCollectionItemsQuery_ResponseAdapter$Parent;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetCollectionItemsQuery$Parent;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Parent implements Adapter<GetCollectionItemsQuery.Parent> {
        public static final Parent INSTANCE = new Parent();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "name"});

        private Parent() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetCollectionItemsQuery.Parent fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
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
                    return new GetCollectionItemsQuery.Parent(strFromJson, strFromJson2);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetCollectionItemsQuery.Parent value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getId());
            writer.name("name");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getName());
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetCollectionItemsQuery_ResponseAdapter$PermissionsV2Api;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetCollectionItemsQuery$PermissionsV2Api;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class PermissionsV2Api implements Adapter<GetCollectionItemsQuery.PermissionsV2Api> {
        public static final PermissionsV2Api INSTANCE = new PermissionsV2Api();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"canInviteCollaborator", "canSetShareAccess", "canDownload", "canPreview", "canComment", "canUpload", "canRename", "canDelete", "canShare", "canViewAnnotations", "canCreateAnnotations"});

        private PermissionsV2Api() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetCollectionItemsQuery.PermissionsV2Api fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) {
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
                        return new GetCollectionItemsQuery.PermissionsV2Api(boolFromJson, boolFromJson2, boolFromJson3, boolFromJson4, boolFromJson5, boolFromJson6, boolFromJson7, boolFromJson8, boolFromJson9, boolFromJson10, boolFromJson11);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetCollectionItemsQuery.PermissionsV2Api value) throws IOException {
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

    /* JADX INFO: compiled from: GetCollectionItemsQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetCollectionItemsQuery_ResponseAdapter$SharedLink;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetCollectionItemsQuery$SharedLink;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class SharedLink implements Adapter<GetCollectionItemsQuery.SharedLink> {
        public static final SharedLink INSTANCE = new SharedLink();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"url", "effectiveAccess", "effectivePermission", "isPasswordEnabled", "unsharedAt", "canDownload"});

        private SharedLink() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetCollectionItemsQuery.SharedLink fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
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
                    return new GetCollectionItemsQuery.SharedLink(strFromJson, strFromJson2, strFromJson3, boolFromJson, date, boolFromJson2);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetCollectionItemsQuery.SharedLink value) throws IOException {
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

    /* JADX INFO: compiled from: GetCollectionItemsQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetCollectionItemsQuery_ResponseAdapter$OnFolder;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetCollectionItemsQuery$OnFolder;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class OnFolder implements Adapter<GetCollectionItemsQuery.OnFolder> {
        public static final OnFolder INSTANCE = new OnFolder();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "type", "name", "size", "createdAt", "updatedAt", "contentCreatedAt", "contentUpdatedAt", "ownedBy", "updatedBy", "hasCollaborations", "isExternallyOwned", "parent", "permissionsV2Api", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK});

        private OnFolder() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0027. Please report as an issue. */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetCollectionItemsQuery.OnFolder fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
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
            GetCollectionItemsQuery.OwnedBy1 ownedBy1 = null;
            GetCollectionItemsQuery.UpdatedBy1 updatedBy1 = null;
            Boolean boolFromJson = null;
            Boolean boolFromJson2 = null;
            GetCollectionItemsQuery.Parent1 parent1 = null;
            GetCollectionItemsQuery.PermissionsV2Api1 permissionsV2Api1 = null;
            GetCollectionItemsQuery.SharedLink1 sharedLink1 = null;
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
                        ownedBy1 = (GetCollectionItemsQuery.OwnedBy1) Adapters.m11185nullable(Adapters.m11187obj$default(OwnedBy1.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        strFromJson = strFromJson;
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 9:
                        updatedBy1 = (GetCollectionItemsQuery.UpdatedBy1) Adapters.m11185nullable(Adapters.m11187obj$default(UpdatedBy1.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        strFromJson = strFromJson;
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 10:
                        boolFromJson = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 11:
                        boolFromJson2 = Adapters.NullableBooleanAdapter.fromJson(reader, customScalarAdapters);
                        break;
                    case 12:
                        parent1 = (GetCollectionItemsQuery.Parent1) Adapters.m11185nullable(Adapters.m11187obj$default(Parent1.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        strFromJson = strFromJson;
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 13:
                        permissionsV2Api1 = (GetCollectionItemsQuery.PermissionsV2Api1) Adapters.m11185nullable(Adapters.m11187obj$default(PermissionsV2Api1.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        strFromJson = strFromJson;
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 14:
                        sharedLink1 = (GetCollectionItemsQuery.SharedLink1) Adapters.m11185nullable(Adapters.m11187obj$default(SharedLink1.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        strFromJson = strFromJson;
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                }
                Intrinsics.checkNotNull(strFromJson);
                Intrinsics.checkNotNull(itemTypeFromJson);
                return new GetCollectionItemsQuery.OnFolder(strFromJson, itemTypeFromJson, strFromJson2, objFromJson, date, date2, date3, date4, ownedBy1, updatedBy1, boolFromJson, boolFromJson2, parent1, permissionsV2Api1, sharedLink1);
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetCollectionItemsQuery.OnFolder value) throws IOException {
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
            writer.name("ownedBy");
            Adapters.m11185nullable(Adapters.m11187obj$default(OwnedBy1.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getOwnedBy());
            writer.name("updatedBy");
            Adapters.m11185nullable(Adapters.m11187obj$default(UpdatedBy1.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getUpdatedBy());
            writer.name("hasCollaborations");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.getHasCollaborations());
            writer.name("isExternallyOwned");
            Adapters.NullableBooleanAdapter.toJson(writer, customScalarAdapters, value.isExternallyOwned());
            writer.name("parent");
            Adapters.m11185nullable(Adapters.m11187obj$default(Parent1.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getParent());
            writer.name("permissionsV2Api");
            Adapters.m11185nullable(Adapters.m11187obj$default(PermissionsV2Api1.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getPermissionsV2Api());
            writer.name(BoxNoteConstants.NOTES_BUILDER_SHARED_LINK);
            Adapters.m11185nullable(Adapters.m11187obj$default(SharedLink1.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getSharedLink());
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetCollectionItemsQuery_ResponseAdapter$OwnedBy1;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetCollectionItemsQuery$OwnedBy1;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class OwnedBy1 implements Adapter<GetCollectionItemsQuery.OwnedBy1> {
        public static final OwnedBy1 INSTANCE = new OwnedBy1();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf("id");

        private OwnedBy1() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetCollectionItemsQuery.OwnedBy1 fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            while (reader.selectName(RESPONSE_NAMES) == 0) {
                strFromJson = Adapters.StringAdapter.fromJson(reader, customScalarAdapters);
            }
            Intrinsics.checkNotNull(strFromJson);
            return new GetCollectionItemsQuery.OwnedBy1(strFromJson);
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetCollectionItemsQuery.OwnedBy1 value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getId());
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetCollectionItemsQuery_ResponseAdapter$UpdatedBy1;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetCollectionItemsQuery$UpdatedBy1;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class UpdatedBy1 implements Adapter<GetCollectionItemsQuery.UpdatedBy1> {
        public static final UpdatedBy1 INSTANCE = new UpdatedBy1();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "name"});

        private UpdatedBy1() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetCollectionItemsQuery.UpdatedBy1 fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
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
                    return new GetCollectionItemsQuery.UpdatedBy1(strFromJson, strFromJson2);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetCollectionItemsQuery.UpdatedBy1 value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getId());
            writer.name("name");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getName());
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetCollectionItemsQuery_ResponseAdapter$Parent1;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetCollectionItemsQuery$Parent1;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Parent1 implements Adapter<GetCollectionItemsQuery.Parent1> {
        public static final Parent1 INSTANCE = new Parent1();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "name"});

        private Parent1() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetCollectionItemsQuery.Parent1 fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
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
                    return new GetCollectionItemsQuery.Parent1(strFromJson, strFromJson2);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetCollectionItemsQuery.Parent1 value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getId());
            writer.name("name");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getName());
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetCollectionItemsQuery_ResponseAdapter$PermissionsV2Api1;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetCollectionItemsQuery$PermissionsV2Api1;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class PermissionsV2Api1 implements Adapter<GetCollectionItemsQuery.PermissionsV2Api1> {
        public static final PermissionsV2Api1 INSTANCE = new PermissionsV2Api1();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"canInviteCollaborator", "canSetShareAccess", "canDownload", "canPreview", "canComment", "canUpload", "canRename", "canDelete", "canShare", "canViewAnnotations", "canCreateAnnotations"});

        private PermissionsV2Api1() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetCollectionItemsQuery.PermissionsV2Api1 fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) {
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
                        return new GetCollectionItemsQuery.PermissionsV2Api1(boolFromJson, boolFromJson2, boolFromJson3, boolFromJson4, boolFromJson5, boolFromJson6, boolFromJson7, boolFromJson8, boolFromJson9, boolFromJson10, boolFromJson11);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetCollectionItemsQuery.PermissionsV2Api1 value) throws IOException {
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

    /* JADX INFO: compiled from: GetCollectionItemsQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetCollectionItemsQuery_ResponseAdapter$SharedLink1;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetCollectionItemsQuery$SharedLink1;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class SharedLink1 implements Adapter<GetCollectionItemsQuery.SharedLink1> {
        public static final SharedLink1 INSTANCE = new SharedLink1();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"url", "effectiveAccess", "effectivePermission", "isPasswordEnabled", "unsharedAt", "canDownload"});

        private SharedLink1() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetCollectionItemsQuery.SharedLink1 fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
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
                    return new GetCollectionItemsQuery.SharedLink1(strFromJson, strFromJson2, strFromJson3, boolFromJson, date, boolFromJson2);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetCollectionItemsQuery.SharedLink1 value) throws IOException {
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

    /* JADX INFO: compiled from: GetCollectionItemsQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetCollectionItemsQuery_ResponseAdapter$OnWeblink;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetCollectionItemsQuery$OnWeblink;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class OnWeblink implements Adapter<GetCollectionItemsQuery.OnWeblink> {
        public static final OnWeblink INSTANCE = new OnWeblink();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "type", "name", "createdAt", "updatedAt", "contentCreatedAt", "contentUpdatedAt", "ownedBy", "updatedBy", "url", "parent", "permissionsV2Api", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK});

        private OnWeblink() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0023. Please report as an issue. */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetCollectionItemsQuery.OnWeblink fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            ItemType itemTypeFromJson = null;
            String strFromJson2 = null;
            Date date = null;
            Date date2 = null;
            Date date3 = null;
            Date date4 = null;
            GetCollectionItemsQuery.OwnedBy2 ownedBy2 = null;
            GetCollectionItemsQuery.UpdatedBy2 updatedBy2 = null;
            Object objFromJson = null;
            GetCollectionItemsQuery.Parent2 parent2 = null;
            GetCollectionItemsQuery.PermissionsV2Api2 permissionsV2Api2 = null;
            GetCollectionItemsQuery.SharedLink2 sharedLink2 = null;
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
                        date2 = (Date) Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 5:
                        date3 = (Date) Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 6:
                        date4 = (Date) Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 7:
                        ownedBy2 = (GetCollectionItemsQuery.OwnedBy2) Adapters.m11185nullable(Adapters.m11187obj$default(OwnedBy2.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        strFromJson = strFromJson;
                        break;
                    case 8:
                        updatedBy2 = (GetCollectionItemsQuery.UpdatedBy2) Adapters.m11185nullable(Adapters.m11187obj$default(UpdatedBy2.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        strFromJson = strFromJson;
                        break;
                    case 9:
                        objFromJson = Adapters.NullableAnyAdapter.fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        break;
                    case 10:
                        parent2 = (GetCollectionItemsQuery.Parent2) Adapters.m11185nullable(Adapters.m11187obj$default(Parent2.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        strFromJson = strFromJson;
                        break;
                    case 11:
                        permissionsV2Api2 = (GetCollectionItemsQuery.PermissionsV2Api2) Adapters.m11185nullable(Adapters.m11187obj$default(PermissionsV2Api2.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        strFromJson = strFromJson;
                        break;
                    case 12:
                        sharedLink2 = (GetCollectionItemsQuery.SharedLink2) Adapters.m11185nullable(Adapters.m11187obj$default(SharedLink2.INSTANCE, false, 1, null)).fromJson(reader, customScalarAdapters);
                        itemTypeFromJson = itemTypeFromJson;
                        strFromJson = strFromJson;
                        break;
                }
                Intrinsics.checkNotNull(strFromJson);
                Intrinsics.checkNotNull(itemTypeFromJson);
                return new GetCollectionItemsQuery.OnWeblink(strFromJson, itemTypeFromJson, strFromJson2, date, date2, date3, date4, ownedBy2, updatedBy2, objFromJson, parent2, permissionsV2Api2, sharedLink2);
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetCollectionItemsQuery.OnWeblink value) throws IOException {
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
            writer.name("contentCreatedAt");
            Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).toJson(writer, customScalarAdapters, value.getContentCreatedAt());
            writer.name("contentUpdatedAt");
            Adapters.m11185nullable(customScalarAdapters.responseAdapterFor(DateTime.INSTANCE.getType())).toJson(writer, customScalarAdapters, value.getContentUpdatedAt());
            writer.name("ownedBy");
            Adapters.m11185nullable(Adapters.m11187obj$default(OwnedBy2.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getOwnedBy());
            writer.name("updatedBy");
            Adapters.m11185nullable(Adapters.m11187obj$default(UpdatedBy2.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getUpdatedBy());
            writer.name("url");
            Adapters.NullableAnyAdapter.toJson(writer, customScalarAdapters, value.getUrl());
            writer.name("parent");
            Adapters.m11185nullable(Adapters.m11187obj$default(Parent2.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getParent());
            writer.name("permissionsV2Api");
            Adapters.m11185nullable(Adapters.m11187obj$default(PermissionsV2Api2.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getPermissionsV2Api());
            writer.name(BoxNoteConstants.NOTES_BUILDER_SHARED_LINK);
            Adapters.m11185nullable(Adapters.m11187obj$default(SharedLink2.INSTANCE, false, 1, null)).toJson(writer, customScalarAdapters, value.getSharedLink());
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetCollectionItemsQuery_ResponseAdapter$OwnedBy2;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetCollectionItemsQuery$OwnedBy2;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class OwnedBy2 implements Adapter<GetCollectionItemsQuery.OwnedBy2> {
        public static final OwnedBy2 INSTANCE = new OwnedBy2();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf("id");

        private OwnedBy2() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetCollectionItemsQuery.OwnedBy2 fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            String strFromJson = null;
            while (reader.selectName(RESPONSE_NAMES) == 0) {
                strFromJson = Adapters.StringAdapter.fromJson(reader, customScalarAdapters);
            }
            Intrinsics.checkNotNull(strFromJson);
            return new GetCollectionItemsQuery.OwnedBy2(strFromJson);
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetCollectionItemsQuery.OwnedBy2 value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getId());
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetCollectionItemsQuery_ResponseAdapter$UpdatedBy2;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetCollectionItemsQuery$UpdatedBy2;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class UpdatedBy2 implements Adapter<GetCollectionItemsQuery.UpdatedBy2> {
        public static final UpdatedBy2 INSTANCE = new UpdatedBy2();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "name"});

        private UpdatedBy2() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetCollectionItemsQuery.UpdatedBy2 fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
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
                    return new GetCollectionItemsQuery.UpdatedBy2(strFromJson, strFromJson2);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetCollectionItemsQuery.UpdatedBy2 value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getId());
            writer.name("name");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getName());
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetCollectionItemsQuery_ResponseAdapter$Parent2;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetCollectionItemsQuery$Parent2;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Parent2 implements Adapter<GetCollectionItemsQuery.Parent2> {
        public static final Parent2 INSTANCE = new Parent2();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"id", "name"});

        private Parent2() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetCollectionItemsQuery.Parent2 fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
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
                    return new GetCollectionItemsQuery.Parent2(strFromJson, strFromJson2);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetCollectionItemsQuery.Parent2 value) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            Intrinsics.checkNotNullParameter(value, "value");
            writer.name("id");
            Adapters.StringAdapter.toJson(writer, customScalarAdapters, value.getId());
            writer.name("name");
            Adapters.NullableStringAdapter.toJson(writer, customScalarAdapters, value.getName());
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetCollectionItemsQuery_ResponseAdapter$PermissionsV2Api2;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetCollectionItemsQuery$PermissionsV2Api2;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class PermissionsV2Api2 implements Adapter<GetCollectionItemsQuery.PermissionsV2Api2> {
        public static final PermissionsV2Api2 INSTANCE = new PermissionsV2Api2();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"canInviteCollaborator", "canSetShareAccess", "canDownload", "canPreview", "canComment", "canUpload", "canRename", "canDelete", "canShare", "canViewAnnotations", "canCreateAnnotations"});

        private PermissionsV2Api2() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetCollectionItemsQuery.PermissionsV2Api2 fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) {
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
                        return new GetCollectionItemsQuery.PermissionsV2Api2(boolFromJson, boolFromJson2, boolFromJson3, boolFromJson4, boolFromJson5, boolFromJson6, boolFromJson7, boolFromJson8, boolFromJson9, boolFromJson10, boolFromJson11);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetCollectionItemsQuery.PermissionsV2Api2 value) throws IOException {
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

    /* JADX INFO: compiled from: GetCollectionItemsQuery_ResponseAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/adapter/GetCollectionItemsQuery_ResponseAdapter$SharedLink2;", "Lcom/apollographql/apollo3/api/Adapter;", "Lcom/box/android/data/GetCollectionItemsQuery$SharedLink2;", "<init>", "()V", "RESPONSE_NAMES", "", "", "getRESPONSE_NAMES", "()Ljava/util/List;", "fromJson", "reader", "Lcom/apollographql/apollo3/api/json/JsonReader;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "toJson", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class SharedLink2 implements Adapter<GetCollectionItemsQuery.SharedLink2> {
        public static final SharedLink2 INSTANCE = new SharedLink2();
        private static final List<String> RESPONSE_NAMES = CollectionsKt.listOf((Object[]) new String[]{"url", "effectiveAccess", "effectivePermission", "isPasswordEnabled", "unsharedAt", "canDownload"});

        private SharedLink2() {
        }

        public final List<String> getRESPONSE_NAMES() {
            return RESPONSE_NAMES;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.apollographql.apollo3.api.Adapter
        public GetCollectionItemsQuery.SharedLink2 fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
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
                    return new GetCollectionItemsQuery.SharedLink2(strFromJson, strFromJson2, strFromJson3, boolFromJson, date, boolFromJson2);
                }
            }
        }

        @Override // com.apollographql.apollo3.api.Adapter
        public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, GetCollectionItemsQuery.SharedLink2 value) throws IOException {
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
