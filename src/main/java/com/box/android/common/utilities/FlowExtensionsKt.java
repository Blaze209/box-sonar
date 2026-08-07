package com.box.android.common.utilities;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: FlowExtensions.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002¨\u0006\u0003"}, d2 = {"cancelIfActive", "", "Lkotlinx/coroutines/Job;", "common_prodRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FlowExtensionsKt {
    public static final void cancelIfActive(Job job) {
        if (job == null || !job.isActive()) {
            return;
        }
        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
    }
}
