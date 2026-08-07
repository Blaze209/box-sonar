package com.microsoft.identity.common;

import android.content.Context;
import com.microsoft.identity.common.internal.cache.SharedPreferencesFileManager;
import com.microsoft.identity.common.internal.util.AbstractSharedPrefNameValueStorage;
import com.microsoft.identity.common.java.util.ported.Predicate;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes14.dex */
public class SharedPreferenceStringStorage extends AbstractSharedPrefNameValueStorage<String> {
    public SharedPreferenceStringStorage(Context context, String str) {
        super(SharedPreferencesFileManager.getSharedPreferences(context, str, null));
        if (context == null) {
            throw new NullPointerException("context is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("sharedPrefFileName is marked non-null but is null");
        }
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public String get(String str) {
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        return this.mManager.getString(str);
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public Iterator<Map.Entry<String, String>> getAllFilteredByKey(Predicate<String> predicate) {
        return this.mManager.getAllFilteredByKey(predicate);
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public Map<String, String> getAll() {
        return this.mManager.getAll();
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public void put(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        this.mManager.putString(str, str2);
    }
}
