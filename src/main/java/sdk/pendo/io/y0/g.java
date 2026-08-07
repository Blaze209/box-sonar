package sdk.pendo.io.y0;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
abstract class g {
    protected String a;
    protected SecureRandom b;

    protected g(String str, SecureRandom secureRandom) {
        this.a = str;
        this.b = secureRandom;
    }

    abstract String a();

    protected KeyFactory b() throws sdk.pendo.io.a1.g {
        String strA = a();
        try {
            String str = this.a;
            return str == null ? KeyFactory.getInstance(strA) : KeyFactory.getInstance(strA, str);
        } catch (NoSuchAlgorithmException e) {
            throw new sdk.pendo.io.a1.g("Couldn't find " + strA + " KeyFactory! " + e, e);
        } catch (NoSuchProviderException e2) {
            throw new sdk.pendo.io.a1.g("Cannot get KeyFactory instance with provider " + this.a, e2);
        }
    }

    public boolean c() {
        Set<String> algorithms = Security.getAlgorithms("KeyFactory");
        Set<String> algorithms2 = Security.getAlgorithms("KeyPairGenerator");
        String strA = a();
        return algorithms2.contains(strA) && algorithms.contains(strA);
    }
}
