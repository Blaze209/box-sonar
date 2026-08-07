package external.sdk.pendo.io.glide;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.tracing.Trace;
import external.sdk.pendo.io.glide.load.ImageHeaderParser;
import external.sdk.pendo.io.glide.load.ResourceEncoder;
import external.sdk.pendo.io.glide.load.data.InputStreamRewinder;
import external.sdk.pendo.io.glide.load.data.ParcelFileDescriptorRewinder;
import external.sdk.pendo.io.glide.load.model.AssetUriLoader;
import external.sdk.pendo.io.glide.load.model.ByteArrayLoader;
import external.sdk.pendo.io.glide.load.model.ByteBufferEncoder;
import external.sdk.pendo.io.glide.load.model.ByteBufferFileLoader;
import external.sdk.pendo.io.glide.load.model.DataUrlLoader;
import external.sdk.pendo.io.glide.load.model.DirectResourceLoader;
import external.sdk.pendo.io.glide.load.model.FileLoader;
import external.sdk.pendo.io.glide.load.model.GlideUrl;
import external.sdk.pendo.io.glide.load.model.MediaStoreFileLoader;
import external.sdk.pendo.io.glide.load.model.ResourceLoader;
import external.sdk.pendo.io.glide.load.model.ResourceUriLoader;
import external.sdk.pendo.io.glide.load.model.StreamEncoder;
import external.sdk.pendo.io.glide.load.model.StringLoader;
import external.sdk.pendo.io.glide.load.model.UnitModelLoader;
import external.sdk.pendo.io.glide.load.model.UriLoader;
import external.sdk.pendo.io.glide.load.model.UrlUriLoader;
import external.sdk.pendo.io.glide.load.model.stream.HttpGlideUrlLoader;
import external.sdk.pendo.io.glide.load.model.stream.MediaStoreImageThumbLoader;
import external.sdk.pendo.io.glide.load.model.stream.MediaStoreVideoThumbLoader;
import external.sdk.pendo.io.glide.load.model.stream.QMediaStoreUriLoader;
import external.sdk.pendo.io.glide.load.model.stream.UrlLoader;
import external.sdk.pendo.io.glide.load.resource.bitmap.BitmapDrawableDecoder;
import external.sdk.pendo.io.glide.load.resource.bitmap.BitmapDrawableEncoder;
import external.sdk.pendo.io.glide.load.resource.bitmap.BitmapEncoder;
import external.sdk.pendo.io.glide.load.resource.bitmap.ByteBufferBitmapDecoder;
import external.sdk.pendo.io.glide.load.resource.bitmap.ByteBufferBitmapImageDecoderResourceDecoder;
import external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser;
import external.sdk.pendo.io.glide.load.resource.bitmap.ExifInterfaceImageHeaderParser;
import external.sdk.pendo.io.glide.load.resource.bitmap.InputStreamBitmapImageDecoderResourceDecoder;
import external.sdk.pendo.io.glide.load.resource.bitmap.ParcelFileDescriptorBitmapDecoder;
import external.sdk.pendo.io.glide.load.resource.bitmap.ResourceBitmapDecoder;
import external.sdk.pendo.io.glide.load.resource.bitmap.StreamBitmapDecoder;
import external.sdk.pendo.io.glide.load.resource.bitmap.UnitBitmapDecoder;
import external.sdk.pendo.io.glide.load.resource.bitmap.VideoDecoder;
import external.sdk.pendo.io.glide.load.resource.bytes.ByteBufferRewinder;
import external.sdk.pendo.io.glide.load.resource.drawable.ResourceDrawableDecoder;
import external.sdk.pendo.io.glide.load.resource.drawable.UnitDrawableDecoder;
import external.sdk.pendo.io.glide.load.resource.file.FileDecoder;
import external.sdk.pendo.io.glide.load.resource.gif.ByteBufferGifDecoder;
import external.sdk.pendo.io.glide.load.resource.gif.GifDrawable;
import external.sdk.pendo.io.glide.load.resource.gif.GifDrawableEncoder;
import external.sdk.pendo.io.glide.load.resource.gif.GifFrameResourceDecoder;
import external.sdk.pendo.io.glide.load.resource.gif.StreamGifDecoder;
import external.sdk.pendo.io.glide.load.resource.transcode.BitmapBytesTranscoder;
import external.sdk.pendo.io.glide.load.resource.transcode.BitmapDrawableTranscoder;
import external.sdk.pendo.io.glide.load.resource.transcode.DrawableBytesTranscoder;
import external.sdk.pendo.io.glide.load.resource.transcode.GifDrawableBytesTranscoder;
import external.sdk.pendo.io.glide.module.AppGlideModule;
import external.sdk.pendo.io.glide.module.GlideModule;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.List;
import sdk.pendo.io.e.i;
import sdk.pendo.io.y.f;

