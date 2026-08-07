package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzju implements Runnable {
    private final /* synthetic */ zzfc zza;
    private final /* synthetic */ zzjp zzb;

    zzju(zzjp zzjpVar, zzfc zzfcVar) {
        this.zzb = zzjpVar;
        this.zza = zzfcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzb) {
            zzjp.zza(this.zzb, false);
            if (!this.zzb.zza.zzab()) {
                this.zzb.zza.zzr().zzw().zza("Connected to remote service");
                this.zzb.zza.zza(this.zza);
            }
        }
    }
}
