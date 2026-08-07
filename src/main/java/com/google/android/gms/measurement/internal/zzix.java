package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzix extends zze {
    private final zzjp zza;
    private zzfc zzb;
    private volatile Boolean zzc;
    private final zzaf zzd;
    private final zzkl zze;
    private final List<Runnable> zzf;
    private final zzaf zzg;

    protected zzix(zzgo zzgoVar) {
        super(zzgoVar);
        this.zzf = new ArrayList();
        this.zze = new zzkl(zzgoVar.zzm());
        this.zza = new zzjp(this);
        this.zzd = new zzja(this, zzgoVar);
        this.zzg = new zzjh(this, zzgoVar);
    }

    @Override // com.google.android.gms.measurement.internal.zze
    protected final boolean zzz() {
        return false;
    }

    public final boolean zzab() {
        zzd();
        zzw();
        return this.zzb != null;
    }

    protected final void zzac() {
        zzd();
        zzw();
        zza(new zzjk(this, zza(true)));
    }

    final void zza(zzfc zzfcVar, AbstractSafeParcelable abstractSafeParcelable, zzm zzmVar) {
        int size;
        List<AbstractSafeParcelable> listZza;
        zzd();
        zzb();
        zzw();
        boolean zZzai = zzai();
        int i = 100;
        int i2 = 0;
        while (i2 < 1001 && i == 100) {
            ArrayList arrayList = new ArrayList();
            if (!zZzai || (listZza = zzj().zza(100)) == null) {
                size = 0;
            } else {
                arrayList.addAll(listZza);
                size = listZza.size();
            }
            if (abstractSafeParcelable != null && size < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            int size2 = arrayList.size();
            int i3 = 0;
            while (i3 < size2) {
                Object obj = arrayList.get(i3);
                i3++;
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) obj;
                if (abstractSafeParcelable2 instanceof zzan) {
                    try {
                        zzfcVar.zza((zzan) abstractSafeParcelable2, zzmVar);
                    } catch (RemoteException e) {
                        zzr().zzf().zza("Failed to send event to the service", e);
                    }
                } else if (abstractSafeParcelable2 instanceof zzkz) {
                    try {
                        zzfcVar.zza((zzkz) abstractSafeParcelable2, zzmVar);
                    } catch (RemoteException e2) {
                        zzr().zzf().zza("Failed to send user property to the service", e2);
                    }
                } else if (abstractSafeParcelable2 instanceof zzv) {
                    try {
                        zzfcVar.zza((zzv) abstractSafeParcelable2, zzmVar);
                    } catch (RemoteException e3) {
                        zzr().zzf().zza("Failed to send conditional user property to the service", e3);
                    }
                } else {
                    zzr().zzf().zza("Discarding data. Unrecognized parcel type.");
                }
            }
            i2++;
            i = size;
        }
    }

    protected final void zza(zzan zzanVar, String str) {
        Preconditions.checkNotNull(zzanVar);
        zzd();
        zzw();
        boolean zZzai = zzai();
        zza(new zzjj(this, zZzai, zZzai && zzj().zza(zzanVar), zzanVar, zza(true), str));
    }

    protected final void zza(zzv zzvVar) {
        Preconditions.checkNotNull(zzvVar);
        zzd();
        zzw();
        zzu();
        zza(new zzjm(this, true, zzj().zza(zzvVar), new zzv(zzvVar), zza(true), zzvVar));
    }

    protected final void zza(AtomicReference<List<zzv>> atomicReference, String str, String str2, String str3) {
        zzd();
        zzw();
        zza(new zzjl(this, atomicReference, str, str2, str3, zza(false)));
    }

    protected final void zza(com.google.android.gms.internal.measurement.zzn zznVar, String str, String str2) {
        zzd();
        zzw();
        zza(new zzjo(this, str, str2, zza(false), zznVar));
    }

    protected final void zza(AtomicReference<List<zzkz>> atomicReference, String str, String str2, String str3, boolean z) {
        zzd();
        zzw();
        zza(new zzjn(this, atomicReference, str, str2, str3, z, zza(false)));
    }

    protected final void zza(com.google.android.gms.internal.measurement.zzn zznVar, String str, String str2, boolean z) {
        zzd();
        zzw();
        zza(new zzjq(this, str, str2, z, zza(false), zznVar));
    }

    protected final void zza(zzkz zzkzVar) {
        zzd();
        zzw();
        zza(new zziz(this, zzai() && zzj().zza(zzkzVar), zzkzVar, zza(true)));
    }

    protected final void zza(AtomicReference<List<zzkz>> atomicReference, boolean z) {
        zzd();
        zzw();
        zza(new zzjc(this, atomicReference, zza(false), z));
    }

    protected final void zzad() {
        zzd();
        zzb();
        zzw();
        zzm zzmVarZza = zza(false);
        if (zzai()) {
            zzj().zzab();
        }
        zza(new zzjb(this, zzmVarZza));
    }

    private final boolean zzai() {
        zzu();
        return true;
    }

    public final void zza(AtomicReference<String> atomicReference) {
        zzd();
        zzw();
        zza(new zzje(this, atomicReference, zza(false)));
    }

    public final void zza(com.google.android.gms.internal.measurement.zzn zznVar) {
        zzd();
        zzw();
        zza(new zzjd(this, zza(false), zznVar));
    }

    protected final void zzae() {
        zzd();
        zzw();
        zzm zzmVarZza = zza(true);
        boolean zZza = zzt().zza(zzap.zzbz);
        if (zZza) {
            zzj().zzac();
        }
        zza(new zzjg(this, zzmVarZza, zZza));
    }

    protected final void zza(zzit zzitVar) {
        zzd();
        zzw();
        zza(new zzjf(this, zzitVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaj() {
        zzd();
        this.zze.zza();
        this.zzd.zza(zzap.zzah.zza(null).longValue());
    }

    final void zzaf() {
        boolean z;
        zzd();
        zzw();
        if (zzab()) {
            return;
        }
        if (this.zzc == null) {
            zzd();
            zzw();
            Boolean boolZzj = zzs().zzj();
            boolean z2 = true;
            if (boolZzj == null || !boolZzj.booleanValue()) {
                zzu();
                boolean z3 = false;
                if (zzg().zzag() == 1) {
                    z = true;
                } else {
                    zzr().zzx().zza("Checking service availability");
                    int iZza = zzp().zza(12451000);
                    if (iZza != 0) {
                        if (iZza == 1) {
                            zzr().zzx().zza("Service missing");
                        } else if (iZza != 2) {
                            if (iZza == 3) {
                                zzr().zzi().zza("Service disabled");
                            } else if (iZza == 9) {
                                zzr().zzi().zza("Service invalid");
                            } else if (iZza == 18) {
                                zzr().zzi().zza("Service updating");
                            } else {
                                zzr().zzi().zza("Unexpected service status", Integer.valueOf(iZza));
                            }
                            z = false;
                            z2 = false;
                        } else {
                            zzr().zzw().zza("Service container out of date");
                            if (zzp().zzj() >= 17443) {
                                Boolean boolZzj2 = zzs().zzj();
                                if (boolZzj2 != null && !boolZzj2.booleanValue()) {
                                    z2 = false;
                                }
                                z = false;
                            }
                        }
                        z = true;
                        z2 = false;
                    } else {
                        zzr().zzx().zza("Service available");
                    }
                    z = true;
                }
                if (z2 || !zzt().zzx()) {
                    z3 = z;
                } else {
                    zzr().zzf().zza("No way to upload. Consider using the full version of Analytics");
                }
                if (z3) {
                    zzs().zza(z2);
                }
            }
            this.zzc = Boolean.valueOf(z2);
        }
        if (this.zzc.booleanValue()) {
            this.zza.zzb();
            return;
        }
        if (zzt().zzx()) {
            return;
        }
        zzu();
        List<ResolveInfo> listQueryIntentServices = MAMPackageManagement.queryIntentServices(zzn().getPackageManager(), new Intent().setClassName(zzn(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if (listQueryIntentServices != null && listQueryIntentServices.size() > 0) {
            Intent intent = new Intent("com.google.android.gms.measurement.START");
            Context contextZzn = zzn();
            zzu();
            intent.setComponent(new ComponentName(contextZzn, "com.google.android.gms.measurement.AppMeasurementService"));
            this.zza.zza(intent);
            return;
        }
        zzr().zzf().zza("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
    }

    final Boolean zzag() {
        return this.zzc;
    }

    protected final void zza(zzfc zzfcVar) {
        zzd();
        Preconditions.checkNotNull(zzfcVar);
        this.zzb = zzfcVar;
        zzaj();
        zzal();
    }

    public final void zzah() {
        zzd();
        zzw();
        this.zza.zza();
        try {
            ConnectionTracker.getInstance().unbindService(zzn(), this.zza);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzb = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(ComponentName componentName) {
        zzd();
        if (this.zzb != null) {
            this.zzb = null;
            zzr().zzx().zza("Disconnected from device MeasurementService", componentName);
            zzd();
            zzaf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzak() {
        zzd();
        if (zzab()) {
            zzr().zzx().zza("Inactivity, disconnecting from the service");
            zzah();
        }
    }

    private final void zza(Runnable runnable) throws IllegalStateException {
        zzd();
        if (zzab()) {
            runnable.run();
        } else {
            if (this.zzf.size() >= 1000) {
                zzr().zzf().zza("Discarding data. Max runnable queue size reached");
                return;
            }
            this.zzf.add(runnable);
            this.zzg.zza(60000L);
            zzaf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzal() {
        zzd();
        zzr().zzx().zza("Processing queued up service tasks", Integer.valueOf(this.zzf.size()));
        Iterator<Runnable> it = this.zzf.iterator();
        while (it.hasNext()) {
            try {
                it.next().run();
            } catch (Exception e) {
                zzr().zzf().zza("Task exception while flushing queue", e);
            }
        }
        this.zzf.clear();
        this.zzg.zzc();
    }

    private final zzm zza(boolean z) {
        zzu();
        return zzg().zza(z ? zzr().zzy() : null);
    }

    public final void zza(com.google.android.gms.internal.measurement.zzn zznVar, zzan zzanVar, String str) {
        zzd();
        zzw();
        if (zzp().zza(12451000) != 0) {
            zzr().zzi().zza("Not bundling data. Service unavailable or out of date");
            zzp().zza(zznVar, new byte[0]);
        } else {
            zza(new zzji(this, zzanVar, str, zznVar));
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzf, com.google.android.gms.measurement.internal.zzhf
    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzf, com.google.android.gms.measurement.internal.zzhf
    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzf, com.google.android.gms.measurement.internal.zzhf
    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzf, com.google.android.gms.measurement.internal.zzhf
    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzb zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzhp zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzfd zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzix zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zziw zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzfg zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final /* bridge */ /* synthetic */ zzkc zzk() {
        return super.zzk();
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

    static /* synthetic */ zzfc zza(zzix zzixVar, zzfc zzfcVar) {
        zzixVar.zzb = null;
        return null;
    }
}
