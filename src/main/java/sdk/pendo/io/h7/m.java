package sdk.pendo.io.h7;

import androidx.media3.exoplayer.upstream.CmcdData;
import external.sdk.pendo.io.gson.Gson;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0080\b\u0018\u00002\u00020\u0001J\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002J\t\u0010\u0005\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\u000f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0014\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u001a\u0010\u001a\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013R\u001a\u0010\u001f\u001a\u00020\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001eR\u001a\u0010\"\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u0011\u001a\u0004\b!\u0010\u0013R\u001a\u0010$\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0011\u001a\u0004\b#\u0010\u0013R\u001a\u0010%\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0011\u001a\u0004\b \u0010\u0013R\u001a\u0010'\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b&\u0010\u0013R \u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030(8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b\u000b\u0010+R\u0016\u00100\u001a\u0004\u0018\u00010-8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00103\u001a\u0004\u0018\u00010\u00108\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0011\u00105\u001a\u00020-8F¢\u0006\u0006\u001a\u0004\b\u0015\u00104R\u0011\u00106\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0013¨\u00067"}, d2 = {"Lsdk/pendo/io/h7/m;", "", "", "", "i", "toString", "", "hashCode", "other", "", "equals", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Z", "b", "()Z", "enable", "", "J", "getInactivityDuration", "()J", "inactivityDuration", "c", "getKeyframeEventFrequency", "keyframeEventFrequency", "d", "getKeyframeTimeFrequency", "keyframeTimeFrequency", "Lsdk/pendo/io/h7/l;", "e", "Lsdk/pendo/io/h7/l;", "()Lsdk/pendo/io/h7/l;", "privacyMode", "f", CmcdData.STREAMING_FORMAT_HLS, "recordingSizeLimit", "g", "recordingPayloadSendingFrequencyTimeMS", "recordingPayloadSendingFrequencyEvents", "getSessionReplayScanDebouncerDelay", "sessionReplayScanDebouncerDelay", "", "j", "Ljava/util/List;", "()Ljava/util/List;", "blockedSelectors", "Lsdk/pendo/io/h7/j;", "k", "Lsdk/pendo/io/h7/j;", "_networkTransportMode", CmcdData.STREAM_TYPE_LIVE, "Ljava/lang/Long;", "_offlineStorageLimit", "()Lsdk/pendo/io/h7/j;", "networkTransportMode", "offlineStorageLimit", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final /* data */ class m {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    @sdk.pendo.io.b0.c("enable")
    private final boolean enable;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @sdk.pendo.io.b0.c("inactivityDuration")
    private final long inactivityDuration;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @sdk.pendo.io.b0.c("keyframeEventFrequency")
    private final long keyframeEventFrequency;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @sdk.pendo.io.b0.c("keyframeTimeFrequency")
    private final long keyframeTimeFrequency;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @sdk.pendo.io.b0.c("privacyMode")
    private final l privacyMode;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @sdk.pendo.io.b0.c("recordingSizeLimit")
    private final long recordingSizeLimit;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @sdk.pendo.io.b0.c("recordingPayloadSendingFrequencyTime")
    private final long recordingPayloadSendingFrequencyTimeMS;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @sdk.pendo.io.b0.c("recordingPayloadSendingFrequencyEvents")
    private final long recordingPayloadSendingFrequencyEvents;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @sdk.pendo.io.b0.c("sessionReplayScanDebouncerDelay")
    private final long sessionReplayScanDebouncerDelay;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @sdk.pendo.io.b0.c("blockedSelectors")
    private final List<String> blockedSelectors;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @sdk.pendo.io.b0.c("networkTransportMode")
    private final j _networkTransportMode;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    @sdk.pendo.io.b0.c("offlineStorageLimit")
    private final Long _offlineStorageLimit;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"sdk/pendo/io/h7/m$a", "Lsdk/pendo/io/g0/a;", "", "", "", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final class a extends sdk.pendo.io.g0.a<Map<String, ? extends Object>> {
        a() {
        }
    }

    public final List<String> a() {
        return this.blockedSelectors;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    public final j c() {
        j jVar = this._networkTransportMode;
        return jVar == null ? j.WIFI_AND_CELLULAR : jVar;
    }

    public final long d() {
        Long l = this._offlineStorageLimit;
        if (l != null) {
            return l.longValue();
        }
        return 262144000L;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final l getPrivacyMode() {
        return this.privacyMode;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof m)) {
            return false;
        }
        m mVar = (m) other;
        return this.enable == mVar.enable && this.inactivityDuration == mVar.inactivityDuration && this.keyframeEventFrequency == mVar.keyframeEventFrequency && this.keyframeTimeFrequency == mVar.keyframeTimeFrequency && this.privacyMode == mVar.privacyMode && this.recordingSizeLimit == mVar.recordingSizeLimit && this.recordingPayloadSendingFrequencyTimeMS == mVar.recordingPayloadSendingFrequencyTimeMS && this.recordingPayloadSendingFrequencyEvents == mVar.recordingPayloadSendingFrequencyEvents && this.sessionReplayScanDebouncerDelay == mVar.sessionReplayScanDebouncerDelay && Intrinsics.areEqual(this.blockedSelectors, mVar.blockedSelectors) && this._networkTransportMode == mVar._networkTransportMode && Intrinsics.areEqual(this._offlineStorageLimit, mVar._offlineStorageLimit);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final long getRecordingPayloadSendingFrequencyEvents() {
        return this.recordingPayloadSendingFrequencyEvents;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final long getRecordingPayloadSendingFrequencyTimeMS() {
        return this.recordingPayloadSendingFrequencyTimeMS;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final long getRecordingSizeLimit() {
        return this.recordingSizeLimit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    public int hashCode() {
        boolean z = this.enable;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int iHashCode = ((((((((((((((((((r0 * 31) + Long.hashCode(this.inactivityDuration)) * 31) + Long.hashCode(this.keyframeEventFrequency)) * 31) + Long.hashCode(this.keyframeTimeFrequency)) * 31) + this.privacyMode.hashCode()) * 31) + Long.hashCode(this.recordingSizeLimit)) * 31) + Long.hashCode(this.recordingPayloadSendingFrequencyTimeMS)) * 31) + Long.hashCode(this.recordingPayloadSendingFrequencyEvents)) * 31) + Long.hashCode(this.sessionReplayScanDebouncerDelay)) * 31) + this.blockedSelectors.hashCode()) * 31;
        j jVar = this._networkTransportMode;
        int iHashCode2 = (iHashCode + (jVar == null ? 0 : jVar.hashCode())) * 31;
        Long l = this._offlineStorageLimit;
        return iHashCode2 + (l != null ? l.hashCode() : 0);
    }

    public final Map<String, Object> i() {
        Gson gson = new Gson();
        Object objA = gson.a(gson.a(this), new a().b());
        Intrinsics.checkNotNullExpressionValue(objA, "fromJson(...)");
        return (Map) objA;
    }

    public String toString() {
        return "RecordingConfigurations(enable=" + this.enable + ", inactivityDuration=" + this.inactivityDuration + ", keyframeEventFrequency=" + this.keyframeEventFrequency + ", keyframeTimeFrequency=" + this.keyframeTimeFrequency + ", privacyMode=" + this.privacyMode + ", recordingSizeLimit=" + this.recordingSizeLimit + ", recordingPayloadSendingFrequencyTimeMS=" + this.recordingPayloadSendingFrequencyTimeMS + ", recordingPayloadSendingFrequencyEvents=" + this.recordingPayloadSendingFrequencyEvents + ", sessionReplayScanDebouncerDelay=" + this.sessionReplayScanDebouncerDelay + ", blockedSelectors=" + this.blockedSelectors + ", _networkTransportMode=" + this._networkTransportMode + ", _offlineStorageLimit=" + this._offlineStorageLimit + ")";
    }
}
