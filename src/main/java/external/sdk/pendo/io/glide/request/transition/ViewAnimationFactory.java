package external.sdk.pendo.io.glide.request.transition;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/* JADX INFO: loaded from: classes4.dex */
public class ViewAnimationFactory<R> implements sdk.pendo.io.w.a<R> {
    private external.sdk.pendo.io.glide.request.transition.a<R> transition;
    private final ViewTransition.a viewTransitionAnimationFactory;

    private static class a implements ViewTransition.a {
        private final Animation a;

        a(Animation animation) {
            this.a = animation;
        }

        @Override // external.sdk.pendo.io.glide.request.transition.ViewTransition.a
        public Animation a(Context context) {
            return this.a;
        }
    }

    private static class b implements ViewTransition.a {
        private final int a;

        b(int i) {
            this.a = i;
        }

        @Override // external.sdk.pendo.io.glide.request.transition.ViewTransition.a
        public Animation a(Context context) {
            return AnimationUtils.loadAnimation(context, this.a);
        }
    }

    public ViewAnimationFactory(int i) {
        this(new b(i));
    }

    @Override // sdk.pendo.io.w.a
    public external.sdk.pendo.io.glide.request.transition.a<R> build(sdk.pendo.io.e.a aVar, boolean z) {
        if (aVar == sdk.pendo.io.e.a.MEMORY_CACHE || !z) {
            return NoTransition.get();
        }
        if (this.transition == null) {
            this.transition = new ViewTransition(this.viewTransitionAnimationFactory);
        }
        return this.transition;
    }

    public ViewAnimationFactory(Animation animation) {
        this(new a(animation));
    }

    ViewAnimationFactory(ViewTransition.a aVar) {
        this.viewTransitionAnimationFactory = aVar;
    }
}
