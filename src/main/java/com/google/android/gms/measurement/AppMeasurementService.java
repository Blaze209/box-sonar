package com.google.android.gms.measurement;

import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.measurement.internal.zzjv;
import com.google.android.gms.measurement.internal.zzjz;
import com.microsoft.intune.mam.client.app.MAMService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
public final class AppMeasurementService extends MAMService implements zzjz {
    private zzjv<AppMeasurementService> zza;

    private final zzjv<AppMeasurementService> zza() {
        if (this.zza == null) {
            this.zza = new zzjv<>(this);
        }
        return this.zza;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        zza().zza();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        zza().zzb();
        super.onDestroy();
    }

    @Override // com.microsoft.intune.mam.client.app.MAMService, com.microsoft.intune.mam.client.app.HookedService
    public final int onMAMStartCommand(Intent intent, int i, int i2) {
        return zza().zza(intent, i, i2);
    }

    @Override // com.microsoft.intune.mam.client.app.HookedService
    public final IBinder onMAMBind(Intent intent) {
        return zza().zza(intent);
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        return zza().zzb(intent);
    }

    @Override // android.app.Service
    public final void onRebind(Intent intent) {
        zza().zzc(intent);
    }

    @Override // com.google.android.gms.measurement.internal.zzjz
    public final boolean zza(int i) {
        return stopSelfResult(i);
    }

    @Override // com.google.android.gms.measurement.internal.zzjz
    public final void zza(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.measurement.internal.zzjz
    public final void zza(Intent intent) {
        AppMeasurementReceiver.completeWakefulIntent(intent);
    }
}
