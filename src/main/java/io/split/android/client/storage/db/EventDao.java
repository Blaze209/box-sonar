package io.split.android.client.storage.db;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface EventDao {
    void delete(List<Long> ids);

    int deleteByStatus(int status, long maxTimestamp, int maxRows);

    void deleteOutdated(long updateAt);

    List<EventEntity> getAll();

    List<EventEntity> getBy(long updateAt, int status, int maxRows);

    void insert(EventEntity event);

    void insert(List<EventEntity> events);

    void updateStatus(List<Long> ids, int status);
}
