package com.box.android.domain.models.observability;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import com.box.android.domain.models.preview.PreviewerType;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Gen204EventModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b(\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002Bk\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010.\u001a\u00020\u0004HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u00100\u001a\u00020\bHÆ\u0003J\t\u00101\u001a\u00020\nHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010 J\u000b\u00104\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010,J\u0080\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u00109J\u0013\u0010:\u001a\u00020\b2\b\u0010;\u001a\u0004\u0018\u00010<HÖ\u0003J\t\u0010=\u001a\u00020\nHÖ\u0001J\t\u0010>\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0015\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,¨\u0006?"}, d2 = {"Lcom/box/android/domain/models/observability/PreviousVersionPreviewPM23Event;", "Lcom/box/android/domain/models/observability/Gen204Event;", "Lcom/box/android/domain/models/DomainModel;", "fileId", "", "previewerType", "Lcom/box/android/domain/models/preview/PreviewerType;", TelemetryEventStrings.Value.FAILED, "", "versionNumber", "", "failReason", "errorCode", "errorMessage", SemanticAttributes.EventDomainValues.DEVICE, "Lcom/box/android/domain/models/observability/DeviceMetric;", "user", "Lcom/box/android/domain/models/observability/UserMetric;", "ttiMs", "", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/preview/PreviewerType;ZILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/box/android/domain/models/observability/DeviceMetric;Lcom/box/android/domain/models/observability/UserMetric;Ljava/lang/Long;)V", "getFileId", "()Ljava/lang/String;", "getPreviewerType", "()Lcom/box/android/domain/models/preview/PreviewerType;", "getFailed", "()Z", "getVersionNumber", "()I", "getFailReason", "getErrorCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getErrorMessage", "getDevice", "()Lcom/box/android/domain/models/observability/DeviceMetric;", "setDevice", "(Lcom/box/android/domain/models/observability/DeviceMetric;)V", "getUser", "()Lcom/box/android/domain/models/observability/UserMetric;", "setUser", "(Lcom/box/android/domain/models/observability/UserMetric;)V", "getTtiMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Lcom/box/android/domain/models/preview/PreviewerType;ZILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/box/android/domain/models/observability/DeviceMetric;Lcom/box/android/domain/models/observability/UserMetric;Ljava/lang/Long;)Lcom/box/android/domain/models/observability/PreviousVersionPreviewPM23Event;", "equals", "other", "", "hashCode", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PreviousVersionPreviewPM23Event extends Gen204Event implements DomainModel {
    private DeviceMetric device;
    private final Integer errorCode;
    private final String errorMessage;
    private final String failReason;
    private final boolean failed;
    private final String fileId;
    private final PreviewerType previewerType;
    private final Long ttiMs;
    private UserMetric user;
    private final int versionNumber;

    public static /* synthetic */ PreviousVersionPreviewPM23Event copy$default(PreviousVersionPreviewPM23Event previousVersionPreviewPM23Event, String str, PreviewerType previewerType, boolean z, int i, String str2, Integer num, String str3, DeviceMetric deviceMetric, UserMetric userMetric, Long l, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = previousVersionPreviewPM23Event.fileId;
        }
        if ((i2 & 2) != 0) {
            previewerType = previousVersionPreviewPM23Event.previewerType;
        }
        if ((i2 & 4) != 0) {
            z = previousVersionPreviewPM23Event.failed;
        }
        if ((i2 & 8) != 0) {
            i = previousVersionPreviewPM23Event.versionNumber;
        }
        if ((i2 & 16) != 0) {
            str2 = previousVersionPreviewPM23Event.failReason;
        }
        if ((i2 & 32) != 0) {
            num = previousVersionPreviewPM23Event.errorCode;
        }
        if ((i2 & 64) != 0) {
            str3 = previousVersionPreviewPM23Event.errorMessage;
        }
        if ((i2 & 128) != 0) {
            deviceMetric = previousVersionPreviewPM23Event.device;
        }
        if ((i2 & 256) != 0) {
            userMetric = previousVersionPreviewPM23Event.user;
        }
        if ((i2 & 512) != 0) {
            l = previousVersionPreviewPM23Event.ttiMs;
        }
        UserMetric userMetric2 = userMetric;
        Long l2 = l;
        String str4 = str3;
        DeviceMetric deviceMetric2 = deviceMetric;
        String str5 = str2;
        Integer num2 = num;
        return previousVersionPreviewPM23Event.copy(str, previewerType, z, i, str5, num2, str4, deviceMetric2, userMetric2, l2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFileId() {
        return this.fileId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Long getTtiMs() {
        return this.ttiMs;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PreviewerType getPreviewerType() {
        return this.previewerType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getFailed() {
        return this.failed;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getVersionNumber() {
        return this.versionNumber;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getFailReason() {
        return this.failReason;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getErrorCode() {
        return this.errorCode;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final DeviceMetric getDevice() {
        return this.device;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final UserMetric getUser() {
        return this.user;
    }

    public final PreviousVersionPreviewPM23Event copy(String fileId, PreviewerType previewerType, boolean failed, int versionNumber, String failReason, Integer errorCode, String errorMessage, DeviceMetric device, UserMetric user, Long ttiMs) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        return new PreviousVersionPreviewPM23Event(fileId, previewerType, failed, versionNumber, failReason, errorCode, errorMessage, device, user, ttiMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreviousVersionPreviewPM23Event)) {
            return false;
        }
        PreviousVersionPreviewPM23Event previousVersionPreviewPM23Event = (PreviousVersionPreviewPM23Event) other;
        return Intrinsics.areEqual(this.fileId, previousVersionPreviewPM23Event.fileId) && this.previewerType == previousVersionPreviewPM23Event.previewerType && this.failed == previousVersionPreviewPM23Event.failed && this.versionNumber == previousVersionPreviewPM23Event.versionNumber && Intrinsics.areEqual(this.failReason, previousVersionPreviewPM23Event.failReason) && Intrinsics.areEqual(this.errorCode, previousVersionPreviewPM23Event.errorCode) && Intrinsics.areEqual(this.errorMessage, previousVersionPreviewPM23Event.errorMessage) && Intrinsics.areEqual(this.device, previousVersionPreviewPM23Event.device) && Intrinsics.areEqual(this.user, previousVersionPreviewPM23Event.user) && Intrinsics.areEqual(this.ttiMs, previousVersionPreviewPM23Event.ttiMs);
    }

    public int hashCode() {
        int iHashCode = this.fileId.hashCode() * 31;
        PreviewerType previewerType = this.previewerType;
        int iHashCode2 = (((((iHashCode + (previewerType == null ? 0 : previewerType.hashCode())) * 31) + Boolean.hashCode(this.failed)) * 31) + Integer.hashCode(this.versionNumber)) * 31;
        String str = this.failReason;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.errorCode;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.errorMessage;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        DeviceMetric deviceMetric = this.device;
        int iHashCode6 = (iHashCode5 + (deviceMetric == null ? 0 : deviceMetric.hashCode())) * 31;
        UserMetric userMetric = this.user;
        int iHashCode7 = (iHashCode6 + (userMetric == null ? 0 : userMetric.hashCode())) * 31;
        Long l = this.ttiMs;
        return iHashCode7 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        return "PreviousVersionPreviewPM23Event(fileId=" + this.fileId + ", previewerType=" + this.previewerType + ", failed=" + this.failed + ", versionNumber=" + this.versionNumber + ", failReason=" + this.failReason + ", errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ", device=" + this.device + ", user=" + this.user + ", ttiMs=" + this.ttiMs + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviousVersionPreviewPM23Event(String fileId, PreviewerType previewerType, boolean z, int i, String str, Integer num, String str2, DeviceMetric deviceMetric, UserMetric userMetric, Long l) {
        super(0L, null, null, 7, null);
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        this.fileId = fileId;
        this.previewerType = previewerType;
        this.failed = z;
        this.versionNumber = i;
        this.failReason = str;
        this.errorCode = num;
        this.errorMessage = str2;
        this.device = deviceMetric;
        this.user = userMetric;
        this.ttiMs = l;
    }

    public /* synthetic */ PreviousVersionPreviewPM23Event(String str, PreviewerType previewerType, boolean z, int i, String str2, Integer num, String str3, DeviceMetric deviceMetric, UserMetric userMetric, Long l, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, previewerType, z, i, str2, num, str3, (i2 & 128) != 0 ? null : deviceMetric, (i2 & 256) != 0 ? null : userMetric, (i2 & 512) != 0 ? null : l);
    }

    public final String getFileId() {
        return this.fileId;
    }

    public final PreviewerType getPreviewerType() {
        return this.previewerType;
    }

    public final boolean getFailed() {
        return this.failed;
    }

    public final int getVersionNumber() {
        return this.versionNumber;
    }

    public final String getFailReason() {
        return this.failReason;
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
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

    public final Long getTtiMs() {
        return this.ttiMs;
    }
}
