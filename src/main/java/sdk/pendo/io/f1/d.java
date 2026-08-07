package sdk.pendo.io.f1;

import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import java.util.ArrayList;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import sdk.pendo.io.d1.l;

/* JADX INFO: loaded from: classes4.dex */
public class d {
    private static final sdk.pendo.io.v4.a b = sdk.pendo.io.v4.b.a((Class<?>) d.class);
    static final /* synthetic */ boolean c = true;
    private sdk.pendo.io.e1.a a;

    private static final class a extends sdk.pendo.io.d1.d {
        private final l a;

        private a(l lVar) {
            this.a = lVar;
        }

        @Override // sdk.pendo.io.d1.l
        public boolean a(l.a aVar) {
            return this.a.a(aVar);
        }

        public String toString() {
            StringBuilder sbAppend;
            String str;
            String string = this.a.toString();
            if (string.startsWith("(")) {
                sbAppend = new StringBuilder("[?").append(string);
                str = "]";
            } else {
                sbAppend = new StringBuilder("[?(").append(string);
                str = ")]";
            }
            return sbAppend.append(str).toString();
        }
    }

    private d(String str) {
        sdk.pendo.io.e1.a aVar = new sdk.pendo.io.e1.a(str);
        this.a = aVar;
        aVar.l();
        if (!this.a.a(AbstractJsonLexerKt.BEGIN_LIST) || !this.a.c(AbstractJsonLexerKt.END_LIST)) {
            throw new sdk.pendo.io.d1.f("Filter must start with '[' and end with ']'. " + str);
        }
        this.a.d(1);
        this.a.b(1);
        this.a.l();
        if (!this.a.a('?')) {
            throw new sdk.pendo.io.d1.f("Filter must start with '[?' and end with ']'. " + str);
        }
        this.a.d(1);
        this.a.l();
        if (!this.a.a('(') || !this.a.c(')')) {
            throw new sdk.pendo.io.d1.f("Filter must start with '[?(' and end with ')]'. " + str);
        }
    }

    public static sdk.pendo.io.d1.d a(String str) {
        return new a(new d(str).a());
    }

    private boolean a(char c2) {
        return c2 == '<' || c2 == '>' || c2 == '=' || c2 == '~' || c2 == '!';
    }

    private int b(int i) {
        while (this.a.c(i) && g.a(new char[]{this.a.a(i)}) > 0) {
            i++;
        }
        return i;
    }

    private h c() {
        j jVarN = n();
        try {
            return new h(jVarN, m(), n());
        } catch (sdk.pendo.io.d1.f unused) {
            this.a.k(this.a.h());
            k.f fVarE = jVarN.e();
            k.f fVarA = fVarE.a(fVarE.t());
            return new h(fVarA, i.EXISTS, fVarA.e().t() ? k.b : k.c);
        }
    }

    private k.c d() {
        int iH = this.a.h();
        char cA = this.a.a();
        if (!c && cA != '[' && cA != '{') {
            throw new AssertionError();
        }
        char c2 = cA == '[' ? AbstractJsonLexerKt.END_LIST : AbstractJsonLexerKt.END_OBJ;
        sdk.pendo.io.e1.a aVar = this.a;
        int iA = aVar.a(aVar.h(), cA, c2, true, false);
        if (iA == -1) {
            throw new sdk.pendo.io.d1.f("String not closed. Expected ' in " + this.a);
        }
        this.a.k(iA + 1);
        sdk.pendo.io.e1.a aVar2 = this.a;
        CharSequence charSequenceA = aVar2.a(iH, aVar2.h());
        b.b("JsonLiteral from {} to {} -> [{}]", Integer.valueOf(iH), Integer.valueOf(this.a.h()), charSequenceA);
        return j.b(charSequenceA);
    }

