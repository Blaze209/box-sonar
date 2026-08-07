package sdk.pendo.io.r0;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes4.dex */
public class e {
    private static final sdk.pendo.io.v4.a a = sdk.pendo.io.v4.b.a((Class<?>) e.class);

    public static boolean a(String str, int i) {
        int iA = sdk.pendo.io.a1.a.a(i);
        try {
            int maxAllowedKeyLength = Cipher.getMaxAllowedKeyLength(str);
            boolean z = iA <= maxAllowedKeyLength;
            if (!z) {
                a.a("max allowed key length for {} is {}", str, Integer.valueOf(maxAllowedKeyLength));
            }
            return z;
        } catch (NoSuchAlgorithmException e) {
            a.a("Unknown/unsupported algorithm, {} {}", str, e);
            return false;
        }
    }
}
