package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzll;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzx extends zzhf {
    private Boolean zza;
    private zzz zzb;
    private Boolean zzc;

    zzx(zzgo zzgoVar) {
        super(zzgoVar);
        this.zzb = zzaa.zza;
    }

    final void zza(zzz zzzVar) {
        this.zzb = zzzVar;
    }

    final int zza(String str) {
        if (com.google.android.gms.internal.measurement.zzji.zzb() && zzd(null, zzap.zzdg)) {
            return zzb(str, zzap.zzag);
        }
        return 500;
    }

    public final int zzb(String str) {
        return zzb(str, zzap.zzn);
    }

    final int zzc(String str) {
        if (com.google.android.gms.internal.measurement.zzji.zzb() && zzd(null, zzap.zzdg)) {
            return zzb(str, zzap.zzaf);
        }
        return 25;
    }

    public final long zze() {
        zzu();
        return 22048L;
    }

    public final boolean zzf() {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    ApplicationInfo applicationInfo = zzn().getApplicationInfo();
                    String myProcessName = ProcessUtils.getMyProcessName();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.zzc = Boolean.valueOf(str != null && str.equals(myProcessName));
                    }
                    if (this.zzc == null) {
                        this.zzc = Boolean.TRUE;
                        zzr().zzf().zza("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzc.booleanValue();
    }

    public final long zza(String str, zzez<Long> zzezVar) {
        if (str == null) {
            return zzezVar.zza(null).longValue();
        }
        String strZza = this.zzb.zza(str, zzezVar.zza());
        if (TextUtils.isEmpty(strZza)) {
            return zzezVar.zza(null).longValue();
        }
        try {
            return zzezVar.zza(Long.valueOf(Long.parseLong(strZza))).longValue();
        } catch (NumberFormatException unused) {
            return zzezVar.zza(null).longValue();
        }
    }

    public final int zzb(String str, zzez<Integer> zzezVar) {
        if (str == null) {
            return zzezVar.zza(null).intValue();
        }
        String strZza = this.zzb.zza(str, zzezVar.zza());
        if (TextUtils.isEmpty(strZza)) {
            return zzezVar.zza(null).intValue();
        }
        try {
            return zzezVar.zza(Integer.valueOf(Integer.parseInt(strZza))).intValue();
        } catch (NumberFormatException unused) {
            return zzezVar.zza(null).intValue();
        }
    }

    public final double zzc(String str, zzez<Double> zzezVar) {
        if (str == null) {
            return zzezVar.zza(null).doubleValue();
        }
        String strZza = this.zzb.zza(str, zzezVar.zza());
        if (TextUtils.isEmpty(strZza)) {
            return zzezVar.zza(null).doubleValue();
        }
        try {
            return zzezVar.zza(Double.valueOf(Double.parseDouble(strZza))).doubleValue();
        } catch (NumberFormatException unused) {
            return zzezVar.zza(null).doubleValue();
        }
    }

    public final boolean zzd(String str, zzez<Boolean> zzezVar) {
        if (str == null) {
            return zzezVar.zza(null).booleanValue();
        }
        String strZza = this.zzb.zza(str, zzezVar.zza());
        if (TextUtils.isEmpty(strZza)) {
            return zzezVar.zza(null).booleanValue();
        }
        return zzezVar.zza(Boolean.valueOf(Boolean.parseBoolean(strZza))).booleanValue();
    }

    public final boolean zze(String str, zzez<Boolean> zzezVar) {
        return zzd(str, zzezVar);
    }

    public final boolean zza(zzez<Boolean> zzezVar) {
        return zzd(null, zzezVar);
    }

    private final Bundle zzy() {
        try {
            if (zzn().getPackageManager() == null) {
                zzr().zzf().zza("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(zzn()).getApplicationInfo(zzn().getPackageName(), 128);
            if (applicationInfo == null) {
                zzr().zzf().zza("Failed to load metadata: ApplicationInfo is null");
                return null;
            }
            return applicationInfo.metaData;
        } catch (PackageManager.NameNotFoundException e) {
            zzr().zzf().zza("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    final Boolean zzd(String str) {
        Preconditions.checkNotEmpty(str);
        Bundle bundleZzy = zzy();
        if (bundleZzy == null) {
            zzr().zzf().zza("Failed to load metadata: Metadata bundle is null");
            return null;
        }
        if (bundleZzy.containsKey(str)) {
            return Boolean.valueOf(bundleZzy.getBoolean(str));
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:14:0x003d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:15:0x003e A[Catch: NotFoundException -> 0x0043, TRY_LEAVE, TryCatch #0 {NotFoundException -> 0x0043, blocks: (B:12:0x002b, B:15:0x003e), top: B:20:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:20:0x002b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    final List<String> zze(String str) {
        Integer numValueOf;
        String[] stringArray;
        Preconditions.checkNotEmpty(str);
        Bundle bundleZzy = zzy();
        if (bundleZzy == null) {
            zzr().zzf().zza("Failed to load metadata: Metadata bundle is null");
        } else {
            if (bundleZzy.containsKey(str)) {
                numValueOf = Integer.valueOf(bundleZzy.getInt(str));
            }
            if (numValueOf == null) {
                return null;
            }
            try {
                stringArray = zzn().getResources().getStringArray(numValueOf.intValue());
                if (stringArray == null) {
                    return null;
                }
                return Arrays.asList(stringArray);
            } catch (Resources.NotFoundException e) {
                zzr().zzf().zza("Failed to load string array from metadata: resource not found", e);
                return null;
            }
        }
        numValueOf = null;
        if (numValueOf == null) {
            return null;
        }
        stringArray = zzn().getResources().getStringArray(numValueOf.intValue());
        if (stringArray == null) {
            return null;
        }
        return Arrays.asList(stringArray);
    }

    public final boolean zzg() {
        zzu();
        Boolean boolZzd = zzd("firebase_analytics_collection_deactivated");
        return boolZzd != null && boolZzd.booleanValue();
    }

    public final Boolean zzh() {
        zzu();
        return zzd("firebase_analytics_collection_enabled");
    }

    public final Boolean zzi() {
        zzb();
        Boolean boolZzd = zzd("google_analytics_adid_collection_enabled");
        return Boolean.valueOf(boolZzd == null || boolZzd.booleanValue());
    }

    public static long zzj() {
        return zzap.zzac.zza(null).longValue();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002f  */
    public final String zza(zzg zzgVar) {
        Uri.Builder builder = new Uri.Builder();
        String strZze = zzgVar.zze();
        if (TextUtils.isEmpty(strZze)) {
            if (zzll.zzb() && zzt().zzd(zzgVar.zzc(), zzap.zzch)) {
                strZze = zzgVar.zzg();
                if (TextUtils.isEmpty(strZze)) {
                    strZze = zzgVar.zzf();
                }
            } else {
                strZze = zzgVar.zzf();
            }
        }
        Uri.Builder builderEncodedAuthority = builder.scheme(zzap.zzd.zza(null)).encodedAuthority(zzap.zze.zza(null));
        String strValueOf = String.valueOf(strZze);
        builderEncodedAuthority.path(strValueOf.length() != 0 ? "config/app/".concat(strValueOf) : new String("config/app/")).appendQueryParameter("app_instance_id", zzgVar.zzd()).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", String.valueOf(zze()));
        return builder.build().toString();
    }

    public static long zzk() {
        return zzap.zzc.zza(null).longValue();
    }

    public final String zzv() {
        return zza("debug.firebase.analytics.app", "");
    }

    public final String zzw() {
        return zza("debug.deferred.deeplink", "");
    }

    private final String zza(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod(PasskeyWebListener.GET_UNIQUE_KEY, String.class, String.class).invoke(null, str, str2);
        } catch (ClassNotFoundException e) {
            zzr().zzf().zza("Could not find SystemProperties class", e);
            return str2;
        } catch (IllegalAccessException e2) {
            zzr().zzf().zza("Could not access SystemProperties.get()", e2);
            return str2;
        } catch (NoSuchMethodException e3) {
            zzr().zzf().zza("Could not find SystemProperties.get() method", e3);
            return str2;
        } catch (InvocationTargetException e4) {
            zzr().zzf().zza("SystemProperties.get() threw an exception", e4);
            return str2;
        }
    }

    public final boolean zzf(String str) {
        return "1".equals(this.zzb.zza(str, "gaia_collection_enabled"));
    }

    public final boolean zzg(String str) {
        return "1".equals(this.zzb.zza(str, "measurement.event_sampling_enabled"));
    }

    final boolean zzh(String str) {
        return zzd(str, zzap.zzai);
    }

    final String zzi(String str) {
        zzez<String> zzezVar = zzap.zzaj;
        if (str == null) {
            return zzezVar.zza(null);
        }
        return zzezVar.zza(this.zzb.zza(str, zzezVar.zza()));
    }

    final boolean zzx() {
        if (this.zza == null) {
            Boolean boolZzd = zzd("app_measurement_lite");
            this.zza = boolZzd;
            if (boolZzd == null) {
                this.zza = false;
            }
        }
        return this.zza.booleanValue() || !this.zzx.zzt();
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
