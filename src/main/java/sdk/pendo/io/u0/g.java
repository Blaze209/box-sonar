package sdk.pendo.io.u0;

import com.microsoft.identity.common.java.crypto.IDevicePopManager;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.RsaUsingShaAlgorithm;

/* JADX INFO: loaded from: classes5.dex */
public class g extends sdk.pendo.io.u0.a {

    public static class a extends g {
        public a() {
            super(AlgorithmIdentifiers.RSA_PSS_USING_SHA256, g.d("SHA256withRSAandMGF1"));
            if (e().equals(RsaUsingShaAlgorithm.RSASSA_PSS)) {
                MGF1ParameterSpec mGF1ParameterSpec = MGF1ParameterSpec.SHA256;
                a(new PSSParameterSpec(mGF1ParameterSpec.getDigestAlgorithm(), IDevicePopManager.MGF_1, mGF1ParameterSpec, 32, 1));
            }
        }
    }

    public static class b extends g {
        public b() {
            super(AlgorithmIdentifiers.RSA_PSS_USING_SHA384, g.d("SHA384withRSAandMGF1"));
            if (e().equals(RsaUsingShaAlgorithm.RSASSA_PSS)) {
                MGF1ParameterSpec mGF1ParameterSpec = MGF1ParameterSpec.SHA384;
                a(new PSSParameterSpec(mGF1ParameterSpec.getDigestAlgorithm(), IDevicePopManager.MGF_1, mGF1ParameterSpec, 48, 1));
            }
        }
    }

    public static class c extends g {
        public c() {
            super(AlgorithmIdentifiers.RSA_PSS_USING_SHA512, g.d("SHA512withRSAandMGF1"));
            if (e().equals(RsaUsingShaAlgorithm.RSASSA_PSS)) {
                MGF1ParameterSpec mGF1ParameterSpec = MGF1ParameterSpec.SHA512;
                a(new PSSParameterSpec(mGF1ParameterSpec.getDigestAlgorithm(), IDevicePopManager.MGF_1, mGF1ParameterSpec, 64, 1));
            }
        }
    }

    public static class d extends g {
        public d() {
            super("RS256", "SHA256withRSA");
        }
    }

    public static class e extends g {
        public e() {
            super(AlgorithmIdentifiers.RSA_USING_SHA384, "SHA384withRSA");
        }
    }

    public static class f extends g {
        public f() {
            super(AlgorithmIdentifiers.RSA_USING_SHA512, "SHA512withRSA");
        }
    }

    public g(String str, String str2) {
        super(str, str2, "RSA");
    }

    static String d(String str) {
        return (!Security.getAlgorithms("Signature").contains(RsaUsingShaAlgorithm.RSASSA_PSS) || Boolean.getBoolean("external.sdk.pendo.io.jose4j.jws.use-legacy-rsapss-alg-names")) ? str : RsaUsingShaAlgorithm.RSASSA_PSS;
    }

    @Override // sdk.pendo.io.u0.a
    public void a(PublicKey publicKey) throws sdk.pendo.io.a1.f {
        sdk.pendo.io.x0.d.a(publicKey);
    }
}
