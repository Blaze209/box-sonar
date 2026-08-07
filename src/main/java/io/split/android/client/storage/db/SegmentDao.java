package io.split.android.client.storage.db;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface SegmentDao<T> {
    List<T> getAll();

    T getByUserKey(String userKey);

    void update(T mySegment);

    void update(String formerUserKey, String userKey, String segmentList);
}
