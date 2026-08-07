package sdk.pendo.io.r1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public class d extends HashMap<String, Object> implements c, f {
    @Override // sdk.pendo.io.r1.b
    public String a() {
        return a(this, i.a);
    }

    @Override // java.util.AbstractMap
    public String toString() {
        return a(this, i.a);
    }

    public static String a(Map<String, ? extends Object> map, g gVar) {
        StringBuilder sb = new StringBuilder();
        try {
            a(map, sb, gVar);
        } catch (IOException unused) {
        }
        return sb.toString();
    }

    @Override // sdk.pendo.io.r1.c
    public String a(g gVar) {
        return a(this, gVar);
    }

    public static void a(Map<String, ? extends Object> map, Appendable appendable, g gVar) throws IOException {
        if (map == null) {
            appendable.append(AbstractJsonLexerKt.NULL);
        } else {
            sdk.pendo.io.u1.d.i.a(map, appendable, gVar);
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0024  */
    /* JADX WARN: Code duplicated, block: B:13:0x002a  */
    public static void a(String str, Object obj, Appendable appendable, g gVar) throws IOException {
        if (str != null) {
            if (gVar.a(str)) {
                appendable.append('\"');
                i.a(str, appendable, gVar);
                appendable.append('\"');
            }
            appendable.append(AbstractJsonLexerKt.COLON);
            if (obj instanceof String) {
                gVar.a(appendable, (String) obj);
            } else {
                i.a(obj, appendable, gVar);
            }
        }
        str = AbstractJsonLexerKt.NULL;
        appendable.append(str);
        appendable.append(AbstractJsonLexerKt.COLON);
        if (obj instanceof String) {
            gVar.a(appendable, (String) obj);
        } else {
            i.a(obj, appendable, gVar);
        }
    }

    @Override // sdk.pendo.io.r1.e
    public void a(Appendable appendable) throws IOException {
        a(this, appendable, i.a);
    }

    @Override // sdk.pendo.io.r1.f
    public void a(Appendable appendable, g gVar) throws IOException {
        a(this, appendable, gVar);
    }
}
