package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
abstract class zzkp extends zzkq {
    private boolean zzb;

    zzkp(zzks zzksVar) {
        super(zzksVar);
        this.zza.zza(this);
    }

    protected abstract boolean zze();

    final boolean zzaj() {
        return this.zzb;
    }

    protected final void zzak() {
        if (!zzaj()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzal() {
        if (this.zzb) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zze();
        this.zza.zzp();
        this.zzb = true;
    }
}
