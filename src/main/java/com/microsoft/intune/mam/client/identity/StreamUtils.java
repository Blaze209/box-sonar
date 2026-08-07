package com.microsoft.intune.mam.client.identity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class StreamUtils {
    private static final int BUFFER_SIZE = 1024;

    public static boolean exactRead(InputStream inputStream, byte[] bArr) throws IOException {
        int length = bArr.length;
        int i = 0;
        while (i < length) {
            int i2 = inputStream.read(bArr, i, length - i);
            if (i2 < 0) {
                return false;
            }
            i += i2;
        }
        return true;
    }

    public static byte[] readAllBytesFromStream(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i = inputStream.read(bArr);
            if (i < 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    private StreamUtils() {
    }
}
