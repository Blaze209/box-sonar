package sdk.pendo.io.a;

/* JADX INFO: loaded from: classes4.dex */
public abstract class u {
    protected final int a;
    protected u b;

    public u(int i) {
        this(i, null);
    }

    public abstract a a();

    public abstract a a(int i, String str, boolean z);

    public abstract a a(int i, e0 e0Var, String str, boolean z);

    public abstract a a(int i, e0 e0Var, s[] sVarArr, s[] sVarArr2, int[] iArr, String str, boolean z);

    public abstract a a(String str, boolean z);

    public abstract void a(int i);

    public abstract void a(int i, int i2);

    public abstract void a(int i, int i2, s sVar, s... sVarArr);

    public abstract void a(int i, int i2, Object[] objArr, int i3, Object[] objArr2);

    public abstract void a(int i, String str);

    public abstract void a(int i, String str, String str2, String str3);

    public abstract void a(int i, String str, String str2, String str3, boolean z);

    public abstract void a(int i, s sVar);

    public abstract void a(int i, boolean z);

    public abstract void a(Object obj);

    public abstract void a(String str, int i);

    public abstract void a(String str, String str2, String str3, s sVar, s sVar2, int i);

    public abstract void a(String str, String str2, q qVar, Object... objArr);

    public abstract void a(c cVar);

    public abstract void a(s sVar);

    public abstract void a(s sVar, s sVar2, s sVar3, String str);

    public abstract void a(s sVar, int[] iArr, s[] sVarArr);

    public abstract a b(int i, e0 e0Var, String str, boolean z);

    public abstract void b();

    public abstract void b(int i, int i2);

    public abstract void b(int i, s sVar);

    public abstract void b(String str, int i);

    public abstract a c(int i, e0 e0Var, String str, boolean z);

    public abstract void c();

    public abstract void c(int i, int i2);

    public abstract void d(int i, int i2);

    public u(int i, u uVar) {
        if (i != 589824 && i != 524288 && i != 458752 && i != 393216 && i != 327680 && i != 262144 && i != 17432576) {
            throw new IllegalArgumentException("Unsupported api " + i);
        }
        if (i == 17432576) {
            j.a(this);
        }
        this.a = i;
        this.b = uVar;
    }
}
