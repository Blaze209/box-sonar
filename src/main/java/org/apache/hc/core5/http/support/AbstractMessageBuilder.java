package org.apache.hc.core5.http.support;

import java.util.Iterator;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpMessage;
import org.apache.hc.core5.http.ProtocolVersion;
import org.apache.hc.core5.http.message.BasicHeader;
import org.apache.hc.core5.http.message.HeaderGroup;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractMessageBuilder<T> {
    private HeaderGroup headerGroup;
    private ProtocolVersion version;

    protected abstract T build();

    protected AbstractMessageBuilder() {
    }

    protected void digest(HttpMessage httpMessage) {
        if (httpMessage == null) {
            return;
        }
        setVersion(httpMessage.getVersion());
        setHeaders(httpMessage.headerIterator());
    }

    public ProtocolVersion getVersion() {
        return this.version;
    }

    public AbstractMessageBuilder<T> setVersion(ProtocolVersion protocolVersion) {
        this.version = protocolVersion;
        return this;
    }

    public Header[] getHeaders() {
        HeaderGroup headerGroup = this.headerGroup;
        if (headerGroup != null) {
            return headerGroup.getHeaders();
        }
        return null;
    }

    public Header[] getHeaders(String str) {
        HeaderGroup headerGroup = this.headerGroup;
        if (headerGroup != null) {
            return headerGroup.getHeaders(str);
        }
        return null;
    }

    public AbstractMessageBuilder<T> setHeaders(Header... headerArr) {
        if (this.headerGroup == null) {
            this.headerGroup = new HeaderGroup();
        }
        this.headerGroup.setHeaders(headerArr);
        return this;
    }

    public AbstractMessageBuilder<T> setHeaders(Iterator<Header> it) {
        HeaderGroup headerGroup = this.headerGroup;
        if (headerGroup == null) {
            this.headerGroup = new HeaderGroup();
        } else {
            headerGroup.clear();
        }
        while (it.hasNext()) {
            this.headerGroup.addHeader(it.next());
        }
        return this;
    }

    public Header[] getFirstHeaders() {
        HeaderGroup headerGroup = this.headerGroup;
        if (headerGroup != null) {
            return headerGroup.getHeaders();
        }
        return null;
    }

    public Header getFirstHeader(String str) {
        HeaderGroup headerGroup = this.headerGroup;
        if (headerGroup != null) {
            return headerGroup.getFirstHeader(str);
        }
        return null;
    }

    public Header getLastHeader(String str) {
        HeaderGroup headerGroup = this.headerGroup;
        if (headerGroup != null) {
            return headerGroup.getLastHeader(str);
        }
        return null;
    }

    public AbstractMessageBuilder<T> addHeader(Header header) {
        if (this.headerGroup == null) {
            this.headerGroup = new HeaderGroup();
        }
        this.headerGroup.addHeader(header);
        return this;
    }

    public AbstractMessageBuilder<T> addHeader(String str, String str2) {
        if (this.headerGroup == null) {
            this.headerGroup = new HeaderGroup();
        }
        this.headerGroup.addHeader(new BasicHeader(str, str2));
        return this;
    }

    public AbstractMessageBuilder<T> removeHeader(Header header) {
        if (this.headerGroup == null) {
            this.headerGroup = new HeaderGroup();
        }
        this.headerGroup.removeHeader(header);
        return this;
    }

    public AbstractMessageBuilder<T> removeHeaders(String str) {
        HeaderGroup headerGroup;
        if (str != null && (headerGroup = this.headerGroup) != null) {
            Iterator<Header> itHeaderIterator = headerGroup.headerIterator();
            while (itHeaderIterator.hasNext()) {
                if (str.equalsIgnoreCase(itHeaderIterator.next().getName())) {
                    itHeaderIterator.remove();
                }
            }
        }
        return this;
    }

    public AbstractMessageBuilder<T> setHeader(Header header) {
        if (this.headerGroup == null) {
            this.headerGroup = new HeaderGroup();
        }
        this.headerGroup.setHeader(header);
        return this;
    }

    public AbstractMessageBuilder<T> setHeader(String str, String str2) {
        if (this.headerGroup == null) {
            this.headerGroup = new HeaderGroup();
        }
        this.headerGroup.setHeader(new BasicHeader(str, str2));
        return this;
    }
}
