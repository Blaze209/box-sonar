package org.apache.hc.core5.http.nio.entity;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.nio.AsyncEntityProducer;
import org.apache.hc.core5.http.nio.DataStreamChannel;
import org.apache.hc.core5.io.Closer;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.Asserts;

/* JADX INFO: loaded from: classes5.dex */
public final class FileEntityProducer implements AsyncEntityProducer {
    private final AtomicReference<RandomAccessFile> accessFileRef;
    private final ByteBuffer byteBuffer;
    private final boolean chunked;
    private final ContentType contentType;
    private boolean eof;
    private final AtomicReference<Exception> exception;
    private final File file;
    private final long length;

    @Override // org.apache.hc.core5.http.nio.AsyncDataProducer
    public int available() {
        return Integer.MAX_VALUE;
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public String getContentEncoding() {
        return null;
    }

    @Override // org.apache.hc.core5.http.nio.AsyncEntityProducer
    public boolean isRepeatable() {
        return true;
    }

    public FileEntityProducer(File file, int i, ContentType contentType, boolean z) {
        this.file = (File) Args.notNull(file, "File");
        this.length = file.length();
        this.byteBuffer = ByteBuffer.allocate(i);
        this.contentType = contentType;
        this.chunked = z;
        this.accessFileRef = new AtomicReference<>();
        this.exception = new AtomicReference<>();
    }

    public FileEntityProducer(File file, ContentType contentType, boolean z) {
        this(file, 8192, contentType, z);
    }

    public FileEntityProducer(File file, ContentType contentType) {
        this(file, contentType, false);
    }

    public FileEntityProducer(File file) {
        this(file, ContentType.APPLICATION_OCTET_STREAM);
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public String getContentType() {
        return Objects.toString(this.contentType, null);
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public long getContentLength() {
        return this.length;
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public boolean isChunked() {
        return this.chunked;
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public Set<String> getTrailerNames() {
        return Collections.emptySet();
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataProducer
    public void produce(DataStreamChannel dataStreamChannel) throws IOException {
        RandomAccessFile randomAccessFile = this.accessFileRef.get();
        if (randomAccessFile == null) {
            randomAccessFile = new RandomAccessFile(this.file, "r");
            Asserts.check(this.accessFileRef.getAndSet(randomAccessFile) == null, "Illegal producer state");
        }
        if (!this.eof && randomAccessFile.getChannel().read(this.byteBuffer) < 0) {
            this.eof = true;
        }
        if (this.byteBuffer.position() > 0) {
            this.byteBuffer.flip();
            dataStreamChannel.write(this.byteBuffer);
            this.byteBuffer.compact();
        }
        if (this.eof && this.byteBuffer.position() == 0) {
            dataStreamChannel.endStream();
            releaseResources();
        }
    }

    @Override // org.apache.hc.core5.http.nio.AsyncEntityProducer
    public void failed(Exception exc) {
        if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.exception, null, exc)) {
            releaseResources();
        }
    }

    public Exception getException() {
        return this.exception.get();
    }

    @Override // org.apache.hc.core5.http.nio.ResourceHolder
    public void releaseResources() {
        this.eof = false;
        Closer.closeQuietly(this.accessFileRef.getAndSet(null));
    }
}
