package sdk.pendo.io.a;

import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;
import com.pspdfkit.ui.toolbar.ContextualToolbar;
import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.Token;

/* JADX INFO: loaded from: classes4.dex */
final class v extends u {
    private static final int[] c0 = {0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 2, 2, 1, 1, 1, 0, 0, 1, 2, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, -1, 0, -1, -1, -1, -1, -1, -2, -1, -2, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, -4, -3, -4, -3, -3, -3, -3, -1, -2, 1, 1, 1, 2, 2, 2, 0, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, -1, -2, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -2, -1, -2, -1, -2, 0, 1, 0, 1, -1, -1, 0, 0, 1, 1, -1, 0, -1, 0, 0, 0, -3, -1, -1, -3, -3, -1, -1, -1, -1, -1, -1, -2, -2, -2, -2, -2, -2, -2, -2, 0, 1, 0, -1, -1, -1, -2, -1, -2, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, -1, -1, 0, 0, -1, -1, 0, 0};
    private final int A;
    private b B;
    private b C;
    private int D;
    private b[] E;
    private int F;
    private b[] G;
    private b H;
    private b I;
    private d J;
    private int K;
    private d L;
    private c M;
    private final int N;
    private s O;
    private s P;
    private s Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int[] V;
    private int[] W;
    private boolean X;
    private boolean Y;
    private int Z;
    private int a0;
    private int b0;
    private final c0 c;
    private final int d;
    private final int e;
    private final String f;
    private final int g;
    private final String h;
    private int i;
    private int j;
    private final d k;
    private r l;
    private r m;
    private int n;
    private d o;
    private int p;
    private d q;
    private int r;
    private d s;
    private int t;
    private d u;
    private b v;
    private b w;
    private c x;
    private final int y;
    private final int[] z;

    v(c0 c0Var, int i, String str, String str2, String str3, String[] strArr, int i2) {
        super(589824);
        this.k = new d();
        this.c = c0Var;
        this.d = "<init>".equals(str) ? 262144 | i : i;
        this.e = c0Var.f(str);
        this.f = str;
        this.g = c0Var.f(str2);
        this.h = str2;
        this.A = str3 == null ? 0 : c0Var.f(str3);
        if (strArr == null || strArr.length <= 0) {
            this.y = 0;
            this.z = null;
        } else {
            int length = strArr.length;
            this.y = length;
            this.z = new int[length];
            for (int i3 = 0; i3 < this.y; i3++) {
                this.z[i3] = c0Var.a(strArr[i3]).a;
            }
        }
        this.N = i2;
        if (i2 != 0) {
            int iB = d0.b(str2) >> 2;
            iB = (i & 8) != 0 ? iB - 1 : iB;
            this.j = iB;
            this.T = iB;
            s sVar = new s();
            this.O = sVar;
            a(sVar);
        }
    }

    private void b(Object obj) {
        if (obj instanceof Integer) {
            this.u.b(((Integer) obj).intValue());
        } else if (obj instanceof String) {
            this.u.b(7).d(this.c.a((String) obj).a);
        } else {
            this.u.b(8).d(((s) obj).d);
        }
    }

    private void c(int i, s sVar) {
        s sVar2 = this.Q;
        sVar2.l = new m(i, sVar, sVar2.l);
    }

    private void d() {
        r rVar = this.l;
        while (true) {
            if (rVar == null) {
                break;
            }
            String str = rVar.e;
            int iA = p.a(this.c, str != null ? str : "java/lang/Throwable");
            s sVarA = rVar.c.a();
            sVarA.a = (short) (sVarA.a | 2);
            s sVarA2 = rVar.b.a();
            for (s sVarA3 = rVar.a.a(); sVarA3 != sVarA2; sVarA3 = sVarA3.k) {
                sVarA3.l = new m(iA, sVarA, sVarA3.l);
            }
            rVar = rVar.f;
        }
        p pVar = this.O.j;
        pVar.a(this.c, this.d, this.h, this.j);
        pVar.a(this);
        s sVar = this.O;
        sVar.m = s.n;
        int iMax = 0;
        while (sVar != s.n) {
            s sVar2 = sVar.m;
            sVar.m = null;
            sVar.a = (short) (sVar.a | 8);
            int iA2 = sVar.j.a() + sVar.h;
            if (iA2 > iMax) {
                iMax = iA2;
            }
            for (m mVar = sVar.l; mVar != null; mVar = mVar.c) {
                s sVarA4 = mVar.b.a();
                if (sVar.j.a(this.c, sVarA4.j, mVar.a) && sVarA4.m == null) {
                    sVarA4.m = sVar2;
                    sVar2 = sVarA4;
                }
            }
            sVar = sVar2;
        }
        for (s sVar3 = this.O; sVar3 != null; sVar3 = sVar3.k) {
            if ((sVar3.a & 10) == 10) {
                sVar3.j.a(this);
            }
            if ((sVar3.a & 8) == 0) {
                s sVar4 = sVar3.k;
                int i = sVar3.d;
                int i2 = (sVar4 == null ? this.k.b : sVar4.d) - 1;
                if (i2 >= i) {
                    for (int i3 = i; i3 < i2; i3++) {
                        this.k.a[i3] = 0;
                    }
                    this.k.a[i2] = ByteSourceJsonBootstrapper.UTF8_BOM_3;
                    this.W[a(i, 0, 1)] = p.a(this.c, "java/lang/Throwable");
                    k();
                    this.l = r.a(this.l, sVar3, sVar4);
                    iMax = Math.max(iMax, 1);
                }
            }
        }
        this.i = iMax;
    }

