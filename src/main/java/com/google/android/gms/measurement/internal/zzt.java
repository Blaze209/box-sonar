package com.google.android.gms.measurement.internal;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzt extends zzu {
    private com.google.android.gms.internal.measurement.zzbj.zze zzg;
    private final /* synthetic */ zzn zzh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzt(zzn zznVar, String str, int i, com.google.android.gms.internal.measurement.zzbj.zze zzeVar) {
        super(str, i);
        this.zzh = zznVar;
        this.zzg = zzeVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzu
    final boolean zzb() {
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.zzu
    final boolean zzc() {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzu
    final int zza() {
        return this.zzg.zzb();
    }

    /* JADX WARN: Multi-variable type inference failed */
    final boolean zza(Long l, Long l2, com.google.android.gms.internal.measurement.zzbr.zzk zzkVar, boolean z) {
        boolean zZzd = this.zzh.zzt().zzd(this.zza, zzap.zzbm);
        boolean zZzd2 = this.zzh.zzt().zzd(this.zza, zzap.zzbs);
        Object[] objArr = com.google.android.gms.internal.measurement.zzkb.zzb() && this.zzh.zzt().zzd(this.zza, zzap.zzbv);
        boolean zZze = this.zzg.zze();
        boolean zZzf = this.zzg.zzf();
        Object[] objArr2 = zZzd && this.zzg.zzh();
        Object[] objArr3 = zZze || zZzf || objArr2 == true;
        Boolean boolZza = null;
        boolZza = null;
        boolZza = null;
        boolZza = null;
        boolZza = null;
        if (z && objArr3 == false) {
            this.zzh.zzr().zzx().zza("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.zzb), this.zzg.zza() ? Integer.valueOf(this.zzg.zzb()) : null);
            return true;
        }
        com.google.android.gms.internal.measurement.zzbj.zzc zzcVarZzd = this.zzg.zzd();
        boolean zZzf2 = zzcVarZzd.zzf();
        if (zzkVar.zzf()) {
            if (!zzcVarZzd.zzc()) {
                this.zzh.zzr().zzi().zza("No number filter for long property. property", this.zzh.zzo().zzc(zzkVar.zzc()));
            } else {
                boolZza = zza(zza(zzkVar.zzg(), zzcVarZzd.zzd()), zZzf2);
            }
        } else if (zzkVar.zzh()) {
            if (!zzcVarZzd.zzc()) {
                this.zzh.zzr().zzi().zza("No number filter for double property. property", this.zzh.zzo().zzc(zzkVar.zzc()));
            } else {
                boolZza = zza(zza(zzkVar.zzi(), zzcVarZzd.zzd()), zZzf2);
            }
        } else if (zzkVar.zzd()) {
            if (!zzcVarZzd.zza()) {
                if (!zzcVarZzd.zzc()) {
                    this.zzh.zzr().zzi().zza("No string or number filter defined. property", this.zzh.zzo().zzc(zzkVar.zzc()));
                } else if (zzkw.zza(zzkVar.zze())) {
                    boolZza = zza(zza(zzkVar.zze(), zzcVarZzd.zzd()), zZzf2);
                } else {
                    this.zzh.zzr().zzi().zza("Invalid user property value for Numeric number filter. property, value", this.zzh.zzo().zzc(zzkVar.zzc()), zzkVar.zze());
                }
            } else {
                boolZza = zza(zza(zzkVar.zze(), zzcVarZzd.zzb(), this.zzh.zzr()), zZzf2);
            }
        } else {
            this.zzh.zzr().zzi().zza("User property has no value, property", this.zzh.zzo().zzc(zzkVar.zzc()));
        }
        this.zzh.zzr().zzx().zza("Property filter result", boolZza == null ? AbstractJsonLexerKt.NULL : boolZza);
        if (boolZza == null) {
            return false;
        }
        this.zzc = true;
        if (zZzd && objArr2 == true && !boolZza.booleanValue()) {
            return true;
        }
        if (!z || this.zzg.zze()) {
            this.zzd = boolZza;
        }
        if (boolZza.booleanValue() && objArr3 != false && zzkVar.zza()) {
            long jZzb = zzkVar.zzb();
            if (zZzd2 && l != null) {
                jZzb = l.longValue();
            }
            if (objArr != false && this.zzg.zze() && !this.zzg.zzf() && l2 != null) {
                jZzb = l2.longValue();
            }
            if (this.zzg.zzf()) {
                this.zzf = Long.valueOf(jZzb);
            } else {
                this.zze = Long.valueOf(jZzb);
            }
        }
        return true;
    }
}
