package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import androidx.media3.common.MimeTypes;
import com.pspdfkit.document.providers.DataProvider;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class z7 {
    public static Bitmap a(w7 w7Var, Function0 function0, String str, Integer num, Integer num2) throws IOException {
        int i = w7Var.b;
        int i2 = w7Var.c;
        int iIntValue = num != null ? num.intValue() : Math.min(2048, i);
        int iIntValue2 = num2 != null ? num2.intValue() : Math.min(2048, i2);
        try {
            Closeable closeable = (Closeable) function0.invoke();
            try {
                InputStream inputStream = (InputStream) closeable;
                BitmapFactory.Options options = new BitmapFactory.Options();
                int iMax = (int) Math.max(Math.ceil(i / iIntValue), Math.ceil(i2 / iIntValue2));
                int iHighestOneBit = Integer.highestOneBit(iMax);
                if (iHighestOneBit != iMax) {
                    iMax = iHighestOneBit * 2;
                }
                options.inSampleSize = iMax;
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(closeable, null);
                if (bitmapDecodeStream == null) {
                    throw new IOException("Could not decode bitmap: " + str);
                }
                int width = bitmapDecodeStream.getWidth();
                int height = bitmapDecodeStream.getHeight();
                int iMin = Math.min(width, iIntValue);
                int iMin2 = Math.min(height, iIntValue2);
                if (width != iMin || height != iMin2) {
                    Matrix matrix = new Matrix();
                    matrix.setRectToRect(new RectF(0.0f, 0.0f, width, height), new RectF(0.0f, 0.0f, iMin, iMin2), Matrix.ScaleToFit.CENTER);
                    a(matrix, w7Var.d);
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeStream, 0, 0, width, height, matrix, true);
                    bitmapCreateBitmap.getClass();
                    return bitmapCreateBitmap;
                }
                if (w7Var.d == 0) {
                    return bitmapDecodeStream;
                }
                Matrix matrix2 = new Matrix();
                a(matrix2, w7Var.d);
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmapDecodeStream, 0, 0, width, height, matrix2, true);
                bitmapCreateBitmap2.getClass();
                return bitmapCreateBitmap2;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(closeable, th);
                    throw th2;
                }
            }
        } catch (IOException e) {
            throw new IOException("Could not open image input stream: " + str, e);
        }
    }

    public static final InputStream b(DataProvider dataProvider) {
        return new nk(dataProvider);
    }

    public static final InputStream c(Context context, Uri uri) throws IOException {
        InputStream inputStreamB = wg.b(context, uri);
        inputStreamB.getClass();
        return inputStreamB;
    }

    @JvmStatic
    public static Single d(final Context context, final Uri uri) {
        context.getClass();
        uri.getClass();
        Single singleFromCallable = Single.fromCallable(new Callable() { // from class: com.pspdfkit.internal.z7$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return z7.e(context, uri);
            }
        });
        synchronized (ar.class) {
            q10.c();
        }
        Scheduler schedulerIo = Schedulers.io();
        schedulerIo.getClass();
        Single singleSubscribeOn = singleFromCallable.subscribeOn(schedulerIo);
        singleSubscribeOn.getClass();
        return singleSubscribeOn;
    }

    public static final u7 e(Context context, Uri uri) {
        return a(context, uri, true);
    }

    public static final InputStream b(Context context, Uri uri) throws IOException {
        InputStream inputStreamB = wg.b(context, uri);
        inputStreamB.getClass();
        return inputStreamB;
    }

    public static u7 a(w7 w7Var, Function0 function0, String str, boolean z) throws IOException {
        Bitmap.CompressFormat compressFormat;
        byte[] bArrA;
        int width = w7Var.b;
        int height = w7Var.c;
        int iMin = z ? width : Math.min(2048, width);
        int iMin2 = z ? height : Math.min(2048, height);
        String str2 = w7Var.a;
        if (Intrinsics.areEqual(str2, MimeTypes.IMAGE_JPEG)) {
            compressFormat = Bitmap.CompressFormat.JPEG;
        } else {
            compressFormat = Intrinsics.areEqual(str2, MimeTypes.IMAGE_PNG) ? Bitmap.CompressFormat.PNG : null;
        }
        Bitmap.CompressFormat compressFormat2 = Bitmap.CompressFormat.JPEG;
        if ((compressFormat == compressFormat2 || compressFormat == Bitmap.CompressFormat.PNG) && width == iMin && height == iMin2 && w7Var.d == 1) {
            InputStream inputStream = (InputStream) function0.invoke();
            bArrA = wg.a(inputStream);
            bArrA.getClass();
            inputStream.close();
        } else {
            Bitmap bitmapA = a(w7Var, function0, str, Integer.valueOf(iMin), Integer.valueOf(iMin2));
            width = bitmapA.getWidth();
            height = bitmapA.getHeight();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Bitmap.CompressFormat compressFormat3 = Bitmap.CompressFormat.PNG;
            if (compressFormat != compressFormat3 && !bitmapA.hasAlpha()) {
                bitmapA.compress(compressFormat2, 99, byteArrayOutputStream);
                compressFormat = compressFormat2;
            } else {
                bitmapA.compress(compressFormat3, 100, byteArrayOutputStream);
                compressFormat = compressFormat3;
            }
            bitmapA.recycle();
            bArrA = byteArrayOutputStream.toByteArray();
            bArrA.getClass();
        }
        return new u7(bArrA, width, height, compressFormat);
    }

    @JvmStatic
    public static u7 a(final Context context, final Uri uri, boolean z) throws IOException {
        context.getClass();
        uri.getClass();
        w7 w7VarA = w7.a.a(context, uri);
        Function0 function0 = new Function0() { // from class: com.pspdfkit.internal.z7$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return z7.c(context, uri);
            }
        };
        String string = uri.toString();
        string.getClass();
        return a(w7VarA, function0, string, z);
    }

    @JvmStatic
    public static u7 a(final DataProvider dataProvider) throws IOException {
        dataProvider.getClass();
        w7 w7VarA = w7.a.a(dataProvider);
        Function0 function0 = new Function0() { // from class: com.pspdfkit.internal.z7$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return z7.b(dataProvider);
            }
        };
        String title = dataProvider.getTitle();
        if (title == null) {
            title = dataProvider.toString();
        }
        return a(w7VarA, function0, title, true);
    }

    @JvmStatic
    public static Bitmap a(final Context context, final Uri uri) throws IOException {
        context.getClass();
        uri.getClass();
        w7 w7VarA = w7.a.a(context, uri);
        Function0 function0 = new Function0() { // from class: com.pspdfkit.internal.z7$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return z7.b(context, uri);
            }
        };
        String string = uri.toString();
        string.getClass();
        return a(w7VarA, function0, string, null, null);
    }

    public static void a(Matrix matrix, int i) {
        switch (i) {
            case 2:
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.postRotate(180.0f);
                break;
            case 4:
                matrix.postScale(1.0f, -1.0f);
                break;
            case 5:
                matrix.postRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.postRotate(90.0f);
                break;
            case 7:
                matrix.postRotate(270.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 8:
                matrix.postRotate(270.0f);
                break;
        }
    }
}
