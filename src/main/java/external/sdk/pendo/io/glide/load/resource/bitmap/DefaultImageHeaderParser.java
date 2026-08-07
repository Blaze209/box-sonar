package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.util.Log;
import external.sdk.pendo.io.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import sdk.pendo.io.y.k;

/* JADX INFO: loaded from: classes4.dex */
public final class DefaultImageHeaderParser implements ImageHeaderParser {
    static final int APP2_SEGMENT_TYPE = 226;
    private static final int AVIF_BRAND = 1635150182;
    private static final int AVIS_BRAND = 1635150195;
    static final int EXIF_MAGIC_NUMBER = 65496;
    static final int EXIF_SEGMENT_TYPE = 225;
    private static final int FTYP_HEADER = 1718909296;
    private static final int GIF_HEADER = 4671814;
    private static final int INTEL_TIFF_MAGIC_NUMBER = 18761;
    private static final int MARKER_EOI = 217;
    private static final int MOTOROLA_TIFF_MAGIC_NUMBER = 19789;
    private static final int ORIENTATION_TAG_TYPE = 274;
    private static final int PNG_HEADER = -1991225785;
    private static final int RIFF_HEADER = 1380533830;
    private static final int SEGMENT_SOS = 218;
    static final int SEGMENT_START_ID = 255;
    private static final String TAG = "DfltImageHeaderParser";
    private static final int VP8_HEADER = 1448097792;
    private static final int VP8_HEADER_MASK = -256;
    private static final int VP8_HEADER_TYPE_EXTENDED = 88;
    private static final int VP8_HEADER_TYPE_LOSSLESS = 76;
    private static final int VP8_HEADER_TYPE_MASK = 255;
    private static final int WEBP_EXTENDED_ALPHA_FLAG = 16;
    private static final int WEBP_EXTENDED_ANIMATION_FLAG = 2;
    private static final int WEBP_HEADER = 1464156752;
    private static final int WEBP_LOSSLESS_ALPHA_FLAG = 8;
    private static final String JPEG_EXIF_SEGMENT_PREAMBLE = "Exif\u0000\u0000";
    static final byte[] JPEG_EXIF_SEGMENT_PREAMBLE_BYTES = JPEG_EXIF_SEGMENT_PREAMBLE.getBytes(Charset.forName("UTF-8"));
    private static final String JPEG_MPF_SEGMENT_PREAMBLE = "MPF";
    static final byte[] JPEG_MPF_SEGMENT_PREAMBLE_BYTES = JPEG_MPF_SEGMENT_PREAMBLE.getBytes(Charset.forName("UTF-8"));
    private static final int[] BYTES_PER_FORMAT = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    private static final class a implements c {
        private final ByteBuffer a;

        a(ByteBuffer byteBuffer) {
            this.a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c
        public short a() throws c.a {
            if (this.a.remaining() >= 1) {
                return (short) (this.a.get() & 255);
            }
            throw new c.a();
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c
        public int b() {
            return a() | (a() << 8);
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c
        public long skip(long j) {
            int iMin = (int) Math.min(this.a.remaining(), j);
            ByteBuffer byteBuffer = this.a;
            byteBuffer.position(byteBuffer.position() + iMin);
            return iMin;
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c
        public int a(byte[] bArr, int i) {
            int iMin = Math.min(i, this.a.remaining());
            if (iMin == 0) {
                return -1;
            }
            this.a.get(bArr, 0, iMin);
            return iMin;
        }
    }

    private static final class b {
        private final ByteBuffer a;

        b(byte[] bArr, int i) {
            this.a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }

        short a(int i) {
            if (a(i, 2)) {
                return this.a.getShort(i);
            }
            return (short) -1;
        }

        int b(int i) {
            if (a(i, 4)) {
                return this.a.getInt(i);
            }
            return -1;
        }

        private boolean a(int i, int i2) {
            return this.a.remaining() - i >= i2;
        }

        int a() {
            return this.a.remaining();
        }

        void a(ByteOrder byteOrder) {
            this.a.order(byteOrder);
        }
    }

    private interface c {

        public static final class a extends IOException {
            a() {
                super("Unexpectedly reached end of a file");
            }
        }

        int a(byte[] bArr, int i);

        short a();

        int b();

        long skip(long j);
    }

    private static final class d implements c {
        private final InputStream a;

        d(InputStream inputStream) {
            this.a = inputStream;
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c
        public short a() throws IOException {
            int i = this.a.read();
            if (i != -1) {
                return (short) i;
            }
            throw new c.a();
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c
        public int b() {
            return a() | (a() << 8);
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c
        public long skip(long j) throws IOException {
            if (j < 0) {
                return 0L;
            }
            long j2 = j;
            while (j2 > 0) {
                long jSkip = this.a.skip(j2);
                if (jSkip <= 0) {
                    if (this.a.read() == -1) {
                        break;
                    }
                    jSkip = 1;
                }
                j2 -= jSkip;
            }
            return j - j2;
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c
        public int a(byte[] bArr, int i) throws c.a {
            int i2 = 0;
            int i3 = 0;
            while (i2 < i && (i3 = this.a.read(bArr, i2, i - i2)) != -1) {
                i2 += i3;
            }
            if (i2 == 0 && i3 == -1) {
                throw new c.a();
            }
            return i2;
        }
    }

    private static int calcTagOffset(int i, int i2) {
        return i + 2 + (i2 * 12);
    }

    private int getOrientation(c cVar, sdk.pendo.io.i.a aVar) {
        try {
            int iB = cVar.b();
            if (!handles(iB)) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Parser doesn't handle magic number: " + iB);
                }
                return -1;
            }
            int iMoveToExifSegmentAndGetLength = moveToExifSegmentAndGetLength(cVar);
            if (iMoveToExifSegmentAndGetLength == -1) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Failed to parse exif segment length, or exif segment not found");
                }
                return -1;
            }
            byte[] bArr = (byte[]) aVar.get(iMoveToExifSegmentAndGetLength, byte[].class);
            try {
                return parseExifSegment(cVar, bArr, iMoveToExifSegmentAndGetLength);
            } finally {
                aVar.put(bArr);
            }
        } catch (c.a unused) {
            return -1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0097, code lost:
    
        if ((r5.a() & 8) != 0) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private external.sdk.pendo.io.glide.load.ImageHeaderParser.ImageType getType(external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c r5) {
        /*
            r4 = this;
            int r0 = r5.b()     // Catch: external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c.a -> L9f
            r1 = 65496(0xffd8, float:9.178E-41)
            if (r0 != r1) goto Lc
            external.sdk.pendo.io.glide.load.ImageHeaderParser$ImageType r4 = external.sdk.pendo.io.glide.load.ImageHeaderParser.ImageType.JPEG     // Catch: external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c.a -> L9f
            return r4
        Lc:
            int r0 = r0 << 8
            short r1 = r5.a()     // Catch: external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c.a -> L9f
            r0 = r0 | r1
            r1 = 4671814(0x474946, float:6.546606E-39)
            if (r0 != r1) goto L1b
            external.sdk.pendo.io.glide.load.ImageHeaderParser$ImageType r4 = external.sdk.pendo.io.glide.load.ImageHeaderParser.ImageType.GIF     // Catch: external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c.a -> L9f
            return r4
        L1b:
            int r0 = r0 << 8
            short r1 = r5.a()     // Catch: external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c.a -> L9f
            r0 = r0 | r1
            r1 = -1991225785(0xffffffff89504e47, float:-2.5073895E-33)
            if (r0 != r1) goto L3c
            r0 = 21
            r5.skip(r0)     // Catch: external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c.a -> L9f
            short r4 = r5.a()     // Catch: external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c.a -> L39
            r5 = 3
            if (r4 < r5) goto L36
            external.sdk.pendo.io.glide.load.ImageHeaderParser$ImageType r4 = external.sdk.pendo.io.glide.load.ImageHeaderParser.ImageType.PNG_A     // Catch: external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c.a -> L39
            return r4
        L36:
            external.sdk.pendo.io.glide.load.ImageHeaderParser$ImageType r4 = external.sdk.pendo.io.glide.load.ImageHeaderParser.ImageType.PNG     // Catch: external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c.a -> L39
            return r4
        L39:
            external.sdk.pendo.io.glide.load.ImageHeaderParser$ImageType r4 = external.sdk.pendo.io.glide.load.ImageHeaderParser.ImageType.PNG     // Catch: external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c.a -> L9f
            return r4
        L3c:
            r1 = 1380533830(0x52494646, float:2.1611685E11)
            if (r0 == r1) goto L46
            external.sdk.pendo.io.glide.load.ImageHeaderParser$ImageType r4 = r4.sniffAvif(r5, r0)     // Catch: external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c.a -> L9f
            return r4
        L46:
            r0 = 4
            r5.skip(r0)     // Catch: external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c.a -> L9f
            int r4 = r5.b()     // Catch: external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c.a -> L9f
            int r4 = r4 << 16
            int r2 = r5.b()     // Catch: external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c.a -> L9f
            r4 = r4 | r2
            r2 = 1464156752(0x57454250, float:2.168886E14)
            if (r4 == r2) goto L5c
            goto L6e
        L5c:
            int r4 = r5.b()     // Catch: external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c.a -> L9f
            int r4 = r4 << 16
            int r2 = r5.b()     // Catch: external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c.a -> L9f
            r4 = r4 | r2
            r2 = r4 & (-256(0xffffffffffffff00, float:NaN))
            r3 = 1448097792(0x56503800, float:5.7234734E13)
            if (r2 == r3) goto L71
        L6e:
            external.sdk.pendo.io.glide.load.ImageHeaderParser$ImageType r4 = external.sdk.pendo.io.glide.load.ImageHeaderParser.ImageType.UNKNOWN     // Catch: external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c.a -> L9f
            return r4
        L71:
            r4 = r4 & 255(0xff, float:3.57E-43)
            r2 = 88
            if (r4 != r2) goto L8a
            r5.skip(r0)     // Catch: external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c.a -> L9f
            short r4 = r5.a()     // Catch: external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c.a -> L9f
            r5 = r4 & 2
            if (r5 == 0) goto L85
            external.sdk.pendo.io.glide.load.ImageHeaderParser$ImageType r4 = external.sdk.pendo.io.glide.load.ImageHeaderParser.ImageType.ANIMATED_WEBP     // Catch: external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c.a -> L9f
            return r4
        L85:
            r4 = r4 & 16
            if (r4 == 0) goto L9c
            goto L99
        L8a:
            r2 = 76
            if (r4 != r2) goto L9c
            r5.skip(r0)     // Catch: external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c.a -> L9f
            short r4 = r5.a()     // Catch: external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c.a -> L9f
            r4 = r4 & 8
            if (r4 == 0) goto L9c
        L99:
            external.sdk.pendo.io.glide.load.ImageHeaderParser$ImageType r4 = external.sdk.pendo.io.glide.load.ImageHeaderParser.ImageType.WEBP_A     // Catch: external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c.a -> L9f
            return r4
        L9c:
            external.sdk.pendo.io.glide.load.ImageHeaderParser$ImageType r4 = external.sdk.pendo.io.glide.load.ImageHeaderParser.ImageType.WEBP     // Catch: external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c.a -> L9f
            return r4
        L9f:
            external.sdk.pendo.io.glide.load.ImageHeaderParser$ImageType r4 = external.sdk.pendo.io.glide.load.ImageHeaderParser.ImageType.UNKNOWN
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.getType(external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser$c):external.sdk.pendo.io.glide.load.ImageHeaderParser$ImageType");
    }

    private static boolean handles(int i) {
        return (i & EXIF_MAGIC_NUMBER) == EXIF_MAGIC_NUMBER || i == MOTOROLA_TIFF_MAGIC_NUMBER || i == INTEL_TIFF_MAGIC_NUMBER;
    }

    private boolean hasJpegExifPreamble(byte[] bArr, int i) {
        return hasMatchingBytes(bArr, i, JPEG_EXIF_SEGMENT_PREAMBLE_BYTES);
    }

    private boolean hasJpegMpf(c cVar, sdk.pendo.io.i.a aVar) {
        boolean zHasJpegMpfPreamble;
        if (getType(cVar) != ImageHeaderParser.ImageType.JPEG) {
            return false;
        }
        do {
            int iMoveToApp2SegmentAndGetLength = moveToApp2SegmentAndGetLength(cVar);
            if (iMoveToApp2SegmentAndGetLength <= 0) {
                if (Log.isLoggable(TAG, 2)) {
                    Log.v(TAG, "hasMpf: Failed to parse APP2 segment length, or no APP2 segment with MPF metadata not found");
                }
                return false;
            }
            byte[] bArr = (byte[]) aVar.get(iMoveToApp2SegmentAndGetLength, byte[].class);
            try {
                zHasJpegMpfPreamble = hasJpegMpfPreamble(cVar, bArr, iMoveToApp2SegmentAndGetLength);
                aVar.put(bArr);
            } catch (Throwable th) {
                aVar.put(bArr);
                throw th;
            }
        } while (!zHasJpegMpfPreamble);
        return true;
    }

    private boolean hasJpegMpfPreamble(c cVar, byte[] bArr, int i) {
        int iA = cVar.a(bArr, i);
        if (iA == i) {
            return hasMatchingBytes(bArr, i, JPEG_MPF_SEGMENT_PREAMBLE_BYTES);
        }
        if (!Log.isLoggable(TAG, 3)) {
            return false;
        }
        Log.d(TAG, "Unable to read APP2 segment data, length: " + i + ", actually read: " + iA);
        return false;
    }

    private boolean hasMatchingBytes(byte[] bArr, int i, byte[] bArr2) {
        boolean z = (bArr == null || bArr2 == null || i <= bArr2.length) ? false : true;
        if (z) {
            for (int i2 = 0; i2 < bArr2.length; i2++) {
                if (bArr[i2] != bArr2[i2]) {
                    return false;
                }
            }
        }
        return z;
    }

    private int moveToApp2SegmentAndGetLength(c cVar) {
        return moveToSegmentAndGetLength(cVar, 226);
    }

    private int moveToExifSegmentAndGetLength(c cVar) {
        return moveToSegmentAndGetLength(cVar, 225);
    }

    private int moveToSegmentAndGetLength(c cVar, int i) {
        short sA;
        int iB;
        long j;
        long jSkip;
        do {
            short sA2 = cVar.a();
            if (sA2 != 255) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Unknown segmentId=" + ((int) sA2));
                }
                return -1;
            }
            sA = cVar.a();
            if (sA == 218) {
                return -1;
            }
            if (sA == 217) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Found MARKER_EOI in " + i + " segment");
                }
                return -1;
            }
            iB = cVar.b() - 2;
            if (sA == i) {
                return iB;
            }
            j = iB;
            jSkip = cVar.skip(j);
        } while (jSkip == j);
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "Unable to skip enough data, type: " + ((int) sA) + ", wanted to skip: " + iB + ", but actually skipped: " + jSkip);
        }
        return -1;
    }

    private static int parseExifSegment(b bVar) {
        ByteOrder byteOrder;
        StringBuilder sb;
        StringBuilder sbAppend;
        String string;
        StringBuilder sbAppend2;
        short sA = bVar.a(6);
        if (sA != INTEL_TIFF_MAGIC_NUMBER) {
            if (sA != MOTOROLA_TIFF_MAGIC_NUMBER && Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Unknown endianness = " + ((int) sA));
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        bVar.a(byteOrder);
        int iB = bVar.b(10) + 6;
        short sA2 = bVar.a(iB);
        for (int i = 0; i < sA2; i++) {
            int iCalcTagOffset = calcTagOffset(iB, i);
            short sA3 = bVar.a(iCalcTagOffset);
            if (sA3 == 274) {
                short sA4 = bVar.a(iCalcTagOffset + 2);
                if (sA4 >= 1 && sA4 <= 12) {
                    int iB2 = bVar.b(iCalcTagOffset + 4);
                    if (iB2 >= 0) {
                        if (Log.isLoggable(TAG, 3)) {
                            Log.d(TAG, "Got tagIndex=" + i + " tagType=" + ((int) sA3) + " formatCode=" + ((int) sA4) + " componentCount=" + iB2);
                        }
                        int i2 = iB2 + BYTES_PER_FORMAT[sA4];
                        if (i2 <= 4) {
                            int i3 = iCalcTagOffset + 8;
                            if (i3 >= 0 && i3 <= bVar.a()) {
                                if (i2 >= 0 && i2 + i3 <= bVar.a()) {
                                    return bVar.a(i3);
                                }
                                if (Log.isLoggable(TAG, 3)) {
                                    sbAppend2 = new StringBuilder("Illegal number of bytes for TI tag data tagType=");
                                    sbAppend = sbAppend2.append((int) sA3);
                                    string = sbAppend.toString();
                                    Log.d(TAG, string);
                                }
                            } else if (Log.isLoggable(TAG, 3)) {
                                sbAppend2 = new StringBuilder("Illegal tagValueOffset=").append(i3).append(" tagType=");
                                sbAppend = sbAppend2.append((int) sA3);
                                string = sbAppend.toString();
                                Log.d(TAG, string);
                            }
                        } else if (Log.isLoggable(TAG, 3)) {
                            sb = new StringBuilder("Got byte count > 4, not orientation, continuing, formatCode=");
                            sbAppend = sb.append((int) sA4);
                            string = sbAppend.toString();
                            Log.d(TAG, string);
                        }
                    } else if (Log.isLoggable(TAG, 3)) {
                        string = "Negative tiff component count";
                        Log.d(TAG, string);
                    }
                } else if (Log.isLoggable(TAG, 3)) {
                    sb = new StringBuilder("Got invalid format code = ");
                    sbAppend = sb.append((int) sA4);
                    string = sbAppend.toString();
                    Log.d(TAG, string);
                }
            }
        }
        return -1;
    }

    private ImageHeaderParser.ImageType sniffAvif(c cVar, int i) {
        if (((cVar.b() << 16) | cVar.b()) != 1718909296) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        int iB = (cVar.b() << 16) | cVar.b();
        if (iB == AVIS_BRAND) {
            return ImageHeaderParser.ImageType.ANIMATED_AVIF;
        }
        int i2 = 0;
        boolean z = iB == AVIF_BRAND;
        cVar.skip(4L);
        int i3 = i - 16;
        if (i3 % 4 == 0) {
            while (i2 < 5 && i3 > 0) {
                int iB2 = (cVar.b() << 16) | cVar.b();
                if (iB2 == AVIS_BRAND) {
                    return ImageHeaderParser.ImageType.ANIMATED_AVIF;
                }
                if (iB2 == AVIF_BRAND) {
                    z = true;
                }
                i2++;
                i3 -= 4;
            }
        }
        return z ? ImageHeaderParser.ImageType.AVIF : ImageHeaderParser.ImageType.UNKNOWN;
    }

    private int parseExifSegment(c cVar, byte[] bArr, int i) {
        int iA = cVar.a(bArr, i);
        if (iA != i) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Unable to read exif segment data, length: " + i + ", actually read: " + iA);
            }
            return -1;
        }
        if (hasJpegExifPreamble(bArr, i)) {
            return parseExifSegment(new b(bArr, i));
        }
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "Missing jpeg exif preamble");
        }
        return -1;
    }

    @Override // external.sdk.pendo.io.glide.load.ImageHeaderParser
    public int getOrientation(InputStream inputStream, sdk.pendo.io.i.a aVar) {
        return getOrientation(new d((InputStream) k.a(inputStream)), (sdk.pendo.io.i.a) k.a(aVar));
    }

    @Override // external.sdk.pendo.io.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType getType(InputStream inputStream) {
        return getType(new d((InputStream) k.a(inputStream)));
    }

    @Override // external.sdk.pendo.io.glide.load.ImageHeaderParser
    public boolean hasJpegMpf(InputStream inputStream, sdk.pendo.io.i.a aVar) {
        return hasJpegMpf(new d((InputStream) k.a(inputStream)), (sdk.pendo.io.i.a) k.a(aVar));
    }

    @Override // external.sdk.pendo.io.glide.load.ImageHeaderParser
    public int getOrientation(ByteBuffer byteBuffer, sdk.pendo.io.i.a aVar) {
        return getOrientation(new a((ByteBuffer) k.a(byteBuffer)), (sdk.pendo.io.i.a) k.a(aVar));
    }

    @Override // external.sdk.pendo.io.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType getType(ByteBuffer byteBuffer) {
        return getType(new a((ByteBuffer) k.a(byteBuffer)));
    }

    @Override // external.sdk.pendo.io.glide.load.ImageHeaderParser
    public boolean hasJpegMpf(ByteBuffer byteBuffer, sdk.pendo.io.i.a aVar) {
        return hasJpegMpf(new a((ByteBuffer) k.a(byteBuffer)), (sdk.pendo.io.i.a) k.a(aVar));
    }
}
