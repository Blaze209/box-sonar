package com.pspdfkit.internal;

import androidx.media3.extractor.ts.PsExtractor;
import androidx.window.core.layout.WindowSizeClass;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public final class m70 extends l70 {

    public static class a extends IllegalArgumentException {
        public a(int i, int i2) {
            super("Unpaired surrogate at index " + i + " of " + i2);
        }
    }

    @Override // com.pspdfkit.internal.l70
    public final int a(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (i2 < length) {
            char cCharAt = charSequence.charAt(i2);
            if (cCharAt >= 2048) {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char cCharAt2 = charSequence.charAt(i2);
                    if (cCharAt2 < 2048) {
                        i += (127 - cCharAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= cCharAt2 && cCharAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) < 65536) {
                                throw new a(i2, length2);
                            }
                            i2++;
                        }
                    }
                    i2++;
                }
                i3 += i;
                break;
            }
            i3 += (127 - cCharAt) >>> 31;
            i2++;
        }
        if (i3 >= length) {
            return i3;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i3) + 4294967296L));
    }

    @Override // com.pspdfkit.internal.l70
    public final String a(ByteBuffer byteBuffer, int i, int i2) throws IllegalArgumentException {
        if (byteBuffer.hasArray()) {
            byte[] bArrArray = byteBuffer.array();
            int iArrayOffset = byteBuffer.arrayOffset() + i;
            if ((iArrayOffset | i2 | ((bArrArray.length - iArrayOffset) - i2)) >= 0) {
                int i3 = iArrayOffset + i2;
                char[] cArr = new char[i2];
                int i4 = 0;
                while (iArrayOffset < i3) {
                    byte b = bArrArray[iArrayOffset];
                    if (b < 0) {
                        break;
                    }
                    iArrayOffset++;
                    cArr[i4] = (char) b;
                    i4++;
                }
                while (iArrayOffset < i3) {
                    int i5 = iArrayOffset + 1;
                    byte b2 = bArrArray[iArrayOffset];
                    if (b2 >= 0) {
                        cArr[i4] = (char) b2;
                        i4++;
                        iArrayOffset = i5;
                        while (iArrayOffset < i3) {
                            byte b3 = bArrArray[iArrayOffset];
                            if (b3 < 0) {
                                break;
                            }
                            iArrayOffset++;
                            cArr[i4] = (char) b3;
                            i4++;
                        }
                    } else if (b2 < -32) {
                        if (i5 < i3) {
                            iArrayOffset += 2;
                            byte b4 = bArrArray[i5];
                            int i6 = i4 + 1;
                            if (b2 >= -62) {
                                if (!l70.a.a(b4)) {
                                    cArr[i4] = (char) ((b4 & 63) | ((b2 & Ascii.US) << 6));
                                    i4 = i6;
                                } else {
                                    throw new IllegalArgumentException("Invalid UTF-8: Illegal trailing byte in 2 bytes utf");
                                }
                            } else {
                                throw new IllegalArgumentException("Invalid UTF-8: Illegal leading byte in 2 bytes utf");
                            }
                        } else {
                            throw new IllegalArgumentException("Invalid UTF-8");
                        }
                    } else if (b2 < -16) {
                        if (i5 < i3 - 1) {
                            int i7 = iArrayOffset + 2;
                            iArrayOffset += 3;
                            l70.a.a(b2, bArrArray[i5], bArrArray[i7], cArr, i4);
                            i4++;
                        } else {
                            throw new IllegalArgumentException("Invalid UTF-8");
                        }
                    } else if (i5 < i3 - 2) {
                        byte b5 = bArrArray[i5];
                        int i8 = iArrayOffset + 3;
                        byte b6 = bArrArray[iArrayOffset + 2];
                        iArrayOffset += 4;
                        l70.a.a(b2, b5, b6, bArrArray[i8], cArr, i4);
                        i4 += 2;
                    } else {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                }
                return new String(cArr, 0, i4);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArrArray.length), Integer.valueOf(iArrayOffset), Integer.valueOf(i2)));
        }
        if ((i | i2 | ((byteBuffer.limit() - i) - i2)) >= 0) {
            int i9 = i + i2;
            char[] cArr2 = new char[i2];
            int i10 = i;
            int i11 = 0;
            while (i10 < i9) {
                byte b7 = byteBuffer.get(i10);
                if (b7 < 0) {
                    break;
                }
                i10++;
                cArr2[i11] = (char) b7;
                i11++;
            }
            int i12 = i11;
            while (i10 < i9) {
                int i13 = i10 + 1;
                byte b8 = byteBuffer.get(i10);
                if (b8 >= 0) {
                    cArr2[i12] = (char) b8;
                    i12++;
                    i10 = i13;
                    while (i10 < i9) {
                        byte b9 = byteBuffer.get(i10);
                        if (b9 < 0) {
                            break;
                        }
                        i10++;
                        cArr2[i12] = (char) b9;
                        i12++;
                    }
                } else if (b8 < -32) {
                    if (i13 < i9) {
                        i10 += 2;
                        byte b10 = byteBuffer.get(i13);
                        int i14 = i12 + 1;
                        if (b8 >= -62) {
                            if (!l70.a.a(b10)) {
                                cArr2[i12] = (char) ((b10 & 63) | ((b8 & Ascii.US) << 6));
                                i12 = i14;
                            } else {
                                throw new IllegalArgumentException("Invalid UTF-8: Illegal trailing byte in 2 bytes utf");
                            }
                        } else {
                            throw new IllegalArgumentException("Invalid UTF-8: Illegal leading byte in 2 bytes utf");
                        }
                    } else {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                } else if (b8 < -16) {
                    if (i13 < i9 - 1) {
                        int i15 = i10 + 2;
                        i10 += 3;
                        l70.a.a(b8, byteBuffer.get(i13), byteBuffer.get(i15), cArr2, i12);
                        i12++;
                    } else {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                } else if (i13 < i9 - 2) {
                    byte b11 = byteBuffer.get(i13);
                    int i16 = i10 + 3;
                    byte b12 = byteBuffer.get(i10 + 2);
                    i10 += 4;
                    l70.a.a(b8, b11, b12, byteBuffer.get(i16), cArr2, i12);
                    i12 += 2;
                } else {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
            }
            return new String(cArr2, 0, i12);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i2)));
    }

    @Override // com.pspdfkit.internal.l70
    public final void a(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i;
        int i2;
        int i3;
        int i4;
        char cCharAt;
        char c = 2048;
        int i5 = 0;
        char c2 = 57343;
        if (byteBuffer.hasArray()) {
            int iArrayOffset = byteBuffer.arrayOffset();
            byte[] bArrArray = byteBuffer.array();
            int iPosition = byteBuffer.position() + iArrayOffset;
            int iRemaining = byteBuffer.remaining();
            int length = charSequence.length();
            int i6 = iRemaining + iPosition;
            while (i5 < length) {
                int i7 = i5 + iPosition;
                if (i7 >= i6 || (cCharAt = charSequence.charAt(i5)) >= 128) {
                    break;
                }
                bArrArray[i7] = (byte) cCharAt;
                i5++;
            }
            if (i5 == length) {
                i3 = iPosition + length;
            } else {
                i3 = iPosition + i5;
                while (i5 < length) {
                    char cCharAt2 = charSequence.charAt(i5);
                    if (cCharAt2 < 128 && i3 < i6) {
                        bArrArray[i3] = (byte) cCharAt2;
                        i3++;
                    } else if (cCharAt2 < c && i3 <= i6 - 2) {
                        int i8 = i3 + 1;
                        bArrArray[i3] = (byte) ((cCharAt2 >>> 6) | 960);
                        i3 += 2;
                        bArrArray[i8] = (byte) ((cCharAt2 & '?') | 128);
                    } else {
                        if ((cCharAt2 >= 55296 && c2 >= cCharAt2) || i3 > i6 - 3) {
                            if (i3 <= i6 - 4) {
                                int i9 = i5 + 1;
                                if (i9 != charSequence.length()) {
                                    char cCharAt3 = charSequence.charAt(i9);
                                    if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                        int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                        bArrArray[i3] = (byte) ((codePoint >>> 18) | PsExtractor.VIDEO_STREAM_MASK);
                                        bArrArray[i3 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                                        int i10 = i3 + 3;
                                        bArrArray[i3 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                                        i3 += 4;
                                        bArrArray[i10] = (byte) ((codePoint & 63) | 128);
                                        i5 = i9;
                                    } else {
                                        i5 = i9;
                                    }
                                }
                                throw new a(i5 - 1, length);
                            }
                            if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i4 = i5 + 1) == charSequence.length() || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i4)))) {
                                throw new a(i5, length);
                            }
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i3);
                        }
                        bArrArray[i3] = (byte) ((cCharAt2 >>> '\f') | WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND);
                        int i11 = i3 + 2;
                        bArrArray[i3 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                        i3 += 3;
                        bArrArray[i11] = (byte) ((cCharAt2 & '?') | 128);
                    }
                    i5++;
                    c = 2048;
                    c2 = 57343;
                }
            }
            byteBuffer.position(i3 - iArrayOffset);
            return;
        }
        int length2 = charSequence.length();
        int iPosition2 = byteBuffer.position();
        while (i5 < length2) {
            try {
                char cCharAt4 = charSequence.charAt(i5);
                if (cCharAt4 >= 128) {
                    break;
                }
                byteBuffer.put(iPosition2 + i5, (byte) cCharAt4);
                i5++;
            } catch (IndexOutOfBoundsException unused) {
                i = iPosition2;
            }
        }
        if (i5 == length2) {
            byteBuffer.position(iPosition2 + i5);
            return;
        }
        int i12 = iPosition2 + i5;
        while (i5 < length2) {
            char cCharAt5 = charSequence.charAt(i5);
            if (cCharAt5 < 128) {
                byteBuffer.put(i12, (byte) cCharAt5);
            } else {
                if (cCharAt5 < 2048) {
                    i2 = i12 + 1;
                    try {
                        byteBuffer.put(i12, (byte) ((cCharAt5 >>> 6) | 192));
                        byteBuffer.put(i2, (byte) ((cCharAt5 & '?') | 128));
                        i12 = i2;
                    } catch (IndexOutOfBoundsException unused2) {
                    }
                } else {
                    if (cCharAt5 >= 55296 && 57343 >= cCharAt5) {
                        int i13 = i5 + 1;
                        if (i13 != length2) {
                            try {
                                char cCharAt6 = charSequence.charAt(i13);
                                if (Character.isSurrogatePair(cCharAt5, cCharAt6)) {
                                    int codePoint2 = Character.toCodePoint(cCharAt5, cCharAt6);
                                    i = i12 + 1;
                                    try {
                                        byteBuffer.put(i12, (byte) ((codePoint2 >>> 18) | PsExtractor.VIDEO_STREAM_MASK));
                                        int i14 = i12 + 2;
                                        try {
                                            byteBuffer.put(i, (byte) (((codePoint2 >>> 12) & 63) | 128));
                                            i12 += 3;
                                            byteBuffer.put(i14, (byte) (((codePoint2 >>> 6) & 63) | 128));
                                            byteBuffer.put(i12, (byte) ((codePoint2 & 63) | 128));
                                            i5 = i13;
                                        } catch (IndexOutOfBoundsException unused3) {
                                            i5 = i13;
                                            i = i14;
                                        }
                                    } catch (IndexOutOfBoundsException unused4) {
                                        i5 = i13;
                                    }
                                } else {
                                    i5 = i13;
                                }
                            } catch (IndexOutOfBoundsException unused5) {
                                i = i12;
                            }
                            i5 = i13;
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i5) + " at index " + (Math.max(i5, (i - byteBuffer.position()) + 1) + byteBuffer.position()));
                        }
                        throw new a(i5, length2);
                    }
                    int i15 = i12 + 1;
                    try {
                        byteBuffer.put(i12, (byte) ((cCharAt5 >>> '\f') | 224));
                        i12 += 2;
                        byteBuffer.put(i15, (byte) (((cCharAt5 >>> 6) & 63) | 128));
                        byteBuffer.put(i12, (byte) ((cCharAt5 & '?') | 128));
                    } catch (IndexOutOfBoundsException unused6) {
                        i2 = i15;
                    }
                    i5++;
                    i12++;
                }
                i = i2;
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i5) + " at index " + (Math.max(i5, (i - byteBuffer.position()) + 1) + byteBuffer.position()));
            }
            i5++;
            i12++;
        }
        byteBuffer.position(i12);
    }
}
