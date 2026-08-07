package sdk.pendo.io.y0;

import java.security.Key;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.interfaces.EdECPrivateKey;
import java.security.interfaces.EdECPublicKey;
import java.security.spec.EdECPoint;
import java.security.spec.EdECPrivateKeySpec;
import java.security.spec.EdECPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public class d extends i {
    public d(String str, SecureRandom secureRandom) {
        super(str, secureRandom);
    }

    @Override // sdk.pendo.io.y0.g
    String a() {
        return "EDDSA";
    }

    @Override // sdk.pendo.io.y0.i
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public EdECPrivateKey a(byte[] bArr, String str) throws sdk.pendo.io.a1.g {
        try {
            return (EdECPrivateKey) b().generatePrivate(new EdECPrivateKeySpec(a(str), bArr));
        } catch (InvalidKeySpecException e) {
            throw new sdk.pendo.io.a1.g("Invalid key spec: " + e, e);
        }
    }

    @Override // sdk.pendo.io.y0.i
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public EdECPublicKey b(byte[] bArr, String str) throws sdk.pendo.io.a1.g {
        byte[] bArr2 = (byte[]) bArr.clone();
        byte b = bArr2[bArr2.length - 1];
        int length = bArr2.length - 1;
        bArr2[length] = (byte) (bArr2[length] & 127);
        try {
            return (EdECPublicKey) b().generatePublic(new EdECPublicKeySpec(a(str), new EdECPoint((b & (-128)) != 0, b.a(sdk.pendo.io.a1.a.d(bArr2)))));
        } catch (InvalidKeySpecException e) {
            throw new sdk.pendo.io.a1.g("Invalid key spec: " + e, e);
        }
    }

    @Override // sdk.pendo.io.y0.i
    public byte[] a(PrivateKey privateKey) {
        return ((EdECPrivateKey) privateKey).getBytes().orElse(sdk.pendo.io.a1.a.a);
    }

    @Override // sdk.pendo.io.y0.i
    public byte[] a(Key key) {
        EdECPublicKey edECPublicKey = (EdECPublicKey) key;
        EdECPoint point = edECPublicKey.getPoint();
        byte[] bArrD = sdk.pendo.io.a1.a.d(point.getY().toByteArray());
        int i = edECPublicKey.getParams().getName().equals("Ed25519") ? 32 : 57;
        if (bArrD.length != i) {
            bArrD = Arrays.copyOf(bArrD, i);
        }
        byte b = point.isXOdd() ? (byte) -128 : (byte) 0;
        int length = bArrD.length - 1;
        bArrD[length] = (byte) (b | bArrD[length]);
        return bArrD;
    }
}
