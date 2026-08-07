package org.apache.hc.core5.http.nio;

import java.io.IOException;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.MessageHeaders;

/* JADX INFO: loaded from: classes5.dex */
public interface NHttpMessageParser<T extends MessageHeaders> {
    T parse(SessionInputBuffer sessionInputBuffer, boolean z) throws HttpException, IOException;

    void reset();
}
