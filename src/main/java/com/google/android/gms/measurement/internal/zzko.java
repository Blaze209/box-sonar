package com.google.android.gms.measurement.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.util.Clock;
import com.microsoft.intune.mam.client.app.MAMPendingIntent;
import com.pspdfkit.analytics.Analytics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzko extends zzkp {
    private final AlarmManager zzb;
    private final zzaf zzc;
    private Integer zzd;

    protected zzko(zzks zzksVar) {
        super(zzksVar);
        this.zzb = (AlarmManager) zzn().getSystemService(NotificationCompat.CATEGORY_ALARM);
        this.zzc = new zzkn(this, zzksVar.zzs(), zzksVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzkp
    protected final boolean zze() {
        this.zzb.cancel(zzw());
        zzk();
        return false;
    }

    private final void zzk() {
        JobScheduler jobScheduler = (JobScheduler) zzn().getSystemService("jobscheduler");
        int iZzv = zzv();
        if (!zzx()) {
            zzr().zzx().zza("Cancelling job. JobID", Integer.valueOf(iZzv));
        }
        jobScheduler.cancel(iZzv);
    }

    public final void zza(long j) {
        zzak();
        zzu();
        Context contextZzn = zzn();
        if (!zzge.zza(contextZzn)) {
            zzr().zzw().zza("Receiver not registered/enabled");
        }
        if (!zzla.zza(contextZzn, false)) {
            zzr().zzw().zza("Service not registered/enabled");
        }
        zzf();
        if (zzx()) {
            zzr().zzx().zza("Scheduling upload, millis", Long.valueOf(j));
        }
        zzm().elapsedRealtime();
        if (j < Math.max(0L, zzap.zzw.zza(null).longValue()) && !this.zzc.zzb()) {
            if (!zzx()) {
                zzr().zzx().zza("Scheduling upload with DelayedRunnable");
            }
            this.zzc.zza(j);
        }
        zzu();
        if (!zzx()) {
            zzr().zzx().zza("Scheduling upload with JobScheduler");
        }
        Context contextZzn2 = zzn();
        ComponentName componentName = new ComponentName(contextZzn2, "com.google.android.gms.measurement.AppMeasurementJobService");
        int iZzv = zzv();
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString(Analytics.Data.ACTION, "com.google.android.gms.measurement.UPLOAD");
        JobInfo jobInfoBuild = new JobInfo.Builder(iZzv, componentName).setMinimumLatency(j).setOverrideDeadline(j << 1).setExtras(persistableBundle).build();
        if (!zzx()) {
            zzr().zzx().zza("Scheduling job. JobID", Integer.valueOf(iZzv));
        }
        com.google.android.gms.internal.measurement.zzh.zza(contextZzn2, jobInfoBuild, "com.google.android.gms", "UploadAlarm");
    }

    private final int zzv() {
        if (this.zzd == null) {
            String strValueOf = String.valueOf(zzn().getPackageName());
            this.zzd = Integer.valueOf((strValueOf.length() != 0 ? "measurement".concat(strValueOf) : new String("measurement")).hashCode());
        }
        return this.zzd.intValue();
    }

    public final void zzf() {
        zzak();
        if (zzx()) {
            zzr().zzx().zza("Unscheduling upload");
        }
        this.zzb.cancel(zzw());
        this.zzc.zzc();
        zzk();
    }

    private final PendingIntent zzw() {
        Context contextZzn = zzn();
        return MAMPendingIntent.getBroadcast(contextZzn, 0, new Intent().setClassName(contextZzn, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), 0);
    }

    private final boolean zzx() {
        return com.google.android.gms.internal.measurement.zzky.zzb() && zzt().zza(zzap.zzcz);
    }

    @Override // com.google.android.gms.measurement.internal.zzkq
    public final /* bridge */ /* synthetic */ zzkw zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzkq
    public final /* bridge */ /* synthetic */ zzn e_() {
        return super.e_();
    }

    @Override // com.google.android.gms.measurement.internal.zzkq
    public final /* bridge */ /* synthetic */ zzac zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzkq
    public final /* bridge */ /* synthetic */ zzgi zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf
    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf
    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf
    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf
    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf
    public final /* bridge */ /* synthetic */ zzah zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf, com.google.android.gms.measurement.internal.zzhh
    public final /* bridge */ /* synthetic */ Clock zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf, com.google.android.gms.measurement.internal.zzhh
    public final /* bridge */ /* synthetic */ Context zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf
    public final /* bridge */ /* synthetic */ zzfi zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf
    public final /* bridge */ /* synthetic */ zzla zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf, com.google.android.gms.measurement.internal.zzhh
    public final /* bridge */ /* synthetic */ zzgh zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf, com.google.android.gms.measurement.internal.zzhh
    public final /* bridge */ /* synthetic */ zzfk zzr() {
        return super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf
    public final /* bridge */ /* synthetic */ zzft zzs() {
        return super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf
    public final /* bridge */ /* synthetic */ zzx zzt() {
        return super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf, com.google.android.gms.measurement.internal.zzhh
    public final /* bridge */ /* synthetic */ zzw zzu() {
        return super.zzu();
    }
}
