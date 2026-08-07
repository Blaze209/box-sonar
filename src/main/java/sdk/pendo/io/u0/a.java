package sdk.pendo.io.u0;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a extends sdk.pendo.io.q0.f implements f {
    private final sdk.pendo.io.v4.a f = sdk.pendo.io.v4.b.a(getClass());
    private AlgorithmParameterSpec g;

    public a(String str, String str2, String str3) {
        a(str);
        b(str2);
        a(sdk.pendo.io.y0.h.ASYMMETRIC);
        c(str3);
    }

    private Signature a(sdk.pendo.io.m0.a aVar) throws sdk.pendo.io.a1.g {
        sdk.pendo.io.m0.a.C0418a c0418aC = aVar.c();
        String strH = c0418aC.h();
        String strE = e();
        c0418aC.g();
        try {
            Signature signature = strH == null ? Signature.getInstance(strE) : Signature.getInstance(strE, strH);
            AlgorithmParameterSpec algorithmParameterSpec = this.g;
            if (algorithmParameterSpec != null) {
                try {
                    signature.setParameter(algorithmParameterSpec);
                    return signature;
                } catch (UnsupportedOperationException e) {
                    if (this.f.a()) {
                        this.f.a("Unable to set algorithm parameter spec on Signature (java algorithm name: " + strE + ") so ignoring the UnsupportedOperationException and relying on the default parameters.", (Throwable) e);
                    }
                }
            }
            return signature;
        } catch (InvalidAlgorithmParameterException e2) {
            throw new sdk.pendo.io.a1.g("Invalid algorithm parameter (" + this.g + ") for: " + strE, e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new sdk.pendo.io.a1.g("Unable to get an implementation of algorithm name: " + strE, e3);
        } catch (NoSuchProviderException e4) {
            throw new sdk.pendo.io.a1.g("Unable to get an implementation of " + strE + " for provider " + strH, e4);
        }
    }

    private void b(Key key) throws sdk.pendo.io.a1.f {
        if (key == null) {
            throw new sdk.pendo.io.a1.f("Key cannot be null");
        }
    }

    private String c(Key key) {
        return "The given key (" + (key == null ? "key is null" : "algorithm=" + key.getAlgorithm()) + ") is not valid ";
    }

    public abstract void a(PublicKey publicKey);

    @Override // sdk.pendo.io.q0.a
    public boolean d() {
        try {
            return a(new sdk.pendo.io.m0.a()) != null;
        } catch (Exception e) {
            this.f.a(c() + " via " + e() + " is NOT available from the underlying JCE (" + sdk.pendo.io.a1.b.a(e) + ").");
            return false;
        }
    }

    private void a(Signature signature, Key key, sdk.pendo.io.m0.a aVar) throws sdk.pendo.io.a1.f {
        try {
            PrivateKey privateKey = (PrivateKey) key;
            SecureRandom secureRandomB = aVar.b();
            if (secureRandomB == null) {
                signature.initSign(privateKey);
            } else {
                signature.initSign(privateKey, secureRandomB);
            }
        } catch (InvalidKeyException e) {
            throw new sdk.pendo.io.a1.f(c(key) + "for " + e(), e);
        }
    }

    private void a(Signature signature, Key key) throws sdk.pendo.io.a1.f {
        try {
            signature.initVerify((PublicKey) key);
        } catch (InvalidKeyException e) {
            throw new sdk.pendo.io.a1.f(c(key) + "for " + e(), e);
        }
    }

    public sdk.pendo.io.q0.g a(Key key, sdk.pendo.io.m0.a aVar) throws sdk.pendo.io.a1.g {
        Signature signatureA = a(aVar);
        a(signatureA, key, aVar);
        return new sdk.pendo.io.q0.g(signatureA);
    }

    protected void a(AlgorithmParameterSpec algorithmParameterSpec) {
        this.g = algorithmParameterSpec;
    }

    public byte[] a(sdk.pendo.io.q0.g gVar, byte[] bArr) throws sdk.pendo.io.a1.g {
        Signature signatureD = gVar.d();
        try {
            signatureD.update(bArr);
            return signatureD.sign();
        } catch (SignatureException e) {
            throw new sdk.pendo.io.a1.g("Problem creating signature.", e);
        }
    }

    @Override // sdk.pendo.io.u0.f
    public void a(Key key) throws sdk.pendo.io.a1.f {
        b(key);
        try {
            a((PublicKey) key);
        } catch (ClassCastException e) {
            throw new sdk.pendo.io.a1.f(c(key) + "(not a public key or is the wrong type of key) for " + e() + "/" + c() + " " + e);
        }
    }

    @Override // sdk.pendo.io.u0.f
    public boolean a(byte[] bArr, Key key, byte[] bArr2, sdk.pendo.io.m0.a aVar) throws sdk.pendo.io.a1.g {
        Signature signatureA = a(aVar);
        a(signatureA, key);
        try {
            signatureA.update(bArr2);
            return signatureA.verify(bArr);
        } catch (SignatureException e) {
            if (!this.f.a()) {
                return false;
            }
            this.f.a("Problem verifying " + c() + " signature: " + sdk.pendo.io.a1.b.a(e));
            return false;
        }
    }
}
