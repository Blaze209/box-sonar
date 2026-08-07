package org.apache.hc.core5.http;

import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public interface MessageHeaders {
    boolean containsHeader(String str);

    int countHeaders(String str);

    Header getFirstHeader(String str);

    Header getHeader(String str) throws ProtocolException;

    Header[] getHeaders();

    Header[] getHeaders(String str);

    Header getLastHeader(String str);

    Iterator<Header> headerIterator();

    Iterator<Header> headerIterator(String str);
}
