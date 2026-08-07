package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzdl;
import com.google.android.gms.internal.measurement.zzdn;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public abstract class zzdl<MessageType extends zzdl<MessageType, BuilderType>, BuilderType extends zzdn<MessageType, BuilderType>> implements zzgo {
    protected int zza = 0;

    @Override // com.google.android.gms.internal.measurement.zzgo
    public final zzdu zzbh() {
        try {
            zzec zzecVarZzc = zzdu.zzc(zzbn());
            zza(zzecVarZzc.zzb());
            return zzecVarZzc.zza();
        } catch (IOException e) {
            String name = getClass().getName();
            throw new RuntimeException(new StringBuilder(String.valueOf(name).length() + 62 + String.valueOf("ByteString").length()).append("Serializing ").append(name).append(" to a ByteString threw an IOException (should never happen).").toString(), e);
        }
    }

    public final byte[] zzbi() {
        try {
            byte[] bArr = new byte[zzbn()];
            zzen zzenVarZza = zzen.zza(bArr);
            zza(zzenVarZza);
            zzenVarZza.zzb();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            throw new RuntimeException(new StringBuilder(String.valueOf(name).length() + 62 + String.valueOf("byte array").length()).append("Serializing ").append(name).append(" to a byte array threw an IOException (should never happen).").toString(), e);
        }
    }

    int zzbj() {
        throw new UnsupportedOperationException();
    }

    void zzc(int i) {
        throw new UnsupportedOperationException();
    }

    protected static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzff.zza(iterable);
        if (iterable instanceof zzfv) {
            List<?> listZzb = ((zzfv) iterable).zzb();
            zzfv zzfvVar = (zzfv) list;
            int size = list.size();
            for (Object obj : listZzb) {
                if (obj == null) {
                    String string = new StringBuilder(37).append("Element at index ").append(zzfvVar.size() - size).append(" is null.").toString();
                    for (int size2 = zzfvVar.size() - 1; size2 >= size; size2--) {
                        zzfvVar.remove(size2);
                    }
                    throw new NullPointerException(string);
                }
                if (obj instanceof zzdu) {
                    zzfvVar.zza((zzdu) obj);
                } else {
                    zzfvVar.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof zzha) {
            list.addAll((Collection) iterable);
            return;
        }
        if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
        }
        int size3 = list.size();
        for (T t : iterable) {
            if (t == null) {
                String string2 = new StringBuilder(37).append("Element at index ").append(list.size() - size3).append(" is null.").toString();
                for (int size4 = list.size() - 1; size4 >= size3; size4--) {
                    list.remove(size4);
                }
                throw new NullPointerException(string2);
            }
            list.add(t);
        }
    }
}
