package com.box.android.domain.models.observability;

import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Gen204EventModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B+\b\u0004\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u0082\u0001\u0014\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'¨\u0006("}, d2 = {"Lcom/box/android/domain/models/observability/Gen204Event;", "", "timestamp", "", SemanticAttributes.EventDomainValues.DEVICE, "Lcom/box/android/domain/models/observability/DeviceMetric;", "user", "Lcom/box/android/domain/models/observability/UserMetric;", "<init>", "(JLcom/box/android/domain/models/observability/DeviceMetric;Lcom/box/android/domain/models/observability/UserMetric;)V", "getTimestamp", "()J", "getDevice", "()Lcom/box/android/domain/models/observability/DeviceMetric;", "setDevice", "(Lcom/box/android/domain/models/observability/DeviceMetric;)V", "getUser", "()Lcom/box/android/domain/models/observability/UserMetric;", "setUser", "(Lcom/box/android/domain/models/observability/UserMetric;)V", "Lcom/box/android/domain/models/observability/ApdexGen204Metric;", "Lcom/box/android/domain/models/observability/AuthEvent;", "Lcom/box/android/domain/models/observability/BoxAiEvent;", "Lcom/box/android/domain/models/observability/BrowsePerformanceEvent;", "Lcom/box/android/domain/models/observability/DownloadJobEvent;", "Lcom/box/android/domain/models/observability/FileActivityEvent;", "Lcom/box/android/domain/models/observability/FolderLoadEvent;", "Lcom/box/android/domain/models/observability/ForceUpdateEvent;", "Lcom/box/android/domain/models/observability/HubAssetLoadingEvent;", "Lcom/box/android/domain/models/observability/HubListLoadingEvent;", "Lcom/box/android/domain/models/observability/JobUploadEvent;", "Lcom/box/android/domain/models/observability/LogEvent;", "Lcom/box/android/domain/models/observability/MoveCopyEvent;", "Lcom/box/android/domain/models/observability/MsalEvent;", "Lcom/box/android/domain/models/observability/OfflineEvent;", "Lcom/box/android/domain/models/observability/PerformanceEvent;", "Lcom/box/android/domain/models/observability/PreviewPM23Event;", "Lcom/box/android/domain/models/observability/PreviousVersionPreviewPM23Event;", "Lcom/box/android/domain/models/observability/WatermarkingUpdateEvent;", "Lcom/box/android/domain/models/observability/XPlatformEvent;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class Gen204Event {
    private DeviceMetric device;
    private final long timestamp;
    private UserMetric user;

    public /* synthetic */ Gen204Event(long j, DeviceMetric deviceMetric, UserMetric userMetric, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, deviceMetric, userMetric);
    }

    private Gen204Event(long j, DeviceMetric deviceMetric, UserMetric userMetric) {
        this.timestamp = j;
        this.device = deviceMetric;
        this.user = userMetric;
    }

    public /* synthetic */ Gen204Event(long j, DeviceMetric deviceMetric, UserMetric userMetric, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? System.currentTimeMillis() : j, (i & 2) != 0 ? null : deviceMetric, (i & 4) != 0 ? null : userMetric, null);
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public DeviceMetric getDevice() {
        return this.device;
    }

    public void setDevice(DeviceMetric deviceMetric) {
        this.device = deviceMetric;
    }

    public UserMetric getUser() {
        return this.user;
    }

    public void setUser(UserMetric userMetric) {
        this.user = userMetric;
    }
}
