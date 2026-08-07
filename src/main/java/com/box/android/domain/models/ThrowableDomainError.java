package com.box.android.domain.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DomainError.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/domain/models/ThrowableDomainError;", "", "domainError", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getDomainError", "()Lcom/box/android/domain/models/DomainError;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ThrowableDomainError extends Throwable {
    private final DomainError domainError;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThrowableDomainError(DomainError domainError) {
        super(domainError.getMessage());
        Intrinsics.checkNotNullParameter(domainError, "domainError");
        this.domainError = domainError;
    }

    public final DomainError getDomainError() {
        return this.domainError;
    }
}
