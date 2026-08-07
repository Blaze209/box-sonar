package com.google.android.gms.measurement.internal;

import com.amplitude.api.AmplitudeClient;
import com.google.android.gms.measurement.AppMeasurement;
import com.j256.ormlite.field.FieldType;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
/* JADX INFO: loaded from: classes11.dex */
public class zzhl {
    public static final String[] zza = {"firebase_last_notification", "first_open_time", "first_visit_time", "last_deep_link_referrer", AmplitudeClient.USER_ID_KEY, "first_open_after_install", "lifetime_user_engagement", "session_user_engagement", "non_personalized_ads", "ga_session_number", "ga_session_id", "last_gclid", "session_number", "session_id"};
    public static final String[] zzb = {AppMeasurement.UserProperty.FIREBASE_LAST_NOTIFICATION, "_fot", "_fvt", "_ldl", FieldType.FOREIGN_ID_FIELD_SUFFIX, "_fi", "_lte", "_se", "_npa", "_sno", "_sid", "_lgclid", "_sno", "_sid"};

    protected zzhl() {
    }

    public static String zza(String str) {
        return zziu.zza(str, zza, zzb);
    }
}
