package org.apache.hc.core5.http.impl.nio;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import org.apache.hc.core5.http.nio.SessionOutputBuffer;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.CharArrayBuffer;
import org.apache.hc.core5.util.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
class SessionOutputBufferImpl extends ExpandableBuffer implements SessionOutputBuffer {
    private static final byte[] CRLF = {Ascii.CR, 10};
    private final CharsetEncoder charEncoder;
    private CharBuffer charbuffer;
    private final int lineBufferSize;

    public SessionOutputBufferImpl(int i, int i2, CharsetEncoder charsetEncoder) {
        super(i);
        this.lineBufferSize = Args.positive(i2, "Line buffer size");
        this.charEncoder = charsetEncoder;
    }

    public SessionOutputBufferImpl(int i, int i2, Charset charset) {
        this(i, i2, charset != null ? charset.newEncoder() : null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SessionOutputBufferImpl(int i, int i2) {
        this(i, i2, (CharsetEncoder) null);
    }

    public SessionOutputBufferImpl(int i) {
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

    @Override // org.apache.hc.core5.http.nio.SessionOutputBuffer
    public int flush(WritableByteChannel writableByteChannel) throws IOException {
        Args.notNull(writableByteChannel, "Channel");
        setOutputMode();
        return writableByteChannel.write(buffer());
    }

    @Override // org.apache.hc.core5.http.nio.SessionOutputBuffer
    public void write(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return;
        }
        setInputMode();
        ensureAdjustedCapacity(buffer().position() + byteBuffer.remaining());
        buffer().put(byteBuffer);
    }

    @Override // org.apache.hc.core5.http.nio.SessionOutputBuffer
    public void write(ReadableByteChannel readableByteChannel) throws IOException {
        if (readableByteChannel == null) {
            return;
        }
        setInputMode();
        readableByteChannel.read(buffer());
    }

    private void write(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        setInputMode();
        int length = bArr.length;
        ensureAdjustedCapacity(buffer().position() + length);
        buffer().put(bArr, 0, length);
    }

    private void writeCRLF() {
        write(CRLF);
    }

    @Override // org.apache.hc.core5.http.nio.SessionOutputBuffer
    public void writeLine(CharArrayBuffer charArrayBuffer) throws CharacterCodingException {
        boolean z;
        if (charArrayBuffer == null) {
            return;
        }
        setInputMode();
        if (charArrayBuffer.length() > 0) {
            int i = 0;
            if (this.charEncoder == null) {
                ensureCapacity(buffer().position() + charArrayBuffer.length());
                if (buffer().hasArray()) {
                    byte[] bArrArray = buffer().array();
                    int length = charArrayBuffer.length();
                    int iPosition = buffer().position();
                    int iArrayOffset = buffer().arrayOffset();
                    while (i < length) {
                        bArrArray[iArrayOffset + iPosition + i] = TextUtils.castAsByte(charArrayBuffer.charAt(i));
                        i++;
                    }
                    buffer().position(iPosition + length);
                } else {
                    while (i < charArrayBuffer.length()) {
                        buffer().put(TextUtils.castAsByte(charArrayBuffer.charAt(i)));
                        i++;
                    }
                }
            } else {
                if (this.charbuffer == null) {
                    this.charbuffer = CharBuffer.allocate(this.lineBufferSize);
                }
                this.charEncoder.reset();
                int length2 = charArrayBuffer.length();
                int i2 = 0;
                while (length2 > 0) {
                    int iRemaining = this.charbuffer.remaining();
                    if (length2 <= iRemaining) {
                        iRemaining = length2;
                        z = true;
                    } else {
                        z = false;
                    }
                    this.charbuffer.put(charArrayBuffer.array(), i2, iRemaining);
                    this.charbuffer.flip();
                    boolean z2 = true;
                    while (z2) {
                        CoderResult coderResultEncode = this.charEncoder.encode(this.charbuffer, buffer(), z);
                        if (coderResultEncode.isError()) {
                            coderResultEncode.throwException();
                        }
                        if (coderResultEncode.isOverflow()) {
                            expand();
                        }
                        z2 = !coderResultEncode.isUnderflow();
                    }
                    this.charbuffer.compact();
                    i2 += iRemaining;
                    length2 -= iRemaining;
                }
                boolean z3 = true;
                while (z3) {
                    CoderResult coderResultFlush = this.charEncoder.flush(buffer());
                    if (coderResultFlush.isError()) {
                        coderResultFlush.throwException();
                    }
                    if (coderResultFlush.isOverflow()) {
                        expand();
                    }
                    z3 = !coderResultFlush.isUnderflow();
                }
            }
        }
        writeCRLF();
    }
}
