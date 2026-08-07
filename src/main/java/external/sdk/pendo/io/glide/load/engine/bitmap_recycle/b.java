package external.sdk.pendo.io.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import sdk.pendo.io.y.l;

/* JADX INFO: loaded from: classes4.dex */
class b implements e {
    private final C0310b a = new C0310b();
    private final d<a, Bitmap> b = new d<>();

    static class a implements f {
        private final C0310b a;
        private int b;
        private int c;
        private Bitmap.Config d;

        public a(C0310b c0310b) {
            this.a = c0310b;
        }

        public void a(int i, int i2, Bitmap.Config config) {
            this.b = i;
            this.c = i2;
            this.d = config;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.b == aVar.b && this.c == aVar.c && this.d == aVar.d) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int i = ((this.b * 31) + this.c) * 31;
            Bitmap.Config config = this.d;
            return i + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return b.a(this.b, this.c, this.d);
        }

        @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.f
        public void a() {
            this.a.a(this);
        }
    }

    /* JADX INFO: renamed from: external.sdk.pendo.io.glide.load.engine.bitmap_recycle.b$b, reason: collision with other inner class name */
    static class C0310b extends c<a> {
        C0310b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a(this);
        }

        a a(int i, int i2, Bitmap.Config config) {
            a aVarB = b();
            aVarB.a(i, i2, config);
            return aVarB;
        }
    }

    b() {
    }

    static String a(int i, int i2, Bitmap.Config config) {
        return "[" + i + "x" + i2 + "], " + config;
    }

    @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.e
    public Bitmap get(int i, int i2, Bitmap.Config config) {
        return this.b.a(this.a.a(i, i2, config));
    }

    @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.e
    public int getSize(Bitmap bitmap) {
        return l.a(bitmap);
    }

    @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.e
    public String logBitmap(int i, int i2, Bitmap.Config config) {
        return a(i, i2, config);
    }

    @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.e
    public void put(Bitmap bitmap) {
        this.b.a(this.a.a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.e
    public Bitmap removeLast() {
        return this.b.a();
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.b;
    }

    private static String a(Bitmap bitmap) {
        return a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // external.sdk.pendo.io.glide.load.engine.bitmap_recycle.e
    public String logBitmap(Bitmap bitmap) {
        return a(bitmap);
    }
}
