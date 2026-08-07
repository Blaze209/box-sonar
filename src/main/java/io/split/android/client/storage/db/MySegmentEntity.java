package io.split.android.client.storage.db;

/* JADX INFO: loaded from: classes4.dex */
public class MySegmentEntity extends SegmentEntity {
    private static final SegmentEntity.Creator<MySegmentEntity> CREATOR = new SegmentEntity.Creator<MySegmentEntity>() { // from class: io.split.android.client.storage.db.MySegmentEntity.1
        @Override // io.split.android.client.storage.db.SegmentEntity.Creator
        public MySegmentEntity createEntity(String userKey, String segmentList, long updatedAt) {
            MySegmentEntity mySegmentEntity = new MySegmentEntity();
            mySegmentEntity.setUserKey(userKey);
            mySegmentEntity.setSegmentList(segmentList);
            mySegmentEntity.setUpdatedAt(updatedAt);
            return mySegmentEntity;
        }
    };

    public static SegmentEntity.Creator<MySegmentEntity> creator() {
        return CREATOR;
    }
}
