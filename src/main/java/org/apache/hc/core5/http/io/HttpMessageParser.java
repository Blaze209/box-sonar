package org.apache.hc.core5.http.io;

import java.io.IOException;
import java.io.InputStream;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.MessageHeaders;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpMessageParser<T extends MessageHeaders> {
    T parse(SessionInputBuffer sessionInputBuffer, InputStream inputStream) throws HttpException, IOException;
}
