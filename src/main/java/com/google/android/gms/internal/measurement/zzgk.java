package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
final class zzgk implements zzgh {
    zzgk() {
    }

    @Override // com.google.android.gms.internal.measurement.zzgh
    public final Map<?, ?> zza(Object obj) {
        return (zzgi) obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzgh
    public final zzgf<?, ?> zzf(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.zzgh
    public final Map<?, ?> zzb(Object obj) {
        return (zzgi) obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzgh
    public final boolean zzc(Object obj) {
        return !((zzgi) obj).zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzgh
    public final Object zzd(Object obj) {
        ((zzgi) obj).zzc();
        return obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzgh
    public final Object zze(Object obj) {
        return zzgi.zza().zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzgh
    public final Object zza(Object obj, Object obj2) {
        zzgi zzgiVarZzb = (zzgi) obj;
        zzgi zzgiVar = (zzgi) obj2;
        if (!zzgiVar.isEmpty()) {
            if (!zzgiVarZzb.zzd()) {
                zzgiVarZzb = zzgiVarZzb.zzb();
            }
            zzgiVarZzb.zza(zzgiVar);
        }
        return zzgiVarZzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzgh
    public final int zza(int i, Object obj, Object obj2) {
        zzgi zzgiVar = (zzgi) obj;
        if (zzgiVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzgiVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
