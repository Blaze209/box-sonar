package io.split.android.client.storage.db.rbs;

/* JADX INFO: loaded from: classes4.dex */
public class RuleBasedSegmentEntity {
    private String body;
    private String name;
    private long updatedAt;

    public RuleBasedSegmentEntity() {
    }

    public RuleBasedSegmentEntity(String name, String body, long updatedAt) {
        this.name = name;
        this.body = body;
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return this.name;
    }

    public String getBody() {
        return this.body;
    }

    public long getUpdatedAt() {
        return this.updatedAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }
}
