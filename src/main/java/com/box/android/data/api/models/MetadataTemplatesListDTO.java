package com.box.android.data.api.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MetadataTemplateDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/api/models/MetadataTemplatesListDTO;", "", "entries", "", "Lcom/box/android/data/api/models/MetadataTemplateDTO;", "<init>", "(Ljava/util/List;)V", "getEntries", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MetadataTemplatesListDTO {
    private final List<MetadataTemplateDTO> entries;

    /* JADX WARN: Multi-variable type inference failed */
    public MetadataTemplatesListDTO() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MetadataTemplatesListDTO copy$default(MetadataTemplatesListDTO metadataTemplatesListDTO, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = metadataTemplatesListDTO.entries;
        }
        return metadataTemplatesListDTO.copy(list);
    }

    public final List<MetadataTemplateDTO> component1() {
        return this.entries;
    }

    public final MetadataTemplatesListDTO copy(@Json(name = "entries") List<MetadataTemplateDTO> entries) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        return new MetadataTemplatesListDTO(entries);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MetadataTemplatesListDTO) && Intrinsics.areEqual(this.entries, ((MetadataTemplatesListDTO) other).entries);
    }

    public int hashCode() {
        return this.entries.hashCode();
    }

    public String toString() {
        return "MetadataTemplatesListDTO(entries=" + this.entries + ")";
    }

    public MetadataTemplatesListDTO(@Json(name = "entries") List<MetadataTemplateDTO> entries) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        this.entries = entries;
    }

    public /* synthetic */ MetadataTemplatesListDTO(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<MetadataTemplateDTO> getEntries() {
        return this.entries;
    }
}
