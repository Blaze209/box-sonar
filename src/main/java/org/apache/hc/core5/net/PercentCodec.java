package org.apache.hc.core5.net;

import com.google.common.base.Ascii;
import com.yubico.yubikit.core.fido.CtapException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.BitSet;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes5.dex */
public class PercentCodec {
    static final BitSet GEN_DELIMS;
    private static final int RADIX = 16;
    public static final PercentCodec RFC3986;
    public static final PercentCodec RFC5987;
    static final BitSet RFC5987_UNRESERVED;
    static final BitSet SUB_DELIMS;
    static final BitSet UNRESERVED;
    static final BitSet URIC;
    private final BitSet unreserved;

    static {
        BitSet bitSet = new BitSet(256);
        GEN_DELIMS = bitSet;
        BitSet bitSet2 = new BitSet(256);
        SUB_DELIMS = bitSet2;
        UNRESERVED = new BitSet(256);
        URIC = new BitSet(256);
        bitSet.set(58);
        bitSet.set(47);
        bitSet.set(63);
        bitSet.set(35);
        bitSet.set(91);
        bitSet.set(93);
        bitSet.set(64);
        bitSet2.set(33);
        bitSet2.set(36);
        bitSet2.set(38);
        bitSet2.set(39);
        bitSet2.set(40);
        bitSet2.set(41);
        bitSet2.set(42);
        bitSet2.set(43);
        bitSet2.set(44);
        bitSet2.set(59);
        bitSet2.set(61);
        for (int i = 97; i <= 122; i++) {
            UNRESERVED.set(i);
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            UNRESERVED.set(i2);
        }
        for (int i3 = 48; i3 <= 57; i3++) {
            UNRESERVED.set(i3);
        }
        BitSet bitSet3 = UNRESERVED;
        bitSet3.set(45);
        bitSet3.set(46);
        bitSet3.set(95);
        bitSet3.set(126);
        BitSet bitSet4 = URIC;
        bitSet4.or(SUB_DELIMS);
        bitSet4.or(bitSet3);
        RFC5987_UNRESERVED = new BitSet(256);
        for (int i4 = 97; i4 <= 122; i4++) {
            RFC5987_UNRESERVED.set(i4);
        }
        for (int i5 = 65; i5 <= 90; i5++) {
            RFC5987_UNRESERVED.set(i5);
        }
        for (int i6 = 48; i6 <= 57; i6++) {
            RFC5987_UNRESERVED.set(i6);
        }
        BitSet bitSet5 = RFC5987_UNRESERVED;
        bitSet5.set(33);
        bitSet5.set(35);
        bitSet5.set(36);
        bitSet5.set(38);
        bitSet5.set(43);
        bitSet5.set(45);
        bitSet5.set(46);
        bitSet5.set(94);
        bitSet5.set(95);
        bitSet5.set(96);
        bitSet5.set(124);
        bitSet5.set(126);
        RFC3986 = new PercentCodec(UNRESERVED);
        RFC5987 = new PercentCodec(bitSet5);
    }

    static void encode(StringBuilder sb, CharSequence charSequence, Charset charset, BitSet bitSet, boolean z) {
        if (charSequence == null) {
            return;
        }
        CharBuffer charBufferWrap = CharBuffer.wrap(charSequence);
        if (charset == null) {
            charset = StandardCharsets.UTF_8;
        }
        ByteBuffer byteBufferEncode = charset.encode(charBufferWrap);
        while (byteBufferEncode.hasRemaining()) {
            byte b = byteBufferEncode.get();
            int i = b & 255;
            if (bitSet.get(i)) {
                sb.append((char) i);
            } else if (z && i == 32) {
                sb.append(Marker.ANY_NON_NULL_MARKER);
            } else {
                sb.append("%");
                char upperCase = Character.toUpperCase(Character.forDigit((i >> 4) & 15, 16));
                char upperCase2 = Character.toUpperCase(Character.forDigit(b & Ascii.SI, 16));
                sb.append(upperCase);
                sb.append(upperCase2);
            }
        }
    }

    static void encode(StringBuilder sb, CharSequence charSequence, Charset charset, boolean z) {
        encode(sb, charSequence, charset, UNRESERVED, z);
    }

    public static void encode(StringBuilder sb, CharSequence charSequence, Charset charset) {
        encode(sb, charSequence, charset, UNRESERVED, false);
    }

    public static String encode(CharSequence charSequence, Charset charset) {
        if (charSequence == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        encode(sb, charSequence, charset, UNRESERVED, false);
        return sb.toString();
    }

    static String decode(CharSequence charSequence, Charset charset, boolean z) {
        if (charSequence == null) {
            return null;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(charSequence.length());
        CharBuffer charBufferWrap = CharBuffer.wrap(charSequence);
        while (charBufferWrap.hasRemaining()) {
            char c = charBufferWrap.get();
            if (c == '%' && charBufferWrap.remaining() >= 2) {
                char c2 = charBufferWrap.get();
                char c3 = charBufferWrap.get();
                int iDigit = Character.digit(c2, 16);
                int iDigit2 = Character.digit(c3, 16);
                if (iDigit != -1 && iDigit2 != -1) {
                    byteBufferAllocate.put((byte) ((iDigit << 4) + iDigit2));
                } else {
                    byteBufferAllocate.put(CtapException.ERR_NO_OPERATIONS);
                    byteBufferAllocate.put((byte) c2);
                    byteBufferAllocate.put((byte) c3);
                }
            } else if (z && c == '+') {
                byteBufferAllocate.put((byte) 32);
            } else {
                byteBufferAllocate.put((byte) c);
            }
        }
        byteBufferAllocate.flip();
        if (charset == null) {
            charset = StandardCharsets.UTF_8;
        }
        return charset.decode(byteBufferAllocate).toString();
    }

    public static String decode(CharSequence charSequence, Charset charset) {
        return decode(charSequence, charset, false);
    }

    private PercentCodec(BitSet bitSet) {
        this.unreserved = bitSet;
    }

    public PercentCodec() {
        this.unreserved = UNRESERVED;
    }

    public void encode(StringBuilder sb, CharSequence charSequence) {
        encode(sb, charSequence, StandardCharsets.UTF_8, this.unreserved, false);
    }

    public String encode(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        encode(sb, charSequence, StandardCharsets.UTF_8, this.unreserved, false);
        return sb.toString();
    }

    public String decode(CharSequence charSequence) {
        return decode(charSequence, StandardCharsets.UTF_8, false);
    }
}
