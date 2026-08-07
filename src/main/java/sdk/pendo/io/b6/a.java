package sdk.pendo.io.b6;

import android.os.Build;
import com.box.androidsdk.content.models.BoxRepresentation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0014¨\u0006\n"}, d2 = {"Lsdk/pendo/io/b6/a;", "Lsdk/pendo/io/a6/a;", "Lorg/json/JSONObject;", BoxRepresentation.FIELD_INFO, "", "c", "json", "b", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class a extends sdk.pendo.io.a6.a {
    private final void c(JSONObject info) {
        try {
            info.put("os", "Android");
            info.put("osVersion", String.valueOf(Build.VERSION.SDK_INT));
            info.put("brand", Build.BRAND);
            info.put("manufacturer", Build.MANUFACTURER);
            info.put("model", Build.MODEL);
            info.put("board", Build.BOARD);
        } catch (JSONException e) {
            PendoLogger.e(e, String.valueOf(e.getMessage()), new Object[0]);
        }
    }

    @Override // sdk.pendo.io.a6.a
    protected void b(JSONObject json) {
        Intrinsics.checkNotNullParameter(json, "json");
        c(json);
    }
}
