package sdk.pendo.io.x0;

import java.security.Key;
import java.security.interfaces.RSAKey;
import sdk.pendo.io.a1.f;

/* JADX INFO: loaded from: classes6.dex */
public class d {
    public static <K extends Key> K a(Key key, Class<K> cls) throws f {
        b(key);
        try {
            return cls.cast(key);
        } catch (ClassCastException e) {
            throw new f("Invalid key " + e);
        }
    }

    public static void b(Key key) throws f {
        if (key == null) {
            throw new f("The key must not be null.");
        }
    }

    public static void a(Key key) throws f {
        int iBitLength;
        if (key == null) {
            throw new f("The RSA key must not be null.");
        }
        if ((key instanceof RSAKey) && (iBitLength = ((RSAKey) key).getModulus().bitLength()) < 2048) {
            throw new f("An RSA key of size 2048 bits or larger MUST be used with the all JOSE RSA algorithms (given key was only " + iBitLength + " bits).");
        }
    }

    public static void a(Key key, String str, int i) throws f {
        int length;
        b(key);
        String algorithm = key.getAlgorithm();
        if (!"AES".equals(algorithm)) {
            throw new f("Invalid key for JWE " + str + ", expected an AES key but an " + algorithm + " key was provided.");
        }
        if (key.getEncoded() != null && (length = key.getEncoded().length) != i) {
            throw new f("Invalid key for JWE " + str + ", expected a " + sdk.pendo.io.a1.a.a(i) + " bit key but a " + sdk.pendo.io.a1.a.a(length) + " bit key was provided.");
        }
    }
}
