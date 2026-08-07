package io.split.android.client.storage.cipher;

/* JADX INFO: loaded from: classes4.dex */
public class NoOpCipher implements SplitCipher {
    @Override // io.split.android.client.storage.cipher.SplitCipher
    public String decrypt(String data) {
        return data;
    }

    @Override // io.split.android.client.storage.cipher.SplitCipher
    public String encrypt(String data) {
        return data;
    }
}
