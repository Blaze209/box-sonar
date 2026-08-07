package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzle;
import com.google.android.gms.internal.measurement.zzlr;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
final class zzim implements Application.ActivityLifecycleCallbacks {
    private final /* synthetic */ zzhp zza;

    private zzim(zzhp zzhpVar) {
        this.zza = zzhpVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [com.google.android.gms.measurement.internal.zzim] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.google.android.gms.measurement.internal.zzhf, com.google.android.gms.measurement.internal.zzhp] */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) throws Throwable {
        zzim zzimVar;
        String str;
        try {
            try {
                this.zza.zzr().zzx().zza("onActivityCreated");
                Intent intent = activity.getIntent();
                if (intent == null) {
                    this.zza.zzi().zza(activity, bundle);
                    return;
                }
                Uri data = intent.getData();
                if (data != null && data.isHierarchical()) {
                    zzimVar = this.zza;
                    zzimVar.zzp();
                    if (zzla.zza(intent)) {
                        str = "gs";
                    } else {
                        str = "auto";
                    }
                    String str2 = str;
                    String queryParameter = data.getQueryParameter("referrer");
                    boolean z = bundle == null;
                    try {
                        if (zzlr.zzb() && zzap.zzcd.zza(null).booleanValue()) {
                            zzim zzimVar2 = this;
                            this.zza.zzq().zza(new zzil(zzimVar2, z, data, str2, queryParameter));
                            zzimVar = zzimVar2;
                        } else {
                            zzim zzimVar3 = this;
                            zzimVar3.zza(z, data, str2, queryParameter);
                            zzimVar = zzimVar3;
                        }
                        zzimVar.zza.zzi().zza(activity, bundle);
                        return;
                    } catch (Exception e) {
                        e = e;
                    }
                }
                this.zza.zzi().zza(activity, bundle);
                return;
            } catch (Throwable th) {
                th = th;
                zzimVar.zza.zzi().zza(activity, bundle);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            zzimVar = this;
        } catch (Throwable th2) {
            th = th2;
            zzimVar = this;
            zzimVar.zza.zzi().zza(activity, bundle);
            throw th;
        }
        zzimVar.zza.zzr().zzf().zza("Throwable caught in onActivityCreated", e);
        zzimVar.zza.zzi().zza(activity, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(boolean z, Uri uri, String str, String str2) {
        Bundle bundleZza;
        Bundle bundleZza2;
        try {
            if (this.zza.zzt().zza(zzap.zzca) || this.zza.zzt().zza(zzap.zzcc) || this.zza.zzt().zza(zzap.zzcb)) {
                zzla zzlaVarZzp = this.zza.zzp();
                if (!TextUtils.isEmpty(str2)) {
                    if (!str2.contains("gclid") && !str2.contains("utm_campaign") && !str2.contains("utm_source") && !str2.contains("utm_medium")) {
                        zzlaVarZzp.zzr().zzw().zza("Activity created with data 'referrer' without required params");
                    } else {
                        String strValueOf = String.valueOf(str2);
                        bundleZza = zzlaVarZzp.zza(Uri.parse(strValueOf.length() != 0 ? "https://google.com/search?".concat(strValueOf) : new String("https://google.com/search?")));
                        if (bundleZza != null) {
                            bundleZza.putString("_cis", "referrer");
                        }
                    }
                }
                bundleZza = null;
            } else {
                bundleZza = null;
            }
            if (z) {
                bundleZza2 = this.zza.zzp().zza(uri);
                if (bundleZza2 != null) {
                    bundleZza2.putString("_cis", "intent");
                    if (this.zza.zzt().zza(zzap.zzca) && !bundleZza2.containsKey("gclid") && bundleZza != null && bundleZza.containsKey("gclid")) {
                        bundleZza2.putString("_cer", String.format("gclid=%s", bundleZza.getString("gclid")));
                    }
                    this.zza.zza(str, "_cmp", bundleZza2);
                }
            } else {
                bundleZza2 = null;
            }
            if (this.zza.zzt().zza(zzap.zzcc) && !this.zza.zzt().zza(zzap.zzcb) && bundleZza != null && bundleZza.containsKey("gclid") && (bundleZza2 == null || !bundleZza2.containsKey("gclid"))) {
                this.zza.zza("auto", "_lgclid", (Object) bundleZza.getString("gclid"), true);
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.zza.zzr().zzw().zza("Activity created with referrer", str2);
            if (this.zza.zzt().zza(zzap.zzcb)) {
                if (bundleZza != null) {
                    this.zza.zza(str, "_cmp", bundleZza);
                } else {
                    this.zza.zzr().zzw().zza("Referrer does not contain valid parameters", str2);
                }
                this.zza.zza("auto", "_ldl", (Object) null, true);
                return;
            }
            if (!str2.contains("gclid") || (!str2.contains("utm_campaign") && !str2.contains("utm_source") && !str2.contains("utm_medium") && !str2.contains("utm_term") && !str2.contains("utm_content"))) {
                this.zza.zzr().zzw().zza("Activity created with data 'referrer' without required params");
            } else {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                this.zza.zza("auto", "_ldl", (Object) str2, true);
            }
        } catch (Exception e) {
            this.zza.zzr().zzf().zza("Throwable caught in handleReferrerForOnActivityCreated", e);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        this.zza.zzi().zzc(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        this.zza.zzi().zzb(activity);
        zzkc zzkcVarZzk = this.zza.zzk();
        zzkcVarZzk.zzq().zza(new zzke(zzkcVarZzk, zzkcVarZzk.zzm().elapsedRealtime()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        if (zzle.zzb() && zzap.zzax.zza(null).booleanValue()) {
            this.zza.zzk().zzab();
            this.zza.zzi().zza(activity);
        } else {
            this.zza.zzi().zza(activity);
            this.zza.zzk().zzab();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zza.zzi().zzb(activity, bundle);
    }

    /* synthetic */ zzim(zzhp zzhpVar, zzhr zzhrVar) {
        this(zzhpVar);
    }
}
