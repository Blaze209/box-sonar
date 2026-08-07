package org.apache.hc.core5.http.nio.entity;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.util.ByteArrayBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class BasicAsyncEntityConsumer extends AbstractBinAsyncEntityConsumer<byte[]> {
    private final ByteArrayBuffer buffer = new ByteArrayBuffer(1024);

    @Override // org.apache.hc.core5.http.nio.entity.AbstractBinDataConsumer
    protected int capacityIncrement() {
        return Integer.MAX_VALUE;
    }

    @Override // org.apache.hc.core5.http.nio.entity.AbstractBinAsyncEntityConsumer
    protected void streamStart(ContentType contentType) throws HttpException, IOException {
    }

    @Override // org.apache.hc.core5.http.nio.entity.AbstractBinDataConsumer
    protected void data(ByteBuffer byteBuffer, boolean z) throws IOException {
        this.buffer.append(byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.hc.core5.http.nio.entity.AbstractBinAsyncEntityConsumer
    public byte[] generateContent() throws IOException {
        return this.buffer.toByteArray();
    }

    @Override // org.apache.hc.core5.http.nio.ResourceHolder
    public void releaseResources() {
        this.buffer.clear();
    }
}
