package com.box.android.data.datasource.gql.cache.partial.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PartialFolderItemConnection.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/datasource/gql/cache/partial/models/PartialFolderItemConnection;", "", "totalCount", "", "edges", "", "", "<init>", "(ILjava/util/List;)V", "getTotalCount", "()I", "getEdges", "()Ljava/util/List;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PartialFolderItemConnection {
    private final List<String> edges;
    private final int totalCount;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PartialFolderItemConnection copy$default(PartialFolderItemConnection partialFolderItemConnection, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = partialFolderItemConnection.totalCount;
        }
        if ((i2 & 2) != 0) {
            list = partialFolderItemConnection.edges;
        }
        return partialFolderItemConnection.copy(i, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTotalCount() {
        return this.totalCount;
    }

    public final List<String> component2() {
        return this.edges;
    }

    public final PartialFolderItemConnection copy(int totalCount, List<String> edges) {
        Intrinsics.checkNotNullParameter(edges, "edges");
        return new PartialFolderItemConnection(totalCount, edges);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PartialFolderItemConnection)) {
            return false;
        }
        PartialFolderItemConnection partialFolderItemConnection = (PartialFolderItemConnection) other;
        return this.totalCount == partialFolderItemConnection.totalCount && Intrinsics.areEqual(this.edges, partialFolderItemConnection.edges);
    }

    public int hashCode() {
        return (Integer.hashCode(this.totalCount) * 31) + this.edges.hashCode();
    }

    public String toString() {
        return "PartialFolderItemConnection(totalCount=" + this.totalCount + ", edges=" + this.edges + ")";
    }

    public PartialFolderItemConnection(int i, List<String> edges) {
        Intrinsics.checkNotNullParameter(edges, "edges");
        this.totalCount = i;
        this.edges = edges;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    public final List<String> getEdges() {
        return this.edges;
    }
}
