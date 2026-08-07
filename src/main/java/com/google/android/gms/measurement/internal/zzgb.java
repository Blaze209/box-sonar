package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.microsoft.identity.client.internal.MsalUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzgb implements Runnable {
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzd zza;
    private final /* synthetic */ ServiceConnection zzb;
    private final /* synthetic */ zzgc zzc;

    zzgb(zzgc zzgcVar, com.google.android.gms.internal.measurement.zzd zzdVar, ServiceConnection serviceConnection) {
        this.zzc = zzgcVar;
        this.zza = zzdVar;
        this.zzb = serviceConnection;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:32:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:38:0x010d  */
    @Override // java.lang.Runnable
    public final void run() {
        zzfz zzfzVar = this.zzc.zza;
        String str = this.zzc.zzb;
        com.google.android.gms.internal.measurement.zzd zzdVar = this.zza;
        ServiceConnection serviceConnection = this.zzb;
        Bundle bundleZza = zzfzVar.zza(str, zzdVar);
        zzfzVar.zza.zzq().zzd();
        if (bundleZza != null) {
            long j = bundleZza.getLong("install_begin_timestamp_seconds", 0L) * 1000;
            if (j == 0) {
                zzfzVar.zza.zzr().zzf().zza("Service response is missing Install Referrer install timestamp");
            } else {
                String string = bundleZza.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    zzfzVar.zza.zzr().zzf().zza("No referrer defined in Install Referrer response");
                } else {
                    zzfzVar.zza.zzr().zzx().zza("InstallReferrer API result", string);
                    zzla zzlaVarZzi = zzfzVar.zza.zzi();
                    String strValueOf = String.valueOf(string);
                    Bundle bundleZza2 = zzlaVarZzi.zza(Uri.parse(strValueOf.length() != 0 ? MsalUtils.QUERY_STRING_SYMBOL.concat(strValueOf) : new String(MsalUtils.QUERY_STRING_SYMBOL)));
                    if (bundleZza2 == null) {
                        zzfzVar.zza.zzr().zzf().zza("No campaign params defined in Install Referrer result");
                    } else {
                        String string2 = bundleZza2.getString(FirebaseAnalytics.Param.MEDIUM);
                        if (string2 != null && !"(not set)".equalsIgnoreCase(string2) && !"organic".equalsIgnoreCase(string2)) {
                            long j2 = bundleZza.getLong("referrer_click_timestamp_seconds", 0L) * 1000;
                            if (j2 == 0) {
                                zzfzVar.zza.zzr().zzf().zza("Install Referrer is missing click timestamp for ad campaign");
                            } else {
                                bundleZza2.putLong("click_timestamp", j2);
                                if (j == zzfzVar.zza.zzc().zzi.zza()) {
                                    zzfzVar.zza.zzu();
                                    zzfzVar.zza.zzr().zzx().zza("Install Referrer campaign has already been logged");
                                } else if (com.google.android.gms.internal.measurement.zzkh.zzb()) {
                                    zzfzVar.zza.zzc().zzi.zza(j);
                                    zzfzVar.zza.zzu();
                                    zzfzVar.zza.zzr().zzx().zza("Logging Install Referrer campaign from sdk with ", "referrer API");
                                    bundleZza2.putString("_cis", "referrer API");
                                    zzfzVar.zza.zzh().zza("auto", "_cmp", bundleZza2);
                                } else {
                                    zzfzVar.zza.zzc().zzi.zza(j);
                                    zzfzVar.zza.zzu();
                                    zzfzVar.zza.zzr().zzx().zza("Logging Install Referrer campaign from sdk with ", "referrer API");
                                    bundleZza2.putString("_cis", "referrer API");
                                    zzfzVar.zza.zzh().zza("auto", "_cmp", bundleZza2);
                                }
                            }
                        } else if (j == zzfzVar.zza.zzc().zzi.zza()) {
                            zzfzVar.zza.zzu();
                            zzfzVar.zza.zzr().zzx().zza("Install Referrer campaign has already been logged");
                        } else if (com.google.android.gms.internal.measurement.zzkh.zzb() || !zzfzVar.zza.zzb().zza(zzap.zzcx) || zzfzVar.zza.zzab()) {
                            zzfzVar.zza.zzc().zzi.zza(j);
                            zzfzVar.zza.zzu();
                            zzfzVar.zza.zzr().zzx().zza("Logging Install Referrer campaign from sdk with ", "referrer API");
                            bundleZza2.putString("_cis", "referrer API");
                            zzfzVar.zza.zzh().zza("auto", "_cmp", bundleZza2);
                        }
                    }
                }
            }
        }
        if (serviceConnection != null) {
            ConnectionTracker.getInstance().unbindService(zzfzVar.zza.zzn(), serviceConnection);
        }
    }
}
