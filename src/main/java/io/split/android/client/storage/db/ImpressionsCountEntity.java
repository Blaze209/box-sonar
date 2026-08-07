package io.split.android.client.storage.db;

import io.split.android.client.dtos.Identifiable;

/* JADX INFO: loaded from: classes4.dex */
public class ImpressionsCountEntity implements Identifiable {
    private String body;
    private long createdAt;
    private long id;
    private int status;

    @Override // io.split.android.client.dtos.Identifiable
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
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
}
