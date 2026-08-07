package com.box.android.domain.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DomainError.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0007\u001a\u00020\u0002*\u00020\u0002¨\u0006\b"}, d2 = {"isNetworkConnectionError", "", "Lcom/box/android/domain/models/DomainError;", "loggingMessage", "", "isItemNotFoundError", "isAuthError", "unwrapCachedDomainError", "domain_prodRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DomainErrorKt {
    public static final boolean isNetworkConnectionError(DomainError domainError) {
        Intrinsics.checkNotNullParameter(domainError, "<this>");
        return (domainError instanceof DomainError.NetworkError) || (domainError instanceof DomainError.NoConnectivityError);
    }

    public static final String loggingMessage(DomainError domainError) {
        Intrinsics.checkNotNullParameter(domainError, "<this>");
        return domainError.getSimpleClassName() + " " + domainError.getMessage();
    }

    public static final boolean isItemNotFoundError(DomainError domainError) {
        Intrinsics.checkNotNullParameter(domainError, "<this>");
        return (domainError instanceof FileUploadDomainError.SourceOrDestNotFound) || (domainError instanceof DomainError.APINotFoundError) || (domainError instanceof DomainError.NoResultFoundError);
    }

    public static final boolean isAuthError(DomainError domainError) {
        Intrinsics.checkNotNullParameter(domainError, "<this>");
        return (domainError instanceof DomainError.APIAuthError) || (domainError instanceof DomainError.Unauthorized);
    }

    public static final DomainError unwrapCachedDomainError(DomainError domainError) {
        Intrinsics.checkNotNullParameter(domainError, "<this>");
        return domainError instanceof DomainError.CachedDomainError ? ((DomainError.CachedDomainError) domainError).getError() : domainError;
    }
}
