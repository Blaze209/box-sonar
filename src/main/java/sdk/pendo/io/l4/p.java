package sdk.pendo.io.l4;

import com.google.common.base.Ascii;
import java.io.EOFException;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import sdk.pendo.io.e2.b0;
import sdk.pendo.io.e2.c0;
import sdk.pendo.io.e2.x;
import sdk.pendo.io.e2.y;

/* JADX INFO: loaded from: classes4.dex */
final class p {
    private static final char[] l = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final Pattern m = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");
    private final String a;
    private final sdk.pendo.io.e2.v b;

    @Nullable
    private String c;

    @Nullable
    private sdk.pendo.io.e2.v.a d;
    private final b0.a e = new b0.a();
    private final sdk.pendo.io.e2.u.a f;

    @Nullable
    private x g;
    private final boolean h;

    @Nullable
    private y.a i;

    @Nullable
    private sdk.pendo.io.e2.s.a j;

    @Nullable
    private c0 k;

    private static class a extends c0 {
        private final c0 b;
        private final x c;

        a(c0 c0Var, x xVar) {
            this.b = c0Var;
            this.c = xVar;
        }

        @Override // sdk.pendo.io.e2.c0
        public long a() {
            return this.b.a();
        }

        @Override // sdk.pendo.io.e2.c0
        /* JADX INFO: renamed from: b */
        public x getContentType() {
            return this.c;
        }

        @Override // sdk.pendo.io.e2.c0
        public void a(sdk.pendo.io.s2.e eVar) {
            this.b.a(eVar);
        }
    }

    p(String str, sdk.pendo.io.e2.v vVar, @Nullable String str2, @Nullable sdk.pendo.io.e2.u uVar, @Nullable x xVar, boolean z, boolean z2, boolean z3) {
        this.a = str;
        this.b = vVar;
        this.c = str2;
        this.g = xVar;
        this.h = z;
        this.f = uVar != null ? uVar.a() : new sdk.pendo.io.e2.u.a();
        if (z2) {
            this.j = new sdk.pendo.io.e2.s.a();
        } else if (z3) {
            y.a aVar = new y.a();
            this.i = aVar;
            aVar.a(y.l);
        }
    }

    void a(String str, String str2, boolean z) {
        sdk.pendo.io.e2.s.a aVar = this.j;
        if (z) {
            aVar.b(str, str2);
        } else {
            aVar.a(str, str2);
        }
    }

    void b(String str, String str2, boolean z) throws EOFException {
        if (this.c == null) {
            throw new AssertionError();
        }
        String strReplace = this.c.replace("{" + str + "}", a(str2, z));
        if (m.matcher(strReplace).matches()) {
            throw new IllegalArgumentException("@Path parameters shouldn't perform path traversal ('.' or '..'): " + str2);
        }
        this.c = strReplace;
    }

    void c(String str, @Nullable String str2, boolean z) {
        String str3 = this.c;
        if (str3 != null) {
            sdk.pendo.io.e2.v.a aVarB = this.b.b(str3);
            this.d = aVarB;
            if (aVarB == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.b + ", Relative: " + this.c);
            }
            this.c = null;
        }
        sdk.pendo.io.e2.v.a aVar = this.d;
        if (z) {
            aVar.a(str, str2);
        } else {
            aVar.b(str, str2);
        }
    }

    void a(String str, String str2) {
        if (!"Content-Type".equalsIgnoreCase(str)) {
            this.f.a(str, str2);
            return;
        }
        try {
            this.g = x.a(str2);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Malformed content type: " + str2, e);
        }
    }

    void a(sdk.pendo.io.e2.u uVar) {
        this.f.a(uVar);
    }

    void a(sdk.pendo.io.e2.u uVar, c0 c0Var) {
        this.i.a(uVar, c0Var);
    }

    void a(y.c cVar) {
        this.i.a(cVar);
    }

    <T> void a(Class<T> cls, @Nullable T t) {
        this.e.a(cls, t);
    }

    private static String a(String str, boolean z) throws EOFException {
        int length = str.length();
        int iCharCount = 0;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt < 32 || iCodePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(iCodePointAt) != -1 || (!z && (iCodePointAt == 47 || iCodePointAt == 37))) {
                sdk.pendo.io.s2.d dVar = new sdk.pendo.io.s2.d();
                dVar.a(str, 0, iCharCount);
                a(dVar, str, iCharCount, length, z);
                return dVar.readUtf8();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str;
    }

    private static void a(sdk.pendo.io.s2.d dVar, String str, int i, int i2, boolean z) throws EOFException {
        sdk.pendo.io.s2.d dVar2 = null;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt < 32 || iCodePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(iCodePointAt) != -1 || (!z && (iCodePointAt == 47 || iCodePointAt == 37))) {
                    if (dVar2 == null) {
                        dVar2 = new sdk.pendo.io.s2.d();
                    }
                    dVar2.f(iCodePointAt);
                    while (!dVar2.exhausted()) {
                        byte b = dVar2.readByte();
                        dVar.writeByte(37);
                        char[] cArr = l;
                        dVar.writeByte((int) cArr[((b & 255) >> 4) & 15]);
                        dVar.writeByte((int) cArr[b & Ascii.SI]);
                    }
                } else {
                    dVar.f(iCodePointAt);
                }
            }
            i += Character.charCount(iCodePointAt);
        }
    }

    b0.a a() {
        sdk.pendo.io.e2.v vVarD;
        sdk.pendo.io.e2.v.a aVar = this.d;
        if (aVar != null) {
            vVarD = aVar.a();
        } else {
            vVarD = this.b.d(this.c);
            if (vVarD == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.b + ", Relative: " + this.c);
            }
        }
        c0 aVar2 = this.k;
        if (aVar2 == null) {
            sdk.pendo.io.e2.s.a aVar3 = this.j;
            if (aVar3 != null) {
                aVar2 = aVar3.a();
            } else {
                y.a aVar4 = this.i;
                if (aVar4 != null) {
                    aVar2 = aVar4.a();
                } else if (this.h) {
                    aVar2 = c0.a((x) null, new byte[0]);
                }
            }
        }
        x xVar = this.g;
        if (xVar != null) {
            if (aVar2 != null) {
                aVar2 = new a(aVar2, xVar);
            } else {
                this.f.a("Content-Type", xVar.getMediaType());
            }
        }
        return this.e.a(vVarD).a(this.f.a()).a(this.a, aVar2);
    }

    void a(c0 c0Var) {
        this.k = c0Var;
    }

    void a(Object obj) {
        this.c = obj.toString();
    }
}
