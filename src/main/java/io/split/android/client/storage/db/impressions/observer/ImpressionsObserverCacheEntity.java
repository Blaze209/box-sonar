package io.split.android.client.storage.db.impressions.observer;

/* JADX INFO: loaded from: classes4.dex */
public class ImpressionsObserverCacheEntity {
    private long createdAt;
    private long hash;
    private long time;

    public ImpressionsObserverCacheEntity() {
    }

    public ImpressionsObserverCacheEntity(long hash, long time, long createdAt) {
        this.hash = hash;
        this.time = time;
        this.createdAt = createdAt;
    }

    public long getHash() {
        return this.hash;
    }

    public void setHash(long hash) {
        this.hash = hash;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }
}
