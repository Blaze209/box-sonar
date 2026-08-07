package com.microsoft.identity.common.internal.cache;

import com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage;
import com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public class DefaultMultiTypeNameValueStorageReencrypter implements IMultiTypeNameValueStorageReencrypter {
    @Override // com.microsoft.identity.common.internal.cache.IMultiTypeNameValueStorageReencrypter
    public void reencrypt(IMultiTypeNameValueStorage iMultiTypeNameValueStorage, IMultiTypeNameValueStorageReencrypter.IStringEncrypter iStringEncrypter, IMultiTypeNameValueStorageReencrypter.IStringDecrypter iStringDecrypter, IMultiTypeNameValueStorageReencrypter.ReencryptionParams reencryptionParams) throws Exception {
        for (Map.Entry entry : new HashMap(iMultiTypeNameValueStorage.getAll()).entrySet()) {
            String str = (String) entry.getKey();
            try {
                iMultiTypeNameValueStorage.putString(str, iStringEncrypter.encrypt(iStringDecrypter.decrypt((String) entry.getValue())));
            } catch (Exception e) {
                if (reencryptionParams.eraseEntryOnError()) {
                    iMultiTypeNameValueStorage.remove(str);
                }
                if (reencryptionParams.eraseAllOnError()) {
                    iMultiTypeNameValueStorage.clear();
                    if (reencryptionParams.abortOnError()) {
                        throw e;
                    }
                    return;
                } else if (reencryptionParams.abortOnError()) {
                    throw e;
                }
            }
        }
    }

    @Override // com.microsoft.identity.common.internal.cache.IMultiTypeNameValueStorageReencrypter
    public void reencryptAsync(final IMultiTypeNameValueStorage iMultiTypeNameValueStorage, final IMultiTypeNameValueStorageReencrypter.IStringEncrypter iStringEncrypter, final IMultiTypeNameValueStorageReencrypter.IStringDecrypter iStringDecrypter, final IMultiTypeNameValueStorageReencrypter.ReencryptionParams reencryptionParams, final TaskCompletedCallbackWithError<Void, Exception> taskCompletedCallbackWithError) {
        new Thread(new Runnable() { // from class: com.microsoft.identity.common.internal.cache.DefaultMultiTypeNameValueStorageReencrypter.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    DefaultMultiTypeNameValueStorageReencrypter.this.reencrypt(iMultiTypeNameValueStorage, iStringEncrypter, iStringDecrypter, reencryptionParams);
                    taskCompletedCallbackWithError.onTaskCompleted(null);
                } catch (Exception e) {
                    taskCompletedCallbackWithError.onError(e);
                }
            }
        }).start();
    }
}
