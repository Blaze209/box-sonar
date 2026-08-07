package com.pspdfkit.document.library;

/* JADX INFO: loaded from: classes3.dex */
public class LibraryIndexStatus {
    private final Status indexStatus;
    private final float progress;

    public enum Status {
        UNKNOWN,
        QUEUED,
        PARTIAL,
        PARTIAL_AND_INDEXING,
        FINISHED
    }

    public LibraryIndexStatus(Status status, float f) {
        this.indexStatus = status;
        this.progress = f;
    }

    public Status getIndexStatus() {
        return this.indexStatus;
    }

    public float getProgress() {
        return this.progress;
    }
}
