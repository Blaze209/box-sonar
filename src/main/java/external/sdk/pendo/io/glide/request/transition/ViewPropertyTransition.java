package external.sdk.pendo.io.glide.request.transition;

import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public class ViewPropertyTransition<R> implements a<R> {
    private final Animator animator;

    public interface Animator {
        void a(View view);
    }

    public ViewPropertyTransition(Animator animator) {
        this.animator = animator;
    }

    @Override // external.sdk.pendo.io.glide.request.transition.a
    public boolean transition(R r, a.InterfaceC0321a interfaceC0321a) {
        if (interfaceC0321a.getView() == null) {
            return false;
        }
        this.animator.a(interfaceC0321a.getView());
        return false;
    }
}
