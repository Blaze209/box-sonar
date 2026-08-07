package org.apache.hc.core5.http.nio.entity;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.UnsupportedCharsetException;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.config.CharCodingConfig;
import org.apache.hc.core5.http.nio.AsyncEntityConsumer;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractCharAsyncEntityConsumer<T> extends AbstractCharDataConsumer implements AsyncEntityConsumer<T> {
    private volatile T content;
    private volatile FutureCallback<T> resultCallback;

    protected abstract T generateContent() throws IOException;

    protected abstract void streamStart(ContentType contentType) throws HttpException, IOException;

    protected AbstractCharAsyncEntityConsumer(int i, CharCodingConfig charCodingConfig) {
        super(i, charCodingConfig);
    }

    public AbstractCharAsyncEntityConsumer() {
    }

    @Override // org.apache.hc.core5.http.nio.AsyncEntityConsumer
    public final void streamStart(EntityDetails entityDetails, FutureCallback<T> futureCallback) throws HttpException, IOException {
        ContentType contentType;
        Args.notNull(futureCallback, "Result callback");
        this.resultCallback = futureCallback;
        if (entityDetails != null) {
            try {
                contentType = ContentType.parse(entityDetails.getContentType());
            } catch (UnsupportedCharsetException e) {
                throw new UnsupportedEncodingException(e.getMessage());
            }
        } else {
            contentType = null;
        }
        setCharset(ContentType.getCharset(contentType, null));
        streamStart(contentType);
    }

    @Override // org.apache.hc.core5.http.nio.entity.AbstractCharDataConsumer
    protected final void completed() throws IOException {
        this.content = generateContent();
        if (this.resultCallback != null) {
            this.resultCallback.completed(this.content);
        }
        releaseResources();
    }

    @Override // org.apache.hc.core5.http.nio.AsyncEntityConsumer
    public final void failed(Exception exc) {
        if (this.resultCallback != null) {
            this.resultCallback.failed(exc);
        }
        releaseResources();
    }

    @Override // org.apache.hc.core5.http.nio.AsyncEntityConsumer
    public final T getContent() {
        return this.content;
    }
}
