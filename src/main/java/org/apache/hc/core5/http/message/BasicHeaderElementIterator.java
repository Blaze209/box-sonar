package org.apache.hc.core5.http.message;

import java.util.Iterator;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HeaderElement;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class BasicHeaderElementIterator extends AbstractHeaderElementIterator<HeaderElement> {
    private final HeaderValueParser parser;

    @Override // org.apache.hc.core5.http.message.AbstractHeaderElementIterator, java.util.Iterator
    public /* bridge */ /* synthetic */ boolean hasNext() {
        return super.hasNext();
    }

    @Override // org.apache.hc.core5.http.message.AbstractHeaderElementIterator, java.util.Iterator
    public /* bridge */ /* synthetic */ void remove() throws UnsupportedOperationException {
        super.remove();
    }

    public BasicHeaderElementIterator(Iterator<? extends Header> it, HeaderValueParser headerValueParser) {
        super(it);
        this.parser = (HeaderValueParser) Args.notNull(headerValueParser, "Parser");
    }

    public BasicHeaderElementIterator(Iterator<? extends Header> it) {
        this(it, BasicHeaderValueParser.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.apache.hc.core5.http.message.AbstractHeaderElementIterator
    public HeaderElement parseHeaderElement(CharSequence charSequence, ParserCursor parserCursor) {
        HeaderElement headerElement = this.parser.parseHeaderElement(charSequence, parserCursor);
        if (headerElement.getName().isEmpty() && headerElement.getValue() == null) {
            return null;
        }
        return headerElement;
    }
}
