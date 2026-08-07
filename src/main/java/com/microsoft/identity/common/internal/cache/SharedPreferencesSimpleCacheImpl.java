package com.microsoft.identity.common.internal.cache;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.microsoft.identity.common.java.cache.IListTypeToken;
import com.microsoft.identity.common.java.cache.ISimpleCache;
import com.microsoft.identity.common.logging.Logger;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public abstract class SharedPreferencesSimpleCacheImpl<T> implements ISimpleCache<T>, IListTypeToken {
    private static final String EMPTY_ARRAY = "[]";
    private static final String TAG = "SharedPreferencesSimpleCacheImpl";
    private final Gson mGson = new Gson();
    private final String mKeySingleEntry;
    private final SharedPreferences mSharedPrefs;

    public SharedPreferencesSimpleCacheImpl(Context context, String str, String str2) {
        Logger.verbose(TAG + "::constructor", "Init");
        this.mSharedPrefs = context.getSharedPreferences(str, 0);
        this.mKeySingleEntry = str2;
    }

    @Override // com.microsoft.identity.common.java.cache.ISimpleCache
    public boolean insert(T t) {
        String str = TAG + ":insert";
        HashSet hashSet = new HashSet(getAll());
        Logger.verbose(str, "Existing metadata contained [" + hashSet.size() + "] elements.");
        hashSet.add(t);
        Logger.verbose(str, "New metadata set size: [" + hashSet.size() + "]");
        String json = this.mGson.toJson(hashSet);
        Logger.verbose(str, "Writing cache entry.");
        boolean zCommit = this.mSharedPrefs.edit().putString(this.mKeySingleEntry, json).commit();
        if (zCommit) {
            Logger.verbose(str, "Cache successfully updated.");
            return zCommit;
        }
        Logger.warn(str, "Error writing to cache.");
        return zCommit;
    }

    @Override // com.microsoft.identity.common.java.cache.ISimpleCache
    public boolean remove(T t) {
        String str = TAG + ":remove";
        HashSet hashSet = new HashSet(getAll());
        Logger.verbose(str, "Existing metadata contained [" + hashSet.size() + "] elements.");
        boolean zRemove = hashSet.remove(t);
        Logger.verbose(str, "New metadata set size: [" + hashSet.size() + "]");
        if (!zRemove) {
            Logger.warn(str, "Nothing to delete -- cache entry is missing!");
            return true;
        }
        String json = this.mGson.toJson(hashSet);
        Logger.verbose(str, "Writing new cache values...");
        boolean zCommit = this.mSharedPrefs.edit().putString(this.mKeySingleEntry, json).commit();
        Logger.verbose(str, "Updated cache contents written? [" + zCommit + "]");
        return zCommit;
    }

    @Override // com.microsoft.identity.common.java.cache.ISimpleCache
    public List<T> getAll() {
        String str = TAG + ":getAll";
        List<T> list = (List) this.mGson.fromJson(this.mSharedPrefs.getString(this.mKeySingleEntry, "[]"), getListTypeToken());
        Logger.verbose(str, "Found [" + list.size() + "] cache entries.");
        return list;
    }

    @Override // com.microsoft.identity.common.java.cache.ISimpleCache
    public boolean clear() {
        String str = TAG + ":clear";
        boolean zCommit = this.mSharedPrefs.edit().clear().commit();
        if (!zCommit) {
            Logger.warn(str, "Failed to clear cache.");
            return zCommit;
        }
        Logger.verbose(str, "Cache successfully cleared.");
        return zCommit;
    }
}
