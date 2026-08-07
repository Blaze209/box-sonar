package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzkv implements Callable<String> {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzks zzb;

    zzkv(zzks zzksVar, zzm zzmVar) {
        this.zzb = zzksVar;
        this.zza = zzmVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        zzg zzgVarZzc = this.zzb.zzc(this.zza);
        if (zzgVarZzc == null) {
            this.zzb.zzr().zzi().zza("App info was null when attempting to get app instance id");
            return null;
        }
        return zzgVarZzc.zzd();
    }
}
