package external.sdk.pendo.io.jose4j.jwt.consumer;

/* JADX INFO: loaded from: classes4.dex */
public class h implements b {
    private static final b.a i = new b.a(2, "No Expiration Time (exp) claim present.");
    private static final b.a j = new b.a(3, "No Issued At (iat) claim present.");
    private static final b.a k = new b.a(4, "No Not Before (nbf) claim present.");
    private boolean a;
    private boolean b;
    private boolean c;
    private sdk.pendo.io.v0.d d;
    private int e = 0;
    private int f = 0;
    private Integer g;
    private Integer h;

    private String a() {
        return this.e > 0 ? " (even when providing " + this.e + " seconds of leeway to account for clock skew)." : ".";
    }

    @Override // external.sdk.pendo.io.jose4j.jwt.consumer.b
    public b.a a(g gVar) {
        sdk.pendo.io.v0.b bVarC = gVar.c();
        sdk.pendo.io.v0.d dVarB = bVarC.b();
        sdk.pendo.io.v0.d dVarC = bVarC.c();
        sdk.pendo.io.v0.d dVarF = bVarC.f();
        if (this.a && dVarB == null) {
            return i;
        }
        if (this.b && dVarC == null) {
            return j;
        }
        if (this.c && dVarF == null) {
            return k;
        }
        sdk.pendo.io.v0.d dVarD = this.d;
        if (dVarD == null) {
            dVarD = sdk.pendo.io.v0.d.d();
        }
        if (dVarB != null) {
            if (sdk.pendo.io.a1.i.b(dVarD.b(), this.e) >= dVarB.b()) {
                return new b.a(1, "The JWT is no longer valid - the evaluation time " + dVarD + " is on or after the Expiration Time (exp=" + dVarB + ") claim value" + a());
            }
            if (dVarC != null && dVarB.a(dVarC)) {
                return new b.a(17, "The Expiration Time (exp=" + dVarB + ") claim value cannot be before the Issued At (iat=" + dVarC + ") claim value.");
            }
            if (dVarF != null && dVarB.a(dVarF)) {
                return new b.a(17, "The Expiration Time (exp=" + dVarB + ") claim value cannot be before the Not Before (nbf=" + dVarF + ") claim value.");
            }
            if (this.f > 0 && sdk.pendo.io.a1.i.b(sdk.pendo.io.a1.i.b(dVarB.b(), this.e), dVarD.b()) > ((long) this.f) * 60) {
                return new b.a(5, "The Expiration Time (exp=" + dVarB + ") claim value cannot be more than " + this.f + " minutes in the future relative to the evaluation time " + dVarD + a());
            }
        }
        if (dVarF != null && sdk.pendo.io.a1.i.a(dVarD.b(), this.e) < dVarF.b()) {
            return new b.a(6, "The JWT is not yet valid as the evaluation time " + dVarD + " is before the Not Before (nbf=" + dVarF + ") claim time" + a());
        }
        if (dVarC == null) {
            return null;
        }
        if (this.g != null && sdk.pendo.io.a1.i.b(sdk.pendo.io.a1.i.b(dVarC.b(), dVarD.b()), this.e) > this.g.intValue()) {
            return new b.a(23, "iat " + dVarC + " is more than " + this.g + " second(s) ahead of now " + dVarD + a());
        }
        if (this.h == null || sdk.pendo.io.a1.i.b(sdk.pendo.io.a1.i.b(dVarD.b(), dVarC.b()), this.e) <= this.h.intValue()) {
            return null;
        }
        return new b.a(24, "As of now " + dVarD + " iat " + dVarC + " is more than " + this.h + " second(s) in the past" + a());
    }
}
