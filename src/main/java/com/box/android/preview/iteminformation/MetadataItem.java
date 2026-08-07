package com.box.android.preview.iteminformation;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ImmutableList;

/* JADX INFO: compiled from: MetadataItem.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/box/android/preview/iteminformation/MetadataItem;", "", "id", "", "title", "fields", "Lkotlinx/collections/immutable/ImmutableList;", "Lcom/box/android/preview/iteminformation/MetadataField;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lkotlinx/collections/immutable/ImmutableList;)V", "getId", "()Ljava/lang/String;", "getTitle", "getFields", "()Lkotlinx/collections/immutable/ImmutableList;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MetadataItem {
    public static final int $stable = 0;
    private final ImmutableList<MetadataField> fields;
    private final String id;
    private final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MetadataItem copy$default(MetadataItem metadataItem, String str, String str2, ImmutableList immutableList, int i, Object obj) {
        if ((i & 1) != 0) {
            str = metadataItem.id;
        }
        if ((i & 2) != 0) {
            str2 = metadataItem.title;
        }
        if ((i & 4) != 0) {
            immutableList = metadataItem.fields;
        }
        return metadataItem.copy(str, str2, immutableList);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final ImmutableList<MetadataField> component3() {
        return this.fields;
    }

    public final MetadataItem copy(String id, String title, ImmutableList<MetadataField> fields) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(fields, "fields");
        return new MetadataItem(id, title, fields);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MetadataItem)) {
            return false;
        }
        MetadataItem metadataItem = (MetadataItem) other;
        return Intrinsics.areEqual(this.id, metadataItem.id) && Intrinsics.areEqual(this.title, metadataItem.title) && Intrinsics.areEqual(this.fields, metadataItem.fields);
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.title.hashCode()) * 31) + this.fields.hashCode();
    }

    public String toString() {
        return "MetadataItem(id=" + this.id + ", title=" + this.title + ", fields=" + this.fields + ")";
    }

    public MetadataItem(String id, String title, ImmutableList<MetadataField> fields) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(fields, "fields");
        this.id = id;
        this.title = title;
        this.fields = fields;
    }

    public final ImmutableList<MetadataField> getFields() {
        return this.fields;
    }

    public final String getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }
}
