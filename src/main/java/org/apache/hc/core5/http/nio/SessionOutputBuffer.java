package org.apache.hc.core5.http.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.CharacterCodingException;
import org.apache.hc.core5.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes5.dex */
public interface SessionOutputBuffer {
    int capacity();

    int flush(WritableByteChannel writableByteChannel) throws IOException;

    boolean hasData();

    int length();

    void write(ByteBuffer byteBuffer);

    void write(ReadableByteChannel readableByteChannel) throws IOException;

    void writeLine(CharArrayBuffer charArrayBuffer) throws CharacterCodingException;
}
