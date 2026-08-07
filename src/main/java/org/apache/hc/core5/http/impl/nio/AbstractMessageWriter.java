package org.apache.hc.core5.http.impl.nio;

import java.io.IOException;
import java.util.Iterator;
import org.apache.hc.core5.http.FormattedHeader;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpMessage;
import org.apache.hc.core5.http.message.BasicLineFormatter;
import org.apache.hc.core5.http.message.LineFormatter;
import org.apache.hc.core5.http.nio.NHttpMessageWriter;
import org.apache.hc.core5.http.nio.SessionOutputBuffer;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractMessageWriter<T extends HttpMessage> implements NHttpMessageWriter<T> {
    private final CharArrayBuffer lineBuf;
    private final LineFormatter lineFormatter;

    @Override // org.apache.hc.core5.http.nio.NHttpMessageWriter
    public void reset() {
    }

    protected abstract void writeHeadLine(T t, CharArrayBuffer charArrayBuffer) throws IOException;

    public AbstractMessageWriter(LineFormatter lineFormatter) {
        this.lineFormatter = lineFormatter == null ? BasicLineFormatter.INSTANCE : lineFormatter;
        this.lineBuf = new CharArrayBuffer(64);
    }

    LineFormatter getLineFormatter() {
        return this.lineFormatter;
    }

    @Override // org.apache.hc.core5.http.nio.NHttpMessageWriter
    public void write(T t, SessionOutputBuffer sessionOutputBuffer) throws HttpException, IOException {
        Args.notNull(t, "HTTP message");
        Args.notNull(sessionOutputBuffer, "Session output buffer");
        writeHeadLine(t, this.lineBuf);
        sessionOutputBuffer.writeLine(this.lineBuf);
        Iterator<Header> itHeaderIterator = t.headerIterator();
        while (itHeaderIterator.hasNext()) {
            Header next = itHeaderIterator.next();
            if (next instanceof FormattedHeader) {
                sessionOutputBuffer.writeLine(((FormattedHeader) next).getBuffer());
            } else {
                this.lineBuf.clear();
                this.lineFormatter.formatHeader(this.lineBuf, next);
                sessionOutputBuffer.writeLine(this.lineBuf);
            }
        }
        this.lineBuf.clear();
        sessionOutputBuffer.writeLine(this.lineBuf);
    }
}
