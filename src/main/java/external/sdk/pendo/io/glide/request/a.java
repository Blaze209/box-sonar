package external.sdk.pendo.io.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import external.sdk.pendo.io.glide.load.MultiTransformation;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.Transformation;
import external.sdk.pendo.io.glide.load.model.stream.HttpGlideUrlLoader;
import external.sdk.pendo.io.glide.load.resource.bitmap.BitmapEncoder;
import external.sdk.pendo.io.glide.load.resource.bitmap.CenterCrop;
import external.sdk.pendo.io.glide.load.resource.bitmap.CenterInside;
import external.sdk.pendo.io.glide.load.resource.bitmap.CircleCrop;
import external.sdk.pendo.io.glide.load.resource.bitmap.DrawableTransformation;
import external.sdk.pendo.io.glide.load.resource.bitmap.FitCenter;
import external.sdk.pendo.io.glide.load.resource.bitmap.VideoDecoder;
import external.sdk.pendo.io.glide.load.resource.drawable.ResourceDrawableDecoder;
import external.sdk.pendo.io.glide.load.resource.gif.GifDrawable;
import external.sdk.pendo.io.glide.load.resource.gif.GifDrawableTransformation;
import external.sdk.pendo.io.glide.request.a;
import external.sdk.pendo.io.glide.signature.EmptySignature;
import java.util.Map;
import sdk.pendo.io.e.f;
import sdk.pendo.io.e.g;
import sdk.pendo.io.y.k;
import sdk.pendo.io.y.l;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a<T extends a<T>> implements Cloneable {
    private static final int DISK_CACHE_STRATEGY = 4;
    private static final int ERROR_ID = 32;
    private static final int ERROR_PLACEHOLDER = 16;
    private static final int FALLBACK = 8192;
    private static final int FALLBACK_ID = 16384;
    private static final int IS_CACHEABLE = 256;
    private static final int ONLY_RETRIEVE_FROM_CACHE = 524288;
    private static final int OVERRIDE = 512;
    private static final int PLACEHOLDER = 64;
    private static final int PLACEHOLDER_ID = 128;
    private static final int PRIORITY = 8;
    private static final int RESOURCE_CLASS = 4096;
    private static final int SIGNATURE = 1024;
    private static final int SIZE_MULTIPLIER = 2;
    private static final int THEME = 32768;
    private static final int TRANSFORMATION = 2048;
    private static final int TRANSFORMATION_ALLOWED = 65536;
    private static final int TRANSFORMATION_REQUIRED = 131072;
    private static final int UNSET = -1;
    private static final int USE_ANIMATION_POOL = 1048576;
    private static final int USE_UNLIMITED_SOURCE_GENERATORS_POOL = 262144;
    private int errorId;
    private Drawable errorPlaceholder;
    private Drawable fallbackDrawable;
    private int fallbackId;
    private int fields;
    private boolean isAutoCloneEnabled;
    private boolean isLocked;
    private boolean isTransformationRequired;
    private boolean onlyRetrieveFromCache;
    private Drawable placeholderDrawable;
    private int placeholderId;
    private Resources.Theme theme;
    private boolean useAnimationPool;
    private boolean useUnlimitedSourceGeneratorsPool;
    private float sizeMultiplier = 1.0f;
    private sdk.pendo.io.h.a diskCacheStrategy = sdk.pendo.io.h.a.e;
    private sdk.pendo.io.c.b priority = sdk.pendo.io.c.b.NORMAL;
    private boolean isCacheable = true;
    private int overrideHeight = -1;
    private int overrideWidth = -1;
    private f signature = EmptySignature.obtain();
    private boolean isTransformationAllowed = true;
    private Options options = new Options();
    private Map<Class<?>, Transformation<?>> transformations = new sdk.pendo.io.y.b();
    private Class<?> resourceClass = Object.class;
    private boolean isScaleOnlyOrNoTransform = true;

    private boolean isSet(int i) {
        return isSet(this.fields, i);
    }

    private static boolean isSet(int i, int i2) {
        return (i & i2) != 0;
    }

    private T optionalScaleOnlyTransform(external.sdk.pendo.io.glide.load.resource.bitmap.a aVar, Transformation<Bitmap> transformation) {
        return (T) scaleOnlyTransform(aVar, transformation, false);
    }

    private T scaleOnlyTransform(external.sdk.pendo.io.glide.load.resource.bitmap.a aVar, Transformation<Bitmap> transformation) {
        return (T) scaleOnlyTransform(aVar, transformation, true);
    }

    private T self() {
        return this;
    }

    public T apply(a<?> aVar) {
        if (this.isAutoCloneEnabled) {
            return (T) mo14694clone().apply(aVar);
        }
        if (isSet(aVar.fields, 2)) {
            this.sizeMultiplier = aVar.sizeMultiplier;
        }
        if (isSet(aVar.fields, 262144)) {
            this.useUnlimitedSourceGeneratorsPool = aVar.useUnlimitedSourceGeneratorsPool;
        }
        if (isSet(aVar.fields, 1048576)) {
            this.useAnimationPool = aVar.useAnimationPool;
        }
        if (isSet(aVar.fields, 4)) {
            this.diskCacheStrategy = aVar.diskCacheStrategy;
        }
        if (isSet(aVar.fields, 8)) {
            this.priority = aVar.priority;
        }
        if (isSet(aVar.fields, 16)) {
            this.errorPlaceholder = aVar.errorPlaceholder;
            this.errorId = 0;
            this.fields &= -33;
        }
        if (isSet(aVar.fields, 32)) {
            this.errorId = aVar.errorId;
            this.errorPlaceholder = null;
            this.fields &= -17;
        }
        if (isSet(aVar.fields, 64)) {
            this.placeholderDrawable = aVar.placeholderDrawable;
            this.placeholderId = 0;
            this.fields &= -129;
        }
        if (isSet(aVar.fields, 128)) {
            this.placeholderId = aVar.placeholderId;
            this.placeholderDrawable = null;
            this.fields &= -65;
        }
        if (isSet(aVar.fields, 256)) {
            this.isCacheable = aVar.isCacheable;
        }
        if (isSet(aVar.fields, 512)) {
            this.overrideWidth = aVar.overrideWidth;
            this.overrideHeight = aVar.overrideHeight;
        }
        if (isSet(aVar.fields, 1024)) {
            this.signature = aVar.signature;
        }
        if (isSet(aVar.fields, 4096)) {
            this.resourceClass = aVar.resourceClass;
        }
        if (isSet(aVar.fields, 8192)) {
            this.fallbackDrawable = aVar.fallbackDrawable;
            this.fallbackId = 0;
            this.fields &= -16385;
        }
        if (isSet(aVar.fields, 16384)) {
            this.fallbackId = aVar.fallbackId;
            this.fallbackDrawable = null;
            this.fields &= -8193;
        }
        if (isSet(aVar.fields, 32768)) {
            this.theme = aVar.theme;
        }
        if (isSet(aVar.fields, 65536)) {
            this.isTransformationAllowed = aVar.isTransformationAllowed;
        }
        if (isSet(aVar.fields, 131072)) {
            this.isTransformationRequired = aVar.isTransformationRequired;
        }
        if (isSet(aVar.fields, 2048)) {
            this.transformations.putAll(aVar.transformations);
            this.isScaleOnlyOrNoTransform = aVar.isScaleOnlyOrNoTransform;
        }
        if (isSet(aVar.fields, 524288)) {
            this.onlyRetrieveFromCache = aVar.onlyRetrieveFromCache;
        }
        if (!this.isTransformationAllowed) {
            this.transformations.clear();
            int i = this.fields;
            this.isTransformationRequired = false;
            this.fields = i & (-133121);
            this.isScaleOnlyOrNoTransform = true;
        }
        this.fields |= aVar.fields;
        this.options.putAll(aVar.options);
        return (T) selfOrThrowIfLocked();
    }

    public T autoClone() {
        if (this.isLocked && !this.isAutoCloneEnabled) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.isAutoCloneEnabled = true;
        return (T) lock();
    }

    public T centerCrop() {
        return (T) transform(external.sdk.pendo.io.glide.load.resource.bitmap.a.e, new CenterCrop());
    }

    public T centerInside() {
        return (T) scaleOnlyTransform(external.sdk.pendo.io.glide.load.resource.bitmap.a.d, new CenterInside());
    }

    public T circleCrop() {
        return (T) transform(external.sdk.pendo.io.glide.load.resource.bitmap.a.d, new CircleCrop());
    }

    @Override // 
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public T mo14694clone() {
        try {
            T t = (T) super.clone();
            Options options = new Options();
            t.options = options;
            options.putAll(this.options);
            sdk.pendo.io.y.b bVar = new sdk.pendo.io.y.b();
            t.transformations = bVar;
            bVar.putAll(this.transformations);
            t.isLocked = false;
            t.isAutoCloneEnabled = false;
            return t;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public T decode(Class<?> cls) {
        if (this.isAutoCloneEnabled) {
            return (T) mo14694clone().decode(cls);
        }
        this.resourceClass = (Class) k.a(cls);
        this.fields |= 4096;
        return (T) selfOrThrowIfLocked();
    }

    public T disallowHardwareConfig() {
        return (T) set(external.sdk.pendo.io.glide.load.resource.bitmap.b.j, Boolean.FALSE);
    }

    public T diskCacheStrategy(sdk.pendo.io.h.a aVar) {
        if (this.isAutoCloneEnabled) {
            return (T) mo14694clone().diskCacheStrategy(aVar);
        }
        this.diskCacheStrategy = (sdk.pendo.io.h.a) k.a(aVar);
        this.fields |= 4;
        return (T) selfOrThrowIfLocked();
    }

    public T dontAnimate() {
        return (T) set(sdk.pendo.io.p.a.b, Boolean.TRUE);
    }

    public T dontTransform() {
        if (this.isAutoCloneEnabled) {
            return (T) mo14694clone().dontTransform();
        }
        this.transformations.clear();
        int i = this.fields;
        this.isTransformationRequired = false;
        this.isTransformationAllowed = false;
        this.fields = (i & (-133121)) | 65536;
        this.isScaleOnlyOrNoTransform = true;
        return (T) selfOrThrowIfLocked();
    }

    public T downsample(external.sdk.pendo.io.glide.load.resource.bitmap.a aVar) {
        return (T) set(external.sdk.pendo.io.glide.load.resource.bitmap.a.h, (external.sdk.pendo.io.glide.load.resource.bitmap.a) k.a(aVar));
    }

    public T encodeFormat(Bitmap.CompressFormat compressFormat) {
        return (T) set(BitmapEncoder.COMPRESSION_FORMAT, (Bitmap.CompressFormat) k.a(compressFormat));
    }

    public T encodeQuality(int i) {
        return (T) set(BitmapEncoder.COMPRESSION_QUALITY, Integer.valueOf(i));
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return isEquivalentTo((a) obj);
        }
        return false;
    }

    public T error(int i) {
        if (this.isAutoCloneEnabled) {
            return (T) mo14694clone().error(i);
        }
        this.errorId = i;
        int i2 = this.fields | 32;
        this.errorPlaceholder = null;
        this.fields = i2 & (-17);
        return (T) selfOrThrowIfLocked();
    }

    public T fallback(int i) {
        if (this.isAutoCloneEnabled) {
            return (T) mo14694clone().fallback(i);
        }
        this.fallbackId = i;
        int i2 = this.fields | 16384;
        this.fallbackDrawable = null;
        this.fields = i2 & (-8193);
        return (T) selfOrThrowIfLocked();
    }

    public T fitCenter() {
        return (T) scaleOnlyTransform(external.sdk.pendo.io.glide.load.resource.bitmap.a.c, new FitCenter());
    }

    public T format(sdk.pendo.io.e.b bVar) {
        k.a(bVar);
        return (T) set(external.sdk.pendo.io.glide.load.resource.bitmap.b.f, bVar).set(sdk.pendo.io.p.a.a, bVar);
    }

    public T frame(long j) {
        return (T) set(VideoDecoder.TARGET_FRAME, Long.valueOf(j));
    }

    public final sdk.pendo.io.h.a getDiskCacheStrategy() {
        return this.diskCacheStrategy;
    }

    public final int getErrorId() {
        return this.errorId;
    }

    public final Drawable getErrorPlaceholder() {
        return this.errorPlaceholder;
    }

    public final Drawable getFallbackDrawable() {
        return this.fallbackDrawable;
    }

    public final int getFallbackId() {
        return this.fallbackId;
    }

    public final boolean getOnlyRetrieveFromCache() {
        return this.onlyRetrieveFromCache;
    }

    public final Options getOptions() {
        return this.options;
    }

    public final int getOverrideHeight() {
        return this.overrideHeight;
    }

    public final int getOverrideWidth() {
        return this.overrideWidth;
    }

    public final Drawable getPlaceholderDrawable() {
        return this.placeholderDrawable;
    }

    public final int getPlaceholderId() {
        return this.placeholderId;
    }

    public final sdk.pendo.io.c.b getPriority() {
        return this.priority;
    }

    public final Class<?> getResourceClass() {
        return this.resourceClass;
    }

    public final f getSignature() {
        return this.signature;
    }

    public final float getSizeMultiplier() {
        return this.sizeMultiplier;
    }

    public final Resources.Theme getTheme() {
        return this.theme;
    }

    public final Map<Class<?>, Transformation<?>> getTransformations() {
        return this.transformations;
    }

    public final boolean getUseAnimationPool() {
        return this.useAnimationPool;
    }

    public final boolean getUseUnlimitedSourceGeneratorsPool() {
        return this.useUnlimitedSourceGeneratorsPool;
    }

    public int hashCode() {
        return l.a(this.theme, l.a(this.signature, l.a(this.resourceClass, l.a(this.transformations, l.a(this.options, l.a(this.priority, l.a(this.diskCacheStrategy, l.a(this.onlyRetrieveFromCache, l.a(this.useUnlimitedSourceGeneratorsPool, l.a(this.isTransformationAllowed, l.a(this.isTransformationRequired, l.a(this.overrideWidth, l.a(this.overrideHeight, l.a(this.isCacheable, l.a(this.fallbackDrawable, l.a(this.fallbackId, l.a(this.placeholderDrawable, l.a(this.placeholderId, l.a(this.errorPlaceholder, l.a(this.errorId, l.a(this.sizeMultiplier)))))))))))))))))))));
    }

    protected final boolean isAutoCloneEnabled() {
        return this.isAutoCloneEnabled;
    }

    public final boolean isDiskCacheStrategySet() {
        return isSet(4);
    }

    public final boolean isEquivalentTo(a<?> aVar) {
        return Float.compare(aVar.sizeMultiplier, this.sizeMultiplier) == 0 && this.errorId == aVar.errorId && l.b(this.errorPlaceholder, aVar.errorPlaceholder) && this.placeholderId == aVar.placeholderId && l.b(this.placeholderDrawable, aVar.placeholderDrawable) && this.fallbackId == aVar.fallbackId && l.b(this.fallbackDrawable, aVar.fallbackDrawable) && this.isCacheable == aVar.isCacheable && this.overrideHeight == aVar.overrideHeight && this.overrideWidth == aVar.overrideWidth && this.isTransformationRequired == aVar.isTransformationRequired && this.isTransformationAllowed == aVar.isTransformationAllowed && this.useUnlimitedSourceGeneratorsPool == aVar.useUnlimitedSourceGeneratorsPool && this.onlyRetrieveFromCache == aVar.onlyRetrieveFromCache && this.diskCacheStrategy.equals(aVar.diskCacheStrategy) && this.priority == aVar.priority && this.options.equals(aVar.options) && this.transformations.equals(aVar.transformations) && this.resourceClass.equals(aVar.resourceClass) && l.b(this.signature, aVar.signature) && l.b(this.theme, aVar.theme);
    }

    public final boolean isLocked() {
        return this.isLocked;
    }

    public final boolean isMemoryCacheable() {
        return this.isCacheable;
    }

    public final boolean isPrioritySet() {
        return isSet(8);
    }

    boolean isScaleOnlyOrNoTransform() {
        return this.isScaleOnlyOrNoTransform;
    }

    public final boolean isSkipMemoryCacheSet() {
        return isSet(256);
    }

    public final boolean isTransformationAllowed() {
        return this.isTransformationAllowed;
    }

    public final boolean isTransformationRequired() {
        return this.isTransformationRequired;
    }

    public final boolean isTransformationSet() {
        return isSet(2048);
    }

    public final boolean isValidOverride() {
        return l.b(this.overrideWidth, this.overrideHeight);
    }

    public T lock() {
        this.isLocked = true;
        return (T) self();
    }

    public T onlyRetrieveFromCache(boolean z) {
        if (this.isAutoCloneEnabled) {
            return (T) mo14694clone().onlyRetrieveFromCache(z);
        }
        this.onlyRetrieveFromCache = z;
        this.fields |= 524288;
        return (T) selfOrThrowIfLocked();
    }

    public T optionalCenterCrop() {
        return (T) optionalTransform(external.sdk.pendo.io.glide.load.resource.bitmap.a.e, new CenterCrop());
    }

    public T optionalCenterInside() {
        return (T) optionalScaleOnlyTransform(external.sdk.pendo.io.glide.load.resource.bitmap.a.d, new CenterInside());
    }

    public T optionalCircleCrop() {
        return (T) optionalTransform(external.sdk.pendo.io.glide.load.resource.bitmap.a.e, new CircleCrop());
    }

    public T optionalFitCenter() {
        return (T) optionalScaleOnlyTransform(external.sdk.pendo.io.glide.load.resource.bitmap.a.c, new FitCenter());
    }

    public T optionalTransform(Transformation<Bitmap> transformation) {
        return (T) transform(transformation, false);
    }

    public T override(int i) {
        return (T) override(i, i);
    }

    public T placeholder(int i) {
        if (this.isAutoCloneEnabled) {
            return (T) mo14694clone().placeholder(i);
        }
        this.placeholderId = i;
        int i2 = this.fields | 128;
        this.placeholderDrawable = null;
        this.fields = i2 & (-65);
        return (T) selfOrThrowIfLocked();
    }

    public T priority(sdk.pendo.io.c.b bVar) {
        if (this.isAutoCloneEnabled) {
            return (T) mo14694clone().priority(bVar);
        }
        this.priority = (sdk.pendo.io.c.b) k.a(bVar);
        this.fields |= 8;
        return (T) selfOrThrowIfLocked();
    }

    T removeOption(g<?> gVar) {
        if (this.isAutoCloneEnabled) {
            return (T) mo14694clone().removeOption(gVar);
        }
        this.options.remove(gVar);
        return (T) selfOrThrowIfLocked();
    }

    protected final T selfOrThrowIfLocked() {
        if (this.isLocked) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return (T) self();
    }

    public <Y> T set(g<Y> gVar, Y y) {
        if (this.isAutoCloneEnabled) {
            return (T) mo14694clone().set(gVar, y);
        }
        k.a(gVar);
        k.a(y);
        this.options.set(gVar, y);
        return (T) selfOrThrowIfLocked();
    }

    public T signature(f fVar) {
        if (this.isAutoCloneEnabled) {
            return (T) mo14694clone().signature(fVar);
        }
        this.signature = (f) k.a(fVar);
        this.fields |= 1024;
        return (T) selfOrThrowIfLocked();
    }

    public T sizeMultiplier(float f) {
        if (this.isAutoCloneEnabled) {
            return (T) mo14694clone().sizeMultiplier(f);
        }
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.sizeMultiplier = f;
        this.fields |= 2;
        return (T) selfOrThrowIfLocked();
    }

    public T skipMemoryCache(boolean z) {
        if (this.isAutoCloneEnabled) {
            return (T) mo14694clone().skipMemoryCache(true);
        }
        this.isCacheable = !z;
        this.fields |= 256;
        return (T) selfOrThrowIfLocked();
    }

    public T theme(Resources.Theme theme) {
        if (this.isAutoCloneEnabled) {
            return (T) mo14694clone().theme(theme);
        }
        this.theme = theme;
        if (theme != null) {
            this.fields |= 32768;
            return (T) set(ResourceDrawableDecoder.THEME, theme);
        }
        this.fields &= -32769;
        return (T) removeOption(ResourceDrawableDecoder.THEME);
    }

    public T timeout(int i) {
        return (T) set(HttpGlideUrlLoader.TIMEOUT, Integer.valueOf(i));
    }

    public T transform(Transformation<Bitmap> transformation) {
        return (T) transform(transformation, true);
    }

    @Deprecated
    public T transforms(Transformation<Bitmap>... transformationArr) {
        return (T) transform((Transformation<Bitmap>) new MultiTransformation(transformationArr), true);
    }

    public T useAnimationPool(boolean z) {
        if (this.isAutoCloneEnabled) {
            return (T) mo14694clone().useAnimationPool(z);
        }
        this.useAnimationPool = z;
        this.fields |= 1048576;
        return (T) selfOrThrowIfLocked();
    }

    public T useUnlimitedSourceGeneratorsPool(boolean z) {
        if (this.isAutoCloneEnabled) {
            return (T) mo14694clone().useUnlimitedSourceGeneratorsPool(z);
        }
        this.useUnlimitedSourceGeneratorsPool = z;
        this.fields |= 262144;
        return (T) selfOrThrowIfLocked();
    }

    private T scaleOnlyTransform(external.sdk.pendo.io.glide.load.resource.bitmap.a aVar, Transformation<Bitmap> transformation, boolean z) {
        T t = z ? (T) transform(aVar, transformation) : (T) optionalTransform(aVar, transformation);
        t.isScaleOnlyOrNoTransform = true;
        return t;
    }

    public T error(Drawable drawable) {
        if (this.isAutoCloneEnabled) {
            return (T) mo14694clone().error(drawable);
        }
        this.errorPlaceholder = drawable;
        int i = this.fields | 16;
        this.errorId = 0;
        this.fields = i & (-33);
        return (T) selfOrThrowIfLocked();
    }

    public T fallback(Drawable drawable) {
        if (this.isAutoCloneEnabled) {
            return (T) mo14694clone().fallback(drawable);
        }
        this.fallbackDrawable = drawable;
        int i = this.fields | 8192;
        this.fallbackId = 0;
        this.fields = i & (-16385);
        return (T) selfOrThrowIfLocked();
    }

    final T optionalTransform(external.sdk.pendo.io.glide.load.resource.bitmap.a aVar, Transformation<Bitmap> transformation) {
        if (this.isAutoCloneEnabled) {
            return (T) mo14694clone().optionalTransform(aVar, transformation);
        }
        downsample(aVar);
        return (T) transform(transformation, false);
    }

    public T override(int i, int i2) {
        if (this.isAutoCloneEnabled) {
            return (T) mo14694clone().override(i, i2);
        }
        this.overrideWidth = i;
        this.overrideHeight = i2;
        this.fields |= 512;
        return (T) selfOrThrowIfLocked();
    }

    public T placeholder(Drawable drawable) {
        if (this.isAutoCloneEnabled) {
            return (T) mo14694clone().placeholder(drawable);
        }
        this.placeholderDrawable = drawable;
        int i = this.fields | 64;
        this.placeholderId = 0;
        this.fields = i & (-129);
        return (T) selfOrThrowIfLocked();
    }

    /* JADX WARN: Multi-variable type inference failed */
    T transform(Transformation<Bitmap> transformation, boolean z) {
        if (this.isAutoCloneEnabled) {
            return (T) mo14694clone().transform(transformation, z);
        }
        DrawableTransformation drawableTransformation = new DrawableTransformation(transformation, z);
        transform(Bitmap.class, transformation, z);
        transform(Drawable.class, drawableTransformation, z);
        transform(BitmapDrawable.class, drawableTransformation.asBitmapDrawable(), z);
        transform(GifDrawable.class, new GifDrawableTransformation(transformation), z);
        return (T) selfOrThrowIfLocked();
    }

    public <Y> T optionalTransform(Class<Y> cls, Transformation<Y> transformation) {
        return (T) transform(cls, transformation, false);
    }

    final T transform(external.sdk.pendo.io.glide.load.resource.bitmap.a aVar, Transformation<Bitmap> transformation) {
        if (this.isAutoCloneEnabled) {
            return (T) mo14694clone().transform(aVar, transformation);
        }
        downsample(aVar);
        return (T) transform(transformation);
    }

    public <Y> T transform(Class<Y> cls, Transformation<Y> transformation) {
        return (T) transform(cls, transformation, true);
    }

    <Y> T transform(Class<Y> cls, Transformation<Y> transformation, boolean z) {
        if (this.isAutoCloneEnabled) {
            return (T) mo14694clone().transform(cls, transformation, z);
        }
        k.a(cls);
        k.a(transformation);
        this.transformations.put(cls, transformation);
        int i = this.fields;
        this.isTransformationAllowed = true;
        this.fields = 67584 | i;
        this.isScaleOnlyOrNoTransform = false;
        if (z) {
            this.fields = i | 198656;
            this.isTransformationRequired = true;
        }
        return (T) selfOrThrowIfLocked();
    }

    public T transform(Transformation<Bitmap>... transformationArr) {
        if (transformationArr.length > 1) {
            return (T) transform((Transformation<Bitmap>) new MultiTransformation(transformationArr), true);
        }
        return transformationArr.length == 1 ? (T) transform(transformationArr[0]) : (T) selfOrThrowIfLocked();
    }
}
