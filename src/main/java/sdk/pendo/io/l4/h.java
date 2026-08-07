package sdk.pendo.io.l4;

import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class h extends RuntimeException {
    private final int a;
    private final String b;
    private final transient r<?> c;

    public h(r<?> rVar) {
        super(a(rVar));
        this.a = rVar.b();
        this.b = rVar.e();
        this.c = rVar;
    }

    private static String a(r<?> rVar) {
        Objects.requireNonNull(rVar, "response == null");
        return "HTTP " + rVar.b() + " " + rVar.e();
    }
}
