package external.sdk.pendo.io.glide.load.resource.gif;

import android.util.Log;
import external.sdk.pendo.io.glide.load.ImageHeaderParser;
import external.sdk.pendo.io.glide.load.Options;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import sdk.pendo.io.e.i;
import sdk.pendo.io.h.c;
import sdk.pendo.io.i.a;

/* JADX INFO: loaded from: classes4.dex */
public class StreamGifDecoder implements i<InputStream, GifDrawable> {
    private static final String TAG = "StreamGifDecoder";
    private final a byteArrayPool;
    private final i<ByteBuffer, GifDrawable> byteBufferDecoder;
    private final List<ImageHeaderParser> parsers;

    public StreamGifDecoder(List<ImageHeaderParser> list, i<ByteBuffer, GifDrawable> iVar, a aVar) {
        this.parsers = list;
        this.byteBufferDecoder = iVar;
        this.byteArrayPool = aVar;
    }

    private static byte[] inputStreamToBytes(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (IOException e) {
            if (!Log.isLoggable(TAG, 5)) {
                return null;
            }
            Log.w(TAG, "Error reading data from stream", e);
            return null;
        }
    }

    @Override // sdk.pendo.io.e.i
    public c<GifDrawable> decode(InputStream inputStream, int i, int i2, Options options) {
        byte[] bArrInputStreamToBytes = inputStreamToBytes(inputStream);
        if (bArrInputStreamToBytes == null) {
            return null;
        }
        return this.byteBufferDecoder.decode(ByteBuffer.wrap(bArrInputStreamToBytes), i, i2, options);
    }

    @Override // sdk.pendo.io.e.i
    public boolean handles(InputStream inputStream, Options options) {
        return !((Boolean) options.get(sdk.pendo.io.p.a.b)).booleanValue() && external.sdk.pendo.io.glide.load.a.b(this.parsers, inputStream, this.byteArrayPool) == ImageHeaderParser.ImageType.GIF;
    }
}
