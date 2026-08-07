package sdk.pendo.io.r0;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.GCMParameterSpec;

/* JADX INFO: loaded from: classes4.dex */
public class s {
    private String a;
    private int b;

    public static class a {
        private byte[] a;
        private byte[] b;
    }

    public s(String str, int i) {
        this.a = str;
        this.b = i;
    }

    public byte[] a(Key key, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, String str) {
        return a(bArr2, bArr3, bArr4, a(key, bArr, 2, str));
    }

    public byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3, Cipher cipher) throws sdk.pendo.io.a1.g {
        a(cipher, bArr3);
        try {
            return cipher.doFinal(sdk.pendo.io.a1.a.a(bArr, bArr2));
        } catch (BadPaddingException | IllegalBlockSizeException e) {
            throw new sdk.pendo.io.a1.g(e.toString(), e);
        }
    }

    public a a(Key key, byte[] bArr, byte[] bArr2, byte[] bArr3, String str) throws sdk.pendo.io.a1.g {
        Cipher cipherA = a(key, bArr, 1, str);
        a(cipherA, bArr3);
        try {
            byte[] bArrDoFinal = cipherA.doFinal(bArr2);
            a aVar = new a();
            int length = bArrDoFinal.length - this.b;
            aVar.a = sdk.pendo.io.a1.a.a(bArrDoFinal, 0, length);
            aVar.b = sdk.pendo.io.a1.a.a(bArrDoFinal, length, this.b);
            return aVar;
        } catch (BadPaddingException | IllegalBlockSizeException e) {
            throw new sdk.pendo.io.a1.g(e.toString(), e);
        }
    }

    public Cipher a(Key key, byte[] bArr, int i, String str) throws sdk.pendo.io.a1.g {
        Cipher cipherA = f.a(this.a, str);
        try {
            cipherA.init(i, key, new GCMParameterSpec(sdk.pendo.io.a1.a.a(this.b), bArr));
            return cipherA;
        } catch (InvalidAlgorithmParameterException e) {
            throw new sdk.pendo.io.a1.g(e.toString(), e);
        } catch (InvalidKeyException e2) {
            throw new sdk.pendo.io.a1.g("Invalid key for " + this.a, e2);
        }
    }

    public boolean a(sdk.pendo.io.v4.a aVar, int i, int i2, String str) {
        if (!e.a(this.a, i)) {
            return false;
        }
        byte[] bArr = {112, 108, 97, 105, 110, 116, 101, 120, 116};
        byte[] bArr2 = {97, 97, 100};
        byte[] bArrD = sdk.pendo.io.a1.a.d(i);
        try {
            a(new sdk.pendo.io.y0.a(bArrD), sdk.pendo.io.a1.a.d(i2), bArr, bArr2, null);
            return true;
        } catch (Throwable th) {
            aVar.a("{} is not available ({}).", str, sdk.pendo.io.a1.b.a(th));
            return false;
        }
    }

    private void a(Cipher cipher, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        cipher.updateAAD(bArr);
    }
}
