package sdk.pendo.io.l1;

/* JADX INFO: loaded from: classes4.dex */
public class e extends c {
    private static final sdk.pendo.io.v4.a g = sdk.pendo.io.v4.b.a((Class<?>) e.class);
    private final d f;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[d.a.values().length];
            a = iArr;
            try {
                iArr[d.a.SLICE_FROM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[d.a.SLICE_BETWEEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[d.a.SLICE_TO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    e(d dVar) {
        this.f = dVar;
    }

    private void b(String str, sdk.pendo.io.e1.h hVar, Object obj, g gVar) {
        int iD = gVar.d().d(obj);
        int iIntValue = this.f.a().intValue();
        int iMin = Math.min(iD, this.f.c().intValue());
        if (iIntValue >= iMin || iD == 0) {
            return;
        }
        g.a("Slice between indexes on array with length: {}. From index: {} to: {}. Input: {}", Integer.valueOf(iD), Integer.valueOf(iIntValue), Integer.valueOf(iMin), toString());
        while (iIntValue < iMin) {
            a(iIntValue, str, obj, gVar);
            iIntValue++;
        }
    }

    private void c(String str, sdk.pendo.io.e1.h hVar, Object obj, g gVar) {
        int iD = gVar.d().d(obj);
        int iIntValue = this.f.a().intValue();
        if (iIntValue < 0) {
            iIntValue += iD;
        }
        int iMax = Math.max(0, iIntValue);
        g.a("Slice from index on array with length: {}. From index: {} to: {}. Input: {}", Integer.valueOf(iD), Integer.valueOf(iMax), Integer.valueOf(iD - 1), toString());
        if (iD == 0 || iMax >= iD) {
            return;
        }
        while (iMax < iD) {
            a(iMax, str, obj, gVar);
            iMax++;
        }
    }

    private void d(String str, sdk.pendo.io.e1.h hVar, Object obj, g gVar) {
        int iD = gVar.d().d(obj);
        if (iD == 0) {
            return;
        }
        int iIntValue = this.f.c().intValue();
        if (iIntValue < 0) {
            iIntValue += iD;
        }
        int iMin = Math.min(iD, iIntValue);
        g.a("Slice to index on array with length: {}. From index: 0 to: {}. Input: {}", Integer.valueOf(iD), Integer.valueOf(iMin), toString());
        for (int i = 0; i < iMin; i++) {
            a(i, str, obj, gVar);
        }
    }

    @Override // sdk.pendo.io.l1.j
    public void a(String str, sdk.pendo.io.e1.h hVar, Object obj, g gVar) {
        if (c(str, obj, gVar)) {
            int i = a.a[this.f.b().ordinal()];
            if (i == 1) {
                c(str, hVar, obj, gVar);
            } else if (i == 2) {
                b(str, hVar, obj, gVar);
            } else {
                if (i != 3) {
                    return;
                }
                d(str, hVar, obj, gVar);
            }
        }
    }

    @Override // sdk.pendo.io.l1.j
    public boolean e() {
        return false;
    }

    @Override // sdk.pendo.io.l1.j
    public String a() {
        return this.f.toString();
    }
}
