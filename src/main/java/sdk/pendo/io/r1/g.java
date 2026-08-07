package sdk.pendo.io.r1;

import java.io.IOException;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public class g {
    public static final g h = new g(0);
    public static final g i = new g(-1);
    public static final g j = new g(2);
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private j.g e;
    private j.g f;
    private j.h g;

    public g(int i2) {
        boolean z = (i2 & 1) == 0;
        this.a = z;
        boolean z2 = (i2 & 4) == 0;
        this.c = z2;
        boolean z3 = (i2 & 2) == 0;
        this.b = z3;
        this.d = (i2 & 16) > 0;
        j.g gVar = (i2 & 8) > 0 ? j.c : j.a;
        if (z2) {
            this.f = j.b;
        } else {
            this.f = gVar;
        }
        this.e = z ? j.b : gVar;
        this.g = z3 ? j.e : j.d;
    }

    public void a(Appendable appendable) throws IOException {
        appendable.append(AbstractJsonLexerKt.COMMA);
    }

    public void b(Appendable appendable) {
    }

    public void c(Appendable appendable) throws IOException {
        appendable.append(AbstractJsonLexerKt.BEGIN_LIST);
    }

    public void d(Appendable appendable) throws IOException {
        appendable.append(AbstractJsonLexerKt.END_LIST);
    }

    public void e(Appendable appendable) {
    }

    public void f(Appendable appendable) {
    }

    public void g(Appendable appendable) throws IOException {
        appendable.append(AbstractJsonLexerKt.COLON);
    }

    public void h(Appendable appendable) {
    }

    public void i(Appendable appendable) throws IOException {
        appendable.append(AbstractJsonLexerKt.COMMA);
    }

    public void j(Appendable appendable) throws IOException {
        appendable.append(AbstractJsonLexerKt.BEGIN_OBJ);
    }

    public void k(Appendable appendable) throws IOException {
        appendable.append(AbstractJsonLexerKt.END_OBJ);
    }

    public void a(String str, Appendable appendable) {
        this.g.a(str, appendable);
    }

    public boolean b(String str) {
        return this.f.a(str);
    }

    public boolean a() {
        return this.d;
    }

    public boolean a(String str) {
        return this.e.a(str);
    }

    public void a(Appendable appendable, String str) throws IOException {
        if (!b(str)) {
            appendable.append(str);
            return;
        }
        appendable.append('\"');
        i.a(str, appendable, this);
        appendable.append('\"');
    }
}
