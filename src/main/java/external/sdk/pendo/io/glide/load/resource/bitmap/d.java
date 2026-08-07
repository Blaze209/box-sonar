package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Gainmap;
import android.graphics.Paint;
import android.os.Build;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import sdk.pendo.io.y.f;
import sdk.pendo.io.y.k;

/* JADX INFO: loaded from: classes4.dex */
final class d {

    private static final class a {
        private static final ColorMatrixColorFilter a = new ColorMatrixColorFilter(new float[]{0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 255.0f});

        public static Gainmap a(Gainmap gainmap) {
            Bitmap gainmapContents = gainmap.getGainmapContents();
            if (gainmapContents.getConfig() != Bitmap.Config.ALPHA_8) {
                return gainmap;
            }
            Gainmap gainmap2 = new Gainmap(a(gainmapContents));
            float[] ratioMin = gainmap.getRatioMin();
            gainmap2.setRatioMin(ratioMin[0], ratioMin[1], ratioMin[2]);
            float[] ratioMax = gainmap.getRatioMax();
            gainmap2.setRatioMax(ratioMax[0], ratioMax[1], ratioMax[2]);
            float[] gamma = gainmap.getGamma();
            gainmap2.setGamma(gamma[0], gamma[1], gamma[2]);
            float[] epsilonSdr = gainmap.getEpsilonSdr();
            gainmap2.setEpsilonSdr(epsilonSdr[0], epsilonSdr[1], epsilonSdr[2]);
            float[] epsilonHdr = gainmap.getEpsilonHdr();
            gainmap2.setEpsilonHdr(epsilonHdr[0], epsilonHdr[1], epsilonHdr[2]);
            gainmap2.setDisplayRatioForFullHdr(gainmap.getDisplayRatioForFullHdr());
            gainmap2.setMinDisplayRatioForHdrTransition(gainmap.getMinDisplayRatioForHdrTransition());
            return gainmap2;
        }

        private static Bitmap a(Bitmap bitmap) {
            k.a(bitmap.getConfig() == Bitmap.Config.ALPHA_8);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            Paint paint = new Paint();
            paint.setColorFilter(a);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            canvas.setBitmap(null);
            return bitmapCreateBitmap;
        }
    }

    public static final class b {
        private static final f.b<Boolean> a = f.a(new f.b() { // from class: external.sdk.pendo.io.glide.load.resource.bitmap.d$b$$ExternalSyntheticLambda0
            @Override // sdk.pendo.io.y.f.b
            public final Object get() {
                return d.b.b();
            }
        });

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Boolean b() {
            return Boolean.valueOf(a());
        }

