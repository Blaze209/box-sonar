package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzgs implements Runnable {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzgp zzb;

    zzgs(zzgp zzgpVar, zzm zzmVar) {
        this.zzb = zzgpVar;
        this.zza = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzo();
        zzks zzksVar = this.zzb.zza;
        zzm zzmVar = this.zza;
        zzksVar.zzq().zzd();
        zzksVar.zzk();
        Preconditions.checkNotEmpty(zzmVar.zza);
        zzksVar.zzc(zzmVar);
    }
}
