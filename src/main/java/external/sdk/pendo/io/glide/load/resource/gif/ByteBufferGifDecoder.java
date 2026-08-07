package external.sdk.pendo.io.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import external.sdk.pendo.io.glide.gifdecoder.StandardGifDecoder;
import external.sdk.pendo.io.glide.gifdecoder.c;
import external.sdk.pendo.io.glide.gifdecoder.d;
import external.sdk.pendo.io.glide.load.ImageHeaderParser;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.resource.UnitTransformation;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;
import sdk.pendo.io.e.i;
import sdk.pendo.io.y.g;
import sdk.pendo.io.y.l;

/* JADX INFO: loaded from: classes4.dex */
public class ByteBufferGifDecoder implements i<ByteBuffer, GifDrawable> {
    private static final a GIF_DECODER_FACTORY = new a();
    private static final b PARSER_POOL = new b();
    private static final String TAG = "BufferGifDecoder";
    private final Context context;
    private final a gifDecoderFactory;
    private final b parserPool;
    private final List<ImageHeaderParser> parsers;
    private final GifBitmapProvider provider;

    static class a {
        a() {
        }

        external.sdk.pendo.io.glide.gifdecoder.a a(external.sdk.pendo.io.glide.gifdecoder.a.InterfaceC0305a interfaceC0305a, c cVar, ByteBuffer byteBuffer, int i) {
            return new StandardGifDecoder(interfaceC0305a, cVar, byteBuffer, i);
        }
    }

    static class b {
        private final Queue<d> a = l.a(0);

        b() {
        }

        synchronized d a(ByteBuffer byteBuffer) {
            d dVarPoll;
            dVarPoll = this.a.poll();
            if (dVarPoll == null) {
                dVarPoll = new d();
            }
            return dVarPoll.a(byteBuffer);
        }

        synchronized void a(d dVar) {
            dVar.a();
            this.a.offer(dVar);
        }
    }

    public ByteBufferGifDecoder(Context context) {
        this(context, external.sdk.pendo.io.glide.a.a(context).g().a(), external.sdk.pendo.io.glide.a.a(context).c(), external.sdk.pendo.io.glide.a.a(context).b());
    }

    private GifDrawableResource decode(ByteBuffer byteBuffer, int i, int i2, d dVar, Options options) {
        StringBuilder sb;
        long jA = g.a();
        try {
            c cVarC = dVar.c();
            if (cVarC.b() > 0 && cVarC.c() == 0) {
                Bitmap.Config config = options.get(sdk.pendo.io.p.a.a) == sdk.pendo.io.e.b.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                external.sdk.pendo.io.glide.gifdecoder.a aVarA = this.gifDecoderFactory.a(this.provider, cVarC, byteBuffer, getSampleSize(cVarC, i, i2));
                aVarA.setDefaultBitmapConfig(config);
                aVarA.advance();
                Bitmap nextFrame = aVarA.getNextFrame();
                if (nextFrame == null) {
                    if (Log.isLoggable(TAG, 2)) {
                        sb = new StringBuilder("Decoded GIF from stream in ");
                    }
                    return null;
                }
                GifDrawableResource gifDrawableResource = new GifDrawableResource(new GifDrawable(this.context, aVarA, UnitTransformation.get(), i, i2, nextFrame));
                if (Log.isLoggable(TAG, 2)) {
                    Log.v(TAG, "Decoded GIF from stream in " + g.a(jA));
                }
                return gifDrawableResource;
            }
            if (!Log.isLoggable(TAG, 2)) {
                return null;
            }
            sb = new StringBuilder("Decoded GIF from stream in ");
            Log.v(TAG, sb.append(g.a(jA)).toString());
            return null;
        } catch (Throwable th) {
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Decoded GIF from stream in " + g.a(jA));
            }
            throw th;
        }
    }

    private static int getSampleSize(c cVar, int i, int i2) {
        int iMin = Math.min(cVar.a() / i2, cVar.d() / i);
        int iMax = Math.max(1, iMin == 0 ? 0 : Integer.highestOneBit(iMin));
        if (Log.isLoggable(TAG, 2) && iMax > 1) {
            Log.v(TAG, "Downsampling GIF, sampleSize: " + iMax + ", target dimens: [" + i + "x" + i2 + "], actual dimens: [" + cVar.d() + "x" + cVar.a() + "]");
        }
        return iMax;
    }

    public ByteBufferGifDecoder(Context context, List<ImageHeaderParser> list, sdk.pendo.io.i.b bVar, sdk.pendo.io.i.a aVar) {
        this(context, list, bVar, aVar, PARSER_POOL, GIF_DECODER_FACTORY);
    }

    @Override // sdk.pendo.io.e.i
    public GifDrawableResource decode(ByteBuffer byteBuffer, int i, int i2, Options options) {
        d dVarA = this.parserPool.a(byteBuffer);
        try {
            return decode(byteBuffer, i, i2, dVarA, options);
        } finally {
            this.parserPool.a(dVarA);
        }
    }

    @Override // sdk.pendo.io.e.i
    public boolean handles(ByteBuffer byteBuffer, Options options) {
        return !((Boolean) options.get(sdk.pendo.io.p.a.b)).booleanValue() && external.sdk.pendo.io.glide.load.a.a(this.parsers, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    ByteBufferGifDecoder(Context context, List<ImageHeaderParser> list, sdk.pendo.io.i.b bVar, sdk.pendo.io.i.a aVar, b bVar2, a aVar2) {
        this.context = context.getApplicationContext();
        this.parsers = list;
        this.gifDecoderFactory = aVar2;
        this.provider = new GifBitmapProvider(bVar, aVar);
        this.parserPool = bVar2;
    }
}
