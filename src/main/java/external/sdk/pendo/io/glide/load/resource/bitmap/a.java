package external.sdk.pendo.io.glide.load.resource.bitmap;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {
    public static final a a = new C0316a();
    public static final a b = new b();
    public static final a c = new e();
    public static final a d = new c();
    public static final a e;
    public static final a f;
    public static final a g;
    public static final sdk.pendo.io.e.g<a> h;
    static final boolean i;

    /* JADX INFO: renamed from: external.sdk.pendo.io.glide.load.resource.bitmap.a$a, reason: collision with other inner class name */
    private static class C0316a extends a {
        C0316a() {
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.a
        public g a(int i, int i2, int i3, int i4) {
            return g.QUALITY;
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.a
        public float b(int i, int i2, int i3, int i4) {
            int iMin = Math.min(i2 / i4, i / i3);
            if (iMin == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(iMin);
        }
    }

    private static class b extends a {
        b() {
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.a
        public g a(int i, int i2, int i3, int i4) {
            return g.MEMORY;
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.a
        public float b(int i, int i2, int i3, int i4) {
            int iCeil = (int) Math.ceil(Math.max(i2 / i4, i / i3));
            int iMax = Math.max(1, Integer.highestOneBit(iCeil));
            return 1.0f / (iMax << (iMax >= iCeil ? 0 : 1));
        }
    }

    private static class c extends a {
        c() {
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.a
        public g a(int i, int i2, int i3, int i4) {
            return b(i, i2, i3, i4) == 1.0f ? g.QUALITY : a.c.a(i, i2, i3, i4);
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.a
        public float b(int i, int i2, int i3, int i4) {
            return Math.min(1.0f, a.c.b(i, i2, i3, i4));
        }
    }

    private static class d extends a {
        d() {
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.a
        public g a(int i, int i2, int i3, int i4) {
            return g.QUALITY;
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.a
        public float b(int i, int i2, int i3, int i4) {
            return Math.max(i3 / i, i4 / i2);
        }
    }

    private static class e extends a {
        e() {
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.a
        public g a(int i, int i2, int i3, int i4) {
            return a.i ? g.QUALITY : g.MEMORY;
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.a
        public float b(int i, int i2, int i3, int i4) {
            if (a.i) {
                return Math.min(i3 / i, i4 / i2);
            }
            int iMax = Math.max(i2 / i4, i / i3);
            if (iMax == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(iMax);
        }
    }

    private static class f extends a {
        f() {
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.a
        public g a(int i, int i2, int i3, int i4) {
            return g.QUALITY;
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.a
        public float b(int i, int i2, int i3, int i4) {
            return 1.0f;
        }
    }

    public enum g {
        MEMORY,
        QUALITY
    }

    static {
        d dVar = new d();
        e = dVar;
        f = new f();
        g = dVar;
        h = sdk.pendo.io.e.g.a("external.sdk.pendo.io.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", dVar);
        i = true;
    }

    public abstract g a(int i2, int i3, int i4, int i5);

    public abstract float b(int i2, int i3, int i4, int i5);
}
