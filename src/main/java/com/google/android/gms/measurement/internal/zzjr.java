package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzjr implements Runnable {
    private final /* synthetic */ ComponentName zza;
    private final /* synthetic */ zzjp zzb;

    zzjr(zzjp zzjpVar, ComponentName componentName) {
        this.zzb = zzjpVar;
        this.zza = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zza(this.zza);
    }
}
