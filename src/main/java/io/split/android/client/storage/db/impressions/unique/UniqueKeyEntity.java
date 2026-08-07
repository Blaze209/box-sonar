package io.split.android.client.storage.db.impressions.unique;

import io.split.android.client.dtos.Identifiable;

/* JADX INFO: loaded from: classes4.dex */
public class UniqueKeyEntity implements Identifiable {
    private long createdAt;
    private String featureList;
    private long id;
    private int status;
    private String userKey;

    public UniqueKeyEntity() {
    }

    public UniqueKeyEntity(String userKey, String featureList, long createdAt, int status) {
        this.userKey = userKey;
        this.featureList = featureList;
        this.createdAt = createdAt;
        this.status = status;
    }

    public String getUserKey() {
        return this.userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public String getFeatureList() {
        return this.featureList;
    }

    public void setFeatureList(String featureList) {
        this.featureList = featureList;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override // io.split.android.client.dtos.Identifiable
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
