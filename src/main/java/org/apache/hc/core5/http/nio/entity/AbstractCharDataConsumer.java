package org.apache.hc.core5.http.nio.entity;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.config.CharCodingConfig;
import org.apache.hc.core5.http.nio.AsyncDataConsumer;
import org.apache.hc.core5.http.nio.CapacityChannel;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractCharDataConsumer implements AsyncDataConsumer {
    protected static final int DEF_BUF_SIZE = 8192;
    private static final ByteBuffer EMPTY_BIN = ByteBuffer.wrap(new byte[0]);
    private volatile ByteBuffer byteBuffer;
    private final CharBuffer charBuffer;
    private final CharCodingConfig charCodingConfig;
    private volatile Charset charset;
    private volatile CharsetDecoder charsetDecoder;

    protected abstract int capacityIncrement();

    protected abstract void completed() throws IOException;

    protected abstract void data(CharBuffer charBuffer, boolean z) throws IOException;

    protected AbstractCharDataConsumer(int i, CharCodingConfig charCodingConfig) {
        this.charBuffer = CharBuffer.allocate(Args.positive(i, "Buffer size"));
        this.charCodingConfig = charCodingConfig == null ? CharCodingConfig.DEFAULT : charCodingConfig;
    }

    public AbstractCharDataConsumer() {
        this(8192, CharCodingConfig.DEFAULT);
    }

    protected final void setCharset(Charset charset) {
        if (charset == null) {
            charset = this.charCodingConfig.getCharset();
        }
        this.charset = charset;
        this.charsetDecoder = null;
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public final void updateCapacity(CapacityChannel capacityChannel) throws IOException {
        capacityChannel.update(capacityIncrement());
    }

    private void checkResult(CoderResult coderResult) throws IOException {
        if (coderResult.isError()) {
            coderResult.throwException();
        }
    }

    private void doDecode(boolean z) throws IOException {
        this.charBuffer.flip();
        data(this.charBuffer, z);
        this.charBuffer.clear();
    }

    private CharsetDecoder getCharsetDecoder() {
        CharsetDecoder charsetDecoderNewDecoder = this.charsetDecoder;
        if (charsetDecoderNewDecoder == null) {
            Charset charset = this.charset;
            if (charset == null) {
                charset = this.charCodingConfig.getCharset();
            }
            if (charset == null) {
                charset = StandardCharsets.UTF_8;
            }
            charsetDecoderNewDecoder = charset.newDecoder();
            this.charsetDecoder = charsetDecoderNewDecoder;
            if (this.charCodingConfig.getMalformedInputAction() != null) {
                charsetDecoderNewDecoder.onMalformedInput(this.charCodingConfig.getMalformedInputAction());
            }
            if (this.charCodingConfig.getUnmappableInputAction() != null) {
                charsetDecoderNewDecoder.onUnmappableCharacter(this.charCodingConfig.getUnmappableInputAction());
            }
        }
        return charsetDecoderNewDecoder;
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public final void consume(ByteBuffer byteBuffer) throws IOException {
        CharsetDecoder charsetDecoder = getCharsetDecoder();
        while (byteBuffer.hasRemaining()) {
            ByteBuffer byteBufferAllocate = this.byteBuffer;
            if (byteBufferAllocate != null && byteBufferAllocate.position() > 0) {
                int iRemaining = byteBufferAllocate.remaining();
                if (iRemaining < byteBuffer.remaining()) {
                    int iLimit = byteBuffer.limit();
                    byteBuffer.limit(byteBuffer.position() + iRemaining);
                    byteBufferAllocate.put(byteBuffer);
                    byteBuffer.limit(iLimit);
                } else {
                    byteBufferAllocate.put(byteBuffer);
                }
                byteBufferAllocate.flip();
                checkResult(charsetDecoder.decode(byteBufferAllocate, this.charBuffer, false));
                doDecode(false);
                byteBufferAllocate.compact();
            }
            if (byteBufferAllocate == null || byteBufferAllocate.position() == 0) {
                CoderResult coderResultDecode = charsetDecoder.decode(byteBuffer, this.charBuffer, false);
                checkResult(coderResultDecode);
                doDecode(false);
                if (coderResultDecode.isUnderflow() && byteBuffer.hasRemaining()) {
                    if (byteBufferAllocate == null) {
                        byteBufferAllocate = ByteBuffer.allocate(Math.max(byteBuffer.remaining(), 1024));
                        this.byteBuffer = byteBufferAllocate;
                    }
                    byteBufferAllocate.put(byteBuffer);
                }
            }
        }
    }

    @Override // org.apache.hc.core5.http.nio.AsyncDataConsumer
    public final void streamEnd(List<? extends Header> list) throws HttpException, IOException {
        CharsetDecoder charsetDecoder = getCharsetDecoder();
        checkResult(charsetDecoder.decode(EMPTY_BIN, this.charBuffer, true));
        doDecode(false);
        checkResult(charsetDecoder.flush(this.charBuffer));
        doDecode(true);
        completed();
    }
}
