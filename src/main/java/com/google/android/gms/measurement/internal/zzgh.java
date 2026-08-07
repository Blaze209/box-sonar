package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzgh extends zzhi {
    private static final AtomicLong zzj = new AtomicLong(Long.MIN_VALUE);
    private zzgl zza;
    private zzgl zzb;
    private final PriorityBlockingQueue<zzgm<?>> zzc;
    private final BlockingQueue<zzgm<?>> zzd;
    private final Thread.UncaughtExceptionHandler zze;
    private final Thread.UncaughtExceptionHandler zzf;
    private final Object zzg;
    private final Semaphore zzh;
    private volatile boolean zzi;

    zzgh(zzgo zzgoVar) {
        super(zzgoVar);
        this.zzg = new Object();
        this.zzh = new Semaphore(2);
        this.zzc = new PriorityBlockingQueue<>();
        this.zzd = new LinkedBlockingQueue();
        this.zze = new zzgj(this, "Thread death: Uncaught exception on worker thread");
        this.zzf = new zzgj(this, "Thread death: Uncaught exception on network thread");
    }

    @Override // com.google.android.gms.measurement.internal.zzhi
    protected final boolean zze() {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzhf
    public final void zzd() {
        if (Thread.currentThread() != this.zza) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzhf
    public final void zzc() {
        if (Thread.currentThread() != this.zzb) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public final boolean zzg() {
        return Thread.currentThread() == this.zza;
    }

    public final <V> Future<V> zza(Callable<V> callable) throws IllegalStateException {
        zzaa();
        Preconditions.checkNotNull(callable);
        zzgm<?> zzgmVar = new zzgm<>(this, (Callable<?>) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.zza) {
            if (!this.zzc.isEmpty()) {
                zzr().zzi().zza("Callable skipped the worker queue.");
            }
            zzgmVar.run();
            return zzgmVar;
        }
        zza(zzgmVar);
        return zzgmVar;
    }

    public final <V> Future<V> zzb(Callable<V> callable) throws IllegalStateException {
        zzaa();
        Preconditions.checkNotNull(callable);
        zzgm<?> zzgmVar = new zzgm<>(this, (Callable<?>) callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.zza) {
            zzgmVar.run();
            return zzgmVar;
        }
        zza(zzgmVar);
        return zzgmVar;
    }

    public final void zza(Runnable runnable) throws IllegalStateException {
        zzaa();
        Preconditions.checkNotNull(runnable);
        zza(new zzgm<>(this, runnable, false, "Task exception on worker thread"));
    }

    final <T> T zza(AtomicReference<T> atomicReference, long j, String str, Runnable runnable) {
        synchronized (atomicReference) {
            zzq().zza(runnable);
            try {
                atomicReference.wait(j);
            } catch (InterruptedException unused) {
                zzfm zzfmVarZzi = zzr().zzi();
                String strValueOf = String.valueOf(str);
                zzfmVarZzi.zza(strValueOf.length() != 0 ? "Interrupted waiting for ".concat(strValueOf) : new String("Interrupted waiting for "));
                return null;
            }
        }
        T t = atomicReference.get();
        if (t == null) {
            zzfm zzfmVarZzi2 = zzr().zzi();
            String strValueOf2 = String.valueOf(str);
            zzfmVarZzi2.zza(strValueOf2.length() != 0 ? "Timed out waiting for ".concat(strValueOf2) : new String("Timed out waiting for "));
        }
        return t;
    }

    private final void zza(zzgm<?> zzgmVar) {
        synchronized (this.zzg) {
            this.zzc.add(zzgmVar);
            zzgl zzglVar = this.zza;
            if (zzglVar == null) {
                zzgl zzglVar2 = new zzgl(this, "Measurement Worker", this.zzc);
                this.zza = zzglVar2;
                zzglVar2.setUncaughtExceptionHandler(this.zze);
                this.zza.start();
            } else {
                zzglVar.zza();
            }
        }
    }

    public final void zzb(Runnable runnable) throws IllegalStateException {
        zzaa();
        Preconditions.checkNotNull(runnable);
        zzgm<?> zzgmVar = new zzgm<>(this, runnable, false, "Task exception on network thread");
        synchronized (this.zzg) {
            this.zzd.add(zzgmVar);
            zzgl zzglVar = this.zzb;
            if (zzglVar == null) {
                zzgl zzglVar2 = new zzgl(this, "Measurement Network", this.zzd);
                this.zzb = zzglVar2;
                zzglVar2.setUncaughtExceptionHandler(this.zzf);
                this.zzb.start();
            } else {
                zzglVar.zza();
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzhf
    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf
    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf
    public final /* bridge */ /* synthetic */ zzah zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf, com.google.android.gms.measurement.internal.zzhh
    public final /* bridge */ /* synthetic */ Clock zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf, com.google.android.gms.measurement.internal.zzhh
    public final /* bridge */ /* synthetic */ Context zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf
    public final /* bridge */ /* synthetic */ zzfi zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf
    public final /* bridge */ /* synthetic */ zzla zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf, com.google.android.gms.measurement.internal.zzhh
    public final /* bridge */ /* synthetic */ zzgh zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf, com.google.android.gms.measurement.internal.zzhh
    public final /* bridge */ /* synthetic */ zzfk zzr() {
        return super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf
    public final /* bridge */ /* synthetic */ zzft zzs() {
        return super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf
    public final /* bridge */ /* synthetic */ zzx zzt() {
        return super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf, com.google.android.gms.measurement.internal.zzhh
    public final /* bridge */ /* synthetic */ zzw zzu() {
        return super.zzu();
    }

    static /* synthetic */ zzgl zza(zzgh zzghVar, zzgl zzglVar) {
        zzghVar.zza = null;
        return null;
    }

    static /* synthetic */ zzgl zzb(zzgh zzghVar, zzgl zzglVar) {
        zzghVar.zzb = null;
        return null;
    }
}
