package sdk.pendo.io.s0;

import java.io.ByteArrayOutputStream;
import javax.crypto.Mac;
import sdk.pendo.io.a1.g;
import sdk.pendo.io.a1.k;
import sdk.pendo.io.y0.f;

/* JADX INFO: loaded from: classes5.dex */
public class e {
    private String a;

    public e(String str) {
        this.a = str;
    }

    public byte[] a(byte[] bArr, byte[] bArr2, int i, int i2, String str) throws g {
        Mac macA = sdk.pendo.io.b1.a.a(this.a, new f(bArr), str);
        int macLength = macA.getMacLength();
        if (i2 > 4294967295L) {
            throw new k("derived key too long " + i2);
        }
        int iCeil = (int) Math.ceil(((double) i2) / ((double) macLength));
        int i3 = iCeil - 1;
        int i4 = i2 - (macLength * i3);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i5 = 0;
        while (i5 < iCeil) {
            int i6 = i5 + 1;
            byte[] bArrA = a(bArr2, i, i6, macA);
            if (i5 == i3) {
                bArrA = sdk.pendo.io.a1.a.a(bArrA, 0, i4);
            }
            byteArrayOutputStream.write(bArrA, 0, bArrA.length);
            i5 = i6;
        }
        return byteArrayOutputStream.toByteArray();
    }

    byte[] a(byte[] bArr, int i, int i2, Mac mac) {
        byte[] bArrDoFinal = null;
        byte[] bArrDoFinal2 = null;
        for (int i3 = 1; i3 <= i; i3++) {
            if (i3 == 1) {
                bArrDoFinal = mac.doFinal(sdk.pendo.io.a1.a.a(bArr, sdk.pendo.io.a1.a.c(i2)));
                bArrDoFinal2 = bArrDoFinal;
            } else {
                bArrDoFinal2 = mac.doFinal(bArrDoFinal2);
                for (int i4 = 0; i4 < bArrDoFinal2.length; i4++) {
                    bArrDoFinal[i4] = (byte) (bArrDoFinal2[i4] ^ bArrDoFinal[i4]);
                }
            }
        }
        return bArrDoFinal;
    }
}
