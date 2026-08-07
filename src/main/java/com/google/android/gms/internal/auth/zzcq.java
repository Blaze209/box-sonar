package com.google.android.gms.internal.auth;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.util.Log;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzcq {
    static volatile zzdh zza = zzdh.zzc();
    private static final Object zzb = new Object();

    public static boolean zza(Context context, Uri uri) {
        ProviderInfo providerInfoResolveContentProvider;
        String authority = uri.getAuthority();
        boolean z = false;
        if (!"com.google.android.gms.phenotype".equals(authority)) {
            Log.e("PhenotypeClientHelper", String.valueOf(authority).concat(" is an unsupported authority. Only com.google.android.gms.phenotype authority is supported."));
            return false;
        }
        if (zza.zzb()) {
            return ((Boolean) zza.zza()).booleanValue();
        }
        synchronized (zzb) {
            if (zza.zzb()) {
                return ((Boolean) zza.zza()).booleanValue();
            }
            if ("com.google.android.gms".equals(context.getPackageName()) || ((providerInfoResolveContentProvider = MAMPackageManagement.resolveContentProvider(context.getPackageManager(), "com.google.android.gms.phenotype", 268435456)) != null && "com.google.android.gms".equals(providerInfoResolveContentProvider.packageName))) {
                try {
                    if ((MAMPackageManagement.getApplicationInfo(context.getPackageManager(), "com.google.android.gms", 0).flags & 129) != 0) {
                        z = true;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            zza = zzdh.zzd(Boolean.valueOf(z));
            return ((Boolean) zza.zza()).booleanValue();
        }
    }
}
