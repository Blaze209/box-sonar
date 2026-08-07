package com.box.android.domain.models.observability;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.DomainModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Gen204EventModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\tHÆ\u0003J0\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/box/android/domain/models/observability/HubAssetLoadingEvent;", "Lcom/box/android/domain/models/observability/Gen204Event;", "Lcom/box/android/domain/models/DomainModel;", "Lcom/box/android/domain/models/observability/HubEvent;", "assetTypeLoaded", "", "duration", "", "failReason", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Lcom/box/android/domain/models/DomainError;)V", "getAssetTypeLoaded", "()Ljava/lang/String;", "getDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFailReason", "()Lcom/box/android/domain/models/DomainError;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/Long;Lcom/box/android/domain/models/DomainError;)Lcom/box/android/domain/models/observability/HubAssetLoadingEvent;", "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class HubAssetLoadingEvent extends Gen204Event implements DomainModel, HubEvent {
    private final String assetTypeLoaded;
    private final Long duration;
    private final DomainError failReason;

    public static /* synthetic */ HubAssetLoadingEvent copy$default(HubAssetLoadingEvent hubAssetLoadingEvent, String str, Long l, DomainError domainError, int i, Object obj) {
        if ((i & 1) != 0) {
            str = hubAssetLoadingEvent.assetTypeLoaded;
        }
        if ((i & 2) != 0) {
            l = hubAssetLoadingEvent.duration;
        }
        if ((i & 4) != 0) {
            domainError = hubAssetLoadingEvent.failReason;
        }
        return hubAssetLoadingEvent.copy(str, l, domainError);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAssetTypeLoaded() {
        return this.assetTypeLoaded;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final DomainError getFailReason() {
        return this.failReason;
    }

    public final HubAssetLoadingEvent copy(String assetTypeLoaded, Long duration, DomainError failReason) {
        Intrinsics.checkNotNullParameter(assetTypeLoaded, "assetTypeLoaded");
        return new HubAssetLoadingEvent(assetTypeLoaded, duration, failReason);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HubAssetLoadingEvent)) {
            return false;
        }
        HubAssetLoadingEvent hubAssetLoadingEvent = (HubAssetLoadingEvent) other;
        return Intrinsics.areEqual(this.assetTypeLoaded, hubAssetLoadingEvent.assetTypeLoaded) && Intrinsics.areEqual(this.duration, hubAssetLoadingEvent.duration) && Intrinsics.areEqual(this.failReason, hubAssetLoadingEvent.failReason);
    }

    public int hashCode() {
        int iHashCode = this.assetTypeLoaded.hashCode() * 31;
        Long l = this.duration;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        DomainError domainError = this.failReason;
        return iHashCode2 + (domainError != null ? domainError.hashCode() : 0);
    }

    public String toString() {
        return "HubAssetLoadingEvent(assetTypeLoaded=" + this.assetTypeLoaded + ", duration=" + this.duration + ", failReason=" + this.failReason + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HubAssetLoadingEvent(String assetTypeLoaded, Long l, DomainError domainError) {
        super(0L, null, null, 7, null);
        Intrinsics.checkNotNullParameter(assetTypeLoaded, "assetTypeLoaded");
        this.assetTypeLoaded = assetTypeLoaded;
        this.duration = l;
        this.failReason = domainError;
    }

    public /* synthetic */ HubAssetLoadingEvent(String str, Long l, DomainError domainError, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : domainError);
    }

    public final String getAssetTypeLoaded() {
        return this.assetTypeLoaded;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final DomainError getFailReason() {
        return this.failReason;
    }
}
