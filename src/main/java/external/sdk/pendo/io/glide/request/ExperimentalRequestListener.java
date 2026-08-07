package external.sdk.pendo.io.glide.request;

import external.sdk.pendo.io.glide.load.engine.n;
import external.sdk.pendo.io.glide.request.target.Target;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public abstract class ExperimentalRequestListener<ResourceT> implements sdk.pendo.io.u.b<ResourceT> {
    @Override // sdk.pendo.io.u.b
    public abstract /* synthetic */ boolean onLoadFailed(n nVar, Object obj, Target target, boolean z);

    public void onRequestStarted(Object obj) {
    }

    @Override // sdk.pendo.io.u.b
    public abstract /* synthetic */ boolean onResourceReady(Object obj, Object obj2, Target target, sdk.pendo.io.e.a aVar, boolean z);

    public abstract boolean onResourceReady(ResourceT resourcet, Object obj, Target<ResourceT> target, sdk.pendo.io.e.a aVar, boolean z, boolean z2);
}