    /* JADX WARN: Code duplicated, block: B:45:0x009e  */
    /* JADX WARN: Code duplicated, block: B:52:0x00b1 A[PHI: r0 r6
      0x00b1: PHI (r0v9 sdk.pendo.io.a.s) = (r0v8 sdk.pendo.io.a.s), (r0v10 sdk.pendo.io.a.s) binds: [B:46:0x00a2, B:42:0x0099] A[DONT_GENERATE, DONT_INLINE]
      0x00b1: PHI (r6v4 sdk.pendo.io.a.m) = (r6v3 sdk.pendo.io.a.m), (r6v6 sdk.pendo.io.a.m) binds: [B:46:0x00a2, B:42:0x0099] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00a2 -> B:52:0x00b1). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private void e() {
        /*
            r8 = this;
            sdk.pendo.io.a.r r0 = r8.l
        L2:
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 == 0) goto L32
            sdk.pendo.io.a.s r2 = r0.c
            sdk.pendo.io.a.s r3 = r0.a
            sdk.pendo.io.a.s r4 = r0.b
        Ld:
            if (r3 == r4) goto L2f
            short r5 = r3.a
            r5 = r5 & 16
            if (r5 != 0) goto L1f
            sdk.pendo.io.a.m r5 = new sdk.pendo.io.a.m
            sdk.pendo.io.a.m r6 = r3.l
            r5.<init>(r1, r2, r6)
            r3.l = r5
            goto L2c
        L1f:
            sdk.pendo.io.a.m r5 = r3.l
            sdk.pendo.io.a.m r5 = r5.c
            sdk.pendo.io.a.m r6 = new sdk.pendo.io.a.m
            sdk.pendo.io.a.m r7 = r5.c
            r6.<init>(r1, r2, r7)
            r5.c = r6
        L2c:
            sdk.pendo.io.a.s r3 = r3.k
            goto Ld
        L2f:
            sdk.pendo.io.a.r r0 = r0.f
            goto L2
        L32:
            boolean r0 = r8.X
            r2 = 1
            if (r0 == 0) goto L7b
            sdk.pendo.io.a.s r0 = r8.O
            r0.a(r2)
            r0 = r2
            r3 = r0
        L3e:
            if (r0 > r3) goto L65
            sdk.pendo.io.a.s r4 = r8.O
        L42:
            if (r4 == 0) goto L61
            short r5 = r4.a
            r5 = r5 & 16
            if (r5 == 0) goto L5e
            short r5 = r4.i
            if (r5 != r0) goto L5e
            sdk.pendo.io.a.m r5 = r4.l
            sdk.pendo.io.a.m r5 = r5.c
            sdk.pendo.io.a.s r5 = r5.b
            short r6 = r5.i
            if (r6 != 0) goto L5e
            int r3 = r3 + 1
            short r3 = (short) r3
            r5.a(r3)
        L5e:
            sdk.pendo.io.a.s r4 = r4.k
            goto L42
        L61:
            int r0 = r0 + 1
            short r0 = (short) r0
            goto L3e
        L65:
            sdk.pendo.io.a.s r0 = r8.O
        L67:
            if (r0 == 0) goto L7b
            short r3 = r0.a
            r3 = r3 & 16
            if (r3 == 0) goto L78
            sdk.pendo.io.a.m r3 = r0.l
            sdk.pendo.io.a.m r3 = r3.c
            sdk.pendo.io.a.s r3 = r3.b
            r3.a(r0)
        L78:
            sdk.pendo.io.a.s r0 = r0.k
            goto L67
        L7b:
            sdk.pendo.io.a.s r0 = r8.O
            sdk.pendo.io.a.s r3 = sdk.pendo.io.a.s.n
            r0.m = r3
            int r3 = r8.i
        L83:
            sdk.pendo.io.a.s r4 = sdk.pendo.io.a.s.n
            if (r0 == r4) goto Lb4
            sdk.pendo.io.a.s r4 = r0.m
            short r5 = r0.f
            short r6 = r0.h
            int r6 = r6 + r5
            if (r6 <= r3) goto L91
            r3 = r6
        L91:
            sdk.pendo.io.a.m r6 = r0.l
            short r0 = r0.a
            r0 = r0 & 16
            if (r0 == 0) goto L9b
        L99:
            r0 = r4
            goto Lb1
        L9b:
            r0 = r4
        L9c:
            if (r6 == 0) goto L83
            sdk.pendo.io.a.s r4 = r6.b
            sdk.pendo.io.a.s r7 = r4.m
            if (r7 != 0) goto Lb1
            int r7 = r6.a
            if (r7 != r1) goto Laa
            r7 = r2
            goto Lab
        Laa:
            int r7 = r7 + r5
        Lab:
            short r7 = (short) r7
            r4.f = r7
            r4.m = r0
            goto L99
        Lb1:
            sdk.pendo.io.a.m r6 = r6.c
            goto L9c
        Lb4:
            r8.i = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.a.v.e():void");
    }

    private void g() {
        int i = this.N;
        if (i == 4) {
            s sVar = new s();
            sVar.j = new p(sVar);
            d dVar = this.k;
            sVar.a(dVar.a, dVar.b);
            this.P.k = sVar;
            this.P = sVar;
        } else {
            if (i != 1) {
                return;
            }
            this.Q.h = (short) this.S;
        }
        this.Q = null;
    }

    private void j() {
        char c;
        int i;
        int[] iArr = this.W;
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = 0;
        int i5 = 3;
        if (this.c.e() < 50) {
            this.u.d(this.W[0]).d(i2);
            int i6 = i2 + 3;
            e(3, i6);
            this.u.d(i3);
            e(i6, i3 + i6);
            return;
        }
        int i7 = this.t == 0 ? this.W[0] : (this.W[0] - this.V[0]) - 1;
        int i8 = this.V[1];
        int i9 = i2 - i8;
        if (i3 == 0) {
            switch (i9) {
                case -3:
                case -2:
                case -1:
                    c = 248;
                    break;
                case 0:
                    c = i7 >= 64 ? (char) 251 : (char) 0;
                    break;
                case 1:
                case 2:
                case 3:
                    c = 252;
                    break;
                default:
                    c = 255;
                    break;
            }
        } else if (i9 == 0 && i3 == 1) {
            c = i7 < 63 ? '@' : (char) 247;
        } else {
            c = 255;
        }
        if (c != 255) {
            int i10 = 3;
            while (true) {
                if (i4 >= i8 || i4 >= i2) {
                    i = i5;
                } else {
                    i = i5;
                    if (this.W[i10] != this.V[i10]) {
                        c = 255;
                    } else {
                        i10++;
                        i4++;
                        i5 = i;
                    }
                }
            }
        } else {
            i = i5;
        }
        if (c == 0) {
            this.u.b(i7);
            return;
        }
        if (c == '@') {
            this.u.b(i7 + 64);
            e(i2 + 3, i2 + 4);
            return;
        }
        if (c == 247) {
            this.u.b(247).d(i7);
            e(i2 + 3, i2 + 4);
            return;
        }
        if (c == 248) {
            this.u.b(i9 + 251).d(i7);
            return;
        }
        if (c == 251) {
            this.u.b(251).d(i7);
            return;
        }
        if (c == 252) {
            int i11 = i;
            this.u.b(i9 + 251).d(i7);
            e(i8 + i11, i2 + i11);
        } else {
            this.u.b(255).d(i7).d(i2);
            int i12 = i2 + 3;
            e(i, i12);
            this.u.d(i3);
            e(i12, i3 + i12);
        }
    }

    boolean a(e eVar, boolean z, boolean z2, int i, int i2, int i3) {
        if (eVar == this.c.f() && i == this.g && i2 == this.A) {
            if (z2 == ((this.d & 131072) != 0)) {
                if (z != (this.c.e() < 49 && (this.d & 4096) != 0)) {
                    return false;
                }
                if (i3 == 0) {
                    if (this.y != 0) {
                        return false;
                    }
                } else if (eVar.g(i3) == this.y) {
                    int i4 = i3 + 2;
                    for (int i5 = 0; i5 < this.y; i5++) {
                        if (eVar.g(i4) != this.z[i5]) {
                            return false;
                        }
                        i4 += 2;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // sdk.pendo.io.a.u
    public void b() {
    }

    @Override // sdk.pendo.io.a.u
    public void c() {
    }

    int f() {
        int iB;
        if (this.a0 != 0) {
            return this.b0 + 6;
        }
        int i = this.k.b;
        if (i <= 0) {
            iB = 8;
        } else {
            if (i > 65535) {
                throw new t(this.c.b(), this.f, this.h, this.k.b);
            }
            this.c.f("Code");
            iB = this.k.b + 16 + r.b(this.l) + 8;
            if (this.u != null) {
                this.c.f(this.c.e() >= 50 ? "StackMapTable" : "StackMap");
                iB += this.u.b + 8;
            }
            if (this.o != null) {
                this.c.f("LineNumberTable");
                iB += this.o.b + 8;
            }
            if (this.q != null) {
                this.c.f("LocalVariableTable");
                iB += this.q.b + 8;
            }
            if (this.s != null) {
                this.c.f("LocalVariableTypeTable");
                iB += this.s.b + 8;
            }
            b bVar = this.v;
            if (bVar != null) {
                iB += bVar.b("RuntimeVisibleTypeAnnotations");
            }
            b bVar2 = this.w;
            if (bVar2 != null) {
                iB += bVar2.b("RuntimeInvisibleTypeAnnotations");
            }
            c cVar = this.x;
            if (cVar != null) {
                c0 c0Var = this.c;
                d dVar = this.k;
                iB += cVar.a(c0Var, dVar.a, dVar.b, this.i, this.j);
            }
        }
        if (this.y > 0) {
            this.c.f("Exceptions");
            iB += (this.y * 2) + 8;
        }
        int iA = iB + c.a(this.c, this.d, this.A) + b.a(this.B, this.C, this.H, this.I);
        b[] bVarArr = this.E;
        if (bVarArr != null) {
            int length = this.D;
            if (length == 0) {
                length = bVarArr.length;
            }
            iA += b.a("RuntimeVisibleParameterAnnotations", bVarArr, length);
        }
        b[] bVarArr2 = this.G;
        if (bVarArr2 != null) {
            int length2 = this.F;
            if (length2 == 0) {
                length2 = bVarArr2.length;
            }
            iA += b.a("RuntimeInvisibleParameterAnnotations", bVarArr2, length2);
        }
        if (this.J != null) {
            this.c.f("AnnotationDefault");
            iA += this.J.b + 6;
        }
        if (this.L != null) {
            this.c.f("MethodParameters");
            iA += this.L.b + 7;
        }
        c cVar2 = this.M;
        return cVar2 != null ? iA + cVar2.a(this.c) : iA;
    }

    boolean h() {
        return this.Y;
    }

    boolean i() {
        return this.t > 0;
    }

    void k() {
        if (this.V != null) {
            if (this.u == null) {
                this.u = new d();
            }
            j();
            this.t++;
        }
        this.V = this.W;
        this.W = null;
    }

    private void e(int i, int i2) {
        while (i < i2) {
            p.a(this.c, this.W[i], this.u);
            i++;
        }
    }

    final void a(c.a aVar) {
        aVar.b(this.M);
        aVar.b(this.x);
    }

    @Override // sdk.pendo.io.a.u
    public void d(int i, int i2) {
        d dVar = this.k;
        this.Z = dVar.b;
        if (i2 < 4 && i != 169) {
            dVar.b((i < 54 ? ((i - 21) << 2) + 26 : ((i - 54) << 2) + 59) + i2);
        } else if (i2 >= 256) {
            dVar.b(196).b(i, i2);
        } else {
            dVar.a(i, i2);
        }
        s sVar = this.Q;
        if (sVar != null) {
            int i3 = this.N;
            if (i3 == 4 || i3 == 3) {
                sVar.j.a(i, i2, (b0) null, (c0) null);
            } else if (i == 169) {
                sVar.a = (short) (sVar.a | 64);
                sVar.g = (short) this.R;
                g();
            } else {
                int i4 = this.R + c0[i];
                if (i4 > this.S) {
                    this.S = i4;
                }
                this.R = i4;
            }
        }
        int i5 = this.N;
        if (i5 != 0) {
            int i6 = (i == 22 || i == 24 || i == 55 || i == 57) ? i2 + 2 : i2 + 1;
            if (i6 > this.j) {
                this.j = i6;
            }
        }
        if (i < 54 || i5 != 4 || this.l == null) {
            return;
        }
        a(new s());
    }

    void f(int i, int i2) {
        this.a0 = i + 6;
        this.b0 = i2 - 6;
    }

    void g(int i, int i2) {
        this.W[i] = i2;
    }

    void a(d dVar) {
        int iA;
        d dVar2 = dVar;
        boolean z = this.c.e() < 49;
        dVar2.d((~(z ? 4096 : 0)) & this.d).d(this.e).d(this.g);
        if (this.a0 != 0) {
            dVar2.a(this.c.f().c, this.a0, this.b0);
            return;
        }
        int iA2 = this.k.b > 0 ? 1 : 0;
        if (this.y > 0) {
            iA2++;
        }
        int i = this.d;
        if ((i & 4096) != 0 && z) {
            iA2++;
        }
        if (this.A != 0) {
            iA2++;
        }
        if ((131072 & i) != 0) {
            iA2++;
        }
        if (this.B != null) {
            iA2++;
        }
        if (this.C != null) {
            iA2++;
        }
        if (this.E != null) {
            iA2++;
        }
        if (this.G != null) {
            iA2++;
        }
        if (this.H != null) {
            iA2++;
        }
        if (this.I != null) {
            iA2++;
        }
        if (this.J != null) {
            iA2++;
        }
        if (this.L != null) {
            iA2++;
        }
        c cVar = this.M;
        if (cVar != null) {
            iA2 += cVar.a();
        }
        dVar2.d(iA2);
        int i2 = this.k.b;
        if (i2 > 0) {
            int iB = i2 + 10 + r.b(this.l);
            d dVar3 = this.u;
            if (dVar3 != null) {
                iB += dVar3.b + 8;
                iA = 1;
            } else {
                iA = 0;
            }
            d dVar4 = this.o;
            if (dVar4 != null) {
                iB += dVar4.b + 8;
                iA++;
            }
            d dVar5 = this.q;
            if (dVar5 != null) {
                iB += dVar5.b + 8;
                iA++;
            }
            d dVar6 = this.s;
            if (dVar6 != null) {
                iB += dVar6.b + 8;
                iA++;
            }
            b bVar = this.v;
            if (bVar != null) {
                iB += bVar.b("RuntimeVisibleTypeAnnotations");
                iA++;
            }
            b bVar2 = this.w;
            if (bVar2 != null) {
                iB += bVar2.b("RuntimeInvisibleTypeAnnotations");
                iA++;
            }
            c cVar2 = this.x;
            if (cVar2 != null) {
                c0 c0Var = this.c;
                d dVar7 = this.k;
                iB += cVar2.a(c0Var, dVar7.a, dVar7.b, this.i, this.j);
                iA += this.x.a();
            }
            d dVarC = dVar2.d(this.c.f("Code")).c(iB).d(this.i).d(this.j).c(this.k.b);
            d dVar8 = this.k;
            dVarC.a(dVar8.a, 0, dVar8.b);
            r.a(this.l, dVar2);
            dVar2.d(iA);
            if (this.u != null) {
                d dVarD = dVar2.d(this.c.f(this.c.e() >= 50 ? "StackMapTable" : "StackMap")).c(this.u.b + 2).d(this.t);
                d dVar9 = this.u;
                dVarD.a(dVar9.a, 0, dVar9.b);
            }
            if (this.o != null) {
                d dVarD2 = dVar2.d(this.c.f("LineNumberTable")).c(this.o.b + 2).d(this.n);
                d dVar10 = this.o;
                dVarD2.a(dVar10.a, 0, dVar10.b);
            }
            if (this.q != null) {
                d dVarD3 = dVar2.d(this.c.f("LocalVariableTable")).c(this.q.b + 2).d(this.p);
                d dVar11 = this.q;
                dVarD3.a(dVar11.a, 0, dVar11.b);
            }
            if (this.s != null) {
                d dVarD4 = dVar2.d(this.c.f("LocalVariableTypeTable")).c(this.s.b + 2).d(this.r);
                d dVar12 = this.s;
                dVarD4.a(dVar12.a, 0, dVar12.b);
            }
            b bVar3 = this.v;
            if (bVar3 != null) {
                bVar3.a(this.c.f("RuntimeVisibleTypeAnnotations"), dVar2);
            }
            b bVar4 = this.w;
            if (bVar4 != null) {
                bVar4.a(this.c.f("RuntimeInvisibleTypeAnnotations"), dVar2);
            }
            c cVar3 = this.x;
            if (cVar3 != null) {
                c0 c0Var2 = this.c;
                d dVar13 = this.k;
                cVar3.a(c0Var2, dVar13.a, dVar13.b, this.i, this.j, dVar);
                dVar2 = dVar;
            }
        }
        if (this.y > 0) {
            dVar2.d(this.c.f("Exceptions")).c((this.y * 2) + 2).d(this.y);
            for (int i3 : this.z) {
                dVar2.d(i3);
            }
        }
        c.a(this.c, this.d, this.A, dVar2);
        b.a(this.c, this.B, this.C, this.H, this.I, dVar2);
        if (this.E != null) {
            int iF = this.c.f("RuntimeVisibleParameterAnnotations");
            b[] bVarArr = this.E;
            int length = this.D;
            if (length == 0) {
                length = bVarArr.length;
            }
            b.a(iF, bVarArr, length, dVar2);
        }
        if (this.G != null) {
            int iF2 = this.c.f("RuntimeInvisibleParameterAnnotations");
            b[] bVarArr2 = this.G;
            int length2 = this.F;
            if (length2 == 0) {
                length2 = bVarArr2.length;
            }
            b.a(iF2, bVarArr2, length2, dVar2);
        }
        if (this.J != null) {
            d dVarC2 = dVar2.d(this.c.f("AnnotationDefault")).c(this.J.b);
            d dVar14 = this.J;
            dVarC2.a(dVar14.a, 0, dVar14.b);
        }
        if (this.L != null) {
            d dVarB = dVar2.d(this.c.f("MethodParameters")).c(this.L.b + 1).b(this.K);
            d dVar15 = this.L;
            dVarB.a(dVar15.a, 0, dVar15.b);
        }
        c cVar4 = this.M;
        if (cVar4 != null) {
            cVar4.a(this.c, dVar2);
        }
    }

    @Override // sdk.pendo.io.a.u
    public void b(int i, int i2) {
        d dVar = this.k;
        this.Z = dVar.b;
        if (i == 17) {
            dVar.b(i, i2);
        } else {
            dVar.a(i, i2);
        }
        s sVar = this.Q;
        if (sVar != null) {
            int i3 = this.N;
            if (i3 == 4 || i3 == 3) {
                sVar.j.a(i, i2, (b0) null, (c0) null);
            } else if (i != 188) {
                int i4 = this.R + 1;
                if (i4 > this.S) {
                    this.S = i4;
                }
                this.R = i4;
            }
        }
    }

    @Override // sdk.pendo.io.a.u
    public void c(int i, int i2) {
        int i3 = this.N;
        if (i3 == 4) {
            d();
            return;
        }
        if (i3 == 1) {
            e();
        } else if (i3 == 2) {
            this.i = this.S;
        } else {
            this.i = i;
            this.j = i2;
        }
    }

    @Override // sdk.pendo.io.a.u
    public void a(int i, boolean z) {
        if (z) {
            this.D = i;
        } else {
            this.F = i;
        }
    }

    @Override // sdk.pendo.io.a.u
    public void b(int i, s sVar) {
        if (this.o == null) {
            this.o = new d();
        }
        this.n++;
        this.o.d(sVar.d);
        this.o.d(i);
    }

    @Override // sdk.pendo.io.a.u
    public a c(int i, e0 e0Var, String str, boolean z) {
        if (z) {
            b bVarA = b.a(this.c, i, e0Var, str, this.H);
            this.H = bVarA;
            return bVarA;
        }
        b bVarA2 = b.a(this.c, i, e0Var, str, this.I);
        this.I = bVarA2;
        return bVarA2;
    }

    @Override // sdk.pendo.io.a.u
    public a a(String str, boolean z) {
        if (z) {
            b bVarA = b.a(this.c, str, this.B);
            this.B = bVarA;
            return bVarA;
        }
        b bVarA2 = b.a(this.c, str, this.C);
        this.C = bVarA2;
        return bVarA2;
    }

    @Override // sdk.pendo.io.a.u
    public void b(String str, int i) {
        if (this.L == null) {
            this.L = new d();
        }
        this.K++;
        this.L.d(str == null ? 0 : this.c.f(str)).d(i);
    }

    @Override // sdk.pendo.io.a.u
    public a a() {
        d dVar = new d();
        this.J = dVar;
        return new b(this.c, false, dVar, null);
    }

    @Override // sdk.pendo.io.a.u
    public a b(int i, e0 e0Var, String str, boolean z) {
        if (z) {
            b bVarA = b.a(this.c, i, e0Var, str, this.v);
            this.v = bVarA;
            return bVarA;
        }
        b bVarA2 = b.a(this.c, i, e0Var, str, this.w);
        this.w = bVarA2;
        return bVarA2;
    }

    @Override // sdk.pendo.io.a.u
    public void a(c cVar) {
        if (cVar.b()) {
            cVar.c = this.x;
            this.x = cVar;
        } else {
            cVar.c = this.M;
            this.M = cVar;
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x004a A[PHI: r4
      0x004a: PHI (r4v3 int) = (r4v1 int), (r4v4 int), (r4v4 int) binds: [B:26:0x0047, B:16:0x0035, B:17:0x0037] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:30:0x004e A[PHI: r4
      0x004e: PHI (r4v7 int) = (r4v2 int), (r4v2 int), (r4v8 int) binds: [B:20:0x003c, B:21:0x003e, B:13:0x0030] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // sdk.pendo.io.a.u
    public void a(int i, String str, String str2, String str3) {
        int i2;
        this.Z = this.k.b;
        b0 b0VarA = this.c.a(str, str2, str3);
        this.k.b(i, b0VarA.a);
        s sVar = this.Q;
        if (sVar != null) {
            int i3 = this.N;
            int i4 = 0;
            if (i3 == 4 || i3 == 3) {
                sVar.j.a(i, 0, b0VarA, this.c);
                return;
            }
            char cCharAt = str3.charAt(0);
            switch (i) {
                case 178:
                    i2 = this.R;
                    if (cCharAt == 'D' || cCharAt == 'J') {
                        i4 = 2;
                    } else {
                        i4 = 1;
                    }
                    break;
                case 179:
                    i2 = this.R;
                    if (cCharAt == 'D' || cCharAt == 'J') {
                        i4 = -2;
                    } else {
                        i4 = -1;
                    }
                    break;
                case 180:
                    i2 = this.R;
                    if (cCharAt == 'D' || cCharAt == 'J') {
                        i4 = 1;
                    }
                    break;
                default:
                    i2 = this.R;
                    if (cCharAt == 'D' || cCharAt == 'J') {
                        i4 = -3;
                    } else {
                        i4 = -2;
                    }
                    break;
            }
            int i5 = i2 + i4;
            if (i5 > this.S) {
                this.S = i5;
            }
            this.R = i5;
        }
    }

    @Override // sdk.pendo.io.a.u
    public void a(int i, int i2, Object[] objArr, int i3, Object[] objArr2) {
        int i4;
        d dVar;
        int i5 = this.N;
        if (i5 == 4) {
            return;
        }
        if (i5 == 3) {
            s sVar = this.Q;
            p pVar = sVar.j;
            if (pVar == null) {
                sVar.j = new l(sVar);
                this.Q.j.a(this.c, this.d, this.h, i2);
            } else if (i == -1) {
                pVar.a(this.c, i2, objArr, i3, objArr2);
            }
            this.Q.j.a(this);
        } else if (i == -1) {
            if (this.V == null) {
                int iB = d0.b(this.h) >> 2;
                p pVar2 = new p(new s());
                pVar2.a(this.c, this.d, this.h, iB);
                pVar2.a(this);
            }
            this.T = i2;
            int iA = a(this.k.b, i2, i3);
            int i6 = 0;
            while (i6 < i2) {
                this.W[iA] = p.a(this.c, objArr[i6]);
                i6++;
                iA++;
            }
            int i7 = 0;
            while (i7 < i3) {
                this.W[iA] = p.a(this.c, objArr2[i7]);
                i7++;
                iA++;
            }
            k();
        } else {
            if (this.c.e() < 50) {
                throw new IllegalArgumentException("Class versions V1_5 or less must use F_NEW frames.");
            }
            if (this.u == null) {
                this.u = new d();
                i4 = this.k.b;
            } else {
                i4 = (this.k.b - this.U) - 1;
                if (i4 < 0) {
                    if (i != 3) {
                        throw new IllegalStateException();
                    }
                    return;
                }
            }
            if (i == 0) {
                this.T = i2;
                this.u.b(255).d(i4).d(i2);
                for (int i8 = 0; i8 < i2; i8++) {
                    b(objArr[i8]);
                }
                this.u.d(i3);
                for (int i9 = 0; i9 < i3; i9++) {
                    b(objArr2[i9]);
                }
            } else if (i != 1) {
                int i10 = 251;
                if (i == 2) {
                    this.T -= i2;
                    dVar = this.u;
                    i10 = 251 - i2;
                } else if (i == 3) {
                    dVar = this.u;
                    if (i4 < 64) {
                        dVar.b(i4);
                    }
                } else {
                    if (i != 4) {
                        throw new IllegalArgumentException();
                    }
                    d dVar2 = this.u;
                    if (i4 < 64) {
                        dVar2.b(i4 + 64);
                    } else {
                        dVar2.b(247).d(i4);
                    }
                    b(objArr2[0]);
                }
                dVar.b(i10).d(i4);
            } else {
                this.T += i2;
                this.u.b(i2 + 251).d(i4);
                for (int i11 = 0; i11 < i2; i11++) {
                    b(objArr[i11]);
                }
            }
            this.U = this.k.b;
            this.t++;
        }
        if (this.N == 2) {
            this.R = i3;
            for (int i12 = 0; i12 < i3; i12++) {
                Object obj = objArr2[i12];
                if (obj == y.e || obj == y.d) {
                    this.R++;
                }
            }
            int i13 = this.R;
            if (i13 > this.S) {
                this.S = i13;
            }
        }
        this.i = Math.max(this.i, i3);
        this.j = Math.max(this.j, this.T);
    }

    int a(int i, int i2, int i3) {
        int i4 = i2 + 3 + i3;
        int[] iArr = this.W;
        if (iArr == null || iArr.length < i4) {
            this.W = new int[i4];
        }
        int[] iArr2 = this.W;
        iArr2[0] = i;
        iArr2[1] = i2;
        iArr2[2] = i3;
        return 3;
    }

    @Override // sdk.pendo.io.a.u
    public void a(int i, int i2) {
        int i3;
        int i4;
        d dVar = this.k;
        this.Z = dVar.b;
        if (i > 255 || i2 > 127 || i2 < -128) {
            dVar.b(196).b(Token.TARGET, i).d(i2);
        } else {
            dVar.b(Token.TARGET).a(i, i2);
        }
        s sVar = this.Q;
        if (sVar != null && ((i4 = this.N) == 4 || i4 == 3)) {
            sVar.j.a(Token.TARGET, i, (b0) null, (c0) null);
        }
        if (this.N == 0 || (i3 = i + 1) <= this.j) {
            return;
        }
        this.j = i3;
    }

    @Override // sdk.pendo.io.a.u
    public void a(int i) {
        d dVar = this.k;
        this.Z = dVar.b;
        dVar.b(i);
        s sVar = this.Q;
        if (sVar != null) {
            int i2 = this.N;
            if (i2 == 4 || i2 == 3) {
                sVar.j.a(i, 0, (b0) null, (c0) null);
            } else {
                int i3 = this.R + c0[i];
                if (i3 > this.S) {
                    this.S = i3;
                }
                this.R = i3;
            }
            if ((i < 172 || i > 177) && i != 191) {
                return;
            }
            g();
        }
    }

    @Override // sdk.pendo.io.a.u
    public a a(int i, e0 e0Var, String str, boolean z) {
        if (z) {
            b bVarA = b.a(this.c, (i & (-16776961)) | (this.Z << 8), e0Var, str, this.v);
            this.v = bVarA;
            return bVarA;
        }
        b bVarA2 = b.a(this.c, (i & (-16776961)) | (this.Z << 8), e0Var, str, this.w);
        this.w = bVarA2;
        return bVarA2;
    }

    @Override // sdk.pendo.io.a.u
    public void a(String str, String str2, q qVar, Object... objArr) {
        this.Z = this.k.b;
        b0 b0VarB = this.c.b(str, str2, qVar, objArr);
        this.k.b(ContextualToolbar.DRAG_BUTTON_ALPHA, b0VarB.a);
        this.k.d(0);
        s sVar = this.Q;
        if (sVar != null) {
            int i = this.N;
            if (i == 4 || i == 3) {
                sVar.j.a(ContextualToolbar.DRAG_BUTTON_ALPHA, 0, b0VarB, this.c);
                return;
            }
            int iA = b0VarB.a();
            int i2 = this.R + ((iA & 3) - (iA >> 2)) + 1;
            if (i2 > this.S) {
                this.S = i2;
            }
            this.R = i2;
        }
    }

    @Override // sdk.pendo.io.a.u
    public void a(int i, s sVar) {
        boolean z;
        d dVar = this.k;
        int i2 = dVar.b;
        this.Z = i2;
        int i3 = i >= 200 ? i - 33 : i;
        if ((sVar.a & 4) == 0 || sVar.d - i2 >= -32768) {
            if (i3 != i) {
                dVar.b(i);
                d dVar2 = this.k;
                sVar.a(dVar2, dVar2.b - 1, true);
            } else {
                dVar.b(i3);
                d dVar3 = this.k;
                sVar.a(dVar3, dVar3.b - 1, false);
            }
            z = false;
        } else {
            if (i3 == 167) {
                dVar.b(200);
            } else {
                if (i3 == 168) {
                    dVar.b(201);
                } else {
                    dVar.b(i3 >= 198 ? i3 ^ 1 : ((i3 + 1) ^ 1) - 1);
                    this.k.d(8);
                    this.k.b(220);
                    this.Y = true;
                    z = true;
                }
                d dVar4 = this.k;
                sVar.a(dVar4, dVar4.b - 1, true);
            }
            z = false;
            d dVar5 = this.k;
            sVar.a(dVar5, dVar5.b - 1, true);
        }
        s sVar2 = this.Q;
        if (sVar2 != null) {
            int i4 = this.N;
            s sVar3 = null;
            if (i4 == 4) {
                sVar2.j.a(i3, 0, (b0) null, (c0) null);
                s sVarA = sVar.a();
                sVarA.a = (short) (sVarA.a | 2);
                c(0, sVar);
                if (i3 != 167) {
                    sVar3 = new s();
                }
            } else if (i4 == 3) {
                sVar2.j.a(i3, 0, (b0) null, (c0) null);
            } else if (i4 == 2) {
                this.R += c0[i3];
            } else if (i3 == 168) {
                short s = sVar.a;
                if ((s & 32) == 0) {
                    sVar.a = (short) (s | 32);
                    this.X = true;
                }
                sVar2.a = (short) (sVar2.a | 16);
                c(this.R + 1, sVar);
                sVar3 = new s();
            } else {
                int i5 = this.R + c0[i3];
                this.R = i5;
                c(i5, sVar);
            }
            if (sVar3 != null) {
                if (z) {
                    sVar3.a = (short) (sVar3.a | 2);
                }
                a(sVar3);
            }
            if (i3 == 167) {
                g();
            }
        }
    }

    @Override // sdk.pendo.io.a.u
    public void a(s sVar) {
        boolean z = this.Y;
        d dVar = this.k;
        this.Y = z | sVar.a(dVar.a, dVar.b);
        short s = sVar.a;
        if ((s & 1) != 0) {
            return;
        }
        int i = this.N;
        if (i == 4) {
            s sVar2 = this.Q;
            if (sVar2 != null) {
                if (sVar.d == sVar2.d) {
                    sVar2.a = (short) (sVar2.a | (s & 2));
                    sVar.j = sVar2.j;
                    return;
                }
                c(0, sVar);
            }
            s sVar3 = this.P;
            if (sVar3 != null) {
                if (sVar.d == sVar3.d) {
                    sVar3.a = (short) (sVar3.a | (sVar.a & 2));
                    sVar.j = sVar3.j;
                    this.Q = sVar3;
                    return;
                }
                sVar3.k = sVar;
            }
            this.P = sVar;
            this.Q = sVar;
            sVar.j = new p(sVar);
            return;
        }
        if (i == 3) {
            s sVar4 = this.Q;
            if (sVar4 != null) {
                sVar4.j.a = sVar;
                return;
            }
        } else {
            if (i == 1) {
                s sVar5 = this.Q;
                if (sVar5 != null) {
                    sVar5.h = (short) this.S;
                    c(this.R, sVar);
                }
                this.Q = sVar;
                this.R = 0;
                this.S = 0;
                s sVar6 = this.P;
                if (sVar6 != null) {
                    sVar6.k = sVar;
                }
                this.P = sVar;
                return;
            }
            if (i != 2 || this.Q != null) {
                return;
            }
        }
        this.Q = sVar;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x004c  */
    /* JADX WARN: Code duplicated, block: B:40:? A[RETURN, SYNTHETIC] */
    @Override // sdk.pendo.io.a.u
    public void a(Object obj) {
        d dVar;
        int i;
        s sVar;
        int i2;
        char cCharAt;
        this.Z = this.k.b;
        b0 b0VarA = this.c.a(obj);
        int i3 = b0VarA.a;
        int i4 = b0VarA.b;
        boolean z = i4 == 5 || i4 == 6 || (i4 == 17 && ((cCharAt = b0VarA.e.charAt(0)) == 'J' || cCharAt == 'D'));
        if (!z) {
            if (i3 >= 256) {
                dVar = this.k;
                i = 19;
            } else {
                this.k.a(18, i3);
            }
            sVar = this.Q;
            if (sVar != null) {
                i2 = this.N;
                if (i2 != 4 || i2 == 3) {
                    sVar.j.a(18, 0, b0VarA, this.c);
                }
                int i5 = this.R + (z ? 2 : 1);
                if (i5 > this.S) {
                    this.S = i5;
                }
                this.R = i5;
                return;
            }
        }
        dVar = this.k;
        i = 20;
        dVar.b(i, i3);
        sVar = this.Q;
        if (sVar != null) {
            i2 = this.N;
            if (i2 != 4) {
            }
            sVar.j.a(18, 0, b0VarA, this.c);
        }
    }

