package com.microsoft.identity.common.java.storage;

import com.microsoft.identity.common.java.crypto.IKeyAccessor;
import com.microsoft.identity.common.java.crypto.KeyAccessorStringAdapter;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.interfaces.INameValueStorage;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.java.util.ported.Predicate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes14.dex */
public class EncryptedNameValueStorage<T> implements INameValueStorage<T> {
    private static final String TAG = "EncryptedNameValueStorage";
    private final KeyAccessorStringAdapter mEncryptionManager;
    private final INameValueStorage<String> mRawNameValueStorage;
    private final IGenericTypeStringAdapter<T> mStringAdapter;

    public EncryptedNameValueStorage(INameValueStorage<String> iNameValueStorage, IKeyAccessor iKeyAccessor, IGenericTypeStringAdapter<T> iGenericTypeStringAdapter) {
        if (iNameValueStorage == null) {
            throw new NullPointerException("rawNameValueStringStorage is marked non-null but is null");
        }
        if (iKeyAccessor == null) {
            throw new NullPointerException("encryptionManager is marked non-null but is null");
        }
        if (iGenericTypeStringAdapter == null) {
            throw new NullPointerException("stringAdapter is marked non-null but is null");
        }
        this.mRawNameValueStorage = iNameValueStorage;
        this.mEncryptionManager = new KeyAccessorStringAdapter(iKeyAccessor);
        this.mStringAdapter = iGenericTypeStringAdapter;
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public T get(String str) {
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        String str2 = TAG + ":get";
        String str3 = this.mRawNameValueStorage.get(str);
        if (StringUtil.isNullOrEmpty(str3)) {
            Logger.info(str2, "Data associated to the given key is null or empty", null);
            remove(str);
            return null;
        }
        try {
            return this.mStringAdapter.adapt(this.mEncryptionManager.decrypt(str3));
        } catch (ClientException unused) {
            Logger.error(str2, "Failed to read encrypted value", null);
            return null;
        }
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public Map<String, T> getAll() {
        Map<String, String> all = this.mRawNameValueStorage.getAll();
        HashMap map = new HashMap();
        for (Map.Entry<String, String> entry : all.entrySet()) {
            T t = get(entry.getKey());
            if (t != null) {
                map.put(entry.getKey(), t);
            }
        }
        return map;
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public void put(String str, T t) {
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        String str2 = TAG + ":put";
        String strEncrypt = null;
        if (t == null) {
            this.mRawNameValueStorage.put(str, null);
            return;
        }
        String strAdapt = this.mStringAdapter.adapt(t);
        if (StringUtil.isNullOrEmpty(strAdapt)) {
            this.mRawNameValueStorage.put(str, strAdapt);
            return;
        }
        try {
            strEncrypt = this.mEncryptionManager.encrypt(strAdapt);
        } catch (ClientException unused) {
            Logger.error(str2, "Failed to store encrypted value", null);
        }
        this.mRawNameValueStorage.put(str, strEncrypt);
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public void remove(String str) {
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        this.mRawNameValueStorage.remove(str);
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public void clear() {
        this.mRawNameValueStorage.clear();
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public Set<String> keySet() {
        return this.mRawNameValueStorage.keySet();
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public Iterator<Map.Entry<String, T>> getAllFilteredByKey(Predicate<String> predicate) {
        if (predicate == null) {
            throw new NullPointerException("keyFilter is marked non-null but is null");
        }
        HashMap map = new HashMap();
        for (Map.Entry<String, T> entry : getAll().entrySet()) {
            if (predicate.test(entry.getKey())) {
                map.put(entry.getKey(), entry.getValue());
            }
        }
        return map.entrySet().iterator();
    }
}
