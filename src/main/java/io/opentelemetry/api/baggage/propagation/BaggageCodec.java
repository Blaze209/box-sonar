package io.opentelemetry.api.baggage.propagation;

import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
class BaggageCodec {
    private static final byte ESCAPE_CHAR = 37;
    private static final int RADIX = 16;

    private BaggageCodec() {
    }

    private static byte[] decode(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (i < bArr.length) {
            byte b = bArr[i];
            if (b == 37) {
                try {
                    int iDigit16 = digit16(bArr[i + 1]);
                    i += 2;
                    byteArrayOutputStream.write((char) ((iDigit16 << 4) + digit16(bArr[i])));
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new IllegalArgumentException("Invalid URL encoding: ", e);
                }
            } else {
                byteArrayOutputStream.write(b);
            }
            i++;
        }
        return byteArrayOutputStream.toByteArray();
    }

    static String decode(String str, Charset charset) {
        return new String(decode(str.getBytes(StandardCharsets.US_ASCII)), charset);
    }

    private static int digit16(byte b) {
        int iDigit = Character.digit((char) b, 16);
        if (iDigit != -1) {
            return iDigit;
        }
        throw new IllegalArgumentException("Invalid URL encoding: not a valid digit (radix 16): " + ((int) b));
    }
}