    @Override // sdk.pendo.io.a.u
    public void a(String str, String str2, String str3, s sVar, s sVar2, int i) {
        if (str3 != null) {
            if (this.s == null) {
                this.s = new d();
            }
            this.r++;
            this.s.d(sVar.d).d(sVar2.d - sVar.d).d(this.c.f(str)).d(this.c.f(str3)).d(i);
        }
        if (this.q == null) {
            this.q = new d();
        }
        this.p++;
        this.q.d(sVar.d).d(sVar2.d - sVar.d).d(this.c.f(str)).d(this.c.f(str2)).d(i);
        if (this.N != 0) {
            char cCharAt = str2.charAt(0);
            int i2 = i + ((cCharAt == 'J' || cCharAt == 'D') ? 2 : 1);
            if (i2 > this.j) {
                this.j = i2;
            }
        }
    }

    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1104)
        	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1058)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(ConstructorVisitor.java:139)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:91)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:56)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    @Override // sdk.pendo.io.a.u
    public sdk.pendo.io.a.a a(
    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1104)
        	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1058)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(ConstructorVisitor.java:139)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:91)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:56)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r6v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:215)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:89)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
        */

    @Override // sdk.pendo.io.a.u
    public void a(s sVar, int[] iArr, s[] sVarArr) {
        d dVar = this.k;
        this.Z = dVar.b;
        dVar.b(171).a((byte[]) null, 0, (4 - (this.k.b % 4)) % 4);
        sVar.a(this.k, this.Z, true);
        this.k.c(sVarArr.length);
        for (int i = 0; i < sVarArr.length; i++) {
            this.k.c(iArr[i]);
            sVarArr[i].a(this.k, this.Z, true);
        }
        a(sVar, sVarArr);
    }

    @Override // sdk.pendo.io.a.u
    public void a(int i, String str, String str2, String str3, boolean z) {
        this.Z = this.k.b;
        b0 b0VarA = this.c.a(str, str2, str3, z);
        if (i == 185) {
            this.k.b(185, b0VarA.a).a(b0VarA.a() >> 2, 0);
        } else {
            this.k.b(i, b0VarA.a);
        }
        s sVar = this.Q;
        if (sVar != null) {
            int i2 = this.N;
            if (i2 == 4 || i2 == 3) {
                sVar.j.a(i, 0, b0VarA, this.c);
                return;
            }
            int iA = b0VarA.a();
            int i3 = (iA & 3) - (iA >> 2);
            int i4 = i == 184 ? this.R + i3 + 1 : this.R + i3;
            if (i4 > this.S) {
                this.S = i4;
            }
            this.R = i4;
        }
    }

    @Override // sdk.pendo.io.a.u
    public void a(String str, int i) {
        this.Z = this.k.b;
        b0 b0VarA = this.c.a(str);
        this.k.b(197, b0VarA.a).b(i);
        s sVar = this.Q;
        if (sVar != null) {
            int i2 = this.N;
            if (i2 == 4 || i2 == 3) {
                sVar.j.a(197, i, b0VarA, this.c);
            } else {
                this.R += 1 - i;
            }
        }
    }

    @Override // sdk.pendo.io.a.u
    public a a(int i, String str, boolean z) {
        if (z) {
            if (this.E == null) {
                this.E = new b[d0.a(this.h).length];
            }
            b[] bVarArr = this.E;
            b bVarA = b.a(this.c, str, bVarArr[i]);
            bVarArr[i] = bVarA;
            return bVarA;
        }
        if (this.G == null) {
            this.G = new b[d0.a(this.h).length];
        }
        b[] bVarArr2 = this.G;
        b bVarA2 = b.a(this.c, str, bVarArr2[i]);
        bVarArr2[i] = bVarA2;
        return bVarA2;
    }

    private void a(s sVar, s[] sVarArr) {
        s sVar2 = this.Q;
        if (sVar2 != null) {
            int i = this.N;
            if (i == 4) {
                sVar2.j.a(171, 0, (b0) null, (c0) null);
                c(0, sVar);
                s sVarA = sVar.a();
                sVarA.a = (short) (sVarA.a | 2);
                for (s sVar3 : sVarArr) {
                    c(0, sVar3);
                    s sVarA2 = sVar3.a();
                    sVarA2.a = (short) (sVarA2.a | 2);
                }
            } else if (i == 1) {
                int i2 = this.R - 1;
                this.R = i2;
                c(i2, sVar);
                for (s sVar4 : sVarArr) {
                    c(this.R, sVar4);
                }
            }
            g();
        }
    }

    @Override // sdk.pendo.io.a.u
    public void a(int i, int i2, s sVar, s... sVarArr) {
        d dVar = this.k;
        this.Z = dVar.b;
        dVar.b(Context.VERSION_1_7).a((byte[]) null, 0, (4 - (this.k.b % 4)) % 4);
        sVar.a(this.k, this.Z, true);
        this.k.c(i).c(i2);
        for (s sVar2 : sVarArr) {
            sVar2.a(this.k, this.Z, true);
        }
        a(sVar, sVarArr);
    }

    @Override // sdk.pendo.io.a.u
    public void a(s sVar, s sVar2, s sVar3, String str) {
        r rVar = new r(sVar, sVar2, sVar3, str != null ? this.c.a(str).a : 0, str);
        if (this.l == null) {
            this.l = rVar;
        } else {
            this.m.f = rVar;
        }
        this.m = rVar;
    }

    @Override // sdk.pendo.io.a.u
    public void a(int i, String str) {
        this.Z = this.k.b;
        b0 b0VarA = this.c.a(str);
        this.k.b(i, b0VarA.a);
        s sVar = this.Q;
        if (sVar != null) {
            int i2 = this.N;
            if (i2 == 4 || i2 == 3) {
                sVar.j.a(i, this.Z, b0VarA, this.c);
            } else if (i == 187) {
                int i3 = this.R + 1;
                if (i3 > this.S) {
                    this.S = i3;
                }
                this.R = i3;
            }
        }
    }
}
