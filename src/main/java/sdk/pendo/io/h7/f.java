package sdk.pendo.io.h7;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005R\u0014\u0010\t\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lsdk/pendo/io/h7/f;", "Lsdk/pendo/io/h7/u;", "Lorg/json/JSONObject;", "b", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lorg/json/JSONArray;", "previousChildNodesJsonArray", "c", "Lorg/json/JSONArray;", "childNodes", "Lsdk/pendo/io/h7/p;", "d", "Lsdk/pendo/io/h7/p;", "e", "()Lsdk/pendo/io/h7/p;", "displayData", "", "timestamp", "", "retroactiveScreenId", "<init>", "(JLjava/lang/String;Lorg/json/JSONArray;Lsdk/pendo/io/h7/p;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class f extends u {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final JSONArray childNodes;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final p displayData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(long j, String retroactiveScreenId, JSONArray childNodes, p displayData) {
        super(j, retroactiveScreenId);
        Intrinsics.checkNotNullParameter(retroactiveScreenId, "retroactiveScreenId");
        Intrinsics.checkNotNullParameter(childNodes, "childNodes");
        Intrinsics.checkNotNullParameter(displayData, "displayData");
        this.childNodes = childNodes;
        this.displayData = displayData;
    }

    public final JSONArray a(JSONArray previousChildNodesJsonArray) throws JSONException {
        if (previousChildNodesJsonArray != null && this.childNodes.length() == previousChildNodesJsonArray.length()) {
            int length = this.childNodes.length();
            for (int i = 0; i < length; i++) {
                if (Intrinsics.areEqual(this.childNodes.getJSONObject(i).toString(), previousChildNodesJsonArray.getJSONObject(i).toString())) {
                }
            }
            return null;
        }
        return this.childNodes;
    }

    @Override // sdk.pendo.io.h7.q
    public JSONObject b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", new JSONObject());
        jSONObject.put("timestamp", getTimestamp());
        jSONObject.put("type", x.FULL_SNAPSHOT.getValue());
        return jSONObject;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final p getDisplayData() {
        return this.displayData;
    }

    @Override // sdk.pendo.io.h7.q
    public JSONObject a() {
        long timestamp = getTimestamp();
        int value = x.FULL_SNAPSHOT.getValue();
        int topInset = this.displayData.getTopInset();
        int leftInset = this.displayData.getLeftInset();
        int value2 = k.DOCUMENT.getValue();
        int value3 = k.DOCUMENT_TYPE.getValue();
        k kVar = k.ELEMENT;
        return new JSONObject("{     \"timestamp\": " + timestamp + ",\n    \"type\": " + value + ",\n    \"data\": {\n      \"initialOffset\": {\n        \"top\": " + topInset + ",\n        \"left\": " + leftInset + "\n      },\n      \"node\": {\n        \"type\": " + value2 + ",\n        \"id\": 1,\n        \"childNodes\": [\n          {\n            \"type\": " + value3 + ",\n            \"id\": 2,\n            \"name\": \"html\"\n          },\n          {\n            \"type\": " + kVar.getValue() + ",\n            \"id\": 3,\n            \"tagName\": \"html\",\n            \"attributes\": {},\n            \"childNodes\": [\n              {\n                \"id\": 100,\n                \"type\": " + kVar.getValue() + ",\n                \"tagName\": \"body\",\n                \"attributes\": {},\n                \"childNodes\": " + this.childNodes + "              }\n            ]\n          }\n        ]\n      }\n    }\n}");
    }
}
