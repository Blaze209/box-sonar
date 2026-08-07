package com.box.android.base.utilities;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.PixelCopy;
import android.view.View;
import android.view.Window;
import androidx.core.content.FileProvider;
import java.io.File;
import java.io.FileOutputStream;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScreenshotCapture.kt */
/* JADX INFO: loaded from: classes9.dex */
@Singleton
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00050\tJ4\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0014¨\u0006\u0016"}, d2 = {"Lcom/box/android/base/utilities/ScreenshotCapture;", "", "<init>", "()V", "capture", "", "window", "Landroid/view/Window;", "callback", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "saveToCacheAndGetUri", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "bitmap", "fileProviderAuthority", "", "filename", "compressionQuality", "", "Companion", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ScreenshotCapture {
    public static final int $stable = 0;
    public static final int DEFAULT_COMPRESSION_QUALITY = 90;
    public static final String DEFAULT_FILENAME = "screenshot.png";

    @Inject
    public ScreenshotCapture() {
    }

    public final void capture(Window window, final Function1<? super Bitmap, Unit> callback) {
        Intrinsics.checkNotNullParameter(window, "window");
        Intrinsics.checkNotNullParameter(callback, "callback");
        View rootView = window.getDecorView().getRootView();
        int width = rootView.getWidth();
        int height = rootView.getHeight();
        if (width <= 0 || height <= 0) {
            callback.invoke(null);
            return;
        }
        try {
            final Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            try {
                PixelCopy.request(window, bitmapCreateBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: com.box.android.base.utilities.ScreenshotCapture$$ExternalSyntheticLambda0
                    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                    public final void onPixelCopyFinished(int i) {
                        ScreenshotCapture.capture$lambda$0(callback, bitmapCreateBitmap, i);
                    }
                }, new Handler(Looper.getMainLooper()));
            } catch (IllegalArgumentException unused) {
                bitmapCreateBitmap.recycle();
                callback.invoke(null);
            }
        } catch (OutOfMemoryError unused2) {
            callback.invoke(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void capture$lambda$0(Function1 function1, Bitmap bitmap, int i) {
        if (i == 0) {
            function1.invoke(bitmap);
        } else {
            bitmap.recycle();
            function1.invoke(null);
        }
    }

    public static /* synthetic */ Uri saveToCacheAndGetUri$default(ScreenshotCapture screenshotCapture, Context context, Bitmap bitmap, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str2 = DEFAULT_FILENAME;
        }
        String str3 = str2;
        if ((i2 & 16) != 0) {
            i = 90;
        }
        return screenshotCapture.saveToCacheAndGetUri(context, bitmap, str, str3, i);
    }

    public final Uri saveToCacheAndGetUri(Context context, Bitmap bitmap, String fileProviderAuthority, String filename, int compressionQuality) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(fileProviderAuthority, "fileProviderAuthority");
        Intrinsics.checkNotNullParameter(filename, "filename");
        try {
            File file = new File(context.getCacheDir(), filename);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, compressionQuality, fileOutputStream);
                CloseableKt.closeFinally(fileOutputStream, null);
                return FileProvider.getUriForFile(context, fileProviderAuthority, file);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(fileOutputStream, th);
                    throw th2;
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }
}
