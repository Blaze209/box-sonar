package sdk.pendo.io.u0;

import java.security.Key;

/* JADX INFO: loaded from: classes5.dex */
public class h extends sdk.pendo.io.q0.f implements f {
    public h() {
        a("none");
        a(sdk.pendo.io.y0.h.NONE);
    }

    private void b(Key key) throws sdk.pendo.io.a1.f {
        if (key != null) {
            throw new sdk.pendo.io.a1.f("JWS Plaintext (alg=none) must not use a key.");
        }
    }

    @Override // sdk.pendo.io.u0.f
    public void a(Key key) throws sdk.pendo.io.a1.f {
        b(key);
    }

    @Override // sdk.pendo.io.q0.a
    public boolean d() {
        return true;
    }

    @Override // sdk.pendo.io.u0.f
    public boolean a(byte[] bArr, Key key, byte[] bArr2, sdk.pendo.io.m0.a aVar) throws sdk.pendo.io.a1.f {
        b(key);
        return bArr.length == 0;
    }
}
