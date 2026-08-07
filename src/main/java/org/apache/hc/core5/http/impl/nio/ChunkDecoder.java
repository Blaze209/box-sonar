package org.apache.hc.core5.http.impl.nio;

import androidx.collection.SieveCacheKt;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;
import org.apache.hc.core5.http.ConnectionClosedException;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.MalformedChunkCodingException;
import org.apache.hc.core5.http.MessageConstraintException;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.TruncatedChunkException;
import org.apache.hc.core5.http.config.Http1Config;
import org.apache.hc.core5.http.impl.BasicHttpTransportMetrics;
import org.apache.hc.core5.http.message.BufferedHeader;
import org.apache.hc.core5.http.nio.SessionInputBuffer;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class ChunkDecoder extends AbstractContentDecoder {
    private long chunkSize;
    private boolean endOfChunk;
    private boolean endOfStream;
    private final Http1Config http1Config;
    private CharArrayBuffer lineBuf;
    private long pos;
    private State state;
    private final List<CharArrayBuffer> trailerBufs;
    private final List<Header> trailers;

    private enum State {
        READ_CONTENT,
        READ_FOOTERS,
        COMPLETED
    }

    public ChunkDecoder(ReadableByteChannel readableByteChannel, SessionInputBuffer sessionInputBuffer, Http1Config http1Config, BasicHttpTransportMetrics basicHttpTransportMetrics) {
        super(readableByteChannel, sessionInputBuffer, basicHttpTransportMetrics);
        this.state = State.READ_CONTENT;
        this.chunkSize = -1L;
        this.pos = 0L;
        this.endOfChunk = false;
        this.endOfStream = false;
        this.http1Config = http1Config == null ? Http1Config.DEFAULT : http1Config;
        this.trailerBufs = new ArrayList();
        this.trailers = new ArrayList();
    }

    public ChunkDecoder(ReadableByteChannel readableByteChannel, SessionInputBuffer sessionInputBuffer, BasicHttpTransportMetrics basicHttpTransportMetrics) {
        this(readableByteChannel, sessionInputBuffer, null, basicHttpTransportMetrics);
    }

    private void readChunkHead() throws IOException {
        CharArrayBuffer charArrayBuffer = this.lineBuf;
        if (charArrayBuffer == null) {
            this.lineBuf = new CharArrayBuffer(32);
        } else {
            charArrayBuffer.clear();
        }
        if (this.endOfChunk) {
            if (this.buffer.readLine(this.lineBuf, this.endOfStream)) {
                if (!this.lineBuf.isEmpty()) {
                    throw new MalformedChunkCodingException("CRLF expected at end of chunk");
                }
                this.endOfChunk = false;
            } else {
                if (this.buffer.length() > 2 || this.endOfStream) {
                    throw new MalformedChunkCodingException("CRLF expected at end of chunk");
                }
                return;
            }
        }
        boolean line = this.buffer.readLine(this.lineBuf, this.endOfStream);
        int maxLineLength = this.http1Config.getMaxLineLength();
        if (maxLineLength > 0 && (this.lineBuf.length() > maxLineLength || (!line && this.buffer.length() > maxLineLength))) {
            throw new MessageConstraintException("Maximum line length limit exceeded");
        }
        if (line) {
            int iIndexOf = this.lineBuf.indexOf(59);
            if (iIndexOf < 0) {
                iIndexOf = this.lineBuf.length();
            }
            String strSubstringTrimmed = this.lineBuf.substringTrimmed(0, iIndexOf);
            try {
                this.chunkSize = Long.parseLong(strSubstringTrimmed, 16);
                this.pos = 0L;
                return;
            } catch (NumberFormatException unused) {
                throw new MalformedChunkCodingException("Bad chunk header: " + strSubstringTrimmed);
            }
        }
        if (this.endOfStream) {
            throw new ConnectionClosedException("Premature end of chunk coded message body: closing chunk expected");
        }
    }

    private void parseHeader() throws IOException {
        char cCharAt;
        CharArrayBuffer charArrayBuffer = this.lineBuf;
        int size = this.trailerBufs.size();
        int i = 0;
        if ((this.lineBuf.charAt(0) == ' ' || this.lineBuf.charAt(0) == '\t') && size > 0) {
            CharArrayBuffer charArrayBuffer2 = this.trailerBufs.get(size - 1);
            while (i < charArrayBuffer.length() && ((cCharAt = charArrayBuffer.charAt(i)) == ' ' || cCharAt == '\t')) {
                i++;
            }
            int maxLineLength = this.http1Config.getMaxLineLength();
            if (maxLineLength > 0 && ((charArrayBuffer2.length() + 1) + charArrayBuffer.length()) - i > maxLineLength) {
                throw new MessageConstraintException("Maximum line length limit exceeded");
            }
            charArrayBuffer2.append(' ');
            charArrayBuffer2.append(charArrayBuffer, i, charArrayBuffer.length() - i);
            return;
        }
        this.trailerBufs.add(charArrayBuffer);
        this.lineBuf = null;
    }

    private void processFooters() throws IOException {
        if (this.trailerBufs.size() > 0) {
            this.trailers.clear();
            for (int i = 0; i < this.trailerBufs.size(); i++) {
                try {
                    this.trailers.add(new BufferedHeader(this.trailerBufs.get(i)));
                } catch (ParseException e) {
                    throw new IOException(e);
                }
            }
        }
        this.trailerBufs.clear();
    }

    @Override // org.apache.hc.core5.http.nio.ContentDecoder
    public int read(ByteBuffer byteBuffer) throws IOException {
        Args.notNull(byteBuffer, "Byte buffer");
        if (this.state == State.COMPLETED) {
            return -1;
        }
        int i = 0;
        while (this.state != State.COMPLETED) {
            if ((!this.buffer.hasData() || this.chunkSize == -1) && fillBufferFromChannel() == -1) {
                this.endOfStream = true;
            }
            int i2 = AnonymousClass1.$SwitchMap$org$apache$hc$core5$http$impl$nio$ChunkDecoder$State[this.state.ordinal()];
            if (i2 == 1) {
                if (this.chunkSize == -1) {
                    readChunkHead();
                    long j = this.chunkSize;
                    if (j == -1) {
                        break;
                    }
                    if (j == 0) {
                        this.chunkSize = -1L;
                        this.state = State.READ_FOOTERS;
                    }
                }
                int i3 = this.buffer.read(byteBuffer, (int) Math.min(this.chunkSize - this.pos, SieveCacheKt.NodeLinkMask));
                if (i3 > 0) {
                    this.pos += (long) i3;
                    i += i3;
                } else if (!this.buffer.hasData() && this.endOfStream) {
                    this.state = State.COMPLETED;
                    setCompleted();
                    throw new TruncatedChunkException("Truncated chunk (expected size: %d; actual size: %d)", Long.valueOf(this.chunkSize), Long.valueOf(this.pos));
                }
                if (this.pos != this.chunkSize) {
                    break;
                }
                this.chunkSize = -1L;
                this.pos = 0L;
                this.endOfChunk = true;
            } else if (i2 == 2) {
                CharArrayBuffer charArrayBuffer = this.lineBuf;
                if (charArrayBuffer == null) {
                    this.lineBuf = new CharArrayBuffer(32);
                } else {
                    charArrayBuffer.clear();
                }
                if (!this.buffer.readLine(this.lineBuf, this.endOfStream)) {
                    if (!this.endOfStream) {
                        break;
                    }
                    this.state = State.COMPLETED;
                    setCompleted();
                    return i;
                }
                if (this.lineBuf.length() > 0) {
                    int maxHeaderCount = this.http1Config.getMaxHeaderCount();
                    if (maxHeaderCount > 0 && this.trailerBufs.size() >= maxHeaderCount) {
                        throw new MessageConstraintException("Maximum header count exceeded");
                    }
                    parseHeader();
                } else {
                    this.state = State.COMPLETED;
                    setCompleted();
                    processFooters();
                }
            } else {
                continue;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: org.apache.hc.core5.http.impl.nio.ChunkDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$hc$core5$http$impl$nio$ChunkDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$org$apache$hc$core5$http$impl$nio$ChunkDecoder$State = iArr;
            try {
                iArr[State.READ_CONTENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$hc$core5$http$impl$nio$ChunkDecoder$State[State.READ_FOOTERS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // org.apache.hc.core5.http.impl.nio.AbstractContentDecoder, org.apache.hc.core5.http.nio.ContentDecoder
    public List<? extends Header> getTrailers() {
        if (this.trailers.isEmpty()) {
            return null;
        }
        return new ArrayList(this.trailers);
    }

    public String toString() {
        return "[chunk-coded; completed: " + this.completed + "]";
    }
}
