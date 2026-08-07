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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002BC\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\rHÆ\u0003JK\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010%\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006+"}, d2 = {"Lcom/box/android/domain/models/observability/WatermarkingUpdateEvent;", "Lcom/box/android/domain/models/observability/Gen204Event;", "Lcom/box/android/domain/models/DomainModel;", "remoteId", "Lcom/box/android/domain/models/ItemId$Remote;", "isWatermarkEnabled", "", TelemetryEventStrings.Value.FAILED, "failReason", "", SemanticAttributes.EventDomainValues.DEVICE, "Lcom/box/android/domain/models/observability/DeviceMetric;", "user", "Lcom/box/android/domain/models/observability/UserMetric;", "<init>", "(Lcom/box/android/domain/models/ItemId$Remote;ZZLjava/lang/String;Lcom/box/android/domain/models/observability/DeviceMetric;Lcom/box/android/domain/models/observability/UserMetric;)V", "getRemoteId", "()Lcom/box/android/domain/models/ItemId$Remote;", "()Z", "getFailed", "getFailReason", "()Ljava/lang/String;", "getDevice", "()Lcom/box/android/domain/models/observability/DeviceMetric;", "setDevice", "(Lcom/box/android/domain/models/observability/DeviceMetric;)V", "getUser", "()Lcom/box/android/domain/models/observability/UserMetric;", "setUser", "(Lcom/box/android/domain/models/observability/UserMetric;)V", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class WatermarkingUpdateEvent extends Gen204Event implements DomainModel {
    private DeviceMetric device;
    private final String failReason;
    private final boolean failed;
    private final boolean isWatermarkEnabled;
    private final ItemId.Remote remoteId;
    private UserMetric user;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WatermarkingUpdateEvent(ItemId.Remote remoteId, boolean z, boolean z2, String str) {
        this(remoteId, z, z2, str, null, null, 48, null);
        Intrinsics.checkNotNullParameter(remoteId, "remoteId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WatermarkingUpdateEvent(ItemId.Remote remoteId, boolean z, boolean z2, String str, DeviceMetric deviceMetric) {
        this(remoteId, z, z2, str, deviceMetric, null, 32, null);
        Intrinsics.checkNotNullParameter(remoteId, "remoteId");
    }

    public static /* synthetic */ WatermarkingUpdateEvent copy$default(WatermarkingUpdateEvent watermarkingUpdateEvent, ItemId.Remote remote, boolean z, boolean z2, String str, DeviceMetric deviceMetric, UserMetric userMetric, int i, Object obj) {
        if ((i & 1) != 0) {
            remote = watermarkingUpdateEvent.remoteId;
        }
        if ((i & 2) != 0) {
            z = watermarkingUpdateEvent.isWatermarkEnabled;
        }
        if ((i & 4) != 0) {
            z2 = watermarkingUpdateEvent.failed;
        }
        if ((i & 8) != 0) {
            str = watermarkingUpdateEvent.failReason;
        }
        if ((i & 16) != 0) {
            deviceMetric = watermarkingUpdateEvent.device;
        }
        if ((i & 32) != 0) {
            userMetric = watermarkingUpdateEvent.user;
        }
        DeviceMetric deviceMetric2 = deviceMetric;
        UserMetric userMetric2 = userMetric;
        return watermarkingUpdateEvent.copy(remote, z, z2, str, deviceMetric2, userMetric2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ItemId.Remote getRemoteId() {
        return this.remoteId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsWatermarkEnabled() {
        return this.isWatermarkEnabled;
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
    public final DeviceMetric getDevice() {
        return this.device;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final UserMetric getUser() {
        return this.user;
    }

    public final WatermarkingUpdateEvent copy(ItemId.Remote remoteId, boolean isWatermarkEnabled, boolean failed, String failReason, DeviceMetric device, UserMetric user) {
        Intrinsics.checkNotNullParameter(remoteId, "remoteId");
        return new WatermarkingUpdateEvent(remoteId, isWatermarkEnabled, failed, failReason, device, user);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WatermarkingUpdateEvent)) {
            return false;
        }
        WatermarkingUpdateEvent watermarkingUpdateEvent = (WatermarkingUpdateEvent) other;
        return Intrinsics.areEqual(this.remoteId, watermarkingUpdateEvent.remoteId) && this.isWatermarkEnabled == watermarkingUpdateEvent.isWatermarkEnabled && this.failed == watermarkingUpdateEvent.failed && Intrinsics.areEqual(this.failReason, watermarkingUpdateEvent.failReason) && Intrinsics.areEqual(this.device, watermarkingUpdateEvent.device) && Intrinsics.areEqual(this.user, watermarkingUpdateEvent.user);
    }

    public int hashCode() {
        int iHashCode = ((((this.remoteId.hashCode() * 31) + Boolean.hashCode(this.isWatermarkEnabled)) * 31) + Boolean.hashCode(this.failed)) * 31;
        String str = this.failReason;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        DeviceMetric deviceMetric = this.device;
        int iHashCode3 = (iHashCode2 + (deviceMetric == null ? 0 : deviceMetric.hashCode())) * 31;
        UserMetric userMetric = this.user;
        return iHashCode3 + (userMetric != null ? userMetric.hashCode() : 0);
    }

    public String toString() {
        return "WatermarkingUpdateEvent(remoteId=" + this.remoteId + ", isWatermarkEnabled=" + this.isWatermarkEnabled + ", failed=" + this.failed + ", failReason=" + this.failReason + ", device=" + this.device + ", user=" + this.user + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatermarkingUpdateEvent(ItemId.Remote remoteId, boolean z, boolean z2, String str, DeviceMetric deviceMetric, UserMetric userMetric) {
        super(0L, null, null, 7, null);
        Intrinsics.checkNotNullParameter(remoteId, "remoteId");
        this.remoteId = remoteId;
        this.isWatermarkEnabled = z;
        this.failed = z2;
        this.failReason = str;
        this.device = deviceMetric;
        this.user = userMetric;
    }

    public /* synthetic */ WatermarkingUpdateEvent(ItemId.Remote remote, boolean z, boolean z2, String str, DeviceMetric deviceMetric, UserMetric userMetric, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(remote, z, z2, str, (i & 16) != 0 ? null : deviceMetric, (i & 32) != 0 ? null : userMetric);
    }

    public final ItemId.Remote getRemoteId() {
        return this.remoteId;
    }

    public final boolean isWatermarkEnabled() {
        return this.isWatermarkEnabled;
    }

    public final boolean getFailed() {
        return this.failed;
    }

    public final String getFailReason() {
        return this.failReason;
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
