package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
abstract class zzhv<T, B> {
    zzhv() {
    }

    abstract B zza();

    abstract T zza(B b);

    abstract void zza(B b, int i, int i2);

    abstract void zza(B b, int i, long j);

    abstract void zza(B b, int i, zzdu zzduVar);

    abstract void zza(B b, int i, T t);

    abstract void zza(T t, zzis zzisVar) throws IOException;

    abstract void zza(Object obj, T t);

    abstract boolean zza(zzhe zzheVar);

    abstract T zzb(Object obj);

    abstract void zzb(B b, int i, long j);

    abstract void zzb(T t, zzis zzisVar) throws IOException;

    abstract void zzb(Object obj, B b);

    abstract B zzc(Object obj);

    abstract T zzc(T t, T t2);

    abstract void zzd(Object obj);

    abstract int zze(T t);

    abstract int zzf(T t);

    final boolean zza(B b, zzhe zzheVar) throws IOException {
        int iZzb = zzheVar.zzb();
        int i = iZzb >>> 3;
        int i2 = iZzb & 7;
        if (i2 == 0) {
            zza(b, i, zzheVar.zzg());
            return true;
        }
        if (i2 == 1) {
            zzb(b, i, zzheVar.zzi());
            return true;
        }
        if (i2 == 2) {
            zza((Object) b, i, zzheVar.zzn());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw zzfo.zzf();
            }
            zza((Object) b, i, zzheVar.zzj());
            return true;
        }
        B bZza = zza();
        int i3 = 4 | (i << 3);
        while (zzheVar.zza() != Integer.MAX_VALUE && zza((Object) bZza, zzheVar)) {
        }
        if (i3 != zzheVar.zzb()) {
            throw zzfo.zze();
        }
        zza(b, i, zza(bZza));
        return true;
    }
}
