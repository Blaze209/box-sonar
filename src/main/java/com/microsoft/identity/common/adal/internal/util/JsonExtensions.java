package com.microsoft.identity.common.adal.internal.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.microsoft.identity.common.internal.broker.BrokerResult;
import com.microsoft.identity.common.internal.util.ICacheRecordGsonAdapter;
import com.microsoft.identity.common.java.cache.ICacheRecord;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public final class JsonExtensions {
    private JsonExtensions() {
    }

    public static List<ICacheRecord> getICacheRecordListFromJsonString(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ICacheRecord.class, new ICacheRecordGsonAdapter());
        return (List) gsonBuilder.create().fromJson(str, TypeToken.getParameterized(List.class, ICacheRecord.class).getType());
    }

    public static String getJsonStringFromICacheRecordList(List<ICacheRecord> list) {
        return new Gson().toJson(list, TypeToken.getParameterized(List.class, ICacheRecord.class).getType());
    }

    public static BrokerResult getBrokerResultFromJsonString(String str) {
        return (BrokerResult) new GsonBuilder().registerTypeAdapter(ICacheRecord.class, new ICacheRecordGsonAdapter()).create().fromJson(str, BrokerResult.class);
    }
}