    private j e() {
        char cA = this.a.j().a();
        if (cA == '\"') {
            return b('\"');
        }
        if (cA == '\'') {
            return b('\'');
        }
        if (cA == '-') {
            return j();
        }
        if (cA == '/') {
            return l();
        }
        if (cA == '[') {
            return d();
        }
        if (cA == 'f') {
            return b();
        }
        if (cA == 'n') {
            return i();
        }
        if (cA != 't') {
            return cA != '{' ? j() : d();
        }
        return b();
    }

    private c f() {
        int iH;
        ArrayList arrayList = new ArrayList();
        do {
            arrayList.add(g());
            iH = this.a.h();
        } while (this.a.a(f.AND.b()));
        this.a.k(iH);
        return 1 == arrayList.size() ? (c) arrayList.get(0) : e.a(arrayList);
    }

    private c g() {
        int iH = this.a.j().h();
        if (this.a.j().a('!')) {
            this.a.g('!');
            char cA = this.a.j().a();
            if (cA != '$' && cA != '@') {
                return e.a(g());
            }
            this.a.k(iH);
        }
        if (!this.a.j().a('(')) {
            return c();
        }
        this.a.g('(');
        c cVarH = h();
        this.a.g(')');
        return cVarH;
    }

    private c h() {
        int iH;
        ArrayList arrayList = new ArrayList();
        do {
            arrayList.add(f());
            iH = this.a.h();
        } while (this.a.a(f.OR.b()));
        this.a.k(iH);
        return 1 == arrayList.size() ? (c) arrayList.get(0) : e.b(arrayList);
    }

    private k.d i() {
        int iH = this.a.h();
        if (this.a.a() == 'n') {
            sdk.pendo.io.e1.a aVar = this.a;
            if (aVar.c(aVar.h() + 3)) {
                sdk.pendo.io.e1.a aVar2 = this.a;
                CharSequence charSequenceA = aVar2.a(aVar2.h(), this.a.h() + 4);
                if (AbstractJsonLexerKt.NULL.equals(charSequenceA.toString())) {
                    b.b("NullLiteral from {} to {} -> [{}]", Integer.valueOf(iH), Integer.valueOf(this.a.h() + 3), charSequenceA);
                    this.a.d(charSequenceA.length());
                    return j.j();
                }
            }
        }
        throw new sdk.pendo.io.d1.f("Expected <null> value");
    }

    private k.e j() {
        int iH = this.a.h();
        while (this.a.d()) {
            sdk.pendo.io.e1.a aVar = this.a;
            if (!aVar.f(aVar.h())) {
                break;
            }
            this.a.d(1);
        }
        sdk.pendo.io.e1.a aVar2 = this.a;
        CharSequence charSequenceA = aVar2.a(iH, aVar2.h());
        b.b("NumberLiteral from {} to {} -> [{}]", Integer.valueOf(iH), Integer.valueOf(this.a.h()), charSequenceA);
        return j.c(charSequenceA);
    }

    private k.f k() {
        char cI = this.a.i();
        int iH = this.a.h();
        sdk.pendo.io.e1.a aVar = this.a;
        while (true) {
            aVar.d(1);
            if (!this.a.d()) {
                break;
            }
            if (this.a.a() == '[') {
                sdk.pendo.io.e1.a aVar2 = this.a;
                int iA = aVar2.a(aVar2.h(), AbstractJsonLexerKt.BEGIN_LIST, AbstractJsonLexerKt.END_LIST, true, false);
                if (iA == -1) {
                    throw new sdk.pendo.io.d1.f("Square brackets does not match in filter " + this.a);
                }
                this.a.k(iA + 1);
            }
            boolean z = this.a.a() == ')' && !(this.a.a() == ')' && a(iH));
            if (!this.a.d() || a(this.a.a()) || this.a.a() == ' ' || z) {
                break;
            }
            aVar = this.a;
        }
        boolean z2 = cI != '!';
        sdk.pendo.io.e1.a aVar3 = this.a;
        return j.a(aVar3.a(iH, aVar3.h()), false, z2);
    }

