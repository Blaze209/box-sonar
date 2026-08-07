package com.bumptech.glide.integration.ktx;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Flows.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\b\u0004¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bumptech/glide/integration/ktx/GlideFlowInstant;", "ResourceT", "", "()V", "status", "Lcom/bumptech/glide/integration/ktx/Status;", "getStatus", "()Lcom/bumptech/glide/integration/ktx/Status;", "Lcom/bumptech/glide/integration/ktx/Placeholder;", "Lcom/bumptech/glide/integration/ktx/Resource;", "ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class GlideFlowInstant<ResourceT> {
    public /* synthetic */ GlideFlowInstant(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract Status getStatus();

    private GlideFlowInstant() {
    }
}
