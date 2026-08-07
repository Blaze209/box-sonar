package sdk.pendo.io.s7;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¨\u0006\u0007"}, d2 = {"Lorg/json/JSONObject;", "", "name", "", "value", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lorg/json/JSONArray;", "pendoIO_release"}, k = 2, mv = {1, 9, 0})
public final class z {
    public static final JSONArray a(JSONArray jSONArray, Object value) {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            if (value instanceof Boolean) {
                jSONArray.put(((Boolean) value).booleanValue());
                return jSONArray;
            }
            if (value instanceof Double) {
                jSONArray.put(((Number) value).doubleValue());
                return jSONArray;
            }
            if (value instanceof Integer) {
                jSONArray.put(((Number) value).intValue());
                return jSONArray;
            }
            if (value instanceof Long) {
                jSONArray.put(((Number) value).longValue());
                return jSONArray;
            }
            jSONArray.put(value);
            return jSONArray;
        } catch (JSONException e) {
            PendoLogger.e(y.a.a(), "Failed to add value to JSONArray with value:" + value, e);
            return jSONArray;
        }
    }

    public static final JSONObject a(JSONObject jSONObject, String name, Object value) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            if (value instanceof Boolean) {
                jSONObject.put(name, ((Boolean) value).booleanValue());
                return jSONObject;
            }
            if (value instanceof Double) {
                jSONObject.put(name, ((Number) value).doubleValue());
                return jSONObject;
            }
            if (value instanceof Integer) {
                jSONObject.put(name, ((Number) value).intValue());
                return jSONObject;
            }
            if (value instanceof Long) {
                jSONObject.put(name, ((Number) value).longValue());
                return jSONObject;
            }
            jSONObject.put(name, value);
            return jSONObject;
        } catch (JSONException e) {
            PendoLogger.e(y.a.a(), "Failed to add key-value pair to JSONObject with key:" + name + " and value:" + value, e);
            return jSONObject;
        }
    }
}
