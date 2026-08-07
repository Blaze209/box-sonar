package org.apache.hc.core5.http.message;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.hc.core5.http.FormattedHeader;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
abstract class AbstractHeaderElementIterator<T> implements Iterator<T> {
    private CharSequence buffer;
    private T currentElement;
    private ParserCursor cursor;
    private final Iterator<? extends Header> headerIt;

    abstract T parseHeaderElement(CharSequence charSequence, ParserCursor parserCursor);

    AbstractHeaderElementIterator(Iterator<? extends Header> it) {
        this.headerIt = (Iterator) Args.notNull(it, "Header iterator");
    }

    private void bufferHeaderValue() {
        this.cursor = null;
        this.buffer = null;
        while (this.headerIt.hasNext()) {
            Header next = this.headerIt.next();
            if (next instanceof FormattedHeader) {
                FormattedHeader formattedHeader = (FormattedHeader) next;
                this.buffer = formattedHeader.getBuffer();
                ParserCursor parserCursor = new ParserCursor(0, this.buffer.length());
                this.cursor = parserCursor;
                parserCursor.updatePos(formattedHeader.getValuePos());
                return;
            }
            String value = next.getValue();
            if (value != null) {
                this.buffer = value;
                this.cursor = new ParserCursor(0, value.length());
                return;
            }
        }
    }

    private void parseNextElement() {
        while (true) {
            if (!this.headerIt.hasNext() && this.cursor == null) {
                return;
            }
            ParserCursor parserCursor = this.cursor;
            if (parserCursor == null || parserCursor.atEnd()) {
                bufferHeaderValue();
            }
            if (this.cursor != null) {
                while (!this.cursor.atEnd()) {
                    T headerElement = parseHeaderElement(this.buffer, this.cursor);
                    if (headerElement != null) {
                        this.currentElement = headerElement;
                        return;
                    }
                }
                if (this.cursor.atEnd()) {
                    this.cursor = null;
                    this.buffer = null;
                }
            }
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.currentElement == null) {
            parseNextElement();
        }
        return this.currentElement != null;
    }

    @Override // java.util.Iterator
    public T next() throws NoSuchElementException {
        if (this.currentElement == null) {
            parseNextElement();
        }
        T t = this.currentElement;
        if (t == null) {
            throw new NoSuchElementException("No more header elements available");
        }
        this.currentElement = null;
        return t;
    }

    @Override // java.util.Iterator
    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
