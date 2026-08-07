package sdk.pendo.io.y0;

import javax.crypto.spec.SecretKeySpec;
import org.jose4j.keys.HmacKey;

/* JADX INFO: loaded from: classes6.dex */
public class f extends SecretKeySpec {
    public f(byte[] bArr) {
        super(bArr, HmacKey.ALGORITHM);
    }
}
