package com.margelo.nitro.boxcontext;

import com.facebook.jni.HybridData;
import com.margelo.nitro.core.Promise;
import dalvik.annotation.optimization.FastNative;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Func_std__shared_ptr_Promise_std__vector_ItemStatus____std__vector_ItemIdentifier__std__vector_ItemIdentifier_.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0013\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J6\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u0097\u0002¢\u0006\u0002\u0010\u000eJ6\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u0083 ¢\u0006\u0002\u0010\u000eR\u0010\u0010\u0006\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/margelo/nitro/boxcontext/Func_std__shared_ptr_Promise_std__vector_ItemStatus____std__vector_ItemIdentifier__std__vector_ItemIdentifier__cxx;", "Lcom/margelo/nitro/boxcontext/Func_std__shared_ptr_Promise_std__vector_ItemStatus____std__vector_ItemIdentifier__std__vector_ItemIdentifier_;", "hybridData", "Lcom/facebook/jni/HybridData;", "<init>", "(Lcom/facebook/jni/HybridData;)V", "mHybridData", "invoke", "Lcom/margelo/nitro/core/Promise;", "", "Lcom/margelo/nitro/boxcontext/ItemStatus;", "selectedItemIds", "Lcom/margelo/nitro/boxcontext/ItemIdentifier;", "itemIds", "([Lcom/margelo/nitro/boxcontext/ItemIdentifier;[Lcom/margelo/nitro/boxcontext/ItemIdentifier;)Lcom/margelo/nitro/core/Promise;", "invoke_cxx", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Func_std__shared_ptr_Promise_std__vector_ItemStatus____std__vector_ItemIdentifier__std__vector_ItemIdentifier__cxx implements Func_std__shared_ptr_Promise_std__vector_ItemStatus____std__vector_ItemIdentifier__std__vector_ItemIdentifier_ {
    private final HybridData mHybridData;

    @FastNative
    private final native Promise<ItemStatus[]> invoke_cxx(ItemIdentifier[] selectedItemIds, ItemIdentifier[] itemIds);

    private Func_std__shared_ptr_Promise_std__vector_ItemStatus____std__vector_ItemIdentifier__std__vector_ItemIdentifier__cxx(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function2
    public Promise<ItemStatus[]> invoke(ItemIdentifier[] selectedItemIds, ItemIdentifier[] itemIds) {
        Intrinsics.checkNotNullParameter(selectedItemIds, "selectedItemIds");
        Intrinsics.checkNotNullParameter(itemIds, "itemIds");
        return invoke_cxx(selectedItemIds, itemIds);
    }
}
