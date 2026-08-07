package sdk.pendo.io.b7;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.core.graphics.drawable.DrawableKt;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.h7.s;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\t\u0010\nJ)\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\t\u0010\rJ+\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\t\u0010\u0010¨\u0006\u0013"}, d2 = {"Lsdk/pendo/io/b7/f;", "", "Landroid/widget/ImageView;", "imageView", "", "shouldApplyPrivacy", "", "elementName", "Landroid/graphics/Bitmap;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Landroid/widget/ImageView;ZLjava/lang/String;)Landroid/graphics/Bitmap;", "Landroid/view/View;", "view", "(Landroid/view/View;ZLjava/lang/String;)Landroid/graphics/Bitmap;", "Landroid/graphics/drawable/Drawable;", "drawable", "(Landroid/graphics/drawable/Drawable;ZLjava/lang/String;)Landroid/graphics/Bitmap;", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class f {
    public static final f a = new f();

    private f() {
    }

    public final Bitmap a(Drawable drawable, boolean shouldApplyPrivacy, String elementName) {
        Intrinsics.checkNotNullParameter(elementName, "elementName");
        if (drawable == null) {
            return null;
        }
        Rect bounds = drawable.getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
        if (bounds.width() == 0 || bounds.height() == 0) {
            return null;
        }
        if (!shouldApplyPrivacy) {
            try {
                return DrawableKt.toBitmap$default(drawable, bounds.width(), bounds.height(), null, 4, null);
            } catch (Exception e) {
                PendoLogger.d("ImageExtractionUtils", "extractBitmapFromDrawable: failed to convert drawable for '" + elementName + "', falling back to blocked bitmap. " + e.getMessage());
            }
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(s.INSTANCE.a(), bounds.width(), bounds.height(), true);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(this, width, height, filter)");
        return bitmapCreateScaledBitmap;
    }

    public final Bitmap a(ImageView imageView, boolean shouldApplyPrivacy, String elementName) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(elementName, "elementName");
        return a(imageView.getDrawable(), shouldApplyPrivacy, elementName);
    }

    public final Bitmap a(View view, boolean shouldApplyPrivacy, String elementName) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementName, "elementName");
        Drawable background = view.getBackground();
        if (background == null || !c.a.d(background)) {
            return null;
        }
        if (background.getBounds().isEmpty()) {
            background.setBounds(0, 0, view.getWidth(), view.getHeight());
        }
        if (background.getBounds().width() <= 0 || background.getBounds().height() <= 0) {
            return null;
        }
        return a(background, shouldApplyPrivacy, elementName);
    }
}
