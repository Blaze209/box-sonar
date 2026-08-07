package external.sdk.pendo.io.glide.load.data;

import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public final class InputStreamRewinder implements b<InputStream> {
    private static final int MARK_READ_LIMIT = 5242880;
    private final sdk.pendo.io.n.a bufferedStream;

    public static final class Factory implements b.a<InputStream> {
        private final sdk.pendo.io.i.a byteArrayPool;

        public Factory(sdk.pendo.io.i.a aVar) {
            this.byteArrayPool = aVar;
        }

        @Override // external.sdk.pendo.io.glide.load.data.b.a
        public b<InputStream> build(InputStream inputStream) {
            return new InputStreamRewinder(inputStream, this.byteArrayPool);
        }

        @Override // external.sdk.pendo.io.glide.load.data.b.a
        public Class<InputStream> getDataClass() {
            return InputStream.class;
        }
    }

    public InputStreamRewinder(InputStream inputStream, sdk.pendo.io.i.a aVar) {
        sdk.pendo.io.n.a aVar2 = new sdk.pendo.io.n.a(inputStream, aVar);
        this.bufferedStream = aVar2;
        aVar2.mark(MARK_READ_LIMIT);
    }

    @Override // external.sdk.pendo.io.glide.load.data.b
    public void cleanup() {
        this.bufferedStream.b();
    }

    public void fixMarkLimits() {
        this.bufferedStream.a();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // external.sdk.pendo.io.glide.load.data.b
    public InputStream rewindAndGet() {
        this.bufferedStream.reset();
        return this.bufferedStream;
    }
}
