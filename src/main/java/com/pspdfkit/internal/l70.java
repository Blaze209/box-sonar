package com.pspdfkit.internal;

import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import okio.Utf8;

/* JADX INFO: loaded from: classes3.dex */
public abstract class l70 {
    public static m70 a;

    public abstract int a(CharSequence charSequence);

    public abstract String a(ByteBuffer byteBuffer, int i, int i2);

    public abstract void a(CharSequence charSequence, ByteBuffer byteBuffer);

    public static class a {
        public static void a(byte b, byte b2, byte b3, char[] cArr, int i) throws IllegalArgumentException {
            if (a(b2) || ((b == -32 && b2 < -96) || ((b == -19 && b2 >= -96) || a(b3)))) {
                throw new IllegalArgumentException("Invalid UTF-8");
            }
            cArr[i] = (char) (((b & Ascii.SI) << 12) | ((b2 & 63) << 6) | (b3 & 63));
        }

        public static boolean a(byte b) {
            return b > -65;
        }

        public static void a(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) throws IllegalArgumentException {
            if (!a(b2)) {
                if ((((b2 + 112) + (b << Ascii.FS)) >> 30) == 0 && !a(b3) && !a(b4)) {
                    int i2 = ((b & 7) << 18) | ((b2 & 63) << 12) | ((b3 & 63) << 6) | (b4 & 63);
                    cArr[i] = (char) ((i2 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                    cArr[i + 1] = (char) ((i2 & 1023) + 56320);
                    return;
                }
            }
            throw new IllegalArgumentException("Invalid UTF-8");
        }
    }
}
