package io.split.android.client.storage.cipher;

import io.split.android.client.utils.Base64Util;
import io.split.android.client.utils.logger.Logger;
import java.nio.charset.Charset;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes4.dex */
public class CBCCipher implements SplitCipher {
    private static final Charset CHARSET = Charset.forName("UTF-8");
    private final CipherProvider mCipherProvider;

    public CBCCipher(String apiKey) {
        this(new CBCCipherProvider(apiKey));
    }

    public CBCCipher(CipherProvider cipherProvider) {
        this.mCipherProvider = cipherProvider;
    }

    @Override // io.split.android.client.storage.cipher.SplitCipher
    public String encrypt(String data) {
        if (data == null) {
            return null;
        }
        Cipher encryptionCipher = this.mCipherProvider.getEncryptionCipher();
        try {
            return Base64Util.encode(encryptionCipher.doFinal(data.getBytes(CHARSET)));
        } catch (Exception e) {
            Logger.e("Error encrypting data: " + e.getMessage());
            return null;
        } finally {
            this.mCipherProvider.release(encryptionCipher);
        }
    }

    @Override // io.split.android.client.storage.cipher.SplitCipher
    public String decrypt(String data) {
        if (data == null) {
            return null;
        }
        Cipher decryptionCipher = this.mCipherProvider.getDecryptionCipher();
        try {
            return new String(decryptionCipher.doFinal(Base64Util.bytesDecode(data)), CHARSET);
        } catch (Exception e) {
            Logger.e("Error decrypting data for source: " + data + " - " + e.getMessage());
            return null;
        } finally {
            this.mCipherProvider.release(decryptionCipher);
        }
    }
}