        private static boolean a() {
            if (Build.VERSION.SDK_INT != 34) {
                return false;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
            Bitmap bitmapCopy = bitmapCreateBitmap.copy(Bitmap.Config.HARDWARE, false);
            bitmapCreateBitmap.recycle();
            boolean z = bitmapCopy == null;
            if (Log.isLoggable("GainmapWorkaroundCalc", 2)) {
                Log.v("GainmapWorkaroundCalc", "calculateNeedsGainmapDecodeWorkaround=" + z);
            }
            if (bitmapCopy != null) {
                bitmapCopy.recycle();
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean b(BitmapFactory.Options options) {
            if (Build.VERSION.SDK_INT == 34 && options.inPreferredConfig == Bitmap.Config.HARDWARE) {
                return a.get().booleanValue();
            }
            return false;
        }
    }

    public static Bitmap a(byte[] bArr, BitmapFactory.Options options, ImageReader imageReader) {
        return (Build.VERSION.SDK_INT == 34 && b.b(options) && a(imageReader)) ? a(bArr, options) : BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
    }

    public static Bitmap a(FileDescriptor fileDescriptor, BitmapFactory.Options options, ImageReader imageReader) {
        return (Build.VERSION.SDK_INT == 34 && b.b(options) && a(imageReader)) ? a(fileDescriptor, options) : BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
    }

    public static Bitmap a(InputStream inputStream, BitmapFactory.Options options, ImageReader imageReader) {
        return (Build.VERSION.SDK_INT == 34 && b.b(options) && a(imageReader)) ? a(inputStream, options) : BitmapFactory.decodeStream(inputStream, null, options);
    }

    private static boolean a(ImageReader imageReader) {
        try {
            boolean zHasJpegMpf = imageReader.hasJpegMpf();
            if (Log.isLoggable("GlideBitmapFactory", 2)) {
                Log.v("GlideBitmapFactory", "isLikelyToContainGainmap=" + zHasJpegMpf);
            }
            return zHasJpegMpf;
        } catch (IOException e) {
            if (!Log.isLoggable("GlideBitmapFactory", 2)) {
                return false;
            }
            Log.v("GlideBitmapFactory", "isLikelyToContainGainmap failed", e);
            return false;
        }
    }

    private static Bitmap a(FileDescriptor fileDescriptor, BitmapFactory.Options options) throws Throwable {
        Throwable th;
        Bitmap bitmapDecodeFileDescriptor;
        k.a(options.inPreferredConfig == Bitmap.Config.HARDWARE);
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap bitmapA = null;
        try {
            bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
            if (bitmapDecodeFileDescriptor == null) {
                if (bitmapDecodeFileDescriptor != null) {
                }
                options.inPreferredConfig = Bitmap.Config.HARDWARE;
                return bitmapA;
            }
            try {
                bitmapA = a(bitmapDecodeFileDescriptor);
            } catch (Throwable th2) {
                th = th2;
                if (bitmapDecodeFileDescriptor != null) {
                    bitmapDecodeFileDescriptor.recycle();
                }
                options.inPreferredConfig = Bitmap.Config.HARDWARE;
                throw th;
            }
            bitmapDecodeFileDescriptor.recycle();
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            return bitmapA;
        } catch (Throwable th3) {
            th = th3;
            bitmapDecodeFileDescriptor = null;
        }
    }

    private static Bitmap a(InputStream inputStream, BitmapFactory.Options options) throws Throwable {
        Throwable th;
        Bitmap bitmapDecodeStream;
        k.a(options.inPreferredConfig == Bitmap.Config.HARDWARE);
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap bitmapA = null;
        try {
            bitmapDecodeStream = BitmapFactory.decodeStream(inputStream, null, options);
            if (bitmapDecodeStream == null) {
                if (bitmapDecodeStream != null) {
                }
                options.inPreferredConfig = Bitmap.Config.HARDWARE;
                return bitmapA;
            }
            try {
                bitmapA = a(bitmapDecodeStream);
            } catch (Throwable th2) {
                th = th2;
                if (bitmapDecodeStream != null) {
                    bitmapDecodeStream.recycle();
                }
                options.inPreferredConfig = Bitmap.Config.HARDWARE;
                throw th;
            }
            bitmapDecodeStream.recycle();
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            return bitmapA;
        } catch (Throwable th3) {
            th = th3;
            bitmapDecodeStream = null;
        }
    }

    private static Bitmap a(byte[] bArr, BitmapFactory.Options options) throws Throwable {
        Throwable th;
        Bitmap bitmapDecodeByteArray;
        k.a(options.inPreferredConfig == Bitmap.Config.HARDWARE);
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap bitmapA = null;
        try {
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmapDecodeByteArray == null) {
                if (bitmapDecodeByteArray != null) {
                }
                options.inPreferredConfig = Bitmap.Config.HARDWARE;
                return bitmapA;
            }
            try {
                bitmapA = a(bitmapDecodeByteArray);
            } catch (Throwable th2) {
                th = th2;
                if (bitmapDecodeByteArray != null) {
                    bitmapDecodeByteArray.recycle();
                }
                options.inPreferredConfig = Bitmap.Config.HARDWARE;
                throw th;
            }
            bitmapDecodeByteArray.recycle();
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            return bitmapA;
        } catch (Throwable th3) {
            th = th3;
            bitmapDecodeByteArray = null;
        }
    }

    private static Bitmap a(Bitmap bitmap) {
        Gainmap gainmap = bitmap.getGainmap();
        if (gainmap != null && gainmap.getGainmapContents().getConfig() == Bitmap.Config.ALPHA_8) {
            bitmap.setGainmap(a.a(gainmap));
        }
        return bitmap.copy(Bitmap.Config.HARDWARE, false);
    }
}
