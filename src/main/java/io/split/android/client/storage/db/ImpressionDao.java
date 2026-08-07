package io.split.android.client.storage.db;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface ImpressionDao {
    void delete(List<Long> ids);

    int deleteByStatus(int status, long maxTimestamp, int maxRows);

    void deleteOutdated(long timestamp);

    List<ImpressionEntity> getAll();

    List<ImpressionEntity> getBy(long timestamp, int status, int maxRows);

    void insert(ImpressionEntity impression);

    void insert(List<ImpressionEntity> impressions);

    void updateStatus(List<Long> ids, int status);
}
