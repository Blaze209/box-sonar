package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
final class zzfz extends zzfy {
    private zzfz() {
        super();
    }

    @Override // com.google.android.gms.internal.measurement.zzfy
    final <L> List<L> zza(Object obj, long j) {
        zzfl zzflVarZzc = zzc(obj, j);
        if (zzflVarZzc.zza()) {
            return zzflVarZzc;
        }
        int size = zzflVarZzc.size();
        zzfl zzflVarZza = zzflVarZzc.zza(size == 0 ? 10 : size << 1);
        zzib.zza(obj, j, zzflVarZza);
        return zzflVarZza;
    }

    @Override // com.google.android.gms.internal.measurement.zzfy
    final void zzb(Object obj, long j) {
        zzc(obj, j).h_();
    }

    @Override // com.google.android.gms.internal.measurement.zzfy
    final <E> void zza(Object obj, Object obj2, long j) {
        zzfl zzflVarZzc = zzc(obj, j);
        zzfl zzflVarZzc2 = zzc(obj2, j);
        int size = zzflVarZzc.size();
        int size2 = zzflVarZzc2.size();
        if (size > 0 && size2 > 0) {
            if (!zzflVarZzc.zza()) {
                zzflVarZzc = zzflVarZzc.zza(size2 + size);
            }
            zzflVarZzc.addAll(zzflVarZzc2);
        }
        if (size > 0) {
            zzflVarZzc2 = zzflVarZzc;
        }
        zzib.zza(obj, j, zzflVarZzc2);
    }

    private static <E> zzfl<E> zzc(Object obj, long j) {
        return (zzfl) zzib.zzf(obj, j);
    }
}
