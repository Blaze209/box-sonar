package com.box.android.data.api.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.JsonClass;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileMetadataInstanceDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\u0015\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003JQ\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\bHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/box/android/data/api/models/FileMetadataInstanceDTO;", "", "id", "", "scope", "templateKey", "parent", "version", "", "fields", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/Map;)V", "getId", "()Ljava/lang/String;", "getScope", "getTemplateKey", "getParent", "getVersion", "()I", "getFields", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FileMetadataInstanceDTO {
    private final Map<String, String> fields;
    private final String id;
    private final String parent;
    private final String scope;
    private final String templateKey;
    private final int version;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FileMetadataInstanceDTO copy$default(FileMetadataInstanceDTO fileMetadataInstanceDTO, String str, String str2, String str3, String str4, int i, Map map, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = fileMetadataInstanceDTO.id;
        }
        if ((i2 & 2) != 0) {
            str2 = fileMetadataInstanceDTO.scope;
        }
        if ((i2 & 4) != 0) {
            str3 = fileMetadataInstanceDTO.templateKey;
        }
        if ((i2 & 8) != 0) {
            str4 = fileMetadataInstanceDTO.parent;
        }
        if ((i2 & 16) != 0) {
            i = fileMetadataInstanceDTO.version;
        }
        if ((i2 & 32) != 0) {
            map = fileMetadataInstanceDTO.fields;
        }
        int i3 = i;
        Map map2 = map;
        return fileMetadataInstanceDTO.copy(str, str2, str3, str4, i3, map2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getScope() {
        return this.scope;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTemplateKey() {
        return this.templateKey;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getParent() {
        return this.parent;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    public final Map<String, String> component6() {
        return this.fields;
    }

    public final FileMetadataInstanceDTO copy(String id, String scope, String templateKey, String parent, int version, Map<String, String> fields) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(templateKey, "templateKey");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(fields, "fields");
        return new FileMetadataInstanceDTO(id, scope, templateKey, parent, version, fields);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileMetadataInstanceDTO)) {
            return false;
        }
        FileMetadataInstanceDTO fileMetadataInstanceDTO = (FileMetadataInstanceDTO) other;
        return Intrinsics.areEqual(this.id, fileMetadataInstanceDTO.id) && Intrinsics.areEqual(this.scope, fileMetadataInstanceDTO.scope) && Intrinsics.areEqual(this.templateKey, fileMetadataInstanceDTO.templateKey) && Intrinsics.areEqual(this.parent, fileMetadataInstanceDTO.parent) && this.version == fileMetadataInstanceDTO.version && Intrinsics.areEqual(this.fields, fileMetadataInstanceDTO.fields);
    }

    public int hashCode() {
        return (((((((((this.id.hashCode() * 31) + this.scope.hashCode()) * 31) + this.templateKey.hashCode()) * 31) + this.parent.hashCode()) * 31) + Integer.hashCode(this.version)) * 31) + this.fields.hashCode();
    }

    public String toString() {
        return "FileMetadataInstanceDTO(id=" + this.id + ", scope=" + this.scope + ", templateKey=" + this.templateKey + ", parent=" + this.parent + ", version=" + this.version + ", fields=" + this.fields + ")";
    }

    public FileMetadataInstanceDTO(String id, String scope, String templateKey, String parent, int i, Map<String, String> fields) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(templateKey, "templateKey");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(fields, "fields");
        this.id = id;
        this.scope = scope;
        this.templateKey = templateKey;
        this.parent = parent;
        this.version = i;
        this.fields = fields;
    }

    public final String getId() {
        return this.id;
    }

    public final String getScope() {
        return this.scope;
    }

    public final String getTemplateKey() {
        return this.templateKey;
    }

    public final String getParent() {
        return this.parent;
    }

    public final int getVersion() {
        return this.version;
    }

    public final Map<String, String> getFields() {
        return this.fields;
    }
}
