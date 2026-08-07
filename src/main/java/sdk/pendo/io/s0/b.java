package sdk.pendo.io.s0;

import com.google.common.base.Ascii;
import com.yubico.yubikit.core.fido.CtapException;

/* JADX INFO: loaded from: classes5.dex */
class b {
    private static final sdk.pendo.io.v4.a a;
    private static Class<c> b;

    static {
        sdk.pendo.io.v4.a aVarA = sdk.pendo.io.v4.b.a((Class<?>) b.class);
        a = aVarA;
        String property = System.getProperty("external.sdk.pendo.io.jose4j.jwe.kdf.ConcatenationKeyDerivationFunctionWithSha256");
        if (property != null) {
            try {
                Class cls = Class.forName(property);
                b = cls;
                c cVar = (c) cls.newInstance();
                cVar.a(new byte[]{124, -81, CtapException.ERR_UNSUPPORTED_OPTION, Ascii.SO, -71, -72, -84, 75, 115, 73, -52, -39, 74, -58, 77, -83}, 512, new byte[8]);
                aVarA.a("Using custom ConcatenationKeyDerivationFunctionWithSha256 implementation: " + cVar.getClass());
            } catch (Throwable th) {
                b = null;
                a.a("Using jose4j's concatenation key derivation function implementation because of problems with " + property, th);
            }
        }
    }

    b() {
    }

    static c a(String str) {
        Class<c> cls = b;
        if (cls != null) {
            try {
                return cls.newInstance();
            } catch (Exception e) {
                a.a("Unable to create new instance of " + b, (Throwable) e);
            }
        }
        return new a("SHA-256", str);
    }
}
