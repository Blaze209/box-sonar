package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import external.sdk.pendo.io.glide.request.transition.BitmapTransitionFactory;
import external.sdk.pendo.io.glide.request.transition.DrawableCrossFadeFactory;

/* JADX INFO: loaded from: classes4.dex */
public final class BitmapTransitionOptions extends external.sdk.pendo.io.glide.e<BitmapTransitionOptions, Bitmap> {
    public static BitmapTransitionOptions with(sdk.pendo.io.w.a<Bitmap> aVar) {
        return new BitmapTransitionOptions().transition(aVar);
    }

    public static BitmapTransitionOptions withCrossFade() {
        return new BitmapTransitionOptions().crossFade();
    }

    public static BitmapTransitionOptions withWrapped(sdk.pendo.io.w.a<Drawable> aVar) {
        return new BitmapTransitionOptions().transitionUsing(aVar);
    }

    public BitmapTransitionOptions crossFade() {
        return crossFade(new DrawableCrossFadeFactory.a());
    }

    @Override // external.sdk.pendo.io.glide.e
    public boolean equals(Object obj) {
        return (obj instanceof BitmapTransitionOptions) && super.equals(obj);
    }

    @Override // external.sdk.pendo.io.glide.e
    public int hashCode() {
        return super.hashCode();
    }

    public BitmapTransitionOptions transitionUsing(sdk.pendo.io.w.a<Drawable> aVar) {
        return transition(new BitmapTransitionFactory(aVar));
    }

    public static BitmapTransitionOptions withCrossFade(int i) {
        return new BitmapTransitionOptions().crossFade(i);
    }

    public BitmapTransitionOptions crossFade(int i) {
        return crossFade(new DrawableCrossFadeFactory.a(i));
    }

    public static BitmapTransitionOptions withCrossFade(DrawableCrossFadeFactory.a aVar) {
        return new BitmapTransitionOptions().crossFade(aVar);
    }

    public BitmapTransitionOptions crossFade(DrawableCrossFadeFactory.a aVar) {
        return transitionUsing(aVar.a());
    }

    public static BitmapTransitionOptions withCrossFade(DrawableCrossFadeFactory drawableCrossFadeFactory) {
        return new BitmapTransitionOptions().crossFade(drawableCrossFadeFactory);
    }

    public BitmapTransitionOptions crossFade(DrawableCrossFadeFactory drawableCrossFadeFactory) {
        return transitionUsing(drawableCrossFadeFactory);
    }
}
