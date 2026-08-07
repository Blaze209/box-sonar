package sdk.pendo.io.y3;

/* JADX INFO: loaded from: classes6.dex */
public final class o<T> extends sdk.pendo.io.k3.j<T> {
    final T[] a;

    static final class a<T> extends sdk.pendo.io.u3.c<T> {
        final sdk.pendo.io.k3.o<? super T> a;
        final T[] b;
        int c;
        boolean d;
        volatile boolean e;

        a(sdk.pendo.io.k3.o<? super T> oVar, T[] tArr) {
            this.a = oVar;
            this.b = tArr;
        }

        @Override // sdk.pendo.io.t3.c
        public int a(int i) {
            if ((i & 1) == 0) {
                return 0;
            }
            this.d = true;
            return 1;
        }

        @Override // sdk.pendo.io.t3.g
        public void clear() {
            this.c = this.b.length;
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            this.e = true;
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return this.e;
        }

        @Override // sdk.pendo.io.t3.g
        public boolean isEmpty() {
            return this.c == this.b.length;
        }

        @Override // sdk.pendo.io.t3.g
        public T poll() {
            int i = this.c;
            T[] tArr = this.b;
            if (i == tArr.length) {
                return null;
            }
            this.c = i + 1;
            return (T) sdk.pendo.io.s3.b.a((Object) tArr[i], "The array element is null");
        }

        void a() {
            T[] tArr = this.b;
            int length = tArr.length;
            for (int i = 0; i < length && !isDisposed(); i++) {
                T t = tArr[i];
                if (t == null) {
                    this.a.onError(new NullPointerException("The element at index " + i + " is null"));
                    return;
                }
                this.a.onNext(t);
            }
            if (isDisposed()) {
                return;
            }
            this.a.onComplete();
        }
    }

    public o(T[] tArr) {
        this.a = tArr;
    }

    @Override // sdk.pendo.io.k3.j
    public void b(sdk.pendo.io.k3.o<? super T> oVar) {
        a aVar = new a(oVar, this.a);
        oVar.onSubscribe(aVar);
        if (aVar.d) {
            return;
        }
        aVar.a();
    }
}
