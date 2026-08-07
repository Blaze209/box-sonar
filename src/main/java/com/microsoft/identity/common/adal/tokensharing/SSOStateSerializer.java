package com.microsoft.identity.common.adal.tokensharing;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.adal.internal.cache.ADALTokenCacheItem;
import com.microsoft.identity.common.adal.internal.tokensharing.TokenCacheItemSerializationAdapater;
import com.microsoft.identity.common.java.exception.ClientException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class SSOStateSerializer {
    private static final Gson GSON = new GsonBuilder().registerTypeAdapter(ADALTokenCacheItem.class, new TokenCacheItemSerializationAdapater()).create();

    @SerializedName("tokenCacheItems")
    private final List<ADALTokenCacheItem> mTokenCacheItems;

    @SerializedName("version")
    private final int version;

    private int getVersion() {
        return 1;
    }

    private SSOStateSerializer() {
        this.version = 1;
        this.mTokenCacheItems = new ArrayList();
    }

    private SSOStateSerializer(ADALTokenCacheItem aDALTokenCacheItem) {
        this.version = 1;
        ArrayList arrayList = new ArrayList();
        this.mTokenCacheItems = arrayList;
        if (aDALTokenCacheItem == null) {
            throw new IllegalArgumentException("tokenItem is null");
        }
        arrayList.add(aDALTokenCacheItem);
    }

    private ADALTokenCacheItem getTokenItem() throws ClientException {
        List<ADALTokenCacheItem> list = this.mTokenCacheItems;
        if (list == null || list.isEmpty()) {
            throw new ClientException(ClientException.TOKEN_CACHE_ITEM_NOT_FOUND, "There is no token cache item in the SSOStateContainer.");
        }
        return this.mTokenCacheItems.get(0);
    }

    private String internalSerialize() {
        return GSON.toJson(this);
    }

    private ADALTokenCacheItem internalDeserialize(String str) throws ClientException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getInt("version") == getVersion()) {
                return ((SSOStateSerializer) GSON.fromJson(str, SSOStateSerializer.class)).getTokenItem();
            }
            throw new ClientException(ClientException.TOKEN_SHARING_DESERIALIZATION_ERROR, "Fail to deserialize because the blob version is incompatible. The version of the serializedBlob is " + jSONObject.getInt("version") + ". And the target class version is " + getVersion());
        } catch (JsonParseException | JSONException e) {
            throw new ClientException(ClientException.TOKEN_SHARING_DESERIALIZATION_ERROR, e.getMessage());
        }
    }

    public static String serialize(ADALTokenCacheItem aDALTokenCacheItem) {
        return new SSOStateSerializer(aDALTokenCacheItem).internalSerialize();
    }

    public static ADALTokenCacheItem deserialize(String str) throws ClientException {
        return new SSOStateSerializer().internalDeserialize(str);
    }
}
