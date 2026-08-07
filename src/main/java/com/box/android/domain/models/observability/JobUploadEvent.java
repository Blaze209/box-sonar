package com.box.android.domain.models.observability;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import com.box.android.domain.models.ItemId;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Gen204EventModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b:\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002BÇ\u0001\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\b\u0012\b\b\u0002\u0010\u001a\u001a\u00020\b\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b\u001f\u0010 J\t\u0010B\u001a\u00020\u0004HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010D\u001a\u00020\bHÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010F\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010G\u001a\u00020\fHÆ\u0003J\t\u0010H\u001a\u00020\fHÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010.J\u000b\u0010J\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010K\u001a\u00020\u0012HÆ\u0003J\u0010\u0010L\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u00104J\u0010\u0010M\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u00104J\u0010\u0010N\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u00104J\u0010\u0010O\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u00104J\t\u0010P\u001a\u00020\u0004HÆ\u0003J\t\u0010Q\u001a\u00020\bHÆ\u0003J\t\u0010R\u001a\u00020\bHÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u001eHÆ\u0003Jâ\u0001\u0010U\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÆ\u0001¢\u0006\u0002\u0010VJ\u0013\u0010W\u001a\u00020\b2\b\u0010X\u001a\u0004\u0018\u00010YHÖ\u0003J\t\u0010Z\u001a\u00020\fHÖ\u0001J\t\u0010[\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010(\u001a\u0004\b\t\u0010'R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\"R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b,\u0010+R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010/\u001a\u0004\b-\u0010.R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\"R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u00105\u001a\u0004\b3\u00104R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u00105\u001a\u0004\b6\u00104R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u00105\u001a\u0004\b7\u00104R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u00105\u001a\u0004\b8\u00104R\u0011\u0010\u0018\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\"R\u0011\u0010\u0019\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010&R\u0011\u0010\u001a\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010&R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010A¨\u0006\\"}, d2 = {"Lcom/box/android/domain/models/observability/JobUploadEvent;", "Lcom/box/android/domain/models/observability/Gen204Event;", "Lcom/box/android/domain/models/DomainModel;", "jobType", "", "itemId", "Lcom/box/android/domain/models/ItemId;", TelemetryEventStrings.Value.FAILED, "", "isRecoverable", "failReason", "numberOfAutomaticRetries", "", "numberOfManualRetries", "sizeKB", "", "sizeBucket", "jobManagerVersion", "Lcom/box/android/domain/models/observability/JobManagerVersion;", "initiatedAt", "", "runningDuration", "totalTime", "bytesProcessed", "folderId", "isUserTriggeredJob", "isNewVersionUpload", SemanticAttributes.EventDomainValues.DEVICE, "Lcom/box/android/domain/models/observability/DeviceMetric;", "user", "Lcom/box/android/domain/models/observability/UserMetric;", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/ItemId;ZLjava/lang/Boolean;Ljava/lang/String;IILjava/lang/Double;Ljava/lang/String;Lcom/box/android/domain/models/observability/JobManagerVersion;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;ZZLcom/box/android/domain/models/observability/DeviceMetric;Lcom/box/android/domain/models/observability/UserMetric;)V", "getJobType", "()Ljava/lang/String;", "getItemId", "()Lcom/box/android/domain/models/ItemId;", "getFailed", "()Z", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFailReason", "getNumberOfAutomaticRetries", "()I", "getNumberOfManualRetries", "getSizeKB", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getSizeBucket", "getJobManagerVersion", "()Lcom/box/android/domain/models/observability/JobManagerVersion;", "getInitiatedAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getRunningDuration", "getTotalTime", "getBytesProcessed", "getFolderId", "getDevice", "()Lcom/box/android/domain/models/observability/DeviceMetric;", "setDevice", "(Lcom/box/android/domain/models/observability/DeviceMetric;)V", "getUser", "()Lcom/box/android/domain/models/observability/UserMetric;", "setUser", "(Lcom/box/android/domain/models/observability/UserMetric;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Lcom/box/android/domain/models/ItemId;ZLjava/lang/Boolean;Ljava/lang/String;IILjava/lang/Double;Ljava/lang/String;Lcom/box/android/domain/models/observability/JobManagerVersion;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;ZZLcom/box/android/domain/models/observability/DeviceMetric;Lcom/box/android/domain/models/observability/UserMetric;)Lcom/box/android/domain/models/observability/JobUploadEvent;", "equals", "other", "", "hashCode", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class JobUploadEvent extends Gen204Event implements DomainModel {
    private final Long bytesProcessed;
    private DeviceMetric device;
    private final String failReason;
    private final boolean failed;
    private final String folderId;
    private final Long initiatedAt;
    private final boolean isNewVersionUpload;
    private final Boolean isRecoverable;
    private final boolean isUserTriggeredJob;
    private final ItemId itemId;
    private final JobManagerVersion jobManagerVersion;
    private final String jobType;
    private final int numberOfAutomaticRetries;
    private final int numberOfManualRetries;
    private final Long runningDuration;
    private final String sizeBucket;
    private final Double sizeKB;
    private final Long totalTime;
    private UserMetric user;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JobUploadEvent(String jobType, ItemId itemId, boolean z, Boolean bool, String str, int i, int i2, Double d, String str2, JobManagerVersion jobManagerVersion, Long l, Long l2, Long l3, Long l4, String folderId) {
        this(jobType, itemId, z, bool, str, i, i2, d, str2, jobManagerVersion, l, l2, l3, l4, folderId, false, false, null, null, 491520, null);
        Intrinsics.checkNotNullParameter(jobType, "jobType");
        Intrinsics.checkNotNullParameter(jobManagerVersion, "jobManagerVersion");
        Intrinsics.checkNotNullParameter(folderId, "folderId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JobUploadEvent(String jobType, ItemId itemId, boolean z, Boolean bool, String str, int i, int i2, Double d, String str2, JobManagerVersion jobManagerVersion, Long l, Long l2, Long l3, Long l4, String folderId, boolean z2) {
        this(jobType, itemId, z, bool, str, i, i2, d, str2, jobManagerVersion, l, l2, l3, l4, folderId, z2, false, null, null, 458752, null);
        Intrinsics.checkNotNullParameter(jobType, "jobType");
        Intrinsics.checkNotNullParameter(jobManagerVersion, "jobManagerVersion");
        Intrinsics.checkNotNullParameter(folderId, "folderId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JobUploadEvent(String jobType, ItemId itemId, boolean z, Boolean bool, String str, int i, int i2, Double d, String str2, JobManagerVersion jobManagerVersion, Long l, Long l2, Long l3, Long l4, String folderId, boolean z2, boolean z3) {
        this(jobType, itemId, z, bool, str, i, i2, d, str2, jobManagerVersion, l, l2, l3, l4, folderId, z2, z3, null, null, 393216, null);
        Intrinsics.checkNotNullParameter(jobType, "jobType");
        Intrinsics.checkNotNullParameter(jobManagerVersion, "jobManagerVersion");
        Intrinsics.checkNotNullParameter(folderId, "folderId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JobUploadEvent(String jobType, ItemId itemId, boolean z, Boolean bool, String str, int i, int i2, Double d, String str2, JobManagerVersion jobManagerVersion, Long l, Long l2, Long l3, Long l4, String folderId, boolean z2, boolean z3, DeviceMetric deviceMetric) {
        this(jobType, itemId, z, bool, str, i, i2, d, str2, jobManagerVersion, l, l2, l3, l4, folderId, z2, z3, deviceMetric, null, 262144, null);
        Intrinsics.checkNotNullParameter(jobType, "jobType");
        Intrinsics.checkNotNullParameter(jobManagerVersion, "jobManagerVersion");
        Intrinsics.checkNotNullParameter(folderId, "folderId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JobUploadEvent(String jobType, ItemId itemId, boolean z, Boolean bool, String str, int i, int i2, Double d, String str2, JobManagerVersion jobManagerVersion, Long l, Long l2, Long l3, String folderId) {
        this(jobType, itemId, z, bool, str, i, i2, d, str2, jobManagerVersion, l, l2, l3, null, folderId, false, false, null, null, 499712, null);
        Intrinsics.checkNotNullParameter(jobType, "jobType");
        Intrinsics.checkNotNullParameter(jobManagerVersion, "jobManagerVersion");
        Intrinsics.checkNotNullParameter(folderId, "folderId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JobUploadEvent(String jobType, ItemId itemId, boolean z, Boolean bool, String str, int i, int i2, Double d, String str2, JobManagerVersion jobManagerVersion, Long l, Long l2, String folderId) {
        this(jobType, itemId, z, bool, str, i, i2, d, str2, jobManagerVersion, l, l2, null, null, folderId, false, false, null, null, 503808, null);
        Intrinsics.checkNotNullParameter(jobType, "jobType");
        Intrinsics.checkNotNullParameter(jobManagerVersion, "jobManagerVersion");
        Intrinsics.checkNotNullParameter(folderId, "folderId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JobUploadEvent(String jobType, ItemId itemId, boolean z, Boolean bool, String str, int i, int i2, Double d, String str2, JobManagerVersion jobManagerVersion, Long l, String folderId) {
        this(jobType, itemId, z, bool, str, i, i2, d, str2, jobManagerVersion, l, null, null, null, folderId, false, false, null, null, 505856, null);
        Intrinsics.checkNotNullParameter(jobType, "jobType");
        Intrinsics.checkNotNullParameter(jobManagerVersion, "jobManagerVersion");
        Intrinsics.checkNotNullParameter(folderId, "folderId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JobUploadEvent(String jobType, ItemId itemId, boolean z, Boolean bool, String str, int i, int i2, Double d, String str2, JobManagerVersion jobManagerVersion, String folderId) {
        this(jobType, itemId, z, bool, str, i, i2, d, str2, jobManagerVersion, null, null, null, null, folderId, false, false, null, null, 506880, null);
        Intrinsics.checkNotNullParameter(jobType, "jobType");
        Intrinsics.checkNotNullParameter(jobManagerVersion, "jobManagerVersion");
        Intrinsics.checkNotNullParameter(folderId, "folderId");
    }

    public static /* synthetic */ JobUploadEvent copy$default(JobUploadEvent jobUploadEvent, String str, ItemId itemId, boolean z, Boolean bool, String str2, int i, int i2, Double d, String str3, JobManagerVersion jobManagerVersion, Long l, Long l2, Long l3, Long l4, String str4, boolean z2, boolean z3, DeviceMetric deviceMetric, UserMetric userMetric, int i3, Object obj) {
        UserMetric userMetric2;
        DeviceMetric deviceMetric2;
        String str5 = (i3 & 1) != 0 ? jobUploadEvent.jobType : str;
        ItemId itemId2 = (i3 & 2) != 0 ? jobUploadEvent.itemId : itemId;
        boolean z4 = (i3 & 4) != 0 ? jobUploadEvent.failed : z;
        Boolean bool2 = (i3 & 8) != 0 ? jobUploadEvent.isRecoverable : bool;
        String str6 = (i3 & 16) != 0 ? jobUploadEvent.failReason : str2;
        int i4 = (i3 & 32) != 0 ? jobUploadEvent.numberOfAutomaticRetries : i;
        int i5 = (i3 & 64) != 0 ? jobUploadEvent.numberOfManualRetries : i2;
        Double d2 = (i3 & 128) != 0 ? jobUploadEvent.sizeKB : d;
        String str7 = (i3 & 256) != 0 ? jobUploadEvent.sizeBucket : str3;
        JobManagerVersion jobManagerVersion2 = (i3 & 512) != 0 ? jobUploadEvent.jobManagerVersion : jobManagerVersion;
        Long l5 = (i3 & 1024) != 0 ? jobUploadEvent.initiatedAt : l;
        Long l6 = (i3 & 2048) != 0 ? jobUploadEvent.runningDuration : l2;
        Long l7 = (i3 & 4096) != 0 ? jobUploadEvent.totalTime : l3;
        Long l8 = (i3 & 8192) != 0 ? jobUploadEvent.bytesProcessed : l4;
        String str8 = str5;
        String str9 = (i3 & 16384) != 0 ? jobUploadEvent.folderId : str4;
        boolean z5 = (i3 & 32768) != 0 ? jobUploadEvent.isUserTriggeredJob : z2;
        boolean z6 = (i3 & 65536) != 0 ? jobUploadEvent.isNewVersionUpload : z3;
        DeviceMetric deviceMetric3 = (i3 & 131072) != 0 ? jobUploadEvent.device : deviceMetric;
        if ((i3 & 262144) != 0) {
            deviceMetric2 = deviceMetric3;
            userMetric2 = jobUploadEvent.user;
        } else {
            userMetric2 = userMetric;
            deviceMetric2 = deviceMetric3;
        }
        return jobUploadEvent.copy(str8, itemId2, z4, bool2, str6, i4, i5, d2, str7, jobManagerVersion2, l5, l6, l7, l8, str9, z5, z6, deviceMetric2, userMetric2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getJobType() {
        return this.jobType;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final JobManagerVersion getJobManagerVersion() {
        return this.jobManagerVersion;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Long getInitiatedAt() {
        return this.initiatedAt;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Long getRunningDuration() {
        return this.runningDuration;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Long getTotalTime() {
        return this.totalTime;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final Long getBytesProcessed() {
        return this.bytesProcessed;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getFolderId() {
        return this.folderId;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final boolean getIsUserTriggeredJob() {
        return this.isUserTriggeredJob;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final boolean getIsNewVersionUpload() {
        return this.isNewVersionUpload;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final DeviceMetric getDevice() {
        return this.device;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final UserMetric getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ItemId getItemId() {
        return this.itemId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getFailed() {
        return this.failed;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getIsRecoverable() {
        return this.isRecoverable;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getFailReason() {
        return this.failReason;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getNumberOfAutomaticRetries() {
        return this.numberOfAutomaticRetries;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getNumberOfManualRetries() {
        return this.numberOfManualRetries;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Double getSizeKB() {
        return this.sizeKB;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getSizeBucket() {
        return this.sizeBucket;
    }

    public final JobUploadEvent copy(String jobType, ItemId itemId, boolean failed, Boolean isRecoverable, String failReason, int numberOfAutomaticRetries, int numberOfManualRetries, Double sizeKB, String sizeBucket, JobManagerVersion jobManagerVersion, Long initiatedAt, Long runningDuration, Long totalTime, Long bytesProcessed, String folderId, boolean isUserTriggeredJob, boolean isNewVersionUpload, DeviceMetric device, UserMetric user) {
        Intrinsics.checkNotNullParameter(jobType, "jobType");
        Intrinsics.checkNotNullParameter(jobManagerVersion, "jobManagerVersion");
        Intrinsics.checkNotNullParameter(folderId, "folderId");
        return new JobUploadEvent(jobType, itemId, failed, isRecoverable, failReason, numberOfAutomaticRetries, numberOfManualRetries, sizeKB, sizeBucket, jobManagerVersion, initiatedAt, runningDuration, totalTime, bytesProcessed, folderId, isUserTriggeredJob, isNewVersionUpload, device, user);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JobUploadEvent)) {
            return false;
        }
        JobUploadEvent jobUploadEvent = (JobUploadEvent) other;
        return Intrinsics.areEqual(this.jobType, jobUploadEvent.jobType) && Intrinsics.areEqual(this.itemId, jobUploadEvent.itemId) && this.failed == jobUploadEvent.failed && Intrinsics.areEqual(this.isRecoverable, jobUploadEvent.isRecoverable) && Intrinsics.areEqual(this.failReason, jobUploadEvent.failReason) && this.numberOfAutomaticRetries == jobUploadEvent.numberOfAutomaticRetries && this.numberOfManualRetries == jobUploadEvent.numberOfManualRetries && Intrinsics.areEqual((Object) this.sizeKB, (Object) jobUploadEvent.sizeKB) && Intrinsics.areEqual(this.sizeBucket, jobUploadEvent.sizeBucket) && this.jobManagerVersion == jobUploadEvent.jobManagerVersion && Intrinsics.areEqual(this.initiatedAt, jobUploadEvent.initiatedAt) && Intrinsics.areEqual(this.runningDuration, jobUploadEvent.runningDuration) && Intrinsics.areEqual(this.totalTime, jobUploadEvent.totalTime) && Intrinsics.areEqual(this.bytesProcessed, jobUploadEvent.bytesProcessed) && Intrinsics.areEqual(this.folderId, jobUploadEvent.folderId) && this.isUserTriggeredJob == jobUploadEvent.isUserTriggeredJob && this.isNewVersionUpload == jobUploadEvent.isNewVersionUpload && Intrinsics.areEqual(this.device, jobUploadEvent.device) && Intrinsics.areEqual(this.user, jobUploadEvent.user);
    }

    public int hashCode() {
        int iHashCode = this.jobType.hashCode() * 31;
        ItemId itemId = this.itemId;
        int iHashCode2 = (((iHashCode + (itemId == null ? 0 : itemId.hashCode())) * 31) + Boolean.hashCode(this.failed)) * 31;
        Boolean bool = this.isRecoverable;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.failReason;
        int iHashCode4 = (((((iHashCode3 + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.numberOfAutomaticRetries)) * 31) + Integer.hashCode(this.numberOfManualRetries)) * 31;
        Double d = this.sizeKB;
        int iHashCode5 = (iHashCode4 + (d == null ? 0 : d.hashCode())) * 31;
        String str2 = this.sizeBucket;
        int iHashCode6 = (((iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.jobManagerVersion.hashCode()) * 31;
        Long l = this.initiatedAt;
        int iHashCode7 = (iHashCode6 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.runningDuration;
        int iHashCode8 = (iHashCode7 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.totalTime;
        int iHashCode9 = (iHashCode8 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Long l4 = this.bytesProcessed;
        int iHashCode10 = (((((((iHashCode9 + (l4 == null ? 0 : l4.hashCode())) * 31) + this.folderId.hashCode()) * 31) + Boolean.hashCode(this.isUserTriggeredJob)) * 31) + Boolean.hashCode(this.isNewVersionUpload)) * 31;
        DeviceMetric deviceMetric = this.device;
        int iHashCode11 = (iHashCode10 + (deviceMetric == null ? 0 : deviceMetric.hashCode())) * 31;
        UserMetric userMetric = this.user;
        return iHashCode11 + (userMetric != null ? userMetric.hashCode() : 0);
    }

    public String toString() {
        return "JobUploadEvent(jobType=" + this.jobType + ", itemId=" + this.itemId + ", failed=" + this.failed + ", isRecoverable=" + this.isRecoverable + ", failReason=" + this.failReason + ", numberOfAutomaticRetries=" + this.numberOfAutomaticRetries + ", numberOfManualRetries=" + this.numberOfManualRetries + ", sizeKB=" + this.sizeKB + ", sizeBucket=" + this.sizeBucket + ", jobManagerVersion=" + this.jobManagerVersion + ", initiatedAt=" + this.initiatedAt + ", runningDuration=" + this.runningDuration + ", totalTime=" + this.totalTime + ", bytesProcessed=" + this.bytesProcessed + ", folderId=" + this.folderId + ", isUserTriggeredJob=" + this.isUserTriggeredJob + ", isNewVersionUpload=" + this.isNewVersionUpload + ", device=" + this.device + ", user=" + this.user + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JobUploadEvent(String jobType, ItemId itemId, boolean z, Boolean bool, String str, int i, int i2, Double d, String str2, JobManagerVersion jobManagerVersion, Long l, Long l2, Long l3, Long l4, String folderId, boolean z2, boolean z3, DeviceMetric deviceMetric, UserMetric userMetric) {
        super(0L, null, null, 7, null);
        Intrinsics.checkNotNullParameter(jobType, "jobType");
        Intrinsics.checkNotNullParameter(jobManagerVersion, "jobManagerVersion");
        Intrinsics.checkNotNullParameter(folderId, "folderId");
        this.jobType = jobType;
        this.itemId = itemId;
        this.failed = z;
        this.isRecoverable = bool;
        this.failReason = str;
        this.numberOfAutomaticRetries = i;
        this.numberOfManualRetries = i2;
        this.sizeKB = d;
        this.sizeBucket = str2;
        this.jobManagerVersion = jobManagerVersion;
        this.initiatedAt = l;
        this.runningDuration = l2;
        this.totalTime = l3;
        this.bytesProcessed = l4;
        this.folderId = folderId;
        this.isUserTriggeredJob = z2;
        this.isNewVersionUpload = z3;
        this.device = deviceMetric;
        this.user = userMetric;
    }

    public /* synthetic */ JobUploadEvent(String str, ItemId itemId, boolean z, Boolean bool, String str2, int i, int i2, Double d, String str3, JobManagerVersion jobManagerVersion, Long l, Long l2, Long l3, Long l4, String str4, boolean z2, boolean z3, DeviceMetric deviceMetric, UserMetric userMetric, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, itemId, z, bool, str2, i, i2, d, str3, jobManagerVersion, (i3 & 1024) != 0 ? null : l, (i3 & 2048) != 0 ? null : l2, (i3 & 4096) != 0 ? null : l3, (i3 & 8192) != 0 ? null : l4, str4, (32768 & i3) != 0 ? true : z2, (65536 & i3) != 0 ? false : z3, (131072 & i3) != 0 ? null : deviceMetric, (i3 & 262144) != 0 ? null : userMetric);
    }

    public final String getJobType() {
        return this.jobType;
    }

    public final ItemId getItemId() {
        return this.itemId;
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

    public final JobManagerVersion getJobManagerVersion() {
        return this.jobManagerVersion;
    }

    public final Long getInitiatedAt() {
        return this.initiatedAt;
    }

    public final Long getRunningDuration() {
        return this.runningDuration;
    }

    public final Long getTotalTime() {
        return this.totalTime;
    }

    public final Long getBytesProcessed() {
        return this.bytesProcessed;
    }

    public final String getFolderId() {
        return this.folderId;
    }

    public final boolean isUserTriggeredJob() {
        return this.isUserTriggeredJob;
    }

    public final boolean isNewVersionUpload() {
        return this.isNewVersionUpload;
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
