package com.google.android.gms.internal.measurement;

import androidx.media3.extractor.ts.PsExtractor;
import androidx.window.core.layout.WindowSizeClass;
import com.google.common.base.Ascii;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
final class zzik extends zzif {
    zzik() {
    }

    @Override // com.google.android.gms.internal.measurement.zzif
    final int zza(int i, byte[] bArr, int i2, int i3) {
        int i4;
        long j;
        if ((i2 | i3 | (bArr.length - i3)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
        }
        long j2 = i2;
        int i5 = (int) (((long) i3) - j2);
        byte b = 0;
        long j3 = 1;
        if (i5 >= 16) {
            long j4 = j2;
            i4 = 0;
            while (true) {
                if (i4 >= i5) {
                    i4 = i5;
                    break;
                }
                long j5 = j4 + 1;
                if (zzib.zza(bArr, j4) < 0) {
                    break;
                }
                i4++;
                j4 = j5;
            }
        } else {
            i4 = 0;
        }
        int i6 = i5 - i4;
        long j6 = j2 + ((long) i4);
        while (true) {
            byte bZza = b;
            while (i6 > 0) {
                long j7 = j6 + j3;
                bZza = zzib.zza(bArr, j6);
                if (bZza < 0) {
                    j6 = j7;
                    break;
                }
                i6--;
                j6 = j7;
            }
            if (i6 == 0) {
                return b;
            }
            int i7 = i6 - 1;
            if (bZza < -32) {
                if (i7 == 0) {
                    return bZza;
                }
                i6 -= 2;
                if (bZza >= -62) {
                    long j8 = j6 + j3;
                    if (zzib.zza(bArr, j6) <= -65) {
                        j = j3;
                        j6 = j8;
                    }
                }
                return -1;
            }
            if (bZza >= -16) {
                j = j3;
                if (i7 < 3) {
                    return zza(bArr, bZza, j6, i7);
                }
                i6 -= 4;
                long j9 = j6 + j;
                byte bZza2 = zzib.zza(bArr, j6);
                if (bZza2 <= -65 && (((bZza << Ascii.FS) + (bZza2 + 112)) >> 30) == 0) {
                    long j10 = 2 + j6;
                    if (zzib.zza(bArr, j9) <= -65) {
                        j6 += 3;
                        if (zzib.zza(bArr, j10) > -65) {
                        }
                    }
                }
                return -1;
            }
            if (i7 < 2) {
                return zza(bArr, bZza, j6, i7);
            }
            i6 -= 3;
            j = j3;
            long j11 = j6 + j;
            byte bZza3 = zzib.zza(bArr, j6);
            if (bZza3 <= -65 && ((bZza != -32 || bZza3 >= -96) && (bZza != -19 || bZza3 < -96))) {
                j6 += 2;
                if (zzib.zza(bArr, j11) > -65) {
                }
            }
            return -1;
            j3 = j;
            b = 0;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzif
    final String zzb(byte[] bArr, int i, int i2) throws zzfo {
        if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        while (i < i3) {
            byte bZza = zzib.zza(bArr, i);
            if (!zzig.zzd(bZza)) {
                break;
            }
            i++;
            zzig.zzb(bZza, cArr, i4);
            i4++;
        }
        int i5 = i4;
        while (i < i3) {
            int i6 = i + 1;
            byte bZza2 = zzib.zza(bArr, i);
            if (zzig.zzd(bZza2)) {
                int i7 = i5 + 1;
                zzig.zzb(bZza2, cArr, i5);
                while (i6 < i3) {
                    byte bZza3 = zzib.zza(bArr, i6);
                    if (!zzig.zzd(bZza3)) {
                        break;
                    }
                    i6++;
                    zzig.zzb(bZza3, cArr, i7);
                    i7++;
                }
                i5 = i7;
                i = i6;
            } else if (zzig.zze(bZza2)) {
                if (i6 >= i3) {
                    throw zzfo.zzh();
                }
                i += 2;
                zzig.zzb(bZza2, zzib.zza(bArr, i6), cArr, i5);
                i5++;
            } else if (zzig.zzf(bZza2)) {
                if (i6 < i3 - 1) {
                    int i8 = i + 2;
                    i += 3;
                    zzig.zzb(bZza2, zzib.zza(bArr, i6), zzib.zza(bArr, i8), cArr, i5);
                    i5++;
                } else {
                    throw zzfo.zzh();
                }
            } else {
                if (i6 >= i3 - 2) {
                    throw zzfo.zzh();
                }
                byte bZza4 = zzib.zza(bArr, i6);
                int i9 = i + 3;
                byte bZza5 = zzib.zza(bArr, i + 2);
                i += 4;
                zzig.zzb(bZza2, bZza4, bZza5, zzib.zza(bArr, i9), cArr, i5);
                i5 += 2;
            }
        }
        return new String(cArr, 0, i5);
    }

    @Override // com.google.android.gms.internal.measurement.zzif
    final int zza(CharSequence charSequence, byte[] bArr, int i, int i2) {
        long j;
        long j2;
        long j3;
        int i3;
        char cCharAt;
        long j4 = i;
        long j5 = ((long) i2) + j4;
        int length = charSequence.length();
        if (length > i2 || bArr.length - i2 < i) {
            throw new ArrayIndexOutOfBoundsException(new StringBuilder(37).append("Failed writing ").append(charSequence.charAt(length - 1)).append(" at index ").append(i + i2).toString());
        }
        int i4 = 0;
        while (true) {
            j = 1;
            if (i4 >= length || (cCharAt = charSequence.charAt(i4)) >= 128) {
                break;
            }
            zzib.zza(bArr, j4, (byte) cCharAt);
            i4++;
            j4 = 1 + j4;
        }
        if (i4 == length) {
            return (int) j4;
        }
        while (i4 < length) {
            char cCharAt2 = charSequence.charAt(i4);
            if (cCharAt2 < 128 && j4 < j5) {
                zzib.zza(bArr, j4, (byte) cCharAt2);
                j3 = j5;
                j2 = j;
                j4 += j;
            } else if (cCharAt2 >= 2048 || j4 > j5 - 2) {
                j2 = j;
                if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || j4 > j5 - 3) {
                    j3 = j5;
                    if (j4 <= j3 - 4) {
                        int i5 = i4 + 1;
                        if (i5 != length) {
                            char cCharAt3 = charSequence.charAt(i5);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                zzib.zza(bArr, j4, (byte) ((codePoint >>> 18) | PsExtractor.VIDEO_STREAM_MASK));
                                zzib.zza(bArr, j4 + j2, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j6 = j4 + 3;
                                zzib.zza(bArr, j4 + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                j4 += 4;
                                zzib.zza(bArr, j6, (byte) ((codePoint & 63) | 128));
                                i4 = i5;
                            } else {
                                i4 = i5;
                            }
                        }
                        throw new zzih(i4 - 1, length);
                    }
                    if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i3 = i4 + 1) == length || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i3)))) {
                        throw new zzih(i4, length);
                    }
                    throw new ArrayIndexOutOfBoundsException(new StringBuilder(46).append("Failed writing ").append(cCharAt2).append(" at index ").append(j4).toString());
                }
                zzib.zza(bArr, j4, (byte) ((cCharAt2 >>> '\f') | WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND));
                long j7 = j4 + 2;
                j3 = j5;
                zzib.zza(bArr, j4 + j2, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                j4 += 3;
                zzib.zza(bArr, j7, (byte) ((cCharAt2 & '?') | 128));
            } else {
                j2 = j;
                long j8 = j4 + j2;
                zzib.zza(bArr, j4, (byte) ((cCharAt2 >>> 6) | 960));
                j4 += 2;
                zzib.zza(bArr, j8, (byte) ((cCharAt2 & '?') | 128));
                j3 = j5;
            }
            i4++;
            j = j2;
            j5 = j3;
        }
        return (int) j4;
    }

    private static int zza(byte[] bArr, int i, long j, int i2) {
        if (i2 == 0) {
            return zzie.zzb(i);
        }
        if (i2 == 1) {
            return zzie.zzb(i, zzib.zza(bArr, j));
        }
        if (i2 == 2) {
            return zzie.zzb(i, zzib.zza(bArr, j), zzib.zza(bArr, j + 1));
        }
        throw new AssertionError();
    }
}
