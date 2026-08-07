package com.box.android.domain.models.observability;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Gen204EventModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0002/0BA\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010!\u001a\u00020\u0004HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000eHÆ\u0003JI\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u00061"}, d2 = {"Lcom/box/android/domain/models/observability/PerformanceEvent;", "Lcom/box/android/domain/models/observability/Gen204Event;", "Lcom/box/android/domain/models/DomainModel;", "type", "Lcom/box/android/domain/models/observability/PerformanceEvent$Type;", "message", "", "duration", "", "status", "Lcom/box/android/domain/models/observability/PerformanceEvent$Status;", SemanticAttributes.EventDomainValues.DEVICE, "Lcom/box/android/domain/models/observability/DeviceMetric;", "user", "Lcom/box/android/domain/models/observability/UserMetric;", "<init>", "(Lcom/box/android/domain/models/observability/PerformanceEvent$Type;Ljava/lang/String;JLcom/box/android/domain/models/observability/PerformanceEvent$Status;Lcom/box/android/domain/models/observability/DeviceMetric;Lcom/box/android/domain/models/observability/UserMetric;)V", "getType", "()Lcom/box/android/domain/models/observability/PerformanceEvent$Type;", "getMessage", "()Ljava/lang/String;", "getDuration", "()J", "getStatus", "()Lcom/box/android/domain/models/observability/PerformanceEvent$Status;", "getDevice", "()Lcom/box/android/domain/models/observability/DeviceMetric;", "setDevice", "(Lcom/box/android/domain/models/observability/DeviceMetric;)V", "getUser", "()Lcom/box/android/domain/models/observability/UserMetric;", "setUser", "(Lcom/box/android/domain/models/observability/UserMetric;)V", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "Type", "Status", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PerformanceEvent extends Gen204Event implements DomainModel {
    private DeviceMetric device;
    private final long duration;
    private final String message;
    private final Status status;
    private final Type type;
    private UserMetric user;

    /* JADX INFO: compiled from: Gen204EventModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/box/android/domain/models/observability/PerformanceEvent$Status;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "FAILURE", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum Status {
        SUCCESS,
        FAILURE;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<Status> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: Gen204EventModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/box/android/domain/models/observability/PerformanceEvent$Type;", "", "<init>", "(Ljava/lang/String;I)V", "SEARCH_API", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum Type {
        SEARCH_API;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PerformanceEvent(Type type, String message, long j, Status status) {
        this(type, message, j, status, null, null, 48, null);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(status, "status");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PerformanceEvent(Type type, String message, long j, Status status, DeviceMetric deviceMetric) {
        this(type, message, j, status, deviceMetric, null, 32, null);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(status, "status");
    }

    public static /* synthetic */ PerformanceEvent copy$default(PerformanceEvent performanceEvent, Type type, String str, long j, Status status, DeviceMetric deviceMetric, UserMetric userMetric, int i, Object obj) {
        if ((i & 1) != 0) {
            type = performanceEvent.type;
        }
        if ((i & 2) != 0) {
            str = performanceEvent.message;
        }
        if ((i & 4) != 0) {
            j = performanceEvent.duration;
        }
        if ((i & 8) != 0) {
            status = performanceEvent.status;
        }
        if ((i & 16) != 0) {
            deviceMetric = performanceEvent.device;
        }
        if ((i & 32) != 0) {
            userMetric = performanceEvent.user;
        }
        UserMetric userMetric2 = userMetric;
        Status status2 = status;
        long j2 = j;
        return performanceEvent.copy(type, str, j2, status2, deviceMetric, userMetric2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Type getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Status getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final DeviceMetric getDevice() {
        return this.device;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final UserMetric getUser() {
        return this.user;
    }

    public final PerformanceEvent copy(Type type, String message, long duration, Status status, DeviceMetric device, UserMetric user) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(status, "status");
        return new PerformanceEvent(type, message, duration, status, device, user);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PerformanceEvent)) {
            return false;
        }
        PerformanceEvent performanceEvent = (PerformanceEvent) other;
        return this.type == performanceEvent.type && Intrinsics.areEqual(this.message, performanceEvent.message) && this.duration == performanceEvent.duration && this.status == performanceEvent.status && Intrinsics.areEqual(this.device, performanceEvent.device) && Intrinsics.areEqual(this.user, performanceEvent.user);
    }

    public int hashCode() {
        int iHashCode = ((((((this.type.hashCode() * 31) + this.message.hashCode()) * 31) + Long.hashCode(this.duration)) * 31) + this.status.hashCode()) * 31;
        DeviceMetric deviceMetric = this.device;
        int iHashCode2 = (iHashCode + (deviceMetric == null ? 0 : deviceMetric.hashCode())) * 31;
        UserMetric userMetric = this.user;
        return iHashCode2 + (userMetric != null ? userMetric.hashCode() : 0);
    }

    public String toString() {
        return "PerformanceEvent(type=" + this.type + ", message=" + this.message + ", duration=" + this.duration + ", status=" + this.status + ", device=" + this.device + ", user=" + this.user + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PerformanceEvent(Type type, String message, long j, Status status, DeviceMetric deviceMetric, UserMetric userMetric) {
        super(0L, null, null, 7, null);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(status, "status");
        this.type = type;
        this.message = message;
        this.duration = j;
        this.status = status;
        this.device = deviceMetric;
        this.user = userMetric;
    }

    public /* synthetic */ PerformanceEvent(Type type, String str, long j, Status status, DeviceMetric deviceMetric, UserMetric userMetric, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(type, str, j, status, (i & 16) != 0 ? null : deviceMetric, (i & 32) != 0 ? null : userMetric);
    }

    public final Type getType() {
        return this.type;
    }

    public final String getMessage() {
        return this.message;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final Status getStatus() {
        return this.status;
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
