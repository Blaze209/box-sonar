package com.box.android.coreservices.observability.appstart.helpers;

import android.os.Process;
import android.os.SystemClock;
import com.box.android.coreservices.observability.appstart.ColdStartTime;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;

/* JADX INFO: compiled from: ColdStartCalculation.kt */
/* JADX INFO: loaded from: classes9.dex */
@Singleton
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"Lcom/box/android/coreservices/observability/appstart/helpers/ColdStartCalculation;", "", "<init>", "()V", "calculateTime", "Lcom/box/android/coreservices/observability/appstart/ColdStartTime;", "Companion", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ColdStartCalculation {
    private static final long PROCESS_START_DURATION_LIMIT_MILLIS = 60000;

    @Inject
    public ColdStartCalculation() {
    }

    public final ColdStartTime calculateTime() {
        long classLoaderStartedTimeMillis = ClassLoaderListener.INSTANCE.getClassLoaderStartedTimeMillis();
        long jUptimeMillis = SystemClock.uptimeMillis() - Process.getStartUptimeMillis();
        return new ColdStartTime(jUptimeMillis > 60000 ? classLoaderStartedTimeMillis : System.currentTimeMillis() - jUptimeMillis, classLoaderStartedTimeMillis);
    }
}
