package org.apache.hc.core5.http.message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.MessageHeaders;
import org.apache.hc.core5.http.ProtocolException;
import org.apache.hc.core5.util.CharArrayBuffer;
import org.apache.hc.core5.util.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
public class HeaderGroup implements MessageHeaders, Serializable {
    private static final Header[] EMPTY = new Header[0];
    private static final long serialVersionUID = 2608834160639271617L;
    private final List<Header> headers = new ArrayList(16);

    public void clear() {
        this.headers.clear();
    }

    public void addHeader(Header header) {
        if (header == null) {
            return;
        }
        this.headers.add(header);
    }

    public boolean removeHeader(Header header) {
        if (header == null) {
            return false;
        }
        for (int i = 0; i < this.headers.size(); i++) {
            Header header2 = this.headers.get(i);
            if (headerEquals(header, header2)) {
                this.headers.remove(header2);
                return true;
            }
        }
        return false;
    }

    private boolean headerEquals(Header header, Header header2) {
        if (header2 != header) {
            return header2.getName().equalsIgnoreCase(header.getName()) && Objects.equals(header.getValue(), header2.getValue());
        }
        return true;
    }

    public boolean removeHeaders(Header header) {
        boolean z = false;
        if (header == null) {
            return false;
        }
        Iterator<Header> itHeaderIterator = headerIterator();
        while (itHeaderIterator.hasNext()) {
            if (headerEquals(header, itHeaderIterator.next())) {
                itHeaderIterator.remove();
                z = true;
            }
        }
        return z;
    }

    public void setHeader(Header header) {
        if (header == null) {
            return;
        }
        for (int i = 0; i < this.headers.size(); i++) {
            if (this.headers.get(i).getName().equalsIgnoreCase(header.getName())) {
                this.headers.set(i, header);
                return;
            }
        }
        this.headers.add(header);
    }

    public void setHeaders(Header... headerArr) {
        clear();
        if (headerArr == null) {
            return;
        }
        Collections.addAll(this.headers, headerArr);
    }

    public Header getCondensedHeader(String str) {
        Header[] headers = getHeaders(str);
        if (headers.length == 0) {
            return null;
        }
        if (headers.length == 1) {
            return headers[0];
        }
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(128);
        charArrayBuffer.append(headers[0].getValue());
        for (int i = 1; i < headers.length; i++) {
            charArrayBuffer.append(", ");
            charArrayBuffer.append(headers[i].getValue());
        }
        return new BasicHeader(TextUtils.toLowerCase(str), charArrayBuffer.toString());
    }

    @Override // org.apache.hc.core5.http.MessageHeaders
    public Header[] getHeaders(String str) {
        ArrayList arrayList = null;
        for (int i = 0; i < this.headers.size(); i++) {
            Header header = this.headers.get(i);
            if (header.getName().equalsIgnoreCase(str)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(header);
            }
        }
        Header[] headerArr = EMPTY;
        return arrayList != null ? (Header[]) arrayList.toArray(headerArr) : headerArr;
    }

    @Override // org.apache.hc.core5.http.MessageHeaders
    public Header getFirstHeader(String str) {
        for (int i = 0; i < this.headers.size(); i++) {
            Header header = this.headers.get(i);
            if (header.getName().equalsIgnoreCase(str)) {
                return header;
            }
        }
        return null;
    }

    @Override // org.apache.hc.core5.http.MessageHeaders
    public Header getHeader(String str) throws ProtocolException {
        Header header = null;
        int i = 0;
        for (int i2 = 0; i2 < this.headers.size(); i2++) {
            Header header2 = this.headers.get(i2);
            if (header2.getName().equalsIgnoreCase(str)) {
                i++;
                header = header2;
            }
        }
        if (i <= 1) {
            return header;
        }
        throw new ProtocolException("multiple '%s' headers found", str);
    }

    @Override // org.apache.hc.core5.http.MessageHeaders
    public Header getLastHeader(String str) {
        for (int size = this.headers.size() - 1; size >= 0; size--) {
            Header header = this.headers.get(size);
            if (header.getName().equalsIgnoreCase(str)) {
                return header;
            }
        }
        return null;
    }

    @Override // org.apache.hc.core5.http.MessageHeaders
    public Header[] getHeaders() {
        return (Header[]) this.headers.toArray(EMPTY);
    }

    @Override // org.apache.hc.core5.http.MessageHeaders
    public boolean containsHeader(String str) {
        for (int i = 0; i < this.headers.size(); i++) {
            if (this.headers.get(i).getName().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.hc.core5.http.MessageHeaders
    public int countHeaders(String str) {
        int i = 0;
        for (int i2 = 0; i2 < this.headers.size(); i2++) {
            if (this.headers.get(i2).getName().equalsIgnoreCase(str)) {
                i++;
            }
        }
        return i;
    }

    @Override // org.apache.hc.core5.http.MessageHeaders
    public Iterator<Header> headerIterator() {
        return new BasicListHeaderIterator(this.headers, null);
    }

    @Override // org.apache.hc.core5.http.MessageHeaders
    public Iterator<Header> headerIterator(String str) {
        return new BasicListHeaderIterator(this.headers, str);
    }

    public boolean removeHeaders(String str) {
        boolean z = false;
        if (str == null) {
            return false;
        }
        Iterator<Header> itHeaderIterator = headerIterator();
        while (itHeaderIterator.hasNext()) {
            if (itHeaderIterator.next().getName().equalsIgnoreCase(str)) {
                itHeaderIterator.remove();
                z = true;
            }
        }
        return z;
    }

    public String toString() {
        return this.headers.toString();
    }
}
