package io.split.android.client.storage.db;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface MyLargeSegmentDao extends SegmentDao<MyLargeSegmentEntity> {
    public static final String TABLE_NAME = "my_large_segments";

    @Override // io.split.android.client.storage.db.SegmentDao
    List<MyLargeSegmentEntity> getAll();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.split.android.client.storage.db.SegmentDao
    MyLargeSegmentEntity getByUserKey(String userKey);

    @Override // io.split.android.client.storage.db.SegmentDao
    void update(MyLargeSegmentEntity mySegment);

    @Override // io.split.android.client.storage.db.SegmentDao
    void update(String formerUserKey, String userKey, String segmentList);
}
