package com.box.android.data.fragment;

import com.apollographql.apollo3.api.Fragment;
import com.box.android.data.datasource.gql.cache.GQLCacheConstants;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemConnectionFragment.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/box/android/data/fragment/ItemConnectionFragment;", "Lcom/apollographql/apollo3/api/Fragment$Data;", "totalCount", "", "edges", "", "Lcom/box/android/data/fragment/ItemConnectionFragment$Edge;", "<init>", "(ILjava/util/List;)V", "getTotalCount", "()I", "getEdges", "()Ljava/util/List;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "Edge", "Node", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ItemConnectionFragment implements Fragment.Data {
    private final List<Edge> edges;
    private final int totalCount;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ItemConnectionFragment copy$default(ItemConnectionFragment itemConnectionFragment, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = itemConnectionFragment.totalCount;
        }
        if ((i2 & 2) != 0) {
            list = itemConnectionFragment.edges;
        }
        return itemConnectionFragment.copy(i, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTotalCount() {
        return this.totalCount;
    }

    public final List<Edge> component2() {
        return this.edges;
    }

    public final ItemConnectionFragment copy(int totalCount, List<Edge> edges) {
        Intrinsics.checkNotNullParameter(edges, "edges");
        return new ItemConnectionFragment(totalCount, edges);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ItemConnectionFragment)) {
            return false;
        }
        ItemConnectionFragment itemConnectionFragment = (ItemConnectionFragment) other;
        return this.totalCount == itemConnectionFragment.totalCount && Intrinsics.areEqual(this.edges, itemConnectionFragment.edges);
    }

    public int hashCode() {
        return (Integer.hashCode(this.totalCount) * 31) + this.edges.hashCode();
    }

    public String toString() {
        return "ItemConnectionFragment(totalCount=" + this.totalCount + ", edges=" + this.edges + ")";
    }

    public ItemConnectionFragment(int i, List<Edge> edges) {
        Intrinsics.checkNotNullParameter(edges, "edges");
        this.totalCount = i;
        this.edges = edges;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    public final List<Edge> getEdges() {
        return this.edges;
    }

    /* JADX INFO: compiled from: ItemConnectionFragment.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/fragment/ItemConnectionFragment$Edge;", "", "id", "", "node", "Lcom/box/android/data/fragment/ItemConnectionFragment$Node;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/fragment/ItemConnectionFragment$Node;)V", "getId", "()Ljava/lang/String;", "getNode", "()Lcom/box/android/data/fragment/ItemConnectionFragment$Node;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    /* JADX INFO: compiled from: ItemConnectionFragment.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/box/android/data/fragment/ItemConnectionFragment$Node;", "", GQLCacheConstants.TYPENAME_KEY, "", "fileFields", "Lcom/box/android/data/fragment/FileFields;", "folderFields", "Lcom/box/android/data/fragment/FolderFields;", "weblinkFields", "Lcom/box/android/data/fragment/WeblinkFields;", "<init>", "(Ljava/lang/String;Lcom/box/android/data/fragment/FileFields;Lcom/box/android/data/fragment/FolderFields;Lcom/box/android/data/fragment/WeblinkFields;)V", "get__typename", "()Ljava/lang/String;", "getFileFields", "()Lcom/box/android/data/fragment/FileFields;", "getFolderFields", "()Lcom/box/android/data/fragment/FolderFields;", "getWeblinkFields", "()Lcom/box/android/data/fragment/WeblinkFields;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Node {
        private final String __typename;
        private final FileFields fileFields;
        private final FolderFields folderFields;
        private final WeblinkFields weblinkFields;

        public static /* synthetic */ Node copy$default(Node node, String str, FileFields fileFields, FolderFields folderFields, WeblinkFields weblinkFields, int i, Object obj) {
            if ((i & 1) != 0) {
                str = node.__typename;
            }
            if ((i & 2) != 0) {
                fileFields = node.fileFields;
            }
            if ((i & 4) != 0) {
                folderFields = node.folderFields;
            }
            if ((i & 8) != 0) {
                weblinkFields = node.weblinkFields;
            }
            return node.copy(str, fileFields, folderFields, weblinkFields);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String get__typename() {
            return this.__typename;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final FileFields getFileFields() {
            return this.fileFields;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final FolderFields getFolderFields() {
            return this.folderFields;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final WeblinkFields getWeblinkFields() {
            return this.weblinkFields;
        }

        public final Node copy(String __typename, FileFields fileFields, FolderFields folderFields, WeblinkFields weblinkFields) {
            Intrinsics.checkNotNullParameter(__typename, "__typename");
            return new Node(__typename, fileFields, folderFields, weblinkFields);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Node)) {
                return false;
            }
            Node node = (Node) other;
            return Intrinsics.areEqual(this.__typename, node.__typename) && Intrinsics.areEqual(this.fileFields, node.fileFields) && Intrinsics.areEqual(this.folderFields, node.folderFields) && Intrinsics.areEqual(this.weblinkFields, node.weblinkFields);
        }

        public int hashCode() {
            int iHashCode = this.__typename.hashCode() * 31;
            FileFields fileFields = this.fileFields;
            int iHashCode2 = (iHashCode + (fileFields == null ? 0 : fileFields.hashCode())) * 31;
            FolderFields folderFields = this.folderFields;
            int iHashCode3 = (iHashCode2 + (folderFields == null ? 0 : folderFields.hashCode())) * 31;
            WeblinkFields weblinkFields = this.weblinkFields;
            return iHashCode3 + (weblinkFields != null ? weblinkFields.hashCode() : 0);
        }

        public String toString() {
            return "Node(__typename=" + this.__typename + ", fileFields=" + this.fileFields + ", folderFields=" + this.folderFields + ", weblinkFields=" + this.weblinkFields + ")";
        }

        public Node(String __typename, FileFields fileFields, FolderFields folderFields, WeblinkFields weblinkFields) {
            Intrinsics.checkNotNullParameter(__typename, "__typename");
            this.__typename = __typename;
            this.fileFields = fileFields;
            this.folderFields = folderFields;
            this.weblinkFields = weblinkFields;
        }

        public final String get__typename() {
            return this.__typename;
        }

        public final FileFields getFileFields() {
            return this.fileFields;
        }

        public final FolderFields getFolderFields() {
            return this.folderFields;
        }

        public final WeblinkFields getWeblinkFields() {
            return this.weblinkFields;
        }
    }
}
