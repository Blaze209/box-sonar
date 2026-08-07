package com.box.android.domain.models.observability;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.domain.models.preview.PreviewerType;
import com.box.androidsdk.content.models.BoxFile;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Gen204EventModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u009f\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010@\u001a\u00020\u0004HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010B\u001a\u00020\u0004HÆ\u0003J\t\u0010C\u001a\u00020\tHÆ\u0003J\t\u0010D\u001a\u00020\u000bHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010)J\u000b\u0010G\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010-J\u000b\u0010I\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010J\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u00101J\u0010\u0010K\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u00104J\u000f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00040\u0017HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u001bHÆ\u0003J¾\u0001\u0010O\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÆ\u0001¢\u0006\u0002\u0010PJ\u0013\u0010Q\u001a\u00020\t2\b\u0010R\u001a\u0004\u0018\u00010SHÖ\u0003J\t\u0010T\u001a\u00020\u000eHÖ\u0001J\t\u0010U\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001fR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010.\u001a\u0004\b,\u0010-R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001fR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u00102\u001a\u0004\b0\u00101R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u00105\u001a\u0004\b3\u00104R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0017¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006V"}, d2 = {"Lcom/box/android/domain/models/observability/PreviewPM23Event;", "Lcom/box/android/domain/models/observability/Gen204Event;", "Lcom/box/android/domain/models/DomainModel;", "fileId", "", "previewerType", "Lcom/box/android/domain/models/preview/PreviewerType;", BoxFile.FIELD_EXTENSION, TelemetryEventStrings.Value.FAILED, "", "previewSource", "Lcom/box/android/domain/models/preview/PreviewSource;", "failReason", "errorCode", "", "errorMessage", "sizeKB", "", "sizeBucket", "loadedFromCache", "ttiMs", "", "itemState", "", SemanticAttributes.EventDomainValues.DEVICE, "Lcom/box/android/domain/models/observability/DeviceMetric;", "user", "Lcom/box/android/domain/models/observability/UserMetric;", "<init>", "(Ljava/lang/String;Lcom/box/android/domain/models/preview/PreviewerType;Ljava/lang/String;ZLcom/box/android/domain/models/preview/PreviewSource;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/util/List;Lcom/box/android/domain/models/observability/DeviceMetric;Lcom/box/android/domain/models/observability/UserMetric;)V", "getFileId", "()Ljava/lang/String;", "getPreviewerType", "()Lcom/box/android/domain/models/preview/PreviewerType;", "getExtension", "getFailed", "()Z", "getPreviewSource", "()Lcom/box/android/domain/models/preview/PreviewSource;", "getFailReason", "getErrorCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getErrorMessage", "getSizeKB", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getSizeBucket", "getLoadedFromCache", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTtiMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getItemState", "()Ljava/util/List;", "getDevice", "()Lcom/box/android/domain/models/observability/DeviceMetric;", "setDevice", "(Lcom/box/android/domain/models/observability/DeviceMetric;)V", "getUser", "()Lcom/box/android/domain/models/observability/UserMetric;", "setUser", "(Lcom/box/android/domain/models/observability/UserMetric;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Lcom/box/android/domain/models/preview/PreviewerType;Ljava/lang/String;ZLcom/box/android/domain/models/preview/PreviewSource;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/util/List;Lcom/box/android/domain/models/observability/DeviceMetric;Lcom/box/android/domain/models/observability/UserMetric;)Lcom/box/android/domain/models/observability/PreviewPM23Event;", "equals", "other", "", "hashCode", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PreviewPM23Event extends Gen204Event implements DomainModel {
    private DeviceMetric device;
    private final Integer errorCode;
    private final String errorMessage;
    private final String extension;
    private final String failReason;
    private final boolean failed;
    private final String fileId;
    private final List<String> itemState;
    private final Boolean loadedFromCache;
    private final PreviewSource previewSource;
    private final PreviewerType previewerType;
    private final String sizeBucket;
    private final Double sizeKB;
    private final Long ttiMs;
    private UserMetric user;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFileId() {
        return this.fileId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getSizeBucket() {
        return this.sizeBucket;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Boolean getLoadedFromCache() {
        return this.loadedFromCache;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Long getTtiMs() {
        return this.ttiMs;
    }

    public final List<String> component13() {
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
    public final PreviewerType getPreviewerType() {
        return this.previewerType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getExtension() {
        return this.extension;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getFailed() {
        return this.failed;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final PreviewSource getPreviewSource() {
        return this.previewSource;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getFailReason() {
        return this.failReason;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getErrorCode() {
        return this.errorCode;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Double getSizeKB() {
        return this.sizeKB;
    }

    public final PreviewPM23Event copy(String fileId, PreviewerType previewerType, String extension, boolean failed, PreviewSource previewSource, String failReason, Integer errorCode, String errorMessage, Double sizeKB, String sizeBucket, Boolean loadedFromCache, Long ttiMs, List<String> itemState, DeviceMetric device, UserMetric user) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(extension, "extension");
        Intrinsics.checkNotNullParameter(previewSource, "previewSource");
        Intrinsics.checkNotNullParameter(itemState, "itemState");
        return new PreviewPM23Event(fileId, previewerType, extension, failed, previewSource, failReason, errorCode, errorMessage, sizeKB, sizeBucket, loadedFromCache, ttiMs, itemState, device, user);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreviewPM23Event)) {
            return false;
        }
        PreviewPM23Event previewPM23Event = (PreviewPM23Event) other;
        return Intrinsics.areEqual(this.fileId, previewPM23Event.fileId) && this.previewerType == previewPM23Event.previewerType && Intrinsics.areEqual(this.extension, previewPM23Event.extension) && this.failed == previewPM23Event.failed && Intrinsics.areEqual(this.previewSource, previewPM23Event.previewSource) && Intrinsics.areEqual(this.failReason, previewPM23Event.failReason) && Intrinsics.areEqual(this.errorCode, previewPM23Event.errorCode) && Intrinsics.areEqual(this.errorMessage, previewPM23Event.errorMessage) && Intrinsics.areEqual((Object) this.sizeKB, (Object) previewPM23Event.sizeKB) && Intrinsics.areEqual(this.sizeBucket, previewPM23Event.sizeBucket) && Intrinsics.areEqual(this.loadedFromCache, previewPM23Event.loadedFromCache) && Intrinsics.areEqual(this.ttiMs, previewPM23Event.ttiMs) && Intrinsics.areEqual(this.itemState, previewPM23Event.itemState) && Intrinsics.areEqual(this.device, previewPM23Event.device) && Intrinsics.areEqual(this.user, previewPM23Event.user);
    }

    public int hashCode() {
        int iHashCode = this.fileId.hashCode() * 31;
        PreviewerType previewerType = this.previewerType;
        int iHashCode2 = (((((((iHashCode + (previewerType == null ? 0 : previewerType.hashCode())) * 31) + this.extension.hashCode()) * 31) + Boolean.hashCode(this.failed)) * 31) + this.previewSource.hashCode()) * 31;
        String str = this.failReason;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.errorCode;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.errorMessage;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Double d = this.sizeKB;
        int iHashCode6 = (iHashCode5 + (d == null ? 0 : d.hashCode())) * 31;
        String str3 = this.sizeBucket;
        int iHashCode7 = (iHashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.loadedFromCache;
        int iHashCode8 = (iHashCode7 + (bool == null ? 0 : bool.hashCode())) * 31;
        Long l = this.ttiMs;
        int iHashCode9 = (((iHashCode8 + (l == null ? 0 : l.hashCode())) * 31) + this.itemState.hashCode()) * 31;
        DeviceMetric deviceMetric = this.device;
        int iHashCode10 = (iHashCode9 + (deviceMetric == null ? 0 : deviceMetric.hashCode())) * 31;
        UserMetric userMetric = this.user;
        return iHashCode10 + (userMetric != null ? userMetric.hashCode() : 0);
    }

    public String toString() {
        return "PreviewPM23Event(fileId=" + this.fileId + ", previewerType=" + this.previewerType + ", extension=" + this.extension + ", failed=" + this.failed + ", previewSource=" + this.previewSource + ", failReason=" + this.failReason + ", errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ", sizeKB=" + this.sizeKB + ", sizeBucket=" + this.sizeBucket + ", loadedFromCache=" + this.loadedFromCache + ", ttiMs=" + this.ttiMs + ", itemState=" + this.itemState + ", device=" + this.device + ", user=" + this.user + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewPM23Event(String fileId, PreviewerType previewerType, String extension, boolean z, PreviewSource previewSource, String str, Integer num, String str2, Double d, String str3, Boolean bool, Long l, List<String> itemState, DeviceMetric deviceMetric, UserMetric userMetric) {
        super(0L, null, null, 7, null);
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(extension, "extension");
        Intrinsics.checkNotNullParameter(previewSource, "previewSource");
        Intrinsics.checkNotNullParameter(itemState, "itemState");
        this.fileId = fileId;
        this.previewerType = previewerType;
        this.extension = extension;
        this.failed = z;
        this.previewSource = previewSource;
        this.failReason = str;
        this.errorCode = num;
        this.errorMessage = str2;
        this.sizeKB = d;
        this.sizeBucket = str3;
        this.loadedFromCache = bool;
        this.ttiMs = l;
        this.itemState = itemState;
        this.device = deviceMetric;
        this.user = userMetric;
    }

    public final String getFileId() {
        return this.fileId;
    }

    public final PreviewerType getPreviewerType() {
        return this.previewerType;
    }

    public final String getExtension() {
        return this.extension;
    }

    public final boolean getFailed() {
        return this.failed;
    }

    public final PreviewSource getPreviewSource() {
        return this.previewSource;
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

    public final Double getSizeKB() {
        return this.sizeKB;
    }

    public final String getSizeBucket() {
        return this.sizeBucket;
    }

    public final Boolean getLoadedFromCache() {
        return this.loadedFromCache;
    }

    public final Long getTtiMs() {
        return this.ttiMs;
    }

    public /* synthetic */ PreviewPM23Event(String str, PreviewerType previewerType, String str2, boolean z, PreviewSource previewSource, String str3, Integer num, String str4, Double d, String str5, Boolean bool, Long l, List list, DeviceMetric deviceMetric, UserMetric userMetric, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, previewerType, str2, z, previewSource, str3, num, str4, d, str5, bool, l, (i & 4096) != 0 ? CollectionsKt.emptyList() : list, (i & 8192) != 0 ? null : deviceMetric, (i & 16384) != 0 ? null : userMetric);
    }

    public final List<String> getItemState() {
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
