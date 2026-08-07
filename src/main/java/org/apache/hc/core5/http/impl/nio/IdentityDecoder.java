package org.apache.hc.core5.http.impl.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import org.apache.hc.core5.http.impl.BasicHttpTransportMetrics;
import org.apache.hc.core5.http.nio.FileContentDecoder;
import org.apache.hc.core5.http.nio.SessionInputBuffer;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class IdentityDecoder extends AbstractContentDecoder implements FileContentDecoder {
    public IdentityDecoder(ReadableByteChannel readableByteChannel, SessionInputBuffer sessionInputBuffer, BasicHttpTransportMetrics basicHttpTransportMetrics) {
        super(readableByteChannel, sessionInputBuffer, basicHttpTransportMetrics);
    }

    @Override // org.apache.hc.core5.http.nio.ContentDecoder
    public int read(ByteBuffer byteBuffer) throws IOException {
        int fromChannel;
        Args.notNull(byteBuffer, "Byte buffer");
        if (isCompleted()) {
            return -1;
        }
        if (this.buffer.hasData()) {
            fromChannel = this.buffer.read(byteBuffer);
        } else {
            fromChannel = readFromChannel(byteBuffer);
        }
        if (fromChannel == -1) {
            setCompleted();
        }
        return fromChannel;
    }

    @Override // org.apache.hc.core5.http.nio.FileContentDecoder
    public long transfer(FileChannel fileChannel, long j, long j2) throws IOException {
        long jTransferFrom;
        if (fileChannel == null || isCompleted()) {
            return 0L;
        }
        if (this.buffer.hasData()) {
            int length = this.buffer.length();
            fileChannel.position(j);
            SessionInputBuffer sessionInputBuffer = this.buffer;
            if (j2 < length) {
                length = (int) j2;
            }
            jTransferFrom = sessionInputBuffer.read(fileChannel, length);
        } else {
            if (!this.channel.isOpen()) {
                jTransferFrom = -1;
            } else {
                if (j > fileChannel.size()) {
                    throw new IOException("Position past end of file [" + j + " > " + fileChannel.size() + "]");
                }
                jTransferFrom = fileChannel.transferFrom(this.channel, j, j2);
                if (j2 > 0 && jTransferFrom == 0) {
                    jTransferFrom = this.buffer.fill(this.channel);
                }
            }
            if (jTransferFrom > 0) {
                this.metrics.incrementBytesTransferred(jTransferFrom);
            }
        }
        if (jTransferFrom == -1) {
            setCompleted();
        }
        return jTransferFrom;
    }

    public String toString() {
        return "[identity; completed: " + this.completed + "]";
    }
}
