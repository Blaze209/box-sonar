package com.box.android.coreservices.observability.appstart;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;

/* JADX INFO: compiled from: AppStartType.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/box/android/coreservices/observability/appstart/ColdStartTime;", "", "processStartedTimeMillis", "", "classLoaderStartedTimeMillis", "<init>", "(JJ)V", "getProcessStartedTimeMillis", "()J", "getClassLoaderStartedTimeMillis", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ColdStartTime {
    private final long classLoaderStartedTimeMillis;
    private final long processStartedTimeMillis;

    public static /* synthetic */ ColdStartTime copy$default(ColdStartTime coldStartTime, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = coldStartTime.processStartedTimeMillis;
        }
        if ((i & 2) != 0) {
            j2 = coldStartTime.classLoaderStartedTimeMillis;
        }
        return coldStartTime.copy(j, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getProcessStartedTimeMillis() {
        return this.processStartedTimeMillis;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getClassLoaderStartedTimeMillis() {
        return this.classLoaderStartedTimeMillis;
    }

    public final ColdStartTime copy(long processStartedTimeMillis, long classLoaderStartedTimeMillis) {
        return new ColdStartTime(processStartedTimeMillis, classLoaderStartedTimeMillis);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ColdStartTime)) {
            return false;
        }
        ColdStartTime coldStartTime = (ColdStartTime) other;
        return this.processStartedTimeMillis == coldStartTime.processStartedTimeMillis && this.classLoaderStartedTimeMillis == coldStartTime.classLoaderStartedTimeMillis;
    }

    public int hashCode() {
        return (Long.hashCode(this.processStartedTimeMillis) * 31) + Long.hashCode(this.classLoaderStartedTimeMillis);
    }

    public String toString() {
        return "ColdStartTime(processStartedTimeMillis=" + this.processStartedTimeMillis + ", classLoaderStartedTimeMillis=" + this.classLoaderStartedTimeMillis + ")";
    }

    public ColdStartTime(long j, long j2) {
        this.processStartedTimeMillis = j;
        this.classLoaderStartedTimeMillis = j2;
    }

    public final long getClassLoaderStartedTimeMillis() {
        return this.classLoaderStartedTimeMillis;
    }

    public final long getProcessStartedTimeMillis() {
        return this.processStartedTimeMillis;
    }
}
