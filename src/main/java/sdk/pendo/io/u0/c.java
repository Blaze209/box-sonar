package sdk.pendo.io.u0;

import java.security.PublicKey;
import java.security.interfaces.EdECPublicKey;

/* JADX INFO: loaded from: classes5.dex */
public class c extends a {
    public c() {
        super("EdDSA", "EdDSA", "OKP");
    }

    @Override // sdk.pendo.io.u0.a
    public void a(PublicKey publicKey) throws sdk.pendo.io.a1.f {
        sdk.pendo.io.x0.d.a(publicKey, EdECPublicKey.class);
    }
}
