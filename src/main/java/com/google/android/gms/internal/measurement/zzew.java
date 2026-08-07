package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
final class zzew<T extends zzey<T>> {
    private static final zzew zzd = new zzew(true);
    final zzhi<T, Object> zza;
    private boolean zzb;
    private boolean zzc;

    private zzew() {
        this.zza = zzhi.zza(16);
    }

    private zzew(boolean z) {
        this(zzhi.zza(0));
        zzb();
    }

    private zzew(zzhi<T, Object> zzhiVar) {
        this.zza = zzhiVar;
        zzb();
    }

    public static <T extends zzey<T>> zzew<T> zza() {
        return zzd;
    }

    public final void zzb() {
        if (this.zzb) {
            return;
        }
        this.zza.zza();
        this.zzb = true;
    }

    public final boolean zzc() {
        return this.zzb;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzew) {
            return this.zza.equals(((zzew) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final Iterator<Map.Entry<T, Object>> zzd() {
        if (this.zzc) {
            return new zzfu(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    final Iterator<Map.Entry<T, Object>> zze() {
        if (this.zzc) {
            return new zzfu(this.zza.zze().iterator());
        }
        return this.zza.zze().iterator();
    }

    private final Object zza(T t) {
        Object obj = this.zza.get(t);
        if (!(obj instanceof zzfp)) {
            return obj;
        }
        return zzfp.zza();
    }

    private final void zzb(T t, Object obj) {
        if (t.zzd()) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                zza(t.zzb(), obj2);
            }
            obj = arrayList;
        } else {
            zza(t.zzb(), obj);
        }
        if (obj instanceof zzfp) {
            this.zzc = true;
        }
        this.zza.put(t, obj);
    }

    private static void zza(zzim zzimVar, Object obj) {
        zzff.zza(obj);
        boolean z = true;
        switch (zzev.zza[zzimVar.zza().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                break;
            case 2:
                z = obj instanceof Long;
                break;
            case 3:
                z = obj instanceof Float;
                break;
            case 4:
                z = obj instanceof Double;
                break;
            case 5:
                z = obj instanceof Boolean;
                break;
            case 6:
                z = obj instanceof String;
                break;
            case 7:
                if (!(obj instanceof zzdu) && !(obj instanceof byte[])) {
                    z = false;
                }
                break;
            case 8:
                if (!(obj instanceof Integer) && !(obj instanceof zzfi)) {
                    z = false;
                }
                break;
            case 9:
                if (!(obj instanceof zzgo) && !(obj instanceof zzfp)) {
                    z = false;
                }
                break;
            default:
                z = false;
                break;
        }
        if (!z) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public final boolean zzf() {
        for (int i = 0; i < this.zza.zzc(); i++) {
            if (!zza((Map.Entry) this.zza.zzb(i))) {
                return false;
            }
        }
        Iterator it = this.zza.zzd().iterator();
        while (it.hasNext()) {
            if (!zza((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private static <T extends zzey<T>> boolean zza(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.zzc() == zzip.MESSAGE) {
            if (key.zzd()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((zzgo) it.next()).zzbl()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzgo) {
                    if (!((zzgo) value).zzbl()) {
                        return false;
                    }
                } else {
                    if (value instanceof zzfp) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzew<T> zzewVar) {
        for (int i = 0; i < zzewVar.zza.zzc(); i++) {
            zzb(zzewVar.zza.zzb(i));
        }
        Iterator it = zzewVar.zza.zzd().iterator();
        while (it.hasNext()) {
            zzb((Map.Entry) it.next());
        }
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzgt) {
            return ((zzgt) obj).clone();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final void zzb(Map.Entry<T, Object> entry) {
        zzgo zzgoVarZzu;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzfp) {
            value = zzfp.zza();
        }
        if (key.zzd()) {
            Object objZza = zza((zzey) key);
            if (objZza == null) {
                objZza = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) objZza).add(zza(it.next()));
            }
            this.zza.put(key, objZza);
            return;
        }
        if (key.zzc() == zzip.MESSAGE) {
            Object objZza2 = zza((zzey) key);
            if (objZza2 == null) {
                this.zza.put(key, zza(value));
                return;
            }
            if (objZza2 instanceof zzgt) {
                zzgoVarZzu = key.zza((zzgt) objZza2, (zzgt) value);
            } else {
                zzgoVarZzu = key.zza(((zzgo) objZza2).zzbr(), (zzgo) value).zzu();
            }
            this.zza.put(key, zzgoVarZzu);
            return;
        }
        this.zza.put(key, zza(value));
    }

    static void zza(zzen zzenVar, zzim zzimVar, int i, Object obj) throws IOException {
        if (zzimVar == zzim.zzj) {
            zzgo zzgoVar = (zzgo) obj;
            zzff.zza(zzgoVar);
            zzenVar.zza(i, 3);
            zzgoVar.zza(zzenVar);
            zzenVar.zza(i, 4);
        }
        zzenVar.zza(i, zzimVar.zzb());
        switch (zzev.zzb[zzimVar.ordinal()]) {
            case 1:
                zzenVar.zza(((Double) obj).doubleValue());
                break;
            case 2:
                zzenVar.zza(((Float) obj).floatValue());
                break;
            case 3:
                zzenVar.zza(((Long) obj).longValue());
                break;
            case 4:
                zzenVar.zza(((Long) obj).longValue());
                break;
            case 5:
                zzenVar.zza(((Integer) obj).intValue());
                break;
            case 6:
                zzenVar.zzc(((Long) obj).longValue());
                break;
            case 7:
                zzenVar.zzd(((Integer) obj).intValue());
                break;
            case 8:
                zzenVar.zza(((Boolean) obj).booleanValue());
                break;
            case 9:
                ((zzgo) obj).zza(zzenVar);
                break;
            case 10:
                zzenVar.zza((zzgo) obj);
                break;
            case 11:
                if (obj instanceof zzdu) {
                    zzenVar.zza((zzdu) obj);
                } else {
                    zzenVar.zza((String) obj);
                }
                break;
            case 12:
                if (obj instanceof zzdu) {
                    zzenVar.zza((zzdu) obj);
                } else {
                    byte[] bArr = (byte[]) obj;
                    zzenVar.zzb(bArr, 0, bArr.length);
                }
                break;
            case 13:
                zzenVar.zzb(((Integer) obj).intValue());
                break;
            case 14:
                zzenVar.zzd(((Integer) obj).intValue());
                break;
            case 15:
                zzenVar.zzc(((Long) obj).longValue());
                break;
            case 16:
                zzenVar.zzc(((Integer) obj).intValue());
                break;
            case 17:
                zzenVar.zzb(((Long) obj).longValue());
                break;
            case 18:
                if (obj instanceof zzfi) {
                    zzenVar.zza(((zzfi) obj).zza());
                } else {
                    zzenVar.zza(((Integer) obj).intValue());
                }
                break;
        }
    }

    public final int zzg() {
        int iZzc = 0;
        for (int i = 0; i < this.zza.zzc(); i++) {
            iZzc += zzc(this.zza.zzb(i));
        }
        Iterator it = this.zza.zzd().iterator();
        while (it.hasNext()) {
            iZzc += zzc((Map.Entry) it.next());
        }
        return iZzc;
    }

    private static int zzc(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzc() == zzip.MESSAGE && !key.zzd() && !key.zze()) {
            if (value instanceof zzfp) {
                return zzen.zzb(entry.getKey().zza(), (zzfp) value);
            }
            return zzen.zzb(entry.getKey().zza(), (zzgo) value);
        }
        return zza((zzey<?>) key, value);
    }

    static int zza(zzim zzimVar, int i, Object obj) {
        int iZze = zzen.zze(i);
        if (zzimVar == zzim.zzj) {
            zzff.zza((zzgo) obj);
            iZze <<= 1;
        }
        return iZze + zzb(zzimVar, obj);
    }

    private static int zzb(zzim zzimVar, Object obj) {
        switch (zzev.zzb[zzimVar.ordinal()]) {
            case 1:
                return zzen.zzb(((Double) obj).doubleValue());
            case 2:
                return zzen.zzb(((Float) obj).floatValue());
            case 3:
                return zzen.zzd(((Long) obj).longValue());
            case 4:
                return zzen.zze(((Long) obj).longValue());
            case 5:
                return zzen.zzf(((Integer) obj).intValue());
            case 6:
                return zzen.zzg(((Long) obj).longValue());
            case 7:
                return zzen.zzi(((Integer) obj).intValue());
            case 8:
                return zzen.zzb(((Boolean) obj).booleanValue());
            case 9:
                return zzen.zzc((zzgo) obj);
            case 10:
                if (obj instanceof zzfp) {
                    return zzen.zza((zzfp) obj);
                }
                return zzen.zzb((zzgo) obj);
            case 11:
                if (obj instanceof zzdu) {
                    return zzen.zzb((zzdu) obj);
                }
                return zzen.zzb((String) obj);
            case 12:
                if (obj instanceof zzdu) {
                    return zzen.zzb((zzdu) obj);
                }
                return zzen.zzb((byte[]) obj);
            case 13:
                return zzen.zzg(((Integer) obj).intValue());
            case 14:
                return zzen.zzj(((Integer) obj).intValue());
            case 15:
                return zzen.zzh(((Long) obj).longValue());
            case 16:
                return zzen.zzh(((Integer) obj).intValue());
            case 17:
                return zzen.zzf(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzfi) {
                    return zzen.zzk(((zzfi) obj).zza());
                }
                return zzen.zzk(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zza(zzey<?> zzeyVar, Object obj) {
        zzim zzimVarZzb = zzeyVar.zzb();
        int iZza = zzeyVar.zza();
        if (zzeyVar.zzd()) {
            int iZza2 = 0;
            if (zzeyVar.zze()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    iZza2 += zzb(zzimVarZzb, it.next());
                }
                return zzen.zze(iZza) + iZza2 + zzen.zzl(iZza2);
            }
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                iZza2 += zza(zzimVarZzb, iZza, it2.next());
            }
            return iZza2;
        }
        return zza(zzimVarZzb, iZza, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzew zzewVar = new zzew();
        for (int i = 0; i < this.zza.zzc(); i++) {
            Map.Entry<K, Object> entryZzb = this.zza.zzb(i);
            zzewVar.zzb((zzey) entryZzb.getKey(), entryZzb.getValue());
        }
        Iterator it = this.zza.zzd().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            zzewVar.zzb((zzey) entry.getKey(), entry.getValue());
        }
        zzewVar.zzc = this.zzc;
        return zzewVar;
    }
}
