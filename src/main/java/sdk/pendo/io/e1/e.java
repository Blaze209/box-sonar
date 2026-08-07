package sdk.pendo.io.e1;

import java.util.Arrays;
import java.util.LinkedList;
import sdk.pendo.io.d1.l;

/* JADX INFO: loaded from: classes4.dex */
public class e implements sdk.pendo.io.d1.b {
    private static final sdk.pendo.io.v4.a c = sdk.pendo.io.v4.b.a((Class<?>) e.class);
    private final sdk.pendo.io.d1.a a;
    private final Object b;

    e(Object obj, sdk.pendo.io.d1.a aVar) {
        i.a(obj, "json can not be null", new Object[0]);
        i.a(aVar, "configuration can not be null", new Object[0]);
        this.a = aVar;
        this.b = obj;
    }

    private sdk.pendo.io.d1.g b(String str, l[] lVarArr) {
        sdk.pendo.io.m1.a aVarA = sdk.pendo.io.m1.b.a();
        String strA = i.a(str, new LinkedList(Arrays.asList(lVarArr)).toString());
        sdk.pendo.io.d1.g gVarA = aVarA.a(strA);
        if (gVarA != null) {
            return gVarA;
        }
        sdk.pendo.io.d1.g gVarA2 = sdk.pendo.io.d1.g.a(str, lVarArr);
        aVarA.a(strA, gVarA2);
        return gVarA2;
    }

    @Override // sdk.pendo.io.d1.m
    public <T> T a(String str, l... lVarArr) {
        i.a(str, "path can not be null or empty", new Object[0]);
        return (T) a(b(str, lVarArr));
    }

    public <T> T a(sdk.pendo.io.d1.g gVar) {
        i.a(gVar, "path can not be null", new Object[0]);
        return (T) gVar.a(this.b, this.a);
    }
}
