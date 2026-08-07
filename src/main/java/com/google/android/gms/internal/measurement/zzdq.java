package com.google.android.gms.internal.measurement;

import com.google.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
final class zzdq {
    static int zza(byte[] bArr, int i, zzdt zzdtVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zza(b, bArr, i2, zzdtVar);
        }
        zzdtVar.zza = b;
        return i2;
    }

    static int zza(int i, byte[] bArr, int i2, zzdt zzdtVar) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzdtVar.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & 127) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzdtVar.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & 127) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzdtVar.zza = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & 127) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzdtVar.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzdtVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zzb(byte[] bArr, int i, zzdt zzdtVar) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            zzdtVar.zzb = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & 127)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & 127)) << i4;
            b = b2;
            i3 = i5;
        }
        zzdtVar.zzb = j2;
        return i3;
    }

    static int zza(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    static long zzb(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    static double zzc(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzb(bArr, i));
    }

    static float zzd(byte[] bArr, int i) {
        return Float.intBitsToFloat(zza(bArr, i));
    }

    static int zzc(byte[] bArr, int i, zzdt zzdtVar) throws zzfo {
        int iZza = zza(bArr, i, zzdtVar);
        int i2 = zzdtVar.zza;
        if (i2 < 0) {
            throw zzfo.zzb();
        }
        if (i2 == 0) {
            zzdtVar.zzc = "";
            return iZza;
        }
        zzdtVar.zzc = new String(bArr, iZza, i2, zzff.zza);
        return iZza + i2;
    }

    static int zzd(byte[] bArr, int i, zzdt zzdtVar) throws zzfo {
        int iZza = zza(bArr, i, zzdtVar);
        int i2 = zzdtVar.zza;
        if (i2 < 0) {
            throw zzfo.zzb();
        }
        if (i2 == 0) {
            zzdtVar.zzc = "";
            return iZza;
        }
        zzdtVar.zzc = zzie.zzb(bArr, iZza, i2);
        return iZza + i2;
    }

    static int zze(byte[] bArr, int i, zzdt zzdtVar) throws zzfo {
        int iZza = zza(bArr, i, zzdtVar);
        int i2 = zzdtVar.zza;
        if (i2 < 0) {
            throw zzfo.zzb();
        }
        if (i2 > bArr.length - iZza) {
            throw zzfo.zza();
        }
        if (i2 == 0) {
            zzdtVar.zzc = zzdu.zza;
            return iZza;
        }
        zzdtVar.zzc = zzdu.zza(bArr, iZza, i2);
        return iZza + i2;
    }

    static int zza(zzhd zzhdVar, byte[] bArr, int i, int i2, zzdt zzdtVar) throws IOException {
        int iZza = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZza = zza(i3, bArr, iZza, zzdtVar);
            i3 = zzdtVar.zza;
        }
        int i4 = iZza;
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzfo.zza();
        }
        Object objZza = zzhdVar.zza();
        int i5 = i4 + i3;
        zzhdVar.zza(objZza, bArr, i4, i5, zzdtVar);
        zzhdVar.zzc(objZza);
        zzdtVar.zzc = objZza;
        return i5;
    }

    static int zza(zzhd zzhdVar, byte[] bArr, int i, int i2, int i3, zzdt zzdtVar) throws IOException {
        zzgs zzgsVar = (zzgs) zzhdVar;
        Object objZza = zzgsVar.zza();
        int iZza = zzgsVar.zza(objZza, bArr, i, i2, i3, zzdtVar);
        zzgsVar.zzc(objZza);
        zzdtVar.zzc = objZza;
        return iZza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzfl<?> zzflVar, zzdt zzdtVar) {
        zzfg zzfgVar = (zzfg) zzflVar;
        int iZza = zza(bArr, i2, zzdtVar);
        zzfgVar.zzd(zzdtVar.zza);
        while (iZza < i3) {
            int iZza2 = zza(bArr, iZza, zzdtVar);
            if (i != zzdtVar.zza) {
                break;
            }
            iZza = zza(bArr, iZza2, zzdtVar);
            zzfgVar.zzd(zzdtVar.zza);
        }
        return iZza;
    }

    static int zza(byte[] bArr, int i, zzfl<?> zzflVar, zzdt zzdtVar) throws IOException {
        zzfg zzfgVar = (zzfg) zzflVar;
        int iZza = zza(bArr, i, zzdtVar);
        int i2 = zzdtVar.zza + iZza;
        while (iZza < i2) {
            iZza = zza(bArr, iZza, zzdtVar);
            zzfgVar.zzd(zzdtVar.zza);
        }
        if (iZza == i2) {
            return iZza;
        }
        throw zzfo.zza();
    }

    static int zza(zzhd<?> zzhdVar, int i, byte[] bArr, int i2, int i3, zzfl<?> zzflVar, zzdt zzdtVar) throws IOException {
        int iZza = zza(zzhdVar, bArr, i2, i3, zzdtVar);
        zzflVar.add(zzdtVar.zzc);
        while (iZza < i3) {
            int iZza2 = zza(bArr, iZza, zzdtVar);
            if (i != zzdtVar.zza) {
                break;
            }
            iZza = zza(zzhdVar, bArr, iZza2, i3, zzdtVar);
            zzflVar.add(zzdtVar.zzc);
        }
        return iZza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzhy zzhyVar, zzdt zzdtVar) throws zzfo {
        if ((i >>> 3) == 0) {
            throw zzfo.zzd();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzb = zzb(bArr, i2, zzdtVar);
            zzhyVar.zza(i, Long.valueOf(zzdtVar.zzb));
            return iZzb;
        }
        if (i4 == 1) {
            zzhyVar.zza(i, Long.valueOf(zzb(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZza = zza(bArr, i2, zzdtVar);
            int i5 = zzdtVar.zza;
            if (i5 < 0) {
                throw zzfo.zzb();
            }
            if (i5 > bArr.length - iZza) {
                throw zzfo.zza();
            }
            if (i5 == 0) {
                zzhyVar.zza(i, zzdu.zza);
            } else {
                zzhyVar.zza(i, zzdu.zza(bArr, iZza, i5));
            }
            return iZza + i5;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                zzhyVar.zza(i, Integer.valueOf(zza(bArr, i2)));
                return i2 + 4;
            }
            throw zzfo.zzd();
        }
        zzhy zzhyVarZzb = zzhy.zzb();
        int i6 = (i & (-8)) | 4;
        int i7 = 0;
        while (i2 < i3) {
            int iZza2 = zza(bArr, i2, zzdtVar);
            i7 = zzdtVar.zza;
            if (i7 == i6) {
                i2 = iZza2;
                break;
            }
            i2 = zza(i7, bArr, iZza2, i3, zzhyVarZzb, zzdtVar);
        }
        if (i2 > i3 || i7 != i6) {
            throw zzfo.zzg();
        }
        zzhyVar.zza(i, zzhyVarZzb);
        return i2;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzdt zzdtVar) throws zzfo {
        if ((i >>> 3) == 0) {
            throw zzfo.zzd();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return zzb(bArr, i2, zzdtVar);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return zza(bArr, i2, zzdtVar) + zzdtVar.zza;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw zzfo.zzd();
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = zza(bArr, i2, zzdtVar);
            i6 = zzdtVar.zza;
            if (i6 == i5) {
                break;
            }
            i2 = zza(i6, bArr, i2, i3, zzdtVar);
        }
        if (i2 > i3 || i6 != i5) {
            throw zzfo.zzg();
        }
        return i2;
    }
}
