package io.split.android.client.storage.db;

/* JADX INFO: loaded from: classes4.dex */
public class SplitEntity {
    private String body;
    private String name;
    private long rowId;
    private long updatedAt;

    public long getRowId() {
        return this.rowId;
    }

    public void setRowId(long rowId) {
        this.rowId = rowId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }
}
