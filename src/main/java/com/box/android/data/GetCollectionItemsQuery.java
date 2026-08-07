package com.box.android.data;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.Query;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.box.android.data.adapter.GetCollectionItemsQuery_ResponseAdapter;
import com.box.android.data.adapter.GetCollectionItemsQuery_VariablesAdapter;
import com.box.android.data.datasource.gql.cache.GQLCacheConstants;
import com.box.android.data.selections.GetCollectionItemsQuerySelections;
import com.box.android.data.type.ItemType;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.box.androidsdk.content.models.BoxCollection;
import java.util.Date;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GetCollectionItemsQuery.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\b\u0086\b\u0018\u0000 62\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0019\u001e\u001f !\"#$%&'()*+,-./0123456B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u00067"}, d2 = {"Lcom/box/android/data/GetCollectionItemsQuery;", "Lcom/apollographql/apollo3/api/Query;", "Lcom/box/android/data/GetCollectionItemsQuery$Data;", "id", "", "<init>", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "document", "name", "serializeVariables", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "adapter", "Lcom/apollographql/apollo3/api/Adapter;", "rootField", "Lcom/apollographql/apollo3/api/CompiledField;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "Data", "Collection", "CollectionItemConnection", "Edge", "Node", "OnFile", "OwnedBy", "UpdatedBy", "Watermark", "Parent", "PermissionsV2Api", "SharedLink", "OnFolder", "OwnedBy1", "UpdatedBy1", "Parent1", "PermissionsV2Api1", "SharedLink1", "OnWeblink", "OwnedBy2", "UpdatedBy2", "Parent2", "PermissionsV2Api2", "SharedLink2", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class GetCollectionItemsQuery implements Query<Data> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String OPERATION_ID = "db9e610aed0c585e86adc045fab7930f95b137ceb120287d114fcc8da7b52310";
    public static final String OPERATION_NAME = "GetCollectionItems";
    private final String id;

    public static /* synthetic */ GetCollectionItemsQuery copy$default(GetCollectionItemsQuery getCollectionItemsQuery, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = getCollectionItemsQuery.id;
        }
        return getCollectionItemsQuery.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final GetCollectionItemsQuery copy(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return new GetCollectionItemsQuery(id);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof GetCollectionItemsQuery) && Intrinsics.areEqual(this.id, ((GetCollectionItemsQuery) other).id);
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public String toString() {
        return "GetCollectionItemsQuery(id=" + this.id + ")";
    }

    public GetCollectionItemsQuery(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
    }

    public final String getId() {
        return this.id;
    }

    @Override // com.apollographql.apollo3.api.Operation
    public String id() {
        return OPERATION_ID;
    }

    @Override // com.apollographql.apollo3.api.Operation
    public String document() {
        return INSTANCE.getOPERATION_DOCUMENT();
    }

    @Override // com.apollographql.apollo3.api.Operation
    public String name() {
        return OPERATION_NAME;
    }

    @Override // com.apollographql.apollo3.api.Operation, com.apollographql.apollo3.api.Executable
    public void serializeVariables(JsonWriter writer, CustomScalarAdapters customScalarAdapters) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
        GetCollectionItemsQuery_VariablesAdapter.INSTANCE.toJson(writer, customScalarAdapters, this);
    }

    @Override // com.apollographql.apollo3.api.Operation, com.apollographql.apollo3.api.Executable
    public Adapter<Data> adapter() {
        return Adapters.m11187obj$default(GetCollectionItemsQuery_ResponseAdapter.Data.INSTANCE, false, 1, null);
    }

    @Override // com.apollographql.apollo3.api.Operation, com.apollographql.apollo3.api.Executable
    public CompiledField rootField() {
        return new CompiledField.Builder("data", com.box.android.data.type.Query.INSTANCE.getType()).selections(GetCollectionItemsQuerySelections.INSTANCE.get__root()).build();
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/GetCollectionItemsQuery$Data;", "Lcom/apollographql/apollo3/api/Query$Data;", BoxCollection.TYPE, "Lcom/box/android/data/GetCollectionItemsQuery$Collection;", "<init>", "(Lcom/box/android/data/GetCollectionItemsQuery$Collection;)V", "getCollection", "()Lcom/box/android/data/GetCollectionItemsQuery$Collection;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Data implements Query.Data {
        private final Collection collection;

        public static /* synthetic */ Data copy$default(Data data, Collection collection, int i, Object obj) {
            if ((i & 1) != 0) {
                collection = data.collection;
            }
            return data.copy(collection);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Collection getCollection() {
            return this.collection;
        }

        public final Data copy(Collection collection) {
            return new Data(collection);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Data) && Intrinsics.areEqual(this.collection, ((Data) other).collection);
        }

        public int hashCode() {
            Collection collection = this.collection;
            if (collection == null) {
                return 0;
            }
            return collection.hashCode();
        }

        public String toString() {
            return "Data(collection=" + this.collection + ")";
        }

        public Data(Collection collection) {
            this.collection = collection;
        }

        public final Collection getCollection() {
            return this.collection;
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/box/android/data/GetCollectionItemsQuery$Collection;", "", "id", "", "collectionItemConnection", "Lcom/box/android/data/GetCollectionItemsQuery$CollectionItemConnection;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/GetCollectionItemsQuery$CollectionItemConnection;)V", "getId", "()Ljava/lang/String;", "getCollectionItemConnection$annotations", "()V", "getCollectionItemConnection", "()Lcom/box/android/data/GetCollectionItemsQuery$CollectionItemConnection;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Collection {
        private final CollectionItemConnection collectionItemConnection;
        private final String id;

        public static /* synthetic */ Collection copy$default(Collection collection, String str, CollectionItemConnection collectionItemConnection, int i, Object obj) {
            if ((i & 1) != 0) {
                str = collection.id;
            }
            if ((i & 2) != 0) {
                collectionItemConnection = collection.collectionItemConnection;
            }
            return collection.copy(str, collectionItemConnection);
        }

        @Deprecated(message = "use itemConnection")
        public static /* synthetic */ void getCollectionItemConnection$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final CollectionItemConnection getCollectionItemConnection() {
            return this.collectionItemConnection;
        }

        public final Collection copy(String id, CollectionItemConnection collectionItemConnection) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Collection(id, collectionItemConnection);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Collection)) {
                return false;
            }
            Collection collection = (Collection) other;
            return Intrinsics.areEqual(this.id, collection.id) && Intrinsics.areEqual(this.collectionItemConnection, collection.collectionItemConnection);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            CollectionItemConnection collectionItemConnection = this.collectionItemConnection;
            return iHashCode + (collectionItemConnection == null ? 0 : collectionItemConnection.hashCode());
        }

        public String toString() {
            return "Collection(id=" + this.id + ", collectionItemConnection=" + this.collectionItemConnection + ")";
        }

        public Collection(String id, CollectionItemConnection collectionItemConnection) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
            this.collectionItemConnection = collectionItemConnection;
        }

        public final String getId() {
            return this.id;
        }

        public final CollectionItemConnection getCollectionItemConnection() {
            return this.collectionItemConnection;
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/GetCollectionItemsQuery$CollectionItemConnection;", "", "edges", "", "Lcom/box/android/data/GetCollectionItemsQuery$Edge;", "<init>", "(Ljava/util/List;)V", "getEdges", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class CollectionItemConnection {
        private final List<Edge> edges;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CollectionItemConnection copy$default(CollectionItemConnection collectionItemConnection, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = collectionItemConnection.edges;
            }
            return collectionItemConnection.copy(list);
        }

        public final List<Edge> component1() {
            return this.edges;
        }

        public final CollectionItemConnection copy(List<Edge> edges) {
            Intrinsics.checkNotNullParameter(edges, "edges");
            return new CollectionItemConnection(edges);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CollectionItemConnection) && Intrinsics.areEqual(this.edges, ((CollectionItemConnection) other).edges);
        }

        public int hashCode() {
            return this.edges.hashCode();
        }

        public String toString() {
            return "CollectionItemConnection(edges=" + this.edges + ")";
        }

        public CollectionItemConnection(List<Edge> edges) {
            Intrinsics.checkNotNullParameter(edges, "edges");
            this.edges = edges;
        }

        public final List<Edge> getEdges() {
            return this.edges;
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/GetCollectionItemsQuery$Edge;", "", "id", "", "node", "Lcom/box/android/data/GetCollectionItemsQuery$Node;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/GetCollectionItemsQuery$Node;)V", "getId", "()Ljava/lang/String;", "getNode", "()Lcom/box/android/data/GetCollectionItemsQuery$Node;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Edge {
        private final String id;
        private final Node node;

        public static /* synthetic */ Edge copy$default(Edge edge, String str, Node node, int i, Object obj) {
            if ((i & 1) != 0) {
                str = edge.id;
            }
            if ((i & 2) != 0) {
                node = edge.node;
            }
            return edge.copy(str, node);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Node getNode() {
            return this.node;
        }

        public final Edge copy(String id, Node node) {
            Intrinsics.checkNotNullParameter(node, "node");
            return new Edge(id, node);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Edge)) {
                return false;
            }
            Edge edge = (Edge) other;
            return Intrinsics.areEqual(this.id, edge.id) && Intrinsics.areEqual(this.node, edge.node);
        }

        public int hashCode() {
            String str = this.id;
            return ((str == null ? 0 : str.hashCode()) * 31) + this.node.hashCode();
        }

        public String toString() {
            return "Edge(id=" + this.id + ", node=" + this.node + ")";
        }

        public Edge(String str, Node node) {
            Intrinsics.checkNotNullParameter(node, "node");
            this.id = str;
            this.node = node;
        }

        public final String getId() {
            return this.id;
        }

        public final Node getNode() {
            return this.node;
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/box/android/data/GetCollectionItemsQuery$Node;", "", GQLCacheConstants.TYPENAME_KEY, "", "onFile", "Lcom/box/android/data/GetCollectionItemsQuery$OnFile;", "onFolder", "Lcom/box/android/data/GetCollectionItemsQuery$OnFolder;", "onWeblink", "Lcom/box/android/data/GetCollectionItemsQuery$OnWeblink;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/GetCollectionItemsQuery$OnFile;Lcom/box/android/data/GetCollectionItemsQuery$OnFolder;Lcom/box/android/data/GetCollectionItemsQuery$OnWeblink;)V", "get__typename", "()Ljava/lang/String;", "getOnFile", "()Lcom/box/android/data/GetCollectionItemsQuery$OnFile;", "getOnFolder", "()Lcom/box/android/data/GetCollectionItemsQuery$OnFolder;", "getOnWeblink", "()Lcom/box/android/data/GetCollectionItemsQuery$OnWeblink;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Node {
        private final String __typename;
        private final OnFile onFile;
        private final OnFolder onFolder;
        private final OnWeblink onWeblink;

        public static /* synthetic */ Node copy$default(Node node, String str, OnFile onFile, OnFolder onFolder, OnWeblink onWeblink, int i, Object obj) {
            if ((i & 1) != 0) {
                str = node.__typename;
            }
            if ((i & 2) != 0) {
                onFile = node.onFile;
            }
            if ((i & 4) != 0) {
                onFolder = node.onFolder;
            }
            if ((i & 8) != 0) {
                onWeblink = node.onWeblink;
            }
            return node.copy(str, onFile, onFolder, onWeblink);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String get__typename() {
            return this.__typename;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final OnFile getOnFile() {
            return this.onFile;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final OnFolder getOnFolder() {
            return this.onFolder;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final OnWeblink getOnWeblink() {
            return this.onWeblink;
        }

        public final Node copy(String __typename, OnFile onFile, OnFolder onFolder, OnWeblink onWeblink) {
            Intrinsics.checkNotNullParameter(__typename, "__typename");
            return new Node(__typename, onFile, onFolder, onWeblink);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Node)) {
                return false;
            }
            Node node = (Node) other;
            return Intrinsics.areEqual(this.__typename, node.__typename) && Intrinsics.areEqual(this.onFile, node.onFile) && Intrinsics.areEqual(this.onFolder, node.onFolder) && Intrinsics.areEqual(this.onWeblink, node.onWeblink);
        }

        public int hashCode() {
            int iHashCode = this.__typename.hashCode() * 31;
            OnFile onFile = this.onFile;
            int iHashCode2 = (iHashCode + (onFile == null ? 0 : onFile.hashCode())) * 31;
            OnFolder onFolder = this.onFolder;
            int iHashCode3 = (iHashCode2 + (onFolder == null ? 0 : onFolder.hashCode())) * 31;
            OnWeblink onWeblink = this.onWeblink;
            return iHashCode3 + (onWeblink != null ? onWeblink.hashCode() : 0);
        }

        public String toString() {
            return "Node(__typename=" + this.__typename + ", onFile=" + this.onFile + ", onFolder=" + this.onFolder + ", onWeblink=" + this.onWeblink + ")";
        }

        public Node(String __typename, OnFile onFile, OnFolder onFolder, OnWeblink onWeblink) {
            Intrinsics.checkNotNullParameter(__typename, "__typename");
            this.__typename = __typename;
            this.onFile = onFile;
            this.onFolder = onFolder;
            this.onWeblink = onWeblink;
        }

        public final String get__typename() {
            return this.__typename;
        }

        public final OnFile getOnFile() {
            return this.onFile;
        }

        public final OnFolder getOnFolder() {
            return this.onFolder;
        }

        public final OnWeblink getOnWeblink() {
            return this.onWeblink;
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery.kt */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u00ad\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u00100J\u0010\u0010F\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u00100J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u001cHÆ\u0003JÖ\u0001\u0010L\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÆ\u0001¢\u0006\u0002\u0010MJ\u0013\u0010N\u001a\u00020\u00122\b\u0010O\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010P\u001a\u00020QHÖ\u0001J\t\u0010R\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b)\u0010'R\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b*\u0010'R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u00101\u001a\u0004\b/\u00100R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u00101\u001a\u0004\b\u0013\u00100R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010 R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:¨\u0006S"}, d2 = {"Lcom/box/android/data/GetCollectionItemsQuery$OnFile;", "", "id", "", "type", "Lcom/box/android/data/type/ItemType;", "name", "size", "createdAt", "Ljava/util/Date;", "updatedAt", "contentCreatedAt", "contentUpdatedAt", "ownedBy", "Lcom/box/android/data/GetCollectionItemsQuery$OwnedBy;", "updatedBy", "Lcom/box/android/data/GetCollectionItemsQuery$UpdatedBy;", "hasCollaborations", "", "isExternallyOwned", "sha1", "watermark", "Lcom/box/android/data/GetCollectionItemsQuery$Watermark;", "parent", "Lcom/box/android/data/GetCollectionItemsQuery$Parent;", "permissionsV2Api", "Lcom/box/android/data/GetCollectionItemsQuery$PermissionsV2Api;", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "Lcom/box/android/data/GetCollectionItemsQuery$SharedLink;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/type/ItemType;Ljava/lang/String;Ljava/lang/Object;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Lcom/box/android/data/GetCollectionItemsQuery$OwnedBy;Lcom/box/android/data/GetCollectionItemsQuery$UpdatedBy;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lcom/box/android/data/GetCollectionItemsQuery$Watermark;Lcom/box/android/data/GetCollectionItemsQuery$Parent;Lcom/box/android/data/GetCollectionItemsQuery$PermissionsV2Api;Lcom/box/android/data/GetCollectionItemsQuery$SharedLink;)V", "getId", "()Ljava/lang/String;", "getType", "()Lcom/box/android/data/type/ItemType;", "getName", "getSize", "()Ljava/lang/Object;", "getCreatedAt", "()Ljava/util/Date;", "getUpdatedAt", "getContentCreatedAt", "getContentUpdatedAt", "getOwnedBy", "()Lcom/box/android/data/GetCollectionItemsQuery$OwnedBy;", "getUpdatedBy", "()Lcom/box/android/data/GetCollectionItemsQuery$UpdatedBy;", "getHasCollaborations", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSha1", "getWatermark", "()Lcom/box/android/data/GetCollectionItemsQuery$Watermark;", "getParent", "()Lcom/box/android/data/GetCollectionItemsQuery$Parent;", "getPermissionsV2Api", "()Lcom/box/android/data/GetCollectionItemsQuery$PermissionsV2Api;", "getSharedLink", "()Lcom/box/android/data/GetCollectionItemsQuery$SharedLink;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Lcom/box/android/data/type/ItemType;Ljava/lang/String;Ljava/lang/Object;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Lcom/box/android/data/GetCollectionItemsQuery$OwnedBy;Lcom/box/android/data/GetCollectionItemsQuery$UpdatedBy;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lcom/box/android/data/GetCollectionItemsQuery$Watermark;Lcom/box/android/data/GetCollectionItemsQuery$Parent;Lcom/box/android/data/GetCollectionItemsQuery$PermissionsV2Api;Lcom/box/android/data/GetCollectionItemsQuery$SharedLink;)Lcom/box/android/data/GetCollectionItemsQuery$OnFile;", "equals", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnFile {
        private final Date contentCreatedAt;
        private final Date contentUpdatedAt;
        private final Date createdAt;
        private final Boolean hasCollaborations;
        private final String id;
        private final Boolean isExternallyOwned;
        private final String name;
        private final OwnedBy ownedBy;
        private final Parent parent;
        private final PermissionsV2Api permissionsV2Api;
        private final String sha1;
        private final SharedLink sharedLink;
        private final Object size;
        private final ItemType type;
        private final Date updatedAt;
        private final UpdatedBy updatedBy;
        private final Watermark watermark;

        public static /* synthetic */ OnFile copy$default(OnFile onFile, String str, ItemType itemType, String str2, Object obj, Date date, Date date2, Date date3, Date date4, OwnedBy ownedBy, UpdatedBy updatedBy, Boolean bool, Boolean bool2, String str3, Watermark watermark, Parent parent, PermissionsV2Api permissionsV2Api, SharedLink sharedLink, int i, Object obj2) {
            SharedLink sharedLink2;
            PermissionsV2Api permissionsV2Api2;
            String str4 = (i & 1) != 0 ? onFile.id : str;
            ItemType itemType2 = (i & 2) != 0 ? onFile.type : itemType;
            String str5 = (i & 4) != 0 ? onFile.name : str2;
            Object obj3 = (i & 8) != 0 ? onFile.size : obj;
            Date date5 = (i & 16) != 0 ? onFile.createdAt : date;
            Date date6 = (i & 32) != 0 ? onFile.updatedAt : date2;
            Date date7 = (i & 64) != 0 ? onFile.contentCreatedAt : date3;
            Date date8 = (i & 128) != 0 ? onFile.contentUpdatedAt : date4;
            OwnedBy ownedBy2 = (i & 256) != 0 ? onFile.ownedBy : ownedBy;
            UpdatedBy updatedBy2 = (i & 512) != 0 ? onFile.updatedBy : updatedBy;
            Boolean bool3 = (i & 1024) != 0 ? onFile.hasCollaborations : bool;
            Boolean bool4 = (i & 2048) != 0 ? onFile.isExternallyOwned : bool2;
            String str6 = (i & 4096) != 0 ? onFile.sha1 : str3;
            Watermark watermark2 = (i & 8192) != 0 ? onFile.watermark : watermark;
            String str7 = str4;
            Parent parent2 = (i & 16384) != 0 ? onFile.parent : parent;
            PermissionsV2Api permissionsV2Api3 = (i & 32768) != 0 ? onFile.permissionsV2Api : permissionsV2Api;
            if ((i & 65536) != 0) {
                permissionsV2Api2 = permissionsV2Api3;
                sharedLink2 = onFile.sharedLink;
            } else {
                sharedLink2 = sharedLink;
                permissionsV2Api2 = permissionsV2Api3;
            }
            return onFile.copy(str7, itemType2, str5, obj3, date5, date6, date7, date8, ownedBy2, updatedBy2, bool3, bool4, str6, watermark2, parent2, permissionsV2Api2, sharedLink2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final UpdatedBy getUpdatedBy() {
            return this.updatedBy;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Boolean getHasCollaborations() {
            return this.hasCollaborations;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final Boolean getIsExternallyOwned() {
            return this.isExternallyOwned;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final String getSha1() {
            return this.sha1;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final Watermark getWatermark() {
            return this.watermark;
        }

        /* JADX INFO: renamed from: component15, reason: from getter */
        public final Parent getParent() {
            return this.parent;
        }

        /* JADX INFO: renamed from: component16, reason: from getter */
        public final PermissionsV2Api getPermissionsV2Api() {
            return this.permissionsV2Api;
        }

        /* JADX INFO: renamed from: component17, reason: from getter */
        public final SharedLink getSharedLink() {
            return this.sharedLink;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ItemType getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Object getSize() {
            return this.size;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Date getCreatedAt() {
            return this.createdAt;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Date getUpdatedAt() {
            return this.updatedAt;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Date getContentCreatedAt() {
            return this.contentCreatedAt;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Date getContentUpdatedAt() {
            return this.contentUpdatedAt;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final OwnedBy getOwnedBy() {
            return this.ownedBy;
        }

        public final OnFile copy(String id, ItemType type, String name, Object size, Date createdAt, Date updatedAt, Date contentCreatedAt, Date contentUpdatedAt, OwnedBy ownedBy, UpdatedBy updatedBy, Boolean hasCollaborations, Boolean isExternallyOwned, String sha1, Watermark watermark, Parent parent, PermissionsV2Api permissionsV2Api, SharedLink sharedLink) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            return new OnFile(id, type, name, size, createdAt, updatedAt, contentCreatedAt, contentUpdatedAt, ownedBy, updatedBy, hasCollaborations, isExternallyOwned, sha1, watermark, parent, permissionsV2Api, sharedLink);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnFile)) {
                return false;
            }
            OnFile onFile = (OnFile) other;
            return Intrinsics.areEqual(this.id, onFile.id) && this.type == onFile.type && Intrinsics.areEqual(this.name, onFile.name) && Intrinsics.areEqual(this.size, onFile.size) && Intrinsics.areEqual(this.createdAt, onFile.createdAt) && Intrinsics.areEqual(this.updatedAt, onFile.updatedAt) && Intrinsics.areEqual(this.contentCreatedAt, onFile.contentCreatedAt) && Intrinsics.areEqual(this.contentUpdatedAt, onFile.contentUpdatedAt) && Intrinsics.areEqual(this.ownedBy, onFile.ownedBy) && Intrinsics.areEqual(this.updatedBy, onFile.updatedBy) && Intrinsics.areEqual(this.hasCollaborations, onFile.hasCollaborations) && Intrinsics.areEqual(this.isExternallyOwned, onFile.isExternallyOwned) && Intrinsics.areEqual(this.sha1, onFile.sha1) && Intrinsics.areEqual(this.watermark, onFile.watermark) && Intrinsics.areEqual(this.parent, onFile.parent) && Intrinsics.areEqual(this.permissionsV2Api, onFile.permissionsV2Api) && Intrinsics.areEqual(this.sharedLink, onFile.sharedLink);
        }

        public int hashCode() {
            int iHashCode = ((this.id.hashCode() * 31) + this.type.hashCode()) * 31;
            String str = this.name;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Object obj = this.size;
            int iHashCode3 = (iHashCode2 + (obj == null ? 0 : obj.hashCode())) * 31;
            Date date = this.createdAt;
            int iHashCode4 = (iHashCode3 + (date == null ? 0 : date.hashCode())) * 31;
            Date date2 = this.updatedAt;
            int iHashCode5 = (iHashCode4 + (date2 == null ? 0 : date2.hashCode())) * 31;
            Date date3 = this.contentCreatedAt;
            int iHashCode6 = (iHashCode5 + (date3 == null ? 0 : date3.hashCode())) * 31;
            Date date4 = this.contentUpdatedAt;
            int iHashCode7 = (iHashCode6 + (date4 == null ? 0 : date4.hashCode())) * 31;
            OwnedBy ownedBy = this.ownedBy;
            int iHashCode8 = (iHashCode7 + (ownedBy == null ? 0 : ownedBy.hashCode())) * 31;
            UpdatedBy updatedBy = this.updatedBy;
            int iHashCode9 = (iHashCode8 + (updatedBy == null ? 0 : updatedBy.hashCode())) * 31;
            Boolean bool = this.hasCollaborations;
            int iHashCode10 = (iHashCode9 + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.isExternallyOwned;
            int iHashCode11 = (iHashCode10 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            String str2 = this.sha1;
            int iHashCode12 = (iHashCode11 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Watermark watermark = this.watermark;
            int iHashCode13 = (iHashCode12 + (watermark == null ? 0 : watermark.hashCode())) * 31;
            Parent parent = this.parent;
            int iHashCode14 = (iHashCode13 + (parent == null ? 0 : parent.hashCode())) * 31;
            PermissionsV2Api permissionsV2Api = this.permissionsV2Api;
            int iHashCode15 = (iHashCode14 + (permissionsV2Api == null ? 0 : permissionsV2Api.hashCode())) * 31;
            SharedLink sharedLink = this.sharedLink;
            return iHashCode15 + (sharedLink != null ? sharedLink.hashCode() : 0);
        }

        public String toString() {
            return "OnFile(id=" + this.id + ", type=" + this.type + ", name=" + this.name + ", size=" + this.size + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", contentCreatedAt=" + this.contentCreatedAt + ", contentUpdatedAt=" + this.contentUpdatedAt + ", ownedBy=" + this.ownedBy + ", updatedBy=" + this.updatedBy + ", hasCollaborations=" + this.hasCollaborations + ", isExternallyOwned=" + this.isExternallyOwned + ", sha1=" + this.sha1 + ", watermark=" + this.watermark + ", parent=" + this.parent + ", permissionsV2Api=" + this.permissionsV2Api + ", sharedLink=" + this.sharedLink + ")";
        }

        public OnFile(String id, ItemType type, String str, Object obj, Date date, Date date2, Date date3, Date date4, OwnedBy ownedBy, UpdatedBy updatedBy, Boolean bool, Boolean bool2, String str2, Watermark watermark, Parent parent, PermissionsV2Api permissionsV2Api, SharedLink sharedLink) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            this.id = id;
            this.type = type;
            this.name = str;
            this.size = obj;
            this.createdAt = date;
            this.updatedAt = date2;
            this.contentCreatedAt = date3;
            this.contentUpdatedAt = date4;
            this.ownedBy = ownedBy;
            this.updatedBy = updatedBy;
            this.hasCollaborations = bool;
            this.isExternallyOwned = bool2;
            this.sha1 = str2;
            this.watermark = watermark;
            this.parent = parent;
            this.permissionsV2Api = permissionsV2Api;
            this.sharedLink = sharedLink;
        }

        public final String getId() {
            return this.id;
        }

        public final ItemType getType() {
            return this.type;
        }

        public final String getName() {
            return this.name;
        }

        public final Object getSize() {
            return this.size;
        }

        public final Date getCreatedAt() {
            return this.createdAt;
        }

        public final Date getUpdatedAt() {
            return this.updatedAt;
        }

        public final Date getContentCreatedAt() {
            return this.contentCreatedAt;
        }

        public final Date getContentUpdatedAt() {
            return this.contentUpdatedAt;
        }

        public final OwnedBy getOwnedBy() {
            return this.ownedBy;
        }

        public final UpdatedBy getUpdatedBy() {
            return this.updatedBy;
        }

        public final Boolean getHasCollaborations() {
            return this.hasCollaborations;
        }

        public final Boolean isExternallyOwned() {
            return this.isExternallyOwned;
        }

        public final String getSha1() {
            return this.sha1;
        }

        public final Watermark getWatermark() {
            return this.watermark;
        }

        public final Parent getParent() {
            return this.parent;
        }

        public final PermissionsV2Api getPermissionsV2Api() {
            return this.permissionsV2Api;
        }

        public final SharedLink getSharedLink() {
            return this.sharedLink;
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/box/android/data/GetCollectionItemsQuery$OwnedBy;", "", "id", "", "<init>", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OwnedBy {
        private final String id;

        public static /* synthetic */ OwnedBy copy$default(OwnedBy ownedBy, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = ownedBy.id;
            }
            return ownedBy.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        public final OwnedBy copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new OwnedBy(id);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OwnedBy) && Intrinsics.areEqual(this.id, ((OwnedBy) other).id);
        }

        public int hashCode() {
            return this.id.hashCode();
        }

        public String toString() {
            return "OwnedBy(id=" + this.id + ")";
        }

        public OwnedBy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public final String getId() {
            return this.id;
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/GetCollectionItemsQuery$UpdatedBy;", "", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class UpdatedBy {
        private final String id;
        private final String name;

        public static /* synthetic */ UpdatedBy copy$default(UpdatedBy updatedBy, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = updatedBy.id;
            }
            if ((i & 2) != 0) {
                str2 = updatedBy.name;
            }
            return updatedBy.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final UpdatedBy copy(String id, String name) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new UpdatedBy(id, name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdatedBy)) {
                return false;
            }
            UpdatedBy updatedBy = (UpdatedBy) other;
            return Intrinsics.areEqual(this.id, updatedBy.id) && Intrinsics.areEqual(this.name, updatedBy.name);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.name;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "UpdatedBy(id=" + this.id + ", name=" + this.name + ")";
        }

        public UpdatedBy(String id, String str) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
            this.name = str;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/GetCollectionItemsQuery$Watermark;", "", "isWatermarked", "", "<init>", "(Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Boolean;)Lcom/box/android/data/GetCollectionItemsQuery$Watermark;", "equals", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Watermark {
        private final Boolean isWatermarked;

        public static /* synthetic */ Watermark copy$default(Watermark watermark, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = watermark.isWatermarked;
            }
            return watermark.copy(bool);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Boolean getIsWatermarked() {
            return this.isWatermarked;
        }

        public final Watermark copy(Boolean isWatermarked) {
            return new Watermark(isWatermarked);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Watermark) && Intrinsics.areEqual(this.isWatermarked, ((Watermark) other).isWatermarked);
        }

        public int hashCode() {
            Boolean bool = this.isWatermarked;
            if (bool == null) {
                return 0;
            }
            return bool.hashCode();
        }

        public String toString() {
            return "Watermark(isWatermarked=" + this.isWatermarked + ")";
        }

        public Watermark(Boolean bool) {
            this.isWatermarked = bool;
        }

        public final Boolean isWatermarked() {
            return this.isWatermarked;
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/GetCollectionItemsQuery$Parent;", "", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Parent {
        private final String id;
        private final String name;

        public static /* synthetic */ Parent copy$default(Parent parent, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = parent.id;
            }
            if ((i & 2) != 0) {
                str2 = parent.name;
            }
            return parent.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final Parent copy(String id, String name) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Parent(id, name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Parent)) {
                return false;
            }
            Parent parent = (Parent) other;
            return Intrinsics.areEqual(this.id, parent.id) && Intrinsics.areEqual(this.name, parent.name);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.name;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Parent(id=" + this.id + ", name=" + this.name + ")";
        }

        public Parent(String id, String str) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
            this.name = str;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b)\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0092\u0001\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u0011R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u0011R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0016\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0017\u0010\u0011R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0018\u0010\u0011R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0019\u0010\u0011R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001a\u0010\u0011R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001b\u0010\u0011R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001c\u0010\u0011¨\u00060"}, d2 = {"Lcom/box/android/data/GetCollectionItemsQuery$PermissionsV2Api;", "", "canInviteCollaborator", "", "canSetShareAccess", "canDownload", "canPreview", "canComment", "canUpload", "canRename", "canDelete", "canShare", "canViewAnnotations", "canCreateAnnotations", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getCanInviteCollaborator", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCanSetShareAccess", "getCanDownload", "getCanPreview", "getCanComment", "getCanUpload", "getCanRename", "getCanDelete", "getCanShare", "getCanViewAnnotations", "getCanCreateAnnotations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/box/android/data/GetCollectionItemsQuery$PermissionsV2Api;", "equals", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PermissionsV2Api {
        private final Boolean canComment;
        private final Boolean canCreateAnnotations;
        private final Boolean canDelete;
        private final Boolean canDownload;
        private final Boolean canInviteCollaborator;
        private final Boolean canPreview;
        private final Boolean canRename;
        private final Boolean canSetShareAccess;
        private final Boolean canShare;
        private final Boolean canUpload;
        private final Boolean canViewAnnotations;

        public static /* synthetic */ PermissionsV2Api copy$default(PermissionsV2Api permissionsV2Api, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = permissionsV2Api.canInviteCollaborator;
            }
            if ((i & 2) != 0) {
                bool2 = permissionsV2Api.canSetShareAccess;
            }
            if ((i & 4) != 0) {
                bool3 = permissionsV2Api.canDownload;
            }
            if ((i & 8) != 0) {
                bool4 = permissionsV2Api.canPreview;
            }
            if ((i & 16) != 0) {
                bool5 = permissionsV2Api.canComment;
            }
            if ((i & 32) != 0) {
                bool6 = permissionsV2Api.canUpload;
            }
            if ((i & 64) != 0) {
                bool7 = permissionsV2Api.canRename;
            }
            if ((i & 128) != 0) {
                bool8 = permissionsV2Api.canDelete;
            }
            if ((i & 256) != 0) {
                bool9 = permissionsV2Api.canShare;
            }
            if ((i & 512) != 0) {
                bool10 = permissionsV2Api.canViewAnnotations;
            }
            if ((i & 1024) != 0) {
                bool11 = permissionsV2Api.canCreateAnnotations;
            }
            Boolean bool12 = bool10;
            Boolean bool13 = bool11;
            Boolean bool14 = bool8;
            Boolean bool15 = bool9;
            Boolean bool16 = bool6;
            Boolean bool17 = bool7;
            Boolean bool18 = bool5;
            Boolean bool19 = bool3;
            return permissionsV2Api.copy(bool, bool2, bool19, bool4, bool18, bool16, bool17, bool14, bool15, bool12, bool13);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Boolean getCanInviteCollaborator() {
            return this.canInviteCollaborator;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Boolean getCanViewAnnotations() {
            return this.canViewAnnotations;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Boolean getCanCreateAnnotations() {
            return this.canCreateAnnotations;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Boolean getCanSetShareAccess() {
            return this.canSetShareAccess;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Boolean getCanDownload() {
            return this.canDownload;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Boolean getCanPreview() {
            return this.canPreview;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Boolean getCanComment() {
            return this.canComment;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Boolean getCanUpload() {
            return this.canUpload;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Boolean getCanRename() {
            return this.canRename;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Boolean getCanDelete() {
            return this.canDelete;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Boolean getCanShare() {
            return this.canShare;
        }

        public final PermissionsV2Api copy(Boolean canInviteCollaborator, Boolean canSetShareAccess, Boolean canDownload, Boolean canPreview, Boolean canComment, Boolean canUpload, Boolean canRename, Boolean canDelete, Boolean canShare, Boolean canViewAnnotations, Boolean canCreateAnnotations) {
            return new PermissionsV2Api(canInviteCollaborator, canSetShareAccess, canDownload, canPreview, canComment, canUpload, canRename, canDelete, canShare, canViewAnnotations, canCreateAnnotations);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PermissionsV2Api)) {
                return false;
            }
            PermissionsV2Api permissionsV2Api = (PermissionsV2Api) other;
            return Intrinsics.areEqual(this.canInviteCollaborator, permissionsV2Api.canInviteCollaborator) && Intrinsics.areEqual(this.canSetShareAccess, permissionsV2Api.canSetShareAccess) && Intrinsics.areEqual(this.canDownload, permissionsV2Api.canDownload) && Intrinsics.areEqual(this.canPreview, permissionsV2Api.canPreview) && Intrinsics.areEqual(this.canComment, permissionsV2Api.canComment) && Intrinsics.areEqual(this.canUpload, permissionsV2Api.canUpload) && Intrinsics.areEqual(this.canRename, permissionsV2Api.canRename) && Intrinsics.areEqual(this.canDelete, permissionsV2Api.canDelete) && Intrinsics.areEqual(this.canShare, permissionsV2Api.canShare) && Intrinsics.areEqual(this.canViewAnnotations, permissionsV2Api.canViewAnnotations) && Intrinsics.areEqual(this.canCreateAnnotations, permissionsV2Api.canCreateAnnotations);
        }

        public int hashCode() {
            Boolean bool = this.canInviteCollaborator;
            int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Boolean bool2 = this.canSetShareAccess;
            int iHashCode2 = (iHashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Boolean bool3 = this.canDownload;
            int iHashCode3 = (iHashCode2 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
            Boolean bool4 = this.canPreview;
            int iHashCode4 = (iHashCode3 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
            Boolean bool5 = this.canComment;
            int iHashCode5 = (iHashCode4 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
            Boolean bool6 = this.canUpload;
            int iHashCode6 = (iHashCode5 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
            Boolean bool7 = this.canRename;
            int iHashCode7 = (iHashCode6 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
            Boolean bool8 = this.canDelete;
            int iHashCode8 = (iHashCode7 + (bool8 == null ? 0 : bool8.hashCode())) * 31;
            Boolean bool9 = this.canShare;
            int iHashCode9 = (iHashCode8 + (bool9 == null ? 0 : bool9.hashCode())) * 31;
            Boolean bool10 = this.canViewAnnotations;
            int iHashCode10 = (iHashCode9 + (bool10 == null ? 0 : bool10.hashCode())) * 31;
            Boolean bool11 = this.canCreateAnnotations;
            return iHashCode10 + (bool11 != null ? bool11.hashCode() : 0);
        }

        public String toString() {
            return "PermissionsV2Api(canInviteCollaborator=" + this.canInviteCollaborator + ", canSetShareAccess=" + this.canSetShareAccess + ", canDownload=" + this.canDownload + ", canPreview=" + this.canPreview + ", canComment=" + this.canComment + ", canUpload=" + this.canUpload + ", canRename=" + this.canRename + ", canDelete=" + this.canDelete + ", canShare=" + this.canShare + ", canViewAnnotations=" + this.canViewAnnotations + ", canCreateAnnotations=" + this.canCreateAnnotations + ")";
        }

        public PermissionsV2Api(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11) {
            this.canInviteCollaborator = bool;
            this.canSetShareAccess = bool2;
            this.canDownload = bool3;
            this.canPreview = bool4;
            this.canComment = bool5;
            this.canUpload = bool6;
            this.canRename = bool7;
            this.canDelete = bool8;
            this.canShare = bool9;
            this.canViewAnnotations = bool10;
            this.canCreateAnnotations = bool11;
        }

        public final Boolean getCanInviteCollaborator() {
            return this.canInviteCollaborator;
        }

        public final Boolean getCanSetShareAccess() {
            return this.canSetShareAccess;
        }

        public final Boolean getCanDownload() {
            return this.canDownload;
        }

        public final Boolean getCanPreview() {
            return this.canPreview;
        }

        public final Boolean getCanComment() {
            return this.canComment;
        }

        public final Boolean getCanUpload() {
            return this.canUpload;
        }

        public final Boolean getCanRename() {
            return this.canRename;
        }

        public final Boolean getCanDelete() {
            return this.canDelete;
        }

        public final Boolean getCanShare() {
            return this.canShare;
        }

        public final Boolean getCanViewAnnotations() {
            return this.canViewAnnotations;
        }

        public final Boolean getCanCreateAnnotations() {
            return this.canCreateAnnotations;
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011JV\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0006\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u0011¨\u0006#"}, d2 = {"Lcom/box/android/data/GetCollectionItemsQuery$SharedLink;", "", "url", "", "effectiveAccess", "effectivePermission", "isPasswordEnabled", "", "unsharedAt", "Ljava/util/Date;", "canDownload", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Date;Ljava/lang/Boolean;)V", "getUrl", "()Ljava/lang/String;", "getEffectiveAccess", "getEffectivePermission", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUnsharedAt", "()Ljava/util/Date;", "getCanDownload", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Date;Ljava/lang/Boolean;)Lcom/box/android/data/GetCollectionItemsQuery$SharedLink;", "equals", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SharedLink {
        private final Boolean canDownload;
        private final String effectiveAccess;
        private final String effectivePermission;
        private final Boolean isPasswordEnabled;
        private final Date unsharedAt;
        private final String url;

        public static /* synthetic */ SharedLink copy$default(SharedLink sharedLink, String str, String str2, String str3, Boolean bool, Date date, Boolean bool2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sharedLink.url;
            }
            if ((i & 2) != 0) {
                str2 = sharedLink.effectiveAccess;
            }
            if ((i & 4) != 0) {
                str3 = sharedLink.effectivePermission;
            }
            if ((i & 8) != 0) {
                bool = sharedLink.isPasswordEnabled;
            }
            if ((i & 16) != 0) {
                date = sharedLink.unsharedAt;
            }
            if ((i & 32) != 0) {
                bool2 = sharedLink.canDownload;
            }
            Date date2 = date;
            Boolean bool3 = bool2;
            return sharedLink.copy(str, str2, str3, bool, date2, bool3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getEffectiveAccess() {
            return this.effectiveAccess;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getEffectivePermission() {
            return this.effectivePermission;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Boolean getIsPasswordEnabled() {
            return this.isPasswordEnabled;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Date getUnsharedAt() {
            return this.unsharedAt;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Boolean getCanDownload() {
            return this.canDownload;
        }

        public final SharedLink copy(String url, String effectiveAccess, String effectivePermission, Boolean isPasswordEnabled, Date unsharedAt, Boolean canDownload) {
            return new SharedLink(url, effectiveAccess, effectivePermission, isPasswordEnabled, unsharedAt, canDownload);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SharedLink)) {
                return false;
            }
            SharedLink sharedLink = (SharedLink) other;
            return Intrinsics.areEqual(this.url, sharedLink.url) && Intrinsics.areEqual(this.effectiveAccess, sharedLink.effectiveAccess) && Intrinsics.areEqual(this.effectivePermission, sharedLink.effectivePermission) && Intrinsics.areEqual(this.isPasswordEnabled, sharedLink.isPasswordEnabled) && Intrinsics.areEqual(this.unsharedAt, sharedLink.unsharedAt) && Intrinsics.areEqual(this.canDownload, sharedLink.canDownload);
        }

        public int hashCode() {
            String str = this.url;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.effectiveAccess;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.effectivePermission;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Boolean bool = this.isPasswordEnabled;
            int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
            Date date = this.unsharedAt;
            int iHashCode5 = (iHashCode4 + (date == null ? 0 : date.hashCode())) * 31;
            Boolean bool2 = this.canDownload;
            return iHashCode5 + (bool2 != null ? bool2.hashCode() : 0);
        }

        public String toString() {
            return "SharedLink(url=" + this.url + ", effectiveAccess=" + this.effectiveAccess + ", effectivePermission=" + this.effectivePermission + ", isPasswordEnabled=" + this.isPasswordEnabled + ", unsharedAt=" + this.unsharedAt + ", canDownload=" + this.canDownload + ")";
        }

        public SharedLink(String str, String str2, String str3, Boolean bool, Date date, Boolean bool2) {
            this.url = str;
            this.effectiveAccess = str2;
            this.effectivePermission = str3;
            this.isPasswordEnabled = bool;
            this.unsharedAt = date;
            this.canDownload = bool2;
        }

        public final String getUrl() {
            return this.url;
        }

        public final String getEffectiveAccess() {
            return this.effectiveAccess;
        }

        public final String getEffectivePermission() {
            return this.effectivePermission;
        }

        public final Boolean isPasswordEnabled() {
            return this.isPasswordEnabled;
        }

        public final Date getUnsharedAt() {
            return this.unsharedAt;
        }

        public final Boolean getCanDownload() {
            return this.canDownload;
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery.kt */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0099\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010@\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010-J\u000b\u0010A\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0019HÆ\u0003J¾\u0001\u0010D\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÆ\u0001¢\u0006\u0002\u0010EJ\u0013\u0010F\u001a\u00020\u00122\b\u0010G\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010H\u001a\u00020IHÖ\u0001J\t\u0010J\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010$R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010.\u001a\u0004\b,\u0010-R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010.\u001a\u0004\b\u0013\u0010-R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b3\u00104¨\u0006K"}, d2 = {"Lcom/box/android/data/GetCollectionItemsQuery$OnFolder;", "", "id", "", "type", "Lcom/box/android/data/type/ItemType;", "name", "size", "createdAt", "Ljava/util/Date;", "updatedAt", "contentCreatedAt", "contentUpdatedAt", "ownedBy", "Lcom/box/android/data/GetCollectionItemsQuery$OwnedBy1;", "updatedBy", "Lcom/box/android/data/GetCollectionItemsQuery$UpdatedBy1;", "hasCollaborations", "", "isExternallyOwned", "parent", "Lcom/box/android/data/GetCollectionItemsQuery$Parent1;", "permissionsV2Api", "Lcom/box/android/data/GetCollectionItemsQuery$PermissionsV2Api1;", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "Lcom/box/android/data/GetCollectionItemsQuery$SharedLink1;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/type/ItemType;Ljava/lang/String;Ljava/lang/Object;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Lcom/box/android/data/GetCollectionItemsQuery$OwnedBy1;Lcom/box/android/data/GetCollectionItemsQuery$UpdatedBy1;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/box/android/data/GetCollectionItemsQuery$Parent1;Lcom/box/android/data/GetCollectionItemsQuery$PermissionsV2Api1;Lcom/box/android/data/GetCollectionItemsQuery$SharedLink1;)V", "getId", "()Ljava/lang/String;", "getType", "()Lcom/box/android/data/type/ItemType;", "getName", "getSize", "()Ljava/lang/Object;", "getCreatedAt", "()Ljava/util/Date;", "getUpdatedAt", "getContentCreatedAt", "getContentUpdatedAt", "getOwnedBy", "()Lcom/box/android/data/GetCollectionItemsQuery$OwnedBy1;", "getUpdatedBy", "()Lcom/box/android/data/GetCollectionItemsQuery$UpdatedBy1;", "getHasCollaborations", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getParent", "()Lcom/box/android/data/GetCollectionItemsQuery$Parent1;", "getPermissionsV2Api", "()Lcom/box/android/data/GetCollectionItemsQuery$PermissionsV2Api1;", "getSharedLink", "()Lcom/box/android/data/GetCollectionItemsQuery$SharedLink1;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Lcom/box/android/data/type/ItemType;Ljava/lang/String;Ljava/lang/Object;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Lcom/box/android/data/GetCollectionItemsQuery$OwnedBy1;Lcom/box/android/data/GetCollectionItemsQuery$UpdatedBy1;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/box/android/data/GetCollectionItemsQuery$Parent1;Lcom/box/android/data/GetCollectionItemsQuery$PermissionsV2Api1;Lcom/box/android/data/GetCollectionItemsQuery$SharedLink1;)Lcom/box/android/data/GetCollectionItemsQuery$OnFolder;", "equals", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnFolder {
        private final Date contentCreatedAt;
        private final Date contentUpdatedAt;
        private final Date createdAt;
        private final Boolean hasCollaborations;
        private final String id;
        private final Boolean isExternallyOwned;
        private final String name;
        private final OwnedBy1 ownedBy;
        private final Parent1 parent;
        private final PermissionsV2Api1 permissionsV2Api;
        private final SharedLink1 sharedLink;
        private final Object size;
        private final ItemType type;
        private final Date updatedAt;
        private final UpdatedBy1 updatedBy;

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final UpdatedBy1 getUpdatedBy() {
            return this.updatedBy;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Boolean getHasCollaborations() {
            return this.hasCollaborations;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final Boolean getIsExternallyOwned() {
            return this.isExternallyOwned;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final Parent1 getParent() {
            return this.parent;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final PermissionsV2Api1 getPermissionsV2Api() {
            return this.permissionsV2Api;
        }

        /* JADX INFO: renamed from: component15, reason: from getter */
        public final SharedLink1 getSharedLink() {
            return this.sharedLink;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ItemType getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Object getSize() {
            return this.size;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Date getCreatedAt() {
            return this.createdAt;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Date getUpdatedAt() {
            return this.updatedAt;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Date getContentCreatedAt() {
            return this.contentCreatedAt;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Date getContentUpdatedAt() {
            return this.contentUpdatedAt;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final OwnedBy1 getOwnedBy() {
            return this.ownedBy;
        }

        public final OnFolder copy(String id, ItemType type, String name, Object size, Date createdAt, Date updatedAt, Date contentCreatedAt, Date contentUpdatedAt, OwnedBy1 ownedBy, UpdatedBy1 updatedBy, Boolean hasCollaborations, Boolean isExternallyOwned, Parent1 parent, PermissionsV2Api1 permissionsV2Api, SharedLink1 sharedLink) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            return new OnFolder(id, type, name, size, createdAt, updatedAt, contentCreatedAt, contentUpdatedAt, ownedBy, updatedBy, hasCollaborations, isExternallyOwned, parent, permissionsV2Api, sharedLink);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnFolder)) {
                return false;
            }
            OnFolder onFolder = (OnFolder) other;
            return Intrinsics.areEqual(this.id, onFolder.id) && this.type == onFolder.type && Intrinsics.areEqual(this.name, onFolder.name) && Intrinsics.areEqual(this.size, onFolder.size) && Intrinsics.areEqual(this.createdAt, onFolder.createdAt) && Intrinsics.areEqual(this.updatedAt, onFolder.updatedAt) && Intrinsics.areEqual(this.contentCreatedAt, onFolder.contentCreatedAt) && Intrinsics.areEqual(this.contentUpdatedAt, onFolder.contentUpdatedAt) && Intrinsics.areEqual(this.ownedBy, onFolder.ownedBy) && Intrinsics.areEqual(this.updatedBy, onFolder.updatedBy) && Intrinsics.areEqual(this.hasCollaborations, onFolder.hasCollaborations) && Intrinsics.areEqual(this.isExternallyOwned, onFolder.isExternallyOwned) && Intrinsics.areEqual(this.parent, onFolder.parent) && Intrinsics.areEqual(this.permissionsV2Api, onFolder.permissionsV2Api) && Intrinsics.areEqual(this.sharedLink, onFolder.sharedLink);
        }

        public int hashCode() {
            int iHashCode = ((this.id.hashCode() * 31) + this.type.hashCode()) * 31;
            String str = this.name;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Object obj = this.size;
            int iHashCode3 = (iHashCode2 + (obj == null ? 0 : obj.hashCode())) * 31;
            Date date = this.createdAt;
            int iHashCode4 = (iHashCode3 + (date == null ? 0 : date.hashCode())) * 31;
            Date date2 = this.updatedAt;
            int iHashCode5 = (iHashCode4 + (date2 == null ? 0 : date2.hashCode())) * 31;
            Date date3 = this.contentCreatedAt;
            int iHashCode6 = (iHashCode5 + (date3 == null ? 0 : date3.hashCode())) * 31;
            Date date4 = this.contentUpdatedAt;
            int iHashCode7 = (iHashCode6 + (date4 == null ? 0 : date4.hashCode())) * 31;
            OwnedBy1 ownedBy1 = this.ownedBy;
            int iHashCode8 = (iHashCode7 + (ownedBy1 == null ? 0 : ownedBy1.hashCode())) * 31;
            UpdatedBy1 updatedBy1 = this.updatedBy;
            int iHashCode9 = (iHashCode8 + (updatedBy1 == null ? 0 : updatedBy1.hashCode())) * 31;
            Boolean bool = this.hasCollaborations;
            int iHashCode10 = (iHashCode9 + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.isExternallyOwned;
            int iHashCode11 = (iHashCode10 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Parent1 parent1 = this.parent;
            int iHashCode12 = (iHashCode11 + (parent1 == null ? 0 : parent1.hashCode())) * 31;
            PermissionsV2Api1 permissionsV2Api1 = this.permissionsV2Api;
            int iHashCode13 = (iHashCode12 + (permissionsV2Api1 == null ? 0 : permissionsV2Api1.hashCode())) * 31;
            SharedLink1 sharedLink1 = this.sharedLink;
            return iHashCode13 + (sharedLink1 != null ? sharedLink1.hashCode() : 0);
        }

        public String toString() {
            return "OnFolder(id=" + this.id + ", type=" + this.type + ", name=" + this.name + ", size=" + this.size + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", contentCreatedAt=" + this.contentCreatedAt + ", contentUpdatedAt=" + this.contentUpdatedAt + ", ownedBy=" + this.ownedBy + ", updatedBy=" + this.updatedBy + ", hasCollaborations=" + this.hasCollaborations + ", isExternallyOwned=" + this.isExternallyOwned + ", parent=" + this.parent + ", permissionsV2Api=" + this.permissionsV2Api + ", sharedLink=" + this.sharedLink + ")";
        }

        public OnFolder(String id, ItemType type, String str, Object obj, Date date, Date date2, Date date3, Date date4, OwnedBy1 ownedBy1, UpdatedBy1 updatedBy1, Boolean bool, Boolean bool2, Parent1 parent1, PermissionsV2Api1 permissionsV2Api1, SharedLink1 sharedLink1) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            this.id = id;
            this.type = type;
            this.name = str;
            this.size = obj;
            this.createdAt = date;
            this.updatedAt = date2;
            this.contentCreatedAt = date3;
            this.contentUpdatedAt = date4;
            this.ownedBy = ownedBy1;
            this.updatedBy = updatedBy1;
            this.hasCollaborations = bool;
            this.isExternallyOwned = bool2;
            this.parent = parent1;
            this.permissionsV2Api = permissionsV2Api1;
            this.sharedLink = sharedLink1;
        }

        public final String getId() {
            return this.id;
        }

        public final ItemType getType() {
            return this.type;
        }

        public final String getName() {
            return this.name;
        }

        public final Object getSize() {
            return this.size;
        }

        public final Date getCreatedAt() {
            return this.createdAt;
        }

        public final Date getUpdatedAt() {
            return this.updatedAt;
        }

        public final Date getContentCreatedAt() {
            return this.contentCreatedAt;
        }

        public final Date getContentUpdatedAt() {
            return this.contentUpdatedAt;
        }

        public final OwnedBy1 getOwnedBy() {
            return this.ownedBy;
        }

        public final UpdatedBy1 getUpdatedBy() {
            return this.updatedBy;
        }

        public final Boolean getHasCollaborations() {
            return this.hasCollaborations;
        }

        public final Boolean isExternallyOwned() {
            return this.isExternallyOwned;
        }

        public final Parent1 getParent() {
            return this.parent;
        }

        public final PermissionsV2Api1 getPermissionsV2Api() {
            return this.permissionsV2Api;
        }

        public final SharedLink1 getSharedLink() {
            return this.sharedLink;
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/box/android/data/GetCollectionItemsQuery$OwnedBy1;", "", "id", "", "<init>", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OwnedBy1 {
        private final String id;

        public static /* synthetic */ OwnedBy1 copy$default(OwnedBy1 ownedBy1, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = ownedBy1.id;
            }
            return ownedBy1.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        public final OwnedBy1 copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new OwnedBy1(id);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OwnedBy1) && Intrinsics.areEqual(this.id, ((OwnedBy1) other).id);
        }

        public int hashCode() {
            return this.id.hashCode();
        }

        public String toString() {
            return "OwnedBy1(id=" + this.id + ")";
        }

        public OwnedBy1(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public final String getId() {
            return this.id;
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/GetCollectionItemsQuery$UpdatedBy1;", "", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class UpdatedBy1 {
        private final String id;
        private final String name;

        public static /* synthetic */ UpdatedBy1 copy$default(UpdatedBy1 updatedBy1, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = updatedBy1.id;
            }
            if ((i & 2) != 0) {
                str2 = updatedBy1.name;
            }
            return updatedBy1.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final UpdatedBy1 copy(String id, String name) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new UpdatedBy1(id, name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdatedBy1)) {
                return false;
            }
            UpdatedBy1 updatedBy1 = (UpdatedBy1) other;
            return Intrinsics.areEqual(this.id, updatedBy1.id) && Intrinsics.areEqual(this.name, updatedBy1.name);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.name;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "UpdatedBy1(id=" + this.id + ", name=" + this.name + ")";
        }

        public UpdatedBy1(String id, String str) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
            this.name = str;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/GetCollectionItemsQuery$Parent1;", "", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Parent1 {
        private final String id;
        private final String name;

        public static /* synthetic */ Parent1 copy$default(Parent1 parent1, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = parent1.id;
            }
            if ((i & 2) != 0) {
                str2 = parent1.name;
            }
            return parent1.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final Parent1 copy(String id, String name) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Parent1(id, name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Parent1)) {
                return false;
            }
            Parent1 parent1 = (Parent1) other;
            return Intrinsics.areEqual(this.id, parent1.id) && Intrinsics.areEqual(this.name, parent1.name);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.name;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Parent1(id=" + this.id + ", name=" + this.name + ")";
        }

        public Parent1(String id, String str) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
            this.name = str;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b)\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0092\u0001\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u0011R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u0011R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0016\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0017\u0010\u0011R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0018\u0010\u0011R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0019\u0010\u0011R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001a\u0010\u0011R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001b\u0010\u0011R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001c\u0010\u0011¨\u00060"}, d2 = {"Lcom/box/android/data/GetCollectionItemsQuery$PermissionsV2Api1;", "", "canInviteCollaborator", "", "canSetShareAccess", "canDownload", "canPreview", "canComment", "canUpload", "canRename", "canDelete", "canShare", "canViewAnnotations", "canCreateAnnotations", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getCanInviteCollaborator", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCanSetShareAccess", "getCanDownload", "getCanPreview", "getCanComment", "getCanUpload", "getCanRename", "getCanDelete", "getCanShare", "getCanViewAnnotations", "getCanCreateAnnotations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/box/android/data/GetCollectionItemsQuery$PermissionsV2Api1;", "equals", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PermissionsV2Api1 {
        private final Boolean canComment;
        private final Boolean canCreateAnnotations;
        private final Boolean canDelete;
        private final Boolean canDownload;
        private final Boolean canInviteCollaborator;
        private final Boolean canPreview;
        private final Boolean canRename;
        private final Boolean canSetShareAccess;
        private final Boolean canShare;
        private final Boolean canUpload;
        private final Boolean canViewAnnotations;

        public static /* synthetic */ PermissionsV2Api1 copy$default(PermissionsV2Api1 permissionsV2Api1, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = permissionsV2Api1.canInviteCollaborator;
            }
            if ((i & 2) != 0) {
                bool2 = permissionsV2Api1.canSetShareAccess;
            }
            if ((i & 4) != 0) {
                bool3 = permissionsV2Api1.canDownload;
            }
            if ((i & 8) != 0) {
                bool4 = permissionsV2Api1.canPreview;
            }
            if ((i & 16) != 0) {
                bool5 = permissionsV2Api1.canComment;
            }
            if ((i & 32) != 0) {
                bool6 = permissionsV2Api1.canUpload;
            }
            if ((i & 64) != 0) {
                bool7 = permissionsV2Api1.canRename;
            }
            if ((i & 128) != 0) {
                bool8 = permissionsV2Api1.canDelete;
            }
            if ((i & 256) != 0) {
                bool9 = permissionsV2Api1.canShare;
            }
            if ((i & 512) != 0) {
                bool10 = permissionsV2Api1.canViewAnnotations;
            }
            if ((i & 1024) != 0) {
                bool11 = permissionsV2Api1.canCreateAnnotations;
            }
            Boolean bool12 = bool10;
            Boolean bool13 = bool11;
            Boolean bool14 = bool8;
            Boolean bool15 = bool9;
            Boolean bool16 = bool6;
            Boolean bool17 = bool7;
            Boolean bool18 = bool5;
            Boolean bool19 = bool3;
            return permissionsV2Api1.copy(bool, bool2, bool19, bool4, bool18, bool16, bool17, bool14, bool15, bool12, bool13);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Boolean getCanInviteCollaborator() {
            return this.canInviteCollaborator;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Boolean getCanViewAnnotations() {
            return this.canViewAnnotations;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Boolean getCanCreateAnnotations() {
            return this.canCreateAnnotations;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Boolean getCanSetShareAccess() {
            return this.canSetShareAccess;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Boolean getCanDownload() {
            return this.canDownload;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Boolean getCanPreview() {
            return this.canPreview;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Boolean getCanComment() {
            return this.canComment;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Boolean getCanUpload() {
            return this.canUpload;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Boolean getCanRename() {
            return this.canRename;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Boolean getCanDelete() {
            return this.canDelete;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Boolean getCanShare() {
            return this.canShare;
        }

        public final PermissionsV2Api1 copy(Boolean canInviteCollaborator, Boolean canSetShareAccess, Boolean canDownload, Boolean canPreview, Boolean canComment, Boolean canUpload, Boolean canRename, Boolean canDelete, Boolean canShare, Boolean canViewAnnotations, Boolean canCreateAnnotations) {
            return new PermissionsV2Api1(canInviteCollaborator, canSetShareAccess, canDownload, canPreview, canComment, canUpload, canRename, canDelete, canShare, canViewAnnotations, canCreateAnnotations);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PermissionsV2Api1)) {
                return false;
            }
            PermissionsV2Api1 permissionsV2Api1 = (PermissionsV2Api1) other;
            return Intrinsics.areEqual(this.canInviteCollaborator, permissionsV2Api1.canInviteCollaborator) && Intrinsics.areEqual(this.canSetShareAccess, permissionsV2Api1.canSetShareAccess) && Intrinsics.areEqual(this.canDownload, permissionsV2Api1.canDownload) && Intrinsics.areEqual(this.canPreview, permissionsV2Api1.canPreview) && Intrinsics.areEqual(this.canComment, permissionsV2Api1.canComment) && Intrinsics.areEqual(this.canUpload, permissionsV2Api1.canUpload) && Intrinsics.areEqual(this.canRename, permissionsV2Api1.canRename) && Intrinsics.areEqual(this.canDelete, permissionsV2Api1.canDelete) && Intrinsics.areEqual(this.canShare, permissionsV2Api1.canShare) && Intrinsics.areEqual(this.canViewAnnotations, permissionsV2Api1.canViewAnnotations) && Intrinsics.areEqual(this.canCreateAnnotations, permissionsV2Api1.canCreateAnnotations);
        }

        public int hashCode() {
            Boolean bool = this.canInviteCollaborator;
            int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Boolean bool2 = this.canSetShareAccess;
            int iHashCode2 = (iHashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Boolean bool3 = this.canDownload;
            int iHashCode3 = (iHashCode2 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
            Boolean bool4 = this.canPreview;
            int iHashCode4 = (iHashCode3 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
            Boolean bool5 = this.canComment;
            int iHashCode5 = (iHashCode4 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
            Boolean bool6 = this.canUpload;
            int iHashCode6 = (iHashCode5 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
            Boolean bool7 = this.canRename;
            int iHashCode7 = (iHashCode6 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
            Boolean bool8 = this.canDelete;
            int iHashCode8 = (iHashCode7 + (bool8 == null ? 0 : bool8.hashCode())) * 31;
            Boolean bool9 = this.canShare;
            int iHashCode9 = (iHashCode8 + (bool9 == null ? 0 : bool9.hashCode())) * 31;
            Boolean bool10 = this.canViewAnnotations;
            int iHashCode10 = (iHashCode9 + (bool10 == null ? 0 : bool10.hashCode())) * 31;
            Boolean bool11 = this.canCreateAnnotations;
            return iHashCode10 + (bool11 != null ? bool11.hashCode() : 0);
        }

        public String toString() {
            return "PermissionsV2Api1(canInviteCollaborator=" + this.canInviteCollaborator + ", canSetShareAccess=" + this.canSetShareAccess + ", canDownload=" + this.canDownload + ", canPreview=" + this.canPreview + ", canComment=" + this.canComment + ", canUpload=" + this.canUpload + ", canRename=" + this.canRename + ", canDelete=" + this.canDelete + ", canShare=" + this.canShare + ", canViewAnnotations=" + this.canViewAnnotations + ", canCreateAnnotations=" + this.canCreateAnnotations + ")";
        }

        public PermissionsV2Api1(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11) {
            this.canInviteCollaborator = bool;
            this.canSetShareAccess = bool2;
            this.canDownload = bool3;
            this.canPreview = bool4;
            this.canComment = bool5;
            this.canUpload = bool6;
            this.canRename = bool7;
            this.canDelete = bool8;
            this.canShare = bool9;
            this.canViewAnnotations = bool10;
            this.canCreateAnnotations = bool11;
        }

        public final Boolean getCanInviteCollaborator() {
            return this.canInviteCollaborator;
        }

        public final Boolean getCanSetShareAccess() {
            return this.canSetShareAccess;
        }

        public final Boolean getCanDownload() {
            return this.canDownload;
        }

        public final Boolean getCanPreview() {
            return this.canPreview;
        }

        public final Boolean getCanComment() {
            return this.canComment;
        }

        public final Boolean getCanUpload() {
            return this.canUpload;
        }

        public final Boolean getCanRename() {
            return this.canRename;
        }

        public final Boolean getCanDelete() {
            return this.canDelete;
        }

        public final Boolean getCanShare() {
            return this.canShare;
        }

        public final Boolean getCanViewAnnotations() {
            return this.canViewAnnotations;
        }

        public final Boolean getCanCreateAnnotations() {
            return this.canCreateAnnotations;
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011JV\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0006\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u0011¨\u0006#"}, d2 = {"Lcom/box/android/data/GetCollectionItemsQuery$SharedLink1;", "", "url", "", "effectiveAccess", "effectivePermission", "isPasswordEnabled", "", "unsharedAt", "Ljava/util/Date;", "canDownload", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Date;Ljava/lang/Boolean;)V", "getUrl", "()Ljava/lang/String;", "getEffectiveAccess", "getEffectivePermission", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUnsharedAt", "()Ljava/util/Date;", "getCanDownload", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Date;Ljava/lang/Boolean;)Lcom/box/android/data/GetCollectionItemsQuery$SharedLink1;", "equals", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SharedLink1 {
        private final Boolean canDownload;
        private final String effectiveAccess;
        private final String effectivePermission;
        private final Boolean isPasswordEnabled;
        private final Date unsharedAt;
        private final String url;

        public static /* synthetic */ SharedLink1 copy$default(SharedLink1 sharedLink1, String str, String str2, String str3, Boolean bool, Date date, Boolean bool2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sharedLink1.url;
            }
            if ((i & 2) != 0) {
                str2 = sharedLink1.effectiveAccess;
            }
            if ((i & 4) != 0) {
                str3 = sharedLink1.effectivePermission;
            }
            if ((i & 8) != 0) {
                bool = sharedLink1.isPasswordEnabled;
            }
            if ((i & 16) != 0) {
                date = sharedLink1.unsharedAt;
            }
            if ((i & 32) != 0) {
                bool2 = sharedLink1.canDownload;
            }
            Date date2 = date;
            Boolean bool3 = bool2;
            return sharedLink1.copy(str, str2, str3, bool, date2, bool3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getEffectiveAccess() {
            return this.effectiveAccess;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getEffectivePermission() {
            return this.effectivePermission;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Boolean getIsPasswordEnabled() {
            return this.isPasswordEnabled;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Date getUnsharedAt() {
            return this.unsharedAt;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Boolean getCanDownload() {
            return this.canDownload;
        }

        public final SharedLink1 copy(String url, String effectiveAccess, String effectivePermission, Boolean isPasswordEnabled, Date unsharedAt, Boolean canDownload) {
            return new SharedLink1(url, effectiveAccess, effectivePermission, isPasswordEnabled, unsharedAt, canDownload);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SharedLink1)) {
                return false;
            }
            SharedLink1 sharedLink1 = (SharedLink1) other;
            return Intrinsics.areEqual(this.url, sharedLink1.url) && Intrinsics.areEqual(this.effectiveAccess, sharedLink1.effectiveAccess) && Intrinsics.areEqual(this.effectivePermission, sharedLink1.effectivePermission) && Intrinsics.areEqual(this.isPasswordEnabled, sharedLink1.isPasswordEnabled) && Intrinsics.areEqual(this.unsharedAt, sharedLink1.unsharedAt) && Intrinsics.areEqual(this.canDownload, sharedLink1.canDownload);
        }

        public int hashCode() {
            String str = this.url;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.effectiveAccess;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.effectivePermission;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Boolean bool = this.isPasswordEnabled;
            int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
            Date date = this.unsharedAt;
            int iHashCode5 = (iHashCode4 + (date == null ? 0 : date.hashCode())) * 31;
            Boolean bool2 = this.canDownload;
            return iHashCode5 + (bool2 != null ? bool2.hashCode() : 0);
        }

        public String toString() {
            return "SharedLink1(url=" + this.url + ", effectiveAccess=" + this.effectiveAccess + ", effectivePermission=" + this.effectivePermission + ", isPasswordEnabled=" + this.isPasswordEnabled + ", unsharedAt=" + this.unsharedAt + ", canDownload=" + this.canDownload + ")";
        }

        public SharedLink1(String str, String str2, String str3, Boolean bool, Date date, Boolean bool2) {
            this.url = str;
            this.effectiveAccess = str2;
            this.effectivePermission = str3;
            this.isPasswordEnabled = bool;
            this.unsharedAt = date;
            this.canDownload = bool2;
        }

        public final String getUrl() {
            return this.url;
        }

        public final String getEffectiveAccess() {
            return this.effectiveAccess;
        }

        public final String getEffectivePermission() {
            return this.effectivePermission;
        }

        public final Boolean isPasswordEnabled() {
            return this.isPasswordEnabled;
        }

        public final Date getUnsharedAt() {
            return this.unsharedAt;
        }

        public final Boolean getCanDownload() {
            return this.canDownload;
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0016HÆ\u0003J¡\u0001\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÆ\u0001J\u0013\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020AHÖ\u0001J\t\u0010B\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0013\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u0006C"}, d2 = {"Lcom/box/android/data/GetCollectionItemsQuery$OnWeblink;", "", "id", "", "type", "Lcom/box/android/data/type/ItemType;", "name", "createdAt", "Ljava/util/Date;", "updatedAt", "contentCreatedAt", "contentUpdatedAt", "ownedBy", "Lcom/box/android/data/GetCollectionItemsQuery$OwnedBy2;", "updatedBy", "Lcom/box/android/data/GetCollectionItemsQuery$UpdatedBy2;", "url", "parent", "Lcom/box/android/data/GetCollectionItemsQuery$Parent2;", "permissionsV2Api", "Lcom/box/android/data/GetCollectionItemsQuery$PermissionsV2Api2;", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "Lcom/box/android/data/GetCollectionItemsQuery$SharedLink2;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/type/ItemType;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Lcom/box/android/data/GetCollectionItemsQuery$OwnedBy2;Lcom/box/android/data/GetCollectionItemsQuery$UpdatedBy2;Ljava/lang/Object;Lcom/box/android/data/GetCollectionItemsQuery$Parent2;Lcom/box/android/data/GetCollectionItemsQuery$PermissionsV2Api2;Lcom/box/android/data/GetCollectionItemsQuery$SharedLink2;)V", "getId", "()Ljava/lang/String;", "getType", "()Lcom/box/android/data/type/ItemType;", "getName", "getCreatedAt", "()Ljava/util/Date;", "getUpdatedAt", "getContentCreatedAt", "getContentUpdatedAt", "getOwnedBy", "()Lcom/box/android/data/GetCollectionItemsQuery$OwnedBy2;", "getUpdatedBy", "()Lcom/box/android/data/GetCollectionItemsQuery$UpdatedBy2;", "getUrl", "()Ljava/lang/Object;", "getParent", "()Lcom/box/android/data/GetCollectionItemsQuery$Parent2;", "getPermissionsV2Api", "()Lcom/box/android/data/GetCollectionItemsQuery$PermissionsV2Api2;", "getSharedLink", "()Lcom/box/android/data/GetCollectionItemsQuery$SharedLink2;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnWeblink {
        private final Date contentCreatedAt;
        private final Date contentUpdatedAt;
        private final Date createdAt;
        private final String id;
        private final String name;
        private final OwnedBy2 ownedBy;
        private final Parent2 parent;
        private final PermissionsV2Api2 permissionsV2Api;
        private final SharedLink2 sharedLink;
        private final ItemType type;
        private final Date updatedAt;
        private final UpdatedBy2 updatedBy;
        private final Object url;

        public static /* synthetic */ OnWeblink copy$default(OnWeblink onWeblink, String str, ItemType itemType, String str2, Date date, Date date2, Date date3, Date date4, OwnedBy2 ownedBy2, UpdatedBy2 updatedBy2, Object obj, Parent2 parent2, PermissionsV2Api2 permissionsV2Api2, SharedLink2 sharedLink2, int i, Object obj2) {
            if ((i & 1) != 0) {
                str = onWeblink.id;
            }
            return onWeblink.copy(str, (i & 2) != 0 ? onWeblink.type : itemType, (i & 4) != 0 ? onWeblink.name : str2, (i & 8) != 0 ? onWeblink.createdAt : date, (i & 16) != 0 ? onWeblink.updatedAt : date2, (i & 32) != 0 ? onWeblink.contentCreatedAt : date3, (i & 64) != 0 ? onWeblink.contentUpdatedAt : date4, (i & 128) != 0 ? onWeblink.ownedBy : ownedBy2, (i & 256) != 0 ? onWeblink.updatedBy : updatedBy2, (i & 512) != 0 ? onWeblink.url : obj, (i & 1024) != 0 ? onWeblink.parent : parent2, (i & 2048) != 0 ? onWeblink.permissionsV2Api : permissionsV2Api2, (i & 4096) != 0 ? onWeblink.sharedLink : sharedLink2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Object getUrl() {
            return this.url;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Parent2 getParent() {
            return this.parent;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final PermissionsV2Api2 getPermissionsV2Api() {
            return this.permissionsV2Api;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final SharedLink2 getSharedLink() {
            return this.sharedLink;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ItemType getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Date getCreatedAt() {
            return this.createdAt;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Date getUpdatedAt() {
            return this.updatedAt;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Date getContentCreatedAt() {
            return this.contentCreatedAt;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Date getContentUpdatedAt() {
            return this.contentUpdatedAt;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final OwnedBy2 getOwnedBy() {
            return this.ownedBy;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final UpdatedBy2 getUpdatedBy() {
            return this.updatedBy;
        }

        public final OnWeblink copy(String id, ItemType type, String name, Date createdAt, Date updatedAt, Date contentCreatedAt, Date contentUpdatedAt, OwnedBy2 ownedBy, UpdatedBy2 updatedBy, Object url, Parent2 parent, PermissionsV2Api2 permissionsV2Api, SharedLink2 sharedLink) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            return new OnWeblink(id, type, name, createdAt, updatedAt, contentCreatedAt, contentUpdatedAt, ownedBy, updatedBy, url, parent, permissionsV2Api, sharedLink);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OnWeblink)) {
                return false;
            }
            OnWeblink onWeblink = (OnWeblink) other;
            return Intrinsics.areEqual(this.id, onWeblink.id) && this.type == onWeblink.type && Intrinsics.areEqual(this.name, onWeblink.name) && Intrinsics.areEqual(this.createdAt, onWeblink.createdAt) && Intrinsics.areEqual(this.updatedAt, onWeblink.updatedAt) && Intrinsics.areEqual(this.contentCreatedAt, onWeblink.contentCreatedAt) && Intrinsics.areEqual(this.contentUpdatedAt, onWeblink.contentUpdatedAt) && Intrinsics.areEqual(this.ownedBy, onWeblink.ownedBy) && Intrinsics.areEqual(this.updatedBy, onWeblink.updatedBy) && Intrinsics.areEqual(this.url, onWeblink.url) && Intrinsics.areEqual(this.parent, onWeblink.parent) && Intrinsics.areEqual(this.permissionsV2Api, onWeblink.permissionsV2Api) && Intrinsics.areEqual(this.sharedLink, onWeblink.sharedLink);
        }

        public int hashCode() {
            int iHashCode = ((this.id.hashCode() * 31) + this.type.hashCode()) * 31;
            String str = this.name;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Date date = this.createdAt;
            int iHashCode3 = (iHashCode2 + (date == null ? 0 : date.hashCode())) * 31;
            Date date2 = this.updatedAt;
            int iHashCode4 = (iHashCode3 + (date2 == null ? 0 : date2.hashCode())) * 31;
            Date date3 = this.contentCreatedAt;
            int iHashCode5 = (iHashCode4 + (date3 == null ? 0 : date3.hashCode())) * 31;
            Date date4 = this.contentUpdatedAt;
            int iHashCode6 = (iHashCode5 + (date4 == null ? 0 : date4.hashCode())) * 31;
            OwnedBy2 ownedBy2 = this.ownedBy;
            int iHashCode7 = (iHashCode6 + (ownedBy2 == null ? 0 : ownedBy2.hashCode())) * 31;
            UpdatedBy2 updatedBy2 = this.updatedBy;
            int iHashCode8 = (iHashCode7 + (updatedBy2 == null ? 0 : updatedBy2.hashCode())) * 31;
            Object obj = this.url;
            int iHashCode9 = (iHashCode8 + (obj == null ? 0 : obj.hashCode())) * 31;
            Parent2 parent2 = this.parent;
            int iHashCode10 = (iHashCode9 + (parent2 == null ? 0 : parent2.hashCode())) * 31;
            PermissionsV2Api2 permissionsV2Api2 = this.permissionsV2Api;
            int iHashCode11 = (iHashCode10 + (permissionsV2Api2 == null ? 0 : permissionsV2Api2.hashCode())) * 31;
            SharedLink2 sharedLink2 = this.sharedLink;
            return iHashCode11 + (sharedLink2 != null ? sharedLink2.hashCode() : 0);
        }

        public String toString() {
            return "OnWeblink(id=" + this.id + ", type=" + this.type + ", name=" + this.name + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", contentCreatedAt=" + this.contentCreatedAt + ", contentUpdatedAt=" + this.contentUpdatedAt + ", ownedBy=" + this.ownedBy + ", updatedBy=" + this.updatedBy + ", url=" + this.url + ", parent=" + this.parent + ", permissionsV2Api=" + this.permissionsV2Api + ", sharedLink=" + this.sharedLink + ")";
        }

        public OnWeblink(String id, ItemType type, String str, Date date, Date date2, Date date3, Date date4, OwnedBy2 ownedBy2, UpdatedBy2 updatedBy2, Object obj, Parent2 parent2, PermissionsV2Api2 permissionsV2Api2, SharedLink2 sharedLink2) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            this.id = id;
            this.type = type;
            this.name = str;
            this.createdAt = date;
            this.updatedAt = date2;
            this.contentCreatedAt = date3;
            this.contentUpdatedAt = date4;
            this.ownedBy = ownedBy2;
            this.updatedBy = updatedBy2;
            this.url = obj;
            this.parent = parent2;
            this.permissionsV2Api = permissionsV2Api2;
            this.sharedLink = sharedLink2;
        }

        public final String getId() {
            return this.id;
        }

        public final ItemType getType() {
            return this.type;
        }

        public final String getName() {
            return this.name;
        }

        public final Date getCreatedAt() {
            return this.createdAt;
        }

        public final Date getUpdatedAt() {
            return this.updatedAt;
        }

        public final Date getContentCreatedAt() {
            return this.contentCreatedAt;
        }

        public final Date getContentUpdatedAt() {
            return this.contentUpdatedAt;
        }

        public final OwnedBy2 getOwnedBy() {
            return this.ownedBy;
        }

        public final UpdatedBy2 getUpdatedBy() {
            return this.updatedBy;
        }

        public final Object getUrl() {
            return this.url;
        }

        public final Parent2 getParent() {
            return this.parent;
        }

        public final PermissionsV2Api2 getPermissionsV2Api() {
            return this.permissionsV2Api;
        }

        public final SharedLink2 getSharedLink() {
            return this.sharedLink;
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/box/android/data/GetCollectionItemsQuery$OwnedBy2;", "", "id", "", "<init>", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OwnedBy2 {
        private final String id;

        public static /* synthetic */ OwnedBy2 copy$default(OwnedBy2 ownedBy2, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = ownedBy2.id;
            }
            return ownedBy2.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        public final OwnedBy2 copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new OwnedBy2(id);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OwnedBy2) && Intrinsics.areEqual(this.id, ((OwnedBy2) other).id);
        }

        public int hashCode() {
            return this.id.hashCode();
        }

        public String toString() {
            return "OwnedBy2(id=" + this.id + ")";
        }

        public OwnedBy2(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public final String getId() {
            return this.id;
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/GetCollectionItemsQuery$UpdatedBy2;", "", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class UpdatedBy2 {
        private final String id;
        private final String name;

        public static /* synthetic */ UpdatedBy2 copy$default(UpdatedBy2 updatedBy2, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = updatedBy2.id;
            }
            if ((i & 2) != 0) {
                str2 = updatedBy2.name;
            }
            return updatedBy2.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final UpdatedBy2 copy(String id, String name) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new UpdatedBy2(id, name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdatedBy2)) {
                return false;
            }
            UpdatedBy2 updatedBy2 = (UpdatedBy2) other;
            return Intrinsics.areEqual(this.id, updatedBy2.id) && Intrinsics.areEqual(this.name, updatedBy2.name);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.name;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "UpdatedBy2(id=" + this.id + ", name=" + this.name + ")";
        }

        public UpdatedBy2(String id, String str) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
            this.name = str;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/GetCollectionItemsQuery$Parent2;", "", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Parent2 {
        private final String id;
        private final String name;

        public static /* synthetic */ Parent2 copy$default(Parent2 parent2, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = parent2.id;
            }
            if ((i & 2) != 0) {
                str2 = parent2.name;
            }
            return parent2.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final Parent2 copy(String id, String name) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Parent2(id, name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Parent2)) {
                return false;
            }
            Parent2 parent2 = (Parent2) other;
            return Intrinsics.areEqual(this.id, parent2.id) && Intrinsics.areEqual(this.name, parent2.name);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.name;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Parent2(id=" + this.id + ", name=" + this.name + ")";
        }

        public Parent2(String id, String str) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
            this.name = str;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b)\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0092\u0001\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u0011R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u0011R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0016\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0017\u0010\u0011R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0018\u0010\u0011R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0019\u0010\u0011R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001a\u0010\u0011R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001b\u0010\u0011R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001c\u0010\u0011¨\u00060"}, d2 = {"Lcom/box/android/data/GetCollectionItemsQuery$PermissionsV2Api2;", "", "canInviteCollaborator", "", "canSetShareAccess", "canDownload", "canPreview", "canComment", "canUpload", "canRename", "canDelete", "canShare", "canViewAnnotations", "canCreateAnnotations", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getCanInviteCollaborator", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCanSetShareAccess", "getCanDownload", "getCanPreview", "getCanComment", "getCanUpload", "getCanRename", "getCanDelete", "getCanShare", "getCanViewAnnotations", "getCanCreateAnnotations", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/box/android/data/GetCollectionItemsQuery$PermissionsV2Api2;", "equals", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class PermissionsV2Api2 {
        private final Boolean canComment;
        private final Boolean canCreateAnnotations;
        private final Boolean canDelete;
        private final Boolean canDownload;
        private final Boolean canInviteCollaborator;
        private final Boolean canPreview;
        private final Boolean canRename;
        private final Boolean canSetShareAccess;
        private final Boolean canShare;
        private final Boolean canUpload;
        private final Boolean canViewAnnotations;

        public static /* synthetic */ PermissionsV2Api2 copy$default(PermissionsV2Api2 permissionsV2Api2, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = permissionsV2Api2.canInviteCollaborator;
            }
            if ((i & 2) != 0) {
                bool2 = permissionsV2Api2.canSetShareAccess;
            }
            if ((i & 4) != 0) {
                bool3 = permissionsV2Api2.canDownload;
            }
            if ((i & 8) != 0) {
                bool4 = permissionsV2Api2.canPreview;
            }
            if ((i & 16) != 0) {
                bool5 = permissionsV2Api2.canComment;
            }
            if ((i & 32) != 0) {
                bool6 = permissionsV2Api2.canUpload;
            }
            if ((i & 64) != 0) {
                bool7 = permissionsV2Api2.canRename;
            }
            if ((i & 128) != 0) {
                bool8 = permissionsV2Api2.canDelete;
            }
            if ((i & 256) != 0) {
                bool9 = permissionsV2Api2.canShare;
            }
            if ((i & 512) != 0) {
                bool10 = permissionsV2Api2.canViewAnnotations;
            }
            if ((i & 1024) != 0) {
                bool11 = permissionsV2Api2.canCreateAnnotations;
            }
            Boolean bool12 = bool10;
            Boolean bool13 = bool11;
            Boolean bool14 = bool8;
            Boolean bool15 = bool9;
            Boolean bool16 = bool6;
            Boolean bool17 = bool7;
            Boolean bool18 = bool5;
            Boolean bool19 = bool3;
            return permissionsV2Api2.copy(bool, bool2, bool19, bool4, bool18, bool16, bool17, bool14, bool15, bool12, bool13);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Boolean getCanInviteCollaborator() {
            return this.canInviteCollaborator;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Boolean getCanViewAnnotations() {
            return this.canViewAnnotations;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final Boolean getCanCreateAnnotations() {
            return this.canCreateAnnotations;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Boolean getCanSetShareAccess() {
            return this.canSetShareAccess;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Boolean getCanDownload() {
            return this.canDownload;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Boolean getCanPreview() {
            return this.canPreview;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Boolean getCanComment() {
            return this.canComment;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Boolean getCanUpload() {
            return this.canUpload;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Boolean getCanRename() {
            return this.canRename;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Boolean getCanDelete() {
            return this.canDelete;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Boolean getCanShare() {
            return this.canShare;
        }

        public final PermissionsV2Api2 copy(Boolean canInviteCollaborator, Boolean canSetShareAccess, Boolean canDownload, Boolean canPreview, Boolean canComment, Boolean canUpload, Boolean canRename, Boolean canDelete, Boolean canShare, Boolean canViewAnnotations, Boolean canCreateAnnotations) {
            return new PermissionsV2Api2(canInviteCollaborator, canSetShareAccess, canDownload, canPreview, canComment, canUpload, canRename, canDelete, canShare, canViewAnnotations, canCreateAnnotations);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PermissionsV2Api2)) {
                return false;
            }
            PermissionsV2Api2 permissionsV2Api2 = (PermissionsV2Api2) other;
            return Intrinsics.areEqual(this.canInviteCollaborator, permissionsV2Api2.canInviteCollaborator) && Intrinsics.areEqual(this.canSetShareAccess, permissionsV2Api2.canSetShareAccess) && Intrinsics.areEqual(this.canDownload, permissionsV2Api2.canDownload) && Intrinsics.areEqual(this.canPreview, permissionsV2Api2.canPreview) && Intrinsics.areEqual(this.canComment, permissionsV2Api2.canComment) && Intrinsics.areEqual(this.canUpload, permissionsV2Api2.canUpload) && Intrinsics.areEqual(this.canRename, permissionsV2Api2.canRename) && Intrinsics.areEqual(this.canDelete, permissionsV2Api2.canDelete) && Intrinsics.areEqual(this.canShare, permissionsV2Api2.canShare) && Intrinsics.areEqual(this.canViewAnnotations, permissionsV2Api2.canViewAnnotations) && Intrinsics.areEqual(this.canCreateAnnotations, permissionsV2Api2.canCreateAnnotations);
        }

        public int hashCode() {
            Boolean bool = this.canInviteCollaborator;
            int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Boolean bool2 = this.canSetShareAccess;
            int iHashCode2 = (iHashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Boolean bool3 = this.canDownload;
            int iHashCode3 = (iHashCode2 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
            Boolean bool4 = this.canPreview;
            int iHashCode4 = (iHashCode3 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
            Boolean bool5 = this.canComment;
            int iHashCode5 = (iHashCode4 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
            Boolean bool6 = this.canUpload;
            int iHashCode6 = (iHashCode5 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
            Boolean bool7 = this.canRename;
            int iHashCode7 = (iHashCode6 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
            Boolean bool8 = this.canDelete;
            int iHashCode8 = (iHashCode7 + (bool8 == null ? 0 : bool8.hashCode())) * 31;
            Boolean bool9 = this.canShare;
            int iHashCode9 = (iHashCode8 + (bool9 == null ? 0 : bool9.hashCode())) * 31;
            Boolean bool10 = this.canViewAnnotations;
            int iHashCode10 = (iHashCode9 + (bool10 == null ? 0 : bool10.hashCode())) * 31;
            Boolean bool11 = this.canCreateAnnotations;
            return iHashCode10 + (bool11 != null ? bool11.hashCode() : 0);
        }

        public String toString() {
            return "PermissionsV2Api2(canInviteCollaborator=" + this.canInviteCollaborator + ", canSetShareAccess=" + this.canSetShareAccess + ", canDownload=" + this.canDownload + ", canPreview=" + this.canPreview + ", canComment=" + this.canComment + ", canUpload=" + this.canUpload + ", canRename=" + this.canRename + ", canDelete=" + this.canDelete + ", canShare=" + this.canShare + ", canViewAnnotations=" + this.canViewAnnotations + ", canCreateAnnotations=" + this.canCreateAnnotations + ")";
        }

        public PermissionsV2Api2(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11) {
            this.canInviteCollaborator = bool;
            this.canSetShareAccess = bool2;
            this.canDownload = bool3;
            this.canPreview = bool4;
            this.canComment = bool5;
            this.canUpload = bool6;
            this.canRename = bool7;
            this.canDelete = bool8;
            this.canShare = bool9;
            this.canViewAnnotations = bool10;
            this.canCreateAnnotations = bool11;
        }

        public final Boolean getCanInviteCollaborator() {
            return this.canInviteCollaborator;
        }

        public final Boolean getCanSetShareAccess() {
            return this.canSetShareAccess;
        }

        public final Boolean getCanDownload() {
            return this.canDownload;
        }

        public final Boolean getCanPreview() {
            return this.canPreview;
        }

        public final Boolean getCanComment() {
            return this.canComment;
        }

        public final Boolean getCanUpload() {
            return this.canUpload;
        }

        public final Boolean getCanRename() {
            return this.canRename;
        }

        public final Boolean getCanDelete() {
            return this.canDelete;
        }

        public final Boolean getCanShare() {
            return this.canShare;
        }

        public final Boolean getCanViewAnnotations() {
            return this.canViewAnnotations;
        }

        public final Boolean getCanCreateAnnotations() {
            return this.canCreateAnnotations;
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011JV\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0006\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0015\u0010\u0011¨\u0006#"}, d2 = {"Lcom/box/android/data/GetCollectionItemsQuery$SharedLink2;", "", "url", "", "effectiveAccess", "effectivePermission", "isPasswordEnabled", "", "unsharedAt", "Ljava/util/Date;", "canDownload", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Date;Ljava/lang/Boolean;)V", "getUrl", "()Ljava/lang/String;", "getEffectiveAccess", "getEffectivePermission", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUnsharedAt", "()Ljava/util/Date;", "getCanDownload", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Date;Ljava/lang/Boolean;)Lcom/box/android/data/GetCollectionItemsQuery$SharedLink2;", "equals", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SharedLink2 {
        private final Boolean canDownload;
        private final String effectiveAccess;
        private final String effectivePermission;
        private final Boolean isPasswordEnabled;
        private final Date unsharedAt;
        private final String url;

        public static /* synthetic */ SharedLink2 copy$default(SharedLink2 sharedLink2, String str, String str2, String str3, Boolean bool, Date date, Boolean bool2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sharedLink2.url;
            }
            if ((i & 2) != 0) {
                str2 = sharedLink2.effectiveAccess;
            }
            if ((i & 4) != 0) {
                str3 = sharedLink2.effectivePermission;
            }
            if ((i & 8) != 0) {
                bool = sharedLink2.isPasswordEnabled;
            }
            if ((i & 16) != 0) {
                date = sharedLink2.unsharedAt;
            }
            if ((i & 32) != 0) {
                bool2 = sharedLink2.canDownload;
            }
            Date date2 = date;
            Boolean bool3 = bool2;
            return sharedLink2.copy(str, str2, str3, bool, date2, bool3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getEffectiveAccess() {
            return this.effectiveAccess;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getEffectivePermission() {
            return this.effectivePermission;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Boolean getIsPasswordEnabled() {
            return this.isPasswordEnabled;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Date getUnsharedAt() {
            return this.unsharedAt;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Boolean getCanDownload() {
            return this.canDownload;
        }

        public final SharedLink2 copy(String url, String effectiveAccess, String effectivePermission, Boolean isPasswordEnabled, Date unsharedAt, Boolean canDownload) {
            return new SharedLink2(url, effectiveAccess, effectivePermission, isPasswordEnabled, unsharedAt, canDownload);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SharedLink2)) {
                return false;
            }
            SharedLink2 sharedLink2 = (SharedLink2) other;
            return Intrinsics.areEqual(this.url, sharedLink2.url) && Intrinsics.areEqual(this.effectiveAccess, sharedLink2.effectiveAccess) && Intrinsics.areEqual(this.effectivePermission, sharedLink2.effectivePermission) && Intrinsics.areEqual(this.isPasswordEnabled, sharedLink2.isPasswordEnabled) && Intrinsics.areEqual(this.unsharedAt, sharedLink2.unsharedAt) && Intrinsics.areEqual(this.canDownload, sharedLink2.canDownload);
        }

        public int hashCode() {
            String str = this.url;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.effectiveAccess;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.effectivePermission;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Boolean bool = this.isPasswordEnabled;
            int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
            Date date = this.unsharedAt;
            int iHashCode5 = (iHashCode4 + (date == null ? 0 : date.hashCode())) * 31;
            Boolean bool2 = this.canDownload;
            return iHashCode5 + (bool2 != null ? bool2.hashCode() : 0);
        }

        public String toString() {
            return "SharedLink2(url=" + this.url + ", effectiveAccess=" + this.effectiveAccess + ", effectivePermission=" + this.effectivePermission + ", isPasswordEnabled=" + this.isPasswordEnabled + ", unsharedAt=" + this.unsharedAt + ", canDownload=" + this.canDownload + ")";
        }

        public SharedLink2(String str, String str2, String str3, Boolean bool, Date date, Boolean bool2) {
            this.url = str;
            this.effectiveAccess = str2;
            this.effectivePermission = str3;
            this.isPasswordEnabled = bool;
            this.unsharedAt = date;
            this.canDownload = bool2;
        }

        public final String getUrl() {
            return this.url;
        }

        public final String getEffectiveAccess() {
            return this.effectiveAccess;
        }

        public final String getEffectivePermission() {
            return this.effectivePermission;
        }

        public final Boolean isPasswordEnabled() {
            return this.isPasswordEnabled;
        }

        public final Date getUnsharedAt() {
            return this.unsharedAt;
        }

        public final Boolean getCanDownload() {
            return this.canDownload;
        }
    }

    /* JADX INFO: compiled from: GetCollectionItemsQuery.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/box/android/data/GetCollectionItemsQuery$Companion;", "", "<init>", "()V", "OPERATION_ID", "", "OPERATION_DOCUMENT", "getOPERATION_DOCUMENT", "()Ljava/lang/String;", "OPERATION_NAME", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getOPERATION_DOCUMENT() {
            return "query GetCollectionItems($id: ID!) { collection(id: $id) { id collectionItemConnection { edges { id: cursor node { __typename ... on File { id type name size createdAt updatedAt contentCreatedAt contentUpdatedAt ownedBy { id } updatedBy { id name } hasCollaborations isExternallyOwned sha1 watermark { isWatermarked } parent { id name } permissionsV2Api { canInviteCollaborator canSetShareAccess canDownload canPreview canComment canUpload canRename canDelete canShare canViewAnnotations canCreateAnnotations } sharedLink { url effectiveAccess effectivePermission isPasswordEnabled unsharedAt canDownload } } ... on Folder { id type name size createdAt updatedAt contentCreatedAt contentUpdatedAt ownedBy { id } updatedBy { id name } hasCollaborations isExternallyOwned parent { id name } permissionsV2Api { canInviteCollaborator canSetShareAccess canDownload canPreview canComment canUpload canRename canDelete canShare canViewAnnotations canCreateAnnotations } sharedLink { url effectiveAccess effectivePermission isPasswordEnabled unsharedAt canDownload } } ... on Weblink { id type name createdAt updatedAt contentCreatedAt contentUpdatedAt ownedBy { id } updatedBy { id name } url parent { id name } permissionsV2Api { canInviteCollaborator canSetShareAccess canDownload canPreview canComment canUpload canRename canDelete canShare canViewAnnotations canCreateAnnotations } sharedLink { url effectiveAccess effectivePermission isPasswordEnabled unsharedAt canDownload } } } } } } }";
        }
    }
}
