package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import external.sdk.pendo.io.glide.load.ImageHeaderParser;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.data.ParcelFileDescriptorRewinder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import sdk.pendo.io.e.g;
import sdk.pendo.io.e.h;
import sdk.pendo.io.y.k;
import sdk.pendo.io.y.l;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    public static final g<sdk.pendo.io.e.b> f = g.a("external.sdk.pendo.io.glide.load.resource.bitmap.Downsampler.DecodeFormat", sdk.pendo.io.e.b.DEFAULT);
    public static final g<h> g = g.a("external.sdk.pendo.io.glide.load.resource.bitmap.Downsampler.PreferredColorSpace");

    @Deprecated
    public static final g<external.sdk.pendo.io.glide.load.resource.bitmap.a> h = external.sdk.pendo.io.glide.load.resource.bitmap.a.h;
    public static final g<Boolean> i;
    public static final g<Boolean> j;
    private static final Set<String> k;
    private static final InterfaceC0317b l;
    private static final Set<ImageHeaderParser.ImageType> m;
    private static final Queue<BitmapFactory.Options> n;
    private final sdk.pendo.io.i.b a;
    private final DisplayMetrics b;
    private final sdk.pendo.io.i.a c;
    private final List<ImageHeaderParser> d;
    private final e e = e.b();

    class a implements InterfaceC0317b {
        a() {
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.b.InterfaceC0317b
        public void a() {
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.b.InterfaceC0317b
        public void a(sdk.pendo.io.i.b bVar, Bitmap bitmap) {
        }
    }

    /* JADX INFO: renamed from: external.sdk.pendo.io.glide.load.resource.bitmap.b$b, reason: collision with other inner class name */
    public interface InterfaceC0317b {
        void a();

        void a(sdk.pendo.io.i.b bVar, Bitmap bitmap);
    }

    static {
        Boolean bool = Boolean.FALSE;
        i = g.a("external.sdk.pendo.io.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        j = g.a("external.sdk.pendo.io.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        k = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        l = new a();
        m = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        n = l.a(0);
    }

    public b(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, sdk.pendo.io.i.b bVar, sdk.pendo.io.i.a aVar) {
        this.d = list;
        this.b = (DisplayMetrics) k.a(displayMetrics);
        this.a = (sdk.pendo.io.i.b) k.a(bVar);
        this.c = (sdk.pendo.io.i.a) k.a(aVar);
    }

    private static int a(double d) {
        int iB = b(d);
        int iC = c(((double) iB) * d);
        return c((d / ((double) (iC / iB))) * ((double) iC));
    }

    private static boolean a(int i2) {
        return i2 == 90 || i2 == 270;
    }

    private boolean a(ImageHeaderParser.ImageType imageType) {
        return true;
    }

    private static int b(double d) {
        if (d > 1.0d) {
            d = 1.0d / d;
        }
        return (int) Math.round(d * 2.147483647E9d);
    }

    private static int c(double d) {
        return (int) (d + 0.5d);
    }

    private static void c(BitmapFactory.Options options) {
        d(options);
        Queue<BitmapFactory.Options> queue = n;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    private static void d(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.inPreferredColorSpace = null;
        options.outColorSpace = null;
        options.outConfig = null;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public boolean a(InputStream inputStream) {
        return true;
    }

    public boolean a(ByteBuffer byteBuffer) {
        return true;
    }

    private void a(ImageReader imageReader, sdk.pendo.io.e.b bVar, boolean z, boolean z2, BitmapFactory.Options options, int i2, int i3) {
        boolean zHasAlpha;
        if (this.e.a(i2, i3, options, z, z2)) {
            return;
        }
        if (bVar == sdk.pendo.io.e.b.PREFER_ARGB_8888) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return;
        }
        try {
            zHasAlpha = imageReader.getImageType().hasAlpha();
        } catch (IOException e) {
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Cannot determine whether the image has alpha or not from header, format " + bVar, e);
            }
            zHasAlpha = false;
        }
        Bitmap.Config config = zHasAlpha ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        options.inPreferredConfig = config;
        if (config == Bitmap.Config.RGB_565) {
            options.inDither = true;
        }
    }

    private static int[] b(ImageReader imageReader, BitmapFactory.Options options, InterfaceC0317b interfaceC0317b, sdk.pendo.io.i.b bVar) {
        options.inJustDecodeBounds = true;
        a(imageReader, options, interfaceC0317b, bVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static void a(ImageHeaderParser.ImageType imageType, ImageReader imageReader, InterfaceC0317b interfaceC0317b, sdk.pendo.io.i.b bVar, external.sdk.pendo.io.glide.load.resource.bitmap.a aVar, int i2, int i3, int i4, int i5, int i6, BitmapFactory.Options options) {
        int i7;
        int i8;
        int i9;
        int iFloor;
        int iFloor2;
        if (i3 <= 0 || i4 <= 0) {
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Unable to determine dimensions for: " + imageType + " with target [" + i5 + "x" + i6 + "]");
                return;
            }
            return;
        }
        if (a(i2)) {
            i8 = i3;
            i7 = i4;
        } else {
            i7 = i3;
            i8 = i4;
        }
        float fB = aVar.b(i7, i8, i5, i6);
        if (fB <= 0.0f) {
            throw new IllegalArgumentException("Cannot scale with factor: " + fB + " from: " + aVar + ", source: [" + i3 + "x" + i4 + "], target: [" + i5 + "x" + i6 + "]");
        }
        external.sdk.pendo.io.glide.load.resource.bitmap.a.g gVarA = aVar.a(i7, i8, i5, i6);
        if (gVarA == null) {
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        float f2 = i7;
        float f3 = i8;
        int i10 = i7;
        int i11 = i8;
        int iC = i10 / c(fB * f2);
        int iC2 = i11 / c(fB * f3);
        external.sdk.pendo.io.glide.load.resource.bitmap.a.g gVar = external.sdk.pendo.io.glide.load.resource.bitmap.a.g.MEMORY;
        int iMax = Math.max(1, Integer.highestOneBit(gVarA == gVar ? Math.max(iC, iC2) : Math.min(iC, iC2)));
        if (gVarA == gVar && iMax < 1.0f / fB) {
            iMax <<= 1;
        }
        options.inSampleSize = iMax;
        if (imageType == ImageHeaderParser.ImageType.JPEG) {
            float fMin = Math.min(iMax, 8);
            i9 = 0;
            iFloor = (int) Math.ceil(f2 / fMin);
            iFloor2 = (int) Math.ceil(f3 / fMin);
            int i12 = iMax / 8;
            if (i12 > 0) {
                iFloor /= i12;
                iFloor2 /= i12;
            }
        } else {
            i9 = 0;
            if (imageType == ImageHeaderParser.ImageType.PNG || imageType == ImageHeaderParser.ImageType.PNG_A) {
                float f4 = iMax;
                iFloor = (int) Math.floor(f2 / f4);
                iFloor2 = (int) Math.floor(f3 / f4);
            } else if (imageType.isWebp()) {
                float f5 = iMax;
                iFloor = Math.round(f2 / f5);
                iFloor2 = Math.round(f3 / f5);
            } else if (i10 % iMax == 0 && i11 % iMax == 0) {
                iFloor = i10 / iMax;
                iFloor2 = i11 / iMax;
            } else {
                int[] iArrB = b(imageReader, options, interfaceC0317b, bVar);
                iFloor = iArrB[0];
                iFloor2 = iArrB[1];
            }
        }
        double dB = aVar.b(iFloor, iFloor2, i5, i6);
        options.inTargetDensity = a(dB);
        options.inDensity = b(dB);
        if (b(options)) {
            options.inScaled = true;
        } else {
            int i13 = i9;
            options.inTargetDensity = i13;
            options.inDensity = i13;
        }
        if (Log.isLoggable("Downsampler", 2)) {
            Log.v("Downsampler", "Calculate scaling, source: [" + i3 + "x" + i4 + "], degreesToRotate: " + i2 + ", target: [" + i5 + "x" + i6 + "], power of two scaled: [" + iFloor + "x" + iFloor2 + "], exact scale factor: " + fB + ", power of 2 sample size: " + iMax + ", adjusted scale factor: " + dB + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
        }
    }

    private static boolean b(BitmapFactory.Options options) {
        int i2;
        int i3 = options.inTargetDensity;
        return i3 > 0 && (i2 = options.inDensity) > 0 && i3 != i2;
    }

    public sdk.pendo.io.h.c<Bitmap> a(ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, Options options) {
        return a(new ImageReader.ParcelFileDescriptorImageReader(parcelFileDescriptor, this.d, this.c), i2, i3, options, l);
    }

    private sdk.pendo.io.h.c<Bitmap> a(ImageReader imageReader, int i2, int i3, Options options, InterfaceC0317b interfaceC0317b) {
        byte[] bArr = (byte[]) this.c.get(65536, byte[].class);
        BitmapFactory.Options optionsA = a();
        optionsA.inTempStorage = bArr;
        sdk.pendo.io.e.b bVar = (sdk.pendo.io.e.b) options.get(f);
        h hVar = (h) options.get(g);
        external.sdk.pendo.io.glide.load.resource.bitmap.a aVar = (external.sdk.pendo.io.glide.load.resource.bitmap.a) options.get(external.sdk.pendo.io.glide.load.resource.bitmap.a.h);
        boolean zBooleanValue = ((Boolean) options.get(i)).booleanValue();
        g<Boolean> gVar = j;
        try {
            return BitmapResource.obtain(a(imageReader, optionsA, aVar, bVar, hVar, options.get(gVar) != null && ((Boolean) options.get(gVar)).booleanValue(), i2, i3, zBooleanValue, interfaceC0317b), this.a);
        } finally {
            c(optionsA);
            this.c.put(bArr);
        }
    }

    public sdk.pendo.io.h.c<Bitmap> a(InputStream inputStream, int i2, int i3, Options options, InterfaceC0317b interfaceC0317b) {
        return a(new ImageReader.InputStreamImageReader(inputStream, this.d, this.c), i2, i3, options, interfaceC0317b);
    }

    public sdk.pendo.io.h.c<Bitmap> a(ByteBuffer byteBuffer, int i2, int i3, Options options) {
        return a(new ImageReader.ByteBufferReader(byteBuffer, this.d, this.c), i2, i3, options, l);
    }

    private Bitmap a(ImageReader imageReader, BitmapFactory.Options options, external.sdk.pendo.io.glide.load.resource.bitmap.a aVar, sdk.pendo.io.e.b bVar, h hVar, boolean z, int i2, int i3, boolean z2, InterfaceC0317b interfaceC0317b) {
        String str;
        ColorSpace colorSpace;
        int iRound;
        long jA = sdk.pendo.io.y.g.a();
        int[] iArrB = b(imageReader, options, interfaceC0317b, this.a);
        int i4 = iArrB[0];
        int i5 = iArrB[1];
        String str2 = options.outMimeType;
        boolean z3 = (i4 == -1 || i5 == -1) ? false : z;
        int imageOrientation = imageReader.getImageOrientation();
        int iA = sdk.pendo.io.n.b.a(imageOrientation);
        boolean zB = sdk.pendo.io.n.b.b(imageOrientation);
        int i6 = i2;
        if (i6 == Integer.MIN_VALUE) {
            i6 = a(iA) ? i5 : i4;
        }
        if (i3 == -2147483648) {
            i3 = a(iA) ? i4 : i5;
        }
        ImageHeaderParser.ImageType imageType = imageReader.getImageType();
        a(imageType, imageReader, interfaceC0317b, this.a, aVar, iA, i4, i5, i6, i3, options);
        int i7 = i6;
        int i8 = i3;
        a(imageReader, bVar, z3, zB, options, i7, i8);
        int i9 = options.inSampleSize;
        if (a(imageType)) {
            if (i4 < 0 || i5 < 0 || !z2) {
                float f2 = b(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                int i10 = options.inSampleSize;
                float f3 = i4;
                float f4 = i10;
                int iCeil = (int) Math.ceil(f3 / f4);
                int iCeil2 = (int) Math.ceil(i5 / f4);
                int iRound2 = Math.round(iCeil * f2);
                iRound = Math.round(iCeil2 * f2);
                str = "Downsampler";
                if (Log.isLoggable(str, 2)) {
                    Log.v(str, "Calculated target [" + iRound2 + "x" + iRound + "] for source [" + i4 + "x" + i5 + "], sampleSize: " + i10 + ", targetDensity: " + options.inTargetDensity + ", density: " + options.inDensity + ", density multiplier: " + f2);
                }
                i7 = iRound2;
            } else {
                str = "Downsampler";
                iRound = i8;
            }
            if (i7 > 0 && iRound > 0) {
                a(options, this.a, i7, iRound);
            }
        } else {
            str = "Downsampler";
        }
        if (hVar != null) {
            options.inPreferredColorSpace = ColorSpace.get((hVar == h.DISPLAY_P3 && (colorSpace = options.outColorSpace) != null && colorSpace.isWideGamut()) ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB);
        }
        Bitmap bitmapA = a(imageReader, options, interfaceC0317b, this.a);
        interfaceC0317b.a(this.a, bitmapA);
        if (Log.isLoggable(str, 2)) {
            a(i4, i5, str2, options, bitmapA, i2, i3, jA);
        }
        if (bitmapA == null) {
            return null;
        }
        bitmapA.setDensity(this.b.densityDpi);
        Bitmap bitmapA2 = sdk.pendo.io.n.b.a(this.a, bitmapA, imageOrientation);
        if (!bitmapA.equals(bitmapA2)) {
            this.a.put(bitmapA);
        }
        return bitmapA2;
    }

    private static Bitmap a(ImageReader imageReader, BitmapFactory.Options options, InterfaceC0317b interfaceC0317b, sdk.pendo.io.i.b bVar) {
        Bitmap bitmapA;
        if (!options.inJustDecodeBounds) {
            interfaceC0317b.a();
            imageReader.stopGrowingBuffers();
        }
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        String str = options.outMimeType;
        sdk.pendo.io.n.b.a().lock();
        try {
            try {
                bitmapA = imageReader.decodeBitmap(options);
            } catch (IllegalArgumentException e) {
                IOException iOExceptionA = a(e, i2, i3, str, options);
                if (Log.isLoggable("Downsampler", 3)) {
                    Log.d("Downsampler", "Failed to decode with inBitmap, trying again without Bitmap re-use", iOExceptionA);
                }
                Bitmap bitmap = options.inBitmap;
                if (bitmap == null) {
                    throw iOExceptionA;
                }
                try {
                    bVar.put(bitmap);
                    options.inBitmap = null;
                    bitmapA = a(imageReader, options, interfaceC0317b, bVar);
                } catch (IOException unused) {
                    throw iOExceptionA;
                }
            }
            return bitmapA;
        } finally {
            sdk.pendo.io.n.b.a().unlock();
        }
    }

    private static String a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    private static synchronized BitmapFactory.Options a() {
        BitmapFactory.Options optionsPoll;
        Queue<BitmapFactory.Options> queue = n;
        synchronized (queue) {
            optionsPoll = queue.poll();
        }
        if (optionsPoll == null) {
            optionsPoll = new BitmapFactory.Options();
            d(optionsPoll);
        }
        return optionsPoll;
    }

    private static String a(BitmapFactory.Options options) {
        return a(options.inBitmap);
    }

    public boolean a(ParcelFileDescriptor parcelFileDescriptor) {
        return ParcelFileDescriptorRewinder.isSupported();
    }

    private static void a(int i2, int i3, String str, BitmapFactory.Options options, Bitmap bitmap, int i4, int i5, long j2) {
        Log.v("Downsampler", "Decoded " + a(bitmap) + " from [" + i2 + "x" + i3 + "] " + str + " with inBitmap " + a(options) + " for [" + i4 + "x" + i5 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + sdk.pendo.io.y.g.a(j2));
    }

    private static IOException a(IllegalArgumentException illegalArgumentException, int i2, int i3, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i2 + ", outHeight: " + i3 + ", outMimeType: " + str + ", inBitmap: " + a(options), illegalArgumentException);
    }

    private static void a(BitmapFactory.Options options, sdk.pendo.io.i.b bVar, int i2, int i3) {
        if (options.inPreferredConfig == Bitmap.Config.HARDWARE) {
            return;
        }
        Bitmap.Config config = options.outConfig;
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = bVar.getDirty(i2, i3, config);
    }
}
