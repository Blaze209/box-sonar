package com.swmansion.rnscreens.gamma.helpers;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\bH\u0000\u001a,\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\bH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"TAG", "", "loadImage", "", "context", "Landroid/content/Context;", "uri", "onLoaded", "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "loadImageInternal", "Landroid/net/Uri;", "react-native-screens_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ImageLoaderKt {
    private static final String TAG = "ImageLoader";

    public static final void loadImage(Context context, String uri, final Function1<? super Drawable, Unit> onLoaded) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(onLoaded, "onLoaded");
        Uri uri2 = new ImageSource(context, uri).getUri(context);
        if (uri2 == null) {
            return;
        }
        loadImageInternal(context, uri2, new Function1() { // from class: com.swmansion.rnscreens.gamma.helpers.ImageLoaderKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ImageLoaderKt.loadImage$lambda$1(onLoaded, (Drawable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit loadImage$lambda$1(final Function1 function1, final Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.swmansion.rnscreens.gamma.helpers.ImageLoaderKt$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                function1.invoke(drawable);
            }
        });
        return Unit.INSTANCE;
    }

    private static final void loadImageInternal(final Context context, final Uri uri, final Function1<? super Drawable, Unit> function1) {
        Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(uri).build(), context).subscribe(new BaseDataSubscriber<CloseableReference<CloseableImage>>() { // from class: com.swmansion.rnscreens.gamma.helpers.ImageLoaderKt.loadImageInternal.1
            @Override // com.facebook.datasource.BaseDataSubscriber
            protected void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                CloseableReference<CloseableImage> result;
                Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                if (dataSource.isFinished() && (result = dataSource.getResult()) != null) {
                    CloseableImage closeableImage = result.get();
                    Intrinsics.checkNotNullExpressionValue(closeableImage, "get(...)");
                    CloseableImage closeableImage2 = closeableImage;
                    if (closeableImage2 instanceof CloseableStaticBitmap) {
                        Bitmap underlyingBitmap = ((CloseableStaticBitmap) closeableImage2).getUnderlyingBitmap();
                        Intrinsics.checkNotNullExpressionValue(underlyingBitmap, "getUnderlyingBitmap(...)");
                        Resources resources = context.getResources();
                        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
                        function1.invoke(new BitmapDrawable(resources, underlyingBitmap));
                    }
                    result.close();
                }
            }

            @Override // com.facebook.datasource.BaseDataSubscriber
            protected void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                Log.e("ImageLoader", "[RNScreens] Error loading image: " + uri, dataSource.getFailureCause());
            }
        }, CallerThreadExecutor.getInstance());
    }
}
