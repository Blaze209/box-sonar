package sdk.pendo.io.r0;

import java.security.Key;
import org.jose4j.jwe.KeyManagementAlgorithmIdentifiers;
import org.jose4j.jwk.OctetSequenceJsonWebKey;

/* JADX INFO: loaded from: classes4.dex */
public class l extends sdk.pendo.io.q0.f implements p {
    public l() {
        a(KeyManagementAlgorithmIdentifiers.DIRECT);
        a(sdk.pendo.io.y0.h.SYMMETRIC);
        c(OctetSequenceJsonWebKey.KEY_TYPE);
    }

    private void b(Key key, g gVar) throws sdk.pendo.io.a1.f {
        int length;
        int iB;
        sdk.pendo.io.x0.d.b(key);
        if (key.getEncoded() != null && (iB = gVar.b().b()) != (length = key.getEncoded().length)) {
            throw new sdk.pendo.io.a1.f("Invalid key for " + c() + " with " + gVar.c() + ", expected a " + sdk.pendo.io.a1.a.a(iB) + " bit key but a " + sdk.pendo.io.a1.a.a(length) + " bit key was provided.");
        }
    }

    @Override // sdk.pendo.io.r0.p
    public Key a(sdk.pendo.io.q0.g gVar, byte[] bArr, i iVar, sdk.pendo.io.x0.b bVar, sdk.pendo.io.m0.a aVar) throws sdk.pendo.io.a1.f {
        Key keyB = gVar.b();
        if (bArr.length == 0) {
            return keyB;
        }
        throw new sdk.pendo.io.a1.f("An empty octet sequence is to be used as the JWE Encrypted Key value when utilizing direct encryption but this JWE has " + bArr.length + " octets in the encrypted key part.");
    }

    @Override // sdk.pendo.io.q0.a
    public boolean d() {
        return true;
    }

    @Override // sdk.pendo.io.r0.p
    public sdk.pendo.io.q0.g a(Key key, sdk.pendo.io.x0.b bVar, sdk.pendo.io.m0.a aVar) {
        return new sdk.pendo.io.q0.g(key);
    }

    @Override // sdk.pendo.io.r0.p
    public void a(Key key, g gVar) throws sdk.pendo.io.a1.f {
        b(key, gVar);
    }
}
