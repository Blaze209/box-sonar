package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import androidx.collection.ArrayMap;
import com.box.boxandroidlibv2private.dao.BoxConvertedPushNotificationDevice;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzmv;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzn extends zzkp {
    private String zzb;
    private Set<Integer> zzc;
    private Map<Integer, zzp> zzd;
    private Long zze;
    private Long zzf;

    zzn(zzks zzksVar) {
        super(zzksVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzkp
    protected final boolean zze() {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:127:0x0326  */
    /* JADX WARN: Code duplicated, block: B:295:0x032d A[SYNTHETIC] */
    final List<com.google.android.gms.internal.measurement.zzbr.zza> zza(String str, List<com.google.android.gms.internal.measurement.zzbr.zzc> list, List<com.google.android.gms.internal.measurement.zzbr.zzk> list2, Long l, Long l2) throws Throwable {
        boolean z;
        boolean z2;
        zzaj zzajVar;
        zzaj zzajVar2;
        Map<Integer, com.google.android.gms.internal.measurement.zzbr.zzi> map;
        com.google.android.gms.internal.measurement.zzbr.zzi zziVar;
        ArrayMap arrayMap;
        List<com.google.android.gms.internal.measurement.zzbj.zzb> list3;
        Map<Integer, com.google.android.gms.internal.measurement.zzbr.zzi> map2;
        boolean z3;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(list2);
        this.zzb = str;
        this.zzc = new HashSet();
        this.zzd = new ArrayMap();
        this.zze = l;
        this.zzf = l2;
        boolean z4 = true;
        if (!zzt().zzd(this.zzb, zzap.zzbm) && !zzt().zzd(this.zzb, zzap.zzbn)) {
            z = false;
            break;
        }
        Iterator<com.google.android.gms.internal.measurement.zzbr.zzc> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if ("_s".equals(it.next().zzc())) {
                z = true;
                break;
            }
        }
        boolean zZzd = zzt().zzd(this.zzb, zzap.zzbm);
        boolean zZzd2 = zzt().zzd(this.zzb, zzap.zzbn);
        boolean z5 = com.google.android.gms.internal.measurement.zzkb.zzb() && zzt().zzd(this.zzb, zzap.zzbx);
        boolean z6 = com.google.android.gms.internal.measurement.zzkb.zzb() && zzt().zzd(this.zzb, zzap.zzbw);
        if (z && zZzd2) {
            zzac zzacVarZzi = zzi();
            String str2 = this.zzb;
            zzacVarZzi.zzak();
            zzacVarZzi.zzd();
            Preconditions.checkNotEmpty(str2);
            ContentValues contentValues = new ContentValues();
            contentValues.put("current_session_count", (Integer) 0);
            try {
                zzacVarZzi.c_().update(BoxConvertedPushNotificationDevice.EVENTS, contentValues, "app_id = ?", new String[]{str2});
            } catch (SQLiteException e) {
                zzacVarZzi.zzr().zzf().zza("Error resetting session-scoped event counts. appId", zzfk.zza(str2), e);
            }
        }
        Map<Integer, List<com.google.android.gms.internal.measurement.zzbj.zzb>> mapEmptyMap = Collections.emptyMap();
        if (z6 && z5) {
            mapEmptyMap = zzi().zze(this.zzb);
        }
        Map<Integer, List<com.google.android.gms.internal.measurement.zzbj.zzb>> map3 = mapEmptyMap;
        Map<Integer, com.google.android.gms.internal.measurement.zzbr.zzi> mapZzg = zzi().zzg(this.zzb);
        if (mapZzg == null || mapZzg.isEmpty()) {
            z2 = true;
        } else {
            HashSet hashSet = new HashSet(mapZzg.keySet());
            if (zZzd && z) {
                String str3 = this.zzb;
                Preconditions.checkNotEmpty(str3);
                Preconditions.checkNotNull(mapZzg);
                ArrayMap arrayMap2 = new ArrayMap();
                if (!mapZzg.isEmpty()) {
                    Map<Integer, List<Integer>> mapZzf = zzi().zzf(str3);
                    Iterator<Integer> it2 = mapZzg.keySet().iterator();
                    while (it2.hasNext()) {
                        int iIntValue = it2.next().intValue();
                        com.google.android.gms.internal.measurement.zzbr.zzi zziVar2 = mapZzg.get(Integer.valueOf(iIntValue));
                        List<Integer> list4 = mapZzf.get(Integer.valueOf(iIntValue));
                        if (list4 == null || list4.isEmpty()) {
                            arrayMap2.put(Integer.valueOf(iIntValue), zziVar2);
                        } else {
                            List<Long> listZza = zzg().zza(zziVar2.zzc(), list4);
                            if (!listZza.isEmpty()) {
                                com.google.android.gms.internal.measurement.zzbr.zzi.zza zzaVarZzb = zziVar2.zzbm().zzb().zzb(listZza);
                                zzaVarZzb.zza().zza(zzg().zza(zziVar2.zza(), list4));
                                for (int i = 0; i < zziVar2.zzf(); i++) {
                                    if (list4.contains(Integer.valueOf(zziVar2.zza(i).zzb()))) {
                                        zzaVarZzb.zza(i);
                                    }
                                }
                                for (int i2 = 0; i2 < zziVar2.zzh(); i2++) {
                                    if (list4.contains(Integer.valueOf(zziVar2.zzb(i2).zzb()))) {
                                        zzaVarZzb.zzb(i2);
                                    }
                                }
                                arrayMap2.put(Integer.valueOf(iIntValue), (com.google.android.gms.internal.measurement.zzbr.zzi) ((com.google.android.gms.internal.measurement.zzfd) zzaVarZzb.zzu()));
                            }
                        }
                        z4 = z4;
                    }
                }
                z2 = z4;
                map = arrayMap2;
            } else {
                z2 = true;
                map = mapZzg;
            }
            Iterator it3 = hashSet.iterator();
            while (it3.hasNext()) {
                int iIntValue2 = ((Integer) it3.next()).intValue();
                com.google.android.gms.internal.measurement.zzbr.zzi zziVar3 = map.get(Integer.valueOf(iIntValue2));
                BitSet bitSet = new BitSet();
                BitSet bitSet2 = new BitSet();
                ArrayMap arrayMap3 = new ArrayMap();
                if (zziVar3 != null && zziVar3.zzf() != 0) {
                    for (com.google.android.gms.internal.measurement.zzbr.zzb zzbVar : zziVar3.zze()) {
                        if (zzbVar.zza()) {
                            arrayMap3.put(Integer.valueOf(zzbVar.zzb()), zzbVar.zzc() ? Long.valueOf(zzbVar.zzd()) : null);
                        }
                    }
                }
                if (zzmv.zzb() && zzt().zzd(this.zzb, zzap.zzbt)) {
                    ArrayMap arrayMap4 = new ArrayMap();
                    if (zziVar3 != null && zziVar3.zzh() != 0) {
                        for (com.google.android.gms.internal.measurement.zzbr.zzj zzjVar : zziVar3.zzg()) {
                            if (zzjVar.zza() && zzjVar.zzd() > 0) {
                                arrayMap4.put(Integer.valueOf(zzjVar.zzb()), Long.valueOf(zzjVar.zza(zzjVar.zzd() - 1)));
                            }
                            zziVar3 = zziVar3;
                        }
                    }
                    zziVar = zziVar3;
                    arrayMap = arrayMap4;
                } else {
                    zziVar = zziVar3;
                    arrayMap = null;
                }
                if (zziVar != null) {
                    int i3 = 0;
                    while (i3 < (zziVar.zzb() << 6)) {
                        if (zzkw.zza(zziVar.zza(), i3)) {
                            map2 = map;
                            zzr().zzx().zza("Filter already evaluated. audience ID, filter ID", Integer.valueOf(iIntValue2), Integer.valueOf(i3));
                            bitSet2.set(i3);
                            if (zzkw.zza(zziVar.zzc(), i3)) {
                                bitSet.set(i3);
                                z3 = z2;
                            }
                            if (!z3) {
                                arrayMap3.remove(Integer.valueOf(i3));
                            }
                            i3++;
                            map = map2;
                        } else {
                            map2 = map;
                        }
                        z3 = false;
                        if (!z3) {
                            arrayMap3.remove(Integer.valueOf(i3));
                        }
                        i3++;
                        map = map2;
                    }
                }
                Map<Integer, com.google.android.gms.internal.measurement.zzbr.zzi> map4 = map;
                com.google.android.gms.internal.measurement.zzbr.zzi zziVar4 = zZzd ? mapZzg.get(Integer.valueOf(iIntValue2)) : zziVar;
                if (z6 && z5 && (list3 = map3.get(Integer.valueOf(iIntValue2))) != null && this.zzf != null && this.zze != null) {
                    for (com.google.android.gms.internal.measurement.zzbj.zzb zzbVar2 : list3) {
                        int iZzb = zzbVar2.zzb();
                        long jLongValue = this.zzf.longValue() / 1000;
                        if (zzbVar2.zzi()) {
                            jLongValue = this.zze.longValue() / 1000;
                        }
                        if (arrayMap3.containsKey(Integer.valueOf(iZzb))) {
                            arrayMap3.put(Integer.valueOf(iZzb), Long.valueOf(jLongValue));
                        }
                        if (arrayMap.containsKey(Integer.valueOf(iZzb))) {
                            arrayMap.put(Integer.valueOf(iZzb), Long.valueOf(jLongValue));
                        }
                    }
                }
                this.zzd.put(Integer.valueOf(iIntValue2), new zzp(this, this.zzb, zziVar4, bitSet, bitSet2, arrayMap3, arrayMap, null));
                map = map4;
            }
        }
        zzq zzqVar = null;
        if (!list.isEmpty()) {
            zzs zzsVar = new zzs(this, zzqVar);
            ArrayMap arrayMap5 = new ArrayMap();
            for (com.google.android.gms.internal.measurement.zzbr.zzc zzcVar : list) {
                com.google.android.gms.internal.measurement.zzbr.zzc zzcVarZza = zzsVar.zza(this.zzb, zzcVar);
                if (zzcVarZza != null) {
                    zzac zzacVarZzi2 = zzi();
                    String str4 = this.zzb;
                    String strZzc = zzcVarZza.zzc();
                    boolean zZzd3 = zzacVarZzi2.zzt().zzd(str4, zzap.zzbn);
                    zzaj zzajVarZza = zzacVarZzi2.zza(str4, zzcVar.zzc());
                    if (zzajVarZza == null) {
                        zzacVarZzi2.zzr().zzi().zza("Event aggregate wasn't created during raw event logging. appId, event", zzfk.zza(str4), zzacVarZzi2.zzo().zza(strZzc));
                        if (zZzd3) {
                            zzajVar = new zzaj(str4, zzcVar.zzc(), 1L, 1L, 1L, zzcVar.zze(), 0L, null, null, null, null);
                        } else {
                            zzajVar = new zzaj(str4, zzcVar.zzc(), 1L, 1L, zzcVar.zze(), 0L, null, null, null, null);
                        }
                    } else if (zZzd3) {
                        zzajVar = new zzaj(zzajVarZza.zza, zzajVarZza.zzb, zzajVarZza.zzc + 1, zzajVarZza.zzd + 1, zzajVarZza.zze + 1, zzajVarZza.zzf, zzajVarZza.zzg, zzajVarZza.zzh, zzajVarZza.zzi, zzajVarZza.zzj, zzajVarZza.zzk);
                    } else {
                        zzajVar = new zzaj(zzajVarZza.zza, zzajVarZza.zzb, zzajVarZza.zzc + 1, zzajVarZza.zzd + 1, zzajVarZza.zze, zzajVarZza.zzf, zzajVarZza.zzg, zzajVarZza.zzh, zzajVarZza.zzi, zzajVarZza.zzj, zzajVarZza.zzk);
                    }
                    zzi().zza(zzajVar);
                    zzaj zzajVar3 = zzajVar;
                    long j = zzajVar3.zzc;
                    String strZzc2 = zzcVarZza.zzc();
                    Map<Integer, List<com.google.android.gms.internal.measurement.zzbj.zzb>> mapZzf2 = (Map) arrayMap5.get(strZzc2);
                    if (mapZzf2 == null) {
                        mapZzf2 = zzi().zzf(this.zzb, strZzc2);
                        if (mapZzf2 == null) {
                            mapZzf2 = new ArrayMap<>();
                        }
                        arrayMap5.put(strZzc2, mapZzf2);
                    }
                    Iterator<Integer> it4 = mapZzf2.keySet().iterator();
                    while (it4.hasNext()) {
                        int iIntValue3 = it4.next().intValue();
                        if (this.zzc.contains(Integer.valueOf(iIntValue3))) {
                            zzr().zzx().zza("Skipping failed audience ID", Integer.valueOf(iIntValue3));
                        } else {
                            Iterator<com.google.android.gms.internal.measurement.zzbj.zzb> it5 = mapZzf2.get(Integer.valueOf(iIntValue3)).iterator();
                            boolean zZza = z2;
                            while (true) {
                                if (!it5.hasNext()) {
                                    zzajVar2 = zzajVar3;
                                    break;
                                }
                                com.google.android.gms.internal.measurement.zzbj.zzb next = it5.next();
                                zzr zzrVar = new zzr(this, this.zzb, iIntValue3, next);
                                zzajVar2 = zzajVar3;
                                zZza = zzrVar.zza(this.zze, this.zzf, zzcVarZza, j, zzajVar2, zza(iIntValue3, next.zzb()));
                                if (zzt().zzd(this.zzb, zzap.zzbu) && !zZza) {
                                    this.zzc.add(Integer.valueOf(iIntValue3));
                                    break;
                                }
                                zza(iIntValue3).zza(zzrVar);
                                zzajVar3 = zzajVar2;
                            }
                            if (!zZza) {
                                this.zzc.add(Integer.valueOf(iIntValue3));
                            }
                            zzajVar3 = zzajVar2;
                        }
                    }
                    zzsVar = zzsVar;
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        if (!list2.isEmpty()) {
            ArrayMap arrayMap6 = new ArrayMap();
            for (com.google.android.gms.internal.measurement.zzbr.zzk zzkVar : list2) {
                arrayList.add(zzkVar.zzc());
                String strZzc3 = zzkVar.zzc();
                Map<Integer, List<com.google.android.gms.internal.measurement.zzbj.zze>> mapZzg2 = (Map) arrayMap6.get(strZzc3);
                if (mapZzg2 == null) {
                    mapZzg2 = zzi().zzg(this.zzb, strZzc3);
                    if (mapZzg2 == null) {
                        mapZzg2 = new ArrayMap<>();
                    }
                    arrayMap6.put(strZzc3, mapZzg2);
                }
                Iterator<Integer> it6 = mapZzg2.keySet().iterator();
                while (it6.hasNext()) {
                    int iIntValue4 = it6.next().intValue();
                    if (this.zzc.contains(Integer.valueOf(iIntValue4))) {
                        zzr().zzx().zza("Skipping failed audience ID", Integer.valueOf(iIntValue4));
                        break;
                    }
                    boolean zZza2 = z2;
                    for (com.google.android.gms.internal.measurement.zzbj.zze zzeVar : mapZzg2.get(Integer.valueOf(iIntValue4))) {
                        if (zzr().zza(2)) {
                            zzr().zzx().zza("Evaluating filter. audience, filter, property", Integer.valueOf(iIntValue4), zzeVar.zza() ? Integer.valueOf(zzeVar.zzb()) : null, zzo().zzc(zzeVar.zzc()));
                            zzr().zzx().zza("Filter definition", zzg().zza(zzeVar));
                        }
                        if (!zzeVar.zza() || zzeVar.zzb() > 256) {
                            zzr().zzi().zza("Invalid property filter ID. appId, id", zzfk.zza(this.zzb), String.valueOf(zzeVar.zza() ? Integer.valueOf(zzeVar.zzb()) : null));
                            zZza2 = false;
                            break;
                        }
                        zzt zztVar = new zzt(this, this.zzb, iIntValue4, zzeVar);
                        zZza2 = zztVar.zza(this.zze, this.zzf, zzkVar, zza(iIntValue4, zzeVar.zzb()));
                        if (zzt().zzd(this.zzb, zzap.zzbu) && !zZza2) {
                            this.zzc.add(Integer.valueOf(iIntValue4));
                            break;
                        }
                        zza(iIntValue4).zza(zztVar);
                    }
                    if (!zZza2) {
                        this.zzc.add(Integer.valueOf(iIntValue4));
                    }
                }
            }
        }
        boolean zZzd4 = zzt().zzd(this.zzb, zzap.zzbs);
        Map<Integer, List<Integer>> arrayMap7 = new ArrayMap<>();
        if (zZzd4) {
            arrayMap7 = zzi().zza(this.zzb, arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        Set<Integer> setKeySet = this.zzd.keySet();
        setKeySet.removeAll(this.zzc);
        Iterator<Integer> it7 = setKeySet.iterator();
        while (it7.hasNext()) {
            int iIntValue5 = it7.next().intValue();
            com.google.android.gms.internal.measurement.zzbr.zza zzaVarZza = this.zzd.get(Integer.valueOf(iIntValue5)).zza(iIntValue5, arrayMap7.get(Integer.valueOf(iIntValue5)));
            arrayList2.add(zzaVarZza);
            zzac zzacVarZzi3 = zzi();
            String str5 = this.zzb;
            com.google.android.gms.internal.measurement.zzbr.zzi zziVarZzc = zzaVarZza.zzc();
            zzacVarZzi3.zzak();
            zzacVarZzi3.zzd();
            Preconditions.checkNotEmpty(str5);
            Preconditions.checkNotNull(zziVarZzc);
            byte[] bArrZzbi = zziVarZzc.zzbi();
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("app_id", str5);
            contentValues2.put("audience_id", Integer.valueOf(iIntValue5));
            contentValues2.put("current_results", bArrZzbi);
            try {
                try {
                    if (zzacVarZzi3.c_().insertWithOnConflict("audience_filter_values", null, contentValues2, 5) == -1) {
                        zzacVarZzi3.zzr().zzf().zza("Failed to insert filter results (got -1). appId", zzfk.zza(str5));
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    zzacVarZzi3.zzr().zzf().zza("Error storing filter results. appId", zzfk.zza(str5), e);
                }
            } catch (SQLiteException e3) {
                e = e3;
            }
        }
        return arrayList2;
    }

    private final zzp zza(int i) {
        if (this.zzd.containsKey(Integer.valueOf(i))) {
            return this.zzd.get(Integer.valueOf(i));
        }
        zzp zzpVar = new zzp(this, this.zzb, null);
        this.zzd.put(Integer.valueOf(i), zzpVar);
        return zzpVar;
    }

    private final boolean zza(int i, int i2) {
        if (this.zzd.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.zzd.get(Integer.valueOf(i)).zzd.get(i2);
    }
}
