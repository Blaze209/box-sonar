package androidx.transition;

import android.graphics.Matrix;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes9.dex */
class ImageViewUtils {
    private static boolean sTryHiddenAnimateTransform = true;

    static void animateTransform(ImageView imageView, Matrix matrix) {
        Api29Impl.animateTransform(imageView, matrix);
    }

    private static void hiddenAnimateTransform(ImageView imageView, Matrix matrix) {
        if (sTryHiddenAnimateTransform) {
            try {
                Api29Impl.animateTransform(imageView, matrix);
            } catch (NoSuchMethodError unused) {
                sTryHiddenAnimateTransform = false;
            }
        }
    }

    private ImageViewUtils() {
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static void animateTransform(ImageView imageView, Matrix matrix) {
            imageView.animateTransform(matrix);
        }
    }
}
