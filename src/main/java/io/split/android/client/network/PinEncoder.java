package io.split.android.client.network;

/* JADX INFO: loaded from: classes4.dex */
interface PinEncoder {
    byte[] encodeCertPin(String algorithm, byte[] encodedPublicKey);
}
