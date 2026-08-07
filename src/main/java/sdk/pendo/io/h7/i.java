package sdk.pendo.io.h7;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lsdk/pendo/io/h7/i;", "Lsdk/pendo/io/h7/u;", "Lorg/json/JSONObject;", "b", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/h7/p;", "c", "Lsdk/pendo/io/h7/p;", "displayData", "", "timestamp", "", "retroactiveScreenId", "<init>", "(JLjava/lang/String;Lsdk/pendo/io/h7/p;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class i extends u {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final p displayData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(long j, String retroactiveScreenId, p displayData) {
        super(j, retroactiveScreenId);
        Intrinsics.checkNotNullParameter(retroactiveScreenId, "retroactiveScreenId");
        Intrinsics.checkNotNullParameter(displayData, "displayData");
        this.displayData = displayData;
    }

    @Override // sdk.pendo.io.h7.q
    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("href", getRetroactiveScreenId());
        jSONObject2.put("width", this.displayData.getWidth());
        jSONObject2.put("height", this.displayData.getHeight());
        jSONObject.put("data", jSONObject2);
        jSONObject.put("timestamp", getTimestamp());
        jSONObject.put("type", x.META_DATA.getValue());
        return jSONObject;
    }

    @Override // sdk.pendo.io.h7.q
    public JSONObject b() {
        return a();
    }
}
