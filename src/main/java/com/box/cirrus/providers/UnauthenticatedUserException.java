package com.box.cirrus.providers;

import kotlin.Metadata;

/* JADX INFO: compiled from: BoxAuthProvider.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/box/cirrus/providers/UnauthenticatedUserException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "()V", "cirrus_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UnauthenticatedUserException extends Exception {
    public UnauthenticatedUserException() {
        super("User not authenticated");
    }
}
