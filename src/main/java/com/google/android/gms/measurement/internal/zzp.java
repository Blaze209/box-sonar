package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzmv;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzp {
    private String zza;
    private boolean zzb;
    private com.google.android.gms.internal.measurement.zzbr.zzi zzc;
    private BitSet zzd;
    private BitSet zze;
    private Map<Integer, Long> zzf;
    private Map<Integer, List<Long>> zzg;
    private final /* synthetic */ zzn zzh;

    private zzp(zzn zznVar, String str) {
        this.zzh = zznVar;
        this.zza = str;
        this.zzb = true;
        this.zzd = new BitSet();
        this.zze = new BitSet();
        this.zzf = new ArrayMap();
        this.zzg = new ArrayMap();
    }

    private zzp(zzn zznVar, String str, com.google.android.gms.internal.measurement.zzbr.zzi zziVar, BitSet bitSet, BitSet bitSet2, Map<Integer, Long> map, Map<Integer, Long> map2) {
        this.zzh = zznVar;
        this.zza = str;
        this.zzd = bitSet;
        this.zze = bitSet2;
        this.zzf = map;
        this.zzg = new ArrayMap();
        if (map2 != null) {
            for (Integer num : map2.keySet()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(map2.get(num));
                this.zzg.put(num, arrayList);
            }
        }
        this.zzb = false;
        this.zzc = zziVar;
    }

    final void zza(zzu zzuVar) {
        int iZza = zzuVar.zza();
        if (zzuVar.zzc != null) {
            this.zze.set(iZza, zzuVar.zzc.booleanValue());
        }
        if (zzuVar.zzd != null) {
            this.zzd.set(iZza, zzuVar.zzd.booleanValue());
        }
        if (zzuVar.zze != null) {
            Long l = this.zzf.get(Integer.valueOf(iZza));
            long jLongValue = zzuVar.zze.longValue() / 1000;
            if (l == null || jLongValue > l.longValue()) {
                this.zzf.put(Integer.valueOf(iZza), Long.valueOf(jLongValue));
            }
        }
        if (zzuVar.zzf != null) {
            List<Long> arrayList = this.zzg.get(Integer.valueOf(iZza));
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.zzg.put(Integer.valueOf(iZza), arrayList);
            }
            if (zzmv.zzb() && this.zzh.zzt().zzd(this.zza, zzap.zzbt) && zzuVar.zzb()) {
                arrayList.clear();
            }
            if (com.google.android.gms.internal.measurement.zzkb.zzb() && this.zzh.zzt().zzd(this.zza, zzap.zzbx) && zzuVar.zzc()) {
                arrayList.clear();
            }
            if (com.google.android.gms.internal.measurement.zzkb.zzb() && this.zzh.zzt().zzd(this.zza, zzap.zzbx)) {
                long jLongValue2 = zzuVar.zzf.longValue() / 1000;
                if (arrayList.contains(Long.valueOf(jLongValue2))) {
                    return;
                }
                arrayList.add(Long.valueOf(jLongValue2));
                return;
            }
            arrayList.add(Long.valueOf(zzuVar.zzf.longValue() / 1000));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.measurement.zzbr$zza$zza, com.google.android.gms.internal.measurement.zzfd$zzb] */
    /* JADX WARN: Type inference failed for: r13v5, types: [com.google.android.gms.internal.measurement.zzbr$zzi$zza] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.util.Collection] */
    final com.google.android.gms.internal.measurement.zzbr.zza zza(int i, List<Integer> list) {
        ArrayList arrayList;
        ?? arrayList2;
        ?? r1;
        ?? Zzh = com.google.android.gms.internal.measurement.zzbr.zza.zzh();
        Zzh.zza(i);
        Zzh.zza(this.zzb);
        com.google.android.gms.internal.measurement.zzbr.zzi zziVar = this.zzc;
        if (zziVar != null) {
            Zzh.zza(zziVar);
        }
        ?? Zza = com.google.android.gms.internal.measurement.zzbr.zzi.zzi().zzb(zzkw.zza(this.zzd)).zza(zzkw.zza(this.zze));
        if (this.zzf == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(this.zzf.size());
            Iterator<Integer> it = this.zzf.keySet().iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                arrayList.add((com.google.android.gms.internal.measurement.zzbr.zzb) ((com.google.android.gms.internal.measurement.zzfd) com.google.android.gms.internal.measurement.zzbr.zzb.zze().zza(iIntValue).zza(this.zzf.get(Integer.valueOf(iIntValue)).longValue()).zzu()));
            }
        }
        Zza.zzc(arrayList);
        if (this.zzg == null) {
            arrayList2 = Collections.emptyList();
        } else {
            arrayList2 = new ArrayList(this.zzg.size());
            for (Integer num : this.zzg.keySet()) {
                com.google.android.gms.internal.measurement.zzbr.zzj.zza zzaVarZza = com.google.android.gms.internal.measurement.zzbr.zzj.zze().zza(num.intValue());
                List<Long> list2 = this.zzg.get(num);
                if (list2 != null) {
                    Collections.sort(list2);
                    zzaVarZza.zza(list2);
                }
                arrayList2.add((com.google.android.gms.internal.measurement.zzbr.zzj) ((com.google.android.gms.internal.measurement.zzfd) zzaVarZza.zzu()));
            }
        }
        if (!zzmv.zzb() || !this.zzh.zzt().zzd(this.zza, zzap.zzbt)) {
            r1 = arrayList2;
            r1 = arrayList2;
            if (Zzh.zza()) {
                List<com.google.android.gms.internal.measurement.zzbr.zzj> listZzg = Zzh.zzb().zzg();
                if (!listZzg.isEmpty()) {
                    r1 = arrayList2;
                    ArrayList arrayList3 = new ArrayList((Collection) arrayList2);
                    ArrayMap arrayMap = new ArrayMap();
                    for (com.google.android.gms.internal.measurement.zzbr.zzj zzjVar : listZzg) {
                        if (zzjVar.zza() && zzjVar.zzd() > 0) {
                            arrayMap.put(Integer.valueOf(zzjVar.zzb()), Long.valueOf(zzjVar.zza(zzjVar.zzd() - 1)));
                        }
                    }
                    for (int i2 = 0; i2 < arrayList3.size(); i2++) {
                        com.google.android.gms.internal.measurement.zzbr.zzj zzjVar2 = (com.google.android.gms.internal.measurement.zzbr.zzj) arrayList3.get(i2);
                        Long l = (Long) arrayMap.remove(zzjVar2.zza() ? Integer.valueOf(zzjVar2.zzb()) : null);
                        if (l != null && (list == null || !list.contains(Integer.valueOf(zzjVar2.zzb())))) {
                            ArrayList arrayList4 = new ArrayList();
                            if (l.longValue() < zzjVar2.zza(0)) {
                                arrayList4.add(l);
                            }
                            arrayList4.addAll(zzjVar2.zzc());
                            arrayList3.set(i2, (com.google.android.gms.internal.measurement.zzbr.zzj) ((com.google.android.gms.internal.measurement.zzfd) zzjVar2.zzbm().zza().zza(arrayList4).zzu()));
                        }
                    }
                    for (Integer num2 : arrayMap.keySet()) {
                        arrayList3.add((com.google.android.gms.internal.measurement.zzbr.zzj) ((com.google.android.gms.internal.measurement.zzfd) com.google.android.gms.internal.measurement.zzbr.zzj.zze().zza(num2.intValue()).zza(((Long) arrayMap.get(num2)).longValue()).zzu()));
                    }
                    r1 = arrayList3;
                }
            }
        }
        r1 = arrayList2;
        r1 = arrayList2;
        Zza.zzd(r1);
        Zzh.zza(Zza);
        return (com.google.android.gms.internal.measurement.zzbr.zza) ((com.google.android.gms.internal.measurement.zzfd) Zzh.zzu());
    }

    /* synthetic */ zzp(zzn zznVar, String str, com.google.android.gms.internal.measurement.zzbr.zzi zziVar, BitSet bitSet, BitSet bitSet2, Map map, Map map2, zzq zzqVar) {
        this(zznVar, str, zziVar, bitSet, bitSet2, map, map2);
    }

    /* synthetic */ zzp(zzn zznVar, String str, zzq zzqVar) {
        this(zznVar, str);
    }
}
