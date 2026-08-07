package sdk.pendo.io.f1;

import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import java.lang.reflect.GenericDeclaration;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import sdk.pendo.io.d1.l;
import sdk.pendo.io.l1.m;

/* JADX INFO: loaded from: classes4.dex */
public interface k {
    public static final d a;
    public static final a b;
    public static final a c;
    public static final j d = new j();

    public static class a extends sdk.pendo.io.f1.j {
        private final Boolean a;

        private a(CharSequence charSequence) {
            this.a = Boolean.valueOf(Boolean.parseBoolean(charSequence.toString()));
        }

        @Override // sdk.pendo.io.f1.j
        public a a() {
            return this;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof i) {
                i iVar = (i) obj;
                if (iVar.s().equalsIgnoreCase(TelemetryEventStrings.Value.TRUE) || iVar.s().equalsIgnoreCase("false")) {
                    obj = new a(iVar.s());
                }
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            Boolean bool = this.a;
            return bool == null ? aVar.a == null : bool.equals(aVar.a);
        }

        @Override // sdk.pendo.io.f1.j
        public boolean k() {
            return true;
        }

        public boolean s() {
            return this.a.booleanValue();
        }

        public String toString() {
            return this.a.toString();
        }

        @Override // sdk.pendo.io.f1.j
        public Class<?> a(l.a aVar) {
            return Boolean.class;
        }
    }

    public static class b extends sdk.pendo.io.f1.j {
        private final Class a;

        b(Class cls) {
            this.a = cls;
        }

        @Override // sdk.pendo.io.f1.j
        public Class<?> a(l.a aVar) {
            return Class.class;
        }

        @Override // sdk.pendo.io.f1.j
        public b b() {
            return this;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            Class cls = this.a;
            return cls == null ? bVar.a == null : cls.equals(bVar.a);
        }

        public Class s() {
            return this.a;
        }

        public String toString() {
            return this.a.getName();
        }
    }

    public static class c extends sdk.pendo.io.f1.j {
        private final Object a;
        private final boolean b = false;

        c(CharSequence charSequence) {
            this.a = charSequence.toString();
        }

        public boolean a(c cVar, l.a aVar) {
            if (this == cVar) {
                return true;
            }
            Object obj = this.a;
            if (obj != null) {
                if (!obj.equals(cVar.g(aVar))) {
                    return false;
                }
            } else if (cVar.a != null) {
                return false;
            }
            return true;
        }

        public sdk.pendo.io.f1.j b(l.a aVar) {
            return !c(aVar) ? k.d : new C0383k(Collections.unmodifiableList((List) g(aVar)));
        }

        @Override // sdk.pendo.io.f1.j
        public c c() {
            return this;
        }

        public boolean d(l.a aVar) {
            if (c(aVar) || e(aVar)) {
                return ((Collection) g(aVar)).size() == 0;
            }
            return !(g(aVar) instanceof String) || ((String) g(aVar)).length() == 0;
        }

        public boolean e(l.a aVar) {
            return g(aVar) instanceof Map;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            Object obj2 = this.a;
            return obj2 == null ? cVar.a == null : obj2.equals(cVar.a);
        }

        public int f(l.a aVar) {
            if (c(aVar)) {
                return ((List) g(aVar)).size();
            }
            return -1;
        }

        public Object g(l.a aVar) {
            try {
                return this.b ? this.a : new sdk.pendo.io.t1.a(-1).a(this.a.toString());
            } catch (sdk.pendo.io.t1.e e) {
                throw new IllegalArgumentException(e);
            }
        }

        @Override // sdk.pendo.io.f1.j
        public boolean l() {
            return true;
        }

        public String toString() {
            return this.a.toString();
        }

        c(Object obj) {
            this.a = obj;
        }

        @Override // sdk.pendo.io.f1.j
        public Class<?> a(l.a aVar) {
            if (c(aVar)) {
                return List.class;
            }
            if (e(aVar)) {
                return Map.class;
            }
            if (g(aVar) instanceof Number) {
                return Number.class;
            }
            if (g(aVar) instanceof String) {
                return String.class;
            }
            return g(aVar) instanceof Boolean ? Boolean.class : Void.class;
        }

        public boolean c(l.a aVar) {
            return g(aVar) instanceof List;
        }
    }

    public static class d extends sdk.pendo.io.f1.j {
        private d() {
        }

        @Override // sdk.pendo.io.f1.j
        public Class<?> a(l.a aVar) {
            return Void.class;
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof d);
        }

