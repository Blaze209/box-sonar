package sdk.pendo.io.a;

/* JADX INFO: loaded from: classes4.dex */
final class b extends a {
    private final c0 c;
    private final boolean d;
    private final d e;
    private final int f;
    private int g;
    private final b h;
    private b i;

    b(c0 c0Var, boolean z, d dVar, b bVar) {
        super(589824);
        this.c = c0Var;
        this.d = z;
        this.e = dVar;
        int i = dVar.b;
        this.f = i == 0 ? -1 : i - 2;
        this.h = bVar;
        if (bVar != null) {
            bVar.i = this;
        }
    }

    static int a(b bVar, b bVar2, b bVar3, b bVar4) {
        int iB = bVar != null ? bVar.b("RuntimeVisibleAnnotations") : 0;
        if (bVar2 != null) {
            iB += bVar2.b("RuntimeInvisibleAnnotations");
        }
        if (bVar3 != null) {
            iB += bVar3.b("RuntimeVisibleTypeAnnotations");
        }
        return bVar4 != null ? iB + bVar4.b("RuntimeInvisibleTypeAnnotations") : iB;
    }

    int b(String str) {
        if (str != null) {
            this.c.f(str);
        }
        int i = 8;
        while (this != null) {
            i += this.e.b;
            this = this.h;
        }
        return i;
    }

    static int a(String str, b[] bVarArr, int i) {
        int iB = (i * 2) + 7;
        for (int i2 = 0; i2 < i; i2++) {
            b bVar = bVarArr[i2];
            iB += bVar == null ? 0 : bVar.b(str) - 8;
        }
        return iB;
    }

    static b a(c0 c0Var, int i, e0 e0Var, String str, b bVar) {
        d dVar = new d();
        f0.a(i, dVar);
        e0.a(e0Var, dVar);
        dVar.d(c0Var.f(str)).d(0);
        return new b(c0Var, true, dVar, bVar);
    }

    static b a(c0 c0Var, String str, b bVar) {
        d dVar = new d();
        dVar.d(c0Var.f(str)).d(0);
        return new b(c0Var, true, dVar, bVar);
    }

    void a(int i, d dVar) {
        int i2 = 2;
        b bVar = null;
        int i3 = 0;
        while (this != null) {
            this.a();
            i2 += this.e.b;
            i3++;
            bVar = this;
            this = this.h;
        }
        dVar.d(i);
        dVar.c(i2);
        dVar.d(i3);
        while (bVar != null) {
            d dVar2 = bVar.e;
            dVar.a(dVar2.a, 0, dVar2.b);
            bVar = bVar.i;
        }
    }

    static void a(c0 c0Var, b bVar, b bVar2, b bVar3, b bVar4, d dVar) {
        if (bVar != null) {
            bVar.a(c0Var.f("RuntimeVisibleAnnotations"), dVar);
        }
        if (bVar2 != null) {
            bVar2.a(c0Var.f("RuntimeInvisibleAnnotations"), dVar);
        }
        if (bVar3 != null) {
            bVar3.a(c0Var.f("RuntimeVisibleTypeAnnotations"), dVar);
        }
        if (bVar4 != null) {
            bVar4.a(c0Var.f("RuntimeInvisibleTypeAnnotations"), dVar);
        }
    }

