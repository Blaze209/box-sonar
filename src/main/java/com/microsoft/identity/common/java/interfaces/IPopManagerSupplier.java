package com.microsoft.identity.common.java.interfaces;

import com.microsoft.identity.common.java.crypto.IDevicePopManager;
import com.microsoft.identity.common.java.exception.ClientException;

/* JADX INFO: loaded from: classes14.dex */
public interface IPopManagerSupplier {
    IDevicePopManager getDevicePopManager(String str) throws ClientException;

    default IDevicePopManager getDefaultDevicePopManager() throws ClientException {
        return getDevicePopManager(null);
    }
}
