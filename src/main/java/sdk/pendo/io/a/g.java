package sdk.pendo.io.a;

/* JADX INFO: loaded from: classes4.dex */
public abstract class g {
    protected final int a;
    protected g b;

    public g(int i) {
        this(i, null);
    }

    public abstract a a(int i, e0 e0Var, String str, boolean z);

    public abstract a a(String str, boolean z);

    public abstract n a(int i, String str, String str2, String str3, Object obj);

    public abstract u a(int i, String str, String str2, String str3, String[] strArr);

    public abstract w a(String str, int i, String str2);

    public abstract void a();

    public abstract void a(int i, int i2, String str, String str2, String str3, String[] strArr);

    public abstract void a(String str);

    public abstract void a(String str, String str2);

    public abstract void a(String str, String str2, String str3);

    public abstract void a(String str, String str2, String str3, int i);

    public abstract void a(c cVar);

    public abstract z b(String str, String str2, String str3);

    public abstract void b(String str);

    public abstract void c(String str);

    public g(int i, g gVar) {
        if (i != 589824 && i != 524288 && i != 458752 && i != 393216 && i != 327680 && i != 262144 && i != 17432576) {
            throw new IllegalArgumentException("Unsupported api " + i);
        }
        if (i == 17432576) {
            j.a(this);
        }
        this.a = i;
        this.b = gVar;
    }
}
