package org.apache.hc.core5.http.impl.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.List;
import org.apache.hc.core5.http.FormattedHeader;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.impl.BasicHttpTransportMetrics;
import org.apache.hc.core5.http.message.BasicLineFormatter;
import org.apache.hc.core5.http.nio.SessionOutputBuffer;
import org.apache.hc.core5.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class ChunkEncoder extends AbstractContentEncoder {
    private final int chunkSizeHint;
    private final CharArrayBuffer lineBuffer;

    public ChunkEncoder(WritableByteChannel writableByteChannel, SessionOutputBuffer sessionOutputBuffer, BasicHttpTransportMetrics basicHttpTransportMetrics, int i) {
        super(writableByteChannel, sessionOutputBuffer, basicHttpTransportMetrics);
        this.chunkSizeHint = Math.max(i, 0);
        this.lineBuffer = new CharArrayBuffer(16);
    }

    public ChunkEncoder(WritableByteChannel writableByteChannel, SessionOutputBuffer sessionOutputBuffer, BasicHttpTransportMetrics basicHttpTransportMetrics) {
        this(writableByteChannel, sessionOutputBuffer, basicHttpTransportMetrics, 0);
    }

    @Override // org.apache.hc.core5.http.nio.ContentEncoder
    public int write(ByteBuffer byteBuffer) throws IOException {
        int i = 0;
        if (byteBuffer == null) {
            return 0;
        }
        assertNotCompleted();
        while (byteBuffer.hasRemaining()) {
            int iRemaining = byteBuffer.remaining();
            int iCapacity = this.buffer.capacity() - 12;
            if (iCapacity > 0) {
                if (iCapacity < iRemaining) {
                    this.lineBuffer.clear();
                    this.lineBuffer.append(Integer.toHexString(iCapacity));
                    this.buffer.writeLine(this.lineBuffer);
                    int iLimit = byteBuffer.limit();
                    byteBuffer.limit(byteBuffer.position() + iCapacity);
                    this.buffer.write(byteBuffer);
                    byteBuffer.limit(iLimit);
                    iRemaining = iCapacity;
                } else {
                    this.lineBuffer.clear();
                    this.lineBuffer.append(Integer.toHexString(iRemaining));
                    this.buffer.writeLine(this.lineBuffer);
                    this.buffer.write(byteBuffer);
                }
                this.lineBuffer.clear();
                this.buffer.writeLine(this.lineBuffer);
                i += iRemaining;
            }
            if (this.buffer.length() >= this.chunkSizeHint || byteBuffer.hasRemaining()) {
                if (flushToChannel() == 0) {
                    break;
                }
            }
        }
        return i;
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractContentEncoder, org.apache.hc.core5.http.nio.ContentEncoder
    public void complete(List<? extends Header> list) throws IOException {
        assertNotCompleted();
        this.lineBuffer.clear();
        this.lineBuffer.append("0");
        this.buffer.writeLine(this.lineBuffer);
        writeTrailers(list);
        this.lineBuffer.clear();
        this.buffer.writeLine(this.lineBuffer);
        super.complete(list);
    }

    private void writeTrailers(List<? extends Header> list) throws IOException {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                Header header = list.get(i);
                if (header instanceof FormattedHeader) {
                    this.buffer.writeLine(((FormattedHeader) header).getBuffer());
                } else {
                    this.lineBuffer.clear();
                    BasicLineFormatter.INSTANCE.formatHeader(this.lineBuffer, header);
                    this.buffer.writeLine(this.lineBuffer);
                }
            }
        }
    }

    public String toString() {
        return "[chunk-coded; completed: " + isCompleted() + "]";
    }
}
