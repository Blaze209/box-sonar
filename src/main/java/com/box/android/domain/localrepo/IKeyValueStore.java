package com.box.android.domain.localrepo;

import com.box.android.domain.models.IBoxPersistableObject;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxEntity;
import com.box.androidsdk.content.models.BoxJsonObject;
import com.eclipsesource.json.JsonObject;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public interface IKeyValueStore {

    public interface KeyNamer {
        String getBoxObjectKey(String str, String str2);

        String getId(String str);

        String getKey(BoxEntity boxEntity);

        String getKey(String str, String str2, String str3);

        String getLocalKey(String str, String str2);

        String getType(String str);

        boolean isBoxItem(String str);

        boolean isLocalItem(String str);
    }

    void clear();

    void clearAllByScheme(String str);

    void delete(String str);

    void destroy();

    boolean getBoolean(String str, boolean z);

    BoxJsonObject getBoxJsonObject(String str);

    BoxJsonObject getBoxJsonObject(String str, String str2);

    <T> T getBoxObject(String str, String str2, String str3, Class<T> cls);

    IBoxPersistableObject getBoxPersistableObject(String str);

    JsonObject getJsonObject(String str);

    JsonObject getJsonObject(String str, String str2);

    IBoxPersistableObject getLocalMetadataForObject(String str, String str2);

    long getLong(String str, long j);

    String getString(String str);

    boolean hasDB();

    KeyNamer keyNamer();

    void precacheTypedIds(List<String> list);

    void put(BoxEntity boxEntity);

    void put(String str, long j);

    void put(String str, String str2);

    void put(String str, boolean z);

    void saveLocalMetadata(IBoxPersistableObject iBoxPersistableObject) throws BoxException;
}
