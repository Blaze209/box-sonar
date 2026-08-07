package org.apache.hc.core5.http.io.entity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class SerializableEntity extends AbstractHttpEntity {
    private final Serializable serializable;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public final long getContentLength() {
        return -1L;
    }

    @Override // org.apache.hc.core5.http.io.entity.AbstractHttpEntity, org.apache.hc.core5.http.HttpEntity
    public final boolean isRepeatable() {
        return true;
    }

    @Override // org.apache.hc.core5.http.HttpEntity
    public final boolean isStreaming() {
        return false;
    }

    public SerializableEntity(Serializable serializable, ContentType contentType, String str) {
        super(contentType, str);
        this.serializable = (Serializable) Args.notNull(serializable, "Source object");
    }

    public SerializableEntity(Serializable serializable, ContentType contentType) {
        this(serializable, contentType, null);
    }

    @Override // org.apache.hc.core5.http.HttpEntity
    public final InputStream getContent() throws IllegalStateException, IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        writeTo(byteArrayOutputStream);
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    @Override // org.apache.hc.core5.http.io.entity.AbstractHttpEntity, org.apache.hc.core5.http.HttpEntity
    public final void writeTo(OutputStream outputStream) throws IOException {
        Args.notNull(outputStream, "Output stream");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(this.serializable);
        objectOutputStream.flush();
    }
}
