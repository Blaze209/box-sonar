package sdk.pendo.io.w1;

import external.sdk.pendo.io.mozilla.javascript.Token;
import java.io.IOException;
import java.io.Writer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import sdk.pendo.io.a2.i;
import sdk.pendo.io.a2.k;
import sdk.pendo.io.a2.l;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class f {
    public static final sdk.pendo.io.a2.b a = new sdk.pendo.io.a2.f(new String[]{"\"", "\\\""}, new String[]{"\\", "\\\\"}).a(new sdk.pendo.io.a2.f(sdk.pendo.io.a2.d.i())).a(sdk.pendo.io.a2.e.a(32, 127));
    public static final sdk.pendo.io.a2.b b = new sdk.pendo.io.a2.a(new sdk.pendo.io.a2.f(new String[]{"'", "\\'"}, new String[]{"\"", "\\\""}, new String[]{"\\", "\\\\"}, new String[]{"/", "\\/"}), new sdk.pendo.io.a2.f(sdk.pendo.io.a2.d.i()), sdk.pendo.io.a2.e.a(32, 127));
    public static final sdk.pendo.io.a2.b c = new sdk.pendo.io.a2.a(new sdk.pendo.io.a2.f(new String[]{"\"", "\\\""}, new String[]{"\\", "\\\\"}, new String[]{"/", "\\/"}), new sdk.pendo.io.a2.f(sdk.pendo.io.a2.d.i()), sdk.pendo.io.a2.e.a(32, 127));

    @Deprecated
    public static final sdk.pendo.io.a2.b d = new sdk.pendo.io.a2.a(new sdk.pendo.io.a2.f(sdk.pendo.io.a2.d.c()), new sdk.pendo.io.a2.f(sdk.pendo.io.a2.d.a()));
    public static final sdk.pendo.io.a2.b e = new sdk.pendo.io.a2.a(new sdk.pendo.io.a2.f(sdk.pendo.io.a2.d.c()), new sdk.pendo.io.a2.f(sdk.pendo.io.a2.d.a()), new sdk.pendo.io.a2.f(new String[]{"\u0000", ""}, new String[]{"\u0001", ""}, new String[]{"\u0002", ""}, new String[]{"\u0003", ""}, new String[]{"\u0004", ""}, new String[]{"\u0005", ""}, new String[]{"\u0006", ""}, new String[]{"\u0007", ""}, new String[]{"\b", ""}, new String[]{"\u000b", ""}, new String[]{"\f", ""}, new String[]{"\u000e", ""}, new String[]{"\u000f", ""}, new String[]{"\u0010", ""}, new String[]{"\u0011", ""}, new String[]{"\u0012", ""}, new String[]{"\u0013", ""}, new String[]{"\u0014", ""}, new String[]{"\u0015", ""}, new String[]{"\u0016", ""}, new String[]{"\u0017", ""}, new String[]{"\u0018", ""}, new String[]{"\u0019", ""}, new String[]{"\u001a", ""}, new String[]{"\u001b", ""}, new String[]{"\u001c", ""}, new String[]{"\u001d", ""}, new String[]{"\u001e", ""}, new String[]{"\u001f", ""}, new String[]{"\ufffe", ""}, new String[]{"\uffff", ""}), sdk.pendo.io.a2.g.a(127, Token.TARGET), sdk.pendo.io.a2.g.a(134, Token.LETEXPR), new l());
    public static final sdk.pendo.io.a2.b f = new sdk.pendo.io.a2.a(new sdk.pendo.io.a2.f(sdk.pendo.io.a2.d.c()), new sdk.pendo.io.a2.f(sdk.pendo.io.a2.d.a()), new sdk.pendo.io.a2.f(new String[]{"\u0000", ""}, new String[]{"\u000b", "&#11;"}, new String[]{"\f", "&#12;"}, new String[]{"\ufffe", ""}, new String[]{"\uffff", ""}), sdk.pendo.io.a2.g.a(1, 8), sdk.pendo.io.a2.g.a(14, 31), sdk.pendo.io.a2.g.a(127, Token.TARGET), sdk.pendo.io.a2.g.a(134, Token.LETEXPR), new l());
    public static final sdk.pendo.io.a2.b g = new sdk.pendo.io.a2.a(new sdk.pendo.io.a2.f(sdk.pendo.io.a2.d.c()), new sdk.pendo.io.a2.f(sdk.pendo.io.a2.d.g()));
    public static final sdk.pendo.io.a2.b h = new sdk.pendo.io.a2.a(new sdk.pendo.io.a2.f(sdk.pendo.io.a2.d.c()), new sdk.pendo.io.a2.f(sdk.pendo.io.a2.d.g()), new sdk.pendo.io.a2.f(sdk.pendo.io.a2.d.e()));
    public static final sdk.pendo.io.a2.b i = new a();
    public static final sdk.pendo.io.a2.b j;
    public static final sdk.pendo.io.a2.b k;
    public static final sdk.pendo.io.a2.b l;
    public static final sdk.pendo.io.a2.b m;
    public static final sdk.pendo.io.a2.b n;
    public static final sdk.pendo.io.a2.b o;
    public static final sdk.pendo.io.a2.b p;

    static class a extends sdk.pendo.io.a2.b {
        private static final String b = String.valueOf('\"');
        private static final char[] c = {AbstractJsonLexerKt.COMMA, '\"', '\r', '\n'};

        a() {
        }

        @Override // sdk.pendo.io.a2.b
        public int a(CharSequence charSequence, int i, Writer writer) throws IOException {
            if (i != 0) {
                throw new IllegalStateException("CsvEscaper should never reach the [1] index");
            }
            if (g.b(charSequence.toString(), c)) {
                writer.write(charSequence.toString());
            } else {
                writer.write(34);
                String string = charSequence.toString();
                String str = b;
                writer.write(g.a(string, str, str + str));
                writer.write(34);
            }
            return Character.codePointCount(charSequence, 0, charSequence.length());
        }
    }

    static class b extends sdk.pendo.io.a2.b {
        private static final String b = String.valueOf('\"');
        private static final char[] c = {AbstractJsonLexerKt.COMMA, '\"', '\r', '\n'};

        b() {
        }

        @Override // sdk.pendo.io.a2.b
        public int a(CharSequence charSequence, int i, Writer writer) throws IOException {
            String string;
            if (i != 0) {
                throw new IllegalStateException("CsvUnescaper should never reach the [1] index");
            }
            if (charSequence.charAt(0) == '\"' && charSequence.charAt(charSequence.length() - 1) == '\"') {
                String string2 = charSequence.subSequence(1, charSequence.length() - 1).toString();
                if (g.a(string2, c)) {
                    StringBuilder sb = new StringBuilder();
                    String str = b;
                    string = g.a(string2, sb.append(str).append(str).toString(), str);
                } else {
                    string = charSequence.toString();
                }
            } else {
                string = charSequence.toString();
            }
            writer.write(string);
            return Character.codePointCount(charSequence, 0, charSequence.length());
        }
    }

    static {
        sdk.pendo.io.a2.a aVar = new sdk.pendo.io.a2.a(new i(), new k(), new sdk.pendo.io.a2.f(sdk.pendo.io.a2.d.j()), new sdk.pendo.io.a2.f(new String[]{"\\\\", "\\"}, new String[]{"\\\"", "\""}, new String[]{"\\'", "'"}, new String[]{"\\", ""}));
        j = aVar;
        k = aVar;
        l = aVar;
        m = new sdk.pendo.io.a2.a(new sdk.pendo.io.a2.f(sdk.pendo.io.a2.d.d()), new sdk.pendo.io.a2.f(sdk.pendo.io.a2.d.h()), new sdk.pendo.io.a2.h(new sdk.pendo.io.a2.h.a[0]));
        n = new sdk.pendo.io.a2.a(new sdk.pendo.io.a2.f(sdk.pendo.io.a2.d.d()), new sdk.pendo.io.a2.f(sdk.pendo.io.a2.d.h()), new sdk.pendo.io.a2.f(sdk.pendo.io.a2.d.f()), new sdk.pendo.io.a2.h(new sdk.pendo.io.a2.h.a[0]));
        o = new sdk.pendo.io.a2.a(new sdk.pendo.io.a2.f(sdk.pendo.io.a2.d.d()), new sdk.pendo.io.a2.f(sdk.pendo.io.a2.d.b()), new sdk.pendo.io.a2.h(new sdk.pendo.io.a2.h.a[0]));
        p = new b();
    }

    public static final String a(String str) {
        return c.a(str);
    }
}
