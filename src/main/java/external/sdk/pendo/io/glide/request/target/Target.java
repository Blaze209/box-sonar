package external.sdk.pendo.io.glide.request.target;

import android.graphics.drawable.Drawable;
import sdk.pendo.io.r.b;
import sdk.pendo.io.u.a;
import sdk.pendo.io.v.c;

/* JADX INFO: loaded from: classes4.dex */
public interface Target<R> extends b {
    public static final int SIZE_ORIGINAL = Integer.MIN_VALUE;

    a getRequest();

    void getSize(c cVar);

    @Override // sdk.pendo.io.r.b
    /* synthetic */ void onDestroy();

    void onLoadCleared(Drawable drawable);

    void onLoadFailed(Drawable drawable);

    void onLoadStarted(Drawable drawable);

    void onResourceReady(R r, external.sdk.pendo.io.glide.request.transition.a<? super R> aVar);

    @Override // sdk.pendo.io.r.b
    /* synthetic */ void onStart();

    @Override // sdk.pendo.io.r.b
    /* synthetic */ void onStop();

    void removeCallback(c cVar);

    void setRequest(a aVar);
}
