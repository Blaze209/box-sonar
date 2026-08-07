package org.apache.hc.core5.http.impl.io;

import java.io.IOException;
import java.io.InputStream;
import org.apache.hc.core5.http.ConnectionClosedException;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.MalformedChunkCodingException;
import org.apache.hc.core5.http.StreamClosedException;
import org.apache.hc.core5.http.TruncatedChunkException;
import org.apache.hc.core5.http.config.Http1Config;
import org.apache.hc.core5.http.io.SessionInputBuffer;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class ChunkedInputStream extends InputStream {
    private static final int BUFFER_SIZE = 2048;
    private static final Header[] EMPTY_FOOTERS = new Header[0];
    private final SessionInputBuffer buffer;
    private long chunkSize;
    private boolean closed;
    private boolean eof;
    private Header[] footers;
    private final Http1Config http1Config;
    private final InputStream inputStream;
    private final CharArrayBuffer lineBuffer;
    private long pos;
    private State state;

    private enum State {
        CHUNK_LEN,
        CHUNK_DATA,
        CHUNK_CRLF,
        CHUNK_INVALID
    }

    public ChunkedInputStream(SessionInputBuffer sessionInputBuffer, InputStream inputStream, Http1Config http1Config) {
        this.footers = EMPTY_FOOTERS;
        this.buffer = (SessionInputBuffer) Args.notNull(sessionInputBuffer, "Session input buffer");
        this.inputStream = (InputStream) Args.notNull(inputStream, "Input stream");
        this.pos = 0L;
        this.lineBuffer = new CharArrayBuffer(16);
        this.http1Config = http1Config == null ? Http1Config.DEFAULT : http1Config;
        this.state = State.CHUNK_LEN;
    }

    public ChunkedInputStream(SessionInputBuffer sessionInputBuffer, InputStream inputStream) {
        this(sessionInputBuffer, inputStream, null);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return (int) Math.min(this.buffer.length(), this.chunkSize - this.pos);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.closed) {
            throw new StreamClosedException();
        }
        if (this.eof) {
            return -1;
        }
        if (this.state != State.CHUNK_DATA) {
            nextChunk();
            if (this.eof) {
                return -1;
            }
        }
        int i = this.buffer.read(this.inputStream);
        if (i != -1) {
            long j = this.pos + 1;
            this.pos = j;
            if (j >= this.chunkSize) {
                this.state = State.CHUNK_CRLF;
            }
        }
        return i;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.closed) {
            throw new StreamClosedException();
        }
        if (i2 == 0) {
            return 0;
        }
        if (this.eof) {
            return -1;
        }
        if (this.state != State.CHUNK_DATA) {
            nextChunk();
            if (this.eof) {
                return -1;
            }
        }
        int i3 = this.buffer.read(bArr, i, (int) Math.min(i2, this.chunkSize - this.pos), this.inputStream);
        if (i3 != -1) {
            long j = this.pos + ((long) i3);
            this.pos = j;
            if (j >= this.chunkSize) {
                this.state = State.CHUNK_CRLF;
            }
            return i3;
        }
        this.eof = true;
        throw new TruncatedChunkException("Truncated chunk (expected size: %d; actual size: %d)", Long.valueOf(this.chunkSize), Long.valueOf(this.pos));
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    private void nextChunk() throws IOException {
        if (this.state == State.CHUNK_INVALID) {
            throw new MalformedChunkCodingException("Corrupt data stream");
        }
        try {
            long chunkSize = getChunkSize();
            this.chunkSize = chunkSize;
            if (chunkSize < 0) {
                throw new MalformedChunkCodingException("Negative chunk size");
            }
            this.state = State.CHUNK_DATA;
            this.pos = 0L;
            if (this.chunkSize == 0) {
                this.eof = true;
                parseTrailerHeaders();
            }
        } catch (MalformedChunkCodingException e) {
            this.state = State.CHUNK_INVALID;
            throw e;
        }
    }

    /* JADX INFO: renamed from: org.apache.hc.core5.http.impl.io.ChunkedInputStream$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$hc$core5$http$impl$io$ChunkedInputStream$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$org$apache$hc$core5$http$impl$io$ChunkedInputStream$State = iArr;
            try {
                iArr[State.CHUNK_CRLF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$hc$core5$http$impl$io$ChunkedInputStream$State[State.CHUNK_LEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private long getChunkSize() throws IOException {
        int i = AnonymousClass1.$SwitchMap$org$apache$hc$core5$http$impl$io$ChunkedInputStream$State[this.state.ordinal()];
        if (i == 1) {
            this.lineBuffer.clear();
            if (this.buffer.readLine(this.lineBuffer, this.inputStream) == -1) {
                throw new MalformedChunkCodingException("CRLF expected at end of chunk");
            }
            if (!this.lineBuffer.isEmpty()) {
                throw new MalformedChunkCodingException("Unexpected content at the end of chunk");
            }
            this.state = State.CHUNK_LEN;
        } else if (i != 2) {
            throw new IllegalStateException("Inconsistent codec state");
        }
        this.lineBuffer.clear();
        if (this.buffer.readLine(this.lineBuffer, this.inputStream) == -1) {
            throw new ConnectionClosedException("Premature end of chunk coded message body: closing chunk expected");
        }
        int iIndexOf = this.lineBuffer.indexOf(59);
        if (iIndexOf < 0) {
            iIndexOf = this.lineBuffer.length();
        }
        String strSubstringTrimmed = this.lineBuffer.substringTrimmed(0, iIndexOf);
        try {
            return Long.parseLong(strSubstringTrimmed, 16);
        } catch (NumberFormatException unused) {
            throw new MalformedChunkCodingException("Bad chunk header: " + strSubstringTrimmed);
        }
    }

    private void parseTrailerHeaders() throws IOException {
        try {
            this.footers = AbstractMessageParser.parseHeaders(this.buffer, this.inputStream, this.http1Config.getMaxHeaderCount(), this.http1Config.getMaxLineLength(), null);
        } catch (HttpException e) {
            MalformedChunkCodingException malformedChunkCodingException = new MalformedChunkCodingException("Invalid trailing header: " + e.getMessage());
            malformedChunkCodingException.initCause(e);
            throw malformedChunkCodingException;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        try {
            if (!this.eof && this.state != State.CHUNK_INVALID) {
                long j = this.chunkSize;
                if (j != this.pos || j <= 0 || read() != -1) {
                    do {
                    } while (read(new byte[2048]) >= 0);
                }
            }
        } finally {
            this.eof = true;
            this.closed = true;
        }
    }

    public Header[] getFooters() {
        Header[] headerArr = this.footers;
        return headerArr.length > 0 ? (Header[]) headerArr.clone() : EMPTY_FOOTERS;
    }
}
