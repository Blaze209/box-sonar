package org.apache.hc.core5.http.message;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class BasicHeaderIterator implements Iterator<Header> {
    private final Header[] allHeaders;
    private int currentIndex = findNext(-1);
    private final String headerName;

    public BasicHeaderIterator(Header[] headerArr, String str) {
        this.allHeaders = (Header[]) Args.notNull(headerArr, "Header array");
        this.headerName = str;
    }

    private int findNext(int i) {
        if (i < -1) {
            return -1;
        }
        int length = this.allHeaders.length - 1;
        boolean zFilterHeader = false;
        while (!zFilterHeader && i < length) {
            i++;
            zFilterHeader = filterHeader(i);
        }
        if (zFilterHeader) {
            return i;
        }
        return -1;
    }

    private boolean filterHeader(int i) {
        String str = this.headerName;
        return str == null || str.equalsIgnoreCase(this.allHeaders[i].getName());
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.currentIndex >= 0;
    }

    @Override // java.util.Iterator
    public Header next() throws NoSuchElementException {
        int i = this.currentIndex;
        if (i < 0) {
            throw new NoSuchElementException("Iteration already finished.");
        }
        this.currentIndex = findNext(i);
        return this.allHeaders[i];
    }

    @Override // java.util.Iterator
    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Removing headers is not supported.");
    }
}
