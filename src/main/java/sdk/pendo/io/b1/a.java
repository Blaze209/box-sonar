package sdk.pendo.io.b1;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.crypto.Mac;
import sdk.pendo.io.a1.f;
import sdk.pendo.io.a1.g;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    public static Mac a(String str, Key key, String str2) throws g {
        Mac macA = a(str, str2);
        a(macA, key);
        return macA;
    }

    public static Mac a(String str, String str2) throws g {
        try {
            return str2 == null ? Mac.getInstance(str) : Mac.getInstance(str, str2);
        } catch (NoSuchAlgorithmException e) {
            throw new g("Unable to get a MAC implementation of algorithm name: " + str, e);
        } catch (NoSuchProviderException e2) {
            throw new g("Unable to get a MAC implementation of algorithm name: " + str + " using provider " + str2, e2);
        }
    }

    public static void a(Mac mac, Key key) throws f {
        try {
            mac.init(key);
        } catch (InvalidKeyException e) {
            throw new f("Key is not valid for " + mac.getAlgorithm() + " - " + e, e);
        }
    }
}
