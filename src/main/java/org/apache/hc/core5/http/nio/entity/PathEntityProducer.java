package org.apache.hc.core5.http.nio.entity;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
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
public final class PathEntityProducer implements AsyncEntityProducer {
    private static final int BUFFER_SIZE = 8192;
    private final ByteBuffer byteBuffer;
    private final AtomicReference<SeekableByteChannel> channelRef;
    private final boolean chunked;
    private final ContentType contentType;
    private boolean eof;
    private final AtomicReference<Exception> exception;
    private final Path file;
    private final long length;
    private final OpenOption[] openOptions;

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

    public PathEntityProducer(Path path, ContentType contentType, boolean z, OpenOption... openOptionArr) throws IOException {
        this(path, 8192, contentType, z, openOptionArr);
    }

    public PathEntityProducer(Path path, ContentType contentType, OpenOption... openOptionArr) throws IOException {
        this(path, contentType, false, openOptionArr);
    }

    public PathEntityProducer(Path path, int i, ContentType contentType, boolean z, OpenOption... openOptionArr) throws IOException {
        this.file = (Path) Args.notNull(path, "file");
        this.openOptions = openOptionArr;
        this.length = Files.size(path);
        this.byteBuffer = ByteBuffer.allocate(i);
        this.contentType = contentType;
        this.chunked = z;
        this.channelRef = new AtomicReference<>();
        this.exception = new AtomicReference<>();
    }

    public PathEntityProducer(Path path, OpenOption... openOptionArr) throws IOException {
        this(path, ContentType.APPLICATION_OCTET_STREAM, openOptionArr);
    }

    @Override // org.apache.hc.core5.http.nio.AsyncEntityProducer
    public void failed(Exception exc) {
        if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.exception, null, exc)) {
            releaseResources();
        }
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public long getContentLength() {
        return this.length;
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public String getContentType() {
        return Objects.toString(this.contentType, null);
    }

    public Exception getException() {
        return this.exception.get();
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public Set<String> getTrailerNames() {
        return Collections.emptySet();
    }

    @Override // org.apache.hc.core5.http.EntityDetails
    public boolean isChunked() {
        return this.chunked;
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataProducer
    public void produce(DataStreamChannel dataStreamChannel) throws IOException {
        SeekableByteChannel seekableByteChannelNewByteChannel = this.channelRef.get();
        if (seekableByteChannelNewByteChannel == null) {
            seekableByteChannelNewByteChannel = Files.newByteChannel(this.file, this.openOptions);
            Asserts.check(this.channelRef.getAndSet(seekableByteChannelNewByteChannel) == null, "Illegal producer state");
        }
        if (!this.eof && seekableByteChannelNewByteChannel.read(this.byteBuffer) < 0) {
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

    @Override // org.apache.hc.core5.http.nio.ResourceHolder
    public void releaseResources() {
        this.eof = false;
        Closer.closeQuietly(this.channelRef.getAndSet(null));
    }
}
