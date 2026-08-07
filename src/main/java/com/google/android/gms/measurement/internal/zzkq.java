package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
class zzkq extends zzhf implements zzhh {
    protected final zzks zza;

    zzkq(zzks zzksVar) {
        super(zzksVar.zzs());
        Preconditions.checkNotNull(zzksVar);
        this.zza = zzksVar;
    }

    public zzgi zzj() {
        return this.zza.zzc();
    }

    public zzac zzi() {
        return this.zza.zze();
    }

    public zzn e_() {
        return this.zza.zzf();
    }

    public zzkw zzg() {
        return this.zza.zzh();
    }
}
