package io.split.android.client.storage.db;

/* JADX INFO: loaded from: classes4.dex */
public class MyLargeSegmentEntity extends SegmentEntity {
    public static final SegmentEntity.Creator<MyLargeSegmentEntity> CREATOR = new SegmentEntity.Creator<MyLargeSegmentEntity>() { // from class: io.split.android.client.storage.db.MyLargeSegmentEntity.1
        @Override // io.split.android.client.storage.db.SegmentEntity.Creator
        public MyLargeSegmentEntity createEntity(String userKey, String segmentList, long updatedAt) {
            MyLargeSegmentEntity myLargeSegmentEntity = new MyLargeSegmentEntity();
            myLargeSegmentEntity.setUserKey(userKey);
            myLargeSegmentEntity.setSegmentList(segmentList);
            myLargeSegmentEntity.setUpdatedAt(updatedAt);
            return myLargeSegmentEntity;
        }
    };

    public static SegmentEntity.Creator<MyLargeSegmentEntity> creator() {
        return CREATOR;
    }
}
