package sdk.pendo.io.u0;

import com.yubico.yubikit.core.fido.CtapException;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.io.IOException;
import java.math.BigInteger;
import java.security.Key;
import java.security.PublicKey;
import java.security.interfaces.ECKey;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.keys.EllipticCurves;

/* JADX INFO: loaded from: classes5.dex */
public class b extends sdk.pendo.io.u0.a {
    private final String h;
    private final int i;

    public static class a extends b {
        public a() {
            super(AlgorithmIdentifiers.ECDSA_USING_P256_CURVE_AND_SHA256, "SHA256withECDSA", EllipticCurves.P_256, 64);
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.u0.b$b, reason: collision with other inner class name */
    public static class C0494b extends b {
        public C0494b() {
            super(AlgorithmIdentifiers.ECDSA_USING_P384_CURVE_AND_SHA384, "SHA384withECDSA", EllipticCurves.P_384, 96);
        }
    }

    public static class c extends b {
        public c() {
            super(AlgorithmIdentifiers.ECDSA_USING_P521_CURVE_AND_SHA512, "SHA512withECDSA", EllipticCurves.P_521, Token.TARGET);
        }
    }

    public static class d extends b {
        sdk.pendo.io.v4.a j;

        public d() {
            super("ES256K", "SHA256withECDSA", "secp256k1", 64);
            this.j = sdk.pendo.io.v4.b.a(getClass());
        }

        @Override // sdk.pendo.io.u0.a, sdk.pendo.io.q0.a
        public boolean d() {
            if (super.d()) {
                try {
                    return a(a(sdk.pendo.io.t0.e.a.a("{\"kty\":\"EC\",\"x\":\"gi0g9DzM2SvjVV7iD_upIU0urmZRjpoIc4Efu8563y8\",\"y\":\"Y5K6GofrdlWNLlfT8-AEyJyVZ3yJJcGgkGroHQCAhmk\",\"crv\":\"secp256k1\",\"d\":\"Vd99BKh6pxt3mXSDJzHuVrCq52xBXAKVahbuFb6dqBc\"}").g(), new sdk.pendo.io.m0.a()), new byte[]{2, 6}) != null;
                } catch (sdk.pendo.io.a1.g e) {
                    this.j.a(c() + " is not available due to " + sdk.pendo.io.a1.b.a(e));
                }
            }
            return false;
        }
    }

    public b(String str, String str2, String str3, int i) {
        super(str, str2, "EC");
        this.h = str3;
        this.i = i;
    }

    public static byte[] a(byte[] bArr, int i) throws IOException {
        int i2;
        if (bArr.length < 8 || bArr[0] != 48) {
            throw new IOException("Invalid format of ECDSA signature");
        }
        byte b = bArr[1];
        if (b > 0) {
            i2 = 2;
        } else {
            if (b != -127) {
                throw new IOException("Invalid format of ECDSA signature");
            }
            i2 = 3;
        }
        int i3 = bArr[i2 + 1];
        int i4 = i3;
        while (i4 > 0 && bArr[((i2 + 2) + i3) - i4] == 0) {
            i4--;
        }
        int i5 = i2 + 2 + i3;
        int i6 = bArr[i5 + 1];
        int i7 = i6;
        while (i7 > 0 && bArr[((i5 + 2) + i6) - i7] == 0) {
            i7--;
        }
        int iMax = Math.max(Math.max(i4, i7), i / 2);
        int i8 = bArr[i2 - 1] & 255;
        if (i8 != bArr.length - i2 || i8 != i3 + 4 + i6 || bArr[i2] != 2 || bArr[i5] != 2) {
            throw new IOException("Invalid format of ECDSA signature");
        }
        int i9 = iMax * 2;
        byte[] bArr2 = new byte[i9];
        System.arraycopy(bArr, i5 - i4, bArr2, iMax - i4, i4);
        System.arraycopy(bArr, ((i5 + 2) + i6) - i7, bArr2, i9 - i7, i7);
        return bArr2;
    }

    public static byte[] b(byte[] bArr) throws IOException {
        int i;
        byte[] bArr2;
        int length = bArr.length / 2;
        int i2 = length;
        while (true) {
            i = 1;
            if (i2 <= 1 || bArr[length - i2] != 0) {
                break;
            }
            i2--;
        }
        int i3 = length - i2;
        int i4 = bArr[i3] < 0 ? i2 + 1 : i2;
        int i5 = length;
        while (i5 > 1 && bArr[(length * 2) - i5] == 0) {
            i5--;
        }
        int i6 = (length * 2) - i5;
        int i7 = bArr[i6] < 0 ? i5 + 1 : i5;
        int i8 = i4 + 4 + i7;
        if (i8 > 255) {
            throw new IOException("Invalid format of ECDSA signature");
        }
        if (i8 < 128) {
            bArr2 = new byte[i4 + 6 + i7];
        } else {
            bArr2 = new byte[i4 + 7 + i7];
            bArr2[1] = -127;
            i = 2;
        }
        bArr2[0] = CtapException.ERR_NOT_ALLOWED;
        bArr2[i] = (byte) i8;
        bArr2[i + 1] = 2;
        bArr2[i + 2] = (byte) i4;
        int i9 = i + 3 + i4;
        System.arraycopy(bArr, i3, bArr2, i9 - i2, i2);
        bArr2[i9] = 2;
        bArr2[i9 + 1] = (byte) i7;
        System.arraycopy(bArr, i6, bArr2, ((i9 + 2) + i7) - i5, i5);
        return bArr2;
    }

    private void d(Key key) throws sdk.pendo.io.a1.f {
        if (key instanceof ECKey) {
            String strA = sdk.pendo.io.y0.e.a(((ECKey) key).getParams().getCurve());
            if (!f().equals(strA)) {
                throw new sdk.pendo.io.a1.f(c() + "/" + e() + " expects a key using " + f() + " but was " + strA);
            }
        }
    }

    public String f() {
        return this.h;
    }

    @Override // sdk.pendo.io.u0.a
    public byte[] a(sdk.pendo.io.q0.g gVar, byte[] bArr) throws sdk.pendo.io.a1.g {
        try {
            return a(super.a(gVar, bArr), this.i);
        } catch (IOException e) {
            throw new sdk.pendo.io.a1.g("Unable to convert DER encoding to R and S as a concatenated byte array.", e);
        }
    }

    @Override // sdk.pendo.io.u0.a
    public void a(PublicKey publicKey) throws sdk.pendo.io.a1.f {
        d(publicKey);
    }

    @Override // sdk.pendo.io.u0.a, sdk.pendo.io.u0.f
    public boolean a(byte[] bArr, Key key, byte[] bArr2, sdk.pendo.io.m0.a aVar) throws sdk.pendo.io.a1.g {
        if (bArr.length > this.i) {
            return false;
        }
        BigInteger bigIntegerA = sdk.pendo.io.y0.b.a(sdk.pendo.io.a1.a.c(bArr));
        BigInteger bigIntegerA2 = sdk.pendo.io.y0.b.a(sdk.pendo.io.a1.a.e(bArr));
        BigInteger order = sdk.pendo.io.y0.e.a(this.h).getOrder();
        BigInteger bigIntegerMod = bigIntegerA.mod(order);
        BigInteger bigInteger = BigInteger.ZERO;
        if (bigIntegerMod.equals(bigInteger) || bigIntegerA2.mod(order).equals(bigInteger)) {
            return false;
        }
        try {
            return super.a(b(bArr), key, bArr2, aVar);
        } catch (IOException e) {
            throw new sdk.pendo.io.a1.g("Unable to convert R and S as a concatenated byte array to DER encoding.", e);
        }
    }
}
