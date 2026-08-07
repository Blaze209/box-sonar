package sdk.pendo.io.h7;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0019\u0012\b\b\u0002\u0010#\u001a\u00020\u001d\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010.\u001a\u00020$\u0012\u0006\u00100\u001a\u00020\u001d¢\u0006\u0004\b@\u0010AJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0006\u0010\b\u001a\u00020\u0007R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\tR\u001a\u0010\u0010\u001a\u00020\u00078\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u00078\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0015\u001a\u00020\u00078\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0014\u0010\u000fR\u001a\u0010\u0018\u001a\u00020\u00078\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0017\u0010\u000fR\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010#\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u000b\u0010 \"\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0017\u0010.\u001a\u00020$8\u0006¢\u0006\f\n\u0004\b,\u0010&\u001a\u0004\b\u0006\u0010-R\u0017\u00100\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b/\u0010\u001f\u001a\u0004\b\u0011\u0010 R\u0014\u00102\u001a\u00020\u00078\u0002X\u0082D¢\u0006\u0006\n\u0004\b1\u0010\tR\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\"\u00108\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010*\u001a\u0004\b8\u00109\"\u0004\b\u000b\u0010:R\"\u0010<\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010*\u001a\u0004\b<\u00109\"\u0004\b\u0006\u0010:R\u0016\u0010>\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u00105R\u0011\u0010?\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b\r\u0010 ¨\u0006B"}, d2 = {"Lsdk/pendo/io/h7/n;", "", "", "Lsdk/pendo/io/h7/q;", "data", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "e", "Ljava/lang/String;", "visitorId", "b", "accountId", "c", "getRecordingId$pendoIO_release", "()Ljava/lang/String;", "recordingId", "d", "getRecordingSessionId$pendoIO_release", "recordingSessionId", "getUrl$pendoIO_release", "url", "f", "getTabId$pendoIO_release", "tabId", "Lsdk/pendo/io/h7/o;", "g", "Lsdk/pendo/io/h7/o;", "recordingPayload", "", CmcdData.STREAMING_FORMAT_HLS, "I", "()I", "setRecordingPayloadCount", "(I)V", "recordingPayloadCount", "", "i", "J", "browserTime", "", "j", "Z", "keyFrame", "k", "()J", "lastKeyFrame", CmcdData.STREAM_TYPE_LIVE, "sequence", CmcdData.OBJECT_TYPE_MANIFEST, "type", "Lorg/json/JSONArray;", "n", "Lorg/json/JSONArray;", "recordingPayloadMetadata", "o", "isOfflineMode", "()Z", "(Z)V", "p", "isOfflineLimitReached", "q", "recordingPayloadJsonArray", "recordingSize", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lsdk/pendo/io/h7/o;IJZJI)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class n {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final String visitorId;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String accountId;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final String recordingId;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final String recordingSessionId;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final String url;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final String tabId;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final o recordingPayload;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private int recordingPayloadCount;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    private final long browserTime;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    private final boolean keyFrame;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    private final long lastKeyFrame;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    private final int sequence;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    private final String type;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    private final JSONArray recordingPayloadMetadata;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    private boolean isOfflineMode;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    private boolean isOfflineLimitReached;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    private JSONArray recordingPayloadJsonArray;

    public n(String visitorId, String accountId, String recordingId, String recordingSessionId, String url, String tabId, o recordingPayload, int i, long j, boolean z, long j2, int i2) {
        Intrinsics.checkNotNullParameter(visitorId, "visitorId");
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        Intrinsics.checkNotNullParameter(recordingId, "recordingId");
        Intrinsics.checkNotNullParameter(recordingSessionId, "recordingSessionId");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(tabId, "tabId");
        Intrinsics.checkNotNullParameter(recordingPayload, "recordingPayload");
        this.visitorId = visitorId;
        this.accountId = accountId;
        this.recordingId = recordingId;
        this.recordingSessionId = recordingSessionId;
        this.url = url;
        this.tabId = tabId;
        this.recordingPayload = recordingPayload;
        this.recordingPayloadCount = i;
        this.browserTime = j;
        this.keyFrame = z;
        this.lastKeyFrame = j2;
        this.sequence = i2;
        this.type = "recording";
        this.recordingPayloadMetadata = recordingPayload.c();
        this.recordingPayloadJsonArray = new JSONArray();
    }

    public final void a(List<? extends q> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.recordingPayloadCount += data.size();
        this.recordingPayload.a(data);
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final int getRecordingPayloadCount() {
        return this.recordingPayloadCount;
    }

    public final int c() {
        return this.recordingPayloadJsonArray.toString().length();
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final int getSequence() {
        return this.sequence;
    }

    public final String e() throws JSONException {
        this.recordingPayloadJsonArray = this.recordingPayload.b();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", this.type);
        jSONObject.put("visitorId", this.visitorId);
        jSONObject.put("accountId", this.accountId);
        jSONObject.put("keyFrame", this.keyFrame);
        jSONObject.put("lastKeyFrame", this.lastKeyFrame);
        jSONObject.put("recordingId", this.recordingId);
        jSONObject.put("recordingSessionId", this.recordingSessionId);
        jSONObject.put("url", this.url);
        jSONObject.put("tabId", this.tabId);
        jSONObject.put("recordingPayload", this.recordingPayloadJsonArray);
        jSONObject.put("sequence", this.sequence);
        jSONObject.put("recordingPayloadCount", this.recordingPayloadCount);
        jSONObject.put("browserTime", this.browserTime);
        jSONObject.put("recordingPayloadMetadata", this.recordingPayloadMetadata);
        jSONObject.put("recordingSize", c());
        jSONObject.put("isOfflineMode", this.isOfflineMode);
        jSONObject.put("isOfflineLimitReached", this.isOfflineLimitReached);
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ n(String str, String str2, String str3, String str4, String str5, String str6, o oVar, int i, long j, boolean z, long j2, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        o oVar2 = (i3 & 64) != 0 ? new o(CollectionsKt.emptyList()) : oVar;
        this(str, str2, str3, str4, str5, str6, oVar2, (i3 & 128) != 0 ? oVar2.a() : i, j, z, j2, i2);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final long getLastKeyFrame() {
        return this.lastKeyFrame;
    }

    public final void b(boolean z) {
        this.isOfflineMode = z;
    }

    public final void a(boolean z) {
        this.isOfflineLimitReached = z;
    }
}
