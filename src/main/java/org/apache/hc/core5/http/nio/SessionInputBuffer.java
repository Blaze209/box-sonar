package org.apache.hc.core5.http.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import org.apache.hc.core5.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes5.dex */
public interface SessionInputBuffer {
    int fill(ReadableByteChannel readableByteChannel) throws IOException;

    boolean hasData();

    int length();

    int read();

    int read(ByteBuffer byteBuffer);

    int read(ByteBuffer byteBuffer, int i);

    int read(WritableByteChannel writableByteChannel) throws IOException;

    int read(WritableByteChannel writableByteChannel, int i) throws IOException;

    boolean readLine(CharArrayBuffer charArrayBuffer, boolean z) throws IOException;
}
