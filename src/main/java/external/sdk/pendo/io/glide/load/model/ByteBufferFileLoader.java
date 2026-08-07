package external.sdk.pendo.io.glide.load.model;

import android.util.Log;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.signature.ObjectKey;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public class ByteBufferFileLoader implements b<File, ByteBuffer> {
    private static final String TAG = "ByteBufferFileLoader";

    public static class Factory implements sdk.pendo.io.l.d<File, ByteBuffer> {
        @Override // sdk.pendo.io.l.d
        public b<File, ByteBuffer> build(e eVar) {
            return new ByteBufferFileLoader();
        }

        public void teardown() {
        }
    }

    private static final class a implements external.sdk.pendo.io.glide.load.data.a<ByteBuffer> {
        private final File a;

        a(File file) {
            this.a = file;
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void cancel() {
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void cleanup() {
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public Class<ByteBuffer> getDataClass() {
            return ByteBuffer.class;
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public sdk.pendo.io.e.a getDataSource() {
            return sdk.pendo.io.e.a.LOCAL;
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void loadData(sdk.pendo.io.c.b bVar, external.sdk.pendo.io.glide.load.data.a.InterfaceC0307a<? super ByteBuffer> interfaceC0307a) {
            try {
                interfaceC0307a.a(sdk.pendo.io.y.a.a(this.a));
            } catch (IOException e) {
                if (Log.isLoggable(ByteBufferFileLoader.TAG, 3)) {
                    Log.d(ByteBufferFileLoader.TAG, "Failed to obtain ByteBuffer for file", e);
                }
                interfaceC0307a.a((Exception) e);
            }
        }
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public b.a<ByteBuffer> buildLoadData(File file, int i, int i2, Options options) {
        return new b.a<>(new ObjectKey(file), new a(file));
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public boolean handles(File file) {
        return true;
    }
}
