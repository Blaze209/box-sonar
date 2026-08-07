package org.apache.hc.core5.http.impl.nio;

import androidx.collection.SieveCacheKt;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import org.apache.hc.core5.http.ConnectionClosedException;
import org.apache.hc.core5.http.impl.BasicHttpTransportMetrics;
import org.apache.hc.core5.http.nio.FileContentDecoder;
import org.apache.hc.core5.http.nio.SessionInputBuffer;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class LengthDelimitedDecoder extends AbstractContentDecoder implements FileContentDecoder {
    private final long contentLength;
    private long len;

    public LengthDelimitedDecoder(ReadableByteChannel readableByteChannel, SessionInputBuffer sessionInputBuffer, BasicHttpTransportMetrics basicHttpTransportMetrics, long j) {
        super(readableByteChannel, sessionInputBuffer, basicHttpTransportMetrics);
        Args.notNegative(j, "Content length");
        this.contentLength = j;
    }

    @Override // org.apache.hc.core5.http.nio.ContentDecoder
    public int read(ByteBuffer byteBuffer) throws IOException {
        int fromChannel;
        Args.notNull(byteBuffer, "Byte buffer");
        if (isCompleted()) {
            return -1;
        }
        int iMin = (int) Math.min(this.contentLength - this.len, SieveCacheKt.NodeLinkMask);
        if (this.buffer.hasData()) {
            fromChannel = this.buffer.read(byteBuffer, Math.min(iMin, this.buffer.length()));
        } else {
            fromChannel = readFromChannel(byteBuffer, iMin);
        }
        if (fromChannel == -1) {
            setCompleted();
            if (this.len < this.contentLength) {
                throw new ConnectionClosedException("Premature end of Content-Length delimited message body (expected: %d; received: %d)", Long.valueOf(this.contentLength), Long.valueOf(this.len));
            }
        }
        long j = this.len + ((long) fromChannel);
        this.len = j;
        if (j >= this.contentLength) {
            this.completed = true;
        }
        if (this.completed && fromChannel == 0) {
            return -1;
        }
        return fromChannel;
    }

    @Override // org.apache.hc.core5.http.nio.FileContentDecoder
    public long transfer(FileChannel fileChannel, long j, long j2) throws IOException {
        long jTransferFrom;
        if (fileChannel == null) {
            return 0L;
        }
        if (isCompleted()) {
            return -1L;
        }
        int iMin = (int) Math.min(this.contentLength - this.len, SieveCacheKt.NodeLinkMask);
        if (this.buffer.hasData()) {
            int iMin2 = Math.min(iMin, this.buffer.length());
            fileChannel.position(j);
            SessionInputBuffer sessionInputBuffer = this.buffer;
            if (j2 < iMin2) {
                iMin2 = (int) j2;
            }
            jTransferFrom = sessionInputBuffer.read(fileChannel, iMin2);
        } else {
            if (!this.channel.isOpen()) {
                jTransferFrom = -1;
            } else {
                if (j > fileChannel.size()) {
                    throw new IOException(String.format("Position past end of file [%d > %d]", Long.valueOf(j), Long.valueOf(fileChannel.size())));
                }
                long j3 = iMin;
                jTransferFrom = fileChannel.transferFrom(this.channel, j, j2 < j3 ? j2 : j3);
            }
            if (jTransferFrom > 0) {
                this.metrics.incrementBytesTransferred(jTransferFrom);
            }
        }
        if (jTransferFrom == -1) {
            setCompleted();
            if (this.len < this.contentLength) {
                throw new ConnectionClosedException("Premature end of Content-Length delimited message body (expected: %d; received: %d)", Long.valueOf(this.contentLength), Long.valueOf(this.len));
            }
        }
        long j4 = this.len + jTransferFrom;
        this.len = j4;
        if (j4 >= this.contentLength) {
            this.completed = true;
        }
        return jTransferFrom;
    }

    public String toString() {
        return "[content length: " + this.contentLength + "; pos: " + this.len + "; completed: " + this.completed + "]";
    }
}
