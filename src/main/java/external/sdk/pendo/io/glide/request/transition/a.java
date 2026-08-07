package external.sdk.pendo.io.glide.request.transition;

import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public interface a<R> {

    /* JADX INFO: renamed from: external.sdk.pendo.io.glide.request.transition.a$a, reason: collision with other inner class name */
    public interface InterfaceC0321a {
        Drawable getCurrentDrawable();

        View getView();

        void setDrawable(Drawable drawable);
    }

    boolean transition(R r, InterfaceC0321a interfaceC0321a);
}
