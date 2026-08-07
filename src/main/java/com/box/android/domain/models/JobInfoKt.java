package com.box.android.domain.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JobInfo.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"progressInPercents", "", "Lcom/box/android/domain/models/JobInfo$Progress;", "domain_prodRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class JobInfoKt {
    public static final float progressInPercents(JobInfo.Progress progress) {
        Intrinsics.checkNotNullParameter(progress, "<this>");
        if (progress.getEstimatedTotal() > 0.0d) {
            return (float) (progress.getDone() / progress.getEstimatedTotal());
        }
        return 0.0f;
    }
}
