package io.split.android.client.storage.db;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface ImpressionsCountDao {
    void delete(List<Long> ids);

    int deleteByStatus(int status, long maxTimestamp, int maxRows);

    void deleteOutdated(long timestamp);

    List<ImpressionsCountEntity> getAll();

    List<ImpressionsCountEntity> getBy(long timestamp, int status, int maxRows);

    void insert(ImpressionsCountEntity count);

    void insert(List<ImpressionsCountEntity> counts);

    void updateStatus(List<Long> ids, int status);
}
