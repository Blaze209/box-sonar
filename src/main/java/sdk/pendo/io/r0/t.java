package sdk.pendo.io.r0;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes4.dex */
public abstract class t extends sdk.pendo.io.q0.f implements p {
    private AlgorithmParameterSpec g;
    protected final sdk.pendo.io.v4.a f = sdk.pendo.io.v4.b.a(getClass());
    protected boolean h = true;

    public t(String str, String str2) {
        b(str);
        a(str2);
    }

    private sdk.pendo.io.m0.a.C0418a a(sdk.pendo.io.m0.a aVar) {
        return this.h ? aVar.c() : aVar.a();
    }

    void a(Cipher cipher, int i, Key key) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec algorithmParameterSpec = this.g;
        if (algorithmParameterSpec == null) {
            cipher.init(i, key);
        } else {
            cipher.init(i, key, algorithmParameterSpec);
        }
    }

    @Override // sdk.pendo.io.r0.p
    public Key a(sdk.pendo.io.q0.g gVar, byte[] bArr, i iVar, sdk.pendo.io.x0.b bVar, sdk.pendo.io.m0.a aVar) {
        Cipher cipherA = gVar.a();
        String strA = iVar.a();
        try {
            return a(aVar).c() == sdk.pendo.io.m0.a.b.DECRYPT ? new SecretKeySpec(cipherA.doFinal(bArr), strA) : cipherA.unwrap(bArr, strA, 3);
        } catch (Exception e) {
            if (this.f.a()) {
                this.f.b("Key unwrap/decrypt failed. Substituting a randomly generated CEK and proceeding. {}", sdk.pendo.io.a1.b.a(e, o.class));
            }
            return new SecretKeySpec(sdk.pendo.io.a1.a.d(iVar.b()), strA);
        }
    }

    protected j a(Key key, i iVar, byte[] bArr, sdk.pendo.io.m0.a aVar) throws sdk.pendo.io.a1.g {
        Cipher cipherA = f.a(e(), a(aVar).a());
        try {
            a(cipherA, 3, key);
            return new j(bArr, cipherA.wrap(new SecretKeySpec(bArr, iVar.a())));
        } catch (InvalidAlgorithmParameterException | IllegalBlockSizeException e) {
            throw new sdk.pendo.io.a1.g("Unable to encrypt (" + cipherA.getAlgorithm() + ") the Content Encryption Key: " + e, e);
        } catch (InvalidKeyException e2) {
            throw new sdk.pendo.io.a1.f("Unable to encrypt (" + cipherA.getAlgorithm() + ") the Content Encryption Key: " + e2, e2);
        }
    }

    public j a(Key key, i iVar, sdk.pendo.io.x0.b bVar, byte[] bArr, sdk.pendo.io.m0.a aVar) {
        if (bArr == null) {
            bArr = sdk.pendo.io.a1.a.d(iVar.b());
        }
        return a(key, iVar, bArr, aVar);
    }

    @Override // sdk.pendo.io.r0.p
    public sdk.pendo.io.q0.g a(Key key, sdk.pendo.io.x0.b bVar, sdk.pendo.io.m0.a aVar) throws sdk.pendo.io.a1.g {
        sdk.pendo.io.m0.a.C0418a c0418aA = a(aVar);
        Cipher cipherA = f.a(e(), c0418aA.a());
        try {
            a(cipherA, c0418aA.c() == sdk.pendo.io.m0.a.b.DECRYPT ? 2 : 4, key);
            return new sdk.pendo.io.q0.g(cipherA);
        } catch (InvalidAlgorithmParameterException e) {
            throw new sdk.pendo.io.a1.g("Unable to initialize cipher (" + cipherA.getAlgorithm() + ") for key unwrap/decrypt - " + e, e);
        } catch (InvalidKeyException e2) {
            throw new sdk.pendo.io.a1.f("Unable to initialize cipher (" + cipherA.getAlgorithm() + ") for key unwrap/decrypt - " + e2, e2);
        }
    }

    public void a(AlgorithmParameterSpec algorithmParameterSpec) {
        this.g = algorithmParameterSpec;
    }
}
