package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzkd {
    final /* synthetic */ zzkc zza;
    private zzki zzb;
    private final Runnable zzc = new Runnable(this) { // from class: com.google.android.gms.measurement.internal.zzkg
        private final zzkd zza;

        {
            this.zza = this;
        }

        @Override // java.lang.Runnable
        public final void run() {
            zzkd zzkdVar = this.zza;
            zzkdVar.zza.zzq().zza(new Runnable(zzkdVar) { // from class: com.google.android.gms.measurement.internal.zzkf
                private final zzkd zza;

                {
                    this.zza = zzkdVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzkd zzkdVar2 = this.zza;
                    zzkdVar2.zza.zzd();
                    zzkdVar2.zza.zzr().zzw().zza("Application backgrounded");
                    zzkdVar2.zza.zzf().zzb("auto", "_ab", new Bundle());
                }
            });
        }
    };

    zzkd(zzkc zzkcVar) {
        this.zza = zzkcVar;
    }

    final void zza() {
        this.zza.zzd();
        if (this.zza.zzt().zza(zzap.zzci)) {
            if (com.google.android.gms.internal.measurement.zzkz.zzb() && this.zza.zzt().zze(this.zza.zzg().zzab(), zzap.zzcv)) {
                if (this.zzb != null) {
                    this.zza.zzc.removeCallbacks(this.zzb);
                    return;
                }
                return;
            }
            this.zza.zzc.removeCallbacks(this.zzc);
        }
    }

    final void zzb() {
        if (this.zza.zzt().zza(zzap.zzci)) {
            if (com.google.android.gms.internal.measurement.zzkz.zzb() && this.zza.zzt().zze(this.zza.zzg().zzab(), zzap.zzcv)) {
                this.zzb = new zzki(this, this.zza.zzm().currentTimeMillis());
                this.zza.zzc.postDelayed(this.zzb, 2000L);
            } else {
                this.zza.zzc.postDelayed(this.zzc, 2000L);
            }
        }
    }
}
