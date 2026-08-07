package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.SieveCacheKt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzll;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzir extends zzkp {
    public zzir(zzks zzksVar) {
        super(zzksVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzkp
    protected final boolean zze() {
        return false;
    }

    public final byte[] zza(zzan zzanVar, String str) {
        zzlb next;
        List<zzlb> list;
        com.google.android.gms.internal.measurement.zzbr.zzf.zza zzaVar;
        Bundle bundle;
        zzg zzgVar;
        com.google.android.gms.internal.measurement.zzbr.zzg.zza zzaVar2;
        byte[] bArr;
        zzaj zzajVarZza;
        long j;
        zzd();
        this.zzx.zzaf();
        Preconditions.checkNotNull(zzanVar);
        Preconditions.checkNotEmpty(str);
        if (!zzt().zze(str, zzap.zzbf)) {
            zzr().zzw().zza("Generating ScionPayload disabled. packageName", str);
            return new byte[0];
        }
        if (!"_iap".equals(zzanVar.zza) && !"_iapx".equals(zzanVar.zza)) {
            zzr().zzw().zza("Generating a payload for this event is not available. package_name, event_name", str, zzanVar.zza);
            return null;
        }
        com.google.android.gms.internal.measurement.zzbr.zzf.zza zzaVarZzb = com.google.android.gms.internal.measurement.zzbr.zzf.zzb();
        zzi().zzf();
        try {
            zzg zzgVarZzb = zzi().zzb(str);
            if (zzgVarZzb == null) {
                zzr().zzw().zza("Log and bundle not available. package_name", str);
                byte[] bArr2 = new byte[0];
                zzi().zzh();
                return bArr2;
            }
            if (!zzgVarZzb.zzr()) {
                zzr().zzw().zza("Log and bundle disabled. package_name", str);
                byte[] bArr3 = new byte[0];
                zzi().zzh();
                return bArr3;
            }
            com.google.android.gms.internal.measurement.zzbr.zzg.zza zzaVarZza = com.google.android.gms.internal.measurement.zzbr.zzg.zzbf().zza(1).zza("android");
            if (!TextUtils.isEmpty(zzgVarZzb.zzc())) {
                zzaVarZza.zzf(zzgVarZzb.zzc());
            }
            if (!TextUtils.isEmpty(zzgVarZzb.zzn())) {
                zzaVarZza.zze(zzgVarZzb.zzn());
            }
            if (!TextUtils.isEmpty(zzgVarZzb.zzl())) {
                zzaVarZza.zzg(zzgVarZzb.zzl());
            }
            if (zzgVarZzb.zzm() != SieveCacheKt.NodeMetaAndPreviousMask) {
                zzaVarZza.zzh((int) zzgVarZzb.zzm());
            }
            zzaVarZza.zzf(zzgVarZzb.zzo()).zzk(zzgVarZzb.zzq());
            if (zzll.zzb() && zzt().zze(zzgVarZzb.zzc(), zzap.zzch)) {
                if (!TextUtils.isEmpty(zzgVarZzb.zze())) {
                    zzaVarZza.zzk(zzgVarZzb.zze());
                } else if (!TextUtils.isEmpty(zzgVarZzb.zzg())) {
                    zzaVarZza.zzp(zzgVarZzb.zzg());
                } else if (!TextUtils.isEmpty(zzgVarZzb.zzf())) {
                    zzaVarZza.zzo(zzgVarZzb.zzf());
                }
            } else if (!TextUtils.isEmpty(zzgVarZzb.zze())) {
                zzaVarZza.zzk(zzgVarZzb.zze());
            } else if (!TextUtils.isEmpty(zzgVarZzb.zzf())) {
                zzaVarZza.zzo(zzgVarZzb.zzf());
            }
            zzaVarZza.zzh(zzgVarZzb.zzp());
            if (this.zzx.zzab() && zzt().zzf(zzaVarZza.zzj())) {
                zzaVarZza.zzj();
                if (!TextUtils.isEmpty(null)) {
                    zzaVarZza.zzn(null);
                }
            }
            Pair<String, Boolean> pairZza = zzs().zza(zzgVarZzb.zzc());
            if (zzgVarZzb.zzaf() && pairZza != null && !TextUtils.isEmpty((CharSequence) pairZza.first)) {
                try {
                    zzaVarZza.zzh(zza((String) pairZza.first, Long.toString(zzanVar.zzd)));
                    if (pairZza.second != null) {
                        zzaVarZza.zza(((Boolean) pairZza.second).booleanValue());
                    }
                } catch (SecurityException e) {
                    zzr().zzw().zza("Resettable device id encryption failed", e.getMessage());
                    byte[] bArr4 = new byte[0];
                    zzi().zzh();
                    return bArr4;
                }
            }
            zzl().zzaa();
            com.google.android.gms.internal.measurement.zzbr.zzg.zza zzaVarZzc = zzaVarZza.zzc(Build.MODEL);
            zzl().zzaa();
            zzaVarZzc.zzb(Build.VERSION.RELEASE).zzf((int) zzl().zzf()).zzd(zzl().zzg());
            try {
                zzaVarZza.zzi(zza(zzgVarZzb.zzd(), Long.toString(zzanVar.zzd)));
                if (!TextUtils.isEmpty(zzgVarZzb.zzi())) {
                    zzaVarZza.zzl(zzgVarZzb.zzi());
                }
                String strZzc = zzgVarZzb.zzc();
                List<zzlb> listZza = zzi().zza(strZzc);
                Iterator<zzlb> it = listZza.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!"_lte".equals(next.zzc));
                if (next == null || next.zze == null) {
                    list = listZza;
                    zzlb zzlbVar = new zzlb(strZzc, "auto", "_lte", zzm().currentTimeMillis(), 0L);
                    list.add(zzlbVar);
                    zzi().zza(zzlbVar);
                } else {
                    list = listZza;
                }
                if (zzt().zze(strZzc, zzap.zzbc)) {
                    zzkw zzkwVarZzg = zzg();
                    zzkwVarZzg.zzr().zzx().zza("Checking account type status for ad personalization signals");
                    if (zzkwVarZzg.zzl().zzj()) {
                        String strZzc2 = zzgVarZzb.zzc();
                        if (zzgVarZzb.zzaf() && zzkwVarZzg.zzj().zze(strZzc2)) {
                            zzkwVarZzg.zzr().zzw().zza("Turning off ad personalization due to account type");
                            Iterator<zzlb> it2 = list.iterator();
                            while (it2.hasNext()) {
                                if ("_npa".equals(it2.next().zzc)) {
                                    it2.remove();
                                    break;
                                }
                            }
                            list.add(new zzlb(strZzc2, "auto", "_npa", zzkwVarZzg.zzm().currentTimeMillis(), 1L));
                        }
                    }
                }
                com.google.android.gms.internal.measurement.zzbr.zzk[] zzkVarArr = new com.google.android.gms.internal.measurement.zzbr.zzk[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    com.google.android.gms.internal.measurement.zzbr.zzk.zza zzaVarZza2 = com.google.android.gms.internal.measurement.zzbr.zzk.zzj().zza(list.get(i).zzc).zza(list.get(i).zzd);
                    zzg().zza(zzaVarZza2, list.get(i).zze);
                    zzkVarArr[i] = (com.google.android.gms.internal.measurement.zzbr.zzk) ((com.google.android.gms.internal.measurement.zzfd) zzaVarZza2.zzu());
                }
                zzaVarZza.zzb(Arrays.asList(zzkVarArr));
                Bundle bundleZzb = zzanVar.zzb.zzb();
                bundleZzb.putLong("_c", 1L);
                zzr().zzw().zza("Marking in-app purchase as real-time");
                bundleZzb.putLong("_r", 1L);
                bundleZzb.putString("_o", zzanVar.zzc);
                if (zzp().zzf(zzaVarZza.zzj())) {
                    zzp().zza(bundleZzb, "_dbg", (Object) 1L);
                    zzp().zza(bundleZzb, "_r", (Object) 1L);
                }
                zzaj zzajVarZza2 = zzi().zza(str, zzanVar.zza);
                if (zzajVarZza2 == null) {
                    bundle = bundleZzb;
                    zzgVar = zzgVarZzb;
                    zzaVar = zzaVarZzb;
                    zzaVar2 = zzaVarZza;
                    bArr = null;
                    zzajVarZza = new zzaj(str, zzanVar.zza, 0L, 0L, zzanVar.zzd, 0L, null, null, null, null);
                    j = 0;
                } else {
                    zzaVar = zzaVarZzb;
                    bundle = bundleZzb;
                    zzgVar = zzgVarZzb;
                    zzaVar2 = zzaVarZza;
                    bArr = null;
                    long j2 = zzajVarZza2.zzf;
                    zzajVarZza = zzajVarZza2.zza(zzanVar.zzd);
                    j = j2;
                }
                zzaj zzajVar = zzajVarZza;
                zzi().zza(zzajVar);
                zzak zzakVar = new zzak(this.zzx, zzanVar.zzc, str, zzanVar.zza, zzanVar.zzd, j, bundle);
                com.google.android.gms.internal.measurement.zzbr.zzc.zza zzaVarZzb2 = com.google.android.gms.internal.measurement.zzbr.zzc.zzj().zza(zzakVar.zzc).zza(zzakVar.zzb).zzb(zzakVar.zzd);
                for (String str2 : zzakVar.zze) {
                    com.google.android.gms.internal.measurement.zzbr.zze.zza zzaVarZza3 = com.google.android.gms.internal.measurement.zzbr.zze.zzk().zza(str2);
                    zzg().zza(zzaVarZza3, zzakVar.zze.zza(str2));
                    zzaVarZzb2.zza(zzaVarZza3);
                }
                com.google.android.gms.internal.measurement.zzbr.zzg.zza zzaVar3 = zzaVar2;
                zzaVar3.zza(zzaVarZzb2).zza(com.google.android.gms.internal.measurement.zzbr.zzh.zza().zza(com.google.android.gms.internal.measurement.zzbr.zzd.zza().zza(zzajVar.zzc).zza(zzanVar.zza)));
                zzaVar3.zzc(e_().zza(zzgVar.zzc(), Collections.emptyList(), zzaVar3.zzd(), Long.valueOf(zzaVarZzb2.zzf()), Long.valueOf(zzaVarZzb2.zzf())));
                if (zzaVarZzb2.zze()) {
                    zzaVar3.zzb(zzaVarZzb2.zzf()).zzc(zzaVarZzb2.zzf());
                }
                long jZzk = zzgVar.zzk();
                if (jZzk != 0) {
                    zzaVar3.zze(jZzk);
                }
                long jZzj = zzgVar.zzj();
                if (jZzj != 0) {
                    zzaVar3.zzd(jZzj);
                } else if (jZzk != 0) {
                    zzaVar3.zzd(jZzk);
                }
                zzgVar.zzv();
                zzaVar3.zzg((int) zzgVar.zzs()).zzg(zzt().zze()).zza(zzm().currentTimeMillis()).zzb(Boolean.TRUE.booleanValue());
                com.google.android.gms.internal.measurement.zzbr.zzf.zza zzaVar4 = zzaVar;
                zzaVar4.zza(zzaVar3);
                zzg zzgVar2 = zzgVar;
                zzgVar2.zza(zzaVar3.zzf());
                zzgVar2.zzb(zzaVar3.zzg());
                zzi().zza(zzgVar2);
                zzi().b_();
                zzi().zzh();
                try {
                    return zzg().zzc(((com.google.android.gms.internal.measurement.zzbr.zzf) ((com.google.android.gms.internal.measurement.zzfd) zzaVar4.zzu())).zzbi());
                } catch (IOException e2) {
                    zzr().zzf().zza("Data loss. Failed to bundle and serialize. appId", zzfk.zza(str), e2);
                    return bArr;
                }
            } catch (SecurityException e3) {
                zzr().zzw().zza("app instance id encryption failed", e3.getMessage());
                byte[] bArr5 = new byte[0];
                zzi().zzh();
                return bArr5;
            }
        } catch (Throwable th) {
            zzi().zzh();
            throw th;
        }
    }

    private static String zza(String str, String str2) {
        throw new SecurityException("This implementation should not be used.");
    }
}
