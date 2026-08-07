package sdk.pendo.io.r1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public class a extends ArrayList<Object> implements List<Object>, c, f {
    @Override // sdk.pendo.io.r1.b
    public String a() {
        return a(this, i.a);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return a();
    }

    public static String a(List<? extends Object> list, g gVar) {
        StringBuilder sb = new StringBuilder();
        try {
            a(list, sb, gVar);
        } catch (IOException unused) {
        }
        return sb.toString();
    }

    @Override // sdk.pendo.io.r1.c
    public String a(g gVar) {
        return a(this, gVar);
    }

    @Override // sdk.pendo.io.r1.e
    public void a(Appendable appendable) throws IOException {
        a(this, appendable, i.a);
    }

    @Override // sdk.pendo.io.r1.f
    public void a(Appendable appendable, g gVar) throws IOException {
        a(this, appendable, gVar);
    }

    public static void a(Iterable<? extends Object> iterable, Appendable appendable, g gVar) throws IOException {
        if (iterable == null) {
            appendable.append(AbstractJsonLexerKt.NULL);
        } else {
            sdk.pendo.io.u1.d.g.a(iterable, appendable, gVar);
        }
    }
}
