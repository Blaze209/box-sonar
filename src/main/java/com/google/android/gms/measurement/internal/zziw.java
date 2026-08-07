package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
public final class zziw extends zze {
    protected zzit zza;
    private volatile zzit zzb;
    private zzit zzc;
    private final Map<Activity, zzit> zzd;
    private zzit zze;
    private String zzf;

    public zziw(zzgo zzgoVar) {
        super(zzgoVar);
        this.zzd = new ConcurrentHashMap();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    protected final boolean zzz() {
        return false;
    }

    public final zzit zzab() {
        zzw();
        zzd();
        return this.zza;
    }

    public final void zza(Activity activity, String str, String str2) {
        if (this.zzb == null) {
            zzr().zzk().zza("setCurrentScreen cannot be called while no activity active");
            return;
        }
        if (this.zzd.get(activity) == null) {
            zzr().zzk().zza("setCurrentScreen must be called with an activity in the activity lifecycle");
            return;
        }
        if (str2 == null) {
            str2 = zza(activity.getClass().getCanonicalName());
        }
        boolean zEquals = this.zzb.zzb.equals(str2);
        boolean zZzc = zzla.zzc(this.zzb.zza, str);
        if (zEquals && zZzc) {
            zzr().zzk().zza("setCurrentScreen cannot be called with the same class and name");
            return;
        }
        if (str != null && (str.length() <= 0 || str.length() > 100)) {
            zzr().zzk().zza("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            return;
        }
        if (str2 != null && (str2.length() <= 0 || str2.length() > 100)) {
            zzr().zzk().zza("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            return;
        }
        zzr().zzx().zza("Setting current screen to name, class", str == null ? AbstractJsonLexerKt.NULL : str, str2);
        zzit zzitVar = new zzit(str, str2, zzp().zzg());
        this.zzd.put(activity, zzitVar);
        zza(activity, zzitVar, true);
    }

    public final zzit zzac() {
        zzb();
        return this.zzb;
    }

    private final void zza(Activity activity, zzit zzitVar, boolean z) {
        zzit zzitVar2 = this.zzb == null ? this.zzc : this.zzb;
        zzit zzitVar3 = zzitVar.zzb == null ? new zzit(zzitVar.zza, zza(activity.getClass().getCanonicalName()), zzitVar.zzc) : zzitVar;
        this.zzc = this.zzb;
        this.zzb = zzitVar3;
        zzq().zza(new zziv(this, z, zzm().elapsedRealtime(), zzitVar2, zzitVar3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzit zzitVar, boolean z, long j) {
        zze().zza(zzm().elapsedRealtime());
        if (zzk().zza(zzitVar.zzd, z, j)) {
            zzitVar.zzd = false;
        }
    }

    public static void zza(zzit zzitVar, Bundle bundle, boolean z) {
        if (bundle != null && zzitVar != null && (!bundle.containsKey("_sc") || z)) {
            if (zzitVar.zza != null) {
                bundle.putString("_sn", zzitVar.zza);
            } else {
                bundle.remove("_sn");
            }
            bundle.putString("_sc", zzitVar.zzb);
            bundle.putLong("_si", zzitVar.zzc);
            return;
        }
        if (bundle != null && zzitVar == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    public final void zza(String str, zzit zzitVar) {
        zzd();
        synchronized (this) {
            String str2 = this.zzf;
            if (str2 == null || str2.equals(str) || zzitVar != null) {
                this.zzf = str;
                this.zze = zzitVar;
            }
        }
    }

    private static String zza(String str) {
        String str2;
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length > 0) {
            str2 = strArrSplit[strArrSplit.length - 1];
        } else {
            str2 = "";
        }
        return str2.length() > 100 ? str2.substring(0, 100) : str2;
    }

    private final zzit zzd(Activity activity) {
        Preconditions.checkNotNull(activity);
        zzit zzitVar = this.zzd.get(activity);
        if (zzitVar != null) {
            return zzitVar;
        }
        zzit zzitVar2 = new zzit(null, zza(activity.getClass().getCanonicalName()), zzp().zzg());
        this.zzd.put(activity, zzitVar2);
        return zzitVar2;
    }

    public final void zza(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.zzd.put(activity, new zzit(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
    }

    public final void zza(Activity activity) {
        zza(activity, zzd(activity), false);
        zzb zzbVarZze = zze();
        zzbVarZze.zzq().zza(new zzc(zzbVarZze, zzbVarZze.zzm().elapsedRealtime()));
    }

    public final void zzb(Activity activity) {
        zzit zzitVarZzd = zzd(activity);
        this.zzc = this.zzb;
        this.zzb = null;
        zzq().zza(new zziy(this, zzitVarZzd, zzm().elapsedRealtime()));
    }

    public final void zzb(Activity activity, Bundle bundle) {
        zzit zzitVar;
        if (bundle == null || (zzitVar = this.zzd.get(activity)) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("id", zzitVar.zzc);
        bundle2.putString("name", zzitVar.zza);
        bundle2.putString("referrer_name", zzitVar.zzb);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    public final void zzc(Activity activity) {
        this.zzd.remove(activity);
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
