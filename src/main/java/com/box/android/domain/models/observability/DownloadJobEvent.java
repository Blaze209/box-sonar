package com.box.android.domain.models.observability;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Gen204EventModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u008d\u0001\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\t\u00104\u001a\u00020\u0004HÆ\u0003J\t\u00105\u001a\u00020\u0006HÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u00107\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u00108\u001a\u00020\nHÆ\u0003J\t\u00109\u001a\u00020\nHÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010;\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010=\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010(J\u000b\u0010>\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0016HÆ\u0003J¢\u0001\u0010A\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÆ\u0001¢\u0006\u0002\u0010BJ\u0013\u0010C\u001a\u00020\u00062\b\u0010D\u001a\u0004\u0018\u00010EHÖ\u0003J\t\u0010F\u001a\u00020\nHÖ\u0001J\t\u0010G\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u0007\u0010\u001dR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010)\u001a\u0004\b*\u0010(R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001aR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u0006H"}, d2 = {"Lcom/box/android/domain/models/observability/DownloadJobEvent;", "Lcom/box/android/domain/models/observability/Gen204Event;", "Lcom/box/android/domain/models/DomainModel;", "fileId", "", TelemetryEventStrings.Value.FAILED, "", "isRecoverable", "failReason", "numberOfAutomaticRetries", "", "numberOfManualRetries", "sizeKB", "", "sizeBucket", "initiatedAt", "", "runningDuration", "itemState", SemanticAttributes.EventDomainValues.DEVICE, "Lcom/box/android/domain/models/observability/DeviceMetric;", "user", "Lcom/box/android/domain/models/observability/UserMetric;", "<init>", "(Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/String;IILjava/lang/Double;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Lcom/box/android/domain/models/observability/DeviceMetric;Lcom/box/android/domain/models/observability/UserMetric;)V", "getFileId", "()Ljava/lang/String;", "getFailed", "()Z", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFailReason", "getNumberOfAutomaticRetries", "()I", "getNumberOfManualRetries", "getSizeKB", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getSizeBucket", "getInitiatedAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getRunningDuration", "getItemState", "getDevice", "()Lcom/box/android/domain/models/observability/DeviceMetric;", "setDevice", "(Lcom/box/android/domain/models/observability/DeviceMetric;)V", "getUser", "()Lcom/box/android/domain/models/observability/UserMetric;", "setUser", "(Lcom/box/android/domain/models/observability/UserMetric;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/String;IILjava/lang/Double;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Lcom/box/android/domain/models/observability/DeviceMetric;Lcom/box/android/domain/models/observability/UserMetric;)Lcom/box/android/domain/models/observability/DownloadJobEvent;", "equals", "other", "", "hashCode", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class DownloadJobEvent extends Gen204Event implements DomainModel {
    private DeviceMetric device;
    private final String failReason;
    private final boolean failed;
    private final String fileId;
    private final Long initiatedAt;
    private final Boolean isRecoverable;
    private final String itemState;
    private final int numberOfAutomaticRetries;
    private final int numberOfManualRetries;
    private final Long runningDuration;
    private final String sizeBucket;
    private final Double sizeKB;
    private UserMetric user;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadJobEvent(String fileId, boolean z, Boolean bool, String str, int i, int i2, Double d, String str2) {
        this(fileId, z, bool, str, i, i2, d, str2, null, null, null, null, null, 7936, null);
        Intrinsics.checkNotNullParameter(fileId, "fileId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadJobEvent(String fileId, boolean z, Boolean bool, String str, int i, int i2, Double d, String str2, Long l) {
        this(fileId, z, bool, str, i, i2, d, str2, l, null, null, null, null, 7680, null);
        Intrinsics.checkNotNullParameter(fileId, "fileId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadJobEvent(String fileId, boolean z, Boolean bool, String str, int i, int i2, Double d, String str2, Long l, Long l2) {
        this(fileId, z, bool, str, i, i2, d, str2, l, l2, null, null, null, 7168, null);
        Intrinsics.checkNotNullParameter(fileId, "fileId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadJobEvent(String fileId, boolean z, Boolean bool, String str, int i, int i2, Double d, String str2, Long l, Long l2, String str3) {
        this(fileId, z, bool, str, i, i2, d, str2, l, l2, str3, null, null, 6144, null);
        Intrinsics.checkNotNullParameter(fileId, "fileId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadJobEvent(String fileId, boolean z, Boolean bool, String str, int i, int i2, Double d, String str2, Long l, Long l2, String str3, DeviceMetric deviceMetric) {
        this(fileId, z, bool, str, i, i2, d, str2, l, l2, str3, deviceMetric, null, 4096, null);
        Intrinsics.checkNotNullParameter(fileId, "fileId");
    }

    public static /* synthetic */ DownloadJobEvent copy$default(DownloadJobEvent downloadJobEvent, String str, boolean z, Boolean bool, String str2, int i, int i2, Double d, String str3, Long l, Long l2, String str4, DeviceMetric deviceMetric, UserMetric userMetric, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = downloadJobEvent.fileId;
        }
        return downloadJobEvent.copy(str, (i3 & 2) != 0 ? downloadJobEvent.failed : z, (i3 & 4) != 0 ? downloadJobEvent.isRecoverable : bool, (i3 & 8) != 0 ? downloadJobEvent.failReason : str2, (i3 & 16) != 0 ? downloadJobEvent.numberOfAutomaticRetries : i, (i3 & 32) != 0 ? downloadJobEvent.numberOfManualRetries : i2, (i3 & 64) != 0 ? downloadJobEvent.sizeKB : d, (i3 & 128) != 0 ? downloadJobEvent.sizeBucket : str3, (i3 & 256) != 0 ? downloadJobEvent.initiatedAt : l, (i3 & 512) != 0 ? downloadJobEvent.runningDuration : l2, (i3 & 1024) != 0 ? downloadJobEvent.itemState : str4, (i3 & 2048) != 0 ? downloadJobEvent.device : deviceMetric, (i3 & 4096) != 0 ? downloadJobEvent.user : userMetric);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFileId() {
        return this.fileId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Long getRunningDuration() {
        return this.runningDuration;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getItemState() {
        return this.itemState;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final DeviceMetric getDevice() {
        return this.device;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final UserMetric getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getFailed() {
        return this.failed;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Boolean getIsRecoverable() {
        return this.isRecoverable;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getFailReason() {
        return this.failReason;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getNumberOfAutomaticRetries() {
        return this.numberOfAutomaticRetries;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getNumberOfManualRetries() {
        return this.numberOfManualRetries;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Double getSizeKB() {
        return this.sizeKB;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getSizeBucket() {
        return this.sizeBucket;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Long getInitiatedAt() {
        return this.initiatedAt;
    }

    public final DownloadJobEvent copy(String fileId, boolean failed, Boolean isRecoverable, String failReason, int numberOfAutomaticRetries, int numberOfManualRetries, Double sizeKB, String sizeBucket, Long initiatedAt, Long runningDuration, String itemState, DeviceMetric device, UserMetric user) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        return new DownloadJobEvent(fileId, failed, isRecoverable, failReason, numberOfAutomaticRetries, numberOfManualRetries, sizeKB, sizeBucket, initiatedAt, runningDuration, itemState, device, user);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DownloadJobEvent)) {
            return false;
        }
        DownloadJobEvent downloadJobEvent = (DownloadJobEvent) other;
        return Intrinsics.areEqual(this.fileId, downloadJobEvent.fileId) && this.failed == downloadJobEvent.failed && Intrinsics.areEqual(this.isRecoverable, downloadJobEvent.isRecoverable) && Intrinsics.areEqual(this.failReason, downloadJobEvent.failReason) && this.numberOfAutomaticRetries == downloadJobEvent.numberOfAutomaticRetries && this.numberOfManualRetries == downloadJobEvent.numberOfManualRetries && Intrinsics.areEqual((Object) this.sizeKB, (Object) downloadJobEvent.sizeKB) && Intrinsics.areEqual(this.sizeBucket, downloadJobEvent.sizeBucket) && Intrinsics.areEqual(this.initiatedAt, downloadJobEvent.initiatedAt) && Intrinsics.areEqual(this.runningDuration, downloadJobEvent.runningDuration) && Intrinsics.areEqual(this.itemState, downloadJobEvent.itemState) && Intrinsics.areEqual(this.device, downloadJobEvent.device) && Intrinsics.areEqual(this.user, downloadJobEvent.user);
    }

    public int hashCode() {
        int iHashCode = ((this.fileId.hashCode() * 31) + Boolean.hashCode(this.failed)) * 31;
        Boolean bool = this.isRecoverable;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.failReason;
        int iHashCode3 = (((((iHashCode2 + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.numberOfAutomaticRetries)) * 31) + Integer.hashCode(this.numberOfManualRetries)) * 31;
        Double d = this.sizeKB;
        int iHashCode4 = (iHashCode3 + (d == null ? 0 : d.hashCode())) * 31;
        String str2 = this.sizeBucket;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.initiatedAt;
        int iHashCode6 = (iHashCode5 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.runningDuration;
        int iHashCode7 = (iHashCode6 + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str3 = this.itemState;
        int iHashCode8 = (iHashCode7 + (str3 == null ? 0 : str3.hashCode())) * 31;
        DeviceMetric deviceMetric = this.device;
        int iHashCode9 = (iHashCode8 + (deviceMetric == null ? 0 : deviceMetric.hashCode())) * 31;
        UserMetric userMetric = this.user;
        return iHashCode9 + (userMetric != null ? userMetric.hashCode() : 0);
    }

    public String toString() {
        return "DownloadJobEvent(fileId=" + this.fileId + ", failed=" + this.failed + ", isRecoverable=" + this.isRecoverable + ", failReason=" + this.failReason + ", numberOfAutomaticRetries=" + this.numberOfAutomaticRetries + ", numberOfManualRetries=" + this.numberOfManualRetries + ", sizeKB=" + this.sizeKB + ", sizeBucket=" + this.sizeBucket + ", initiatedAt=" + this.initiatedAt + ", runningDuration=" + this.runningDuration + ", itemState=" + this.itemState + ", device=" + this.device + ", user=" + this.user + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadJobEvent(String fileId, boolean z, Boolean bool, String str, int i, int i2, Double d, String str2, Long l, Long l2, String str3, DeviceMetric deviceMetric, UserMetric userMetric) {
        super(0L, null, null, 7, null);
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        this.fileId = fileId;
        this.failed = z;
        this.isRecoverable = bool;
        this.failReason = str;
        this.numberOfAutomaticRetries = i;
        this.numberOfManualRetries = i2;
        this.sizeKB = d;
        this.sizeBucket = str2;
        this.initiatedAt = l;
        this.runningDuration = l2;
        this.itemState = str3;
        this.device = deviceMetric;
        this.user = userMetric;
    }

    public /* synthetic */ DownloadJobEvent(String str, boolean z, Boolean bool, String str2, int i, int i2, Double d, String str3, Long l, Long l2, String str4, DeviceMetric deviceMetric, UserMetric userMetric, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, bool, str2, i, i2, d, str3, (i3 & 256) != 0 ? null : l, (i3 & 512) != 0 ? null : l2, (i3 & 1024) != 0 ? null : str4, (i3 & 2048) != 0 ? null : deviceMetric, (i3 & 4096) != 0 ? null : userMetric);
    }

    public final String getFileId() {
        return this.fileId;
    }

    public final boolean getFailed() {
        return this.failed;
    }

    public final Boolean isRecoverable() {
        return this.isRecoverable;
    }

    public final String getFailReason() {
        return this.failReason;
    }

    public final int getNumberOfAutomaticRetries() {
        return this.numberOfAutomaticRetries;
    }

    public final int getNumberOfManualRetries() {
        return this.numberOfManualRetries;
    }

    public final Double getSizeKB() {
        return this.sizeKB;
    }

    public final String getSizeBucket() {
        return this.sizeBucket;
    }

    public final Long getInitiatedAt() {
        return this.initiatedAt;
    }

    public final Long getRunningDuration() {
        return this.runningDuration;
    }

    public final String getItemState() {
        return this.itemState;
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
