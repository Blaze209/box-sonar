package com.microsoft.identity.common.internal.util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.microsoft.identity.common.java.cache.CacheRecord;
import com.microsoft.identity.common.java.cache.ICacheRecord;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes14.dex */
public class ICacheRecordGsonAdapter implements JsonDeserializer<ICacheRecord> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public ICacheRecord deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return (ICacheRecord) jsonDeserializationContext.deserialize(jsonElement, CacheRecord.class);
    }
}
