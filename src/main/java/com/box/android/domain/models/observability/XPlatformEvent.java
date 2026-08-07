package com.box.android.domain.models.observability;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainModel;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Gen204EventModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B³\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\t\u00102\u001a\u00020\u0004HÆ\u0003J\t\u00103\u001a\u00020\u0004HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010(J\u000b\u0010@\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0016HÆ\u0003JÊ\u0001\u0010B\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÆ\u0001¢\u0006\u0002\u0010CJ\u0013\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010GHÖ\u0003J\t\u0010H\u001a\u00020IHÖ\u0001J\t\u0010J\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u0006K"}, d2 = {"Lcom/box/android/domain/models/observability/XPlatformEvent;", "Lcom/box/android/domain/models/observability/Gen204Event;", "Lcom/box/android/domain/models/DomainModel;", "name", "", "moduleId", "status", "errorCode", "errorMessage", "source", "appMode", "data", "sessionId", "agentId", "turnId", "traceId", "agentReleaseState", "duration", "", SemanticAttributes.EventDomainValues.DEVICE, "Lcom/box/android/domain/models/observability/DeviceMetric;", "user", "Lcom/box/android/domain/models/observability/UserMetric;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/box/android/domain/models/observability/DeviceMetric;Lcom/box/android/domain/models/observability/UserMetric;)V", "getName", "()Ljava/lang/String;", "getModuleId", "getStatus", "getErrorCode", "getErrorMessage", "getSource", "getAppMode", "getData", "getSessionId", "getAgentId", "getTurnId", "getTraceId", "getAgentReleaseState", "getDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDevice", "()Lcom/box/android/domain/models/observability/DeviceMetric;", "setDevice", "(Lcom/box/android/domain/models/observability/DeviceMetric;)V", "getUser", "()Lcom/box/android/domain/models/observability/UserMetric;", "setUser", "(Lcom/box/android/domain/models/observability/UserMetric;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/box/android/domain/models/observability/DeviceMetric;Lcom/box/android/domain/models/observability/UserMetric;)Lcom/box/android/domain/models/observability/XPlatformEvent;", "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class XPlatformEvent extends Gen204Event implements DomainModel {
    private final String agentId;
    private final String agentReleaseState;
    private final String appMode;
    private final String data;
    private DeviceMetric device;
    private final Long duration;
    private final String errorCode;
    private final String errorMessage;
    private final String moduleId;
    private final String name;
    private final String sessionId;
    private final String source;
    private final String status;
    private final String traceId;
    private final String turnId;
    private UserMetric user;

    public static /* synthetic */ XPlatformEvent copy$default(XPlatformEvent xPlatformEvent, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, Long l, DeviceMetric deviceMetric, UserMetric userMetric, int i, Object obj) {
        String str14 = (i & 1) != 0 ? xPlatformEvent.name : str;
        return xPlatformEvent.copy(str14, (i & 2) != 0 ? xPlatformEvent.moduleId : str2, (i & 4) != 0 ? xPlatformEvent.status : str3, (i & 8) != 0 ? xPlatformEvent.errorCode : str4, (i & 16) != 0 ? xPlatformEvent.errorMessage : str5, (i & 32) != 0 ? xPlatformEvent.source : str6, (i & 64) != 0 ? xPlatformEvent.appMode : str7, (i & 128) != 0 ? xPlatformEvent.data : str8, (i & 256) != 0 ? xPlatformEvent.sessionId : str9, (i & 512) != 0 ? xPlatformEvent.agentId : str10, (i & 1024) != 0 ? xPlatformEvent.turnId : str11, (i & 2048) != 0 ? xPlatformEvent.traceId : str12, (i & 4096) != 0 ? xPlatformEvent.agentReleaseState : str13, (i & 8192) != 0 ? xPlatformEvent.duration : l, (i & 16384) != 0 ? xPlatformEvent.device : deviceMetric, (i & 32768) != 0 ? xPlatformEvent.user : userMetric);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getAgentId() {
        return this.agentId;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getTurnId() {
        return this.turnId;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getAgentReleaseState() {
        return this.agentReleaseState;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final Long getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final DeviceMetric getDevice() {
        return this.device;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final UserMetric getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getModuleId() {
        return this.moduleId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getErrorCode() {
        return this.errorCode;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSource() {
        return this.source;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getAppMode() {
        return this.appMode;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getData() {
        return this.data;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    public final XPlatformEvent copy(String name, String moduleId, String status, String errorCode, String errorMessage, String source, String appMode, String data, String sessionId, String agentId, String turnId, String traceId, String agentReleaseState, Long duration, DeviceMetric device, UserMetric user) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(moduleId, "moduleId");
        return new XPlatformEvent(name, moduleId, status, errorCode, errorMessage, source, appMode, data, sessionId, agentId, turnId, traceId, agentReleaseState, duration, device, user);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof XPlatformEvent)) {
            return false;
        }
        XPlatformEvent xPlatformEvent = (XPlatformEvent) other;
        return Intrinsics.areEqual(this.name, xPlatformEvent.name) && Intrinsics.areEqual(this.moduleId, xPlatformEvent.moduleId) && Intrinsics.areEqual(this.status, xPlatformEvent.status) && Intrinsics.areEqual(this.errorCode, xPlatformEvent.errorCode) && Intrinsics.areEqual(this.errorMessage, xPlatformEvent.errorMessage) && Intrinsics.areEqual(this.source, xPlatformEvent.source) && Intrinsics.areEqual(this.appMode, xPlatformEvent.appMode) && Intrinsics.areEqual(this.data, xPlatformEvent.data) && Intrinsics.areEqual(this.sessionId, xPlatformEvent.sessionId) && Intrinsics.areEqual(this.agentId, xPlatformEvent.agentId) && Intrinsics.areEqual(this.turnId, xPlatformEvent.turnId) && Intrinsics.areEqual(this.traceId, xPlatformEvent.traceId) && Intrinsics.areEqual(this.agentReleaseState, xPlatformEvent.agentReleaseState) && Intrinsics.areEqual(this.duration, xPlatformEvent.duration) && Intrinsics.areEqual(this.device, xPlatformEvent.device) && Intrinsics.areEqual(this.user, xPlatformEvent.user);
    }

    public int hashCode() {
        int iHashCode = ((this.name.hashCode() * 31) + this.moduleId.hashCode()) * 31;
        String str = this.status;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.errorCode;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.errorMessage;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.source;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.appMode;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.data;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.sessionId;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.agentId;
        int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.turnId;
        int iHashCode10 = (iHashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.traceId;
        int iHashCode11 = (iHashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.agentReleaseState;
        int iHashCode12 = (iHashCode11 + (str11 == null ? 0 : str11.hashCode())) * 31;
        Long l = this.duration;
        int iHashCode13 = (iHashCode12 + (l == null ? 0 : l.hashCode())) * 31;
        DeviceMetric deviceMetric = this.device;
        int iHashCode14 = (iHashCode13 + (deviceMetric == null ? 0 : deviceMetric.hashCode())) * 31;
        UserMetric userMetric = this.user;
        return iHashCode14 + (userMetric != null ? userMetric.hashCode() : 0);
    }

    public String toString() {
        return "XPlatformEvent(name=" + this.name + ", moduleId=" + this.moduleId + ", status=" + this.status + ", errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ", source=" + this.source + ", appMode=" + this.appMode + ", data=" + this.data + ", sessionId=" + this.sessionId + ", agentId=" + this.agentId + ", turnId=" + this.turnId + ", traceId=" + this.traceId + ", agentReleaseState=" + this.agentReleaseState + ", duration=" + this.duration + ", device=" + this.device + ", user=" + this.user + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XPlatformEvent(String name, String moduleId, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Long l, DeviceMetric deviceMetric, UserMetric userMetric) {
        super(0L, null, null, 7, null);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(moduleId, "moduleId");
        this.name = name;
        this.moduleId = moduleId;
        this.status = str;
        this.errorCode = str2;
        this.errorMessage = str3;
        this.source = str4;
        this.appMode = str5;
        this.data = str6;
        this.sessionId = str7;
        this.agentId = str8;
        this.turnId = str9;
        this.traceId = str10;
        this.agentReleaseState = str11;
        this.duration = l;
        this.device = deviceMetric;
        this.user = userMetric;
    }

    public /* synthetic */ XPlatformEvent(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, Long l, DeviceMetric deviceMetric, UserMetric userMetric, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, str7, str8, (i & 256) != 0 ? null : str9, (i & 512) != 0 ? null : str10, (i & 1024) != 0 ? null : str11, (i & 2048) != 0 ? null : str12, (i & 4096) != 0 ? null : str13, (i & 8192) != 0 ? null : l, (i & 16384) != 0 ? null : deviceMetric, (i & 32768) != 0 ? null : userMetric);
    }

    public final String getName() {
        return this.name;
    }

    public final String getModuleId() {
        return this.moduleId;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getAppMode() {
        return this.appMode;
    }

    public final String getData() {
        return this.data;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getAgentId() {
        return this.agentId;
    }

    public final String getTurnId() {
        return this.turnId;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public final String getAgentReleaseState() {
        return this.agentReleaseState;
    }

    public final Long getDuration() {
        return this.duration;
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
