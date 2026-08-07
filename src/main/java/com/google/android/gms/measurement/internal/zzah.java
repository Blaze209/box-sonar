package com.google.android.gms.measurement.internal;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.util.Clock;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzah extends zzhi {
    private long zza;
    private String zzb;
    private Boolean zzc;
    private AccountManager zzd;
    private Boolean zze;
    private long zzf;

    zzah(zzgo zzgoVar) {
        super(zzgoVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzhi
    protected final boolean zze() {
        Calendar calendar = Calendar.getInstance();
        this.zza = TimeUnit.MINUTES.convert(calendar.get(15) + calendar.get(16), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String lowerCase = locale.getLanguage().toLowerCase(Locale.ENGLISH);
        String lowerCase2 = locale.getCountry().toLowerCase(Locale.ENGLISH);
        this.zzb = new StringBuilder(String.valueOf(lowerCase).length() + 1 + String.valueOf(lowerCase2).length()).append(lowerCase).append(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR).append(lowerCase2).toString();
        return false;
    }

    public final long zzf() {
        zzaa();
        return this.zza;
    }

    public final String zzg() {
        zzaa();
        return this.zzb;
    }

    public final boolean zza(Context context) {
        if (this.zzc == null) {
            zzu();
            this.zzc = false;
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    MAMPackageManagement.getPackageInfo(packageManager, "com.google.android.gms", 128);
                    this.zzc = true;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return this.zzc.booleanValue();
    }

    final long zzh() {
        zzd();
        return this.zzf;
    }

    final void zzi() {
        zzd();
        this.zze = null;
        this.zzf = 0L;
    }

    final boolean zzj() {
        zzd();
        long jCurrentTimeMillis = zzm().currentTimeMillis();
        if (jCurrentTimeMillis - this.zzf > 86400000) {
            this.zze = null;
        }
        Boolean bool = this.zze;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (ContextCompat.checkSelfPermission(zzn(), "android.permission.GET_ACCOUNTS") != 0) {
            zzr().zzj().zza("Permission error checking for dasher/unicorn accounts");
            this.zzf = jCurrentTimeMillis;
            this.zze = false;
            return false;
        }
        if (this.zzd == null) {
            this.zzd = AccountManager.get(zzn());
        }
        try {
            Account[] result = this.zzd.getAccountsByTypeAndFeatures("com.google", new String[]{"service_HOSTED"}, null, null).getResult();
            if (result != null && result.length > 0) {
                this.zze = true;
                this.zzf = jCurrentTimeMillis;
                return true;
            }
            Account[] result2 = this.zzd.getAccountsByTypeAndFeatures("com.google", new String[]{"service_uca"}, null, null).getResult();
            if (result2 != null && result2.length > 0) {
                this.zze = true;
                this.zzf = jCurrentTimeMillis;
                return true;
            }
            this.zzf = jCurrentTimeMillis;
            this.zze = false;
            return false;
        } catch (AuthenticatorException | OperationCanceledException | IOException e) {
            zzr().zzg().zza("Exception checking account types", e);
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
    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzhf
    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
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
}
