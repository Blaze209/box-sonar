package com.box.android.data.fragment;

import com.apollographql.apollo3.api.Fragment;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemConnectionEdgesOnlyFragment.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0017B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/box/android/data/fragment/ItemConnectionEdgesOnlyFragment;", "Lcom/apollographql/apollo3/api/Fragment$Data;", "totalCount", "", "edges", "", "Lcom/box/android/data/fragment/ItemConnectionEdgesOnlyFragment$Edge;", "<init>", "(ILjava/util/List;)V", "getTotalCount", "()I", "getEdges", "()Ljava/util/List;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "Edge", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ItemConnectionEdgesOnlyFragment implements Fragment.Data {
    private final List<Edge> edges;
    private final int totalCount;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ItemConnectionEdgesOnlyFragment copy$default(ItemConnectionEdgesOnlyFragment itemConnectionEdgesOnlyFragment, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = itemConnectionEdgesOnlyFragment.totalCount;
        }
        if ((i2 & 2) != 0) {
            list = itemConnectionEdgesOnlyFragment.edges;
        }
        return itemConnectionEdgesOnlyFragment.copy(i, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTotalCount() {
        return this.totalCount;
    }

    public final List<Edge> component2() {
        return this.edges;
    }

    public final ItemConnectionEdgesOnlyFragment copy(int totalCount, List<Edge> edges) {
        Intrinsics.checkNotNullParameter(edges, "edges");
        return new ItemConnectionEdgesOnlyFragment(totalCount, edges);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ItemConnectionEdgesOnlyFragment)) {
            return false;
        }
        ItemConnectionEdgesOnlyFragment itemConnectionEdgesOnlyFragment = (ItemConnectionEdgesOnlyFragment) other;
        return this.totalCount == itemConnectionEdgesOnlyFragment.totalCount && Intrinsics.areEqual(this.edges, itemConnectionEdgesOnlyFragment.edges);
    }

    public int hashCode() {
        return (Integer.hashCode(this.totalCount) * 31) + this.edges.hashCode();
    }

    public String toString() {
        return "ItemConnectionEdgesOnlyFragment(totalCount=" + this.totalCount + ", edges=" + this.edges + ")";
    }

    public ItemConnectionEdgesOnlyFragment(int i, List<Edge> edges) {
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

    /* JADX INFO: compiled from: ItemConnectionEdgesOnlyFragment.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/box/android/data/fragment/ItemConnectionEdgesOnlyFragment$Edge;", "", "id", "", "<init>", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Edge {
        private final String id;

        public static /* synthetic */ Edge copy$default(Edge edge, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = edge.id;
            }
            return edge.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        public final Edge copy(String id) {
            return new Edge(id);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Edge) && Intrinsics.areEqual(this.id, ((Edge) other).id);
        }

        public int hashCode() {
            String str = this.id;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "Edge(id=" + this.id + ")";
        }

        public Edge(String str) {
            this.id = str;
        }

        public final String getId() {
            return this.id;
        }
    }
}
