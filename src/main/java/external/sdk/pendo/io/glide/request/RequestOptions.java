package external.sdk.pendo.io.glide.request;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import external.sdk.pendo.io.glide.load.Transformation;
import sdk.pendo.io.e.f;
import sdk.pendo.io.e.g;

/* JADX INFO: loaded from: classes4.dex */
public class RequestOptions extends a<RequestOptions> {
    private static RequestOptions centerCropOptions;
    private static RequestOptions centerInsideOptions;
    private static RequestOptions circleCropOptions;
    private static RequestOptions fitCenterOptions;
    private static RequestOptions noAnimationOptions;
    private static RequestOptions noTransformOptions;
    private static RequestOptions skipMemoryCacheFalseOptions;
    private static RequestOptions skipMemoryCacheTrueOptions;

    public static RequestOptions bitmapTransform(Transformation<Bitmap> transformation) {
        return new RequestOptions().transform(transformation);
    }

    public static RequestOptions centerCropTransform() {
        if (centerCropOptions == null) {
            centerCropOptions = new RequestOptions().centerCrop().autoClone();
        }
        return centerCropOptions;
    }

    public static RequestOptions centerInsideTransform() {
        if (centerInsideOptions == null) {
            centerInsideOptions = new RequestOptions().centerInside().autoClone();
        }
        return centerInsideOptions;
    }

    public static RequestOptions circleCropTransform() {
        if (circleCropOptions == null) {
            circleCropOptions = new RequestOptions().circleCrop().autoClone();
        }
        return circleCropOptions;
    }

    public static RequestOptions decodeTypeOf(Class<?> cls) {
        return new RequestOptions().decode(cls);
    }

    public static RequestOptions diskCacheStrategyOf(sdk.pendo.io.h.a aVar) {
        return new RequestOptions().diskCacheStrategy(aVar);
    }

    public static RequestOptions downsampleOf(external.sdk.pendo.io.glide.load.resource.bitmap.a aVar) {
        return new RequestOptions().downsample(aVar);
    }

    public static RequestOptions encodeFormatOf(Bitmap.CompressFormat compressFormat) {
        return new RequestOptions().encodeFormat(compressFormat);
    }

    public static RequestOptions encodeQualityOf(int i) {
        return new RequestOptions().encodeQuality(i);
    }

    public static RequestOptions errorOf(int i) {
        return new RequestOptions().error(i);
    }

    public static RequestOptions fitCenterTransform() {
        if (fitCenterOptions == null) {
            fitCenterOptions = new RequestOptions().fitCenter().autoClone();
        }
        return fitCenterOptions;
    }

    public static RequestOptions formatOf(sdk.pendo.io.e.b bVar) {
        return new RequestOptions().format(bVar);
    }

    public static RequestOptions frameOf(long j) {
        return new RequestOptions().frame(j);
    }

    public static RequestOptions noAnimation() {
        if (noAnimationOptions == null) {
            noAnimationOptions = new RequestOptions().dontAnimate().autoClone();
        }
        return noAnimationOptions;
    }

    public static RequestOptions noTransformation() {
        if (noTransformOptions == null) {
            noTransformOptions = new RequestOptions().dontTransform().autoClone();
        }
        return noTransformOptions;
    }

    public static <T> RequestOptions option(g<T> gVar, T t) {
        return new RequestOptions().set(gVar, t);
    }

    public static RequestOptions overrideOf(int i) {
        return overrideOf(i, i);
    }

    public static RequestOptions placeholderOf(int i) {
        return new RequestOptions().placeholder(i);
    }

    public static RequestOptions priorityOf(sdk.pendo.io.c.b bVar) {
        return new RequestOptions().priority(bVar);
    }

    public static RequestOptions signatureOf(f fVar) {
        return new RequestOptions().signature(fVar);
    }

    public static RequestOptions sizeMultiplierOf(float f) {
        return new RequestOptions().sizeMultiplier(f);
    }

    public static RequestOptions skipMemoryCacheOf(boolean z) {
        if (z) {
            if (skipMemoryCacheTrueOptions == null) {
                skipMemoryCacheTrueOptions = new RequestOptions().skipMemoryCache(true).autoClone();
            }
            return skipMemoryCacheTrueOptions;
        }
        if (skipMemoryCacheFalseOptions == null) {
            skipMemoryCacheFalseOptions = new RequestOptions().skipMemoryCache(false).autoClone();
        }
        return skipMemoryCacheFalseOptions;
    }

    public static RequestOptions timeoutOf(int i) {
        return new RequestOptions().timeout(i);
    }

    @Override // external.sdk.pendo.io.glide.request.a
    public boolean equals(Object obj) {
        return (obj instanceof RequestOptions) && super.equals(obj);
    }

    @Override // external.sdk.pendo.io.glide.request.a
    public int hashCode() {
        return super.hashCode();
    }

    public static RequestOptions errorOf(Drawable drawable) {
        return new RequestOptions().error(drawable);
    }

    public static RequestOptions overrideOf(int i, int i2) {
        return new RequestOptions().override(i, i2);
    }

    public static RequestOptions placeholderOf(Drawable drawable) {
        return new RequestOptions().placeholder(drawable);
    }
}
