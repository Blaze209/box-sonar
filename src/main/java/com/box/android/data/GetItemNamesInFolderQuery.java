package com.box.android.data;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.Query;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.box.android.data.adapter.GetItemNamesInFolderQuery_ResponseAdapter;
import com.box.android.data.adapter.GetItemNamesInFolderQuery_VariablesAdapter;
import com.box.android.data.datasource.gql.cache.GQLCacheConstants;
import com.box.android.data.selections.GetItemNamesInFolderQuerySelections;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GetItemNamesInFolderQuery.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0007\u001f !\"#$%B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006&"}, d2 = {"Lcom/box/android/data/GetItemNamesInFolderQuery;", "Lcom/apollographql/apollo3/api/Query;", "Lcom/box/android/data/GetItemNamesInFolderQuery$Data;", "folderID", "", "<init>", "(Ljava/lang/String;)V", "getFolderID", "()Ljava/lang/String;", "id", "document", "name", "serializeVariables", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "adapter", "Lcom/apollographql/apollo3/api/Adapter;", "rootField", "Lcom/apollographql/apollo3/api/CompiledField;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "Data", "Folder", GQLCacheConstants.TYPENAME_ITEM_CONNECTION, "Edge", "Node", "OnCoreItem", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class GetItemNamesInFolderQuery implements Query<Data> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String OPERATION_ID = "80c2f546bcb13eab9d7b4befe1b8d3c7fc8d8062a5707d7e085513744e3c7286";
    public static final String OPERATION_NAME = "getItemNamesInFolder";
    private final String folderID;

    public static /* synthetic */ GetItemNamesInFolderQuery copy$default(GetItemNamesInFolderQuery getItemNamesInFolderQuery, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = getItemNamesInFolderQuery.folderID;
        }
        return getItemNamesInFolderQuery.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFolderID() {
        return this.folderID;
    }

    public final GetItemNamesInFolderQuery copy(String folderID) {
        Intrinsics.checkNotNullParameter(folderID, "folderID");
        return new GetItemNamesInFolderQuery(folderID);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof GetItemNamesInFolderQuery) && Intrinsics.areEqual(this.folderID, ((GetItemNamesInFolderQuery) other).folderID);
    }

    public int hashCode() {
        return this.folderID.hashCode();
    }

    public String toString() {
        return "GetItemNamesInFolderQuery(folderID=" + this.folderID + ")";
    }

    public GetItemNamesInFolderQuery(String folderID) {
        Intrinsics.checkNotNullParameter(folderID, "folderID");
        this.folderID = folderID;
    }

    public final String getFolderID() {
        return this.folderID;
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
        GetItemNamesInFolderQuery_VariablesAdapter.INSTANCE.toJson(writer, customScalarAdapters, this);
    }

    @Override // com.apollographql.apollo3.api.Operation, com.apollographql.apollo3.api.Executable
    public Adapter<Data> adapter() {
        return Adapters.m11187obj$default(GetItemNamesInFolderQuery_ResponseAdapter.Data.INSTANCE, false, 1, null);
    }

    @Override // com.apollographql.apollo3.api.Operation, com.apollographql.apollo3.api.Executable
    public CompiledField rootField() {
        return new CompiledField.Builder("data", com.box.android.data.type.Query.INSTANCE.getType()).selections(GetItemNamesInFolderQuerySelections.INSTANCE.get__root()).build();
    }

    /* JADX INFO: compiled from: GetItemNamesInFolderQuery.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/GetItemNamesInFolderQuery$Data;", "Lcom/apollographql/apollo3/api/Query$Data;", "folder", "Lcom/box/android/data/GetItemNamesInFolderQuery$Folder;", "<init>", "(Lcom/box/android/data/GetItemNamesInFolderQuery$Folder;)V", "getFolder", "()Lcom/box/android/data/GetItemNamesInFolderQuery$Folder;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Data implements Query.Data {
        private final Folder folder;

        public static /* synthetic */ Data copy$default(Data data, Folder folder, int i, Object obj) {
            if ((i & 1) != 0) {
                folder = data.folder;
            }
            return data.copy(folder);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Folder getFolder() {
            return this.folder;
        }

        public final Data copy(Folder folder) {
            return new Data(folder);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Data) && Intrinsics.areEqual(this.folder, ((Data) other).folder);
        }

        public int hashCode() {
            Folder folder = this.folder;
            if (folder == null) {
                return 0;
            }
            return folder.hashCode();
        }

        public String toString() {
            return "Data(folder=" + this.folder + ")";
        }

        public Data(Folder folder) {
            this.folder = folder;
        }

        public final Folder getFolder() {
            return this.folder;
        }
    }

    /* JADX INFO: compiled from: GetItemNamesInFolderQuery.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/GetItemNamesInFolderQuery$Folder;", "", "id", "", "itemConnection", "Lcom/box/android/data/GetItemNamesInFolderQuery$ItemConnection;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/GetItemNamesInFolderQuery$ItemConnection;)V", "getId", "()Ljava/lang/String;", "getItemConnection", "()Lcom/box/android/data/GetItemNamesInFolderQuery$ItemConnection;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Folder {
        private final String id;
        private final ItemConnection itemConnection;

        public static /* synthetic */ Folder copy$default(Folder folder, String str, ItemConnection itemConnection, int i, Object obj) {
            if ((i & 1) != 0) {
                str = folder.id;
            }
            if ((i & 2) != 0) {
                itemConnection = folder.itemConnection;
            }
            return folder.copy(str, itemConnection);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ItemConnection getItemConnection() {
            return this.itemConnection;
        }

        public final Folder copy(String id, ItemConnection itemConnection) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Folder(id, itemConnection);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Folder)) {
                return false;
            }
            Folder folder = (Folder) other;
            return Intrinsics.areEqual(this.id, folder.id) && Intrinsics.areEqual(this.itemConnection, folder.itemConnection);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            ItemConnection itemConnection = this.itemConnection;
            return iHashCode + (itemConnection == null ? 0 : itemConnection.hashCode());
        }

        public String toString() {
            return "Folder(id=" + this.id + ", itemConnection=" + this.itemConnection + ")";
        }

        public Folder(String id, ItemConnection itemConnection) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
            this.itemConnection = itemConnection;
        }

        public final String getId() {
            return this.id;
        }

        public final ItemConnection getItemConnection() {
            return this.itemConnection;
        }
    }

    /* JADX INFO: compiled from: GetItemNamesInFolderQuery.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/GetItemNamesInFolderQuery$ItemConnection;", "", "edges", "", "Lcom/box/android/data/GetItemNamesInFolderQuery$Edge;", "<init>", "(Ljava/util/List;)V", "getEdges", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ItemConnection {
        private final List<Edge> edges;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ItemConnection copy$default(ItemConnection itemConnection, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = itemConnection.edges;
            }
            return itemConnection.copy(list);
        }

        public final List<Edge> component1() {
            return this.edges;
        }

        public final ItemConnection copy(List<Edge> edges) {
            Intrinsics.checkNotNullParameter(edges, "edges");
            return new ItemConnection(edges);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ItemConnection) && Intrinsics.areEqual(this.edges, ((ItemConnection) other).edges);
        }

        public int hashCode() {
            return this.edges.hashCode();
        }

        public String toString() {
            return "ItemConnection(edges=" + this.edges + ")";
        }

        public ItemConnection(List<Edge> edges) {
            Intrinsics.checkNotNullParameter(edges, "edges");
            this.edges = edges;
        }

        public final List<Edge> getEdges() {
            return this.edges;
        }
    }

    /* JADX INFO: compiled from: GetItemNamesInFolderQuery.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/GetItemNamesInFolderQuery$Edge;", "", "id", "", "node", "Lcom/box/android/data/GetItemNamesInFolderQuery$Node;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/GetItemNamesInFolderQuery$Node;)V", "getId", "()Ljava/lang/String;", "getNode", "()Lcom/box/android/data/GetItemNamesInFolderQuery$Node;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    /* JADX INFO: compiled from: GetItemNamesInFolderQuery.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/GetItemNamesInFolderQuery$Node;", "", GQLCacheConstants.TYPENAME_KEY, "", "onCoreItem", "Lcom/box/android/data/GetItemNamesInFolderQuery$OnCoreItem;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/GetItemNamesInFolderQuery$OnCoreItem;)V", "get__typename", "()Ljava/lang/String;", "getOnCoreItem", "()Lcom/box/android/data/GetItemNamesInFolderQuery$OnCoreItem;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Node {
        private final String __typename;
        private final OnCoreItem onCoreItem;

        public static /* synthetic */ Node copy$default(Node node, String str, OnCoreItem onCoreItem, int i, Object obj) {
            if ((i & 1) != 0) {
                str = node.__typename;
            }
            if ((i & 2) != 0) {
                onCoreItem = node.onCoreItem;
            }
            return node.copy(str, onCoreItem);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String get__typename() {
            return this.__typename;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final OnCoreItem getOnCoreItem() {
            return this.onCoreItem;
        }

        public final Node copy(String __typename, OnCoreItem onCoreItem) {
            Intrinsics.checkNotNullParameter(__typename, "__typename");
            return new Node(__typename, onCoreItem);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Node)) {
                return false;
            }
            Node node = (Node) other;
            return Intrinsics.areEqual(this.__typename, node.__typename) && Intrinsics.areEqual(this.onCoreItem, node.onCoreItem);
        }

        public int hashCode() {
            int iHashCode = this.__typename.hashCode() * 31;
            OnCoreItem onCoreItem = this.onCoreItem;
            return iHashCode + (onCoreItem == null ? 0 : onCoreItem.hashCode());
        }

        public String toString() {
            return "Node(__typename=" + this.__typename + ", onCoreItem=" + this.onCoreItem + ")";
        }

        public Node(String __typename, OnCoreItem onCoreItem) {
            Intrinsics.checkNotNullParameter(__typename, "__typename");
            this.__typename = __typename;
            this.onCoreItem = onCoreItem;
        }

        public final String get__typename() {
            return this.__typename;
        }

        public final OnCoreItem getOnCoreItem() {
            return this.onCoreItem;
        }
    }

    /* JADX INFO: compiled from: GetItemNamesInFolderQuery.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/box/android/data/GetItemNamesInFolderQuery$OnCoreItem;", "", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class OnCoreItem {
        private final String name;

        public static /* synthetic */ OnCoreItem copy$default(OnCoreItem onCoreItem, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = onCoreItem.name;
            }
            return onCoreItem.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final OnCoreItem copy(String name) {
            return new OnCoreItem(name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnCoreItem) && Intrinsics.areEqual(this.name, ((OnCoreItem) other).name);
        }

        public int hashCode() {
            String str = this.name;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "OnCoreItem(name=" + this.name + ")";
        }

        public OnCoreItem(String str) {
            this.name = str;
        }

        public final String getName() {
            return this.name;
        }
    }

    /* JADX INFO: compiled from: GetItemNamesInFolderQuery.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/box/android/data/GetItemNamesInFolderQuery$Companion;", "", "<init>", "()V", "OPERATION_ID", "", "OPERATION_DOCUMENT", "getOPERATION_DOCUMENT", "()Ljava/lang/String;", "OPERATION_NAME", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getOPERATION_DOCUMENT() {
            return "query getItemNamesInFolder($folderID: ID!) { folder(id: $folderID) { id itemConnection { edges { id: cursor node { __typename ... on CoreItem { name } } } } } }";
        }
    }
}
