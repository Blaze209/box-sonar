package io.split.android.client.network;

/* JADX INFO: loaded from: classes4.dex */
public interface BaseHttpResponse {
    int getHttpStatus();

    boolean isBadRequestError();

    boolean isClientRelatedError();

    boolean isCredentialsError();

    boolean isSuccess();
}
