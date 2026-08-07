package org.apache.hc.core5.http.impl.io;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import org.apache.hc.core5.http.impl.BasicHttpTransportMetrics;
import org.apache.hc.core5.http.io.HttpTransportMetrics;
import org.apache.hc.core5.http.io.SessionOutputBuffer;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.ByteArrayBuffer;
import org.apache.hc.core5.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class SessionOutputBufferImpl implements SessionOutputBuffer {
    private static final byte[] CRLF = {Ascii.CR, 10};
    private ByteBuffer bbuf;
    private final ByteArrayBuffer buffer;
    private final CharsetEncoder encoder;
    private final int fragmentSizeHint;
    private final BasicHttpTransportMetrics metrics;

    public SessionOutputBufferImpl(BasicHttpTransportMetrics basicHttpTransportMetrics, int i, int i2, CharsetEncoder charsetEncoder) {
        Args.positive(i, "Buffer size");
        Args.notNull(basicHttpTransportMetrics, "HTTP transport metrics");
        this.metrics = basicHttpTransportMetrics;
        this.buffer = new ByteArrayBuffer(i);
        this.fragmentSizeHint = i2 >= 0 ? i2 : i;
        this.encoder = charsetEncoder;
    }

    public SessionOutputBufferImpl(int i) {
        this(new BasicHttpTransportMetrics(), i, i, null);
    }

    public SessionOutputBufferImpl(int i, CharsetEncoder charsetEncoder) {
        this(new BasicHttpTransportMetrics(), i, i, charsetEncoder);
    }

    @Override // org.apache.hc.core5.http.io.SessionOutputBuffer
    public int capacity() {
        return this.buffer.capacity();
    }

    @Override // org.apache.hc.core5.http.io.SessionOutputBuffer
    public int length() {
        return this.buffer.length();
    }

    @Override // org.apache.hc.core5.http.io.SessionOutputBuffer
    public int available() {
        return capacity() - length();
    }

    private void flushBuffer(OutputStream outputStream) throws IOException {
        int length = this.buffer.length();
        if (length > 0) {
            outputStream.write(this.buffer.array(), 0, length);
            this.buffer.clear();
            this.metrics.incrementBytesTransferred(length);
        }
    }

    @Override // org.apache.hc.core5.http.io.SessionOutputBuffer
    public void flush(OutputStream outputStream) throws IOException {
        Args.notNull(outputStream, "Output stream");
        flushBuffer(outputStream);
        outputStream.flush();
    }

    @Override // org.apache.hc.core5.http.io.SessionOutputBuffer
    public void write(byte[] bArr, int i, int i2, OutputStream outputStream) throws IOException {
        if (bArr == null) {
            return;
        }
        Args.notNull(outputStream, "Output stream");
        if (i2 > this.fragmentSizeHint || i2 > this.buffer.capacity()) {
            flushBuffer(outputStream);
            outputStream.write(bArr, i, i2);
            this.metrics.incrementBytesTransferred(i2);
        } else {
            if (i2 > this.buffer.capacity() - this.buffer.length()) {
                flushBuffer(outputStream);
            }
            this.buffer.append(bArr, i, i2);
        }
    }

    @Override // org.apache.hc.core5.http.io.SessionOutputBuffer
    public void write(byte[] bArr, OutputStream outputStream) throws IOException {
        if (bArr == null) {
            return;
        }
        write(bArr, 0, bArr.length, outputStream);
    }

    @Override // org.apache.hc.core5.http.io.SessionOutputBuffer
    public void write(int i, OutputStream outputStream) throws IOException {
        Args.notNull(outputStream, "Output stream");
        if (this.fragmentSizeHint > 0) {
            if (this.buffer.isFull()) {
                flushBuffer(outputStream);
            }
            this.buffer.append(i);
        } else {
            flushBuffer(outputStream);
            outputStream.write(i);
        }
    }

    @Override // org.apache.hc.core5.http.io.SessionOutputBuffer
    public void writeLine(CharArrayBuffer charArrayBuffer, OutputStream outputStream) throws IOException {
        if (charArrayBuffer == null) {
            return;
        }
        Args.notNull(outputStream, "Output stream");
        int i = 0;
        if (this.encoder == null) {
            int length = charArrayBuffer.length();
            while (length > 0) {
                int iMin = Math.min(this.buffer.capacity() - this.buffer.length(), length);
                if (iMin > 0) {
                    this.buffer.append(charArrayBuffer, i, iMin);
                }
                if (this.buffer.isFull()) {
                    flushBuffer(outputStream);
                }
                i += iMin;
                length -= iMin;
            }
        } else {
            writeEncoded(CharBuffer.wrap(charArrayBuffer.array(), 0, charArrayBuffer.length()), outputStream);
        }
        write(CRLF, outputStream);
    }

    private void writeEncoded(CharBuffer charBuffer, OutputStream outputStream) throws IOException {
        if (charBuffer.hasRemaining()) {
            if (this.bbuf == null) {
                this.bbuf = ByteBuffer.allocate(1024);
            }
            this.encoder.reset();
            while (charBuffer.hasRemaining()) {
                handleEncodingResult(this.encoder.encode(charBuffer, this.bbuf, true), outputStream);
            }
            handleEncodingResult(this.encoder.flush(this.bbuf), outputStream);
            this.bbuf.clear();
        }
    }

    private void handleEncodingResult(CoderResult coderResult, OutputStream outputStream) throws IOException {
        if (coderResult.isError()) {
            coderResult.throwException();
        }
        this.bbuf.flip();
        while (this.bbuf.hasRemaining()) {
            write(this.bbuf.get(), outputStream);
        }
        this.bbuf.compact();
    }

    @Override // org.apache.hc.core5.http.io.SessionOutputBuffer
    public HttpTransportMetrics getMetrics() {
        return this.metrics;
    }
}
