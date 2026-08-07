package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzjt implements Runnable {
    private final /* synthetic */ zzjp zza;

    zzjt(zzjp zzjpVar) {
        this.zza = zzjpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzix zzixVar = this.zza.zza;
        Context contextZzn = this.zza.zza.zzn();
        this.zza.zza.zzu();
        zzixVar.zza(new ComponentName(contextZzn, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
