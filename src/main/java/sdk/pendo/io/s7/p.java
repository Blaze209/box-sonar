package sdk.pendo.io.s7;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import org.json.JSONArray;
import org.json.JSONException;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes5.dex */
public final class p {

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[sdk.pendo.io.b.c.EnumC0347c.values().length];
            a = iArr;
            try {
                iArr[sdk.pendo.io.b.c.EnumC0347c.INTEGER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[sdk.pendo.io.b.c.EnumC0347c.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static Boolean a(String str, TextView textView) {
        Typeface typefaceB = str != null ? o.b(str) : null;
        if (typefaceB == null) {
            return Boolean.FALSE;
        }
        textView.setTypeface(typefaceB);
        return Boolean.TRUE;
    }

    public static String a(String str, sdk.pendo.io.b.c cVar, TextView textView) {
        int iA = a(cVar);
        String strA = a(str, iA);
        try {
            Typeface font = ResourcesCompat.getFont(PendoInternal.o(), PendoInternal.o().getResources().getIdentifier(strA, "font", PendoInternal.o().getPackageName()));
            if (font != null) {
                textView.setTypeface(font);
                return strA;
            }
        } catch (Resources.NotFoundException unused) {
            PendoLogger.d("Font not in resources", new Object[0]);
        }
        if (strA == null) {
            return null;
        }
        textView.setTypeface(Typeface.create(strA, iA));
        return strA;
    }

    public static String a(String str, int i) {
        JSONArray jSONArray;
        String string;
        try {
            jSONArray = new JSONArray(str);
        } catch (JSONException unused) {
            jSONArray = null;
        }
        if (str != null) {
            return str;
        }
        if (jSONArray == null) {
            return null;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                string = jSONArray.get(i2).toString();
            } catch (JSONException e) {
                PendoLogger.e(e, e.getMessage(), new Object[0]);
                string = null;
            }
            if (string == null) {
                return null;
            }
            if (Typeface.create(string, i) != null) {
                return string;
            }
        }
        return null;
    }

    public static sdk.pendo.io.i0.b a(Context context, int i, int i2, int i3, sdk.pendo.io.i0.a aVar) {
        return a(context, i, i2, aVar).a(i3);
    }

    public static sdk.pendo.io.i0.b a(Context context, int i, int i2, sdk.pendo.io.i0.a aVar) {
        return new sdk.pendo.io.i0.b(context, aVar).b(i2).c(i);
    }

    public static char a(String str) {
        return str.charAt(0);
    }

    public static sdk.pendo.io.i0.a a(char c, sdk.pendo.io.i0.a aVar) {
        sdk.pendo.io.z5.b bVarA = sdk.pendo.io.z5.b.a(Character.valueOf(c));
        return bVarA != null ? bVarA : aVar;
    }

    public static int a(sdk.pendo.io.b.c cVar) {
        if (cVar == null) {
            return 0;
        }
        int i = a.a[cVar.b.ordinal()];
        if (i == 1) {
            return cVar.h();
        }
        if (i != 2) {
            return 0;
        }
        String strJ = cVar.j();
        if ("bold".equals(strJ)) {
            return 1;
        }
        if ("italic".equals(strJ)) {
            return 2;
        }
        return "bold_italic".equals(strJ) ? 3 : 0;
    }
}
