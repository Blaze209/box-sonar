package com.microsoft.identity.common.java.eststelemetry;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import com.microsoft.identity.common.java.interfaces.INameValueStorage;
import com.microsoft.identity.common.java.logging.Logger;

/* JADX INFO: loaded from: classes14.dex */
public class LastRequestTelemetryCache implements IRequestTelemetryCache<LastRequestTelemetry> {
    static final String LAST_TELEMETRY_HEADER_STRING_CACHE_KEY = "last_telemetry_header_string";
    static final String LAST_TELEMETRY_OBJECT_CACHE_KEY = "last_telemetry_object";
    static final String LAST_TELEMETRY_SCHEMA_VERSION_CACHE_KEY = "last_telemetry_schema_version";
    private static final String TAG = "LastRequestTelemetryCache";
    private static final Gson mGson = new Gson();
    private final INameValueStorage<String> mStorage;

    public LastRequestTelemetryCache(INameValueStorage<String> iNameValueStorage) {
        if (iNameValueStorage == null) {
            throw new NullPointerException("keyPairStorage is marked non-null but is null");
        }
        String str = TAG;
        Logger.verbose(str, "Init: " + str);
        this.mStorage = iNameValueStorage;
    }

    @Override // com.microsoft.identity.common.java.eststelemetry.IRequestTelemetryCache
    public synchronized LastRequestTelemetry getRequestTelemetryFromCache() {
        try {
            try {
                String str = this.mStorage.get(LAST_TELEMETRY_OBJECT_CACHE_KEY);
                if (str == null) {
                    Logger.info(TAG + ":getRequestTelemetryFromCache", "There is no last request telemetry saved in the cache. Returning NULL");
                    return null;
                }
                LastRequestTelemetry lastRequestTelemetry = (LastRequestTelemetry) mGson.fromJson(str, LastRequestTelemetry.class);
                if (lastRequestTelemetry == null) {
                    Logger.warn(TAG + ":getRequestTelemetryFromCache", "Last Request Telemetry deserialization failed");
                }
                return lastRequestTelemetry;
            } catch (OutOfMemoryError e) {
                this.mStorage.clear();
                throw e;
            }
        } catch (JsonSyntaxException e2) {
            Logger.error(TAG + ":getRequestTelemetryFromCache", "Last Request Telemetry deserialization failed", e2);
            return null;
        }
    }

    @Override // com.microsoft.identity.common.java.eststelemetry.IRequestTelemetryCache
    public void clear() {
        this.mStorage.clear();
    }

    @Override // com.microsoft.identity.common.java.eststelemetry.IRequestTelemetryCache
    public synchronized void saveRequestTelemetryToCache(LastRequestTelemetry lastRequestTelemetry) {
        try {
            if (lastRequestTelemetry == null) {
                throw new NullPointerException("requestTelemetry is marked non-null but is null");
            }
            Logger.verbose(TAG, "Saving Last Request Telemetry to cache...");
            saveRequestTelemetryObjectToCache(lastRequestTelemetry);
            saveTelemetryHeaderStringToCache(lastRequestTelemetry);
            saveTelemetrySchemaVersionToCache(lastRequestTelemetry);
        } catch (Throwable th) {
            throw th;
        }
    }

    private void saveRequestTelemetryObjectToCache(LastRequestTelemetry lastRequestTelemetry) {
        if (lastRequestTelemetry == null) {
            throw new NullPointerException("requestTelemetry is marked non-null but is null");
        }
        saveToTelemetryCache(LAST_TELEMETRY_OBJECT_CACHE_KEY, generateCacheValue(lastRequestTelemetry));
    }

    private void saveTelemetryHeaderStringToCache(LastRequestTelemetry lastRequestTelemetry) {
        if (lastRequestTelemetry == null) {
            throw new NullPointerException("requestTelemetry is marked non-null but is null");
        }
        saveToTelemetryCache(LAST_TELEMETRY_HEADER_STRING_CACHE_KEY, lastRequestTelemetry.getCompleteHeaderString());
    }

    private void saveTelemetrySchemaVersionToCache(LastRequestTelemetry lastRequestTelemetry) {
        if (lastRequestTelemetry == null) {
            throw new NullPointerException("requestTelemetry is marked non-null but is null");
        }
        saveToTelemetryCache(LAST_TELEMETRY_SCHEMA_VERSION_CACHE_KEY, lastRequestTelemetry.getSchemaVersion());
    }

    private void saveToTelemetryCache(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("cacheKey is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("cacheValue is marked non-null but is null");
        }
        this.mStorage.put(str, str2);
    }

    private String generateCacheValue(LastRequestTelemetry lastRequestTelemetry) {
        Gson gson = mGson;
        return gson.toJson((JsonElement) gson.toJsonTree(lastRequestTelemetry).getAsJsonObject());
    }
}
