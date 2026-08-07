package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
final class zzgd implements zzgl {
    private zzgl[] zza;

    zzgd(zzgl... zzglVarArr) {
        this.zza = zzglVarArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzgl
    public final boolean zza(Class<?> cls) {
        for (zzgl zzglVar : this.zza) {
            if (zzglVar.zza(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzgl
    public final zzgm zzb(Class<?> cls) {
        for (zzgl zzglVar : this.zza) {
            if (zzglVar.zza(cls)) {
                return zzglVar.zzb(cls);
            }
        }
        String strValueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(strValueOf.length() != 0 ? "No factory is available for message type: ".concat(strValueOf) : new String("No factory is available for message type: "));
    }
}
