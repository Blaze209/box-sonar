package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
public class zzgo implements zzhh {
    private static volatile zzgo zza;
    private long zzaa;
    private volatile Boolean zzab;
    private Boolean zzac;
    private Boolean zzad;
    private int zzae;
    private final long zzag;
    private final Context zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final boolean zzf;
    private final zzw zzg;
    private final zzx zzh;
    private final zzft zzi;
    private final zzfk zzj;
    private final zzgh zzk;
    private final zzkc zzl;
    private final zzla zzm;
    private final zzfi zzn;
    private final Clock zzo;
    private final zziw zzp;
    private final zzhp zzq;
    private final zzb zzr;
    private final zzin zzs;
    private zzfg zzt;
    private zzix zzu;
    private zzah zzv;
    private zzfd zzw;
    private zzfz zzx;
    private Boolean zzz;
    private boolean zzy = false;
    private AtomicInteger zzaf = new AtomicInteger(0);

    private zzgo(zzhq zzhqVar) {
        boolean z = false;
        Preconditions.checkNotNull(zzhqVar);
        zzw zzwVar = new zzw(zzhqVar.zza);
        this.zzg = zzwVar;
        zzfa.zza = zzwVar;
        Context context = zzhqVar.zza;
        this.zzb = context;
        this.zzc = zzhqVar.zzb;
        this.zzd = zzhqVar.zzc;
        this.zze = zzhqVar.zzd;
        this.zzf = zzhqVar.zzh;
        this.zzab = zzhqVar.zze;
        com.google.android.gms.internal.measurement.zzv zzvVar = zzhqVar.zzg;
        if (zzvVar != null && zzvVar.zzg != null) {
            Object obj = zzvVar.zzg.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.zzac = (Boolean) obj;
            }
            Object obj2 = zzvVar.zzg.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.zzad = (Boolean) obj2;
            }
        }
        com.google.android.gms.internal.measurement.zzcl.zza(context);
        Clock defaultClock = DefaultClock.getInstance();
        this.zzo = defaultClock;
        this.zzag = defaultClock.currentTimeMillis();
        this.zzh = new zzx(this);
        zzft zzftVar = new zzft(this);
        zzftVar.zzab();
        this.zzi = zzftVar;
        zzfk zzfkVar = new zzfk(this);
        zzfkVar.zzab();
        this.zzj = zzfkVar;
        zzla zzlaVar = new zzla(this);
        zzlaVar.zzab();
        this.zzm = zzlaVar;
        zzfi zzfiVar = new zzfi(this);
        zzfiVar.zzab();
        this.zzn = zzfiVar;
        this.zzr = new zzb(this);
        zziw zziwVar = new zziw(this);
        zziwVar.zzx();
        this.zzp = zziwVar;
        zzhp zzhpVar = new zzhp(this);
        zzhpVar.zzx();
        this.zzq = zzhpVar;
        zzkc zzkcVar = new zzkc(this);
        zzkcVar.zzx();
        this.zzl = zzkcVar;
        zzin zzinVar = new zzin(this);
        zzinVar.zzab();
        this.zzs = zzinVar;
        zzgh zzghVar = new zzgh(this);
        zzghVar.zzab();
        this.zzk = zzghVar;
        if (zzhqVar.zzg != null && zzhqVar.zzg.zzb != 0) {
            z = true;
        }
        if (context.getApplicationContext() instanceof Application) {
            zzhp zzhpVarZzh = zzh();
            if (zzhpVarZzh.zzn().getApplicationContext() instanceof Application) {
                Application application = (Application) zzhpVarZzh.zzn().getApplicationContext();
                if (zzhpVarZzh.zza == null) {
                    zzhpVarZzh.zza = new zzim(zzhpVarZzh, null);
                }
                if (!z) {
                    application.unregisterActivityLifecycleCallbacks(zzhpVarZzh.zza);
                    application.registerActivityLifecycleCallbacks(zzhpVarZzh.zza);
                    zzhpVarZzh.zzr().zzx().zza("Registered activity lifecycle callback");
                }
            }
        } else {
            zzr().zzi().zza("Application context is not an Application");
        }
        zzghVar.zza(new zzgq(this, zzhqVar));
    }

    final void zzae() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzhq zzhqVar) {
        String strConcat;
        zzfm zzfmVarZzv;
        zzq().zzd();
        zzah zzahVar = new zzah(this);
        zzahVar.zzab();
        this.zzv = zzahVar;
        zzfd zzfdVar = new zzfd(this, zzhqVar.zzf);
        zzfdVar.zzx();
        this.zzw = zzfdVar;
        zzfg zzfgVar = new zzfg(this);
        zzfgVar.zzx();
        this.zzt = zzfgVar;
        zzix zzixVar = new zzix(this);
        zzixVar.zzx();
        this.zzu = zzixVar;
        this.zzm.zzac();
        this.zzi.zzac();
        this.zzx = new zzfz(this);
        this.zzw.zzy();
        zzr().zzv().zza("App measurement initialized, version", Long.valueOf(this.zzh.zze()));
        zzr().zzv().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String strZzab = zzfdVar.zzab();
        if (TextUtils.isEmpty(this.zzc)) {
            if (zzi().zzf(strZzab)) {
                zzfmVarZzv = zzr().zzv();
                strConcat = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
            } else {
                zzfm zzfmVarZzv2 = zzr().zzv();
                String strValueOf = String.valueOf(strZzab);
                strConcat = strValueOf.length() != 0 ? "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(strValueOf) : new String("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ");
                zzfmVarZzv = zzfmVarZzv2;
            }
            zzfmVarZzv.zza(strConcat);
        }
        zzr().zzw().zza("Debug-level message logging enabled");
        if (this.zzae != this.zzaf.get()) {
            zzr().zzf().zza("Not all components initialized", Integer.valueOf(this.zzae), Integer.valueOf(this.zzaf.get()));
        }
        this.zzy = true;
    }

    protected final void zza() {
        zzq().zzd();
        if (zzc().zzc.zza() == 0) {
            zzc().zzc.zza(this.zzo.currentTimeMillis());
        }
        if (Long.valueOf(zzc().zzh.zza()).longValue() == 0) {
            zzr().zzx().zza("Persisting first open", Long.valueOf(this.zzag));
            zzc().zzh.zza(this.zzag);
        }
        if (!zzah()) {
            if (zzab()) {
                if (!zzi().zzd("android.permission.INTERNET")) {
                    zzr().zzf().zza("App is missing INTERNET permission");
                }
                if (!zzi().zzd("android.permission.ACCESS_NETWORK_STATE")) {
                    zzr().zzf().zza("App is missing ACCESS_NETWORK_STATE permission");
                }
                if (!Wrappers.packageManager(this.zzb).isCallerInstantApp() && !this.zzh.zzx()) {
                    if (!zzge.zza(this.zzb)) {
                        zzr().zzf().zza("AppMeasurementReceiver not registered/enabled");
                    }
                    if (!zzla.zza(this.zzb, false)) {
                        zzr().zzf().zza("AppMeasurementService not registered/enabled");
                    }
                }
                zzr().zzf().zza("Uploading is not possible. App measurement disabled");
            }
        } else {
            if (!TextUtils.isEmpty(zzy().zzac()) || !TextUtils.isEmpty(zzy().zzad())) {
                zzi();
                if (zzla.zza(zzy().zzac(), zzc().zzh(), zzy().zzad(), zzc().zzi())) {
                    zzr().zzv().zza("Rechecking which service to use due to a GMP App Id change");
                    zzc().zzk();
                    zzk().zzab();
                    this.zzu.zzah();
                    this.zzu.zzaf();
                    zzc().zzh.zza(this.zzag);
                    zzc().zzj.zza(null);
                }
                zzc().zzc(zzy().zzac());
                zzc().zzd(zzy().zzad());
            }
            zzh().zza(zzc().zzj.zza());
            if (com.google.android.gms.internal.measurement.zzka.zzb() && this.zzh.zza(zzap.zzcq) && !zzi().zzv() && !TextUtils.isEmpty(zzc().zzw.zza())) {
                zzr().zzi().zza("Remote config removed with active feature rollouts");
                zzc().zzw.zza(null);
            }
            if (!TextUtils.isEmpty(zzy().zzac()) || !TextUtils.isEmpty(zzy().zzad())) {
                boolean zZzab = zzab();
                if (!zzc().zzx() && !this.zzh.zzg()) {
                    zzc().zzc(!zZzab);
                }
                if (zZzab) {
                    zzh().zzai();
                }
                zze().zza.zza();
                zzw().zza(new AtomicReference<>());
            }
        }
        zzc().zzo.zza(this.zzh.zza(zzap.zzbi));
        zzc().zzp.zza(this.zzh.zza(zzap.zzbj));
    }

    @Override // com.google.android.gms.measurement.internal.zzhh
    public final zzw zzu() {
        return this.zzg;
    }

    public final zzx zzb() {
        return this.zzh;
    }

    public final zzft zzc() {
        zza((zzhf) this.zzi);
        return this.zzi;
    }

    @Override // com.google.android.gms.measurement.internal.zzhh
    public final zzfk zzr() {
        zzb(this.zzj);
        return this.zzj;
    }

    public final zzfk zzd() {
        zzfk zzfkVar = this.zzj;
        if (zzfkVar == null || !zzfkVar.zzz()) {
            return null;
        }
        return this.zzj;
    }

    @Override // com.google.android.gms.measurement.internal.zzhh
    public final zzgh zzq() {
        zzb(this.zzk);
        return this.zzk;
    }

    public final zzkc zze() {
        zzb(this.zzl);
        return this.zzl;
    }

    public final zzfz zzf() {
        return this.zzx;
    }

    final zzgh zzg() {
        return this.zzk;
    }

    public final zzhp zzh() {
        zzb(this.zzq);
        return this.zzq;
    }

    public final zzla zzi() {
        zza((zzhf) this.zzm);
        return this.zzm;
    }

    public final zzfi zzj() {
        zza((zzhf) this.zzn);
        return this.zzn;
    }

    public final zzfg zzk() {
        zzb(this.zzt);
        return this.zzt;
    }

    private final zzin zzaj() {
        zzb(this.zzs);
        return this.zzs;
    }

    @Override // com.google.android.gms.measurement.internal.zzhh
    public final Context zzn() {
        return this.zzb;
    }

    public final boolean zzl() {
        return TextUtils.isEmpty(this.zzc);
    }

    public final String zzo() {
        return this.zzc;
    }

    public final String zzp() {
        return this.zzd;
    }

    public final String zzs() {
        return this.zze;
    }

    public final boolean zzt() {
        return this.zzf;
    }

    @Override // com.google.android.gms.measurement.internal.zzhh
    public final Clock zzm() {
        return this.zzo;
    }

    public final zziw zzv() {
        zzb(this.zzp);
        return this.zzp;
    }

    public final zzix zzw() {
        zzb(this.zzu);
        return this.zzu;
    }

    public final zzah zzx() {
        zzb(this.zzv);
        return this.zzv;
    }

    public final zzfd zzy() {
        zzb(this.zzw);
        return this.zzw;
    }

    public final zzb zzz() {
        zzb zzbVar = this.zzr;
        if (zzbVar != null) {
            return zzbVar;
        }
        throw new IllegalStateException("Component not created");
    }

    public static zzgo zza(Context context, String str, String str2, Bundle bundle) {
        return zza(context, new com.google.android.gms.internal.measurement.zzv(0L, 0L, true, null, null, null, bundle));
    }

    public static zzgo zza(Context context, com.google.android.gms.internal.measurement.zzv zzvVar) {
        if (zzvVar != null && (zzvVar.zze == null || zzvVar.zzf == null)) {
            zzvVar = new com.google.android.gms.internal.measurement.zzv(zzvVar.zza, zzvVar.zzb, zzvVar.zzc, zzvVar.zzd, null, null, zzvVar.zzg);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zza == null) {
            synchronized (zzgo.class) {
                if (zza == null) {
                    zza = new zzgo(new zzhq(context, zzvVar));
                }
            }
        } else if (zzvVar != null && zzvVar.zzg != null && zzvVar.zzg.containsKey("dataCollectionDefaultEnabled")) {
            zza.zza(zzvVar.zzg.getBoolean("dataCollectionDefaultEnabled"));
        }
        return zza;
    }

    private final void zzak() {
        if (!this.zzy) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }

    private static void zzb(zzhi zzhiVar) {
        if (zzhiVar == null) {
            throw new IllegalStateException("Component not created");
        }
        if (zzhiVar.zzz()) {
            return;
        }
        String strValueOf = String.valueOf(zzhiVar.getClass());
        throw new IllegalStateException(new StringBuilder(String.valueOf(strValueOf).length() + 27).append("Component not initialized: ").append(strValueOf).toString());
    }

    private static void zzb(zze zzeVar) {
        if (zzeVar == null) {
            throw new IllegalStateException("Component not created");
        }
        if (zzeVar.zzv()) {
            return;
        }
        String strValueOf = String.valueOf(zzeVar.getClass());
        throw new IllegalStateException(new StringBuilder(String.valueOf(strValueOf).length() + 27).append("Component not initialized: ").append(strValueOf).toString());
    }

    private static void zza(zzhf zzhfVar) {
        if (zzhfVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    final void zza(boolean z) {
        this.zzab = Boolean.valueOf(z);
    }

    public final boolean zzaa() {
        return this.zzab != null && this.zzab.booleanValue();
    }

    public final boolean zzab() {
        if (com.google.android.gms.internal.measurement.zzkt.zzb() && this.zzh.zza(zzap.zzcy)) {
            return zzac() == 0;
        }
        zzq().zzd();
        zzak();
        if (this.zzh.zzg()) {
            return false;
        }
        Boolean bool = this.zzad;
        if (bool != null && bool.booleanValue()) {
            return false;
        }
        Boolean boolZzv = zzc().zzv();
        if (boolZzv != null) {
            return boolZzv.booleanValue();
        }
        Boolean boolZzh = this.zzh.zzh();
        if (boolZzh != null) {
            return boolZzh.booleanValue();
        }
        Boolean bool2 = this.zzac;
        if (bool2 != null) {
            return bool2.booleanValue();
        }
        if (GoogleServices.isMeasurementExplicitlyDisabled()) {
            return false;
        }
        if (!this.zzh.zza(zzap.zzaz) || this.zzab == null) {
            return true;
        }
        return this.zzab.booleanValue();
    }

    public final int zzac() {
        zzq().zzd();
        if (this.zzh.zzg()) {
            return 1;
        }
        Boolean bool = this.zzad;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        Boolean boolZzv = zzc().zzv();
        if (boolZzv != null) {
            return boolZzv.booleanValue() ? 0 : 3;
        }
        Boolean boolZzh = this.zzh.zzh();
        if (boolZzh != null) {
            return boolZzh.booleanValue() ? 0 : 4;
        }
        Boolean bool2 = this.zzac;
        if (bool2 != null) {
            return bool2.booleanValue() ? 0 : 5;
        }
        if (GoogleServices.isMeasurementExplicitlyDisabled()) {
            return 6;
        }
        return (!this.zzh.zza(zzap.zzaz) || this.zzab == null || this.zzab.booleanValue()) ? 0 : 7;
    }

    final long zzad() {
        Long lValueOf = Long.valueOf(zzc().zzh.zza());
        if (lValueOf.longValue() == 0) {
            return this.zzag;
        }
        return Math.min(this.zzag, lValueOf.longValue());
    }

    final void zzaf() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    final void zza(zzhi zzhiVar) {
        this.zzae++;
    }

    final void zza(zze zzeVar) {
        this.zzae++;
    }

    final void zzag() {
        this.zzaf.incrementAndGet();
    }

    protected final boolean zzah() {
        zzak();
        zzq().zzd();
        Boolean bool = this.zzz;
        if (bool == null || this.zzaa == 0 || (bool != null && !bool.booleanValue() && Math.abs(this.zzo.elapsedRealtime() - this.zzaa) > 1000)) {
            this.zzaa = this.zzo.elapsedRealtime();
            boolean z = true;
            Boolean boolValueOf = Boolean.valueOf(zzi().zzd("android.permission.INTERNET") && zzi().zzd("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.packageManager(this.zzb).isCallerInstantApp() || this.zzh.zzx() || (zzge.zza(this.zzb) && zzla.zza(this.zzb, false))));
            this.zzz = boolValueOf;
            if (boolValueOf.booleanValue()) {
                if (!zzi().zza(zzy().zzac(), zzy().zzad(), zzy().zzae()) && TextUtils.isEmpty(zzy().zzad())) {
                    z = false;
                }
                this.zzz = Boolean.valueOf(z);
            }
        }
        return this.zzz.booleanValue();
    }

    public final void zzai() {
        zzq().zzd();
        zzb(zzaj());
        String strZzab = zzy().zzab();
        Pair<String, Boolean> pairZza = zzc().zza(strZzab);
        if (!this.zzh.zzi().booleanValue() || ((Boolean) pairZza.second).booleanValue() || TextUtils.isEmpty((CharSequence) pairZza.first)) {
            zzr().zzw().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            return;
        }
        if (!zzaj().zzg()) {
            zzr().zzi().zza("Network is not available for Deferred Deep Link request. Skipping");
            return;
        }
        URL urlZza = zzi().zza(zzy().zzt().zze(), strZzab, (String) pairZza.first, zzc().zzv.zza() - 1);
        zzin zzinVarZzaj = zzaj();
        zziq zziqVar = new zziq(this) { // from class: com.google.android.gms.measurement.internal.zzgn
            private final zzgo zza;

            {
                this.zza = this;
            }

            @Override // com.google.android.gms.measurement.internal.zziq
            public final void zza(String str, int i, Throwable th, byte[] bArr, Map map) {
                this.zza.zza(str, i, th, bArr, map);
            }
        };
        zzinVarZzaj.zzd();
        zzinVarZzaj.zzaa();
        Preconditions.checkNotNull(urlZza);
        Preconditions.checkNotNull(zziqVar);
        zzinVarZzaj.zzq().zzb(new zzip(zzinVarZzaj, strZzab, urlZza, null, null, zziqVar));
    }

    final /* synthetic */ void zza(String str, int i, Throwable th, byte[] bArr, Map map) {
        List<ResolveInfo> listQueryIntentActivities;
        if ((i != 200 && i != 204 && i != 304) || th != null) {
            zzr().zzi().zza("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i), th);
            return;
        }
        zzc().zzu.zza(true);
        if (bArr.length == 0) {
            zzr().zzw().zza("Deferred Deep Link response empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String strOptString = jSONObject.optString("deeplink", "");
            String strOptString2 = jSONObject.optString("gclid", "");
            double dOptDouble = jSONObject.optDouble("timestamp", 0.0d);
            if (TextUtils.isEmpty(strOptString)) {
                zzr().zzw().zza("Deferred Deep Link is empty.");
                return;
            }
            zzla zzlaVarZzi = zzi();
            zzlaVarZzi.zzb();
            if (TextUtils.isEmpty(strOptString) || (listQueryIntentActivities = MAMPackageManagement.queryIntentActivities(zzlaVarZzi.zzn().getPackageManager(), new Intent("android.intent.action.VIEW", Uri.parse(strOptString)), 0)) == null || listQueryIntentActivities.isEmpty()) {
                zzr().zzi().zza("Deferred Deep Link validation failed. gclid, deep link", strOptString2, strOptString);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("gclid", strOptString2);
            bundle.putString("_cis", "ddp");
            this.zzq.zza("auto", "_cmp", bundle);
            zzla zzlaVarZzi2 = zzi();
            if (TextUtils.isEmpty(strOptString) || !zzlaVarZzi2.zza(strOptString, dOptDouble)) {
                return;
            }
            zzlaVarZzi2.zzn().sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
        } catch (JSONException e) {
            zzr().zzf().zza("Failed to parse the Deferred Deep Link response. exception", e);
        }
    }
}
