package com.box.android.domain.models.observability;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Gen204EventModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002:\u00016BW\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010(\u001a\u00020\u0004HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010,\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u000fHÆ\u0003J`\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u00020%2\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u00020\nHÖ\u0001J\t\u00105\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020%¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u00067"}, d2 = {"Lcom/box/android/domain/models/observability/MsalEvent;", "Lcom/box/android/domain/models/observability/Gen204Event;", "Lcom/box/android/domain/models/DomainModel;", "eventType", "Lcom/box/android/domain/models/observability/MsalEvent$EventType;", "completionStatus", "Lcom/box/android/domain/models/observability/Gen204ActionCompletionStatus;", "failReason", "", "errorCode", "", "subtype", SemanticAttributes.EventDomainValues.DEVICE, "Lcom/box/android/domain/models/observability/DeviceMetric;", "user", "Lcom/box/android/domain/models/observability/UserMetric;", "<init>", "(Lcom/box/android/domain/models/observability/MsalEvent$EventType;Lcom/box/android/domain/models/observability/Gen204ActionCompletionStatus;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/box/android/domain/models/observability/DeviceMetric;Lcom/box/android/domain/models/observability/UserMetric;)V", "getEventType", "()Lcom/box/android/domain/models/observability/MsalEvent$EventType;", "getCompletionStatus", "()Lcom/box/android/domain/models/observability/Gen204ActionCompletionStatus;", "getFailReason", "()Ljava/lang/String;", "getErrorCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSubtype", "getDevice", "()Lcom/box/android/domain/models/observability/DeviceMetric;", "setDevice", "(Lcom/box/android/domain/models/observability/DeviceMetric;)V", "getUser", "()Lcom/box/android/domain/models/observability/UserMetric;", "setUser", "(Lcom/box/android/domain/models/observability/UserMetric;)V", TelemetryEventStrings.Value.FAILED, "", "getFailed", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Lcom/box/android/domain/models/observability/MsalEvent$EventType;Lcom/box/android/domain/models/observability/Gen204ActionCompletionStatus;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/box/android/domain/models/observability/DeviceMetric;Lcom/box/android/domain/models/observability/UserMetric;)Lcom/box/android/domain/models/observability/MsalEvent;", "equals", "other", "", "hashCode", "toString", "EventType", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MsalEvent extends Gen204Event implements DomainModel {
    private final Gen204ActionCompletionStatus completionStatus;
    private DeviceMetric device;
    private final Integer errorCode;
    private final EventType eventType;
    private final String failReason;
    private final boolean failed;
    private final String subtype;
    private UserMetric user;

    /* JADX INFO: compiled from: Gen204EventModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/box/android/domain/models/observability/MsalEvent$EventType;", "", "<init>", "(Ljava/lang/String;I)V", "Login", "Remediate", "PolicyBlocked", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum EventType {
        Login,
        Remediate,
        PolicyBlocked;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<EventType> getEntries() {
            return $ENTRIES;
        }
    }

    public static /* synthetic */ MsalEvent copy$default(MsalEvent msalEvent, EventType eventType, Gen204ActionCompletionStatus gen204ActionCompletionStatus, String str, Integer num, String str2, DeviceMetric deviceMetric, UserMetric userMetric, int i, Object obj) {
        if ((i & 1) != 0) {
            eventType = msalEvent.eventType;
        }
        if ((i & 2) != 0) {
            gen204ActionCompletionStatus = msalEvent.completionStatus;
        }
        if ((i & 4) != 0) {
            str = msalEvent.failReason;
        }
        if ((i & 8) != 0) {
            num = msalEvent.errorCode;
        }
        if ((i & 16) != 0) {
            str2 = msalEvent.subtype;
        }
        if ((i & 32) != 0) {
            deviceMetric = msalEvent.device;
        }
        if ((i & 64) != 0) {
            userMetric = msalEvent.user;
        }
        DeviceMetric deviceMetric2 = deviceMetric;
        UserMetric userMetric2 = userMetric;
        String str3 = str2;
        String str4 = str;
        return msalEvent.copy(eventType, gen204ActionCompletionStatus, str4, num, str3, deviceMetric2, userMetric2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final EventType getEventType() {
        return this.eventType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Gen204ActionCompletionStatus getCompletionStatus() {
        return this.completionStatus;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFailReason() {
        return this.failReason;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getErrorCode() {
        return this.errorCode;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSubtype() {
        return this.subtype;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final DeviceMetric getDevice() {
        return this.device;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final UserMetric getUser() {
        return this.user;
    }

    public final MsalEvent copy(EventType eventType, Gen204ActionCompletionStatus completionStatus, String failReason, Integer errorCode, String subtype, DeviceMetric device, UserMetric user) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        return new MsalEvent(eventType, completionStatus, failReason, errorCode, subtype, device, user);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MsalEvent)) {
            return false;
        }
        MsalEvent msalEvent = (MsalEvent) other;
        return this.eventType == msalEvent.eventType && this.completionStatus == msalEvent.completionStatus && Intrinsics.areEqual(this.failReason, msalEvent.failReason) && Intrinsics.areEqual(this.errorCode, msalEvent.errorCode) && Intrinsics.areEqual(this.subtype, msalEvent.subtype) && Intrinsics.areEqual(this.device, msalEvent.device) && Intrinsics.areEqual(this.user, msalEvent.user);
    }

    public int hashCode() {
        int iHashCode = this.eventType.hashCode() * 31;
        Gen204ActionCompletionStatus gen204ActionCompletionStatus = this.completionStatus;
        int iHashCode2 = (iHashCode + (gen204ActionCompletionStatus == null ? 0 : gen204ActionCompletionStatus.hashCode())) * 31;
        String str = this.failReason;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.errorCode;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.subtype;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        DeviceMetric deviceMetric = this.device;
        int iHashCode6 = (iHashCode5 + (deviceMetric == null ? 0 : deviceMetric.hashCode())) * 31;
        UserMetric userMetric = this.user;
        return iHashCode6 + (userMetric != null ? userMetric.hashCode() : 0);
    }

    public String toString() {
        return "MsalEvent(eventType=" + this.eventType + ", completionStatus=" + this.completionStatus + ", failReason=" + this.failReason + ", errorCode=" + this.errorCode + ", subtype=" + this.subtype + ", device=" + this.device + ", user=" + this.user + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsalEvent(EventType eventType, Gen204ActionCompletionStatus gen204ActionCompletionStatus, String str, Integer num, String str2, DeviceMetric deviceMetric, UserMetric userMetric) {
        super(0L, null, null, 7, null);
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        this.eventType = eventType;
        this.completionStatus = gen204ActionCompletionStatus;
        this.failReason = str;
        this.errorCode = num;
        this.subtype = str2;
        this.device = deviceMetric;
        this.user = userMetric;
        this.failed = (num == null && str == null && gen204ActionCompletionStatus != Gen204ActionCompletionStatus.FAILED) ? false : true;
    }

    public /* synthetic */ MsalEvent(EventType eventType, Gen204ActionCompletionStatus gen204ActionCompletionStatus, String str, Integer num, String str2, DeviceMetric deviceMetric, UserMetric userMetric, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(eventType, (i & 2) != 0 ? null : gen204ActionCompletionStatus, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : deviceMetric, (i & 64) != 0 ? null : userMetric);
    }

    public final EventType getEventType() {
        return this.eventType;
    }

    public final Gen204ActionCompletionStatus getCompletionStatus() {
        return this.completionStatus;
    }

    public final String getFailReason() {
        return this.failReason;
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public final String getSubtype() {
        return this.subtype;
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

    public final boolean getFailed() {
        return this.failed;
    }
}
