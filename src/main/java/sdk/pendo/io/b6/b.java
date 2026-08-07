package sdk.pendo.io.b6;

import android.util.DisplayMetrics;
import com.box.androidsdk.content.models.BoxRepresentation;
import com.facebook.react.uimanager.ViewProps;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.s7.z;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0014¨\u0006\n"}, d2 = {"Lsdk/pendo/io/b6/b;", "Lsdk/pendo/io/a6/a;", "Lorg/json/JSONObject;", BoxRepresentation.FIELD_INFO, "", "c", "json", "b", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class b extends sdk.pendo.io.a6.a {
    private final void c(JSONObject info) {
        DisplayMetrics displayMetrics = PendoInternal.o().getResources().getDisplayMetrics();
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.densityDpi;
        double d = i3;
        double dSqrt = Math.sqrt(Math.pow(((double) i2) / d, 2.0d) + Math.pow(((double) i) / d, 2.0d));
        JSONObject jSONObject = new JSONObject();
        z.a(jSONObject, "width", Integer.valueOf(i2));
        z.a(jSONObject, "height", Integer.valueOf(i));
        z.a(jSONObject, "density", Integer.valueOf(i3));
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(dSqrt)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        Double dValueOf = Double.valueOf(str);
        Intrinsics.checkNotNullExpressionValue(dValueOf, "valueOf(...)");
        z.a(jSONObject, "size", dValueOf);
        z.a(info, ViewProps.DISPLAY, jSONObject);
    }

    @Override // sdk.pendo.io.a6.a
    protected void b(JSONObject json) {
        Intrinsics.checkNotNullParameter(json, "json");
        c(json);
    }
}
