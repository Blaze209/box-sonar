package org.apache.hc.core5.http.impl.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import org.apache.hc.core5.http.impl.BasicHttpTransportMetrics;
import org.apache.hc.core5.http.nio.FileContentEncoder;
import org.apache.hc.core5.http.nio.SessionOutputBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class IdentityEncoder extends AbstractContentEncoder implements FileContentEncoder {
    private final int fragHint;

    public IdentityEncoder(WritableByteChannel writableByteChannel, SessionOutputBuffer sessionOutputBuffer, BasicHttpTransportMetrics basicHttpTransportMetrics, int i) {
        super(writableByteChannel, sessionOutputBuffer, basicHttpTransportMetrics);
        this.fragHint = Math.max(i, 0);
    }

    public IdentityEncoder(WritableByteChannel writableByteChannel, SessionOutputBuffer sessionOutputBuffer, BasicHttpTransportMetrics basicHttpTransportMetrics) {
        this(writableByteChannel, sessionOutputBuffer, basicHttpTransportMetrics, 0);
    }

    @Override // org.apache.hc.core5.http.nio.ContentEncoder
    public int write(ByteBuffer byteBuffer) throws IOException {
        int length;
        int iWriteToBuffer = 0;
        if (byteBuffer == null) {
            return 0;
        }
        assertNotCompleted();
        while (byteBuffer.hasRemaining()) {
            if (this.buffer.hasData() || this.fragHint > 0) {
                int iRemaining = byteBuffer.remaining();
                int i = this.fragHint;
                if (iRemaining <= i && (length = i - this.buffer.length()) > 0) {
                    iWriteToBuffer += writeToBuffer(byteBuffer, Math.min(length, byteBuffer.remaining()));
                }
            }
            if (this.buffer.hasData() && ((this.buffer.length() >= this.fragHint || byteBuffer.hasRemaining()) && flushToChannel() == 0)) {
                return iWriteToBuffer;
            }
            if (!this.buffer.hasData() && byteBuffer.remaining() > this.fragHint) {
                int iWriteToChannel = writeToChannel(byteBuffer);
                iWriteToBuffer += iWriteToChannel;
                if (iWriteToChannel == 0) {
                    break;
                }
            }
        }
        return iWriteToBuffer;
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
        long jTransferTo = fileChannel.transferTo(j, j2, this.channel);
        if (jTransferTo > 0) {
            this.metrics.incrementBytesTransferred(jTransferTo);
        }
        return jTransferTo;
    }

    public String toString() {
        return "[identity; completed: " + isCompleted() + "]";
    }
}
