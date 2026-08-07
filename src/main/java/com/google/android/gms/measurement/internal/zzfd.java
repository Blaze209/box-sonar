package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.android.gms.internal.measurement.zzll;
import com.google.android.gms.internal.measurement.zznh;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzfd extends zze {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private long zzg;
    private List<String> zzh;
    private int zzi;
    private String zzj;
    private String zzk;
    private String zzl;

    zzfd(zzgo zzgoVar, long j) {
        super(zzgoVar);
        this.zzg = j;
    }

    @Override // com.google.android.gms.measurement.internal.zze
    protected final boolean zzz() {
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x027a A[Catch: IllegalStateException -> 0x02a8, TryCatch #3 {IllegalStateException -> 0x02a8, blocks: (B:81:0x0225, B:85:0x0232, B:88:0x023c, B:90:0x0248, B:94:0x025f, B:96:0x0267, B:103:0x028b, B:105:0x029f, B:107:0x02a4, B:106:0x02a2, B:98:0x026d, B:99:0x0274, B:101:0x027a), top: B:136:0x0225 }] */
    /* JADX WARN: Code duplicated, block: B:103:0x028b A[Catch: IllegalStateException -> 0x02a8, TryCatch #3 {IllegalStateException -> 0x02a8, blocks: (B:81:0x0225, B:85:0x0232, B:88:0x023c, B:90:0x0248, B:94:0x025f, B:96:0x0267, B:103:0x028b, B:105:0x029f, B:107:0x02a4, B:106:0x02a2, B:98:0x026d, B:99:0x0274, B:101:0x027a), top: B:136:0x0225 }] */
    /* JADX WARN: Code duplicated, block: B:105:0x029f A[Catch: IllegalStateException -> 0x02a8, TryCatch #3 {IllegalStateException -> 0x02a8, blocks: (B:81:0x0225, B:85:0x0232, B:88:0x023c, B:90:0x0248, B:94:0x025f, B:96:0x0267, B:103:0x028b, B:105:0x029f, B:107:0x02a4, B:106:0x02a2, B:98:0x026d, B:99:0x0274, B:101:0x027a), top: B:136:0x0225 }] */
    /* JADX WARN: Code duplicated, block: B:106:0x02a2 A[Catch: IllegalStateException -> 0x02a8, TryCatch #3 {IllegalStateException -> 0x02a8, blocks: (B:81:0x0225, B:85:0x0232, B:88:0x023c, B:90:0x0248, B:94:0x025f, B:96:0x0267, B:103:0x028b, B:105:0x029f, B:107:0x02a4, B:106:0x02a2, B:98:0x026d, B:99:0x0274, B:101:0x027a), top: B:136:0x0225 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:115:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:117:0x02de  */
    /* JADX WARN: Code duplicated, block: B:118:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:121:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:124:0x0309  */
    /* JADX WARN: Code duplicated, block: B:126:0x030d  */
    /* JADX WARN: Code duplicated, block: B:128:0x0318  */
    /* JADX WARN: Code duplicated, block: B:138:0x0309 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:37:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:40:0x00d3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:42:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:44:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:61:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:63:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:65:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:66:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:67:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:72:0x01ed A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:73:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:77:0x0211  */
    /* JADX WARN: Code duplicated, block: B:80:0x021d  */
    /* JADX WARN: Code duplicated, block: B:83:0x022f  */
    /* JADX WARN: Code duplicated, block: B:84:0x0231  */
    /* JADX WARN: Code duplicated, block: B:99:0x0274 A[Catch: IllegalStateException -> 0x02a8, TryCatch #3 {IllegalStateException -> 0x02a8, blocks: (B:81:0x0225, B:85:0x0232, B:88:0x023c, B:90:0x0248, B:94:0x025f, B:96:0x0267, B:103:0x028b, B:105:0x029f, B:107:0x02a4, B:106:0x02a2, B:98:0x026d, B:99:0x0274, B:101:0x027a), top: B:136:0x0225 }] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.measurement.internal.zze
    protected final void zzaa() {
        String str;
        String string;
        Status statusInitialize;
        boolean z;
        char c;
        char c2;
        boolean z2;
        List<String> listZze;
        Iterator<String> it;
        String googleAppId;
        String str2;
        String str3;
        Boolean boolZzh;
        String packageName = zzn().getPackageName();
        PackageManager packageManager = zzn().getPackageManager();
        String str4 = "";
        String installerPackageName = "unknown";
        String str5 = "Unknown";
        int i = Integer.MIN_VALUE;
        try {
            if (packageManager == null) {
                zzr().zzf().zza("PackageManager is null, app identity information might be inaccurate. appId", zzfk.zza(packageName));
            } else {
                try {
                    installerPackageName = MAMPackageManagement.getInstallerPackageName(packageManager, packageName);
                } catch (IllegalArgumentException unused) {
                    zzr().zzf().zza("Error retrieving app installer package name. appId", zzfk.zza(packageName));
                }
                if (installerPackageName == null) {
                    installerPackageName = "manual_install";
                } else if ("com.android.vending".equals(installerPackageName)) {
                    installerPackageName = "";
                }
                try {
                    PackageInfo packageInfo = MAMPackageManagement.getPackageInfo(packageManager, zzn().getPackageName(), 0);
                    if (packageInfo != null) {
                        CharSequence applicationLabel = MAMPackageManagement.getApplicationLabel(packageManager, packageInfo.applicationInfo);
                        string = !TextUtils.isEmpty(applicationLabel) ? applicationLabel.toString() : "Unknown";
                        try {
                            str5 = packageInfo.versionName;
                            i = packageInfo.versionCode;
                        } catch (PackageManager.NameNotFoundException unused2) {
                            str = str5;
                            str5 = string;
                            zzr().zzf().zza("Error retrieving package info. appId, appName", zzfk.zza(packageName), str5);
                            string = str5;
                            str5 = str;
                        }
                    }
                } catch (PackageManager.NameNotFoundException unused3) {
                    str = "Unknown";
                }
                this.zza = packageName;
                this.zzd = installerPackageName;
                this.zzb = str5;
                this.zzc = i;
                this.zze = string;
                this.zzf = 0L;
                zzu();
                statusInitialize = GoogleServices.initialize(zzn());
                z = true;
                if (statusInitialize == null && statusInitialize.isSuccess()) {
                    c = true;
                } else {
                    c = false;
                }
                if (TextUtils.isEmpty(this.zzx.zzo()) && "am".equals(this.zzx.zzp())) {
                    c2 = true;
                } else {
                    c2 = false;
                }
                z2 = c | c2;
                if (!z2) {
                    if (statusInitialize == null) {
                        zzr().zzg().zza("GoogleService failed to initialize (no status)");
                    } else {
                        zzr().zzg().zza("GoogleService failed to initialize, status", Integer.valueOf(statusInitialize.getStatusCode()), statusInitialize.getStatusMessage());
                    }
                }
                if (!z2) {
                    z = false;
                } else if (!com.google.android.gms.internal.measurement.zzkt.zzb() && zzt().zza(zzap.zzcy)) {
                    int iZzac = this.zzx.zzac();
                    switch (iZzac) {
                        case 0:
                            zzr().zzx().zza("App measurement collection enabled");
                            break;
                        case 1:
                            zzr().zzv().zza("App measurement deactivated via the manifest");
                            break;
                        case 2:
                            zzr().zzx().zza("App measurement deactivated via the init parameters");
                            break;
                        case 3:
                            zzr().zzv().zza("App measurement disabled by setMeasurementEnabled(false)");
                            break;
                        case 4:
                            zzr().zzv().zza("App measurement disabled via the manifest");
                            break;
                        case 5:
                            zzr().zzx().zza("App measurement disabled via the init parameters");
                            break;
                        case 6:
                            zzr().zzk().zza("App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics");
                            break;
                        case 7:
                            zzr().zzv().zza("App measurement disabled via the global data collection setting");
                            break;
                        default:
                            zzr().zzv().zza("App measurement disabled");
                            zzr().zzg().zza("Invalid scion state in identity");
                            break;
                    }
                    if (iZzac != 0) {
                        z = false;
                    }
                } else {
                    boolZzh = zzt().zzh();
                    if (zzt().zzg()) {
                        if (this.zzx.zzl()) {
                            zzr().zzv().zza("Collection disabled with firebase_analytics_collection_deactivated=1");
                        }
                    } else if (boolZzh == null && !boolZzh.booleanValue()) {
                        if (this.zzx.zzl()) {
                            zzr().zzv().zza("Collection disabled with firebase_analytics_collection_enabled=0");
                        }
                    } else if (boolZzh != null && GoogleServices.isMeasurementExplicitlyDisabled()) {
                        zzr().zzv().zza("Collection disabled with google_app_measurement_enable=0");
                    } else {
                        zzr().zzx().zza("Collection enabled");
                    }
                    z = false;
                }
                this.zzj = "";
                this.zzk = "";
                this.zzl = "";
                zzu();
                if (c2 != false) {
                    this.zzk = this.zzx.zzo();
                }
                googleAppId = GoogleServices.getGoogleAppId();
                if (TextUtils.isEmpty(googleAppId)) {
                    str2 = "";
                } else {
                    str2 = googleAppId;
                }
                this.zzj = str2;
                if (!zzll.zzb() && zzt().zza(zzap.zzch)) {
                    StringResourceValueReader stringResourceValueReader = new StringResourceValueReader(zzn());
                    String string2 = stringResourceValueReader.getString("ga_app_id");
                    if (!TextUtils.isEmpty(string2)) {
                        str4 = string2;
                    }
                    this.zzl = str4;
                    if (!TextUtils.isEmpty(googleAppId) || !TextUtils.isEmpty(string2)) {
                        this.zzk = stringResourceValueReader.getString("admob_app_id");
                    }
                } else if (!TextUtils.isEmpty(googleAppId)) {
                    this.zzk = new StringResourceValueReader(zzn()).getString("admob_app_id");
                }
                if (z) {
                    zzfm zzfmVarZzx = zzr().zzx();
                    String str6 = this.zza;
                    if (TextUtils.isEmpty(this.zzj)) {
                        str3 = this.zzk;
                    } else {
                        str3 = this.zzj;
                    }
                    zzfmVarZzx.zza("App measurement enabled for app package, google app id", str6, str3);
                }
                this.zzh = null;
                if (zzt().zza(zzap.zzbl)) {
                    zzu();
                    listZze = zzt().zze("analytics.safelisted_events");
                    if (listZze == null) {
                        if (listZze.size() == 0) {
                            zzr().zzk().zza("Safelisted event list is empty. Ignoring");
                        } else {
                            it = listZze.iterator();
                            do {
                                if (it.hasNext()) {
                                    this.zzh = listZze;
                                }
                            } while (zzp().zzb("safelisted event", it.next()));
                        }
                    } else {
                        this.zzh = listZze;
                    }
                }
                if (packageManager != null) {
                    this.zzi = InstantApps.isInstantApp(zzn()) ? 1 : 0;
                } else {
                    this.zzi = 0;
                }
            }
            googleAppId = GoogleServices.getGoogleAppId();
            if (TextUtils.isEmpty(googleAppId)) {
                str2 = "";
            } else {
                str2 = googleAppId;
            }
            this.zzj = str2;
            if (!zzll.zzb()) {
                if (!TextUtils.isEmpty(googleAppId)) {
                    this.zzk = new StringResourceValueReader(zzn()).getString("admob_app_id");
                }
            } else if (!TextUtils.isEmpty(googleAppId)) {
                this.zzk = new StringResourceValueReader(zzn()).getString("admob_app_id");
            }
            if (z) {
                zzfm zzfmVarZzx2 = zzr().zzx();
                String str7 = this.zza;
                if (TextUtils.isEmpty(this.zzj)) {
                    str3 = this.zzk;
                } else {
                    str3 = this.zzj;
                }
                zzfmVarZzx2.zza("App measurement enabled for app package, google app id", str7, str3);
            }
        } catch (IllegalStateException e) {
            zzr().zzf().zza("Fetching Google App Id failed with exception. appId", zzfk.zza(packageName), e);
        }
        string = "Unknown";
        this.zza = packageName;
        this.zzd = installerPackageName;
        this.zzb = str5;
        this.zzc = i;
        this.zze = string;
        this.zzf = 0L;
        zzu();
        statusInitialize = GoogleServices.initialize(zzn());
        z = true;
        if (statusInitialize == null) {
            c = false;
        } else {
            c = false;
        }
        if (TextUtils.isEmpty(this.zzx.zzo())) {
            c2 = false;
        } else {
            c2 = false;
        }
        z2 = c | c2;
        if (!z2) {
            if (statusInitialize == null) {
                zzr().zzg().zza("GoogleService failed to initialize (no status)");
            } else {
                zzr().zzg().zza("GoogleService failed to initialize, status", Integer.valueOf(statusInitialize.getStatusCode()), statusInitialize.getStatusMessage());
            }
        }
        if (!z2) {
            z = false;
        } else if (!com.google.android.gms.internal.measurement.zzkt.zzb()) {
            boolZzh = zzt().zzh();
            if (zzt().zzg()) {
                if (this.zzx.zzl()) {
                    zzr().zzv().zza("Collection disabled with firebase_analytics_collection_deactivated=1");
                }
            } else if (boolZzh == null) {
                if (boolZzh != null) {
                }
                zzr().zzx().zza("Collection enabled");
            } else {
                if (boolZzh != null) {
                }
                zzr().zzx().zza("Collection enabled");
            }
            z = false;
        } else {
            boolZzh = zzt().zzh();
            if (zzt().zzg()) {
                if (this.zzx.zzl()) {
                    zzr().zzv().zza("Collection disabled with firebase_analytics_collection_deactivated=1");
                }
            } else if (boolZzh == null) {
                if (boolZzh != null) {
                }
                zzr().zzx().zza("Collection enabled");
            } else {
                if (boolZzh != null) {
                }
                zzr().zzx().zza("Collection enabled");
            }
            z = false;
        }
        this.zzj = "";
        this.zzk = "";
        this.zzl = "";
        zzu();
        if (c2 != false) {
            this.zzk = this.zzx.zzo();
        }
        this.zzh = null;
        if (zzt().zza(zzap.zzbl)) {
            zzu();
            listZze = zzt().zze("analytics.safelisted_events");
            if (listZze == null) {
                if (listZze.size() == 0) {
                    zzr().zzk().zza("Safelisted event list is empty. Ignoring");
                } else {
                    it = listZze.iterator();
                    do {
                        if (it.hasNext()) {
                            this.zzh = listZze;
                        }
                    } while (zzp().zzb("safelisted event", it.next()));
                }
            } else {
                this.zzh = listZze;
            }
        }
        if (packageManager != null) {
            this.zzi = InstantApps.isInstantApp(zzn()) ? 1 : 0;
        } else {
            this.zzi = 0;
        }
    }

    final zzm zza(String str) {
        Boolean boolZzd;
        zzd();
        zzb();
        String strZzab = zzab();
        String strZzac = zzac();
        zzw();
        String str2 = this.zzb;
        long jZzaf = zzaf();
        zzw();
        String str3 = this.zzd;
        long jZze = zzt().zze();
        zzw();
        zzd();
        if (this.zzf == 0) {
            this.zzf = this.zzx.zzi().zza(zzn(), zzn().getPackageName());
        }
        long j = this.zzf;
        boolean zZzab = this.zzx.zzab();
        boolean z = !zzs().zzs;
        zzd();
        zzb();
        String strZzae = null;
        String strZzai = !this.zzx.zzab() ? null : zzai();
        long jZzad = this.zzx.zzad();
        int iZzag = zzag();
        boolean zBooleanValue = zzt().zzi().booleanValue();
        zzx zzxVarZzt = zzt();
        zzxVarZzt.zzb();
        Boolean boolZzd2 = zzxVarZzt.zzd("google_analytics_ssaid_collection_enabled");
        boolean zBooleanValue2 = Boolean.valueOf(boolZzd2 == null || boolZzd2.booleanValue()).booleanValue();
        zzft zzftVarZzs = zzs();
        zzftVarZzs.zzd();
        boolean z2 = zzftVarZzs.zzg().getBoolean("deferred_analytics_collection", false);
        String strZzad = zzad();
        Boolean boolValueOf = (!zzt().zza(zzap.zzbc) || (boolZzd = zzt().zzd("google_analytics_default_allow_ad_personalization_signals")) == null) ? null : Boolean.valueOf(!boolZzd.booleanValue());
        long j2 = this.zzg;
        List<String> list = zzt().zza(zzap.zzbl) ? this.zzh : null;
        if (zzll.zzb() && zzt().zza(zzap.zzch)) {
            strZzae = zzae();
        }
        return new zzm(strZzab, strZzac, str2, jZzaf, str3, jZze, j, str, zZzab, z, strZzai, 0L, jZzad, iZzag, zBooleanValue, zBooleanValue2, z2, strZzad, boolValueOf, j2, list, strZzae);
    }

    private final String zzai() {
        if (zznh.zzb() && zzt().zza(zzap.zzck)) {
            zzr().zzx().zza("Disabled IID for tests.");
            return null;
        }
        try {
            Class<?> clsLoadClass = zzn().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
            if (clsLoadClass == null) {
                return null;
            }
            try {
                Object objInvoke = clsLoadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, zzn());
                if (objInvoke == null) {
                    return null;
                }
                try {
                    return (String) clsLoadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(objInvoke, new Object[0]);
                } catch (Exception unused) {
                    zzr().zzk().zza("Failed to retrieve Firebase Instance Id");
                    return null;
                }
            } catch (Exception unused2) {
                zzr().zzj().zza("Failed to obtain Firebase Analytics instance");
                return null;
            }
        } catch (ClassNotFoundException unused3) {
        }
    }

    final String zzab() {
        zzw();
        return this.zza;
    }

    final String zzac() {
        zzw();
        return this.zzj;
    }

    final String zzad() {
        zzw();
        return this.zzk;
    }

    final String zzae() {
        zzw();
        return this.zzl;
    }

    final int zzaf() {
        zzw();
        return this.zzc;
    }

    final int zzag() {
        zzw();
        return this.zzi;
    }

    final List<String> zzah() {
        return this.zzh;
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
