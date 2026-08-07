package androidx.media3.extractor.mp4;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.container.Mp4Box;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.SniffFailure;
import java.io.IOException;

/* JADX INFO: loaded from: classes8.dex */
public final class Sniffer {
    public static final int BRAND_HEIC = 1751476579;
    public static final int BRAND_QUICKTIME = 1903435808;
    private static final int[] COMPATIBLE_BRANDS = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, Mp4Box.TYPE_avc1, Mp4Box.TYPE_hvc1, Mp4Box.TYPE_hev1, Mp4Box.TYPE_av01, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, BRAND_QUICKTIME, 1297305174, 1684175153, 1769172332, 1885955686};
    private static final int SEARCH_LENGTH = 4096;

    public static SniffFailure sniffFragmented(ExtractorInput extractorInput) throws IOException {
        return sniffInternal(extractorInput, true, false);
    }

    public static SniffFailure sniffUnfragmented(ExtractorInput extractorInput, boolean z) throws IOException {
        return sniffInternal(extractorInput, false, z);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x016a  */
    /* JADX WARN: Code duplicated, block: B:102:0x016d  */
    /* JADX WARN: Code duplicated, block: B:104:0x0171 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:105:0x0173  */
    /* JADX WARN: Code duplicated, block: B:107:0x0176  */
    /* JADX WARN: Code duplicated, block: B:109:0x0179 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x0074  */
    /* JADX WARN: Multi-variable type inference failed */
    private static SniffFailure sniffInternal(ExtractorInput extractorInput, boolean z, boolean z2) throws IOException {
        SniffFailure sniffFailure;
        int i;
        int i2;
        int i3;
        long j;
        int i4;
        int[] iArr;
        long length = extractorInput.getLength();
        long j2 = -1;
        int i5 = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
        long j3 = 4096;
        if (i5 != 0 && length <= 4096) {
            j3 = length;
        }
        int i6 = (int) j3;
        ParsableByteArray parsableByteArray = new ParsableByteArray(64);
        int i7 = 0;
        int i8 = 0;
        boolean z3 = false;
        while (true) {
            if (i8 < i6) {
                parsableByteArray.reset(8);
                if (extractorInput.peekFully(parsableByteArray.getData(), i7, 8, true)) {
                    long unsignedInt = parsableByteArray.readUnsignedInt();
                    int i9 = parsableByteArray.readInt();
                    if (unsignedInt == 1) {
                        j2 = j2;
                        extractorInput.peekFully(parsableByteArray.getData(), 8, 8);
                        i2 = 16;
                        parsableByteArray.setLimit(16);
                        unsignedInt = parsableByteArray.readLong();
                        i8 = i8;
                    } else {
                        j2 = j2;
                        if (unsignedInt == 0) {
                            long length2 = extractorInput.getLength();
                            if (length2 != j2) {
                                unsignedInt = (length2 - extractorInput.getPeekPosition()) + ((long) 8);
                            }
                        }
                        i2 = 8;
                    }
                    long j4 = unsignedInt;
                    sniffFailure = null;
                    long j5 = i2;
                    if (j4 < j5) {
                        if (i9 != 1718773093 || i2 != 8) {
                            return new AtomSizeTooSmallSniffFailure(i9, j4, i2);
                        }
                        j4 = j5;
                    }
                    int i10 = i8 + i2;
                    if (i9 == 1836019574 || i9 == 1970628964) {
                        i6 += (int) j4;
                        i3 = i5;
                        if (i5 != 0 && i6 > length) {
                            i6 = (int) length;
                        }
                        if (i9 == 1836019574) {
                            i8 = i10;
                            i5 = i3;
                            i7 = 0;
                        }
                    } else {
                        i3 = i5;
                    }
                    if (i9 == 1953653099 || i9 == 1835297121 || i9 == 1835626086) {
                        j = length;
                        i4 = 0;
                        i8 = i10;
                    } else if (i9 == 1836019558 || i9 == 1836475768) {
                        i = 1;
                    } else {
                        if (i9 == 1835295092) {
                            z3 = true;
                        }
                        if (i9 != 1937007212 || j4 <= 1000000) {
                            j = length;
                            if ((((long) i10) + j4) - j5 < i6) {
                                int i11 = (int) (j4 - j5);
                                i8 = i10 + i11;
                                if (i9 != 1718909296) {
                                    i4 = 0;
                                    if (i11 != 0) {
                                        extractorInput.advancePeekPosition(i11);
                                    }
                                } else {
                                    if (i11 < 8) {
                                        return new AtomSizeTooSmallSniffFailure(i9, i11, 8);
                                    }
                                    parsableByteArray.reset(i11);
                                    i4 = 0;
                                    extractorInput.peekFully(parsableByteArray.getData(), 0, i11);
                                    int i12 = parsableByteArray.readInt();
                                    if (isCompatibleBrand(i12, z2)) {
                                        z3 = true;
                                    }
                                    parsableByteArray.skipBytes(4);
                                    int iBytesLeft = parsableByteArray.bytesLeft() / 4;
                                    if (z3 || iBytesLeft <= 0) {
                                        iArr = sniffFailure;
                                    } else {
                                        iArr = new int[iBytesLeft];
                                        for (int i13 = 0; i13 < iBytesLeft; i13++) {
                                            int i14 = parsableByteArray.readInt();
                                            iArr[i13] = i14;
                                            if (isCompatibleBrand(i14, z2)) {
                                                z3 = true;
                                                break;
                                            }
                                        }
                                    }
                                    if (!z3) {
                                        return new UnsupportedBrandsSniffFailure(i12, iArr);
                                    }
                                }
                            }
                        }
                        i = 0;
                    }
                    i7 = i4;
                    i5 = i3;
                    length = j;
                }
                if (!z3) {
                    return NoDeclaredBrandSniffFailure.INSTANCE;
                }
                if (z != i) {
                    return sniffFailure;
                }
                if (i != 0) {
                    return IncorrectFragmentationSniffFailure.FILE_FRAGMENTED;
                }
                return IncorrectFragmentationSniffFailure.FILE_NOT_FRAGMENTED;
            }
            sniffFailure = null;
            i = i7;
            if (!z3) {
                return NoDeclaredBrandSniffFailure.INSTANCE;
            }
            if (z != i) {
                return sniffFailure;
            }
            if (i != 0) {
                return IncorrectFragmentationSniffFailure.FILE_FRAGMENTED;
            }
            return IncorrectFragmentationSniffFailure.FILE_NOT_FRAGMENTED;
        }
    }

    private static boolean isCompatibleBrand(int i, boolean z) {
        if ((i >>> 8) == 3368816) {
            return true;
        }
        if (i == 1751476579 && z) {
            return true;
        }
        for (int i2 : COMPATIBLE_BRANDS) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private Sniffer() {
    }
}
