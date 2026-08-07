package sdk.pendo.io.v;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import external.sdk.pendo.io.glide.request.target.BitmapImageViewTarget;
import external.sdk.pendo.io.glide.request.target.DrawableImageViewTarget;
import external.sdk.pendo.io.glide.request.target.ViewTarget;

/* JADX INFO: loaded from: classes5.dex */
public class b {
    public <Z> ViewTarget<ImageView, Z> a(ImageView imageView, Class<Z> cls) {
        if (Bitmap.class.equals(cls)) {
            return new BitmapImageViewTarget(imageView);
        }
        if (Drawable.class.isAssignableFrom(cls)) {
            return new DrawableImageViewTarget(imageView);
        }
        throw new IllegalArgumentException("Unhandled class: " + cls + ", try .as*(Class).transcode(ResourceTranscoder)");
    }
}
