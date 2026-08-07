package com.microsoft.identity.common.crypto;

import android.content.Context;
import com.microsoft.identity.common.adal.internal.AuthenticationSettings;
import com.microsoft.identity.common.java.crypto.StorageEncryptionManager;
import com.microsoft.identity.common.java.crypto.key.ISecretKeyProvider;
import com.microsoft.identity.common.java.crypto.key.PredefinedKeyProvider;
import com.microsoft.identity.common.logging.Logger;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public class AndroidAuthSdkStorageEncryptionManager extends StorageEncryptionManager {
    private static final String TAG = "AndroidAuthSdkStorageEncryptionManager";
    public static final String WRAPPED_KEY_FILE_NAME = "adalks";
    public static final String WRAPPING_KEY_ALIAS = "AdalKey";
    private final ISecretKeyProvider mKeyStoreKeyProvider;
    private final PredefinedKeyProvider mPredefinedKeyProvider;

    public AndroidAuthSdkStorageEncryptionManager(Context context) {
        if (context == null) {
            throw new NullPointerException("context is marked non-null but is null");
        }
        if (AuthenticationSettings.INSTANCE.getSecretKeyData() == null) {
            this.mPredefinedKeyProvider = null;
        } else {
            this.mPredefinedKeyProvider = new PredefinedKeyProvider("USER_DEFINED_KEY", AuthenticationSettings.INSTANCE.getSecretKeyData());
        }
        this.mKeyStoreKeyProvider = KeyStoreBackedSecretKeyProviderFactory.INSTANCE.create(WRAPPING_KEY_ALIAS, WRAPPED_KEY_FILE_NAME, context);
    }

    @Override // com.microsoft.identity.common.java.crypto.StorageEncryptionManager
    public ISecretKeyProvider getKeyProviderForEncryption() {
        PredefinedKeyProvider predefinedKeyProvider = this.mPredefinedKeyProvider;
        return predefinedKeyProvider != null ? predefinedKeyProvider : this.mKeyStoreKeyProvider;
    }

    @Override // com.microsoft.identity.common.java.crypto.StorageEncryptionManager
    public List<ISecretKeyProvider> getKeyProviderForDecryption(byte[] bArr) {
        String str = TAG + ":getKeyLoaderForDecryption";
        String keyIdentifierFromCipherText = getKeyIdentifierFromCipherText(bArr);
        if (PredefinedKeyProvider.USER_PROVIDED_KEY_IDENTIFIER.equalsIgnoreCase(keyIdentifierFromCipherText)) {
            PredefinedKeyProvider predefinedKeyProvider = this.mPredefinedKeyProvider;
            if (predefinedKeyProvider != null) {
                return Collections.singletonList(predefinedKeyProvider);
            }
            throw new IllegalStateException("Cipher Text is encrypted by USER_PROVIDED_KEY_IDENTIFIER, but mPredefinedKeyProvider is null.");
        }
        if (this.mKeyStoreKeyProvider.getKeyTypeIdentifier().equalsIgnoreCase(keyIdentifierFromCipherText)) {
            return Collections.singletonList(this.mKeyStoreKeyProvider);
        }
        Logger.warn(str, "Cannot find a matching key to decrypt the given blob. Key Identifier = " + keyIdentifierFromCipherText);
        return Collections.emptyList();
    }
}
