package external.sdk.pendo.io.glide.request.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import external.sdk.pendo.io.glide.request.transition.a;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ImageViewTarget<Z> extends ViewTarget<ImageView, Z> implements a.InterfaceC0321a {
    private Animatable animatable;

    public ImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    private void maybeUpdateAnimatable(Z z) {
        if (!(z instanceof Animatable)) {
            this.animatable = null;
            return;
        }
        Animatable animatable = (Animatable) z;
        this.animatable = animatable;
        animatable.start();
    }

    private void setResourceInternal(Z z) {
        setResource(z);
        maybeUpdateAnimatable(z);
    }

    @Override // external.sdk.pendo.io.glide.request.transition.a.InterfaceC0321a
    public Drawable getCurrentDrawable() {
        return ((ImageView) this.view).getDrawable();
    }

    @Override // external.sdk.pendo.io.glide.request.target.ViewTarget, external.sdk.pendo.io.glide.request.target.BaseTarget, external.sdk.pendo.io.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
        super.onLoadCleared(drawable);
        Animatable animatable = this.animatable;
        if (animatable != null) {
            animatable.stop();
        }
        setResourceInternal(null);
        setDrawable(drawable);
    }

    @Override // external.sdk.pendo.io.glide.request.target.BaseTarget, external.sdk.pendo.io.glide.request.target.Target
    public void onLoadFailed(Drawable drawable) {
        super.onLoadFailed(drawable);
        setResourceInternal(null);
        setDrawable(drawable);
    }

    @Override // external.sdk.pendo.io.glide.request.target.ViewTarget, external.sdk.pendo.io.glide.request.target.BaseTarget, external.sdk.pendo.io.glide.request.target.Target
    public void onLoadStarted(Drawable drawable) {
        super.onLoadStarted(drawable);
        setResourceInternal(null);
        setDrawable(drawable);
    }

    @Override // external.sdk.pendo.io.glide.request.target.Target
    public void onResourceReady(Z z, a<? super Z> aVar) {
        if (aVar == null || !aVar.transition(z, this)) {
            setResourceInternal(z);
        } else {
            maybeUpdateAnimatable(z);
        }
    }

    @Override // external.sdk.pendo.io.glide.request.target.BaseTarget, external.sdk.pendo.io.glide.request.target.Target, sdk.pendo.io.r.b
    public void onStart() {
        Animatable animatable = this.animatable;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // external.sdk.pendo.io.glide.request.target.BaseTarget, external.sdk.pendo.io.glide.request.target.Target, sdk.pendo.io.r.b
    public void onStop() {
        Animatable animatable = this.animatable;
        if (animatable != null) {
            animatable.stop();
        }
    }

    @Override // external.sdk.pendo.io.glide.request.transition.a.InterfaceC0321a
    public void setDrawable(Drawable drawable) {
        ((ImageView) this.view).setImageDrawable(drawable);
    }

    protected abstract void setResource(Z z);

    @Deprecated
    public ImageViewTarget(ImageView imageView, boolean z) {
        super(imageView, z);
    }
}
