package external.sdk.pendo.io.glide.request.transition;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;

/* JADX INFO: loaded from: classes4.dex */
public class ViewTransition<R> implements external.sdk.pendo.io.glide.request.transition.a<R> {
    private final a viewTransitionAnimationFactory;

    interface a {
        Animation a(Context context);
    }

    ViewTransition(a aVar) {
        this.viewTransitionAnimationFactory = aVar;
    }

    @Override // external.sdk.pendo.io.glide.request.transition.a
    public boolean transition(R r, external.sdk.pendo.io.glide.request.transition.a.InterfaceC0321a interfaceC0321a) {
        View view = interfaceC0321a.getView();
        if (view == null) {
            return false;
        }
        view.clearAnimation();
        view.startAnimation(this.viewTransitionAnimationFactory.a(view.getContext()));
        return false;
    }
}
