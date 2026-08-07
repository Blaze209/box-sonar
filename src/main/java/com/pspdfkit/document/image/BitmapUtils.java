package com.pspdfkit.document.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.core.content.ContextCompat;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.q10;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.z7;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.io.IOException;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public class BitmapUtils {
    public static Bitmap decodeBitmap(Context context, Uri uri) throws IOException {
        uw.a(context, "context", null);
        uw.a(uri, "imageUri", null);
        return z7.a(context, uri);
    }

    public static Single<Bitmap> decodeBitmapAsync(final Context context, final Uri uri) {
        uw.a(context, "context", null);
        uw.a(uri, "imageUri", null);
        Single singleFromCallable = Single.fromCallable(new Callable() { // from class: com.pspdfkit.document.image.BitmapUtils$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return BitmapUtils.decodeBitmap(context, uri);
            }
        });
        synchronized (ar.class) {
            q10.c();
        }
        Scheduler schedulerIo = Schedulers.io();
        schedulerIo.getClass();
        return singleFromCallable.subscribeOn(schedulerIo);
    }

    public static Bitmap fromDrawable(Context context, int i) {
        Drawable drawable = ContextCompat.getDrawable(context, i);
        Canvas canvas = new Canvas();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        canvas.setBitmap(bitmapCreateBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }
}
