package com.margelo.nitro.boxcontext;

import com.margelo.nitro.core.Promise;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Func_std__shared_ptr_Promise_std__vector_ItemStatus____std__vector_ItemIdentifier__std__vector_ItemIdentifier_.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B9\u00120\u0010\u0002\u001a,\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u00060\u0003¢\u0006\u0004\b\b\u0010\tJ6\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0097\u0002¢\u0006\u0002\u0010\rR8\u0010\u0002\u001a,\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/margelo/nitro/boxcontext/Func_std__shared_ptr_Promise_std__vector_ItemStatus____std__vector_ItemIdentifier__std__vector_ItemIdentifier__java;", "Lcom/margelo/nitro/boxcontext/Func_std__shared_ptr_Promise_std__vector_ItemStatus____std__vector_ItemIdentifier__std__vector_ItemIdentifier_;", "function", "Lkotlin/Function2;", "", "Lcom/margelo/nitro/boxcontext/ItemIdentifier;", "Lcom/margelo/nitro/core/Promise;", "Lcom/margelo/nitro/boxcontext/ItemStatus;", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "invoke", "selectedItemIds", "itemIds", "([Lcom/margelo/nitro/boxcontext/ItemIdentifier;[Lcom/margelo/nitro/boxcontext/ItemIdentifier;)Lcom/margelo/nitro/core/Promise;", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Func_std__shared_ptr_Promise_std__vector_ItemStatus____std__vector_ItemIdentifier__std__vector_ItemIdentifier__java implements Func_std__shared_ptr_Promise_std__vector_ItemStatus____std__vector_ItemIdentifier__std__vector_ItemIdentifier_ {
    private final Function2<ItemIdentifier[], ItemIdentifier[], Promise<ItemStatus[]>> function;

    /* JADX WARN: Multi-variable type inference failed */
    public Func_std__shared_ptr_Promise_std__vector_ItemStatus____std__vector_ItemIdentifier__std__vector_ItemIdentifier__java(Function2<? super ItemIdentifier[], ? super ItemIdentifier[], Promise<ItemStatus[]>> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        this.function = function;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function2
    public Promise<ItemStatus[]> invoke(ItemIdentifier[] selectedItemIds, ItemIdentifier[] itemIds) {
        Intrinsics.checkNotNullParameter(selectedItemIds, "selectedItemIds");
        Intrinsics.checkNotNullParameter(itemIds, "itemIds");
        return this.function.invoke(selectedItemIds, itemIds);
    }
}