        public String toString() {
            return AbstractJsonLexerKt.NULL;
        }
    }

    public static class e extends sdk.pendo.io.f1.j {
        public static e b = new e((BigDecimal) null);
        private final BigDecimal a;

        e(CharSequence charSequence) {
            this.a = new BigDecimal(charSequence.toString());
        }

        @Override // sdk.pendo.io.f1.j
        public Class<?> a(l.a aVar) {
            return Number.class;
        }

        @Override // sdk.pendo.io.f1.j
        public e d() {
            return this;
        }

        public boolean equals(Object obj) {
            e eVarD;
            if (this == obj) {
                return true;
            }
            return ((obj instanceof e) || (obj instanceof i)) && (eVarD = ((sdk.pendo.io.f1.j) obj).d()) != b && this.a.compareTo(eVarD.a) == 0;
        }

        @Override // sdk.pendo.io.f1.j
        public i h() {
            return new i(this.a.toString(), false);
        }

        @Override // sdk.pendo.io.f1.j
        public boolean m() {
            return true;
        }

        public BigDecimal s() {
            return this.a;
        }

        public String toString() {
            return this.a.toString();
        }

        e(BigDecimal bigDecimal) {
            this.a = bigDecimal;
        }
    }

    public static class f extends sdk.pendo.io.f1.j {
        private static final sdk.pendo.io.v4.a d = sdk.pendo.io.v4.b.a((Class<?>) f.class);
        private final sdk.pendo.io.e1.g a;
        private final boolean b;
        private final boolean c;

        f(CharSequence charSequence, boolean z, boolean z2) {
            this(sdk.pendo.io.l1.i.a(charSequence.toString(), new l[0]), z, z2);
        }

        public f a(boolean z) {
            return new f(this.a, true, z);
        }

        public sdk.pendo.io.f1.j b(l.a aVar) {
            Object value;
            sdk.pendo.io.o1.c cVarG;
            GenericDeclaration genericDeclaration;
            sdk.pendo.io.d1.a aVarA;
            if (s()) {
                try {
                    return this.a.a(aVar.c(), aVar.b(), sdk.pendo.io.d1.a.a().a(aVar.a().f()).a(sdk.pendo.io.d1.i.REQUIRE_PROPERTIES).a()).a(false) == sdk.pendo.io.n1.b.a ? k.c : k.b;
                } catch (sdk.pendo.io.d1.k unused) {
                    return k.c;
                }
            }
            try {
                if (aVar instanceof m) {
                    value = ((m) aVar).a(this.a);
                } else {
                    value = this.a.a(this.a.b() ? aVar.b() : aVar.c(), aVar.b(), aVar.a()).getValue();
                }
                Object objG = aVar.a().f().g(value);
                if (objG instanceof Number) {
                    return sdk.pendo.io.f1.j.c((CharSequence) objG.toString());
                }
                if (objG instanceof String) {
                    return sdk.pendo.io.f1.j.a(objG.toString(), false);
                }
                if (objG instanceof Boolean) {
                    return sdk.pendo.io.f1.j.a((CharSequence) objG.toString());
                }
                if (objG == null) {
                    return k.a;
                }
                if (aVar.a().f().e(objG)) {
                    cVarG = aVar.a().g();
                    genericDeclaration = List.class;
                    aVarA = aVar.a();
                } else {
                    if (!aVar.a().f().a(objG)) {
                        throw new sdk.pendo.io.d1.h("Could not convert " + objG.toString() + " to a ValueNode");
                    }
                    cVarG = aVar.a().g();
                    genericDeclaration = Map.class;
                    aVarA = aVar.a();
                }
                return sdk.pendo.io.f1.j.a(cVarG.a(objG, genericDeclaration, aVarA));
            } catch (sdk.pendo.io.d1.k unused2) {
                return k.d;
            }
        }

        @Override // sdk.pendo.io.f1.j
        public f e() {
            return this;
        }

        @Override // sdk.pendo.io.f1.j
        public boolean n() {
            return true;
        }

        public boolean s() {
            return this.b;
        }

        public boolean t() {
            return this.c;
        }

        public String toString() {
            return (!this.b || this.c) ? this.a.toString() : sdk.pendo.io.e1.i.a("!", this.a.toString());
        }

        f(sdk.pendo.io.e1.g gVar, boolean z, boolean z2) {
            this.a = gVar;
            this.b = z;
            this.c = z2;
            d.b("PathNode {} existsCheck: {}", gVar, Boolean.valueOf(z));
        }

        @Override // sdk.pendo.io.f1.j
        public Class<?> a(l.a aVar) {
            return Void.class;
        }
    }

    public static class g extends sdk.pendo.io.f1.j {
        private final String a;
        private final Pattern b;
        private final String c;

        g(CharSequence charSequence) {
            String string = charSequence.toString();
            int iIndexOf = string.indexOf(47);
            int iLastIndexOf = string.lastIndexOf(47);
            String strSubstring = string.substring(iIndexOf + 1, iLastIndexOf);
            this.a = strSubstring;
            int i = iLastIndexOf + 1;
            String strSubstring2 = string.length() > i ? string.substring(i) : "";
            this.c = strSubstring2;
            this.b = Pattern.compile(strSubstring, sdk.pendo.io.f1.g.a(strSubstring2.toCharArray()));
        }

        @Override // sdk.pendo.io.f1.j
        public Class<?> a(l.a aVar) {
            return Void.TYPE;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            Pattern pattern = this.b;
            return pattern == null ? gVar.b == null : pattern.equals(gVar.b);
        }

        @Override // sdk.pendo.io.f1.j
        public g f() {
            return this;
        }

        @Override // sdk.pendo.io.f1.j
        public boolean o() {
            return true;
        }

        Pattern s() {
            return this.b;
        }

        public String toString() {
            return !this.a.startsWith("/") ? "/" + this.a + "/" + this.c : this.a;
        }

        g(Pattern pattern) {
            this.a = pattern.pattern();
            this.b = pattern;
            this.c = sdk.pendo.io.f1.g.a(pattern.flags());
        }
    }

    public static class h extends sdk.pendo.io.f1.j {
    }

    public static class i extends sdk.pendo.io.f1.j {
        private final String a;
        private boolean b;

        i(CharSequence charSequence, boolean z) {
            String string;
            this.b = true;
            if (!z || charSequence.length() <= 1) {
                string = charSequence.toString();
            } else {
                char cCharAt = charSequence.charAt(0);
                char cCharAt2 = charSequence.charAt(charSequence.length() - 1);
                if (cCharAt == '\'' && cCharAt2 == '\'') {
                    charSequence = charSequence.subSequence(1, charSequence.length() - 1);
                } else if (cCharAt == '\"' && cCharAt2 == '\"') {
                    charSequence = charSequence.subSequence(1, charSequence.length() - 1);
                    this.b = false;
                }
                string = sdk.pendo.io.e1.i.a(charSequence.toString());
            }
            this.a = string;
        }

        public boolean a(String str) {
            return s().contains(str);
        }

        @Override // sdk.pendo.io.f1.j
        public e d() {
            try {
                return new e(new BigDecimal(this.a));
            } catch (NumberFormatException unused) {
                return e.b;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i) && !(obj instanceof e) && !(obj instanceof a)) {
                return false;
            }
            i iVar = obj instanceof a ? new i(((a) obj).a.toString(), false) : ((sdk.pendo.io.f1.j) obj).h();
            String str = this.a;
            return str == null ? iVar.s() == null : str.equals(iVar.s());
        }

        @Override // sdk.pendo.io.f1.j
        public i h() {
            return this;
        }

        public boolean isEmpty() {
            return s().isEmpty();
        }

        @Override // sdk.pendo.io.f1.j
        public boolean p() {
            return true;
        }

        public String s() {
            return this.a;
        }

        public int t() {
            return s().length();
        }

        public String toString() {
            String str = this.b ? "'" : "\"";
            return str + sdk.pendo.io.e1.i.a(this.a, true) + str;
        }

        @Override // sdk.pendo.io.f1.j
        public Class<?> a(l.a aVar) {
            return String.class;
        }
    }

    public static class j extends sdk.pendo.io.f1.j {
        @Override // sdk.pendo.io.f1.j
        public Class<?> a(l.a aVar) {
            return Void.class;
        }

        public boolean equals(Object obj) {
            return false;
        }

        @Override // sdk.pendo.io.f1.j
        public boolean q() {
            return true;
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.f1.k$k, reason: collision with other inner class name */
    public static class C0383k extends sdk.pendo.io.f1.j implements Iterable<sdk.pendo.io.f1.j> {
        private List<sdk.pendo.io.f1.j> a = new ArrayList();

        public C0383k(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                this.a.add(sdk.pendo.io.f1.j.d(it.next()));
            }
        }

        public boolean a(sdk.pendo.io.f1.j jVar) {
            return this.a.contains(jVar);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof C0383k) {
                return this.a.equals(((C0383k) obj).a);
            }
            return false;
        }

        @Override // sdk.pendo.io.f1.j
        public C0383k i() {
            return this;
        }

        @Override // java.lang.Iterable
        public Iterator<sdk.pendo.io.f1.j> iterator() {
            return this.a.iterator();
        }

        @Override // sdk.pendo.io.f1.j
        public boolean r() {
            return true;
        }

        public String toString() {
            return "[" + sdk.pendo.io.e1.i.a(",", this.a) + "]";
        }

        public boolean a(C0383k c0383k) {
            Iterator<sdk.pendo.io.f1.j> it = this.a.iterator();
            while (it.hasNext()) {
                if (!c0383k.a.contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // sdk.pendo.io.f1.j
        public Class<?> a(l.a aVar) {
            return List.class;
        }
    }

    static {
        a = new d();
        b = new a(TelemetryEventStrings.Value.TRUE);
        c = new a("false");
    }
}
