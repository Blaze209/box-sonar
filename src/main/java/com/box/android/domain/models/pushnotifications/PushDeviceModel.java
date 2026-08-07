package com.box.android.domain.models.pushnotifications;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PushDeviceModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006!"}, d2 = {"Lcom/box/android/domain/models/pushnotifications/PushDeviceModel;", "Lcom/box/android/domain/models/DomainModel;", "id", "", "token", "language", "version", "registered", "", "enabled", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getId", "()Ljava/lang/String;", "getToken", "getLanguage", "getVersion", "getRegistered", "()Z", "getEnabled", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PushDeviceModel implements DomainModel {
    private final boolean enabled;
    private final String id;
    private final String language;
    private final boolean registered;
    private final String token;
    private final String version;

    public static /* synthetic */ PushDeviceModel copy$default(PushDeviceModel pushDeviceModel, String str, String str2, String str3, String str4, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pushDeviceModel.id;
        }
        if ((i & 2) != 0) {
            str2 = pushDeviceModel.token;
        }
        if ((i & 4) != 0) {
            str3 = pushDeviceModel.language;
        }
        if ((i & 8) != 0) {
            str4 = pushDeviceModel.version;
        }
        if ((i & 16) != 0) {
            z = pushDeviceModel.registered;
        }
        if ((i & 32) != 0) {
            z2 = pushDeviceModel.enabled;
        }
        boolean z3 = z;
        boolean z4 = z2;
        return pushDeviceModel.copy(str, str2, str3, str4, z3, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getRegistered() {
        return this.registered;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    public final PushDeviceModel copy(String id, String token, String language, String version, boolean registered, boolean enabled) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(version, "version");
        return new PushDeviceModel(id, token, language, version, registered, enabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PushDeviceModel)) {
            return false;
        }
        PushDeviceModel pushDeviceModel = (PushDeviceModel) other;
        return Intrinsics.areEqual(this.id, pushDeviceModel.id) && Intrinsics.areEqual(this.token, pushDeviceModel.token) && Intrinsics.areEqual(this.language, pushDeviceModel.language) && Intrinsics.areEqual(this.version, pushDeviceModel.version) && this.registered == pushDeviceModel.registered && this.enabled == pushDeviceModel.enabled;
    }

    public int hashCode() {
        return (((((((((this.id.hashCode() * 31) + this.token.hashCode()) * 31) + this.language.hashCode()) * 31) + this.version.hashCode()) * 31) + Boolean.hashCode(this.registered)) * 31) + Boolean.hashCode(this.enabled);
    }

    public String toString() {
        return "PushDeviceModel(id=" + this.id + ", token=" + this.token + ", language=" + this.language + ", version=" + this.version + ", registered=" + this.registered + ", enabled=" + this.enabled + ")";
    }

    public PushDeviceModel(String id, String token, String language, String version, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(version, "version");
        this.id = id;
        this.token = token;
        this.language = language;
        this.version = version;
        this.registered = z;
        this.enabled = z2;
    }

    public final String getId() {
        return this.id;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getVersion() {
        return this.version;
    }

    public final boolean getRegistered() {
        return this.registered;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }
}
