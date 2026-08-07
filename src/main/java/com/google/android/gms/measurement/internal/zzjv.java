package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzjz;
import com.pspdfkit.analytics.Analytics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzjv<T extends Context & zzjz> {
    private final T zza;

    public zzjv(T t) {
        Preconditions.checkNotNull(t);
        this.zza = t;
    }

    public final void zza() {
        zzgo zzgoVarZza = zzgo.zza(this.zza, (com.google.android.gms.internal.measurement.zzv) null);
        zzfk zzfkVarZzr = zzgoVarZza.zzr();
        zzgoVarZza.zzu();
        zzfkVarZzr.zzx().zza("Local AppMeasurementService is starting up");
    }

    public final void zzb() {
        zzgo zzgoVarZza = zzgo.zza(this.zza, (com.google.android.gms.internal.measurement.zzv) null);
        zzfk zzfkVarZzr = zzgoVarZza.zzr();
        zzgoVarZza.zzu();
        zzfkVarZzr.zzx().zza("Local AppMeasurementService is shutting down");
    }

    public final int zza(final Intent intent, int i, final int i2) {
        zzgo zzgoVarZza = zzgo.zza(this.zza, (com.google.android.gms.internal.measurement.zzv) null);
        final zzfk zzfkVarZzr = zzgoVarZza.zzr();
        if (intent == null) {
            zzfkVarZzr.zzi().zza("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        zzgoVarZza.zzu();
        zzfkVarZzr.zzx().zza("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            zza(new Runnable(this, i2, zzfkVarZzr, intent) { // from class: com.google.android.gms.measurement.internal.zzjy
                private final zzjv zza;
                private final int zzb;
                private final zzfk zzc;
                private final Intent zzd;

                {
                    this.zza = this;
                    this.zzb = i2;
                    this.zzc = zzfkVarZzr;
                    this.zzd = intent;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zza(this.zzb, this.zzc, this.zzd);
                }
            });
        }
        return 2;
    }

    private final void zza(Runnable runnable) {
        zzks zzksVarZza = zzks.zza(this.zza);
        zzksVarZza.zzq().zza(new zzka(this, zzksVarZza, runnable));
    }

    public final IBinder zza(Intent intent) {
        if (intent == null) {
            zzc().zzf().zza("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzgp(zzks.zza(this.zza));
        }
        zzc().zzi().zza("onBind received unknown action", action);
        return null;
    }

    public final boolean zzb(Intent intent) {
        if (intent == null) {
            zzc().zzf().zza("onUnbind called with null intent");
            return true;
        }
        zzc().zzx().zza("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    public final boolean zza(final JobParameters jobParameters) {
        zzgo zzgoVarZza = zzgo.zza(this.zza, (com.google.android.gms.internal.measurement.zzv) null);
        final zzfk zzfkVarZzr = zzgoVarZza.zzr();
        String string = jobParameters.getExtras().getString(Analytics.Data.ACTION);
        zzgoVarZza.zzu();
        zzfkVarZzr.zzx().zza("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        zza(new Runnable(this, zzfkVarZzr, jobParameters) { // from class: com.google.android.gms.measurement.internal.zzjx
            private final zzjv zza;
            private final zzfk zzb;
            private final JobParameters zzc;

            {
                this.zza = this;
                this.zzb = zzfkVarZzr;
                this.zzc = jobParameters;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza(this.zzb, this.zzc);
            }
        });
        return true;
    }

    public final void zzc(Intent intent) {
        if (intent == null) {
            zzc().zzf().zza("onRebind called with null intent");
        } else {
            zzc().zzx().zza("onRebind called. action", intent.getAction());
        }
    }

    private final zzfk zzc() {
        return zzgo.zza(this.zza, (com.google.android.gms.internal.measurement.zzv) null).zzr();
    }

    final /* synthetic */ void zza(zzfk zzfkVar, JobParameters jobParameters) {
        zzfkVar.zzx().zza("AppMeasurementJobService processed last upload request.");
        this.zza.zza(jobParameters, false);
    }

    final /* synthetic */ void zza(int i, zzfk zzfkVar, Intent intent) {
        if (this.zza.zza(i)) {
            zzfkVar.zzx().zza("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            zzc().zzx().zza("Completed wakeful intent.");
            this.zza.zza(intent);
        }
    }
}
