package sdk.pendo.io.j0;

import android.content.Context;
import android.graphics.Typeface;
import java.util.HashMap;
import java.util.Map;
import sdk.pendo.io.i0.c;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    private final c a;
    private final Map<String, sdk.pendo.io.i0.a> b = new HashMap();
    private Typeface c;

    public a(c cVar) {
        this.a = cVar;
        for (sdk.pendo.io.i0.a aVar : cVar.b()) {
            this.b.put(aVar.b(), aVar);
        }
    }

    public c a() {
        return this.a;
    }

    public Typeface a(Context context) {
        Typeface typeface = this.c;
        if (typeface != null) {
            return typeface;
        }
        synchronized (this) {
            Typeface typeface2 = this.c;
            if (typeface2 != null) {
                return typeface2;
            }
            Typeface typefaceCreateFromAsset = Typeface.createFromAsset(context.getAssets(), this.a.a());
            this.c = typefaceCreateFromAsset;
            return typefaceCreateFromAsset;
        }
    }

    public boolean a(sdk.pendo.io.i0.a aVar) {
        return this.b.values().contains(aVar);
    }
}
