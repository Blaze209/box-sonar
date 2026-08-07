package com.box.android.data.api.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClientSettingsDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/api/models/JWTAppSettings;", "", "default", "Lcom/box/android/data/api/models/JWTAuthInfo;", "<init>", "(Lcom/box/android/data/api/models/JWTAuthInfo;)V", "getDefault", "()Lcom/box/android/data/api/models/JWTAuthInfo;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class JWTAppSettings {
    private final JWTAuthInfo default;

    public static /* synthetic */ JWTAppSettings copy$default(JWTAppSettings jWTAppSettings, JWTAuthInfo jWTAuthInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            jWTAuthInfo = jWTAppSettings.default;
        }
        return jWTAppSettings.copy(jWTAuthInfo);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final JWTAuthInfo getDefault() {
        return this.default;
    }

    public final JWTAppSettings copy(@Json(name = "default") JWTAuthInfo jWTAuthInfo) {
        Intrinsics.checkNotNullParameter(jWTAuthInfo, "default");
        return new JWTAppSettings(jWTAuthInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof JWTAppSettings) && Intrinsics.areEqual(this.default, ((JWTAppSettings) other).default);
    }

    public int hashCode() {
        return this.default.hashCode();
    }

    public String toString() {
        return "JWTAppSettings(default=" + this.default + ")";
    }

    public JWTAppSettings(@Json(name = "default") JWTAuthInfo jWTAuthInfo) {
        Intrinsics.checkNotNullParameter(jWTAuthInfo, "default");
        this.default = jWTAuthInfo;
    }

    public final JWTAuthInfo getDefault() {
        return this.default;
    }
}
