package external.sdk.pendo.io.jose4j.jwt.consumer;

/* JADX INFO: loaded from: classes4.dex */
public class f implements b {
    private static final b.a b = new b.a(13, "The JWT ID (jti) claim is not present.");
    private boolean a;

    public f(boolean z) {
        this.a = z;
    }

    @Override // external.sdk.pendo.io.jose4j.jwt.consumer.b
    public b.a a(g gVar) {
        if (gVar.c().e() == null && this.a) {
            return b;
        }
        return null;
    }
}
