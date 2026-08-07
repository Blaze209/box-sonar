package com.box.android.domain.models.observability;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.DomainModel;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Gen204EventModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BI\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010$\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000eHÆ\u0003JT\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u00060"}, d2 = {"Lcom/box/android/domain/models/observability/HubListLoadingEvent;", "Lcom/box/android/domain/models/observability/Gen204Event;", "Lcom/box/android/domain/models/DomainModel;", "Lcom/box/android/domain/models/observability/HubEvent;", "sortPreferences", "", "itemsScreenMode", "ttiMs", "", "failReason", "Lcom/box/android/domain/models/DomainError;", SemanticAttributes.EventDomainValues.DEVICE, "Lcom/box/android/domain/models/observability/DeviceMetric;", "user", "Lcom/box/android/domain/models/observability/UserMetric;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/box/android/domain/models/DomainError;Lcom/box/android/domain/models/observability/DeviceMetric;Lcom/box/android/domain/models/observability/UserMetric;)V", "getSortPreferences", "()Ljava/lang/String;", "getItemsScreenMode", "getTtiMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFailReason", "()Lcom/box/android/domain/models/DomainError;", "getDevice", "()Lcom/box/android/domain/models/observability/DeviceMetric;", "setDevice", "(Lcom/box/android/domain/models/observability/DeviceMetric;)V", "getUser", "()Lcom/box/android/domain/models/observability/UserMetric;", "setUser", "(Lcom/box/android/domain/models/observability/UserMetric;)V", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/box/android/domain/models/DomainError;Lcom/box/android/domain/models/observability/DeviceMetric;Lcom/box/android/domain/models/observability/UserMetric;)Lcom/box/android/domain/models/observability/HubListLoadingEvent;", "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class HubListLoadingEvent extends Gen204Event implements DomainModel, HubEvent {
    private DeviceMetric device;
    private final DomainError failReason;
    private final String itemsScreenMode;
    private final String sortPreferences;
    private final Long ttiMs;
    private UserMetric user;

    public static /* synthetic */ HubListLoadingEvent copy$default(HubListLoadingEvent hubListLoadingEvent, String str, String str2, Long l, DomainError domainError, DeviceMetric deviceMetric, UserMetric userMetric, int i, Object obj) {
        if ((i & 1) != 0) {
            str = hubListLoadingEvent.sortPreferences;
        }
        if ((i & 2) != 0) {
            str2 = hubListLoadingEvent.itemsScreenMode;
        }
        if ((i & 4) != 0) {
            l = hubListLoadingEvent.ttiMs;
        }
        if ((i & 8) != 0) {
            domainError = hubListLoadingEvent.failReason;
        }
        if ((i & 16) != 0) {
            deviceMetric = hubListLoadingEvent.device;
        }
        if ((i & 32) != 0) {
            userMetric = hubListLoadingEvent.user;
        }
        DeviceMetric deviceMetric2 = deviceMetric;
        UserMetric userMetric2 = userMetric;
        return hubListLoadingEvent.copy(str, str2, l, domainError, deviceMetric2, userMetric2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSortPreferences() {
        return this.sortPreferences;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getItemsScreenMode() {
        return this.itemsScreenMode;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getTtiMs() {
        return this.ttiMs;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final DomainError getFailReason() {
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

    public final HubListLoadingEvent copy(String sortPreferences, String itemsScreenMode, Long ttiMs, DomainError failReason, DeviceMetric device, UserMetric user) {
        Intrinsics.checkNotNullParameter(itemsScreenMode, "itemsScreenMode");
        return new HubListLoadingEvent(sortPreferences, itemsScreenMode, ttiMs, failReason, device, user);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HubListLoadingEvent)) {
            return false;
        }
        HubListLoadingEvent hubListLoadingEvent = (HubListLoadingEvent) other;
        return Intrinsics.areEqual(this.sortPreferences, hubListLoadingEvent.sortPreferences) && Intrinsics.areEqual(this.itemsScreenMode, hubListLoadingEvent.itemsScreenMode) && Intrinsics.areEqual(this.ttiMs, hubListLoadingEvent.ttiMs) && Intrinsics.areEqual(this.failReason, hubListLoadingEvent.failReason) && Intrinsics.areEqual(this.device, hubListLoadingEvent.device) && Intrinsics.areEqual(this.user, hubListLoadingEvent.user);
    }

    public int hashCode() {
        String str = this.sortPreferences;
        int iHashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.itemsScreenMode.hashCode()) * 31;
        Long l = this.ttiMs;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        DomainError domainError = this.failReason;
        int iHashCode3 = (iHashCode2 + (domainError == null ? 0 : domainError.hashCode())) * 31;
        DeviceMetric deviceMetric = this.device;
        int iHashCode4 = (iHashCode3 + (deviceMetric == null ? 0 : deviceMetric.hashCode())) * 31;
        UserMetric userMetric = this.user;
        return iHashCode4 + (userMetric != null ? userMetric.hashCode() : 0);
    }

    public String toString() {
        return "HubListLoadingEvent(sortPreferences=" + this.sortPreferences + ", itemsScreenMode=" + this.itemsScreenMode + ", ttiMs=" + this.ttiMs + ", failReason=" + this.failReason + ", device=" + this.device + ", user=" + this.user + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HubListLoadingEvent(String str, String itemsScreenMode, Long l, DomainError domainError, DeviceMetric deviceMetric, UserMetric userMetric) {
        super(0L, null, null, 7, null);
        Intrinsics.checkNotNullParameter(itemsScreenMode, "itemsScreenMode");
        this.sortPreferences = str;
        this.itemsScreenMode = itemsScreenMode;
        this.ttiMs = l;
        this.failReason = domainError;
        this.device = deviceMetric;
        this.user = userMetric;
    }

    public /* synthetic */ HubListLoadingEvent(String str, String str2, Long l, DomainError domainError, DeviceMetric deviceMetric, UserMetric userMetric, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : domainError, (i & 16) != 0 ? null : deviceMetric, (i & 32) != 0 ? null : userMetric);
    }

    public final String getSortPreferences() {
        return this.sortPreferences;
    }

    public final String getItemsScreenMode() {
        return this.itemsScreenMode;
    }

    public final Long getTtiMs() {
        return this.ttiMs;
    }

    public final DomainError getFailReason() {
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
