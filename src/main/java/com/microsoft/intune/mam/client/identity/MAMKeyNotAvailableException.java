package com.microsoft.intune.mam.client.identity;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class MAMKeyNotAvailableException extends IOException {
    public MAMKeyNotAvailableException(Throwable th) {
        super("Cannot decrypt data because this app is not managed and encryption keys are only available to managed apps", th);
    }
}
