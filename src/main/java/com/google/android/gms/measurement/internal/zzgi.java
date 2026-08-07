package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzgi extends zzkp implements zzz {
    private static int zzb = 65535;
    private static int zzc = 2;
    private final Map<String, Map<String, String>> zzd;
    private final Map<String, Map<String, Boolean>> zze;
    private final Map<String, Map<String, Boolean>> zzf;
    private final Map<String, com.google.android.gms.internal.measurement.zzbo.zzb> zzg;
    private final Map<String, Map<String, Integer>> zzh;
    private final Map<String, String> zzi;

    zzgi(zzks zzksVar) {
        super(zzksVar);
        this.zzd = new ArrayMap();
        this.zze = new ArrayMap();
        this.zzf = new ArrayMap();
        this.zzg = new ArrayMap();
        this.zzi = new ArrayMap();
        this.zzh = new ArrayMap();
    }

    @Override // com.google.android.gms.measurement.internal.zzkp
    protected final boolean zze() {
        return false;
    }

    private final void zzi(String str) throws Throwable {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        if (this.zzg.get(str) == null) {
            byte[] bArrZzd = zzi().zzd(str);
            if (bArrZzd == null) {
                this.zzd.put(str, null);
                this.zze.put(str, null);
                this.zzf.put(str, null);
                this.zzg.put(str, null);
                this.zzi.put(str, null);
                this.zzh.put(str, null);
                return;
            }
            com.google.android.gms.internal.measurement.zzbo.zzb.zza zzaVarZzbm = zza(str, bArrZzd).zzbm();
            zza(str, zzaVarZzbm);
            this.zzd.put(str, zza((com.google.android.gms.internal.measurement.zzbo.zzb) ((com.google.android.gms.internal.measurement.zzfd) zzaVarZzbm.zzu())));
            this.zzg.put(str, (com.google.android.gms.internal.measurement.zzbo.zzb) ((com.google.android.gms.internal.measurement.zzfd) zzaVarZzbm.zzu()));
            this.zzi.put(str, null);
        }
    }

    protected final com.google.android.gms.internal.measurement.zzbo.zzb zza(String str) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        zzi(str);
        return this.zzg.get(str);
    }

    protected final String zzb(String str) {
        zzd();
        return this.zzi.get(str);
    }

    protected final void zzc(String str) {
        zzd();
        this.zzi.put(str, null);
    }

    final void zzd(String str) {
        zzd();
        this.zzg.remove(str);
    }

    final boolean zze(String str) {
        zzd();
        com.google.android.gms.internal.measurement.zzbo.zzb zzbVarZza = zza(str);
        if (zzbVarZza == null) {
            return false;
        }
        return zzbVarZza.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzz
    public final String zza(String str, String str2) throws Throwable {
        zzd();
        zzi(str);
        Map<String, String> map = this.zzd.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }

    private static Map<String, String> zza(com.google.android.gms.internal.measurement.zzbo.zzb zzbVar) {
        ArrayMap arrayMap = new ArrayMap();
        if (zzbVar != null) {
            for (com.google.android.gms.internal.measurement.zzbo.zzc zzcVar : zzbVar.zze()) {
                arrayMap.put(zzcVar.zza(), zzcVar.zzb());
            }
        }
        return arrayMap;
    }

    private final void zza(String str, com.google.android.gms.internal.measurement.zzbo.zzb.zza zzaVar) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        if (zzaVar != null) {
            for (int i = 0; i < zzaVar.zza(); i++) {
                com.google.android.gms.internal.measurement.zzbo.zza.C0205zza c0205zzaZzbm = zzaVar.zza(i).zzbm();
                if (TextUtils.isEmpty(c0205zzaZzbm.zza())) {
                    zzr().zzi().zza("EventConfig contained null event name");
                } else {
                    String strZzb = zzhj.zzb(c0205zzaZzbm.zza());
                    if (!TextUtils.isEmpty(strZzb)) {
                        c0205zzaZzbm = c0205zzaZzbm.zza(strZzb);
                        zzaVar.zza(i, c0205zzaZzbm);
                    }
                    arrayMap.put(c0205zzaZzbm.zza(), Boolean.valueOf(c0205zzaZzbm.zzb()));
                    arrayMap2.put(c0205zzaZzbm.zza(), Boolean.valueOf(c0205zzaZzbm.zzc()));
                    if (c0205zzaZzbm.zzd()) {
                        if (c0205zzaZzbm.zze() < zzc || c0205zzaZzbm.zze() > zzb) {
                            zzr().zzi().zza("Invalid sampling rate. Event name, sample rate", c0205zzaZzbm.zza(), Integer.valueOf(c0205zzaZzbm.zze()));
                        } else {
                            arrayMap3.put(c0205zzaZzbm.zza(), Integer.valueOf(c0205zzaZzbm.zze()));
                        }
                    }
                }
            }
        }
        this.zze.put(str, arrayMap);
        this.zzf.put(str, arrayMap2);
        this.zzh.put(str, arrayMap3);
    }

    protected final boolean zza(String str, byte[] bArr, String str2) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        com.google.android.gms.internal.measurement.zzbo.zzb.zza zzaVarZzbm = zza(str, bArr).zzbm();
        if (zzaVarZzbm == null) {
            return false;
        }
        zza(str, zzaVarZzbm);
        this.zzg.put(str, (com.google.android.gms.internal.measurement.zzbo.zzb) ((com.google.android.gms.internal.measurement.zzfd) zzaVarZzbm.zzu()));
        this.zzi.put(str, str2);
        this.zzd.put(str, zza((com.google.android.gms.internal.measurement.zzbo.zzb) ((com.google.android.gms.internal.measurement.zzfd) zzaVarZzbm.zzu())));
        zzi().zzb(str, new ArrayList(zzaVarZzbm.zzb()));
        try {
            zzaVarZzbm.zzc();
            bArr = ((com.google.android.gms.internal.measurement.zzbo.zzb) ((com.google.android.gms.internal.measurement.zzfd) zzaVarZzbm.zzu())).zzbi();
        } catch (RuntimeException e) {
            zzr().zzi().zza("Unable to serialize reduced-size config. Storing full config instead. appId", zzfk.zza(str), e);
        }
        zzac zzacVarZzi = zzi();
        Preconditions.checkNotEmpty(str);
        zzacVarZzi.zzd();
        zzacVarZzi.zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        try {
            if (zzacVarZzi.c_().update("apps", contentValues, "app_id = ?", new String[]{str}) == 0) {
                zzacVarZzi.zzr().zzf().zza("Failed to update remote config (got 0). appId", zzfk.zza(str));
            }
        } catch (SQLiteException e2) {
            zzacVarZzi.zzr().zzf().zza("Error storing remote config. appId", zzfk.zza(str), e2);
        }
        this.zzg.put(str, (com.google.android.gms.internal.measurement.zzbo.zzb) ((com.google.android.gms.internal.measurement.zzfd) zzaVarZzbm.zzu()));
        return true;
    }

    final boolean zzb(String str, String str2) throws Throwable {
        Boolean bool;
        zzd();
        zzi(str);
        if (zzg(str) && zzla.zze(str2)) {
            return true;
        }
        if (zzh(str) && zzla.zza(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.zze.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    final boolean zzc(String str, String str2) throws Throwable {
        Boolean bool;
        zzd();
        zzi(str);
        if (FirebaseAnalytics.Event.ECOMMERCE_PURCHASE.equals(str2)) {
            return true;
        }
        if (com.google.android.gms.internal.measurement.zzjp.zzb() && zzt().zza(zzap.zzdf) && ("purchase".equals(str2) || "refund".equals(str2))) {
            return true;
        }
        Map<String, Boolean> map = this.zzf.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    final int zzd(String str, String str2) throws Throwable {
        Integer num;
        zzd();
        zzi(str);
        Map<String, Integer> map = this.zzh.get(str);
        if (map == null || (num = map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    final long zzf(String str) throws Throwable {
        String strZza = zza(str, "measurement.account.time_zone_offset_minutes");
        if (TextUtils.isEmpty(strZza)) {
            return 0L;
        }
        try {
            return Long.parseLong(strZza);
        } catch (NumberFormatException e) {
            zzr().zzi().zza("Unable to parse timezone offset. appId", zzfk.zza(str), e);
            return 0L;
        }
    }

    private final com.google.android.gms.internal.measurement.zzbo.zzb zza(String str, byte[] bArr) {
        if (bArr == null) {
            return com.google.android.gms.internal.measurement.zzbo.zzb.zzj();
        }
        try {
            com.google.android.gms.internal.measurement.zzbo.zzb zzbVar = (com.google.android.gms.internal.measurement.zzbo.zzb) ((com.google.android.gms.internal.measurement.zzfd) ((com.google.android.gms.internal.measurement.zzbo.zzb.zza) zzkw.zza(com.google.android.gms.internal.measurement.zzbo.zzb.zzi(), bArr)).zzu());
            zzr().zzx().zza("Parsed config. version, gmp_app_id", zzbVar.zza() ? Long.valueOf(zzbVar.zzb()) : null, zzbVar.zzc() ? zzbVar.zzd() : null);
            return zzbVar;
        } catch (com.google.android.gms.internal.measurement.zzfo e) {
            zzr().zzi().zza("Unable to merge remote config. appId", zzfk.zza(str), e);
            return com.google.android.gms.internal.measurement.zzbo.zzb.zzj();
        } catch (RuntimeException e2) {
            zzr().zzi().zza("Unable to merge remote config. appId", zzfk.zza(str), e2);
            return com.google.android.gms.internal.measurement.zzbo.zzb.zzj();
        }
    }

    final boolean zzg(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_internal"));
    }

    final boolean zzh(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_public"));
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
