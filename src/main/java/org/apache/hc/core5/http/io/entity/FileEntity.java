package org.apache.hc.core5.http.io.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class FileEntity extends AbstractHttpEntity {
    private final File file;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }

    @Override // org.apache.hc.core5.http.io.entity.AbstractHttpEntity, org.apache.hc.core5.http.HttpEntity
    public final boolean isRepeatable() {
        return true;
    }

    @Override // org.apache.hc.core5.http.HttpEntity
    public final boolean isStreaming() {
        return false;
    }

    public FileEntity(File file, ContentType contentType, String str) {
        super(contentType, str);
        this.file = (File) Args.notNull(file, "File");
    }

    public FileEntity(File file, ContentType contentType) {
        super(contentType, (String) null);
        this.file = (File) Args.notNull(file, "File");
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public final long getContentLength() {
        return this.file.length();
    }

    @Override // org.apache.hc.core5.http.HttpEntity
    public final InputStream getContent() throws IOException {
        return new FileInputStream(this.file);
    }
}
