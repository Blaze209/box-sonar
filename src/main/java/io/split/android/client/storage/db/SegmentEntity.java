package io.split.android.client.storage.db;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SegmentEntity {
    private String segmentList;
    private long updatedAt;
    private String userKey;

    public interface Creator<T extends SegmentEntity> {
        T createEntity(String userKey, String segmentList, long updatedAt);
    }

    public static Creator<?> creator() {
        return null;
    }

    public String getUserKey() {
        return this.userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public String getSegmentList() {
        return this.segmentList;
    }

    public void setSegmentList(String segmentList) {
        this.segmentList = segmentList;
    }

    public long getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }
}
