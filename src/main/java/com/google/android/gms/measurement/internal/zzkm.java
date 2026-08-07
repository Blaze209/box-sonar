package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzkm {
    final /* synthetic */ zzkc zza;

    zzkm(zzkc zzkcVar) {
        this.zza = zzkcVar;
    }

    final void zza() {
        if (zzle.zzb() && this.zza.zzt().zza(zzap.zzay)) {
            this.zza.zzd();
            if (this.zza.zzs().zza(this.zza.zzm().currentTimeMillis())) {
                this.zza.zzs().zzm.zza(true);
                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                ActivityManager.getMyMemoryState(runningAppProcessInfo);
                if (runningAppProcessInfo.importance == 100) {
                    this.zza.zzr().zzx().zza("Detected application was in foreground");
                    zzb(this.zza.zzm().currentTimeMillis(), false);
                }
            }
        }
    }

    final void zza(long j, boolean z) {
        this.zza.zzd();
        this.zza.zzac();
        if (this.zza.zzs().zza(j)) {
            this.zza.zzs().zzm.zza(true);
            this.zza.zzs().zzr.zza(0L);
        }
        if (z && this.zza.zzt().zza(zzap.zzat)) {
            this.zza.zzs().zzq.zza(j);
        }
        if (this.zza.zzs().zzm.zza()) {
            zzb(j, z);
        }
    }

    private final void zzb(long j, boolean z) {
        this.zza.zzd();
        if (zzle.zzb() && this.zza.zzt().zza(zzap.zzay)) {
            if (!this.zza.zzx.zzab()) {
                return;
            } else {
                this.zza.zzs().zzq.zza(j);
            }
        }
        this.zza.zzr().zzx().zza("Session started, time", Long.valueOf(this.zza.zzm().elapsedRealtime()));
        Long lValueOf = this.zza.zzt().zza(zzap.zzar) ? Long.valueOf(j / 1000) : null;
        this.zza.zzf().zza("auto", "_sid", lValueOf, j);
        this.zza.zzs().zzm.zza(false);
        Bundle bundle = new Bundle();
        if (this.zza.zzt().zza(zzap.zzar)) {
            bundle.putLong("_sid", lValueOf.longValue());
        }
        if (this.zza.zzt().zza(zzap.zzcj) && z) {
            bundle.putLong("_aib", 1L);
        }
        this.zza.zzf().zza("auto", "_s", j, bundle);
        if (com.google.android.gms.internal.measurement.zzka.zzb() && this.zza.zzt().zza(zzap.zzcq)) {
            String strZza = this.zza.zzs().zzw.zza();
            if (!TextUtils.isEmpty(strZza)) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("_ffr", strZza);
                this.zza.zzf().zza("auto", "_ssr", j, bundle2);
            }
        }
        if (zzle.zzb() && this.zza.zzt().zza(zzap.zzay)) {
            return;
        }
        this.zza.zzs().zzq.zza(j);
    }
}
