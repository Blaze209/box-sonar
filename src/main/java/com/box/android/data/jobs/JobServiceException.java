package com.box.android.data.jobs;

import com.box.android.domain.models.DomainError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JobService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/box/android/data/jobs/JobServiceException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class JobServiceException extends Exception {
    private final DomainError error;

    public JobServiceException(DomainError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.error = error;
    }

    public final DomainError getError() {
        return this.error;
    }
}
