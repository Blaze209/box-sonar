package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
final class zzga extends zzfy {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzga() {
        super();
    }

    @Override // com.google.android.gms.internal.measurement.zzfy
    final <L> List<L> zza(Object obj, long j) {
        return zza(obj, j, 10);
    }

    @Override // com.google.android.gms.internal.measurement.zzfy
    final void zzb(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) zzib.zzf(obj, j);
        if (list instanceof zzfv) {
            objUnmodifiableList = ((zzfv) list).g_();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzha) && (list instanceof zzfl)) {
                zzfl zzflVar = (zzfl) list;
                if (zzflVar.zza()) {
                    zzflVar.h_();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzib.zza(obj, j, objUnmodifiableList);
    }

    private static <L> List<L> zza(Object obj, long j, int i) {
        List<L> arrayList;
        List<L> listZzc = zzc(obj, j);
        if (listZzc.isEmpty()) {
            if (listZzc instanceof zzfv) {
                arrayList = new zzfw(i);
            } else if ((listZzc instanceof zzha) && (listZzc instanceof zzfl)) {
                arrayList = ((zzfl) listZzc).zza(i);
            } else {
                arrayList = new ArrayList<>(i);
            }
            zzib.zza(obj, j, arrayList);
            return arrayList;
        }
        if (zza.isAssignableFrom(listZzc.getClass())) {
            ArrayList arrayList2 = new ArrayList(listZzc.size() + i);
            arrayList2.addAll(listZzc);
            zzib.zza(obj, j, arrayList2);
            return arrayList2;
        }
        if (listZzc instanceof zzia) {
            zzfw zzfwVar = new zzfw(listZzc.size() + i);
            zzfwVar.addAll((zzia) listZzc);
            zzib.zza(obj, j, zzfwVar);
            return zzfwVar;
        }
        if ((listZzc instanceof zzha) && (listZzc instanceof zzfl)) {
            zzfl zzflVar = (zzfl) listZzc;
            if (!zzflVar.zza()) {
                zzfl zzflVarZza = zzflVar.zza(listZzc.size() + i);
                zzib.zza(obj, j, zzflVarZza);
                return zzflVarZza;
            }
        }
        return listZzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzfy
    final <E> void zza(Object obj, Object obj2, long j) {
        List listZzc = zzc(obj2, j);
        List listZza = zza(obj, j, listZzc.size());
        int size = listZza.size();
        int size2 = listZzc.size();
        if (size > 0 && size2 > 0) {
            listZza.addAll(listZzc);
        }
        if (size > 0) {
            listZzc = listZza;
        }
        zzib.zza(obj, j, listZzc);
    }

    private static <E> List<E> zzc(Object obj, long j) {
        return (List) zzib.zzf(obj, j);
    }
}
