package com.bumptech.glide.integration.ktx;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;

/* JADX INFO: compiled from: Flows.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0006\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/bumptech/glide/integration/ktx/AsyncGlideSize;", "Lcom/bumptech/glide/integration/ktx/ResolvableGlideSize;", "()V", "size", "Lkotlinx/coroutines/CompletableDeferred;", "Lcom/bumptech/glide/integration/ktx/Size;", "getSize", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setSize", "", "ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AsyncGlideSize extends ResolvableGlideSize {
    private final CompletableDeferred<Size> size;

    public AsyncGlideSize() {
        super(null);
        this.size = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
    }

    public final void setSize(Size size) {
        Intrinsics.checkNotNullParameter(size, "size");
        this.size.complete(size);
    }

    public final Object getSize(Continuation<? super Size> continuation) {
        return this.size.await(continuation);
    }
}
