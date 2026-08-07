package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzb extends zzf {
    private final Map<String, Long> zza;
    private final Map<String, Integer> zzb;
    private long zzc;

    public zzb(zzgo zzgoVar) {
        super(zzgoVar);
        this.zzb = new ArrayMap();
        this.zza = new ArrayMap();
    }

    public final void zza(String str, long j) {
        if (str == null || str.length() == 0) {
            zzr().zzf().zza("Ad unit id must be a non-empty string");
        } else {
            zzq().zza(new zza(this, str, j));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzc(String str, long j) {
        zzb();
        zzd();
        Preconditions.checkNotEmpty(str);
        if (this.zzb.isEmpty()) {
            this.zzc = j;
        }
        Integer num = this.zzb.get(str);
        if (num != null) {
            this.zzb.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (this.zzb.size() >= 100) {
            zzr().zzi().zza("Too many ads visible");
        } else {
            this.zzb.put(str, 1);
            this.zza.put(str, Long.valueOf(j));
        }
    }

    public final void zzb(String str, long j) {
        if (str == null || str.length() == 0) {
            zzr().zzf().zza("Ad unit id must be a non-empty string");
        } else {
            zzq().zza(new zzd(this, str, j));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzd(String str, long j) {
        zzb();
        zzd();
        Preconditions.checkNotEmpty(str);
        Integer num = this.zzb.get(str);
        if (num != null) {
            zzit zzitVarZzab = zzi().zzab();
            int iIntValue = num.intValue() - 1;
            if (iIntValue == 0) {
                this.zzb.remove(str);
                Long l = this.zza.get(str);
                if (l == null) {
                    zzr().zzf().zza("First ad unit exposure time was never set");
                } else {
                    long jLongValue = j - l.longValue();
                    this.zza.remove(str);
                    zza(str, jLongValue, zzitVarZzab);
                }
                if (this.zzb.isEmpty()) {
                    long j2 = this.zzc;
                    if (j2 == 0) {
                        zzr().zzf().zza("First ad exposure time was never set");
                        return;
                    } else {
                        zza(j - j2, zzitVarZzab);
                        this.zzc = 0L;
                        return;
                    }
                }
                return;
            }
            this.zzb.put(str, Integer.valueOf(iIntValue));
            return;
        }
        zzr().zzf().zza("Call to endAdUnitExposure for unknown ad unit id", str);
    }

    private final void zza(long j, zzit zzitVar) {
        if (zzitVar == null) {
            zzr().zzx().zza("Not logging ad exposure. No active activity");
            return;
        }
        if (j < 1000) {
            zzr().zzx().zza("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("_xt", j);
        zziw.zza(zzitVar, bundle, true);
        zzf().zza("am", "_xa", bundle);
    }

    private final void zza(String str, long j, zzit zzitVar) {
        if (zzitVar == null) {
            zzr().zzx().zza("Not logging ad unit exposure. No active activity");
            return;
        }
        if (j < 1000) {
            zzr().zzx().zza("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("_ai", str);
        bundle.putLong("_xt", j);
        zziw.zza(zzitVar, bundle, true);
        zzf().zza("am", "_xu", bundle);
    }

    public final void zza(long j) {
        zzit zzitVarZzab = zzi().zzab();
        for (String str : this.zza.keySet()) {
            zza(str, j - this.zza.get(str).longValue(), zzitVarZzab);
        }
        if (!this.zza.isEmpty()) {
            zza(j - this.zzc, zzitVarZzab);
        }
        zzb(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(long j) {
        Iterator<String> it = this.zza.keySet().iterator();
        while (it.hasNext()) {
            this.zza.put(it.next(), Long.valueOf(j));
        }
        if (this.zza.isEmpty()) {
            return;
        }
        this.zzc = j;
    }

    @Override // com.google.android.gms.measurement.internal.zzf, com.google.android.gms.measurement.internal.zzhf
    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzf, com.google.android.gms.measurement.internal.zzhf
    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzf, com.google.android.gms.measurement.internal.zzhf
    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzf, com.google.android.gms.measurement.internal.zzhf
    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzb zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzhp zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzfd zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzix zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zziw zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzfg zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzkc zzk() {
        return super.zzk();
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
