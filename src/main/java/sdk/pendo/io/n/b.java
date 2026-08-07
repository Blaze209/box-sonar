package sdk.pendo.io.n;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import sdk.pendo.io.y.k;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private static final Paint a = new Paint(6);
    private static final Paint b = new Paint(7);
    private static final Paint c;
    private static final Set<String> d;
    private static final Lock e;

    class a implements c {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // sdk.pendo.io.n.b.c
        public void a(Canvas canvas, Paint paint, RectF rectF) {
            float f = this.a;
            canvas.drawRoundRect(rectF, f, f, paint);
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.n.b$b, reason: collision with other inner class name */
    class C0424b implements c {
        final /* synthetic */ float a;
        final /* synthetic */ float b;
        final /* synthetic */ float c;
        final /* synthetic */ float d;

        C0424b(float f, float f2, float f3, float f4) {
            this.a = f;
            this.b = f2;
            this.c = f3;
            this.d = f4;
        }

        @Override // sdk.pendo.io.n.b.c
        public void a(Canvas canvas, Paint paint, RectF rectF) {
            Path path = new Path();
            float f = this.a;
            float f2 = this.b;
            float f3 = this.c;
            float f4 = this.d;
            path.addRoundRect(rectF, new float[]{f, f, f2, f2, f3, f3, f4, f4}, Path.Direction.CW);
            canvas.drawPath(path, paint);
        }
    }

    private interface c {
        void a(Canvas canvas, Paint paint, RectF rectF);
    }

    private static final class d implements Lock {
        d() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lock() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lockInterruptibly() {
        }

        @Override // java.util.concurrent.locks.Lock
        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock() {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long j, TimeUnit timeUnit) {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public void unlock() {
        }
    }

    static {
        HashSet hashSet = new HashSet(Arrays.asList("XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"));
        d = hashSet;
        e = hashSet.contains(Build.MODEL) ? new ReentrantLock() : new d();
        Paint paint = new Paint(7);
        c = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    public static int a(int i) {
        switch (i) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    private static void a(Bitmap bitmap, Bitmap bitmap2, Matrix matrix) {
        e.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, a);
            a(canvas);
        } finally {
            e.unlock();
        }
    }

    public static Bitmap b(sdk.pendo.io.i.b bVar, Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size too big for input, fit centering instead");
            }
            return d(bVar, bitmap, i, i2);
        }
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "requested target size larger or equal to input, returning input");
        }
        return bitmap;
    }

    public static boolean b(int i) {
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public static Bitmap c(sdk.pendo.io.i.b bVar, Bitmap bitmap, int i, int i2) {
        int iMin = Math.min(i, i2);
        float f = iMin;
        float f2 = f / 2.0f;
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        float fMax = Math.max(f / width, f / height);
        float f3 = width * fMax;
        float f4 = fMax * height;
        float f5 = (f - f3) / 2.0f;
        float f6 = (f - f4) / 2.0f;
        RectF rectF = new RectF(f5, f6, f3 + f5, f4 + f6);
        Bitmap bitmapA = a(bVar, bitmap);
        Bitmap bitmap2 = bVar.get(iMin, iMin, a(bitmap));
        bitmap2.setHasAlpha(true);
        Lock lock = e;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawCircle(f2, f2, f2, b);
            canvas.drawBitmap(bitmapA, (Rect) null, rectF, c);
            a(canvas);
            lock.unlock();
            if (!bitmapA.equals(bitmap)) {
                bVar.put(bitmapA);
            }
            return bitmap2;
        } catch (Throwable th) {
            e.unlock();
            throw th;
        }
    }

    public static Bitmap d(sdk.pendo.io.i.b bVar, Bitmap bitmap, int i, int i2) {
        String str;
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                str = "requested target size matches input, returning input";
                Log.v("TransformationUtils", str);
                return bitmap;
            }
            return bitmap;
        }
        float fMin = Math.min(i / bitmap.getWidth(), i2 / bitmap.getHeight());
        int iRound = Math.round(bitmap.getWidth() * fMin);
        int iRound2 = Math.round(bitmap.getHeight() * fMin);
        if (bitmap.getWidth() == iRound && bitmap.getHeight() == iRound2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                str = "adjusted target size matches input, returning input";
                Log.v("TransformationUtils", str);
                return bitmap;
            }
            return bitmap;
        }
        Bitmap bitmap2 = bVar.get((int) (bitmap.getWidth() * fMin), (int) (bitmap.getHeight() * fMin), b(bitmap));
        a(bitmap, bitmap2);
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "request: " + i + "x" + i2);
            Log.v("TransformationUtils", "toFit:   " + bitmap.getWidth() + "x" + bitmap.getHeight());
            Log.v("TransformationUtils", "toReuse: " + bitmap2.getWidth() + "x" + bitmap2.getHeight());
            Log.v("TransformationUtils", "minPct:   " + fMin);
        }
        Matrix matrix = new Matrix();
        matrix.setScale(fMin, fMin);
        a(bitmap, bitmap2, matrix);
        return bitmap2;
    }

    public static Bitmap a(sdk.pendo.io.i.b bVar, Bitmap bitmap, int i, int i2) {
        float width;
        float width2;
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float height = 0.0f;
        if (bitmap.getWidth() * i2 > bitmap.getHeight() * i) {
            width = i2 / bitmap.getHeight();
            width2 = (i - (bitmap.getWidth() * width)) * 0.5f;
        } else {
            width = i / bitmap.getWidth();
            height = (i2 - (bitmap.getHeight() * width)) * 0.5f;
            width2 = 0.0f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (width2 + 0.5f), (int) (height + 0.5f));
        Bitmap bitmap2 = bVar.get(i, i2, b(bitmap));
        a(bitmap, bitmap2);
        a(bitmap, bitmap2, matrix);
        return bitmap2;
    }

    private static Bitmap.Config b(Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }

    private static void a(Canvas canvas) {
        canvas.setBitmap(null);
    }

    private static Bitmap a(sdk.pendo.io.i.b bVar, Bitmap bitmap) {
        Bitmap.Config configA = a(bitmap);
        if (configA.equals(bitmap.getConfig())) {
            return bitmap;
        }
        Bitmap bitmap2 = bVar.get(bitmap.getWidth(), bitmap.getHeight(), configA);
        new Canvas(bitmap2).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return bitmap2;
    }

    public static Bitmap b(sdk.pendo.io.i.b bVar, Bitmap bitmap, int i) {
        k.a(i > 0, "roundingRadius must be greater than 0.");
        return a(bVar, bitmap, new a(i));
    }

    private static Bitmap.Config a(Bitmap bitmap) {
        return Bitmap.Config.RGBA_F16.equals(bitmap.getConfig()) ? Bitmap.Config.RGBA_F16 : Bitmap.Config.ARGB_8888;
    }

    public static Lock a() {
        return e;
    }

    static void a(int i, Matrix matrix) {
        switch (i) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                return;
            case 3:
                matrix.setRotate(180.0f);
                return;
            case 4:
                matrix.setRotate(180.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                return;
            case 7:
                matrix.setRotate(-90.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                return;
            default:
                return;
        }
        matrix.postScale(-1.0f, 1.0f);
    }

    public static Bitmap a(Bitmap bitmap, int i) {
        Bitmap bitmap2;
        if (i == 0) {
            return bitmap;
        }
        try {
            Matrix matrix = new Matrix();
            matrix.setRotate(i);
            bitmap2 = bitmap;
            try {
                return Bitmap.createBitmap(bitmap2, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } catch (Exception e2) {
                e = e2;
                Exception exc = e;
                if (!Log.isLoggable("TransformationUtils", 6)) {
                    return bitmap2;
                }
                Log.e("TransformationUtils", "Exception when trying to orient image", exc);
                return bitmap2;
            }
        } catch (Exception e3) {
            e = e3;
            bitmap2 = bitmap;
        }
    }

    public static Bitmap a(sdk.pendo.io.i.b bVar, Bitmap bitmap, int i) {
        if (!b(i)) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        a(i, matrix);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap a(sdk.pendo.io.i.b bVar, Bitmap bitmap, float f, float f2, float f3, float f4) {
        return a(bVar, bitmap, new C0424b(f, f2, f3, f4));
    }

    private static Bitmap a(sdk.pendo.io.i.b bVar, Bitmap bitmap, c cVar) {
        Bitmap.Config configA = a(bitmap);
        Bitmap bitmapA = a(bVar, bitmap);
        Bitmap bitmap2 = bVar.get(bitmapA.getWidth(), bitmapA.getHeight(), configA);
        bitmap2.setHasAlpha(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmapA, tileMode, tileMode);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        RectF rectF = new RectF(0.0f, 0.0f, bitmap2.getWidth(), bitmap2.getHeight());
        Lock lock = e;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            cVar.a(canvas, paint, rectF);
            a(canvas);
            lock.unlock();
            if (!bitmapA.equals(bitmap)) {
                bVar.put(bitmapA);
            }
            return bitmap2;
        } catch (Throwable th) {
            e.unlock();
            throw th;
        }
    }

    public static void a(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }
}
