package io.split.android.client.network;

import io.split.android.client.network.AuthenticatedRequest;

/* JADX INFO: loaded from: classes4.dex */
interface Authenticator<T extends AuthenticatedRequest<?>> {
    T authenticate(T request);
}
