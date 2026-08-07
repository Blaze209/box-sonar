package external.sdk.pendo.io.glide.request.transition;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes4.dex */
public class DrawableCrossFadeFactory implements sdk.pendo.io.w.a<Drawable> {
    private final int duration;
    private final boolean isCrossFadeEnabled;
    private DrawableCrossFadeTransition resourceTransition;

    public static class a {
        private final int a;
        private boolean b;

        public a() {
            this(300);
        }

        public DrawableCrossFadeFactory a() {
            return new DrawableCrossFadeFactory(this.a, this.b);
        }

        public a(int i) {
            this.a = i;
        }
    }

    protected DrawableCrossFadeFactory(int i, boolean z) {
        this.duration = i;
        this.isCrossFadeEnabled = z;
    }

    private external.sdk.pendo.io.glide.request.transition.a<Drawable> getResourceTransition() {
        if (this.resourceTransition == null) {
            this.resourceTransition = new DrawableCrossFadeTransition(this.duration, this.isCrossFadeEnabled);
        }
        return this.resourceTransition;
    }

    @Override // sdk.pendo.io.w.a
    public external.sdk.pendo.io.glide.request.transition.a<Drawable> build(sdk.pendo.io.e.a aVar, boolean z) {
        return aVar == sdk.pendo.io.e.a.MEMORY_CACHE ? NoTransition.get() : getResourceTransition();
    }
}
