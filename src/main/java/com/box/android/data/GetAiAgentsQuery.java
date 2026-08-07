package com.box.android.data;

import com.apollographql.apollo3.api.Adapter;
import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.Query;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.box.android.data.adapter.GetAiAgentsQuery_ResponseAdapter;
import com.box.android.data.selections.GetAiAgentsQuerySelections;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.microsoft.identity.nativeauth.NativeAuthPublicClientApplicationConfiguration;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: GetAiAgentsQuery.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0007\u0019\u001a\u001b\u001c\u001d\u001e\u001fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016¨\u0006 "}, d2 = {"Lcom/box/android/data/GetAiAgentsQuery;", "Lcom/apollographql/apollo3/api/Query;", "Lcom/box/android/data/GetAiAgentsQuery$Data;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "id", "", "document", "name", "serializeVariables", "", "writer", "Lcom/apollographql/apollo3/api/json/JsonWriter;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "adapter", "Lcom/apollographql/apollo3/api/Adapter;", "rootField", "Lcom/apollographql/apollo3/api/CompiledField;", "Data", "FilteredForUserAiAgents", "Edge", "Node", "Capabilities", "Ask", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GetAiAgentsQuery implements Query<Data> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String OPERATION_ID = "ee40e37d4e73d1f05758acd97c9a8ba507f124a2291648c666cbfbd348ea7f01";
    public static final String OPERATION_NAME = "GetAiAgents";

    @Override // com.apollographql.apollo3.api.Operation, com.apollographql.apollo3.api.Executable
    public void serializeVariables(JsonWriter writer, CustomScalarAdapters customScalarAdapters) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
    }

    public boolean equals(Object other) {
        return other != null && other.getClass() == getClass();
    }

    public int hashCode() {
        return Reflection.getOrCreateKotlinClass(getClass()).hashCode();
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
    public Adapter<Data> adapter() {
        return Adapters.m11187obj$default(GetAiAgentsQuery_ResponseAdapter.Data.INSTANCE, false, 1, null);
    }

    @Override // com.apollographql.apollo3.api.Operation, com.apollographql.apollo3.api.Executable
    public CompiledField rootField() {
        return new CompiledField.Builder("data", com.box.android.data.type.Query.INSTANCE.getType()).selections(GetAiAgentsQuerySelections.INSTANCE.get__root()).build();
    }

    /* JADX INFO: compiled from: GetAiAgentsQuery.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/GetAiAgentsQuery$Data;", "Lcom/apollographql/apollo3/api/Query$Data;", "filteredForUserAiAgents", "Lcom/box/android/data/GetAiAgentsQuery$FilteredForUserAiAgents;", "<init>", "(Lcom/box/android/data/GetAiAgentsQuery$FilteredForUserAiAgents;)V", "getFilteredForUserAiAgents", "()Lcom/box/android/data/GetAiAgentsQuery$FilteredForUserAiAgents;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Data implements Query.Data {
        private final FilteredForUserAiAgents filteredForUserAiAgents;

        public static /* synthetic */ Data copy$default(Data data, FilteredForUserAiAgents filteredForUserAiAgents, int i, Object obj) {
            if ((i & 1) != 0) {
                filteredForUserAiAgents = data.filteredForUserAiAgents;
            }
            return data.copy(filteredForUserAiAgents);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FilteredForUserAiAgents getFilteredForUserAiAgents() {
            return this.filteredForUserAiAgents;
        }

        public final Data copy(FilteredForUserAiAgents filteredForUserAiAgents) {
            Intrinsics.checkNotNullParameter(filteredForUserAiAgents, "filteredForUserAiAgents");
            return new Data(filteredForUserAiAgents);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Data) && Intrinsics.areEqual(this.filteredForUserAiAgents, ((Data) other).filteredForUserAiAgents);
        }

        public int hashCode() {
            return this.filteredForUserAiAgents.hashCode();
        }

        public String toString() {
            return "Data(filteredForUserAiAgents=" + this.filteredForUserAiAgents + ")";
        }

        public Data(FilteredForUserAiAgents filteredForUserAiAgents) {
            Intrinsics.checkNotNullParameter(filteredForUserAiAgents, "filteredForUserAiAgents");
            this.filteredForUserAiAgents = filteredForUserAiAgents;
        }

        public final FilteredForUserAiAgents getFilteredForUserAiAgents() {
            return this.filteredForUserAiAgents;
        }
    }

    /* JADX INFO: compiled from: GetAiAgentsQuery.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/GetAiAgentsQuery$FilteredForUserAiAgents;", "", "edges", "", "Lcom/box/android/data/GetAiAgentsQuery$Edge;", "<init>", "(Ljava/util/List;)V", "getEdges", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class FilteredForUserAiAgents {
        private final List<Edge> edges;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ FilteredForUserAiAgents copy$default(FilteredForUserAiAgents filteredForUserAiAgents, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = filteredForUserAiAgents.edges;
            }
            return filteredForUserAiAgents.copy(list);
        }

        public final List<Edge> component1() {
            return this.edges;
        }

        public final FilteredForUserAiAgents copy(List<Edge> edges) {
            Intrinsics.checkNotNullParameter(edges, "edges");
            return new FilteredForUserAiAgents(edges);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof FilteredForUserAiAgents) && Intrinsics.areEqual(this.edges, ((FilteredForUserAiAgents) other).edges);
        }

        public int hashCode() {
            return this.edges.hashCode();
        }

        public String toString() {
            return "FilteredForUserAiAgents(edges=" + this.edges + ")";
        }

        public FilteredForUserAiAgents(List<Edge> edges) {
            Intrinsics.checkNotNullParameter(edges, "edges");
            this.edges = edges;
        }

        public final List<Edge> getEdges() {
            return this.edges;
        }
    }

    /* JADX INFO: compiled from: GetAiAgentsQuery.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/GetAiAgentsQuery$Edge;", "", "node", "Lcom/box/android/data/GetAiAgentsQuery$Node;", "<init>", "(Lcom/box/android/data/GetAiAgentsQuery$Node;)V", "getNode", "()Lcom/box/android/data/GetAiAgentsQuery$Node;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
            Intrinsics.checkNotNullParameter(node, "node");
            return new Edge(node);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Edge) && Intrinsics.areEqual(this.node, ((Edge) other).node);
        }

        public int hashCode() {
            return this.node.hashCode();
        }

        public String toString() {
            return "Edge(node=" + this.node + ")";
        }

        public Edge(Node node) {
            Intrinsics.checkNotNullParameter(node, "node");
            this.node = node;
        }

        public final Node getNode() {
            return this.node;
        }
    }

    /* JADX INFO: compiled from: GetAiAgentsQuery.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003JH\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0005\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/box/android/data/GetAiAgentsQuery$Node;", "", "id", "", "name", "isEnterpriseDefault", "", "iconReference", NativeAuthPublicClientApplicationConfiguration.NativeAuthSerializedNames.CAPABILITIES, "Lcom/box/android/data/GetAiAgentsQuery$Capabilities;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/box/android/data/GetAiAgentsQuery$Capabilities;)V", "getId", "()Ljava/lang/String;", "getName", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getIconReference", "getCapabilities", "()Lcom/box/android/data/GetAiAgentsQuery$Capabilities;", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/box/android/data/GetAiAgentsQuery$Capabilities;)Lcom/box/android/data/GetAiAgentsQuery$Node;", "equals", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Node {
        private final Capabilities capabilities;
        private final String iconReference;
        private final String id;
        private final Boolean isEnterpriseDefault;
        private final String name;

        public static /* synthetic */ Node copy$default(Node node, String str, String str2, Boolean bool, String str3, Capabilities capabilities, int i, Object obj) {
            if ((i & 1) != 0) {
                str = node.id;
            }
            if ((i & 2) != 0) {
                str2 = node.name;
            }
            if ((i & 4) != 0) {
                bool = node.isEnterpriseDefault;
            }
            if ((i & 8) != 0) {
                str3 = node.iconReference;
            }
            if ((i & 16) != 0) {
                capabilities = node.capabilities;
            }
            Capabilities capabilities2 = capabilities;
            Boolean bool2 = bool;
            return node.copy(str, str2, bool2, str3, capabilities2);
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
        public final Boolean getIsEnterpriseDefault() {
            return this.isEnterpriseDefault;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getIconReference() {
            return this.iconReference;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Capabilities getCapabilities() {
            return this.capabilities;
        }

        public final Node copy(String id, String name, Boolean isEnterpriseDefault, String iconReference, Capabilities capabilities) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Node(id, name, isEnterpriseDefault, iconReference, capabilities);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Node)) {
                return false;
            }
            Node node = (Node) other;
            return Intrinsics.areEqual(this.id, node.id) && Intrinsics.areEqual(this.name, node.name) && Intrinsics.areEqual(this.isEnterpriseDefault, node.isEnterpriseDefault) && Intrinsics.areEqual(this.iconReference, node.iconReference) && Intrinsics.areEqual(this.capabilities, node.capabilities);
        }

        public int hashCode() {
            int iHashCode = this.id.hashCode() * 31;
            String str = this.name;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Boolean bool = this.isEnterpriseDefault;
            int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
            String str2 = this.iconReference;
            int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Capabilities capabilities = this.capabilities;
            return iHashCode4 + (capabilities != null ? capabilities.hashCode() : 0);
        }

        public String toString() {
            return "Node(id=" + this.id + ", name=" + this.name + ", isEnterpriseDefault=" + this.isEnterpriseDefault + ", iconReference=" + this.iconReference + ", capabilities=" + this.capabilities + ")";
        }

        public Node(String id, String str, Boolean bool, String str2, Capabilities capabilities) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
            this.name = str;
            this.isEnterpriseDefault = bool;
            this.iconReference = str2;
            this.capabilities = capabilities;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public final Boolean isEnterpriseDefault() {
            return this.isEnterpriseDefault;
        }

        public final String getIconReference() {
            return this.iconReference;
        }

        public final Capabilities getCapabilities() {
            return this.capabilities;
        }
    }

    /* JADX INFO: compiled from: GetAiAgentsQuery.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/GetAiAgentsQuery$Capabilities;", "", "ask", "Lcom/box/android/data/GetAiAgentsQuery$Ask;", "<init>", "(Lcom/box/android/data/GetAiAgentsQuery$Ask;)V", "getAsk", "()Lcom/box/android/data/GetAiAgentsQuery$Ask;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Capabilities {
        private final Ask ask;

        public static /* synthetic */ Capabilities copy$default(Capabilities capabilities, Ask ask, int i, Object obj) {
            if ((i & 1) != 0) {
                ask = capabilities.ask;
            }
            return capabilities.copy(ask);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Ask getAsk() {
            return this.ask;
        }

        public final Capabilities copy(Ask ask) {
            return new Capabilities(ask);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Capabilities) && Intrinsics.areEqual(this.ask, ((Capabilities) other).ask);
        }

        public int hashCode() {
            Ask ask = this.ask;
            if (ask == null) {
                return 0;
            }
            return ask.hashCode();
        }

        public String toString() {
            return "Capabilities(ask=" + this.ask + ")";
        }

        public Capabilities(Ask ask) {
            this.ask = ask;
        }

        public final Ask getAsk() {
            return this.ask;
        }
    }

    /* JADX INFO: compiled from: GetAiAgentsQuery.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/box/android/data/GetAiAgentsQuery$Ask;", "", "description", "", "<init>", "(Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Ask {
        private final String description;

        public static /* synthetic */ Ask copy$default(Ask ask, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = ask.description;
            }
            return ask.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        public final Ask copy(String description) {
            return new Ask(description);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Ask) && Intrinsics.areEqual(this.description, ((Ask) other).description);
        }

        public int hashCode() {
            String str = this.description;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "Ask(description=" + this.description + ")";
        }

        public Ask(String str) {
            this.description = str;
        }

        public final String getDescription() {
            return this.description;
        }
    }

    /* JADX INFO: compiled from: GetAiAgentsQuery.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/box/android/data/GetAiAgentsQuery$Companion;", "", "<init>", "()V", "OPERATION_ID", "", "OPERATION_DOCUMENT", "getOPERATION_DOCUMENT", "()Ljava/lang/String;", "OPERATION_NAME", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getOPERATION_DOCUMENT() {
            return "query GetAiAgents { filteredForUserAiAgents(mode: ASK) { edges { node { id name isEnterpriseDefault iconReference capabilities { ask { description } } } } } }";
        }
    }
}
