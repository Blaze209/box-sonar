package sdk.pendo.io.r1;

import java.io.IOException;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public class i {
    public static g a = g.h;
    public static final sdk.pendo.io.u1.d b = new sdk.pendo.io.u1.d();
    public static final sdk.pendo.io.v1.j c = new sdk.pendo.io.v1.j();

    public static void a(String str, Appendable appendable, g gVar) {
        if (str == null) {
            return;
        }
        gVar.a(str, appendable);
    }

    public static <T> T a(String str, Class<T> cls) {
        try {
            return (T) new sdk.pendo.io.t1.a(sdk.pendo.io.t1.a.c).a(str, c.a((Class) cls));
        } catch (Exception unused) {
            return null;
        }
    }

    public static void a(Object obj, Appendable appendable, g gVar) throws IOException {
        if (obj == null) {
            appendable.append(AbstractJsonLexerKt.NULL);
            return;
        }
        Class<?> cls = obj.getClass();
        sdk.pendo.io.u1.d dVar = b;
        sdk.pendo.io.u1.e<Object> eVarA = dVar.a(cls);
        if (eVarA == null) {
            if (cls.isArray()) {
                eVarA = sdk.pendo.io.u1.d.l;
            } else {
                eVarA = dVar.b(obj.getClass());
                if (eVarA == null) {
                    eVarA = sdk.pendo.io.u1.d.j;
                }
            }
            dVar.a(eVarA, cls);
        }
        eVarA.a(obj, appendable, gVar);
    }
}
