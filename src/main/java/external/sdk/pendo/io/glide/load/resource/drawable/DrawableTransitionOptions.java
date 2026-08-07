package external.sdk.pendo.io.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import external.sdk.pendo.io.glide.e;
import external.sdk.pendo.io.glide.request.transition.DrawableCrossFadeFactory;

/* JADX INFO: loaded from: classes4.dex */
public final class DrawableTransitionOptions extends e<DrawableTransitionOptions, Drawable> {
    public static DrawableTransitionOptions with(sdk.pendo.io.w.a<Drawable> aVar) {
        return new DrawableTransitionOptions().transition(aVar);
    }

    public static DrawableTransitionOptions withCrossFade() {
        return new DrawableTransitionOptions().crossFade();
    }

    public DrawableTransitionOptions crossFade() {
        return crossFade(new DrawableCrossFadeFactory.a());
    }

    @Override // external.sdk.pendo.io.glide.e
    public boolean equals(Object obj) {
        return (obj instanceof DrawableTransitionOptions) && super.equals(obj);
    }

    @Override // external.sdk.pendo.io.glide.e
    public int hashCode() {
        return super.hashCode();
    }

    public static DrawableTransitionOptions withCrossFade(int i) {
        return new DrawableTransitionOptions().crossFade(i);
    }

    public DrawableTransitionOptions crossFade(int i) {
        return crossFade(new DrawableCrossFadeFactory.a(i));
    }

    public static DrawableTransitionOptions withCrossFade(DrawableCrossFadeFactory.a aVar) {
        return new DrawableTransitionOptions().crossFade(aVar);
    }

    public DrawableTransitionOptions crossFade(DrawableCrossFadeFactory.a aVar) {
        return crossFade(aVar.a());
    }

    public static DrawableTransitionOptions withCrossFade(DrawableCrossFadeFactory drawableCrossFadeFactory) {
        return new DrawableTransitionOptions().crossFade(drawableCrossFadeFactory);
    }

    public DrawableTransitionOptions crossFade(DrawableCrossFadeFactory drawableCrossFadeFactory) {
        return transition(drawableCrossFadeFactory);
    }
}
