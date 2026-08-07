package sdk.pendo.io.r0;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: classes4.dex */
public class f {
    static Cipher a(String str, String str2) throws sdk.pendo.io.a1.g {
        try {
            return str2 == null ? Cipher.getInstance(str) : Cipher.getInstance(str, str2);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw new sdk.pendo.io.a1.g(e.toString(), e);
        } catch (NoSuchProviderException e2) {
            throw new sdk.pendo.io.a1.g("Unable to get a Cipher implementation of " + str + " using provider " + str2, e2);
        }
    }
}
