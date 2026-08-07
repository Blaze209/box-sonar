package com.box.android.data.datasource.errors;

import kotlin.Metadata;

/* JADX INFO: compiled from: RemoteError.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/data/datasource/errors/RequestCancelledError;", "Lcom/box/android/data/datasource/errors/RemoteError;", "<init>", "()V", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RequestCancelledError extends RemoteError {
    public static final RequestCancelledError INSTANCE = new RequestCancelledError();

    private RequestCancelledError() {
        super(-1, null, 2, null);
    }
}
