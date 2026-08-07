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
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002:\u00013BK\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010&\u001a\u00020\u0004HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010*\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u000eHÆ\u0003JT\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020#2\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u00020\nHÖ\u0001J\t\u00102\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0011\u0010\"\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u00064"}, d2 = {"Lcom/box/android/domain/models/observability/AuthEvent;", "Lcom/box/android/domain/models/observability/Gen204Event;", "Lcom/box/android/domain/models/DomainModel;", "eventType", "Lcom/box/android/domain/models/observability/AuthEvent$EventType;", "completionStatus", "Lcom/box/android/domain/models/observability/Gen204ActionCompletionStatus;", "failReason", "", "errorCode", "", SemanticAttributes.EventDomainValues.DEVICE, "Lcom/box/android/domain/models/observability/DeviceMetric;", "user", "Lcom/box/android/domain/models/observability/UserMetric;", "<init>", "(Lcom/box/android/domain/models/observability/AuthEvent$EventType;Lcom/box/android/domain/models/observability/Gen204ActionCompletionStatus;Ljava/lang/String;Ljava/lang/Integer;Lcom/box/android/domain/models/observability/DeviceMetric;Lcom/box/android/domain/models/observability/UserMetric;)V", "getEventType", "()Lcom/box/android/domain/models/observability/AuthEvent$EventType;", "getCompletionStatus", "()Lcom/box/android/domain/models/observability/Gen204ActionCompletionStatus;", "getFailReason", "()Ljava/lang/String;", "getErrorCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDevice", "()Lcom/box/android/domain/models/observability/DeviceMetric;", "setDevice", "(Lcom/box/android/domain/models/observability/DeviceMetric;)V", "getUser", "()Lcom/box/android/domain/models/observability/UserMetric;", "setUser", "(Lcom/box/android/domain/models/observability/UserMetric;)V", TelemetryEventStrings.Value.FAILED, "", "getFailed", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Lcom/box/android/domain/models/observability/AuthEvent$EventType;Lcom/box/android/domain/models/observability/Gen204ActionCompletionStatus;Ljava/lang/String;Ljava/lang/Integer;Lcom/box/android/domain/models/observability/DeviceMetric;Lcom/box/android/domain/models/observability/UserMetric;)Lcom/box/android/domain/models/observability/AuthEvent;", "equals", "other", "", "hashCode", "toString", "EventType", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AuthEvent extends Gen204Event implements DomainModel {
    private final Gen204ActionCompletionStatus completionStatus;
    private DeviceMetric device;
    private final Integer errorCode;
    private final EventType eventType;
    private final String failReason;
    private final boolean failed;
    private UserMetric user;

    /* JADX INFO: compiled from: Gen204EventModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/box/android/domain/models/observability/AuthEvent$EventType;", "", "<init>", "(Ljava/lang/String;I)V", "Login", "Register", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum EventType {
        Login,
        Register;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<EventType> getEntries() {
            return $ENTRIES;
        }
    }

    public static /* synthetic */ AuthEvent copy$default(AuthEvent authEvent, EventType eventType, Gen204ActionCompletionStatus gen204ActionCompletionStatus, String str, Integer num, DeviceMetric deviceMetric, UserMetric userMetric, int i, Object obj) {
        if ((i & 1) != 0) {
            eventType = authEvent.eventType;
        }
        if ((i & 2) != 0) {
            gen204ActionCompletionStatus = authEvent.completionStatus;
        }
        if ((i & 4) != 0) {
            str = authEvent.failReason;
        }
        if ((i & 8) != 0) {
            num = authEvent.errorCode;
        }
        if ((i & 16) != 0) {
            deviceMetric = authEvent.device;
        }
        if ((i & 32) != 0) {
            userMetric = authEvent.user;
        }
        DeviceMetric deviceMetric2 = deviceMetric;
        UserMetric userMetric2 = userMetric;
        return authEvent.copy(eventType, gen204ActionCompletionStatus, str, num, deviceMetric2, userMetric2);
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
    public final DeviceMetric getDevice() {
        return this.device;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final UserMetric getUser() {
        return this.user;
    }

    public final AuthEvent copy(EventType eventType, Gen204ActionCompletionStatus completionStatus, String failReason, Integer errorCode, DeviceMetric device, UserMetric user) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        return new AuthEvent(eventType, completionStatus, failReason, errorCode, device, user);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthEvent)) {
            return false;
        }
        AuthEvent authEvent = (AuthEvent) other;
        return this.eventType == authEvent.eventType && this.completionStatus == authEvent.completionStatus && Intrinsics.areEqual(this.failReason, authEvent.failReason) && Intrinsics.areEqual(this.errorCode, authEvent.errorCode) && Intrinsics.areEqual(this.device, authEvent.device) && Intrinsics.areEqual(this.user, authEvent.user);
    }

    public int hashCode() {
        int iHashCode = this.eventType.hashCode() * 31;
        Gen204ActionCompletionStatus gen204ActionCompletionStatus = this.completionStatus;
        int iHashCode2 = (iHashCode + (gen204ActionCompletionStatus == null ? 0 : gen204ActionCompletionStatus.hashCode())) * 31;
        String str = this.failReason;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.errorCode;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        DeviceMetric deviceMetric = this.device;
        int iHashCode5 = (iHashCode4 + (deviceMetric == null ? 0 : deviceMetric.hashCode())) * 31;
        UserMetric userMetric = this.user;
        return iHashCode5 + (userMetric != null ? userMetric.hashCode() : 0);
    }

    public String toString() {
        return "AuthEvent(eventType=" + this.eventType + ", completionStatus=" + this.completionStatus + ", failReason=" + this.failReason + ", errorCode=" + this.errorCode + ", device=" + this.device + ", user=" + this.user + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthEvent(EventType eventType, Gen204ActionCompletionStatus gen204ActionCompletionStatus, String str, Integer num, DeviceMetric deviceMetric, UserMetric userMetric) {
        super(0L, null, null, 7, null);
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        this.eventType = eventType;
        this.completionStatus = gen204ActionCompletionStatus;
        this.failReason = str;
        this.errorCode = num;
        this.device = deviceMetric;
        this.user = userMetric;
        this.failed = (num == null && str == null && gen204ActionCompletionStatus != Gen204ActionCompletionStatus.FAILED) ? false : true;
    }

    public /* synthetic */ AuthEvent(EventType eventType, Gen204ActionCompletionStatus gen204ActionCompletionStatus, String str, Integer num, DeviceMetric deviceMetric, UserMetric userMetric, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(eventType, (i & 2) != 0 ? null : gen204ActionCompletionStatus, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : deviceMetric, (i & 32) != 0 ? null : userMetric);
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
