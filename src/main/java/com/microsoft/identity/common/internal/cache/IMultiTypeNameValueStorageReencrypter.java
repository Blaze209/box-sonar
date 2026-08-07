package com.microsoft.identity.common.internal.cache;

import com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage;
import com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError;

/* JADX INFO: loaded from: classes14.dex */
@Deprecated
public interface IMultiTypeNameValueStorageReencrypter {

    public interface IStringDecrypter {
        String decrypt(String str) throws Exception;
    }

    public interface IStringEncrypter {
        String encrypt(String str) throws Exception;
    }

    void reencrypt(IMultiTypeNameValueStorage iMultiTypeNameValueStorage, IStringEncrypter iStringEncrypter, IStringDecrypter iStringDecrypter, ReencryptionParams reencryptionParams) throws Exception;

    void reencryptAsync(IMultiTypeNameValueStorage iMultiTypeNameValueStorage, IStringEncrypter iStringEncrypter, IStringDecrypter iStringDecrypter, ReencryptionParams reencryptionParams, TaskCompletedCallbackWithError<Void, Exception> taskCompletedCallbackWithError);

    public static class ReencryptionParams {
        private final boolean mAbortOnError;
        private final boolean mEraseAllOnError;
        private final boolean mEraseEntryOnError;

        public ReencryptionParams(boolean z, boolean z2, boolean z3) {
            this.mAbortOnError = z;
            this.mEraseEntryOnError = z2;
            this.mEraseAllOnError = z3;
        }

        boolean abortOnError() {
            return this.mAbortOnError;
        }

        boolean eraseEntryOnError() {
            return this.mEraseEntryOnError;
        }

        boolean eraseAllOnError() {
            return this.mEraseAllOnError;
        }
    }
}
