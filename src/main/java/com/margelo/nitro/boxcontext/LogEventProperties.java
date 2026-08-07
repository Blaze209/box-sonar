package com.margelo.nitro.boxcontext;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.microsoft.identity.common.java.AuthenticationConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LogEventProperties.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b+\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 42\u00020\u0001:\u00014B\u0087\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J£\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013¨\u00065"}, d2 = {"Lcom/margelo/nitro/boxcontext/LogEventProperties;", "", "module_id", "", "status", AuthenticationConstants.OAuth2.ERROR_CODE, "error_message", "source", "app_mode", "data", "session_id", "agent_id", "turn_id", "trace_id", "agent_release_state", "duration", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getModule_id", "()Ljava/lang/String;", "getStatus", "getError_code", "getError_message", "getSource", "getApp_mode", "getData", "getSession_id", "getAgent_id", "getTurn_id", "getTrace_id", "getAgent_release_state", "getDuration", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "Companion", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class LogEventProperties {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String agent_id;
    private final String agent_release_state;
    private final String app_mode;
    private final String data;
    private final String duration;
    private final String error_code;
    private final String error_message;
    private final String module_id;
    private final String session_id;
    private final String source;
    private final String status;
    private final String trace_id;
    private final String turn_id;

    public static /* synthetic */ LogEventProperties copy$default(LogEventProperties logEventProperties, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i, Object obj) {
        if ((i & 1) != 0) {
            str = logEventProperties.module_id;
        }
        return logEventProperties.copy(str, (i & 2) != 0 ? logEventProperties.status : str2, (i & 4) != 0 ? logEventProperties.error_code : str3, (i & 8) != 0 ? logEventProperties.error_message : str4, (i & 16) != 0 ? logEventProperties.source : str5, (i & 32) != 0 ? logEventProperties.app_mode : str6, (i & 64) != 0 ? logEventProperties.data : str7, (i & 128) != 0 ? logEventProperties.session_id : str8, (i & 256) != 0 ? logEventProperties.agent_id : str9, (i & 512) != 0 ? logEventProperties.turn_id : str10, (i & 1024) != 0 ? logEventProperties.trace_id : str11, (i & 2048) != 0 ? logEventProperties.agent_release_state : str12, (i & 4096) != 0 ? logEventProperties.duration : str13);
    }

    @JvmStatic
    private static final LogEventProperties fromCpp(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        return INSTANCE.fromCpp(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getModule_id() {
        return this.module_id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getTurn_id() {
        return this.turn_id;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getTrace_id() {
        return this.trace_id;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getAgent_release_state() {
        return this.agent_release_state;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getError_code() {
        return this.error_code;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getError_message() {
        return this.error_message;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSource() {
        return this.source;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getApp_mode() {
        return this.app_mode;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getData() {
        return this.data;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getSession_id() {
        return this.session_id;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getAgent_id() {
        return this.agent_id;
    }

    public final LogEventProperties copy(String module_id, String status, String error_code, String error_message, String source, String app_mode, String data, String session_id, String agent_id, String turn_id, String trace_id, String agent_release_state, String duration) {
        Intrinsics.checkNotNullParameter(module_id, "module_id");
        return new LogEventProperties(module_id, status, error_code, error_message, source, app_mode, data, session_id, agent_id, turn_id, trace_id, agent_release_state, duration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LogEventProperties)) {
            return false;
        }
        LogEventProperties logEventProperties = (LogEventProperties) other;
        return Intrinsics.areEqual(this.module_id, logEventProperties.module_id) && Intrinsics.areEqual(this.status, logEventProperties.status) && Intrinsics.areEqual(this.error_code, logEventProperties.error_code) && Intrinsics.areEqual(this.error_message, logEventProperties.error_message) && Intrinsics.areEqual(this.source, logEventProperties.source) && Intrinsics.areEqual(this.app_mode, logEventProperties.app_mode) && Intrinsics.areEqual(this.data, logEventProperties.data) && Intrinsics.areEqual(this.session_id, logEventProperties.session_id) && Intrinsics.areEqual(this.agent_id, logEventProperties.agent_id) && Intrinsics.areEqual(this.turn_id, logEventProperties.turn_id) && Intrinsics.areEqual(this.trace_id, logEventProperties.trace_id) && Intrinsics.areEqual(this.agent_release_state, logEventProperties.agent_release_state) && Intrinsics.areEqual(this.duration, logEventProperties.duration);
    }

    public int hashCode() {
        int iHashCode = this.module_id.hashCode() * 31;
        String str = this.status;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.error_code;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.error_message;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.source;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.app_mode;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.data;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.session_id;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.agent_id;
        int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.turn_id;
        int iHashCode10 = (iHashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.trace_id;
        int iHashCode11 = (iHashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.agent_release_state;
        int iHashCode12 = (iHashCode11 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.duration;
        return iHashCode12 + (str12 != null ? str12.hashCode() : 0);
    }

    public String toString() {
        return "LogEventProperties(module_id=" + this.module_id + ", status=" + this.status + ", error_code=" + this.error_code + ", error_message=" + this.error_message + ", source=" + this.source + ", app_mode=" + this.app_mode + ", data=" + this.data + ", session_id=" + this.session_id + ", agent_id=" + this.agent_id + ", turn_id=" + this.turn_id + ", trace_id=" + this.trace_id + ", agent_release_state=" + this.agent_release_state + ", duration=" + this.duration + ")";
    }

    public LogEventProperties(String module_id, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        Intrinsics.checkNotNullParameter(module_id, "module_id");
        this.module_id = module_id;
        this.status = str;
        this.error_code = str2;
        this.error_message = str3;
        this.source = str4;
        this.app_mode = str5;
        this.data = str6;
        this.session_id = str7;
        this.agent_id = str8;
        this.turn_id = str9;
        this.trace_id = str10;
        this.agent_release_state = str11;
        this.duration = str12;
    }

    public final String getModule_id() {
        return this.module_id;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getError_code() {
        return this.error_code;
    }

    public final String getError_message() {
        return this.error_message;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getApp_mode() {
        return this.app_mode;
    }

    public final String getData() {
        return this.data;
    }

    public final String getSession_id() {
        return this.session_id;
    }

    public final String getAgent_id() {
        return this.agent_id;
    }

    public final String getTurn_id() {
        return this.turn_id;
    }

    public final String getTrace_id() {
        return this.trace_id;
    }

    public final String getAgent_release_state() {
        return this.agent_release_state;
    }

    public final String getDuration() {
        return this.duration;
    }

    /* JADX INFO: compiled from: LogEventProperties.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0088\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0003¨\u0006\u0014"}, d2 = {"Lcom/margelo/nitro/boxcontext/LogEventProperties$Companion;", "", "<init>", "()V", "fromCpp", "Lcom/margelo/nitro/boxcontext/LogEventProperties;", "module_id", "", "status", AuthenticationConstants.OAuth2.ERROR_CODE, "error_message", "source", "app_mode", "data", "session_id", "agent_id", "turn_id", "trace_id", "agent_release_state", "duration", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final LogEventProperties fromCpp(String module_id, String status, String error_code, String error_message, String source, String app_mode, String data, String session_id, String agent_id, String turn_id, String trace_id, String agent_release_state, String duration) {
            return new LogEventProperties(module_id, status, error_code, error_message, source, app_mode, data, session_id, agent_id, turn_id, trace_id, agent_release_state, duration);
        }
    }
}
