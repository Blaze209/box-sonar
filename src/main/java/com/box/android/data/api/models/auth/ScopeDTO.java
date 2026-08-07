package com.box.android.data.api.models.auth;

import com.box.android.data.api.models.items.mini.FileMiniDTO;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScopeDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/data/api/models/auth/ScopeDTO;", "", "name", "Lcom/box/android/data/api/models/auth/Scope;", "appliedTo", "Lcom/box/android/data/api/models/items/mini/FileMiniDTO;", "<init>", "(Lcom/box/android/data/api/models/auth/Scope;Lcom/box/android/data/api/models/items/mini/FileMiniDTO;)V", "getName", "()Lcom/box/android/data/api/models/auth/Scope;", "getAppliedTo", "()Lcom/box/android/data/api/models/items/mini/FileMiniDTO;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ScopeDTO {
    private final FileMiniDTO appliedTo;
    private final Scope name;

    public static /* synthetic */ ScopeDTO copy$default(ScopeDTO scopeDTO, Scope scope, FileMiniDTO fileMiniDTO, int i, Object obj) {
        if ((i & 1) != 0) {
            scope = scopeDTO.name;
        }
        if ((i & 2) != 0) {
            fileMiniDTO = scopeDTO.appliedTo;
        }
        return scopeDTO.copy(scope, fileMiniDTO);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Scope getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final FileMiniDTO getAppliedTo() {
        return this.appliedTo;
    }

    public final ScopeDTO copy(@Json(name = "scope") Scope name, @Json(name = "object") FileMiniDTO appliedTo) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(appliedTo, "appliedTo");
        return new ScopeDTO(name, appliedTo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScopeDTO)) {
            return false;
        }
        ScopeDTO scopeDTO = (ScopeDTO) other;
        return this.name == scopeDTO.name && Intrinsics.areEqual(this.appliedTo, scopeDTO.appliedTo);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.appliedTo.hashCode();
    }

    public String toString() {
        return "ScopeDTO(name=" + this.name + ", appliedTo=" + this.appliedTo + ")";
    }

    public ScopeDTO(@Json(name = "scope") Scope name, @Json(name = "object") FileMiniDTO appliedTo) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(appliedTo, "appliedTo");
        this.name = name;
        this.appliedTo = appliedTo;
    }

    public final FileMiniDTO getAppliedTo() {
        return this.appliedTo;
    }

    public final Scope getName() {
        return this.name;
    }
}
