package sdk.pendo.io.d5;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
class a {
    public static byte[] a(byte[][] bArr) {
        int length = 0;
        for (byte[] bArr2 : bArr) {
            length += bArr2.length;
        }
        return a(bArr, length);
    }

    public static byte[] a(byte[][] bArr, int i) {
        if (bArr.length == 0) {
            return new byte[0];
        }
        if (bArr.length == 1) {
            return bArr[0];
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        for (byte[] bArr2 : bArr) {
            byteBufferAllocate.put(bArr2);
        }
        return byteBufferAllocate.array();
    }
}
