package io.split.android.client.storage.db.attributes;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface AttributesDao {
    void deleteAll(String userKey);

    List<AttributesEntity> getAll();

    AttributesEntity getByUserKey(String userKey);

    void update(AttributesEntity attributesEntity);

    void update(String formerUserKey, String userKey, String attributes);
}
