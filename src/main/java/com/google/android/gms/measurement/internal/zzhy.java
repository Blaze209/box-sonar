package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzle;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzhy implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzhp zzb;

    zzhy(zzhp zzhpVar, long j) {
        this.zzb = zzhpVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzhp zzhpVar = this.zzb;
        long j = this.zza;
        zzhpVar.zzd();
        zzhpVar.zzb();
        zzhpVar.zzw();
        zzhpVar.zzr().zzw().zza("Resetting analytics data (FE)");
        zzkc zzkcVarZzk = zzhpVar.zzk();
        zzkcVarZzk.zzd();
        zzkcVarZzk.zzb.zza();
        boolean zZzab = zzhpVar.zzx.zzab();
        zzft zzftVarZzs = zzhpVar.zzs();
        zzftVarZzs.zzh.zza(j);
        if (!TextUtils.isEmpty(zzftVarZzs.zzs().zzw.zza())) {
            zzftVarZzs.zzw.zza(null);
        }
        if (zzle.zzb() && zzftVarZzs.zzt().zza(zzap.zzcr)) {
            zzftVarZzs.zzq.zza(0L);
        }
        if (!zzftVarZzs.zzt().zzg()) {
            zzftVarZzs.zzc(!zZzab);
        }
        zzhpVar.zzh().zzad();
        if (zzle.zzb() && zzhpVar.zzt().zza(zzap.zzcr)) {
            zzhpVar.zzk().zza.zza();
        }
        zzhpVar.zzb = !zZzab;
        this.zzb.zzh().zza(new AtomicReference<>());
    }
}
