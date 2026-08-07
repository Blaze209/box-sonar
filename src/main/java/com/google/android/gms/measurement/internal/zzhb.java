package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzhb implements Callable<List<zzlb>> {
    private final /* synthetic */ zzm zza;
    private final /* synthetic */ zzgp zzb;

    zzhb(zzgp zzgpVar, zzm zzmVar) {
        this.zzb = zzgpVar;
        this.zza = zzmVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzlb> call() throws Exception {
        this.zzb.zza.zzo();
        return this.zzb.zza.zze().zza(this.zza.zza);
    }
}
