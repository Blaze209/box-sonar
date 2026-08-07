package com.nimbusds.jose;

/* JADX INFO: loaded from: classes3.dex */
public interface PayloadTransformer<T> {
    T transform(Payload payload);
}
