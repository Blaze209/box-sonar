package sdk.pendo.io.t1;

import sdk.pendo.io.v1.k;

/* JADX INFO: loaded from: classes5.dex */
public class a {
    public static int c;
    private int a;
    private d b;

    static {
        c = System.getProperty("JSON_SMART_SIMPLE") != null ? 4032 : -1;
    }

    public a(int i) {
        this.a = i;
    }

    private d a() {
        if (this.b == null) {
            this.b = new d(this.a);
        }
        return this.b;
    }

    public Object a(String str) {
        return a().b(str);
    }

    public <T> T a(String str, k<T> kVar) {
        return (T) a().a(str, kVar);
    }
}
