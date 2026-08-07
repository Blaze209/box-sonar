package sdk.pendo.io.r0;

import com.microsoft.identity.common.crypto.KeyStoreBackedSecretKeyProvider;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import org.jose4j.jwe.ContentEncryptionAlgorithmIdentifiers;
import org.jose4j.mac.MacUtil;

/* JADX INFO: loaded from: classes4.dex */
public class a extends sdk.pendo.io.q0.f implements g {
    private final String f;
    private final int g;
    private final i h;

    /* JADX INFO: renamed from: sdk.pendo.io.r0.a$a, reason: collision with other inner class name */
    public static class C0468a extends a {
        public C0468a() {
            super(ContentEncryptionAlgorithmIdentifiers.AES_128_CBC_HMAC_SHA_256, 32, "HmacSHA256", 16);
        }
    }

    public static class b extends a {
        public b() {
            super(ContentEncryptionAlgorithmIdentifiers.AES_192_CBC_HMAC_SHA_384, 48, MacUtil.HMAC_SHA384, 24);
        }
    }

    public static class c extends a {
        public c() {
            super(ContentEncryptionAlgorithmIdentifiers.AES_256_CBC_HMAC_SHA_512, 64, MacUtil.HMAC_SHA512, 32);
        }
    }

    public a(String str, int i, String str2, int i2) {
        a(str);
        this.h = new i(i, "AES");
        this.f = str2;
        this.g = i2;
        b(KeyStoreBackedSecretKeyProvider.AES_CBC_PKCS5_PADDING_TRANSFORMATION);
        a(sdk.pendo.io.y0.h.SYMMETRIC);
        c("AES");
    }

    private byte[] b(byte[] bArr) {
        return sdk.pendo.io.a1.a.a(sdk.pendo.io.a1.a.a(bArr));
    }

    @Override // sdk.pendo.io.r0.g
    public byte[] a(k kVar, byte[] bArr, byte[] bArr2, sdk.pendo.io.x0.b bVar, sdk.pendo.io.m0.a aVar) throws sdk.pendo.io.a1.g {
        String strB = h.b(bVar, aVar);
        String strC = h.c(bVar, aVar);
        byte[] bArrC = kVar.c();
        byte[] bArrB = kVar.b();
        byte[] bArrA = kVar.a();
        if (!sdk.pendo.io.a1.a.a(bArrA, sdk.pendo.io.a1.a.a(sdk.pendo.io.b1.a.a(f(), new sdk.pendo.io.y0.f(sdk.pendo.io.a1.a.c(bArr2)), strC).doFinal(sdk.pendo.io.a1.a.a(bArr, bArrC, bArrB, b(bArr))), 0, g()))) {
            throw new sdk.pendo.io.a1.d("Authentication tag check failed. Message=" + new sdk.pendo.io.k0.b().a(bArrA));
        }
        sdk.pendo.io.y0.a aVar2 = new sdk.pendo.io.y0.a(sdk.pendo.io.a1.a.e(bArr2));
        Cipher cipherA = f.a(e(), strB);
        try {
            cipherA.init(2, aVar2, new IvParameterSpec(bArrC));
            try {
                return cipherA.doFinal(bArrB);
            } catch (BadPaddingException | IllegalBlockSizeException e) {
                throw new sdk.pendo.io.a1.g(e.toString(), e);
            }
        } catch (InvalidAlgorithmParameterException e2) {
            throw new sdk.pendo.io.a1.g(e2.toString(), e2);
        } catch (InvalidKeyException e3) {
            throw new sdk.pendo.io.a1.g("Invalid key for " + e(), e3);
        }
    }

    @Override // sdk.pendo.io.q0.a
    public boolean d() {
        return e.a(e(), b().b() / 2);
    }

    public String f() {
        return this.f;
    }

    public int g() {
        return this.g;
    }

    @Override // sdk.pendo.io.r0.g
    public i b() {
        return this.h;
    }
}