    static void a(int i, b[] bVarArr, int i2, d dVar) {
        int iB = (i2 * 2) + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            b bVar = bVarArr[i3];
            iB += bVar == null ? 0 : bVar.b(null) - 8;
        }
        dVar.d(i);
        dVar.c(iB);
        dVar.b(i2);
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = 0;
            b bVar2 = null;
            for (b bVar3 = bVarArr[i4]; bVar3 != null; bVar3 = bVar3.h) {
                bVar3.a();
                i5++;
                bVar2 = bVar3;
            }
            dVar.d(i5);
            while (bVar2 != null) {
                d dVar2 = bVar2.e;
                dVar.a(dVar2.a, 0, dVar2.b);
                bVar2 = bVar2.i;
            }
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // sdk.pendo.io.a.a
    public void a(String str, Object obj) {
        this.g++;
        if (this.d) {
            this.e.d(this.c.f(str));
        }
        if (obj instanceof String) {
            this.e.b(115, this.c.f((String) obj));
            return;
        }
        if (obj instanceof Byte) {
            this.e.b(66, this.c.a((int) ((Byte) obj).byteValue()).a);
            return;
        }
        if (obj instanceof Boolean) {
            this.e.b(90, this.c.a(((Boolean) obj).booleanValue() ? 1 : 0).a);
            return;
        }
        if (obj instanceof Character) {
            this.e.b(67, this.c.a((int) ((Character) obj).charValue()).a);
            return;
        }
        if (obj instanceof Short) {
            this.e.b(83, this.c.a((int) ((Short) obj).shortValue()).a);
            return;
        }
        if (obj instanceof d0) {
            this.e.b(99, this.c.f(((d0) obj).a()));
            return;
        }
        int i = 0;
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            this.e.b(91, bArr.length);
            int length = bArr.length;
            while (i < length) {
                this.e.b(66, this.c.a((int) bArr[i]).a);
                i++;
            }
            return;
        }
        if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            this.e.b(91, zArr.length);
            int length2 = zArr.length;
            while (i < length2) {
                this.e.b(90, this.c.a(zArr[i] ? 1 : 0).a);
                i++;
            }
            return;
        }
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            this.e.b(91, sArr.length);
            int length3 = sArr.length;
            while (i < length3) {
                this.e.b(83, this.c.a((int) sArr[i]).a);
                i++;
            }
            return;
        }
        if (obj instanceof char[]) {
            char[] cArr = (char[]) obj;
            this.e.b(91, cArr.length);
            int length4 = cArr.length;
            while (i < length4) {
                this.e.b(67, this.c.a((int) cArr[i]).a);
                i++;
            }
            return;
        }
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            this.e.b(91, iArr.length);
            int length5 = iArr.length;
            while (i < length5) {
                this.e.b(73, this.c.a(iArr[i]).a);
                i++;
            }
            return;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            this.e.b(91, jArr.length);
            int length6 = jArr.length;
            while (i < length6) {
                this.e.b(74, this.c.a(jArr[i]).a);
                i++;
            }
            return;
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            this.e.b(91, fArr.length);
            int length7 = fArr.length;
            while (i < length7) {
                this.e.b(70, this.c.a(fArr[i]).a);
                i++;
            }
            return;
        }
        if (!(obj instanceof double[])) {
            b0 b0VarA = this.c.a(obj);
            this.e.b(".s.IFJDCS".charAt(b0VarA.b), b0VarA.a);
            return;
        }
        double[] dArr = (double[]) obj;
        this.e.b(91, dArr.length);
        int length8 = dArr.length;
        while (i < length8) {
            this.e.b(68, this.c.a(dArr[i]).a);
            i++;
        }
    }

    @Override // sdk.pendo.io.a.a
    public a a(String str, String str2) {
        this.g++;
        if (this.d) {
            this.e.d(this.c.f(str));
        }
        this.e.b(64, this.c.f(str2)).d(0);
        return new b(this.c, true, this.e, null);
    }

    @Override // sdk.pendo.io.a.a
    public a a(String str) {
        this.g++;
        if (this.d) {
            this.e.d(this.c.f(str));
        }
        this.e.b(91, 0);
        return new b(this.c, false, this.e, null);
    }

    @Override // sdk.pendo.io.a.a
    public void a() {
        int i = this.f;
        if (i != -1) {
            byte[] bArr = this.e.a;
            int i2 = this.g;
            bArr[i] = (byte) (i2 >>> 8);
            bArr[i + 1] = (byte) i2;
        }
    }

    @Override // sdk.pendo.io.a.a
    public void a(String str, String str2, String str3) {
        this.g++;
        if (this.d) {
            this.e.d(this.c.f(str));
        }
        this.e.b(101, this.c.f(str2)).d(this.c.f(str3));
    }
}
