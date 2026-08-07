package sdk.pendo.io.h7;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000b¨\u0006\u0015"}, d2 = {"Lsdk/pendo/io/h7/h;", "Lsdk/pendo/io/h7/u;", "Lorg/json/JSONObject;", "b", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "", "c", "I", "type", "", "d", "F", "x", "e", "y", "", "timestamp", "", "retroactiveScreenId", "<init>", "(JLjava/lang/String;IFF)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class h extends u {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final int type;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final float x;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final float y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(long j, String retroactiveScreenId, int i, float f, float f2) {
        super(j, retroactiveScreenId);
        Intrinsics.checkNotNullParameter(retroactiveScreenId, "retroactiveScreenId");
        this.type = i;
        this.x = f;
        this.y = f2;
    }

    @Override // sdk.pendo.io.h7.q
    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("source", w.MOUSE_INTERACTION.getValue());
        jSONObject2.put("id", 100);
        jSONObject2.put("pointerType", v.TOUCH.getValue());
        jSONObject2.put("type", this.type);
        jSONObject2.put("x", Float.valueOf(this.x));
        jSONObject2.put("y", Float.valueOf(this.y));
        jSONObject.put("data", jSONObject2);
        jSONObject.put("timestamp", getTimestamp());
        jSONObject.put("type", x.INCREMENTAL_SNAPSHOT.getValue());
        return jSONObject;
    }

    @Override // sdk.pendo.io.h7.q
    public JSONObject b() {
        return a();
    }
}
