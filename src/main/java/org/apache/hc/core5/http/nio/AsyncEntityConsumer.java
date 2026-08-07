package org.apache.hc.core5.http.nio;

import java.io.IOException;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.HttpException;

/* JADX INFO: loaded from: classes5.dex */
public interface AsyncEntityConsumer<T> extends AsyncDataConsumer {
    void failed(Exception exc);

    T getContent();

    void streamStart(EntityDetails entityDetails, FutureCallback<T> futureCallback) throws HttpException, IOException;
}
