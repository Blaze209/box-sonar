package com.google.android.gms.measurement;

import android.app.job.JobParameters;
import android.content.Intent;
import com.google.android.gms.measurement.internal.zzjv;
import com.google.android.gms.measurement.internal.zzjz;
import com.microsoft.intune.mam.client.app.job.MAMJobService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
public final class AppMeasurementJobService extends MAMJobService implements zzjz {
    private zzjv<AppMeasurementJobService> zza;

    private final zzjv<AppMeasurementJobService> zza() {
        if (this.zza == null) {
            this.zza = new zzjv<>(this);
        }
        return this.zza;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzjz
    public final void zza(Intent intent) {
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

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        return zza().zza(jobParameters);
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
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.measurement.internal.zzjz
    public final void zza(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }
}
