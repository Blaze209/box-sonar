package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.measurement.zzle;
import com.google.android.gms.internal.measurement.zzmv;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzhp extends zze {
    protected zzim zza;
    protected boolean zzb;
    private zzho zzc;
    private final Set<zzhn> zzd;
    private boolean zze;
    private final AtomicReference<String> zzf;

    protected zzhp(zzgo zzgoVar) {
        super(zzgoVar);
        this.zzd = new CopyOnWriteArraySet();
        this.zzb = true;
        this.zzf = new AtomicReference<>();
    }

    @Override // com.google.android.gms.measurement.internal.zze
    protected final boolean zzz() {
        return false;
    }

    public final void zzab() {
        if (zzn().getApplicationContext() instanceof Application) {
            ((Application) zzn().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
        }
    }

    public final Boolean zzac() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzq().zza(atomicReference, 15000L, "boolean test flag value", new zzhr(this, atomicReference));
    }

    public final String zzad() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzq().zza(atomicReference, 15000L, "String test flag value", new zzib(this, atomicReference));
    }

    public final Long zzae() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzq().zza(atomicReference, 15000L, "long test flag value", new zzid(this, atomicReference));
    }

    public final Integer zzaf() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzq().zza(atomicReference, 15000L, "int test flag value", new zzig(this, atomicReference));
    }

    public final Double zzag() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzq().zza(atomicReference, 15000L, "double test flag value", new zzif(this, atomicReference));
    }

    public final void zza(boolean z) {
        zzw();
        zzb();
        zzq().zza(new zzii(this, z));
    }

    public final void zzb(boolean z) {
        zzw();
        zzb();
        zzq().zza(new zzih(this, z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzd(boolean z) {
        zzd();
        zzb();
        zzw();
        zzr().zzw().zza("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzs().zzb(z);
        zzam();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:14:0x0059  */
    public final void zzam() {
        zzhp zzhpVar;
        if (zzt().zza(zzap.zzbd)) {
            zzd();
            String strZza = zzs().zzn.zza();
            if (strZza == null) {
                zzhpVar = this;
            } else if ("unset".equals(strZza)) {
                zzhpVar = this;
                zzhpVar.zza("app", "_npa", (Object) null, zzm().currentTimeMillis());
            } else {
                zzhpVar = this;
                zzhpVar.zza("app", "_npa", Long.valueOf(TelemetryEventStrings.Value.TRUE.equals(strZza) ? 1L : 0L), zzhpVar.zzm().currentTimeMillis());
            }
        } else {
            zzhpVar = this;
        }
        if (zzhpVar.zzx.zzab() && zzhpVar.zzb) {
            zzhpVar.zzr().zzw().zza("Recording app launch after enabling measurement for the first time (FE)");
            zzhpVar.zzai();
            if (zzle.zzb() && zzhpVar.zzt().zza(zzap.zzcr)) {
                zzhpVar.zzk().zza.zza();
            }
            if (com.google.android.gms.internal.measurement.zzkh.zzb() && zzhpVar.zzt().zza(zzap.zzcx) && zzhpVar.zzx.zzf().zza.zzc().zzi.zza() <= 0) {
                zzhpVar.zzx.zzf().zza();
                return;
            }
            return;
        }
        zzhpVar.zzr().zzw().zza("Updating Scion state (FE)");
        zzhpVar.zzh().zzac();
    }

    public final void zza(long j) {
        zzb();
        zzq().zza(new zzik(this, j));
    }

    public final void zzb(long j) {
        zzb();
        zzq().zza(new zzij(this, j));
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z) {
        zza(str, str2, bundle, false, true, zzm().currentTimeMillis());
    }

    public final void zza(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, zzm().currentTimeMillis());
    }

    final void zzb(String str, String str2, Bundle bundle) {
        zzb();
        zzd();
        zza(str, str2, zzm().currentTimeMillis(), bundle);
    }

    final void zza(String str, String str2, long j, Bundle bundle) {
        zzb();
        zzd();
        zza(str, str2, j, bundle, true, this.zzc == null || zzla.zze(str2), false, null);
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00fa  */
    protected final void zza(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzhp zzhpVar;
        long j2;
        String str4;
        String str5;
        int i;
        String str6;
        int i2;
        Class<?> cls;
        List<String> listZzah;
        String str7 = str;
        Preconditions.checkNotEmpty(str7);
        Preconditions.checkNotNull(bundle);
        zzd();
        zzw();
        if (!this.zzx.zzab()) {
            zzr().zzw().zza("Event not sent since app measurement is disabled");
            return;
        }
        if (zzt().zza(zzap.zzbl) && (listZzah = zzg().zzah()) != null && !listZzah.contains(str2)) {
            zzr().zzw().zza("Dropping non-safelisted event. event name, origin", str2, str7);
            return;
        }
        if (!this.zze) {
            this.zze = true;
            try {
                if (!this.zzx.zzt()) {
                    cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, zzn().getClassLoader());
                } else {
                    cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService");
                }
                try {
                    cls.getDeclaredMethod("initialize", Context.class).invoke(null, zzn());
                } catch (Exception e) {
                    zzr().zzi().zza("Failed to invoke Tag Manager's initialize() method", e);
                }
            } catch (ClassNotFoundException unused) {
                zzr().zzv().zza("Tag Manager is not found and thus will not be used");
            }
        }
        if (zzt().zza(zzap.zzca) && "_cmp".equals(str2) && bundle.containsKey("gclid")) {
            zza("auto", "_lgclid", bundle.getString("gclid"), zzm().currentTimeMillis());
        }
        if (z3) {
            zzu();
            if (!"_iap".equals(str2)) {
                zzla zzlaVarZzi = this.zzx.zzi();
                if (!zzlaVarZzi.zza("event", str2)) {
                    i2 = 2;
                } else if (!zzlaVarZzi.zza("event", zzhj.zza, str2)) {
                    i2 = 13;
                } else if (zzlaVarZzi.zza("event", 40, str2)) {
                    i2 = 0;
                } else {
                    i2 = 2;
                }
                if (i2 != 0) {
                    zzr().zzh().zza("Invalid public event name. Event will not be logged (FE)", zzo().zza(str2));
                    this.zzx.zzi();
                    this.zzx.zzi().zza(i2, "_ev", zzla.zza(str2, 40, true), str2 != null ? str2.length() : 0);
                    return;
                }
            }
        }
        zzu();
        zzit zzitVarZzab = zzi().zzab();
        if (zzitVarZzab != null && !bundle.containsKey("_sc")) {
            zzitVarZzab.zzd = true;
        }
        zziw.zza(zzitVarZzab, bundle, z && z3);
        boolean zEquals = "am".equals(str7);
        boolean zZze = zzla.zze(str2);
        if (z && this.zzc != null && !zZze && !zEquals) {
            zzr().zzw().zza("Passing event to registered event handler (FE)", zzo().zza(str2), zzo().zza(bundle));
            this.zzc.interceptEvent(str7, str2, bundle, j);
            return;
        }
        if (this.zzx.zzah()) {
            int iZzb = zzp().zzb(str2);
            if (iZzb != 0) {
                zzr().zzh().zza("Invalid event name. Event will not be logged (FE)", zzo().zza(str2));
                zzp();
                this.zzx.zzi().zza(str3, iZzb, "_ev", zzla.zza(str2, 40, true), str2 != null ? str2.length() : 0);
                return;
            }
            List<String> listListOf = CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"});
            Bundle bundleZza = zzp().zza(str3, str2, bundle, listListOf, z3, true);
            zzit zzitVar = (bundleZza != null && bundleZza.containsKey("_sc") && bundleZza.containsKey("_si")) ? new zzit(bundleZza.getString("_sn"), bundleZza.getString("_sc"), Long.valueOf(bundleZza.getLong("_si")).longValue()) : null;
            if (zzitVar != null) {
                zzitVarZzab = zzitVar;
            }
            String str8 = "_ae";
            if (zzt().zza(zzap.zzba)) {
                zzu();
                if (zzi().zzab() != null && "_ae".equals(str2)) {
                    long jZzb = zzk().zzb.zzb();
                    if (jZzb > 0) {
                        zzp().zza(bundleZza, jZzb);
                    }
                }
            }
            if (com.google.android.gms.internal.measurement.zzka.zzb() && zzt().zza(zzap.zzcq)) {
                if (!"auto".equals(str7) && "_ssr".equals(str2)) {
                    zzla zzlaVarZzp = zzp();
                    String string = bundleZza.getString("_ffr");
                    String strTrim = Strings.isEmptyOrWhitespace(string) ? null : string.trim();
                    if (zzla.zzc(strTrim, zzlaVarZzp.zzs().zzw.zza())) {
                        zzlaVarZzp.zzr().zzw().zza("Not logging duplicate session_start_with_rollout event");
                        return;
                    }
                    zzlaVarZzp.zzs().zzw.zza(strTrim);
                } else if ("_ae".equals(str2)) {
                    String strZza = zzp().zzs().zzw.zza();
                    if (!TextUtils.isEmpty(strZza)) {
                        bundleZza.putString("_ffr", strZza);
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(bundleZza);
            long jNextLong = zzp().zzh().nextLong();
            if (zzt().zza(zzap.zzau) && zzs().zzq.zza() > 0 && zzs().zza(j) && zzs().zzt.zza()) {
                zzr().zzx().zza("Current session is expired, remove the session number, ID, and engagement time");
                if (zzt().zza(zzap.zzar)) {
                    j2 = jNextLong;
                    zza("auto", "_sid", (Object) null, zzm().currentTimeMillis());
                } else {
                    j2 = jNextLong;
                }
                if (zzt().zza(zzap.zzas)) {
                    zza("auto", "_sno", (Object) null, zzm().currentTimeMillis());
                }
                if (zzmv.zzb() && zzt().zza(zzap.zzbq)) {
                    zza("auto", "_se", (Object) null, zzm().currentTimeMillis());
                    zzhpVar = this;
                } else {
                    zzhpVar = this;
                }
            } else {
                zzhpVar = this;
                j2 = jNextLong;
            }
            if (zzhpVar.zzt().zza(zzap.zzat) && bundleZza.getLong(FirebaseAnalytics.Param.EXTEND_SESSION, 0L) == 1) {
                zzhpVar.zzr().zzx().zza("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                zzhpVar.zzx.zze().zza.zza(j, true);
            }
            String[] strArr = (String[]) bundleZza.keySet().toArray(new String[bundleZza.size()]);
            Arrays.sort(strArr);
            if (com.google.android.gms.internal.measurement.zzjp.zzb() && zzhpVar.zzt().zza(zzap.zzdd) && zzhpVar.zzt().zza(zzap.zzdc)) {
                for (String str9 : strArr) {
                    zzhpVar.zzp();
                    Bundle[] bundleArrZza = zzla.zza(bundleZza.get(str9));
                    if (bundleArrZza != null) {
                        bundleZza.putParcelableArray(str9, bundleArrZza);
                    }
                }
                str4 = str2;
                str5 = "_ae";
            } else {
                int length = strArr.length;
                int i3 = 0;
                int length2 = 0;
                while (i3 < length) {
                    String str10 = strArr[i3];
                    Object obj = bundleZza.get(str10);
                    zzhpVar.zzp();
                    Bundle[] bundleArrZza2 = zzla.zza(obj);
                    if (bundleArrZza2 != null) {
                        bundleZza.putInt(str10, bundleArrZza2.length);
                        int i4 = 0;
                        while (i4 < bundleArrZza2.length) {
                            Bundle bundle2 = bundleArrZza2[i4];
                            zziw.zza(zzitVarZzab, bundle2, true);
                            Bundle bundleZza2 = zzhpVar.zzp().zza(str3, "_ep", bundle2, listListOf, z3, false);
                            bundleZza2.putString("_en", str2);
                            bundleZza2.putLong("_eid", j2);
                            bundleZza2.putString("_gn", str10);
                            bundleZza2.putInt("_ll", bundleArrZza2.length);
                            bundleZza2.putInt("_i", i4);
                            arrayList.add(bundleZza2);
                            i4++;
                            str8 = str8;
                            str10 = str10;
                            i3 = i3;
                        }
                        i = i3;
                        str6 = str8;
                        length2 += bundleArrZza2.length;
                    } else {
                        i = i3;
                        str6 = str8;
                    }
                    i3 = i + 1;
                    strArr = strArr;
                    length = length;
                    j2 = j2;
                    str8 = str6;
                }
                str4 = str2;
                str5 = str8;
                long j3 = j2;
                if (length2 != 0) {
                    bundleZza.putLong("_eid", j3);
                    bundleZza.putInt("_epc", length2);
                }
            }
            int i5 = 0;
            while (i5 < arrayList.size()) {
                Bundle bundleZza3 = (Bundle) arrayList.get(i5);
                String str11 = i5 != 0 ? "_ep" : str4;
                bundleZza3.putString("_o", str7);
                if (z2) {
                    bundleZza3 = zzhpVar.zzp().zza(bundleZza3);
                }
                Bundle bundle3 = bundleZza3;
                if (!com.google.android.gms.internal.measurement.zzkt.zzb() || !zzhpVar.zzt().zza(zzap.zzcy)) {
                    zzhpVar.zzr().zzw().zza("Logging event (FE)", zzhpVar.zzo().zza(str4), zzhpVar.zzo().zza(bundle3));
                }
                zzhpVar.zzh().zza(new zzan(str11, new zzam(bundle3), str7, j), str3);
                if (!zEquals) {
                    Iterator<zzhn> it = zzhpVar.zzd.iterator();
                    while (it.hasNext()) {
                        it.next().onEvent(str, str4, new Bundle(bundle3), j);
                    }
                }
                i5++;
                str7 = str;
                str4 = str4;
            }
            String str12 = str4;
            zzhpVar.zzu();
            if (zzhpVar.zzi().zzab() == null || !str5.equals(str12)) {
                return;
            }
            zzhpVar.zzk().zza(true, true, zzhpVar.zzm().elapsedRealtime());
        }
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        zzb();
        if (str == null) {
            str = "app";
        }
        String str3 = str;
        if (bundle == null) {
            bundle = new Bundle();
        }
        zzb(str3, str2, j, bundle, z2, !z2 || this.zzc == null || zzla.zze(str2), !z, null);
    }

    private final void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzq().zza(new zzhu(this, str, str2, j, zzla.zzb(bundle), z, z2, z3, str3));
    }

    public final void zza(String str, String str2, Object obj, boolean z) {
        zza(str, str2, obj, z, zzm().currentTimeMillis());
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0020  */
    public final void zza(String str, String str2, Object obj, boolean z, long j) {
        int iZzc;
        if (str == null) {
            str = "app";
        }
        String str3 = str;
        if (z) {
            iZzc = zzp().zzc(str2);
        } else {
            zzla zzlaVarZzp = zzp();
            if (!zzlaVarZzp.zza("user property", str2)) {
                iZzc = 6;
            } else if (!zzlaVarZzp.zza("user property", zzhl.zza, str2)) {
                iZzc = 15;
            } else if (zzlaVarZzp.zza("user property", 24, str2)) {
                iZzc = 0;
            } else {
                iZzc = 6;
            }
        }
        if (iZzc != 0) {
            zzp();
            this.zzx.zzi().zza(iZzc, "_ev", zzla.zza(str2, 24, true), str2 != null ? str2.length() : 0);
            return;
        }
        if (obj != null) {
            int iZzb = zzp().zzb(str2, obj);
            if (iZzb != 0) {
                zzp();
                this.zzx.zzi().zza(iZzb, "_ev", zzla.zza(str2, 24, true), ((obj instanceof String) || (obj instanceof CharSequence)) ? String.valueOf(obj).length() : 0);
                return;
            } else {
                Object objZzc = zzp().zzc(str2, obj);
                if (objZzc != null) {
                    zza(str3, str2, j, objZzc);
                    return;
                }
                return;
            }
        }
        zza(str3, str2, j, (Object) null);
    }

    private final void zza(String str, String str2, long j, Object obj) {
        zzq().zza(new zzht(this, str, str2, obj, j));
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0062 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:19:0x0064  */
    /* JADX WARN: Code duplicated, block: B:21:0x0072  */
    final void zza(String str, String str2, Object obj, long j) {
        String str3;
        Object obj2;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzb();
        zzw();
        if (zzt().zza(zzap.zzbd) && FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS.equals(str2)) {
            if (obj instanceof String) {
                String str4 = (String) obj;
                if (!TextUtils.isEmpty(str4)) {
                    Long lValueOf = Long.valueOf("false".equals(str4.toLowerCase(Locale.ENGLISH)) ? 1L : 0L);
                    zzs().zzn.zza(lValueOf.longValue() == 1 ? TelemetryEventStrings.Value.TRUE : "false");
                    obj2 = lValueOf;
                } else if (obj == null) {
                    zzs().zzn.zza("unset");
                    obj2 = obj;
                } else {
                    str3 = str2;
                    obj2 = obj;
                }
            } else if (obj == null) {
                zzs().zzn.zza("unset");
                obj2 = obj;
            } else {
                str3 = str2;
                obj2 = obj;
            }
            str3 = "_npa";
        } else {
            str3 = str2;
            obj2 = obj;
        }
        if (!this.zzx.zzab()) {
            zzr().zzx().zza("User property not set since app measurement is disabled");
        } else if (this.zzx.zzah()) {
            zzh().zza(new zzkz(str3, j, obj2, str));
        }
    }

    public final List<zzkz> zzc(boolean z) {
        zzb();
        zzw();
        zzr().zzx().zza("Getting user properties (FE)");
        if (zzq().zzg()) {
            zzr().zzf().zza("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        }
        if (zzw.zza()) {
            zzr().zzf().zza("Cannot get all user properties from main thread");
            return Collections.emptyList();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzx.zzq().zza(atomicReference, 5000L, "get user properties", new zzhw(this, atomicReference, z));
        List<zzkz> list = (List) atomicReference.get();
        if (list != null) {
            return list;
        }
        zzr().zzf().zza("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z));
        return Collections.emptyList();
    }

    public final String zzah() {
        zzb();
        return this.zzf.get();
    }

    public final String zzc(long j) {
        if (zzq().zzg()) {
            zzr().zzf().zza("Cannot retrieve app instance id from analytics worker thread");
            return null;
        }
        if (zzw.zza()) {
            zzr().zzf().zza("Cannot retrieve app instance id from main thread");
            return null;
        }
        long jElapsedRealtime = zzm().elapsedRealtime();
        String strZze = zze(120000L);
        long jElapsedRealtime2 = zzm().elapsedRealtime() - jElapsedRealtime;
        return (strZze != null || jElapsedRealtime2 >= 120000) ? strZze : zze(120000 - jElapsedRealtime2);
    }

    final void zza(String str) {
        this.zzf.set(str);
    }

    private final String zze(long j) {
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            zzq().zza(new zzhv(this, atomicReference));
            try {
                atomicReference.wait(j);
            } catch (InterruptedException unused) {
                zzr().zzi().zza("Interrupted waiting for app instance id");
                return null;
            }
        }
        return (String) atomicReference.get();
    }

    public final void zzd(long j) {
        zza((String) null);
        zzq().zza(new zzhy(this, j));
    }

    public final void zzai() {
        zzd();
        zzb();
        zzw();
        if (this.zzx.zzah()) {
            if (zzt().zza(zzap.zzby)) {
                zzx zzxVarZzt = zzt();
                zzxVarZzt.zzu();
                Boolean boolZzd = zzxVarZzt.zzd("google_analytics_deferred_deep_link_enabled");
                if (boolZzd != null && boolZzd.booleanValue()) {
                    zzr().zzw().zza("Deferred Deep Link feature enabled.");
                    zzq().zza(new Runnable(this) { // from class: com.google.android.gms.measurement.internal.zzhs
                        private final zzhp zza;

                        {
                            this.zza = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            zzhp zzhpVar = this.zza;
                            zzhpVar.zzd();
                            if (zzhpVar.zzs().zzu.zza()) {
                                zzhpVar.zzr().zzw().zza("Deferred Deep Link already retrieved. Not fetching again.");
                                return;
                            }
                            long jZza = zzhpVar.zzs().zzv.zza();
                            zzhpVar.zzs().zzv.zza(1 + jZza);
                            if (jZza < 5) {
                                zzhpVar.zzx.zzai();
                            } else {
                                zzhpVar.zzr().zzi().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                                zzhpVar.zzs().zzu.zza(true);
                            }
                        }
                    });
                }
            }
            zzh().zzae();
            this.zzb = false;
            String strZzw = zzs().zzw();
            if (TextUtils.isEmpty(strZzw)) {
                return;
            }
            zzl().zzaa();
            if (strZzw.equals(Build.VERSION.RELEASE)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", strZzw);
            zza("auto", "_ou", bundle);
        }
    }

    public final void zza(zzho zzhoVar) {
        zzho zzhoVar2;
        zzd();
        zzb();
        zzw();
        if (zzhoVar != null && zzhoVar != (zzhoVar2 = this.zzc)) {
            Preconditions.checkState(zzhoVar2 == null, "EventInterceptor already set.");
        }
        this.zzc = zzhoVar;
    }

    public final void zza(zzhn zzhnVar) {
        zzb();
        zzw();
        Preconditions.checkNotNull(zzhnVar);
        if (this.zzd.add(zzhnVar)) {
            return;
        }
        zzr().zzi().zza("OnEventListener already registered");
    }

    public final void zzb(zzhn zzhnVar) {
        zzb();
        zzw();
        Preconditions.checkNotNull(zzhnVar);
        if (this.zzd.remove(zzhnVar)) {
            return;
        }
        zzr().zzi().zza("OnEventListener had not been registered");
    }

    public final void zza(Bundle bundle) {
        zza(bundle, zzm().currentTimeMillis());
    }

    public final void zza(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        zzb();
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            zzr().zzi().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        zzb(bundle2, j);
    }

    public final void zzb(Bundle bundle) {
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle.getString("app_id"));
        zza();
        zzb(new Bundle(bundle), zzm().currentTimeMillis());
    }

    private final void zzb(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        zzhk.zza(bundle, "app_id", String.class, null);
        zzhk.zza(bundle, "origin", String.class, null);
        zzhk.zza(bundle, "name", String.class, null);
        zzhk.zza(bundle, "value", Object.class, null);
        zzhk.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
        zzhk.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L);
        zzhk.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        zzhk.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzhk.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        zzhk.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzhk.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L);
        zzhk.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        zzhk.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle.getString("name"));
        Preconditions.checkNotEmpty(bundle.getString("origin"));
        Preconditions.checkNotNull(bundle.get("value"));
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle.getString("name");
        Object obj = bundle.get("value");
        if (zzp().zzc(string) != 0) {
            zzr().zzf().zza("Invalid conditional user property name", zzo().zzc(string));
            return;
        }
        if (zzp().zzb(string, obj) != 0) {
            zzr().zzf().zza("Invalid conditional user property value", zzo().zzc(string), obj);
            return;
        }
        Object objZzc = zzp().zzc(string, obj);
        if (objZzc == null) {
            zzr().zzf().zza("Unable to normalize conditional user property value", zzo().zzc(string), obj);
            return;
        }
        zzhk.zza(bundle, objZzc);
        long j2 = bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
        if (!TextUtils.isEmpty(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME)) && (j2 > 15552000000L || j2 < 1)) {
            zzr().zzf().zza("Invalid conditional user property timeout", zzo().zzc(string), Long.valueOf(j2));
            return;
        }
        long j3 = bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
        if (j3 > 15552000000L || j3 < 1) {
            zzr().zzf().zza("Invalid conditional user property time to live", zzo().zzc(string), Long.valueOf(j3));
        } else {
            zzq().zza(new zzia(this, bundle));
        }
    }

    public final void zzc(String str, String str2, Bundle bundle) {
        zzb();
        zzb((String) null, str, str2, bundle);
    }

    public final void zza(String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotEmpty(str);
        zza();
        zzb(str, str2, str3, bundle);
    }

    private final void zzb(String str, String str2, String str3, Bundle bundle) {
        long jCurrentTimeMillis = zzm().currentTimeMillis();
        Preconditions.checkNotEmpty(str2);
        Bundle bundle2 = new Bundle();
        if (str != null) {
            bundle2.putString("app_id", str);
        }
        bundle2.putString("name", str2);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, jCurrentTimeMillis);
        if (str3 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str3);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        zzq().zza(new zzhz(this, bundle2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzc(Bundle bundle) {
        zzd();
        zzw();
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle.getString("name"));
        Preconditions.checkNotEmpty(bundle.getString("origin"));
        Preconditions.checkNotNull(bundle.get("value"));
        if (!this.zzx.zzab()) {
            zzr().zzx().zza("Conditional property not set since app measurement is disabled");
            return;
        }
        zzkz zzkzVar = new zzkz(bundle.getString("name"), bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP), bundle.get("value"), bundle.getString("origin"));
        try {
            zzan zzanVarZza = zzp().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS), bundle.getString("origin"), 0L, true, false);
            zzh().zza(new zzv(bundle.getString("app_id"), bundle.getString("origin"), zzkzVar, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), false, bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), zzp().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS), bundle.getString("origin"), 0L, true, false), bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), zzanVarZza, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzp().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), bundle.getString("origin"), 0L, true, false)));
        } catch (IllegalArgumentException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzd(Bundle bundle) {
        zzd();
        zzw();
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle.getString("name"));
        if (!this.zzx.zzab()) {
            zzr().zzx().zza("Conditional property not cleared since app measurement is disabled");
            return;
        }
        try {
            zzh().zza(new zzv(bundle.getString("app_id"), bundle.getString("origin"), new zzkz(bundle.getString("name"), 0L, null, null), bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), bundle.getBoolean("active"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzp().zza(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), bundle.getString("origin"), bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), true, false)));
        } catch (IllegalArgumentException unused) {
        }
    }

    public final ArrayList<Bundle> zza(String str, String str2) {
        zzb();
        return zzb((String) null, str, str2);
    }

    public final ArrayList<Bundle> zza(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zza();
        return zzb(str, str2, str3);
    }

    private final ArrayList<Bundle> zzb(String str, String str2, String str3) {
        if (zzq().zzg()) {
            zzr().zzf().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        }
        if (zzw.zza()) {
            zzr().zzf().zza("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzx.zzq().zza(atomicReference, 5000L, "get conditional user properties", new zzic(this, atomicReference, str, str2, str3));
        List list = (List) atomicReference.get();
        if (list == null) {
            zzr().zzf().zza("Timed out waiting for get conditional user properties", str);
            return new ArrayList<>();
        }
        return zzla.zzb((List<zzv>) list);
    }

    public final Map<String, Object> zza(String str, String str2, boolean z) {
        zzb();
        return zzb((String) null, str, str2, z);
    }

    public final Map<String, Object> zza(String str, String str2, String str3, boolean z) {
        Preconditions.checkNotEmpty(str);
        zza();
        return zzb(str, str2, str3, z);
    }

    private final Map<String, Object> zzb(String str, String str2, String str3, boolean z) {
        if (zzq().zzg()) {
            zzr().zzf().zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        if (zzw.zza()) {
            zzr().zzf().zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzx.zzq().zza(atomicReference, 5000L, "get user properties", new zzie(this, atomicReference, str, str2, str3, z));
        List<zzkz> list = (List) atomicReference.get();
        if (list == null) {
            zzr().zzf().zza("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyMap();
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (zzkz zzkzVar : list) {
            arrayMap.put(zzkzVar.zza, zzkzVar.zza());
        }
        return arrayMap;
    }

    public final String zzaj() {
        zzit zzitVarZzac = this.zzx.zzv().zzac();
        if (zzitVarZzac != null) {
            return zzitVarZzac.zza;
        }
        return null;
    }

    public final String zzak() {
        zzit zzitVarZzac = this.zzx.zzv().zzac();
        if (zzitVarZzac != null) {
            return zzitVarZzac.zzb;
        }
        return null;
    }

    public final String zzal() {
        if (this.zzx.zzo() != null) {
            return this.zzx.zzo();
        }
        try {
            return GoogleServices.getGoogleAppId();
        } catch (IllegalStateException e) {
            this.zzx.zzr().zzf().zza("getGoogleAppId failed with exception", e);
            return null;
        }
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
