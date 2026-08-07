package com.box.android.domain.models.observability;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import com.box.android.domain.models.ItemId;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Gen204EventModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002BS\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010$\u001a\u00020\u0004HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010&\u001a\u00020\bHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010)\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u000fHÆ\u0003J^\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020\b2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u00020\u0006HÖ\u0001J\t\u00101\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001b\u0010\u0015R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u00062"}, d2 = {"Lcom/box/android/domain/models/observability/FolderLoadEvent;", "Lcom/box/android/domain/models/observability/Gen204Event;", "Lcom/box/android/domain/models/DomainModel;", "remoteId", "Lcom/box/android/domain/models/ItemId$Remote;", "numberOfItems", "", TelemetryEventStrings.Value.FAILED, "", "failReason", "", "errorCode", SemanticAttributes.EventDomainValues.DEVICE, "Lcom/box/android/domain/models/observability/DeviceMetric;", "user", "Lcom/box/android/domain/models/observability/UserMetric;", "<init>", "(Lcom/box/android/domain/models/ItemId$Remote;Ljava/lang/Integer;ZLjava/lang/String;Ljava/lang/Integer;Lcom/box/android/domain/models/observability/DeviceMetric;Lcom/box/android/domain/models/observability/UserMetric;)V", "getRemoteId", "()Lcom/box/android/domain/models/ItemId$Remote;", "getNumberOfItems", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFailed", "()Z", "getFailReason", "()Ljava/lang/String;", "getErrorCode", "getDevice", "()Lcom/box/android/domain/models/observability/DeviceMetric;", "setDevice", "(Lcom/box/android/domain/models/observability/DeviceMetric;)V", "getUser", "()Lcom/box/android/domain/models/observability/UserMetric;", "setUser", "(Lcom/box/android/domain/models/observability/UserMetric;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Lcom/box/android/domain/models/ItemId$Remote;Ljava/lang/Integer;ZLjava/lang/String;Ljava/lang/Integer;Lcom/box/android/domain/models/observability/DeviceMetric;Lcom/box/android/domain/models/observability/UserMetric;)Lcom/box/android/domain/models/observability/FolderLoadEvent;", "equals", "other", "", "hashCode", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FolderLoadEvent extends Gen204Event implements DomainModel {
    private DeviceMetric device;
    private final Integer errorCode;
    private final String failReason;
    private final boolean failed;
    private final Integer numberOfItems;
    private final ItemId.Remote remoteId;
    private UserMetric user;

    public static /* synthetic */ FolderLoadEvent copy$default(FolderLoadEvent folderLoadEvent, ItemId.Remote remote, Integer num, boolean z, String str, Integer num2, DeviceMetric deviceMetric, UserMetric userMetric, int i, Object obj) {
        if ((i & 1) != 0) {
            remote = folderLoadEvent.remoteId;
        }
        if ((i & 2) != 0) {
            num = folderLoadEvent.numberOfItems;
        }
        if ((i & 4) != 0) {
            z = folderLoadEvent.failed;
        }
        if ((i & 8) != 0) {
            str = folderLoadEvent.failReason;
        }
        if ((i & 16) != 0) {
            num2 = folderLoadEvent.errorCode;
        }
        if ((i & 32) != 0) {
            deviceMetric = folderLoadEvent.device;
        }
        if ((i & 64) != 0) {
            userMetric = folderLoadEvent.user;
        }
        DeviceMetric deviceMetric2 = deviceMetric;
        UserMetric userMetric2 = userMetric;
        Integer num3 = num2;
        boolean z2 = z;
        return folderLoadEvent.copy(remote, num, z2, str, num3, deviceMetric2, userMetric2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ItemId.Remote getRemoteId() {
        return this.remoteId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getNumberOfItems() {
        return this.numberOfItems;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getFailed() {
        return this.failed;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getFailReason() {
        return this.failReason;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getErrorCode() {
        return this.errorCode;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final DeviceMetric getDevice() {
        return this.device;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final UserMetric getUser() {
        return this.user;
    }

    public final FolderLoadEvent copy(ItemId.Remote remoteId, Integer numberOfItems, boolean failed, String failReason, Integer errorCode, DeviceMetric device, UserMetric user) {
        Intrinsics.checkNotNullParameter(remoteId, "remoteId");
        return new FolderLoadEvent(remoteId, numberOfItems, failed, failReason, errorCode, device, user);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FolderLoadEvent)) {
            return false;
        }
        FolderLoadEvent folderLoadEvent = (FolderLoadEvent) other;
        return Intrinsics.areEqual(this.remoteId, folderLoadEvent.remoteId) && Intrinsics.areEqual(this.numberOfItems, folderLoadEvent.numberOfItems) && this.failed == folderLoadEvent.failed && Intrinsics.areEqual(this.failReason, folderLoadEvent.failReason) && Intrinsics.areEqual(this.errorCode, folderLoadEvent.errorCode) && Intrinsics.areEqual(this.device, folderLoadEvent.device) && Intrinsics.areEqual(this.user, folderLoadEvent.user);
    }

    public int hashCode() {
        int iHashCode = this.remoteId.hashCode() * 31;
        Integer num = this.numberOfItems;
        int iHashCode2 = (((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + Boolean.hashCode(this.failed)) * 31;
        String str = this.failReason;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num2 = this.errorCode;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        DeviceMetric deviceMetric = this.device;
        int iHashCode5 = (iHashCode4 + (deviceMetric == null ? 0 : deviceMetric.hashCode())) * 31;
        UserMetric userMetric = this.user;
        return iHashCode5 + (userMetric != null ? userMetric.hashCode() : 0);
    }

    public String toString() {
        return "FolderLoadEvent(remoteId=" + this.remoteId + ", numberOfItems=" + this.numberOfItems + ", failed=" + this.failed + ", failReason=" + this.failReason + ", errorCode=" + this.errorCode + ", device=" + this.device + ", user=" + this.user + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FolderLoadEvent(ItemId.Remote remoteId, Integer num, boolean z, String str, Integer num2, DeviceMetric deviceMetric, UserMetric userMetric) {
        super(0L, null, null, 7, null);
        Intrinsics.checkNotNullParameter(remoteId, "remoteId");
        this.remoteId = remoteId;
        this.numberOfItems = num;
        this.failed = z;
        this.failReason = str;
        this.errorCode = num2;
        this.device = deviceMetric;
        this.user = userMetric;
    }

    public /* synthetic */ FolderLoadEvent(ItemId.Remote remote, Integer num, boolean z, String str, Integer num2, DeviceMetric deviceMetric, UserMetric userMetric, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(remote, (i & 2) != 0 ? null : num, z, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : num2, (i & 32) != 0 ? null : deviceMetric, (i & 64) != 0 ? null : userMetric);
    }

    public final ItemId.Remote getRemoteId() {
        return this.remoteId;
    }

    public final Integer getNumberOfItems() {
        return this.numberOfItems;
    }

    public final boolean getFailed() {
        return this.failed;
    }

    public final String getFailReason() {
        return this.failReason;
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    @Override // com.box.android.domain.models.observability.Gen204Event
    public DeviceMetric getDevice() {
        return this.device;
    }

    @Override // com.box.android.domain.models.observability.Gen204Event
    public void setDevice(DeviceMetric deviceMetric) {
        this.device = deviceMetric;
    }

    @Override // com.box.android.domain.models.observability.Gen204Event
    public UserMetric getUser() {
        return this.user;
    }

    @Override // com.box.android.domain.models.observability.Gen204Event
    public void setUser(UserMetric userMetric) {
        this.user = userMetric;
    }
}
