package com.google.api.client.util.store;

import java.io.IOException;
import java.io.Serializable;

/* JADX INFO: loaded from: classes10.dex */
public interface DataStoreFactory {
    <V extends Serializable> DataStore<V> getDataStore(String str) throws IOException;
}
