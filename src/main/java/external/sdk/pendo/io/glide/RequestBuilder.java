package external.sdk.pendo.io.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.facebook.common.util.UriUtil;
import external.sdk.pendo.io.glide.request.ErrorRequestCoordinator;
import external.sdk.pendo.io.glide.request.FutureTarget;
import external.sdk.pendo.io.glide.request.RequestFutureTarget;
import external.sdk.pendo.io.glide.request.RequestOptions;
import external.sdk.pendo.io.glide.request.SingleRequest;
import external.sdk.pendo.io.glide.request.ThumbnailRequestCoordinator;
import external.sdk.pendo.io.glide.request.target.PreloadTarget;
import external.sdk.pendo.io.glide.request.target.Target;
import external.sdk.pendo.io.glide.request.target.ViewTarget;
import external.sdk.pendo.io.glide.signature.AndroidResourceSignature;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import sdk.pendo.io.y.k;
import sdk.pendo.io.y.l;

/* JADX INFO: loaded from: classes4.dex */
public class RequestBuilder<TranscodeType> extends external.sdk.pendo.io.glide.request.a<RequestBuilder<TranscodeType>> {
    protected static final RequestOptions DOWNLOAD_ONLY_OPTIONS = new RequestOptions().diskCacheStrategy(sdk.pendo.io.h.a.c).priority(sdk.pendo.io.c.b.LOW).skipMemoryCache(true);
    private final Context context;
    private RequestBuilder<TranscodeType> errorBuilder;
    private final external.sdk.pendo.io.glide.a glide;
    private final b glideContext;
    private boolean isDefaultTransitionOptionsSet;
    private boolean isModelSet;
    private boolean isThumbnailBuilt;
    private Object model;
    private List<sdk.pendo.io.u.b<TranscodeType>> requestListeners;
    private final RequestManager requestManager;
    private Float thumbSizeMultiplier;
    private RequestBuilder<TranscodeType> thumbnailBuilder;
    private final Class<TranscodeType> transcodeClass;
    private e<?, ? super TranscodeType> transitionOptions;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[sdk.pendo.io.c.b.values().length];
            b = iArr;
            try {
                iArr[sdk.pendo.io.c.b.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[sdk.pendo.io.c.b.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[sdk.pendo.io.c.b.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[sdk.pendo.io.c.b.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            a = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    protected RequestBuilder(external.sdk.pendo.io.glide.a aVar, RequestManager requestManager, Class<TranscodeType> cls, Context context) {
        this.isDefaultTransitionOptionsSet = true;
        this.glide = aVar;
        this.requestManager = requestManager;
        this.transcodeClass = cls;
        this.context = context;
        this.transitionOptions = requestManager.getDefaultTransitionOptions(cls);
        this.glideContext = aVar.f();
        initRequestListeners(requestManager.getDefaultRequestListeners());
        apply((external.sdk.pendo.io.glide.request.a<?>) requestManager.getDefaultRequestOptions());
    }

    private RequestBuilder<TranscodeType> applyResourceThemeAndSignature(RequestBuilder<TranscodeType> requestBuilder) {
        return requestBuilder.theme(this.context.getTheme()).signature(AndroidResourceSignature.obtain(this.context));
    }

    private sdk.pendo.io.u.a buildRequest(Target<TranscodeType> target, sdk.pendo.io.u.b<TranscodeType> bVar, external.sdk.pendo.io.glide.request.a<?> aVar, Executor executor) {
        return buildRequestRecursive(new Object(), target, bVar, null, this.transitionOptions, aVar.getPriority(), aVar.getOverrideWidth(), aVar.getOverrideHeight(), aVar, executor);
    }

    private sdk.pendo.io.u.a buildRequestRecursive(Object obj, Target<TranscodeType> target, sdk.pendo.io.u.b<TranscodeType> bVar, external.sdk.pendo.io.glide.request.b bVar2, e<?, ? super TranscodeType> eVar, sdk.pendo.io.c.b bVar3, int i, int i2, external.sdk.pendo.io.glide.request.a<?> aVar, Executor executor) {
        ErrorRequestCoordinator errorRequestCoordinator;
        if (this.errorBuilder != null) {
            errorRequestCoordinator = new ErrorRequestCoordinator(obj, bVar2);
            bVar2 = errorRequestCoordinator;
        } else {
            errorRequestCoordinator = null;
        }
        sdk.pendo.io.u.a aVarBuildThumbnailRequestRecursive = buildThumbnailRequestRecursive(obj, target, bVar, bVar2, eVar, bVar3, i, i2, aVar, executor);
        if (errorRequestCoordinator == null) {
            return aVarBuildThumbnailRequestRecursive;
        }
        int overrideWidth = this.errorBuilder.getOverrideWidth();
        int overrideHeight = this.errorBuilder.getOverrideHeight();
        if (l.b(i, i2) && !this.errorBuilder.isValidOverride()) {
            overrideWidth = aVar.getOverrideWidth();
            overrideHeight = aVar.getOverrideHeight();
        }
        int i3 = overrideHeight;
        RequestBuilder<TranscodeType> requestBuilder = this.errorBuilder;
        ErrorRequestCoordinator errorRequestCoordinator2 = errorRequestCoordinator;
        errorRequestCoordinator2.setRequests(aVarBuildThumbnailRequestRecursive, requestBuilder.buildRequestRecursive(obj, target, bVar, errorRequestCoordinator2, requestBuilder.transitionOptions, requestBuilder.getPriority(), overrideWidth, i3, this.errorBuilder, executor));
        return errorRequestCoordinator2;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private sdk.pendo.io.u.a buildThumbnailRequestRecursive(Object obj, Target<TranscodeType> target, sdk.pendo.io.u.b<TranscodeType> bVar, external.sdk.pendo.io.glide.request.b bVar2, e<?, ? super TranscodeType> eVar, sdk.pendo.io.c.b bVar3, int i, int i2, external.sdk.pendo.io.glide.request.a<?> aVar, Executor executor) {
        RequestBuilder<TranscodeType> requestBuilder = this.thumbnailBuilder;
        if (requestBuilder == null) {
            if (this.thumbSizeMultiplier == null) {
                return obtainRequest(obj, target, bVar, aVar, bVar2, eVar, bVar3, i, i2, executor);
            }
            ThumbnailRequestCoordinator thumbnailRequestCoordinator = new ThumbnailRequestCoordinator(obj, bVar2);
            thumbnailRequestCoordinator.setRequests(obtainRequest(obj, target, bVar, aVar, thumbnailRequestCoordinator, eVar, bVar3, i, i2, executor), obtainRequest(obj, target, bVar, aVar.mo14694clone().sizeMultiplier(this.thumbSizeMultiplier.floatValue()), thumbnailRequestCoordinator, eVar, getThumbnailPriority(bVar3), i, i2, executor));
            return thumbnailRequestCoordinator;
        }
        if (this.isThumbnailBuilt) {
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        e<?, ? super TranscodeType> eVar2 = requestBuilder.isDefaultTransitionOptionsSet ? eVar : requestBuilder.transitionOptions;
        sdk.pendo.io.c.b priority = requestBuilder.isPrioritySet() ? this.thumbnailBuilder.getPriority() : getThumbnailPriority(bVar3);
        int overrideWidth = this.thumbnailBuilder.getOverrideWidth();
        int overrideHeight = this.thumbnailBuilder.getOverrideHeight();
        if (l.b(i, i2) && !this.thumbnailBuilder.isValidOverride()) {
            overrideWidth = aVar.getOverrideWidth();
            overrideHeight = aVar.getOverrideHeight();
        }
        ThumbnailRequestCoordinator thumbnailRequestCoordinator2 = new ThumbnailRequestCoordinator(obj, bVar2);
        sdk.pendo.io.u.a aVarObtainRequest = obtainRequest(obj, target, bVar, aVar, thumbnailRequestCoordinator2, eVar, bVar3, i, i2, executor);
        this.isThumbnailBuilt = true;
        RequestBuilder requestBuilder2 = (RequestBuilder<TranscodeType>) this.thumbnailBuilder;
        sdk.pendo.io.u.a aVarBuildRequestRecursive = requestBuilder2.buildRequestRecursive(obj, target, bVar, thumbnailRequestCoordinator2, eVar2, priority, overrideWidth, overrideHeight, requestBuilder2, executor);
        this.isThumbnailBuilt = false;
        thumbnailRequestCoordinator2.setRequests(aVarObtainRequest, aVarBuildRequestRecursive);
        return thumbnailRequestCoordinator2;
    }

    private RequestBuilder<TranscodeType> cloneWithNullErrorAndThumbnail() {
        return mo14694clone().error((RequestBuilder) null).thumbnail((RequestBuilder) null);
    }

    private sdk.pendo.io.c.b getThumbnailPriority(sdk.pendo.io.c.b bVar) {
        int i = a.b[bVar.ordinal()];
        if (i == 1) {
            return sdk.pendo.io.c.b.NORMAL;
        }
        if (i == 2) {
            return sdk.pendo.io.c.b.HIGH;
        }
        if (i == 3 || i == 4) {
            return sdk.pendo.io.c.b.IMMEDIATE;
        }
        throw new IllegalArgumentException("unknown priority: " + getPriority());
    }

    private void initRequestListeners(List<sdk.pendo.io.u.b<Object>> list) {
        Iterator<sdk.pendo.io.u.b<Object>> it = list.iterator();
        while (it.hasNext()) {
            addListener((sdk.pendo.io.u.b) it.next());
        }
    }

    private boolean isSkipMemoryCacheWithCompletePreviousRequest(external.sdk.pendo.io.glide.request.a<?> aVar, sdk.pendo.io.u.a aVar2) {
        return !aVar.isMemoryCacheable() && aVar2.isComplete();
    }

    private RequestBuilder<TranscodeType> loadGeneric(Object obj) {
        if (isAutoCloneEnabled()) {
            return mo14694clone().loadGeneric(obj);
        }
        this.model = obj;
        this.isModelSet = true;
        return selfOrThrowIfLocked();
    }

    private RequestBuilder<TranscodeType> maybeApplyOptionsResourceUri(Uri uri, RequestBuilder<TranscodeType> requestBuilder) {
        return (uri == null || !UriUtil.QUALIFIED_RESOURCE_SCHEME.equals(uri.getScheme())) ? requestBuilder : applyResourceThemeAndSignature(requestBuilder);
    }

    private sdk.pendo.io.u.a obtainRequest(Object obj, Target<TranscodeType> target, sdk.pendo.io.u.b<TranscodeType> bVar, external.sdk.pendo.io.glide.request.a<?> aVar, external.sdk.pendo.io.glide.request.b bVar2, e<?, ? super TranscodeType> eVar, sdk.pendo.io.c.b bVar3, int i, int i2, Executor executor) {
        Context context = this.context;
        b bVar4 = this.glideContext;
        return SingleRequest.obtain(context, bVar4, obj, this.model, this.transcodeClass, aVar, i, i2, bVar3, target, bVar, this.requestListeners, bVar2, bVar4.d(), eVar.getTransitionFactory(), executor);
    }

    public RequestBuilder<TranscodeType> addListener(sdk.pendo.io.u.b<TranscodeType> bVar) {
        if (isAutoCloneEnabled()) {
            return mo14694clone().addListener(bVar);
        }
        if (bVar != null) {
            if (this.requestListeners == null) {
                this.requestListeners = new ArrayList();
            }
            this.requestListeners.add(bVar);
        }
        return selfOrThrowIfLocked();
    }

    @Override // external.sdk.pendo.io.glide.request.a
    public RequestBuilder<TranscodeType> apply(external.sdk.pendo.io.glide.request.a<?> aVar) {
        k.a(aVar);
        return (RequestBuilder) super.apply(aVar);
    }

    @Override // external.sdk.pendo.io.glide.request.a
    /* JADX INFO: renamed from: clone */
    public RequestBuilder<TranscodeType> mo14694clone() {
        RequestBuilder<TranscodeType> requestBuilder = (RequestBuilder) super.mo14694clone();
        requestBuilder.transitionOptions = requestBuilder.transitionOptions.m14713clone();
        if (requestBuilder.requestListeners != null) {
            requestBuilder.requestListeners = new ArrayList(requestBuilder.requestListeners);
        }
        RequestBuilder<TranscodeType> requestBuilder2 = requestBuilder.thumbnailBuilder;
        if (requestBuilder2 != null) {
            requestBuilder.thumbnailBuilder = requestBuilder2.mo14694clone();
        }
        RequestBuilder<TranscodeType> requestBuilder3 = requestBuilder.errorBuilder;
        if (requestBuilder3 != null) {
            requestBuilder.errorBuilder = requestBuilder3.mo14694clone();
        }
        return requestBuilder;
    }

    @Deprecated
    public FutureTarget<File> downloadOnly(int i, int i2) {
        return getDownloadOnlyRequest().submit(i, i2);
    }

    @Override // external.sdk.pendo.io.glide.request.a
    public boolean equals(Object obj) {
        if (obj instanceof RequestBuilder) {
            RequestBuilder requestBuilder = (RequestBuilder) obj;
            if (super.equals(requestBuilder) && Objects.equals(this.transcodeClass, requestBuilder.transcodeClass) && this.transitionOptions.equals(requestBuilder.transitionOptions) && Objects.equals(this.model, requestBuilder.model) && Objects.equals(this.requestListeners, requestBuilder.requestListeners) && Objects.equals(this.thumbnailBuilder, requestBuilder.thumbnailBuilder) && Objects.equals(this.errorBuilder, requestBuilder.errorBuilder) && Objects.equals(this.thumbSizeMultiplier, requestBuilder.thumbSizeMultiplier) && this.isDefaultTransitionOptionsSet == requestBuilder.isDefaultTransitionOptionsSet && this.isModelSet == requestBuilder.isModelSet) {
                return true;
            }
        }
        return false;
    }

    public RequestBuilder<TranscodeType> error(RequestBuilder<TranscodeType> requestBuilder) {
        if (isAutoCloneEnabled()) {
            return mo14694clone().error((RequestBuilder) requestBuilder);
        }
        this.errorBuilder = requestBuilder;
        return selfOrThrowIfLocked();
    }

    public <Y extends Target<TranscodeType>> Y experimentalIntoFront(Y y) {
        return (Y) into(y, null, sdk.pendo.io.y.e.c());
    }

    public Target<TranscodeType> experimentalPreloadFront(int i, int i2) {
        return experimentalIntoFront(PreloadTarget.obtain(this.requestManager, i, i2));
    }

    protected RequestBuilder<File> getDownloadOnlyRequest() {
        return new RequestBuilder(File.class, this).apply((external.sdk.pendo.io.glide.request.a<?>) DOWNLOAD_ONLY_OPTIONS);
    }

    Object getModel() {
        return this.model;
    }

    RequestManager getRequestManager() {
        return this.requestManager;
    }

    @Override // external.sdk.pendo.io.glide.request.a
    public int hashCode() {
        return l.a(this.isModelSet, l.a(this.isDefaultTransitionOptionsSet, l.a(this.thumbSizeMultiplier, l.a(this.errorBuilder, l.a(this.thumbnailBuilder, l.a(this.requestListeners, l.a(this.model, l.a(this.transitionOptions, l.a(this.transcodeClass, super.hashCode())))))))));
    }

    @Deprecated
    public FutureTarget<TranscodeType> into(int i, int i2) {
        return submit(i, i2);
    }

    public RequestBuilder<TranscodeType> listener(sdk.pendo.io.u.b<TranscodeType> bVar) {
        if (isAutoCloneEnabled()) {
            return mo14694clone().listener(bVar);
        }
        this.requestListeners = null;
        return addListener(bVar);
    }

    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<TranscodeType> m14695load(Bitmap bitmap) {
        return loadGeneric(bitmap).apply((external.sdk.pendo.io.glide.request.a<?>) RequestOptions.diskCacheStrategyOf(sdk.pendo.io.h.a.b));
    }

    public Target<TranscodeType> preload() {
        return preload(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public FutureTarget<TranscodeType> submit() {
        return submit(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Deprecated
    public RequestBuilder<TranscodeType> thumbnail(float f) {
        if (isAutoCloneEnabled()) {
            return mo14694clone().thumbnail(f);
        }
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.thumbSizeMultiplier = Float.valueOf(f);
        return selfOrThrowIfLocked();
    }

    public RequestBuilder<TranscodeType> transition(e<?, ? super TranscodeType> eVar) {
        if (isAutoCloneEnabled()) {
            return mo14694clone().transition(eVar);
        }
        this.transitionOptions = (e) k.a(eVar);
        this.isDefaultTransitionOptionsSet = false;
        return selfOrThrowIfLocked();
    }

    protected RequestBuilder(Class<TranscodeType> cls, RequestBuilder<?> requestBuilder) {
        this(requestBuilder.glide, requestBuilder.requestManager, cls, requestBuilder.context);
        this.model = requestBuilder.model;
        this.isModelSet = requestBuilder.isModelSet;
        apply((external.sdk.pendo.io.glide.request.a<?>) requestBuilder);
    }

    @Override // external.sdk.pendo.io.glide.request.a
    public /* bridge */ /* synthetic */ external.sdk.pendo.io.glide.request.a apply(external.sdk.pendo.io.glide.request.a aVar) {
        return apply((external.sdk.pendo.io.glide.request.a<?>) aVar);
    }

    @Deprecated
    public <Y extends Target<File>> Y downloadOnly(Y y) {
        return (Y) getDownloadOnlyRequest().into(y);
    }

    public RequestBuilder<TranscodeType> error(Object obj) {
        return error((RequestBuilder) (obj == null ? null : cloneWithNullErrorAndThumbnail().m14700load(obj)));
    }

    public ViewTarget<ImageView, TranscodeType> experimentalIntoFront(ImageView imageView) {
        external.sdk.pendo.io.glide.request.a aVarOptionalCenterCrop;
        l.b();
        k.a(imageView);
        if (!isTransformationSet() && isTransformationAllowed() && imageView.getScaleType() != null) {
            switch (a.a[imageView.getScaleType().ordinal()]) {
                case 1:
                    aVarOptionalCenterCrop = mo14694clone().optionalCenterCrop();
                    break;
                case 2:
                case 6:
                    aVarOptionalCenterCrop = mo14694clone().optionalCenterInside();
                    break;
                case 3:
                case 4:
                case 5:
                    aVarOptionalCenterCrop = mo14694clone().optionalFitCenter();
                    break;
                default:
                    aVarOptionalCenterCrop = this;
                    break;
            }
        } else {
            aVarOptionalCenterCrop = this;
        }
        return (ViewTarget) into(this.glideContext.a(imageView, this.transcodeClass), null, aVarOptionalCenterCrop, sdk.pendo.io.y.e.c());
    }

    public <Y extends Target<TranscodeType>> Y into(Y y) {
        return (Y) into(y, null, sdk.pendo.io.y.e.b());
    }

    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<TranscodeType> m14696load(Drawable drawable) {
        return loadGeneric(drawable).apply((external.sdk.pendo.io.glide.request.a<?>) RequestOptions.diskCacheStrategyOf(sdk.pendo.io.h.a.b));
    }

    public Target<TranscodeType> preload(int i, int i2) {
        return into(PreloadTarget.obtain(this.requestManager, i, i2));
    }

    public FutureTarget<TranscodeType> submit(int i, int i2) {
        RequestFutureTarget requestFutureTarget = new RequestFutureTarget(i, i2);
        return (FutureTarget) into(requestFutureTarget, requestFutureTarget, sdk.pendo.io.y.e.a());
    }

    public RequestBuilder<TranscodeType> thumbnail(RequestBuilder<TranscodeType> requestBuilder) {
        if (isAutoCloneEnabled()) {
            return mo14694clone().thumbnail(requestBuilder);
        }
        this.thumbnailBuilder = requestBuilder;
        return selfOrThrowIfLocked();
    }

    private <Y extends Target<TranscodeType>> Y into(Y y, sdk.pendo.io.u.b<TranscodeType> bVar, external.sdk.pendo.io.glide.request.a<?> aVar, Executor executor) {
        k.a(y);
        if (!this.isModelSet) {
            throw new IllegalArgumentException("You must call #load() before calling #into()");
        }
        sdk.pendo.io.u.a aVarBuildRequest = buildRequest(y, bVar, aVar, executor);
        sdk.pendo.io.u.a request = y.getRequest();
        if (aVarBuildRequest.isEquivalentTo(request) && !isSkipMemoryCacheWithCompletePreviousRequest(aVar, request)) {
            if (!((sdk.pendo.io.u.a) k.a(request)).isRunning()) {
                request.begin();
            }
            return y;
        }
        this.requestManager.clear((Target<?>) y);
        y.setRequest(aVarBuildRequest);
        this.requestManager.track(y, aVarBuildRequest);
        return y;
    }

    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<TranscodeType> m14697load(Uri uri) {
        return maybeApplyOptionsResourceUri(uri, loadGeneric(uri));
    }

    public RequestBuilder<TranscodeType> thumbnail(List<RequestBuilder<TranscodeType>> list) {
        RequestBuilder<TranscodeType> requestBuilderThumbnail = null;
        if (list == null || list.isEmpty()) {
            return thumbnail((RequestBuilder) null);
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            RequestBuilder<TranscodeType> requestBuilder = list.get(size);
            if (requestBuilder != null) {
                requestBuilderThumbnail = requestBuilderThumbnail == null ? requestBuilder : requestBuilder.thumbnail(requestBuilderThumbnail);
            }
        }
        return thumbnail(requestBuilderThumbnail);
    }

    public <Y extends Target<TranscodeType>> Y into(Y y, sdk.pendo.io.u.b<TranscodeType> bVar, Executor executor) {
        return (Y) into(y, bVar, this, executor);
    }

    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<TranscodeType> m14698load(File file) {
        return loadGeneric(file);
    }

    public RequestBuilder<TranscodeType> thumbnail(RequestBuilder<TranscodeType>... requestBuilderArr) {
        return (requestBuilderArr == null || requestBuilderArr.length == 0) ? thumbnail((RequestBuilder) null) : thumbnail(Arrays.asList(requestBuilderArr));
    }

    public ViewTarget<ImageView, TranscodeType> into(ImageView imageView) {
        external.sdk.pendo.io.glide.request.a aVarOptionalCenterCrop;
        l.b();
        k.a(imageView);
        if (!isTransformationSet() && isTransformationAllowed() && imageView.getScaleType() != null) {
            switch (a.a[imageView.getScaleType().ordinal()]) {
                case 1:
                    aVarOptionalCenterCrop = mo14694clone().optionalCenterCrop();
                    break;
                case 2:
                case 6:
                    aVarOptionalCenterCrop = mo14694clone().optionalCenterInside();
                    break;
                case 3:
                case 4:
                case 5:
                    aVarOptionalCenterCrop = mo14694clone().optionalFitCenter();
                    break;
                default:
                    aVarOptionalCenterCrop = this;
                    break;
            }
        } else {
            aVarOptionalCenterCrop = this;
        }
        return (ViewTarget) into(this.glideContext.a(imageView, this.transcodeClass), null, aVarOptionalCenterCrop, sdk.pendo.io.y.e.b());
    }

    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<TranscodeType> m14699load(Integer num) {
        return applyResourceThemeAndSignature(loadGeneric(num));
    }

    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<TranscodeType> m14700load(Object obj) {
        return loadGeneric(obj);
    }

    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<TranscodeType> m14701load(String str) {
        return loadGeneric(str);
    }

    @Deprecated
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<TranscodeType> m14702load(URL url) {
        return loadGeneric(url);
    }

    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public RequestBuilder<TranscodeType> m14703load(byte[] bArr) {
        RequestBuilder<TranscodeType> requestBuilderLoadGeneric = loadGeneric(bArr);
        if (!requestBuilderLoadGeneric.isDiskCacheStrategySet()) {
            requestBuilderLoadGeneric = requestBuilderLoadGeneric.apply((external.sdk.pendo.io.glide.request.a<?>) RequestOptions.diskCacheStrategyOf(sdk.pendo.io.h.a.b));
        }
        return !requestBuilderLoadGeneric.isSkipMemoryCacheSet() ? requestBuilderLoadGeneric.apply((external.sdk.pendo.io.glide.request.a<?>) RequestOptions.skipMemoryCacheOf(true)) : requestBuilderLoadGeneric;
    }
}
