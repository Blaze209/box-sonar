package com.box.android.domain.configuration;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IFeatureFlip.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/box/android/domain/configuration/FlippablePreRelease;", "", "key", "", "<init>", "(Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FlippablePreRelease {
    private final String key;

    public static /* synthetic */ FlippablePreRelease copy$default(FlippablePreRelease flippablePreRelease, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = flippablePreRelease.key;
        }
        return flippablePreRelease.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    public final FlippablePreRelease copy(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return new FlippablePreRelease(key);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FlippablePreRelease) && Intrinsics.areEqual(this.key, ((FlippablePreRelease) other).key);
    }

    public int hashCode() {
        return this.key.hashCode();
    }

    public String toString() {
        return "FlippablePreRelease(key=" + this.key + ")";
    }

    public FlippablePreRelease(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.key = key;
    }

    public final String getKey() {
        return this.key;
    }
}
