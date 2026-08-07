package external.sdk.pendo.io.jose4j.jwt.consumer;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class e implements b {
    private Set<String> a;
    private boolean b;

    public e(String str, boolean z) {
        if (str != null) {
            this.a = Collections.singleton(str);
        }
        this.b = z;
    }

    private String a() {
        return this.a.size() == 1 ? this.a.iterator().next() : "one of " + this.a;
    }

    @Override // external.sdk.pendo.io.jose4j.jwt.consumer.b
    public b.a a(g gVar) {
        String strD = gVar.c().d();
        if (strD == null) {
            if (this.b) {
                return new b.a(11, "No Issuer (iss) claim present.");
            }
            return null;
        }
        Set<String> set = this.a;
        if (set == null || set.contains(strD)) {
            return null;
        }
        return new b.a(12, "Issuer (iss) claim value (" + strD + ") doesn't match expected value of " + a());
    }
}
