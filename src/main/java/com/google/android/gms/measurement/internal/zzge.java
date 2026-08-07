package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.microsoft.identity.client.internal.MsalUtils;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzge {
    private final zzgf zza;

    public zzge(zzgf zzgfVar) {
        Preconditions.checkNotNull(zzgfVar);
        this.zza = zzgfVar;
    }

    public static boolean zza(Context context) {
        ActivityInfo receiverInfo;
        Preconditions.checkNotNull(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            return (packageManager == null || (receiverInfo = MAMPackageManagement.getReceiverInfo(packageManager, new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) == null || !receiverInfo.enabled) ? false : true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public final void zza(Context context, Intent intent) {
        zzgo zzgoVarZza = zzgo.zza(context, (com.google.android.gms.internal.measurement.zzv) null);
        zzfk zzfkVarZzr = zzgoVarZza.zzr();
        if (intent == null) {
            zzfkVarZzr.zzi().zza("Receiver called with null intent");
            return;
        }
        zzgoVarZza.zzu();
        String action = intent.getAction();
        zzfkVarZzr.zzx().zza("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            zzfkVarZzr.zzx().zza("Starting wakeful intent.");
            this.zza.doStartService(context, className);
            return;
        }
        if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            try {
                zzgoVarZza.zzq().zza(new zzgd(this, zzgoVarZza, zzfkVarZzr));
            } catch (Exception e) {
                zzfkVarZzr.zzi().zza("Install Referrer Reporter encountered a problem", e);
            }
            BroadcastReceiver.PendingResult pendingResultDoGoAsync = this.zza.doGoAsync();
            String stringExtra = intent.getStringExtra("referrer");
            if (stringExtra == null) {
                zzfkVarZzr.zzx().zza("Install referrer extras are null");
                if (pendingResultDoGoAsync != null) {
                    pendingResultDoGoAsync.finish();
                    return;
                }
                return;
            }
            zzfkVarZzr.zzv().zza("Install referrer extras are", stringExtra);
            if (!stringExtra.contains(MsalUtils.QUERY_STRING_SYMBOL)) {
                String strValueOf = String.valueOf(stringExtra);
                stringExtra = strValueOf.length() != 0 ? MsalUtils.QUERY_STRING_SYMBOL.concat(strValueOf) : new String(MsalUtils.QUERY_STRING_SYMBOL);
            }
            Bundle bundleZza = zzgoVarZza.zzi().zza(Uri.parse(stringExtra));
            if (bundleZza == null) {
                zzfkVarZzr.zzx().zza("No campaign defined in install referrer broadcast");
                if (pendingResultDoGoAsync != null) {
                    pendingResultDoGoAsync.finish();
                    return;
                }
                return;
            }
            long longExtra = intent.getLongExtra("referrer_timestamp_seconds", 0L) * 1000;
            if (longExtra == 0) {
                zzfkVarZzr.zzi().zza("Install referrer is missing timestamp");
            }
            zzgoVarZza.zzq().zza(new zzgg(this, zzgoVarZza, longExtra, bundleZza, context, zzfkVarZzr, pendingResultDoGoAsync));
        }
    }
}
