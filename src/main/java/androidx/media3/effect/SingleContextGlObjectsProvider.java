package androidx.media3.effect;

import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.util.GlUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SingleContextGlObjectsProvider.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0016J&\u0010\u0010\u001a\u00070\u0011¢\u0006\u0002\b\u00122\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0096\u0001J8\u0010\u0016\u001a\u00070\u0017¢\u0006\u0002\b\u00122\u000b\u0010\u0013\u001a\u00070\t¢\u0006\u0002\b\u00122\u000b\u0010\u0014\u001a\u00070\u0018¢\u0006\u0002\b\u00122\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0096\u0001J(\u0010\u001b\u001a\u00070\u0017¢\u0006\u0002\b\u00122\u000b\u0010\u0013\u001a\u00070\u0006¢\u0006\u0002\b\u00122\u000b\u0010\u0014\u001a\u00070\t¢\u0006\u0002\b\u0012H\u0096\u0001R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/media3/effect/SingleContextGlObjectsProvider;", "Landroidx/media3/common/GlObjectsProvider;", "delegate", "<init>", "(Landroidx/media3/common/GlObjectsProvider;)V", "singleEglContext", "Landroid/opengl/EGLContext;", "createEglContext", "eglDisplay", "Landroid/opengl/EGLDisplay;", "openGlVersion", "", "configAttributes", "", "release", "", "createBuffersForTexture", "Landroidx/media3/common/GlTextureInfo;", "Lkotlin/jvm/internal/EnhancedNullability;", "p0", "p1", "p2", "createEglSurface", "Landroid/opengl/EGLSurface;", "", "p3", "", "createFocusedPlaceholderEglSurface", "lib-effect_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SingleContextGlObjectsProvider implements GlObjectsProvider {
    private final GlObjectsProvider delegate;
    private EGLContext singleEglContext;

    /* JADX WARN: Multi-variable type inference failed */
    public SingleContextGlObjectsProvider() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // androidx.media3.common.GlObjectsProvider
    public GlTextureInfo createBuffersForTexture(int p0, int p1, int p2) throws GlUtil.GlException {
        GlTextureInfo glTextureInfoCreateBuffersForTexture = this.delegate.createBuffersForTexture(p0, p1, p2);
        Intrinsics.checkNotNullExpressionValue(glTextureInfoCreateBuffersForTexture, "createBuffersForTexture(...)");
        return glTextureInfoCreateBuffersForTexture;
    }

    @Override // androidx.media3.common.GlObjectsProvider
    public EGLSurface createEglSurface(EGLDisplay p0, Object p1, int p2, boolean p3) throws GlUtil.GlException {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        EGLSurface eGLSurfaceCreateEglSurface = this.delegate.createEglSurface(p0, p1, p2, p3);
        Intrinsics.checkNotNullExpressionValue(eGLSurfaceCreateEglSurface, "createEglSurface(...)");
        return eGLSurfaceCreateEglSurface;
    }

    @Override // androidx.media3.common.GlObjectsProvider
    public EGLSurface createFocusedPlaceholderEglSurface(EGLContext p0, EGLDisplay p1) throws GlUtil.GlException {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        EGLSurface eGLSurfaceCreateFocusedPlaceholderEglSurface = this.delegate.createFocusedPlaceholderEglSurface(p0, p1);
        Intrinsics.checkNotNullExpressionValue(eGLSurfaceCreateFocusedPlaceholderEglSurface, "createFocusedPlaceholderEglSurface(...)");
        return eGLSurfaceCreateFocusedPlaceholderEglSurface;
    }

    public SingleContextGlObjectsProvider(GlObjectsProvider delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    public /* synthetic */ SingleContextGlObjectsProvider(DefaultGlObjectsProvider defaultGlObjectsProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new DefaultGlObjectsProvider() : defaultGlObjectsProvider);
    }

    @Override // androidx.media3.common.GlObjectsProvider
    public EGLContext createEglContext(EGLDisplay eglDisplay, int openGlVersion, int[] configAttributes) throws GlUtil.GlException {
        Intrinsics.checkNotNullParameter(eglDisplay, "eglDisplay");
        Intrinsics.checkNotNullParameter(configAttributes, "configAttributes");
        EGLContext eGLContext = this.singleEglContext;
        if (eGLContext != null) {
            return eGLContext;
        }
        EGLContext eGLContextCreateEglContext = this.delegate.createEglContext(eglDisplay, openGlVersion, configAttributes);
        Intrinsics.checkNotNullExpressionValue(eGLContextCreateEglContext, "createEglContext(...)");
        this.singleEglContext = eGLContextCreateEglContext;
        return eGLContextCreateEglContext;
    }

    @Override // androidx.media3.common.GlObjectsProvider
    public void release(EGLDisplay eglDisplay) throws GlUtil.GlException {
        Intrinsics.checkNotNullParameter(eglDisplay, "eglDisplay");
        if (this.singleEglContext != null) {
            this.delegate.release(eglDisplay);
            this.singleEglContext = null;
        }
    }
}
