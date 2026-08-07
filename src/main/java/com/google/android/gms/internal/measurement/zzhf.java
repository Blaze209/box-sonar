package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
final class zzhf {
    private static final Class<?> zza = zzd();
    private static final zzhv<?, ?> zzb = zza(false);
    private static final zzhv<?, ?> zzc = zza(true);
    private static final zzhv<?, ?> zzd = new zzhx();

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzfd.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zza(int i, List<Double> list, zzis zzisVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzisVar.zzg(i, list, z);
    }

    public static void zzb(int i, List<Float> list, zzis zzisVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzisVar.zzf(i, list, z);
    }

    public static void zzc(int i, List<Long> list, zzis zzisVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzisVar.zzc(i, list, z);
    }

    public static void zzd(int i, List<Long> list, zzis zzisVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzisVar.zzd(i, list, z);
    }

    public static void zze(int i, List<Long> list, zzis zzisVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzisVar.zzn(i, list, z);
    }

    public static void zzf(int i, List<Long> list, zzis zzisVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzisVar.zze(i, list, z);
    }

    public static void zzg(int i, List<Long> list, zzis zzisVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzisVar.zzl(i, list, z);
    }

    public static void zzh(int i, List<Integer> list, zzis zzisVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzisVar.zza(i, list, z);
    }

    public static void zzi(int i, List<Integer> list, zzis zzisVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzisVar.zzj(i, list, z);
    }

    public static void zzj(int i, List<Integer> list, zzis zzisVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzisVar.zzm(i, list, z);
    }

    public static void zzk(int i, List<Integer> list, zzis zzisVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzisVar.zzb(i, list, z);
    }

    public static void zzl(int i, List<Integer> list, zzis zzisVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzisVar.zzk(i, list, z);
    }

    public static void zzm(int i, List<Integer> list, zzis zzisVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzisVar.zzh(i, list, z);
    }

    public static void zzn(int i, List<Boolean> list, zzis zzisVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzisVar.zzi(i, list, z);
    }

    public static void zza(int i, List<String> list, zzis zzisVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzisVar.zza(i, list);
    }

    public static void zzb(int i, List<zzdu> list, zzis zzisVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzisVar.zzb(i, list);
    }

    public static void zza(int i, List<?> list, zzis zzisVar, zzhd zzhdVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzisVar.zza(i, list, zzhdVar);
    }

    public static void zzb(int i, List<?> list, zzis zzisVar, zzhd zzhdVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzisVar.zzb(i, list, zzhdVar);
    }

