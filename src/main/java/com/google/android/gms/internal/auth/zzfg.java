package com.google.android.gms.internal.auth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
/* JADX INFO: loaded from: classes13.dex */
final class zzfg extends zzfk {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzfg() {
        super(null);
    }

    /* synthetic */ zzfg(zzff zzffVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.auth.zzfk
    final void zza(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) zzhi.zzf(obj, j);
        if (list instanceof zzfe) {
            objUnmodifiableList = ((zzfe) list).zze();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzgd) && (list instanceof zzey)) {
                zzey zzeyVar = (zzey) list;
                if (zzeyVar.zzc()) {
                    zzeyVar.zzb();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzhi.zzp(obj, j, objUnmodifiableList);
    }

    @Override // com.google.android.gms.internal.auth.zzfk
    final void zzb(Object obj, Object obj2, long j) {
        List list;
        List list2;
        List listZzd;
        List list3 = (List) zzhi.zzf(obj2, j);
        int size = list3.size();
        List list4 = (List) zzhi.zzf(obj, j);
        if (list4.isEmpty()) {
            if (list4 instanceof zzfe) {
                listZzd = new zzfd(size);
            } else {
                listZzd = ((list4 instanceof zzgd) && (list4 instanceof zzey)) ? ((zzey) list4).zzd(size) : new ArrayList(size);
            }
            zzhi.zzp(obj, j, listZzd);
            list2 = listZzd;
        } else {
            if (zza.isAssignableFrom(list4.getClass())) {
                ArrayList arrayList = new ArrayList(list4.size() + size);
                arrayList.addAll(list4);
                zzhi.zzp(obj, j, arrayList);
                list = arrayList;
            } else if (list4 instanceof zzhd) {
                zzfd zzfdVar = new zzfd(list4.size() + size);
                zzfdVar.addAll(zzfdVar.size(), (zzhd) list4);
                zzhi.zzp(obj, j, zzfdVar);
                list = zzfdVar;
            } else if ((list4 instanceof zzgd) && (list4 instanceof zzey)) {
                zzey zzeyVar = (zzey) list4;
                if (!zzeyVar.zzc()) {
                    list2 = list4;
                    list2 = list4;
                    list2 = list4;
                    zzey zzeyVarZzd = zzeyVar.zzd(list4.size() + size);
                    zzhi.zzp(obj, j, zzeyVarZzd);
                    list2 = zzeyVarZzd;
                }
            }
            list2 = list;
        }
        list2 = list4;
        list2 = list4;
        list2 = list4;
        list2 = list4;
        list2 = list4;
        list2 = list4;
        int size2 = list2.size();
        int size3 = list3.size();
        if (size2 > 0 && size3 > 0) {
            list2.addAll(list3);
        }
        if (size2 > 0) {
            list3 = list2;
        }
        zzhi.zzp(obj, j, list3);
    }
}
