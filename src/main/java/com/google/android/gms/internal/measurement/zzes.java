package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
abstract class zzes<T extends zzey<T>> {
    zzes() {
    }

    abstract int zza(Map.Entry<?, ?> entry);

    abstract zzew<T> zza(Object obj);

    abstract Object zza(zzeq zzeqVar, zzgo zzgoVar, int i);

    abstract <UT, UB> UB zza(zzhe zzheVar, Object obj, zzeq zzeqVar, zzew<T> zzewVar, UB ub, zzhv<UT, UB> zzhvVar) throws IOException;

    abstract void zza(zzdu zzduVar, Object obj, zzeq zzeqVar, zzew<T> zzewVar) throws IOException;

    abstract void zza(zzhe zzheVar, Object obj, zzeq zzeqVar, zzew<T> zzewVar) throws IOException;

    abstract void zza(zzis zzisVar, Map.Entry<?, ?> entry) throws IOException;

    abstract boolean zza(zzgo zzgoVar);

    abstract zzew<T> zzb(Object obj);

    abstract void zzc(Object obj);
}
