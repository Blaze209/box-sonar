package sdk.pendo.io.y;

/* JADX INFO: loaded from: classes6.dex */
public final class f {

    /* JADX INFO: Add missing generic type declarations: [T] */
    class a<T> implements b<T> {
        private volatile T a;
        final /* synthetic */ b b;

        a(b bVar) {
            this.b = bVar;
        }

        @Override // sdk.pendo.io.y.f.b
        public T get() {
            if (this.a == null) {
                synchronized (this) {
                    if (this.a == null) {
                        this.a = (T) k.a(this.b.get());
                    }
                }
            }
            return this.a;
        }
    }

    public interface b<T> {
        T get();
    }

    public static <T> b<T> a(b<T> bVar) {
        return new a(bVar);
    }
}
