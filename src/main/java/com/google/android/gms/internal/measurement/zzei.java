package com.google.android.gms.internal.measurement;

import androidx.work.WorkInfo;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
final class zzei extends zzeg {
    private final byte[] zzd;
    private final boolean zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;

    private zzei(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzk = Integer.MAX_VALUE;
        this.zzd = bArr;
        this.zzf = i2 + i;
        this.zzh = i;
        this.zzi = i;
        this.zze = z;
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final int zza() throws IOException {
        if (zzt()) {
            this.zzj = 0;
            return 0;
        }
        int iZzv = zzv();
        this.zzj = iZzv;
        if ((iZzv >>> 3) != 0) {
            return iZzv;
        }
        throw zzfo.zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final void zza(int i) throws zzfo {
        if (this.zzj != i) {
            throw zzfo.zze();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final boolean zzb(int i) throws IOException {
        int iZza;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.zzf - this.zzh >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.zzd;
                    int i4 = this.zzh;
                    this.zzh = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw zzfo.zzc();
            }
            while (i3 < 10) {
                if (zzaa() < 0) {
                    i3++;
                }
            }
            throw zzfo.zzc();
            return true;
        }
        if (i2 == 1) {
            zzf(8);
            return true;
        }
        if (i2 == 2) {
            zzf(zzv());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 == 5) {
                zzf(4);
                return true;
            }
            throw zzfo.zzf();
        }
        do {
            iZza = zza();
            if (iZza == 0) {
                break;
            }
        } while (zzb(iZza));
        zza(((i >>> 3) << 3) | 4);
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final double zzb() throws IOException {
        return Double.longBitsToDouble(zzy());
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final float zzc() throws IOException {
        return Float.intBitsToFloat(zzx());
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final long zzd() throws IOException {
        return zzw();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final long zze() throws IOException {
        return zzw();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final int zzf() throws IOException {
        return zzv();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final long zzg() throws IOException {
        return zzy();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final int zzh() throws IOException {
        return zzx();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final boolean zzi() throws IOException {
        return zzw() != 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final String zzj() throws IOException {
        int iZzv = zzv();
        if (iZzv > 0 && iZzv <= this.zzf - this.zzh) {
            String str = new String(this.zzd, this.zzh, iZzv, zzff.zza);
            this.zzh += iZzv;
            return str;
        }
        if (iZzv == 0) {
            return "";
        }
        if (iZzv < 0) {
            throw zzfo.zzb();
        }
        throw zzfo.zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final String zzk() throws IOException {
        int iZzv = zzv();
        if (iZzv > 0) {
            int i = this.zzf;
            int i2 = this.zzh;
            if (iZzv <= i - i2) {
                String strZzb = zzie.zzb(this.zzd, i2, iZzv);
                this.zzh += iZzv;
                return strZzb;
            }
        }
        if (iZzv == 0) {
            return "";
        }
        if (iZzv <= 0) {
            throw zzfo.zzb();
        }
        throw zzfo.zza();
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0031 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:16:0x0033 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x0035  */
    /* JADX WARN: Code duplicated, block: B:20:0x003c  */
    /* JADX WARN: Code duplicated, block: B:22:0x0041  */
    @Override // com.google.android.gms.internal.measurement.zzeg
    public final zzdu zzl() throws IOException {
        byte[] bArrCopyOfRange;
        int iZzv = zzv();
        if (iZzv > 0) {
            int i = this.zzf;
            int i2 = this.zzh;
            if (iZzv <= i - i2) {
                zzdu zzduVarZza = zzdu.zza(this.zzd, i2, iZzv);
                this.zzh += iZzv;
                return zzduVarZza;
            }
        }
        if (iZzv == 0) {
            return zzdu.zza;
        }
        if (iZzv > 0) {
            int i3 = this.zzf;
            int i4 = this.zzh;
            if (iZzv <= i3 - i4) {
                int i5 = iZzv + i4;
                this.zzh = i5;
                bArrCopyOfRange = Arrays.copyOfRange(this.zzd, i4, i5);
            } else {
                if (iZzv <= 0) {
                    throw zzfo.zza();
                }
                if (iZzv == 0) {
                    bArrCopyOfRange = zzff.zzb;
                } else {
                    throw zzfo.zzb();
                }
            }
        } else {
            if (iZzv <= 0) {
                throw zzfo.zza();
            }
            if (iZzv == 0) {
                bArrCopyOfRange = zzff.zzb;
            } else {
                throw zzfo.zzb();
            }
        }
        return zzdu.zza(bArrCopyOfRange);
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final int zzm() throws IOException {
        return zzv();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final int zzn() throws IOException {
        return zzv();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final int zzo() throws IOException {
        return zzx();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final long zzp() throws IOException {
        return zzy();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final int zzq() throws IOException {
        return zze(zzv());
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final long zzr() throws IOException {
        return zza(zzw());
    }

    private final int zzv() throws IOException {
        int i;
        int i2 = this.zzh;
        int i3 = this.zzf;
        if (i3 != i2) {
            byte[] bArr = this.zzd;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.zzh = i4;
                return b;
            }
            if (i3 - i4 >= 9) {
                int i5 = i2 + 2;
                int i6 = (bArr[i4] << 7) ^ b;
                if (i6 < 0) {
                    i = i6 ^ WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
                } else {
                    int i7 = i2 + 3;
                    int i8 = (bArr[i5] << Ascii.SO) ^ i6;
                    if (i8 >= 0) {
                        i = i8 ^ 16256;
                    } else {
                        int i9 = i2 + 4;
                        int i10 = i8 ^ (bArr[i7] << 21);
                        if (i10 < 0) {
                            i = (-2080896) ^ i10;
                        } else {
                            i7 = i2 + 5;
                            byte b2 = bArr[i9];
                            int i11 = (i10 ^ (b2 << Ascii.FS)) ^ 266354560;
                            if (b2 < 0) {
                                i9 = i2 + 6;
                                if (bArr[i7] < 0) {
                                    i7 = i2 + 7;
                                    if (bArr[i9] < 0) {
                                        i9 = i2 + 8;
                                        if (bArr[i7] < 0) {
                                            i7 = i2 + 9;
                                            if (bArr[i9] < 0) {
                                                int i12 = i2 + 10;
                                                if (bArr[i7] >= 0) {
                                                    i5 = i12;
                                                    i = i11;
                                                }
                                            }
                                        }
                                    }
                                }
                                i = i11;
                            }
                            i = i11;
                        }
                        i5 = i9;
                    }
                    i5 = i7;
                }
                this.zzh = i5;
                return i;
            }
        }
        return (int) zzs();
    }

    private final long zzw() throws IOException {
        long j;
        long j2;
        long j3;
        int i = this.zzh;
        int i2 = this.zzf;
        if (i2 != i) {
            byte[] bArr = this.zzd;
            int i3 = i + 1;
            byte b = bArr[i];
            if (b >= 0) {
                this.zzh = i3;
                return b;
            }
            if (i2 - i3 >= 9) {
                int i4 = i + 2;
                int i5 = (bArr[i3] << 7) ^ b;
                if (i5 < 0) {
                    j = i5 ^ WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
                } else {
                    int i6 = i + 3;
                    int i7 = (bArr[i4] << Ascii.SO) ^ i5;
                    if (i7 >= 0) {
                        j = i7 ^ 16256;
                        i4 = i6;
                    } else {
                        int i8 = i + 4;
                        int i9 = i7 ^ (bArr[i6] << 21);
                        if (i9 < 0) {
                            long j4 = (-2080896) ^ i9;
                            i4 = i8;
                            j = j4;
                        } else {
                            long j5 = i9;
                            i4 = i + 5;
                            long j6 = j5 ^ (((long) bArr[i8]) << 28);
                            if (j6 >= 0) {
                                j3 = 266354560;
                            } else {
                                int i10 = i + 6;
                                long j7 = j6 ^ (((long) bArr[i4]) << 35);
                                if (j7 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    i4 = i + 7;
                                    j6 = j7 ^ (((long) bArr[i10]) << 42);
                                    if (j6 >= 0) {
                                        j3 = 4363953127296L;
                                    } else {
                                        i10 = i + 8;
                                        j7 = j6 ^ (((long) bArr[i4]) << 49);
                                        if (j7 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            i4 = i + 9;
                                            long j8 = (j7 ^ (((long) bArr[i10]) << 56)) ^ 71499008037633920L;
                                            if (j8 < 0) {
                                                int i11 = i + 10;
                                                if (bArr[i4] >= 0) {
                                                    i4 = i11;
                                                }
                                            }
                                            j = j8;
                                        }
                                    }
                                }
                                j = j7 ^ j2;
                                i4 = i10;
                            }
                            j = j6 ^ j3;
                        }
                    }
                }
                this.zzh = i4;
                return j;
            }
        }
        return zzs();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    final long zzs() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte bZzaa = zzaa();
            j |= ((long) (bZzaa & 127)) << i;
            if ((bZzaa & 128) == 0) {
                return j;
            }
        }
        throw zzfo.zzc();
    }

    private final int zzx() throws IOException {
        int i = this.zzh;
        if (this.zzf - i < 4) {
            throw zzfo.zza();
        }
        byte[] bArr = this.zzd;
        this.zzh = i + 4;
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24);
    }

    private final long zzy() throws IOException {
        int i = this.zzh;
        if (this.zzf - i < 8) {
            throw zzfo.zza();
        }
        byte[] bArr = this.zzd;
        this.zzh = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final int zzc(int i) throws zzfo {
        if (i < 0) {
            throw zzfo.zzb();
        }
        int iZzu = i + zzu();
        int i2 = this.zzk;
        if (iZzu > i2) {
            throw zzfo.zza();
        }
        this.zzk = iZzu;
        zzz();
        return i2;
    }

    private final void zzz() {
        int i = this.zzf + this.zzg;
        this.zzf = i;
        int i2 = i - this.zzi;
        int i3 = this.zzk;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.zzg = i4;
            this.zzf = i - i4;
            return;
        }
        this.zzg = 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final void zzd(int i) {
        this.zzk = i;
        zzz();
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final boolean zzt() throws IOException {
        return this.zzh == this.zzf;
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final int zzu() {
        return this.zzh - this.zzi;
    }

    private final byte zzaa() throws IOException {
        int i = this.zzh;
        if (i == this.zzf) {
            throw zzfo.zza();
        }
        byte[] bArr = this.zzd;
        this.zzh = i + 1;
        return bArr[i];
    }

    private final void zzf(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.zzf;
            int i3 = this.zzh;
            if (i <= i2 - i3) {
                this.zzh = i3 + i;
                return;
            }
        }
        if (i < 0) {
            throw zzfo.zzb();
        }
        throw zzfo.zza();
    }
}
