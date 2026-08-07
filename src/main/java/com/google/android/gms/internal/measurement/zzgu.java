package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
final class zzgu<T> implements zzhd<T> {
    private final zzgo zza;
    private final zzhv<?, ?> zzb;
    private final boolean zzc;
    private final zzes<?> zzd;

    private zzgu(zzhv<?, ?> zzhvVar, zzes<?> zzesVar, zzgo zzgoVar) {
        this.zzb = zzhvVar;
        this.zzc = zzesVar.zza(zzgoVar);
        this.zzd = zzesVar;
        this.zza = zzgoVar;
    }

    static <T> zzgu<T> zza(zzhv<?, ?> zzhvVar, zzes<?> zzesVar, zzgo zzgoVar) {
        return new zzgu<>(zzhvVar, zzesVar, zzgoVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzhd
    public final T zza() {
        return (T) this.zza.zzbs().zzt();
    }

    @Override // com.google.android.gms.internal.measurement.zzhd
    public final boolean zza(T t, T t2) {
        if (!this.zzb.zzb(t).equals(this.zzb.zzb(t2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zza(t).equals(this.zzd.zza(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzhd
    public final int zza(T t) {
        int iHashCode = this.zzb.zzb(t).hashCode();
        return this.zzc ? (iHashCode * 53) + this.zzd.zza(t).hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.measurement.zzhd
    public final void zzb(T t, T t2) {
        zzhf.zza(this.zzb, t, t2);
        if (this.zzc) {
            zzhf.zza(this.zzd, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzhd
    public final void zza(T t, zzis zzisVar) throws IOException {
        Iterator itZzd = this.zzd.zza(t).zzd();
        while (itZzd.hasNext()) {
            Map.Entry entry = (Map.Entry) itZzd.next();
            zzey zzeyVar = (zzey) entry.getKey();
            if (zzeyVar.zzc() != zzip.MESSAGE || zzeyVar.zzd() || zzeyVar.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof zzfr) {
                zzisVar.zza(zzeyVar.zza(), (Object) ((zzfr) entry).zza().zzc());
            } else {
                zzisVar.zza(zzeyVar.zza(), entry.getValue());
            }
        }
        zzhv<?, ?> zzhvVar = this.zzb;
        zzhvVar.zzb(zzhvVar.zzb(t), zzisVar);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x009b  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a1 A[EDGE_INSN: B:58:0x00a1->B:35:0x00a1 BREAK  A[LOOP:1: B:18:0x0059->B:63:0x0059], SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzhd
    public final void zza(T t, byte[] bArr, int i, int i2, zzdt zzdtVar) throws IOException {
        int iZza;
        zzfd zzfdVar = (zzfd) t;
        zzhy zzhyVarZzb = zzfdVar.zzb;
        if (zzhyVarZzb == zzhy.zza()) {
            zzhyVarZzb = zzhy.zzb();
            zzfdVar.zzb = zzhyVarZzb;
        }
        zzhy zzhyVar = zzhyVarZzb;
        ((zzfd.zzd) t).zza();
        zzfd.zzf zzfVar = null;
        while (i < i2) {
            int iZza2 = zzdq.zza(bArr, i, zzdtVar);
            int i3 = zzdtVar.zza;
            if (i3 == 11) {
                byte[] bArr2 = bArr;
                int i4 = i2;
                zzdt zzdtVar2 = zzdtVar;
                int i5 = 0;
                zzdu zzduVar = null;
                while (true) {
                    if (iZza2 >= i4) {
                        iZza = iZza2;
                        break;
                    }
                    iZza = zzdq.zza(bArr2, iZza2, zzdtVar2);
                    int i6 = zzdtVar2.zza;
                    int i7 = i6 >>> 3;
                    int i8 = i6 & 7;
                    if (i7 == 2) {
                        if (i8 != 0) {
                            if (i6 != 12) {
                                break;
                                break;
                            }
                            iZza2 = zzdq.zza(i6, bArr2, iZza, i4, zzdtVar2);
                        } else {
                            iZza2 = zzdq.zza(bArr2, iZza, zzdtVar2);
                            i5 = zzdtVar2.zza;
                            zzfVar = (zzfd.zzf) this.zzd.zza(zzdtVar2.zzd, this.zza, i5);
                        }
                    } else {
                        if (i7 == 3) {
                            if (zzfVar != null) {
                                zzgz.zza();
                                throw new NoSuchMethodError();
                            }
                            if (i8 == 2) {
                                iZza2 = zzdq.zze(bArr2, iZza, zzdtVar2);
                                zzduVar = (zzdu) zzdtVar2.zzc;
                            }
                        }
                        if (i6 != 12) {
                            break;
                        } else {
                            iZza2 = zzdq.zza(i6, bArr2, iZza, i4, zzdtVar2);
                        }
                    }
                }
                if (zzduVar != null) {
                    zzhyVar.zza((i5 << 3) | 2, zzduVar);
                }
                i = iZza;
                bArr = bArr2;
                i2 = i4;
                zzdtVar = zzdtVar2;
            } else if ((i3 & 7) == 2) {
                zzfVar = (zzfd.zzf) this.zzd.zza(zzdtVar.zzd, this.zza, i3 >>> 3);
                if (zzfVar != null) {
                    zzgz.zza();
                    throw new NoSuchMethodError();
                }
                i = zzdq.zza(i3, bArr, iZza2, i2, zzhyVar, zzdtVar);
            } else {
                i = zzdq.zza(i3, bArr, iZza2, i2, zzdtVar);
            }
        }
        if (i != i2) {
            throw zzfo.zzg();
        }
    }

    /* JADX WARN: Code duplicated, block: B:49:0x0086 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:? A[LOOP:0: B:45:0x000c->B:53:?, LOOP_END, SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.zzhd
    public final void zza(T t, zzhe zzheVar, zzeq zzeqVar) throws IOException {
        boolean zZzc;
        zzhv<?, ?> zzhvVar = this.zzb;
        zzes<?> zzesVar = this.zzd;
        Object objZzc = zzhvVar.zzc(t);
        zzew<T> zzewVarZzb = zzesVar.zzb(t);
        while (zzheVar.zza() != Integer.MAX_VALUE) {
            try {
                int iZzb = zzheVar.zzb();
                if (iZzb != 11) {
                    if ((iZzb & 7) == 2) {
                        Object objZza = zzesVar.zza(zzeqVar, this.zza, iZzb >>> 3);
                        if (objZza != null) {
                            zzesVar.zza(zzheVar, objZza, zzeqVar, zzewVarZzb);
                        } else {
                            zZzc = zzhvVar.zza(objZzc, zzheVar);
                        }
                    } else {
                        zZzc = zzheVar.zzc();
                    }
                    if (!zZzc) {
                        zzhvVar.zzb(t, objZzc);
                        return;
                    }
                } else {
                    Object objZza2 = null;
                    int iZzo = 0;
                    zzdu zzduVarZzn = null;
                    while (zzheVar.zza() != Integer.MAX_VALUE) {
                        int iZzb2 = zzheVar.zzb();
                        if (iZzb2 == 16) {
                            iZzo = zzheVar.zzo();
                            objZza2 = zzesVar.zza(zzeqVar, this.zza, iZzo);
                        } else if (iZzb2 == 26) {
                            if (objZza2 != null) {
                                zzesVar.zza(zzheVar, objZza2, zzeqVar, zzewVarZzb);
                            } else {
                                zzduVarZzn = zzheVar.zzn();
                            }
                        } else if (!zzheVar.zzc()) {
                            break;
                        }
                    }
                    if (zzheVar.zzb() != 12) {
                        throw zzfo.zze();
                    }
                    if (zzduVarZzn != null) {
                        if (objZza2 != null) {
                            zzesVar.zza(zzduVarZzn, objZza2, zzeqVar, zzewVarZzb);
                        } else {
                            zzhvVar.zza(objZzc, iZzo, zzduVarZzn);
                        }
                    }
                }
                zZzc = true;
                if (!zZzc) {
                    zzhvVar.zzb(t, objZzc);
                    return;
                }
            } catch (Throwable th) {
                zzhvVar.zzb(t, objZzc);
                throw th;
            }
        }
        zzhvVar.zzb(t, objZzc);
    }

    @Override // com.google.android.gms.internal.measurement.zzhd
    public final void zzc(T t) {
        this.zzb.zzd(t);
        this.zzd.zzc(t);
    }

    @Override // com.google.android.gms.internal.measurement.zzhd
    public final boolean zzd(T t) {
        return this.zzd.zza(t).zzf();
    }

    @Override // com.google.android.gms.internal.measurement.zzhd
    public final int zzb(T t) {
        zzhv<?, ?> zzhvVar = this.zzb;
        int iZze = zzhvVar.zze(zzhvVar.zzb(t));
        return this.zzc ? iZze + this.zzd.zza(t).zzg() : iZze;
    }
}
