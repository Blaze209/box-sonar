package org.apache.hc.core5.http.impl.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import org.apache.hc.core5.http.MessageConstraintException;
import org.apache.hc.core5.http.nio.SessionInputBuffer;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes5.dex */
class SessionInputBufferImpl extends ExpandableBuffer implements SessionInputBuffer {
    private final CharsetDecoder charDecoder;
    private CharBuffer charbuffer;
    private final int lineBuffersize;
    private final int maxLineLen;

    public SessionInputBufferImpl(int i, int i2, int i3, CharsetDecoder charsetDecoder) {
        super(i);
        this.lineBuffersize = Args.positive(i2, "Line buffer size");
        this.maxLineLen = Math.max(i3, 0);
        this.charDecoder = charsetDecoder;
    }

    public SessionInputBufferImpl(int i, int i2, int i3, Charset charset) {
        this(i, i2, i3, charset != null ? charset.newDecoder() : null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SessionInputBufferImpl(int i, int i2, int i3) {
        this(i, i2, i3, (CharsetDecoder) null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SessionInputBufferImpl(int i, int i2) {
        this(i, i2, 0, (CharsetDecoder) null);
    }

    public SessionInputBufferImpl(int i) {
        this(i, 256);
    }

    @Override // org.apache.hc.core5.http.impl.nio.ExpandableBuffer
    public int length() {
        return super.length();
    }

    @Override // org.apache.hc.core5.http.impl.nio.ExpandableBuffer
    public boolean hasData() {
        return super.hasData();
    }

    @Override // org.apache.hc.core5.http.impl.nio.ExpandableBuffer
    public int capacity() {
        return super.capacity();
    }

    public void put(ByteBuffer byteBuffer) {
        if (byteBuffer == null || !byteBuffer.hasRemaining()) {
            return;
        }
        setInputMode();
        ensureAdjustedCapacity(buffer().position() + byteBuffer.remaining());
        buffer().put(byteBuffer);
    }

    @Override // org.apache.hc.core5.http.nio.SessionInputBuffer
    public int fill(ReadableByteChannel readableByteChannel) throws IOException {
        Args.notNull(readableByteChannel, "Channel");
        setInputMode();
        if (!buffer().hasRemaining()) {
            expand();
        }
        return readableByteChannel.read(buffer());
    }

    @Override // org.apache.hc.core5.http.nio.SessionInputBuffer
    public int read() {
        setOutputMode();
        return buffer().get() & 255;
    }

    @Override // org.apache.hc.core5.http.nio.SessionInputBuffer
    public int read(ByteBuffer byteBuffer, int i) {
        if (byteBuffer == null) {
            return 0;
        }
        setOutputMode();
        int iMin = Math.min(byteBuffer.remaining(), i);
        int iMin2 = Math.min(buffer().remaining(), iMin);
        if (buffer().remaining() > iMin2) {
            int iLimit = buffer().limit();
            buffer().limit(buffer().position() + iMin2);
            byteBuffer.put(buffer());
            buffer().limit(iLimit);
            return iMin;
        }
        byteBuffer.put(buffer());
        return iMin2;
    }

    @Override // org.apache.hc.core5.http.nio.SessionInputBuffer
    public int read(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return 0;
        }
        return read(byteBuffer, byteBuffer.remaining());
    }

    @Override // org.apache.hc.core5.http.nio.SessionInputBuffer
    public int read(WritableByteChannel writableByteChannel, int i) throws IOException {
        if (writableByteChannel == null) {
            return 0;
        }
        setOutputMode();
        if (buffer().remaining() > i) {
            int iLimit = buffer().limit();
            buffer().limit(iLimit - (buffer().remaining() - i));
            int iWrite = writableByteChannel.write(buffer());
            buffer().limit(iLimit);
            return iWrite;
        }
        return writableByteChannel.write(buffer());
    }

    @Override // org.apache.hc.core5.http.nio.SessionInputBuffer
    public int read(WritableByteChannel writableByteChannel) throws IOException {
        if (writableByteChannel == null) {
            return 0;
        }
        setOutputMode();
        return writableByteChannel.write(buffer());
    }

    @Override // org.apache.hc.core5.http.nio.SessionInputBuffer
    public boolean readLine(CharArrayBuffer charArrayBuffer, boolean z) throws IOException {
        int iLimit;
        CoderResult coderResultDecode;
        setOutputMode();
        int iPosition = buffer().position();
        while (true) {
            if (iPosition >= buffer().limit()) {
                iLimit = -1;
                break;
            }
            if (buffer().get(iPosition) == 10) {
                iLimit = iPosition + 1;
                break;
            }
            iPosition++;
        }
        if (this.maxLineLen > 0) {
            if ((iLimit > 0 ? iLimit : buffer().limit()) - buffer().position() >= this.maxLineLen) {
                throw new MessageConstraintException("Maximum line length limit exceeded");
            }
        }
        if (iLimit == -1) {
            if (!z || !buffer().hasRemaining()) {
                return false;
            }
            iLimit = buffer().limit();
        }
        int iLimit2 = buffer().limit();
        buffer().limit(iLimit);
        charArrayBuffer.ensureCapacity(buffer().limit() - buffer().position());
        if (this.charDecoder == null) {
            if (buffer().hasArray()) {
                byte[] bArrArray = buffer().array();
                int iPosition2 = buffer().position();
                int iRemaining = buffer().remaining();
                charArrayBuffer.append(bArrArray, buffer().arrayOffset() + iPosition2, iRemaining);
                buffer().position(iPosition2 + iRemaining);
            } else {
                while (buffer().hasRemaining()) {
                    charArrayBuffer.append((char) (buffer().get() & 255));
                }
            }
        } else {
            if (this.charbuffer == null) {
                this.charbuffer = CharBuffer.allocate(this.lineBuffersize);
            }
            this.charDecoder.reset();
            do {
                coderResultDecode = this.charDecoder.decode(buffer(), this.charbuffer, true);
                if (coderResultDecode.isError()) {
                    coderResultDecode.throwException();
                }
                if (coderResultDecode.isOverflow()) {
                    this.charbuffer.flip();
                    charArrayBuffer.append(this.charbuffer.array(), this.charbuffer.arrayOffset() + this.charbuffer.position(), this.charbuffer.remaining());
                    this.charbuffer.clear();
                }
            } while (!coderResultDecode.isUnderflow());
            this.charDecoder.flush(this.charbuffer);
            this.charbuffer.flip();
            if (this.charbuffer.hasRemaining()) {
                charArrayBuffer.append(this.charbuffer.array(), this.charbuffer.arrayOffset() + this.charbuffer.position(), this.charbuffer.remaining());
            }
        }
        buffer().limit(iLimit2);
        int length = charArrayBuffer.length();
        if (length > 0) {
            if (charArrayBuffer.charAt(length - 1) == '\n') {
                length--;
                charArrayBuffer.setLength(length);
            }
            if (length > 0 && charArrayBuffer.charAt(length - 1) == '\r') {
                charArrayBuffer.setLength(length - 1);
            }
        }
        return true;
    }
}
