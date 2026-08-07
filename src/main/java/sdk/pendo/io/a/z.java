package sdk.pendo.io.a;

/* JADX INFO: loaded from: classes4.dex */
public abstract class z {
    protected final int a;
    z b;

    public z(int i) {
        this(i, null);
    }

    public abstract a a(int i, e0 e0Var, String str, boolean z);

    public abstract a a(String str, boolean z);

    public abstract void a();

    public abstract void a(c cVar);

    public z(int i, z zVar) {
        if (i != 589824 && i != 524288 && i != 458752 && i != 393216 && i != 327680 && i != 262144 && i != 17432576) {
            throw new IllegalArgumentException("Unsupported api " + i);
        }
        if (i == 17432576) {
            j.a(this);
        }
        this.a = i;
        this.b = zVar;
    }
}
