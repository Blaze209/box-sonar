package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzs {
    private com.google.android.gms.internal.measurement.zzbr.zzc zza;
    private Long zzb;
    private long zzc;
    private final /* synthetic */ zzn zzd;

    private zzs(zzn zznVar) {
        this.zzd = zznVar;
    }

    final com.google.android.gms.internal.measurement.zzbr.zzc zza(String str, com.google.android.gms.internal.measurement.zzbr.zzc zzcVar) {
        String strZzc = zzcVar.zzc();
        List<com.google.android.gms.internal.measurement.zzbr.zze> listZza = zzcVar.zza();
        Long l = (Long) this.zzd.zzg().zzb(zzcVar, "_eid");
        boolean z = l != null;
        if (z && strZzc.equals("_ep")) {
            String str2 = (String) this.zzd.zzg().zzb(zzcVar, "_en");
            if (TextUtils.isEmpty(str2)) {
                if (com.google.android.gms.internal.measurement.zzky.zzb() && this.zzd.zzt().zzd(str, zzap.zzcz)) {
                    this.zzd.zzr().zzg().zza("Extra parameter without an event name. eventId", l);
                } else {
                    this.zzd.zzr().zzf().zza("Extra parameter without an event name. eventId", l);
                }
                return null;
            }
            if (this.zza == null || this.zzb == null || l.longValue() != this.zzb.longValue()) {
                Pair<com.google.android.gms.internal.measurement.zzbr.zzc, Long> pairZza = this.zzd.zzi().zza(str, l);
                if (pairZza == null || pairZza.first == null) {
                    if (com.google.android.gms.internal.measurement.zzky.zzb() && this.zzd.zzt().zzd(str, zzap.zzcz)) {
                        this.zzd.zzr().zzg().zza("Extra parameter without existing main event. eventName, eventId", str2, l);
                    } else {
                        this.zzd.zzr().zzf().zza("Extra parameter without existing main event. eventName, eventId", str2, l);
                    }
                    return null;
                }
                this.zza = (com.google.android.gms.internal.measurement.zzbr.zzc) pairZza.first;
                this.zzc = ((Long) pairZza.second).longValue();
                this.zzb = (Long) this.zzd.zzg().zzb(this.zza, "_eid");
            }
            long j = this.zzc - 1;
            this.zzc = j;
            if (j <= 0) {
                zzac zzacVarZzi = this.zzd.zzi();
                zzacVarZzi.zzd();
                zzacVarZzi.zzr().zzx().zza("Clearing complex main event info. appId", str);
                try {
                    zzacVarZzi.c_().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                } catch (SQLiteException e) {
                    zzacVarZzi.zzr().zzf().zza("Error clearing complex main event", e);
                }
            } else {
                this.zzd.zzi().zza(str, l, this.zzc, this.zza);
            }
            ArrayList arrayList = new ArrayList();
            for (com.google.android.gms.internal.measurement.zzbr.zze zzeVar : this.zza.zza()) {
                this.zzd.zzg();
                if (zzkw.zza(zzcVar, zzeVar.zzb()) == null) {
                    arrayList.add(zzeVar);
                }
            }
            if (!arrayList.isEmpty()) {
                arrayList.addAll(listZza);
                listZza = arrayList;
            } else if (com.google.android.gms.internal.measurement.zzky.zzb() && this.zzd.zzt().zzd(str, zzap.zzcz)) {
                this.zzd.zzr().zzg().zza("No unique parameters in main event. eventName", str2);
            } else {
                this.zzd.zzr().zzi().zza("No unique parameters in main event. eventName", str2);
            }
            strZzc = str2;
        } else if (z) {
            this.zzb = l;
            this.zza = zzcVar;
            Object objZzb = this.zzd.zzg().zzb(zzcVar, "_epc");
            long jLongValue = ((Long) (objZzb != null ? objZzb : 0L)).longValue();
            this.zzc = jLongValue;
            if (jLongValue > 0) {
                this.zzd.zzi().zza(str, l, this.zzc, zzcVar);
            } else if (com.google.android.gms.internal.measurement.zzky.zzb() && this.zzd.zzt().zzd(str, zzap.zzcz)) {
                this.zzd.zzr().zzg().zza("Complex event with zero extra param count. eventName", strZzc);
            } else {
                this.zzd.zzr().zzi().zza("Complex event with zero extra param count. eventName", strZzc);
            }
        }
        return (com.google.android.gms.internal.measurement.zzbr.zzc) ((com.google.android.gms.internal.measurement.zzfd) zzcVar.zzbm().zza(strZzc).zzc().zza(listZza).zzu());
    }

    /* synthetic */ zzs(zzn zznVar, zzq zzqVar) {
        this(zznVar);
    }
}
