package org.apache.hc.core5.http.impl.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class BufferedData extends ExpandableBuffer {
    public static BufferedData allocate(int i) {
        return new BufferedData(i);
    }

    protected BufferedData(int i) {
        super(i);
    }

    @Override // org.apache.hc.core5.http.impl.nio.ExpandableBuffer
    public final boolean hasData() {
        return super.hasData();
    }

    @Override // org.apache.hc.core5.http.impl.nio.ExpandableBuffer
    public final int length() {
        return super.length();
    }

    @Override // org.apache.hc.core5.http.impl.nio.ExpandableBuffer
    public final int capacity() {
        return super.capacity();
    }

    @Override // org.apache.hc.core5.http.impl.nio.ExpandableBuffer
    public final void clear() {
        super.clear();
    }

    public final void put(ByteBuffer byteBuffer) {
        Args.notNull(byteBuffer, "Data source");
        setInputMode();
        ensureAdjustedCapacity(buffer().position() + byteBuffer.remaining());
        buffer().put(byteBuffer);
    }

    public final int readFrom(ReadableByteChannel readableByteChannel) throws IOException {
        Args.notNull(readableByteChannel, "Channel");
        setInputMode();
        if (!buffer().hasRemaining()) {
            expand();
        }
        return readableByteChannel.read(buffer());
    }

    public final int writeTo(WritableByteChannel writableByteChannel) throws IOException {
        if (writableByteChannel == null) {
            return 0;
        }
        setOutputMode();
        return writableByteChannel.write(buffer());
    }

    public final ByteBuffer data() {
        setOutputMode();
        return buffer();
    }
}
