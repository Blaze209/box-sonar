package io.split.android.client.storage.db.impressions.unique;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface UniqueKeysDao {
    void delete(List<String> userKeys);

    void deleteById(List<Long> ids);

    int deleteByStatus(int status, long maxTimestamp, int maxRows);

    void deleteOutdated(long beforeTimestamp);

    List<UniqueKeyEntity> getAll();

    List<UniqueKeyEntity> getBy(long fromTimestamp, int status, int maxRows);

    long insert(UniqueKeyEntity uniqueKeyEntity);

    List<Long> insert(List<UniqueKeyEntity> uniqueKeyEntityList);

    void updateStatus(List<Long> ids, int status);
}
