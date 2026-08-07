package org.apache.hc.core5.http.impl.io;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import org.apache.hc.core5.http.FormattedHeader;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpMessage;
import org.apache.hc.core5.http.io.HttpMessageWriter;
import org.apache.hc.core5.http.io.SessionOutputBuffer;
import org.apache.hc.core5.http.message.BasicLineFormatter;
import org.apache.hc.core5.http.message.LineFormatter;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractMessageWriter<T extends HttpMessage> implements HttpMessageWriter<T> {
    private final CharArrayBuffer lineBuf;
    private final LineFormatter lineFormatter;

    protected abstract void writeHeadLine(T t, CharArrayBuffer charArrayBuffer) throws IOException;

    public AbstractMessageWriter(LineFormatter lineFormatter) {
        this.lineFormatter = lineFormatter == null ? BasicLineFormatter.INSTANCE : lineFormatter;
        this.lineBuf = new CharArrayBuffer(128);
    }

    LineFormatter getLineFormatter() {
        return this.lineFormatter;
    }

    @Override // org.apache.hc.core5.http.io.HttpMessageWriter
    public void write(T t, SessionOutputBuffer sessionOutputBuffer, OutputStream outputStream) throws HttpException, IOException {
        Args.notNull(t, "HTTP message");
        Args.notNull(sessionOutputBuffer, "Session output buffer");
        Args.notNull(outputStream, "Output stream");
        writeHeadLine(t, this.lineBuf);
        sessionOutputBuffer.writeLine(this.lineBuf, outputStream);
        Iterator<Header> itHeaderIterator = t.headerIterator();
        while (itHeaderIterator.hasNext()) {
            Header next = itHeaderIterator.next();
            if (next instanceof FormattedHeader) {
                sessionOutputBuffer.writeLine(((FormattedHeader) next).getBuffer(), outputStream);
            } else {
                this.lineBuf.clear();
                this.lineFormatter.formatHeader(this.lineBuf, next);
                sessionOutputBuffer.writeLine(this.lineBuf, outputStream);
            }
        }
        this.lineBuf.clear();
        sessionOutputBuffer.writeLine(this.lineBuf, outputStream);
    }
}
