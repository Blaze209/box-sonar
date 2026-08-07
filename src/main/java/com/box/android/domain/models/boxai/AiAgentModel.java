package com.box.android.domain.models.boxai;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AiAgentModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003JA\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/box/android/domain/models/boxai/AiAgentModel;", "Lcom/box/android/domain/models/DomainModel;", "id", "", "name", "isDefault", "", "iconLink", "description", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "()Z", "getIconLink", "getDescription", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AiAgentModel implements DomainModel {
    private final String description;
    private final String iconLink;
    private final String id;
    private final boolean isDefault;
    private final String name;

    public static /* synthetic */ AiAgentModel copy$default(AiAgentModel aiAgentModel, String str, String str2, boolean z, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = aiAgentModel.id;
        }
        if ((i & 2) != 0) {
            str2 = aiAgentModel.name;
        }
        if ((i & 4) != 0) {
            z = aiAgentModel.isDefault;
        }
        if ((i & 8) != 0) {
            str3 = aiAgentModel.iconLink;
        }
        if ((i & 16) != 0) {
            str4 = aiAgentModel.description;
        }
        String str5 = str4;
        boolean z2 = z;
        return aiAgentModel.copy(str, str2, z2, str3, str5);
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
    public final boolean getIsDefault() {
        return this.isDefault;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getIconLink() {
        return this.iconLink;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final AiAgentModel copy(String id, String name, boolean isDefault, String iconLink, String description) {
        Intrinsics.checkNotNullParameter(id, "id");
        return new AiAgentModel(id, name, isDefault, iconLink, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AiAgentModel)) {
            return false;
        }
        AiAgentModel aiAgentModel = (AiAgentModel) other;
        return Intrinsics.areEqual(this.id, aiAgentModel.id) && Intrinsics.areEqual(this.name, aiAgentModel.name) && this.isDefault == aiAgentModel.isDefault && Intrinsics.areEqual(this.iconLink, aiAgentModel.iconLink) && Intrinsics.areEqual(this.description, aiAgentModel.description);
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        String str = this.name;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.isDefault)) * 31;
        String str2 = this.iconLink;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.description;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "AiAgentModel(id=" + this.id + ", name=" + this.name + ", isDefault=" + this.isDefault + ", iconLink=" + this.iconLink + ", description=" + this.description + ")";
    }

    public AiAgentModel(String id, String str, boolean z, String str2, String str3) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
        this.name = str;
        this.isDefault = z;
        this.iconLink = str2;
        this.description = str3;
    }

    public /* synthetic */ AiAgentModel(String str, String str2, boolean z, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4);
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean isDefault() {
        return this.isDefault;
    }

    public final String getIconLink() {
        return this.iconLink;
    }

    public final String getDescription() {
        return this.description;
    }
}
