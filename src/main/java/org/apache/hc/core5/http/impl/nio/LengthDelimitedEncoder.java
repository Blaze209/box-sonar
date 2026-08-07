package org.apache.hc.core5.http.impl.nio;

import androidx.collection.SieveCacheKt;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import org.apache.hc.core5.http.impl.BasicHttpTransportMetrics;
import org.apache.hc.core5.http.nio.FileContentEncoder;
import org.apache.hc.core5.http.nio.SessionOutputBuffer;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class LengthDelimitedEncoder extends AbstractContentEncoder implements FileContentEncoder {
    private final long contentLength;
    private final int fragHint;
    private long remaining;

    public LengthDelimitedEncoder(WritableByteChannel writableByteChannel, SessionOutputBuffer sessionOutputBuffer, BasicHttpTransportMetrics basicHttpTransportMetrics, long j, int i) {
        super(writableByteChannel, sessionOutputBuffer, basicHttpTransportMetrics);
        Args.notNegative(j, "Content length");
        this.contentLength = j;
        this.fragHint = Math.max(i, 0);
        this.remaining = j;
    }

    public LengthDelimitedEncoder(WritableByteChannel writableByteChannel, SessionOutputBuffer sessionOutputBuffer, BasicHttpTransportMetrics basicHttpTransportMetrics, long j) {
        this(writableByteChannel, sessionOutputBuffer, basicHttpTransportMetrics, j, 0);
    }

    private int nextChunk(ByteBuffer byteBuffer) {
        return (int) Math.min(Math.min(this.remaining, SieveCacheKt.NodeLinkMask), byteBuffer.remaining());
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0060  */
    @Override // org.apache.hc.core5.http.nio.ContentEncoder
    public int write(ByteBuffer byteBuffer) throws IOException {
        int iNextChunk;
        int i;
        int length;
        int iNextChunk2;
        int i2 = 0;
        if (byteBuffer == null) {
            return 0;
        }
        assertNotCompleted();
        while (byteBuffer.hasRemaining() && this.remaining > 0) {
            if ((this.buffer.hasData() || this.fragHint > 0) && (iNextChunk = nextChunk(byteBuffer)) <= (i = this.fragHint) && (length = i - this.buffer.length()) > 0) {
                int iWriteToBuffer = writeToBuffer(byteBuffer, Math.min(length, iNextChunk));
                this.remaining -= (long) iWriteToBuffer;
                i2 += iWriteToBuffer;
            }
            if (this.buffer.hasData()) {
                int iNextChunk3 = nextChunk(byteBuffer);
                if ((this.buffer.length() >= this.fragHint || iNextChunk3 > 0) && flushToChannel() == 0) {
                    break;
                }
                if (this.buffer.hasData() && (iNextChunk2 = nextChunk(byteBuffer)) > this.fragHint) {
                    int iWriteToChannel = writeToChannel(byteBuffer, iNextChunk2);
                    this.remaining -= (long) iWriteToChannel;
                    i2 += iWriteToChannel;
                    if (iWriteToChannel == 0) {
                        break;
                    }
                }
            } else if (this.buffer.hasData()) {
            }
        }
        if (this.remaining <= 0) {
            super.complete(null);
        }
        return i2;
    }

    @Override // org.apache.hc.core5.http.nio.FileContentEncoder
    public long transfer(FileChannel fileChannel, long j, long j2) throws IOException {
        if (fileChannel == null) {
            return 0L;
        }
        assertNotCompleted();
        flushToChannel();
        if (this.buffer.hasData()) {
            return 0L;
        }
        long jTransferTo = fileChannel.transferTo(j, Math.min(this.remaining, j2), this.channel);
        if (jTransferTo > 0) {
            this.metrics.incrementBytesTransferred(jTransferTo);
        }
        long j3 = this.remaining - jTransferTo;
        this.remaining = j3;
        if (j3 <= 0) {
            super.complete(null);
        }
        return jTransferTo;
    }

    public String toString() {
        return "[content length: " + this.contentLength + "; pos: " + (this.contentLength - this.remaining) + "; completed: " + isCompleted() + "]";
    }
}
