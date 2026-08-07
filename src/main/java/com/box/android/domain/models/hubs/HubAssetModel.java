package com.box.android.domain.models.hubs;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HubModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/box/android/domain/models/hubs/HubAssetModel;", "Lcom/box/android/domain/models/DomainModel;", "type", "Lcom/box/android/domain/models/hubs/HubAssetType;", "signedUrl", "", "lastUpdated", "Ljava/util/Date;", "<init>", "(Lcom/box/android/domain/models/hubs/HubAssetType;Ljava/lang/String;Ljava/util/Date;)V", "getType", "()Lcom/box/android/domain/models/hubs/HubAssetType;", "getSignedUrl", "()Ljava/lang/String;", "getLastUpdated", "()Ljava/util/Date;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class HubAssetModel implements DomainModel {
    private final Date lastUpdated;
    private final String signedUrl;
    private final HubAssetType type;

    public static /* synthetic */ HubAssetModel copy$default(HubAssetModel hubAssetModel, HubAssetType hubAssetType, String str, Date date, int i, Object obj) {
        if ((i & 1) != 0) {
            hubAssetType = hubAssetModel.type;
        }
        if ((i & 2) != 0) {
            str = hubAssetModel.signedUrl;
        }
        if ((i & 4) != 0) {
            date = hubAssetModel.lastUpdated;
        }
        return hubAssetModel.copy(hubAssetType, str, date);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final HubAssetType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSignedUrl() {
        return this.signedUrl;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Date getLastUpdated() {
        return this.lastUpdated;
    }

    public final HubAssetModel copy(HubAssetType type, String signedUrl, Date lastUpdated) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new HubAssetModel(type, signedUrl, lastUpdated);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HubAssetModel)) {
            return false;
        }
        HubAssetModel hubAssetModel = (HubAssetModel) other;
        return this.type == hubAssetModel.type && Intrinsics.areEqual(this.signedUrl, hubAssetModel.signedUrl) && Intrinsics.areEqual(this.lastUpdated, hubAssetModel.lastUpdated);
    }

    public int hashCode() {
        int iHashCode = this.type.hashCode() * 31;
        String str = this.signedUrl;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Date date = this.lastUpdated;
        return iHashCode2 + (date != null ? date.hashCode() : 0);
    }

    public String toString() {
        return "HubAssetModel(type=" + this.type + ", signedUrl=" + this.signedUrl + ", lastUpdated=" + this.lastUpdated + ")";
    }

    public HubAssetModel(HubAssetType type, String str, Date date) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.signedUrl = str;
        this.lastUpdated = date;
    }

    public /* synthetic */ HubAssetModel(HubAssetType hubAssetType, String str, Date date, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(hubAssetType, str, (i & 4) != 0 ? null : date);
    }

    public final Date getLastUpdated() {
        return this.lastUpdated;
    }

    public final String getSignedUrl() {
        return this.signedUrl;
    }

    public final HubAssetType getType() {
        return this.type;
    }
}
