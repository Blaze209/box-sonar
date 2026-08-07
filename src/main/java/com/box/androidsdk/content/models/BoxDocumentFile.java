package com.box.androidsdk.content.models;

/* JADX INFO: loaded from: classes13.dex */
public class BoxDocumentFile extends BoxFile {
    public static final String FIELD_CONTENT_SIZE = "content_size";

    public BoxDocumentFile(BoxFile boxFile) {
        createFromJson(boxFile.toJson());
    }

    public BoxDocumentFile setContentLength(long j) {
        set(FIELD_CONTENT_SIZE, Long.valueOf(j));
        return this;
    }

    public Long getContentLength() {
        return getPropertyAsLong(FIELD_CONTENT_SIZE);
    }
}
