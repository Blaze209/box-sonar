package io.split.android.client.storage.db.attributes;

/* JADX INFO: loaded from: classes4.dex */
public class AttributesEntity {
    private String attributes;
    private long updatedAt;
    private String userKey;

    public AttributesEntity() {
    }

    public AttributesEntity(String userKey, String attributes, long updatedAt) {
        this.userKey = userKey;
        this.attributes = attributes;
        this.updatedAt = updatedAt;
    }

    public String getUserKey() {
        return this.userKey;
    }

    public String getAttributes() {
        return this.attributes;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public long getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }
}
