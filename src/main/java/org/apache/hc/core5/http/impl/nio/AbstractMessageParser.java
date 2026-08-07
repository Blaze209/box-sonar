package org.apache.hc.core5.http.impl.nio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpMessage;
import org.apache.hc.core5.http.MessageConstraintException;
import org.apache.hc.core5.http.config.Http1Config;
import org.apache.hc.core5.http.message.LazyLineParser;
import org.apache.hc.core5.http.message.LineParser;
import org.apache.hc.core5.http.nio.NHttpMessageParser;
import org.apache.hc.core5.http.nio.SessionInputBuffer;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractMessageParser<T extends HttpMessage> implements NHttpMessageParser<T> {
    private int emptyLineCount;
    private final List<CharArrayBuffer> headerBufs;
    private final Http1Config http1Config;
    private CharArrayBuffer lineBuf;
    private final LineParser lineParser;
    private T message;
    private State state;

    private enum State {
        READ_HEAD_LINE,
        READ_HEADERS,
        COMPLETED
    }

    protected abstract T createMessage(CharArrayBuffer charArrayBuffer) throws HttpException;

    public AbstractMessageParser(Http1Config http1Config, LineParser lineParser) {
        this.http1Config = http1Config == null ? Http1Config.DEFAULT : http1Config;
        this.lineParser = lineParser == null ? LazyLineParser.INSTANCE : lineParser;
        this.headerBufs = new ArrayList();
        this.state = State.READ_HEAD_LINE;
    }

    @Deprecated
    public AbstractMessageParser(LineParser lineParser, Http1Config http1Config) {
        this(http1Config, lineParser);
    }

    LineParser getLineParser() {
        return this.lineParser;
    }

    @Override // org.apache.hc.core5.http.nio.NHttpMessageParser
    public void reset() {
        this.state = State.READ_HEAD_LINE;
        this.headerBufs.clear();
        this.emptyLineCount = 0;
        this.message = null;
    }

    private T parseHeadLine() throws HttpException, IOException {
        if (this.lineBuf.isEmpty()) {
            int i = this.emptyLineCount + 1;
            this.emptyLineCount = i;
            if (i < this.http1Config.getMaxEmptyLineCount()) {
                return null;
            }
            throw new MessageConstraintException("Maximum empty line limit exceeded");
        }
        return (T) createMessage(this.lineBuf);
    }

    private void parseHeader() throws IOException {
        char cCharAt;
        CharArrayBuffer charArrayBuffer = this.lineBuf;
        int size = this.headerBufs.size();
        int i = 0;
        if ((this.lineBuf.charAt(0) == ' ' || this.lineBuf.charAt(0) == '\t') && size > 0) {
            CharArrayBuffer charArrayBuffer2 = this.headerBufs.get(size - 1);
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
        this.headerBufs.add(charArrayBuffer);
        this.lineBuf = null;
    }

    @Override // org.apache.hc.core5.http.nio.NHttpMessageParser
    public T parse(SessionInputBuffer sessionInputBuffer, boolean z) throws HttpException, IOException {
        Args.notNull(sessionInputBuffer, "Session input buffer");
        while (this.state != State.COMPLETED) {
            CharArrayBuffer charArrayBuffer = this.lineBuf;
            if (charArrayBuffer == null) {
                this.lineBuf = new CharArrayBuffer(64);
            } else {
                charArrayBuffer.clear();
            }
            boolean line = sessionInputBuffer.readLine(this.lineBuf, z);
            int maxLineLength = this.http1Config.getMaxLineLength();
            if (maxLineLength > 0 && (this.lineBuf.length() > maxLineLength || (!line && sessionInputBuffer.length() > maxLineLength))) {
                throw new MessageConstraintException("Maximum line length limit exceeded");
            }
            if (!line) {
                break;
            }
            int i = AnonymousClass1.$SwitchMap$org$apache$hc$core5$http$impl$nio$AbstractMessageParser$State[this.state.ordinal()];
            if (i == 1) {
                T t = (T) parseHeadLine();
                this.message = t;
                if (t != null) {
                    this.state = State.READ_HEADERS;
                }
            } else if (i == 2) {
                if (this.lineBuf.length() > 0) {
                    int maxHeaderCount = this.http1Config.getMaxHeaderCount();
                    if (maxHeaderCount > 0 && this.headerBufs.size() >= maxHeaderCount) {
                        throw new MessageConstraintException("Maximum header count exceeded");
                    }
                    parseHeader();
                } else {
                    this.state = State.COMPLETED;
                }
            }
            if (z && !sessionInputBuffer.hasData()) {
                this.state = State.COMPLETED;
            }
        }
        if (this.state != State.COMPLETED) {
            return null;
        }
        Iterator<CharArrayBuffer> it = this.headerBufs.iterator();
        while (it.hasNext()) {
            this.message.addHeader(this.lineParser.parseHeader(it.next()));
        }
        return this.message;
    }

    /* JADX INFO: renamed from: org.apache.hc.core5.http.impl.nio.AbstractMessageParser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$hc$core5$http$impl$nio$AbstractMessageParser$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$org$apache$hc$core5$http$impl$nio$AbstractMessageParser$State = iArr;
            try {
                iArr[State.READ_HEAD_LINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$hc$core5$http$impl$nio$AbstractMessageParser$State[State.READ_HEADERS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
