package sdk.pendo.io.o;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import external.sdk.pendo.io.glide.load.ImageHeaderParser;
import external.sdk.pendo.io.glide.load.Options;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import sdk.pendo.io.e.i;
import sdk.pendo.io.y.l;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private final List<ImageHeaderParser> a;
    private final sdk.pendo.io.i.a b;

    /* JADX INFO: renamed from: sdk.pendo.io.o.a$a, reason: collision with other inner class name */
    private static final class C0440a implements sdk.pendo.io.h.c<Drawable> {
        private final AnimatedImageDrawable a;

        C0440a(AnimatedImageDrawable animatedImageDrawable) {
            this.a = animatedImageDrawable;
        }

        @Override // sdk.pendo.io.h.c
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AnimatedImageDrawable get() {
            return this.a;
        }

        @Override // sdk.pendo.io.h.c
        public Class<Drawable> getResourceClass() {
            return Drawable.class;
        }

        @Override // sdk.pendo.io.h.c
        public int getSize() {
            return this.a.getIntrinsicWidth() * this.a.getIntrinsicHeight() * l.a(Bitmap.Config.ARGB_8888) * 2;
        }

        @Override // sdk.pendo.io.h.c
        public void recycle() {
            this.a.stop();
            this.a.clearAnimationCallbacks();
        }
    }

    private static final class b implements i<ByteBuffer, Drawable> {
        private final a a;

        b(a aVar) {
            this.a = aVar;
        }

        @Override // sdk.pendo.io.e.i
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public sdk.pendo.io.h.c<Drawable> decode(ByteBuffer byteBuffer, int i, int i2, Options options) {
            return this.a.a(ImageDecoder.createSource(byteBuffer), i, i2, options);
        }

        @Override // sdk.pendo.io.e.i
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean handles(ByteBuffer byteBuffer, Options options) {
            return this.a.a(byteBuffer);
        }
    }

    private static final class c implements i<InputStream, Drawable> {
        private final a a;

        c(a aVar) {
            this.a = aVar;
        }

        @Override // sdk.pendo.io.e.i
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public sdk.pendo.io.h.c<Drawable> decode(InputStream inputStream, int i, int i2, Options options) {
            return this.a.a(ImageDecoder.createSource(sdk.pendo.io.y.a.a(inputStream)), i, i2, options);
        }

        @Override // sdk.pendo.io.e.i
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean handles(InputStream inputStream, Options options) {
            return this.a.a(inputStream);
        }
    }

    private a(List<ImageHeaderParser> list, sdk.pendo.io.i.a aVar) {
        this.a = list;
        this.b = aVar;
    }

    public static i<ByteBuffer, Drawable> a(List<ImageHeaderParser> list, sdk.pendo.io.i.a aVar) {
        return new b(new a(list, aVar));
    }

    public static i<InputStream, Drawable> b(List<ImageHeaderParser> list, sdk.pendo.io.i.a aVar) {
        return new c(new a(list, aVar));
    }

    sdk.pendo.io.h.c<Drawable> a(ImageDecoder.Source source, int i, int i2, Options options) throws IOException {
        Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(source, new sdk.pendo.io.m.a(i, i2, options));
        if (drawableDecodeDrawable instanceof AnimatedImageDrawable) {
            return new C0440a((AnimatedImageDrawable) drawableDecodeDrawable);
        }
        throw new IOException("Received unexpected drawable type for animated image, failing: " + drawableDecodeDrawable);
    }

    boolean a(InputStream inputStream) {
        return a(external.sdk.pendo.io.glide.load.a.b(this.a, inputStream, this.b));
    }

    boolean a(ByteBuffer byteBuffer) {
        return a(external.sdk.pendo.io.glide.load.a.a(this.a, byteBuffer));
    }

    private boolean a(ImageHeaderParser.ImageType imageType) {
        if (imageType != ImageHeaderParser.ImageType.ANIMATED_WEBP) {
            return Build.VERSION.SDK_INT >= 31 && imageType == ImageHeaderParser.ImageType.ANIMATED_AVIF;
        }
        return true;
    }
}
