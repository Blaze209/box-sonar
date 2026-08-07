package com.bumptech.glide;

import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GlideIntegration.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a?\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0018\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u0005*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010\u0007\u001a\u0002H\u0003H\u0000¢\u0006\u0002\u0010\b\u001a\u0018\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n*\u0006\u0012\u0002\b\u00030\u0006H\u0000¨\u0006\f"}, d2 = {"intoDirect", "", "ResourceT", "TargetAndRequestListenerT", "Lcom/bumptech/glide/request/target/Target;", "Lcom/bumptech/glide/request/RequestListener;", "Lcom/bumptech/glide/RequestBuilder;", "targetAndRequestListener", "(Lcom/bumptech/glide/RequestBuilder;Lcom/bumptech/glide/request/target/Target;)V", "requestManager", "Lcom/bumptech/glide/RequestManager;", "kotlin.jvm.PlatformType", "ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class GlideIntegrationKt {
    public static final RequestManager requestManager(RequestBuilder<?> requestBuilder) {
        Intrinsics.checkNotNullParameter(requestBuilder, "<this>");
        return requestBuilder.getRequestManager();
    }

    /* JADX WARN: Incorrect types in method signature: <ResourceT:Ljava/lang/Object;TargetAndRequestListenerT::Lcom/bumptech/glide/request/target/Target<TResourceT;>;:Lcom/bumptech/glide/request/RequestListener<TResourceT;>;>(Lcom/bumptech/glide/RequestBuilder<TResourceT;>;TTargetAndRequestListenerT;)V */
    public static final void intoDirect(RequestBuilder requestBuilder, Target targetAndRequestListener) {
        Intrinsics.checkNotNullParameter(requestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(targetAndRequestListener, "targetAndRequestListener");
        requestBuilder.into(targetAndRequestListener, (RequestListener) targetAndRequestListener, new Executor() { // from class: com.bumptech.glide.GlideIntegrationKt$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                runnable.run();
            }
        });
    }
}
