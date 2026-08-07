package com.box.android.domain.models.observability;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.jobs.JobType;
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
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001OB§\u0001\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\t\u00109\u001a\u00020\u0004HÆ\u0003J\t\u0010:\u001a\u00020\u0006HÆ\u0003J\t\u0010;\u001a\u00020\bHÆ\u0003J\t\u0010<\u001a\u00020\nHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010)J\u0010\u0010A\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010)J\u0010\u0010B\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010)J\t\u0010C\u001a\u00020\u0010HÆ\u0003J\t\u0010D\u001a\u00020\u0010HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0019HÆ\u0003J¶\u0001\u0010H\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u00102\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÆ\u0001¢\u0006\u0002\u0010IJ\u0013\u0010J\u001a\u00020\b2\b\u0010K\u001a\u0004\u0018\u00010LHÖ\u0003J\t\u0010M\u001a\u00020\u0010HÖ\u0001J\t\u0010N\u001a\u00020\fHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010*\u001a\u0004\b+\u0010)R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010*\u001a\u0004\b,\u0010)R\u0011\u0010\u0013\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0014\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b/\u0010.R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b0\u0010%R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006P"}, d2 = {"Lcom/box/android/domain/models/observability/OfflineEvent;", "Lcom/box/android/domain/models/observability/Gen204Event;", "Lcom/box/android/domain/models/DomainModel;", "eventType", "Lcom/box/android/domain/models/observability/OfflineEvent$EventType;", "remoteId", "Lcom/box/android/domain/models/ItemId$Remote;", TelemetryEventStrings.Value.FAILED, "", "jobManagerVersion", "Lcom/box/android/domain/models/observability/JobManagerVersion;", "failReason", "", "downloadOriginalStatus", "downloadPreviewStatus", "totalFiles", "", "succeededFiles", "failedFiles", "numberOfAutomaticRetries", "numberOfManualRetries", "itemState", SemanticAttributes.EventDomainValues.DEVICE, "Lcom/box/android/domain/models/observability/DeviceMetric;", "user", "Lcom/box/android/domain/models/observability/UserMetric;", "<init>", "(Lcom/box/android/domain/models/observability/OfflineEvent$EventType;Lcom/box/android/domain/models/ItemId$Remote;ZLcom/box/android/domain/models/observability/JobManagerVersion;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;IILjava/lang/String;Lcom/box/android/domain/models/observability/DeviceMetric;Lcom/box/android/domain/models/observability/UserMetric;)V", "getEventType", "()Lcom/box/android/domain/models/observability/OfflineEvent$EventType;", "getRemoteId", "()Lcom/box/android/domain/models/ItemId$Remote;", "getFailed", "()Z", "getJobManagerVersion", "()Lcom/box/android/domain/models/observability/JobManagerVersion;", "getFailReason", "()Ljava/lang/String;", "getDownloadOriginalStatus", "getDownloadPreviewStatus", "getTotalFiles", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSucceededFiles", "getFailedFiles", "getNumberOfAutomaticRetries", "()I", "getNumberOfManualRetries", "getItemState", "getDevice", "()Lcom/box/android/domain/models/observability/DeviceMetric;", "setDevice", "(Lcom/box/android/domain/models/observability/DeviceMetric;)V", "getUser", "()Lcom/box/android/domain/models/observability/UserMetric;", "setUser", "(Lcom/box/android/domain/models/observability/UserMetric;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Lcom/box/android/domain/models/observability/OfflineEvent$EventType;Lcom/box/android/domain/models/ItemId$Remote;ZLcom/box/android/domain/models/observability/JobManagerVersion;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;IILjava/lang/String;Lcom/box/android/domain/models/observability/DeviceMetric;Lcom/box/android/domain/models/observability/UserMetric;)Lcom/box/android/domain/models/observability/OfflineEvent;", "equals", "other", "", "hashCode", "toString", "EventType", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class OfflineEvent extends Gen204Event implements DomainModel {
    private DeviceMetric device;
    private final String downloadOriginalStatus;
    private final String downloadPreviewStatus;
    private final EventType eventType;
    private final String failReason;
    private final boolean failed;
    private final Integer failedFiles;
    private final String itemState;
    private final JobManagerVersion jobManagerVersion;
    private final int numberOfAutomaticRetries;
    private final int numberOfManualRetries;
    private final ItemId.Remote remoteId;
    private final Integer succeededFiles;
    private final Integer totalFiles;
    private UserMetric user;

    /* JADX INFO: compiled from: Gen204EventModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/box/android/domain/models/observability/OfflineEvent$EventType;", "", "<init>", "(Ljava/lang/String;I)V", "MarkForOfflineFile", JobType.MARK_FOR_OFFLINE_FOLDER, "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum EventType {
        MarkForOfflineFile,
        MarkForOfflineFolder;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<EventType> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OfflineEvent(EventType eventType, ItemId.Remote remoteId, boolean z, JobManagerVersion jobManagerVersion, String str) {
        this(eventType, remoteId, z, jobManagerVersion, str, null, null, null, null, null, 0, 0, null, null, null, 32736, null);
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(remoteId, "remoteId");
        Intrinsics.checkNotNullParameter(jobManagerVersion, "jobManagerVersion");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OfflineEvent(EventType eventType, ItemId.Remote remoteId, boolean z, JobManagerVersion jobManagerVersion, String str, String str2) {
        this(eventType, remoteId, z, jobManagerVersion, str, str2, null, null, null, null, 0, 0, null, null, null, 32704, null);
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(remoteId, "remoteId");
        Intrinsics.checkNotNullParameter(jobManagerVersion, "jobManagerVersion");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OfflineEvent(EventType eventType, ItemId.Remote remoteId, boolean z, JobManagerVersion jobManagerVersion, String str, String str2, String str3) {
        this(eventType, remoteId, z, jobManagerVersion, str, str2, str3, null, null, null, 0, 0, null, null, null, 32640, null);
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(remoteId, "remoteId");
        Intrinsics.checkNotNullParameter(jobManagerVersion, "jobManagerVersion");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OfflineEvent(EventType eventType, ItemId.Remote remoteId, boolean z, JobManagerVersion jobManagerVersion, String str, String str2, String str3, Integer num) {
        this(eventType, remoteId, z, jobManagerVersion, str, str2, str3, num, null, null, 0, 0, null, null, null, 32512, null);
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(remoteId, "remoteId");
        Intrinsics.checkNotNullParameter(jobManagerVersion, "jobManagerVersion");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OfflineEvent(EventType eventType, ItemId.Remote remoteId, boolean z, JobManagerVersion jobManagerVersion, String str, String str2, String str3, Integer num, Integer num2) {
        this(eventType, remoteId, z, jobManagerVersion, str, str2, str3, num, num2, null, 0, 0, null, null, null, 32256, null);
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(remoteId, "remoteId");
        Intrinsics.checkNotNullParameter(jobManagerVersion, "jobManagerVersion");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OfflineEvent(EventType eventType, ItemId.Remote remoteId, boolean z, JobManagerVersion jobManagerVersion, String str, String str2, String str3, Integer num, Integer num2, Integer num3) {
        this(eventType, remoteId, z, jobManagerVersion, str, str2, str3, num, num2, num3, 0, 0, null, null, null, 31744, null);
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(remoteId, "remoteId");
        Intrinsics.checkNotNullParameter(jobManagerVersion, "jobManagerVersion");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OfflineEvent(EventType eventType, ItemId.Remote remoteId, boolean z, JobManagerVersion jobManagerVersion, String str, String str2, String str3, Integer num, Integer num2, Integer num3, int i) {
        this(eventType, remoteId, z, jobManagerVersion, str, str2, str3, num, num2, num3, i, 0, null, null, null, 30720, null);
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(remoteId, "remoteId");
        Intrinsics.checkNotNullParameter(jobManagerVersion, "jobManagerVersion");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OfflineEvent(EventType eventType, ItemId.Remote remoteId, boolean z, JobManagerVersion jobManagerVersion, String str, String str2, String str3, Integer num, Integer num2, Integer num3, int i, int i2) {
        this(eventType, remoteId, z, jobManagerVersion, str, str2, str3, num, num2, num3, i, i2, null, null, null, 28672, null);
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(remoteId, "remoteId");
        Intrinsics.checkNotNullParameter(jobManagerVersion, "jobManagerVersion");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OfflineEvent(EventType eventType, ItemId.Remote remoteId, boolean z, JobManagerVersion jobManagerVersion, String str, String str2, String str3, Integer num, Integer num2, Integer num3, int i, int i2, String str4) {
        this(eventType, remoteId, z, jobManagerVersion, str, str2, str3, num, num2, num3, i, i2, str4, null, null, 24576, null);
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(remoteId, "remoteId");
        Intrinsics.checkNotNullParameter(jobManagerVersion, "jobManagerVersion");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OfflineEvent(EventType eventType, ItemId.Remote remoteId, boolean z, JobManagerVersion jobManagerVersion, String str, String str2, String str3, Integer num, Integer num2, Integer num3, int i, int i2, String str4, DeviceMetric deviceMetric) {
        this(eventType, remoteId, z, jobManagerVersion, str, str2, str3, num, num2, num3, i, i2, str4, deviceMetric, null, 16384, null);
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(remoteId, "remoteId");
        Intrinsics.checkNotNullParameter(jobManagerVersion, "jobManagerVersion");
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final EventType getEventType() {
        return this.eventType;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Integer getFailedFiles() {
        return this.failedFiles;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getNumberOfAutomaticRetries() {
        return this.numberOfAutomaticRetries;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final int getNumberOfManualRetries() {
        return this.numberOfManualRetries;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getItemState() {
        return this.itemState;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final DeviceMetric getDevice() {
        return this.device;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final UserMetric getUser() {
        return this.user;
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
    public final String getDownloadOriginalStatus() {
        return this.downloadOriginalStatus;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getDownloadPreviewStatus() {
        return this.downloadPreviewStatus;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Integer getTotalFiles() {
        return this.totalFiles;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Integer getSucceededFiles() {
        return this.succeededFiles;
    }

    public final OfflineEvent copy(EventType eventType, ItemId.Remote remoteId, boolean failed, JobManagerVersion jobManagerVersion, String failReason, String downloadOriginalStatus, String downloadPreviewStatus, Integer totalFiles, Integer succeededFiles, Integer failedFiles, int numberOfAutomaticRetries, int numberOfManualRetries, String itemState, DeviceMetric device, UserMetric user) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(remoteId, "remoteId");
        Intrinsics.checkNotNullParameter(jobManagerVersion, "jobManagerVersion");
        return new OfflineEvent(eventType, remoteId, failed, jobManagerVersion, failReason, downloadOriginalStatus, downloadPreviewStatus, totalFiles, succeededFiles, failedFiles, numberOfAutomaticRetries, numberOfManualRetries, itemState, device, user);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OfflineEvent)) {
            return false;
        }
        OfflineEvent offlineEvent = (OfflineEvent) other;
        return this.eventType == offlineEvent.eventType && Intrinsics.areEqual(this.remoteId, offlineEvent.remoteId) && this.failed == offlineEvent.failed && this.jobManagerVersion == offlineEvent.jobManagerVersion && Intrinsics.areEqual(this.failReason, offlineEvent.failReason) && Intrinsics.areEqual(this.downloadOriginalStatus, offlineEvent.downloadOriginalStatus) && Intrinsics.areEqual(this.downloadPreviewStatus, offlineEvent.downloadPreviewStatus) && Intrinsics.areEqual(this.totalFiles, offlineEvent.totalFiles) && Intrinsics.areEqual(this.succeededFiles, offlineEvent.succeededFiles) && Intrinsics.areEqual(this.failedFiles, offlineEvent.failedFiles) && this.numberOfAutomaticRetries == offlineEvent.numberOfAutomaticRetries && this.numberOfManualRetries == offlineEvent.numberOfManualRetries && Intrinsics.areEqual(this.itemState, offlineEvent.itemState) && Intrinsics.areEqual(this.device, offlineEvent.device) && Intrinsics.areEqual(this.user, offlineEvent.user);
    }

    public int hashCode() {
        int iHashCode = ((((((this.eventType.hashCode() * 31) + this.remoteId.hashCode()) * 31) + Boolean.hashCode(this.failed)) * 31) + this.jobManagerVersion.hashCode()) * 31;
        String str = this.failReason;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.downloadOriginalStatus;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.downloadPreviewStatus;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.totalFiles;
        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.succeededFiles;
        int iHashCode6 = (iHashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.failedFiles;
        int iHashCode7 = (((((iHashCode6 + (num3 == null ? 0 : num3.hashCode())) * 31) + Integer.hashCode(this.numberOfAutomaticRetries)) * 31) + Integer.hashCode(this.numberOfManualRetries)) * 31;
        String str4 = this.itemState;
        int iHashCode8 = (iHashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
        DeviceMetric deviceMetric = this.device;
        int iHashCode9 = (iHashCode8 + (deviceMetric == null ? 0 : deviceMetric.hashCode())) * 31;
        UserMetric userMetric = this.user;
        return iHashCode9 + (userMetric != null ? userMetric.hashCode() : 0);
    }

    public String toString() {
        return "OfflineEvent(eventType=" + this.eventType + ", remoteId=" + this.remoteId + ", failed=" + this.failed + ", jobManagerVersion=" + this.jobManagerVersion + ", failReason=" + this.failReason + ", downloadOriginalStatus=" + this.downloadOriginalStatus + ", downloadPreviewStatus=" + this.downloadPreviewStatus + ", totalFiles=" + this.totalFiles + ", succeededFiles=" + this.succeededFiles + ", failedFiles=" + this.failedFiles + ", numberOfAutomaticRetries=" + this.numberOfAutomaticRetries + ", numberOfManualRetries=" + this.numberOfManualRetries + ", itemState=" + this.itemState + ", device=" + this.device + ", user=" + this.user + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineEvent(EventType eventType, ItemId.Remote remoteId, boolean z, JobManagerVersion jobManagerVersion, String str, String str2, String str3, Integer num, Integer num2, Integer num3, int i, int i2, String str4, DeviceMetric deviceMetric, UserMetric userMetric) {
        super(0L, null, null, 7, null);
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(remoteId, "remoteId");
        Intrinsics.checkNotNullParameter(jobManagerVersion, "jobManagerVersion");
        this.eventType = eventType;
        this.remoteId = remoteId;
        this.failed = z;
        this.jobManagerVersion = jobManagerVersion;
        this.failReason = str;
        this.downloadOriginalStatus = str2;
        this.downloadPreviewStatus = str3;
        this.totalFiles = num;
        this.succeededFiles = num2;
        this.failedFiles = num3;
        this.numberOfAutomaticRetries = i;
        this.numberOfManualRetries = i2;
        this.itemState = str4;
        this.device = deviceMetric;
        this.user = userMetric;
    }

    public /* synthetic */ OfflineEvent(EventType eventType, ItemId.Remote remote, boolean z, JobManagerVersion jobManagerVersion, String str, String str2, String str3, Integer num, Integer num2, Integer num3, int i, int i2, String str4, DeviceMetric deviceMetric, UserMetric userMetric, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(eventType, remote, z, jobManagerVersion, str, (i3 & 32) != 0 ? null : str2, (i3 & 64) != 0 ? null : str3, (i3 & 128) != 0 ? null : num, (i3 & 256) != 0 ? null : num2, (i3 & 512) != 0 ? null : num3, (i3 & 1024) != 0 ? 0 : i, (i3 & 2048) != 0 ? 0 : i2, (i3 & 4096) != 0 ? null : str4, (i3 & 8192) != 0 ? null : deviceMetric, (i3 & 16384) != 0 ? null : userMetric);
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

    public final String getDownloadOriginalStatus() {
        return this.downloadOriginalStatus;
    }

    public final String getDownloadPreviewStatus() {
        return this.downloadPreviewStatus;
    }

    public final Integer getTotalFiles() {
        return this.totalFiles;
    }

    public final Integer getSucceededFiles() {
        return this.succeededFiles;
    }

    public final Integer getFailedFiles() {
        return this.failedFiles;
    }

    public final int getNumberOfAutomaticRetries() {
        return this.numberOfAutomaticRetries;
    }

    public final int getNumberOfManualRetries() {
        return this.numberOfManualRetries;
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
