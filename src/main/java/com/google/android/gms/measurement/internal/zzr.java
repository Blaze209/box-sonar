package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzr extends zzu {
    private com.google.android.gms.internal.measurement.zzbj.zzb zzg;
    private final /* synthetic */ zzn zzh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzr(zzn zznVar, String str, int i, com.google.android.gms.internal.measurement.zzbj.zzb zzbVar) {
        super(str, i);
        this.zzh = zznVar;
        this.zzg = zzbVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzu
    final boolean zzb() {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzu
    final int zza() {
        return this.zzg.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzu
    final boolean zzc() {
        return this.zzg.zzf();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0294  */
    /* JADX WARN: Code duplicated, block: B:103:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:111:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:114:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:119:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:121:0x0301  */
    /* JADX WARN: Code duplicated, block: B:122:0x0312  */
    /* JADX WARN: Code duplicated, block: B:124:0x0318  */
    /* JADX WARN: Code duplicated, block: B:126:0x0320  */
    /* JADX WARN: Code duplicated, block: B:129:0x032c  */
    /* JADX WARN: Code duplicated, block: B:135:0x0380 A[EDGE_INSN: B:135:0x0380->B:138:0x03ca BREAK  A[LOOP:0: B:54:0x0147->B:59:0x0177]] */
    /* JADX WARN: Code duplicated, block: B:136:0x03a4  */
    /* JADX WARN: Code duplicated, block: B:172:0x017f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:173:0x015d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:174:0x01a2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:175:0x0219 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:176:0x01c0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:177:0x01a8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:178:0x01de A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:179:0x01c6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:180:0x01f0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:182:0x018c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:186:0x02ae A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:187:0x026f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:188:0x012f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:189:0x03ca A[EDGE_INSN: B:189:0x03ca->B:138:0x03ca BREAK  A[LOOP:0: B:54:0x0147->B:59:0x0177], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:190:0x03c9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:191:0x0246 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:192:0x0269 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:193:0x02f7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:194:0x02b8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:195:0x012f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:196:0x03ca A[EDGE_INSN: B:196:0x03ca->B:138:0x03ca BREAK  A[LOOP:0: B:54:0x0147->B:59:0x0177], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:197:0x03ca A[EDGE_INSN: B:197:0x03ca->B:138:0x03ca BREAK  A[LOOP:0: B:54:0x0147->B:59:0x0177], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:198:0x02b2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:199:0x037e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:200:0x0359 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:201:0x0334 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:202:0x012f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:204:0x0221 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:205:0x0221 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:206:0x0221 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x013a  */
    /* JADX WARN: Code duplicated, block: B:56:0x014d  */
    /* JADX WARN: Code duplicated, block: B:59:0x0177 A[LOOP:0: B:54:0x0147->B:59:0x0177, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:63:0x0192  */
    /* JADX WARN: Code duplicated, block: B:69:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:70:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:76:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:77:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:81:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:86:0x0227  */
    /* JADX WARN: Code duplicated, block: B:91:0x023b  */
    /* JADX WARN: Code duplicated, block: B:95:0x0261  */
    final boolean zza(Long l, Long l2, com.google.android.gms.internal.measurement.zzbr.zzc zzcVar, long j, zzaj zzajVar, boolean z) {
        HashSet hashSet;
        Iterator<com.google.android.gms.internal.measurement.zzbj.zzc> it;
        ArrayMap arrayMap;
        Iterator<com.google.android.gms.internal.measurement.zzbr.zze> it2;
        Iterator<com.google.android.gms.internal.measurement.zzbj.zzc> it3;
        com.google.android.gms.internal.measurement.zzbj.zzc next;
        boolean z2;
        String strZzh;
        Object obj;
        Boolean boolZza;
        Boolean boolZza2;
        String str;
        Boolean boolZza3;
        com.google.android.gms.internal.measurement.zzbr.zze next2;
        Long lValueOf;
        Double dValueOf;
        com.google.android.gms.internal.measurement.zzbj.zzc next3;
        boolean zZzd = this.zzh.zzt().zzd(this.zza, zzap.zzbm);
        boolean zZzd2 = this.zzh.zzt().zzd(this.zza, zzap.zzbn);
        Boolean bool = false;
        boolean z3 = com.google.android.gms.internal.measurement.zzkb.zzb() && this.zzh.zzt().zzd(this.zza, zzap.zzbx);
        long j2 = (zZzd2 && zZzd && this.zzg.zzk()) ? zzajVar.zze : j;
        if (this.zzh.zzr().zza(2)) {
            this.zzh.zzr().zzx().zza("Evaluating filter. audience, filter, event", Integer.valueOf(this.zzb), this.zzg.zza() ? Integer.valueOf(this.zzg.zzb()) : null, this.zzh.zzo().zza(this.zzg.zzc()));
            this.zzh.zzr().zzx().zza("Filter definition", this.zzh.zzg().zza(this.zzg));
        }
        if (!this.zzg.zza() || this.zzg.zzb() > 256) {
            this.zzh.zzr().zzi().zza("Invalid event filter ID. appId, id", zzfk.zza(this.zza), String.valueOf(this.zzg.zza() ? Integer.valueOf(this.zzg.zzb()) : null));
            return !this.zzh.zzt().zzd(this.zza, zzap.zzbu);
        }
        boolean z4 = this.zzg.zzh() || this.zzg.zzi() || (zZzd && this.zzg.zzk());
        if (z && !z4) {
            this.zzh.zzr().zzx().zza("Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.zzb), this.zzg.zza() ? Integer.valueOf(this.zzg.zzb()) : null);
            return true;
        }
        com.google.android.gms.internal.measurement.zzbj.zzb zzbVar = this.zzg;
        String strZzc = zzcVar.zzc();
        if (zzbVar.zzf()) {
            Boolean boolZza4 = zza(j2, zzbVar.zzg());
            if (boolZza4 == null) {
                bool = null;
                break;
            }
            if (boolZza4.booleanValue()) {
                hashSet = new HashSet();
                it = zzbVar.zzd().iterator();
                while (true) {
                    if (it.hasNext()) {
                        next3 = it.next();
                        if (next3.zzh().isEmpty()) {
                            this.zzh.zzr().zzi().zza("null or empty param name in filter. event", this.zzh.zzo().zza(strZzc));
                        } else {
                            hashSet.add(next3.zzh());
                        }
                    } else {
                        arrayMap = new ArrayMap();
                        it2 = zzcVar.zza().iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                next2 = it2.next();
                                if (!hashSet.contains(next2.zzb())) {
                                    if (next2.zze()) {
                                        String strZzb = next2.zzb();
                                        if (next2.zze()) {
                                            lValueOf = Long.valueOf(next2.zzf());
                                        } else {
                                            lValueOf = null;
                                        }
                                        arrayMap.put(strZzb, lValueOf);
                                    } else if (next2.zzg()) {
                                        String strZzb2 = next2.zzb();
                                        if (next2.zzg()) {
                                            dValueOf = Double.valueOf(next2.zzh());
                                        } else {
                                            dValueOf = null;
                                        }
                                        arrayMap.put(strZzb2, dValueOf);
                                    } else if (next2.zzc()) {
                                        arrayMap.put(next2.zzb(), next2.zzd());
                                    } else {
                                        this.zzh.zzr().zzi().zza("Unknown value for param. event, param", this.zzh.zzo().zza(strZzc), this.zzh.zzo().zzb(next2.zzb()));
                                    }
                                }
                            } else {
                                it3 = zzbVar.zzd().iterator();
                                while (true) {
                                    if (it3.hasNext()) {
                                        next = it3.next();
                                        if (next.zze()) {
                                            z2 = false;
                                        } else {
                                            z2 = false;
                                        }
                                        strZzh = next.zzh();
                                        if (strZzh.isEmpty()) {
                                            this.zzh.zzr().zzi().zza("Event has empty param name. event", this.zzh.zzo().zza(strZzc));
                                        } else {
                                            obj = arrayMap.get(strZzh);
                                            if (obj instanceof Long) {
                                                if (!next.zzc()) {
                                                    this.zzh.zzr().zzi().zza("No number filter for long param. event, param", this.zzh.zzo().zza(strZzc), this.zzh.zzo().zzb(strZzh));
                                                } else {
                                                    boolZza = zza(((Long) obj).longValue(), next.zzd());
                                                    if (boolZza == null) {
                                                        if (boolZza.booleanValue() == z2) {
                                                            break;
                                                            break;
                                                        }
                                                    }
                                                }
                                            } else if (obj instanceof Double) {
                                                if (!next.zzc()) {
                                                    this.zzh.zzr().zzi().zza("No number filter for double param. event, param", this.zzh.zzo().zza(strZzc), this.zzh.zzo().zzb(strZzh));
                                                } else {
                                                    boolZza2 = zza(((Double) obj).doubleValue(), next.zzd());
                                                    if (boolZza2 == null) {
                                                        if (boolZza2.booleanValue() == z2) {
                                                            break;
                                                            break;
                                                        }
                                                    }
                                                }
                                            } else if (obj instanceof String) {
                                                if (next.zza()) {
                                                    boolZza3 = zza((String) obj, next.zzb(), this.zzh.zzr());
                                                } else if (next.zzc()) {
                                                    str = (String) obj;
                                                    if (zzkw.zza(str)) {
                                                        boolZza3 = zza(str, next.zzd());
                                                    } else {
                                                        this.zzh.zzr().zzi().zza("Invalid param value for number filter. event, param", this.zzh.zzo().zza(strZzc), this.zzh.zzo().zzb(strZzh));
                                                    }
                                                } else {
                                                    this.zzh.zzr().zzi().zza("No filter for String param. event, param", this.zzh.zzo().zza(strZzc), this.zzh.zzo().zzb(strZzh));
                                                }
                                                if (boolZza3 == null) {
                                                    if (boolZza3.booleanValue() == z2) {
                                                        break;
                                                        break;
                                                    }
                                                }
                                            } else {
                                                if (obj == null) {
                                                    this.zzh.zzr().zzx().zza("Missing param for filter. event, param", this.zzh.zzo().zza(strZzc), this.zzh.zzo().zzb(strZzh));
                                                    break;
                                                }
                                                this.zzh.zzr().zzi().zza("Unknown param type. event, param", this.zzh.zzo().zza(strZzc), this.zzh.zzo().zzb(strZzh));
                                            }
                                        }
                                    } else {
                                        bool = true;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    bool = null;
                    break;
                }
            }
        } else {
            hashSet = new HashSet();
            it = zzbVar.zzd().iterator();
            while (true) {
                if (it.hasNext()) {
                    next3 = it.next();
                    if (next3.zzh().isEmpty()) {
                        this.zzh.zzr().zzi().zza("null or empty param name in filter. event", this.zzh.zzo().zza(strZzc));
                    } else {
                        hashSet.add(next3.zzh());
                    }
                } else {
                    arrayMap = new ArrayMap();
                    it2 = zzcVar.zza().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            next2 = it2.next();
                            if (!hashSet.contains(next2.zzb())) {
                                if (next2.zze()) {
                                    String strZzb3 = next2.zzb();
                                    if (next2.zze()) {
                                        lValueOf = Long.valueOf(next2.zzf());
                                    } else {
                                        lValueOf = null;
                                    }
                                    arrayMap.put(strZzb3, lValueOf);
                                } else if (next2.zzg()) {
                                    String strZzb4 = next2.zzb();
                                    if (next2.zzg()) {
                                        dValueOf = Double.valueOf(next2.zzh());
                                    } else {
                                        dValueOf = null;
                                    }
                                    arrayMap.put(strZzb4, dValueOf);
                                } else if (next2.zzc()) {
                                    arrayMap.put(next2.zzb(), next2.zzd());
                                } else {
                                    this.zzh.zzr().zzi().zza("Unknown value for param. event, param", this.zzh.zzo().zza(strZzc), this.zzh.zzo().zzb(next2.zzb()));
                                }
                            }
                        } else {
                            it3 = zzbVar.zzd().iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    next = it3.next();
                                    if (next.zze() || !next.zzf()) {
                                        z2 = false;
                                    } else {
                                        z2 = true;
                                    }
                                    strZzh = next.zzh();
                                    if (strZzh.isEmpty()) {
                                        this.zzh.zzr().zzi().zza("Event has empty param name. event", this.zzh.zzo().zza(strZzc));
                                    } else {
                                        obj = arrayMap.get(strZzh);
                                        if (obj instanceof Long) {
                                            if (!next.zzc()) {
                                                this.zzh.zzr().zzi().zza("No number filter for long param. event, param", this.zzh.zzo().zza(strZzc), this.zzh.zzo().zzb(strZzh));
                                            } else {
                                                boolZza = zza(((Long) obj).longValue(), next.zzd());
                                                if (boolZza == null) {
                                                    if (boolZza.booleanValue() == z2) {
                                                        break;
                                                    }
                                                }
                                            }
                                        } else if (obj instanceof Double) {
                                            if (!next.zzc()) {
                                                this.zzh.zzr().zzi().zza("No number filter for double param. event, param", this.zzh.zzo().zza(strZzc), this.zzh.zzo().zzb(strZzh));
                                            } else {
                                                boolZza2 = zza(((Double) obj).doubleValue(), next.zzd());
                                                if (boolZza2 == null) {
                                                    if (boolZza2.booleanValue() == z2) {
                                                        break;
                                                    }
                                                }
                                            }
                                        } else if (obj instanceof String) {
                                            if (next.zza()) {
                                                boolZza3 = zza((String) obj, next.zzb(), this.zzh.zzr());
                                            } else if (next.zzc()) {
                                                str = (String) obj;
                                                if (zzkw.zza(str)) {
                                                    boolZza3 = zza(str, next.zzd());
                                                } else {
                                                    this.zzh.zzr().zzi().zza("Invalid param value for number filter. event, param", this.zzh.zzo().zza(strZzc), this.zzh.zzo().zzb(strZzh));
                                                }
                                            } else {
                                                this.zzh.zzr().zzi().zza("No filter for String param. event, param", this.zzh.zzo().zza(strZzc), this.zzh.zzo().zzb(strZzh));
                                            }
                                            if (boolZza3 == null) {
                                                if (boolZza3.booleanValue() == z2) {
                                                    break;
                                                }
                                            }
                                        } else {
                                            if (obj == null) {
                                                this.zzh.zzr().zzx().zza("Missing param for filter. event, param", this.zzh.zzo().zza(strZzc), this.zzh.zzo().zzb(strZzh));
                                                break;
                                            }
                                            this.zzh.zzr().zzi().zza("Unknown param type. event, param", this.zzh.zzo().zza(strZzc), this.zzh.zzo().zzb(strZzh));
                                        }
                                    }
                                } else {
                                    bool = true;
                                    break;
                                }
                            }
                        }
                    }
                }
                bool = null;
                break;
            }
        }
        this.zzh.zzr().zzx().zza("Event filter result", bool == null ? AbstractJsonLexerKt.NULL : bool);
        if (bool == null) {
            return false;
        }
        this.zzc = true;
        if (!bool.booleanValue()) {
            return true;
        }
        this.zzd = true;
        if (z4 && zzcVar.zzd()) {
            Long lValueOf2 = Long.valueOf(zzcVar.zze());
            if (this.zzg.zzi()) {
                if (z3 && this.zzg.zzf()) {
                    lValueOf2 = l;
                }
                this.zzf = lValueOf2;
            } else {
                if (z3 && this.zzg.zzf()) {
                    lValueOf2 = l2;
                }
                this.zze = lValueOf2;
            }
        }
        return true;
    }
}
