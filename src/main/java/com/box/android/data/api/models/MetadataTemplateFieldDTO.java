package com.box.android.data.api.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MetadataTemplateDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/box/android/data/api/models/MetadataTemplateFieldDTO;", "", "key", "", "displayName", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getDisplayName", "getType", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MetadataTemplateFieldDTO {
    private final String displayName;
    private final String key;
    private final String type;

    public static /* synthetic */ MetadataTemplateFieldDTO copy$default(MetadataTemplateFieldDTO metadataTemplateFieldDTO, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = metadataTemplateFieldDTO.key;
        }
        if ((i & 2) != 0) {
            str2 = metadataTemplateFieldDTO.displayName;
        }
        if ((i & 4) != 0) {
            str3 = metadataTemplateFieldDTO.type;
        }
        return metadataTemplateFieldDTO.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final MetadataTemplateFieldDTO copy(@Json(name = "key") String key, @Json(name = "displayName") String displayName, @Json(name = "type") String type) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(type, "type");
        return new MetadataTemplateFieldDTO(key, displayName, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MetadataTemplateFieldDTO)) {
            return false;
        }
        MetadataTemplateFieldDTO metadataTemplateFieldDTO = (MetadataTemplateFieldDTO) other;
        return Intrinsics.areEqual(this.key, metadataTemplateFieldDTO.key) && Intrinsics.areEqual(this.displayName, metadataTemplateFieldDTO.displayName) && Intrinsics.areEqual(this.type, metadataTemplateFieldDTO.type);
    }

    public int hashCode() {
        return (((this.key.hashCode() * 31) + this.displayName.hashCode()) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "MetadataTemplateFieldDTO(key=" + this.key + ", displayName=" + this.displayName + ", type=" + this.type + ")";
    }

    public MetadataTemplateFieldDTO(@Json(name = "key") String key, @Json(name = "displayName") String displayName, @Json(name = "type") String type) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(type, "type");
        this.key = key;
        this.displayName = displayName;
        this.type = type;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public /* synthetic */ MetadataTemplateFieldDTO(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? "string" : str3);
    }

    public final String getType() {
        return this.type;
    }
}
