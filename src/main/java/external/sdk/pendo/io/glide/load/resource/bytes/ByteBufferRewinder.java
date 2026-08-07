package external.sdk.pendo.io.glide.load.resource.bytes;

import external.sdk.pendo.io.glide.load.data.b;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public class ByteBufferRewinder implements b<ByteBuffer> {
    private final ByteBuffer buffer;

    public static class Factory implements b.a<ByteBuffer> {
        @Override // external.sdk.pendo.io.glide.load.data.b.a
        public Class<ByteBuffer> getDataClass() {
            return ByteBuffer.class;
        }

        @Override // external.sdk.pendo.io.glide.load.data.b.a
        public b<ByteBuffer> build(ByteBuffer byteBuffer) {
            return new ByteBufferRewinder(byteBuffer);
        }
    }

    public ByteBufferRewinder(ByteBuffer byteBuffer) {
        this.buffer = byteBuffer;
    }

    @Override // external.sdk.pendo.io.glide.load.data.b
    public void cleanup() {
    }

    @Override // external.sdk.pendo.io.glide.load.data.b
    public ByteBuffer rewindAndGet() {
        this.buffer.position(0);
        return this.buffer;
    }
}
