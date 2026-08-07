package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzkn extends zzaf {
    private final /* synthetic */ zzks zza;
    private final /* synthetic */ zzko zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzkn(zzko zzkoVar, zzhh zzhhVar, zzks zzksVar) {
        super(zzhhVar);
        this.zzb = zzkoVar;
        this.zza = zzksVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzaf
    public final void zza() {
        this.zzb.zzf();
        this.zzb.zzr().zzx().zza("Starting upload from DelayedRunnable");
        this.zza.zzl();
    }
}
