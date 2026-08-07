package io.split.android.client.storage.db;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface MySegmentDao extends SegmentDao<MySegmentEntity> {
    public static final String TABLE_NAME = "my_segments";

    @Override // io.split.android.client.storage.db.SegmentDao
    List<MySegmentEntity> getAll();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.split.android.client.storage.db.SegmentDao
    MySegmentEntity getByUserKey(String userKey);

    @Override // io.split.android.client.storage.db.SegmentDao
    void update(MySegmentEntity mySegment);

    @Override // io.split.android.client.storage.db.SegmentDao
    void update(String formerUserKey, String userKey, String segmentList);
}
