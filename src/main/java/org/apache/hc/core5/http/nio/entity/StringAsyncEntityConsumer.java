package org.apache.hc.core5.http.nio.entity;

import java.io.IOException;
import java.nio.CharBuffer;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.config.CharCodingConfig;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class StringAsyncEntityConsumer extends AbstractCharAsyncEntityConsumer<String> {
    private final int capacityIncrement;
    private final CharArrayBuffer content;

    @Override // org.apache.hc.core5.http.nio.entity.AbstractCharAsyncEntityConsumer
    protected final void streamStart(ContentType contentType) throws HttpException, IOException {
    }

    public StringAsyncEntityConsumer(int i, int i2, CharCodingConfig charCodingConfig) {
        super(i, charCodingConfig);
        this.capacityIncrement = Args.positive(i2, "Capacity increment");
        this.content = new CharArrayBuffer(1024);
    }

    public StringAsyncEntityConsumer(int i) {
        this(8192, i, CharCodingConfig.DEFAULT);
    }

    public StringAsyncEntityConsumer(CharCodingConfig charCodingConfig) {
        this(8192, Integer.MAX_VALUE, charCodingConfig);
    }

    public StringAsyncEntityConsumer() {
        this(Integer.MAX_VALUE);
    }

    @Override // org.apache.hc.core5.http.nio.entity.AbstractCharDataConsumer
    protected int capacityIncrement() {
        return Math.max(this.capacityIncrement, this.content.capacity() - this.content.length());
    }

    @Override // org.apache.hc.core5.http.nio.entity.AbstractCharDataConsumer
    protected final void data(CharBuffer charBuffer, boolean z) {
        Args.notNull(charBuffer, "CharBuffer");
        int iRemaining = charBuffer.remaining();
        this.content.ensureCapacity(iRemaining);
        charBuffer.get(this.content.array(), this.content.length(), iRemaining);
        CharArrayBuffer charArrayBuffer = this.content;
        charArrayBuffer.setLength(charArrayBuffer.length() + iRemaining);
    }

    @Override // org.apache.hc.core5.http.nio.entity.AbstractCharAsyncEntityConsumer
    public String generateContent() {
        return this.content.toString();
    }

    @Override // org.apache.hc.core5.http.nio.ResourceHolder
    public void releaseResources() {
        this.content.clear();
    }
}
