package com.margelo.nitro.boxcontext;

import com.margelo.nitro.core.Promise;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Func_std__shared_ptr_Promise_std__vector_ItemStatus____std__vector_ItemIdentifier__std__vector_ItemIdentifier_.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bç\u0080\u0001\u0018\u00002,\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00020\u00040\u0001J6\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H§\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/margelo/nitro/boxcontext/Func_std__shared_ptr_Promise_std__vector_ItemStatus____std__vector_ItemIdentifier__std__vector_ItemIdentifier_;", "Lkotlin/Function2;", "", "Lcom/margelo/nitro/boxcontext/ItemIdentifier;", "Lcom/margelo/nitro/core/Promise;", "Lcom/margelo/nitro/boxcontext/ItemStatus;", "invoke", "selectedItemIds", "itemIds", "([Lcom/margelo/nitro/boxcontext/ItemIdentifier;[Lcom/margelo/nitro/boxcontext/ItemIdentifier;)Lcom/margelo/nitro/core/Promise;", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface Func_std__shared_ptr_Promise_std__vector_ItemStatus____std__vector_ItemIdentifier__std__vector_ItemIdentifier_ extends Function2<ItemIdentifier[], ItemIdentifier[], Promise<ItemStatus[]>> {
    Promise<ItemStatus[]> invoke(ItemIdentifier[] selectedItemIds, ItemIdentifier[] itemIds);
}