    private k.g l() {
        int iB;
        int iH = this.a.h();
        int iE = this.a.e('/');
        if (iE == -1) {
            throw new sdk.pendo.io.d1.f("Pattern not closed. Expected / in " + this.a);
        }
        int i = iE + 1;
        if (this.a.c(i) && (iB = b(i)) > iE) {
            iE += this.a.a(i, iB).length();
        }
        this.a.k(iE + 1);
        sdk.pendo.io.e1.a aVar = this.a;
        CharSequence charSequenceA = aVar.a(iH, aVar.h());
        b.b("PatternNode from {} to {} -> [{}]", Integer.valueOf(iH), Integer.valueOf(this.a.h()), charSequenceA);
        return j.d(charSequenceA);
    }

    private i m() {
        int iH = this.a.j().h();
        if (a(this.a.a())) {
            while (this.a.d() && a(this.a.a())) {
                this.a.d(1);
            }
        } else {
            while (this.a.d() && this.a.a() != ' ') {
                this.a.d(1);
            }
        }
        sdk.pendo.io.e1.a aVar = this.a;
        CharSequence charSequenceA = aVar.a(iH, aVar.h());
        b.b("Operator from {} to {} -> [{}]", Integer.valueOf(iH), Integer.valueOf(this.a.h() - 1), charSequenceA);
        return i.a(charSequenceA.toString());
    }

    private j n() {
        char cA = this.a.j().a();
        if (cA != '!') {
            if (cA != '$' && cA != '@') {
                return e();
            }
            return k();
        }
        this.a.d(1);
        char cA2 = this.a.j().a();
        if (cA2 != '$' && cA2 != '@') {
            throw new sdk.pendo.io.d1.f(String.format("Unexpected character: %c", '!'));
        }
        return k();
    }

    private k.a b() {
        int iH = this.a.h();
        int iH2 = this.a.a() == 't' ? this.a.h() + 3 : this.a.h() + 4;
        if (!this.a.c(iH2)) {
            throw new sdk.pendo.io.d1.f("Expected boolean literal");
        }
        CharSequence charSequenceA = this.a.a(iH, iH2 + 1);
        if (!charSequenceA.equals(TelemetryEventStrings.Value.TRUE) && !charSequenceA.equals("false")) {
            throw new sdk.pendo.io.d1.f("Expected boolean literal");
        }
        this.a.d(charSequenceA.length());
        b.b("BooleanLiteral from {} to {} -> [{}]", Integer.valueOf(iH), Integer.valueOf(iH2), charSequenceA);
        return j.a(charSequenceA);
    }

    public l a() {
        try {
            c cVarH = h();
            this.a.j();
            if (!this.a.d()) {
                return cVarH;
            }
            sdk.pendo.io.e1.a aVar = this.a;
            throw new sdk.pendo.io.d1.f(String.format("Expected end of filter expression instead of: %s", aVar.a(aVar.h(), this.a.f())));
        } catch (sdk.pendo.io.d1.f e) {
            throw e;
        } catch (Exception unused) {
            throw new sdk.pendo.io.d1.f("Failed to parse filter: " + this.a + ", error on position: " + this.a.h() + ", char: " + this.a.a());
        }
    }

    private boolean a(int i) {
        int iE;
        if (this.a.a() == ')' && (iE = this.a.e()) != -1 && this.a.a(iE) == '(') {
            do {
                iE--;
                if (!this.a.c(iE) || iE <= i) {
                }
            } while (this.a.a(iE) != '.');
            return true;
        }
        return false;
    }

    private k.i b(char c2) {
        int iH = this.a.h();
        int iE = this.a.e(c2);
        if (iE == -1) {
            throw new sdk.pendo.io.d1.f("String literal does not have matching quotes. Expected " + c2 + " in " + this.a);
        }
        this.a.k(iE + 1);
        sdk.pendo.io.e1.a aVar = this.a;
        CharSequence charSequenceA = aVar.a(iH, aVar.h());
        b.b("StringLiteral from {} to {} -> [{}]", Integer.valueOf(iH), Integer.valueOf(this.a.h()), charSequenceA);
        return j.a(charSequenceA, true);
    }
}
