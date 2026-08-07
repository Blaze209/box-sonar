package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzfj implements Runnable {
    private final /* synthetic */ int zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ Object zzc;
    private final /* synthetic */ Object zzd;
    private final /* synthetic */ Object zze;
    private final /* synthetic */ zzfk zzf;

    zzfj(zzfk zzfkVar, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zzf = zzfkVar;
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zze = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzft zzftVarZzc = this.zzf.zzx.zzc();
        if (!zzftVarZzc.zzz()) {
            this.zzf.zza(6, "Persisted config not initialized. Not logging error/warn");
            return;
        }
        if (this.zzf.zza == 0) {
            if (this.zzf.zzt().zzf()) {
                zzfk zzfkVar = this.zzf;
                zzfkVar.zzu();
                zzfkVar.zza = 'C';
            } else {
                zzfk zzfkVar2 = this.zzf;
                zzfkVar2.zzu();
                zzfkVar2.zza = 'c';
            }
        }
        if (this.zzf.zzb < 0) {
            zzfk zzfkVar3 = this.zzf;
            zzfkVar3.zzb = zzfkVar3.zzt().zze();
        }
        char cCharAt = "01VDIWEA?".charAt(this.zza);
        char c = this.zzf.zza;
        long j = this.zzf.zzb;
        String strZza = zzfk.zza(true, this.zzb, this.zzc, this.zzd, this.zze);
        String string = new StringBuilder(String.valueOf(strZza).length() + 24).append("2").append(cCharAt).append(c).append(j).append(":").append(strZza).toString();
        if (string.length() > 1024) {
            string = this.zzb.substring(0, 1024);
        }
        zzftVarZzc.zzb.zza(string, 1L);
    }
}
