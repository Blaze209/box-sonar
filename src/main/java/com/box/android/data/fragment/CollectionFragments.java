package com.box.android.data.fragment;

import com.apollographql.apollo3.api.Fragment;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionFragments.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/box/android/data/fragment/CollectionFragments;", "Lcom/apollographql/apollo3/api/Fragment$Data;", "id", "", "name", "collectionType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getCollectionType", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CollectionFragments implements Fragment.Data {
    private final String collectionType;
    private final String id;
    private final String name;

    public static /* synthetic */ CollectionFragments copy$default(CollectionFragments collectionFragments, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = collectionFragments.id;
        }
        if ((i & 2) != 0) {
            str2 = collectionFragments.name;
        }
        if ((i & 4) != 0) {
            str3 = collectionFragments.collectionType;
        }
        return collectionFragments.copy(str, str2, str3);
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
    public final String getCollectionType() {
        return this.collectionType;
    }

    public final CollectionFragments copy(String id, String name, String collectionType) {
        Intrinsics.checkNotNullParameter(id, "id");
        return new CollectionFragments(id, name, collectionType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CollectionFragments)) {
            return false;
        }
        CollectionFragments collectionFragments = (CollectionFragments) other;
        return Intrinsics.areEqual(this.id, collectionFragments.id) && Intrinsics.areEqual(this.name, collectionFragments.name) && Intrinsics.areEqual(this.collectionType, collectionFragments.collectionType);
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.collectionType;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "CollectionFragments(id=" + this.id + ", name=" + this.name + ", collectionType=" + this.collectionType + ")";
    }

    public CollectionFragments(String id, String str, String str2) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
        this.name = str;
        this.collectionType = str2;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getCollectionType() {
        return this.collectionType;
    }
}
