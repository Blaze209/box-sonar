package org.apache.hc.core5.http.io.entity;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class PathEntity extends AbstractHttpEntity {
    private final Path path;

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

    public PathEntity(Path path, ContentType contentType, String str) {
        super(contentType, str);
        this.path = (Path) Args.notNull(path, "Path");
    }

    public PathEntity(Path path, ContentType contentType) {
        super(contentType, (String) null);
        this.path = (Path) Args.notNull(path, "Path");
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public final long getContentLength() {
        try {
            return Files.size(this.path);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // org.apache.hc.core5.http.HttpEntity
    public final InputStream getContent() throws IOException {
        return Files.newInputStream(this.path, new OpenOption[0]);
    }
}
