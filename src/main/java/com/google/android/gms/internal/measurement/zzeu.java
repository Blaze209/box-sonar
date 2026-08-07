package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
final class zzeu extends zzes<zzfd.zzc> {
    zzeu() {
    }

    @Override // com.google.android.gms.internal.measurement.zzes
    final boolean zza(zzgo zzgoVar) {
        return zzgoVar instanceof zzfd.zzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzes
    final zzew<zzfd.zzc> zza(Object obj) {
        return ((zzfd.zzd) obj).zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzes
    final zzew<zzfd.zzc> zzb(Object obj) {
        return ((zzfd.zzd) obj).zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzes
    final void zzc(Object obj) {
        zza(obj).zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzes
    final <UT, UB> UB zza(zzhe zzheVar, Object obj, zzeq zzeqVar, zzew<zzfd.zzc> zzewVar, UB ub, zzhv<UT, UB> zzhvVar) throws IOException {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.zzes
    final int zza(Map.Entry<?, ?> entry) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.zzes
    final void zza(zzis zzisVar, Map.Entry<?, ?> entry) throws IOException {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.zzes
    final Object zza(zzeq zzeqVar, zzgo zzgoVar, int i) {
        return zzeqVar.zza(zzgoVar, i);
    }

    @Override // com.google.android.gms.internal.measurement.zzes
    final void zza(zzhe zzheVar, Object obj, zzeq zzeqVar, zzew<zzfd.zzc> zzewVar) throws IOException {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.zzes
    final void zza(zzdu zzduVar, Object obj, zzeq zzeqVar, zzew<zzfd.zzc> zzewVar) throws IOException {
        throw new NoSuchMethodError();
    }
}
