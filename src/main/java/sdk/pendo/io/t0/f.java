package sdk.pendo.io.t0;

import java.math.BigInteger;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;
import sdk.pendo.io.y0.j;

/* JADX INFO: loaded from: classes5.dex */
public class f extends e {
    public f(RSAPublicKey rSAPublicKey) {
        super(rSAPublicKey);
    }

    @Override // sdk.pendo.io.t0.e
    protected void a(Map<String, Object> map) {
        RSAPrivateKey rSAPrivateKeyI = i();
        if (rSAPrivateKeyI != null) {
            a(map, "d", rSAPrivateKeyI.getPrivateExponent());
            if (rSAPrivateKeyI instanceof RSAPrivateCrtKey) {
                RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) rSAPrivateKeyI;
                a(map, "p", rSAPrivateCrtKey.getPrimeP());
                a(map, "q", rSAPrivateCrtKey.getPrimeQ());
                a(map, "dp", rSAPrivateCrtKey.getPrimeExponentP());
                a(map, "dq", rSAPrivateCrtKey.getPrimeExponentQ());
                a(map, "qi", rSAPrivateCrtKey.getCrtCoefficient());
            }
        }
    }

    @Override // sdk.pendo.io.t0.e
    protected void b(Map<String, Object> map) {
        RSAPublicKey rSAPublicKeyJ = j();
        a(map, "n", rSAPublicKeyJ.getModulus());
        a(map, "e", rSAPublicKeyJ.getPublicExponent());
    }

    @Override // sdk.pendo.io.t0.b
    public String c() {
        return "RSA";
    }

    public RSAPrivateKey i() {
        return (RSAPrivateKey) this.h;
    }

    public RSAPublicKey j() {
        return (RSAPublicKey) this.f;
    }

    public f(Map<String, Object> map) {
        this(map, null);
    }

    public f(Map<String, Object> map, String str) {
        char c;
        RSAPrivateKey rSAPrivateKeyA;
        super(map, str);
        BigInteger bigIntegerB = b(map, "n", true);
        BigInteger bigIntegerB2 = b(map, "e", true);
        j jVar = new j(str, null);
        this.f = jVar.b(bigIntegerB, bigIntegerB2);
        e();
        String str2 = "dq";
        String str3 = "dp";
        String str4 = "q";
        String str5 = "p";
        if (map.containsKey("d")) {
            BigInteger bigIntegerB3 = b(map, "d", false);
            if (map.containsKey("p")) {
                c = 0;
                rSAPrivateKeyA = jVar.a(bigIntegerB, bigIntegerB2, bigIntegerB3, b(map, "p", false), b(map, "q", false), b(map, "dp", false), b(map, "dq", false), b(map, "qi", false));
            } else {
                c = 0;
                rSAPrivateKeyA = jVar.a(bigIntegerB, bigIntegerB3);
            }
            this.h = rSAPrivateKeyA;
        } else {
            str2 = "dq";
            str3 = "dp";
            str4 = "q";
            str5 = "p";
            c = 0;
        }
        String[] strArr = new String[8];
        strArr[c] = "n";
        strArr[1] = "e";
        strArr[2] = "d";
        strArr[3] = str5;
        strArr[4] = str4;
        strArr[5] = str3;
        strArr[6] = str2;
        strArr[7] = "qi";
        a(strArr);
    }
}
