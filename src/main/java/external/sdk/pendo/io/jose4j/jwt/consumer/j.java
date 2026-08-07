package external.sdk.pendo.io.jose4j.jwt.consumer;

/* JADX INFO: loaded from: classes4.dex */
public class j implements b {
    private static final b.a c = new b.a(14, "No Subject (sub) claim is present.");
    private boolean a;
    private String b;

    public j(String str) {
        this(true);
        this.b = str;
    }

    @Override // external.sdk.pendo.io.jose4j.jwt.consumer.b
    public b.a a(g gVar) {
        String strH = gVar.c().h();
        if (strH == null && this.a) {
            return c;
        }
        String str = this.b;
        if (str == null || str.equals(strH)) {
            return null;
        }
        return new b.a(15, "Subject (sub) claim value (" + strH + ") doesn't match expected value of " + this.b);
    }

    public j(boolean z) {
        this.a = z;
    }
}
