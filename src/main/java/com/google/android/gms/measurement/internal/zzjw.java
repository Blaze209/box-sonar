package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzjw implements Runnable {
    private final /* synthetic */ zzjp zza;

    zzjw(zzjp zzjpVar) {
        this.zza = zzjpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzix.zza(this.zza.zza, (zzfc) null);
        this.zza.zza.zzal();
    }
}
