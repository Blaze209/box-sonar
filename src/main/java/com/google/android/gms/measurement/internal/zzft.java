package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.amplitude.api.Constants;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzft extends zzhi {
    static final Pair<String, Long> zza = new Pair<>("", 0L);
    private boolean zzaa;
    private long zzab;
    public zzfx zzb;
    public final zzfy zzc;
    public final zzfy zzd;
    public final zzfy zze;
    public final zzfy zzf;
    public final zzfy zzg;
    public final zzfy zzh;
    public final zzfy zzi;
    public final zzga zzj;
    public final zzfy zzk;
    public final zzfy zzl;
    public final zzfv zzm;
    public final zzga zzn;
    public final zzfv zzo;
    public final zzfv zzp;
    public final zzfy zzq;
    public final zzfy zzr;
    public boolean zzs;
    public zzfv zzt;
    public zzfv zzu;
    public zzfy zzv;
    public final zzga zzw;
    private SharedPreferences zzy;
    private String zzz;

    final Pair<String, Boolean> zza(String str) {
        zzd();
        long jElapsedRealtime = zzm().elapsedRealtime();
        if (this.zzz != null && jElapsedRealtime < this.zzab) {
            return new Pair<>(this.zzz, Boolean.valueOf(this.zzaa));
        }
        this.zzab = jElapsedRealtime + zzt().zza(str, zzap.zza);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(zzn());
            if (advertisingIdInfo != null) {
                this.zzz = advertisingIdInfo.getId();
                this.zzaa = advertisingIdInfo.isLimitAdTrackingEnabled();
            }
            if (this.zzz == null) {
                this.zzz = "";
            }
        } catch (Exception e) {
            zzr().zzw().zza("Unable to get advertising id", e);
            this.zzz = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(this.zzz, Boolean.valueOf(this.zzaa));
    }

    @Override // com.google.android.gms.measurement.internal.zzhi
    protected final boolean zze() {
        return true;
    }

    final String zzb(String str) {
        zzd();
        String str2 = (String) zza(str).first;
        MessageDigest messageDigestZzi = zzla.zzi();
        if (messageDigestZzi == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, messageDigestZzi.digest(str2.getBytes())));
    }

    zzft(zzgo zzgoVar) {
        super(zzgoVar);
        this.zzc = new zzfy(this, "last_upload", 0L);
        this.zzd = new zzfy(this, "last_upload_attempt", 0L);
        this.zze = new zzfy(this, "backoff", 0L);
        this.zzf = new zzfy(this, "last_delete_stale", 0L);
        this.zzk = new zzfy(this, "time_before_start", 10000L);
        this.zzl = new zzfy(this, "session_timeout", Constants.SESSION_TIMEOUT_MILLIS);
        this.zzm = new zzfv(this, "start_new_session", true);
        this.zzq = new zzfy(this, "last_pause_time", 0L);
        this.zzr = new zzfy(this, "time_active", 0L);
        this.zzn = new zzga(this, "non_personalized_ads", null);
        this.zzo = new zzfv(this, "use_dynamite_api", false);
        this.zzp = new zzfv(this, "allow_remote_dynamite", false);
        this.zzg = new zzfy(this, "midnight_offset", 0L);
        this.zzh = new zzfy(this, "first_open_time", 0L);
        this.zzi = new zzfy(this, "app_install_time", 0L);
        this.zzj = new zzga(this, "app_instance_id", null);
        this.zzt = new zzfv(this, "app_backgrounded", false);
        this.zzu = new zzfv(this, "deep_link_retrieval_complete", false);
        this.zzv = new zzfy(this, "deep_link_retrieval_attempts", 0L);
        this.zzw = new zzga(this, "firebase_feature_rollouts", null);
    }

    @Override // com.google.android.gms.measurement.internal.zzhi
    protected final void f_() {
        SharedPreferences sharedPreferences = zzn().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.zzy = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("has_been_opened", false);
        this.zzs = z;
        if (!z) {
            SharedPreferences.Editor editorEdit = this.zzy.edit();
            editorEdit.putBoolean("has_been_opened", true);
            editorEdit.apply();
        }
        this.zzb = new zzfx(this, "health_monitor", Math.max(0L, zzap.zzb.zza(null).longValue()));
    }

    protected final SharedPreferences zzg() {
        zzd();
        zzaa();
        return this.zzy;
    }

    final void zzc(String str) {
        zzd();
        SharedPreferences.Editor editorEdit = zzg().edit();
        editorEdit.putString("gmp_app_id", str);
        editorEdit.apply();
    }

    final String zzh() {
        zzd();
        return zzg().getString("gmp_app_id", null);
    }

    final void zzd(String str) {
        zzd();
        SharedPreferences.Editor editorEdit = zzg().edit();
        editorEdit.putString("admob_app_id", str);
        editorEdit.apply();
    }

    final String zzi() {
        zzd();
        return zzg().getString("admob_app_id", null);
    }

    final Boolean zzj() {
        zzd();
        if (zzg().contains("use_service")) {
            return Boolean.valueOf(zzg().getBoolean("use_service", false));
        }
        return null;
    }

    final void zza(boolean z) {
        zzd();
        SharedPreferences.Editor editorEdit = zzg().edit();
        editorEdit.putBoolean("use_service", z);
        editorEdit.apply();
    }

    final void zzk() {
        zzd();
        Boolean boolZzv = zzv();
        SharedPreferences.Editor editorEdit = zzg().edit();
        editorEdit.clear();
        editorEdit.apply();
        if (boolZzv != null) {
            zzb(boolZzv.booleanValue());
        }
    }

    final void zzb(boolean z) {
        zzd();
        SharedPreferences.Editor editorEdit = zzg().edit();
        editorEdit.putBoolean("measurement_enabled", z);
        editorEdit.apply();
    }

    final Boolean zzv() {
        zzd();
        if (zzg().contains("measurement_enabled")) {
            return Boolean.valueOf(zzg().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    protected final String zzw() {
        zzd();
        String string = zzg().getString("previous_os_version", null);
        zzl().zzaa();
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str) && !str.equals(string)) {
            SharedPreferences.Editor editorEdit = zzg().edit();
            editorEdit.putString("previous_os_version", str);
            editorEdit.apply();
        }
        return string;
    }

    final void zzc(boolean z) {
        zzd();
        zzr().zzx().zza("App measurement setting deferred collection", Boolean.valueOf(z));
        SharedPreferences.Editor editorEdit = zzg().edit();
        editorEdit.putBoolean("deferred_analytics_collection", z);
        editorEdit.apply();
    }

    final boolean zzx() {
        return this.zzy.contains("deferred_analytics_collection");
    }

    final boolean zza(long j) {
        return j - this.zzl.zza() > this.zzq.zza();
    }
}
