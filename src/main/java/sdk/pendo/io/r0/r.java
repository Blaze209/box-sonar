package sdk.pendo.io.r0;

import com.microsoft.identity.common.java.crypto.IDevicePopManager;
import java.security.Key;
import java.security.PrivateKey;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import org.jose4j.jwe.KeyManagementAlgorithmIdentifiers;

/* JADX INFO: loaded from: classes4.dex */
public class r extends t {

    public static class a extends r {
        public a() {
            super("RSA/ECB/PKCS1Padding", KeyManagementAlgorithmIdentifiers.RSA1_5);
        }
    }

    public static class b extends r {
        public b() {
            super("RSA/ECB/OAEPWithSHA-256AndMGF1Padding", KeyManagementAlgorithmIdentifiers.RSA_OAEP_256);
            a(new OAEPParameterSpec("SHA-256", IDevicePopManager.MGF_1, MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT));
        }

        @Override // sdk.pendo.io.r0.r, sdk.pendo.io.q0.a
        public boolean d() {
            b bVar;
            try {
                bVar = this;
                try {
                    return bVar.a(sdk.pendo.io.t0.b.a.a("{\"kty\":\"RSA\",\"n\":\"sXchDaQebHnPiGvyDOAT4saGEUetSyo9MKLOoWFsueri23bOdgWp4Dy1WlUzewbgBHod5pcM9H95GQRV3JDXboIRROSBigeC5yjU1hGzHHyXss8UDprecbAYxknTcQkhslANGRUZmdTOQ5qTRsLAt6BTYuyvVRdhS8exSZEy_c4gs_7svlJJQ4H9_NxsiIoLwAEk7-Q3UXERGYw_75IDrGA84-lA_-Ct4eTlXHBIY2EaV7t7LjJaynVJCpkv4LKjTTAumiGUIuQhrNhZLuF_RJLqHpM2kgWFLU7-VTdL1VbC2tejvcI2BlMkEpk1BzBZI0KQB0GaDWFLN-aEAw3vRw\",\"e\":\"AQAB\"}").a(), new i(16, "AES"), (sdk.pendo.io.x0.b) null, (byte[]) null, new sdk.pendo.io.m0.a()) != null;
                } catch (sdk.pendo.io.a1.g e) {
                    e = e;
                    bVar.f.a(bVar.c() + " is not available due to " + sdk.pendo.io.a1.b.a(e));
                    return false;
                }
            } catch (sdk.pendo.io.a1.g e2) {
                e = e2;
                bVar = this;
            }
        }
    }

    public static class c extends r {
        public c() {
            super("RSA/ECB/OAEPWithSHA-1AndMGF1Padding", KeyManagementAlgorithmIdentifiers.RSA_OAEP);
        }
    }

    public r(String str, String str2) {
        super(str, str2);
        c("RSA");
        a(sdk.pendo.io.y0.h.ASYMMETRIC);
    }

    @Override // sdk.pendo.io.r0.p
    public void a(Key key, g gVar) throws sdk.pendo.io.a1.f {
        sdk.pendo.io.x0.d.a((PrivateKey) sdk.pendo.io.x0.d.a(key, PrivateKey.class));
    }

    @Override // sdk.pendo.io.q0.a
    public boolean d() {
        try {
            return f.a(e(), null) != null;
        } catch (sdk.pendo.io.a1.g unused) {
        }
    }
}
