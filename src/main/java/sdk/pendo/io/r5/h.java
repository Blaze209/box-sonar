package sdk.pendo.io.r5;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.s7.u0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0005J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\n\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0005J\u0006\u0010\u0004\u001a\u00020\u000eR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000fR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lsdk/pendo/io/r5/h;", "", "Lsdk/pendo/io/r5/d;", "event", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "b", "", "deviceTime", "visitorId", "d", "accountId", "orientation", "c", "Lorg/json/JSONObject;", "Ljava/lang/String;", "Ljava/lang/Long;", "duration", "e", "f", "Lorg/json/JSONArray;", "g", "Lorg/json/JSONArray;", "activeTime", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class h {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private String event;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private Long deviceTime;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private String duration;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private String visitorId;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private String accountId;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private String orientation;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private JSONArray activeTime;

    public final JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String str = this.event;
        if (str != null) {
            jSONObject.put("event", str);
        }
        Long l = this.deviceTime;
        if (l != null) {
            jSONObject.put("device_time", l.longValue());
        }
        String str2 = this.visitorId;
        if (str2 != null) {
            jSONObject.put("visitorId", str2);
        }
        String str3 = this.accountId;
        if (str3 != null) {
            jSONObject.put("accountId", str3);
        }
        String str4 = this.orientation;
        if (str4 != null) {
            jSONObject.put("orientation", str4);
        }
        String str5 = this.duration;
        if (str5 != null) {
            jSONObject.put("duration", str5);
        }
        JSONArray jSONArray = this.activeTime;
        if (jSONArray != null) {
            jSONObject.put("activeTime", jSONArray);
        }
        jSONObject.put("sdkVersion", u0.a());
        return jSONObject;
    }

    public final h b(String event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.event = event;
        return this;
    }

    public final h c(String orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        this.orientation = orientation;
        return this;
    }

    public final h d(String visitorId) {
        this.visitorId = visitorId;
        return this;
    }

    public final h a(String accountId) {
        this.accountId = accountId;
        return this;
    }

    public final h a(long deviceTime) {
        this.deviceTime = Long.valueOf(deviceTime);
        return this;
    }

    public final h a(d event) {
        Intrinsics.checkNotNullParameter(event, "event");
        String strB = event.b();
        Intrinsics.checkNotNullExpressionValue(strB, "getValue(...)");
        return b(strB);
    }
}
