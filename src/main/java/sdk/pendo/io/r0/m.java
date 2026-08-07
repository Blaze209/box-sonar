package sdk.pendo.io.r0;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECFieldFp;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import javax.crypto.KeyAgreement;
import javax.crypto.spec.SecretKeySpec;
import org.jose4j.jwe.KeyManagementAlgorithmIdentifiers;

/* JADX INFO: loaded from: classes4.dex */
public class m extends sdk.pendo.io.q0.f implements p {
    String f;

    public m() {
        this.f = "enc";
        a(KeyManagementAlgorithmIdentifiers.ECDH_ES);
        b("ECDH");
        c("EC");
        a(sdk.pendo.io.y0.h.ASYMMETRIC);
    }

    private void a(ECKey eCKey) throws sdk.pendo.io.a1.f {
        if ("secp256k1".equals(sdk.pendo.io.y0.e.a(eCKey.getParams().getCurve()))) {
            throw new sdk.pendo.io.a1.f("Use of the secp256k1 curve is not defined for ECDH-ES key agreement with JOSE.");
        }
    }

    @Override // sdk.pendo.io.q0.a
    public boolean d() {
        return new sdk.pendo.io.y0.c().c() && sdk.pendo.io.q0.b.a("KeyAgreement", e());
    }

    public m(String str) {
        this();
        this.f = str;
    }

    private void a(ECPublicKey eCPublicKey, ECPrivateKey eCPrivateKey) throws sdk.pendo.io.a1.f {
        EllipticCurve curve = eCPrivateKey.getParams().getCurve();
        ECPoint w = eCPublicKey.getW();
        BigInteger affineX = w.getAffineX();
        BigInteger affineY = w.getAffineY();
        BigInteger a = curve.getA();
        BigInteger b = curve.getB();
        BigInteger p = ((ECFieldFp) curve.getField()).getP();
        if (!affineY.pow(2).mod(p).equals(affineX.pow(3).add(a.multiply(affineX)).add(b).mod(p))) {
            throw new sdk.pendo.io.a1.f("epk is invalid for " + sdk.pendo.io.y0.e.a(curve));
        }
    }

    private KeyAgreement a(PrivateKey privateKey, PublicKey publicKey, sdk.pendo.io.m0.a aVar) throws sdk.pendo.io.a1.g {
        KeyAgreement keyAgreementA = a(aVar.c().b(), privateKey instanceof ECPrivateKey ? e() : "XDH");
        try {
            keyAgreementA.init(privateKey);
            keyAgreementA.doPhase(publicKey, true);
            return keyAgreementA;
        } catch (InvalidKeyException e) {
            throw new sdk.pendo.io.a1.f("Invalid Key for " + e() + " key agreement - " + e, e);
        }
    }

    private KeyAgreement a(String str, String str2) throws sdk.pendo.io.a1.g {
        try {
            return str == null ? KeyAgreement.getInstance(str2) : KeyAgreement.getInstance(str2, str);
        } catch (NoSuchAlgorithmException e) {
            throw new sdk.pendo.io.a1.k("No " + str2 + " KeyAgreement available.", e);
        } catch (NoSuchProviderException e2) {
            throw new sdk.pendo.io.a1.g("Cannot get " + str2 + " KeyAgreement with provider " + str, e2);
        }
    }

    private byte[] a(i iVar, sdk.pendo.io.x0.b bVar, byte[] bArr, sdk.pendo.io.m0.a aVar) {
        return new sdk.pendo.io.s0.d(aVar.a().f()).a(bArr, sdk.pendo.io.a1.a.a(iVar.b()), bVar.c(this.f), bVar.c("apu"), bVar.c("apv"));
    }

    @Override // sdk.pendo.io.r0.p
    public Key a(sdk.pendo.io.q0.g gVar, byte[] bArr, i iVar, sdk.pendo.io.x0.b bVar, sdk.pendo.io.m0.a aVar) {
        return new SecretKeySpec(a(iVar, bVar, gVar.c().generateSecret(), aVar), iVar.a());
    }

    @Override // sdk.pendo.io.r0.p
    public sdk.pendo.io.q0.g a(Key key, sdk.pendo.io.x0.b bVar, sdk.pendo.io.m0.a aVar) throws sdk.pendo.io.a1.f {
        PublicKey publicKeyH = bVar.a("epk", aVar.a().d()).h();
        PrivateKey privateKey = (PrivateKey) key;
        if (publicKeyH instanceof ECPublicKey) {
            ECPrivateKey eCPrivateKey = (ECPrivateKey) key;
            a(eCPrivateKey);
            a((ECPublicKey) publicKeyH, eCPrivateKey);
        }
        return new sdk.pendo.io.q0.g(a(privateKey, publicKeyH, aVar));
    }

    @Override // sdk.pendo.io.r0.p
    public void a(Key key, g gVar) throws sdk.pendo.io.a1.f {
        if (!(key instanceof ECPrivateKey) && !sdk.pendo.io.y0.l.b(key)) {
            throw new sdk.pendo.io.a1.f("Decrypting with ECDH expects ECPrivateKey or XECPrivateKey but was given " + key);
        }
    }
}
