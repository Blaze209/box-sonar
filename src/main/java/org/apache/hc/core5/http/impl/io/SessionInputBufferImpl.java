package org.apache.hc.core5.http.impl.io;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import org.apache.hc.core5.http.MessageConstraintException;
import org.apache.hc.core5.http.impl.BasicHttpTransportMetrics;
import org.apache.hc.core5.http.io.HttpTransportMetrics;
import org.apache.hc.core5.http.io.SessionInputBuffer;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.ByteArrayBuffer;
import org.apache.hc.core5.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class SessionInputBufferImpl implements SessionInputBuffer {
    private final byte[] buffer;
    private int bufferLen;
    private int bufferPos;
    private CharBuffer cbuf;
    private final CharsetDecoder decoder;
    private final ByteArrayBuffer lineBuffer;
    private final int maxLineLen;
    private final BasicHttpTransportMetrics metrics;
    private final int minChunkLimit;

    public SessionInputBufferImpl(BasicHttpTransportMetrics basicHttpTransportMetrics, int i, int i2, int i3, CharsetDecoder charsetDecoder) {
        Args.notNull(basicHttpTransportMetrics, "HTTP transport metrics");
        Args.positive(i, "Buffer size");
        this.metrics = basicHttpTransportMetrics;
        this.buffer = new byte[i];
        this.bufferPos = 0;
        this.bufferLen = 0;
        this.minChunkLimit = i2 < 0 ? 512 : i2;
        this.maxLineLen = Math.max(i3, 0);
        this.lineBuffer = new ByteArrayBuffer(i);
        this.decoder = charsetDecoder;
    }

    public SessionInputBufferImpl(BasicHttpTransportMetrics basicHttpTransportMetrics, int i) {
        this(basicHttpTransportMetrics, i, i, 0, null);
    }

    public SessionInputBufferImpl(int i, int i2) {
        this(new BasicHttpTransportMetrics(), i, i, i2, null);
    }

    public SessionInputBufferImpl(int i, CharsetDecoder charsetDecoder) {
        this(new BasicHttpTransportMetrics(), i, i, 0, charsetDecoder);
    }

    public SessionInputBufferImpl(int i) {
        this(new BasicHttpTransportMetrics(), i, i, 0, null);
    }

    @Override // org.apache.hc.core5.http.io.SessionInputBuffer
    public int capacity() {
        return this.buffer.length;
    }

    @Override // org.apache.hc.core5.http.io.SessionInputBuffer
    public int length() {
        return this.bufferLen - this.bufferPos;
    }

    @Override // org.apache.hc.core5.http.io.SessionInputBuffer
    public int available() {
        return capacity() - length();
    }

    public int fillBuffer(InputStream inputStream) throws IOException {
        Args.notNull(inputStream, "Input stream");
        int i = this.bufferPos;
        if (i > 0) {
            int i2 = this.bufferLen - i;
            if (i2 > 0) {
                byte[] bArr = this.buffer;
                System.arraycopy(bArr, i, bArr, 0, i2);
            }
            this.bufferPos = 0;
            this.bufferLen = i2;
        }
        int i3 = this.bufferLen;
        byte[] bArr2 = this.buffer;
        int i4 = inputStream.read(bArr2, i3, bArr2.length - i3);
        if (i4 == -1) {
            return -1;
        }
        this.bufferLen = i3 + i4;
        this.metrics.incrementBytesTransferred(i4);
        return i4;
    }

    public boolean hasBufferedData() {
        return this.bufferPos < this.bufferLen;
    }

    public void clear() {
        this.bufferPos = 0;
        this.bufferLen = 0;
    }

    @Override // org.apache.hc.core5.http.io.SessionInputBuffer
    public int read(InputStream inputStream) throws IOException {
        Args.notNull(inputStream, "Input stream");
        while (!hasBufferedData()) {
            if (fillBuffer(inputStream) == -1) {
                return -1;
            }
        }
        byte[] bArr = this.buffer;
        int i = this.bufferPos;
        this.bufferPos = i + 1;
        return bArr[i] & 255;
    }

    @Override // org.apache.hc.core5.http.io.SessionInputBuffer
    public int read(byte[] bArr, int i, int i2, InputStream inputStream) throws IOException {
        Args.notNull(inputStream, "Input stream");
        if (bArr == null || bArr.length == 0 || i2 == 0) {
            return 0;
        }
        if (hasBufferedData()) {
            int iMin = Math.min(i2, this.bufferLen - this.bufferPos);
            System.arraycopy(this.buffer, this.bufferPos, bArr, i, iMin);
            this.bufferPos += iMin;
            return iMin;
        }
        if (i2 > this.minChunkLimit) {
            int i3 = inputStream.read(bArr, i, i2);
            if (i3 > 0) {
                this.metrics.incrementBytesTransferred(i3);
            }
            return i3;
        }
        while (!hasBufferedData()) {
            if (fillBuffer(inputStream) == -1) {
                return -1;
            }
        }
        int iMin2 = Math.min(i2, this.bufferLen - this.bufferPos);
        System.arraycopy(this.buffer, this.bufferPos, bArr, i, iMin2);
        this.bufferPos += iMin2;
        return iMin2;
    }

    @Override // org.apache.hc.core5.http.io.SessionInputBuffer
    public int read(byte[] bArr, InputStream inputStream) throws IOException {
        if (bArr == null) {
            return 0;
        }
        return read(bArr, 0, bArr.length, inputStream);
    }

    @Override // org.apache.hc.core5.http.io.SessionInputBuffer
    public int readLine(CharArrayBuffer charArrayBuffer, InputStream inputStream) throws IOException {
        Args.notNull(charArrayBuffer, "Char array buffer");
        Args.notNull(inputStream, "Input stream");
        boolean z = true;
        int iFillBuffer = 0;
        while (z) {
            int i = this.bufferPos;
            while (true) {
                if (i >= this.bufferLen) {
                    i = -1;
                    break;
                }
                if (this.buffer[i] == 10) {
                    break;
                }
                i++;
            }
            if (this.maxLineLen > 0) {
                if ((this.lineBuffer.length() + (i >= 0 ? i : this.bufferLen)) - this.bufferPos >= this.maxLineLen) {
                    throw new MessageConstraintException("Maximum line length limit exceeded");
                }
            }
            if (i != -1) {
                if (this.lineBuffer.isEmpty()) {
                    return lineFromReadBuffer(charArrayBuffer, i);
                }
                int i2 = i + 1;
                int i3 = this.bufferPos;
                this.lineBuffer.append(this.buffer, i3, i2 - i3);
                this.bufferPos = i2;
            } else {
                if (hasBufferedData()) {
                    int i4 = this.bufferLen;
                    int i5 = this.bufferPos;
                    this.lineBuffer.append(this.buffer, i5, i4 - i5);
                    this.bufferPos = this.bufferLen;
                }
                iFillBuffer = fillBuffer(inputStream);
                if (iFillBuffer == -1) {
                }
            }
            z = false;
        }
        if (iFillBuffer == -1 && this.lineBuffer.isEmpty()) {
            return -1;
        }
        return lineFromLineBuffer(charArrayBuffer);
    }

    private int lineFromLineBuffer(CharArrayBuffer charArrayBuffer) throws IOException {
        int length = this.lineBuffer.length();
        if (length > 0) {
            if (this.lineBuffer.byteAt(length - 1) == 10) {
                length--;
            }
            if (length > 0 && this.lineBuffer.byteAt(length - 1) == 13) {
                length--;
            }
        }
        if (this.decoder == null) {
            charArrayBuffer.append(this.lineBuffer, 0, length);
        } else {
            length = appendDecoded(charArrayBuffer, ByteBuffer.wrap(this.lineBuffer.array(), 0, length));
        }
        this.lineBuffer.clear();
        return length;
    }

    private int lineFromReadBuffer(CharArrayBuffer charArrayBuffer, int i) throws IOException {
        int i2 = this.bufferPos;
        this.bufferPos = i + 1;
        if (i > i2 && this.buffer[i - 1] == 13) {
            i--;
        }
        int i3 = i - i2;
        if (this.decoder == null) {
            charArrayBuffer.append(this.buffer, i2, i3);
            return i3;
        }
        return appendDecoded(charArrayBuffer, ByteBuffer.wrap(this.buffer, i2, i3));
    }

    private int appendDecoded(CharArrayBuffer charArrayBuffer, ByteBuffer byteBuffer) throws IOException {
        int iHandleDecodingResult = 0;
        if (!byteBuffer.hasRemaining()) {
            return 0;
        }
        if (this.cbuf == null) {
            this.cbuf = CharBuffer.allocate(1024);
        }
        this.decoder.reset();
        while (byteBuffer.hasRemaining()) {
            iHandleDecodingResult += handleDecodingResult(this.decoder.decode(byteBuffer, this.cbuf, true), charArrayBuffer);
        }
        int iHandleDecodingResult2 = iHandleDecodingResult + handleDecodingResult(this.decoder.flush(this.cbuf), charArrayBuffer);
        this.cbuf.clear();
        return iHandleDecodingResult2;
    }

    private int handleDecodingResult(CoderResult coderResult, CharArrayBuffer charArrayBuffer) throws IOException {
        if (coderResult.isError()) {
            coderResult.throwException();
        }
        this.cbuf.flip();
        int iRemaining = this.cbuf.remaining();
        while (this.cbuf.hasRemaining()) {
            charArrayBuffer.append(this.cbuf.get());
        }
        this.cbuf.compact();
        return iRemaining;
    }

    @Override // org.apache.hc.core5.http.io.SessionInputBuffer
    public HttpTransportMetrics getMetrics() {
        return this.metrics;
    }
}
