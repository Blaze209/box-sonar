package external.sdk.pendo.io.glide.request.transition;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BitmapContainerTransitionFactory<R> implements sdk.pendo.io.w.a<R> {
    private final sdk.pendo.io.w.a<Drawable> realFactory;

    private final class a implements external.sdk.pendo.io.glide.request.transition.a<R> {
        private final external.sdk.pendo.io.glide.request.transition.a<Drawable> a;

        a(external.sdk.pendo.io.glide.request.transition.a<Drawable> aVar) {
            this.a = aVar;
        }

        @Override // external.sdk.pendo.io.glide.request.transition.a
        public boolean transition(R r, external.sdk.pendo.io.glide.request.transition.a.InterfaceC0321a interfaceC0321a) {
            return this.a.transition(new BitmapDrawable(interfaceC0321a.getView().getResources(), BitmapContainerTransitionFactory.this.getBitmap(r)), interfaceC0321a);
        }
    }

    public BitmapContainerTransitionFactory(sdk.pendo.io.w.a<Drawable> aVar) {
        this.realFactory = aVar;
    }

    @Override // sdk.pendo.io.w.a
    public external.sdk.pendo.io.glide.request.transition.a<R> build(sdk.pendo.io.e.a aVar, boolean z) {
        return new a(this.realFactory.build(aVar, z));
    }

    protected abstract Bitmap getBitmap(R r);
}