/* JADX INFO: loaded from: classes4.dex */
final class d {

    class a implements f.b<Registry> {
        private boolean a;
        final /* synthetic */ external.sdk.pendo.io.glide.a b;
        final /* synthetic */ List c;
        final /* synthetic */ AppGlideModule d;

        a(external.sdk.pendo.io.glide.a aVar, List list, AppGlideModule appGlideModule) {
            this.b = aVar;
            this.c = list;
            this.d = appGlideModule;
        }

        @Override // sdk.pendo.io.y.f.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Registry get() {
            if (this.a) {
                throw new IllegalStateException("Recursive Registry initialization! In your AppGlideModule and LibraryGlideModules, Make sure you're using the provided Registry rather calling glide.getRegistry()!");
            }
            Trace.beginSection("Glide registry");
            this.a = true;
            try {
                return d.a(this.b, this.c, this.d);
            } finally {
                this.a = false;
                Trace.endSection();
            }
        }
    }

    static Registry a(external.sdk.pendo.io.glide.a aVar, List<GlideModule> list, AppGlideModule appGlideModule) {
        sdk.pendo.io.i.b bVarC = aVar.c();
        sdk.pendo.io.i.a aVarB = aVar.b();
        Context applicationContext = aVar.f().getApplicationContext();
        c cVarE = aVar.f().e();
        Registry registry = new Registry();
        a(applicationContext, registry, bVarC, aVarB, cVarE);
        a(applicationContext, aVar, registry, list, appGlideModule);
        return registry;
    }

    static f.b<Registry> b(external.sdk.pendo.io.glide.a aVar, List<GlideModule> list, AppGlideModule appGlideModule) {
        return new a(aVar, list, appGlideModule);
    }

    private static void a(Context context, Registry registry, sdk.pendo.io.i.b bVar, sdk.pendo.io.i.a aVar, c cVar) {
        i byteBufferBitmapDecoder;
        i streamBitmapDecoder;
        registry.a((ImageHeaderParser) new DefaultImageHeaderParser());
        registry.a((ImageHeaderParser) new ExifInterfaceImageHeaderParser());
        Resources resources = context.getResources();
        List<ImageHeaderParser> listA = registry.a();
        ByteBufferGifDecoder byteBufferGifDecoder = new ByteBufferGifDecoder(context, listA, bVar, aVar);
        i<ParcelFileDescriptor, Bitmap> iVarParcel = VideoDecoder.parcel(bVar);
        external.sdk.pendo.io.glide.load.resource.bitmap.b bVar2 = new external.sdk.pendo.io.glide.load.resource.bitmap.b(registry.a(), resources.getDisplayMetrics(), bVar, aVar);
        if (cVar.a(GlideBuilder.b.class)) {
            streamBitmapDecoder = new InputStreamBitmapImageDecoderResourceDecoder();
            byteBufferBitmapDecoder = new ByteBufferBitmapImageDecoderResourceDecoder();
        } else {
            byteBufferBitmapDecoder = new ByteBufferBitmapDecoder(bVar2);
            streamBitmapDecoder = new StreamBitmapDecoder(bVar2, aVar);
        }
        registry.a("Animation", InputStream.class, Drawable.class, sdk.pendo.io.o.a.b(listA, aVar));
        registry.a("Animation", ByteBuffer.class, Drawable.class, sdk.pendo.io.o.a.a(listA, aVar));
        ResourceDrawableDecoder resourceDrawableDecoder = new ResourceDrawableDecoder(context);
        BitmapEncoder bitmapEncoder = new BitmapEncoder(aVar);
        BitmapBytesTranscoder bitmapBytesTranscoder = new BitmapBytesTranscoder();
        GifDrawableBytesTranscoder gifDrawableBytesTranscoder = new GifDrawableBytesTranscoder();
        ContentResolver contentResolver = context.getContentResolver();
        registry.a(ByteBuffer.class, new ByteBufferEncoder()).a(InputStream.class, new StreamEncoder(aVar)).a(com.bumptech.glide.Registry.BUCKET_BITMAP, ByteBuffer.class, Bitmap.class, byteBufferBitmapDecoder).a(com.bumptech.glide.Registry.BUCKET_BITMAP, InputStream.class, Bitmap.class, streamBitmapDecoder);
        if (ParcelFileDescriptorRewinder.isSupported()) {
            registry.a(com.bumptech.glide.Registry.BUCKET_BITMAP, ParcelFileDescriptor.class, Bitmap.class, new ParcelFileDescriptorBitmapDecoder(bVar2));
        }
        registry.a(com.bumptech.glide.Registry.BUCKET_BITMAP, AssetFileDescriptor.class, Bitmap.class, VideoDecoder.asset(bVar));
        registry.a(com.bumptech.glide.Registry.BUCKET_BITMAP, ParcelFileDescriptor.class, Bitmap.class, iVarParcel).a(Bitmap.class, Bitmap.class, UnitModelLoader.Factory.getInstance()).a(com.bumptech.glide.Registry.BUCKET_BITMAP, Bitmap.class, Bitmap.class, new UnitBitmapDecoder()).a(Bitmap.class, (ResourceEncoder) bitmapEncoder).a(com.bumptech.glide.Registry.BUCKET_BITMAP_DRAWABLE, ByteBuffer.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, byteBufferBitmapDecoder)).a(com.bumptech.glide.Registry.BUCKET_BITMAP_DRAWABLE, InputStream.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, streamBitmapDecoder)).a(com.bumptech.glide.Registry.BUCKET_BITMAP_DRAWABLE, ParcelFileDescriptor.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, iVarParcel)).a(BitmapDrawable.class, (ResourceEncoder) new BitmapDrawableEncoder(bVar, bitmapEncoder)).a("Animation", InputStream.class, GifDrawable.class, new StreamGifDecoder(listA, byteBufferGifDecoder, aVar)).a("Animation", ByteBuffer.class, GifDrawable.class, byteBufferGifDecoder).a(GifDrawable.class, (ResourceEncoder) new GifDrawableEncoder()).a(external.sdk.pendo.io.glide.gifdecoder.a.class, external.sdk.pendo.io.glide.gifdecoder.a.class, UnitModelLoader.Factory.getInstance()).a(com.bumptech.glide.Registry.BUCKET_BITMAP, external.sdk.pendo.io.glide.gifdecoder.a.class, Bitmap.class, new GifFrameResourceDecoder(bVar)).a(Uri.class, Drawable.class, resourceDrawableDecoder).a(Uri.class, Bitmap.class, new ResourceBitmapDecoder(resourceDrawableDecoder, bVar)).a((external.sdk.pendo.io.glide.load.data.b.a<?>) new ByteBufferRewinder.Factory()).a(File.class, ByteBuffer.class, new ByteBufferFileLoader.Factory()).a(File.class, InputStream.class, new FileLoader.StreamFactory()).a(File.class, File.class, new FileDecoder()).a(File.class, ParcelFileDescriptor.class, new FileLoader.FileDescriptorFactory()).a(File.class, File.class, UnitModelLoader.Factory.getInstance()).a((external.sdk.pendo.io.glide.load.data.b.a<?>) new InputStreamRewinder.Factory(aVar));
        if (ParcelFileDescriptorRewinder.isSupported()) {
            registry.a((external.sdk.pendo.io.glide.load.data.b.a<?>) new ParcelFileDescriptorRewinder.Factory());
        }
        sdk.pendo.io.l.d<Integer, InputStream> dVarInputStreamFactory = DirectResourceLoader.inputStreamFactory(context);
        sdk.pendo.io.l.d<Integer, AssetFileDescriptor> dVarAssetFileDescriptorFactory = DirectResourceLoader.assetFileDescriptorFactory(context);
        sdk.pendo.io.l.d<Integer, Drawable> dVarDrawableFactory = DirectResourceLoader.drawableFactory(context);
        Class cls = Integer.TYPE;
        registry.a(cls, InputStream.class, dVarInputStreamFactory).a(Integer.class, InputStream.class, dVarInputStreamFactory).a(cls, AssetFileDescriptor.class, dVarAssetFileDescriptorFactory).a(Integer.class, AssetFileDescriptor.class, dVarAssetFileDescriptorFactory).a(cls, Drawable.class, dVarDrawableFactory).a(Integer.class, Drawable.class, dVarDrawableFactory).a(Uri.class, InputStream.class, ResourceUriLoader.newStreamFactory(context)).a(Uri.class, AssetFileDescriptor.class, ResourceUriLoader.newAssetFileDescriptorFactory(context));
        ResourceLoader.UriFactory uriFactory = new ResourceLoader.UriFactory(resources);
        ResourceLoader.AssetFileDescriptorFactory assetFileDescriptorFactory = new ResourceLoader.AssetFileDescriptorFactory(resources);
        ResourceLoader.StreamFactory streamFactory = new ResourceLoader.StreamFactory(resources);
        registry.a(Integer.class, Uri.class, uriFactory).a(cls, Uri.class, uriFactory).a(Integer.class, AssetFileDescriptor.class, assetFileDescriptorFactory).a(cls, AssetFileDescriptor.class, assetFileDescriptorFactory).a(Integer.class, InputStream.class, streamFactory).a(cls, InputStream.class, streamFactory);
        registry.a(String.class, InputStream.class, new DataUrlLoader.StreamFactory()).a(Uri.class, InputStream.class, new DataUrlLoader.StreamFactory()).a(String.class, InputStream.class, new StringLoader.StreamFactory()).a(String.class, ParcelFileDescriptor.class, new StringLoader.FileDescriptorFactory()).a(String.class, AssetFileDescriptor.class, new StringLoader.AssetFileDescriptorFactory()).a(Uri.class, InputStream.class, new AssetUriLoader.StreamFactory(context.getAssets())).a(Uri.class, AssetFileDescriptor.class, new AssetUriLoader.FileDescriptorFactory(context.getAssets())).a(Uri.class, InputStream.class, new MediaStoreImageThumbLoader.Factory(context)).a(Uri.class, InputStream.class, new MediaStoreVideoThumbLoader.Factory(context));
        registry.a(Uri.class, InputStream.class, new QMediaStoreUriLoader.InputStreamFactory(context));
        registry.a(Uri.class, ParcelFileDescriptor.class, new QMediaStoreUriLoader.FileDescriptorFactory(context));
        boolean zA = cVar.a(GlideBuilder.UseMediaStoreOpenFileApisIfPossible.class);
        registry.a(Uri.class, InputStream.class, new UriLoader.StreamFactory(contentResolver, zA)).a(Uri.class, ParcelFileDescriptor.class, new UriLoader.FileDescriptorFactory(contentResolver, zA)).a(Uri.class, AssetFileDescriptor.class, new UriLoader.AssetFileDescriptorFactory(contentResolver, zA)).a(Uri.class, InputStream.class, new UrlUriLoader.StreamFactory()).a(URL.class, InputStream.class, new UrlLoader.StreamFactory()).a(Uri.class, File.class, new MediaStoreFileLoader.Factory(context)).a(GlideUrl.class, InputStream.class, new HttpGlideUrlLoader.Factory()).a(byte[].class, ByteBuffer.class, new ByteArrayLoader.ByteBufferFactory()).a(byte[].class, InputStream.class, new ByteArrayLoader.StreamFactory()).a(Uri.class, Uri.class, UnitModelLoader.Factory.getInstance()).a(Drawable.class, Drawable.class, UnitModelLoader.Factory.getInstance()).a(Drawable.class, Drawable.class, new UnitDrawableDecoder()).a(Bitmap.class, BitmapDrawable.class, new BitmapDrawableTranscoder(resources)).a(Bitmap.class, byte[].class, bitmapBytesTranscoder).a(Drawable.class, byte[].class, new DrawableBytesTranscoder(bVar, bitmapBytesTranscoder, gifDrawableBytesTranscoder)).a(GifDrawable.class, byte[].class, gifDrawableBytesTranscoder);
        i<ByteBuffer, Bitmap> iVarByteBuffer = VideoDecoder.byteBuffer(bVar);
        registry.a(ByteBuffer.class, Bitmap.class, iVarByteBuffer);
        registry.a(ByteBuffer.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, iVarByteBuffer));
    }

    private static void a(Context context, external.sdk.pendo.io.glide.a aVar, Registry registry, List<GlideModule> list, AppGlideModule appGlideModule) {
        for (GlideModule glideModule : list) {
            try {
                glideModule.registerComponents(context, aVar, registry);
            } catch (AbstractMethodError e) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + glideModule.getClass().getName(), e);
            }
        }
        if (appGlideModule != null) {
            appGlideModule.registerComponents(context, aVar, registry);
        }
    }
}
