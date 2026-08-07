package org.apache.hc.core5.http.impl.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.List;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.impl.BasicHttpTransportMetrics;
import org.apache.hc.core5.http.nio.ContentDecoder;
import org.apache.hc.core5.http.nio.SessionInputBuffer;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractContentDecoder implements ContentDecoder {
    final SessionInputBuffer buffer;
    final ReadableByteChannel channel;
    protected boolean completed;
    final BasicHttpTransportMetrics metrics;

    @Override // org.apache.hc.core5.http.nio.ContentDecoder
    public List<? extends Header> getTrailers() {
        return null;
    }

    public AbstractContentDecoder(ReadableByteChannel readableByteChannel, SessionInputBuffer sessionInputBuffer, BasicHttpTransportMetrics basicHttpTransportMetrics) {
        Args.notNull(readableByteChannel, "Channel");
        Args.notNull(sessionInputBuffer, "Session input buffer");
        Args.notNull(basicHttpTransportMetrics, "Transport metrics");
        this.buffer = sessionInputBuffer;
        this.channel = readableByteChannel;
        this.metrics = basicHttpTransportMetrics;
    }

    protected ReadableByteChannel channel() {
        return this.channel;
    }

    protected SessionInputBuffer buffer() {
        return this.buffer;
    }

    protected BasicHttpTransportMetrics metrics() {
        return this.metrics;
    }

    @Override // org.apache.hc.core5.http.nio.ContentDecoder
    public boolean isCompleted() {
        return this.completed;
    }

    public void setCompleted(boolean z) {
        this.completed = z;
    }

    protected void setCompleted() {
        this.completed = true;
    }

    protected int readFromChannel(ByteBuffer byteBuffer) throws IOException {
        int i = this.channel.read(byteBuffer);
        if (i > 0) {
            this.metrics.incrementBytesTransferred(i);
        }
        return i;
    }

    protected int fillBufferFromChannel() throws IOException {
        int iFill = this.buffer.fill(this.channel);
        if (iFill > 0) {
            this.metrics.incrementBytesTransferred(iFill);
        }
        return iFill;
    }

    protected int readFromChannel(ByteBuffer byteBuffer, int i) throws IOException {
        int i2;
        if (byteBuffer.remaining() > i) {
            int iLimit = byteBuffer.limit();
            byteBuffer.limit(iLimit - (byteBuffer.remaining() - i));
            i2 = this.channel.read(byteBuffer);
            byteBuffer.limit(iLimit);
        } else {
            i2 = this.channel.read(byteBuffer);
        }
        if (i2 > 0) {
            this.metrics.incrementBytesTransferred(i2);
        }
        return i2;
    }
}
