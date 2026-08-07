package sdk.pendo.io.y0;

import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.NamedParameterSpec;

/* JADX INFO: loaded from: classes6.dex */
public abstract class i extends g {
    public i(String str, SecureRandom secureRandom) {
        super(str, secureRandom);
    }

    public abstract PrivateKey a(byte[] bArr, String str);

    NamedParameterSpec a(String str) {
        try {
            return new NamedParameterSpec(str);
        } catch (NoClassDefFoundError e) {
            throw new sdk.pendo.io.a1.g(str + " NamedParameterSpec not available. " + sdk.pendo.io.a1.b.a(e));
        }
    }

    public abstract byte[] a(Key key);

    public abstract byte[] a(PrivateKey privateKey);

    public abstract PublicKey b(byte[] bArr, String str);

    public static i a(String str, String str2, SecureRandom secureRandom) {
        if (str.equals("Ed25519") || str.equals("Ed448")) {
            return new d(str2, secureRandom);
        }
        if (str.equals("X25519") || str.equals("X448")) {
            return new l(str2, secureRandom);
        }
        return null;
    }
}
