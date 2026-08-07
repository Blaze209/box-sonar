package sdk.pendo.io.m1;

/* JADX INFO: loaded from: classes4.dex */
public class b {
    private static a a;

    public static a a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = b();
                }
            }
        }
        return a;
    }

    private static a b() {
        return new c(400);
    }
}
