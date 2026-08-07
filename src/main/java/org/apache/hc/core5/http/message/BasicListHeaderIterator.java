package org.apache.hc.core5.http.message;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.Asserts;

/* JADX INFO: loaded from: classes5.dex */
class BasicListHeaderIterator implements Iterator<Header> {
    private final List<? extends Header> allHeaders;
    private final String headerName;
    private int currentIndex = findNext(-1);
    private int lastIndex = -1;

    public BasicListHeaderIterator(List<? extends Header> list, String str) {
        this.allHeaders = (List) Args.notNull(list, "Header list");
        this.headerName = str;
    }

    protected int findNext(int i) {
        if (i < -1) {
            return -1;
        }
        int size = this.allHeaders.size() - 1;
        boolean zFilterHeader = false;
        while (!zFilterHeader && i < size) {
            i++;
            zFilterHeader = filterHeader(i);
        }
        if (zFilterHeader) {
            return i;
        }
        return -1;
    }

    private boolean filterHeader(int i) {
        if (this.headerName == null) {
            return true;
        }
        return this.headerName.equalsIgnoreCase(this.allHeaders.get(i).getName());
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
        this.lastIndex = i;
        this.currentIndex = findNext(i);
        return this.allHeaders.get(i);
    }

    @Override // java.util.Iterator
    public void remove() throws UnsupportedOperationException {
        Asserts.check(this.lastIndex >= 0, "No header to remove");
        this.allHeaders.remove(this.lastIndex);
        this.lastIndex = -1;
        this.currentIndex--;
    }
}
