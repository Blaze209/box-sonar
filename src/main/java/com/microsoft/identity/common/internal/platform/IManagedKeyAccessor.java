package com.microsoft.identity.common.internal.platform;

import com.microsoft.identity.common.java.crypto.IKeyAccessor;
import com.microsoft.identity.common.java.crypto.IKeyStoreKeyManager;
import java.security.KeyStore;
import java.security.KeyStore.Entry;

/* JADX INFO: loaded from: classes14.dex */
public interface IManagedKeyAccessor<K extends KeyStore.Entry> extends IKeyAccessor {
    IKeyStoreKeyManager<K> getManager();
}
