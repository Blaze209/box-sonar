package sdk.pendo.io.u0;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import org.jose4j.jwk.OctetSequenceJsonWebKey;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.mac.MacUtil;

/* JADX INFO: loaded from: classes5.dex */
public class d extends sdk.pendo.io.q0.f implements f {
    private int f;

    public static class a extends d {
        public a() {
            super("HS256", "HmacSHA256", 256);
        }
    }

    public static class b extends d {
        public b() {
            super(AlgorithmIdentifiers.HMAC_SHA384, MacUtil.HMAC_SHA384, 384);
        }
    }

    public static class c extends d {
        public c() {
            super(AlgorithmIdentifiers.HMAC_SHA512, MacUtil.HMAC_SHA512, 512);
        }
    }

    public d(String str, String str2, int i) {
        a(str);
        b(str2);
        a(sdk.pendo.io.y0.h.SYMMETRIC);
        c(OctetSequenceJsonWebKey.KEY_TYPE);
        this.f = i;
    }

    private Mac a(Key key, sdk.pendo.io.m0.a aVar) {
        return sdk.pendo.io.b1.a.a(e(), key, aVar.c().e());
    }

    void b(Key key) throws sdk.pendo.io.a1.f {
        int iA;
        if (key == null) {
            throw new sdk.pendo.io.a1.f("key is null");
        }
        if (key.getEncoded() != null && (iA = sdk.pendo.io.a1.a.a(key.getEncoded())) < this.f) {
            throw new sdk.pendo.io.a1.f("A key of the same size as the hash output (i.e. " + this.f + " bits for " + c() + ") or larger MUST be used with the HMAC SHA algorithms but this key is only " + iA + " bits");
        }
    }

    @Override // sdk.pendo.io.q0.a
    public boolean d() {
        try {
            Mac.getInstance(e());
            return true;
        } catch (NoSuchAlgorithmException unused) {
            return false;
        }
    }

    @Override // sdk.pendo.io.u0.f
    public void a(Key key) throws sdk.pendo.io.a1.f {
        b(key);
    }

    @Override // sdk.pendo.io.u0.f
    public boolean a(byte[] bArr, Key key, byte[] bArr2, sdk.pendo.io.m0.a aVar) throws sdk.pendo.io.a1.f {
        if (key instanceof SecretKey) {
            return sdk.pendo.io.a1.a.a(bArr, a(key, aVar).doFinal(bArr2));
        }
        throw new sdk.pendo.io.a1.f(key.getClass() + " cannot be used for HMAC verification.");
    }
}
