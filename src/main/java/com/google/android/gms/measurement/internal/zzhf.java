package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
class zzhf implements zzhh {
    protected final zzgo zzx;

    zzhf(zzgo zzgoVar) {
        Preconditions.checkNotNull(zzgoVar);
        this.zzx = zzgoVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzhh
    public zzw zzu() {
        return this.zzx.zzu();
    }

    public zzx zzt() {
        return this.zzx.zzb();
    }

    public zzft zzs() {
        return this.zzx.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzhh
    public zzfk zzr() {
        return this.zzx.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzhh
    public zzgh zzq() {
        return this.zzx.zzq();
    }

    public zzla zzp() {
        return this.zzx.zzi();
    }

    public zzfi zzo() {
        return this.zzx.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzhh
    public Context zzn() {
        return this.zzx.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzhh
    public Clock zzm() {
        return this.zzx.zzm();
    }

    public zzah zzl() {
        return this.zzx.zzx();
    }

    public void zzd() {
        this.zzx.zzq().zzd();
    }

    public void zzc() {
        this.zzx.zzq().zzc();
    }

    public void zzb() {
        this.zzx.zzae();
    }

    public void zza() {
        this.zzx.zzaf();
    }
}
