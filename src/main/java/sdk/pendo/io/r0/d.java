package sdk.pendo.io.r0;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import org.jose4j.jwe.KeyManagementAlgorithmIdentifiers;
import org.jose4j.jwk.OctetSequenceJsonWebKey;

/* JADX INFO: loaded from: classes4.dex */
public class d extends t {
    int i;

    public static class a extends d {
        public a() {
            super(KeyManagementAlgorithmIdentifiers.A128KW, 16);
        }
    }

    public static class b extends d {
        public b() {
            super(KeyManagementAlgorithmIdentifiers.A192KW, 24);
        }
    }

    public static class c extends d {
        public c() {
            super(KeyManagementAlgorithmIdentifiers.A256KW, 32);
        }
    }

    public d(String str, int i) {
        super("AESWrap", str);
        c(OctetSequenceJsonWebKey.KEY_TYPE);
        a(sdk.pendo.io.y0.h.SYMMETRIC);
        this.i = i;
    }

    @Override // sdk.pendo.io.r0.p
    public void a(Key key, g gVar) throws sdk.pendo.io.a1.f {
        b(key);
    }

    void b(Key key) throws sdk.pendo.io.a1.f {
        sdk.pendo.io.x0.d.a(key, c(), f());
    }

    @Override // sdk.pendo.io.q0.a
    public boolean d() {
        int iF = f();
        String strE = e();
        try {
            Cipher.getInstance(strE);
            return e.a(strE, iF);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            this.f.a("{} for {} is not available ({}).", strE, c(), sdk.pendo.io.a1.b.a(e));
            return false;
        }
    }

    int f() {
        return this.i;
    }

    d g() {
        this.h = false;
        return this;
    }
}
