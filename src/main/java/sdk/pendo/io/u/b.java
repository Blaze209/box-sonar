package sdk.pendo.io.u;

import external.sdk.pendo.io.glide.load.engine.n;
import external.sdk.pendo.io.glide.request.target.Target;

/* JADX INFO: loaded from: classes5.dex */
public interface b<R> {
    boolean onLoadFailed(n nVar, Object obj, Target<R> target, boolean z);

    boolean onResourceReady(R r, Object obj, Target<R> target, sdk.pendo.io.e.a aVar, boolean z);
}
