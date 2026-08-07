package com.box.android.data.datasource.gql.cache.partial.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.JsonClass;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PartialMiniItem.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\t\u0010\u0019\u001a\u00020\tHÆ\u0003JB\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lcom/box/android/data/datasource/gql/cache/partial/models/PartialMiniItem;", "", "id", "", "name", "type", "size", "", "contentUpdatedAt", "Ljava/util/Date;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/util/Date;)V", "getId", "()Ljava/lang/String;", "getName", "getType", "getSize", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getContentUpdatedAt", "()Ljava/util/Date;", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/util/Date;)Lcom/box/android/data/datasource/gql/cache/partial/models/PartialMiniItem;", "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PartialMiniItem {
    private final Date contentUpdatedAt;
    private final String id;
    private final String name;
    private final Float size;
    private final String type;

    public static /* synthetic */ PartialMiniItem copy$default(PartialMiniItem partialMiniItem, String str, String str2, String str3, Float f, Date date, int i, Object obj) {
        if ((i & 1) != 0) {
            str = partialMiniItem.id;
        }
        if ((i & 2) != 0) {
            str2 = partialMiniItem.name;
        }
        if ((i & 4) != 0) {
            str3 = partialMiniItem.type;
        }
        if ((i & 8) != 0) {
            f = partialMiniItem.size;
        }
        if ((i & 16) != 0) {
            date = partialMiniItem.contentUpdatedAt;
        }
        Date date2 = date;
        String str4 = str3;
        return partialMiniItem.copy(str, str2, str4, f, date2);
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
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Float getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Date getContentUpdatedAt() {
        return this.contentUpdatedAt;
    }

    public final PartialMiniItem copy(String id, String name, String type, Float size, Date contentUpdatedAt) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(contentUpdatedAt, "contentUpdatedAt");
        return new PartialMiniItem(id, name, type, size, contentUpdatedAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PartialMiniItem)) {
            return false;
        }
        PartialMiniItem partialMiniItem = (PartialMiniItem) other;
        return Intrinsics.areEqual(this.id, partialMiniItem.id) && Intrinsics.areEqual(this.name, partialMiniItem.name) && Intrinsics.areEqual(this.type, partialMiniItem.type) && Intrinsics.areEqual((Object) this.size, (Object) partialMiniItem.size) && Intrinsics.areEqual(this.contentUpdatedAt, partialMiniItem.contentUpdatedAt);
    }

    public int hashCode() {
        int iHashCode = ((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.type.hashCode()) * 31;
        Float f = this.size;
        return ((iHashCode + (f == null ? 0 : f.hashCode())) * 31) + this.contentUpdatedAt.hashCode();
    }

    public String toString() {
        return "PartialMiniItem(id=" + this.id + ", name=" + this.name + ", type=" + this.type + ", size=" + this.size + ", contentUpdatedAt=" + this.contentUpdatedAt + ")";
    }

    public PartialMiniItem(String id, String name, String type, Float f, Date contentUpdatedAt) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(contentUpdatedAt, "contentUpdatedAt");
        this.id = id;
        this.name = name;
        this.type = type;
        this.size = f;
        this.contentUpdatedAt = contentUpdatedAt;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getType() {
        return this.type;
    }

    public final Float getSize() {
        return this.size;
    }

    public final Date getContentUpdatedAt() {
        return this.contentUpdatedAt;
    }
}
