package com.box.android.data;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.Query;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.box.android.data.adapter.GetAiSessionsQuery_ResponseAdapter;
import com.box.android.data.adapter.GetAiSessionsQuery_VariablesAdapter;
import com.box.android.data.datasource.gql.cache.GQLCacheConstants;
import com.box.android.data.selections.GetAiSessionsQuerySelections;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxIterator;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GetAiSessionsQuery.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0086\b\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\b\u001f !\"#$%&B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001e\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006'"}, d2 = {"Lcom/box/android/data/GetAiSessionsQuery;", "Lcom/apollographql/apollo3/api/Query;", "Lcom/box/android/data/GetAiSessionsQuery$Data;", BoxIterator.FIELD_LIMIT, "", "<init>", "(I)V", "getLimit", "()I", "id", "", "document", "name", "serializeVariables", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "adapter", "Lcom/apollographql/apollo3/api/Adapter;", "rootField", "Lcom/apollographql/apollo3/api/CompiledField;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "Data", "ItemV2s", "Edge", "Node", "Data1", "OnAiSessionData", "AiAgentSession", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class GetAiSessionsQuery implements Query<Data> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String OPERATION_ID = "279714335291d4c4fe2d9289162bdd5bdd6ac14ada908167e9bf7a68e7b6e61a";
    public static final String OPERATION_NAME = "GetAiSessions";
    private final int limit;

    public static /* synthetic */ GetAiSessionsQuery copy$default(GetAiSessionsQuery getAiSessionsQuery, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = getAiSessionsQuery.limit;
        }
        return getAiSessionsQuery.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getLimit() {
        return this.limit;
    }

    public final GetAiSessionsQuery copy(int limit) {
        return new GetAiSessionsQuery(limit);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof GetAiSessionsQuery) && this.limit == ((GetAiSessionsQuery) other).limit;
    }

    public int hashCode() {
        return Integer.hashCode(this.limit);
    }

    public String toString() {
        return "GetAiSessionsQuery(limit=" + this.limit + ")";
    }

    public GetAiSessionsQuery(int i) {
        this.limit = i;
    }

    public final int getLimit() {
        return this.limit;
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
    public void serializeVariables(JsonWriter writer, CustomScalarAdapters customScalarAdapters) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
        GetAiSessionsQuery_VariablesAdapter.INSTANCE.toJson(writer, customScalarAdapters, this);
    }

    @Override // com.apollographql.apollo3.api.Operation, com.apollographql.apollo3.api.Executable
    public Adapter<Data> adapter() {
        return Adapters.m11187obj$default(GetAiSessionsQuery_ResponseAdapter.Data.INSTANCE, false, 1, null);
    }

    @Override // com.apollographql.apollo3.api.Operation, com.apollographql.apollo3.api.Executable
    public CompiledField rootField() {
        return new CompiledField.Builder("data", com.box.android.data.type.Query.INSTANCE.getType()).selections(GetAiSessionsQuerySelections.INSTANCE.get__root()).build();
    }

    /* JADX INFO: compiled from: GetAiSessionsQuery.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/GetAiSessionsQuery$Data;", "Lcom/apollographql/apollo3/api/Query$Data;", "itemV2s", "Lcom/box/android/data/GetAiSessionsQuery$ItemV2s;", "<init>", "(Lcom/box/android/data/GetAiSessionsQuery$ItemV2s;)V", "getItemV2s", "()Lcom/box/android/data/GetAiSessionsQuery$ItemV2s;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Data implements Query.Data {
        private final ItemV2s itemV2s;

        public static /* synthetic */ Data copy$default(Data data, ItemV2s itemV2s, int i, Object obj) {
            if ((i & 1) != 0) {
                itemV2s = data.itemV2s;
            }
            return data.copy(itemV2s);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ItemV2s getItemV2s() {
            return this.itemV2s;
        }

        public final Data copy(ItemV2s itemV2s) {
            Intrinsics.checkNotNullParameter(itemV2s, "itemV2s");
            return new Data(itemV2s);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Data) && Intrinsics.areEqual(this.itemV2s, ((Data) other).itemV2s);
        }

        public int hashCode() {
            return this.itemV2s.hashCode();
        }

        public String toString() {
            return "Data(itemV2s=" + this.itemV2s + ")";
        }

        public Data(ItemV2s itemV2s) {
            Intrinsics.checkNotNullParameter(itemV2s, "itemV2s");
            this.itemV2s = itemV2s;
        }

        public final ItemV2s getItemV2s() {
            return this.itemV2s;
        }
    }

    /* JADX INFO: compiled from: GetAiSessionsQuery.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/GetAiSessionsQuery$ItemV2s;", "", "edges", "", "Lcom/box/android/data/GetAiSessionsQuery$Edge;", "<init>", "(Ljava/util/List;)V", "getEdges", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ItemV2s {
        private final List<Edge> edges;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ItemV2s copy$default(ItemV2s itemV2s, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = itemV2s.edges;
            }
            return itemV2s.copy(list);
        }

        public final List<Edge> component1() {
            return this.edges;
        }

        public final ItemV2s copy(List<Edge> edges) {
            Intrinsics.checkNotNullParameter(edges, "edges");
            return new ItemV2s(edges);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ItemV2s) && Intrinsics.areEqual(this.edges, ((ItemV2s) other).edges);
        }

        public int hashCode() {
            return this.edges.hashCode();
        }

        public String toString() {
            return "ItemV2s(edges=" + this.edges + ")";
        }

        public ItemV2s(List<Edge> edges) {
            Intrinsics.checkNotNullParameter(edges, "edges");
            this.edges = edges;
        }

        public final List<Edge> getEdges() {
            return this.edges;
        }
    }

    /* JADX INFO: compiled from: GetAiSessionsQuery.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/GetAiSessionsQuery$Edge;", "", "node", "Lcom/box/android/data/GetAiSessionsQuery$Node;", "<init>", "(Lcom/box/android/data/GetAiSessionsQuery$Node;)V", "getNode", "()Lcom/box/android/data/GetAiSessionsQuery$Node;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Edge {
        private final Node node;

        public static /* synthetic */ Edge copy$default(Edge edge, Node node, int i, Object obj) {
            if ((i & 1) != 0) {
                node = edge.node;
            }
            return edge.copy(node);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Node getNode() {
            return this.node;
        }

        public final Edge copy(Node node) {
            return new Edge(node);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Edge) && Intrinsics.areEqual(this.node, ((Edge) other).node);
        }

        public int hashCode() {
            Node node = this.node;
            if (node == null) {
                return 0;
            }
            return node.hashCode();
        }

        public String toString() {
            return "Edge(node=" + this.node + ")";
        }

        public Edge(Node node) {
            this.node = node;
        }

        public final Node getNode() {
            return this.node;
        }
    }

    /* JADX INFO: compiled from: GetAiSessionsQuery.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/box/android/data/GetAiSessionsQuery$Node;", "", "id", "", "name", "data", "Lcom/box/android/data/GetAiSessionsQuery$Data1;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/GetAiSessionsQuery$Data1;)V", "getId", "()Ljava/lang/String;", "getName", "getData", "()Lcom/box/android/data/GetAiSessionsQuery$Data1;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Node {
        private final Data1 data;
        private final String id;
        private final String name;

        public static /* synthetic */ Node copy$default(Node node, String str, String str2, Data1 data1, int i, Object obj) {
            if ((i & 1) != 0) {
                str = node.id;
            }
            if ((i & 2) != 0) {
                str2 = node.name;
            }
            if ((i & 4) != 0) {
                data1 = node.data;
            }
            return node.copy(str, str2, data1);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Data1 getData() {
            return this.data;
        }

        public final Node copy(String id, String name, Data1 data) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Node(id, name, data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Node)) {
                return false;
            }
            Node node = (Node) other;
            return Intrinsics.areEqual(this.id, node.id) && Intrinsics.areEqual(this.name, node.name) && Intrinsics.areEqual(this.data, node.data);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.name;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Data1 data1 = this.data;
            return iHashCode2 + (data1 != null ? data1.hashCode() : 0);
        }

        public String toString() {
            return "Node(id=" + this.id + ", name=" + this.name + ", data=" + this.data + ")";
        }

        public Node(String id, String str, Data1 data1) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
            this.name = str;
            this.data = data1;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public final Data1 getData() {
            return this.data;
        }
    }

    /* JADX INFO: compiled from: GetAiSessionsQuery.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/GetAiSessionsQuery$Data1;", "", GQLCacheConstants.TYPENAME_KEY, "", "onAiSessionData", "Lcom/box/android/data/GetAiSessionsQuery$OnAiSessionData;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/GetAiSessionsQuery$OnAiSessionData;)V", "get__typename", "()Ljava/lang/String;", "getOnAiSessionData", "()Lcom/box/android/data/GetAiSessionsQuery$OnAiSessionData;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Data1 {
        private final String __typename;
        private final OnAiSessionData onAiSessionData;

        public static /* synthetic */ Data1 copy$default(Data1 data1, String str, OnAiSessionData onAiSessionData, int i, Object obj) {
            if ((i & 1) != 0) {
                str = data1.__typename;
            }
            if ((i & 2) != 0) {
                onAiSessionData = data1.onAiSessionData;
            }
            return data1.copy(str, onAiSessionData);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String get__typename() {
            return this.__typename;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final OnAiSessionData getOnAiSessionData() {
            return this.onAiSessionData;
        }

        public final Data1 copy(String __typename, OnAiSessionData onAiSessionData) {
            Intrinsics.checkNotNullParameter(__typename, "__typename");
            return new Data1(__typename, onAiSessionData);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Data1)) {
                return false;
            }
            Data1 data1 = (Data1) other;
            return Intrinsics.areEqual(this.__typename, data1.__typename) && Intrinsics.areEqual(this.onAiSessionData, data1.onAiSessionData);
        }

        public int hashCode() {
            int iHashCode = this.__typename.hashCode() * 31;
            OnAiSessionData onAiSessionData = this.onAiSessionData;
            return iHashCode + (onAiSessionData == null ? 0 : onAiSessionData.hashCode());
        }

        public String toString() {
            return "Data1(__typename=" + this.__typename + ", onAiSessionData=" + this.onAiSessionData + ")";
        }

        public Data1(String __typename, OnAiSessionData onAiSessionData) {
            Intrinsics.checkNotNullParameter(__typename, "__typename");
            this.__typename = __typename;
            this.onAiSessionData = onAiSessionData;
        }

        public final String get__typename() {
            return this.__typename;
        }

        public final OnAiSessionData getOnAiSessionData() {
            return this.onAiSessionData;
        }
    }

    /* JADX INFO: compiled from: GetAiSessionsQuery.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/GetAiSessionsQuery$OnAiSessionData;", "", "aiAgentSession", "Lcom/box/android/data/GetAiSessionsQuery$AiAgentSession;", "<init>", "(Lcom/box/android/data/GetAiSessionsQuery$AiAgentSession;)V", "getAiAgentSession", "()Lcom/box/android/data/GetAiSessionsQuery$AiAgentSession;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnAiSessionData {
        private final AiAgentSession aiAgentSession;

        public static /* synthetic */ OnAiSessionData copy$default(OnAiSessionData onAiSessionData, AiAgentSession aiAgentSession, int i, Object obj) {
            if ((i & 1) != 0) {
                aiAgentSession = onAiSessionData.aiAgentSession;
            }
            return onAiSessionData.copy(aiAgentSession);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final AiAgentSession getAiAgentSession() {
            return this.aiAgentSession;
        }

        public final OnAiSessionData copy(AiAgentSession aiAgentSession) {
            return new OnAiSessionData(aiAgentSession);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnAiSessionData) && Intrinsics.areEqual(this.aiAgentSession, ((OnAiSessionData) other).aiAgentSession);
        }

        public int hashCode() {
            AiAgentSession aiAgentSession = this.aiAgentSession;
            if (aiAgentSession == null) {
                return 0;
            }
            return aiAgentSession.hashCode();
        }

        public String toString() {
            return "OnAiSessionData(aiAgentSession=" + this.aiAgentSession + ")";
        }

        public OnAiSessionData(AiAgentSession aiAgentSession) {
            this.aiAgentSession = aiAgentSession;
        }

        public final AiAgentSession getAiAgentSession() {
            return this.aiAgentSession;
        }
    }

    /* JADX INFO: compiled from: GetAiSessionsQuery.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/box/android/data/GetAiSessionsQuery$AiAgentSession;", "", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class AiAgentSession {
        private final String name;

        public static /* synthetic */ AiAgentSession copy$default(AiAgentSession aiAgentSession, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = aiAgentSession.name;
            }
            return aiAgentSession.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final AiAgentSession copy(String name) {
            return new AiAgentSession(name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AiAgentSession) && Intrinsics.areEqual(this.name, ((AiAgentSession) other).name);
        }

        public int hashCode() {
            String str = this.name;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "AiAgentSession(name=" + this.name + ")";
        }

        public AiAgentSession(String str) {
            this.name = str;
        }

        public final String getName() {
            return this.name;
        }
    }

    /* JADX INFO: compiled from: GetAiSessionsQuery.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/box/android/data/GetAiSessionsQuery$Companion;", "", "<init>", "()V", "OPERATION_ID", "", "OPERATION_DOCUMENT", "getOPERATION_DOCUMENT", "()Ljava/lang/String;", "OPERATION_NAME", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getOPERATION_DOCUMENT() {
            return "query GetAiSessions($limit: Int!) { itemV2s(request: { query: { itemFilter: { type: ai_session }  }  orderBy: [{ field: CREATED_AT direction: DESC } ] limit: $limit includeTotalCount: false } ) { edges { node { id name data { __typename ... on AiSessionData { aiAgentSession { name } } } } } } }";
        }
    }
}