    static int zza(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzgc)) {
            int iZzd = 0;
            while (i < size) {
                iZzd += zzen.zzd(list.get(i).longValue());
                i++;
            }
            return iZzd;
        }
        zzgc zzgcVar = (zzgc) list;
        int iZzd2 = 0;
        while (i < size) {
            iZzd2 += zzen.zzd(zzgcVar.zzb(i));
            i++;
        }
        return iZzd2;
    }

    static int zza(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zza(list) + (list.size() * zzen.zze(i));
    }

    static int zzb(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzgc)) {
            int iZze = 0;
            while (i < size) {
                iZze += zzen.zze(list.get(i).longValue());
                i++;
            }
            return iZze;
        }
        zzgc zzgcVar = (zzgc) list;
        int iZze2 = 0;
        while (i < size) {
            iZze2 += zzen.zze(zzgcVar.zzb(i));
            i++;
        }
        return iZze2;
    }

    static int zzb(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzb(list) + (size * zzen.zze(i));
    }

    static int zzc(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzgc)) {
            int iZzf = 0;
            while (i < size) {
                iZzf += zzen.zzf(list.get(i).longValue());
                i++;
            }
            return iZzf;
        }
        zzgc zzgcVar = (zzgc) list;
        int iZzf2 = 0;
        while (i < size) {
            iZzf2 += zzen.zzf(zzgcVar.zzb(i));
            i++;
        }
        return iZzf2;
    }

    static int zzc(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzc(list) + (size * zzen.zze(i));
    }

    static int zzd(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfg)) {
            int iZzk = 0;
            while (i < size) {
                iZzk += zzen.zzk(list.get(i).intValue());
                i++;
            }
            return iZzk;
        }
        zzfg zzfgVar = (zzfg) list;
        int iZzk2 = 0;
        while (i < size) {
            iZzk2 += zzen.zzk(zzfgVar.zzc(i));
            i++;
        }
        return iZzk2;
    }

    static int zzd(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzen.zze(i));
    }

    static int zze(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfg)) {
            int iZzf = 0;
            while (i < size) {
                iZzf += zzen.zzf(list.get(i).intValue());
                i++;
            }
            return iZzf;
        }
        zzfg zzfgVar = (zzfg) list;
        int iZzf2 = 0;
        while (i < size) {
            iZzf2 += zzen.zzf(zzfgVar.zzc(i));
            i++;
        }
        return iZzf2;
    }

    static int zze(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzen.zze(i));
    }

    static int zzf(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfg)) {
            int iZzg = 0;
            while (i < size) {
                iZzg += zzen.zzg(list.get(i).intValue());
                i++;
            }
            return iZzg;
        }
        zzfg zzfgVar = (zzfg) list;
        int iZzg2 = 0;
        while (i < size) {
            iZzg2 += zzen.zzg(zzfgVar.zzc(i));
            i++;
        }
        return iZzg2;
    }

    static int zzf(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzf(list) + (size * zzen.zze(i));
    }

    static int zzg(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfg)) {
            int iZzh = 0;
            while (i < size) {
                iZzh += zzen.zzh(list.get(i).intValue());
                i++;
            }
            return iZzh;
        }
        zzfg zzfgVar = (zzfg) list;
        int iZzh2 = 0;
        while (i < size) {
            iZzh2 += zzen.zzh(zzfgVar.zzc(i));
            i++;
        }
        return iZzh2;
    }

    static int zzg(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzen.zze(i));
    }

    static int zzh(List<?> list) {
        return list.size() << 2;
    }

    static int zzh(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzen.zzi(i, 0);
    }

    static int zzi(List<?> list) {
        return list.size() << 3;
    }

    static int zzi(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzen.zzg(i, 0L);
    }

    static int zzj(List<?> list) {
        return list.size();
    }

    static int zzj(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzen.zzb(i, true);
    }

    static int zza(int i, List<?> list) {
        int iZzb;
        int iZzb2;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int iZze = zzen.zze(i) * size;
        if (!(list instanceof zzfv)) {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof zzdu) {
                    iZzb = zzen.zzb((zzdu) obj);
                } else {
                    iZzb = zzen.zzb((String) obj);
                }
                iZze += iZzb;
                i2++;
            }
            return iZze;
        }
        zzfv zzfvVar = (zzfv) list;
        while (i2 < size) {
            Object objZzb = zzfvVar.zzb(i2);
            if (objZzb instanceof zzdu) {
                iZzb2 = zzen.zzb((zzdu) objZzb);
            } else {
                iZzb2 = zzen.zzb((String) objZzb);
            }
            iZze += iZzb2;
            i2++;
        }
        return iZze;
    }

    static int zza(int i, Object obj, zzhd zzhdVar) {
        if (obj instanceof zzft) {
            return zzen.zza(i, (zzft) obj);
        }
        return zzen.zzb(i, (zzgo) obj, zzhdVar);
    }

    static int zza(int i, List<?> list, zzhd zzhdVar) {
        int iZza;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZze = zzen.zze(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof zzft) {
                iZza = zzen.zza((zzft) obj);
            } else {
                iZza = zzen.zza((zzgo) obj, zzhdVar);
            }
            iZze += iZza;
        }
        return iZze;
    }

    static int zzb(int i, List<zzdu> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZze = size * zzen.zze(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            iZze += zzen.zzb(list.get(i2));
        }
        return iZze;
    }

    static int zzb(int i, List<zzgo> list, zzhd zzhdVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzc = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZzc += zzen.zzc(i, list.get(i2), zzhdVar);
        }
        return iZzc;
    }

    public static zzhv<?, ?> zza() {
        return zzb;
    }

    public static zzhv<?, ?> zzb() {
        return zzc;
    }

    public static zzhv<?, ?> zzc() {
        return zzd;
    }

    private static zzhv<?, ?> zza(boolean z) {
        try {
            Class<?> clsZze = zze();
            if (clsZze == null) {
                return null;
            }
            return (zzhv) clsZze.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzd() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zze() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static <T> void zza(zzgh zzghVar, T t, T t2, long j) {
        zzib.zza(t, j, zzghVar.zza(zzib.zzf(t, j), zzib.zzf(t2, j)));
    }

    static <T, FT extends zzey<FT>> void zza(zzes<FT> zzesVar, T t, T t2) {
        zzew<T> zzewVarZza = zzesVar.zza(t2);
        if (zzewVarZza.zza.isEmpty()) {
            return;
        }
        zzesVar.zzb(t).zza((zzew) zzewVarZza);
    }

    static <T, UT, UB> void zza(zzhv<UT, UB> zzhvVar, T t, T t2) {
        zzhvVar.zza(t, zzhvVar.zzc(zzhvVar.zzb(t), zzhvVar.zzb(t2)));
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzfk zzfkVar, UB ub, zzhv<UT, UB> zzhvVar) {
        if (zzfkVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int iIntValue = list.get(i3).intValue();
                if (zzfkVar.zza(iIntValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(iIntValue));
                    }
                    i2++;
                } else {
                    ub = (UB) zza(i, iIntValue, ub, zzhvVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
            return ub;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int iIntValue2 = it.next().intValue();
            if (!zzfkVar.zza(iIntValue2)) {
                ub = (UB) zza(i, iIntValue2, ub, zzhvVar);
                it.remove();
            }
        }
        return ub;
    }

    static <UT, UB> UB zza(int i, int i2, UB ub, zzhv<UT, UB> zzhvVar) {
        if (ub == null) {
            ub = zzhvVar.zza();
        }
        zzhvVar.zza(ub, i, i2);
        return ub;
    }
}
