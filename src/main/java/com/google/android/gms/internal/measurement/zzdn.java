package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzdl;
import com.google.android.gms.internal.measurement.zzdn;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public abstract class zzdn<MessageType extends zzdl<MessageType, BuilderType>, BuilderType extends zzdn<MessageType, BuilderType>> implements zzgn {
    protected abstract BuilderType zza(MessageType messagetype);

    public abstract BuilderType zza(zzeg zzegVar, zzeq zzeqVar) throws IOException;

    @Override // 
    /* JADX INFO: renamed from: zzp, reason: merged with bridge method [inline-methods] */
    public abstract BuilderType clone();

    public BuilderType zza(byte[] bArr, int i, int i2) throws zzfo {
        try {
            zzeg zzegVarZza = zzeg.zza(bArr, 0, i2, false);
            zza(zzegVarZza, zzeq.zza());
            zzegVarZza.zza(0);
            return this;
        } catch (zzfo e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    public BuilderType zza(byte[] bArr, int i, int i2, zzeq zzeqVar) throws zzfo {
        try {
            zzeg zzegVarZza = zzeg.zza(bArr, 0, i2, false);
            zza(zzegVarZza, zzeqVar);
            zzegVarZza.zza(0);
            return this;
        } catch (zzfo e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    private final String zza(String str) {
        String name = getClass().getName();
        return new StringBuilder(String.valueOf(name).length() + 60 + String.valueOf(str).length()).append("Reading ").append(name).append(" from a ").append(str).append(" threw an IOException (should never happen).").toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzgn
    public final /* synthetic */ zzgn zza(zzgo zzgoVar) {
        if (!zzbt().getClass().isInstance(zzgoVar)) {
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
        return zza((zzdl) zzgoVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzgn
    public final /* synthetic */ zzgn zza(byte[] bArr, zzeq zzeqVar) throws zzfo {
        return zza(bArr, 0, bArr.length, zzeqVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzgn
    public final /* synthetic */ zzgn zza(byte[] bArr) throws zzfo {
        return zza(bArr, 0, bArr.length);
    }
}
