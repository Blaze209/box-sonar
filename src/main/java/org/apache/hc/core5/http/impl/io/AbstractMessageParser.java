package org.apache.hc.core5.http.impl.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.hc.core5.http.ConnectionClosedException;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpMessage;
import org.apache.hc.core5.http.MessageConstraintException;
import org.apache.hc.core5.http.config.Http1Config;
import org.apache.hc.core5.http.io.HttpMessageParser;
import org.apache.hc.core5.http.io.SessionInputBuffer;
import org.apache.hc.core5.http.message.LazyLineParser;
import org.apache.hc.core5.http.message.LineParser;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractMessageParser<T extends HttpMessage> implements HttpMessageParser<T> {
    private static final int HEADERS = 1;
    private static final int HEAD_LINE = 0;
    private final CharArrayBuffer headLine;
    private final List<CharArrayBuffer> headerLines;
    private final Http1Config http1Config;
    private final LineParser lineParser;
    private T message;
    private int state;

    protected abstract T createMessage(CharArrayBuffer charArrayBuffer) throws HttpException, IOException;

    public AbstractMessageParser(Http1Config http1Config, LineParser lineParser) {
        this.http1Config = http1Config == null ? Http1Config.DEFAULT : http1Config;
        this.lineParser = lineParser == null ? LazyLineParser.INSTANCE : lineParser;
        this.headerLines = new ArrayList();
        this.headLine = new CharArrayBuffer(128);
        this.state = 0;
    }

    @Deprecated
    public AbstractMessageParser(LineParser lineParser, Http1Config http1Config) {
        this(http1Config, lineParser);
    }

    LineParser getLineParser() {
        return this.lineParser;
    }

    public static Header[] parseHeaders(SessionInputBuffer sessionInputBuffer, InputStream inputStream, int i, int i2, LineParser lineParser) throws HttpException, IOException {
        ArrayList arrayList = new ArrayList();
        if (lineParser == null) {
            lineParser = LazyLineParser.INSTANCE;
        }
        return parseHeaders(sessionInputBuffer, inputStream, i, i2, lineParser, arrayList);
    }

    public static Header[] parseHeaders(SessionInputBuffer sessionInputBuffer, InputStream inputStream, int i, int i2, LineParser lineParser, List<CharArrayBuffer> list) throws HttpException, IOException {
        int i3;
        char cCharAt;
        Args.notNull(sessionInputBuffer, "Session input buffer");
        Args.notNull(inputStream, "Input stream");
        Args.notNull(lineParser, "Line parser");
        Args.notNull(list, "Header line list");
        CharArrayBuffer charArrayBuffer = null;
        CharArrayBuffer charArrayBuffer2 = null;
        while (true) {
            if (charArrayBuffer == null) {
                charArrayBuffer = new CharArrayBuffer(64);
            } else {
                charArrayBuffer.clear();
            }
            i3 = 0;
            if (sessionInputBuffer.readLine(charArrayBuffer, inputStream) == -1 || charArrayBuffer.length() < 1) {
                break;
            }
            if ((charArrayBuffer.charAt(0) == ' ' || charArrayBuffer.charAt(0) == '\t') && charArrayBuffer2 != null) {
                while (i3 < charArrayBuffer.length() && ((cCharAt = charArrayBuffer.charAt(i3)) == ' ' || cCharAt == '\t')) {
                    i3++;
                }
                if (i2 > 0 && ((charArrayBuffer2.length() + 1) + charArrayBuffer.length()) - i3 > i2) {
                    throw new MessageConstraintException("Maximum line length limit exceeded");
                }
                charArrayBuffer2.append(' ');
                charArrayBuffer2.append(charArrayBuffer, i3, charArrayBuffer.length() - i3);
            } else {
                list.add(charArrayBuffer);
                charArrayBuffer2 = charArrayBuffer;
                charArrayBuffer = null;
            }
            if (i > 0 && list.size() >= i) {
                throw new MessageConstraintException("Maximum header count exceeded");
            }
        }
        Header[] headerArr = new Header[list.size()];
        while (i3 < list.size()) {
            headerArr[i3] = lineParser.parseHeader(list.get(i3));
            i3++;
        }
        return headerArr;
    }

    @Deprecated
    protected IOException createConnectionClosedException() {
        return new ConnectionClosedException();
    }

    @Override // org.apache.hc.core5.http.io.HttpMessageParser
    public T parse(SessionInputBuffer sessionInputBuffer, InputStream inputStream) throws HttpException, IOException {
        Args.notNull(sessionInputBuffer, "Session input buffer");
        Args.notNull(inputStream, "Input stream");
        int i = this.state;
        if (i == 0) {
            for (int i2 = 0; i2 < this.http1Config.getMaxEmptyLineCount(); i2++) {
                this.headLine.clear();
                if (sessionInputBuffer.readLine(this.headLine, inputStream) == -1) {
                    return null;
                }
                if (this.headLine.length() > 0) {
                    T t = (T) createMessage(this.headLine);
                    this.message = t;
                    if (t != null) {
                        break;
                    }
                }
            }
            if (this.message == null) {
                throw new MessageConstraintException("Maximum empty line limit exceeded");
            }
            this.state = 1;
        } else if (i != 1) {
            throw new IllegalStateException("Inconsistent parser state");
        }
        this.message.setHeaders(parseHeaders(sessionInputBuffer, inputStream, this.http1Config.getMaxHeaderCount(), this.http1Config.getMaxLineLength(), this.lineParser, this.headerLines));
        T t2 = this.message;
        this.message = null;
        this.headerLines.clear();
        this.state = 0;
        return t2;
    }
}
