package sdk.pendo.io.a1;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/* JADX INFO: loaded from: classes4.dex */
public class c {
    public static MessageDigest a(String str, String str2) {
        try {
            return str2 == null ? MessageDigest.getInstance(str) : MessageDigest.getInstance(str, str2);
        } catch (NoSuchAlgorithmException unused) {
            throw new k("Unable to get MessageDigest instance with " + str);
        } catch (NoSuchProviderException e) {
            throw new k("Unable to get a MessageDigest implementation of algorithm name: " + str + " using provider " + str2, e);
        }
    }
}
