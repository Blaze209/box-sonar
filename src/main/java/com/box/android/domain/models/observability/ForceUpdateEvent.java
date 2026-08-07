package com.box.android.domain.models.observability;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import com.box.android.domain.models.ForceUpdateReason;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Gen204EventModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001&B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003J7\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006'"}, d2 = {"Lcom/box/android/domain/models/observability/ForceUpdateEvent;", "Lcom/box/android/domain/models/observability/Gen204Event;", "Lcom/box/android/domain/models/DomainModel;", "eventSubType", "Lcom/box/android/domain/models/observability/ForceUpdateEvent$EventSubType;", "forceUpdateReason", "Lcom/box/android/domain/models/ForceUpdateReason;", SemanticAttributes.EventDomainValues.DEVICE, "Lcom/box/android/domain/models/observability/DeviceMetric;", "user", "Lcom/box/android/domain/models/observability/UserMetric;", "<init>", "(Lcom/box/android/domain/models/observability/ForceUpdateEvent$EventSubType;Lcom/box/android/domain/models/ForceUpdateReason;Lcom/box/android/domain/models/observability/DeviceMetric;Lcom/box/android/domain/models/observability/UserMetric;)V", "getEventSubType", "()Lcom/box/android/domain/models/observability/ForceUpdateEvent$EventSubType;", "getForceUpdateReason", "()Lcom/box/android/domain/models/ForceUpdateReason;", "getDevice", "()Lcom/box/android/domain/models/observability/DeviceMetric;", "setDevice", "(Lcom/box/android/domain/models/observability/DeviceMetric;)V", "getUser", "()Lcom/box/android/domain/models/observability/UserMetric;", "setUser", "(Lcom/box/android/domain/models/observability/UserMetric;)V", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "EventSubType", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ForceUpdateEvent extends Gen204Event implements DomainModel {
    private DeviceMetric device;
    private final EventSubType eventSubType;
    private final ForceUpdateReason forceUpdateReason;
    private UserMetric user;

    /* JADX INFO: compiled from: Gen204EventModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/domain/models/observability/ForceUpdateEvent$EventSubType;", "", "<init>", "(Ljava/lang/String;I)V", "Triggered", "InAppUpdateStarted", "InAppUpdateResumed", "FallbackUpdateNotAvailable", "FallbackUpdateCheckFailed", "GooglePlayWebFallback", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum EventSubType {
        Triggered,
        InAppUpdateStarted,
        InAppUpdateResumed,
        FallbackUpdateNotAvailable,
        FallbackUpdateCheckFailed,
        GooglePlayWebFallback;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<EventSubType> getEntries() {
            return $ENTRIES;
        }
    }

    public static /* synthetic */ ForceUpdateEvent copy$default(ForceUpdateEvent forceUpdateEvent, EventSubType eventSubType, ForceUpdateReason forceUpdateReason, DeviceMetric deviceMetric, UserMetric userMetric, int i, Object obj) {
        if ((i & 1) != 0) {
            eventSubType = forceUpdateEvent.eventSubType;
        }
        if ((i & 2) != 0) {
            forceUpdateReason = forceUpdateEvent.forceUpdateReason;
        }
        if ((i & 4) != 0) {
            deviceMetric = forceUpdateEvent.device;
        }
        if ((i & 8) != 0) {
            userMetric = forceUpdateEvent.user;
        }
        return forceUpdateEvent.copy(eventSubType, forceUpdateReason, deviceMetric, userMetric);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final EventSubType getEventSubType() {
        return this.eventSubType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ForceUpdateReason getForceUpdateReason() {
        return this.forceUpdateReason;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final DeviceMetric getDevice() {
        return this.device;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final UserMetric getUser() {
        return this.user;
    }

    public final ForceUpdateEvent copy(EventSubType eventSubType, ForceUpdateReason forceUpdateReason, DeviceMetric device, UserMetric user) {
        Intrinsics.checkNotNullParameter(eventSubType, "eventSubType");
        return new ForceUpdateEvent(eventSubType, forceUpdateReason, device, user);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ForceUpdateEvent)) {
            return false;
        }
        ForceUpdateEvent forceUpdateEvent = (ForceUpdateEvent) other;
        return this.eventSubType == forceUpdateEvent.eventSubType && this.forceUpdateReason == forceUpdateEvent.forceUpdateReason && Intrinsics.areEqual(this.device, forceUpdateEvent.device) && Intrinsics.areEqual(this.user, forceUpdateEvent.user);
    }

    public int hashCode() {
        int iHashCode = this.eventSubType.hashCode() * 31;
        ForceUpdateReason forceUpdateReason = this.forceUpdateReason;
        int iHashCode2 = (iHashCode + (forceUpdateReason == null ? 0 : forceUpdateReason.hashCode())) * 31;
        DeviceMetric deviceMetric = this.device;
        int iHashCode3 = (iHashCode2 + (deviceMetric == null ? 0 : deviceMetric.hashCode())) * 31;
        UserMetric userMetric = this.user;
        return iHashCode3 + (userMetric != null ? userMetric.hashCode() : 0);
    }

    public String toString() {
        return "ForceUpdateEvent(eventSubType=" + this.eventSubType + ", forceUpdateReason=" + this.forceUpdateReason + ", device=" + this.device + ", user=" + this.user + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForceUpdateEvent(EventSubType eventSubType, ForceUpdateReason forceUpdateReason, DeviceMetric deviceMetric, UserMetric userMetric) {
        super(0L, null, null, 7, null);
        Intrinsics.checkNotNullParameter(eventSubType, "eventSubType");
        this.eventSubType = eventSubType;
        this.forceUpdateReason = forceUpdateReason;
        this.device = deviceMetric;
        this.user = userMetric;
    }

    public /* synthetic */ ForceUpdateEvent(EventSubType eventSubType, ForceUpdateReason forceUpdateReason, DeviceMetric deviceMetric, UserMetric userMetric, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(eventSubType, (i & 2) != 0 ? null : forceUpdateReason, (i & 4) != 0 ? null : deviceMetric, (i & 8) != 0 ? null : userMetric);
    }

    public final EventSubType getEventSubType() {
        return this.eventSubType;
    }

    public final ForceUpdateReason getForceUpdateReason() {
        return this.forceUpdateReason;
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
