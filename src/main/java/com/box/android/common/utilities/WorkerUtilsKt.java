package com.box.android.common.utilities;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WorkerUtils.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001¨\u0006\u0003"}, d2 = {"workerNameFix", "", "className", "common_prodRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class WorkerUtilsKt {
    public static final String workerNameFix(String className) {
        Intrinsics.checkNotNullParameter(className, "className");
        return Intrinsics.areEqual(className, "com.box.android.jobmanager.BoxRetryWorker") ? "com.box.android.coreservices.jobmanager.tasks.BoxRetryWorker" : className;
    }
}
