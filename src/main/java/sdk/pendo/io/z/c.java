package sdk.pendo.io.z;

/* JADX INFO: loaded from: classes6.dex */
public abstract class c {

    private static class b extends c {
        private volatile boolean a;

        b() {
            super();
        }

        @Override // sdk.pendo.io.z.c
        public void a(boolean z) {
            this.a = z;
        }

        @Override // sdk.pendo.io.z.c
        public void b() {
            if (this.a) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    private c() {
    }

    public static c a() {
        return new b();
    }

    abstract void a(boolean z);

    public abstract void b();
}
