package com.box.android.domain.models.metadata;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MetadataTemplateModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/box/android/domain/models/metadata/MetadataTemplateFieldModel;", "", "key", "", "displayName", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getDisplayName", "getType", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MetadataTemplateFieldModel {
    private final String displayName;
    private final String key;
    private final String type;

    public static /* synthetic */ MetadataTemplateFieldModel copy$default(MetadataTemplateFieldModel metadataTemplateFieldModel, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = metadataTemplateFieldModel.key;
        }
        if ((i & 2) != 0) {
            str2 = metadataTemplateFieldModel.displayName;
        }
        if ((i & 4) != 0) {
            str3 = metadataTemplateFieldModel.type;
        }
        return metadataTemplateFieldModel.copy(str, str2, str3);
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

    public final MetadataTemplateFieldModel copy(String key, String displayName, String type) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(type, "type");
        return new MetadataTemplateFieldModel(key, displayName, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MetadataTemplateFieldModel)) {
            return false;
        }
        MetadataTemplateFieldModel metadataTemplateFieldModel = (MetadataTemplateFieldModel) other;
        return Intrinsics.areEqual(this.key, metadataTemplateFieldModel.key) && Intrinsics.areEqual(this.displayName, metadataTemplateFieldModel.displayName) && Intrinsics.areEqual(this.type, metadataTemplateFieldModel.type);
    }

    public int hashCode() {
        return (((this.key.hashCode() * 31) + this.displayName.hashCode()) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "MetadataTemplateFieldModel(key=" + this.key + ", displayName=" + this.displayName + ", type=" + this.type + ")";
    }

    public MetadataTemplateFieldModel(String key, String displayName, String type) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(type, "type");
        this.key = key;
        this.displayName = displayName;
        this.type = type;
    }

    public /* synthetic */ MetadataTemplateFieldModel(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? "string" : str3);
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getType() {
        return this.type;
    }
}
