package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzki implements Runnable {
    long zza;
    final /* synthetic */ zzkd zzb;

    zzki(zzkd zzkdVar, long j) {
        this.zzb = zzkdVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzq().zza(new Runnable(this) { // from class: com.google.android.gms.measurement.internal.zzkh
            private final zzki zza;

            {
                this.zza = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzki zzkiVar = this.zza;
                zzkd zzkdVar = zzkiVar.zzb;
                long j = zzkiVar.zza;
                zzkdVar.zza.zzd();
                zzkdVar.zza.zzr().zzw().zza("Application going to the background");
                zzkdVar.zza.zzf().zza("auto", "_ab", j, new Bundle());
            }
        });
    }
}
