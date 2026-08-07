package org.apache.hc.core5.http.impl.io;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import org.apache.hc.core5.function.Supplier;
import org.apache.hc.core5.http.FormattedHeader;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.StreamClosedException;
import org.apache.hc.core5.http.io.SessionOutputBuffer;
import org.apache.hc.core5.http.message.BasicLineFormatter;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class ChunkedOutputStream extends OutputStream {
    private final SessionOutputBuffer buffer;
    private final byte[] cache;
    private int cachePosition;
    private boolean closed;
    private final CharArrayBuffer lineBuffer;
    private final OutputStream outputStream;
    private final Supplier<List<? extends Header>> trailerSupplier;
    private boolean wroteLastChunk;

    public ChunkedOutputStream(SessionOutputBuffer sessionOutputBuffer, OutputStream outputStream, byte[] bArr, Supplier<List<? extends Header>> supplier) {
        this.buffer = (SessionOutputBuffer) Args.notNull(sessionOutputBuffer, "Session output buffer");
        this.outputStream = (OutputStream) Args.notNull(outputStream, "Output stream");
        this.cache = (byte[]) Args.notNull(bArr, "Chunk cache");
        this.lineBuffer = new CharArrayBuffer(32);
        this.trailerSupplier = supplier;
    }

    public ChunkedOutputStream(SessionOutputBuffer sessionOutputBuffer, OutputStream outputStream, int i, Supplier<List<? extends Header>> supplier) {
        this(sessionOutputBuffer, outputStream, new byte[i <= 0 ? 8192 : i], supplier);
    }

    public ChunkedOutputStream(SessionOutputBuffer sessionOutputBuffer, OutputStream outputStream, int i) {
        this(sessionOutputBuffer, outputStream, i, (Supplier<List<? extends Header>>) null);
    }

    private void flushCache() throws IOException {
        if (this.cachePosition > 0) {
            this.lineBuffer.clear();
            this.lineBuffer.append(Integer.toHexString(this.cachePosition));
            this.buffer.writeLine(this.lineBuffer, this.outputStream);
            this.buffer.write(this.cache, 0, this.cachePosition, this.outputStream);
            this.lineBuffer.clear();
            this.buffer.writeLine(this.lineBuffer, this.outputStream);
            this.cachePosition = 0;
        }
    }

    private void flushCacheWithAppend(byte[] bArr, int i, int i2) throws IOException {
        this.lineBuffer.clear();
        this.lineBuffer.append(Integer.toHexString(this.cachePosition + i2));
        this.buffer.writeLine(this.lineBuffer, this.outputStream);
        this.buffer.write(this.cache, 0, this.cachePosition, this.outputStream);
        this.buffer.write(bArr, i, i2, this.outputStream);
        this.lineBuffer.clear();
        this.buffer.writeLine(this.lineBuffer, this.outputStream);
        this.cachePosition = 0;
    }

    private void writeClosingChunk() throws IOException {
        this.lineBuffer.clear();
        this.lineBuffer.append('0');
        this.buffer.writeLine(this.lineBuffer, this.outputStream);
        writeTrailers();
        this.lineBuffer.clear();
        this.buffer.writeLine(this.lineBuffer, this.outputStream);
    }

    private void writeTrailers() throws IOException {
        Supplier<List<? extends Header>> supplier = this.trailerSupplier;
        List<? extends Header> list = supplier != null ? supplier.get() : null;
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                Header header = list.get(i);
                if (header instanceof FormattedHeader) {
                    this.buffer.writeLine(((FormattedHeader) header).getBuffer(), this.outputStream);
                } else {
                    this.lineBuffer.clear();
                    BasicLineFormatter.INSTANCE.formatHeader(this.lineBuffer, header);
                    this.buffer.writeLine(this.lineBuffer, this.outputStream);
                }
            }
        }
    }

    public void finish() throws IOException {
        if (this.wroteLastChunk) {
            return;
        }
        flushCache();
        writeClosingChunk();
        this.wroteLastChunk = true;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        if (this.closed) {
            throw new StreamClosedException();
        }
        byte[] bArr = this.cache;
        int i2 = this.cachePosition;
        bArr[i2] = (byte) i;
        int i3 = i2 + 1;
        this.cachePosition = i3;
        if (i3 == bArr.length) {
            flushCache();
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.closed) {
            throw new StreamClosedException();
        }
        byte[] bArr2 = this.cache;
        int length = bArr2.length;
        int i3 = this.cachePosition;
        if (i2 >= length - i3) {
            flushCacheWithAppend(bArr, i, i2);
        } else {
            System.arraycopy(bArr, i, bArr2, i3, i2);
            this.cachePosition += i2;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        flushCache();
        this.buffer.flush(this.outputStream);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        finish();
        this.buffer.flush(this.outputStream);
    }
}
