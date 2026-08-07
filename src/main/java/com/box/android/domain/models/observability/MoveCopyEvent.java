package com.box.android.domain.models.observability;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import com.box.android.domain.models.ItemId;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Gen204EventModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002:\u00013BK\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010%\u001a\u00020\u0004HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003J\t\u0010(\u001a\u00020\nHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0010HÆ\u0003JU\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001J\u0013\u0010-\u001a\u00020\b2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u00020\fHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u00064"}, d2 = {"Lcom/box/android/domain/models/observability/MoveCopyEvent;", "Lcom/box/android/domain/models/observability/Gen204Event;", "Lcom/box/android/domain/models/DomainModel;", "eventType", "Lcom/box/android/domain/models/observability/MoveCopyEvent$EventType;", "remoteId", "Lcom/box/android/domain/models/ItemId$Remote;", TelemetryEventStrings.Value.FAILED, "", "jobManagerVersion", "Lcom/box/android/domain/models/observability/JobManagerVersion;", "failReason", "", SemanticAttributes.EventDomainValues.DEVICE, "Lcom/box/android/domain/models/observability/DeviceMetric;", "user", "Lcom/box/android/domain/models/observability/UserMetric;", "<init>", "(Lcom/box/android/domain/models/observability/MoveCopyEvent$EventType;Lcom/box/android/domain/models/ItemId$Remote;ZLcom/box/android/domain/models/observability/JobManagerVersion;Ljava/lang/String;Lcom/box/android/domain/models/observability/DeviceMetric;Lcom/box/android/domain/models/observability/UserMetric;)V", "getEventType", "()Lcom/box/android/domain/models/observability/MoveCopyEvent$EventType;", "getRemoteId", "()Lcom/box/android/domain/models/ItemId$Remote;", "getFailed", "()Z", "getJobManagerVersion", "()Lcom/box/android/domain/models/observability/JobManagerVersion;", "getFailReason", "()Ljava/lang/String;", "getDevice", "()Lcom/box/android/domain/models/observability/DeviceMetric;", "setDevice", "(Lcom/box/android/domain/models/observability/DeviceMetric;)V", "getUser", "()Lcom/box/android/domain/models/observability/UserMetric;", "setUser", "(Lcom/box/android/domain/models/observability/UserMetric;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "EventType", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MoveCopyEvent extends Gen204Event implements DomainModel {
    private DeviceMetric device;
    private final EventType eventType;
    private final String failReason;
    private final boolean failed;
    private final JobManagerVersion jobManagerVersion;
    private final ItemId.Remote remoteId;
    private UserMetric user;

    /* JADX INFO: compiled from: Gen204EventModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/box/android/domain/models/observability/MoveCopyEvent$EventType;", "", "<init>", "(Ljava/lang/String;I)V", "Move", "Copy", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum EventType {
        Move,
        Copy;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<EventType> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MoveCopyEvent(EventType eventType, ItemId.Remote remoteId, boolean z, JobManagerVersion jobManagerVersion, String str) {
        this(eventType, remoteId, z, jobManagerVersion, str, null, null, 96, null);
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(remoteId, "remoteId");
        Intrinsics.checkNotNullParameter(jobManagerVersion, "jobManagerVersion");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MoveCopyEvent(EventType eventType, ItemId.Remote remoteId, boolean z, JobManagerVersion jobManagerVersion, String str, DeviceMetric deviceMetric) {
        this(eventType, remoteId, z, jobManagerVersion, str, deviceMetric, null, 64, null);
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(remoteId, "remoteId");
        Intrinsics.checkNotNullParameter(jobManagerVersion, "jobManagerVersion");
    }

    public static /* synthetic */ MoveCopyEvent copy$default(MoveCopyEvent moveCopyEvent, EventType eventType, ItemId.Remote remote, boolean z, JobManagerVersion jobManagerVersion, String str, DeviceMetric deviceMetric, UserMetric userMetric, int i, Object obj) {
        if ((i & 1) != 0) {
            eventType = moveCopyEvent.eventType;
        }
        if ((i & 2) != 0) {
            remote = moveCopyEvent.remoteId;
        }
        if ((i & 4) != 0) {
            z = moveCopyEvent.failed;
        }
        if ((i & 8) != 0) {
            jobManagerVersion = moveCopyEvent.jobManagerVersion;
        }
        if ((i & 16) != 0) {
            str = moveCopyEvent.failReason;
        }
        if ((i & 32) != 0) {
            deviceMetric = moveCopyEvent.device;
        }
        if ((i & 64) != 0) {
            userMetric = moveCopyEvent.user;
        }
        DeviceMetric deviceMetric2 = deviceMetric;
        UserMetric userMetric2 = userMetric;
        String str2 = str;
        boolean z2 = z;
        return moveCopyEvent.copy(eventType, remote, z2, jobManagerVersion, str2, deviceMetric2, userMetric2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final EventType getEventType() {
        return this.eventType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ItemId.Remote getRemoteId() {
        return this.remoteId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getFailed() {
        return this.failed;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final JobManagerVersion getJobManagerVersion() {
        return this.jobManagerVersion;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getFailReason() {
        return this.failReason;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final DeviceMetric getDevice() {
        return this.device;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final UserMetric getUser() {
        return this.user;
    }

    public final MoveCopyEvent copy(EventType eventType, ItemId.Remote remoteId, boolean failed, JobManagerVersion jobManagerVersion, String failReason, DeviceMetric device, UserMetric user) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(remoteId, "remoteId");
        Intrinsics.checkNotNullParameter(jobManagerVersion, "jobManagerVersion");
        return new MoveCopyEvent(eventType, remoteId, failed, jobManagerVersion, failReason, device, user);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MoveCopyEvent)) {
            return false;
        }
        MoveCopyEvent moveCopyEvent = (MoveCopyEvent) other;
        return this.eventType == moveCopyEvent.eventType && Intrinsics.areEqual(this.remoteId, moveCopyEvent.remoteId) && this.failed == moveCopyEvent.failed && this.jobManagerVersion == moveCopyEvent.jobManagerVersion && Intrinsics.areEqual(this.failReason, moveCopyEvent.failReason) && Intrinsics.areEqual(this.device, moveCopyEvent.device) && Intrinsics.areEqual(this.user, moveCopyEvent.user);
    }

    public int hashCode() {
        int iHashCode = ((((((this.eventType.hashCode() * 31) + this.remoteId.hashCode()) * 31) + Boolean.hashCode(this.failed)) * 31) + this.jobManagerVersion.hashCode()) * 31;
        String str = this.failReason;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        DeviceMetric deviceMetric = this.device;
        int iHashCode3 = (iHashCode2 + (deviceMetric == null ? 0 : deviceMetric.hashCode())) * 31;
        UserMetric userMetric = this.user;
        return iHashCode3 + (userMetric != null ? userMetric.hashCode() : 0);
    }

    public String toString() {
        return "MoveCopyEvent(eventType=" + this.eventType + ", remoteId=" + this.remoteId + ", failed=" + this.failed + ", jobManagerVersion=" + this.jobManagerVersion + ", failReason=" + this.failReason + ", device=" + this.device + ", user=" + this.user + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MoveCopyEvent(EventType eventType, ItemId.Remote remoteId, boolean z, JobManagerVersion jobManagerVersion, String str, DeviceMetric deviceMetric, UserMetric userMetric) {
        super(0L, null, null, 7, null);
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(remoteId, "remoteId");
        Intrinsics.checkNotNullParameter(jobManagerVersion, "jobManagerVersion");
        this.eventType = eventType;
        this.remoteId = remoteId;
        this.failed = z;
        this.jobManagerVersion = jobManagerVersion;
        this.failReason = str;
        this.device = deviceMetric;
        this.user = userMetric;
    }

    public /* synthetic */ MoveCopyEvent(EventType eventType, ItemId.Remote remote, boolean z, JobManagerVersion jobManagerVersion, String str, DeviceMetric deviceMetric, UserMetric userMetric, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(eventType, remote, z, jobManagerVersion, str, (i & 32) != 0 ? null : deviceMetric, (i & 64) != 0 ? null : userMetric);
    }

    public final EventType getEventType() {
        return this.eventType;
    }

    public final ItemId.Remote getRemoteId() {
        return this.remoteId;
    }

    public final boolean getFailed() {
        return this.failed;
    }

    public final JobManagerVersion getJobManagerVersion() {
        return this.jobManagerVersion;
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
