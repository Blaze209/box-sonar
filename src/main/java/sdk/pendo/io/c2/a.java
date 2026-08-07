package sdk.pendo.io.c2;

/* JADX INFO: loaded from: classes4.dex */
public final class a<L, R> extends b<L, R> {
    public static final a<?, ?>[] d = new a[0];
    private static final a e = b(null, null);
    public final L b;
    public final R c;

    public a(L l, R r) {
        this.b = l;
        this.c = r;
    }

    @Override // sdk.pendo.io.c2.b
    public L a() {
        return this.b;
    }

    @Override // sdk.pendo.io.c2.b
    public R b() {
        return this.c;
    }

    @Override // java.util.Map.Entry
    public R setValue(R r) {
        throw new UnsupportedOperationException();
    }

    public static <L, R> a<L, R> b(L l, R r) {
        return new a<>(l, r);
    }
}
