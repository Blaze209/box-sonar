package external.sdk.pendo.io.glide.util;

import android.graphics.drawable.Drawable;
import android.view.View;
import external.sdk.pendo.io.glide.request.target.CustomViewTarget;
import java.util.Arrays;
import sdk.pendo.io.v.c;

/* JADX INFO: loaded from: classes4.dex */
public class ViewPreloadSizeProvider<T> implements c {
    private int[] size;
    private a viewTarget;

    static final class a extends CustomViewTarget<View, Object> {
        a(View view) {
            super(view);
        }

        @Override // external.sdk.pendo.io.glide.request.target.Target
        public void onLoadFailed(Drawable drawable) {
        }

        @Override // external.sdk.pendo.io.glide.request.target.CustomViewTarget
        protected void onResourceCleared(Drawable drawable) {
        }

        @Override // external.sdk.pendo.io.glide.request.target.Target
        public void onResourceReady(Object obj, external.sdk.pendo.io.glide.request.transition.a<? super Object> aVar) {
        }
    }

    public ViewPreloadSizeProvider() {
    }

    public ViewPreloadSizeProvider(View view) {
        a aVar = new a(view);
        this.viewTarget = aVar;
        aVar.getSize(this);
    }

    public int[] getPreloadSize(T t, int i, int i2) {
        int[] iArr = this.size;
        if (iArr == null) {
            return null;
        }
        return Arrays.copyOf(iArr, iArr.length);
    }

    @Override // sdk.pendo.io.v.c
    public void onSizeReady(int i, int i2) {
        this.size = new int[]{i, i2};
        this.viewTarget = null;
    }

    public void setView(View view) {
        if (this.size == null && this.viewTarget == null) {
            a aVar = new a(view);
            this.viewTarget = aVar;
            aVar.getSize(this);
        }
    }
}
