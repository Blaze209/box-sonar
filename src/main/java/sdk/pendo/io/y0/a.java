package sdk.pendo.io.y0;

import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes6.dex */
public class a extends SecretKeySpec {
    public a(byte[] bArr) {
        super(bArr, "AES");
    }

    public String toString() {
        return sdk.pendo.io.a1.a.a(getEncoded().length) + " bit AES key";
    }
}
