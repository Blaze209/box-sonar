package external.sdk.pendo.io.glide.request.transition;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;

/* JADX INFO: loaded from: classes4.dex */
public class DrawableCrossFadeTransition implements a<Drawable> {
    private final int duration;
    private final boolean isCrossFadeEnabled;

    public DrawableCrossFadeTransition(int i, boolean z) {
        this.duration = i;
        this.isCrossFadeEnabled = z;
    }

    @Override // external.sdk.pendo.io.glide.request.transition.a
    public boolean transition(Drawable drawable, a.InterfaceC0321a interfaceC0321a) {
        Drawable currentDrawable = interfaceC0321a.getCurrentDrawable();
        if (currentDrawable == null) {
            currentDrawable = new ColorDrawable(0);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{currentDrawable, drawable});
        transitionDrawable.setCrossFadeEnabled(this.isCrossFadeEnabled);
        transitionDrawable.startTransition(this.duration);
        interfaceC0321a.setDrawable(transitionDrawable);
        return true;
    }
}
