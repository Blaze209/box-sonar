package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
final class zzgb implements zzhg {
    private static final zzgl zzb = new zzge();
    private final zzgl zza;

    public zzgb() {
        this(new zzgd(zzfe.zza(), zza()));
    }

    private zzgb(zzgl zzglVar) {
        this.zza = (zzgl) zzff.zza(zzglVar, "messageInfoFactory");
    }

    @Override // com.google.android.gms.internal.measurement.zzhg
    public final <T> zzhd<T> zza(Class<T> cls) {
        zzhf.zza((Class<?>) cls);
        zzgm zzgmVarZzb = this.zza.zzb(cls);
        if (zzgmVarZzb.zzb()) {
            if (zzfd.class.isAssignableFrom(cls)) {
                return zzgu.zza(zzhf.zzc(), zzet.zza(), zzgmVarZzb.zzc());
            }
            return zzgu.zza(zzhf.zza(), zzet.zzb(), zzgmVarZzb.zzc());
        }
        if (zzfd.class.isAssignableFrom(cls)) {
            if (zza(zzgmVarZzb)) {
                return zzgs.zza(cls, zzgmVarZzb, zzgy.zzb(), zzfy.zzb(), zzhf.zzc(), zzet.zza(), zzgj.zzb());
            }
            return zzgs.zza(cls, zzgmVarZzb, zzgy.zzb(), zzfy.zzb(), zzhf.zzc(), (zzes<?>) null, zzgj.zzb());
        }
        if (zza(zzgmVarZzb)) {
            return zzgs.zza(cls, zzgmVarZzb, zzgy.zza(), zzfy.zza(), zzhf.zza(), zzet.zzb(), zzgj.zza());
        }
        return zzgs.zza(cls, zzgmVarZzb, zzgy.zza(), zzfy.zza(), zzhf.zzb(), (zzes<?>) null, zzgj.zza());
    }

    private static boolean zza(zzgm zzgmVar) {
        return zzgmVar.zza() == zzfd.zze.zzh;
    }

    private static zzgl zza() {
        try {
            return (zzgl) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return zzb;
        }
    }
}
